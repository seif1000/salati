package com.example.adkari;



import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.adkari.adapter.TabAdapter;
import com.example.adkari.adkarFragment.FragmenMassaa;
import com.example.adkari.adkarFragment.FragmenSabah;
import com.example.adkari.adkarFragment.Fragmenistrfar;
import com.example.adkari.adkarFragment.Fragmensalat;
import com.example.adkari.adkarFragment.Fragmentasbih;
import com.google.android.material.tabs.TabLayout;

public class AdkarActivity extends AppCompatActivity {
    private TextView textView ;

    TabAdapter tabAdapter ;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adkar);

       tabLayout =(TabLayout) findViewById(R.id.tabs) ;
       viewPager = findViewById(R.id.viewpager) ;

        tabAdapter = new TabAdapter(getSupportFragmentManager()) ;
        tabAdapter.addFragment(new Fragmenistrfar(),"اذكار المسلم");
        tabAdapter.addFragment(new FragmenSabah(),"اذكار الصباح");
        tabAdapter.addFragment(new FragmenMassaa(),"اذكار المساء");
        tabAdapter.addFragment(new Fragmensalat(),"اذكار الصلاة");
        tabAdapter.addFragment(new Fragmentasbih(),"ادعية");

        viewPager.setAdapter(tabAdapter);
        tabLayout.setupWithViewPager(viewPager);


        textView = findViewById(R.id.textView) ;
        Intent intent = getIntent() ;

        String title = intent.getStringExtra("SELECTED ITEM NAME") ;
        int position = intent.getIntExtra("SELECTED ITEM POSITION",0) ;

        TabLayout.Tab tab = tabLayout.getTabAt(position);
        tab.select();
       // textView.setText(title);
    }
}
