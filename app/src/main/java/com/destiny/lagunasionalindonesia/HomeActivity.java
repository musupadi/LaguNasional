package com.destiny.lagunasionalindonesia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.destiny.lagunasionalindonesia.Fragment.BerandaFragment;
import com.destiny.lagunasionalindonesia.Fragment.DaftarPutarFragment;
import com.destiny.lagunasionalindonesia.Fragment.ListWajibFragment;
import com.destiny.lagunasionalindonesia.Fragment.PlayFragment;
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
                    Bundle bundle = new Bundle();
                    bundle.putString("SCORE","0");
                    selectedFragment = new SearchFragment();
                    selectedFragment.setArguments(bundle);
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
        Fragment fragment = new BerandaFragment();
        Intent data = getIntent();
        //Constant
        String Wajib = data.getStringExtra("WAJIB");
        String LaguWajib = data.getStringExtra("LaguWajib");
        String Score = data.getStringExtra("SCORE");
        //Constant
        String Judul = data.getStringExtra("Judul");
        String Pencipta = data.getStringExtra("Pencipta");
        String Asal = data.getStringExtra ("Asal");
        String Lirik = data.getStringExtra("Lirik");
        String Lagu = data.getStringExtra("Lagu");
        if (Wajib !=null){
            Bundle bundle = new Bundle();
            bundle.putString("LIST",Wajib);
            fragment = new ListWajibFragment();
            fragment.setArguments(bundle);
        }else if(LaguWajib !=null){
            Bundle bundle = new Bundle();
            bundle.putString("MUSIC",LaguWajib);
            bundle.putString("Judul",Judul);
            bundle.putString("Pencipta",Pencipta);
            bundle.putString("Asal",Asal);
            bundle.putString("Lirik",Lirik);
            bundle.putString("Lagu",Lagu);
            fragment = new PlayFragment();
            fragment.setArguments(bundle);
        }else if(Score != null){
            Bundle bundle = new Bundle();
            bundle.putString("SCORE",Score);
            fragment = new SearchFragment();
            fragment.setArguments(bundle);
        }
        ChangeFragment(fragment);
    }
    private void ChangeFragment(Fragment fragment){
        if(fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.Container,fragment);
            ft.commit();
        }
    }

}
