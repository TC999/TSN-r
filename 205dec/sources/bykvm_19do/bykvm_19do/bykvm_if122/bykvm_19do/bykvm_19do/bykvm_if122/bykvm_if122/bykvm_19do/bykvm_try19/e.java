package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.f;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* compiled from: Platform.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final e f1224a = a();

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f1225b = Logger.getLogger(v.class.getName());

    public static e b() {
        return f1224a;
    }

    public void a(Socket socket, InetSocketAddress inetSocketAddress, int i4) throws IOException {
        socket.connect(inetSocketAddress, i4);
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void a(SSLSocket sSLSocket, String str, List<w> list) {
    }

    public String b(SSLSocket sSLSocket) {
        return null;
    }

    public boolean b(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] b(List<w> list) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            w wVar = list.get(i4);
            if (wVar != w.HTTP_1_0) {
                cVar.writeByte(wVar.toString().length());
                cVar.d(wVar.toString());
            }
        }
        return cVar.c();
    }

    public void a(int i4, String str, Throwable th) {
        f1225b.log(i4 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object a(String str) {
        if (f1225b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        a(5, str, (Throwable) obj);
    }

    public static List<String> a(List<w> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            w wVar = list.get(i4);
            if (wVar != w.HTTP_1_0) {
                arrayList.add(wVar.toString());
            }
        }
        return arrayList;
    }

    public f b(X509TrustManager x509TrustManager) {
        return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.b(x509TrustManager.getAcceptedIssuers());
    }

    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c a(X509TrustManager x509TrustManager) {
        return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.a(b(x509TrustManager));
    }

    private static e a() {
        e a4 = a.a();
        if (a4 != null) {
            return a4;
        }
        b a5 = b.a();
        if (a5 != null) {
            return a5;
        }
        e a6 = c.a();
        return a6 != null ? a6 : new e();
    }
}
