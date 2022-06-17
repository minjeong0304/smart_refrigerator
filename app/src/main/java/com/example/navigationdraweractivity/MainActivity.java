package com.example.navigationdraweractivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.navigationdraweractivity.ui.recipe.RecipeFragment;
import com.example.navigationdraweractivity.ui.home.HomeFragment;
import com.example.navigationdraweractivity.ui.kcal.KcalFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.appcompat.app.AppCompatActivity;

import com.example.navigationdraweractivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private BottomNavigationView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private HomeFragment homeFragment;
    private RecipeFragment recipeFragment;
    private KcalFragment slideshowFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        setSupportActionBar(binding.appBarMain.toolbar);

        bottomNavigationView = findViewById(R.id.BottomNavi);
        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener(){

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        setFrag(0);
                        break;
                    case R.id.gallery:
                        setFrag(1);
                        break;
                    case R.id.slideshow:
                        setFrag(2);
                        break;
                }
                return true;
            }
        });
        homeFragment = new HomeFragment();
        recipeFragment = new RecipeFragment();
        slideshowFragment = new KcalFragment();
        setFrag(0);  // 첫 프래그먼트 화면을 무엇으로 지정해줄 것인지 선택


    }

    private void setFrag(int n){

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (n){
            case 0:
                ft.replace(R.id.main_frame, homeFragment);
                ft.commit();
                break;
            case 1:
                ft.replace(R.id.main_frame, recipeFragment);
                ft.commit();
                break;
            case 2:
                ft.replace(R.id.main_frame, slideshowFragment);
                ft.commit();
                break;
        }

    }

}