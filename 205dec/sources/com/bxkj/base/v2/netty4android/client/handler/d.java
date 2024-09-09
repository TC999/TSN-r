package com.bxkj.base.v2.netty4android.client.handler;

import com.orhanobut.logger.j;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NettyClientHandler.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001c\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0014J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/handler/d;", "Lio/netty/channel/SimpleChannelInboundHandler;", "Lcom/bxkj/base/v2/netty4android/client/command/a;", "Lio/netty/channel/ChannelHandlerContext;", "ctx", "", "evt", "Lkotlin/f1;", "userEventTriggered", "channelActive", "channelInactive", "channelHandlerContext", "msg", "a", "", "cause", "exceptionCaught", "", "b", "I", "index", "", "c", "Z", "isSendheartBeat", "d", "Ljava/lang/Object;", "heartBeatData", "Lk/b;", "listener", "<init>", "(Lk/b;IZLjava/lang/Object;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public final class d extends SimpleChannelInboundHandler<com.bxkj.base.v2.netty4android.client.command.a> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final k.b<com.bxkj.base.v2.netty4android.client.command.a> f18774a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18775b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f18776c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Object f18777d;

    public d(@Nullable k.b<com.bxkj.base.v2.netty4android.client.command.a> bVar, int i4, boolean z3, @Nullable Object obj) {
        this.f18774a = bVar;
        this.f18775b = i4;
        this.f18776c = z3;
        this.f18777d = obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.SimpleChannelInboundHandler
    /* renamed from: a */
    public void channelRead0(@NotNull ChannelHandlerContext channelHandlerContext, @NotNull com.bxkj.base.v2.netty4android.client.command.a msg) {
        f0.p(channelHandlerContext, "channelHandlerContext");
        f0.p(msg, "msg");
        msg.d("\u670d\u52a1\u5668\u54cd\u5e94\u6570\u636e\uff1a");
        k.b<com.bxkj.base.v2.netty4android.client.command.a> bVar = this.f18774a;
        if (bVar == null) {
            return;
        }
        bVar.a(msg, this.f18775b);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(@NotNull ChannelHandlerContext ctx) {
        f0.p(ctx, "ctx");
        j.d("\u5ba2\u6237\u7aef\u4e0a\u7ebf", new Object[0]);
        k.b<com.bxkj.base.v2.netty4android.client.command.a> bVar = this.f18774a;
        if (bVar == null) {
            return;
        }
        bVar.c(1, this.f18775b);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(@NotNull ChannelHandlerContext ctx) {
        f0.p(ctx, "ctx");
        j.d("\u5ba2\u6237\u7aef\u4e0b\u7ebf", new Object[0]);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(@NotNull ChannelHandlerContext ctx, @NotNull Throwable cause) {
        f0.p(ctx, "ctx");
        f0.p(cause, "cause");
        j.e("exceptionCaught", new Object[0]);
        k.b<com.bxkj.base.v2.netty4android.client.command.a> bVar = this.f18774a;
        if (bVar != null) {
            bVar.c(-1, this.f18775b);
        }
        cause.printStackTrace();
        ctx.close();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(@NotNull ChannelHandlerContext ctx, @NotNull Object evt) {
        f0.p(ctx, "ctx");
        f0.p(evt, "evt");
        if ((evt instanceof IdleStateEvent) && ((IdleStateEvent) evt).state() == IdleState.WRITER_IDLE) {
            if (this.f18776c) {
                Object obj = this.f18777d;
                if (obj == null) {
                    Channel channel = ctx.channel();
                    String property = System.getProperty("line.separator");
                    f0.m(property);
                    channel.writeAndFlush(f0.C("Heartbeat", property));
                    return;
                } else if (obj instanceof String) {
                    Channel channel2 = ctx.channel();
                    String property2 = System.getProperty("line.separator");
                    f0.m(property2);
                    channel2.writeAndFlush(f0.C((String) this.f18777d, property2));
                    return;
                } else if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    f0.m(bArr);
                    ctx.channel().writeAndFlush(Unpooled.copiedBuffer(bArr));
                    return;
                } else if (obj instanceof com.bxkj.base.v2.netty4android.client.command.a) {
                    ctx.writeAndFlush(obj);
                    return;
                } else {
                    j.d("userEventTriggered: heartBeatData type error", new Object[0]);
                    return;
                }
            }
            j.d("\u4e0d\u53d1\u9001\u5fc3\u8df3", new Object[0]);
        }
    }
}
