package com.kwad.sdk.p440k;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* renamed from: com.kwad.sdk.k.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10838a implements Interceptor {
    @Override // okhttp3.Interceptor
    public final Response intercept(Interceptor.Chain chain) {
        try {
            return chain.proceed(chain.request());
        } catch (Exception e) {
            if (e instanceof IOException) {
                throw e;
            }
            throw new IOException(e);
        }
    }
}
