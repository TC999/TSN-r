package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.k;
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

/* compiled from: ConnectionSpecSelector.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final List<k> f953a;

    /* renamed from: b  reason: collision with root package name */
    private int f954b = 0;

    /* renamed from: c  reason: collision with root package name */
    private boolean f955c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f956d;

    public b(List<k> list) {
        this.f953a = list;
    }

    private boolean b(SSLSocket sSLSocket) {
        for (int i4 = this.f954b; i4 < this.f953a.size(); i4++) {
            if (this.f953a.get(i4).a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    public k a(SSLSocket sSLSocket) throws IOException {
        k kVar;
        int i4 = this.f954b;
        int size = this.f953a.size();
        while (true) {
            if (i4 >= size) {
                kVar = null;
                break;
            }
            kVar = this.f953a.get(i4);
            if (kVar.a(sSLSocket)) {
                this.f954b = i4 + 1;
                break;
            }
            i4++;
        }
        if (kVar != null) {
            this.f955c = b(sSLSocket);
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.f884a.a(kVar, sSLSocket, this.f956d);
            return kVar;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f956d + ", modes=" + this.f953a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean a(IOException iOException) {
        this.f956d = true;
        if (!this.f955c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z3 = iOException instanceof SSLHandshakeException;
        if ((z3 && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z3 || (iOException instanceof SSLProtocolException);
    }
}
