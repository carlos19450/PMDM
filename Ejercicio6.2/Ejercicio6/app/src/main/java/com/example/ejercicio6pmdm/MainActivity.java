package com.example.ejercicio6pmdm;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.ejercicio6pmdm.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private NavController optionsActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());
        setSupportActionBar(binding.toolbar);
        //Drawer
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                // Top-level destinations:
                R.id.drawer1Fragment, R.id.drawer2Fragment
        )
                .setOpenableLayout(binding.drawerLayout)
                .build();

        NavController drawer = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_drawer)).getNavController();
        NavigationUI.setupWithNavController(binding.navView, drawer);
        NavigationUI.setupWithNavController(binding.toolbar, drawer, appBarConfiguration);
        //Bottom
        NavController bottom = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_botton)).getNavController();
        NavigationUI.setupWithNavController(binding.bottomNavView, bottom);
        NavigationUI.setupWithNavController(binding.toolbar, bottom);
        //OptionsActivity
        AppBarConfiguration appBarConfiguration2 = new AppBarConfiguration.Builder(
                R.id.options1Fragment, R.id.options2Fragment
        )
                .build();

        optionsActivity = ((NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment_options_activity)).getNavController();
        NavigationUI.setupWithNavController(binding.toolbar, optionsActivity, appBarConfiguration2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return NavigationUI.onNavDestinationSelected(item, optionsActivity)
                || super.onOptionsItemSelected(item);
    }
}



