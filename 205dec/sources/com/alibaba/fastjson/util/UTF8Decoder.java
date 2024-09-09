package com.alibaba.fastjson.util;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class UTF8Decoder extends CharsetDecoder {
    private static final Charset charset = Charset.forName("UTF-8");

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class Surrogate {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public static final int UCS4_MAX = 1114111;
        public static final int UCS4_MIN = 65536;

        private Surrogate() {
        }

        public static char high(int i4) {
            return (char) ((((i4 - 65536) >> 10) & 1023) | 55296);
        }

        public static char low(int i4) {
            return (char) (((i4 - 65536) & 1023) | 56320);
        }

        public static boolean neededFor(int i4) {
            return i4 >= 65536 && i4 <= 1114111;
        }
    }

    public UTF8Decoder() {
        super(charset, 1.0f, 1.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0093, code lost:
        return xflow(r13, r5, r6, r14, r8, 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ca, code lost:
        return xflow(r13, r5, r6, r14, r8, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0123, code lost:
        return xflow(r13, r5, r6, r14, r8, 4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.nio.charset.CoderResult decodeArrayLoop(java.nio.ByteBuffer r13, java.nio.CharBuffer r14) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.UTF8Decoder.decodeArrayLoop(java.nio.ByteBuffer, java.nio.CharBuffer):java.nio.charset.CoderResult");
    }

    private static boolean isMalformed2(int i4, int i5) {
        return (i4 & 30) == 0 || (i5 & 192) != 128;
    }

    private static boolean isMalformed3(int i4, int i5, int i6) {
        return ((i4 != -32 || (i5 & 224) != 128) && (i5 & 192) == 128 && (i6 & 192) == 128) ? false : true;
    }

    private static boolean isMalformed4(int i4, int i5, int i6) {
        return ((i4 & 192) == 128 && (i5 & 192) == 128 && (i6 & 192) == 128) ? false : true;
    }

    private static boolean isNotContinuation(int i4) {
        return (i4 & 192) != 128;
    }

    private static CoderResult lookupN(ByteBuffer byteBuffer, int i4) {
        for (int i5 = 1; i5 < i4; i5++) {
            if (isNotContinuation(byteBuffer.get())) {
                return CoderResult.malformedForLength(i5);
            }
        }
        return CoderResult.malformedForLength(i4);
    }

    private static CoderResult malformed(ByteBuffer byteBuffer, int i4, CharBuffer charBuffer, int i5, int i6) {
        byteBuffer.position(i4 - byteBuffer.arrayOffset());
        CoderResult malformedN = malformedN(byteBuffer, i6);
        updatePositions(byteBuffer, i4, charBuffer, i5);
        return malformedN;
    }

    public static CoderResult malformedN(ByteBuffer byteBuffer, int i4) {
        int i5 = 1;
        if (i4 == 1) {
            byte b4 = byteBuffer.get();
            if ((b4 >> 2) == -2) {
                return byteBuffer.remaining() < 4 ? CoderResult.UNDERFLOW : lookupN(byteBuffer, 5);
            } else if ((b4 >> 1) == -2) {
                if (byteBuffer.remaining() < 5) {
                    return CoderResult.UNDERFLOW;
                }
                return lookupN(byteBuffer, 6);
            } else {
                return CoderResult.malformedForLength(1);
            }
        } else if (i4 != 2) {
            if (i4 == 3) {
                byte b5 = byteBuffer.get();
                byte b6 = byteBuffer.get();
                if ((b5 != -32 || (b6 & 224) != 128) && !isNotContinuation(b6)) {
                    i5 = 2;
                }
                return CoderResult.malformedForLength(i5);
            } else if (i4 == 4) {
                int i6 = byteBuffer.get() & 255;
                int i7 = byteBuffer.get() & 255;
                if (i6 > 244 || ((i6 == 240 && (i7 < 144 || i7 > 191)) || ((i6 == 244 && (i7 & 240) != 128) || isNotContinuation(i7)))) {
                    return CoderResult.malformedForLength(1);
                }
                return isNotContinuation(byteBuffer.get()) ? CoderResult.malformedForLength(2) : CoderResult.malformedForLength(3);
            } else {
                throw new IllegalStateException();
            }
        } else {
            return CoderResult.malformedForLength(1);
        }
    }

    static void updatePositions(Buffer buffer, int i4, Buffer buffer2, int i5) {
        buffer.position(i4);
        buffer2.position(i5);
    }

    private static CoderResult xflow(Buffer buffer, int i4, int i5, Buffer buffer2, int i6, int i7) {
        updatePositions(buffer, i4, buffer2, i6);
        return (i7 == 0 || i5 - i4 < i7) ? CoderResult.UNDERFLOW : CoderResult.OVERFLOW;
    }

    @Override // java.nio.charset.CharsetDecoder
    protected CoderResult decodeLoop(ByteBuffer byteBuffer, CharBuffer charBuffer) {
        return decodeArrayLoop(byteBuffer, charBuffer);
    }
}
