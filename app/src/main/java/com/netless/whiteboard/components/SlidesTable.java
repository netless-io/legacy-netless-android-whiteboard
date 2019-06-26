package com.netless.whiteboard.components;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.herewhite.sdk.domain.Scene;
import com.netless.whiteboard.R;

public class SlidesTable extends BaseAdapter {

    private final AppCompatActivity activity;
    private final ListView listView;
    private Scene[] scenes = new Scene[] {};

    public SlidesTable(AppCompatActivity activity) {
        this.activity = activity;
        this.listView = activity.findViewById(R.id.listView);
        this.listView.setAdapter(this);
    }

    public void setScene(Scene[] scenes) {
        this.scenes = scenes;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return this.scenes.length;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return this.scenes[i];
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.activity).inflate(R.layout.room_page_slide, viewGroup, false);
        }
        TextView textView = view.findViewById(R.id.text);
        Scene scene = this.scenes[i];

        textView.setText(scene.getName());

        return view;
    }
}
