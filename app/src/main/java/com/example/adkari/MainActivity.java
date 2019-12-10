package com.example.adkari;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.adkari.mainFragment.FragmenAdan;
import com.example.adkari.mainFragment.FragmenAdd;
import com.example.adkari.mainFragment.FragmenAdkar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView =findViewById(R.id.nav) ;
        bottomNavigationView.setOnNavigationItemSelectedListener(listenr  );

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container ,new FragmenAdkar()).commit() ;
        }


    }
     BottomNavigationView.OnNavigationItemSelectedListener listenr =  new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selected = null ;

            switch (menuItem.getItemId()){
                case R.id.adkar:
                    selected = new FragmenAdkar() ;
                    break;
                case R.id.adan:
                    selected = new FragmenAdan() ;
                    break;
                case R.id.add:
                    selected = new FragmenAdd() ;
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container,selected).commit() ;


            return true ;
        }
    };
}
