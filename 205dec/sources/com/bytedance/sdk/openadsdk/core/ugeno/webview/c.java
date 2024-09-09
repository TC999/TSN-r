package com.bytedance.sdk.openadsdk.core.ugeno.webview;

import android.content.Context;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.sdk.openadsdk.core.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends b<PageWebView> {

    /* renamed from: c  reason: collision with root package name */
    private String f35064c;

    public c(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: c */
    public PageWebView xv() {
        return new PageWebView(this.f26040w);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        ((PageWebView) this.ux).setMeta(w.c(p()));
        ((PageWebView) this.ux).w(p());
        ((PageWebView) this.ux).setUGenContext(this.gd);
        ((PageWebView) this.ux).c();
        ((PageWebView) this.ux).c(this.f35064c);
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        if (str.equals("src")) {
            this.f35064c = str2;
        }
    }
}
