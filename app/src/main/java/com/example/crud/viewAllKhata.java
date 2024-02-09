package com.example.crud;

import android.database.SQLException;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class viewAllKhata extends AppCompatActivity {

    RecyclerView recyclerViewKhata;
    KhaataDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_khata);

        recyclerViewKhata = findViewById(R.id.ViewKhata);
        db = new KhaataDB(this);

        try {
            db.open();
            List<KhataItem> khataList = db.getAllKhata();
            db.close();

            KhataAdapter adapter = new KhataAdapter(khataList);
            recyclerViewKhata.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewKhata.setAdapter(adapter);

        } catch (SQLException e) {
            Toast.makeText(viewAllKhata.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
