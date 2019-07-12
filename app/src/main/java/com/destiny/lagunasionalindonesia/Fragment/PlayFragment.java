package com.destiny.lagunasionalindonesia.Fragment;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.destiny.lagunasionalindonesia.HomeActivity;
import com.destiny.lagunasionalindonesia.MainActivity;
import com.destiny.lagunasionalindonesia.Model.DB_Helper;
import com.destiny.lagunasionalindonesia.Model.Models;
import com.destiny.lagunasionalindonesia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayFragment extends Fragment {
    ImageView Kembali,DaftarPutar,KembaliLagu,Putar,SelanjutnyaLagu;
    TextView lirik,lagu,pencipta,asal,judul;
    Button Update,Delete;
    DB_Helper dbHelper;
    Dialog myDialog;
    boolean onClicked = true;

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
        final MediaPlayer SuaraLagu = MediaPlayer.create(getActivity(),Integer.parseInt(Lagu));
        //Done
        dbHelper = new DB_Helper(getActivity());
        //Cursor cursor = dbHelper.checkPahlawan(p.getNama());
        DaftarPutar=(ImageView)view.findViewById(R.id.ivDaftarPutar);
        lirik=(TextView)view.findViewById(R.id.tvLirik);
        pencipta=(TextView)view.findViewById(R.id.tvPencipta);
        judul=(TextView)view.findViewById(R.id.tvJudul);
        Putar=(ImageView)view.findViewById(R.id.ivMusikPlay);
        Kembali=(ImageView)view.findViewById(R.id.ivBack);
        //Toast.makeText(getActivity(),Lirik,Toast.LENGTH_SHORT).show();
        if (MUSIC.equals("LAGUWAJIB")){
            PlayMusikWajib(Judul,Pencipta,Asal,Lirik,Lagu);
        }
        DaftarPutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String IDJudul = null;
                myDialog = new Dialog(getActivity());
                myDialog.setContentView(R.layout.layout_dialog);
                Delete = (Button)myDialog.findViewById(R.id.btnDelete);
                Drawable DrawableHapus = getResources().getDrawable(R.drawable.hapus);
                Drawable DrawableFav = getResources().getDrawable(R.drawable.play);
                Cursor cursors = dbHelper.checkLagu(Judul);
                if (cursors.getCount()>0){
                    while (cursors.moveToNext()){
                        IDJudul = cursors.getString(0);
                    }
                }
                if (IDJudul != null){
                    DaftarPutar.setImageDrawable(DrawableFav);
                    myDialog.show();
                }else{
                    DaftarPutar.setImageDrawable(DrawableHapus);
                    Toast.makeText(getActivity()," Ditambahkan Ke Daftar Putar",Toast.LENGTH_SHORT).show();
                    Models model = new Models(Judul,
                            Pencipta,
                            Asal,
                            Lirik,
                            Lagu);
                    dbHelper.FavoriteLagu(model);
                }
                Delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dbHelper.deleteLaguRecord(Judul,getActivity());
                        myDialog.dismiss();
                    }
                });

            }
        });
        Kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),HomeActivity.class);
                startActivity(intent);
            }
        });
        Putar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable DrawableHapus = getResources().getDrawable(R.drawable.pause);
                Drawable DrawablePlay = getResources().getDrawable(R.drawable.play);
                if (onClicked){
                    Putar.setImageDrawable(DrawableHapus);
                    SuaraLagu.start();
                    onClicked = false;
                }else{
                    Putar.setImageDrawable(DrawablePlay);
                    SuaraLagu.pause();
                    onClicked = true;
                }
            }
        });
    }
    private void PlayMusikWajib(String Judul,String Pencipta,String Asal,String Lirik,String Lagu){
        lirik.setText(Lirik);
        pencipta.setText(Pencipta);
        judul.setText(Judul);
    }
}
