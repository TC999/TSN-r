package xyz.adscope.common.network.ssl;

import android.os.Build;
import java.net.InetAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class TLSSocketFactory extends SSLSocketFactory {

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f65028b;

    /* renamed from: c  reason: collision with root package name */
    public static final X509TrustManager f65029c;

    /* renamed from: a  reason: collision with root package name */
    public SSLSocketFactory f65030a;

    static {
        if (Build.VERSION.SDK_INT >= 26) {
            f65028b = new String[]{"TLSv1", "TLSv1.1", "TLSv1.2"};
        } else {
            f65028b = new String[]{"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"};
        }
        f65029c = new X509TrustManager() { // from class: xyz.adscope.common.network.ssl.TLSSocketFactory.1
            @Override // javax.net.ssl.X509TrustManager
            public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
            }

            @Override // javax.net.ssl.X509TrustManager
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[0];
            }
        };
    }

    public TLSSocketFactory() {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{f65029c}, new SecureRandom());
            this.f65030a = sSLContext.getSocketFactory();
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    public TLSSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.f65030a = sSLSocketFactory;
    }

    public static void a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f65028b);
        }
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket() {
        Socket createSocket = this.f65030a.createSocket();
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i4) {
        Socket createSocket = this.f65030a.createSocket(str, i4);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i4, InetAddress inetAddress, int i5) {
        Socket createSocket = this.f65030a.createSocket(str, i4, inetAddress, i5);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i4) {
        Socket createSocket = this.f65030a.createSocket(inetAddress, i4);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i4, InetAddress inetAddress2, int i5) {
        Socket createSocket = this.f65030a.createSocket(inetAddress, i4, inetAddress2, i5);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i4, boolean z3) {
        Socket createSocket = this.f65030a.createSocket(socket, str, i4, z3);
        a(createSocket);
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f65030a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f65030a.getSupportedCipherSuites();
    }
}
