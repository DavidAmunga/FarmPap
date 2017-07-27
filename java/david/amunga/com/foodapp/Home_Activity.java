package david.amunga.com.foodapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;



import java.util.ArrayList;
import java.util.List;

import qdx.bezierviewpager_compile.BezierRoundView;
import qdx.bezierviewpager_compile.vPage.BezierViewPager;
import qdx.bezierviewpager_compile.vPage.CardPagerAdapter;



public class Home_Activity extends AppCompatActivity {
    private static final int REQUEST_LOCATION = 1;

    List<String> lstImages=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

        buildImageList();


        CardPagerAdapter cardAdapter=new CardPagerAdapter(this);
        cardAdapter.addImgUrlList(lstImages);

        BezierViewPager viewPager=(BezierViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(cardAdapter);

        BezierRoundView round_view=(BezierRoundView)findViewById(R.id.round_view);
        round_view.attach2ViewPage(viewPager);



        BottomNavigationView bottomNavigationView=(BottomNavigationView)findViewById(R.id.bottom_navigation);



        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_menu:
                                Intent intent=new Intent(Home_Activity.this, Food_List_Activity.class);
                                startActivity(intent);
                                break;
                            case R.id.action_about:
                                Intent a=new Intent(Home_Activity.this, AboutActivity.class);
                                startActivity(a);
                                break;


                        }
                        return true;
                    }
                });



    }

    private void buildImageList() {
        lstImages.add("http://i.imgur.com/PdnDsdo.png");
        lstImages.add("http://i.imgur.com/P96bjfy.png");
        lstImages.add("http://i.imgur.com/DaIvsK0.png");

    }


}
