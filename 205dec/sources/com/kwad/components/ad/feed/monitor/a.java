package com.kwad.components.ad.feed.monitor;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.config.d;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.q;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    public static Pair<Integer, String> d(@NonNull AdTemplate adTemplate) {
        String K = com.kwad.sdk.core.response.b.a.K(e.dQ(adTemplate));
        if (TextUtils.isEmpty(K)) {
            return new Pair<>(2, "empty videoUrl");
        }
        int yU = d.yU();
        String str = "";
        int i4 = 1;
        if (yU < 0) {
            File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(K);
            if (!q.L(bV)) {
                a.C0699a c0699a = new a.C0699a();
                int i5 = com.kwad.sdk.core.diskcache.b.a.Dc().a(K, c0699a) ? 1 : 2;
                str = c0699a.msg;
                i4 = i5;
            }
            adTemplate.setDownloadSize(bV != null ? bV.length() : 0L);
        } else if (yU > 0) {
            a.C0699a c0699a2 = new a.C0699a();
            f bl = com.kwad.sdk.core.videocache.c.a.bl(ServiceProvider.getContext());
            if (!bl.eC(K)) {
                i4 = bl.a(K, (long) (yU * 1024), c0699a2, null) ? 1 : 2;
            }
            str = c0699a2.msg;
            adTemplate.setDownloadSize(yU * 1024);
        } else {
            adTemplate.setDownloadSize(0L);
        }
        return new Pair<>(Integer.valueOf(i4), str);
    }
}
