package com.example.motion.myalarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdaptor extends BaseAdapter {

    private List<MyAlarm> myAlarms;

    public MyArrayAdaptor() {
        myAlarms = new ArrayList<>();
    }

    public void additem(MyAlarm myAlarm) {
        myAlarms.add(myAlarm);
        notifyDataSetChanged();
    }

    @Override // 어댑터에 몇 개의 항목이 있는지 조사
    public int getCount() {
        return myAlarms.size();
    }

    @Override //arA의 positon에 해당하는 깂을 가져옴
    public Object getItem(int position) {
        return myAlarms.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view, parent, false);
        }

        TextView typetext = (TextView) convertView.findViewById(R.id.type_alarm);
        typetext.setText(myAlarms.get(position).getType());

        TextView timetext = (TextView) convertView.findViewById(R.id.time_alarm);
        timetext.setText(myAlarms.get(position).getTime());

        TextView memotext = (TextView) convertView.findViewById(R.id.memo_alarm);
        memotext.setText(myAlarms.get(position).getMemo());

        TextView againtext = (TextView) convertView.findViewById(R.id.again_alarm);
        againtext.setText(myAlarms.get(position).getAgainTime());

        return convertView;
    }



}



