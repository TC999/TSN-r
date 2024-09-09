package xyz.adscope.common.network;

import java.io.Closeable;
import xyz.adscope.common.network.util.IOUtils;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public final class Response implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final int f64835a;

    /* renamed from: b  reason: collision with root package name */
    public final Headers f64836b;

    /* renamed from: c  reason: collision with root package name */
    public final ResponseBody f64837c;

    /* renamed from: d  reason: collision with root package name */
    public final String f64838d;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f64839a;

        /* renamed from: b  reason: collision with root package name */
        public Headers f64840b;

        /* renamed from: c  reason: collision with root package name */
        public ResponseBody f64841c;

        /* renamed from: d  reason: collision with root package name */
        public String f64842d;

        public Builder body(ResponseBody responseBody) {
            this.f64841c = responseBody;
            return this;
        }

        public Response build() {
            return new Response(this);
        }

        public Builder code(int i4) {
            this.f64839a = i4;
            return this;
        }

        public Builder headers(Headers headers) {
            this.f64840b = headers;
            return this;
        }

        public Builder locationUrl(String str) {
            this.f64842d = str;
            return this;
        }
    }

    public Response(Builder builder) {
        this.f64835a = builder.f64839a;
        this.f64836b = builder.f64840b;
        this.f64837c = builder.f64841c;
        this.f64838d = builder.f64842d;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public ResponseBody body() {
        return this.f64837c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IOUtils.closeQuietly(this.f64837c);
    }

    public int code() {
        return this.f64835a;
    }

    public Headers headers() {
        return this.f64836b;
    }

    public boolean isRedirect() {
        int i4 = this.f64835a;
        if (i4 == 307 || i4 == 308) {
            return true;
        }
        switch (i4) {
            case 300:
            case 301:
            case 302:
            case 303:
                return true;
            default:
                return false;
        }
    }

    public String locationUrl() {
        return this.f64838d;
    }
}
