package com.kwad.components.ad.reward.j;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.track.AdTrackLog;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static void a(boolean z3, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable com.kwad.sdk.core.adlog.c.b bVar) {
        boolean a4 = com.kwad.components.core.s.b.qY().a(adTemplate, jSONObject, bVar);
        if (z3 && a4) {
            c.e(e.dK(adTemplate) == 2, adTemplate);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, com.kwad.sdk.core.adlog.c.b bVar, JSONObject jSONObject) {
        if (bVar == null) {
            bVar = new com.kwad.sdk.core.adlog.c.b();
        }
        bVar.b(adTemplate, str, str2, null);
        com.kwad.sdk.core.adlog.c.a(adTemplate, bVar, jSONObject);
    }

    public static void a(final Context context, AdTemplate adTemplate, String str, final int i4, JSONObject jSONObject) {
        com.kwad.sdk.core.adlog.c.b cM = new com.kwad.sdk.core.adlog.c.b().cM(18);
        cM.b(adTemplate, str, null, new com.kwad.sdk.g.a<AdTrackLog>() { // from class: com.kwad.components.ad.reward.j.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: a */
            public void accept(AdTrackLog adTrackLog) {
                adTrackLog.rewardDetailStatusBarHeight = com.kwad.sdk.d.a.a.getStatusBarHeight(context);
                adTrackLog.rewardDetailCallPositionY = i4;
            }
        });
        com.kwad.sdk.core.adlog.c.d(adTemplate, jSONObject, cM);
    }
}
