package com.example.motion.myalarm;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Motion on 2017-07-10.
 */

public class MyRepeatListAdapter extends BaseAdapter {

    List<Repeat> list;
    LayoutInflater inflater;
    Activity activity;

    public MyRepeatListAdapter(RepeatActivity activity, List<Repeat> list) {
        this.list = list;
        this.activity = activity;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_my_repeat_list, parent, false);
        }
        TextView textView = (TextView) convertView.findViewById(R.id.choice_date);
        textView.setText(list.get(position).getDay());

        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkbox_day);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                list.get(position).setChecked(isChecked);
            }
        });

        return convertView;
    }

}
