package com.bytedance.sdk.component.xv.w;

import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class ia {

    /* renamed from: c  reason: collision with root package name */
    private final me f31020c;
    private final List<Certificate> sr;

    /* renamed from: w  reason: collision with root package name */
    private final ev f31021w;
    private final List<Certificate> xv;

    private ia(me meVar, ev evVar, List<Certificate> list, List<Certificate> list2) {
        this.f31020c = meVar;
        this.f31021w = evVar;
        this.xv = list;
        this.sr = list2;
    }

    public static ia c(SSLSession sSLSession) {
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
            ev c4 = ev.c(str);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                me c5 = me.c(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused2) {
                }
                if (certificateArr != null) {
                    emptyList = com.bytedance.sdk.component.xv.w.c.xv.c(certificateArr);
                } else {
                    emptyList = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    emptyList2 = com.bytedance.sdk.component.xv.w.c.xv.c(localCertificates);
                } else {
                    emptyList2 = Collections.emptyList();
                }
                return new ia(c5, c4, emptyList, emptyList2);
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public boolean equals(Object obj) {
        if (obj instanceof ia) {
            ia iaVar = (ia) obj;
            return this.f31020c.equals(iaVar.f31020c) && this.f31021w.equals(iaVar.f31021w) && this.xv.equals(iaVar.xv) && this.sr.equals(iaVar.sr);
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f31020c.hashCode()) * 31) + this.f31021w.hashCode()) * 31) + this.xv.hashCode()) * 31) + this.sr.hashCode();
    }

    public List<Certificate> sr() {
        return this.sr;
    }

    public ev w() {
        return this.f31021w;
    }

    public List<Certificate> xv() {
        return this.xv;
    }

    public me c() {
        return this.f31020c;
    }
}
