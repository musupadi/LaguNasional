package com.destiny.lagunasionalindonesia.Adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.destiny.lagunasionalindonesia.Model.Models;
import com.destiny.lagunasionalindonesia.R;

import java.util.ArrayList;

public class AdapterLaguWajib extends RecyclerView.Adapter<AdapterLaguWajib.CardViewViewHolder>{
    private Context context;
    private ArrayList<Models> listLaguWajib;

    private ArrayList<Models> getListLaguWajib() {
        return listLaguWajib;
    }
    public void setListLaguWajib(ArrayList<Models> listLaguWajib) {
        this.listLaguWajib= listLaguWajib;
    }
    public AdapterLaguWajib(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_lagu, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder cardViewViewHolder, int i) {
        final Models p = getListLaguWajib().get(i);
        cardViewViewHolder.tvJudul.setText(p.getJudul());
        cardViewViewHolder.tvPenyanyi.setText(p.getPencipta());
        cardViewViewHolder.list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return getListLaguWajib().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder{
        TextView tvJudul, tvPenyanyi;
        RelativeLayout list;
        CardViewViewHolder(View itemView) {
            super(itemView);
            tvJudul = itemView.findViewById(R.id.tvJudul);
            tvPenyanyi= itemView.findViewById(R.id.tvPenyanyi);
            list = itemView.findViewById(R.id.List);
        }
    }
}