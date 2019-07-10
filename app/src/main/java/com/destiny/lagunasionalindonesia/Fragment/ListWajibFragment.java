package com.destiny.lagunasionalindonesia.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.Toast;

import com.destiny.lagunasionalindonesia.Adapter.AdapterAutoLagu;
import com.destiny.lagunasionalindonesia.Adapter.AdapterLaguWajib;
import com.destiny.lagunasionalindonesia.HomeActivity;
import com.destiny.lagunasionalindonesia.Model.DataModelWajib;
import com.destiny.lagunasionalindonesia.Model.Models;
import com.destiny.lagunasionalindonesia.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListWajibFragment extends Fragment {

    RecyclerView rvCategory;
    ImageView search;
    AutoCompleteTextView SearchLagu;
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
        SearchLagu = (AutoCompleteTextView)view.findViewById(R.id.etSearchLagu);
        search = (ImageView)view.findViewById(R.id.ivSearch);

        //getArguments
        final String List = this.getArguments().getString("LIST").toString();
        pList.addAll(DataModelWajib.getListData());
        rvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdapterLaguWajib cardViewAdapter = new AdapterLaguWajib(getActivity());
        AdapterAutoLagu auto = new AdapterAutoLagu(getActivity(),pList);
        cardViewAdapter.setListLaguWajib(pList);
        SearchLagu.setAdapter(auto);
        rvCategory.setAdapter(cardViewAdapter);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getActivity(),pList.get(0).getJudul(),Toast.LENGTH_SHORT).show();
                for (int i=0; i <=pList.size()-1;i++){
                    if(pList.get(i).getJudul().equals(SearchLagu.getText().toString())){
                        Intent goInput = new Intent(getActivity(), HomeActivity.class);
                        goInput.putExtra("LaguWajib","LAGUWAJIB");
                        goInput.putExtra("Judul",pList.get(i).getJudul().toString());
                        goInput.putExtra("Pencipta",pList.get(i).getPencipta().toString());
                        goInput.putExtra( "Asal",pList.get(i).getAsal().toString());
                        goInput.putExtra("Lirik",pList.get(i).getLirik().toString());
                        goInput.putExtra("Lagu",pList.get(i).getLagu().toString());
                        getActivity().startActivities(new Intent[]{goInput});
                    }
                }
            }
        });
    }
}
