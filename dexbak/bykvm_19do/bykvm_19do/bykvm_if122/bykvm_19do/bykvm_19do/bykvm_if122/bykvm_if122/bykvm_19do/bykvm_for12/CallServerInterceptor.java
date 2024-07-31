package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ForwardingSink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Okio;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.RealConnection;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.StreamAllocation;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.net.ProtocolException;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CallServerInterceptor implements Interceptor {

    /* renamed from: a */
    private final boolean f931a;

    /* compiled from: CallServerInterceptor.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.b$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static final class C1022a extends ForwardingSink {

        /* renamed from: b */
        long f932b;

        C1022a(Sink sink) {
            super(sink);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.ForwardingSink, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink
        /* renamed from: b */
        public void mo58561b(Buffer buffer, long j) throws IOException {
            super.mo58561b(buffer, j);
            this.f932b += j;
        }
    }

    public CallServerInterceptor(boolean z) {
        this.f931a = z;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor
    /* renamed from: a */
    public Response mo58275a(Interceptor.InterfaceC1079a interfaceC1079a) throws IOException {
        Response m58836a;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) interfaceC1079a;
        HttpCodec m58754h = realInterceptorChain.m58754h();
        StreamAllocation m58753i = realInterceptorChain.m58753i();
        RealConnection realConnection = (RealConnection) realInterceptorChain.m58756f();
        Request mo58272b = realInterceptorChain.mo58272b();
        long currentTimeMillis = System.currentTimeMillis();
        realInterceptorChain.m58755g().m58350d(realInterceptorChain.m58757e());
        m58754h.mo58643a(mo58272b);
        realInterceptorChain.m58755g().m58362a(realInterceptorChain.m58757e(), mo58272b);
        Response.C1017a c1017a = null;
        if (HttpMethod.m58762b(mo58272b.m58207e()) && mo58272b.m58212a() != null) {
            if ("100-continue".equalsIgnoreCase(mo58272b.m58211a(HttpHeaders.Names.EXPECT))) {
                m58754h.mo58639b();
                realInterceptorChain.m58755g().m58348f(realInterceptorChain.m58757e());
                c1017a = m58754h.mo58640a(true);
            }
            if (c1017a == null) {
                realInterceptorChain.m58755g().m58351c(realInterceptorChain.m58757e());
                C1022a c1022a = new C1022a(m58754h.mo58642a(mo58272b, mo58272b.m58212a().mo58189a()));
                BufferedSink m58927a = Okio.m58927a(c1022a);
                mo58272b.m58212a().mo58188a(m58927a);
                m58927a.close();
                realInterceptorChain.m58755g().m58366a(realInterceptorChain.m58757e(), c1022a.f932b);
            } else if (!realConnection.m58724c()) {
                m58753i.m58692d();
            }
        }
        m58754h.mo58645a();
        if (c1017a == null) {
            realInterceptorChain.m58755g().m58348f(realInterceptorChain.m58757e());
            c1017a = m58754h.mo58640a(false);
        }
        Response m58836a2 = c1017a.m58828a(mo58272b).m58831a(m58753i.m58695b().m58725b()).m58824b(currentTimeMillis).m58834a(System.currentTimeMillis()).m58836a();
        realInterceptorChain.m58755g().m58365a(realInterceptorChain.m58757e(), m58836a2);
        int m58846c = m58836a2.m58846c();
        if (this.f931a && m58846c == 101) {
            m58836a = m58836a2.m58841h().m58832a(C1061c.f1235c).m58836a();
        } else {
            m58836a = m58836a2.m58841h().m58832a(m58754h.mo58644a(m58836a2)).m58836a();
        }
        if ("close".equalsIgnoreCase(m58836a.m58838k().m58211a("Connection")) || "close".equalsIgnoreCase(m58836a.m58849a("Connection"))) {
            m58753i.m58692d();
        }
        if ((m58846c == 204 || m58846c == 205) && m58836a.m58850a().mo58752a() > 0) {
            throw new ProtocolException("HTTP " + m58846c + " had non-zero Content-Length: " + m58836a.m58850a().mo58752a());
        }
        return m58836a;
    }
}
