package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ConnectionSpec {

    /* renamed from: e */
    private static final CipherSuite[] f1318e;

    /* renamed from: f */
    public static final ConnectionSpec f1319f;

    /* renamed from: g */
    public static final ConnectionSpec f1320g;

    /* renamed from: a */
    final boolean f1321a;

    /* renamed from: b */
    final boolean f1322b;

    /* renamed from: c */
    final String[] f1323c;

    /* renamed from: d */
    final String[] f1324d;

    static {
        CipherSuite[] cipherSuiteArr = {CipherSuite.f1302m, CipherSuite.f1304o, CipherSuite.f1303n, CipherSuite.f1305p, CipherSuite.f1307r, CipherSuite.f1306q, CipherSuite.f1298i, CipherSuite.f1300k, CipherSuite.f1299j, CipherSuite.f1301l, CipherSuite.f1296g, CipherSuite.f1297h, CipherSuite.f1294e, CipherSuite.f1295f, CipherSuite.f1293d};
        f1318e = cipherSuiteArr;
        C1070a m58393a = new C1070a(true).m58393a(cipherSuiteArr);
        TlsVersion tlsVersion = TlsVersion.TLS_1_0;
        ConnectionSpec m58396a = m58393a.m58394a(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, tlsVersion).m58395a(true).m58396a();
        f1319f = m58396a;
        new C1070a(m58396a).m58394a(tlsVersion).m58395a(true).m58396a();
        f1320g = new C1070a(false).m58396a();
    }

    ConnectionSpec(C1070a c1070a) {
        this.f1321a = c1070a.f1325a;
        this.f1323c = c1070a.f1326b;
        this.f1324d = c1070a.f1327c;
        this.f1322b = c1070a.f1328d;
    }

    /* renamed from: a */
    public List<CipherSuite> m58403a() {
        String[] strArr = this.f1323c;
        if (strArr != null) {
            return CipherSuite.m58412a(strArr);
        }
        return null;
    }

    /* renamed from: b */
    public boolean m58400b() {
        return this.f1321a;
    }

    /* renamed from: c */
    public boolean m58398c() {
        return this.f1322b;
    }

    /* renamed from: d */
    public List<TlsVersion> m58397d() {
        String[] strArr = this.f1324d;
        if (strArr != null) {
            return TlsVersion.m58425a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ConnectionSpec) {
            if (obj == this) {
                return true;
            }
            ConnectionSpec connectionSpec = (ConnectionSpec) obj;
            boolean z = this.f1321a;
            if (z != connectionSpec.f1321a) {
                return false;
            }
            return !z || (Arrays.equals(this.f1323c, connectionSpec.f1323c) && Arrays.equals(this.f1324d, connectionSpec.f1324d) && this.f1322b == connectionSpec.f1322b);
        }
        return false;
    }

    public int hashCode() {
        if (this.f1321a) {
            return ((((Arrays.hashCode(this.f1323c) + 527) * 31) + Arrays.hashCode(this.f1324d)) * 31) + (!this.f1322b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f1321a) {
            String obj = this.f1323c != null ? m58403a().toString() : "[all enabled]";
            String obj2 = this.f1324d != null ? m58397d().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.f1322b + ")";
        }
        return "ConnectionSpec()";
    }

    /* compiled from: ConnectionSpec.java */
    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.k$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static final class C1070a {

        /* renamed from: a */
        boolean f1325a;

        /* renamed from: b */
        String[] f1326b;

        /* renamed from: c */
        String[] f1327c;

        /* renamed from: d */
        boolean f1328d;

        C1070a(boolean z) {
            this.f1325a = z;
        }

        /* renamed from: a */
        public C1070a m58393a(CipherSuite... cipherSuiteArr) {
            if (this.f1325a) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].f1308a;
                }
                return m58392a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: b */
        public C1070a m58391b(String... strArr) {
            if (this.f1325a) {
                if (strArr.length != 0) {
                    this.f1327c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C1070a(ConnectionSpec connectionSpec) {
            this.f1325a = connectionSpec.f1321a;
            this.f1326b = connectionSpec.f1323c;
            this.f1327c = connectionSpec.f1324d;
            this.f1328d = connectionSpec.f1322b;
        }

        /* renamed from: a */
        public C1070a m58392a(String... strArr) {
            if (this.f1325a) {
                if (strArr.length != 0) {
                    this.f1326b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        /* renamed from: a */
        public C1070a m58394a(TlsVersion... tlsVersionArr) {
            if (this.f1325a) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].f1282a;
                }
                return m58391b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        /* renamed from: a */
        public C1070a m58395a(boolean z) {
            if (this.f1325a) {
                this.f1328d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        /* renamed from: a */
        public ConnectionSpec m58396a() {
            return new ConnectionSpec(this);
        }
    }

    /* renamed from: b */
    private ConnectionSpec m58399b(SSLSocket sSLSocket, boolean z) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f1323c != null) {
            enabledCipherSuites = C1061c.m58461a(CipherSuite.f1291b, sSLSocket.getEnabledCipherSuites(), this.f1323c);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f1324d != null) {
            enabledProtocols = C1061c.m58461a(C1061c.f1247o, sSLSocket.getEnabledProtocols(), this.f1324d);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int m58462a = C1061c.m58462a(CipherSuite.f1291b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && m58462a != -1) {
            enabledCipherSuites = C1061c.m58457a(enabledCipherSuites, supportedCipherSuites[m58462a]);
        }
        return new C1070a(this).m58392a(enabledCipherSuites).m58391b(enabledProtocols).m58396a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m58401a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec m58399b = m58399b(sSLSocket, z);
        String[] strArr = m58399b.f1324d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = m58399b.f1323c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: a */
    public boolean m58402a(SSLSocket sSLSocket) {
        if (this.f1321a) {
            String[] strArr = this.f1324d;
            if (strArr == null || C1061c.m58453b(C1061c.f1247o, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f1323c;
                return strArr2 == null || C1061c.m58453b(CipherSuite.f1291b, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }
}
