package io.netty.handler.ssl;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.security.cert.X509Certificate;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class OpenSslTlsv13X509ExtendedTrustManager extends X509ExtendedTrustManager {
    private final X509ExtendedTrustManager tm;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class DummySSLEngine extends SSLEngine {
        private final boolean client;

        DummySSLEngine(boolean z3) {
            this.client = z3;
        }

        @Override // javax.net.ssl.SSLEngine
        public void beginHandshake() throws SSLException {
        }

        @Override // javax.net.ssl.SSLEngine
        public void closeInbound() throws SSLException {
        }

        @Override // javax.net.ssl.SSLEngine
        public void closeOutbound() {
        }

        @Override // javax.net.ssl.SSLEngine
        public Runnable getDelegatedTask() {
            return null;
        }

        @Override // javax.net.ssl.SSLEngine
        public boolean getEnableSessionCreation() {
            return false;
        }

        @Override // javax.net.ssl.SSLEngine
        public String[] getEnabledCipherSuites() {
            return EmptyArrays.EMPTY_STRINGS;
        }

        @Override // javax.net.ssl.SSLEngine
        public String[] getEnabledProtocols() {
            return new String[]{"TLSv1.3"};
        }

        @Override // javax.net.ssl.SSLEngine
        public SSLSession getHandshakeSession() {
            return new SSLSession() { // from class: io.netty.handler.ssl.OpenSslTlsv13X509ExtendedTrustManager.DummySSLEngine.1
                @Override // javax.net.ssl.SSLSession
                public int getApplicationBufferSize() {
                    return 0;
                }

                @Override // javax.net.ssl.SSLSession
                public String getCipherSuite() {
                    return null;
                }

                @Override // javax.net.ssl.SSLSession
                public long getCreationTime() {
                    return 0L;
                }

                @Override // javax.net.ssl.SSLSession
                public byte[] getId() {
                    return EmptyArrays.EMPTY_BYTES;
                }

                @Override // javax.net.ssl.SSLSession
                public long getLastAccessedTime() {
                    return 0L;
                }

                @Override // javax.net.ssl.SSLSession
                public Certificate[] getLocalCertificates() {
                    return EmptyArrays.EMPTY_CERTIFICATES;
                }

                @Override // javax.net.ssl.SSLSession
                public Principal getLocalPrincipal() {
                    return null;
                }

                @Override // javax.net.ssl.SSLSession
                public int getPacketBufferSize() {
                    return 0;
                }

                @Override // javax.net.ssl.SSLSession
                public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
                    return EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                }

                @Override // javax.net.ssl.SSLSession
                public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
                    return EmptyArrays.EMPTY_CERTIFICATES;
                }

                @Override // javax.net.ssl.SSLSession
                public String getPeerHost() {
                    return null;
                }

                @Override // javax.net.ssl.SSLSession
                public int getPeerPort() {
                    return 0;
                }

                @Override // javax.net.ssl.SSLSession
                public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
                    return null;
                }

                @Override // javax.net.ssl.SSLSession
                public String getProtocol() {
                    return "TLSv1.3";
                }

                @Override // javax.net.ssl.SSLSession
                public SSLSessionContext getSessionContext() {
                    return null;
                }

                @Override // javax.net.ssl.SSLSession
                public Object getValue(String str) {
                    return null;
                }

                @Override // javax.net.ssl.SSLSession
                public String[] getValueNames() {
                    return EmptyArrays.EMPTY_STRINGS;
                }

                @Override // javax.net.ssl.SSLSession
                public void invalidate() {
                }

                @Override // javax.net.ssl.SSLSession
                public boolean isValid() {
                    return false;
                }

                @Override // javax.net.ssl.SSLSession
                public void putValue(String str, Object obj) {
                }

                @Override // javax.net.ssl.SSLSession
                public void removeValue(String str) {
                }
            };
        }

        @Override // javax.net.ssl.SSLEngine
        public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }

        @Override // javax.net.ssl.SSLEngine
        public boolean getNeedClientAuth() {
            return false;
        }

        @Override // javax.net.ssl.SSLEngine
        public SSLSession getSession() {
            return getHandshakeSession();
        }

        @Override // javax.net.ssl.SSLEngine
        public String[] getSupportedCipherSuites() {
            return EmptyArrays.EMPTY_STRINGS;
        }

        @Override // javax.net.ssl.SSLEngine
        public String[] getSupportedProtocols() {
            return new String[]{"TLSv1.3"};
        }

        @Override // javax.net.ssl.SSLEngine
        public boolean getUseClientMode() {
            return this.client;
        }

        @Override // javax.net.ssl.SSLEngine
        public boolean getWantClientAuth() {
            return false;
        }

        @Override // javax.net.ssl.SSLEngine
        public boolean isInboundDone() {
            return true;
        }

        @Override // javax.net.ssl.SSLEngine
        public boolean isOutboundDone() {
            return true;
        }

        @Override // javax.net.ssl.SSLEngine
        public void setEnableSessionCreation(boolean z3) {
        }

        @Override // javax.net.ssl.SSLEngine
        public void setEnabledCipherSuites(String[] strArr) {
        }

        @Override // javax.net.ssl.SSLEngine
        public void setEnabledProtocols(String[] strArr) {
        }

        @Override // javax.net.ssl.SSLEngine
        public void setNeedClientAuth(boolean z3) {
        }

        @Override // javax.net.ssl.SSLEngine
        public void setUseClientMode(boolean z3) {
        }

        @Override // javax.net.ssl.SSLEngine
        public void setWantClientAuth(boolean z3) {
        }

        @Override // javax.net.ssl.SSLEngine
        public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i4, int i5) throws SSLException {
            throw new UnsupportedOperationException();
        }

        @Override // javax.net.ssl.SSLEngine
        public SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i4, int i5, ByteBuffer byteBuffer) throws SSLException {
            throw new UnsupportedOperationException();
        }
    }

    private OpenSslTlsv13X509ExtendedTrustManager(X509ExtendedTrustManager x509ExtendedTrustManager) {
        this.tm = x509ExtendedTrustManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static X509ExtendedTrustManager wrap(X509ExtendedTrustManager x509ExtendedTrustManager, boolean z3) {
        if (PlatformDependent.javaVersion() < 11) {
            try {
                java.security.cert.X509Certificate[] x509CertificateArr = {OpenSsl.selfSignedCertificate()};
                if (z3) {
                    x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, "RSA", new DummySSLEngine(true));
                } else {
                    x509ExtendedTrustManager.checkClientTrusted(x509CertificateArr, "RSA", new DummySSLEngine(false));
                }
            } catch (IllegalArgumentException unused) {
                return new OpenSslTlsv13X509ExtendedTrustManager(x509ExtendedTrustManager);
            } catch (Throwable unused2) {
            }
        }
        return x509ExtendedTrustManager;
    }

    private static SSLEngine wrapEngine(final SSLEngine sSLEngine) {
        final SSLSession handshakeSession = sSLEngine.getHandshakeSession();
        return (handshakeSession == null || !"TLSv1.3".equals(handshakeSession.getProtocol())) ? sSLEngine : new JdkSslEngine(sSLEngine) { // from class: io.netty.handler.ssl.OpenSslTlsv13X509ExtendedTrustManager.1
            @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
            public SSLSession getHandshakeSession() {
                if (PlatformDependent.javaVersion() >= 7) {
                    SSLSession sSLSession = handshakeSession;
                    if (sSLSession instanceof ExtendedOpenSslSession) {
                        final ExtendedOpenSslSession extendedOpenSslSession = (ExtendedOpenSslSession) sSLSession;
                        return new ExtendedOpenSslSession(extendedOpenSslSession) { // from class: io.netty.handler.ssl.OpenSslTlsv13X509ExtendedTrustManager.1.1
                            @Override // javax.net.ssl.ExtendedSSLSession
                            public String[] getPeerSupportedSignatureAlgorithms() {
                                return extendedOpenSslSession.getPeerSupportedSignatureAlgorithms();
                            }

                            @Override // io.netty.handler.ssl.ExtendedOpenSslSession, javax.net.ssl.SSLSession
                            public String getProtocol() {
                                return "TLSv1.2";
                            }

                            @Override // io.netty.handler.ssl.ExtendedOpenSslSession, javax.net.ssl.ExtendedSSLSession
                            public List getRequestedServerNames() {
                                return extendedOpenSslSession.getRequestedServerNames();
                            }
                        };
                    }
                }
                return new SSLSession() { // from class: io.netty.handler.ssl.OpenSslTlsv13X509ExtendedTrustManager.1.2
                    @Override // javax.net.ssl.SSLSession
                    public int getApplicationBufferSize() {
                        return handshakeSession.getApplicationBufferSize();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public String getCipherSuite() {
                        return handshakeSession.getCipherSuite();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public long getCreationTime() {
                        return handshakeSession.getCreationTime();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public byte[] getId() {
                        return handshakeSession.getId();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public long getLastAccessedTime() {
                        return handshakeSession.getLastAccessedTime();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public Certificate[] getLocalCertificates() {
                        return handshakeSession.getLocalCertificates();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public Principal getLocalPrincipal() {
                        return handshakeSession.getLocalPrincipal();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public int getPacketBufferSize() {
                        return handshakeSession.getPacketBufferSize();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
                        return handshakeSession.getPeerCertificateChain();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
                        return handshakeSession.getPeerCertificates();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public String getPeerHost() {
                        return handshakeSession.getPeerHost();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public int getPeerPort() {
                        return handshakeSession.getPeerPort();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
                        return handshakeSession.getPeerPrincipal();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public String getProtocol() {
                        return "TLSv1.2";
                    }

                    @Override // javax.net.ssl.SSLSession
                    public SSLSessionContext getSessionContext() {
                        return handshakeSession.getSessionContext();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public Object getValue(String str) {
                        return handshakeSession.getValue(str);
                    }

                    @Override // javax.net.ssl.SSLSession
                    public String[] getValueNames() {
                        return handshakeSession.getValueNames();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public void invalidate() {
                        handshakeSession.invalidate();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public boolean isValid() {
                        return handshakeSession.isValid();
                    }

                    @Override // javax.net.ssl.SSLSession
                    public void putValue(String str, Object obj) {
                        handshakeSession.putValue(str, obj);
                    }

                    @Override // javax.net.ssl.SSLSession
                    public void removeValue(String str) {
                        handshakeSession.removeValue(str);
                    }
                };
            }

            public String getNegotiatedApplicationProtocol() {
                SSLEngine sSLEngine2 = sSLEngine;
                if (sSLEngine2 instanceof ApplicationProtocolAccessor) {
                    return ((ApplicationProtocolAccessor) sSLEngine2).getNegotiatedApplicationProtocol();
                }
                return super.getNegotiatedApplicationProtocol();
            }
        };
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        this.tm.checkClientTrusted(x509CertificateArr, str, socket);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        this.tm.checkServerTrusted(x509CertificateArr, str, socket);
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return this.tm.getAcceptedIssuers();
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        this.tm.checkClientTrusted(x509CertificateArr, str, wrapEngine(sSLEngine));
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        this.tm.checkServerTrusted(x509CertificateArr, str, wrapEngine(sSLEngine));
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.tm.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.tm.checkServerTrusted(x509CertificateArr, str);
    }
}
