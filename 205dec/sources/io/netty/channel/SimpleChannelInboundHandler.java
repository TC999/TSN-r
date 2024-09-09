package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class SimpleChannelInboundHandler<I> extends ChannelInboundHandlerAdapter {
    private final boolean autoRelease;
    private final TypeParameterMatcher matcher;

    /* JADX INFO: Access modifiers changed from: protected */
    public SimpleChannelInboundHandler() {
        this(true);
    }

    public boolean acceptInboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        boolean z3 = true;
        try {
            if (acceptInboundMessage(obj)) {
                channelRead0(channelHandlerContext, obj);
            } else {
                z3 = false;
                channelHandlerContext.fireChannelRead(obj);
            }
        } finally {
            if (this.autoRelease && 1 != 0) {
                ReferenceCountUtil.release(obj);
            }
        }
    }

    protected abstract void channelRead0(ChannelHandlerContext channelHandlerContext, I i4) throws Exception;

    protected SimpleChannelInboundHandler(boolean z3) {
        this.matcher = TypeParameterMatcher.find(this, SimpleChannelInboundHandler.class, "I");
        this.autoRelease = z3;
    }

    protected SimpleChannelInboundHandler(Class<? extends I> cls) {
        this(cls, true);
    }

    protected SimpleChannelInboundHandler(Class<? extends I> cls, boolean z3) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.autoRelease = z3;
    }
}
