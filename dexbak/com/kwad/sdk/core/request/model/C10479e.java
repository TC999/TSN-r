package com.kwad.sdk.core.request.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.network.InterfaceC10435k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10479e implements InterfaceC9914b {
    private InterfaceC9914b azJ;

    /* renamed from: Fe */
    public static C10479e m25984Fe() {
        C10479e c10479e = new C10479e();
        try {
            c10479e.azJ = ((InterfaceC10435k) ServiceProvider.get(InterfaceC10435k.class)).mo24875yk();
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return c10479e;
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.m23678a(jSONObject, "modeInfo", this.azJ);
        return jSONObject;
    }
}
