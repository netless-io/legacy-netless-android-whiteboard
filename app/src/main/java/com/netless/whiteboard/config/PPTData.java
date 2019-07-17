package com.netless.whiteboard.config;

import com.herewhite.sdk.domain.PptPage;
import com.herewhite.sdk.domain.Scene;
import com.netless.whiteboard.R;

public class PPTData {

    private int id;
    private int resourceId;
    private boolean isDynamicPPT;
    private Scene[] scenes;

    public static final PPTData[] pptDatas = new PPTData[]{
            new PPTData(1, R.drawable.img_ppt1, true, 960, 540, new String[]{
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/1.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/2.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/3.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/4.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/5.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/6.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/7.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/8.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/9.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/10.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/11.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/12.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/13.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/14.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/15.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/16.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/17.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/18.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/19.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/20.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/21.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/22.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/23.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/24.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/25.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/26.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/27.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/28.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/29.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/3c0014a06f4c47f88a568eee77996edc/30.slide"
            }),
            new PPTData(2, R.drawable.img_ppt2, true, 960, 540, new String[] {
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/1.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/2.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/3.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/4.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/5.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/6.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/7.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/8.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/9.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/10.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/11.slide",
                    "pptx://white-cover.oss-cn-hangzhou.aliyuncs.com/dynamicConvert/6d5bd36769d44dcb808bccda068f972b/12.slide"
            }),
            new PPTData(3, R.drawable.img_ppt3, false, 960, 540, new String[] {
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/1.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/2.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/3.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/4.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/5.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/6.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/7.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/8.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/9.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/10.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/11.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/12.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/13.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/14.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/15.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/16.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/17.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/18.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/19.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/20.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/21.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/22.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/23.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/24.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/25.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/26.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/27.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/28.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/29.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/30.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/31.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/32.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/33.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/34.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/35.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/36.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/37.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/38.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/39.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/40.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/6c537d1380584f4b82a8b521336fcfbe/41.png"
            }),
            new PPTData(4, R.drawable.img_ppt4, false, 960, 540, new String[] {
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/1.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/2.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/3.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/4.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/5.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/6.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/7.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/8.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/9.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/10.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/11.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/12.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/13.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/14.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/15.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/16.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/17.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/18.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/19.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/20.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/21.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/22.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/23.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/24.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/25.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/26.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/27.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/28.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/29.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/30.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/31.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/32.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/33.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/34.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/35.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/36.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/37.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/dbd36235042547f8888e9d82594c1b27/38.png"
            }),
            new PPTData(5, R.drawable.img_ppt5, false, 960, 540, new String[] {
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/1.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/2.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/3.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/4.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/5.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/6.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/7.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/8.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/9.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/10.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/11.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/12.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/13.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/14.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/15.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/16.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/17.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/18.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/19.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/20.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/21.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/22.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/23.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/24.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/25.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/26.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/27.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/28.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/29.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/30.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/31.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/32.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/33.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/34.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/35.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/36.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/37.png",
                    "https://netless-agora-whiteboard.oss-cn-hangzhou.aliyuncs.com/staticConvert/79b8340e6e814d919f47293376102013/38.png"
            }),
    };

    private PPTData(int id, int resourceId, boolean isDynamicPPT, double width, double height, String[] pptList) {
        this.id = id;
        this.resourceId = resourceId;
        this.isDynamicPPT = isDynamicPPT;
        this.scenes = new Scene[pptList.length];

        for (int i = 0; i < pptList.length; ++ i) {
            Scene scene = new Scene();
            PptPage ppt = new PptPage(pptList[i], width, height);

            scene.setName("" + i);
            scene.setPpt(ppt);

            this.scenes[i] = scene;
        }
    }

    public int getId() {
        return id;
    }

    public int getResourceId() {
        return resourceId;
    }

    public boolean isDynamicPPT() {
        return isDynamicPPT;
    }

    public Scene[] getScenes() {
        return scenes;
    }
}
