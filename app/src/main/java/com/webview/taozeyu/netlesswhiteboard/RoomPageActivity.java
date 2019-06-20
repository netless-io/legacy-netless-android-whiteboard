package com.webview.taozeyu.netlesswhiteboard;

import com.herewhite.sdk.*;
import com.herewhite.sdk.domain.*;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class RoomPageActivity extends AppCompatActivity {

    private WhiteSdk whiteSdk;
    private Room room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_page);
        WhiteBroadView whiteBroadView = findViewById(R.id.whiteboard);
        WhiteSdkConfiguration configuration = new WhiteSdkConfiguration(DeviceType.touch, 10, 0.1);

        Bundle bundle = this.getIntent().getExtras();
        RoomParams roomParams = new RoomParams(
                bundle.getString("uuid"),
                bundle.getString("roomToken")
        );
        this.whiteSdk = new WhiteSdk(whiteBroadView, this, configuration);
        this.whiteSdk.joinRoom(roomParams, new AbstractRoomCallbacks() {

            @Override
            public void onPhaseChanged(RoomPhase phase) {
                onRoomPhaseChange(phase);
            }

        }, new Promise<Room>() {

            @Override
            public void then(Room room) {
                RoomPageActivity.this.room = room;
            }

            @Override
            public void catchEx(SDKError sdkError) {
                showToast(sdkError.getMessage());
            }
        });
    }

    private void onRoomPhaseChange(RoomPhase phase) {
        if (phase == RoomPhase.connected) {
            this.showToast("连接成功");

        } else if (phase == RoomPhase.disconnected) {
            this.showToast("断开连接");

        } else if (phase == RoomPhase.reconnecting) {
            this.showToast("重新建立连接");
        }
    }

    private void showToast(Object o) {
        Toast.makeText(this, o.toString(), Toast.LENGTH_SHORT).show();
    }
}
