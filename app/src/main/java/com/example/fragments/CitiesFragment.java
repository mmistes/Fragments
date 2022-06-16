package com.example.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class CitiesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String [] cities = getResources().getStringArray(R.array.cities);

        for (int i = 0; i < cities.length; i++){
            String city = cities[i];
            TextView tv = new TextView(getContext());
            tv.setText(city);
            tv.setTextSize(28);
            layoutView.addView(tv);
            final int position = i;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showCoatOfArms(position);
                }
            });
        }
    }

    private void showCoatOfArms(int position) {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            showLandCoatOfArms(position);
        }
        else {
            showPortraitCoatOfArms(position);
        }

    }

    private void showLandCoatOfArms(int position) {
        CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(position);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        //.addToBackStack(null) - добавляет фрагменты в бэкстек, чтобы можно было вернуться к предыдущему
        //фрагменту с помощью кнопки назад
        //Корневые фрагменты не нужно добавлять в бэкстек (Мэйн активити -> ситис фрагмент(корневой) - коат оф армс фрагмент(дочерний))
        // .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) базовая анимация из класса FragmentTransaction
        fragmentManager
                .beginTransaction()
                .replace(R.id.coat_of_arms_image_container, coatOfArmsFragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    private void showPortraitCoatOfArms(int position) {
        CoatOfArmsFragment coatOfArmsFragment = CoatOfArmsFragment.newInstance(position);
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        //.addToBackStack(null) - добавляет фрагменты в бэкстек, чтобы можно было вернуться к предыдущему
        //фрагменту с помощью кнопки назад
        //Корневые фрагменты не нужно добавлять в бэкстек (Мэйн активити -> ситис фрагмент(корневой) - коат оф армс фрагмент(дочерний))
        // .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE) базовая анимация из класса FragmentTransaction
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, coatOfArmsFragment)
                .addToBackStack(null)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }
}