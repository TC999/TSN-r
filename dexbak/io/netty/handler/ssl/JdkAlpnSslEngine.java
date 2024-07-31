package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.internal.ObjectUtil;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import org.eclipse.jetty.alpn.ALPN;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class JdkAlpnSslEngine extends JdkSslEngine {
    private static boolean available;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JdkAlpnSslEngine(SSLEngine sSLEngine, final JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z) {
        super(sSLEngine);
        ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator, "applicationNegotiator");
        if (z) {
            final JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector = (JdkApplicationProtocolNegotiator.ProtocolSelector) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator.protocols())), "protocolSelector");
            ALPN.put(sSLEngine, new ALPN.ServerProvider() { // from class: io.netty.handler.ssl.JdkAlpnSslEngine.1
                public String select(List<String> list) throws SSLException {
                    try {
                        return protocolSelector.select(list);
                    } catch (SSLHandshakeException e) {
                        throw e;
                    } catch (Throwable th) {
                        SSLHandshakeException sSLHandshakeException = new SSLHandshakeException(th.getMessage());
                        sSLHandshakeException.initCause(th);
                        throw sSLHandshakeException;
                    }
                }

                public void unsupported() {
                    protocolSelector.unsupported();
                }
            });
            return;
        }
        final JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolSelectionListener = (JdkApplicationProtocolNegotiator.ProtocolSelectionListener) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator.protocols()), "protocolListener");
        ALPN.put(sSLEngine, new ALPN.ClientProvider() { // from class: io.netty.handler.ssl.JdkAlpnSslEngine.2
            public List<String> protocols() {
                return jdkApplicationProtocolNegotiator.protocols();
            }

            public void selected(String str) throws SSLException {
                try {
                    protocolSelectionListener.selected(str);
                } catch (SSLHandshakeException e) {
                    throw e;
                } catch (Throwable th) {
                    SSLHandshakeException sSLHandshakeException = new SSLHandshakeException(th.getMessage());
                    sSLHandshakeException.initCause(th);
                    throw sSLHandshakeException;
                }
            }

            public void unsupported() {
                protocolSelectionListener.unsupported();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isAvailable() {
        updateAvailability();
        return available;
    }

    private static void updateAvailability() {
        if (available) {
            return;
        }
        try {
            Class.forName("sun.security.ssl.ALPNExtension", true, null);
            available = true;
        } catch (Exception unused) {
        }
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public void closeInbound() throws SSLException {
        ALPN.remove(getWrappedEngine());
        super.closeInbound();
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public void closeOutbound() {
        ALPN.remove(getWrappedEngine());
        super.closeOutbound();
    }
}
