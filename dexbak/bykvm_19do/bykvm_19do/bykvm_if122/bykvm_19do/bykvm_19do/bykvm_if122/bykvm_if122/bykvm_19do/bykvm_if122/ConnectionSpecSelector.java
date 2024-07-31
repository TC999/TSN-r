package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.ConnectionSpec;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.Internal;
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

/* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.b */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class ConnectionSpecSelector {

    /* renamed from: a */
    private final List<ConnectionSpec> f960a;

    /* renamed from: b */
    private int f961b = 0;

    /* renamed from: c */
    private boolean f962c;

    /* renamed from: d */
    private boolean f963d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f960a = list;
    }

    /* renamed from: b */
    private boolean m58736b(SSLSocket sSLSocket) {
        for (int i = this.f961b; i < this.f960a.size(); i++) {
            if (this.f960a.get(i).m58402a(sSLSocket)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public ConnectionSpec m58737a(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i = this.f961b;
        int size = this.f960a.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f960a.get(i);
            if (connectionSpec.m58402a(sSLSocket)) {
                this.f961b = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec != null) {
            this.f962c = m58736b(sSLSocket);
            Internal.f891a.mo58233a(connectionSpec, sSLSocket, this.f963d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f963d + ", modes=" + this.f960a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    /* renamed from: a */
    public boolean m58738a(IOException iOException) {
        this.f963d = true;
        if (!this.f962c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return z || (iOException instanceof SSLProtocolException);
    }
}
