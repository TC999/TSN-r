package com.bytedance.sdk.component.xv.w;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final k f31054c;
    private static final ev[] ev;

    /* renamed from: w  reason: collision with root package name */
    public static final k f31055w;
    public static final k xv;

    /* renamed from: f  reason: collision with root package name */
    final String[] f31056f;

    /* renamed from: r  reason: collision with root package name */
    final String[] f31057r;
    final boolean sr;
    final boolean ux;

    static {
        ev[] evVarArr = {ev.ix, ev.ab, ev.f30976d, ev.xq, ev.al, ev.lp, ev.qy, ev.f30994v, ev.iw, ev.kr, ev.ge, ev.ta, ev.eq, ev.yu, ev.gd};
        ev = evVarArr;
        c c4 = new c(true).c(evVarArr);
        me meVar = me.TLS_1_0;
        k c5 = c4.c(me.TLS_1_3, me.TLS_1_2, me.TLS_1_1, meVar).c(true).c();
        f31054c = c5;
        f31055w = new c(c5).c(meVar).c(true).c();
        xv = new c(false).c();
    }

    k(c cVar) {
        this.sr = cVar.f31058c;
        this.f31056f = cVar.f31059w;
        this.f31057r = cVar.xv;
        this.ux = cVar.sr;
    }

    public boolean c() {
        return this.sr;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            if (obj == this) {
                return true;
            }
            k kVar = (k) obj;
            boolean z3 = this.sr;
            if (z3 != kVar.sr) {
                return false;
            }
            return !z3 || (Arrays.equals(this.f31056f, kVar.f31056f) && Arrays.equals(this.f31057r, kVar.f31057r) && this.ux == kVar.ux);
        }
        return false;
    }

    public int hashCode() {
        if (this.sr) {
            return ((((527 + Arrays.hashCode(this.f31056f)) * 31) + Arrays.hashCode(this.f31057r)) * 31) + (!this.ux ? 1 : 0);
        }
        return 17;
    }

    public boolean sr() {
        return this.ux;
    }

    public String toString() {
        if (this.sr) {
            String obj = this.f31056f != null ? w().toString() : "[all enabled]";
            String obj2 = this.f31057r != null ? xv().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.ux + ")";
        }
        return "ConnectionSpec()";
    }

    public List<ev> w() {
        String[] strArr = this.f31056f;
        if (strArr != null) {
            return ev.c(strArr);
        }
        return null;
    }

    public List<me> xv() {
        String[] strArr = this.f31057r;
        if (strArr != null) {
            return me.c(strArr);
        }
        return null;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        boolean f31058c;
        boolean sr;

        /* renamed from: w  reason: collision with root package name */
        String[] f31059w;
        String[] xv;

        c(boolean z3) {
            this.f31058c = z3;
        }

        public c c(ev... evVarArr) {
            if (this.f31058c) {
                String[] strArr = new String[evVarArr.length];
                for (int i4 = 0; i4 < evVarArr.length; i4++) {
                    strArr[i4] = evVarArr[i4].vj;
                }
                return c(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public c w(String... strArr) {
            if (this.f31058c) {
                if (strArr.length != 0) {
                    this.xv = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public c(k kVar) {
            this.f31058c = kVar.sr;
            this.f31059w = kVar.f31056f;
            this.xv = kVar.f31057r;
            this.sr = kVar.ux;
        }

        public c c(String... strArr) {
            if (this.f31058c) {
                if (strArr.length != 0) {
                    this.f31059w = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public c c(me... meVarArr) {
            if (this.f31058c) {
                String[] strArr = new String[meVarArr.length];
                for (int i4 = 0; i4 < meVarArr.length; i4++) {
                    strArr[i4] = meVarArr[i4].f31066f;
                }
                return w(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public c c(boolean z3) {
            if (this.f31058c) {
                this.sr = z3;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public k c() {
            return new k(this);
        }
    }

    private k w(SSLSocket sSLSocket, boolean z3) {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f31056f != null) {
            enabledCipherSuites = com.bytedance.sdk.component.xv.w.c.xv.c(ev.f30975c, sSLSocket.getEnabledCipherSuites(), this.f31056f);
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f31057r != null) {
            enabledProtocols = com.bytedance.sdk.component.xv.w.c.xv.c(com.bytedance.sdk.component.xv.w.c.xv.ev, sSLSocket.getEnabledProtocols(), this.f31057r);
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int c4 = com.bytedance.sdk.component.xv.w.c.xv.c(ev.f30975c, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z3 && c4 != -1) {
            enabledCipherSuites = com.bytedance.sdk.component.xv.w.c.xv.c(enabledCipherSuites, supportedCipherSuites[c4]);
        }
        return new c(this).c(enabledCipherSuites).w(enabledProtocols).c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(SSLSocket sSLSocket, boolean z3) {
        k w3 = w(sSLSocket, z3);
        String[] strArr = w3.f31057r;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = w3.f31056f;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean c(SSLSocket sSLSocket) {
        if (this.sr) {
            String[] strArr = this.f31057r;
            if (strArr == null || com.bytedance.sdk.component.xv.w.c.xv.w(com.bytedance.sdk.component.xv.w.c.xv.ev, strArr, sSLSocket.getEnabledProtocols())) {
                String[] strArr2 = this.f31056f;
                return strArr2 == null || com.bytedance.sdk.component.xv.w.c.xv.w(ev.f30975c, strArr2, sSLSocket.getEnabledCipherSuites());
            }
            return false;
        }
        return false;
    }
}
