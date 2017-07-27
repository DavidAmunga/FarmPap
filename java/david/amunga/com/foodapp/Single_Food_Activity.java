package david.amunga.com.foodapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Single_Food_Activity extends AppCompatActivity {
    private static final String TAG = "Single_Food_Activity";

    TextView foodName,total_amount,single_amount,qty;
    Button btnAdd,btnMinus;

    int quantity=1;
    int amount,num=0,price=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single__food);


        foodName=(TextView)findViewById(R.id.food_name);
        total_amount=(TextView)findViewById(R.id.total_amount);
        single_amount=(TextView)findViewById(R.id.single_amount);
        qty=(TextView)findViewById(R.id.quantity);
        qty.setText(String.valueOf(quantity));

        //Set TextView Name
        Intent FoodIntent=getIntent();
        final String Foodvalue=FoodIntent.getStringExtra("FoodType");
        foodName.setText(Foodvalue);


        //Set TextView Price
        Intent Priceintent=getIntent();
        final String Pricevalue=Priceintent.getStringExtra("Price");
        single_amount.setText(Pricevalue);


        btnAdd=(Button)findViewById(R.id.add);
        btnMinus=(Button)findViewById(R.id.minus);




        String s1=single_amount.getText().toString().substring(4);
        price=Integer.parseInt(s1.toString());



        amount=price*quantity;

        total_amount.setText("Total: "+amount);

        Log.d(TAG, "amount"+amount);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                qty.setText(String.valueOf(quantity));
                amount=price*quantity;
                total_amount.setText("Total: "+amount);
                Log.d(TAG, "amount: "+amount);

            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quantity!=0)
                {
                    quantity--;

                }
                else
                {
                    quantity=0;
                }
                qty.setText(String.valueOf(quantity));
                amount=price*quantity;
                total_amount.setText("Total: "+amount);
            }
        });


        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_navigation_single);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_back:
                                Intent backIntent=new Intent(Single_Food_Activity.this, Food_List_Activity.class);
                                startActivity(backIntent);
                                break;
                            case R.id.action_order:
                                Log.d(TAG, "onNavigationItemSelected: Order Selected ");
                                Intent OrderIntent=new Intent(Single_Food_Activity.this, Food_Checkout_Activity.class);
                                startActivity(OrderIntent);

                        }
                        return true;
                    }
                });




    }



}
