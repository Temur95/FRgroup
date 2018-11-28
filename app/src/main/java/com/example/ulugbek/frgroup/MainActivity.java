package com.example.ulugbek.frgroup;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity{

    DrawerLayout mDrawerLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //BOttomNavigationViewListener
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        //to open HomeFragment first instead of MainActivity
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout, new HomeFragment()).commit();


        //NavigationViewListener
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(navDrawerListener);

        //toolbar setting menu drawerButton
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_drawer_menu);

        //DrawerLayout implementing
        mDrawerLayout = findViewById(R.id.drawerLayout);


    }

    //set drawerMenuButton to auto open NavigationDrawerMenu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            case R.id.logout:
                confirmExit();
                break;
            case R.id.myAccount:

                Intent intent = new Intent(this,MyAccount.class);
                startActivity(intent);
                finish();
                break;

        }
        return true;
    }




    //NagivationDrawerListener
    private NavigationView.OnNavigationItemSelectedListener navDrawerListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            android.support.v4.app.Fragment selectFragment = null;
            DrawerLayout mDrawerLayout = findViewById(R.id.drawerLayout);

            switch (item.getItemId()){

                case R.id.drawerLayout_menu_client:
                    selectFragment = new ClientFragment();
                    break;
                case R.id.drawerLayout_menu_dealer:
                    selectFragment = new DealerFragment();
                    break;
                case R.id.drawerLayout_menu_term:
                    selectFragment = new TermsFragment();
                    break;
                case R.id.drawerLayout_menu_about:
                    selectFragment = new AboutFragment();
                    break;
                case R.id.drawerLayout_menu_log_out:
//                        Intent i = new Intent(MainActivity.this,Login.class);
//                        startActivity(i);
//                        finish();
                    break;

            }
 
            getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,selectFragment).commit();
            //close Drawer when menu item tapped
            mDrawerLayout.closeDrawers();
            return true;

        }
    };

    //BOttomNavigationViewListener
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            android.support.v4.app.Fragment selectFragment = null;

            switch (item.getItemId()){

                case R.id.bottomNavigation_menu_home:
                    selectFragment = new HomeFragment();
                    break;
                case R.id.bottomNavigation_menu_popular:
                    selectFragment = new PopFragment();
                    break;
                case R.id.bottomNavigation_menu_auction:
                    selectFragment = new AuctionFragment();
                    break;
                case R.id.bottomNavigation_menu_catalog:
                    selectFragment = new com.example.ulugbek.frgroup.ListFragment();
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.main_frameLayout,selectFragment).commit();
            return true;

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    public void confirmExit(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Spiders");
        builder.setMessage("Do you want to log out?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
//                        SharedPreferences my = getSharedPreferences("login",MODE_PRIVATE);
//                        my.edit().remove("username").commit();
//                        my.edit().remove("password").commit();

                        FirebaseAuth.getInstance().signOut();

                        Intent intent = new Intent(MainActivity.this, Login.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }


}

