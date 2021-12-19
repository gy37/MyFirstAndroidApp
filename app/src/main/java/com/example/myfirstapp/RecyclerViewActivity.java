package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.myfirstapp.Items.Fruit;
import com.example.myfirstapp.Items.FruitRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        getFruits();
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitRecyclerAdapter adapter = new FruitRecyclerAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }

    private void getFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.mipmap.ic_launcher_round);
            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banana"), R.mipmap.ic_launcher_round);
            fruitList.add(banana);
            Fruit orange = new Fruit(getRandomLengthName("Orange"), R.mipmap.ic_launcher_round);
            fruitList.add(orange);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"), R.mipmap.ic_launcher_round);
            fruitList.add(watermelon);
            Fruit pear = new Fruit(getRandomLengthName("Pear"), R.mipmap.ic_launcher_round);
            fruitList.add(pear);
            Fruit grape = new Fruit(getRandomLengthName("Grape"), R.mipmap.ic_launcher_round);
            fruitList.add(grape);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"), R.mipmap.ic_launcher_round);
            fruitList.add(pineapple);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}