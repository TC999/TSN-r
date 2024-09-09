package xyz.adscope.common.network;

import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public abstract class Request {

    /* renamed from: a  reason: collision with root package name */
    public final RequestMethod f64816a;

    /* renamed from: b  reason: collision with root package name */
    public final Headers f64817b;

    /* renamed from: c  reason: collision with root package name */
    public final Proxy f64818c;

    /* renamed from: d  reason: collision with root package name */
    public final SSLSocketFactory f64819d;

    /* renamed from: e  reason: collision with root package name */
    public final HostnameVerifier f64820e;

    /* renamed from: f  reason: collision with root package name */
    public final int f64821f;

    /* renamed from: g  reason: collision with root package name */
    public final int f64822g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f64823h;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static abstract class Api<T extends Api<T>> {

        /* renamed from: a  reason: collision with root package name */
        public final RequestMethod f64824a;

        /* renamed from: b  reason: collision with root package name */
        public final Headers f64825b;

        /* renamed from: c  reason: collision with root package name */
        public Proxy f64826c;

        /* renamed from: d  reason: collision with root package name */
        public SSLSocketFactory f64827d;

        /* renamed from: e  reason: collision with root package name */
        public HostnameVerifier f64828e;

        /* renamed from: f  reason: collision with root package name */
        public int f64829f;

        /* renamed from: g  reason: collision with root package name */
        public int f64830g;

        /* renamed from: h  reason: collision with root package name */
        public Object f64831h;

        public Api(RequestMethod requestMethod) {
            Headers headers = new Headers();
            this.f64825b = headers;
            this.f64826c = Kalle.getConfig().getProxy();
            this.f64827d = Kalle.getConfig().getSSLSocketFactory();
            this.f64828e = Kalle.getConfig().getHostnameVerifier();
            this.f64829f = Kalle.getConfig().getConnectTimeout();
            this.f64830g = Kalle.getConfig().getReadTimeout();
            this.f64824a = requestMethod;
            headers.add(Kalle.getConfig().getHeaders());
        }

        public T addHeader(String str, String str2) {
            this.f64825b.add(str, str2);
            return this;
        }

        public T clearHeaders() {
            this.f64825b.clear();
            return this;
        }

        public abstract T clearParams();

        public T connectTimeout(int i4, TimeUnit timeUnit) {
            this.f64829f = (int) Math.min(timeUnit.toMillis(i4), 2147483647L);
            return this;
        }

        public T hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f64828e = hostnameVerifier;
            return this;
        }

        public abstract T param(String str, char c4);

        public abstract T param(String str, double d4);

        public abstract T param(String str, float f4);

        public abstract T param(String str, int i4);

        public abstract T param(String str, long j4);

        public abstract T param(String str, String str2);

        public abstract T param(String str, List<String> list);

        public abstract T param(String str, short s3);

        public abstract T param(String str, boolean z3);

        public abstract T path(char c4);

        public abstract T path(double d4);

        public abstract T path(float f4);

        public abstract T path(int i4);

        public abstract T path(long j4);

        public abstract T path(String str);

        public abstract T path(boolean z3);

        public T proxy(Proxy proxy) {
            this.f64826c = proxy;
            return this;
        }

        public T readTimeout(int i4, TimeUnit timeUnit) {
            this.f64830g = (int) Math.min(timeUnit.toMillis(i4), 2147483647L);
            return this;
        }

        public T removeHeader(String str) {
            this.f64825b.remove(str);
            return this;
        }

        public abstract T removeParam(String str);

        public T setHeader(String str, String str2) {
            this.f64825b.set(str, str2);
            return this;
        }

        public T setHeaders(Headers headers) {
            this.f64825b.set(headers);
            return this;
        }

        public T sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f64827d = sSLSocketFactory;
            return this;
        }

        public T tag(Object obj) {
            this.f64831h = obj;
            return this;
        }
    }

    public <T extends Api<T>> Request(Api<T> api) {
        this.f64816a = api.f64824a;
        this.f64817b = api.f64825b;
        this.f64818c = api.f64826c;
        this.f64819d = api.f64827d;
        this.f64820e = api.f64828e;
        this.f64821f = api.f64829f;
        this.f64822g = api.f64830g;
        this.f64823h = api.f64831h;
    }

    public abstract RequestBody body();

    public int connectTimeout() {
        return this.f64821f;
    }

    public abstract Params copyParams();

    public Headers headers() {
        return this.f64817b;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f64820e;
    }

    public RequestMethod method() {
        return this.f64816a;
    }

    public Proxy proxy() {
        return this.f64818c;
    }

    public int readTimeout() {
        return this.f64822g;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f64819d;
    }

    public Object tag() {
        return this.f64823h;
    }

    public abstract Url url();
}
