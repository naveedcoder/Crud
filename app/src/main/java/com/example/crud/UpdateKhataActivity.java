package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class UpdateKhataActivity extends AppCompatActivity {
    TextInputEditText etKhataId, etUpdatedTitle, etUpdatedDesc, etUpdatedDate, etUpdatedPrice;
    Button btnUpdateKhata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_khata);
        init();

        KhaataDB db = new KhaataDB(this);

        btnUpdateKhata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String khataId = etKhataId.getText().toString().trim();
                String updatedTitle = etUpdatedTitle.getText().toString().trim();
                String updatedDesc = etUpdatedDesc.getText().toString().trim();
                String updatedDate = etUpdatedDate.getText().toString().trim();
                String updatedPrice = etUpdatedPrice.getText().toString().trim();

                try {
                    db.open();
                    long records = db.updatKhaata(khataId, updatedTitle, updatedDesc, updatedDate, updatedPrice);
                    db.close();

                    if (records > 0) {
                        Toast.makeText(UpdateKhataActivity.this, "Khata updated successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(UpdateKhataActivity.this, "Failed to update Khata", Toast.LENGTH_SHORT).show();
                    }
                } catch (SQLException e) {
                    Toast.makeText(UpdateKhataActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        etKhataId = findViewById(R.id.etKhataId);
        etUpdatedTitle = findViewById(R.id.etUpdatedTitle);
        etUpdatedDesc = findViewById(R.id.etUpdatedDesc);
        etUpdatedDate = findViewById(R.id.etUpdatedDate);
        etUpdatedPrice = findViewById(R.id.etUpdatedPrice);
        btnUpdateKhata = findViewById(R.id.btnUpdateKhata);
        if (etKhataId == null || etUpdatedTitle == null || etUpdatedDesc == null
                || etUpdatedDate == null || etUpdatedPrice == null || btnUpdateKhata == null) {
            // Handle the case where any view is not found
            Toast.makeText(this, "Error finding views", Toast.LENGTH_SHORT).show();
            finish(); // Finish the activity to prevent further execution
        }
    }
    }

