package com.webview.taozeyu.netlesswhiteboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCreateBoard = findViewById(R.id.btnCreateBoard);
        Button btnJoinBoard = findViewById(R.id.btnJoinBoard);

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
    }

    private void onClickJoinBoard() {
    }
}
