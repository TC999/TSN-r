package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.ah */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class C2588ah implements NativeCPUManager.DataPostBackListener {

    /* renamed from: a */
    final /* synthetic */ Object f8553a;

    /* renamed from: b */
    final /* synthetic */ C2585ae f8554b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2588ah(C2585ae c2585ae, Object obj) {
        this.f8554b = c2585ae;
        this.f8553a = obj;
    }

    @Override // com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener
    public void postback(JSONObject jSONObject) {
        Object obj = this.f8553a;
        if (obj instanceof Activity) {
            View findViewById = ((Activity) obj).findViewById(17);
            if (findViewById instanceof WebView) {
                this.f8554b.m51038a((WebView) findViewById, jSONObject);
            }
        }
    }
}
