package xyz.adscope.common.network;

import java.util.List;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.Url;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UrlRequest extends Request {

    /* renamed from: i  reason: collision with root package name */
    public final Url f64864i;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Api<T extends Api<T>> extends Request.Api<T> {

        /* renamed from: i  reason: collision with root package name */
        public Url.Builder f64865i;

        public Api(Url url, RequestMethod requestMethod) {
            super(requestMethod);
            Url.Builder builder = url.builder();
            this.f64865i = builder;
            builder.addQuery(Kalle.getConfig().getParams());
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T clearParams() {
            this.f64865i.clearQuery();
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public /* bridge */ /* synthetic */ Request.Api param(String str, List list) {
            return param(str, (List<String>) list);
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, char c4) {
            this.f64865i.addQuery(str, c4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, double d4) {
            this.f64865i.addQuery(str, d4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, float f4) {
            this.f64865i.addQuery(str, f4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, int i4) {
            this.f64865i.addQuery(str, i4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, long j4) {
            this.f64865i.addQuery(str, j4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, String str2) {
            this.f64865i.addQuery(str, str2);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, List<String> list) {
            this.f64865i.addQuery(str, list);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, short s3) {
            this.f64865i.addQuery(str, s3);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, boolean z3) {
            this.f64865i.addQuery(str, z3);
            return this;
        }

        public T params(Params params) {
            this.f64865i.addQuery(params);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(char c4) {
            this.f64865i.addPath(c4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(double d4) {
            this.f64865i.addPath(d4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(float f4) {
            this.f64865i.addPath(f4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(int i4) {
            this.f64865i.addPath(i4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(long j4) {
            this.f64865i.addPath(j4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(String str) {
            this.f64865i.addPath(str);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(boolean z3) {
            this.f64865i.addPath(z3);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T removeParam(String str) {
            this.f64865i.removeQuery(str);
            return this;
        }

        public T setParams(Params params) {
            this.f64865i.setQuery(params);
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder extends Api<Builder> {
        public Builder(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public UrlRequest build() {
            return new UrlRequest(this);
        }
    }

    public UrlRequest(Api api) {
        super(api);
        this.f64864i = api.f64865i.build();
    }

    public static Builder newBuilder(String str, RequestMethod requestMethod) {
        return newBuilder(Url.newBuilder(str).build(), requestMethod);
    }

    @Deprecated
    public static Builder newBuilder(Url.Builder builder, RequestMethod requestMethod) {
        return newBuilder(builder.build(), requestMethod);
    }

    public static Builder newBuilder(Url url, RequestMethod requestMethod) {
        return new Builder(url, requestMethod);
    }

    @Override // xyz.adscope.common.network.Request
    public RequestBody body() {
        throw new AssertionError("It should not be called.");
    }

    @Override // xyz.adscope.common.network.Request
    public Params copyParams() {
        return this.f64864i.getParams();
    }

    @Override // xyz.adscope.common.network.Request
    public Url url() {
        return this.f64864i;
    }
}
