package david.amunga.com.foodapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.lucasurbas.listitemview.ListItemView;

public class Food_List_Activity extends AppCompatActivity {
    private static final String TAG = "Food_List_Activity";


    ListItemView lstOne,lstTwo,lstThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food__list);


        lstOne=(ListItemView)findViewById(R.id.list_item_1);
        lstTwo=(ListItemView)findViewById(R.id.list_item_2);
        lstThree=(ListItemView)findViewById(R.id.list_item_3);


        lstOne.setOnMenuItemClickListener(new ListItemView.OnMenuItemClickListener() {
            @Override
            public void onActionMenuItemSelected(MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.action_buy:
                        Intent singleIntent=new Intent(Food_List_Activity.this, Single_Food_Activity.class);
                        Log.d(TAG, "Title"+lstOne.getTitle());
                        singleIntent.putExtra("FoodType",lstOne.getTitle());
                        singleIntent.putExtra("Price", lstOne.getSubtitle());
                        startActivity(singleIntent);
                    case R.id.action_info:
                        Toast.makeText(Food_List_Activity.this,"Fruitcake with alot of love!",Toast.LENGTH_SHORT).show();
                    case R.id.action_love:
                        Toast.makeText(Food_List_Activity.this,"Really Great!",Toast.LENGTH_SHORT).show();
                }
            }
        });
        lstTwo.setOnMenuItemClickListener(new ListItemView.OnMenuItemClickListener() {
            @Override
            public void onActionMenuItemSelected(MenuItem item) {
                switch(item.getItemId())
                {
                    case R.id.action_buy:
                        Intent singleIntent=new Intent(Food_List_Activity.this, Single_Food_Activity.class);
                        singleIntent.putExtra("FoodType",lstTwo.getTitle());
                        singleIntent.putExtra("Price", lstTwo.getSubtitle());
                        startActivity(singleIntent);
                    case R.id.action_info:
                        Toast.makeText(Food_List_Activity.this,"Butter Cookies!",Toast.LENGTH_SHORT).show();
                    case R.id.action_love:
                        Toast.makeText(Food_List_Activity.this,"Really Great!",Toast.LENGTH_SHORT).show();
                }

            }
        });


        lstThree.setOnMenuItemClickListener(new ListItemView.OnMenuItemClickListener() {
            @Override
            public void onActionMenuItemSelected(MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.action_buy:
                        Intent singleIntent=new Intent(Food_List_Activity.this, Single_Food_Activity.class);
                        singleIntent.putExtra("FoodType",lstThree.getTitle());
                        singleIntent.putExtra("Price", lstThree.getSubtitle());
                        startActivity(singleIntent);
                    case R.id.action_info:
                        Toast.makeText(Food_List_Activity.this,"Chicken Licken!!!!",Toast.LENGTH_SHORT).show();
                    case R.id.action_love:
                        Toast.makeText(Food_List_Activity.this,"Really Great!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_navigation_list);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_menu:
                                Intent Homeintent=new Intent(Food_List_Activity.this, Food_List_Activity.class);
                                startActivity(Homeintent);

                            case R.id.action_back:
                                Intent backIntent=new Intent(Food_List_Activity.this, Home_Activity.class);
                                startActivity(backIntent);

                        }
                        return true;
                    }
                });
    }




}
