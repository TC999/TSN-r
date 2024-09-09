package com.bytedance.sdk.component.xv.w.c.r;

import com.bytedance.sdk.component.xv.w.c.gd.f;
import com.bytedance.sdk.component.xv.w.j;
import com.bytedance.sdk.component.xv.w.ls;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* renamed from: c  reason: collision with root package name */
    private static final ux f30795c = c();

    /* renamed from: w  reason: collision with root package name */
    private static final Logger f30796w = Logger.getLogger(j.class.getName());

    public static ux w() {
        return f30795c;
    }

    public String c(SSLSocket sSLSocket) {
        return null;
    }

    public void c(Socket socket, InetSocketAddress inetSocketAddress, int i4) throws IOException {
        socket.connect(inetSocketAddress, i4);
    }

    public void c(SSLSocket sSLSocket, String str, List<ls> list) {
    }

    public void w(SSLSocket sSLSocket) {
    }

    public boolean w(String str) {
        return true;
    }

    public String xv() {
        return "OkHttp";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] w(List<ls> list) {
        com.bytedance.sdk.component.xv.c.xv xvVar = new com.bytedance.sdk.component.xv.c.xv();
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            ls lsVar = list.get(i4);
            if (lsVar != ls.HTTP_1_0) {
                xvVar.gd(lsVar.toString().length());
                xvVar.w(lsVar.toString());
            }
        }
        try {
            return xvVar.ia();
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void c(int i4, String str, Throwable th) {
        f30796w.log(i4 == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public Object c(String str) {
        if (f30796w.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public void c(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        c(5, str, (Throwable) obj);
    }

    public static List<String> c(List<ls> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            ls lsVar = list.get(i4);
            if (lsVar != ls.HTTP_1_0) {
                arrayList.add(lsVar.toString());
            }
        }
        return arrayList;
    }

    public f w(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.xv.w.c.gd.w(x509TrustManager.getAcceptedIssuers());
    }

    public com.bytedance.sdk.component.xv.w.c.gd.xv c(X509TrustManager x509TrustManager) {
        return new com.bytedance.sdk.component.xv.w.c.gd.c(w(x509TrustManager));
    }

    private static ux c() {
        ux c4 = c.c();
        if (c4 != null) {
            return c4;
        }
        w c5 = w.c();
        if (c5 != null) {
            return c5;
        }
        ux c6 = xv.c();
        return c6 != null ? c6 : new ux();
    }
}
