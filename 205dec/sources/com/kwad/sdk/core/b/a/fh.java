package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class fh implements com.kwad.sdk.core.d<AdMatrixInfo.InstalledActivateInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.InstalledActivateInfo installedActivateInfo, JSONObject jSONObject) {
        a2(installedActivateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.InstalledActivateInfo installedActivateInfo, JSONObject jSONObject) {
        return b2(installedActivateInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.InstalledActivateInfo installedActivateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        installedActivateInfo.cardSwitch = jSONObject.optBoolean("cardSwitch");
        installedActivateInfo.showTime = jSONObject.optLong("showTime");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.InstalledActivateInfo installedActivateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        boolean z3 = installedActivateInfo.cardSwitch;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "cardSwitch", z3);
        }
        long j4 = installedActivateInfo.showTime;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "showTime", j4);
        }
        return jSONObject;
    }
}
