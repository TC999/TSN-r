package com.tsn.chat.handler;

import com.tsn.chat.model.ResponseMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import java.io.PrintStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ClientHandler.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends ChannelInboundHandlerAdapter {
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelActive(ChannelHandlerContext channelHandlerContext) throws Exception {
        com.tsn.chat.utils.b.f52413k = 1;
        com.tsn.chat.utils.b.f52403a.add(channelHandlerContext.channel());
        y0.a.a().h();
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
            printStream.println("\u63a5\u53d7\u5230\u6d88\u606f:" + responseMessage.toString());
            z0.a.a(responseMessage);
        }
        byte[] bArr3 = new byte[readableBytes];
        byteBuf.resetReaderIndex();
        for (int i4 = 0; i4 < readableBytes; i4++) {
            bArr3[i4] = byteBuf.readByte();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th) {
        PrintStream printStream = System.out;
        printStream.println("exceptionCaught:" + th.getMessage());
        com.tsn.chat.utils.b.f52404b = "";
        if (com.tsn.chat.utils.b.f52403a.size() > 0) {
            com.tsn.chat.utils.b.f52403a.close();
            com.tsn.chat.utils.b.f52403a.clear();
        }
        channelHandlerContext.close();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) {
        System.out.println("handlerRemoved(\u94fe\u63a5\u5173\u95ed)");
        com.tsn.chat.utils.b.f52404b = "";
        if (com.tsn.chat.utils.b.f52403a.size() > 0) {
            com.tsn.chat.utils.b.f52403a.close();
            com.tsn.chat.utils.b.f52403a.clear();
        }
        y0.a.a().b();
    }
}
