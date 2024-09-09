package com.mbridge.msdk.mbjscommon.webEnvCheck;

import android.content.Context;
import com.mbridge.msdk.c.b.c;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class WebEnvCheckEntry {
    public void check(Context context) {
        WindVaneWebView windVaneWebView = new WindVaneWebView(context);
        windVaneWebView.loadDataWithBaseURL(null, "<html><script>" + c.a().b() + "</script></html>", "text/html", "utf-8", null);
    }
}
