package com.kwad.components.p208ad.p212c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.video.C9000j;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.sdk.core.diskcache.p394b.C10291a;
import com.kwad.sdk.core.network.p404a.C10404a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.videocache.C10569f;
import com.kwad.sdk.core.videocache.p415c.C10562a;
import com.kwad.sdk.export.proxy.AdHttpResponseListener;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11122q;
import java.io.File;

/* renamed from: com.kwad.components.ad.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7352b {
    @WorkerThread
    /* renamed from: a */
    public static boolean m33446a(@NonNull AdTemplate adTemplate, boolean z, final AdVideoPreCacheConfig adVideoPreCacheConfig, final InterfaceC7351a interfaceC7351a) {
        String m25977K = C10483a.m25977K(C10487e.m25641dQ(adTemplate));
        if (TextUtils.isEmpty(m25977K)) {
            return false;
        }
        final long adVideoPreCacheSize = adVideoPreCacheConfig.getAdVideoPreCacheSize() * 1024;
        String str = "";
        boolean z2 = true;
        if (adVideoPreCacheSize > 0) {
            long j = adVideoPreCacheConfig.isContinueLoadingAll() ? -1L : adVideoPreCacheSize;
            C10404a.C10405a c10405a = new C10404a.C10405a();
            C10569f m25468bl = C10562a.m25468bl(ServiceProvider.getContext());
            if (m25468bl.m25440eB(m25977K)) {
                m33448a(interfaceC7351a);
            } else {
                z2 = m25468bl.m25447a(m25977K, j, c10405a, new AdHttpResponseListener() { // from class: com.kwad.components.ad.c.b.1

                    /* renamed from: bF */
                    private boolean f25265bF = false;

                    @Override // com.kwad.sdk.export.proxy.AdHttpResponseListener
                    public final boolean onReadProgress(long j2, long j3) {
                        if ((j2 >= adVideoPreCacheSize || j2 >= j3) && !this.f25265bF) {
                            this.f25265bF = true;
                            C7352b.m33448a(interfaceC7351a);
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
            str = c10405a.msg;
        } else if (adVideoPreCacheSize < 0) {
            File m26391bV = C10291a.m26395Dc().m26391bV(m25977K);
            if (!C11122q.m23750L(m26391bV)) {
                C10404a.C10405a c10405a2 = new C10404a.C10405a();
                z2 = C10291a.m26395Dc().m26393a(m25977K, c10405a2);
                str = c10405a2.msg;
            }
            adTemplate.setDownloadSize(m26391bV != null ? m26391bV.length() : 0L);
            if (z2) {
                m33448a(interfaceC7351a);
            }
        } else {
            m33448a(interfaceC7351a);
        }
        if (z2) {
            C9000j.m29405n(m25977K, adVideoPreCacheConfig.getAdVideoPreCacheSize());
        } else {
            C8032c.m31764a(z, adTemplate, str);
            C8031b.m31782a(z, adTemplate);
            m33447a(interfaceC7351a, str);
        }
        return z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m33448a(InterfaceC7351a interfaceC7351a) {
        if (interfaceC7351a == null) {
            return;
        }
        interfaceC7351a.mo31980V();
    }

    /* renamed from: a */
    private static void m33447a(InterfaceC7351a interfaceC7351a, String str) {
        if (interfaceC7351a == null) {
            return;
        }
        interfaceC7351a.mo31979W();
    }
}
