package com.kwad.sdk.core.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.webview.p417a.C10601a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10967e;
import com.kwad.sdk.utils.C11070bs;

/* renamed from: com.kwad.sdk.core.webview.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10624c extends WebView {
    private boolean aDO;
    private C10601a aDP;

    public C10624c(Context context) {
        super(m25252bn(context));
        this.aDO = true;
        init();
    }

    /* renamed from: bn */
    private static Context m25252bn(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21 && i < 23) {
            context = context.createConfigurationContext(new Configuration());
        }
        Context m24557dp = C10887l.m24557dp(context);
        if (C10887l.m24554ds(m24557dp)) {
            return m24557dp;
        }
        ((InterfaceC10967e) ServiceProvider.get(InterfaceC10967e.class)).gatherException(new IllegalArgumentException("KSApiWebView context not except--context:" + m24557dp.getClass().getName() + "--classloader:" + m24557dp.getClass().getClassLoader() + "--context2:" + C10887l.m24557dp(ServiceProvider.m24363KO()).getClass().getName()));
        return C10887l.m24557dp(ServiceProvider.m24363KO());
    }

    private void init() {
        C11070bs.m23848a(this);
        C10601a c10601a = new C10601a();
        this.aDP = c10601a;
        setWebViewClient(c10601a);
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
            C10331c.printStackTraceOnly(th);
        }
    }

    public void setEnableDestroy(boolean z) {
        this.aDO = z;
    }

    public void setNeedHybridLoad(boolean z) {
        this.aDP.setNeedHybridLoad(z);
    }

    public C10624c(Context context, AttributeSet attributeSet) {
        super(m25252bn(context), attributeSet);
        this.aDO = true;
        init();
    }

    public C10624c(Context context, AttributeSet attributeSet, int i) {
        super(m25252bn(context), attributeSet, i);
        this.aDO = true;
        init();
    }

    @RequiresApi(api = 21)
    public C10624c(Context context, AttributeSet attributeSet, int i, int i2) {
        super(m25252bn(context), attributeSet, i, i2);
        this.aDO = true;
        init();
    }

    public C10624c(Context context, AttributeSet attributeSet, int i, boolean z) {
        super(m25252bn(context), attributeSet, i, z);
        this.aDO = true;
        init();
    }
}
