package com.acse.ottn.dsbridge;

import com.acse.ottn.dsbridge.DWebView;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.dsbridge.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1549k implements InterfaceC1539a {

    /* renamed from: a */
    final /* synthetic */ String f2882a;

    /* renamed from: b */
    final /* synthetic */ DWebView.InnerJavascriptInterface f2883b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1549k(DWebView.InnerJavascriptInterface innerJavascriptInterface, String str) {
        this.f2883b = innerJavascriptInterface;
        this.f2882a = str;
    }

    /* renamed from: a */
    private void m56450a(Object obj, boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            jSONObject.put("data", obj);
            String str = this.f2882a;
            if (str != null) {
                String format = String.format("%s(%s.data);", str, jSONObject.toString());
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(format);
                    sb.append("delete window.");
                    sb.append(this.f2882a);
                    format = sb.toString();
                }
                DWebView.this.m56476a(format);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.acse.ottn.dsbridge.InterfaceC1539a
    /* renamed from: a */
    public void mo56451a(Object obj) {
        m56450a(obj, false);
    }

    @Override // com.acse.ottn.dsbridge.InterfaceC1539a
    /* renamed from: b */
    public void mo56449b(Object obj) {
        m56450a(obj, true);
    }

    @Override // com.acse.ottn.dsbridge.InterfaceC1539a
    public void complete() {
        m56450a(null, true);
    }
}
