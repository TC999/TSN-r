package com.mbridge.msdk.mbjscommon.windvane;

import android.content.Context;

/* renamed from: com.mbridge.msdk.mbjscommon.windvane.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class WindVanePlugin {
    protected Context mContext;
    protected WindVaneWebView mWebView;
    protected Object object;

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        this.mContext = context;
        this.mWebView = windVaneWebView;
    }

    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        this.object = obj;
        this.mWebView = windVaneWebView;
    }
}
