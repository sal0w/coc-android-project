package com.parse.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    List<Base> bases = new ArrayList<Base>();
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*ParseQuery<Base> query =new ParseQuery<Base>("salow");
        query.findInBackground(new FindCallback<Base>() {
            @Override
            public void done(List<Base> objects, ParseException e) {

                if (e != null) {

                    Toast.makeText(MainActivity.this, "Error" + e, Toast.LENGTH_SHORT).show();
                }
                for (Base base : objects) {

                    Base newbase = new Base();
                    newbase.setBase(base.getBase());
                    newbase.setDescription(base.getDescription());
                    newbase.setImage(base.getImage());
                    newbase.setName(base.getName());
                    newbase.setTownhall(base.getTownhall());
                    bases.add(newbase);


                }
                //Toast.makeText(SearchActivity.this, "Error" + e, Toast.LENGTH_SHORT).show();
            }
        });*/


        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, UploadActivity.class);
                startActivity(intent);


            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    ///pass what base

    public void passWhatBase(){
        int sectionNumber =mViewPager.getCurrentItem();
        Boolean war = true;
        Boolean village = false;
        WhatBase obj = new WhatBase();
        if (sectionNumber == 0){
            obj.setBolBase(village);
        }
        else if (sectionNumber == 1){
            obj.setBolBase(war);

        }


    }


    /////Buttons

    public void TownHall1(View v){
        passWhatBase();
        PassBase object =new PassBase();
        object.setBaseNumber(1);
        Intent intent = new Intent (MainActivity.this, SearchActivity.class);
        startActivity(intent);



    }

    public void TownHall2(View v){

        passWhatBase();
        PassBase object =new PassBase();
        object.setBaseNumber(2);
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);



    }

    public void TownHall3(View v){


        passWhatBase();
        PassBase object =new PassBase();
        object.setBaseNumber(3);
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);



    }

    public void TownHall4(View v){


        passWhatBase();
        PassBase object =new PassBase();
        object.setBaseNumber(4);
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);



    }

    public void TownHall5(View v){


        passWhatBase();
        PassBase object =new PassBase();
        object.setBaseNumber(5);
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);



    }

    public void TownHall6(View v){


        passWhatBase();
        PassBase object =new PassBase();
        object.setBaseNumber(6);
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);



    }

    public void TownHall7(View v){


        passWhatBase();
        PassBase object =new PassBase();
        object.setBaseNumber(7);
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);



    }

    public void TownHall8(View v){


        passWhatBase();
        PassBase object =new PassBase();
        object.setBaseNumber(8);
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);



    }

    public void TownHall9(View v){


        passWhatBase();
        PassBase object =new PassBase();
        object.setBaseNumber(9);
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);



    }

    public void TownHall10(View v){


        passWhatBase();
        PassBase object =new PassBase();
        object.setBaseNumber(10);
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);



    }

    public void TownHall11(View v){






    }

    public void TownHall12(View v){






    }

    /////buttons










    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_signin) {
            // Handle the camera action
        }
        else if (id == R.id.nav_favorite) {

        }
        else if (id == R.id.nav_share) {

        }
        else if (id == R.id.nav_send) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Home Village";
                case 1:
                    return "War Base";

            }
            return null;
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";



        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */











        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();

            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);





            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {



            View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            //Log.d("sal ", getString(getArguments().getInt(ARG_SECTION_NUMBER)));



            return rootView;
        }
    }

}
