package com.example.adkari.mainFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adkari.AdkarActivity;
import com.example.adkari.adapter.AdkarAdapter;
import com.example.adkari.adapter.AdkarItem;
import com.example.adkari.R;

import java.util.ArrayList;

public class FragmenAdkar extends Fragment {

    private RecyclerView mRecyclerView ;
    private ArrayList<AdkarItem> mAdkarItems ;
    private RecyclerView.LayoutManager mLayoutManager ;
    private AdkarAdapter mAdapter ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_adkar,container,false) ;

        mAdkarItems = new ArrayList<>() ;
        mRecyclerView =(RecyclerView) v.findViewById(R.id.adkar_list) ;

        mAdkarItems.add(new AdkarItem("اذكار المسلم"));
        mAdkarItems.add(new AdkarItem("اذكار الصباح"));
        mAdkarItems.add(new AdkarItem("اذكار المساء"));
        mAdkarItems.add(new AdkarItem("اذكار الصلاة"));
        mAdkarItems.add(new AdkarItem("ادعية"));


        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new AdkarAdapter(mAdkarItems);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new AdkarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                String item = mAdkarItems.get(position).getmText() ;

                Intent intent = new Intent(getActivity(), AdkarActivity.class) ;

               intent.putExtra("SELECTED ITEM POSITION",position) ;
               intent.putExtra("SELECTED ITEM NAME" ,item) ;

               startActivity(intent);

            }


        });


        return v ;

    }


}
