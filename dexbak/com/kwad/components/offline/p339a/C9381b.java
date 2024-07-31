package com.kwad.components.offline.p339a;

import android.content.Context;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.p304n.p305a.p306a.InterfaceC8695a;
import com.kwad.components.core.p304n.p311b.AbstractC8702a;
import com.kwad.components.core.p304n.p311b.C8735b;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.offline.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9381b extends AbstractC8702a<IAdLiveOfflineCompo> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.offline.a.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9383a {
        private static final C9381b acC = new C9381b((byte) 0);
    }

    /* synthetic */ C9381b(byte b) {
        this();
    }

    @InvokeBy(invokerClass = C8735b.class, methodId = "initOC")
    /* renamed from: aj */
    public static void m28862aj(Context context) {
        m28861tE().init(context);
    }

    /* renamed from: tE */
    private static C9381b m28861tE() {
        return C9383a.acC;
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo28832a(Context context, boolean z, IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        m28865a(context, iAdLiveOfflineCompo);
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    public final String getTag() {
        return "AdLiveInitModule";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    public final boolean isEnabled() {
        return ((Boolean) C10251d.m26520b(C10250c.arG)).booleanValue();
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oO */
    public final String mo28822oO() {
        return "LIVE";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oP */
    public final String mo28821oP() {
        return IAdLiveOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oQ */
    public final String mo28820oQ() {
        return "3.3.59";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oR */
    public final String mo28819oR() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/adLive/ks_so-adLiveNoSoRelease-3.3.59-5a16210b94-483.zip";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oS */
    public final String mo28818oS() {
        return "d4d7aede5bd01c9eaf4bf3cf50b001ef";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oT */
    public final String mo28817oT() {
        return "ks_live_3359";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oU */
    public final String mo28816oU() {
        return IAdLiveOfflineCompo.IMPL;
    }

    private C9381b() {
    }

    /* renamed from: a */
    private void m28865a(Context context, final IAdLiveOfflineCompo iAdLiveOfflineCompo) {
        iAdLiveOfflineCompo.init(context, new C9384c(), new InitCallBack() { // from class: com.kwad.components.offline.a.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                C9381b.this.m29999au(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    C9861c.m27503a(InterfaceC8695a.class, new C9378a(iAdLiveOfflineCompo));
                    C9381b.this.m29995oN();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
