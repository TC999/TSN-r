package io.netty.buffer;

import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import kotlin.UByte;
import kotlin.UShort;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class UnsafeByteBufUtil {
    private static final boolean UNALIGNED = PlatformDependent.isUnaligned();
    private static final byte ZERO = 0;

    private UnsafeByteBufUtil() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuf copy(AbstractByteBuf abstractByteBuf, long j, int i, int i2) {
        abstractByteBuf.checkIndex(i, i2);
        ByteBuf directBuffer = abstractByteBuf.alloc().directBuffer(i2, abstractByteBuf.maxCapacity());
        if (i2 != 0) {
            if (directBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(j, directBuffer.memoryAddress(), i2);
                directBuffer.setIndex(0, i2);
            } else {
                directBuffer.writeBytes(abstractByteBuf, i, i2);
            }
        }
        return directBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(long j) {
        return PlatformDependent.getByte(j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j, int i, ByteBuf byteBuf, int i2, int i3) {
        abstractByteBuf.checkIndex(i, i3);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (!MathUtil.isOutOfBounds(i2, i3, byteBuf.capacity())) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(j, byteBuf.memoryAddress() + i2, i3);
                return;
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(j, byteBuf.array(), byteBuf.arrayOffset() + i2, i3);
                return;
            } else {
                byteBuf.setBytes(i2, abstractByteBuf, i, i3);
                return;
            }
        }
        throw new IndexOutOfBoundsException("dstIndex: " + i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(long j) {
        if (UNALIGNED) {
            int i = PlatformDependent.getInt(j);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i : Integer.reverseBytes(i);
        }
        return (PlatformDependent.getByte(j + 3) & UByte.f41242c) | (PlatformDependent.getByte(j) << BinaryMemcacheOpcodes.FLUSHQ) | ((PlatformDependent.getByte(1 + j) & UByte.f41242c) << 16) | ((PlatformDependent.getByte(2 + j) & UByte.f41242c) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIntLE(long j) {
        if (UNALIGNED) {
            int i = PlatformDependent.getInt(j);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i) : i;
        }
        return (PlatformDependent.getByte(j + 3) << BinaryMemcacheOpcodes.FLUSHQ) | (PlatformDependent.getByte(j) & UByte.f41242c) | ((PlatformDependent.getByte(1 + j) & UByte.f41242c) << 8) | ((PlatformDependent.getByte(2 + j) & UByte.f41242c) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(long j) {
        if (UNALIGNED) {
            long j2 = PlatformDependent.getLong(j);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j2 : Long.reverseBytes(j2);
        }
        return (PlatformDependent.getByte(j + 7) & 255) | (PlatformDependent.getByte(j) << 56) | ((PlatformDependent.getByte(1 + j) & 255) << 48) | ((PlatformDependent.getByte(2 + j) & 255) << 40) | ((PlatformDependent.getByte(3 + j) & 255) << 32) | ((PlatformDependent.getByte(4 + j) & 255) << 24) | ((PlatformDependent.getByte(5 + j) & 255) << 16) | ((PlatformDependent.getByte(6 + j) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLongLE(long j) {
        if (UNALIGNED) {
            long j2 = PlatformDependent.getLong(j);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j2) : j2;
        }
        return (PlatformDependent.getByte(j + 7) << 56) | (PlatformDependent.getByte(j) & 255) | ((PlatformDependent.getByte(1 + j) & 255) << 8) | ((PlatformDependent.getByte(2 + j) & 255) << 16) | ((PlatformDependent.getByte(3 + j) & 255) << 24) | ((PlatformDependent.getByte(4 + j) & 255) << 32) | ((PlatformDependent.getByte(5 + j) & 255) << 40) | ((255 & PlatformDependent.getByte(6 + j)) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(long j) {
        if (UNALIGNED) {
            short s = PlatformDependent.getShort(j);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s : Short.reverseBytes(s);
        }
        return (short) ((PlatformDependent.getByte(j + 1) & UByte.f41242c) | (PlatformDependent.getByte(j) << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShortLE(long j) {
        if (!UNALIGNED) {
            return (short) ((PlatformDependent.getByte(j + 1) << 8) | (PlatformDependent.getByte(j) & UByte.f41242c));
        }
        short s = PlatformDependent.getShort(j);
        return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s) : s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMedium(long j) {
        int i;
        byte b;
        int i2;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i = PlatformDependent.getByte(j) & UByte.f41242c;
                i2 = (PlatformDependent.getShort(j + 1) & UShort.f40820c) << 8;
                return i2 | i;
            }
            i = (Short.reverseBytes(PlatformDependent.getShort(j)) & UShort.f40820c) << 8;
            b = PlatformDependent.getByte(j + 2);
        } else {
            i = ((PlatformDependent.getByte(j) & UByte.f41242c) << 16) | ((PlatformDependent.getByte(1 + j) & UByte.f41242c) << 8);
            b = PlatformDependent.getByte(j + 2);
        }
        i2 = b & UByte.f41242c;
        return i2 | i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMediumLE(long j) {
        int i;
        int i2;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i = (Short.reverseBytes(PlatformDependent.getShort(j)) & UShort.f40820c) << 8;
                i2 = PlatformDependent.getByte(j + 2) & UByte.f41242c;
            } else {
                i = PlatformDependent.getByte(j) & UByte.f41242c;
                i2 = (PlatformDependent.getShort(j + 1) & UShort.f40820c) << 8;
            }
        } else {
            long j2 = j + 1;
            i = (PlatformDependent.getByte(j) & UByte.f41242c) | ((PlatformDependent.getByte(j2) & UByte.f41242c) << 8);
            i2 = (PlatformDependent.getByte(j2) & UByte.f41242c) << 16;
        }
        return i2 | i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static UnpooledUnsafeDirectByteBuf newUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, int i, int i2) {
        if (PlatformDependent.useDirectBufferNoCleaner()) {
            return new UnpooledUnsafeNoCleanerDirectByteBuf(byteBufAllocator, i, i2);
        }
        return new UnpooledUnsafeDirectByteBuf(byteBufAllocator, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setByte(long j, int i) {
        PlatformDependent.putByte(j, (byte) i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int setBytes(AbstractByteBuf abstractByteBuf, long j, int i, InputStream inputStream, int i2) throws IOException {
        abstractByteBuf.checkIndex(i, i2);
        ByteBuf heapBuffer = abstractByteBuf.alloc().heapBuffer(i2);
        try {
            byte[] array = heapBuffer.array();
            int arrayOffset = heapBuffer.arrayOffset();
            int read = inputStream.read(array, arrayOffset, i2);
            if (read > 0) {
                PlatformDependent.copyMemory(array, arrayOffset, j, read);
            }
            return read;
        } finally {
            heapBuffer.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setInt(long j, int i) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i = Integer.reverseBytes(i);
            }
            PlatformDependent.putInt(j, i);
            return;
        }
        PlatformDependent.putByte(j, (byte) (i >>> 24));
        PlatformDependent.putByte(1 + j, (byte) (i >>> 16));
        PlatformDependent.putByte(2 + j, (byte) (i >>> 8));
        PlatformDependent.putByte(j + 3, (byte) i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIntLE(long j, int i) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i = Integer.reverseBytes(i);
            }
            PlatformDependent.putInt(j, i);
            return;
        }
        PlatformDependent.putByte(j, (byte) i);
        PlatformDependent.putByte(1 + j, (byte) (i >>> 8));
        PlatformDependent.putByte(2 + j, (byte) (i >>> 16));
        PlatformDependent.putByte(j + 3, (byte) (i >>> 24));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLong(long j, long j2) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j2 = Long.reverseBytes(j2);
            }
            PlatformDependent.putLong(j, j2);
            return;
        }
        PlatformDependent.putByte(j, (byte) (j2 >>> 56));
        PlatformDependent.putByte(1 + j, (byte) (j2 >>> 48));
        PlatformDependent.putByte(2 + j, (byte) (j2 >>> 40));
        PlatformDependent.putByte(3 + j, (byte) (j2 >>> 32));
        PlatformDependent.putByte(4 + j, (byte) (j2 >>> 24));
        PlatformDependent.putByte(5 + j, (byte) (j2 >>> 16));
        PlatformDependent.putByte(6 + j, (byte) (j2 >>> 8));
        PlatformDependent.putByte(j + 7, (byte) j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLongLE(long j, long j2) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j2 = Long.reverseBytes(j2);
            }
            PlatformDependent.putLong(j, j2);
            return;
        }
        PlatformDependent.putByte(j, (byte) j2);
        PlatformDependent.putByte(1 + j, (byte) (j2 >>> 8));
        PlatformDependent.putByte(2 + j, (byte) (j2 >>> 16));
        PlatformDependent.putByte(3 + j, (byte) (j2 >>> 24));
        PlatformDependent.putByte(4 + j, (byte) (j2 >>> 32));
        PlatformDependent.putByte(5 + j, (byte) (j2 >>> 40));
        PlatformDependent.putByte(6 + j, (byte) (j2 >>> 48));
        PlatformDependent.putByte(j + 7, (byte) (j2 >>> 56));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMedium(long j, int i) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putByte(j, (byte) i);
                PlatformDependent.putShort(j + 1, (short) (i >>> 8));
                return;
            }
            PlatformDependent.putShort(j, Short.reverseBytes((short) (i >>> 8)));
            PlatformDependent.putByte(j + 2, (byte) i);
            return;
        }
        PlatformDependent.putByte(j, (byte) (i >>> 16));
        PlatformDependent.putByte(1 + j, (byte) (i >>> 8));
        PlatformDependent.putByte(j + 2, (byte) i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMediumLE(long j, int i) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putShort(j, Short.reverseBytes((short) (i >>> 8)));
                PlatformDependent.putByte(j + 2, (byte) i);
                return;
            }
            PlatformDependent.putByte(j, (byte) i);
            PlatformDependent.putShort(j + 1, (short) (i >>> 8));
            return;
        }
        PlatformDependent.putByte(j, (byte) i);
        PlatformDependent.putByte(1 + j, (byte) (i >>> 8));
        PlatformDependent.putByte(j + 2, (byte) (i >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShort(long j, int i) {
        if (UNALIGNED) {
            short s = (short) i;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s = Short.reverseBytes(s);
            }
            PlatformDependent.putShort(j, s);
            return;
        }
        PlatformDependent.putByte(j, (byte) (i >>> 8));
        PlatformDependent.putByte(j + 1, (byte) i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShortLE(long j, int i) {
        if (UNALIGNED) {
            short s = (short) i;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s = Short.reverseBytes(s);
            }
            PlatformDependent.putShort(j, s);
            return;
        }
        PlatformDependent.putByte(j, (byte) i);
        PlatformDependent.putByte(j + 1, (byte) (i >>> 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZero(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        PlatformDependent.setMemory(bArr, i, i2, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte getByte(byte[] bArr, int i) {
        return PlatformDependent.getByte(bArr, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setByte(byte[] bArr, int i, int i2) {
        PlatformDependent.putByte(bArr, i, (byte) i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setZero(AbstractByteBuf abstractByteBuf, long j, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        abstractByteBuf.checkIndex(i, i2);
        PlatformDependent.setMemory(j, i2, (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(byte[] bArr, int i) {
        if (UNALIGNED) {
            int i2 = PlatformDependent.getInt(bArr, i);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? i2 : Integer.reverseBytes(i2);
        }
        return (PlatformDependent.getByte(bArr, i + 3) & UByte.f41242c) | (PlatformDependent.getByte(bArr, i) << BinaryMemcacheOpcodes.FLUSHQ) | ((PlatformDependent.getByte(bArr, i + 1) & UByte.f41242c) << 16) | ((PlatformDependent.getByte(bArr, i + 2) & UByte.f41242c) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getIntLE(byte[] bArr, int i) {
        if (UNALIGNED) {
            int i2 = PlatformDependent.getInt(bArr, i);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Integer.reverseBytes(i2) : i2;
        }
        return (PlatformDependent.getByte(bArr, i + 3) << BinaryMemcacheOpcodes.FLUSHQ) | (PlatformDependent.getByte(bArr, i) & UByte.f41242c) | ((PlatformDependent.getByte(bArr, i + 1) & UByte.f41242c) << 8) | ((PlatformDependent.getByte(bArr, i + 2) & UByte.f41242c) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(byte[] bArr, int i) {
        if (UNALIGNED) {
            long j = PlatformDependent.getLong(bArr, i);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? j : Long.reverseBytes(j);
        }
        return (PlatformDependent.getByte(bArr, i + 7) & 255) | (PlatformDependent.getByte(bArr, i) << 56) | ((PlatformDependent.getByte(bArr, i + 1) & 255) << 48) | ((PlatformDependent.getByte(bArr, i + 2) & 255) << 40) | ((PlatformDependent.getByte(bArr, i + 3) & 255) << 32) | ((PlatformDependent.getByte(bArr, i + 4) & 255) << 24) | ((PlatformDependent.getByte(bArr, i + 5) & 255) << 16) | ((PlatformDependent.getByte(bArr, i + 6) & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLongLE(byte[] bArr, int i) {
        if (UNALIGNED) {
            long j = PlatformDependent.getLong(bArr, i);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Long.reverseBytes(j) : j;
        }
        return (PlatformDependent.getByte(bArr, i + 7) << 56) | (PlatformDependent.getByte(bArr, i) & 255) | ((PlatformDependent.getByte(bArr, i + 1) & 255) << 8) | ((PlatformDependent.getByte(bArr, i + 2) & 255) << 16) | ((PlatformDependent.getByte(bArr, i + 3) & 255) << 24) | ((PlatformDependent.getByte(bArr, i + 4) & 255) << 32) | ((PlatformDependent.getByte(bArr, i + 5) & 255) << 40) | ((255 & PlatformDependent.getByte(bArr, i + 6)) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShort(byte[] bArr, int i) {
        if (UNALIGNED) {
            short s = PlatformDependent.getShort(bArr, i);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? s : Short.reverseBytes(s);
        }
        return (short) ((PlatformDependent.getByte(bArr, i + 1) & UByte.f41242c) | (PlatformDependent.getByte(bArr, i) << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static short getShortLE(byte[] bArr, int i) {
        if (UNALIGNED) {
            short s = PlatformDependent.getShort(bArr, i);
            return PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? Short.reverseBytes(s) : s;
        }
        return (short) ((PlatformDependent.getByte(i) & UByte.f41242c) | (PlatformDependent.getByte(i + 1) << 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShort(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            short s = (short) i2;
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s = Short.reverseBytes(s);
            }
            PlatformDependent.putShort(bArr, i, s);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) (i2 >>> 8));
        PlatformDependent.putByte(bArr, i + 1, (byte) i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setShortLE(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            short s = (short) i2;
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                s = Short.reverseBytes(s);
            }
            PlatformDependent.putShort(bArr, i, s);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) i2);
        PlatformDependent.putByte(bArr, i + 1, (byte) (i2 >>> 8));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMedium(byte[] bArr, int i) {
        int i2;
        byte b;
        int i3;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i2 = PlatformDependent.getByte(bArr, i) & UByte.f41242c;
                i3 = (PlatformDependent.getShort(bArr, i + 1) & UShort.f40820c) << 8;
                return i3 | i2;
            }
            i2 = (Short.reverseBytes(PlatformDependent.getShort(bArr, i)) & UShort.f40820c) << 8;
            b = PlatformDependent.getByte(bArr, i + 2);
        } else {
            i2 = ((PlatformDependent.getByte(bArr, i) & UByte.f41242c) << 16) | ((PlatformDependent.getByte(bArr, i + 1) & UByte.f41242c) << 8);
            b = PlatformDependent.getByte(bArr, i + 2);
        }
        i3 = b & UByte.f41242c;
        return i3 | i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getUnsignedMediumLE(byte[] bArr, int i) {
        int i2;
        int i3;
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i2 = (Short.reverseBytes(PlatformDependent.getShort(bArr, i)) & UShort.f40820c) << 8;
                i3 = PlatformDependent.getByte(bArr, i + 2) & UByte.f41242c;
            } else {
                i2 = PlatformDependent.getByte(bArr, i) & UByte.f41242c;
                i3 = (PlatformDependent.getShort(bArr, i + 1) & UShort.f40820c) << 8;
            }
        } else {
            i2 = (PlatformDependent.getByte(bArr, i) & UByte.f41242c) | ((PlatformDependent.getByte(bArr, i + 1) & UByte.f41242c) << 8);
            i3 = (PlatformDependent.getByte(bArr, i + 2) & UByte.f41242c) << 16;
        }
        return i3 | i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setInt(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i2 = Integer.reverseBytes(i2);
            }
            PlatformDependent.putInt(bArr, i, i2);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) (i2 >>> 24));
        PlatformDependent.putByte(bArr, i + 1, (byte) (i2 >>> 16));
        PlatformDependent.putByte(bArr, i + 2, (byte) (i2 >>> 8));
        PlatformDependent.putByte(bArr, i + 3, (byte) i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setIntLE(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                i2 = Integer.reverseBytes(i2);
            }
            PlatformDependent.putInt(bArr, i, i2);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) i2);
        PlatformDependent.putByte(bArr, i + 1, (byte) (i2 >>> 8));
        PlatformDependent.putByte(bArr, i + 2, (byte) (i2 >>> 16));
        PlatformDependent.putByte(bArr, i + 3, (byte) (i2 >>> 24));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf abstractByteBuf, long j, int i, ByteBuf byteBuf, int i2, int i3) {
        abstractByteBuf.checkIndex(i, i3);
        ObjectUtil.checkNotNull(byteBuf, "src");
        if (MathUtil.isOutOfBounds(i2, i3, byteBuf.capacity())) {
            throw new IndexOutOfBoundsException("srcIndex: " + i2);
        } else if (i3 != 0) {
            if (byteBuf.hasMemoryAddress()) {
                PlatformDependent.copyMemory(byteBuf.memoryAddress() + i2, j, i3);
            } else if (byteBuf.hasArray()) {
                PlatformDependent.copyMemory(byteBuf.array(), byteBuf.arrayOffset() + i2, j, i3);
            } else {
                byteBuf.getBytes(i2, abstractByteBuf, i, i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j, int i, byte[] bArr, int i2, int i3) {
        abstractByteBuf.checkIndex(i, i3);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (MathUtil.isOutOfBounds(i2, i3, bArr.length)) {
            throw new IndexOutOfBoundsException("dstIndex: " + i2);
        } else if (i3 != 0) {
            PlatformDependent.copyMemory(j, bArr, i2, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMedium(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putByte(bArr, i, (byte) i2);
                PlatformDependent.putShort(bArr, i + 1, (short) (i2 >>> 8));
                return;
            }
            PlatformDependent.putShort(bArr, i, Short.reverseBytes((short) (i2 >>> 8)));
            PlatformDependent.putByte(bArr, i + 2, (byte) i2);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) (i2 >>> 16));
        PlatformDependent.putByte(bArr, i + 1, (byte) (i2 >>> 8));
        PlatformDependent.putByte(bArr, i + 2, (byte) i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setMediumLE(byte[] bArr, int i, int i2) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                PlatformDependent.putShort(bArr, i, Short.reverseBytes((short) (i2 >>> 8)));
                PlatformDependent.putByte(bArr, i + 2, (byte) i2);
                return;
            }
            PlatformDependent.putByte(bArr, i, (byte) i2);
            PlatformDependent.putShort(bArr, i + 1, (short) (i2 >>> 8));
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) i2);
        PlatformDependent.putByte(bArr, i + 1, (byte) (i2 >>> 8));
        PlatformDependent.putByte(bArr, i + 2, (byte) (i2 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLong(byte[] bArr, int i, long j) {
        if (UNALIGNED) {
            if (!PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j = Long.reverseBytes(j);
            }
            PlatformDependent.putLong(bArr, i, j);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) (j >>> 56));
        PlatformDependent.putByte(bArr, i + 1, (byte) (j >>> 48));
        PlatformDependent.putByte(bArr, i + 2, (byte) (j >>> 40));
        PlatformDependent.putByte(bArr, i + 3, (byte) (j >>> 32));
        PlatformDependent.putByte(bArr, i + 4, (byte) (j >>> 24));
        PlatformDependent.putByte(bArr, i + 5, (byte) (j >>> 16));
        PlatformDependent.putByte(bArr, i + 6, (byte) (j >>> 8));
        PlatformDependent.putByte(bArr, i + 7, (byte) j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setLongLE(byte[] bArr, int i, long j) {
        if (UNALIGNED) {
            if (PlatformDependent.BIG_ENDIAN_NATIVE_ORDER) {
                j = Long.reverseBytes(j);
            }
            PlatformDependent.putLong(bArr, i, j);
            return;
        }
        PlatformDependent.putByte(bArr, i, (byte) j);
        PlatformDependent.putByte(bArr, i + 1, (byte) (j >>> 8));
        PlatformDependent.putByte(bArr, i + 2, (byte) (j >>> 16));
        PlatformDependent.putByte(bArr, i + 3, (byte) (j >>> 24));
        PlatformDependent.putByte(bArr, i + 4, (byte) (j >>> 32));
        PlatformDependent.putByte(bArr, i + 5, (byte) (j >>> 40));
        PlatformDependent.putByte(bArr, i + 6, (byte) (j >>> 48));
        PlatformDependent.putByte(bArr, i + 7, (byte) (j >>> 56));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j, int i, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(i);
        int min = Math.min(abstractByteBuf.capacity() - i, byteBuffer.remaining());
        if (min == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            if (!byteBuffer.isReadOnly()) {
                PlatformDependent.copyMemory(j, PlatformDependent.directBufferAddress(byteBuffer) + byteBuffer.position(), min);
                byteBuffer.position(byteBuffer.position() + min);
                return;
            }
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            PlatformDependent.copyMemory(j, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), min);
            byteBuffer.position(byteBuffer.position() + min);
        } else {
            byteBuffer.put(abstractByteBuf.nioBuffer());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf abstractByteBuf, long j, int i, byte[] bArr, int i2, int i3) {
        abstractByteBuf.checkIndex(i, i3);
        if (i3 != 0) {
            PlatformDependent.copyMemory(bArr, i2, j, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setBytes(AbstractByteBuf abstractByteBuf, long j, int i, ByteBuffer byteBuffer) {
        abstractByteBuf.checkIndex(i, byteBuffer.remaining());
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return;
        }
        if (byteBuffer.isDirect()) {
            PlatformDependent.copyMemory(PlatformDependent.directBufferAddress(byteBuffer) + byteBuffer.position(), j, byteBuffer.remaining());
            byteBuffer.position(byteBuffer.position() + remaining);
        } else if (byteBuffer.hasArray()) {
            PlatformDependent.copyMemory(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), j, remaining);
            byteBuffer.position(byteBuffer.position() + remaining);
        } else {
            ByteBuf heapBuffer = abstractByteBuf.alloc().heapBuffer(remaining);
            try {
                byte[] array = heapBuffer.array();
                byteBuffer.get(array, heapBuffer.arrayOffset(), remaining);
                PlatformDependent.copyMemory(array, heapBuffer.arrayOffset(), j, remaining);
            } finally {
                heapBuffer.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void getBytes(AbstractByteBuf abstractByteBuf, long j, int i, OutputStream outputStream, int i2) throws IOException {
        abstractByteBuf.checkIndex(i, i2);
        if (i2 != 0) {
            ByteBuf heapBuffer = abstractByteBuf.alloc().heapBuffer(i2);
            try {
                byte[] array = heapBuffer.array();
                int arrayOffset = heapBuffer.arrayOffset();
                PlatformDependent.copyMemory(j, array, arrayOffset, i2);
                outputStream.write(array, arrayOffset, i2);
            } finally {
                heapBuffer.release();
            }
        }
    }
}
