package io.netty.channel.sctp.oio;

import com.sun.nio.sctp.SctpChannel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPromise;
import io.netty.channel.oio.AbstractOioMessageChannel;
import io.netty.channel.sctp.DefaultSctpServerChannelConfig;
import io.netty.channel.sctp.SctpServerChannel;
import io.netty.channel.sctp.SctpServerChannelConfig;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class OioSctpServerChannel extends AbstractOioMessageChannel implements SctpServerChannel {
    private final SctpServerChannelConfig config;
    private final com.sun.nio.sctp.SctpServerChannel sch;
    private final Selector selector;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(OioSctpServerChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 1);

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class OioSctpServerChannelConfig extends DefaultSctpServerChannelConfig {
        @Override // io.netty.channel.DefaultChannelConfig
        protected void autoReadCleared() {
            OioSctpServerChannel.this.clearReadPending();
        }

        private OioSctpServerChannelConfig(OioSctpServerChannel oioSctpServerChannel, com.sun.nio.sctp.SctpServerChannel sctpServerChannel) {
            super(oioSctpServerChannel, sctpServerChannel);
        }
    }

    public OioSctpServerChannel() {
        this(newServerSocket());
    }

    private static com.sun.nio.sctp.SctpServerChannel newServerSocket() {
        try {
            return com.sun.nio.sctp.SctpServerChannel.open();
        } catch (IOException e) {
            throw new ChannelException("failed to create a sctp server channel", e);
        }
    }

    @Override // io.netty.channel.sctp.SctpServerChannel
    public Set<InetSocketAddress> allLocalAddresses() {
        try {
            Set<SocketAddress> allLocalAddresses = this.sch.getAllLocalAddresses();
            LinkedHashSet linkedHashSet = new LinkedHashSet(allLocalAddresses.size());
            for (SocketAddress socketAddress : allLocalAddresses) {
                linkedHashSet.add((InetSocketAddress) socketAddress);
            }
            return linkedHashSet;
        } catch (Throwable unused) {
            return Collections.emptySet();
        }
    }

    @Override // io.netty.channel.sctp.SctpServerChannel
    public ChannelFuture bindAddress(InetAddress inetAddress) {
        return bindAddress(inetAddress, newPromise());
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.sch.bind(socketAddress, this.config.getBacklog());
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        try {
            this.selector.close();
        } catch (IOException e) {
            logger.warn("Failed to close a selector.", (Throwable) e);
        }
        this.sch.close();
    }

    @Override // io.netty.channel.oio.AbstractOioChannel
    protected void doConnect(SocketAddress socketAddress, SocketAddress socketAddress2) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDisconnect() throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.oio.AbstractOioMessageChannel
    protected int doReadMessages(List<Object> list) throws Exception {
        if (isActive()) {
            SctpChannel sctpChannel = null;
            int i = 0;
            try {
                if (this.selector.select(1000L) > 0) {
                    Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
                    do {
                        it.remove();
                        if (it.next().isAcceptable() && (sctpChannel = this.sch.accept()) != null) {
                            list.add(new OioSctpChannel(this, sctpChannel));
                            i++;
                        }
                    } while (it.hasNext());
                    return i;
                }
            } catch (Throwable th) {
                logger.warn("Failed to create a new channel from an accepted sctp channel.", th);
                if (sctpChannel != null) {
                    try {
                        sctpChannel.close();
                    } catch (Throwable th2) {
                        logger.warn("Failed to close a sctp channel.", th2);
                    }
                }
            }
            return i;
        }
        return -1;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.AbstractChannel
    protected Object filterOutboundMessage(Object obj) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return isOpen() && localAddress0() != null;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.sch.isOpen();
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        try {
            Iterator it = this.sch.getAllLocalAddresses().iterator();
            if (it.hasNext()) {
                return (SocketAddress) it.next();
            }
            return null;
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress remoteAddress() {
        return null;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress remoteAddress0() {
        return null;
    }

    @Override // io.netty.channel.sctp.SctpServerChannel
    public ChannelFuture unbindAddress(InetAddress inetAddress) {
        return unbindAddress(inetAddress, newPromise());
    }

    public OioSctpServerChannel(com.sun.nio.sctp.SctpServerChannel sctpServerChannel) {
        super(null);
        if (sctpServerChannel != null) {
            this.sch = sctpServerChannel;
            try {
                try {
                    sctpServerChannel.configureBlocking(false);
                    Selector open = Selector.open();
                    this.selector = open;
                    sctpServerChannel.register(open, 16);
                    this.config = new OioSctpServerChannelConfig(this, sctpServerChannel);
                    return;
                } catch (Exception e) {
                    throw new ChannelException("failed to initialize a sctp server channel", e);
                }
            } catch (Throwable th) {
                try {
                    sctpServerChannel.close();
                } catch (IOException e2) {
                    logger.warn("Failed to close a sctp server channel.", (Throwable) e2);
                }
                throw th;
            }
        }
        throw new NullPointerException("sctp server channel");
    }

    @Override // io.netty.channel.sctp.SctpServerChannel
    public ChannelFuture bindAddress(final InetAddress inetAddress, final ChannelPromise channelPromise) {
        if (eventLoop().inEventLoop()) {
            try {
                this.sch.bindAddress(inetAddress);
                channelPromise.setSuccess();
            } catch (Throwable th) {
                channelPromise.setFailure(th);
            }
        } else {
            eventLoop().execute(new Runnable() { // from class: io.netty.channel.sctp.oio.OioSctpServerChannel.1
                @Override // java.lang.Runnable
                public void run() {
                    OioSctpServerChannel.this.bindAddress(inetAddress, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override // io.netty.channel.Channel
    public SctpServerChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public InetSocketAddress localAddress() {
        return (InetSocketAddress) super.localAddress();
    }

    @Override // io.netty.channel.sctp.SctpServerChannel
    public ChannelFuture unbindAddress(final InetAddress inetAddress, final ChannelPromise channelPromise) {
        if (eventLoop().inEventLoop()) {
            try {
                this.sch.unbindAddress(inetAddress);
                channelPromise.setSuccess();
            } catch (Throwable th) {
                channelPromise.setFailure(th);
            }
        } else {
            eventLoop().execute(new Runnable() { // from class: io.netty.channel.sctp.oio.OioSctpServerChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    OioSctpServerChannel.this.unbindAddress(inetAddress, channelPromise);
                }
            });
        }
        return channelPromise;
    }
}
