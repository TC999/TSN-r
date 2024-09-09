package com.bytedance.sdk.component.c;

import android.webkit.WebView;
import com.bytedance.component.sdk.annotation.AnyThread;
import com.bytedance.component.sdk.annotation.UiThread;
import com.bytedance.sdk.component.c.sr;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s {

    /* renamed from: c  reason: collision with root package name */
    static j f29708c;

    /* renamed from: f  reason: collision with root package name */
    private ys f29709f;

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f29710r;
    private final p sr;
    private final List<t> ux;

    /* renamed from: w  reason: collision with root package name */
    private final c f29711w;
    private final WebView xv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar) {
        j jVar;
        ArrayList arrayList = new ArrayList();
        this.ux = arrayList;
        this.f29710r = false;
        this.sr = pVar;
        q c4 = (!pVar.ev || (jVar = f29708c) == null) ? null : jVar.c(pVar.f29684k);
        if (pVar.f29682c != null) {
            c cVar = pVar.f29688w;
            if (cVar == null) {
                this.f29711w = new n();
            } else {
                this.f29711w = cVar;
            }
        } else {
            this.f29711w = pVar.f29688w;
        }
        this.f29711w.c(pVar, c4);
        this.xv = pVar.f29682c;
        arrayList.add(pVar.f29685p);
        gd.c(pVar.f29683f);
        gb.c(pVar.f29686r);
    }

    public static p c(WebView webView) {
        return new p(webView);
    }

    private void w() {
        if (this.f29710r) {
            gd.c(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    @AnyThread
    public <T> void c(String str, T t3) {
        w();
        this.f29711w.c(str, (String) t3);
    }

    public s c(String str, ux<?, ?> uxVar) {
        return c(str, (String) null, uxVar);
    }

    @UiThread
    public s c(String str, String str2, ux<?, ?> uxVar) {
        w();
        this.f29711w.f29653r.c(str, uxVar);
        ys ysVar = this.f29709f;
        if (ysVar != null) {
            ysVar.c(str);
        }
        return this;
    }

    public s c(String str, sr.w wVar) {
        return c(str, (String) null, wVar);
    }

    @UiThread
    public s c(String str, String str2, sr.w wVar) {
        w();
        this.f29711w.f29653r.c(str, wVar);
        ys ysVar = this.f29709f;
        if (ysVar != null) {
            ysVar.c(str);
        }
        return this;
    }

    public void c() {
        if (this.f29710r) {
            return;
        }
        this.f29711w.w();
        this.f29710r = true;
        for (t tVar : this.ux) {
            if (tVar != null) {
                tVar.c();
            }
        }
    }
}
