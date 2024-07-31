package com.kwad.sdk.core.request.model;

import android.location.Location;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11029av;
import com.kwad.sdk.utils.C11126t;
import com.kwad.sdk.utils.p452c.C11078a;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.request.model.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10477c implements InterfaceC9914b {
    private static C10477c azE;
    private double latitude;
    private double longitude;
    private int type;

    /* renamed from: Fb */
    public static C10477c m25987Fb() {
        Location location;
        C10477c c10477c = azE;
        if (c10477c != null) {
            return c10477c;
        }
        try {
            azE = new C10477c();
            C11078a m24052bV = C11029av.m24052bV(((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).getContext());
            if (m24052bV != null && (location = m24052bV.aSm) != null) {
                azE.latitude = location.getLatitude();
                azE.longitude = m24052bV.aSm.getLongitude();
                azE.type = m24052bV.type;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return azE;
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, "latitude", this.latitude);
        C11126t.putValue(jSONObject, "longitude", this.longitude);
        C11126t.putValue(jSONObject, "type", this.type);
        return jSONObject;
    }
}
