package io.netty.bootstrap;

import io.netty.bootstrap.AbstractBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.util.AttributeKey;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractBootstrapConfig<B extends AbstractBootstrap<B, C>, C extends Channel> {
    protected final B bootstrap;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractBootstrapConfig(B b) {
        this.bootstrap = (B) ObjectUtil.checkNotNull(b, "bootstrap");
    }

    public final Map<AttributeKey<?>, Object> attrs() {
        return this.bootstrap.attrs();
    }

    public final ChannelFactory<? extends C> channelFactory() {
        return this.bootstrap.channelFactory();
    }

    public final EventLoopGroup group() {
        return this.bootstrap.group();
    }

    public final ChannelHandler handler() {
        return this.bootstrap.handler();
    }

    public final SocketAddress localAddress() {
        return this.bootstrap.localAddress();
    }

    public final Map<ChannelOption<?>, Object> options() {
        return this.bootstrap.options();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        sb.append('(');
        EventLoopGroup group = group();
        if (group != null) {
            sb.append("group: ");
            sb.append(StringUtil.simpleClassName(group));
            sb.append(", ");
        }
        ChannelFactory<? extends C> channelFactory = channelFactory();
        if (channelFactory != null) {
            sb.append("channelFactory: ");
            sb.append(channelFactory);
            sb.append(", ");
        }
        SocketAddress localAddress = localAddress();
        if (localAddress != null) {
            sb.append("localAddress: ");
            sb.append(localAddress);
            sb.append(", ");
        }
        Map<ChannelOption<?>, Object> options = options();
        if (!options.isEmpty()) {
            sb.append("options: ");
            sb.append(options);
            sb.append(", ");
        }
        Map<AttributeKey<?>, Object> attrs = attrs();
        if (!attrs.isEmpty()) {
            sb.append("attrs: ");
            sb.append(attrs);
            sb.append(", ");
        }
        ChannelHandler handler = handler();
        if (handler != null) {
            sb.append("handler: ");
            sb.append(handler);
            sb.append(", ");
        }
        if (sb.charAt(sb.length() - 1) == '(') {
            sb.append(')');
        } else {
            sb.setCharAt(sb.length() - 2, ')');
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
