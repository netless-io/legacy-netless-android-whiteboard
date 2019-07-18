package com.netless.whiteboard.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import com.herewhite.sdk.AbstractPlayerEventListener;
import com.herewhite.sdk.Player;
import com.herewhite.sdk.WhiteBroadView;
import com.herewhite.sdk.WhiteSdk;
import com.herewhite.sdk.WhiteSdkConfiguration;
import com.herewhite.sdk.domain.DeviceType;
import com.herewhite.sdk.domain.PlayerConfiguration;
import com.herewhite.sdk.domain.PlayerPhase;
import com.herewhite.sdk.domain.Promise;
import com.herewhite.sdk.domain.SDKError;
import com.netless.whiteboard.R;

public class ReplayPageActivity extends AppCompatActivity {

    private static final int SEEK_BAR_SCALE_COUNT = 1000;

    private Player player;

    private boolean didLeave = false;
    private boolean isPlaying = false;
    private boolean isTracking = false;
    private long trackingTime = 0;

    private ProgressBar icoLoading;
    private SeekBar seekBar;
    private Button btnGoBack;
    private Button btnOperation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_replay_page);

        this.icoLoading = findViewById(R.id.icoLoading);
        this.btnGoBack = findViewById(R.id.btnGoBack);
        this.btnOperation = findViewById(R.id.btnOperation);
        this.seekBar = findViewById(R.id.seekBar);

        this.icoLoading.getIndeterminateDrawable().setColorFilter(
                getResources().getColor(R.color.colorGrayBorder),
                android.graphics.PorterDuff.Mode.SRC_IN
        );
        this.setEnable(false);

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
            public void onPhaseChanged(final PlayerPhase phase) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onPlayerPhaseChanged(phase);
                    }
                });
            }

            @Override
            public void onScheduleTimeChanged(final long time) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onPlayerScheduleTimeChanged(time);
                    }
                });
            }

        }, new Promise<Player>() {

            @Override
            public void then(final Player player) {
                setupPlayer(player);
            }

            @Override
            public void catchEx(final SDKError sdkError) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast(sdkError.getMessage());
                    }
                });
            }
        });
        this.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (isTracking) {
                    trackingTime = i;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isTracking = true;
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                isTracking = false;
                onSeekTo(trackingTime);
            }
        });
        this.btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onClickGoBack();
                    }
                });
            }
        });
        this.btnOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        onClickOperation();
                    }
                });
            }
        });
    }

    private void setEnable(boolean enable) {
        this.btnOperation.setEnabled(enable);
    }

    private void setupPlayer(Player player) {
        this.player = player;

        if (this.didLeave) {
            player.stop();
        } else {
            this.icoLoading.setVisibility(View.INVISIBLE);
            this.setEnable(true);
        }
    }

    private void onPlayerPhaseChanged(PlayerPhase phase) {
        if (phase == PlayerPhase.buffering || phase == PlayerPhase.waitingFirstFrame) {
            this.btnOperation.setEnabled(false);
            this.btnOperation.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_player_play, 0, 0, 0);
            this.icoLoading.setVisibility(View.VISIBLE);

        } else {
            this.btnOperation.setEnabled(true);
            this.icoLoading.setVisibility(View.INVISIBLE);

            if (phase == PlayerPhase.playing) {
                this.btnOperation.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_player_pause, 0, 0, 0);
            } else {
                this.btnOperation.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_player_play, 0, 0, 0);
            }
        }
    }

    private void onPlayerScheduleTimeChanged(long time) {
        if (!this.isTracking) {
            double progressRate = (double) time / (double) this.player.getPlayerTimeInfo().getTimeDuration();
            int progress = (int) (progressRate * SEEK_BAR_SCALE_COUNT);
            this.seekBar.setProgress(progress);
        }
    }

    private void onSeekTo(long time) {
        double progressRate = (double) time / (double) SEEK_BAR_SCALE_COUNT;
        long progressTime = (int) (progressRate * this.player.getPlayerTimeInfo().getTimeDuration());
        this.player.seekToScheduleTime(progressTime);
    }

    private void onClickGoBack() {
        if (this.player != null) {
            player.stop();
        }
        this.didLeave = true;
        this.finish();
    }

    private void onClickOperation() {
        this.isPlaying = !this.isPlaying;

        if (this.isPlaying) {
            this.player.play();
        } else {
            this.player.pause();
        }
    }

    private void showToast(Object o) {
        Toast.makeText(this, o.toString(), Toast.LENGTH_SHORT).show();
    }
}
