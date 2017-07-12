package com.example.motion.myalarm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

//클래스 이름에는 _를 주지 않아요
public class MySdSoundAdapter extends BaseAdapter {

    List<MySdSound> list;
    LayoutInflater inflater;
    Activity activity;

    public MySdSoundAdapter(Activity activity, List<MySdSound> list) {
        this.list = list;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
}

    @Override
    public int getCount() {
        return list.size();
    }

    // TODO: 2017-07-07 getItem 메소드의 리턴값은 리스트에 출력되는 값을 리턴시키면 되요
    @Override
    public Object getItem(int position) {
        return list.get(position);
        //        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            // TODO: 2017-07-07 리스트 adapter는 별도의 layout을 생성하여 사용해야해요
            convertView = inflater.inflate(R.layout.item_my_music_list, parent, false);
            //            convertView = inflater.inflate(R.layout.set_sound, parent, false);
            //            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            //            convertView.setLayoutParams(layoutParams);
        }

        TextView title = (TextView) convertView.findViewById(R.id.title);
        title.setText(list.get(position).getTitle());

        TextView artist = (TextView) convertView.findViewById(R.id.artist);
        artist.setText(list.get(position).getArtist());

        return convertView;
    }

}
