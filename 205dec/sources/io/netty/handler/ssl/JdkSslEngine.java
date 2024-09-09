package io.netty.handler.ssl;

import java.nio.ByteBuffer;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class JdkSslEngine extends SSLEngine {
    private final SSLEngine engine;
    private final JdkSslSession session;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JdkSslEngine(SSLEngine sSLEngine) {
        this.engine = sSLEngine;
        this.session = new JdkSslSession(sSLEngine);
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() throws SSLException {
        this.engine.beginHandshake();
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() throws SSLException {
        this.engine.closeInbound();
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        this.engine.closeOutbound();
    }

    @Override // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return this.engine.getDelegatedTask();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.engine.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.engine.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.engine.getEnabledProtocols();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getHandshakeSession() {
        return this.engine.getHandshakeSession();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return this.engine.getHandshakeStatus();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.engine.getNeedClientAuth();
    }

    @Override // javax.net.ssl.SSLEngine
    public String getPeerHost() {
        return this.engine.getPeerHost();
    }

    @Override // javax.net.ssl.SSLEngine
    public int getPeerPort() {
        return this.engine.getPeerPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLParameters getSSLParameters() {
        return this.engine.getSSLParameters();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return this.engine.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return this.engine.getSupportedProtocols();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.engine.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.engine.getWantClientAuth();
    }

    public SSLEngine getWrappedEngine() {
        return this.engine;
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isInboundDone() {
        return this.engine.isInboundDone();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isOutboundDone() {
        return this.engine.isOutboundDone();
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean z3) {
        this.engine.setEnableSessionCreation(z3);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] strArr) {
        this.engine.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] strArr) {
        this.engine.setEnabledProtocols(strArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean z3) {
        this.engine.setNeedClientAuth(z3);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setSSLParameters(SSLParameters sSLParameters) {
        this.engine.setSSLParameters(sSLParameters);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean z3) {
        this.engine.setUseClientMode(z3);
    }

    @Override // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean z3) {
        this.engine.setWantClientAuth(z3);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBuffer2);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.engine.wrap(byteBuffer, byteBuffer2);
    }

    @Override // javax.net.ssl.SSLEngine
    public JdkSslSession getSession() {
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBufferArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer) throws SSLException {
        return this.engine.wrap(byteBufferArr, byteBuffer);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i4, int i5) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBufferArr, i4, i5);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i4, int i5, ByteBuffer byteBuffer) throws SSLException {
        return this.engine.wrap(byteBufferArr, i4, i5, byteBuffer);
    }
}
