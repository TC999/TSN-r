package xyz.adscope.common.network.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SSLUtils {
    public static final HostnameVerifier HOSTNAME_VERIFIER = new HostnameVerifier() { // from class: xyz.adscope.common.network.ssl.SSLUtils.1
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    };
    public static final SSLSocketFactory SSL_SOCKET_FACTORY = new TLSSocketFactory();
}
