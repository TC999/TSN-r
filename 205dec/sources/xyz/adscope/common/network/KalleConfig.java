package xyz.adscope.common.network;

import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import xyz.adscope.common.network.Params;
import xyz.adscope.common.network.connect.ConnectFactory;
import xyz.adscope.common.network.connect.Interceptor;
import xyz.adscope.common.network.connect.Network;
import xyz.adscope.common.network.cookie.CookieStore;
import xyz.adscope.common.network.simple.Converter;
import xyz.adscope.common.network.simple.cache.CacheStore;
import xyz.adscope.common.network.ssl.SSLUtils;
import xyz.adscope.common.network.urlconnect.URLConnectionFactory;
import xyz.adscope.common.network.util.MainExecutor;
import xyz.adscope.common.network.util.WorkExecutor;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public final class KalleConfig {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f64782a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f64783b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f64784c;

    /* renamed from: d  reason: collision with root package name */
    public final Headers f64785d;

    /* renamed from: e  reason: collision with root package name */
    public final Proxy f64786e;

    /* renamed from: f  reason: collision with root package name */
    public final SSLSocketFactory f64787f;

    /* renamed from: g  reason: collision with root package name */
    public final HostnameVerifier f64788g;

    /* renamed from: h  reason: collision with root package name */
    public final int f64789h;

    /* renamed from: i  reason: collision with root package name */
    public final int f64790i;

    /* renamed from: j  reason: collision with root package name */
    public final Params f64791j;

    /* renamed from: k  reason: collision with root package name */
    public final CacheStore f64792k;

    /* renamed from: l  reason: collision with root package name */
    public final Network f64793l;

    /* renamed from: m  reason: collision with root package name */
    public final ConnectFactory f64794m;

    /* renamed from: n  reason: collision with root package name */
    public final CookieStore f64795n;

    /* renamed from: o  reason: collision with root package name */
    public final List<Interceptor> f64796o;

    /* renamed from: p  reason: collision with root package name */
    public final Converter f64797p;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public Executor f64798a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f64799b;

        /* renamed from: c  reason: collision with root package name */
        public Charset f64800c;

        /* renamed from: d  reason: collision with root package name */
        public Headers f64801d;

        /* renamed from: e  reason: collision with root package name */
        public Proxy f64802e;

        /* renamed from: f  reason: collision with root package name */
        public SSLSocketFactory f64803f;

        /* renamed from: g  reason: collision with root package name */
        public HostnameVerifier f64804g;

        /* renamed from: h  reason: collision with root package name */
        public int f64805h;

        /* renamed from: i  reason: collision with root package name */
        public int f64806i;

        /* renamed from: j  reason: collision with root package name */
        public Params.Builder f64807j;

        /* renamed from: k  reason: collision with root package name */
        public CacheStore f64808k;

        /* renamed from: l  reason: collision with root package name */
        public Network f64809l;

        /* renamed from: m  reason: collision with root package name */
        public ConnectFactory f64810m;

        /* renamed from: n  reason: collision with root package name */
        public CookieStore f64811n;

        /* renamed from: o  reason: collision with root package name */
        public List<Interceptor> f64812o;

        /* renamed from: p  reason: collision with root package name */
        public Converter f64813p;

        public Builder() {
            this.f64801d = new Headers();
            this.f64807j = Params.newBuilder();
            this.f64812o = new ArrayList();
            this.f64801d.set("Accept", Headers.VALUE_ACCEPT_ALL);
            this.f64801d.set("Accept-Encoding", Headers.VALUE_ACCEPT_ENCODING);
            this.f64801d.set("Content-Type", "application/x-www-form-urlencoded");
            this.f64801d.set("Connection", "keep-alive");
            this.f64801d.set("User-Agent", Headers.VALUE_USER_AGENT);
            this.f64801d.set("Accept-Language", Headers.VALUE_ACCEPT_LANGUAGE);
        }

        public Builder addHeader(String str, String str2) {
            this.f64801d.add(str, str2);
            return this;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            this.f64812o.add(interceptor);
            return this;
        }

        public Builder addInterceptors(List<Interceptor> list) {
            this.f64812o.addAll(list);
            return this;
        }

        public Builder addParam(String str, String str2) {
            this.f64807j.add(str, str2);
            return this;
        }

        public KalleConfig build() {
            return new KalleConfig(this);
        }

        public Builder cacheStore(CacheStore cacheStore) {
            this.f64808k = cacheStore;
            return this;
        }

        public Builder charset(Charset charset) {
            this.f64800c = charset;
            return this;
        }

        public Builder connectFactory(ConnectFactory connectFactory) {
            this.f64810m = connectFactory;
            return this;
        }

        public Builder connectionTimeout(int i4, TimeUnit timeUnit) {
            this.f64805h = (int) Math.min(timeUnit.toMillis(i4), 2147483647L);
            return this;
        }

        public Builder converter(Converter converter) {
            this.f64813p = converter;
            return this;
        }

        public Builder cookieStore(CookieStore cookieStore) {
            this.f64811n = cookieStore;
            return this;
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f64804g = hostnameVerifier;
            return this;
        }

        public Builder mainThreadExecutor(Executor executor) {
            this.f64799b = executor;
            return this;
        }

        public Builder network(Network network) {
            this.f64809l = network;
            return this;
        }

        public Builder proxy(Proxy proxy) {
            this.f64802e = proxy;
            return this;
        }

        public Builder readTimeout(int i4, TimeUnit timeUnit) {
            this.f64806i = (int) Math.min(timeUnit.toMillis(i4), 2147483647L);
            return this;
        }

        public Builder setHeader(String str, String str2) {
            this.f64801d.set(str, str2);
            return this;
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f64803f = sSLSocketFactory;
            return this;
        }

        public Builder workThreadExecutor(Executor executor) {
            this.f64798a = executor;
            return this;
        }
    }

    public KalleConfig(Builder builder) {
        this.f64782a = builder.f64798a == null ? new WorkExecutor() : builder.f64798a;
        this.f64783b = builder.f64799b == null ? new MainExecutor() : builder.f64799b;
        this.f64784c = builder.f64800c == null ? Charset.defaultCharset() : builder.f64800c;
        this.f64785d = builder.f64801d;
        this.f64786e = builder.f64802e;
        this.f64787f = builder.f64803f == null ? SSLUtils.SSL_SOCKET_FACTORY : builder.f64803f;
        this.f64788g = builder.f64804g == null ? SSLUtils.HOSTNAME_VERIFIER : builder.f64804g;
        this.f64789h = builder.f64805h <= 0 ? 10000 : builder.f64805h;
        this.f64790i = builder.f64806i > 0 ? builder.f64806i : 10000;
        this.f64791j = builder.f64807j.build();
        this.f64792k = builder.f64808k == null ? CacheStore.DEFAULT : builder.f64808k;
        this.f64793l = builder.f64809l == null ? Network.DEFAULT : builder.f64809l;
        this.f64794m = builder.f64810m == null ? URLConnectionFactory.newBuilder().build() : builder.f64810m;
        this.f64795n = builder.f64811n == null ? CookieStore.DEFAULT : builder.f64811n;
        this.f64796o = Collections.unmodifiableList(builder.f64812o);
        this.f64797p = builder.f64813p == null ? Converter.DEFAULT : builder.f64813p;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public CacheStore getCacheStore() {
        return this.f64792k;
    }

    public Charset getCharset() {
        return this.f64784c;
    }

    public ConnectFactory getConnectFactory() {
        return this.f64794m;
    }

    public int getConnectTimeout() {
        return this.f64789h;
    }

    public Converter getConverter() {
        return this.f64797p;
    }

    public CookieStore getCookieStore() {
        return this.f64795n;
    }

    public Headers getHeaders() {
        return this.f64785d;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f64788g;
    }

    public List<Interceptor> getInterceptor() {
        return this.f64796o;
    }

    public Executor getMainExecutor() {
        return this.f64783b;
    }

    public Network getNetwork() {
        return this.f64793l;
    }

    public Params getParams() {
        return this.f64791j;
    }

    public Proxy getProxy() {
        return this.f64786e;
    }

    public int getReadTimeout() {
        return this.f64790i;
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.f64787f;
    }

    public Executor getWorkExecutor() {
        return this.f64782a;
    }
}
