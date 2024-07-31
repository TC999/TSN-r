package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19;

import android.net.ssl.SSLSockets;
import android.os.Build;
import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.Protocol;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.CertificateChainCleaner;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.TrustRootIndex;
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
/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class AndroidPlatform extends Platform {

    /* renamed from: c */
    private final OptionalMethod<Socket> f1206c;

    /* renamed from: d */
    private final OptionalMethod<Socket> f1207d;

    /* renamed from: e */
    private final OptionalMethod<Socket> f1208e;

    /* renamed from: f */
    private final OptionalMethod<Socket> f1209f;

    /* renamed from: g */
    private final C1059c f1210g = C1059c.m58506a();

    /* compiled from: AndroidPlatform.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.a$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static final class C1057a extends CertificateChainCleaner {

        /* renamed from: a */
        private final Object f1211a;

        /* renamed from: b */
        private final Method f1212b;

        C1057a(Object obj, Method method) {
            this.f1211a = obj;
            this.f1212b = method;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.CertificateChainCleaner
        /* renamed from: a */
        public List<Certificate> mo58508a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f1212b.invoke(this.f1211a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C1057a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.a$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static final class C1058b implements TrustRootIndex {

        /* renamed from: a */
        private final X509TrustManager f1213a;

        /* renamed from: b */
        private final Method f1214b;

        C1058b(X509TrustManager x509TrustManager, Method method) {
            this.f1214b = method;
            this.f1213a = x509TrustManager;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.TrustRootIndex
        /* renamed from: a */
        public X509Certificate mo58507a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f1214b.invoke(this.f1213a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw C1061c.m58466a("unable to get issues and signature", (Exception) e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof C1058b) {
                C1058b c1058b = (C1058b) obj;
                return this.f1213a.equals(c1058b.f1213a) && this.f1214b.equals(c1058b.f1214b);
            }
            return false;
        }

        public int hashCode() {
            return this.f1213a.hashCode() + (this.f1214b.hashCode() * 31);
        }
    }

    AndroidPlatform(Class<?> cls, OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
        this.f1206c = optionalMethod;
        this.f1207d = optionalMethod2;
        this.f1208e = optionalMethod3;
        this.f1209f = optionalMethod4;
    }

    /* renamed from: c */
    private static boolean m58509c() {
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

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: a */
    public void mo58490a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!C1061c.m58474a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT == 26) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
            throw e2;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: b */
    public String mo58482b(SSLSocket sSLSocket) {
        byte[] bArr;
        OptionalMethod<Socket> optionalMethod = this.f1208e;
        if (optionalMethod == null || !optionalMethod.m58499a((OptionalMethod<Socket>) sSLSocket) || (bArr = (byte[]) this.f1208e.m58495d(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, C1061c.f1241i);
    }

    /* compiled from: AndroidPlatform.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.a$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static final class C1059c {

        /* renamed from: a */
        private final Method f1215a;

        /* renamed from: b */
        private final Method f1216b;

        /* renamed from: c */
        private final Method f1217c;

        C1059c(Method method, Method method2, Method method3) {
            this.f1215a = method;
            this.f1216b = method2;
            this.f1217c = method3;
        }

        /* renamed from: a */
        Object m58504a(String str) {
            Method method = this.f1215a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f1216b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: a */
        boolean m58505a(Object obj) {
            if (obj != null) {
                try {
                    this.f1217c.invoke(obj, new Object[0]);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
            return false;
        }

        /* renamed from: a */
        static C1059c m58506a() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new C1059c(method3, method2, method);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: b */
    public boolean mo58484b(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m58510b(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo58484b(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw C1061c.m58466a("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw C1061c.m58466a("unable to determine cleartext support", e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw C1061c.m58466a("unable to determine cleartext support", e);
        }
    }

    /* renamed from: b */
    private boolean m58510b(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return m58511a(str, cls, obj);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: a */
    public void mo58487a(SSLSocket sSLSocket, String str, List<Protocol> list) {
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
                this.f1206c.m58496c(sSLSocket, Boolean.TRUE);
                this.f1207d.m58496c(sSLSocket, str);
            }
        }
        OptionalMethod<Socket> optionalMethod = this.f1209f;
        if (optionalMethod == null || !optionalMethod.m58499a((OptionalMethod<Socket>) sSLSocket)) {
            return;
        }
        this.f1209f.m58495d(sSLSocket, Platform.m58483b(list));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: b */
    public TrustRootIndex mo58481b(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new C1058b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo58481b(x509TrustManager);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: a */
    public void mo58493a(int i, String str, Throwable th) {
        int min;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                }
                i3 = min;
            }
            i3 = min + 1;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: a */
    public Object mo58492a(String str) {
        return this.f1210g.m58504a(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: a */
    public void mo58491a(String str, Object obj) {
        if (this.f1210g.m58505a(obj)) {
            return;
        }
        mo58493a(5, str, (Throwable) null);
    }

    /* renamed from: a */
    private boolean m58511a(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo58484b(str);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.Platform
    /* renamed from: a */
    public CertificateChainCleaner mo58486a(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C1057a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.mo58486a(x509TrustManager);
        }
    }

    /* renamed from: a */
    public static Platform m58512a() {
        Class<?> cls;
        OptionalMethod optionalMethod;
        OptionalMethod optionalMethod2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            OptionalMethod optionalMethod3 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
            OptionalMethod optionalMethod4 = new OptionalMethod(null, "setHostname", String.class);
            if (m58509c()) {
                OptionalMethod optionalMethod5 = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                optionalMethod2 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                optionalMethod = optionalMethod5;
            } else {
                optionalMethod = null;
                optionalMethod2 = null;
            }
            return new AndroidPlatform(cls2, optionalMethod3, optionalMethod4, optionalMethod, optionalMethod2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }
}
