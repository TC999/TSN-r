package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.Buffer;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.OkHttpClient;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Protocol;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.BasicCertificateChainCleaner;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.BasicTrustRootIndex;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.CertificateChainCleaner;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.TrustRootIndex;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Platform {

    /* renamed from: a */
    private static final Platform f1231a = m58494a();

    /* renamed from: b */
    private static final Logger f1232b = Logger.getLogger(OkHttpClient.class.getName());

    /* renamed from: b */
    public static Platform m58485b() {
        return f1231a;
    }

    /* renamed from: a */
    public void mo58490a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: a */
    public void mo58488a(SSLSocket sSLSocket) {
    }

    /* renamed from: a */
    public void mo58487a(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    /* renamed from: b */
    public String mo58482b(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: b */
    public boolean mo58484b(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static byte[] m58483b(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.mo58918d(protocol.toString());
            }
        }
        return buffer.m58951c();
    }

    /* renamed from: a */
    public void mo58493a(int i, String str, Throwable th) {
        f1232b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: a */
    public Object mo58492a(String str) {
        if (f1232b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: a */
    public void mo58491a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo58493a(5, str, (Throwable) obj);
    }

    /* renamed from: a */
    public static List<String> m58489a(List<Protocol> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                arrayList.add(protocol.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public TrustRootIndex mo58481b(X509TrustManager x509TrustManager) {
        return new BasicTrustRootIndex(x509TrustManager.getAcceptedIssuers());
    }

    /* renamed from: a */
    public CertificateChainCleaner mo58486a(X509TrustManager x509TrustManager) {
        return new BasicCertificateChainCleaner(mo58481b(x509TrustManager));
    }

    /* renamed from: a */
    private static Platform m58494a() {
        Platform m58512a = AndroidPlatform.m58512a();
        if (m58512a != null) {
            return m58512a;
        }
        Jdk9Platform m58503a = Jdk9Platform.m58503a();
        if (m58503a != null) {
            return m58503a;
        }
        Platform m58502a = JdkWithJettyBootPlatform.m58502a();
        return m58502a != null ? m58502a : new Platform();
    }
}
