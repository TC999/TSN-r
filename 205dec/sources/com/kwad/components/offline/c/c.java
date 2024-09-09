package com.kwad.components.offline.c;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.request.g;
import com.kwad.components.core.request.h;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TkLoggerReporter;
import com.kwad.components.offline.api.tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.i;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ay;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c extends com.kwad.components.core.n.b.a<ITkOfflineCompo> {
    private static long acU;
    private final List<com.kwad.components.core.n.a.d.a> acT;
    private final AtomicBoolean acV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.offline.c.c$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public final class AnonymousClass1 implements InitCallBack {
        final /* synthetic */ ITkOfflineCompo acW;
        final /* synthetic */ boolean acX;
        final /* synthetic */ long acY;
        final /* synthetic */ long acZ;
        final /* synthetic */ Context gq;

        AnonymousClass1(ITkOfflineCompo iTkOfflineCompo, boolean z3, long j4, long j5, Context context) {
            this.acW = iTkOfflineCompo;
            this.acX = z3;
            this.acY = j4;
            this.acZ = j5;
            this.gq = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i4) {
            c.this.au(i4);
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z3) {
            try {
                final b bVar = new b(this.acW);
                com.kwad.sdk.components.c.a(com.kwad.components.core.n.a.d.c.class, bVar);
                c.this.acV.set(true);
                int i4 = z3 ? 2 : 1;
                int i5 = this.acX ? 2 : 1;
                c.this.b(i4, i5, SystemClock.elapsedRealtime() - this.acY, this.acZ);
                TkLoggerReporter.get().reportTKSOLoad("ad_client_apm_log", new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.acZ).setSoLoadTime(SystemClock.elapsedRealtime() - this.acY).setInitSdkTimeConsuming(SystemClock.elapsedRealtime() - k.zd().zz()).setThreadPoolCoreSize(i.xe().wY().xz()).setOfflineSource(i5).setSoSource(i4).toJson());
                c.this.oN();
                g.b(new h() { // from class: com.kwad.components.offline.c.c.1.1
                    @Override // com.kwad.components.core.request.h, com.kwad.components.core.request.g.a
                    public final void d(@NonNull final SdkConfigData sdkConfigData) {
                        super.d(sdkConfigData);
                        com.kwad.sdk.utils.g.execute(new ay() { // from class: com.kwad.components.offline.c.c.1.1.1
                            @Override // com.kwad.sdk.utils.ay
                            public final void doTask() {
                                C06641 c06641 = C06641.this;
                                bVar.onConfigRefresh(AnonymousClass1.this.gq, sdkConfigData.toJson());
                            }
                        });
                    }
                });
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class a {
        private static final c adf = new c((byte) 0);
    }

    /* synthetic */ c(byte b4) {
        this();
    }

    @InvokeBy(invokerClass = com.kwad.components.core.n.b.b.class, methodId = "initOC")
    public static void aj(Context context) {
        acU = SystemClock.elapsedRealtime();
        tJ().init(context);
    }

    public static c tJ() {
        return a.adf;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.n.b.a
    public final boolean isEnabled() {
        return ((Boolean) com.kwad.sdk.core.config.d.b(com.kwad.sdk.core.config.c.arH)).booleanValue();
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oO() {
        return "TK";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oP() {
        return "com.kwad.components.tachikoma";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oQ() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oR() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.59.1-dcbd937f5d-492.zip";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oS() {
        return "703df8b860ec5061cb90cac6b9ed6bc2";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oT() {
        return "ks_tk_33591";
    }

    @Override // com.kwad.components.core.n.b.a
    public final String oU() {
        return "com.kwad.tachikoma.TkOfflineCompoImpl";
    }

    private c() {
        this.acT = new CopyOnWriteArrayList();
        this.acV = new AtomicBoolean(false);
    }

    public final void b(com.kwad.components.core.n.a.d.a aVar) {
        if (aVar == null) {
            return;
        }
        this.acT.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i4, int i5, long j4, long j5) {
        for (com.kwad.components.core.n.a.d.a aVar : this.acT) {
            try {
                aVar.a(i4, i5, j4, j5);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.b.a
    public void a(Context context, boolean z3, ITkOfflineCompo iTkOfflineCompo) {
        iTkOfflineCompo.init(context, new d(), new AnonymousClass1(iTkOfflineCompo, z3, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - acU, context));
    }

    public final void a(com.kwad.components.core.n.a.d.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (this.acV.get()) {
                aVar.a(1, 1, 0L, 0L);
            }
            this.acT.add(aVar);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
