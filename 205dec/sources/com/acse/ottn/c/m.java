package com.acse.ottn.c;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class m implements HostnameVerifier {
    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        return str != null && str.endsWith("boo.chat");
    }
}
