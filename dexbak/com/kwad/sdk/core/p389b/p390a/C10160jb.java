package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10160jb implements InterfaceC10273d<SplashExtraDataImpl> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        m26768a(splashExtraDataImpl, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        return m26767b(splashExtraDataImpl, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26768a(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashExtraDataImpl.disableShake = jSONObject.optBoolean("disableShake");
        splashExtraDataImpl.disableRotate = jSONObject.optBoolean("disableRotate");
        splashExtraDataImpl.disableSlide = jSONObject.optBoolean("disableSlide");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26767b(SplashExtraDataImpl splashExtraDataImpl, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z = splashExtraDataImpl.disableShake;
        if (z) {
            C11126t.putValue(jSONObject, "disableShake", z);
        }
        boolean z2 = splashExtraDataImpl.disableRotate;
        if (z2) {
            C11126t.putValue(jSONObject, "disableRotate", z2);
        }
        boolean z3 = splashExtraDataImpl.disableSlide;
        if (z3) {
            C11126t.putValue(jSONObject, "disableSlide", z3);
        }
        return jSONObject;
    }
}
