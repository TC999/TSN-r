package com.kwad.components.p208ad.reward.p257j;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.components.core.p330s.C8934b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.track.AdTrackLog;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p434g.InterfaceC10761a;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.j.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7955b {
    /* renamed from: a */
    public static void m31926a(boolean z, AdTemplate adTemplate, @Nullable JSONObject jSONObject, @Nullable C9913b c9913b) {
        boolean m29571a = C8934b.m29570qY().m29571a(adTemplate, jSONObject, c9913b);
        if (z && m29571a) {
            C8032c.m31751e(C10487e.m25647dK(adTemplate) == 2, adTemplate);
        }
    }

    /* renamed from: a */
    public static void m31927a(AdTemplate adTemplate, String str, String str2, C9913b c9913b, JSONObject jSONObject) {
        if (c9913b == null) {
            c9913b = new C9913b();
        }
        c9913b.m27267b(adTemplate, str, str2, null);
        C9908c.m27340a(adTemplate, c9913b, jSONObject);
    }

    /* renamed from: a */
    public static void m31928a(final Context context, AdTemplate adTemplate, String str, final int i, JSONObject jSONObject) {
        C9913b m27264cM = new C9913b().m27264cM(18);
        m27264cM.m27267b(adTemplate, str, null, new InterfaceC10761a<AdTrackLog>() { // from class: com.kwad.components.ad.reward.j.b.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: a */
            public void accept(AdTrackLog adTrackLog) {
                adTrackLog.rewardDetailStatusBarHeight = C10751a.getStatusBarHeight(context);
                adTrackLog.rewardDetailCallPositionY = i;
            }
        });
        C9908c.m27309d(adTemplate, jSONObject, m27264cM);
    }
}
