package com.example.giannisavini.lab02;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lsvsStates;
    private TextView txtClickedItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lsvsStates = (ListView) findViewById(R.id.lsv_state);
        //List<State> states = new ArrayList<>();
        String[] states = {"Italia", "Regno Unito", "Francia", "Germania", "Spagana", "Svizzera",
                            "Belgio", "Portogallo", "Austria", "Norvegia", "Svezia", "Finlandia"};
        ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(this, R.layout.list_item_state ,R.id.txv_state, states);
        lsvsStates.setAdapter(stateAdapter);

        lsvsStates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = (String) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, itemClicked, Toast.LENGTH_SHORT).show();
            }
        });
        /*
        lsvsStates.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String itemClicked = (String) parent.getItemAtPosition(position);
                new AlertDialog().Builder(MainActivity.this)
                return false;
            }
        });
        */
    }
}
