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

import com.destiny.lagunasionalindonesia.Adapter.AdapterLaguWajib;
import com.destiny.lagunasionalindonesia.Model.DataModelWajib;
import com.destiny.lagunasionalindonesia.Model.Models;
import com.destiny.lagunasionalindonesia.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListWajibFragment extends Fragment {

    RecyclerView rvCategory;
    private ArrayList<Models> pList = new ArrayList<>();
    public ListWajibFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_wajib, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvCategory = (RecyclerView)view.findViewById(R.id.recycler);


        //getArguments
        final String List = this.getArguments().getString("LIST").toString();
        pList.addAll(DataModelWajib.getListData());
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdapterLaguWajib cardViewAdapter = new AdapterLaguWajib(getActivity());
        cardViewAdapter.setListLaguWajib(pList);
        rvCategory.setAdapter(cardViewAdapter);
    }
}
