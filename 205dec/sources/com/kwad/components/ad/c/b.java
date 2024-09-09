package com.kwad.components.ad.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.reward.monitor.c;
import com.kwad.components.core.video.j;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.videocache.f;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.q;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    @WorkerThread
    public static boolean a(@NonNull AdTemplate adTemplate, boolean z3, final AdVideoPreCacheConfig adVideoPreCacheConfig, final a aVar) {
        String K = com.kwad.sdk.core.response.b.a.K(e.dQ(adTemplate));
        if (TextUtils.isEmpty(K)) {
            return false;
        }
        final long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * 1024;
        String str = "";
        boolean z4 = true;
        if (adVideoPreCacheSize > 0) {
            long j4 = adVideoPreCacheConfig.isContinueLoadingAll() ? -1L : adVideoPreCacheSize;
            a.C0699a c0699a = new a.C0699a();
            f bl = com.kwad.sdk.core.videocache.c.a.bl(ServiceProvider.getContext());
            if (bl.eB(K)) {
                a(aVar);
            } else {
                z4 = bl.a(K, j4, c0699a, new AdHttpResponseListener() { // from class: com.kwad.components.ad.c.b.1
                    private boolean bF = false;

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final boolean onReadProgress(long j5, long j6) {
                        if ((j5 >= adVideoPreCacheSize || j5 >= j6) && !this.bF) {
                            this.bF = true;
                            b.a(aVar);
                            if (!adVideoPreCacheConfig.isContinueLoadingAll()) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseEnd() {
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final void onResponseStart() {
                    }
                });
            }
            str = c0699a.msg;
        } else if (adVideoPreCacheSize < 0) {
            File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(K);
            if (!q.L(bV)) {
                a.C0699a c0699a2 = new a.C0699a();
                z4 = com.kwad.sdk.core.diskcache.b.a.Dc().a(K, c0699a2);
                str = c0699a2.msg;
            }
            adTemplate.setDownloadSize(bV != null ? bV.length() : 0L);
            if (z4) {
                a(aVar);
            }
        } else {
            a(aVar);
        }
        if (z4) {
            j.n(K, adVideoPreCacheConfig.getAdVideoPreCacheSize());
        } else {
            c.a(z3, adTemplate, str);
            com.kwad.components.ad.reward.monitor.b.a(z3, adTemplate);
            a(aVar, str);
        }
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(a aVar) {
        if (aVar == null) {
            return;
        }
        aVar.V();
    }

    private static void a(a aVar, String str) {
        if (aVar == null) {
            return;
        }
        aVar.W();
    }
}
