package com.amap.api.col.p0003l;

import android.content.Context;
import android.net.SSLSessionCache;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.amap.api.col.p0003l.g4;
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
/* renamed from: com.amap.api.col.3l.w6  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class w6 extends SSLSocketFactory {

    /* renamed from: a  reason: collision with root package name */
    private SSLSocketFactory f9367a;

    /* renamed from: b  reason: collision with root package name */
    private Context f9368b;

    /* renamed from: c  reason: collision with root package name */
    private SSLContext f9369c;

    /* compiled from: NetManger.java */
    /* renamed from: com.amap.api.col.3l.w6$a */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    static class a extends Handler {
        /* synthetic */ a(Looper looper, byte b4) {
            this(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            try {
                int i4 = message.what;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        private a(Looper looper) {
            super(looper);
        }

        public a() {
        }
    }

    public w6(Context context, SSLContext sSLContext) {
        SSLSocketFactory sSLSocketFactory;
        if (context != null) {
            try {
                this.f9368b = StubApp.getOrigApplicationContext(context.getApplicationContext());
            } catch (Throwable th) {
                try {
                    u5.p(th, "myssl", "<init>");
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
                        if (this.f9369c == null) {
                            this.f9369c = SSLContext.getDefault();
                        }
                    } catch (Throwable th3) {
                        u5.p(th3, "myssl", "<init2>");
                    }
                    try {
                        if (this.f9367a == null) {
                            this.f9367a = (SSLSocketFactory) SSLSocketFactory.getDefault();
                        }
                    } catch (Throwable th22) {
                        u5.p(th22, "myssl", "<init3>");
                    }
                }
            }
        }
        this.f9369c = sSLContext;
        if (sSLContext != null) {
            this.f9367a = sSLContext.getSocketFactory();
        }
        try {
            if (this.f9369c == null) {
                this.f9369c = SSLContext.getDefault();
            }
        } catch (Throwable th4) {
            u5.p(th4, "myssl", "<init2>");
        }
        try {
            if (this.f9367a == null) {
                this.f9367a = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
        } catch (Throwable th5) {
            u5.p(th5, "myssl", "<init3>");
        }
    }

    private static Socket a(Socket socket) {
        try {
            if (Build.VERSION.SDK_INT >= 21 && g4.g.f7864b && (socket instanceof SSLSocket)) {
                ((SSLSocket) socket).setEnabledProtocols(new String[]{"TLSv1.2"});
            }
        } catch (Throwable th) {
            u5.p(th, "myssl", "stlv2");
        }
        return socket;
    }

    private void c(SSLSessionCache sSLSessionCache) {
        SSLContext sSLContext = this.f9369c;
        if (sSLContext == null) {
            return;
        }
        try {
            SSLSessionContext clientSessionContext = sSLContext.getClientSessionContext();
            Field declaredField = sSLSessionCache.getClass().getDeclaredField(q4.u("UbVNlc3Npb25DYWNoZQ"));
            declaredField.setAccessible(true);
            Object obj = declaredField.get(sSLSessionCache);
            Method[] methods = clientSessionContext.getClass().getMethods();
            String u3 = q4.u("Yc2V0UGVyc2lzdGVudENhY2hl");
            for (Method method : methods) {
                if (method.getName().equals(u3)) {
                    method.invoke(clientSessionContext, obj);
                    return;
                }
            }
        } catch (Throwable th) {
            u5.p(th, "myssl", "isc2");
        }
    }

    private static void d(Socket socket) {
        int i4 = Build.VERSION.SDK_INT;
        if (g4.g.f7865c && g4.g.f7867e && (socket instanceof SSLSocket)) {
            int i5 = g4.g.f7868f;
            int i6 = g4.g.f7866d;
            if (i5 <= i6) {
                i6 = g4.g.f7868f;
            }
            if (i6 <= 17 || i4 <= i6) {
                try {
                    socket.getClass().getMethod(q4.u("Cc2V0VXNlU2Vzc2lvblRpY2tldHM"), Boolean.TYPE).invoke(socket, Boolean.TRUE);
                } catch (Throwable th) {
                    u5.p(th, "myssl", "sust");
                }
            }
        }
    }

    public final void b() {
        int i4 = Build.VERSION.SDK_INT;
        if (!g4.g.f7865c || this.f9368b == null || this.f9369c == null) {
            return;
        }
        int i5 = g4.g.f7866d;
        if (i5 <= 17 || i4 <= i5) {
            SSLSessionCache sSLSessionCache = new SSLSessionCache(this.f9368b);
            if (i4 > 20 && i4 < 28) {
                try {
                    sSLSessionCache.getClass().getMethod(q4.u("MaW5zdGFsbA"), SSLSessionCache.class, SSLContext.class).invoke(sSLSessionCache, sSLSessionCache, this.f9369c);
                    return;
                } catch (Throwable th) {
                    u5.p(th, "myssl", "isc1");
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
            SSLSocketFactory sSLSocketFactory = this.f9367a;
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
            SSLSocketFactory sSLSocketFactory = this.f9367a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getDefaultCipherSuites();
            }
        } catch (Throwable th) {
            u5.p(th, "myssl", "gdcs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        try {
            SSLSocketFactory sSLSocketFactory = this.f9367a;
            if (sSLSocketFactory != null) {
                return sSLSocketFactory.getSupportedCipherSuites();
            }
        } catch (Throwable th) {
            u5.p(th, "myssl", "gscs");
        }
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i4, boolean z3) throws IOException {
        boolean z4;
        IOException iOException;
        try {
            SSLSocketFactory sSLSocketFactory = this.f9367a;
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
            SSLSocketFactory sSLSocketFactory = this.f9367a;
            if (sSLSocketFactory != null) {
                Socket a4 = a(sSLSocketFactory.createSocket(str, i4));
                d(a4);
                return a4;
            }
            return null;
        } catch (Throwable th) {
            u5.p(th, "myssl", "cs3");
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
            SSLSocketFactory sSLSocketFactory = this.f9367a;
            if (sSLSocketFactory != null) {
                Socket a4 = a(sSLSocketFactory.createSocket(str, i4, inetAddress, i5));
                d(a4);
                return a4;
            }
            return null;
        } catch (Throwable th) {
            u5.p(th, "myssl", "cs4");
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
            SSLSocketFactory sSLSocketFactory = this.f9367a;
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
            SSLSocketFactory sSLSocketFactory = this.f9367a;
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
