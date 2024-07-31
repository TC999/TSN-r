package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ji */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10167ji implements InterfaceC10273d<SplashSkipViewModel> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        m26754a(splashSkipViewModel, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        return m26753b(splashSkipViewModel, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26754a(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSkipViewModel.skipSecond = jSONObject.optInt("skipSecond");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26753b(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = splashSkipViewModel.skipSecond;
        if (i != 0) {
            C11126t.putValue(jSONObject, "skipSecond", i);
        }
        return jSONObject;
    }
}
