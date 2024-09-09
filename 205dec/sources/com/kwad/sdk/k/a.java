package com.kwad.sdk.k;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        try {
            return chain.proceed(chain.request());
        } catch (Exception e4) {
            if (e4 instanceof IOException) {
                throw e4;
            }
            throw new IOException(e4);
        }
    }
}
