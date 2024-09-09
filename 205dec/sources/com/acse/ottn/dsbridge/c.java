package com.acse.ottn.dsbridge;

import com.acse.ottn.dsbridge.DWebView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Object f5591a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DWebView.AnonymousClass1 f5592b;

    c(DWebView.AnonymousClass1 anonymousClass1, Object obj) {
        this.f5592b = anonymousClass1;
        this.f5591a = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONObject jSONObject = (JSONObject) this.f5591a;
        try {
            int i4 = jSONObject.getInt("id");
            boolean z3 = jSONObject.getBoolean(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
            l lVar = (l) DWebView.this.m.get(Integer.valueOf(i4));
            Object obj = jSONObject.has("data") ? jSONObject.get("data") : null;
            if (lVar != null) {
                lVar.a(obj);
                if (z3) {
                    DWebView.this.m.remove(Integer.valueOf(i4));
                }
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
    }
}
