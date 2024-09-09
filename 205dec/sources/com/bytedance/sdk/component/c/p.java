package com.bytedance.sdk.component.c;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.c.k;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p {

    /* renamed from: c  reason: collision with root package name */
    WebView f29682c;
    boolean ev;

    /* renamed from: f  reason: collision with root package name */
    boolean f29683f;
    k.w fp;
    bk gd;

    /* renamed from: p  reason: collision with root package name */
    t f29685p;

    /* renamed from: r  reason: collision with root package name */
    boolean f29686r;
    ev sr;

    /* renamed from: t  reason: collision with root package name */
    boolean f29687t;
    Context ux;

    /* renamed from: w  reason: collision with root package name */
    c f29688w;
    boolean ys;
    String xv = "IESJSBridge";

    /* renamed from: k  reason: collision with root package name */
    String f29684k = "host";

    /* renamed from: a  reason: collision with root package name */
    final Set<String> f29681a = new LinkedHashSet();
    final Set<String> bk = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(WebView webView) {
        this.f29682c = webView;
    }

    private void xv() {
        if ((this.f29682c == null && !this.f29687t && this.f29688w == null) || ((TextUtils.isEmpty(this.xv) && this.f29682c != null) || this.sr == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public p c(c cVar) {
        this.f29688w = cVar;
        return this;
    }

    public Context getContext() {
        return this.ux;
    }

    public p w(boolean z3) {
        this.f29686r = z3;
        return this;
    }

    public p c(String str) {
        this.xv = str;
        return this;
    }

    public s w() {
        xv();
        return new s(this);
    }

    public p c(a aVar) {
        this.sr = ev.c(aVar);
        return this;
    }

    public p c(boolean z3) {
        this.f29683f = z3;
        return this;
    }

    public p c() {
        this.ys = true;
        return this;
    }

    p() {
    }
}
