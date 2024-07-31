package com.tsn.chat.handler;

import com.tsn.chat.model.ResponseMessage;
import com.tsn.chat.utils.Global;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.io.PrintStream;
import p660y0.BaseApplication;
import p663z0.HandlerProcessing;

/* renamed from: com.tsn.chat.handler.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        Global.f37515k = 1;
        Global.f37505a.add(channelHandlerContext.channel());
        BaseApplication.m38a().mo34h();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) {
        ByteBuf byteBuf = (ByteBuf) obj;
        int readableBytes = byteBuf.readableBytes();
        byte[] bArr = new byte[readableBytes];
        if (readableBytes >= 4) {
            byteBuf.readByte();
            short readShort = byteBuf.readShort();
            byte readByte = byteBuf.readByte();
            byte[] bArr2 = new byte[readShort - 6];
            byteBuf.readBytes(bArr2);
            byteBuf.readBytes(new byte[2]);
            ResponseMessage responseMessage = new ResponseMessage(readByte, new String(bArr2));
            PrintStream printStream = System.out;
            printStream.println("接受到消息:" + responseMessage.toString());
            HandlerProcessing.m8a(responseMessage);
        }
        byte[] bArr3 = new byte[readableBytes];
        byteBuf.resetReaderIndex();
        for (int i = 0; i < readableBytes; i++) {
            bArr3[i] = byteBuf.readByte();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        PrintStream printStream = System.out;
        printStream.println("exceptionCaught:" + th.getMessage());
        Global.f37506b = "";
        if (Global.f37505a.size() > 0) {
            Global.f37505a.close();
            Global.f37505a.clear();
        }
        channelHandlerContext.close();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        System.out.println("handlerRemoved(链接关闭)");
        Global.f37506b = "";
        if (Global.f37505a.size() > 0) {
            Global.f37505a.close();
            Global.f37505a.clear();
        }
        BaseApplication.m38a().mo27b();
    }
}
