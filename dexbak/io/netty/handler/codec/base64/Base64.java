package io.netty.handler.codec.base64;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import kotlin.jvm.internal.C14354n;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Base64 {
    private static final byte EQUALS_SIGN = 61;
    private static final byte EQUALS_SIGN_ENC = -1;
    private static final int MAX_LINE_LENGTH = 76;
    private static final byte NEW_LINE = 10;
    private static final byte WHITE_SPACE_ENC = -5;

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

    private static int decode4to3(byte[] bArr, int i, ByteBuf byteBuf, int i2, Base64Dialect base64Dialect) {
        byte[] decodabet = decodabet(base64Dialect);
        int i3 = i + 2;
        if (bArr[i3] == 61) {
            byteBuf.setByte(i2, (byte) ((((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i]] & 255) << 18)) >>> 16));
            return 1;
        }
        int i4 = i + 3;
        if (bArr[i4] == 61) {
            int i5 = (decodabet[bArr[i + 1]] & 255) << 12;
            int i6 = ((decodabet[bArr[i3]] & 255) << 6) | i5 | ((decodabet[bArr[i]] & 255) << 18);
            byteBuf.setByte(i2, (byte) (i6 >>> 16));
            byteBuf.setByte(i2 + 1, (byte) (i6 >>> 8));
            return 2;
        }
        try {
            int i7 = (decodabet[bArr[i4]] & 255) | ((decodabet[bArr[i + 1]] & 255) << 12) | ((decodabet[bArr[i]] & 255) << 18) | ((decodabet[bArr[i3]] & 255) << 6);
            byteBuf.setByte(i2, (byte) (i7 >> 16));
            byteBuf.setByte(i2 + 1, (byte) (i7 >> 8));
            byteBuf.setByte(i2 + 2, (byte) i7);
            return 3;
        } catch (IndexOutOfBoundsException unused) {
            throw new IllegalArgumentException("not encoded in Base64");
        }
    }

    public static ByteBuf encode(ByteBuf byteBuf) {
        return encode(byteBuf, Base64Dialect.STANDARD);
    }

    private static void encode3to4(ByteBuf byteBuf, int i, int i2, ByteBuf byteBuf2, int i3, Base64Dialect base64Dialect) {
        byte[] alphabet = alphabet(base64Dialect);
        int i4 = (i2 > 0 ? (byteBuf.getByte(i) << BinaryMemcacheOpcodes.FLUSHQ) >>> 8 : 0) | (i2 > 1 ? (byteBuf.getByte(i + 1) << BinaryMemcacheOpcodes.FLUSHQ) >>> 16 : 0) | (i2 > 2 ? (byteBuf.getByte(i + 2) << BinaryMemcacheOpcodes.FLUSHQ) >>> 24 : 0);
        if (i2 == 1) {
            byteBuf2.setByte(i3, alphabet[i4 >>> 18]);
            byteBuf2.setByte(i3 + 1, alphabet[(i4 >>> 12) & 63]);
            byteBuf2.setByte(i3 + 2, 61);
            byteBuf2.setByte(i3 + 3, 61);
        } else if (i2 == 2) {
            byteBuf2.setByte(i3, alphabet[i4 >>> 18]);
            byteBuf2.setByte(i3 + 1, alphabet[(i4 >>> 12) & 63]);
            byteBuf2.setByte(i3 + 2, alphabet[(i4 >>> 6) & 63]);
            byteBuf2.setByte(i3 + 3, 61);
        } else if (i2 != 3) {
        } else {
            byteBuf2.setByte(i3, alphabet[i4 >>> 18]);
            byteBuf2.setByte(i3 + 1, alphabet[(i4 >>> 12) & 63]);
            byteBuf2.setByte(i3 + 2, alphabet[(i4 >>> 6) & 63]);
            byteBuf2.setByte(i3 + 3, alphabet[i4 & 63]);
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

    public static ByteBuf encode(ByteBuf byteBuf, boolean z) {
        return encode(byteBuf, z, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, boolean z, Base64Dialect base64Dialect) {
        if (byteBuf != null) {
            ByteBuf encode = encode(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), z, base64Dialect);
            byteBuf.readerIndex(byteBuf.writerIndex());
            return encode;
        }
        throw new NullPointerException("src");
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i, int i2) {
        return decode(byteBuf, i, i2, Base64Dialect.STANDARD);
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i, int i2, Base64Dialect base64Dialect) {
        return decode(byteBuf, i, i2, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf decode(ByteBuf byteBuf, int i, int i2, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        if (byteBuf != null) {
            if (base64Dialect != null) {
                byte[] decodabet = decodabet(base64Dialect);
                ByteBuf order = byteBufAllocator.buffer((i2 * 3) / 4).order(byteBuf.order());
                byte[] bArr = new byte[4];
                int i3 = 0;
                int i4 = 0;
                for (int i5 = i; i5 < i + i2; i5++) {
                    byte b = (byte) (byteBuf.getByte(i5) & C14354n.f41155b);
                    byte b2 = decodabet[b];
                    if (b2 < -5) {
                        throw new IllegalArgumentException("bad Base64 input character at " + i5 + ": " + ((int) byteBuf.getUnsignedByte(i5)) + " (decimal)");
                    }
                    if (b2 >= -1) {
                        int i6 = i3 + 1;
                        bArr[i3] = b;
                        if (i6 > 3) {
                            i4 += decode4to3(bArr, 0, order, i4, base64Dialect);
                            if (b == 61) {
                                break;
                            }
                            i3 = 0;
                        } else {
                            i3 = i6;
                        }
                    }
                }
                return order.slice(0, i4);
            }
            throw new NullPointerException("dialect");
        }
        throw new NullPointerException("src");
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i, int i2) {
        return encode(byteBuf, i, i2, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i, int i2, Base64Dialect base64Dialect) {
        return encode(byteBuf, i, i2, breakLines(base64Dialect), base64Dialect);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i, int i2, boolean z) {
        return encode(byteBuf, i, i2, z, Base64Dialect.STANDARD);
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i, int i2, boolean z, Base64Dialect base64Dialect) {
        return encode(byteBuf, i, i2, z, base64Dialect, byteBuf.alloc());
    }

    public static ByteBuf encode(ByteBuf byteBuf, int i, int i2, boolean z, Base64Dialect base64Dialect, ByteBufAllocator byteBufAllocator) {
        if (byteBuf != null) {
            if (base64Dialect != null) {
                int i3 = (i2 * 4) / 3;
                ByteBuf order = byteBufAllocator.buffer((i2 % 3 > 0 ? 4 : 0) + i3 + (z ? i3 / 76 : 0)).order(byteBuf.order());
                int i4 = i2 - 2;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (i5 < i4) {
                    encode3to4(byteBuf, i5 + i, 3, order, i6, base64Dialect);
                    i7 += 4;
                    if (z && i7 == 76) {
                        order.setByte(i6 + 4, 10);
                        i6++;
                        i7 = 0;
                    }
                    i5 += 3;
                    i6 += 4;
                }
                if (i5 < i2) {
                    encode3to4(byteBuf, i5 + i, i2 - i5, order, i6, base64Dialect);
                    i6 += 4;
                }
                if (i6 > 1 && order.getByte(i6 - 1) == 10) {
                    i6--;
                }
                return order.slice(0, i6);
            }
            throw new NullPointerException("dialect");
        }
        throw new NullPointerException("src");
    }
}
