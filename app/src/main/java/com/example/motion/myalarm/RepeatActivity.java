package com.example.motion.myalarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Motion on 2017-07-10.
 */

public class RepeatActivity extends AppCompatActivity{

    private ListView repeatListView;
    private List<Repeat> repeats;
    private String[] daysArray;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_repeat);

        daysArray = getResources().getStringArray(R.array.days);

        repeats = new ArrayList<>();
        for(String day : daysArray) {
            repeats.add(new Repeat(day, false));
        }

        repeatListView = (ListView) findViewById(R.id.item_list_repeat);

        MyRepeatListAdapter myAdapter = new MyRepeatListAdapter(this, repeats);
        repeatListView.setAdapter(myAdapter);
    }
}
