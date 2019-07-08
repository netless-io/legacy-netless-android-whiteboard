package com.netless.whiteboard.components;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.herewhite.sdk.Room;
import com.netless.whiteboard.R;
import com.netless.whiteboard.config.PPTData;

public class PPTPreviewsTable extends ArrayAdapter<PPTData> {

    private final AppCompatActivity activity;
    private final DrawerLayout panMain;
    private final ListView listView;

    private Room room;

    public PPTPreviewsTable(AppCompatActivity activity, DrawerLayout panMain) {
        super(activity, R.layout.room_page_ppt);
        this.activity = activity;
        this.panMain = panMain;
        this.listView = activity.findViewById(R.id.pptListView);
        this.listView.setAdapter(this);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                onClickPreview(i);
            }
        });
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public int getCount() {
        return PPTData.pptDatas.length;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.activity).inflate(R.layout.room_page_ppt_preview, viewGroup, false);
        }
        PPTData pptData = PPTData.pptDatas[i];
        TextView textDynamicPPT = view.findViewById(R.id.textDynamicPPT);
        final ImageView imageView = view.findViewById(R.id.imgPreview);

        textDynamicPPT.setVisibility(pptData.isDynamicPPT() ? View.VISIBLE : View.INVISIBLE);
        imageView.setImageDrawable(this.activity.getResources().getDrawable(pptData.getResourceId(), this.activity.getApplication().getTheme()));

        return view;
    }

    private void onClickPreview(int index) {
        if (this.room != null) {
            PPTData pptData = PPTData.pptDatas[index];
            String directory = "/defaultPPT" + pptData.getId();
            String scenePath = directory + "/" + pptData.getScenes()[0].getName();

            this.room.putScenes(directory, pptData.getScenes(), 0);
            this.room.setScenePath(scenePath);
            this.panMain.closeDrawer(GravityCompat.START);
        }
    }
}
