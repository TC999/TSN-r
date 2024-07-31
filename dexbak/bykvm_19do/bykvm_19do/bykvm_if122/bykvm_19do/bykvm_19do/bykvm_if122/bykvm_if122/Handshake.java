package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.C1061c;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.q */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Handshake {

    /* renamed from: a */
    private final TlsVersion f1353a;

    /* renamed from: b */
    private final CipherSuite f1354b;

    /* renamed from: c */
    private final List<Certificate> f1355c;

    /* renamed from: d */
    private final List<Certificate> f1356d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f1353a = tlsVersion;
        this.f1354b = cipherSuite;
        this.f1355c = list;
        this.f1356d = list2;
    }

    /* renamed from: a */
    public static Handshake m58344a(SSLSession sSLSession) {
        String str;
        List emptyList;
        List emptyList2;
        Certificate[] certificateArr = null;
        try {
            str = sSLSession.getCipherSuite();
        } catch (Exception unused) {
            str = null;
        }
        if (str != null) {
            CipherSuite m58414a = CipherSuite.m58414a(str);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                TlsVersion m58426a = TlsVersion.m58426a(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused2) {
                }
                if (certificateArr != null) {
                    emptyList = C1061c.m58458a(certificateArr);
                } else {
                    emptyList = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    emptyList2 = C1061c.m58458a(localCertificates);
                } else {
                    emptyList2 = Collections.emptyList();
                }
                return new Handshake(m58426a, m58414a, emptyList, emptyList2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    /* renamed from: b */
    public List<Certificate> m58343b() {
        return this.f1355c;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            return this.f1353a.equals(handshake.f1353a) && this.f1354b.equals(handshake.f1354b) && this.f1355c.equals(handshake.f1355c) && this.f1356d.equals(handshake.f1356d);
        }
        return false;
    }

    public int hashCode() {
        return ((((((this.f1353a.hashCode() + 527) * 31) + this.f1354b.hashCode()) * 31) + this.f1355c.hashCode()) * 31) + this.f1356d.hashCode();
    }

    /* renamed from: a */
    public CipherSuite m58345a() {
        return this.f1354b;
    }
}
