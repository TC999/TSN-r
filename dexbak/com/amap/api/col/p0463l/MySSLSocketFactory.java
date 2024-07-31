package com.amap.api.col.p0463l;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import com.amap.api.col.p0463l.AuthConfigManager;
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

/* renamed from: com.amap.api.col.3l.v6 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class MySSLSocketFactory extends SSLSocketFactory {

    /* renamed from: a */
    private SSLSocketFactory f5565a;

    /* renamed from: b */
    private Context f5566b;

    /* renamed from: c */
    private SSLContext f5567c;

    public MySSLSocketFactory(Context context, SSLContext sSLContext) {
        SSLSocketFactory sSLSocketFactory;
        if (context != null) {
            try {
                this.f5566b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            } catch (Throwable th) {
                try {
                    SDKLogHandler.m53863p(th, "myssl", "<init>");
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
                        if (this.f5567c == null) {
                            this.f5567c = SSLContext.getDefault();
                        }
                    } catch (Throwable th3) {
                        SDKLogHandler.m53863p(th3, "myssl", "<init2>");
                    }
                    try {
                        if (this.f5565a == null) {
                            this.f5565a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                        }
                    } catch (Throwable th22) {
                        SDKLogHandler.m53863p(th22, "myssl", "<init3>");
                    }
                }
            }
        }
        this.f5567c = sSLContext;
        if (sSLContext != null) {
            this.f5565a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f5567c == null) {
                this.f5567c = SSLContext.getDefault();
            }
        } catch (Throwable th4) {
            SDKLogHandler.m53863p(th4, "myssl", "<init2>");
        }
        try {
            if (this.f5565a == null) {
                this.f5565a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th5) {
            SDKLogHandler.m53863p(th5, "myssl", "<init3>");
        }
    }

    /* renamed from: a */
    private static Socket m53650a(Socket socket) {
        try {
            if (Build.VERSION.SDK_INT >= 21 && AuthConfigManager.C1807g.f4152b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "myssl", "stlv2");
        }
        return socket;
    }

    /* renamed from: c */
    private void m53648c(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f5567c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(C1925p4.m54183u("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String m54183u = C1925p4.m54183u("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(m54183u)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "myssl", "isc2");
        }
    }

    /* renamed from: d */
    private static void m53647d(Socket socket) {
        int i = Build.VERSION.SDK_INT;
        if (AuthConfigManager.C1807g.f4153c && AuthConfigManager.C1807g.f4155e && (socket instanceof SSLSocket)) {
            int i2 = AuthConfigManager.C1807g.f4156f;
            int i3 = AuthConfigManager.C1807g.f4154d;
            if (i2 <= i3) {
                i3 = AuthConfigManager.C1807g.f4156f;
            }
            if (i3 <= 17 || i <= i3) {
                try {
                    socket.getClass().getMethod(C1925p4.m54183u("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "myssl", "sust");
                }
            }
        }
    }

    /* renamed from: b */
    public final void m53649b() {
        int i = Build.VERSION.SDK_INT;
        if (!AuthConfigManager.C1807g.f4153c || this.f5566b == null || this.f5567c == null) {
            return;
        }
        int i2 = AuthConfigManager.C1807g.f4154d;
        if (i2 <= 17 || i <= i2) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f5566b);
            if (i > 20 && i < 28) {
                try {
                    sSLSessionCache.getClass().getMethod(C1925p4.m54183u("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f5567c);
                    return;
                } catch (Throwable th) {
                    SDKLogHandler.m53863p(th, "myssl", "isc1");
                    m53648c(sSLSessionCache);
                    return;
                }
            }
            m53648c(sSLSessionCache);
        }
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        boolean z;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f5565a;
            if (sSLSocketFactory != null) {
                Socket m53650a = m53650a(sSLSocketFactory.createSocket());
                m53647d(m53650a);
                return m53650a;
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
            SSLSocketFactory sSLSocketFactory = this.f5565a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f5565a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "myssl", "gscs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        boolean z2;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f5565a;
            if (sSLSocketFactory != null) {
                Socket m53650a = m53650a(sSLSocketFactory.createSocket(socket, str, i, z));
                m53647d(m53650a);
                return m53650a;
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
            SSLSocketFactory sSLSocketFactory = this.f5565a;
            if (sSLSocketFactory != null) {
                Socket m53650a = m53650a(sSLSocketFactory.createSocket(str, i));
                m53647d(m53650a);
                return m53650a;
            }
            return null;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "myssl", "cs3");
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
            SSLSocketFactory sSLSocketFactory = this.f5565a;
            if (sSLSocketFactory != null) {
                Socket m53650a = m53650a(sSLSocketFactory.createSocket(str, i, inetAddress, i2));
                m53647d(m53650a);
                return m53650a;
            }
            return null;
        } catch (Throwable th) {
            SDKLogHandler.m53863p(th, "myssl", "cs4");
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
            SSLSocketFactory sSLSocketFactory = this.f5565a;
            if (sSLSocketFactory != null) {
                Socket m53650a = m53650a(sSLSocketFactory.createSocket(inetAddress, i));
                m53647d(m53650a);
                return m53650a;
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
            SSLSocketFactory sSLSocketFactory = this.f5565a;
            if (sSLSocketFactory != null) {
                Socket m53650a = m53650a(sSLSocketFactory.createSocket(inetAddress, i, inetAddress2, i2));
                m53647d(m53650a);
                return m53650a;
            }
            return null;
        } finally {
            if (!z) {
            }
        }
    }
}
