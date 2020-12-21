package com.example.kelompok1g;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText editTextNamaHewan;
    Button buttonBeratBadanIdeal;
    Spinner spinnerBeratBadanIdeal;

    DatabaseReference dataBaseBeratBadanIdeal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBaseBeratBadanIdeal = FirebaseDatabase.getInstance().getReference("BeratBadanIdeal");

        editTextNamaHewan = (EditText) findViewById(R.id.editTextNamaHewan);
        buttonBeratBadanIdeal = (Button) findViewById(R.id.buttonBeratBadanIdeal);
        spinnerBeratBadanIdeal = (Spinner) findViewById(R.id.spinnerBeratBadanIdeal);



        buttonBeratBadanIdeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TambahBeratBadanIdeal();
            }
        });


    }

    private void TambahBeratBadanIdeal() {
        String MasukanNamaHewan = editTextNamaHewan.getText().toString().trim();
        String BeratBadanIdeal = spinnerBeratBadanIdeal.getSelectedItem().toString();

        if (!TextUtils.isEmpty(MasukanNamaHewan)) {

            String id = dataBaseBeratBadanIdeal.push().getKey();

            BeratBadanIdeal beratBadanIdeal = new BeratBadanIdeal(BeratBadanIdeal);

            dataBaseBeratBadanIdeal.setValue(beratBadanIdeal);

            Toast.makeText(this, "berat badan tambah", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "Kamu Harus Masukan Nama", Toast.LENGTH_LONG).show();
        }
    };
}