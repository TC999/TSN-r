package io.netty.handler.ssl;

import io.netty.handler.ssl.ApplicationProtocolConfig;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface OpenSslApplicationProtocolNegotiator extends ApplicationProtocolNegotiator {
    ApplicationProtocolConfig.Protocol protocol();

    ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior();

    ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior();
}
