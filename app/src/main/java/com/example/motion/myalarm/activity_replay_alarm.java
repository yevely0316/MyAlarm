package com.example.motion.myalarm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Motion on 2017-07-12.
 */

public class activity_replay_alarm extends AppCompatActivity {
    private ListView replayListView;
    private List<Replay> replays;
    private String[] minuteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.replay_alarm);

        minuteArray = getResources().getStringArray(R.array.eachminute);

        replays = new ArrayList<>();
        for (String replay : minuteArray) {
            replays.add(new Replay(replay, false));
        }
        replayListView = (ListView) findViewById(R.id.item_list_replay);

        MyReplayAdapter myAdapter = new MyReplayAdapter(this, replays);
        replayListView.setAdapter(myAdapter);
    }
}
