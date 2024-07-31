package com.acse.ottn.p041c;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: com.acse.ottn.c.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1478i implements HostnameVerifier {

    /* renamed from: a */
    final /* synthetic */ AbstractC1479j f2713a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1478i(AbstractC1479j abstractC1479j) {
        this.f2713a = abstractC1479j;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
