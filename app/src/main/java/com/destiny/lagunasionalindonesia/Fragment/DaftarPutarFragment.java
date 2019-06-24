package com.destiny.lagunasionalindonesia.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.destiny.lagunasionalindonesia.Model.DB_Helper;
import com.destiny.lagunasionalindonesia.Model.DataModelDaerah;
import com.destiny.lagunasionalindonesia.Model.Models;
import com.destiny.lagunasionalindonesia.Model.ModelsAdapter;
import com.destiny.lagunasionalindonesia.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DaftarPutarFragment extends Fragment {
    private RecyclerView rvCategory;
    private ArrayList<Models> pList = new ArrayList<>();
    DB_Helper dbHelper;

    public DaftarPutarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_daftar_putar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Variable
        rvCategory = (RecyclerView)view.findViewById(R.id.navigation_DaftarPutar);
        //Done

        pList.addAll(DataModelDaerah.getListData());
        rvCategory.setHasFixedSize(true);
        dbHelper = new DB_Helper(getActivity());
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        ModelsAdapter pahlawanAdapter = new ModelsAdapter(dbHelper.modelList(),getActivity(),rvCategory);
        rvCategory.setAdapter(pahlawanAdapter);
    }
}
