package com.parse.starter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

public class SearchActivity extends AppCompatActivity {

    /*List<Base> bases = new ArrayList<Base>();
    private ParseQueryAdapter<ParseObject> mainAdapter;*/
    Boolean war = true;
    Boolean vilage= false;
    Boolean whatBase;
    int Basenumber;
    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;

    private ParseGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        whatBase= WhatBase.getBolBase();
        Basenumber = PassBase.getBaseNumber();
        /*String ad = String.valueOf(Basenumber);

        Toast.makeText(SearchActivity.this, ad, Toast.LENGTH_SHORT).show();
*/
        /*if (whatBase == war){
            Toast.makeText(SearchActivity.this, "War ", Toast.LENGTH_SHORT).show();
        }
        else if (whatBase == vilage){

            Toast.makeText(SearchActivity.this, "villlage ", Toast.LENGTH_SHORT).show();
        }
*/



        ParseQueryAdapter.QueryFactory<Base> factory = new ParseQueryAdapter.QueryFactory<Base>() {
            @Override
            public ParseQuery<Base> create() {
                ParseQuery query = new ParseQuery("salow");
                query.whereNotEqualTo("Base", whatBase);
                query.whereEqualTo("Townhall",Basenumber);
                return query;
            }
        };



        mRecyclerView = (RecyclerView) findViewById(R.id.list);

        adapter = new ParseGridAdapter(this,factory,true);

        mRecyclerView.setAdapter(adapter);
        adapter.loadObjects();


        ParseGridAdapter.OnItemClickListener onItemClickListener = new ParseGridAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Base base,View v, int position) {
                String ad = base.getName();
                CopyBase obi = new CopyBase(base);

                Intent intent = new Intent(SearchActivity.this, ScrollingActivity.class);
               /* Bundle bundle = new Bundle();
                bundle.putParcelable("mylist", ads);
                intent.putExtras(bundle);*/

                startActivity(intent);



            }
        };
        adapter.setOnItemClickListener(onItemClickListener);

        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);







        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Wait for Update", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
