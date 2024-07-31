package com.kwad.sdk.p441l.p442a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11034az;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.l.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10853b extends C10482a implements InterfaceC9914b {
    public int aMS;
    public int aMT;
    public int aMU;

    public C10853b(int i, int i2, int i3) {
        this.aMS = i;
        this.aMT = i2;
        this.aMU = i3;
    }

    /* renamed from: Ky */
    public static synchronized C10853b m24642Ky() {
        synchronized (C10853b.class) {
            if (((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24321yC()) {
                return C11034az.m23988Ky();
            }
            return null;
        }
    }

    /* renamed from: a */
    private static void m24641a(C10853b c10853b, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10853b.aMS = jSONObject.optInt("cellId", -1);
        c10853b.aMT = jSONObject.optInt("lac", -1);
        c10853b.aMU = jSONObject.optInt("bsss", -1);
    }

    /* renamed from: b */
    private static JSONObject m24640b(C10853b c10853b, JSONObject jSONObject) {
        C11126t.putValue(jSONObject, "cellId", c10853b.aMS);
        C11126t.putValue(jSONObject, "lac", c10853b.aMT);
        C11126t.putValue(jSONObject, "bsss", c10853b.aMU);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        m24641a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        return m24640b(this, new JSONObject());
    }
}
