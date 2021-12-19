package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myfirstapp.Items.Fruit;
import com.example.myfirstapp.Items.FruitAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private String[] data = { "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango" };

    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListViewActivity.this, android.R.layout.simple_list_item_1, data);
//        ListView listView = findViewById(R.id.list_view);
//        listView.setAdapter(adapter);

        getFruits();
        FruitAdapter fruitAdapter = new FruitAdapter(ListViewActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.mipmap.ic_launcher_round);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.mipmap.ic_launcher_round);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.mipmap.ic_launcher_round);
            fruitList.add(orange);
            Fruit watermelon = new Fruit("Watermelon", R.mipmap.ic_launcher_round);
            fruitList.add(watermelon);
            Fruit pear = new Fruit("Pear", R.mipmap.ic_launcher_round);
            fruitList.add(pear);
            Fruit grape = new Fruit("Grape", R.mipmap.ic_launcher_round);
            fruitList.add(grape);
            Fruit pineapple = new Fruit("Pineapple", R.mipmap.ic_launcher_round);
            fruitList.add(pineapple);
        }
    }
}