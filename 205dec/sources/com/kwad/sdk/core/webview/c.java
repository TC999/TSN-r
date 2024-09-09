package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.n.l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bs;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c extends WebView {
    private boolean aDO;
    private com.kwad.sdk.core.webview.a.a aDP;

    public c(Context context) {
        super(bn(context));
        this.aDO = true;
        init();
    }

    private static Context bn(Context context) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21 && i4 < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context dp = l.dp(context);
        if (l.ds(dp)) {
            return dp;
        }
        ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + dp.getClass().getName() + "--classloader:" + dp.getClass().getClassLoader() + "--context2:" + l.dp(ServiceProvider.KO()).getClass().getName()));
        return l.dp(ServiceProvider.KO());
    }

    private void init() {
        bs.a(this);
        com.kwad.sdk.core.webview.a.a aVar = new com.kwad.sdk.core.webview.a.a();
        this.aDP = aVar;
        setWebViewClient(aVar);
    }

    @Override // android.webkit.WebView
    public void destroy() {
        if (this.aDO) {
            release();
        }
    }

    public final void release() {
        try {
            ViewParent parent = getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
            super.destroy();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
        }
    }

    public void setEnableDestroy(boolean z3) {
        this.aDO = z3;
    }

    public void setNeedHybridLoad(boolean z3) {
        this.aDP.setNeedHybridLoad(z3);
    }

    public c(Context context, AttributeSet attributeSet) {
        super(bn(context), attributeSet);
        this.aDO = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i4) {
        super(bn(context), attributeSet, i4);
        this.aDO = true;
        init();
    }

    @RequiresApi(api = 21)
    public c(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(bn(context), attributeSet, i4, i5);
        this.aDO = true;
        init();
    }

    public c(Context context, AttributeSet attributeSet, int i4, boolean z3) {
        super(bn(context), attributeSet, i4, z3);
        this.aDO = true;
        init();
    }
}
