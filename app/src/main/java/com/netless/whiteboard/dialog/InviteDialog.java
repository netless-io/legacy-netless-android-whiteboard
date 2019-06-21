package com.netless.whiteboard.dialog;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.netless.whiteboard.R;

public class InviteDialog extends DialogFragment {

    private String url;

    public void setUUID(String uuid) {
        this.url = "https://demo.herewhite.com/#/zh-CN/whiteboard/" + uuid + "/";
    }

    @Override
    public void onStart() {
        super.onStart();
        ImageView imageView = getDialog().findViewById(R.id.imgQRCode);
        TextView txtWebsiteURL = getDialog().findViewById(R.id.txtWebsiteURL);
        Button btnCopy = getDialog().findViewById(R.id.btnCopy);

        txtWebsiteURL.setText(this.url);
        btnCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickCopy();
            }
        });
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.invite_dialog, null))
                // Add action buttons
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
        return builder.create();
    }

    private void onClickCopy() {
        ClipboardManager cm = (ClipboardManager) this.getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData mClipData = ClipData.newPlainText("Label", this.url);
        cm.setPrimaryClip(mClipData);
        Toast.makeText(this.getContext(), "链接已复制到剪切板", Toast.LENGTH_SHORT).show();
    }
}
