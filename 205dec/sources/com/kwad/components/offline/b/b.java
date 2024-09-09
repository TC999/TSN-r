package com.kwad.components.offline.b;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.g;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.obiwan.IObiwanOfflineCompo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b extends com.kwad.components.core.n.b.a<IObiwanOfflineCompo> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {
        private static final b acQ = new b((byte) 0);
    }

    /* synthetic */ b(byte b4) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void aj(Context context) {
        tH().init(context);
    }

    private static b tH() {
        return a.acQ;
    }

    @Override // com.kwad.components.core.n.b.a
    public final /* bridge */ /* synthetic */ void a(Context context, boolean z3, IObiwanOfflineCompo iObiwanOfflineCompo) {
        a(context, iObiwanOfflineCompo);
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "ObiwanInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.ase)).booleanValue();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oO() {
        return "OBIWAN";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oP() {
        return "com.kwad.components.obiwan";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oQ() {
        return "3.3.56";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oR() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/obiwan/ks_so-obiwanNoSoRelease-3.3.56-445ef4f109-409.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oS() {
        return "d4a07cc878d997efd944c0182236fa7c";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oT() {
        return "ks_obiwan_3356";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oU() {
        return "com.kwad.sdk.core.log.ObiwanOfflineCompoImpl";
    }

    private b() {
    }

    private void a(Context context, final IObiwanOfflineCompo iObiwanOfflineCompo) {
        iObiwanOfflineCompo.init(context, new d(), new InitCallBack() { // from class: com.kwad.components.offline.b.b.1
            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onError(int i4) {
                b.this.au(i4);
            }

            @Override // com.kwad.components.offline.api.InitCallBack
            public final void onSuccess(boolean z3) {
                try {
                    final com.kwad.components.offline.b.a aVar = new com.kwad.components.offline.b.a(iObiwanOfflineCompo);
                    com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.c.a.class, aVar);
                    com.kwad.sdk.core.e.c.a(new c(aVar.getLog()));
                    b.this.oN();
                    g.b(new g.a() { // from class: com.kwad.components.offline.b.b.1.1
                        private void updateConfigs() {
                            com.kwad.sdk.core.e.c.a(com.kwad.sdk.core.config.d.a(com.kwad.sdk.core.config.c.ase) ? new c(aVar.getLog()) : null);
                            aVar.updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.g.a
                        public final void d(@NonNull SdkConfigData sdkConfigData) {
                            updateConfigs();
                        }

                        @Override // com.kwad.components.core.request.g.a
                        public final void qv() {
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
