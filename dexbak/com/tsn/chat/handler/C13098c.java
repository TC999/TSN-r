package com.tsn.chat.handler;

import com.tsn.chat.model.RequestMessage;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.PrintStream;

/* compiled from: Encoder.java */
/* renamed from: com.tsn.chat.handler.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13098c extends MessageToByteEncoder<Object> {
    /* renamed from: a */
    public static byte[] m14867a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    @Override // io.netty.handler.codec.MessageToByteEncoder
    protected void encode(ChannelHandlerContext channelHandlerContext, Object obj, ByteBuf byteBuf) throws Exception {
        RequestMessage requestMessage = (RequestMessage) obj;
        PrintStream printStream = System.out;
        printStream.println("发送的消息:" + requestMessage.toString());
        byteBuf.writeByte(requestMessage.getHeader());
        byteBuf.writeShort(requestMessage.getLength());
        byteBuf.writeByte(requestMessage.getControlType());
        byteBuf.writeBytes(requestMessage.getDatas().getBytes());
        byteBuf.writeShort(0);
    }
}
