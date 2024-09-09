package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ai implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JSONObject f12348a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ WebView f12349b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ae f12350c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ae aeVar, JSONObject jSONObject, WebView webView) {
        this.f12350c = aeVar;
        this.f12348a = jSONObject;
        this.f12349b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f12348a == null || this.f12349b == null) {
            return;
        }
        this.f12349b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.f12348a.toString().replace("\"", "\\\"") + "\")");
    }
}
