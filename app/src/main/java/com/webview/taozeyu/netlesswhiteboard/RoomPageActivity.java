package com.webview.taozeyu.netlesswhiteboard;

import com.herewhite.sdk.*;
import com.herewhite.sdk.domain.*;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class RoomPageActivity extends AppCompatActivity {

    private WhiteSdk whiteSdk;
    private Room room;
    private boolean didLeave = false;

    private Button btnGoBack;
    private Button btnInvite;
    private Button btnCamera;
    private Button btnSlides;
    private Button btnUpload;

    private View appliancesToolbar;
    private Button btnSelector;
    private Button btnPencil;
    private Button btnText;
    private Button btnEraser;
    private Button btnEllipse;
    private Button btnRectangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_room_page);

        this.btnGoBack = findViewById(R.id.btnGoBack);
        this.btnInvite = findViewById(R.id.btnInvite);
        this.btnCamera = findViewById(R.id.btnCamera);
        this.btnSlides = findViewById(R.id.btnSlides);
        this.btnUpload = findViewById(R.id.btnUpload);

        this.appliancesToolbar = findViewById(R.id.appliancesToolbar);
        this.btnSelector = findViewById(R.id.btnSelector);
        this.btnPencil = findViewById(R.id.btnPencil);
        this.btnText = findViewById(R.id.btnText);
        this.btnEraser = findViewById(R.id.btnEraser);
        this.btnEllipse = findViewById(R.id.btnEllipse);
        this.btnRectangle = findViewById(R.id.btnRectangle);

        this.setButtonsEnable(false);

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
                if (RoomPageActivity.this.didLeave) {
                    room.disconnect();
                }
            }

            @Override
            public void catchEx(SDKError sdkError) {
                showToast(sdkError.getMessage());
            }
        });

        this.btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoBack();
            }
        });
    }

    private void setButtonsEnable(boolean enable) {
        if (!this.didLeave) {
            this.btnInvite.setEnabled(enable);
            this.btnCamera.setEnabled(enable);
            this.btnSlides.setEnabled(enable);
            this.btnUpload.setEnabled(enable);
        }
    }

    private void onClickGoBack() {
        if (this.room != null) {
            room.disconnect();
        }
        this.didLeave = true;
        this.finish();
    }

    private void onRoomPhaseChange(RoomPhase phase) {
        if (phase == RoomPhase.connected) {
            this.showToast("连接成功");
            this.setButtonsEnable(true);

        } else if (phase == RoomPhase.disconnected) {
            this.showToast("断开连接");
            this.setButtonsEnable(false);

        } else if (phase == RoomPhase.reconnecting) {
            this.showToast("重新建立连接");
            this.setButtonsEnable(false);
        }
    }

    private void showToast(Object o) {
        if (!this.didLeave) {
            Toast.makeText(this, o.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
