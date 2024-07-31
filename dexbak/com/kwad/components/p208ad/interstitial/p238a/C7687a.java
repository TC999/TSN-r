package com.kwad.components.p208ad.interstitial.p238a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.p208ad.interstitial.report.C7804b;
import com.kwad.components.p208ad.interstitial.report.realtime.C7810a;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.network.p404a.C10404a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.videocache.C10569f;
import com.kwad.sdk.core.videocache.p415c.C10562a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11122q;
import java.io.File;

/* renamed from: com.kwad.components.ad.interstitial.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7687a {
    /* renamed from: j */
    public static boolean m32649j(@NonNull AdTemplate adTemplate) {
        boolean z;
        C10569f m25468bl;
        String m25977K = C10483a.m25977K(C10487e.m25641dQ(adTemplate));
        if (TextUtils.isEmpty(m25977K)) {
            C7804b.m32292dO().m32293b(adTemplate, "empty videoUrl");
            return false;
        }
        C7804b.m32292dO().m32291o(adTemplate);
        int m26500yU = C10251d.m26500yU();
        String str = "";
        if (m26500yU < 0) {
            File m26391bV = C10291a.m26395Dc().m26391bV(m25977K);
            if (C11122q.m23750L(m26391bV)) {
                z = true;
            } else {
                C10404a.C10405a c10405a = new C10404a.C10405a();
                z = C10291a.m26395Dc().m26393a(m25977K, c10405a);
                str = c10405a.msg;
            }
            adTemplate.setDownloadSize(m26391bV != null ? m26391bV.length() : 0L);
            adTemplate.setDownloadType(2);
        } else if (m26500yU > 0) {
            C10404a.C10405a c10405a2 = new C10404a.C10405a();
            if (C10251d.m26557CE() == 1) {
                m25468bl = C10562a.m25469b(ServiceProvider.getContext(), 1, 0);
            } else if (C10251d.m26557CE() == 2) {
                m25468bl = C10562a.m25469b(ServiceProvider.getContext(), 1, 1);
            } else {
                m25468bl = C10562a.m25468bl(ServiceProvider.getContext());
            }
            z = !m25468bl.m25439eC(m25977K) ? m25468bl.m25447a(m25977K, m26500yU * 1024, c10405a2, null) : true;
            str = c10405a2.msg;
            adTemplate.setDownloadSize(m26500yU * 1024);
            adTemplate.setDownloadType(3);
        } else {
            adTemplate.setDownloadSize(0L);
            adTemplate.setDownloadType(1);
            z = true;
        }
        if (!z) {
            adTemplate.setDownloadStatus(2);
            C7804b.m32292dO().m32293b(adTemplate, str);
            C7810a.m32265dU();
            C7810a.m32266b(str, adTemplate);
        } else {
            adTemplate.setDownloadStatus(1);
        }
        return z;
    }
}
