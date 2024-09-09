package com.kwad.sdk.l.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
    public int aMS;
    public int aMT;
    public int aMU;

    public b(int i4, int i5, int i6) {
        this.aMS = i4;
        this.aMT = i5;
        this.aMU = i6;
    }

    public static synchronized b Ky() {
        synchronized (b.class) {
            if (((h) ServiceProvider.get(h.class)).yC()) {
                return az.Ky();
            }
            return null;
        }
    }

    private static void a(b bVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        bVar.aMS = jSONObject.optInt("cellId", -1);
        bVar.aMT = jSONObject.optInt("lac", -1);
        bVar.aMU = jSONObject.optInt("bsss", -1);
    }

    private static JSONObject b(b bVar, JSONObject jSONObject) {
        t.putValue(jSONObject, "cellId", bVar.aMS);
        t.putValue(jSONObject, "lac", bVar.aMT);
        t.putValue(jSONObject, "bsss", bVar.aMU);
        return jSONObject;
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
        a(this, jSONObject);
        super.afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
    public final JSONObject toJson() {
        return b(this, new JSONObject());
    }
}
