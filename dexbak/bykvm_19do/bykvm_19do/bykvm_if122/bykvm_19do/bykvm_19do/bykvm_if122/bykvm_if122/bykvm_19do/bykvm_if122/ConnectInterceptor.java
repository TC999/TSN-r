package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.RealInterceptorChain;
import java.io.IOException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ConnectInterceptor implements Interceptor {

    /* renamed from: a */
    public final OkHttpClient f959a;

    public ConnectInterceptor(OkHttpClient okHttpClient) {
        this.f959a = okHttpClient;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor
    /* renamed from: a */
    public Response mo58275a(Interceptor.InterfaceC1079a interfaceC1079a) throws IOException {
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) interfaceC1079a;
        Request mo58272b = realInterceptorChain.mo58272b();
        StreamAllocation m58753i = realInterceptorChain.m58753i();
        return realInterceptorChain.m58758a(mo58272b, m58753i, m58753i.m58699a(this.f959a, interfaceC1079a, !mo58272b.m58207e().equals("GET")), m58753i.m58695b());
    }
}
