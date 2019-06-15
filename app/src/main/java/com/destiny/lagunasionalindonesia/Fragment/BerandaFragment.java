package com.destiny.lagunasionalindonesia.Fragment;


import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.destiny.lagunasionalindonesia.HomeActivity;
import com.destiny.lagunasionalindonesia.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BerandaFragment extends Fragment {
    ImageView daerah,wajib;

    public BerandaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_beranda, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wajib = (ImageView)view.findViewById(R.id.Wajib);
        daerah = (ImageView)view.findViewById(R.id.Daerah);
        wajib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goInput = new Intent(getActivity(), HomeActivity.class);
                goInput.putExtra("WAJIB","wajib");
                getActivity().startActivities(new Intent[]{goInput});
            }
        });
    }
}
