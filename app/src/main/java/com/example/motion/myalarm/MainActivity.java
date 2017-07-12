package com.example.motion.myalarm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.*;

//findViewById는 해당하는 클래스에서 찾아옴
public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_MENU = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //다른 메소드에서 사용하지 않는 맴버변수인 경우 로컬변수로 처리
        ListView lvAlarm = (ListView) findViewById(R.id.list_alarm);
        ArrayList<MyAlarm> myAlarms = new ArrayList<>();
        myAlarms.add(new MyAlarm("PM", "4:07", "앱 만들기 UI 1번째 수행중", "다시 알림 5분"));

        // TODO: 2017-07-11 필요없는 생성자 값 제거하고 객체 생성하기
        // adaptor 에게 값을 넘겨줘야함

        MyArrayAdaptor adaptor = new MyArrayAdaptor();
        adaptor.additem(new MyAlarm("PM", "4:07", "앱 만들기 UI 1번째 수행중", "다시 알림 5분"));
        lvAlarm.setAdapter(adaptor);



        // 레이아웃에 클릭 이벤트를 주고싶으면 먼저 레이아웃에 id를 할당하고 클릭 이벤트를 할당하면 되요
        findViewById(R.id.layout_add_alarm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_set_alarm.class);
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });

        Button listAlarm_setbtn = (Button) findViewById(R.id.button_add_alarm);
        listAlarm_setbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_set_alarm.class);
                // startActivityForResult메소드를 이용해서 Acitivty를 열었을 때는 Result를 받을 수 있는 메소드를 선언해야해요
                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}