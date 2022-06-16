package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CitiesFragment citiesFragment = new CitiesFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, citiesFragment)
                .commit();


        //Если горизонтальная ориентация
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            //Если мы ещё не создавали фрагменты
            CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(0);
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.coat_of_arms_image_container, coatOfArmsFragment)
                    .commit();
        }
    }
    
}