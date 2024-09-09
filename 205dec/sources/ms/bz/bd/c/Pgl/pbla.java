package ms.bz.bd.c.Pgl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
class pbla extends SSLSocketFactory {

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f61429b = {(String) pblk.a(16777217, 0, 0, "6c770f", new byte[]{19, 77, 119, 85, 94, 63, 103})};

    /* renamed from: a  reason: collision with root package name */
    final SSLSocketFactory f61430a;

    public pbla(SSLSocketFactory sSLSocketFactory) {
        this.f61430a = sSLSocketFactory;
    }

    private Socket a(Socket socket) {
        if (socket instanceof SSLSocket) {
            ((SSLSocket) socket).setEnabledProtocols(f61429b);
        }
        return socket;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i4) throws IOException, UnknownHostException {
        return a(this.f61430a.createSocket(str, i4));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i4, InetAddress inetAddress, int i5) throws IOException, UnknownHostException {
        return a(this.f61430a.createSocket(str, i4, inetAddress, i5));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i4) throws IOException {
        return a(this.f61430a.createSocket(inetAddress, i4));
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i4, InetAddress inetAddress2, int i5) throws IOException {
        return a(this.f61430a.createSocket(inetAddress, i4, inetAddress2, i5));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i4, boolean z3) throws IOException {
        return a(this.f61430a.createSocket(socket, str, i4, z3));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.f61430a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.f61430a.getSupportedCipherSuites();
    }
}
