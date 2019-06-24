package com.netless.whiteboard.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.herewhite.sdk.AbstractPlayerEventListener;
import com.herewhite.sdk.Player;
import com.herewhite.sdk.WhiteBroadView;
import com.herewhite.sdk.WhiteSdk;
import com.herewhite.sdk.WhiteSdkConfiguration;
import com.herewhite.sdk.domain.DeviceType;
import com.herewhite.sdk.domain.PlayerConfiguration;
import com.herewhite.sdk.domain.Promise;
import com.herewhite.sdk.domain.SDKError;
import com.netless.whiteboard.R;

public class ReplayPageActivity extends AppCompatActivity {

    private Player player;
    private boolean didLeave = false;

    private ProgressBar icoLoading;
    private Button btnGoBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_replay_page);

        this.icoLoading = findViewById(R.id.icoLoading);
        this.btnGoBack = findViewById(R.id.btnGoBack);

        WhiteBroadView whiteBroadView = findViewById(R.id.whiteboard);
        WhiteSdkConfiguration configuration = new WhiteSdkConfiguration(DeviceType.touch, 10, 0.1);
        WhiteSdk whiteSdk = new WhiteSdk(whiteBroadView, this, configuration);

        Bundle bundle = this.getIntent().getExtras();
        PlayerConfiguration playerConfiguration = new PlayerConfiguration(
                bundle.getString("uuid"),
                bundle.getString("roomToken")
        );
        whiteSdk.createPlayer(playerConfiguration, new AbstractPlayerEventListener() {

            @Override
            public void onLoadFirstFrame() {
                ReplayPageActivity.this.onLoadFirstFrame();
            }

        }, new Promise<Player>() {

            @Override
            public void then(Player player) {
                ReplayPageActivity.this.player = player;
                setupPlayer(player);
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

    private void onLoadFirstFrame() {
        this.icoLoading.setVisibility(View.INVISIBLE);
    }

    private void setupPlayer(Player player) {
        if (this.didLeave) {
            player.stop();
        } else {
            player.play();
        }
    }

    private void onClickGoBack() {
        if (this.player != null) {
            player.stop();
        }
        this.didLeave = true;
        this.finish();
    }


    private void showToast(Object o) {
        Toast.makeText(this, o.toString(), Toast.LENGTH_SHORT).show();
    }
}
