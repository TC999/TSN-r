package io.netty.handler.ssl;

import io.netty.handler.ssl.JdkApplicationProtocolNegotiator;
import io.netty.util.internal.ObjectUtil;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLHandshakeException;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
class JdkBaseApplicationProtocolNegotiator implements JdkApplicationProtocolNegotiator {
    private final JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory listenerFactory;
    private final List<String> protocols;
    private final JdkApplicationProtocolNegotiator.ProtocolSelectorFactory selectorFactory;
    private final JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory;
    static final JdkApplicationProtocolNegotiator.ProtocolSelectorFactory FAIL_SELECTOR_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectorFactory() { // from class: io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.1
        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectorFactory
        public JdkApplicationProtocolNegotiator.ProtocolSelector newSelector(SSLEngine sSLEngine, Set<String> set) {
            return new FailProtocolSelector((JdkSslEngine) sSLEngine, set);
        }
    };
    static final JdkApplicationProtocolNegotiator.ProtocolSelectorFactory NO_FAIL_SELECTOR_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectorFactory() { // from class: io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.2
        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectorFactory
        public JdkApplicationProtocolNegotiator.ProtocolSelector newSelector(SSLEngine sSLEngine, Set<String> set) {
            return new NoFailProtocolSelector((JdkSslEngine) sSLEngine, set);
        }
    };
    static final JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory FAIL_SELECTION_LISTENER_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory() { // from class: io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.3
        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory
        public JdkApplicationProtocolNegotiator.ProtocolSelectionListener newListener(SSLEngine sSLEngine, List<String> list) {
            return new FailProtocolSelectionListener((JdkSslEngine) sSLEngine, list);
        }
    };
    static final JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory NO_FAIL_SELECTION_LISTENER_FACTORY = new JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory() { // from class: io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.4
        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory
        public JdkApplicationProtocolNegotiator.ProtocolSelectionListener newListener(SSLEngine sSLEngine, List<String> list) {
            return new NoFailProtocolSelectionListener((JdkSslEngine) sSLEngine, list);
        }
    };

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    protected static final class FailProtocolSelectionListener extends NoFailProtocolSelectionListener {
        public FailProtocolSelectionListener(JdkSslEngine jdkSslEngine, List<String> list) {
            super(jdkSslEngine, list);
        }

        @Override // io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.NoFailProtocolSelectionListener
        public void noSelectedMatchFound(String str) throws Exception {
            throw new SSLHandshakeException("No compatible protocols found");
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    protected static final class FailProtocolSelector extends NoFailProtocolSelector {
        public FailProtocolSelector(JdkSslEngine jdkSslEngine, Set<String> set) {
            super(jdkSslEngine, set);
        }

        @Override // io.netty.handler.ssl.JdkBaseApplicationProtocolNegotiator.NoFailProtocolSelector
        public String noSelectMatchFound() throws Exception {
            throw new SSLHandshakeException("Selected protocol is not supported");
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    protected static class NoFailProtocolSelectionListener implements JdkApplicationProtocolNegotiator.ProtocolSelectionListener {
        private final JdkSslEngine jettyWrapper;
        private final List<String> supportedProtocols;

        public NoFailProtocolSelectionListener(JdkSslEngine jdkSslEngine, List<String> list) {
            this.jettyWrapper = jdkSslEngine;
            this.supportedProtocols = list;
        }

        public void noSelectedMatchFound(String str) throws Exception {
        }

        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectionListener
        public void selected(String str) throws Exception {
            if (this.supportedProtocols.contains(str)) {
                this.jettyWrapper.getSession().setApplicationProtocol(str);
            } else {
                noSelectedMatchFound(str);
            }
        }

        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelectionListener
        public void unsupported() {
            this.jettyWrapper.getSession().setApplicationProtocol(null);
        }
    }

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    protected static class NoFailProtocolSelector implements JdkApplicationProtocolNegotiator.ProtocolSelector {
        private final JdkSslEngine jettyWrapper;
        private final Set<String> supportedProtocols;

        public NoFailProtocolSelector(JdkSslEngine jdkSslEngine, Set<String> set) {
            this.jettyWrapper = jdkSslEngine;
            this.supportedProtocols = set;
        }

        public String noSelectMatchFound() throws Exception {
            this.jettyWrapper.getSession().setApplicationProtocol(null);
            return null;
        }

        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelector
        public String select(List<String> list) throws Exception {
            for (String str : this.supportedProtocols) {
                if (list.contains(str)) {
                    this.jettyWrapper.getSession().setApplicationProtocol(str);
                    return str;
                }
            }
            return noSelectMatchFound();
        }

        @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator.ProtocolSelector
        public void unsupported() {
            this.jettyWrapper.getSession().setApplicationProtocol(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JdkBaseApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.SslEngineWrapperFactory sslEngineWrapperFactory, JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolSelectionListenerFactory, Iterable<String> iterable) {
        this(sslEngineWrapperFactory, protocolSelectorFactory, protocolSelectionListenerFactory, ApplicationProtocolUtil.toList(iterable));
    }

    @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolListenerFactory() {
        return this.listenerFactory;
    }

    @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory() {
        return this.selectorFactory;
    }

    @Override // io.netty.handler.ssl.ApplicationProtocolNegotiator
    public List<String> protocols() {
        return this.protocols;
    }

    @Override // io.netty.handler.ssl.JdkApplicationProtocolNegotiator
    public JdkApplicationProtocolNegotiator.SslEngineWrapperFactory wrapperFactory() {
        return this.wrapperFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public JdkBaseApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.SslEngineWrapperFactory sslEngineWrapperFactory, JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolSelectionListenerFactory, String... strArr) {
        this(sslEngineWrapperFactory, protocolSelectorFactory, protocolSelectionListenerFactory, ApplicationProtocolUtil.toList(strArr));
    }

    private JdkBaseApplicationProtocolNegotiator(JdkApplicationProtocolNegotiator.SslEngineWrapperFactory sslEngineWrapperFactory, JdkApplicationProtocolNegotiator.ProtocolSelectorFactory protocolSelectorFactory, JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory protocolSelectionListenerFactory, List<String> list) {
        this.wrapperFactory = (JdkApplicationProtocolNegotiator.SslEngineWrapperFactory) ObjectUtil.checkNotNull(sslEngineWrapperFactory, "wrapperFactory");
        this.selectorFactory = (JdkApplicationProtocolNegotiator.ProtocolSelectorFactory) ObjectUtil.checkNotNull(protocolSelectorFactory, "selectorFactory");
        this.listenerFactory = (JdkApplicationProtocolNegotiator.ProtocolSelectionListenerFactory) ObjectUtil.checkNotNull(protocolSelectionListenerFactory, "listenerFactory");
        this.protocols = Collections.unmodifiableList((List) ObjectUtil.checkNotNull(list, "protocols"));
    }
}
