package xyz.adscope.common.network.simple;

import android.text.TextUtils;
import java.lang.reflect.Type;
import xyz.adscope.common.network.BodyRequest;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.simple.cache.CacheMode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SimpleBodyRequest extends BodyRequest implements SimpleRequest {

    /* renamed from: l  reason: collision with root package name */
    public final CacheMode f64993l;

    /* renamed from: m  reason: collision with root package name */
    public final String f64994m;

    /* renamed from: n  reason: collision with root package name */
    public final Converter f64995n;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Api extends BodyRequest.Api<Api> {

        /* renamed from: l  reason: collision with root package name */
        public CacheMode f64996l;

        /* renamed from: m  reason: collision with root package name */
        public String f64997m;

        /* renamed from: n  reason: collision with root package name */
        public Converter f64998n;

        public Api(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public Api cacheKey(String str) {
            this.f64997m = str;
            return this;
        }

        public Api cacheMode(CacheMode cacheMode) {
            this.f64996l = cacheMode;
            return this;
        }

        public Api converter(Converter converter) {
            this.f64998n = converter;
            return this;
        }

        public <S, F> Canceller perform(Callback<S, F> callback) {
            return RequestManager.getInstance().perform(new SimpleBodyRequest(this), callback);
        }

        public <S, F> SimpleResponse<S, F> perform(Type type, Type type2) {
            return RequestManager.getInstance().perform(new SimpleBodyRequest(this), type, type2);
        }
    }

    public SimpleBodyRequest(Api api) {
        super(api);
        this.f64993l = api.f64996l == null ? CacheMode.HTTP : api.f64996l;
        this.f64994m = TextUtils.isEmpty(api.f64997m) ? url().toString() : api.f64997m;
        this.f64995n = api.f64998n;
    }

    public static Api newApi(Url url, RequestMethod requestMethod) {
        return new Api(url, requestMethod);
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public String cacheKey() {
        return this.f64994m;
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public CacheMode cacheMode() {
        return this.f64993l;
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public Converter converter() {
        return this.f64995n;
    }
}
