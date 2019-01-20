package com.example.tanmay.timetable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    public void generateTable(int timeTable){

        ArrayList<String> content = new ArrayList<>();
        for(int i=1; i<=10;i++)
        {
            content.add(Integer.toString(timeTable)+" x "+ Integer.toString(i)+" = "+Integer.toString(i*timeTable));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, content);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar= findViewById(R.id.seekBar);
        listView= findViewById(R.id.list);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress<1) {
                    progress = 1;
                    seekBar.setProgress(1);
                }
                generateTable(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        generateTable(10);
    }
}
