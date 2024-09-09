package xyz.adscope.common.network;

import java.io.File;
import java.util.List;
import java.util.Map;
import xyz.adscope.common.network.Params;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.Url;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class BodyRequest extends Request {

    /* renamed from: i  reason: collision with root package name */
    public final Url f64764i;

    /* renamed from: j  reason: collision with root package name */
    public final RequestBody f64765j;

    /* renamed from: k  reason: collision with root package name */
    public final Params f64766k;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Api<T extends Api<T>> extends Request.Api<T> {

        /* renamed from: i  reason: collision with root package name */
        public Url.Builder f64767i;

        /* renamed from: j  reason: collision with root package name */
        public Params.Builder f64768j;

        /* renamed from: k  reason: collision with root package name */
        public RequestBody f64769k;

        public Api(Url url, RequestMethod requestMethod) {
            super(requestMethod);
            this.f64767i = url.builder();
            Params.Builder newBuilder = Params.newBuilder();
            this.f64768j = newBuilder;
            newBuilder.add(Kalle.getConfig().getParams());
        }

        public T binaries(String str, List<Binary> list) {
            this.f64768j.binaries(str, list);
            return this;
        }

        public T binary(String str, Binary binary) {
            this.f64768j.binary(str, binary);
            return this;
        }

        public T body(RequestBody requestBody) {
            this.f64769k = requestBody;
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T clearParams() {
            this.f64768j.clear();
            return this;
        }

        public T file(String str, File file) {
            this.f64768j.file(str, file);
            return this;
        }

        public T files(String str, List<File> list) {
            this.f64768j.files(str, list);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, char c4) {
            this.f64768j.add(str, c4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, double d4) {
            this.f64768j.add(str, d4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, float f4) {
            this.f64768j.add(str, f4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, int i4) {
            return param(str, Integer.toString(i4));
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, long j4) {
            this.f64768j.add(str, j4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, String str2) {
            this.f64768j.add(str, str2);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, List<String> list) {
            this.f64768j.add(str, list);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, short s3) {
            this.f64768j.add(str, s3);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T param(String str, boolean z3) {
            this.f64768j.add(str, z3);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public /* bridge */ /* synthetic */ Request.Api param(String str, List list) {
            return param(str, (List<String>) list);
        }

        public T params(Map<String, String> map) {
            this.f64768j.add(map);
            return this;
        }

        public T params(Params params) {
            this.f64768j.add(params);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(char c4) {
            this.f64767i.addPath(c4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(double d4) {
            this.f64767i.addPath(d4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(float f4) {
            this.f64767i.addPath(f4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(int i4) {
            this.f64767i.addPath(i4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(long j4) {
            this.f64767i.addPath(j4);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(String str) {
            this.f64767i.addPath(str);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T path(boolean z3) {
            this.f64767i.addPath(z3);
            return this;
        }

        @Override // xyz.adscope.common.network.Request.Api
        public T removeParam(String str) {
            this.f64768j.remove(str);
            return this;
        }

        public T setParams(Params params) {
            this.f64768j.set(params);
            return this;
        }

        public T setUrlParam(Params params) {
            this.f64767i.setQuery(params);
            return this;
        }

        public T urlParam(String str, char c4) {
            this.f64767i.addQuery(str, c4);
            return this;
        }

        public T urlParam(String str, double d4) {
            this.f64767i.addQuery(str, d4);
            return this;
        }

        public T urlParam(String str, float f4) {
            this.f64767i.addQuery(str, f4);
            return this;
        }

        public T urlParam(String str, int i4) {
            this.f64767i.addQuery(str, i4);
            return this;
        }

        public T urlParam(String str, long j4) {
            this.f64767i.addQuery(str, j4);
            return this;
        }

        public T urlParam(String str, String str2) {
            this.f64767i.addQuery(str, str2);
            return this;
        }

        public T urlParam(String str, List<String> list) {
            this.f64767i.addQuery(str, list);
            return this;
        }

        public T urlParam(String str, short s3) {
            this.f64767i.addQuery(str, s3);
            return this;
        }

        public T urlParam(String str, boolean z3) {
            this.f64767i.addQuery(str, z3);
            return this;
        }

        public T urlParam(Params params) {
            this.f64767i.addQuery(params);
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Builder extends Api<Builder> {
        public Builder(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public BodyRequest build() {
            return new BodyRequest(this);
        }
    }

    public BodyRequest(Api api) {
        super(api);
        this.f64764i = api.f64767i.build();
        Params build = api.f64768j.build();
        this.f64766k = build;
        this.f64765j = api.f64769k == null ? build.hasBinary() ? build.toFormBody() : build.toUrlBody() : api.f64769k;
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
        return this.f64765j;
    }

    @Override // xyz.adscope.common.network.Request
    public Params copyParams() {
        return this.f64766k;
    }

    @Override // xyz.adscope.common.network.Request
    public Url url() {
        return this.f64764i;
    }
}
