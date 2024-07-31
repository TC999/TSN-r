package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Headers;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.HttpMethod;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Request {

    /* renamed from: a */
    final HttpUrl f1455a;

    /* renamed from: b */
    final String f1456b;

    /* renamed from: c */
    final Headers f1457c;

    /* renamed from: d */
    final RequestBody f1458d;

    /* renamed from: e */
    final Object f1459e;

    /* renamed from: f */
    private volatile CacheControl f1460f;

    Request(C1083a c1083a) {
        this.f1455a = c1083a.f1461a;
        this.f1456b = c1083a.f1462b;
        this.f1457c = c1083a.f1463c.m58335a();
        this.f1458d = c1083a.f1464d;
        Object obj = c1083a.f1465e;
        this.f1459e = obj == null ? this : obj;
    }

    /* renamed from: a */
    public String m58211a(String str) {
        return this.f1457c.m58340a(str);
    }

    /* renamed from: b */
    public CacheControl m58210b() {
        CacheControl cacheControl = this.f1460f;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl m58441a = CacheControl.m58441a(this.f1457c);
        this.f1460f = m58441a;
        return m58441a;
    }

    /* renamed from: c */
    public Headers m58209c() {
        return this.f1457c;
    }

    /* renamed from: d */
    public boolean m58208d() {
        return this.f1455a.m58306h();
    }

    /* renamed from: e */
    public String m58207e() {
        return this.f1456b;
    }

    /* renamed from: f */
    public C1083a m58206f() {
        return new C1083a(this);
    }

    /* renamed from: g */
    public HttpUrl m58205g() {
        return this.f1455a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f1456b);
        sb.append(", url=");
        sb.append(this.f1455a);
        sb.append(", tag=");
        Object obj = this.f1459e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    /* compiled from: Request.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1083a {

        /* renamed from: a */
        HttpUrl f1461a;

        /* renamed from: b */
        String f1462b;

        /* renamed from: c */
        Headers.C1076a f1463c;

        /* renamed from: d */
        RequestBody f1464d;

        /* renamed from: e */
        Object f1465e;

        public C1083a() {
            this.f1462b = "GET";
            this.f1463c = new Headers.C1076a();
        }

        /* renamed from: a */
        public C1083a m58201a(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.f1461a = httpUrl;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: b */
        public C1083a m58194b(String str) {
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str = "https:" + str.substring(4);
                }
                HttpUrl m58311d = HttpUrl.m58311d(str);
                if (m58311d != null) {
                    return m58201a(m58311d);
                }
                throw new IllegalArgumentException("unexpected url: " + str);
            }
            throw new NullPointerException("url == null");
        }

        /* renamed from: a */
        public C1083a m58196a(String str, String str2) {
            this.f1463c.m58333a(str, str2);
            return this;
        }

        C1083a(Request request) {
            this.f1461a = request.f1455a;
            this.f1462b = request.f1456b;
            this.f1464d = request.f1458d;
            this.f1465e = request.f1459e;
            this.f1463c = request.f1457c.m58342a();
        }

        /* renamed from: a */
        public C1083a m58198a(String str) {
            this.f1463c.m58332b(str);
            return this;
        }

        /* renamed from: a */
        public C1083a m58202a(Headers headers) {
            this.f1463c = headers.m58342a();
            return this;
        }

        /* renamed from: a */
        public C1083a m58203a(CacheControl cacheControl) {
            String cacheControl2 = cacheControl.toString();
            return cacheControl2.isEmpty() ? m58198a("Cache-Control") : m58193b("Cache-Control", cacheControl2);
        }

        /* renamed from: a */
        public C1083a m58200a(RequestBody requestBody) {
            return m58197a("POST", requestBody);
        }

        /* renamed from: b */
        public C1083a m58193b(String str, String str2) {
            this.f1463c.m58330c(str, str2);
            return this;
        }

        /* renamed from: a */
        public C1083a m58197a(String str, RequestBody requestBody) {
            if (str != null) {
                if (str.length() != 0) {
                    if (requestBody != null && !HttpMethod.m58762b(str)) {
                        throw new IllegalArgumentException("method " + str + " must not have a request body.");
                    } else if (requestBody == null && HttpMethod.m58759e(str)) {
                        throw new IllegalArgumentException("method " + str + " must have a request body.");
                    } else {
                        this.f1462b = str;
                        this.f1464d = requestBody;
                        return this;
                    }
                }
                throw new IllegalArgumentException("method.length() == 0");
            }
            throw new NullPointerException("method == null");
        }

        /* renamed from: b */
        public C1083a m58195b() {
            return m58197a("GET", (RequestBody) null);
        }

        /* renamed from: a */
        public C1083a m58199a(Object obj) {
            this.f1465e = obj;
            return this;
        }

        /* renamed from: a */
        public Request m58204a() {
            if (this.f1461a != null) {
                return new Request(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    /* renamed from: a */
    public RequestBody m58212a() {
        return this.f1458d;
    }
}
