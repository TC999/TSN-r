package com.acse.ottn.c;

import com.acse.ottn.g3;
import com.acse.ottn.util.ra;
import okhttp3.logging.HttpLoggingInterceptor;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class g implements HttpLoggingInterceptor.Logger {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f5324a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(j jVar) {
        this.f5324a = jVar;
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
    public void log(String str) {
        ra.a(g3.f5672e, str);
    }
}
