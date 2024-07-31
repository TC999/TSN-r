package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.BufferedSource;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Okio;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Sink;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Timeout;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Protocol;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Request;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Response;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ResponseBody;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.CacheStrategy;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpHeaders;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpMethod;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.RealResponseBody;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class CacheInterceptor implements Interceptor {

    /* renamed from: a */
    final InternalCache f893a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CacheInterceptor.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public class C1020a implements Source {

        /* renamed from: a */
        boolean f894a;

        /* renamed from: b */
        final /* synthetic */ BufferedSource f895b;

        /* renamed from: c */
        final /* synthetic */ CacheRequest f896c;

        /* renamed from: d */
        final /* synthetic */ BufferedSink f897d;

        C1020a(CacheInterceptor cacheInterceptor, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.f895b = bufferedSource;
            this.f896c = cacheRequest;
            this.f897d = bufferedSink;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: a */
        public long mo58558a(Buffer buffer, long j) throws IOException {
            try {
                long mo58558a = this.f895b.mo58558a(buffer, j);
                if (mo58558a == -1) {
                    if (!this.f894a) {
                        this.f894a = true;
                        this.f897d.close();
                    }
                    return -1L;
                }
                buffer.m58960a(this.f897d.mo58905o(), buffer.m58947f() - mo58558a, mo58558a);
                this.f897d.mo58916z();
                return mo58558a;
            } catch (IOException e) {
                if (!this.f894a) {
                    this.f894a = true;
                    this.f896c.m58811a();
                }
                throw e;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f894a && !C1061c.m58477a(this, 100, TimeUnit.MILLISECONDS)) {
                this.f894a = true;
                this.f896c.m58811a();
            }
            this.f895b.close();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Source
        /* renamed from: t */
        public Timeout mo58555t() {
            return this.f895b.mo58555t();
        }
    }

    public CacheInterceptor(InternalCache internalCache) {
        this.f893a = internalCache;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Interceptor
    /* renamed from: a */
    public Response mo58275a(Interceptor.InterfaceC1079a interfaceC1079a) throws IOException {
        InternalCache internalCache = this.f893a;
        Response m58797b = internalCache != null ? internalCache.m58797b(interfaceC1079a.mo58272b()) : null;
        CacheStrategy m58808a = new CacheStrategy.C1021a(System.currentTimeMillis(), interfaceC1079a.mo58272b(), m58797b).m58808a();
        Request request = m58808a.f898a;
        Response response = m58808a.f899b;
        InternalCache internalCache2 = this.f893a;
        if (internalCache2 != null) {
            internalCache2.m58799a(m58808a);
        }
        if (m58797b != null && response == null) {
            C1061c.m58475a(m58797b.m58850a());
        }
        if (request == null && response == null) {
            return new Response.C1017a().m58828a(interfaceC1079a.mo58272b()).m58829a(Protocol.HTTP_1_1).m58835a(504).m58827a("Unsatisfiable Request (only-if-cached)").m58832a(C1061c.f1235c).m58824b(-1L).m58834a(System.currentTimeMillis()).m58836a();
        }
        if (request == null) {
            return response.m58841h().m58833a(m58815a(response)).m58836a();
        }
        try {
            Response mo58273a = interfaceC1079a.mo58273a(request);
            if (mo58273a == null && m58797b != null) {
            }
            if (response != null) {
                if (mo58273a.m58846c() == 304) {
                    Response m58836a = response.m58841h().m58830a(m58813a(response.m58844e(), mo58273a.m58844e())).m58824b(mo58273a.m58837l()).m58834a(mo58273a.m58839j()).m58833a(m58815a(response)).m58823b(m58815a(mo58273a)).m58836a();
                    mo58273a.m58850a().close();
                    this.f893a.m58802a();
                    this.f893a.m58800a(response, m58836a);
                    return m58836a;
                }
                C1061c.m58475a(response.m58850a());
            }
            Response m58836a2 = mo58273a.m58841h().m58833a(m58815a(response)).m58823b(m58815a(mo58273a)).m58836a();
            if (this.f893a != null) {
                if (HttpHeaders.m58765b(m58836a2) && CacheStrategy.m58809a(m58836a2, request)) {
                    return m58814a(this.f893a.m58801a(m58836a2), m58836a2);
                }
                if (HttpMethod.m58763a(request.m58207e())) {
                    try {
                        this.f893a.m58798a(request);
                    } catch (IOException unused) {
                    }
                }
            }
            return m58836a2;
        } finally {
            if (m58797b != null) {
                C1061c.m58475a(m58797b.m58850a());
            }
        }
    }

    /* renamed from: a */
    private static Response m58815a(Response response) {
        return (response == null || response.m58850a() == null) ? response : response.m58841h().m58832a((ResponseBody) null).m58836a();
    }

    /* renamed from: a */
    private Response m58814a(CacheRequest cacheRequest, Response response) throws IOException {
        Sink m58810b;
        if (cacheRequest == null || (m58810b = cacheRequest.m58810b()) == null) {
            return response;
        }
        return response.m58841h().m58832a(new RealResponseBody(response.m58849a("Content-Type"), response.m58850a().mo58752a(), Okio.m58926a(new C1020a(this, response.m58850a().mo58750c(), cacheRequest, Okio.m58927a(m58810b))))).m58836a();
    }

    /* renamed from: a */
    private static Headers m58813a(Headers headers, Headers headers2) {
        Headers.C1076a c1076a = new Headers.C1076a();
        int m58338b = headers.m58338b();
        for (int i = 0; i < m58338b; i++) {
            String m58341a = headers.m58341a(i);
            String m58337b = headers.m58337b(i);
            if ((!HttpHeaders.Names.WARNING.equalsIgnoreCase(m58341a) || !m58337b.startsWith("1")) && (!m58812a(m58341a) || headers2.m58340a(m58341a) == null)) {
                Internal.f891a.mo58231a(c1076a, m58341a, m58337b);
            }
        }
        int m58338b2 = headers2.m58338b();
        for (int i2 = 0; i2 < m58338b2; i2++) {
            String m58341a2 = headers2.m58341a(i2);
            if (!"Content-Length".equalsIgnoreCase(m58341a2) && m58812a(m58341a2)) {
                Internal.f891a.mo58231a(c1076a, m58341a2, headers2.m58337b(i2));
            }
        }
        return c1076a.m58335a();
    }

    /* renamed from: a */
    static boolean m58812a(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || HttpHeaders.Names.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.Names.f40229TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HttpHeaders.Names.TRANSFER_ENCODING.equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }
}
