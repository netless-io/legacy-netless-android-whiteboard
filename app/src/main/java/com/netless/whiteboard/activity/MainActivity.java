package com.netless.whiteboard.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;

import com.google.zxing.integration.android.IntentResult;
import com.netless.whiteboard.R;
import com.netless.whiteboard.components.RemoteAPI;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private IntentIntegrator qrScan;

    private Button btnCreateBoard;
    private Button btnJoinBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        qrScan = new IntentIntegrator(this)
                .setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES)
                .setPrompt("请对准二维码")
                .autoWide()
                .setCameraId(0);

        this.btnCreateBoard = findViewById(R.id.btnCreateBoard);
        this.btnJoinBoard = findViewById(R.id.btnJoinBoard);

        btnCreateBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.onClickCreateBoard();
            }
        });
        btnJoinBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.onClickJoinBoard();
            }
        });
    }

    private void onClickCreateBoard() {
        this.setEnableButtons(false);
        RemoteAPI.instance.createRoom("test room", new RemoteAPI.Callback() {

            @Override
            public void success(final String uuid, final String roomToken) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        joinRoom(uuid, roomToken);
                        setEnableButtons(true);
                    }
                });
            }

            @Override
            public void fail(final String errorMessage) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.this.alert("创建房间失败", errorMessage);
                        MainActivity.this.setEnableButtons(true);
                    }
                });
            }
        });
    }

    private void onClickJoinBoard() {
        switch (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)) {
            case PackageManager.PERMISSION_GRANTED: {
                qrScan.initiateScan();
                break;
            }
            case PackageManager.PERMISSION_DENIED: {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                    this.alert("无法获取摄像头权限", "扫描二维码需要摄像头权限，你已经永久禁止授予该 App 权限。");
                } else {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 0);
                }
                break;
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            qrScan.initiateScan();

        } else {
            this.alert("无法获取摄像头权限", "没有摄像头权限，App 将无法扫描二维码");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(this, "未找到二维码", Toast.LENGTH_LONG).show();
            } else {
                this.joinRoomWithURL(result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void joinRoomWithURL(String url) {
        if (url.matches("https://demo\\.herewhite\\.com/#/(\\w|-)+/whiteboard/[a-z0-9]+/?")) {
            String[] cells = url.split("/");
            String uuid = cells[cells.length - 1];

            if (uuid.trim().equals("")) {
                uuid = cells[cells.length - 2];
            }
            this.setEnableButtons(false);
            RemoteAPI.instance.getRoom(uuid, new RemoteAPI.Callback() {
                @Override
                public void success(final String uuid, final String roomToken) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            joinRoom(uuid, roomToken);
                            setEnableButtons(true);
                        }
                    });
                }

                @Override
                public void fail(final String errorMessage) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.this.alert("创建房间失败", errorMessage);
                            MainActivity.this.setEnableButtons(true);
                        }
                    });
                }
            });
        } else {
            this.alert("错误", "无法识别的二维码");
        }
    }

    private void joinRoom(String uuid, String roomToken) {
        Intent intent = new Intent(MainActivity.this, RoomPageActivity.class);
        intent.putExtra("uuid", uuid);
        intent.putExtra("roomToken", roomToken);
        MainActivity.this.startActivity(intent);
    }

    private void alert(String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    private void setEnableButtons(boolean enable) {
        this.btnCreateBoard.setEnabled(enable);
        this.btnJoinBoard.setEnabled(enable);
    }
}
