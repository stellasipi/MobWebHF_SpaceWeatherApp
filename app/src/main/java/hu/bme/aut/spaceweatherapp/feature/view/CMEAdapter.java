package hu.bme.aut.spaceweatherapp.feature.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.spaceweatherapp.R;
import hu.bme.aut.spaceweatherapp.feature.view.*;
import hu.bme.aut.spaceweatherapp.data.entities.CME_item;


public class CMEAdapter extends RecyclerView.Adapter<CMEAdapter.CMEViewHolder> {
    private final List<CME_item> items;

    public CMEAdapter(){
        items = new ArrayList<>();
    }

    @NonNull
    @Override
    public CMEAdapter.CMEViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_cme,parent,false);
        return new CMEAdapter.CMEViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CMEViewHolder holder, int position) {
        //super.onBindViewHolder(holder, position);
        CME_item item=items.get(position);
        holder.startTimeTextView.setText(item.startTime);
        /*holder.latTextView.setText(Double.toString(item.cmeAnalyses.latitude));
        holder.longTextView.setText(Double.toString(item.cmeAnalyses.longitude));
        holder.speedTextView.setText(Double.toString(item.cmeAnalyses.speed));
        holder.typeTextView.setText(item.cmeAnalyses.type);*/
        holder.noteTextView.setText(item.note);
        holder.catalogTextView.setText(item.catalog);

        holder.item=item;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(CME_item item){
        items.add(item);
        notifyItemInserted(items.size()-1);
    }

    public void update(List<CME_item> cme_items){
        items.clear();
        items.addAll(cme_items);
        notifyDataSetChanged();
    }

    public interface CMEItemClickListener{
        void onItemChanged(CME_item item);
    }

    class CMEViewHolder extends RecyclerView.ViewHolder{

       /*public CMEViewHolder(@NonNull View itemView) {
            super(itemView);
        }*/

        TextView startTimeTextView;
        /*TextView latTextView;
        TextView longTextView;
        TextView speedTextView;
        TextView typeTextView;*/
        TextView noteTextView;
        TextView catalogTextView;

        CME_item item;

        CMEViewHolder(View itemView){
            super(itemView);
            startTimeTextView= itemView.findViewById(R.id.tvStartTime);
        /*latTextView= itemView.findViewById(R.id.tvLat);
        longTextView= itemView.findViewById(R.id.tvLong);
        speedTextView= itemView.findViewById(R.id.tvSpeed);
        typeTextView= itemView.findViewById(R.id.tvType);*/
            noteTextView= itemView.findViewById(R.id.tvNote);
            catalogTextView= itemView.findViewById(R.id.tvCatalog);
        }
    }
}
