package io.netty.handler.codec.base64;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteOrder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Base64 {
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    private static final byte WHITE_SPACE_ENC = -5;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class Decoder implements ByteProcessor {
        private final byte[] b4;
        private int b4Posn;
        private byte[] decodabet;
        private ByteBuf dest;
        private int outBuffPosn;
        private byte sbiCrop;
        private byte sbiDecode;

        private Decoder() {
            this.b4 = new byte[4];
        }

        private static int decode4to3(byte[] bArr, ByteBuf byteBuf, int i4, byte[] bArr2) {
            int i5;
            int i6;
            int i7;
            byte b4 = bArr[0];
            byte b5 = bArr[1];
            byte b6 = bArr[2];
            if (b6 == 61) {
                try {
                    byteBuf.setByte(i4, ((bArr2[b4] & 255) << 2) | ((bArr2[b5] & 255) >>> 4));
                    return 1;
                } catch (IndexOutOfBoundsException unused) {
                    throw new IllegalArgumentException("not encoded in Base64");
                }
            }
            byte b7 = bArr[3];
            if (b7 == 61) {
                byte b8 = bArr2[b5];
                try {
                    if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                        i7 = ((b8 & 15) << 4) | ((((bArr2[b4] & 63) << 2) | ((b8 & 240) >> 4)) << 8) | ((bArr2[b6] & 252) >>> 2);
                    } else {
                        i7 = ((((b8 & 15) << 4) | ((bArr2[b6] & 252) >>> 2)) << 8) | ((bArr2[b4] & 63) << 2) | ((b8 & 240) >> 4);
                    }
                    byteBuf.setShort(i4, i7);
                    return 2;
                } catch (IndexOutOfBoundsException unused2) {
                    throw new IllegalArgumentException("not encoded in Base64");
                }
            }
            try {
                if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
                    i5 = ((bArr2[b4] & 63) << 18) | ((bArr2[b5] & 255) << 12) | ((bArr2[b6] & 255) << 6);
                    i6 = bArr2[b7] & 255;
                } else {
                    byte b9 = bArr2[b5];
                    byte b10 = bArr2[b6];
                    i5 = ((bArr2[b4] & 63) << 2) | ((b9 & 15) << 12) | ((b9 & 240) >>> 4) | ((b10 & 3) << 22) | ((b10 & 252) << 6);
                    i6 = (bArr2[b7] & 255) << 16;
                }
                byteBuf.setMedium(i4, i6 | i5);
                return 3;
            } catch (IndexOutOfBoundsException unused3) {
                throw new IllegalArgumentException("not encoded in Base64");
            }
        }

        ByteBuf decode(ByteBuf byteBuf, int i4, int i5, ByteBufAllocator byteBufAllocator, Base64Dialect base64Dialect) {
            this.dest = byteBufAllocator.buffer(Base64.decodedBufferSize(i5)).order(byteBuf.order());
            this.decodabet = Base64.access$100(base64Dialect);
            try {
                byteBuf.forEachByte(i4, i5, this);
                return this.dest.slice(0, this.outBuffPosn);
            } catch (Throwable th) {
                this.dest.release();
                PlatformDependent.throwException(th);
                return null;
            }
        }

        @Override // io.netty.util.ByteProcessor
        public boolean process(byte b4) throws Exception {
            byte b5 = (byte) (b4 & Byte.MAX_VALUE);
            this.sbiCrop = b5;
            byte[] bArr = this.decodabet;
            byte b6 = bArr[b5];
            this.sbiDecode = b6;
            if (b6 < -5) {
                throw new IllegalArgumentException("invalid bad Base64 input character: " + ((int) ((short) (b4 & 255))) + " (decimal)");
            } else if (b6 >= -1) {
                byte[] bArr2 = this.b4;
                int i4 = this.b4Posn;
                int i5 = i4 + 1;
                this.b4Posn = i5;
                bArr2[i4] = b5;
                if (i5 > 3) {
                    int i6 = this.outBuffPosn;
                    this.outBuffPosn = i6 + decode4to3(bArr2, this.dest, i6, bArr);
                    this.b4Posn = 0;
                    return this.sbiCrop != 61;
                }
                return true;
            } else {
                return true;
            }
        }
    }

    private Base64() {
    }

    private static byte[] alphabet(Base64Dialect base64Dialect) {
        if (base64Dialect != null) {
            return base64Dialect.alphabet;
        }
        throw new NullPointerException("dialect");
    }

    private static boolean breakLines(Base64Dialect base64Dialect) {
        if (base64Dialect != null) {
            return base64Dialect.breakLinesByDefault;
        }
        throw new NullPointerException("dialect");
    }

    private static byte[] decodabet(Base64Dialect base64Dialect) {
        if (base64Dialect != null) {
            return base64Dialect.decodabet;
        }
        throw new NullPointerException("dialect");
    }

    public static ByteBuf decode(ByteBuf byteBuf) {
        return decode(byteBuf, Base64Dialect.STANDARD);
    }

    private static int decode4to3(byte[] bArr, int i4, ByteBuf byteBuf, int i5, Base64Dialect base64Dialect) {
        byte[] decodabet = decodabet(base64Dialect);
        int i6 = i4 + 2;
        if (bArr[i6] == 61) {
            byteBuf.setByte(i5, (byte) ((((decodabet[bArr[i4 + 1]] & 255) << 12) | ((decodabet[bArr[i4]] & 255) << 18)) >>> 16));
            return 1;
        }
        int i7 = i4 + 3;
        if (bArr[i7] == 61) {
            int i8 = (decodabet[bArr[i4 + 1]] & 255) << 12;
            int i9 = ((decodabet[bArr[i6]] & 255) << 6) | i8 | ((decodabet[bArr[i4]] & 255) << 18);
            byteBuf.setByte(i5, (byte) (i9 >>> 16));
            byteBuf.setByte(i5 + 1, (byte) (i9 >>> 8));
            return 2;
        }
        try {
            int i10 = (decodabet[bArr[i7]] & 255) | ((decodabet[bArr[i4 + 1]] & 255) << 12) | ((decodabet[bArr[i4]] & 255) << 18) | ((decodabet[bArr[i6]] & 255) << 6);
            byteBuf.setByte(i5, (byte) (i10 >> 16));
            byteBuf.setByte(i5 + 1, (byte) (i10 >> 8));
            byteBuf.setByte(i5 + 2, (byte) i10);
            return 3;
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("not encoded in Base64");
        }
    }

    public static ByteBuf encode(ByteBuf byteBuf) {
        return encode(byteBuf, Base64Dialect.STANDARD);
    }

    private static void encode3to4(ByteBuf byteBuf, int i4, int i5, ByteBuf byteBuf2, int i6, Base64Dialect base64Dialect) {
        byte[] alphabet = alphabet(base64Dialect);
        int i7 = (i5 > 0 ? (byteBuf.getByte(i4) << 24) >>> 8 : 0) | (i5 > 1 ? (byteBuf.getByte(i4 + 1) << 24) >>> 16 : 0) | (i5 > 2 ? (byteBuf.getByte(i4 + 2) << 24) >>> 24 : 0);
        if (i5 == 1) {
            byteBuf2.setByte(i6, alphabet[i7 >>> 18]);
            byteBuf2.setByte(i6 + 1, alphabet[(i7 >>> 12) & 63]);
            byteBuf2.setByte(i6 + 2, 61);
            byteBuf2.setByte(i6 + 3, 61);
        } else if (i5 == 2) {
            byteBuf2.setByte(i6, alphabet[i7 >>> 18]);
            byteBuf2.setByte(i6 + 1, alphabet[(i7 >>> 12) & 63]);
            byteBuf2.setByte(i6 + 2, alphabet[(i7 >>> 6) & 63]);
            byteBuf2.setByte(i6 + 3, 61);
        } else if (i5 != 3) {
        } else {
            byteBuf2.setByte(i6, alphabet[i7 >>> 18]);
            byteBuf2.setByte(i6 + 1, alphabet[(i7 >>> 12) & 63]);
            byteBuf2.setByte(i6 + 2, alphabet[(i7 >>> 6) & 63]);
            byteBuf2.setByte(i6 + 3, alphabet[i7 & 63]);
        }
    }

    public static ByteBuf decode(ByteBuf byteBuf, Base64Dialect base64Dialect) {
        if (byteBuf != null) {
            ByteBuf decode = decode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), base64Dialect);
            byteBuf.readerIndex(byteBuf.writerIndex());
            return decode;
        }
        throw new NullPointerException("src");
    }

    public static ByteBuf encode(ByteBuf byteBuf, Base64Dialect base64Dialect) {
        return encode(byteBuf, breakLines(base64Dialect), base64Dialect);
    }

    public static ByteBuf encode(ByteBuf byteBuf, boolean z3) {
        return encode(byteBuf, z3, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, boolean z3, Base64Dialect base64Dialect) {
        if (byteBuf != null) {
            ByteBuf encode = encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), z3, base64Dialect);
            byteBuf.readerIndex(byteBuf.writerIndex());
            return encode;
        }
        throw new NullPointerException("src");
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i4, int i5) {
        return decode(byteBuf, i4, i5, Base64Dialect.STANDARD);
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i4, int i5, Base64Dialect base64Dialect) {
        return decode(byteBuf, i4, i5, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i4, int i5, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        if (byteBuf != null) {
            if (base64Dialect != null) {
                byte[] decodabet = decodabet(base64Dialect);
                ByteBuf order = byteBufAllocator.buffer((i5 * 3) / 4).order(byteBuf.order());
                byte[] bArr = new byte[4];
                int i6 = 0;
                int i7 = 0;
                for (int i8 = i4; i8 < i4 + i5; i8++) {
                    byte b4 = (byte) (byteBuf.getByte(i8) & Byte.MAX_VALUE);
                    byte b5 = decodabet[b4];
                    if (b5 < -5) {
                        throw new IllegalArgumentException("bad Base64 input character at " + i8 + ": " + ((int) byteBuf.getUnsignedByte(i8)) + " (decimal)");
                    }
                    if (b5 >= -1) {
                        int i9 = i6 + 1;
                        bArr[i6] = b4;
                        if (i9 > 3) {
                            i7 += decode4to3(bArr, 0, order, i7, base64Dialect);
                            if (b4 == 61) {
                                break;
                            }
                            i6 = 0;
                        } else {
                            i6 = i9;
                        }
                    }
                }
                return order.slice(0, i7);
            }
            throw new NullPointerException("dialect");
        }
        throw new NullPointerException("src");
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i4, int i5) {
        return encode(byteBuf, i4, i5, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i4, int i5, Base64Dialect base64Dialect) {
        return encode(byteBuf, i4, i5, breakLines(base64Dialect), base64Dialect);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i4, int i5, boolean z3) {
        return encode(byteBuf, i4, i5, z3, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i4, int i5, boolean z3, Base64Dialect base64Dialect) {
        return encode(byteBuf, i4, i5, z3, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i4, int i5, boolean z3, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        if (byteBuf != null) {
            if (base64Dialect != null) {
                int i6 = (i5 * 4) / 3;
                ByteBuf order = byteBufAllocator.buffer((i5 % 3 > 0 ? 4 : 0) + i6 + (z3 ? i6 / 76 : 0)).order(byteBuf.order());
                int i7 = i5 - 2;
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                while (i8 < i7) {
                    encode3to4(byteBuf, i8 + i4, 3, order, i9, base64Dialect);
                    i10 += 4;
                    if (z3 && i10 == 76) {
                        order.setByte(i9 + 4, 10);
                        i9++;
                        i10 = 0;
                    }
                    i8 += 3;
                    i9 += 4;
                }
                if (i8 < i5) {
                    encode3to4(byteBuf, i8 + i4, i5 - i8, order, i9, base64Dialect);
                    i9 += 4;
                }
                if (i9 > 1 && order.getByte(i9 - 1) == 10) {
                    i9--;
                }
                return order.slice(0, i9);
            }
            throw new NullPointerException("dialect");
        }
        throw new NullPointerException("src");
    }
}
