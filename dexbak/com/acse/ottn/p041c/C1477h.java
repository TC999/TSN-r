package com.acse.ottn.p041c;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: com.acse.ottn.c.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1477h implements Interceptor {

    /* renamed from: a */
    final /* synthetic */ AbstractC1479j f2712a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1477h(AbstractC1479j abstractC1479j) {
        this.f2712a = abstractC1479j;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request.Builder newBuilder = chain.request().newBuilder();
        newBuilder.addHeader("Accept", "application/json,utf-8");
        newBuilder.addHeader("Content-Type", "application/json;utf-8");
        return chain.proceed(newBuilder.build());
    }
}
