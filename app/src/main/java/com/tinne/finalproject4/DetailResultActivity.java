package com.tinne.finalproject4;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tinne.finalproject4.databinding.ActivityDetailResultBinding;

public class DetailResultActivity extends AppCompatActivity {
    private ActivityDetailResultBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailResultBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String kemana = getIntent().getStringExtra("EXTRA_KEMANA");
        String darimana = getIntent().getStringExtra("EXTRA_DARIMANA");
        String nama = getIntent().getStringExtra("EXTRA_NAMA");
        String kode = getIntent().getStringExtra("EXTRA_KODE");
        String jKemana = getIntent().getStringExtra("EXTRA_JAMKEMANA");
        String jDarimana = getIntent().getStringExtra("EXTRA_JAMDARIMANA");
        int image = getIntent().getIntExtra("EXTRA_IMAGE", R.drawable.bus3);

        binding.tvNamaBus.setText(nama);
        binding.tvKodeBus.setText(kode);
        String fromTo = darimana + " ke " + kemana;
        binding.tvFromTo.setText(fromTo);
        binding.tvDarimana.setText(darimana);
        binding.tvKemana.setText(kemana);
        binding.tvJamDarimana.setText(jDarimana);
        binding.tvJamKemana.setText(jKemana);

        Glide.with(this)
                .load(image)
                .fitCenter()
                .apply(new RequestOptions().override(300, 150))
                .placeholder(R.drawable.imghome)
                .into(binding.imgBus);

        binding.btnBack.setOnClickListener(v -> onBackPressed());

        binding.btnSeat.setOnClickListener(v -> {
            Intent intent = new Intent(DetailResultActivity.this, ChooseSeatActivity.class);
            startActivity(intent);
        });

    }
}