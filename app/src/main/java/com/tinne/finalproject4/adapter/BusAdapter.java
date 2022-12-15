package com.tinne.finalproject4.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tinne.finalproject4.DetailResultActivity;
import com.tinne.finalproject4.databinding.ResultLayoutBinding;
import com.tinne.finalproject4.model.BusModel;

import java.util.ArrayList;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<BusModel> list;

    public BusAdapter(Context context, ArrayList<BusModel> list) {

        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public BusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ResultLayoutBinding binding = ResultLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BusAdapter.ViewHolder holder, int position) {

        BusModel busModel = list.get(position);
        if (busModel != null) {
            holder.bind(busModel);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ResultLayoutBinding binding;


        public ViewHolder(ResultLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(BusModel busModel) {
            binding.tvNamaBus.setText(busModel.getNamaBus());
            binding.tvKodeBus.setText(busModel.getKodeBus());
            binding.tvDarimana.setText(busModel.getDarimana());
            binding.tvJamDarimana.setText(busModel.getJamDarimana());
            binding.tvKemana.setText(busModel.getKemana());
            binding.tvJamKemana.setText(busModel.getJamKemana());
            int harga = busModel.getHarga();
            binding.tvHarga.setText(String.valueOf(harga));


            binding.btnBook.setOnClickListener(v -> {
                Intent intent = new Intent(context, DetailResultActivity.class);
                intent.putExtra("EXTRA_NAMA", busModel.getNamaBus());
                intent.putExtra("EXTRA_KODE", busModel.getKodeBus());
                intent.putExtra("EXTRA_IMAGE", busModel.getImage());
                intent.putExtra("EXTRA_DARIMANA", busModel.getDarimana());
                intent.putExtra("EXTRA_KEMANA", busModel.getKemana());
                intent.putExtra("EXTRA_JAMKEMANA", busModel.getJamKemana());
                intent.putExtra("EXTRA_JAMDARIMANA", busModel.getJamDarimana());
                intent.putExtra("EXTRA_HARGA", busModel.getHarga());

                binding.btnBook.getContext().startActivity(intent);
            });
        }
    }
}



