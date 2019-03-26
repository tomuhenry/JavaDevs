package com.andela.tomusange.javadevsnairobi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: started");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/1.sm.png");
        mNames.add("Yellow Flower");

        mImageUrls.add("https://www.gstatic.com/webp/gallery/4.sm.jpg");
        mNames.add("Tree");

        mImageUrls.add("https://i.ebayimg.com/images/g/k5cAAOSwNSxVeEJv/s-l300.jpg");
        mNames.add("Blue Rose");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/1.sm.png");
        mNames.add("Yellow Flower");

        mImageUrls.add("https://www.gstatic.com/webp/gallery/4.sm.jpg");
        mNames.add("Tree");

        mImageUrls.add("https://i.ebayimg.com/images/g/k5cAAOSwNSxVeEJv/s-l300.jpg");
        mNames.add("Blue Rose");

        mImageUrls.add("https://www.gstatic.com/webp/gallery3/1.sm.png");
        mNames.add("Yellow Flower");

        mImageUrls.add("https://www.gstatic.com/webp/gallery/4.sm.jpg");
        mNames.add("Tree");

        mImageUrls.add("https://i.ebayimg.com/images/g/k5cAAOSwNSxVeEJv/s-l300.jpg");
        mNames.add("Blue Rose");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerView");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdadpter adapter = new RecyclerViewAdadpter(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
