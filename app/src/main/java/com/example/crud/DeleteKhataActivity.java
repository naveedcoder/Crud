package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class DeleteKhataActivity extends AppCompatActivity {
    TextInputEditText etDeleteKhataId;
    Button btnDeleteKhata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_khata);
        init();

        KhaataDB db = new KhaataDB(this);

        btnDeleteKhata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deleteKhataId = etDeleteKhataId.getText().toString().trim();

                try {
                    db.open();
                    int recordsDeleted = db.removeKhaata(deleteKhataId);
                    db.close();

                    if (recordsDeleted > 0) {
                        Toast.makeText(DeleteKhataActivity.this, "Khata deleted successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DeleteKhataActivity.this, "Failed to delete Khata", Toast.LENGTH_SHORT).show();
                    }
                } catch (SQLException e) {
                    Toast.makeText(DeleteKhataActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void init() {
        etDeleteKhataId = findViewById(R.id.etDeleteKhataId);
        btnDeleteKhata = findViewById(R.id.btnDeleteKhata);

        if (etDeleteKhataId == null || btnDeleteKhata == null) {
            Toast.makeText(this, "Error finding views", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
