package com.tinne.finalproject4;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.tinne.finalproject4.databinding.ActivityHomeInputBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class HomeInputActivity extends AppCompatActivity {
    final String EXTRA_DARIMANA = "extra_darimana";
    final String EXTRA_KEMANA = "extra_kemana";
    final String EXTRA_DATE = "extra_date";
    Calendar newCalendar;
    String date = "";
    String from;
    String to;
    String passenger;
    SimpleDateFormat dateFormatter;
    private ActivityHomeInputBinding binding;
    private DatePickerDialog datePickerDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mAuth = FirebaseAuth.getInstance();

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);


        binding.EdDate.setOnClickListener(v -> showDateDialog());

        binding.btnFindNow.setOnClickListener(v -> {
            from = binding.EdFrom.getText().toString().trim();
            to = binding.EdTo.getText().toString().trim();
            date = binding.EdDate.getText().toString().trim();
            passenger = binding.EdPassenger.toString().trim();
            Intent intent = new Intent(this, ResultHomeActivity.class);
            intent.putExtra(EXTRA_KEMANA, to);
            intent.putExtra(EXTRA_DARIMANA, from);
            intent.putExtra(EXTRA_DATE, date);
            startActivity(intent);
        });
        binding.btnlogout.setOnClickListener(v -> {
            mAuth.signOut();
            finish();
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        newCalendar = Calendar.getInstance();
    }

    private void showDateDialog() {

        /*
          Calendar untuk mendapatkan tanggal sekarang
         */
        Calendar newCalendars = Calendar.getInstance();

        /*
          Initiate DatePicker dialog
         */
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                /*
                  Method ini dipanggil saat kita selesai memilih tanggal di DatePicker
                 */

                /*
                  Set Calendar untuk menampung tanggal yang dipilih
                 */
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                /*
                  Update TextView dengan tanggal yang kita pilih
                 */
                binding.EdDate.setText(dateFormatter.format(newDate.getTime()));

            }

        }, newCalendars.get(Calendar.YEAR), newCalendars.get(Calendar.MONTH), newCalendars.get(Calendar.DAY_OF_MONTH));

        /*
          Tampilkan DatePicker dialog
         */
        datePickerDialog.show();
    }

}