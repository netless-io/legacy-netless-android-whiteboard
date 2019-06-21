package com.netless.whiteboard.components;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.Button;

import java.util.Map;

public class AppliancesTooBar {

    private static int colorGray = 0xFF9D9CA5;

    private final Map<String, Button> appliances;
    private String currentApplianceName;

    public AppliancesTooBar(String applianceName, Map<String, Button> appliances) {
        this.currentApplianceName = applianceName;
        this.appliances = appliances;

        for (Map.Entry<String, Button> entry: this.appliances.entrySet()) {
            if (entry.getKey().equals(applianceName)) {
                this.setColorWithButton(entry.getValue(), AppliancesTooBar.colorGray);
            } else {
                this.setColorWithButton(entry.getValue(), AppliancesTooBar.colorGray);
            }
        }
    }

    public void setCurrentApplianceName(String name) {
        if (!this.currentApplianceName.equals(name)) {
            this.currentApplianceName = name;
        }
    }

    public void setButtonsEnable(boolean enable) {
        for (Button button: this.appliances.values()) {
            button.setEnabled(enable);
        }
    }

    private void setColorWithButton(Button button, int color) {
        Drawable drawable = button.getCompoundDrawablesRelative()[0];
        drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }
}
