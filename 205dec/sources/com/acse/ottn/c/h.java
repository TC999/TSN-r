package com.acse.ottn.c;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class h implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f5325a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(j jVar) {
        this.f5325a = jVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder newBuilder = chain.request().newBuilder();
        newBuilder.addHeader("Accept", "application/json,utf-8");
        newBuilder.addHeader("Content-Type", "application/json;utf-8");
        return chain.proceed(newBuilder.build());
    }
}
