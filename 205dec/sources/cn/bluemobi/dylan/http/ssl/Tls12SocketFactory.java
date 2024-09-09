package cn.bluemobi.dylan.http.ssl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Tls12SocketFactory extends SSLSocketFactory {
    private static final String[] TLS_SUPPORT_VERSION = {"TLSv1.1", "TLSv1.2"};
    final SSLSocketFactory delegate;

    public Tls12SocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.delegate = sSLSocketFactory;
    }

    private Socket patch(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(TLS_SUPPORT_VERSION);
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i4, boolean z3) throws IOException {
        return patch(this.delegate.createSocket(socket, str, i4, z3));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i4) throws IOException, UnknownHostException {
        return patch(this.delegate.createSocket(str, i4));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i4, InetAddress inetAddress, int i5) throws IOException, UnknownHostException {
        return patch(this.delegate.createSocket(str, i4, inetAddress, i5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i4) throws IOException {
        return patch(this.delegate.createSocket(inetAddress, i4));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i4, InetAddress inetAddress2, int i5) throws IOException {
        return patch(this.delegate.createSocket(inetAddress, i4, inetAddress2, i5));
    }
}
