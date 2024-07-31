package com.kwad.sdk.commercial.p379h;

import android.content.Context;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.components.C9865f;
import com.kwad.sdk.core.p391c.AbstractC10247d;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p397e.p398a.InterfaceC10329a;
import com.kwad.sdk.p437i.C10795g;
import com.kwad.sdk.p437i.C10796h;
import com.kwad.sdk.p437i.InterfaceC10794f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11029av;
import com.kwad.sdk.utils.C11095g;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.kwad.sdk.commercial.h.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9837a implements InterfaceC10329a {

    /* renamed from: JB */
    private final AtomicBoolean f29518JB;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.commercial.h.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9841a {
        private static final C9837a aoH = new C9837a((byte) 0);
    }

    /* synthetic */ C9837a(byte b) {
        this();
    }

    /* renamed from: AR */
    public static C9837a m27546AR() {
        return C9841a.aoH;
    }

    @InvokeBy(invokerClass = C10331c.class, methodId = "registerLogger")
    public static void register() {
        C10331c.m26256a(m27546AR());
    }

    /* renamed from: cH */
    public final void m27545cH(String str) {
        try {
            if (this.f29518JB.get()) {
                return;
            }
            Context m24363KO = ServiceProvider.m24363KO();
            final InterfaceC10968f interfaceC10968f = (InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class);
            C10796h.m24844Jc().m24829a(str, C10795g.m24860IX().m24854fN(ServiceProvider.m24362KP().appId).m24853fO(ServiceProvider.getSdkVersion()).m24852fP(C11029av.getOaid()).m24849fS(C11029av.m24033cv(m24363KO)).m24851fQ(C11029av.getDeviceId()).m24850fR(C11029av.m24032cw(m24363KO)).m24846m(interfaceC10968f.mo24331yx()).m24855bE(C9865f.encryptDisable()).m24848fT(interfaceC10968f.mo24332yw()).m24847g(interfaceC10968f.mo24329yz()).m24845n(interfaceC10968f.mo24330yy()), new InterfaceC10794f() { // from class: com.kwad.sdk.commercial.h.a.1
                @Override // com.kwad.sdk.p437i.InterfaceC10794f
                /* renamed from: a */
                public final void mo24862a(String str2, Map<String, String> map, String str3) {
                    interfaceC10968f.mo24344a(str2, map, str3);
                }

                @Override // com.kwad.sdk.p437i.InterfaceC10794f
                /* renamed from: al */
                public final String mo24861al(String str2) {
                    return interfaceC10968f.mo24342al(str2);
                }
            });
            C10232b.m26625DD();
            C10232b.m26622a(new AbstractC10247d() { // from class: com.kwad.sdk.commercial.h.a.2
                @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                }

                @Override // com.kwad.sdk.core.p391c.AbstractC10247d, com.kwad.sdk.core.p391c.InterfaceC10246c
                public final void onBackToForeground() {
                    super.onBackToForeground();
                    C11095g.schedule(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.commercial.h.a.2.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C10796h.m24844Jc().m24843Jd();
                        }
                    }, 3L, TimeUnit.SECONDS);
                }
            });
            this.f29518JB.set(true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: d */
    public final void mo26267d(String str, String str2) {
        C10796h.m24844Jc().m24822f("d", str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: e */
    public final void mo26266e(String str, String str2) {
        C10796h.m24844Jc().m24822f("e", str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: i */
    public final void mo26265i(String str, String str2) {
        C10796h.m24844Jc().m24822f("i", str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    public final void printStackTraceOnly(Throwable th) {
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: v */
    public final void mo26264v(String str, String str2) {
        C10796h.m24844Jc().m24822f("v", str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: w */
    public final void mo26262w(String str, String str2) {
        C10796h.m24844Jc().m24822f(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }

    private C9837a() {
        this.f29518JB = new AtomicBoolean(false);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: v */
    public final void mo26263v(String str, String str2, boolean z) {
        C10796h.m24844Jc().m24822f("v", str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: w */
    public final void mo26261w(String str, String str2, boolean z) {
        C10796h.m24844Jc().m24822f(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }
}
