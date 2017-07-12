package com.example.motion.myalarm;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

//클래스 이름이 명확해야해요, ex) AddAlarmActivity
public class SetSoundActivity extends AppCompatActivity {

    private static final int REQUEST_READ_EXTERNAL_STORAGE_PERMISSION = 1001;
    private ListView mySdSoundList;

    public ArrayList<MySdSound> setMySdSounds;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_sound);

        setMySdSounds = new ArrayList<>(); // 음악아이디, 앨범아이디, 제목, 아티스트 불러오기
        mySdSoundList = (ListView) findViewById(R.id.my_sd_music_list);

        getMySdSound();

        MySdSoundAdapter myAdapter = new MySdSoundAdapter(this, setMySdSounds);
        mySdSoundList.setAdapter(myAdapter);

        // TODO: 2017-07-07 리스트 아이템에 클릭 이벤트를 주고 싶으면 listview의 onItemClickListener을 쓰면 되요
    }


    public void getMySdSound() {
        if (checkReadStrogePermisson()) {
            return;
        }

        String[] projection = {MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE, MediaStore.Audio.Media.ARTIST};
        Cursor cursor = getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, projection, null, null, null);
        // TODO: 2017-07-07 cursor는 null이 리턴될 가능성이 큰 아이기 때문에 체크를 항상 해줘야해요
        // TODO: 2017-07-07 cursor의 위치가 첫번째가 아닐 가능성이 있기 때문에 커서를 맨 처음으로 옮겨야해요
        if (cursor == null) {
            return;
        }

        if (cursor.moveToFirst()) {
            // TODO: 2017-07-07 while을 사용하면 맨 처음 리소스 다음부터 추출되기 때문에 do-while을 써야해요

            do {
                MySdSound sdMusic = new MySdSound();
                sdMusic.setId(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media._ID)));
                sdMusic.setTitle(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE)));
                sdMusic.setArtist(cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST)));
                setMySdSounds.add(sdMusic);
            } while (cursor.moveToNext());
        }

        cursor.close();
    }

    private boolean checkReadStrogePermisson() {
        /*
        1. SDK 버전 체크
        2. 이전에 권한이 허용 되어있는지
        3. 허용이 안되어있으면 권한 허용 요청
         */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_READ_EXTERNAL_STORAGE_PERMISSION);
                return true;
            }

            return false;
        }

        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_READ_EXTERNAL_STORAGE_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) { //권한동의 버튼에 동의를 눌렀는지, 안 눌렀는지 확인
                    getMySdSound();
                } else {
                    Toast.makeText(SetSoundActivity.this, "권한사용을 동의해주셔야 이용이 가능합니다.", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }
    }

}
