package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.base64.Base64;
import io.netty.handler.codec.base64.Base64Dialect;
import io.netty.util.NetUtil;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLHandshakeException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class SslUtils {
    static final String[] DEFAULT_CIPHER_SUITES;
    static final String[] DEFAULT_TLSV13_CIPHER_SUITES;
    static final String INVALID_CIPHER = "SSL_NULL_WITH_NULL_NULL";
    static final int NOT_ENCRYPTED = -2;
    static final int NOT_ENOUGH_DATA = -1;
    static final String PROTOCOL_SSL_V2 = "SSLv2";
    static final String PROTOCOL_SSL_V2_HELLO = "SSLv2Hello";
    static final String PROTOCOL_SSL_V3 = "SSLv3";
    static final String PROTOCOL_TLS_V1 = "TLSv1";
    static final String PROTOCOL_TLS_V1_1 = "TLSv1.1";
    static final String PROTOCOL_TLS_V1_2 = "TLSv1.2";
    static final String PROTOCOL_TLS_V1_3 = "TLSv1.3";
    static final int SSL_CONTENT_TYPE_ALERT = 21;
    static final int SSL_CONTENT_TYPE_APPLICATION_DATA = 23;
    static final int SSL_CONTENT_TYPE_CHANGE_CIPHER_SPEC = 20;
    static final int SSL_CONTENT_TYPE_EXTENSION_HEARTBEAT = 24;
    static final int SSL_CONTENT_TYPE_HANDSHAKE = 22;
    static final int SSL_RECORD_HEADER_LENGTH = 5;
    static final Set<String> TLSV13_CIPHERS = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList("TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_AES_128_GCM_SHA256", "TLS_AES_128_CCM_8_SHA256", "TLS_AES_128_CCM_SHA256")));
    static final String[] TLSV13_CIPHER_SUITES;

    static {
        String[] strArr = {"TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384"};
        TLSV13_CIPHER_SUITES = strArr;
        if (PlatformDependent.javaVersion() >= 11) {
            DEFAULT_TLSV13_CIPHER_SUITES = strArr;
        } else {
            DEFAULT_TLSV13_CIPHER_SUITES = EmptyArrays.EMPTY_STRINGS;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        arrayList.add("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        arrayList.add("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        arrayList.add("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        arrayList.add("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        arrayList.add("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        arrayList.add("TLS_RSA_WITH_AES_128_GCM_SHA256");
        arrayList.add("TLS_RSA_WITH_AES_128_CBC_SHA");
        arrayList.add("TLS_RSA_WITH_AES_256_CBC_SHA");
        Collections.addAll(arrayList, DEFAULT_TLSV13_CIPHER_SUITES);
        DEFAULT_CIPHER_SUITES = (String[]) arrayList.toArray(new String[0]);
    }

    private SslUtils() {
    }

    static void addIfSupported(Set<String> set, List<String> list, String... strArr) {
        for (String str : strArr) {
            if (set.contains(str)) {
                list.add(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0028  */
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
                case 24: goto Lb;
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
            int r4 = unsignedShortBE(r6, r4)
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
            if (r2 != 0) goto L58
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
            if (r1 == r2) goto L42
            if (r1 != r3) goto L40
            goto L42
        L40:
            r6 = -2
            return r6
        L42:
            if (r0 != r2) goto L4c
            short r6 = shortBE(r6, r7)
            r6 = r6 & 32767(0x7fff, float:4.5916E-41)
            int r6 = r6 + r2
            goto L53
        L4c:
            short r6 = shortBE(r6, r7)
            r6 = r6 & 16383(0x3fff, float:2.2957E-41)
            int r6 = r6 + r3
        L53:
            r4 = r6
            if (r4 > r0) goto L58
            r6 = -1
            return r6
        L58:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslUtils.getEncryptedPacketLength(io.netty.buffer.ByteBuf, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void handleHandshakeFailure(ChannelHandlerContext channelHandlerContext, Throwable th, boolean z3) {
        channelHandlerContext.flush();
        if (z3) {
            channelHandlerContext.fireUserEventTriggered((Object) new SslHandshakeCompletionEvent(th));
        }
        channelHandlerContext.close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isTLSv13Cipher(String str) {
        return TLSV13_CIPHERS.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isValidHostNameForSNI(String str) {
        return (str == null || str.indexOf(46) <= 0 || str.endsWith(".") || NetUtil.isValidIpV4Address(str) || NetUtil.isValidIpV6Address(str)) ? false : true;
    }

    private static short shortBE(ByteBuf byteBuf, int i4) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.getShort(i4) : byteBuf.getShortLE(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuf toBase64(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf) {
        ByteBuf encode = Base64.encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), true, Base64Dialect.STANDARD, byteBufAllocator);
        byteBuf.readerIndex(byteBuf.writerIndex());
        return encode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SSLHandshakeException toSSLHandshakeException(Throwable th) {
        if (th instanceof SSLHandshakeException) {
            return (SSLHandshakeException) th;
        }
        return (SSLHandshakeException) new SSLHandshakeException(th.getMessage()).initCause(th);
    }

    private static short unsignedByte(byte b4) {
        return (short) (b4 & 255);
    }

    private static int unsignedShortBE(ByteBuf byteBuf, int i4) {
        return byteBuf.order() == ByteOrder.BIG_ENDIAN ? byteBuf.getUnsignedShort(i4) : byteBuf.getUnsignedShortLE(i4);
    }

    static void useFallbackCiphersIfDefaultIsEmpty(List<String> list, Iterable<String> iterable) {
        if (list.isEmpty()) {
            for (String str : iterable) {
                if (!str.startsWith("SSL_") && !str.contains("_RC4_")) {
                    list.add(str);
                }
            }
        }
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

    private static short shortBE(ByteBuffer byteBuffer, int i4) {
        return byteBuffer.order() == ByteOrder.BIG_ENDIAN ? byteBuffer.getShort(i4) : ByteBufUtil.swapShort(byteBuffer.getShort(i4));
    }

    private static int unsignedShortBE(ByteBuffer byteBuffer, int i4) {
        return shortBE(byteBuffer, i4) & 65535;
    }

    static void useFallbackCiphersIfDefaultIsEmpty(List<String> list, String... strArr) {
        useFallbackCiphersIfDefaultIsEmpty(list, Arrays.asList(strArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getEncryptedPacketLength(ByteBuffer[] byteBufferArr, int i4) {
        ByteBuffer byteBuffer = byteBufferArr[i4];
        if (byteBuffer.remaining() >= 5) {
            return getEncryptedPacketLength(byteBuffer);
        }
        ByteBuffer allocate = ByteBuffer.allocate(5);
        while (true) {
            int i5 = i4 + 1;
            ByteBuffer duplicate = byteBufferArr[i4].duplicate();
            if (duplicate.remaining() > allocate.remaining()) {
                duplicate.limit(duplicate.position() + allocate.remaining());
            }
            allocate.put(duplicate);
            if (!allocate.hasRemaining()) {
                allocate.flip();
                return getEncryptedPacketLength(allocate);
            }
            i4 = i5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int getEncryptedPacketLength(java.nio.ByteBuffer r7) {
        /*
            int r0 = r7.position()
            byte r1 = r7.get(r0)
            short r1 = unsignedByte(r1)
            r2 = 1
            r3 = 0
            switch(r1) {
                case 20: goto L13;
                case 21: goto L13;
                case 22: goto L13;
                case 23: goto L13;
                case 24: goto L13;
                default: goto L11;
            }
        L11:
            r1 = 0
            goto L14
        L13:
            r1 = 1
        L14:
            r4 = 3
            if (r1 == 0) goto L30
            int r5 = r0 + 1
            byte r5 = r7.get(r5)
            short r5 = unsignedByte(r5)
            if (r5 != r4) goto L31
            int r5 = r0 + 3
            int r5 = unsignedShortBE(r7, r5)
            r6 = 5
            int r5 = r5 + r6
            if (r5 > r6) goto L2e
            goto L32
        L2e:
            r3 = r1
            goto L32
        L30:
            r3 = r1
        L31:
            r5 = 0
        L32:
            if (r3 != 0) goto L6c
            byte r1 = r7.get(r0)
            short r1 = unsignedByte(r1)
            r1 = r1 & 128(0x80, float:1.8E-43)
            r3 = 2
            if (r1 == 0) goto L43
            r1 = 2
            goto L44
        L43:
            r1 = 3
        L44:
            int r5 = r0 + r1
            int r5 = r5 + r2
            byte r2 = r7.get(r5)
            short r2 = unsignedByte(r2)
            if (r2 == r3) goto L56
            if (r2 != r4) goto L54
            goto L56
        L54:
            r7 = -2
            return r7
        L56:
            if (r1 != r3) goto L60
            short r7 = shortBE(r7, r0)
            r7 = r7 & 32767(0x7fff, float:4.5916E-41)
            int r7 = r7 + r3
            goto L67
        L60:
            short r7 = shortBE(r7, r0)
            r7 = r7 & 16383(0x3fff, float:2.2957E-41)
            int r7 = r7 + r4
        L67:
            r5 = r7
            if (r5 > r1) goto L6c
            r7 = -1
            return r7
        L6c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.ssl.SslUtils.getEncryptedPacketLength(java.nio.ByteBuffer):int");
    }
}
