package com.example.adkari.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adkari.R;

import java.util.ArrayList;

public class AdkarAdapter extends RecyclerView.Adapter <AdkarAdapter.ViewHolder> {
    public ArrayList<AdkarItem> mAdkarItems ;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position );


    }



    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTextView ;

        public ViewHolder(@NonNull final View itemView , final OnItemClickListener listener) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.contenu_item) ;



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }

    }

    public AdkarAdapter(ArrayList<AdkarItem> adkarItems){
        mAdkarItems = adkarItems ;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adkar_item,parent,false) ;
         ViewHolder vh = new ViewHolder(v ,mListener) ;
         return vh ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           AdkarItem currentAdkar = mAdkarItems.get(position) ;
           holder.mTextView.setText(currentAdkar.getmText());

    }

    @Override
    public int getItemCount() {
        return mAdkarItems.size();
    }



}
