package com.acse.ottn.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class CustomWebView extends WebView {
    public CustomWebView(Context context) {
        super(m55851a(context));
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(m55851a(context), attributeSet);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i) {
        super(m55851a(context), attributeSet, i);
    }

    /* renamed from: a */
    public static Context m55851a(Context context) {
        int i = Build.VERSION.SDK_INT;
        return (i < 21 || i >= 23) ? context : context.createConfigurationContext(new Configuration());
    }
}
