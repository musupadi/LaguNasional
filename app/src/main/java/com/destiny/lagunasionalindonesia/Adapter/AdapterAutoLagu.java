package com.destiny.lagunasionalindonesia.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import com.destiny.lagunasionalindonesia.Model.Models;
import com.destiny.lagunasionalindonesia.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterAutoLagu extends ArrayAdapter<Models> {
    private List<Models> dmListFull;

    public AdapterAutoLagu(@NonNull Context context, @NonNull List<Models> countryList) {
        super(context, 0, countryList);
        dmListFull = new ArrayList<>(countryList);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        return countryFilter;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_data_lagu, parent, false
            );
        }

        TextView textViewJudul = convertView.findViewById(R.id.tvJudul);
        TextView textViewPenyanyi = convertView.findViewById(R.id.tvPencipta);

        Models dm = getItem(position);

        if (dm != null) {
            textViewJudul.setText(dm.getJudul());
            textViewPenyanyi.setText(dm.getPencipta());
        }

        return convertView;
    }

    private Filter countryFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<Models> suggestions = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                suggestions.addAll(dmListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Models item : dmListFull) {
                    if (item.getJudul().toLowerCase().contains(filterPattern)) {
                        suggestions.add(item);
                    }
                }
            }

            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List) results.values);
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {
            return ((Models) resultValue).getJudul();
        }
    };
}
