package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jk */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10169jk implements InterfaceC10273d<StatusInfo.SplashStyleControl> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        m26750a(splashStyleControl, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        return m26749b(splashStyleControl, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26750a(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashStyleControl.disableShake = jSONObject.optBoolean("disableShake");
        splashStyleControl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashStyleControl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26749b(StatusInfo.SplashStyleControl splashStyleControl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = splashStyleControl.disableShake;
        if (z) {
            C11126t.putValue(jSONObject, "disableShake", z);
        }
        boolean z2 = splashStyleControl.disableRotate;
        if (z2) {
            C11126t.putValue(jSONObject, "disableRotate", z2);
        }
        boolean z3 = splashStyleControl.disableSlide;
        if (z3) {
            C11126t.putValue(jSONObject, "disableSlide", z3);
        }
        return jSONObject;
    }
}
