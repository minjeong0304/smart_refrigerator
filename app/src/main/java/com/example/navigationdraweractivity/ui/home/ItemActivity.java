package com.example.navigationdraweractivity.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navigationdraweractivity.R;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {

    private Intent intent;
    private String name, kcal, carbs, protein, fat, sugar;
    private ImageView profile, imageView;
    private TextView textView_name, textView_cal, textView_carbs, textView_protein, textView_fat, textView_sugar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_view);

        intent = getIntent();
//        profile = intent.get
        name = intent.getStringExtra( "name");
        kcal = intent.getStringExtra( "kcal");
        carbs = intent.getStringExtra( "carbs");
        protein = intent.getStringExtra("protein");
        fat = intent.getStringExtra("fat");
        sugar = intent.getStringExtra("sugar");

        //imageView = findViewById(R.id.item_detail_image);
        textView_name = findViewById(R.id.item_detail_name);
        textView_cal = findViewById(R.id.item_detail_cal);
        textView_carbs = findViewById(R.id.item_detail_carbs);
        textView_protein = findViewById(R.id.item_detail_protein);
        textView_fat = findViewById(R.id.item_detail_fat);
        textView_sugar = findViewById(R.id.item_detail_sugar);


//        imageView.setImageResource(profile);

        textView_name.setText("식품 : " + name);
        textView_cal.setText("칼로리 : " + kcal + " (kcal)");
        textView_carbs.setText("탄수화물 : " +carbs + " (g)");
        textView_carbs.setText("탄수화물 : " +carbs + " (g)");
        textView_protein.setText("단백질 : " +protein + " (g)");
        textView_fat.setText("지방 : " +fat + " (g)");
        textView_sugar.setText("당 : " + sugar + " (g)");

    }
}
