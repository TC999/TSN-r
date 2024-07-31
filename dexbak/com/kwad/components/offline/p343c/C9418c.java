package com.kwad.components.offline.p343c;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.core.p304n.p305a.p309d.InterfaceC8698a;
import com.kwad.components.core.p304n.p305a.p309d.InterfaceC8701c;
import com.kwad.components.core.p304n.p311b.AbstractC8702a;
import com.kwad.components.core.p304n.p311b.C8735b;
import com.kwad.components.core.request.AbstractC8923h;
import com.kwad.components.core.request.C8918g;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.components.offline.api.InitCallBack;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.offline.api.p341tk.ITkOfflineCompo;
import com.kwad.components.offline.api.p341tk.TkLoggerReporter;
import com.kwad.components.offline.api.p341tk.model.report.TKDownloadMsg;
import com.kwad.library.solder.lib.C9645i;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.components.offline.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9418c extends AbstractC8702a<ITkOfflineCompo> {
    private static long acU;
    private final List<InterfaceC8698a> acT;
    private final AtomicBoolean acV;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.offline.c.c$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public final class C94191 implements InitCallBack {
        final /* synthetic */ ITkOfflineCompo acW;
        final /* synthetic */ boolean acX;
        final /* synthetic */ long acY;
        final /* synthetic */ long acZ;

        /* renamed from: gq */
        final /* synthetic */ Context f29470gq;

        C94191(ITkOfflineCompo iTkOfflineCompo, boolean z, long j, long j2, Context context) {
            this.acW = iTkOfflineCompo;
            this.acX = z;
            this.acY = j;
            this.acZ = j2;
            this.f29470gq = context;
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onError(int i) {
            C9418c.this.m29999au(i);
        }

        @Override // com.kwad.components.offline.api.InitCallBack
        public final void onSuccess(boolean z) {
            try {
                final C9415b c9415b = new C9415b(this.acW);
                C9861c.m27503a(InterfaceC8701c.class, c9415b);
                C9418c.this.acV.set(true);
                int i = z ? 2 : 1;
                int i2 = this.acX ? 2 : 1;
                C9418c.this.m28825b(i, i2, SystemClock.elapsedRealtime() - this.acY, this.acZ);
                TkLoggerReporter.get().reportTKSOLoad(ILoggerReporter.Category.APM_LOG, new TKDownloadMsg().setDownloadState(3).setOfflineLoadTime(this.acZ).setSoLoadTime(SystemClock.elapsedRealtime() - this.acY).setInitSdkTimeConsuming(SystemClock.elapsedRealtime() - C10829k.m24699zd().m24677zz()).setThreadPoolCoreSize(C9645i.m28105xe().m28106wY().m28147xz()).setOfflineSource(i2).setSoSource(i).toJson());
                C9418c.this.m29995oN();
                C8918g.m29605b(new AbstractC8923h() { // from class: com.kwad.components.offline.c.c.1.1
                    @Override // com.kwad.components.core.request.AbstractC8923h, com.kwad.components.core.request.C8918g.InterfaceC8922a
                    /* renamed from: d */
                    public final void mo24671d(@NonNull final SdkConfigData sdkConfigData) {
                        super.mo24671d(sdkConfigData);
                        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.offline.c.c.1.1.1
                            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                            public final void doTask() {
                                C94201 c94201 = C94201.this;
                                c9415b.onConfigRefresh(C94191.this.f29470gq, sdkConfigData.toJson());
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
    /* renamed from: com.kwad.components.offline.c.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9422a {
        private static final C9418c adf = new C9418c((byte) 0);
    }

    /* synthetic */ C9418c(byte b) {
        this();
    }

    @InvokeBy(invokerClass = C8735b.class, methodId = "initOC")
    /* renamed from: aj */
    public static void m28826aj(Context context) {
        acU = SystemClock.elapsedRealtime();
        m28815tJ().init(context);
    }

    /* renamed from: tJ */
    public static C9418c m28815tJ() {
        return C9422a.adf;
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    public final String getTag() {
        return "TkInitModule";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    public final boolean isEnabled() {
        return ((Boolean) C10251d.m26520b(C10250c.arH)).booleanValue();
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oO */
    public final String mo28822oO() {
        return "TK";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oP */
    public final String mo28821oP() {
        return ITkOfflineCompo.PACKAGE_NAME;
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oQ */
    public final String mo28820oQ() {
        return BuildConfig.VERSION_NAME;
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oR */
    public final String mo28819oR() {
        return "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/offline_components/tk/ks_so-tachikomaNoSoRelease-3.3.59.1-dcbd937f5d-492.zip";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oS */
    public final String mo28818oS() {
        return "703df8b860ec5061cb90cac6b9ed6bc2";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oT */
    public final String mo28817oT() {
        return "ks_tk_33591";
    }

    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: oU */
    public final String mo28816oU() {
        return ITkOfflineCompo.IMPL;
    }

    private C9418c() {
        this.acT = new CopyOnWriteArrayList();
        this.acV = new AtomicBoolean(false);
    }

    /* renamed from: b */
    public final void m28824b(InterfaceC8698a interfaceC8698a) {
        if (interfaceC8698a == null) {
            return;
        }
        this.acT.remove(interfaceC8698a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m28825b(int i, int i2, long j, long j2) {
        for (InterfaceC8698a interfaceC8698a : this.acT) {
            try {
                interfaceC8698a.mo29087a(i, i2, j, j2);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.p304n.p311b.AbstractC8702a
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo28832a(Context context, boolean z, ITkOfflineCompo iTkOfflineCompo) {
        iTkOfflineCompo.init(context, new C9423d(), new C94191(iTkOfflineCompo, z, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - acU, context));
    }

    /* renamed from: a */
    public final void m28830a(InterfaceC8698a interfaceC8698a) {
        if (interfaceC8698a == null) {
            return;
        }
        try {
            if (this.acV.get()) {
                interfaceC8698a.mo29087a(1, 1, 0L, 0L);
            }
            this.acT.add(interfaceC8698a);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
