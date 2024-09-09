package com.kwad.sdk.core.b.a;

import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class jb implements com.kwad.sdk.core.d<SplashExtraDataImpl> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        a2(splashExtraDataImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        return b2(splashExtraDataImpl, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashExtraDataImpl.disableShake = jSONObject.optBoolean("disableShake");
        splashExtraDataImpl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashExtraDataImpl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = splashExtraDataImpl.disableShake;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableShake", z3);
        }
        boolean z4 = splashExtraDataImpl.disableRotate;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableRotate", z4);
        }
        boolean z5 = splashExtraDataImpl.disableSlide;
        if (z5) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "disableSlide", z5);
        }
        return jSONObject;
    }
}
