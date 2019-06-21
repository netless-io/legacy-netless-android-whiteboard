package com.netless.whiteboard.components;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;

import com.herewhite.sdk.Room;
import com.herewhite.sdk.domain.MemberState;

import java.util.Map;

public class AppliancesTooBar {

    private static int colorGray = 0xFF9D9CA5;

    private final Map<String, Button> appliances;
    private String currentApplianceName;
    private Room room = null;

    public AppliancesTooBar(Map<String, Button> appliances) {
        this.currentApplianceName = null;
        this.appliances = appliances;

        for (Map.Entry<String, Button> e: this.appliances.entrySet()) {
            final String applianceName = e.getKey();
            Button button = e.getValue();
            this.setColorWithButton(button, AppliancesTooBar.colorGray);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickApplianceButton(applianceName);
                }
            });
        }
        this.setButtonsEnable(false);
    }

    public void setState(String currentApplianceName, int[] sdkColor) {
        String originalApplianceName = this.currentApplianceName;

        this.currentApplianceName = currentApplianceName;

        if (originalApplianceName != null) {
            Button originalButton = this.appliances.get(originalApplianceName);
            this.setColorWithButton(originalButton, AppliancesTooBar.colorGray);
        }
        Button currentButton = this.appliances.get(this.currentApplianceName);
        int color = 0xff << 24 | (sdkColor[0] & 0xff) << 16 | (sdkColor[1] & 0xff) << 8 | (sdkColor[2] & 0xff);

        this.setColorWithButton(currentButton, color);
    }

    public void setRoom(Room room) {
        this.room = room;
        this.setButtonsEnable(true);
    }

    public void setButtonsEnable(boolean enable) {
        if (this.room != null) {
            for (Button button: this.appliances.values()) {
                button.setEnabled(enable);
            }
        }
    }

    private void setColorWithButton(Button button, int color) {
        Drawable drawable = button.getCompoundDrawablesRelative()[0];
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    private void onClickApplianceButton(String applianceName) {
        MemberState memberState = new MemberState();
        memberState.setCurrentApplianceName(applianceName);
        this.room.setMemberState(memberState);
    }
}
