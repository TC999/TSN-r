package com.bytedance.sdk.component.xv.w.c.r;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import com.acse.ottn.f3;
import com.bytedance.sdk.component.xv.w.c.gd.f;
import com.bytedance.sdk.component.xv.w.ls;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends ux {

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f30784c;

    /* renamed from: f  reason: collision with root package name */
    private final xv f30785f = xv.c();
    private final sr<Socket> sr;
    private final sr<Socket> ux;

    /* renamed from: w  reason: collision with root package name */
    private final sr<Socket> f30786w;
    private final sr<Socket> xv;

    /* renamed from: com.bytedance.sdk.component.xv.w.c.r.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static final class C0461c extends com.bytedance.sdk.component.xv.w.c.gd.xv {

        /* renamed from: c  reason: collision with root package name */
        private final Object f30787c;

        /* renamed from: w  reason: collision with root package name */
        private final Method f30788w;

        C0461c(Object obj, Method method) {
            this.f30787c = obj;
            this.f30788w = method;
        }

        @Override // com.bytedance.sdk.component.xv.w.c.gd.xv
        public List<Certificate> c(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f30788w.invoke(this.f30787c, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e4) {
                throw new AssertionError(e4);
            } catch (InvocationTargetException e5) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e5.getMessage());
                sSLPeerUnverifiedException.initCause(e5);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C0461c;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static final class w implements f {

        /* renamed from: c  reason: collision with root package name */
        private final X509TrustManager f30789c;

        /* renamed from: w  reason: collision with root package name */
        private final Method f30790w;

        w(X509TrustManager x509TrustManager, Method method) {
            this.f30790w = method;
            this.f30789c = x509TrustManager;
        }

        @Override // com.bytedance.sdk.component.xv.w.c.gd.f
        public X509Certificate c(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f30790w.invoke(this.f30789c, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e4) {
                throw com.bytedance.sdk.component.xv.w.c.xv.c("unable to get issues and signature", (Exception) e4);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof w) {
                w wVar = (w) obj;
                return this.f30789c.equals(wVar.f30789c) && this.f30790w.equals(wVar.f30790w);
            }
            return false;
        }

        public int hashCode() {
            return this.f30789c.hashCode() + (this.f30790w.hashCode() * 31);
        }
    }

    c(Class<?> cls, sr<Socket> srVar, sr<Socket> srVar2, sr<Socket> srVar3, sr<Socket> srVar4) {
        this.f30784c = cls;
        this.f30786w = srVar;
        this.xv = srVar2;
        this.sr = srVar3;
        this.ux = srVar4;
    }

    private static boolean sr() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public void c(Socket socket, InetSocketAddress inetSocketAddress, int i4) throws IOException {
        try {
            socket.connect(inetSocketAddress, i4);
        } catch (AssertionError e4) {
            if (!com.bytedance.sdk.component.xv.w.c.xv.c(e4)) {
                throw e4;
            }
            throw new IOException(e4);
        } catch (ClassCastException e5) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e5);
                throw iOException;
            }
            throw e5;
        } catch (SecurityException e6) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e6);
            throw iOException2;
        } catch (Exception unused) {
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public boolean w(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return c(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.w(str);
        } catch (IllegalAccessException e4) {
            e = e4;
            throw com.bytedance.sdk.component.xv.w.c.xv.c("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e5) {
            e = e5;
            throw com.bytedance.sdk.component.xv.w.c.xv.c("unable to determine cleartext support", e);
        } catch (NoClassDefFoundError unused2) {
            if (Build.VERSION.SDK_INT < 23) {
                return super.w(str);
            }
            return false;
        } catch (InvocationTargetException e6) {
            e = e6;
            throw com.bytedance.sdk.component.xv.w.c.xv.c("unable to determine cleartext support", e);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static final class xv {

        /* renamed from: c  reason: collision with root package name */
        private final Method f30791c;

        /* renamed from: w  reason: collision with root package name */
        private final Method f30792w;
        private final Method xv;

        xv(Method method, Method method2, Method method3) {
            this.f30791c = method;
            this.f30792w = method2;
            this.xv = method3;
        }

        Object c(String str) {
            Method method = this.f30791c;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f30792w.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        boolean c(Object obj) {
            if (obj != null) {
                try {
                    this.xv.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }

        static xv c() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod(f3.f5657f, new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new xv(method3, method2, method);
        }
    }

    private boolean w(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.w(str);
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public void c(SSLSocket sSLSocket, String str, List<ls> list) {
        if (str != null) {
            if (Build.VERSION.SDK_INT >= 30) {
                try {
                    SSLSockets.setUseSessionTickets(sSLSocket, true);
                    SNIHostName sNIHostName = new SNIHostName(str);
                    SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                    sSLParameters.setServerNames(Collections.singletonList(sNIHostName));
                    sSLSocket.setSSLParameters(sSLParameters);
                } catch (Exception unused) {
                }
            } else {
                this.f30786w.w(sSLSocket, Boolean.TRUE);
                this.xv.w(sSLSocket, str);
            }
        }
        sr<Socket> srVar = this.ux;
        if (srVar == null || !srVar.c((sr<Socket>) sSLSocket)) {
            return;
        }
        this.ux.sr(sSLSocket, ux.w(list));
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public f w(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new w(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.w(x509TrustManager);
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public String c(SSLSocket sSLSocket) {
        byte[] bArr;
        sr<Socket> srVar = this.sr;
        if (srVar == null || !srVar.c((sr<Socket>) sSLSocket) || (bArr = (byte[]) this.sr.sr(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, com.bytedance.sdk.component.xv.w.c.xv.ux);
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public void c(int i4, String str, Throwable th) {
        int min;
        int i5 = i4 != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i6 = 0;
        int length = str.length();
        while (i6 < length) {
            int indexOf = str.indexOf(10, i6);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i6 + 4000);
                Log.println(i5, "OkHttp", str.substring(i6, min));
                if (min >= indexOf) {
                    break;
                }
                i6 = min;
            }
            i6 = min + 1;
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public Object c(String str) {
        return this.f30785f.c(str);
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public void c(String str, Object obj) {
        if (this.f30785f.c(obj)) {
            return;
        }
        c(5, str, (Throwable) null);
    }

    private boolean c(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return w(str, cls, obj);
        }
    }

    @Override // com.bytedance.sdk.component.xv.w.c.r.ux
    public com.bytedance.sdk.component.xv.w.c.gd.xv c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C0461c(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.c(x509TrustManager);
        }
    }

    public static ux c() {
        Class<?> cls;
        sr srVar;
        sr srVar2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            sr srVar3 = new sr(null, "setUseSessionTickets", Boolean.TYPE);
            sr srVar4 = new sr(null, "setHostname", String.class);
            if (sr()) {
                sr srVar5 = new sr(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                srVar2 = new sr(null, "setAlpnProtocols", byte[].class);
                srVar = srVar5;
            } else {
                srVar = null;
                srVar2 = null;
            }
            return new c(cls2, srVar3, srVar4, srVar, srVar2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }
}
