package com.netless.whiteboard.components;

import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.netless.whiteboard.R;

public class SlidesTable {

    private ListView listView;
    private String datas[]={ "Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday" };//准备数据源

    public SlidesTable(AppCompatActivity activity) {
        this.listView = activity.findViewById(R.id.listView);
        ArrayAdapter adapter = new ArrayAdapter<String>(activity, android.R.layout.simple_list_item_1, datas);
        this.listView.setAdapter(adapter);
    }
}
