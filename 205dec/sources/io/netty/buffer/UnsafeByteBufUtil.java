package io.netty.buffer;

import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class UnsafeByteBufUtil {
    private static final boolean UNALIGNED = PlatformDependent.isUnaligned();
    private static final byte ZERO = 0;

    private UnsafeByteBufUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuf copy(AbstractByteBuf abstractByteBuf, long j4, int i4, int i5) {
        abstractByteBuf.checkIndex(i4, i5);
        ByteBuf directBuffer = abstractByteBuf.alloc().directBuffer(i5, abstractByteBuf.maxCapacity());
        if (i5 != 0) {
            if (directBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(j4, directBuffer.memoryAddress(), i5);
                directBuffer.setIndex(0, i5);
            } else {
                directBuffer.writeBytes(abstractByteBuf, i4, i5);
            }
        }
        return directBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(long j4) {
        return PlatformDependent.getByte(j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j4, int i4, ByteBuf byteBuf, int i5, int i6) {
        abstractByteBuf.checkIndex(i4, i6);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (!MathUtil.isOutOfBounds(i5, i6, byteBuf.capacity())) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(j4, byteBuf.memoryAddress() + i5, i6);
                return;
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(j4, byteBuf.array(), byteBuf.arrayOffset() + i5, i6);
                return;
            } else {
                byteBuf.setBytes(i5, abstractByteBuf, i4, i6);
                return;
            }
        }
        throw new IndexOutOfBoundsException("dstIndex: " + i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(long j4) {
        if (UNALIGNED) {
            int i4 = PlatformDependent.getInt(j4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i4 : Integer.reverseBytes(i4);
        }
        return (PlatformDependent.getByte(j4 + 3) & 255) | (PlatformDependent.getByte(j4) << 24) | ((PlatformDependent.getByte(1 + j4) & 255) << 16) | ((PlatformDependent.getByte(2 + j4) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIntLE(long j4) {
        if (UNALIGNED) {
            int i4 = PlatformDependent.getInt(j4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i4) : i4;
        }
        return (PlatformDependent.getByte(j4 + 3) << 24) | (PlatformDependent.getByte(j4) & 255) | ((PlatformDependent.getByte(1 + j4) & 255) << 8) | ((PlatformDependent.getByte(2 + j4) & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(long j4) {
        if (UNALIGNED) {
            long j5 = PlatformDependent.getLong(j4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j5 : Long.reverseBytes(j5);
        }
        return (PlatformDependent.getByte(j4 + 7) & 255) | (PlatformDependent.getByte(j4) << 56) | ((PlatformDependent.getByte(1 + j4) & 255) << 48) | ((PlatformDependent.getByte(2 + j4) & 255) << 40) | ((PlatformDependent.getByte(3 + j4) & 255) << 32) | ((PlatformDependent.getByte(4 + j4) & 255) << 24) | ((PlatformDependent.getByte(5 + j4) & 255) << 16) | ((PlatformDependent.getByte(6 + j4) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLongLE(long j4) {
        if (UNALIGNED) {
            long j5 = PlatformDependent.getLong(j4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j5) : j5;
        }
        return (PlatformDependent.getByte(j4 + 7) << 56) | (PlatformDependent.getByte(j4) & 255) | ((PlatformDependent.getByte(1 + j4) & 255) << 8) | ((PlatformDependent.getByte(2 + j4) & 255) << 16) | ((PlatformDependent.getByte(3 + j4) & 255) << 24) | ((PlatformDependent.getByte(4 + j4) & 255) << 32) | ((PlatformDependent.getByte(5 + j4) & 255) << 40) | ((255 & PlatformDependent.getByte(6 + j4)) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(long j4) {
        if (UNALIGNED) {
            short s3 = PlatformDependent.getShort(j4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s3 : Short.reverseBytes(s3);
        }
        return (short) ((PlatformDependent.getByte(j4 + 1) & 255) | (PlatformDependent.getByte(j4) << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShortLE(long j4) {
        if (UNALIGNED) {
            short s3 = PlatformDependent.getShort(j4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s3) : s3;
        }
        return (short) ((PlatformDependent.getByte(j4 + 1) << 8) | (PlatformDependent.getByte(j4) & 255));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMedium(long j4) {
        int i4;
        byte b4;
        int i5;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i4 = PlatformDependent.getByte(j4) & 255;
                i5 = (PlatformDependent.getShort(j4 + 1) & 65535) << 8;
                return i5 | i4;
            }
            i4 = (Short.reverseBytes(PlatformDependent.getShort(j4)) & 65535) << 8;
            b4 = PlatformDependent.getByte(j4 + 2);
        } else {
            i4 = ((PlatformDependent.getByte(j4) & 255) << 16) | ((PlatformDependent.getByte(1 + j4) & 255) << 8);
            b4 = PlatformDependent.getByte(j4 + 2);
        }
        i5 = b4 & 255;
        return i5 | i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMediumLE(long j4) {
        int i4;
        int i5;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i4 = (Short.reverseBytes(PlatformDependent.getShort(j4)) & 65535) << 8;
                i5 = PlatformDependent.getByte(j4 + 2) & 255;
            } else {
                i4 = PlatformDependent.getByte(j4) & 255;
                i5 = (PlatformDependent.getShort(j4 + 1) & 65535) << 8;
            }
        } else {
            long j5 = j4 + 1;
            i4 = (PlatformDependent.getByte(j4) & 255) | ((PlatformDependent.getByte(j5) & 255) << 8);
            i5 = (PlatformDependent.getByte(j5) & 255) << 16;
        }
        return i5 | i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnpooledUnsafeDirectByteBuf newUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i4, int i5) {
        if (PlatformDependent.useDirectBufferNoCleaner()) {
            return new UnpooledUnsafeNoCleanerDirectByteBuf(byteBufAllocator, i4, i5);
        }
        return new UnpooledUnsafeDirectByteBuf(byteBufAllocator, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setByte(long j4, int i4) {
        PlatformDependent.putByte(j4, (byte) i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setBytes(AbstractByteBuf abstractByteBuf, long j4, int i4, InputStream inputStream, int i5) throws IOException {
        abstractByteBuf.checkIndex(i4, i5);
        ByteBuf heapBuffer = abstractByteBuf.alloc().heapBuffer(i5);
        try {
            byte[] array = heapBuffer.array();
            int arrayOffset = heapBuffer.arrayOffset();
            int read = inputStream.read(array, arrayOffset, i5);
            if (read > 0) {
                PlatformDependent.copyMemory(array, arrayOffset, j4, read);
            }
            return read;
        } finally {
            heapBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setInt(long j4, int i4) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i4 = Integer.reverseBytes(i4);
            }
            PlatformDependent.putInt(j4, i4);
            return;
        }
        PlatformDependent.putByte(j4, (byte) (i4 >>> 24));
        PlatformDependent.putByte(1 + j4, (byte) (i4 >>> 16));
        PlatformDependent.putByte(2 + j4, (byte) (i4 >>> 8));
        PlatformDependent.putByte(j4 + 3, (byte) i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIntLE(long j4, int i4) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i4 = Integer.reverseBytes(i4);
            }
            PlatformDependent.putInt(j4, i4);
            return;
        }
        PlatformDependent.putByte(j4, (byte) i4);
        PlatformDependent.putByte(1 + j4, (byte) (i4 >>> 8));
        PlatformDependent.putByte(2 + j4, (byte) (i4 >>> 16));
        PlatformDependent.putByte(j4 + 3, (byte) (i4 >>> 24));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLong(long j4, long j5) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j5 = Long.reverseBytes(j5);
            }
            PlatformDependent.putLong(j4, j5);
            return;
        }
        PlatformDependent.putByte(j4, (byte) (j5 >>> 56));
        PlatformDependent.putByte(1 + j4, (byte) (j5 >>> 48));
        PlatformDependent.putByte(2 + j4, (byte) (j5 >>> 40));
        PlatformDependent.putByte(3 + j4, (byte) (j5 >>> 32));
        PlatformDependent.putByte(4 + j4, (byte) (j5 >>> 24));
        PlatformDependent.putByte(5 + j4, (byte) (j5 >>> 16));
        PlatformDependent.putByte(6 + j4, (byte) (j5 >>> 8));
        PlatformDependent.putByte(j4 + 7, (byte) j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLongLE(long j4, long j5) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j5 = Long.reverseBytes(j5);
            }
            PlatformDependent.putLong(j4, j5);
            return;
        }
        PlatformDependent.putByte(j4, (byte) j5);
        PlatformDependent.putByte(1 + j4, (byte) (j5 >>> 8));
        PlatformDependent.putByte(2 + j4, (byte) (j5 >>> 16));
        PlatformDependent.putByte(3 + j4, (byte) (j5 >>> 24));
        PlatformDependent.putByte(4 + j4, (byte) (j5 >>> 32));
        PlatformDependent.putByte(5 + j4, (byte) (j5 >>> 40));
        PlatformDependent.putByte(6 + j4, (byte) (j5 >>> 48));
        PlatformDependent.putByte(j4 + 7, (byte) (j5 >>> 56));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMedium(long j4, int i4) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putByte(j4, (byte) i4);
                PlatformDependent.putShort(j4 + 1, (short) (i4 >>> 8));
                return;
            }
            PlatformDependent.putShort(j4, Short.reverseBytes((short) (i4 >>> 8)));
            PlatformDependent.putByte(j4 + 2, (byte) i4);
            return;
        }
        PlatformDependent.putByte(j4, (byte) (i4 >>> 16));
        PlatformDependent.putByte(1 + j4, (byte) (i4 >>> 8));
        PlatformDependent.putByte(j4 + 2, (byte) i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMediumLE(long j4, int i4) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putShort(j4, Short.reverseBytes((short) (i4 >>> 8)));
                PlatformDependent.putByte(j4 + 2, (byte) i4);
                return;
            }
            PlatformDependent.putByte(j4, (byte) i4);
            PlatformDependent.putShort(j4 + 1, (short) (i4 >>> 8));
            return;
        }
        PlatformDependent.putByte(j4, (byte) i4);
        PlatformDependent.putByte(1 + j4, (byte) (i4 >>> 8));
        PlatformDependent.putByte(j4 + 2, (byte) (i4 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShort(long j4, int i4) {
        if (UNALIGNED) {
            short s3 = (short) i4;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s3 = Short.reverseBytes(s3);
            }
            PlatformDependent.putShort(j4, s3);
            return;
        }
        PlatformDependent.putByte(j4, (byte) (i4 >>> 8));
        PlatformDependent.putByte(j4 + 1, (byte) i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShortLE(long j4, int i4) {
        if (UNALIGNED) {
            short s3 = (short) i4;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s3 = Short.reverseBytes(s3);
            }
            PlatformDependent.putShort(j4, s3);
            return;
        }
        PlatformDependent.putByte(j4, (byte) i4);
        PlatformDependent.putByte(j4 + 1, (byte) (i4 >>> 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZero(byte[] bArr, int i4, int i5) {
        if (i5 == 0) {
            return;
        }
        PlatformDependent.setMemory(bArr, i4, i5, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(byte[] bArr, int i4) {
        return PlatformDependent.getByte(bArr, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setByte(byte[] bArr, int i4, int i5) {
        PlatformDependent.putByte(bArr, i4, (byte) i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZero(AbstractByteBuf abstractByteBuf, long j4, int i4, int i5) {
        if (i5 == 0) {
            return;
        }
        abstractByteBuf.checkIndex(i4, i5);
        PlatformDependent.setMemory(j4, i5, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(byte[] bArr, int i4) {
        if (UNALIGNED) {
            int i5 = PlatformDependent.getInt(bArr, i4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i5 : Integer.reverseBytes(i5);
        }
        return (PlatformDependent.getByte(bArr, i4 + 3) & 255) | (PlatformDependent.getByte(bArr, i4) << 24) | ((PlatformDependent.getByte(bArr, i4 + 1) & 255) << 16) | ((PlatformDependent.getByte(bArr, i4 + 2) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIntLE(byte[] bArr, int i4) {
        if (UNALIGNED) {
            int i5 = PlatformDependent.getInt(bArr, i4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i5) : i5;
        }
        return (PlatformDependent.getByte(bArr, i4 + 3) << 24) | (PlatformDependent.getByte(bArr, i4) & 255) | ((PlatformDependent.getByte(bArr, i4 + 1) & 255) << 8) | ((PlatformDependent.getByte(bArr, i4 + 2) & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(byte[] bArr, int i4) {
        if (UNALIGNED) {
            long j4 = PlatformDependent.getLong(bArr, i4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j4 : Long.reverseBytes(j4);
        }
        return (PlatformDependent.getByte(bArr, i4 + 7) & 255) | (PlatformDependent.getByte(bArr, i4) << 56) | ((PlatformDependent.getByte(bArr, i4 + 1) & 255) << 48) | ((PlatformDependent.getByte(bArr, i4 + 2) & 255) << 40) | ((PlatformDependent.getByte(bArr, i4 + 3) & 255) << 32) | ((PlatformDependent.getByte(bArr, i4 + 4) & 255) << 24) | ((PlatformDependent.getByte(bArr, i4 + 5) & 255) << 16) | ((PlatformDependent.getByte(bArr, i4 + 6) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLongLE(byte[] bArr, int i4) {
        if (UNALIGNED) {
            long j4 = PlatformDependent.getLong(bArr, i4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j4) : j4;
        }
        return (PlatformDependent.getByte(bArr, i4 + 7) << 56) | (PlatformDependent.getByte(bArr, i4) & 255) | ((PlatformDependent.getByte(bArr, i4 + 1) & 255) << 8) | ((PlatformDependent.getByte(bArr, i4 + 2) & 255) << 16) | ((PlatformDependent.getByte(bArr, i4 + 3) & 255) << 24) | ((PlatformDependent.getByte(bArr, i4 + 4) & 255) << 32) | ((PlatformDependent.getByte(bArr, i4 + 5) & 255) << 40) | ((255 & PlatformDependent.getByte(bArr, i4 + 6)) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(byte[] bArr, int i4) {
        if (UNALIGNED) {
            short s3 = PlatformDependent.getShort(bArr, i4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s3 : Short.reverseBytes(s3);
        }
        return (short) ((PlatformDependent.getByte(bArr, i4 + 1) & 255) | (PlatformDependent.getByte(bArr, i4) << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShortLE(byte[] bArr, int i4) {
        if (UNALIGNED) {
            short s3 = PlatformDependent.getShort(bArr, i4);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s3) : s3;
        }
        return (short) ((PlatformDependent.getByte(i4) & 255) | (PlatformDependent.getByte(i4 + 1) << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShort(byte[] bArr, int i4, int i5) {
        if (UNALIGNED) {
            short s3 = (short) i5;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s3 = Short.reverseBytes(s3);
            }
            PlatformDependent.putShort(bArr, i4, s3);
            return;
        }
        PlatformDependent.putByte(bArr, i4, (byte) (i5 >>> 8));
        PlatformDependent.putByte(bArr, i4 + 1, (byte) i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShortLE(byte[] bArr, int i4, int i5) {
        if (UNALIGNED) {
            short s3 = (short) i5;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s3 = Short.reverseBytes(s3);
            }
            PlatformDependent.putShort(bArr, i4, s3);
            return;
        }
        PlatformDependent.putByte(bArr, i4, (byte) i5);
        PlatformDependent.putByte(bArr, i4 + 1, (byte) (i5 >>> 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMedium(byte[] bArr, int i4) {
        int i5;
        byte b4;
        int i6;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i5 = PlatformDependent.getByte(bArr, i4) & 255;
                i6 = (PlatformDependent.getShort(bArr, i4 + 1) & 65535) << 8;
                return i6 | i5;
            }
            i5 = (Short.reverseBytes(PlatformDependent.getShort(bArr, i4)) & 65535) << 8;
            b4 = PlatformDependent.getByte(bArr, i4 + 2);
        } else {
            i5 = ((PlatformDependent.getByte(bArr, i4) & 255) << 16) | ((PlatformDependent.getByte(bArr, i4 + 1) & 255) << 8);
            b4 = PlatformDependent.getByte(bArr, i4 + 2);
        }
        i6 = b4 & 255;
        return i6 | i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMediumLE(byte[] bArr, int i4) {
        int i5;
        int i6;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i5 = (Short.reverseBytes(PlatformDependent.getShort(bArr, i4)) & 65535) << 8;
                i6 = PlatformDependent.getByte(bArr, i4 + 2) & 255;
            } else {
                i5 = PlatformDependent.getByte(bArr, i4) & 255;
                i6 = (PlatformDependent.getShort(bArr, i4 + 1) & 65535) << 8;
            }
        } else {
            i5 = (PlatformDependent.getByte(bArr, i4) & 255) | ((PlatformDependent.getByte(bArr, i4 + 1) & 255) << 8);
            i6 = (PlatformDependent.getByte(bArr, i4 + 2) & 255) << 16;
        }
        return i6 | i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setInt(byte[] bArr, int i4, int i5) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i5 = Integer.reverseBytes(i5);
            }
            PlatformDependent.putInt(bArr, i4, i5);
            return;
        }
        PlatformDependent.putByte(bArr, i4, (byte) (i5 >>> 24));
        PlatformDependent.putByte(bArr, i4 + 1, (byte) (i5 >>> 16));
        PlatformDependent.putByte(bArr, i4 + 2, (byte) (i5 >>> 8));
        PlatformDependent.putByte(bArr, i4 + 3, (byte) i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIntLE(byte[] bArr, int i4, int i5) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i5 = Integer.reverseBytes(i5);
            }
            PlatformDependent.putInt(bArr, i4, i5);
            return;
        }
        PlatformDependent.putByte(bArr, i4, (byte) i5);
        PlatformDependent.putByte(bArr, i4 + 1, (byte) (i5 >>> 8));
        PlatformDependent.putByte(bArr, i4 + 2, (byte) (i5 >>> 16));
        PlatformDependent.putByte(bArr, i4 + 3, (byte) (i5 >>> 24));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf abstractByteBuf, long j4, int i4, ByteBuf byteBuf, int i5, int i6) {
        abstractByteBuf.checkIndex(i4, i6);
        ObjectUtil.checkNotNull(byteBuf, "src");
        if (MathUtil.isOutOfBounds(i5, i6, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException("srcIndex: " + i5);
        } else if (i6 != 0) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(byteBuf.memoryAddress() + i5, j4, i6);
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(byteBuf.array(), byteBuf.arrayOffset() + i5, j4, i6);
            } else {
                byteBuf.getBytes(i5, abstractByteBuf, i4, i6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j4, int i4, byte[] bArr, int i5, int i6) {
        abstractByteBuf.checkIndex(i4, i6);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (MathUtil.isOutOfBounds(i5, i6, bArr.length)) {
            throw new IndexOutOfBoundsException("dstIndex: " + i5);
        } else if (i6 != 0) {
            PlatformDependent.copyMemory(j4, bArr, i5, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMedium(byte[] bArr, int i4, int i5) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putByte(bArr, i4, (byte) i5);
                PlatformDependent.putShort(bArr, i4 + 1, (short) (i5 >>> 8));
                return;
            }
            PlatformDependent.putShort(bArr, i4, Short.reverseBytes((short) (i5 >>> 8)));
            PlatformDependent.putByte(bArr, i4 + 2, (byte) i5);
            return;
        }
        PlatformDependent.putByte(bArr, i4, (byte) (i5 >>> 16));
        PlatformDependent.putByte(bArr, i4 + 1, (byte) (i5 >>> 8));
        PlatformDependent.putByte(bArr, i4 + 2, (byte) i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMediumLE(byte[] bArr, int i4, int i5) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putShort(bArr, i4, Short.reverseBytes((short) (i5 >>> 8)));
                PlatformDependent.putByte(bArr, i4 + 2, (byte) i5);
                return;
            }
            PlatformDependent.putByte(bArr, i4, (byte) i5);
            PlatformDependent.putShort(bArr, i4 + 1, (short) (i5 >>> 8));
            return;
        }
        PlatformDependent.putByte(bArr, i4, (byte) i5);
        PlatformDependent.putByte(bArr, i4 + 1, (byte) (i5 >>> 8));
        PlatformDependent.putByte(bArr, i4 + 2, (byte) (i5 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLong(byte[] bArr, int i4, long j4) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j4 = Long.reverseBytes(j4);
            }
            PlatformDependent.putLong(bArr, i4, j4);
            return;
        }
        PlatformDependent.putByte(bArr, i4, (byte) (j4 >>> 56));
        PlatformDependent.putByte(bArr, i4 + 1, (byte) (j4 >>> 48));
        PlatformDependent.putByte(bArr, i4 + 2, (byte) (j4 >>> 40));
        PlatformDependent.putByte(bArr, i4 + 3, (byte) (j4 >>> 32));
        PlatformDependent.putByte(bArr, i4 + 4, (byte) (j4 >>> 24));
        PlatformDependent.putByte(bArr, i4 + 5, (byte) (j4 >>> 16));
        PlatformDependent.putByte(bArr, i4 + 6, (byte) (j4 >>> 8));
        PlatformDependent.putByte(bArr, i4 + 7, (byte) j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLongLE(byte[] bArr, int i4, long j4) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j4 = Long.reverseBytes(j4);
            }
            PlatformDependent.putLong(bArr, i4, j4);
            return;
        }
        PlatformDependent.putByte(bArr, i4, (byte) j4);
        PlatformDependent.putByte(bArr, i4 + 1, (byte) (j4 >>> 8));
        PlatformDependent.putByte(bArr, i4 + 2, (byte) (j4 >>> 16));
        PlatformDependent.putByte(bArr, i4 + 3, (byte) (j4 >>> 24));
        PlatformDependent.putByte(bArr, i4 + 4, (byte) (j4 >>> 32));
        PlatformDependent.putByte(bArr, i4 + 5, (byte) (j4 >>> 40));
        PlatformDependent.putByte(bArr, i4 + 6, (byte) (j4 >>> 48));
        PlatformDependent.putByte(bArr, i4 + 7, (byte) (j4 >>> 56));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j4, int i4, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(i4);
        int min = Math.min(abstractByteBuf.capacity() - i4, byteBuffer.remaining());
        if (min == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            if (!byteBuffer.isReadOnly()) {
                PlatformDependent.copyMemory(j4, PlatformDependent.directBufferAddress(byteBuffer) + byteBuffer.position(), min);
                byteBuffer.position(byteBuffer.position() + min);
                return;
            }
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            PlatformDependent.copyMemory(j4, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), min);
            byteBuffer.position(byteBuffer.position() + min);
        } else {
            byteBuffer.put(abstractByteBuf.nioBuffer());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf abstractByteBuf, long j4, int i4, byte[] bArr, int i5, int i6) {
        abstractByteBuf.checkIndex(i4, i6);
        if (i6 != 0) {
            PlatformDependent.copyMemory(bArr, i5, j4, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf abstractByteBuf, long j4, int i4, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(i4, byteBuffer.remaining());
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + byteBuffer.position(), j4, byteBuffer.remaining());
            byteBuffer.position(byteBuffer.position() + remaining);
        } else if (byteBuffer.hasArray()) {
            PlatformDependent.copyMemory(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), j4, remaining);
            byteBuffer.position(byteBuffer.position() + remaining);
        } else {
            ByteBuf heapBuffer = abstractByteBuf.alloc().heapBuffer(remaining);
            try {
                byte[] array = heapBuffer.array();
                byteBuffer.get(array, heapBuffer.arrayOffset(), remaining);
                PlatformDependent.copyMemory(array, heapBuffer.arrayOffset(), j4, remaining);
            } finally {
                heapBuffer.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j4, int i4, OutputStream outputStream, int i5) throws IOException {
        abstractByteBuf.checkIndex(i4, i5);
        if (i5 != 0) {
            ByteBuf heapBuffer = abstractByteBuf.alloc().heapBuffer(i5);
            try {
                byte[] array = heapBuffer.array();
                int arrayOffset = heapBuffer.arrayOffset();
                PlatformDependent.copyMemory(j4, array, arrayOffset, i5);
                outputStream.write(array, arrayOffset, i5);
            } finally {
                heapBuffer.release();
            }
        }
    }
}
