package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityListView extends AppCompatActivity {

    private ListView listView;

    private ArrayAdapter<String> adapter;
    private List<String> values = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view);
        addValues();
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this, R.layout.myrow, R.id.rowTextView, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((listView, linearLayout, pos, id) ->{
            TextView tv = linearLayout.findViewById(R.id.rowTextView);
            System.out.println("you pressed " + tv.getText());
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        });
    }
    // Task Implement Add button. Back at 9.20

    public void addPressed(View view){
        System.out.println("Add pressed");
        values.add("New Value");
        adapter.notifyDataSetChanged(); //Should update the layout
    }


    private void addValues(){
        values.add("A");
        values.add("B");
        values.add("C");
    }
}