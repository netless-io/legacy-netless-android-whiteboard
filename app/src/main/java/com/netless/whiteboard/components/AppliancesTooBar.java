package com.netless.whiteboard.components;

import android.widget.Button;

import java.util.Map;

public class AppliancesTooBar {

    private final Map<String, Button> appliances;
    private String currentApplianceName;

    public AppliancesTooBar(String applianceName, Map<String, Button> appliances) {
        this.currentApplianceName = applianceName;
        this.appliances = appliances;
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
}
