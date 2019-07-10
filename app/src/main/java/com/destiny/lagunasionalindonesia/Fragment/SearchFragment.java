package com.destiny.lagunasionalindonesia.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import com.destiny.lagunasionalindonesia.Adapter.AdapterAutoLagu;
import com.destiny.lagunasionalindonesia.Adapter.AdapterLaguWajib;
import com.destiny.lagunasionalindonesia.HomeActivity;
import com.destiny.lagunasionalindonesia.Model.DataModelAll;
import com.destiny.lagunasionalindonesia.Model.Models;
import com.destiny.lagunasionalindonesia.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    Button Quiz;

    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Quiz = (Button)view.findViewById(R.id.btnQuiz);
        Quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goInput = new Intent(getActivity(), QuizActivity.class);
                goInput.putExtra("NO","0");
                goInput.putExtra("SCORE","0");
                getActivity().startActivities(new Intent[]{goInput});
            }
        });

    }
}
