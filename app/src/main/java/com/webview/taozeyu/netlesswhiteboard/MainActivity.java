package com.webview.taozeyu.netlesswhiteboard;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCreateBoard;
    private Button btnJoinBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        MainActivity.this.alert("创建房间成功", uuid + " " + roomToken);
                    }
                });
            }

            @Override
            public void fail(final String errorMessage) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        MainActivity.this.setEnableButtons(true);
                        MainActivity.this.alert("创建房间失败", errorMessage);
                    }
                });
            }
        });
    }

    private void onClickJoinBoard() {
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
