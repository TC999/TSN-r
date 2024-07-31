package com.kwad.sdk.core.webview.p422c;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.utils.C11126t;
import com.umeng.ccg.CcgConstant;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.webview.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10626b implements InterfaceC9914b {
    public String aEC;
    public String aED;
    public String data;

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.aEC = jSONObject.optString(CcgConstant.f38549t);
        this.data = jSONObject.optString("data");
        this.aED = jSONObject.optString("callback");
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, CcgConstant.f38549t, this.aEC);
        C11126t.putValue(jSONObject, "data", this.data);
        C11126t.putValue(jSONObject, "callback", this.aED);
        return jSONObject;
    }
}
