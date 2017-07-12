package com.example.motion.myalarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


//클래스 이름이 명확해야해요, ex) AddAlarmActivity
public class activity_set_alarm extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 나중에 리소스 파일이 많아지면 어느 화면에 적용되는 xml 파일인지 모를수 있기 때문에 activity로 시작하는게 좋아요
        setContentView(R.layout.set_alarm);

        // 리소스 이름은 소문자로만, 각 단어 사이에는 _ 추가
        Button setButton = (Button) findViewById(R.id.setAlarm_submit);
        setButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 아래와 동일한 동작을 하는 로직은 하나의 메소드로 묶는게 좋아요
                clickResult();
            }
        });
        Button cencleButton = (Button) findViewById(R.id.setAlarm_cencel);
        cencleButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                clickResult();
            }
        });

        //액티비티를 하나 생성했으면 원하는 동작에서 잘 나오는지를 먼저 확인해야해요
        findViewById(R.id.layout_set_sound).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_set_alarm.this, SetSoundActivity.class));
            }
        });

        findViewById(R.id.layout_set_repeat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_set_alarm.this, RepeatActivity.class));
            }
        });
        findViewById(R.id.layout_set_replay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_set_alarm.this, activity_replay_alarm.class));
            }
        });
    }


    // 메소드 이름은 낙타 표기법으로
    // https://google.github.io/styleguide/javaguide.html#s5.2.3-method-names 참조
    // 메소드 이름은 소문자로 정의하고, 언더바는 넣지 않는다.
    public void clickResult() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }
}