package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.b;
import com.tencent.open.c.d;
import com.tencent.open.log.SLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c extends b.a {

    /* renamed from: d  reason: collision with root package name */
    private String f51862d;

    public c(WebView webView, long j4, String str, String str2) {
        super(webView, j4, str);
        this.f51862d = str2;
    }

    private void b(String str) {
        WebView webView = this.f51686a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f51862d);
            stringBuffer.append("){");
            stringBuffer.append(this.f51862d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            SLog.v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }

    @Override // com.tencent.open.b.a
    public void a(Object obj) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.b.a
    public void a() {
        SLog.d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.b.a
    public void a(String str) {
        SLog.v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("result", !d.f51730a ? -4 : 0);
            jSONObject.put("sn", this.f51687b);
            jSONObject.put("data", str);
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        b(jSONObject.toString());
    }
}
