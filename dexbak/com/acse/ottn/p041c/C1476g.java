package com.acse.ottn.p041c;

import com.acse.ottn.util.C1694ra;
import okhttp3.logging.HttpLoggingInterceptor;

/* renamed from: com.acse.ottn.c.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1476g implements HttpLoggingInterceptor.Logger {

    /* renamed from: a */
    final /* synthetic */ AbstractC1479j f2711a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1476g(AbstractC1479j abstractC1479j) {
        this.f2711a = abstractC1479j;
    }

    @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
    public void log(String str) {
        C1694ra.m55917a("RetrofitServiceManager", str);
    }
}
