package com.netless.whiteboard.config;

import com.netless.whiteboard.R;

public class PPTData {

    private int resourceId;
    private boolean isDynamicPPT;

    public static final PPTData[] pptDatas = new PPTData[]{
            new PPTData(R.drawable.img_ppt1, true),
            new PPTData(R.drawable.img_ppt2, true),
            new PPTData(R.drawable.img_ppt3, false),
            new PPTData(R.drawable.img_ppt4, false),
            new PPTData(R.drawable.img_ppt5, false),
    };

    private PPTData(int resourceId, boolean isDynamicPPT) {
        this.resourceId = resourceId;
        this.isDynamicPPT = isDynamicPPT;
    }

    public int getResourceId() {
        return resourceId;
    }

    public boolean isDynamicPPT() {
        return isDynamicPPT;
    }
}
