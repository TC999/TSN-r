package com.amap.api.col.s;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.s.y0;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: MySSLSocketFactory.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class y2 extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f10539a;

    /* renamed from: b  reason: collision with root package name */
    private Context f10540b;

    /* renamed from: c  reason: collision with root package name */
    private SSLContext f10541c;

    public y2(Context context, SSLContext sSLContext) {
        SSLSocketFactory sSLSocketFactory;
        if (context != null) {
            try {
                this.f10540b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            } catch (Throwable th) {
                try {
                    g2.o(th, "myssl", "<init>");
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
                        if (this.f10541c == null) {
                            this.f10541c = SSLContext.getDefault();
                        }
                    } catch (Throwable th3) {
                        g2.o(th3, "myssl", "<init2>");
                    }
                    try {
                        if (this.f10539a == null) {
                            this.f10539a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                        }
                    } catch (Throwable th22) {
                        g2.o(th22, "myssl", "<init3>");
                    }
                }
            }
        }
        this.f10541c = sSLContext;
        if (sSLContext != null) {
            this.f10539a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f10541c == null) {
                this.f10541c = SSLContext.getDefault();
            }
        } catch (Throwable th4) {
            g2.o(th4, "myssl", "<init2>");
        }
        try {
            if (this.f10539a == null) {
                this.f10539a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th5) {
            g2.o(th5, "myssl", "<init3>");
        }
    }

    private static Socket a(Socket socket) {
        try {
            if (Build.VERSION.SDK_INT >= 21 && y0.g.f10530b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        } catch (Throwable th) {
            g2.o(th, "myssl", "stlv2");
        }
        return socket;
    }

    private void c(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f10541c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(j1.t("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String t3 = j1.t("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(t3)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            g2.o(th, "myssl", "isc2");
        }
    }

    private static void d(Socket socket) {
        int i4 = Build.VERSION.SDK_INT;
        if (y0.g.f10531c && y0.g.f10533e && (socket instanceof SSLSocket)) {
            int i5 = y0.g.f10534f;
            int i6 = y0.g.f10532d;
            if (i5 <= i6) {
                i6 = y0.g.f10534f;
            }
            if (i6 <= 17 || i4 <= i6) {
                try {
                    socket.getClass().getMethod(j1.t("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    g2.o(th, "myssl", "sust");
                }
            }
        }
    }

    public final void b() {
        int i4 = Build.VERSION.SDK_INT;
        if (!y0.g.f10531c || this.f10540b == null || this.f10541c == null) {
            return;
        }
        int i5 = y0.g.f10532d;
        if (i5 <= 17 || i4 <= i5) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f10540b);
            if (i4 > 20 && i4 < 28) {
                try {
                    sSLSessionCache.getClass().getMethod(j1.t("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f10541c);
                    return;
                } catch (Throwable th) {
                    g2.o(th, "myssl", "isc1");
                    c(sSLSessionCache);
                    return;
                }
            }
            c(sSLSessionCache);
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        boolean z3;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f10539a;
            if (sSLSocketFactory != null) {
                Socket a4 = a(sSLSocketFactory.createSocket());
                d(a4);
                return a4;
            }
            return null;
        } finally {
            if (!z3) {
            }
        }
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f10539a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            g2.o(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f10539a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            g2.o(th, "myssl", "gscs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i4, boolean z3) throws IOException {
        boolean z4;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f10539a;
            if (sSLSocketFactory != null) {
                Socket a4 = a(sSLSocketFactory.createSocket(socket, str, i4, z3));
                d(a4);
                return a4;
            }
            return null;
        } finally {
            if (!z4) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i4) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f10539a;
            if (sSLSocketFactory != null) {
                Socket a4 = a(sSLSocketFactory.createSocket(str, i4));
                d(a4);
                return a4;
            }
            return null;
        } catch (Throwable th) {
            g2.o(th, "myssl", "cs3");
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
    public final Socket createSocket(String str, int i4, InetAddress inetAddress, int i5) throws IOException, UnknownHostException {
        try {
            SSLSocketFactory sSLSocketFactory = this.f10539a;
            if (sSLSocketFactory != null) {
                Socket a4 = a(sSLSocketFactory.createSocket(str, i4, inetAddress, i5));
                d(a4);
                return a4;
            }
            return null;
        } catch (Throwable th) {
            g2.o(th, "myssl", "cs4");
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
    public final Socket createSocket(InetAddress inetAddress, int i4) throws IOException {
        boolean z3;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f10539a;
            if (sSLSocketFactory != null) {
                Socket a4 = a(sSLSocketFactory.createSocket(inetAddress, i4));
                d(a4);
                return a4;
            }
            return null;
        } finally {
            if (!z3) {
            }
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i4, InetAddress inetAddress2, int i5) throws IOException {
        boolean z3;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f10539a;
            if (sSLSocketFactory != null) {
                Socket a4 = a(sSLSocketFactory.createSocket(inetAddress, i4, inetAddress2, i5));
                d(a4);
                return a4;
            }
            return null;
        } finally {
            if (!z3) {
            }
        }
    }
}
