package com.tinne.finalproject4;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tinne.finalproject4.adapter.BusAdapter;
import com.tinne.finalproject4.data.Data;
import com.tinne.finalproject4.databinding.ActivityResultHomeBinding;
import com.tinne.finalproject4.model.BusModel;

import java.util.ArrayList;

public class ResultHomeActivity extends AppCompatActivity {
    final String EXTRA_DARIMANA = "extra_darimana";
    final String EXTRA_KEMANA = "extra_kemana";
    final String EXTRA_DATE = "extra_date";
    private ActivityResultHomeBinding binding;
    private RecyclerView recyclerView;
    private BusAdapter busAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityResultHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String kemana = getIntent().getStringExtra(EXTRA_KEMANA);
        String darimana = getIntent().getStringExtra(EXTRA_DARIMANA);
        String date = getIntent().getStringExtra(EXTRA_DATE);
        int image = getIntent().getIntExtra("EXTRA_IMAGE", R.drawable.bus1);
        ArrayList<BusModel> list = new Data().getData(kemana, darimana, image);
        busAdapter = new BusAdapter(this, list);

        recyclerView = binding.clubRecview;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(busAdapter);
        busAdapter.notifyDataSetChanged();

        binding.tvDate.setText(date);
        String fromTo = darimana + " ke " + kemana;
        binding.tvFromTo.setText(fromTo);


        binding.btnBack.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });


    }
}