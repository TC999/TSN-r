package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import java.io.Closeable;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Response implements Closeable {

    /* renamed from: a */
    final Request f862a;

    /* renamed from: b */
    final Protocol f863b;

    /* renamed from: c */
    final int f864c;

    /* renamed from: d */
    final String f865d;

    /* renamed from: e */
    final Handshake f866e;

    /* renamed from: f */
    final Headers f867f;

    /* renamed from: g */
    final ResponseBody f868g;

    /* renamed from: h */
    final Response f869h;

    /* renamed from: i */
    final Response f870i;

    /* renamed from: j */
    final Response f871j;

    /* renamed from: k */
    final long f872k;

    /* renamed from: l */
    final long f873l;

    /* renamed from: m */
    private volatile CacheControl f874m;

    /* compiled from: Response.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1017a {

        /* renamed from: a */
        Request f875a;

        /* renamed from: b */
        Protocol f876b;

        /* renamed from: c */
        int f877c;

        /* renamed from: d */
        String f878d;

        /* renamed from: e */
        Handshake f879e;

        /* renamed from: f */
        Headers.C1076a f880f;

        /* renamed from: g */
        ResponseBody f881g;

        /* renamed from: h */
        Response f882h;

        /* renamed from: i */
        Response f883i;

        /* renamed from: j */
        Response f884j;

        /* renamed from: k */
        long f885k;

        /* renamed from: l */
        long f886l;

        public C1017a() {
            this.f877c = -1;
            this.f880f = new Headers.C1076a();
        }

        /* renamed from: d */
        private void m58821d(Response response) {
            if (response.f868g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* renamed from: a */
        public C1017a m58828a(Request request) {
            this.f875a = request;
            return this;
        }

        /* renamed from: b */
        public C1017a m58823b(Response response) {
            if (response != null) {
                m58826a("networkResponse", response);
            }
            this.f882h = response;
            return this;
        }

        /* renamed from: c */
        public C1017a m58822c(Response response) {
            if (response != null) {
                m58821d(response);
            }
            this.f884j = response;
            return this;
        }

        /* renamed from: a */
        public C1017a m58829a(Protocol protocol) {
            this.f876b = protocol;
            return this;
        }

        /* renamed from: a */
        public C1017a m58835a(int i) {
            this.f877c = i;
            return this;
        }

        /* renamed from: b */
        public C1017a m58824b(long j) {
            this.f885k = j;
            return this;
        }

        C1017a(Response response) {
            this.f877c = -1;
            this.f875a = response.f862a;
            this.f876b = response.f863b;
            this.f877c = response.f864c;
            this.f878d = response.f865d;
            this.f879e = response.f866e;
            this.f880f = response.f867f.m58342a();
            this.f881g = response.f868g;
            this.f882h = response.f869h;
            this.f883i = response.f870i;
            this.f884j = response.f871j;
            this.f885k = response.f872k;
            this.f886l = response.f873l;
        }

        /* renamed from: a */
        public C1017a m58827a(String str) {
            this.f878d = str;
            return this;
        }

        /* renamed from: a */
        public C1017a m58831a(Handshake handshake) {
            this.f879e = handshake;
            return this;
        }

        /* renamed from: a */
        public C1017a m58825a(String str, String str2) {
            this.f880f.m58333a(str, str2);
            return this;
        }

        /* renamed from: a */
        public C1017a m58830a(Headers headers) {
            this.f880f = headers.m58342a();
            return this;
        }

        /* renamed from: a */
        public C1017a m58832a(ResponseBody responseBody) {
            this.f881g = responseBody;
            return this;
        }

        /* renamed from: a */
        public C1017a m58833a(Response response) {
            if (response != null) {
                m58826a("cacheResponse", response);
            }
            this.f883i = response;
            return this;
        }

        /* renamed from: a */
        private void m58826a(String str, Response response) {
            if (response.f868g == null) {
                if (response.f869h == null) {
                    if (response.f870i == null) {
                        if (response.f871j == null) {
                            return;
                        }
                        throw new IllegalArgumentException(str + ".priorResponse != null");
                    }
                    throw new IllegalArgumentException(str + ".cacheResponse != null");
                }
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            throw new IllegalArgumentException(str + ".body != null");
        }

        /* renamed from: a */
        public C1017a m58834a(long j) {
            this.f886l = j;
            return this;
        }

        /* renamed from: a */
        public Response m58836a() {
            if (this.f875a != null) {
                if (this.f876b != null) {
                    if (this.f877c >= 0) {
                        if (this.f878d != null) {
                            return new Response(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f877c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }
    }

    Response(C1017a c1017a) {
        this.f862a = c1017a.f875a;
        this.f863b = c1017a.f876b;
        this.f864c = c1017a.f877c;
        this.f865d = c1017a.f878d;
        this.f866e = c1017a.f879e;
        this.f867f = c1017a.f880f.m58335a();
        this.f868g = c1017a.f881g;
        this.f869h = c1017a.f882h;
        this.f870i = c1017a.f883i;
        this.f871j = c1017a.f884j;
        this.f872k = c1017a.f885k;
        this.f873l = c1017a.f886l;
    }

    /* renamed from: a */
    public String m58849a(String str) {
        return m58848a(str, null);
    }

    /* renamed from: b */
    public CacheControl m58847b() {
        CacheControl cacheControl = this.f874m;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl m58441a = CacheControl.m58441a(this.f867f);
        this.f874m = m58441a;
        return m58441a;
    }

    /* renamed from: c */
    public int m58846c() {
        return this.f864c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.f868g;
        if (responseBody != null) {
            responseBody.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    /* renamed from: d */
    public Handshake m58845d() {
        return this.f866e;
    }

    /* renamed from: e */
    public Headers m58844e() {
        return this.f867f;
    }

    /* renamed from: f */
    public boolean m58843f() {
        int i = this.f864c;
        return i >= 200 && i < 300;
    }

    /* renamed from: g */
    public String m58842g() {
        return this.f865d;
    }

    /* renamed from: h */
    public C1017a m58841h() {
        return new C1017a(this);
    }

    /* renamed from: i */
    public Response m58840i() {
        return this.f871j;
    }

    /* renamed from: j */
    public long m58839j() {
        return this.f873l;
    }

    /* renamed from: k */
    public Request m58838k() {
        return this.f862a;
    }

    /* renamed from: l */
    public long m58837l() {
        return this.f872k;
    }

    public String toString() {
        return "Response{protocol=" + this.f863b + ", code=" + this.f864c + ", message=" + this.f865d + ", url=" + this.f862a.m58205g() + '}';
    }

    /* renamed from: a */
    public String m58848a(String str, String str2) {
        String m58340a = this.f867f.m58340a(str);
        return m58340a != null ? m58340a : str2;
    }

    /* renamed from: a */
    public ResponseBody m58850a() {
        return this.f868g;
    }
}
