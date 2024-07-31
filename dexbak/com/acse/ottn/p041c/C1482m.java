package com.acse.ottn.p041c;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* renamed from: com.acse.ottn.c.m */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1482m implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return str != null && str.endsWith("boo.chat");
    }
}
