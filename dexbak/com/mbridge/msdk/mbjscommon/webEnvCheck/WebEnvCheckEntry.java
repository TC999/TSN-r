package com.mbridge.msdk.mbjscommon.webEnvCheck;

import android.content.Context;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.p457c.p459b.WebEnvCheckController;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class WebEnvCheckEntry {
    public void check(Context context) {
        WindVaneWebView windVaneWebView = new WindVaneWebView(context);
        windVaneWebView.loadDataWithBaseURL(null, "<html><script>" + WebEnvCheckController.m23225a().m23222b() + "</script></html>", "text/html", "utf-8", null);
    }
}
