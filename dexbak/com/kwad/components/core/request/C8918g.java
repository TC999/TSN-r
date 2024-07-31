package com.kwad.components.core.request;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.config.C10249b;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import com.kwad.sdk.utils.C11131x;
import com.kwad.sdk.utils.C11137y;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.request.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8918g {
    private static final AtomicBoolean sHasInit = new AtomicBoolean();

    /* renamed from: Rs */
    private static volatile boolean f28801Rs = false;

    /* renamed from: Rt */
    private static final List<InterfaceC8922a> f28802Rt = new CopyOnWriteArrayList();

    /* renamed from: com.kwad.components.core.request.g$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8922a {
        /* renamed from: d */
        void mo24671d(@NonNull SdkConfigData sdkConfigData);

        /* renamed from: qv */
        void mo24670qv();
    }

    /* renamed from: a */
    public static synchronized void m29607a(InterfaceC8922a interfaceC8922a) {
        synchronized (C8918g.class) {
            C10331c.m26254d("ConfigRequestManager", "init config");
            if (sHasInit.getAndSet(true)) {
                C10331c.m26254d("ConfigRequestManager", "config request manager has init");
                return;
            }
            f28802Rt.add(interfaceC8922a);
            C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.request.g.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    Context m24363KO = ServiceProvider.m24363KO();
                    C11137y.m23571k(m24363KO, C11137y.m23585cb(m24363KO) + 1);
                    C10251d.m26521aS(m24363KO);
                    C8918g.m29602qs();
                    C8918g.m29603qr();
                }
            });
        }
    }

    static /* synthetic */ boolean access$102(boolean z) {
        f28801Rs = true;
        return true;
    }

    /* renamed from: qr */
    public static void m29603qr() {
        C10331c.m26254d("ConfigRequestManager", "requestConfig");
        new AbstractC10436l<C8917f, SdkConfigData>() { // from class: com.kwad.components.core.request.g.2
            @NonNull
            /* renamed from: aw */
            private static SdkConfigData m29600aw(String str) {
                SdkConfigData sdkConfigData = new SdkConfigData();
                try {
                    C11137y.m23598aj(ServiceProvider.m24363KO(), str);
                    sdkConfigData.parseJson(new JSONObject(str));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
                return sdkConfigData;
            }

            @NonNull
            /* renamed from: qu */
            private static C8917f m29599qu() {
                return new C8917f();
            }

            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            public final /* synthetic */ InterfaceC10420f createRequest() {
                return m29599qu();
            }

            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            public final /* synthetic */ SdkConfigData parseData(String str) {
                return m29600aw(str);
            }
        }.request(new AbstractC10439o<C8917f, SdkConfigData>() { // from class: com.kwad.components.core.request.g.3
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            /* renamed from: a */
            public void onError(@NonNull C8917f c8917f, int i, String str) {
                super.onError(c8917f, i, str);
                C10331c.m26254d("ConfigRequestManager", "onError errorCode=" + i + " errorMsg=" + str);
            }

            /* renamed from: c */
            private static void m29597c(@NonNull SdkConfigData sdkConfigData) {
                try {
                    C10331c.m26257T("ConfigRequestManager", "load config success");
                    C10249b.m26597aQ(ServiceProvider.m24363KO());
                    C10251d.m26518f(sdkConfigData);
                    C8918g.access$102(true);
                    C8918g.m29606a(sdkConfigData);
                    C11131x.m23664LA();
                    C11131x.m23658Lu();
                    C11137y.m23571k(ServiceProvider.m24363KO(), 0);
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m29597c((SdkConfigData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: qs */
    public static void m29602qs() {
        for (InterfaceC8922a interfaceC8922a : f28802Rt) {
            try {
                interfaceC8922a.mo24670qv();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* renamed from: b */
    public static void m29605b(InterfaceC8922a interfaceC8922a) {
        try {
            f28802Rt.add(interfaceC8922a);
            if (C10251d.isLoaded()) {
                interfaceC8922a.mo24670qv();
            }
            if (f28801Rs) {
                interfaceC8922a.mo24671d(C10251d.m26554Ca());
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m29606a(@NonNull SdkConfigData sdkConfigData) {
        for (InterfaceC8922a interfaceC8922a : f28802Rt) {
            try {
                interfaceC8922a.mo24671d(sdkConfigData);
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }
}
