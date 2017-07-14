package com.example.motion.myalarm;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


//클래스 이름이 명확해야해요, ex) AddAlarmActivity
public class SetActivity extends AppCompatActivity {

    public static final int SetSoundCode = 1001;
    public static final int RepeatCode = 1002;

    int position = 0;

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
                startActivityForResult(new Intent(SetActivity.this, SetSoundActivity.class), SetSoundCode);
            }
        });

        findViewById(R.id.layout_set_repeat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(SetActivity.this, RepeatActivity.class), RepeatCode);
            }
        });
        findViewById(R.id.layout_set_replay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
    }

    void show() {
        final List<String> ListItems = new ArrayList<>();

        ListItems.add("1분");
        ListItems.add("3분");
        ListItems.add("5분");
        ListItems.add("10분");
        ListItems.add("15분");

        final CharSequence[] items = ListItems.toArray(new String[ListItems.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("다시 알림 시간 설정");
        builder.setSingleChoiceItems(items, position, //아이템
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        position = which;

                    }
                });
        builder.setPositiveButton(android.R.string.ok, // ok버튼
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String msg = "";

                        msg = ListItems.get(position); // 사용자가 선택한 값

                        Toast.makeText(SetActivity.this,
                                "다시알림\n" + msg, Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton(android.R.string.cancel, //취소버튼
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();
    }

    // 메소드 이름은 낙타 표기법으로
    // https://google.github.io/styleguide/javaguide.html#s5.2.3-method-names 참조
    // 메소드 이름은 소문자로 정의하고, 언더바는 넣지 않는다.
    public void clickResult() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}