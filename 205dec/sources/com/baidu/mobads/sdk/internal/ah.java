package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.View;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class ah implements NativeCPUManager.DataPostBackListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f12346a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ ae f12347b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ae aeVar, Object obj) {
        this.f12347b = aeVar;
        this.f12346a = obj;
    }

    @Override // com.baidu.mobads.sdk.api.NativeCPUManager.DataPostBackListener
    public void postback(JSONObject jSONObject) {
        Object obj = this.f12346a;
        if (obj instanceof Activity) {
            View findViewById = ((Activity) obj).findViewById(17);
            if (findViewById instanceof WebView) {
                this.f12347b.a((WebView) findViewById, jSONObject);
            }
        }
    }
}
