package com.example.ejercicio6pmdm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.ejercicio6pmdm.databinding.ActivityBottomBinding;
import com.example.ejercicio6pmdm.databinding.ActivityDrawerBinding;
import com.example.ejercicio6pmdm.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityDrawerBinding binding1;
    ActivityBottomBinding binding2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Drawer
        setContentView((binding1 = ActivityDrawerBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding1.toolbar);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                // Top-level destinations:
                R.id.drawer1Fragment, R.id.drawer2Fragment
        )
                .setOpenableLayout(binding1.drawerLayout)
                .build();

        NavController navController1 = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding1.navView, navController1);
        NavigationUI.setupWithNavController(binding1.toolbar, navController1, appBarConfiguration);
        //Bottom
        setContentView((binding2 = ActivityBottomBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding2.toolbar);

        NavController navController2 = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)).getNavController();
        NavigationUI.setupWithNavController(binding2.bottomNavView, navController2);
        NavigationUI.setupWithNavController(binding2.toolbar, navController2);
    }
}


