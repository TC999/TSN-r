package com.acse.ottn.c;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class i implements HostnameVerifier {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f5326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(j jVar) {
        this.f5326a = jVar;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return true;
    }
}
