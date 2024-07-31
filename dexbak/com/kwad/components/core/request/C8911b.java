package com.kwad.components.core.request;

import com.kwad.sdk.service.ServiceProvider;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.kwad.components.core.request.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8911b {

    /* renamed from: Rp */
    private final List<InterfaceC8912a> f28798Rp;

    /* renamed from: com.kwad.components.core.request.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8912a {
        /* renamed from: qp */
        void mo24655qp();
    }

    /* renamed from: com.kwad.components.core.request.b$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C8913b {

        /* renamed from: Rq */
        private static final C8911b f28799Rq = new C8911b((byte) 0);
    }

    /* synthetic */ C8911b(byte b) {
        this();
    }

    /* renamed from: qn */
    public static C8911b m29612qn() {
        return C8913b.f28799Rq;
    }

    /* renamed from: a */
    public final void m29614a(InterfaceC8912a interfaceC8912a) {
        this.f28798Rp.add(interfaceC8912a);
    }

    /* renamed from: b */
    public final void m29613b(InterfaceC8912a interfaceC8912a) {
        this.f28798Rp.remove(interfaceC8912a);
    }

    /* renamed from: qo */
    public final void m29611qo() {
        for (InterfaceC8912a interfaceC8912a : this.f28798Rp) {
            if (interfaceC8912a != null) {
                try {
                    interfaceC8912a.mo24655qp();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        }
    }

    private C8911b() {
        this.f28798Rp = new CopyOnWriteArrayList();
    }
}
