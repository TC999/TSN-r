package xyz.adscope.common.network.simple;

import android.text.TextUtils;
import java.lang.reflect.Type;
import xyz.adscope.common.network.Canceller;
import xyz.adscope.common.network.RequestMethod;
import xyz.adscope.common.network.Url;
import xyz.adscope.common.network.UrlRequest;
import xyz.adscope.common.network.simple.cache.CacheMode;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SimpleUrlRequest extends UrlRequest implements SimpleRequest {

    /* renamed from: j  reason: collision with root package name */
    public final CacheMode f65009j;

    /* renamed from: k  reason: collision with root package name */
    public final String f65010k;

    /* renamed from: l  reason: collision with root package name */
    public final Converter f65011l;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static class Api extends UrlRequest.Api<Api> {

        /* renamed from: j  reason: collision with root package name */
        public CacheMode f65012j;

        /* renamed from: k  reason: collision with root package name */
        public String f65013k;

        /* renamed from: l  reason: collision with root package name */
        public Converter f65014l;

        public Api(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }

        public Api cacheKey(String str) {
            this.f65013k = str;
            return this;
        }

        public Api cacheMode(CacheMode cacheMode) {
            this.f65012j = cacheMode;
            return this;
        }

        public Api converter(Converter converter) {
            this.f65014l = converter;
            return this;
        }

        public <S, F> Canceller perform(Callback<S, F> callback) {
            return RequestManager.getInstance().perform(new SimpleUrlRequest(this), callback);
        }

        public <S, F> SimpleResponse<S, F> perform(Type type, Type type2) {
            return RequestManager.getInstance().perform(new SimpleUrlRequest(this), type, type2);
        }
    }

    public SimpleUrlRequest(Api api) {
        super(api);
        this.f65009j = api.f65012j == null ? CacheMode.HTTP : api.f65012j;
        this.f65010k = TextUtils.isEmpty(api.f65013k) ? url().toString() : api.f65013k;
        this.f65011l = api.f65014l;
    }

    public static Api newApi(Url url, RequestMethod requestMethod) {
        return new Api(url, requestMethod);
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public String cacheKey() {
        return this.f65010k;
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public CacheMode cacheMode() {
        return this.f65009j;
    }

    @Override // xyz.adscope.common.network.simple.SimpleRequest
    public Converter converter() {
        return this.f65011l;
    }
}
