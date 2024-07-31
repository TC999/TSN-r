package com.kwad.components.p208ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
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

/* renamed from: com.kwad.components.ad.feed.monitor.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7600a {
    /* renamed from: d */
    public static Pair<Integer, String> m32825d(@NonNull AdTemplate adTemplate) {
        String m25977K = C10483a.m25977K(C10487e.m25641dQ(adTemplate));
        if (TextUtils.isEmpty(m25977K)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int m26500yU = C10251d.m26500yU();
        String str = "";
        int i = 1;
        if (m26500yU < 0) {
            File m26391bV = C10291a.m26395Dc().m26391bV(m25977K);
            if (!C11122q.m23750L(m26391bV)) {
                C10404a.C10405a c10405a = new C10404a.C10405a();
                int i2 = C10291a.m26395Dc().m26393a(m25977K, c10405a) ? 1 : 2;
                str = c10405a.msg;
                i = i2;
            }
            adTemplate.setDownloadSize(m26391bV != null ? m26391bV.length() : 0L);
        } else if (m26500yU > 0) {
            C10404a.C10405a c10405a2 = new C10404a.C10405a();
            C10569f m25468bl = C10562a.m25468bl(ServiceProvider.getContext());
            if (!m25468bl.m25439eC(m25977K)) {
                i = m25468bl.m25447a(m25977K, (long) (m26500yU * 1024), c10405a2, null) ? 1 : 2;
            }
            str = c10405a2.msg;
            adTemplate.setDownloadSize(m26500yU * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i), str);
    }
}
