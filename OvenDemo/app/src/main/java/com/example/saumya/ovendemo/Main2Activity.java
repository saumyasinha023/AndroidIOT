package com.example.saumya.ovendemo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {

    private TextView mTextMessage;
    private Context mContext;
    private ConstraintLayout constrain;
    private Button button;
    private RecyclerView recycle;
    private LinearLayoutManager mGridManager;
    private RecycleAdapter mAdapter;
    Random random=new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mContext = getApplicationContext();
        constrain = (ConstraintLayout) findViewById(R.id.container);
        button = (Button) findViewById(R.id.button2);
        recycle = (RecyclerView) findViewById(R.id.recycleView);
        final String[] animals = {
                "Aardvark",
                "Albatross",
                "Alligator",
                "Alpaca",
                "Ant",
                "Anteater",
                "Antelope",
                "Ape",
                "Armadillo",
                "Donkey",
                "Baboon",
                "Badger",
                "Barracuda",
                "Bear",
                "Beaver",
                "Bee"
        };
        final List<String> animalsList = new ArrayList(Arrays.asList(animals));
        mGridManager=new LinearLayoutManager(mContext);
        recycle.setLayoutManager(mGridManager);
        mAdapter=new RecycleAdapter(mContext,animalsList);
        recycle.setAdapter(mAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=0;
                String itemLabel=""+random.nextInt(1000);
                animalsList.add(position,""+itemLabel);
                mAdapter.notifyItemInserted(position);
                recycle.scrollToPosition(position);
                Toast.makeText(mContext,"Added item",Toast.LENGTH_LONG);
            }
        });

    }

}
