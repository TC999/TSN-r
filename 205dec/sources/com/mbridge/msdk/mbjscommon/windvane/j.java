package com.mbridge.msdk.mbjscommon.windvane;

import android.content.Context;

/* compiled from: WindVanePlugin.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class j {
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
