package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import org.eclipse.jetty.npn.NextProtoNego;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class JdkNpnSslEngine extends JdkSslEngine {
    private static boolean available;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JdkNpnSslEngine(SSLEngine sSLEngine, final JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, boolean z) {
        super(sSLEngine);
        ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator, "applicationNegotiator");
        if (z) {
            final JdkApplicationProtocolNegotiator.ProtocolSelectionListener protocolSelectionListener = (JdkApplicationProtocolNegotiator.ProtocolSelectionListener) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolListenerFactory().newListener(this, jdkApplicationProtocolNegotiator.protocols()), "protocolListener");
            NextProtoNego.put(sSLEngine, new NextProtoNego.ServerProvider() { // from class: io.netty.handler.ssl.JdkNpnSslEngine.1
                public void protocolSelected(String str) {
                    try {
                        protocolSelectionListener.selected(str);
                    } catch (Throwable th) {
                        PlatformDependent.throwException(th);
                    }
                }

                public List<String> protocols() {
                    return jdkApplicationProtocolNegotiator.protocols();
                }

                public void unsupported() {
                    protocolSelectionListener.unsupported();
                }
            });
            return;
        }
        final JdkApplicationProtocolNegotiator.ProtocolSelector protocolSelector = (JdkApplicationProtocolNegotiator.ProtocolSelector) ObjectUtil.checkNotNull(jdkApplicationProtocolNegotiator.protocolSelectorFactory().newSelector(this, new LinkedHashSet(jdkApplicationProtocolNegotiator.protocols())), "protocolSelector");
        NextProtoNego.put(sSLEngine, new NextProtoNego.ClientProvider() { // from class: io.netty.handler.ssl.JdkNpnSslEngine.2
            public String selectProtocol(List<String> list) {
                try {
                    return protocolSelector.select(list);
                } catch (Throwable th) {
                    PlatformDependent.throwException(th);
                    return null;
                }
            }

            public boolean supports() {
                return true;
            }

            public void unsupported() {
                protocolSelector.unsupported();
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
            Class.forName("sun.security.ssl.NextProtoNegoExtension", true, null);
            available = true;
        } catch (Exception unused) {
        }
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public void closeInbound() throws SSLException {
        NextProtoNego.remove(getWrappedEngine());
        super.closeInbound();
    }

    @Override // io.netty.handler.ssl.JdkSslEngine, javax.net.ssl.SSLEngine
    public void closeOutbound() {
        NextProtoNego.remove(getWrappedEngine());
        super.closeOutbound();
    }
}
