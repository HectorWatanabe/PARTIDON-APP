package pe.edu.upc.partidon.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.partidon.Activities.WallCourtActivity;
import pe.edu.upc.partidon.R;
import pe.edu.upc.partidon.models.Court;
import pe.edu.upc.partidon.models.CourtSection;


public class SectionCourtAdapter extends RecyclerView.Adapter<SectionCourtAdapter.ViewHolder> {
    private Context context;
    private List<CourtSection> sectioncourts;

    public SectionCourtAdapter(Context context, @NonNull List<CourtSection> sectioncourts){
        this.context = context;
        this.sectioncourts = sectioncourts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_section_court,parent,false));
    }

    @Override
    public void onBindViewHolder(SectionCourtAdapter.ViewHolder holder, int position) {
        holder.titleSectionCourtTextView.setText(sectioncourts.get(position).getTitle());
        holder.tipeCourtInputTextView.setText(sectioncourts.get(position).getTipe());
        holder.metreCourtInputTextView.setText(sectioncourts.get(position).getMetre());
        holder.chairCourtInputTextView.setText(sectioncourts.get(position).getChair());
        holder.priceCourtInputTextView.setText(sectioncourts.get(position).getPriceAsString());
        holder.saleCourtInputTextView.setText(sectioncourts.get(position).getSaleAsString());
    }

    @Override
    public int getItemCount() {
        return sectioncourts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleSectionCourtTextView;
        TextView tipeCourtInputTextView;
        TextView metreCourtInputTextView;
        TextView chairCourtInputTextView;
        TextView priceCourtInputTextView;
        TextView saleCourtInputTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleSectionCourtTextView = (TextView) itemView.findViewById(R.id.titleSectionCourtTextView);
            tipeCourtInputTextView = (TextView) itemView.findViewById(R.id.tipeCourtInputTextView);
            metreCourtInputTextView = (TextView) itemView.findViewById(R.id.metreCourtInputTextView);
            chairCourtInputTextView = (TextView) itemView.findViewById(R.id.chairCourtInputTextView);
            priceCourtInputTextView = (TextView) itemView.findViewById(R.id.priceCourtInputTextView);
            saleCourtInputTextView = (TextView) itemView.findViewById(R.id.saleCourtInputTextView);
        }
    }
}