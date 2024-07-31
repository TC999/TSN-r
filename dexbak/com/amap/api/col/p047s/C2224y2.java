package com.amap.api.col.p047s;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.p047s.C2212y0;
import com.stub.StubApp;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: MySSLSocketFactory.java */
/* renamed from: com.amap.api.col.s.y2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2224y2 extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f6816a;

    /* renamed from: b */
    private Context f6817b;

    /* renamed from: c */
    private SSLContext f6818c;

    public C2224y2(Context context, SSLContext sSLContext) {
        SSLSocketFactory sSLSocketFactory;
        if (context != null) {
            try {
                this.f6817b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            } catch (Throwable th) {
                try {
                    C2060g2.m52972o(th, "myssl", "<init>");
                    try {
                        if (sSLSocketFactory == null) {
                            return;
                        }
                        return;
                    } catch (Throwable th2) {
                        return;
                    }
                } finally {
                    try {
                        if (this.f6818c == null) {
                            this.f6818c = SSLContext.getDefault();
                        }
                    } catch (Throwable th3) {
                        C2060g2.m52972o(th3, "myssl", "<init2>");
                    }
                    try {
                        if (this.f6816a == null) {
                            this.f6816a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                        }
                    } catch (Throwable th22) {
                        C2060g2.m52972o(th22, "myssl", "<init3>");
                    }
                }
            }
        }
        this.f6818c = sSLContext;
        if (sSLContext != null) {
            this.f6816a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f6818c == null) {
                this.f6818c = SSLContext.getDefault();
            }
        } catch (Throwable th4) {
            C2060g2.m52972o(th4, "myssl", "<init2>");
        }
        try {
            if (this.f6816a == null) {
                this.f6816a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th5) {
            C2060g2.m52972o(th5, "myssl", "<init3>");
        }
    }

    /* renamed from: a */
    private static Socket m52188a(Socket socket) {
        try {
            if (Build.VERSION.SDK_INT >= 21 && C2212y0.C2221g.f6807b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        } catch (Throwable th) {
            C2060g2.m52972o(th, "myssl", "stlv2");
        }
        return socket;
    }

    /* renamed from: c */
    private void m52186c(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f6818c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(C2079j1.m52857t("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String m52857t = C2079j1.m52857t("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(m52857t)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            C2060g2.m52972o(th, "myssl", "isc2");
        }
    }

    /* renamed from: d */
    private static void m52185d(Socket socket) {
        int i = Build.VERSION.SDK_INT;
        if (C2212y0.C2221g.f6808c && C2212y0.C2221g.f6810e && (socket instanceof SSLSocket)) {
            int i2 = C2212y0.C2221g.f6811f;
            int i3 = C2212y0.C2221g.f6809d;
            if (i2 <= i3) {
                i3 = C2212y0.C2221g.f6811f;
            }
            if (i3 <= 17 || i <= i3) {
                try {
                    socket.getClass().getMethod(C2079j1.m52857t("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    C2060g2.m52972o(th, "myssl", "sust");
                }
            }
        }
    }

    /* renamed from: b */
    public final void m52187b() {
        int i = Build.VERSION.SDK_INT;
        if (!C2212y0.C2221g.f6808c || this.f6817b == null || this.f6818c == null) {
            return;
        }
        int i2 = C2212y0.C2221g.f6809d;
        if (i2 <= 17 || i <= i2) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f6817b);
            if (i > 20 && i < 28) {
                try {
                    sSLSessionCache.getClass().getMethod(C2079j1.m52857t("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f6818c);
                    return;
                } catch (Throwable th) {
                    C2060g2.m52972o(th, "myssl", "isc1");
                    m52186c(sSLSessionCache);
                    return;
                }
            }
            m52186c(sSLSessionCache);
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        boolean z;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f6816a;
            if (sSLSocketFactory != null) {
                Socket m52188a = m52188a(sSLSocketFactory.createSocket());
                m52185d(m52188a);
                return m52188a;
            }
            return null;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f6816a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            C2060g2.m52972o(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f6816a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            C2060g2.m52972o(th, "myssl", "gscs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        boolean z2;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f6816a;
            if (sSLSocketFactory != null) {
                Socket m52188a = m52188a(sSLSocketFactory.createSocket(socket, str, i, z));
                m52185d(m52188a);
                return m52188a;
            }
            return null;
        } finally {
            if (!z2) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f6816a;
            if (sSLSocketFactory != null) {
                Socket m52188a = m52188a(sSLSocketFactory.createSocket(str, i));
                m52185d(m52188a);
                return m52188a;
            }
            return null;
        } catch (Throwable th) {
            C2060g2.m52972o(th, "myssl", "cs3");
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof IOException) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f6816a;
            if (sSLSocketFactory != null) {
                Socket m52188a = m52188a(sSLSocketFactory.createSocket(str, i, inetAddress, i2));
                m52185d(m52188a);
                return m52188a;
            }
            return null;
        } catch (Throwable th) {
            C2060g2.m52972o(th, "myssl", "cs4");
            if (!(th instanceof UnknownHostException)) {
                if (th instanceof IOException) {
                    throw th;
                }
                return null;
            }
            throw th;
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        boolean z;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f6816a;
            if (sSLSocketFactory != null) {
                Socket m52188a = m52188a(sSLSocketFactory.createSocket(inetAddress, i));
                m52185d(m52188a);
                return m52188a;
            }
            return null;
        } finally {
            if (!z) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        boolean z;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f6816a;
            if (sSLSocketFactory != null) {
                Socket m52188a = m52188a(sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
                m52185d(m52188a);
                return m52188a;
            }
            return null;
        } finally {
            if (!z) {
            }
        }
    }
}
