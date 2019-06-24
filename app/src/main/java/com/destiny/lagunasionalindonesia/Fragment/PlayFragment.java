package com.destiny.lagunasionalindonesia.Fragment;


import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.destiny.lagunasionalindonesia.Model.DB_Helper;
import com.destiny.lagunasionalindonesia.Model.Models;
import com.destiny.lagunasionalindonesia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {
    ImageView Kembali,DaftarPutar,KembaliLagu,Putar,SelanjutnyaLagu;
    TextView lirik,lagu,pencipta,asal,judul;
    DB_Helper dbHelper;

    public PlayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_play, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //GetString
        final String MUSIC = this.getArguments().getString("MUSIC").toString();
        final String Judul = this.getArguments().getString("Judul").toString();
        final String Pencipta = this.getArguments().getString("Pencipta").toString();
        final String Asal = this.getArguments().getString("Asal").toString();
        final String Lirik = this.getArguments().getString("Lirik").toString();
        final String Lagu = this.getArguments().getString("Lagu").toString();
        //Done
        dbHelper = new DB_Helper(getActivity());
        //Cursor cursor = dbHelper.checkPahlawan(p.getNama());
        DaftarPutar=(ImageView)view.findViewById(R.id.ivDaftarPutar);
        lirik=(TextView)view.findViewById(R.id.tvLirik);
        pencipta=(TextView)view.findViewById(R.id.tvPencipta);
        judul=(TextView)view.findViewById(R.id.tvJudul);
        //Toast.makeText(getActivity(),Lirik,Toast.LENGTH_SHORT).show();
        if (MUSIC.equals("LAGUWAJIB")){
            PlayMusikWajib(Judul,Pencipta,Asal,Lirik,Lagu);
        }
        DaftarPutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity()," Ditambahkan Ke Daftar Putar",Toast.LENGTH_SHORT).show();
                Models model = new Models(Judul,
                        Pencipta,
                        Asal,
                        Lirik,
                        Lagu);
                dbHelper.FavoriteLagu(model);
            }
        });
    }
    private void PlayMusikWajib(String Judul,String Pencipta,String Asal,String Lirik,String Lagu){
        lirik.setText(Lirik);
        pencipta.setText(Pencipta);
        judul.setText(Judul);

    }
}
