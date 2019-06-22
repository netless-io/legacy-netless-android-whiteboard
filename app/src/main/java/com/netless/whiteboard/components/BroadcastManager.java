package com.netless.whiteboard.components;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.herewhite.sdk.Room;
import com.herewhite.sdk.domain.ViewMode;
import com.netless.whiteboard.R;

public class BroadcastManager {

    private final Context context;
    private final Button btnCamera;

    private Room room;
    private ViewMode viewMode = ViewMode.Freedom;
    private boolean hasBroadcaster = false;
    private boolean didDispose = false;

    public BroadcastManager(Context context, Button btnCamera) {
        this.context = context;
        this.btnCamera = btnCamera;
        this.btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickCamera();
            }
        });
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setState(ViewMode viewMode, boolean hasBroadcaster) {
        if (viewMode == ViewMode.Broadcaster) {
            this.btnCamera.setBackgroundResource(R.drawable.ic_highlight_primary_round_button);
        } else {
            this.btnCamera.setBackgroundResource(R.drawable.ic_primary_round_button);
        }
        this.viewMode = viewMode;
        this.hasBroadcaster = hasBroadcaster;
    }

    public void dispose() {
        this.didDispose = true;
    }

    private void onClickCamera() {
        if (this.room != null) {
            if (this.hasBroadcaster) {
                // TODO

            } else if (this.viewMode == ViewMode.Broadcaster) {
                this.room.setViewMode(ViewMode.Freedom);
                this.showToast("退出演讲模式，他人不再跟随你的视角");

            } else {
                this.room.setViewMode(ViewMode.Broadcaster);
                this.showToast("进入演讲模式，他人将会跟随你的视角");
            }

        }
    }

    private void showToast(String text) {
        if (!this.didDispose) {
            Toast.makeText(this.context, text, Toast.LENGTH_SHORT).show();
        }
    }
}
