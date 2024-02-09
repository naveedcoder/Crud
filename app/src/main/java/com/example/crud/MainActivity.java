package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
TextInputEditText etTitle,etDesc,etDate,etPrice;
Button AddKhata,UpdateKhata,DeleteKhata,ViewKhata,clear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        KhaataDB db=new KhaataDB(this);
        AddKhata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString().trim();
                String desc = etDesc.getText().toString().trim();
                String date = etDate.getText().toString().trim();
                String price = etPrice.getText().toString().trim();

                try {
                    db.open();
                    long records = db.addNewKhata(title, desc, date, price);
                    db.close();
                    Toast.makeText(MainActivity.this, "Khaata added successfully", Toast.LENGTH_SHORT).show();
                }catch (SQLException e)
                {
                    Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        DeleteKhata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DeleteKhataActivity.class);
                startActivity(intent);
            }
        });

        UpdateKhata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdateKhataActivity.class);
                startActivity(intent);
            }
        });

        ViewKhata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, viewAllKhata.class);
                startActivity(intent);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etTitle.getText().clear();
                etDesc.getText().clear();
                etDate.getText().clear();
                etPrice.getText().clear();
            }
        });
    }
    private void init(){
        etTitle=findViewById(R.id.etTitle);
        etDesc=findViewById(R.id.etDesc);
        etDate=findViewById(R.id.etDate);
        etPrice=findViewById(R.id.etPrice);
        AddKhata=findViewById(R.id.AddKhata);
        UpdateKhata=findViewById(R.id.UpdateKhata);
        DeleteKhata=findViewById(R.id.DeleteKhata);
        ViewKhata=findViewById(R.id.ViewKhata);
        clear=findViewById(R.id.clear);
    }
}