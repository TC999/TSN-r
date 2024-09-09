package io.netty.handler.ssl;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
abstract class ExtendedOpenSslSession extends ExtendedSSLSession implements OpenSslSession {
    private static final String[] LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS = {"SHA512withRSA", "SHA512withECDSA", "SHA384withRSA", "SHA384withECDSA", "SHA256withRSA", "SHA256withECDSA", "SHA224withRSA", "SHA224withECDSA", "SHA1withRSA", "SHA1withECDSA"};
    private final OpenSslSession wrapped;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExtendedOpenSslSession(OpenSslSession openSslSession) {
        this.wrapped = openSslSession;
    }

    @Override // javax.net.ssl.SSLSession
    public final int getApplicationBufferSize() {
        return this.wrapped.getApplicationBufferSize();
    }

    @Override // javax.net.ssl.SSLSession
    public final String getCipherSuite() {
        return this.wrapped.getCipherSuite();
    }

    @Override // javax.net.ssl.SSLSession
    public final long getCreationTime() {
        return this.wrapped.getCreationTime();
    }

    @Override // javax.net.ssl.SSLSession
    public final byte[] getId() {
        return this.wrapped.getId();
    }

    @Override // javax.net.ssl.SSLSession
    public final long getLastAccessedTime() {
        return this.wrapped.getLastAccessedTime();
    }

    @Override // javax.net.ssl.SSLSession
    public final Certificate[] getLocalCertificates() {
        return this.wrapped.getLocalCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public final Principal getLocalPrincipal() {
        return this.wrapped.getLocalPrincipal();
    }

    @Override // javax.net.ssl.ExtendedSSLSession
    public final String[] getLocalSupportedSignatureAlgorithms() {
        return (String[]) LOCAL_SUPPORTED_SIGNATURE_ALGORITHMS.clone();
    }

    @Override // javax.net.ssl.SSLSession
    public final int getPacketBufferSize() {
        return this.wrapped.getPacketBufferSize();
    }

    @Override // javax.net.ssl.SSLSession
    public final X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        return this.wrapped.getPeerCertificateChain();
    }

    @Override // javax.net.ssl.SSLSession
    public final Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        return this.wrapped.getPeerCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public final String getPeerHost() {
        return this.wrapped.getPeerHost();
    }

    @Override // javax.net.ssl.SSLSession
    public final int getPeerPort() {
        return this.wrapped.getPeerPort();
    }

    @Override // javax.net.ssl.SSLSession
    public final Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return this.wrapped.getPeerPrincipal();
    }

    @Override // javax.net.ssl.SSLSession
    public String getProtocol() {
        return this.wrapped.getProtocol();
    }

    @Override // javax.net.ssl.ExtendedSSLSession
    public abstract List getRequestedServerNames();

    @Override // javax.net.ssl.SSLSession
    public final SSLSessionContext getSessionContext() {
        return this.wrapped.getSessionContext();
    }

    public List<byte[]> getStatusResponses() {
        return Collections.emptyList();
    }

    @Override // javax.net.ssl.SSLSession
    public final Object getValue(String str) {
        return this.wrapped.getValue(str);
    }

    @Override // javax.net.ssl.SSLSession
    public final String[] getValueNames() {
        return this.wrapped.getValueNames();
    }

    @Override // io.netty.handler.ssl.OpenSslSession
    public final void handshakeFinished() throws SSLException {
        this.wrapped.handshakeFinished();
    }

    @Override // javax.net.ssl.SSLSession
    public final void invalidate() {
        this.wrapped.invalidate();
    }

    @Override // javax.net.ssl.SSLSession
    public final boolean isValid() {
        return this.wrapped.isValid();
    }

    @Override // javax.net.ssl.SSLSession
    public final void putValue(String str, Object obj) {
        this.wrapped.putValue(str, obj);
    }

    @Override // javax.net.ssl.SSLSession
    public final void removeValue(String str) {
        this.wrapped.removeValue(str);
    }

    @Override // io.netty.handler.ssl.OpenSslSession
    public final void tryExpandApplicationBufferSize(int i4) {
        this.wrapped.tryExpandApplicationBufferSize(i4);
    }
}
