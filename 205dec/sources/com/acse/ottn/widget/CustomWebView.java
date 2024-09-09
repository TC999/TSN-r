package com.acse.ottn.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class CustomWebView extends WebView {
    public CustomWebView(Context context) {
        super(a(context));
    }

    public static Context a(Context context) {
        int i4 = Build.VERSION.SDK_INT;
        return (i4 < 21 || i4 >= 23) ? context : context.createConfigurationContext(new Configuration());
    }

    public CustomWebView(Context context, AttributeSet attributeSet) {
        super(a(context), attributeSet);
    }

    public CustomWebView(Context context, AttributeSet attributeSet, int i4) {
        super(a(context), attributeSet, i4);
    }
}
