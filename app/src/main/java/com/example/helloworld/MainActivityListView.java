package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.helloworld.adapter.MyAdapter;
import com.example.helloworld.model.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivityListView extends AppCompatActivity {

    private ListView listView;

    private ArrayAdapter<String> adapter;
    private MyAdapter myAdapter;
    private List<Item> values = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_view);
        addValues();
        listView = findViewById(R.id.listView);
        // adapter = new ArrayAdapter<>(this, R.layout.myrow, R.id.rowTextView, values);
        myAdapter = new MyAdapter(values, this);
        listView.setAdapter(myAdapter);

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
        values.add(new Item("New Item", 0));
        adapter.notifyDataSetChanged(); //Should update the layout
    }


    private void addValues(){
        values.add(new Item("Car 1", R.drawable.car1));
        values.add(new Item("Car 2", R.drawable.car2));
    }
}