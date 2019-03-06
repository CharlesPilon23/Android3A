package com.example.projet_mobile.presentation;

import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projet_mobile.R;
import com.example.projet_mobile.model.Launches;
import com.squareup.picasso.Picasso;

public class LaunchesAdapter extends RecyclerView.Adapter<LaunchesAdapter.ViewHolder> {
    private final Context context;
    private List<Launches> values;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Launches item);
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView img;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            img = v.findViewById(R.id.MissionPatch);
        }
    }

    public void add(int position, Launches item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }


    public LaunchesAdapter(List<Launches> myDataset, Context context, OnItemClickListener listener) {
        values = myDataset;
        this.context = context;
        this.listener = listener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public LaunchesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final Launches launches = values.get(position);
        holder.txtHeader.setText(launches.getFlightNumber() +" - "+ launches.getMissionName());
        holder.txtFooter.setText(launches.getLaunchYear());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(launches);
            }
        });
        Picasso.with(context).load(launches.getLinks().getMissionPatch()).into(holder.img);



        //holder.txtFooter.setText("Footer: " + name);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}
