package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class k {

    /* renamed from: e  reason: collision with root package name */
    private static final h[] f1311e;

    /* renamed from: f  reason: collision with root package name */
    public static final k f1312f;

    /* renamed from: g  reason: collision with root package name */
    public static final k f1313g;

    /* renamed from: a  reason: collision with root package name */
    final boolean f1314a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f1315b;

    /* renamed from: c  reason: collision with root package name */
    final String[] f1316c;

    /* renamed from: d  reason: collision with root package name */
    final String[] f1317d;

    static {
        h[] hVarArr = {h.f1295m, h.f1297o, h.f1296n, h.f1298p, h.f1300r, h.f1299q, h.f1291i, h.f1293k, h.f1292j, h.f1294l, h.f1289g, h.f1290h, h.f1287e, h.f1288f, h.f1286d};
        f1311e = hVarArr;
        a a4 = new a(true).a(hVarArr);
        d0 d0Var = d0.TLS_1_0;
        k a5 = a4.a(d0.TLS_1_3, d0.TLS_1_2, d0.TLS_1_1, d0Var).a(true).a();
        f1312f = a5;
        new a(a5).a(d0Var).a(true).a();
        f1313g = new a(false).a();
    }

    k(a aVar) {
        this.f1314a = aVar.f1318a;
        this.f1316c = aVar.f1319b;
        this.f1317d = aVar.f1320c;
        this.f1315b = aVar.f1321d;
    }

    public List<h> a() {
        String[] strArr = this.f1316c;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    public boolean b() {
        return this.f1314a;
    }

    public boolean c() {
        return this.f1315b;
    }

    public List<d0> d() {
        String[] strArr = this.f1317d;
        if (strArr != null) {
            return d0.a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            if (obj == this) {
                return true;
            }
            k kVar = (k) obj;
            boolean z3 = this.f1314a;
            if (z3 != kVar.f1314a) {
                return false;
            }
            return !z3 || (Arrays.equals(this.f1316c, kVar.f1316c) && Arrays.equals(this.f1317d, kVar.f1317d) && this.f1315b == kVar.f1315b);
        }
        return false;
    }

    public int hashCode() {
        if (this.f1314a) {
            return ((((Arrays.hashCode(this.f1316c) + 527) * 31) + Arrays.hashCode(this.f1317d)) * 31) + (!this.f1315b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f1314a) {
            String obj = this.f1316c != null ? a().toString() : "[all enabled]";
            String obj2 = this.f1317d != null ? d().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f1315b + ")";
        }
        return "ConnectionSpec()";
    }

    /* compiled from: ConnectionSpec.java */
    /* loaded from: E:\TSN-r\205dec\6276784.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        boolean f1318a;

        /* renamed from: b  reason: collision with root package name */
        String[] f1319b;

        /* renamed from: c  reason: collision with root package name */
        String[] f1320c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1321d;

        a(boolean z3) {
            this.f1318a = z3;
        }

        public a a(h... hVarArr) {
            if (this.f1318a) {
                String[] strArr = new String[hVarArr.length];
                for (int i4 = 0; i4 < hVarArr.length; i4++) {
                    strArr[i4] = hVarArr[i4].f1301a;
                }
                return a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a b(String... strArr) {
            if (this.f1318a) {
                if (strArr.length != 0) {
                    this.f1320c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(k kVar) {
            this.f1318a = kVar.f1314a;
            this.f1319b = kVar.f1316c;
            this.f1320c = kVar.f1317d;
            this.f1321d = kVar.f1315b;
        }

        public a a(String... strArr) {
            if (this.f1318a) {
                if (strArr.length != 0) {
                    this.f1319b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(d0... d0VarArr) {
            if (this.f1318a) {
                String[] strArr = new String[d0VarArr.length];
                for (int i4 = 0; i4 < d0VarArr.length; i4++) {
                    strArr[i4] = d0VarArr[i4].f1275a;
                }
                return b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(boolean z3) {
            if (this.f1318a) {
                this.f1321d = z3;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public k a() {
            return new k(this);
        }
    }

    private k b(SSLSocket sSLSocket, boolean z3) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f1316c != null) {
            enabledCipherSuites = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(h.f1284b, sSLSocket.getEnabledCipherSuites(), this.f1316c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f1317d != null) {
            enabledProtocols = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1240o, sSLSocket.getEnabledProtocols(), this.f1317d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(h.f1284b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z3 && a4 != -1) {
            enabledCipherSuites = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(enabledCipherSuites, supportedCipherSuites[a4]);
        }
        return new a(this).a(enabledCipherSuites).b(enabledProtocols).a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(SSLSocket sSLSocket, boolean z3) {
        k b4 = b(sSLSocket, z3);
        String[] strArr = b4.f1317d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b4.f1316c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        if (this.f1314a) {
            String[] strArr = this.f1317d;
            if (strArr == null || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.f1240o, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f1316c;
                return strArr2 == null || bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(h.f1284b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }
}
