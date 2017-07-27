package david.amunga.com.foodapp;

import android.content.Intent;
import android.location.Geocoder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

public class Food_Checkout_Activity extends AppCompatActivity  {
    private static final String TAG = "Food_Checkout_Activity";

    TextView payInfo;
    Button btn_locate,btn_order;

    private final int REQUEST_CODE_PLACEPICKER = 1;



    Geocoder geocoder;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food__checkout);


        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.options_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        payInfo=(TextView)findViewById(R.id.payInfo);
        btn_locate=(Button)findViewById(R.id.btn_locate);
        btn_order=(Button)findViewById(R.id.btn_order);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Log.d(TAG, "onItemSelected:"+parent.getSelectedItem());
                if(parent.getSelectedItem().equals("Pay By MPESA"))
                {
                    payInfo.setText("PayBill No: 441234");
                    payInfo.setVisibility(View.VISIBLE);
                }
                else if(parent.getSelectedItem().equals("Pay By Delivery"))
                {
                    payInfo.setText("Delivery Address:");

                    startPlacePickerActivity();
                    btn_locate.setVisibility(View.VISIBLE);
                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn_locate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPlacePickerActivity();
            }
        });

    }
    public void orderItem(View view)
    {
        payInfo.setText("Your Order has been received! We shall notify you on delivery");
    }

    private void startPlacePickerActivity() {
        PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
        // this would only work if you have your Google Places API working

        try {
            Intent intent = intentBuilder.build(this);

            startActivityForResult(intent, REQUEST_CODE_PLACEPICKER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void displaySelectedPlaceFromPlacePicker(Intent data) {
        Place placeSelected = PlacePicker.getPlace(data, this);

        String name = placeSelected.getName().toString();
        String address = placeSelected.getAddress().toString();

        payInfo.setText("Deliver to "+name+", at "+address);
        payInfo.setVisibility(View.VISIBLE);
        btn_order.setVisibility(View.VISIBLE);
    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PLACEPICKER && resultCode == RESULT_OK) {
            displaySelectedPlaceFromPlacePicker(data);
        }
    }

}
