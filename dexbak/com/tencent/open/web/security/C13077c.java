package com.tencent.open.web.security;

import android.webkit.WebView;
import com.tencent.open.C13006b;
import com.tencent.open.log.SLog;
import com.tencent.open.p567c.C13028d;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.web.security.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13077c extends C13006b.C13007a {

    /* renamed from: d */
    private String f37462d;

    public C13077c(WebView webView, long j, String str, String str2) {
        super(webView, j, str);
        this.f37462d = str2;
    }

    /* renamed from: b */
    private void m14900b(String str) {
        WebView webView = this.f37285a.get();
        if (webView != null) {
            StringBuffer stringBuffer = new StringBuffer("javascript:");
            stringBuffer.append("if(!!");
            stringBuffer.append(this.f37462d);
            stringBuffer.append("){");
            stringBuffer.append(this.f37462d);
            stringBuffer.append("(");
            stringBuffer.append(str);
            stringBuffer.append(")}");
            String stringBuffer2 = stringBuffer.toString();
            SLog.m15123v("openSDK_LOG.SecureJsListener", "-->callback, callback: " + stringBuffer2);
            webView.loadUrl(stringBuffer2);
        }
    }

    @Override // com.tencent.open.C13006b.C13007a
    /* renamed from: a */
    public void mo14902a(Object obj) {
        SLog.m15123v("openSDK_LOG.SecureJsListener", "-->onComplete, result: " + obj);
    }

    @Override // com.tencent.open.C13006b.C13007a
    /* renamed from: a */
    public void mo14903a() {
        SLog.m15131d("openSDK_LOG.SecureJsListener", "-->onNoMatchMethod...");
    }

    @Override // com.tencent.open.C13006b.C13007a
    /* renamed from: a */
    public void mo14901a(String str) {
        SLog.m15123v("openSDK_LOG.SecureJsListener", "-->onCustomCallback, js: " + str);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonNetImpl.RESULT, !C13028d.f37330a ? -4 : 0);
            jSONObject.put("sn", this.f37286b);
            jSONObject.put("data", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        m14900b(jSONObject.toString());
    }
}
