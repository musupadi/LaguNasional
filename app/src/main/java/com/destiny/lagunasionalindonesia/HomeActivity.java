package com.destiny.lagunasionalindonesia;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import com.destiny.lagunasionalindonesia.Fragment.BerandaFragment;
import com.destiny.lagunasionalindonesia.Fragment.DaftarPutarFragment;
import com.destiny.lagunasionalindonesia.Fragment.SearchFragment;
import com.destiny.lagunasionalindonesia.Fragment.TentangFragment;

public class HomeActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_Beranda:
                    selectedFragment = new BerandaFragment();
                    break;
                case R.id.navigation_Pencarian:
                    selectedFragment = new SearchFragment();
                    break;
                case R.id.navigation_DaftarPutar:
                    selectedFragment = new DaftarPutarFragment();
                    break;
                case R.id.navigation_Tentang:
                    selectedFragment = new TentangFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.Container,
                    selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
