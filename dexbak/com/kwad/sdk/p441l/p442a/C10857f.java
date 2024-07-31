package com.kwad.sdk.p441l.p442a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.kwad.sdk.utils.C11034az;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.l.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10857f extends C10482a implements InterfaceC9914b {
    public int aNd = -1;
    public int aNe = -1;

    /* renamed from: Kz */
    public static synchronized C10857f m24627Kz() {
        synchronized (C10857f.class) {
            if (((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24323yA()) {
                return C11034az.m23987Kz();
            }
            return null;
        }
    }

    /* renamed from: a */
    private void m24626a(C10857f c10857f, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        c10857f.aNd = jSONObject.optInt("phoneCount", -1);
        c10857f.aNe = jSONObject.optInt("activePhoneCount", -1);
        super.afterToJson(jSONObject);
    }

    /* renamed from: b */
    private static JSONObject m24625b(C10857f c10857f, JSONObject jSONObject) {
        C11126t.putValue(jSONObject, "phoneCount", c10857f.aNd);
        C11126t.putValue(jSONObject, "activePhoneCount", c10857f.aNe);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        m24626a(this, jSONObject);
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject m24625b = m24625b(this, new JSONObject());
        afterToJson(m24625b);
        return m24625b;
    }
}
