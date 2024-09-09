package com.bytedance.sdk.component.xv.w.c.w;

import com.bytedance.sdk.component.xv.w.k;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class w {

    /* renamed from: c  reason: collision with root package name */
    private final List<k> f30930c;
    private boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private int f30931w = 0;
    private boolean xv;

    public w(List<k> list) {
        this.f30930c = list;
    }

    private boolean w(SSLSocket sSLSocket) {
        for (int i4 = this.f30931w; i4 < this.f30930c.size(); i4++) {
            if (this.f30930c.get(i4).c(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public k c(SSLSocket sSLSocket) throws IOException {
        k kVar;
        int i4 = this.f30931w;
        int size = this.f30930c.size();
        while (true) {
            if (i4 >= size) {
                kVar = null;
                break;
            }
            kVar = this.f30930c.get(i4);
            if (kVar.c(sSLSocket)) {
                this.f30931w = i4 + 1;
                break;
            }
            i4++;
        }
        if (kVar != null) {
            this.xv = w(sSLSocket);
            com.bytedance.sdk.component.xv.w.c.c.f30735c.c(kVar, sSLSocket, this.sr);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.sr + ", modes=" + this.f30930c + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean c(IOException iOException) {
        this.sr = true;
        if (!this.xv || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z3 = iOException instanceof SSLHandshakeException;
        if ((z3 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z3 || (iOException instanceof SSLProtocolException);
    }
}
