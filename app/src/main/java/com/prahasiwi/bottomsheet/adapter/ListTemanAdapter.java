package com.prahasiwi.bottomsheet.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.prahasiwi.bottomsheet.R;
import com.prahasiwi.bottomsheet.model.Teman;

import java.util.ArrayList;
import java.util.List;

public class ListTemanAdapter extends RecyclerView.Adapter<ListTemanAdapter.ViewHolder> {
    private List<Teman> list;
    private ListTemanAdapterListener listener;

    public ListTemanAdapter(ListTemanAdapterListener listener) {
        this.list = new ArrayList<>();
        this.listener = listener;
    }

    public void setData(List<Teman> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListTemanAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_teman, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Teman model = list.get(position);

        holder.tx_judul.setText(model.getNama());
        holder.tx_tx_descform.setText(model.getLokasi());
        holder.tx_tx_lokasi.setText(model.getWaktu());
        holder.cl_teman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClickListTemanAdapter(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout cl_teman;
        TextView tx_judul, tx_tx_descform, tx_tx_lokasi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cl_teman = itemView.findViewById(R.id.cl_teman);
            tx_judul = itemView.findViewById(R.id.tx_judul);
            tx_tx_descform = itemView.findViewById(R.id.tx_tx_descform);
            tx_tx_lokasi = itemView.findViewById(R.id.tx_tx_lokasi);
        }
    }

    public interface ListTemanAdapterListener {
        void onClickListTemanAdapter(int position);
    }
}
