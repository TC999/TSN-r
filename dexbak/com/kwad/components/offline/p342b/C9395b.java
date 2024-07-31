package com.kwad.components.offline.p342b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.p304n.p305a.p308c.InterfaceC8697a;
import com.kwad.components.core.p304n.p311b.AbstractC8702a;
import com.kwad.components.core.p304n.p311b.C8735b;
import com.kwad.components.core.request.C8918g;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.components.offline.b.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9395b extends AbstractC8702a<IObiwanOfflineCompo> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.offline.b.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9398a {
        private static final C9395b acQ = new C9395b((byte) 0);
    }

    /* synthetic */ C9395b(byte b) {
        this();
    }

    @InvokeBy(invokerClass = C8735b.class, methodId = "initOC")
    /* renamed from: aj */
    public static void m28848aj(Context context) {
        m28847tH().init(context);
    }

    /* renamed from: tH */
    private static C9395b m28847tH() {
        return C9398a.acQ;
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo28832a(Context context, boolean z, IObiwanOfflineCompo iObiwanOfflineCompo) {
        m28851a(context, iObiwanOfflineCompo);
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    public final boolean isEnabled() {
        return ((Boolean) C10251d.m26520b(C10250c.ase)).booleanValue();
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oO */
    public final String mo28822oO() {
        return "OBIWAN";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oP */
    public final String mo28821oP() {
        return IObiwanOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oQ */
    public final String mo28820oQ() {
        return "3.3.56";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oR */
    public final String mo28819oR() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.56-445ef4f109-409.zip";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oS */
    public final String mo28818oS() {
        return "d4a07cc878d997efd944c0182236fa7c";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oT */
    public final String mo28817oT() {
        return "ks_obiwan_3356";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oU */
    public final String mo28816oU() {
        return IObiwanOfflineCompo.IMPL;
    }

    private C9395b() {
    }

    /* renamed from: a */
    private void m28851a(Context context, final IObiwanOfflineCompo iObiwanOfflineCompo) {
        iObiwanOfflineCompo.init(context, new C9400d(), new InitCallBack() { // from class: com.kwad.components.offline.b.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i) {
                C9395b.this.m29999au(i);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z) {
                try {
                    final C9394a c9394a = new C9394a(iObiwanOfflineCompo);
                    C9861c.m27503a(InterfaceC8697a.class, c9394a);
                    C10331c.m26256a(new C9399c(c9394a.getLog()));
                    C9395b.this.m29995oN();
                    C8918g.m29605b(new C8918g.InterfaceC8922a() { // from class: com.kwad.components.offline.b.b.1.1
                        private void updateConfigs() {
                            C10331c.m26256a(C10251d.m26527a(C10250c.ase) ? new C9399c(c9394a.getLog()) : null);
                            c9394a.updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.C8918g.InterfaceC8922a
                        /* renamed from: d */
                        public final void mo24671d(@NonNull SdkConfigData sdkConfigData) {
                            updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.C8918g.InterfaceC8922a
                        /* renamed from: qv */
                        public final void mo24670qv() {
                            updateConfigs();
                        }
                    });
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }
}
