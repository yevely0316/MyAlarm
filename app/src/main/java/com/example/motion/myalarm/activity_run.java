package com.example.motion.myalarm;

import android.content.ContentResolver;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class activity_run extends AppCompatActivity implements View.OnClickListener {

    private ContentResolver res;
    boolean isPlaying = true;
    private int position;
    private ArrayList<MySdSound> sdlist;
    private MediaPlayer mediaPlayer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_alarm);
        Intent intent = getIntent();
        MediaPlayer mediaPlayer = new MediaPlayer();

        position = intent.getIntExtra("position", 0);
        sdlist = (ArrayList<MySdSound>) intent.getSerializableExtra("playList");
        res = getContentResolver();

        Button stop = (Button) findViewById(R.id.stop_playing_Alarm);
        Button play = (Button) findViewById(R.id.again_playing_Alarm);

        stop.setOnClickListener(this);
        play.setOnClickListener(this);

        playMusic(sdlist.get(position));

    }

    public void playMusic(MySdSound mysdsound) {
        try {
            Uri musicURI = Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, "" + mysdsound.getId());
            mediaPlayer.reset();
            mediaPlayer.setDataSource(this, musicURI);
            mediaPlayer.prepare();
            mediaPlayer.start();

        }
        catch (Exception e) {
            // TODO: 2017-07-07 Exception에서는 어떤한 원인으로 발생했는지 로그를 출력 할 수 있기때문에 로그를 출력해주는게 좋아요
            Log.e("e", "음악 불러오기 오류", e);
        }
    }


    @Override
    public void onClick(View v) {

    }
}
