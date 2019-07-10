package com.destiny.lagunasionalindonesia.Model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.destiny.lagunasionalindonesia.HomeActivity;
import com.destiny.lagunasionalindonesia.R;

import java.util.List;

public class ModelsAdapter extends RecyclerView.Adapter<ModelsAdapter.ViewHolder> {
    private List<Models> mMusicList;
    private Context mContext;
    private RecyclerView mRecyclerV;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView Judul, Penyanyi;
        public RelativeLayout list;

        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            Judul=(TextView)v.findViewById(R.id.tvJudul);
            Penyanyi=(TextView)v.findViewById(R.id.tvPenyanyi);
            list=(RelativeLayout)v.findViewById(R.id.List);
        }
    }

    public void add(int position, Models models) {
        mMusicList.add(position, models);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        mMusicList.remove(position);
        notifyItemRemoved(position);
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    public ModelsAdapter(List<Models> myDataset, Context context, RecyclerView recyclerView) {
        mMusicList = myDataset;
        mContext = context;
        mRecyclerV = recyclerView;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ModelsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.list_lagu, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            final Models models = mMusicList.get(position);
            holder.Judul.setText(models.getJudul());
            holder.Penyanyi.setText(models.getPencipta());
            holder.list.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goInput = new Intent(mContext, HomeActivity.class);
                    goInput.putExtra("LaguWajib","LAGUWAJIB");
                    goInput.putExtra("Judul",models.getJudul());
                    goInput.putExtra("Pencipta",models.getPencipta());
                    goInput.putExtra( "Asal",models.getAsal());
                    goInput.putExtra("Lirik",models.getLirik());
                    goInput.putExtra("Lagu",models.getLagu());
                    mContext.startActivities(new Intent[]{goInput});
                }
            });
        }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mMusicList.size();
    }

}
