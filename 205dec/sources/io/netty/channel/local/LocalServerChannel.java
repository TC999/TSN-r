package io.netty.channel.local;

import io.netty.channel.AbstractServerChannel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.DefaultChannelConfig;
import io.netty.channel.EventLoop;
import io.netty.channel.SingleThreadEventLoop;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import java.net.SocketAddress;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class LocalServerChannel extends AbstractServerChannel {
    private volatile boolean acceptInProgress;
    private volatile LocalAddress localAddress;
    private volatile int state;
    private final ChannelConfig config = new DefaultChannelConfig(this);
    private final Queue<Object> inboundBuffer = new ArrayDeque();
    private final Runnable shutdownHook = new Runnable() { // from class: io.netty.channel.local.LocalServerChannel.1
        @Override // java.lang.Runnable
        public void run() {
            LocalServerChannel.this.unsafe().close(LocalServerChannel.this.unsafe().voidPromise());
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void serve0(LocalChannel localChannel) {
        this.inboundBuffer.add(localChannel);
        if (!this.acceptInProgress) {
            return;
        }
        this.acceptInProgress = false;
        ChannelPipeline pipeline = pipeline();
        while (true) {
            Object poll = this.inboundBuffer.poll();
            if (poll == null) {
                pipeline.fireChannelReadComplete();
                return;
            }
            pipeline.fireChannelRead(poll);
        }
    }

    @Override // io.netty.channel.Channel
    public ChannelConfig config() {
        return this.config;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBeginRead() throws Exception {
        if (this.acceptInProgress) {
            return;
        }
        Queue<Object> queue = this.inboundBuffer;
        if (queue.isEmpty()) {
            this.acceptInProgress = true;
            return;
        }
        ChannelPipeline pipeline = pipeline();
        while (true) {
            Object poll = queue.poll();
            if (poll == null) {
                pipeline.fireChannelReadComplete();
                return;
            }
            pipeline.fireChannelRead(poll);
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doBind(SocketAddress socketAddress) throws Exception {
        this.localAddress = LocalChannelRegistry.register(this, this.localAddress, socketAddress);
        this.state = 1;
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doClose() throws Exception {
        if (this.state <= 1) {
            if (this.localAddress != null) {
                LocalChannelRegistry.unregister(this.localAddress);
                this.localAddress = null;
            }
            this.state = 2;
        }
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doDeregister() throws Exception {
        ((SingleThreadEventExecutor) eventLoop()).removeShutdownHook(this.shutdownHook);
    }

    @Override // io.netty.channel.AbstractChannel
    protected void doRegister() throws Exception {
        ((SingleThreadEventExecutor) eventLoop()).addShutdownHook(this.shutdownHook);
    }

    @Override // io.netty.channel.Channel
    public boolean isActive() {
        return this.state == 1;
    }

    @Override // io.netty.channel.AbstractChannel
    protected boolean isCompatible(EventLoop eventLoop) {
        return eventLoop instanceof SingleThreadEventLoop;
    }

    @Override // io.netty.channel.Channel
    public boolean isOpen() {
        return this.state < 2;
    }

    @Override // io.netty.channel.AbstractChannel
    protected SocketAddress localAddress0() {
        return this.localAddress;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocalChannel serve(LocalChannel localChannel) {
        final LocalChannel localChannel2 = new LocalChannel(this, localChannel);
        if (eventLoop().inEventLoop()) {
            serve0(localChannel2);
        } else {
            eventLoop().execute(new Runnable() { // from class: io.netty.channel.local.LocalServerChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    LocalServerChannel.this.serve0(localChannel2);
                }
            });
        }
        return localChannel2;
    }

    @Override // io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public LocalAddress localAddress() {
        return (LocalAddress) super.localAddress();
    }

    @Override // io.netty.channel.AbstractServerChannel, io.netty.channel.AbstractChannel, io.netty.channel.Channel
    public LocalAddress remoteAddress() {
        return (LocalAddress) super.remoteAddress();
    }
}
