package com.bytedance.sdk.openadsdk.core.s;

import android.content.Context;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.bk.ev;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private ev f34526c;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.bk.c f34527w;

    public ev c(Context context, WebView webView, com.bytedance.sdk.openadsdk.bk.xv xvVar, com.bytedance.sdk.openadsdk.bk.c cVar, Set<String> set, ev.c cVar2) {
        if (this.f34526c == null) {
            ev c4 = ev.c(context, webView, xvVar, cVar, set, cVar2, true);
            this.f34526c = c4;
            c4.ux(false);
        }
        this.f34527w = cVar;
        return this.f34526c;
    }
}
