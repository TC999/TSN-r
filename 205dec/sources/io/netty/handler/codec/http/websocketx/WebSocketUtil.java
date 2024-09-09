package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.base64.Base64;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.FastThreadLocal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class WebSocketUtil {
    private static final FastThreadLocal<MessageDigest> MD5 = new FastThreadLocal<MessageDigest>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketUtil.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public MessageDigest initialValue() throws Exception {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
                throw new InternalError("MD5 not supported on this platform - Outdated?");
            }
        }
    };
    private static final FastThreadLocal<MessageDigest> SHA1 = new FastThreadLocal<MessageDigest>() { // from class: io.netty.handler.codec.http.websocketx.WebSocketUtil.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.netty.util.concurrent.FastThreadLocal
        public MessageDigest initialValue() throws Exception {
            try {
                return MessageDigest.getInstance("SHA1");
            } catch (NoSuchAlgorithmException unused) {
                throw new InternalError("SHA-1 not supported on this platform - Outdated?");
            }
        }
    };

    private WebSocketUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String base64(byte[] bArr) {
        ByteBuf encode = Base64.encode(Unpooled.wrappedBuffer(bArr));
        String byteBuf = encode.toString(CharsetUtil.UTF_8);
        encode.release();
        return byteBuf;
    }

    private static byte[] digest(FastThreadLocal<MessageDigest> fastThreadLocal, byte[] bArr) {
        MessageDigest messageDigest = fastThreadLocal.get();
        messageDigest.reset();
        return messageDigest.digest(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] md5(byte[] bArr) {
        return digest(MD5, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] randomBytes(int i4) {
        byte[] bArr = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[i5] = (byte) randomNumber(0, 255);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int randomNumber(int i4, int i5) {
        double random = Math.random();
        double d4 = i5;
        Double.isNaN(d4);
        double d5 = i4;
        Double.isNaN(d5);
        return (int) ((random * d4) + d5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] sha1(byte[] bArr) {
        return digest(SHA1, bArr);
    }
}
