package com.acse.ottn.dsbridge;

import com.acse.ottn.dsbridge.DWebView;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class k implements a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5608a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DWebView.InnerJavascriptInterface f5609b;

    k(DWebView.InnerJavascriptInterface innerJavascriptInterface, String str) {
        this.f5609b = innerJavascriptInterface;
        this.f5608a = str;
    }

    private void a(Object obj, boolean z3) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", 0);
            jSONObject.put("data", obj);
            String str = this.f5608a;
            if (str != null) {
                String format = String.format("%s(%s.data);", str, jSONObject.toString());
                if (z3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(format);
                    sb.append("delete window.");
                    sb.append(this.f5608a);
                    format = sb.toString();
                }
                DWebView.this.a(format);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.acse.ottn.dsbridge.a
    public void a(Object obj) {
        a(obj, false);
    }

    @Override // com.acse.ottn.dsbridge.a
    public void b(Object obj) {
        a(obj, true);
    }

    @Override // com.acse.ottn.dsbridge.a
    public void complete() {
        a(null, true);
    }
}
