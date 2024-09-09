package com.tsn.chat.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: MyClientInitializer.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d extends ChannelInitializer<SocketChannel> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.channel.ChannelInitializer
    /* renamed from: a */
    public void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("encoder", new c());
        pipeline.addLast("decoder", new b());
        pipeline.addLast("handler", new a());
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        PrintStream printStream = System.out;
        printStream.println("---channelRead--- msg=" + obj);
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        System.out.println("---channelReadComplete---");
        super.channelReadComplete(channelHandlerContext);
    }
}
