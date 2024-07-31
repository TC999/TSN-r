package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SslUtils {
    public static final int SSL_CONTENT_TYPE_ALERT = 21;
    public static final int SSL_CONTENT_TYPE_APPLICATION_DATA = 23;
    public static final int SSL_CONTENT_TYPE_CHANGE_CIPHER_SPEC = 20;
    public static final int SSL_CONTENT_TYPE_HANDSHAKE = 22;
    public static final int SSL_RECORD_HEADER_LENGTH = 5;

    private SslUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getEncryptedPacketLength(io.netty.buffer.ByteBuf r6, int r7) {
        /*
            short r0 = r6.getUnsignedByte(r7)
            r1 = 1
            r2 = 0
            switch(r0) {
                case 20: goto Lb;
                case 21: goto Lb;
                case 22: goto Lb;
                case 23: goto Lb;
                default: goto L9;
            }
        L9:
            r0 = 0
            goto Lc
        Lb:
            r0 = 1
        Lc:
            r3 = 3
            if (r0 == 0) goto L24
            int r4 = r7 + 1
            short r4 = r6.getUnsignedByte(r4)
            if (r4 != r3) goto L25
            int r4 = r7 + 3
            int r4 = r6.getUnsignedShort(r4)
            r5 = 5
            int r4 = r4 + r5
            if (r4 > r5) goto L22
            goto L26
        L22:
            r2 = r0
            goto L26
        L24:
            r2 = r0
        L25:
            r4 = 0
        L26:
            if (r2 != 0) goto L57
            short r0 = r6.getUnsignedByte(r7)
            r0 = r0 & 128(0x80, float:1.8E-43)
            r2 = 2
            if (r0 == 0) goto L33
            r0 = 2
            goto L34
        L33:
            r0 = 3
        L34:
            int r4 = r7 + r0
            int r4 = r4 + r1
            short r1 = r6.getUnsignedByte(r4)
            r4 = -1
            if (r1 == r2) goto L42
            if (r1 != r3) goto L41
            goto L42
        L41:
            return r4
        L42:
            if (r0 != r2) goto L4c
            short r6 = r6.getShort(r7)
            r6 = r6 & 32767(0x7fff, float:4.5916E-41)
            int r6 = r6 + r2
            goto L53
        L4c:
            short r6 = r6.getShort(r7)
            r6 = r6 & 16383(0x3fff, float:2.2957E-41)
            int r6 = r6 + r3
        L53:
            if (r6 > r0) goto L56
            return r4
        L56:
            r4 = r6
        L57:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslUtils.getEncryptedPacketLength(io.netty.buffer.ByteBuf, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void notifyHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th) {
        channelHandlerContext.flush();
        channelHandlerContext.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(th));
        channelHandlerContext.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuf toBase64(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        ByteBuf encode = Base64.encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), true, Base64Dialect.STANDARD, byteBufAllocator);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return encode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zeroout(ByteBuf byteBuf) {
        if (byteBuf.isReadOnly()) {
            return;
        }
        byteBuf.setZero(0, byteBuf.capacity());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zerooutAndRelease(ByteBuf byteBuf) {
        zeroout(byteBuf);
        byteBuf.release();
    }
}
