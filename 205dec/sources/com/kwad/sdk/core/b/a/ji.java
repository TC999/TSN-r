package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ji implements com.kwad.sdk.core.d<SplashSkipViewModel> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        a2(splashSkipViewModel, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        return b2(splashSkipViewModel, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSkipViewModel.skipSecond = jSONObject.optInt("skipSecond");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(SplashSkipViewModel splashSkipViewModel, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = splashSkipViewModel.skipSecond;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "skipSecond", i4);
        }
        return jSONObject;
    }
}
