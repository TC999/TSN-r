package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Unpooled {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ByteBufAllocator ALLOC;
    public static final ByteOrder BIG_ENDIAN;
    public static final ByteBuf EMPTY_BUFFER;
    public static final ByteOrder LITTLE_ENDIAN;

    static {
        UnpooledByteBufAllocator unpooledByteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
        ALLOC = unpooledByteBufAllocator;
        BIG_ENDIAN = ByteOrder.BIG_ENDIAN;
        LITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
        EMPTY_BUFFER = unpooledByteBufAllocator.buffer(0, 0);
    }

    private Unpooled() {
    }

    public static ByteBuf buffer() {
        return ALLOC.heapBuffer();
    }

    public static CompositeByteBuf compositeBuffer() {
        return compositeBuffer(16);
    }

    public static ByteBuf copiedBuffer(byte[] bArr) {
        if (bArr.length == 0) {
            return EMPTY_BUFFER;
        }
        return wrappedBuffer((byte[]) bArr.clone());
    }

    public static ByteBuf copyBoolean(boolean z) {
        ByteBuf buffer = buffer(1);
        buffer.writeBoolean(z);
        return buffer;
    }

    public static ByteBuf copyDouble(double d) {
        ByteBuf buffer = buffer(8);
        buffer.writeDouble(d);
        return buffer;
    }

    public static ByteBuf copyFloat(float f) {
        ByteBuf buffer = buffer(4);
        buffer.writeFloat(f);
        return buffer;
    }

    public static ByteBuf copyInt(int i) {
        ByteBuf buffer = buffer(4);
        buffer.writeInt(i);
        return buffer;
    }

    public static ByteBuf copyLong(long j) {
        ByteBuf buffer = buffer(8);
        buffer.writeLong(j);
        return buffer;
    }

    public static ByteBuf copyMedium(int i) {
        ByteBuf buffer = buffer(3);
        buffer.writeMedium(i);
        return buffer;
    }

    public static ByteBuf copyShort(int i) {
        ByteBuf buffer = buffer(2);
        buffer.writeShort(i);
        return buffer;
    }

    public static ByteBuf directBuffer() {
        return ALLOC.directBuffer();
    }

    @Deprecated
    public static ByteBuf unmodifiableBuffer(ByteBuf byteBuf) {
        ByteOrder order = byteBuf.order();
        ByteOrder byteOrder = BIG_ENDIAN;
        if (order == byteOrder) {
            return new ReadOnlyByteBuf(byteBuf);
        }
        return new ReadOnlyByteBuf(byteBuf.order(byteOrder)).order(LITTLE_ENDIAN);
    }

    public static ByteBuf unreleasableBuffer(ByteBuf byteBuf) {
        return new UnreleasableByteBuf(byteBuf);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr) {
        if (bArr.length == 0) {
            return EMPTY_BUFFER;
        }
        return new UnpooledHeapByteBuf(ALLOC, bArr, bArr.length);
    }

    public static ByteBuf buffer(int i) {
        return ALLOC.heapBuffer(i);
    }

    public static CompositeByteBuf compositeBuffer(int i) {
        return new CompositeByteBuf(ALLOC, false, i);
    }

    public static ByteBuf directBuffer(int i) {
        return ALLOC.directBuffer(i);
    }

    public static ByteBuf buffer(int i, int i2) {
        return ALLOC.heapBuffer(i, i2);
    }

    public static ByteBuf copyBoolean(boolean... zArr) {
        if (zArr != null && zArr.length != 0) {
            ByteBuf buffer = buffer(zArr.length);
            for (boolean z : zArr) {
                buffer.writeBoolean(z);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyDouble(double... dArr) {
        if (dArr != null && dArr.length != 0) {
            ByteBuf buffer = buffer(dArr.length * 8);
            for (double d : dArr) {
                buffer.writeDouble(d);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyFloat(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            ByteBuf buffer = buffer(fArr.length * 4);
            for (float f : fArr) {
                buffer.writeFloat(f);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyInt(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            ByteBuf buffer = buffer(iArr.length * 4);
            for (int i : iArr) {
                buffer.writeInt(i);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyLong(long... jArr) {
        if (jArr != null && jArr.length != 0) {
            ByteBuf buffer = buffer(jArr.length * 8);
            for (long j : jArr) {
                buffer.writeLong(j);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyMedium(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            ByteBuf buffer = buffer(iArr.length * 3);
            for (int i : iArr) {
                buffer.writeMedium(i);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copyShort(short... sArr) {
        if (sArr != null && sArr.length != 0) {
            ByteBuf buffer = buffer(sArr.length * 2);
            for (short s : sArr) {
                buffer.writeShort(s);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf directBuffer(int i, int i2) {
        return ALLOC.directBuffer(i, i2);
    }

    public static ByteBuf copiedBuffer(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return wrappedBuffer(bArr2);
    }

    public static ByteBuf wrappedBuffer(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return EMPTY_BUFFER;
        }
        if (i == 0 && i2 == bArr.length) {
            return wrappedBuffer(bArr);
        }
        return wrappedBuffer(bArr).slice(i, i2);
    }

    public static ByteBuf unmodifiableBuffer(ByteBuf... byteBufArr) {
        return new FixedCompositeByteBuf(ALLOC, byteBufArr);
    }

    public static ByteBuf copiedBuffer(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining == 0) {
            return EMPTY_BUFFER;
        }
        byte[] bArr = new byte[remaining];
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.get(bArr);
        return wrappedBuffer(bArr).order(duplicate.order());
    }

    public static ByteBuf copyShort(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            ByteBuf buffer = buffer(iArr.length * 2);
            for (int i : iArr) {
                buffer.writeShort(i);
            }
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return EMPTY_BUFFER;
        }
        if (!byteBuffer.isDirect() && byteBuffer.hasArray()) {
            return wrappedBuffer(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()).order(byteBuffer.order());
        }
        if (PlatformDependent.hasUnsafe()) {
            if (byteBuffer.isReadOnly()) {
                if (byteBuffer.isDirect()) {
                    return new ReadOnlyUnsafeDirectByteBuf(ALLOC, byteBuffer);
                }
                return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
            }
            return new UnpooledUnsafeDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
        } else if (byteBuffer.isReadOnly()) {
            return new ReadOnlyByteBufferBuf(ALLOC, byteBuffer);
        } else {
            return new UnpooledDirectByteBuf(ALLOC, byteBuffer, byteBuffer.remaining());
        }
    }

    public static ByteBuf copiedBuffer(ByteBuf byteBuf) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes > 0) {
            ByteBuf buffer = buffer(readableBytes);
            buffer.writeBytes(byteBuf, byteBuf.readerIndex(), readableBytes);
            return buffer;
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(byte[]... bArr) {
        int length = bArr.length;
        if (length != 0) {
            if (length != 1) {
                int i = 0;
                for (byte[] bArr2 : bArr) {
                    if (Integer.MAX_VALUE - i >= bArr2.length) {
                        i += bArr2.length;
                    } else {
                        throw new IllegalArgumentException("The total length of the specified arrays is too big.");
                    }
                }
                if (i == 0) {
                    return EMPTY_BUFFER;
                }
                byte[] bArr3 = new byte[i];
                int i2 = 0;
                for (byte[] bArr4 : bArr) {
                    System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
                    i2 += bArr4.length;
                }
                return wrappedBuffer(bArr3);
            } else if (bArr[0].length == 0) {
                return EMPTY_BUFFER;
            } else {
                return copiedBuffer(bArr[0]);
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(long j, int i, boolean z) {
        return new WrappedUnpooledUnsafeDirectByteBuf(ALLOC, j, i, z);
    }

    public static ByteBuf wrappedBuffer(ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            return byteBuf.slice();
        }
        byteBuf.release();
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(byte[]... bArr) {
        return wrappedBuffer(16, bArr);
    }

    public static ByteBuf wrappedBuffer(ByteBuf... byteBufArr) {
        return wrappedBuffer(16, byteBufArr);
    }

    public static ByteBuf wrappedBuffer(ByteBuffer... byteBufferArr) {
        return wrappedBuffer(16, byteBufferArr);
    }

    public static ByteBuf wrappedBuffer(int i, byte[]... bArr) {
        int length = bArr.length;
        if (length != 0) {
            if (length != 1) {
                ArrayList arrayList = new ArrayList(bArr.length);
                for (byte[] bArr2 : bArr) {
                    if (bArr2 == null) {
                        break;
                    }
                    if (bArr2.length > 0) {
                        arrayList.add(wrappedBuffer(bArr2));
                    }
                }
                if (!arrayList.isEmpty()) {
                    return new CompositeByteBuf(ALLOC, false, i, (Iterable<ByteBuf>) arrayList);
                }
            } else if (bArr[0].length != 0) {
                return wrappedBuffer(bArr[0]);
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length != 0) {
            if (length != 1) {
                ByteOrder byteOrder = null;
                int i = 0;
                for (ByteBuf byteBuf : byteBufArr) {
                    int readableBytes = byteBuf.readableBytes();
                    if (readableBytes > 0) {
                        if (Integer.MAX_VALUE - i < readableBytes) {
                            throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                        }
                        i += readableBytes;
                        if (byteOrder != null) {
                            if (!byteOrder.equals(byteBuf.order())) {
                                throw new IllegalArgumentException("inconsistent byte order");
                            }
                        } else {
                            byteOrder = byteBuf.order();
                        }
                    }
                }
                if (i == 0) {
                    return EMPTY_BUFFER;
                }
                byte[] bArr = new byte[i];
                int i2 = 0;
                for (ByteBuf byteBuf2 : byteBufArr) {
                    int readableBytes2 = byteBuf2.readableBytes();
                    byteBuf2.getBytes(byteBuf2.readerIndex(), bArr, i2, readableBytes2);
                    i2 += readableBytes2;
                }
                return wrappedBuffer(bArr).order(byteOrder);
            }
            return copiedBuffer(byteBufArr[0]);
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(int i, ByteBuf... byteBufArr) {
        int length = byteBufArr.length;
        if (length != 0) {
            if (length != 1) {
                for (int i2 = 0; i2 < byteBufArr.length; i2++) {
                    ByteBuf byteBuf = byteBufArr[i2];
                    if (byteBuf.isReadable()) {
                        return new CompositeByteBuf(ALLOC, false, i, byteBufArr, i2, byteBufArr.length);
                    }
                    byteBuf.release();
                }
            } else {
                ByteBuf byteBuf2 = byteBufArr[0];
                if (byteBuf2.isReadable()) {
                    return wrappedBuffer(byteBuf2.order(BIG_ENDIAN));
                }
                byteBuf2.release();
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(ByteBuffer... byteBufferArr) {
        int length = byteBufferArr.length;
        if (length != 0) {
            if (length != 1) {
                ByteOrder byteOrder = null;
                int i = 0;
                for (ByteBuffer byteBuffer : byteBufferArr) {
                    int remaining = byteBuffer.remaining();
                    if (remaining > 0) {
                        if (Integer.MAX_VALUE - i < remaining) {
                            throw new IllegalArgumentException("The total length of the specified buffers is too big.");
                        }
                        i += remaining;
                        if (byteOrder != null) {
                            if (!byteOrder.equals(byteBuffer.order())) {
                                throw new IllegalArgumentException("inconsistent byte order");
                            }
                        } else {
                            byteOrder = byteBuffer.order();
                        }
                    }
                }
                if (i == 0) {
                    return EMPTY_BUFFER;
                }
                byte[] bArr = new byte[i];
                int i2 = 0;
                for (ByteBuffer byteBuffer2 : byteBufferArr) {
                    ByteBuffer duplicate = byteBuffer2.duplicate();
                    int remaining2 = duplicate.remaining();
                    duplicate.get(bArr, i2, remaining2);
                    i2 += remaining2;
                }
                return wrappedBuffer(bArr).order(byteOrder);
            }
            return copiedBuffer(byteBufferArr[0]);
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf wrappedBuffer(int i, ByteBuffer... byteBufferArr) {
        int length = byteBufferArr.length;
        if (length != 0) {
            if (length != 1) {
                ArrayList arrayList = new ArrayList(byteBufferArr.length);
                for (ByteBuffer byteBuffer : byteBufferArr) {
                    if (byteBuffer == null) {
                        break;
                    }
                    if (byteBuffer.remaining() > 0) {
                        arrayList.add(wrappedBuffer(byteBuffer.order(BIG_ENDIAN)));
                    }
                }
                if (!arrayList.isEmpty()) {
                    return new CompositeByteBuf(ALLOC, false, i, (Iterable<ByteBuf>) arrayList);
                }
            } else if (byteBufferArr[0].hasRemaining()) {
                return wrappedBuffer(byteBufferArr[0].order(BIG_ENDIAN));
            }
        }
        return EMPTY_BUFFER;
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, Charset charset) {
        if (charSequence != null) {
            if (charSequence instanceof CharBuffer) {
                return copiedBuffer((CharBuffer) charSequence, charset);
            }
            return copiedBuffer(CharBuffer.wrap(charSequence), charset);
        }
        throw new NullPointerException("string");
    }

    public static ByteBuf copiedBuffer(CharSequence charSequence, int i, int i2, Charset charset) {
        if (charSequence != null) {
            if (i2 == 0) {
                return EMPTY_BUFFER;
            }
            if (charSequence instanceof CharBuffer) {
                CharBuffer charBuffer = (CharBuffer) charSequence;
                if (charBuffer.hasArray()) {
                    return copiedBuffer(charBuffer.array(), charBuffer.arrayOffset() + charBuffer.position() + i, i2, charset);
                }
                CharBuffer slice = charBuffer.slice();
                slice.limit(i2);
                slice.position(i);
                return copiedBuffer(slice, charset);
            }
            return copiedBuffer(CharBuffer.wrap(charSequence, i, i2 + i), charset);
        }
        throw new NullPointerException("string");
    }

    public static ByteBuf copiedBuffer(char[] cArr, Charset charset) {
        if (cArr != null) {
            return copiedBuffer(cArr, 0, cArr.length, charset);
        }
        throw new NullPointerException("array");
    }

    public static ByteBuf copiedBuffer(char[] cArr, int i, int i2, Charset charset) {
        if (cArr != null) {
            if (i2 == 0) {
                return EMPTY_BUFFER;
            }
            return copiedBuffer(CharBuffer.wrap(cArr, i, i2), charset);
        }
        throw new NullPointerException("array");
    }

    private static ByteBuf copiedBuffer(CharBuffer charBuffer, Charset charset) {
        return ByteBufUtil.encodeString0(ALLOC, true, charBuffer, charset, 0);
    }
}
