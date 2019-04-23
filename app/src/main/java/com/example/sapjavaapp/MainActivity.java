package com.example.sapjavaapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class MainActivity extends AppCompatActivity {

    static String[][] spaceProbes = {
            {"1", "Peter", "stone", "Mars"},
            {"2", "Vlad", "chemical", "Veneer"},
            {"3", "Victor", "water", "Neptun"},
            {"4", "Oleg", "snow", "Saturn"},
            {"5", "Sasha", "solar", "Moon"}

    };
    static String[] spaceProbeHeaders = {"No", "Name", "Propellant", "Destination"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        final TableView<String[]> tableView = findViewById(R.id.tableView);

        tableView.setHeaderBackgroundColor(Color.parseColor("#2ecc71"));
        tableView.setHeaderAdapter(new SimpleTableHeaderAdapter(this, spaceProbeHeaders));
        tableView.setColumnCount(4);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tableView.setDataAdapter(new SimpleTableDataAdapter(MainActivity.this, spaceProbes));
            }
        });

        tableView.addDataClickListener(new TableDataClickListener<String[]>() {
            @Override
            public void onDataClicked(int rowIndex, String[] clickedData) {
                Toast.makeText(MainActivity.this, clickedData[3], Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
