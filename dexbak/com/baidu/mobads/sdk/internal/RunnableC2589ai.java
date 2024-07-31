package com.baidu.mobads.sdk.internal;

import android.webkit.WebView;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.ai */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RunnableC2589ai implements Runnable {

    /* renamed from: a */
    final /* synthetic */ JSONObject f8555a;

    /* renamed from: b */
    final /* synthetic */ WebView f8556b;

    /* renamed from: c */
    final /* synthetic */ C2585ae f8557c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2589ai(C2585ae c2585ae, JSONObject jSONObject, WebView webView) {
        this.f8557c = c2585ae;
        this.f8555a = jSONObject;
        this.f8556b = webView;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f8555a == null || this.f8556b == null) {
            return;
        }
        this.f8556b.loadUrl("javascript:window.sdkCallback.userInteractCb(\"" + this.f8555a.toString().replace("\"", "\\\"") + "\")");
    }
}
