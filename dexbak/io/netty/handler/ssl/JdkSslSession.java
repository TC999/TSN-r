package io.netty.handler.ssl;

import java.security.Principal;
import java.security.cert.Certificate;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class JdkSslSession implements SSLSession, ApplicationProtocolAccessor {
    private volatile String applicationProtocol;
    private final SSLEngine engine;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JdkSslSession(SSLEngine sSLEngine) {
        this.engine = sSLEngine;
    }

    private SSLSession unwrap() {
        return this.engine.getSession();
    }

    @Override // javax.net.ssl.SSLSession
    public int getApplicationBufferSize() {
        return unwrap().getApplicationBufferSize();
    }

    @Override // io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override // javax.net.ssl.SSLSession
    public String getCipherSuite() {
        return unwrap().getCipherSuite();
    }

    @Override // javax.net.ssl.SSLSession
    public long getCreationTime() {
        return unwrap().getCreationTime();
    }

    @Override // javax.net.ssl.SSLSession
    public byte[] getId() {
        return unwrap().getId();
    }

    @Override // javax.net.ssl.SSLSession
    public long getLastAccessedTime() {
        return unwrap().getLastAccessedTime();
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getLocalCertificates() {
        return unwrap().getLocalCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getLocalPrincipal() {
        return unwrap().getLocalPrincipal();
    }

    @Override // javax.net.ssl.SSLSession
    public int getPacketBufferSize() {
        return unwrap().getPacketBufferSize();
    }

    @Override // javax.net.ssl.SSLSession
    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
        return unwrap().getPeerCertificateChain();
    }

    @Override // javax.net.ssl.SSLSession
    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
        return unwrap().getPeerCertificates();
    }

    @Override // javax.net.ssl.SSLSession
    public String getPeerHost() {
        return unwrap().getPeerHost();
    }

    @Override // javax.net.ssl.SSLSession
    public int getPeerPort() {
        return unwrap().getPeerPort();
    }

    @Override // javax.net.ssl.SSLSession
    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
        return unwrap().getPeerPrincipal();
    }

    @Override // javax.net.ssl.SSLSession
    public String getProtocol() {
        return unwrap().getProtocol();
    }

    @Override // javax.net.ssl.SSLSession
    public SSLSessionContext getSessionContext() {
        return unwrap().getSessionContext();
    }

    @Override // javax.net.ssl.SSLSession
    public Object getValue(String str) {
        return unwrap().getValue(str);
    }

    @Override // javax.net.ssl.SSLSession
    public String[] getValueNames() {
        return unwrap().getValueNames();
    }

    @Override // javax.net.ssl.SSLSession
    public void invalidate() {
        unwrap().invalidate();
    }

    @Override // javax.net.ssl.SSLSession
    public boolean isValid() {
        return unwrap().isValid();
    }

    @Override // javax.net.ssl.SSLSession
    public void putValue(String str, Object obj) {
        unwrap().putValue(str, obj);
    }

    @Override // javax.net.ssl.SSLSession
    public void removeValue(String str) {
        unwrap().removeValue(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setApplicationProtocol(String str) {
        this.applicationProtocol = str;
    }
}
