package com.acse.ottn.dsbridge;

import com.acse.ottn.dsbridge.DWebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.dsbridge.c */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1541c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Object f2865a;

    /* renamed from: b */
    final /* synthetic */ DWebView.C15341 f2866b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1541c(DWebView.C15341 c15341, Object obj) {
        this.f2866b = c15341;
        this.f2865a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = (JSONObject) this.f2865a;
        try {
            int i = jSONObject.getInt("id");
            boolean z = jSONObject.getBoolean(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
            InterfaceC1550l interfaceC1550l = DWebView.this.f2856m.get(Integer.valueOf(i));
            Object obj = jSONObject.has("data") ? jSONObject.get("data") : null;
            if (interfaceC1550l != null) {
                interfaceC1550l.m56448a(obj);
                if (z) {
                    DWebView.this.f2856m.remove(Integer.valueOf(i));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
