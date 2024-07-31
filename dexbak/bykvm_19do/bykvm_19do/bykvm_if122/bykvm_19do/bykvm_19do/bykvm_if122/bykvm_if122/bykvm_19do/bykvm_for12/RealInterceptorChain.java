package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Call;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Connection;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.EventListener;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RealConnection;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.StreamAllocation;
import java.io.IOException;
import java.util.List;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RealInterceptorChain implements Interceptor.InterfaceC1079a {

    /* renamed from: a */
    private final List<Interceptor> f936a;

    /* renamed from: b */
    private final StreamAllocation f937b;

    /* renamed from: c */
    private final HttpCodec f938c;

    /* renamed from: d */
    private final RealConnection f939d;

    /* renamed from: e */
    private final int f940e;

    /* renamed from: f */
    private final Request f941f;

    /* renamed from: g */
    private final Call f942g;

    /* renamed from: h */
    private final EventListener f943h;

    /* renamed from: i */
    private final int f944i;

    /* renamed from: j */
    private final int f945j;

    /* renamed from: k */
    private final int f946k;

    /* renamed from: l */
    private int f947l;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, Request request, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.f936a = list;
        this.f939d = realConnection;
        this.f937b = streamAllocation;
        this.f938c = httpCodec;
        this.f940e = i;
        this.f941f = request;
        this.f942g = call;
        this.f943h = eventListener;
        this.f944i = i2;
        this.f945j = i3;
        this.f946k = i4;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor.InterfaceC1079a
    /* renamed from: a */
    public int mo58274a() {
        return this.f946k;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor.InterfaceC1079a
    /* renamed from: b */
    public Request mo58272b() {
        return this.f941f;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor.InterfaceC1079a
    /* renamed from: c */
    public int mo58271c() {
        return this.f944i;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor.InterfaceC1079a
    /* renamed from: d */
    public int mo58270d() {
        return this.f945j;
    }

    /* renamed from: e */
    public Call m58757e() {
        return this.f942g;
    }

    /* renamed from: f */
    public Connection m58756f() {
        return this.f939d;
    }

    /* renamed from: g */
    public EventListener m58755g() {
        return this.f943h;
    }

    /* renamed from: h */
    public HttpCodec m58754h() {
        return this.f938c;
    }

    /* renamed from: i */
    public StreamAllocation m58753i() {
        return this.f937b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor.InterfaceC1079a
    /* renamed from: a */
    public Response mo58273a(Request request) throws IOException {
        return m58758a(request, this.f937b, this.f938c, this.f939d);
    }

    /* renamed from: a */
    public Response m58758a(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.f940e < this.f936a.size()) {
            this.f947l++;
            if (this.f938c != null && !this.f939d.m58728a(request.m58205g())) {
                throw new IllegalStateException("network interceptor " + this.f936a.get(this.f940e - 1) + " must retain the same host and port");
            } else if (this.f938c != null && this.f947l > 1) {
                throw new IllegalStateException("network interceptor " + this.f936a.get(this.f940e - 1) + " must call proceed() exactly once");
            } else {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f936a, streamAllocation, httpCodec, realConnection, this.f940e + 1, request, this.f942g, this.f943h, this.f944i, this.f945j, this.f946k);
                Interceptor interceptor = this.f936a.get(this.f940e);
                Response mo58275a = interceptor.mo58275a(realInterceptorChain);
                if (httpCodec != null && this.f940e + 1 < this.f936a.size() && realInterceptorChain.f947l != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (mo58275a != null) {
                    if (mo58275a.m58850a() != null) {
                        return mo58275a;
                    }
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                } else {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                }
            }
        }
        throw new AssertionError();
    }
}
