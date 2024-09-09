package io.netty.buffer;

import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;
import io.netty.util.Recycler;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class ByteBufUtil {
    private static final FastThreadLocal<CharBuffer> CHAR_BUFFERS;
    static final ByteBufAllocator DEFAULT_ALLOCATOR;
    private static final ByteProcessor FIND_NON_ASCII;
    private static final int MAX_BYTES_PER_CHAR_UTF8;
    private static final int MAX_CHAR_BUFFER_SIZE;
    private static final int THREAD_LOCAL_BUFFER_SIZE;
    private static final byte WRITE_UTF_UNKNOWN = 63;
    private static final InternalLogger logger;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class ThreadLocalDirectByteBuf extends UnpooledDirectByteBuf {
        private static final Recycler<ThreadLocalDirectByteBuf> RECYCLER = new Recycler<ThreadLocalDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalDirectByteBuf.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public ThreadLocalDirectByteBuf newObject(Recycler.Handle<ThreadLocalDirectByteBuf> handle) {
                return new ThreadLocalDirectByteBuf(handle);
            }
        };
        private final Recycler.Handle<ThreadLocalDirectByteBuf> handle;

        static ThreadLocalDirectByteBuf newInstance() {
            ThreadLocalDirectByteBuf threadLocalDirectByteBuf = RECYCLER.get();
            threadLocalDirectByteBuf.setRefCnt(1);
            return threadLocalDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        protected void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
                return;
            }
            clear();
            this.handle.recycle(this);
        }

        private ThreadLocalDirectByteBuf(Recycler.Handle<ThreadLocalDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class ThreadLocalUnsafeDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
        private static final Recycler<ThreadLocalUnsafeDirectByteBuf> RECYCLER = new Recycler<ThreadLocalUnsafeDirectByteBuf>() { // from class: io.netty.buffer.ByteBufUtil.ThreadLocalUnsafeDirectByteBuf.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.netty.util.Recycler
            public ThreadLocalUnsafeDirectByteBuf newObject(Recycler.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
                return new ThreadLocalUnsafeDirectByteBuf(handle);
            }
        };
        private final Recycler.Handle<ThreadLocalUnsafeDirectByteBuf> handle;

        static ThreadLocalUnsafeDirectByteBuf newInstance() {
            ThreadLocalUnsafeDirectByteBuf threadLocalUnsafeDirectByteBuf = RECYCLER.get();
            threadLocalUnsafeDirectByteBuf.setRefCnt(1);
            return threadLocalUnsafeDirectByteBuf;
        }

        @Override // io.netty.buffer.UnpooledUnsafeDirectByteBuf, io.netty.buffer.AbstractReferenceCountedByteBuf
        protected void deallocate() {
            if (capacity() > ByteBufUtil.THREAD_LOCAL_BUFFER_SIZE) {
                super.deallocate();
                return;
            }
            clear();
            this.handle.recycle(this);
        }

        private ThreadLocalUnsafeDirectByteBuf(Recycler.Handle<ThreadLocalUnsafeDirectByteBuf> handle) {
            super(UnpooledByteBufAllocator.DEFAULT, 256, Integer.MAX_VALUE);
            this.handle = handle;
        }
    }

    static {
        ByteBufAllocator byteBufAllocator;
        InternalLogger internalLoggerFactory = InternalLoggerFactory.getInstance(ByteBufUtil.class);
        logger = internalLoggerFactory;
        CHAR_BUFFERS = new FastThreadLocal<CharBuffer>() { // from class: io.netty.buffer.ByteBufUtil.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // io.netty.util.concurrent.FastThreadLocal
            public CharBuffer initialValue() throws Exception {
                return CharBuffer.allocate(1024);
            }
        };
        MAX_BYTES_PER_CHAR_UTF8 = (int) CharsetUtil.encoder(CharsetUtil.UTF_8).maxBytesPerChar();
        String trim = SystemPropertyUtil.get("io.netty.allocator.type", PlatformDependent.isAndroid() ? "unpooled" : "pooled").toLowerCase(Locale.US).trim();
        if ("unpooled".equals(trim)) {
            byteBufAllocator = UnpooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", trim);
        } else if ("pooled".equals(trim)) {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: {}", trim);
        } else {
            byteBufAllocator = PooledByteBufAllocator.DEFAULT;
            internalLoggerFactory.debug("-Dio.netty.allocator.type: pooled (unknown: {})", trim);
        }
        DEFAULT_ALLOCATOR = byteBufAllocator;
        int i4 = SystemPropertyUtil.getInt("io.netty.threadLocalDirectBufferSize", 65536);
        THREAD_LOCAL_BUFFER_SIZE = i4;
        internalLoggerFactory.debug("-Dio.netty.threadLocalDirectBufferSize: {}", Integer.valueOf(i4));
        int i5 = SystemPropertyUtil.getInt("io.netty.maxThreadLocalCharBufferSize", 16384);
        MAX_CHAR_BUFFER_SIZE = i5;
        internalLoggerFactory.debug("-Dio.netty.maxThreadLocalCharBufferSize: {}", Integer.valueOf(i5));
        FIND_NON_ASCII = new ByteProcessor() { // from class: io.netty.buffer.ByteBufUtil.2
            @Override // io.netty.util.ByteProcessor
            public boolean process(byte b4) {
                return b4 >= 0;
            }
        };
    }

    private ByteBufUtil() {
    }

    public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf) {
        appendPrettyHexDump(sb, byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static int compare(ByteBuf byteBuf, ByteBuf byteBuf2) {
        long compareUintBigEndianA;
        int readableBytes = byteBuf.readableBytes();
        int readableBytes2 = byteBuf2.readableBytes();
        int min = Math.min(readableBytes, readableBytes2);
        int i4 = min >>> 2;
        int i5 = min & 3;
        int readerIndex = byteBuf.readerIndex();
        int readerIndex2 = byteBuf2.readerIndex();
        if (i4 > 0) {
            boolean z3 = byteBuf.order() == ByteOrder.BIG_ENDIAN;
            int i6 = i4 << 2;
            if (byteBuf.order() == byteBuf2.order()) {
                compareUintBigEndianA = z3 ? compareUintBigEndian(byteBuf, byteBuf2, readerIndex, readerIndex2, i6) : compareUintLittleEndian(byteBuf, byteBuf2, readerIndex, readerIndex2, i6);
            } else {
                compareUintBigEndianA = z3 ? compareUintBigEndianA(byteBuf, byteBuf2, readerIndex, readerIndex2, i6) : compareUintBigEndianB(byteBuf, byteBuf2, readerIndex, readerIndex2, i6);
            }
            if (compareUintBigEndianA != 0) {
                return (int) Math.min(2147483647L, compareUintBigEndianA);
            }
            readerIndex += i6;
            readerIndex2 += i6;
        }
        int i7 = i5 + readerIndex;
        while (readerIndex < i7) {
            int unsignedByte = byteBuf.getUnsignedByte(readerIndex) - byteBuf2.getUnsignedByte(readerIndex2);
            if (unsignedByte != 0) {
                return unsignedByte;
            }
            readerIndex++;
            readerIndex2++;
        }
        return readableBytes - readableBytes2;
    }

    private static long compareUintBigEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i4, int i5, int i6) {
        int i7 = i6 + i4;
        while (i4 < i7) {
            long unsignedInt = byteBuf.getUnsignedInt(i4) - byteBuf2.getUnsignedInt(i5);
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i4 += 4;
            i5 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianA(ByteBuf byteBuf, ByteBuf byteBuf2, int i4, int i5, int i6) {
        int i7 = i6 + i4;
        while (i4 < i7) {
            long unsignedInt = byteBuf.getUnsignedInt(i4) - byteBuf2.getUnsignedIntLE(i5);
            if (unsignedInt != 0) {
                return unsignedInt;
            }
            i4 += 4;
            i5 += 4;
        }
        return 0L;
    }

    private static long compareUintBigEndianB(ByteBuf byteBuf, ByteBuf byteBuf2, int i4, int i5, int i6) {
        int i7 = i6 + i4;
        while (i4 < i7) {
            long unsignedIntLE = byteBuf.getUnsignedIntLE(i4) - byteBuf2.getUnsignedInt(i5);
            if (unsignedIntLE != 0) {
                return unsignedIntLE;
            }
            i4 += 4;
            i5 += 4;
        }
        return 0L;
    }

    private static long compareUintLittleEndian(ByteBuf byteBuf, ByteBuf byteBuf2, int i4, int i5, int i6) {
        int i7 = i6 + i4;
        while (i4 < i7) {
            long unsignedIntLE = byteBuf.getUnsignedIntLE(i4) - byteBuf2.getUnsignedIntLE(i5);
            if (unsignedIntLE != 0) {
                return unsignedIntLE;
            }
            i4 += 4;
            i5 += 4;
        }
        return 0L;
    }

    public static void copy(AsciiString asciiString, int i4, ByteBuf byteBuf, int i5, int i6) {
        if (!MathUtil.isOutOfBounds(i4, i6, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).setBytes(i5, asciiString.array(), i4 + asciiString.arrayOffset(), i6);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i4 + ") <= srcIdx + length(" + i6 + ") <= srcLen(" + asciiString.length() + ')');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decodeString(ByteBuf byteBuf, int i4, int i5, Charset charset) {
        if (i5 == 0) {
            return "";
        }
        CharsetDecoder decoder = CharsetUtil.decoder(charset);
        double d4 = i5;
        double maxCharsPerByte = decoder.maxCharsPerByte();
        Double.isNaN(d4);
        Double.isNaN(maxCharsPerByte);
        int i6 = (int) (d4 * maxCharsPerByte);
        FastThreadLocal<CharBuffer> fastThreadLocal = CHAR_BUFFERS;
        CharBuffer charBuffer = fastThreadLocal.get();
        if (charBuffer.length() < i6) {
            charBuffer = CharBuffer.allocate(i6);
            if (i6 <= MAX_CHAR_BUFFER_SIZE) {
                fastThreadLocal.set(charBuffer);
            }
        } else {
            charBuffer.clear();
        }
        if (byteBuf.nioBufferCount() == 1) {
            decodeString(decoder, byteBuf.internalNioBuffer(i4, i5), charBuffer);
        } else {
            ByteBuf heapBuffer = byteBuf.alloc().heapBuffer(i5);
            try {
                heapBuffer.writeBytes(byteBuf, i4, i5);
                decodeString(decoder, heapBuffer.internalNioBuffer(0, i5), charBuffer);
            } finally {
                heapBuffer.release();
            }
        }
        return charBuffer.flip().toString();
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuf encodeString0(ByteBufAllocator byteBufAllocator, boolean z3, CharBuffer charBuffer, Charset charset, int i4) {
        ByteBuf buffer;
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        double remaining = charBuffer.remaining();
        double maxBytesPerChar = encoder.maxBytesPerChar();
        Double.isNaN(remaining);
        Double.isNaN(maxBytesPerChar);
        int i5 = ((int) (remaining * maxBytesPerChar)) + i4;
        if (z3) {
            buffer = byteBufAllocator.heapBuffer(i5);
        } else {
            buffer = byteBufAllocator.buffer(i5);
        }
        try {
            try {
                ByteBuffer internalNioBuffer = buffer.internalNioBuffer(0, i5);
                int position = internalNioBuffer.position();
                CoderResult encode = encoder.encode(charBuffer, internalNioBuffer, true);
                if (!encode.isUnderflow()) {
                    encode.throwException();
                }
                CoderResult flush = encoder.flush(internalNioBuffer);
                if (!flush.isUnderflow()) {
                    flush.throwException();
                }
                buffer.writerIndex((buffer.writerIndex() + internalNioBuffer.position()) - position);
                return buffer;
            } catch (CharacterCodingException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    public static boolean equals(ByteBuf byteBuf, int i4, ByteBuf byteBuf2, int i5, int i6) {
        if (i4 >= 0 && i5 >= 0 && i6 >= 0) {
            if (byteBuf.writerIndex() - i6 < i4 || byteBuf2.writerIndex() - i6 < i5) {
                return false;
            }
            int i7 = i6 >>> 3;
            if (byteBuf.order() == byteBuf2.order()) {
                while (i7 > 0) {
                    if (byteBuf.getLong(i4) != byteBuf2.getLong(i5)) {
                        return false;
                    }
                    i4 += 8;
                    i5 += 8;
                    i7--;
                }
            } else {
                while (i7 > 0) {
                    if (byteBuf.getLong(i4) != swapLong(byteBuf2.getLong(i5))) {
                        return false;
                    }
                    i4 += 8;
                    i5 += 8;
                    i7--;
                }
            }
            for (int i8 = i6 & 7; i8 > 0; i8--) {
                if (byteBuf.getByte(i4) != byteBuf2.getByte(i5)) {
                    return false;
                }
                i4++;
                i5++;
            }
            return true;
        }
        throw new IllegalArgumentException("All indexes and lengths must be non-negative");
    }

    private static int firstIndexOf(ByteBuf byteBuf, int i4, int i5, byte b4) {
        int max = Math.max(i4, 0);
        if (max >= i5 || byteBuf.capacity() == 0) {
            return -1;
        }
        return byteBuf.forEachByte(max, i5 - max, new ByteProcessor.IndexOfProcessor(b4));
    }

    public static byte[] getBytes(ByteBuf byteBuf) {
        return getBytes(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static int hashCode(ByteBuf byteBuf) {
        int i4;
        int readableBytes = byteBuf.readableBytes();
        int i5 = readableBytes >>> 2;
        int i6 = readableBytes & 3;
        int readerIndex = byteBuf.readerIndex();
        if (byteBuf.order() == ByteOrder.BIG_ENDIAN) {
            i4 = 1;
            while (i5 > 0) {
                i4 = (i4 * 31) + byteBuf.getInt(readerIndex);
                readerIndex += 4;
                i5--;
            }
        } else {
            i4 = 1;
            while (i5 > 0) {
                i4 = (i4 * 31) + swapInt(byteBuf.getInt(readerIndex));
                readerIndex += 4;
                i5--;
            }
        }
        while (i6 > 0) {
            i4 = (i4 * 31) + byteBuf.getByte(readerIndex);
            i6--;
            readerIndex++;
        }
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    public static String hexDump(ByteBuf byteBuf) {
        return hexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static int indexOf(ByteBuf byteBuf, int i4, int i5, byte b4) {
        if (i4 <= i5) {
            return firstIndexOf(byteBuf, i4, i5, b4);
        }
        return lastIndexOf(byteBuf, i4, i5, b4);
    }

    private static boolean isAscii(ByteBuf byteBuf, int i4, int i5) {
        return byteBuf.forEachByte(i4, i5, FIND_NON_ASCII) == -1;
    }

    public static boolean isText(ByteBuf byteBuf, Charset charset) {
        return isText(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes(), charset);
    }

    private static boolean isUtf8(ByteBuf byteBuf, int i4, int i5) {
        int i6;
        int i7 = i5 + i4;
        while (i4 < i7) {
            int i8 = i4 + 1;
            byte b4 = byteBuf.getByte(i4);
            if ((b4 & 128) == 0) {
                i4 = i8;
            } else if ((b4 & 224) == 192) {
                if (i8 >= i7) {
                    return false;
                }
                int i9 = i8 + 1;
                if ((byteBuf.getByte(i8) & 192) != 128 || (b4 & 255) < 194) {
                    return false;
                }
                i4 = i9;
            } else if ((b4 & 240) != 224) {
                if ((b4 & 248) != 240 || i8 > i7 - 3) {
                    return false;
                }
                int i10 = i8 + 1;
                byte b5 = byteBuf.getByte(i8);
                int i11 = i10 + 1;
                byte b6 = byteBuf.getByte(i10);
                int i12 = i11 + 1;
                byte b7 = byteBuf.getByte(i11);
                if ((b5 & 192) == 128 && (b6 & 192) == 128 && (b7 & 192) == 128 && (i6 = b4 & 255) <= 244 && ((i6 != 240 || (b5 & 255) >= 144) && (i6 != 244 || (b5 & 255) <= 143))) {
                    i4 = i12;
                }
                return false;
            } else if (i8 > i7 - 2) {
                return false;
            } else {
                int i13 = i8 + 1;
                byte b8 = byteBuf.getByte(i8);
                int i14 = i13 + 1;
                byte b9 = byteBuf.getByte(i13);
                if ((b8 & 192) != 128 || (b9 & 192) != 128) {
                    return false;
                }
                int i15 = b4 & 15;
                if (i15 == 0 && (b8 & 255) < 160) {
                    return false;
                }
                if (i15 == 13 && (b8 & 255) > 159) {
                    return false;
                }
                i4 = i14;
            }
        }
        return true;
    }

    private static int lastIndexOf(ByteBuf byteBuf, int i4, int i5, byte b4) {
        int min = Math.min(i4, byteBuf.capacity());
        if (min < 0 || byteBuf.capacity() == 0) {
            return -1;
        }
        return byteBuf.forEachByteDesc(i5, min - i5, new ByteProcessor.IndexOfProcessor(b4));
    }

    public static String prettyHexDump(ByteBuf byteBuf) {
        return prettyHexDump(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public static ByteBuf readBytes(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int i4) {
        ByteBuf buffer = byteBufAllocator.buffer(i4);
        try {
            byteBuf.readBytes(buffer);
            return buffer;
        } catch (Throwable th) {
            buffer.release();
            throw th;
        }
    }

    public static int swapInt(int i4) {
        return Integer.reverseBytes(i4);
    }

    public static long swapLong(long j4) {
        return Long.reverseBytes(j4);
    }

    public static int swapMedium(int i4) {
        int i5 = ((i4 >>> 16) & 255) | ((i4 << 16) & 16711680) | (65280 & i4);
        return (8388608 & i5) != 0 ? i5 | (-16777216) : i5;
    }

    public static short swapShort(short s3) {
        return Short.reverseBytes(s3);
    }

    public static ByteBuf threadLocalDirectBuffer() {
        if (THREAD_LOCAL_BUFFER_SIZE <= 0) {
            return null;
        }
        if (PlatformDependent.hasUnsafe()) {
            return ThreadLocalUnsafeDirectByteBuf.newInstance();
        }
        return ThreadLocalDirectByteBuf.newInstance();
    }

    public static int utf8MaxBytes(CharSequence charSequence) {
        return charSequence.length() * MAX_BYTES_PER_CHAR_UTF8;
    }

    public static ByteBuf writeAscii(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf buffer = byteBufAllocator.buffer(charSequence.length());
        writeAscii(buffer, charSequence);
        return buffer;
    }

    public static ByteBuf writeUtf8(ByteBufAllocator byteBufAllocator, CharSequence charSequence) {
        ByteBuf buffer = byteBufAllocator.buffer(utf8MaxBytes(charSequence));
        writeUtf8(buffer, charSequence);
        return buffer;
    }

    public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf, int i4, int i5) {
        HexUtil.appendPrettyHexDump(sb, byteBuf, i4, i5);
    }

    public static ByteBuf encodeString(ByteBufAllocator byteBufAllocator, CharBuffer charBuffer, Charset charset, int i4) {
        return encodeString0(byteBufAllocator, false, charBuffer, charset, i4);
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i4, int i5) {
        return getBytes(byteBuf, i4, i5, true);
    }

    public static String hexDump(ByteBuf byteBuf, int i4, int i5) {
        return HexUtil.hexDump(byteBuf, i4, i5);
    }

    public static boolean isText(ByteBuf byteBuf, int i4, int i5, Charset charset) {
        ObjectUtil.checkNotNull(byteBuf, "buf");
        ObjectUtil.checkNotNull(charset, "charset");
        int readerIndex = byteBuf.readerIndex() + byteBuf.readableBytes();
        if (i4 >= 0 && i5 >= 0 && i4 <= readerIndex - i5) {
            if (charset.equals(CharsetUtil.UTF_8)) {
                return isUtf8(byteBuf, i4, i5);
            }
            if (charset.equals(CharsetUtil.US_ASCII)) {
                return isAscii(byteBuf, i4, i5);
            }
            CodingErrorAction codingErrorAction = CodingErrorAction.REPORT;
            CharsetDecoder decoder = CharsetUtil.decoder(charset, codingErrorAction, codingErrorAction);
            try {
                if (byteBuf.nioBufferCount() == 1) {
                    decoder.decode(byteBuf.internalNioBuffer(i4, i5));
                } else {
                    ByteBuf heapBuffer = byteBuf.alloc().heapBuffer(i5);
                    heapBuffer.writeBytes(byteBuf, i4, i5);
                    decoder.decode(heapBuffer.internalNioBuffer(0, i5));
                    heapBuffer.release();
                }
                return true;
            } catch (CharacterCodingException unused) {
                return false;
            }
        }
        throw new IndexOutOfBoundsException("index: " + i4 + " length: " + i5);
    }

    public static String prettyHexDump(ByteBuf byteBuf, int i4, int i5) {
        return HexUtil.prettyHexDump(byteBuf, i4, i5);
    }

    public static byte[] getBytes(ByteBuf byteBuf, int i4, int i5, boolean z3) {
        if (!MathUtil.isOutOfBounds(i4, i5, byteBuf.capacity())) {
            if (byteBuf.hasArray()) {
                if (!z3 && i4 == 0 && i5 == byteBuf.capacity()) {
                    return byteBuf.array();
                }
                int arrayOffset = byteBuf.arrayOffset() + i4;
                return Arrays.copyOfRange(byteBuf.array(), arrayOffset, i5 + arrayOffset);
            }
            byte[] bArr = new byte[i5];
            byteBuf.getBytes(i4, bArr);
            return bArr;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i4 + ") <= start + length(" + i5 + ") <= buf.capacity(" + byteBuf.capacity() + ')');
    }

    public static String hexDump(byte[] bArr) {
        return hexDump(bArr, 0, bArr.length);
    }

    public static int writeAscii(ByteBuf byteBuf, CharSequence charSequence) {
        int length = charSequence.length();
        byteBuf.ensureWritable(length);
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            byteBuf.writeBytes(asciiString.array(), asciiString.arrayOffset(), asciiString.length());
            return length;
        }
        while (!(byteBuf instanceof AbstractByteBuf)) {
            if (byteBuf instanceof WrappedByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                byteBuf.writeBytes(charSequence.toString().getBytes(CharsetUtil.US_ASCII));
            }
        }
        AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
        int writeAscii = writeAscii(abstractByteBuf, abstractByteBuf.writerIndex, charSequence, length);
        abstractByteBuf.writerIndex += writeAscii;
        return writeAscii;
    }

    public static int writeUtf8(ByteBuf byteBuf, CharSequence charSequence) {
        int length = charSequence.length();
        byteBuf.ensureWritable(utf8MaxBytes(charSequence));
        while (!(byteBuf instanceof AbstractByteBuf)) {
            if (byteBuf instanceof WrappedByteBuf) {
                byteBuf = byteBuf.unwrap();
            } else {
                byte[] bytes = charSequence.toString().getBytes(CharsetUtil.UTF_8);
                byteBuf.writeBytes(bytes);
                return bytes.length;
            }
        }
        AbstractByteBuf abstractByteBuf = (AbstractByteBuf) byteBuf;
        int writeUtf8 = writeUtf8(abstractByteBuf, abstractByteBuf.writerIndex, charSequence, length);
        abstractByteBuf.writerIndex += writeUtf8;
        return writeUtf8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class HexUtil {
        private static final char[] BYTE2CHAR = new char[256];
        private static final char[] HEXDUMP_TABLE = new char[1024];
        private static final String[] HEXPADDING = new String[16];
        private static final String[] HEXDUMP_ROWPREFIXES = new String[4096];
        private static final String[] BYTE2HEX = new String[256];
        private static final String[] BYTEPADDING = new String[16];

        static {
            char[] charArray = "0123456789abcdef".toCharArray();
            int i4 = 0;
            for (int i5 = 0; i5 < 256; i5++) {
                char[] cArr = HEXDUMP_TABLE;
                int i6 = i5 << 1;
                cArr[i6] = charArray[(i5 >>> 4) & 15];
                cArr[i6 + 1] = charArray[i5 & 15];
            }
            int i7 = 0;
            while (true) {
                String[] strArr = HEXPADDING;
                if (i7 >= strArr.length) {
                    break;
                }
                int length = strArr.length - i7;
                StringBuilder sb = new StringBuilder(length * 3);
                for (int i8 = 0; i8 < length; i8++) {
                    sb.append("   ");
                }
                HEXPADDING[i7] = sb.toString();
                i7++;
            }
            int i9 = 0;
            while (true) {
                String[] strArr2 = HEXDUMP_ROWPREFIXES;
                if (i9 >= strArr2.length) {
                    break;
                }
                StringBuilder sb2 = new StringBuilder(12);
                sb2.append(StringUtil.NEWLINE);
                sb2.append(Long.toHexString(((i9 << 4) & 4294967295L) | 4294967296L));
                sb2.setCharAt(sb2.length() - 9, '|');
                sb2.append('|');
                strArr2[i9] = sb2.toString();
                i9++;
            }
            int i10 = 0;
            while (true) {
                String[] strArr3 = BYTE2HEX;
                if (i10 >= strArr3.length) {
                    break;
                }
                strArr3[i10] = ' ' + StringUtil.byteToHexStringPadded(i10);
                i10++;
            }
            int i11 = 0;
            while (true) {
                String[] strArr4 = BYTEPADDING;
                if (i11 >= strArr4.length) {
                    break;
                }
                int length2 = strArr4.length - i11;
                StringBuilder sb3 = new StringBuilder(length2);
                for (int i12 = 0; i12 < length2; i12++) {
                    sb3.append(' ');
                }
                BYTEPADDING[i11] = sb3.toString();
                i11++;
            }
            while (true) {
                char[] cArr2 = BYTE2CHAR;
                if (i4 >= cArr2.length) {
                    return;
                }
                if (i4 > 31 && i4 < 127) {
                    cArr2[i4] = (char) i4;
                } else {
                    cArr2[i4] = '.';
                }
                i4++;
            }
        }

        private HexUtil() {
        }

        private static void appendHexDumpRowPrefix(StringBuilder sb, int i4, int i5) {
            String[] strArr = HEXDUMP_ROWPREFIXES;
            if (i4 < strArr.length) {
                sb.append(strArr[i4]);
                return;
            }
            sb.append(StringUtil.NEWLINE);
            sb.append(Long.toHexString((i5 & 4294967295L) | 4294967296L));
            sb.setCharAt(sb.length() - 9, '|');
            sb.append('|');
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void appendPrettyHexDump(StringBuilder sb, ByteBuf byteBuf, int i4, int i5) {
            if (MathUtil.isOutOfBounds(i4, i5, byteBuf.capacity())) {
                throw new IndexOutOfBoundsException("expected: 0 <= offset(" + i4 + ") <= offset + length(" + i5 + ") <= buf.capacity(" + byteBuf.capacity() + ')');
            } else if (i5 != 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("         +-------------------------------------------------+");
                String str = StringUtil.NEWLINE;
                sb2.append(str);
                sb2.append("         |  0  1  2  3  4  5  6  7  8  9  a  b  c  d  e  f |");
                sb2.append(str);
                sb2.append("+--------+-------------------------------------------------+----------------+");
                sb.append(sb2.toString());
                int i6 = i5 >>> 4;
                int i7 = i5 & 15;
                for (int i8 = 0; i8 < i6; i8++) {
                    int i9 = (i8 << 4) + i4;
                    appendHexDumpRowPrefix(sb, i8, i9);
                    int i10 = i9 + 16;
                    for (int i11 = i9; i11 < i10; i11++) {
                        sb.append(BYTE2HEX[byteBuf.getUnsignedByte(i11)]);
                    }
                    sb.append(" |");
                    while (i9 < i10) {
                        sb.append(BYTE2CHAR[byteBuf.getUnsignedByte(i9)]);
                        i9++;
                    }
                    sb.append('|');
                }
                if (i7 != 0) {
                    int i12 = (i6 << 4) + i4;
                    appendHexDumpRowPrefix(sb, i6, i12);
                    int i13 = i12 + i7;
                    for (int i14 = i12; i14 < i13; i14++) {
                        sb.append(BYTE2HEX[byteBuf.getUnsignedByte(i14)]);
                    }
                    sb.append(HEXPADDING[i7]);
                    sb.append(" |");
                    while (i12 < i13) {
                        sb.append(BYTE2CHAR[byteBuf.getUnsignedByte(i12)]);
                        i12++;
                    }
                    sb.append(BYTEPADDING[i7]);
                    sb.append('|');
                }
                sb.append(StringUtil.NEWLINE + "+--------+-------------------------------------------------+----------------+");
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(ByteBuf byteBuf, int i4, int i5) {
            if (i5 < 0) {
                throw new IllegalArgumentException("length: " + i5);
            } else if (i5 == 0) {
                return "";
            } else {
                int i6 = i4 + i5;
                char[] cArr = new char[i5 << 1];
                int i7 = 0;
                while (i4 < i6) {
                    System.arraycopy(HEXDUMP_TABLE, byteBuf.getUnsignedByte(i4) << 1, cArr, i7, 2);
                    i4++;
                    i7 += 2;
                }
                return new String(cArr);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String prettyHexDump(ByteBuf byteBuf, int i4, int i5) {
            if (i5 == 0) {
                return "";
            }
            StringBuilder sb = new StringBuilder(((i5 / 16) + (i5 % 15 == 0 ? 0 : 1) + 4) * 80);
            appendPrettyHexDump(sb, byteBuf, i4, i5);
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String hexDump(byte[] bArr, int i4, int i5) {
            if (i5 < 0) {
                throw new IllegalArgumentException("length: " + i5);
            } else if (i5 == 0) {
                return "";
            } else {
                int i6 = i4 + i5;
                char[] cArr = new char[i5 << 1];
                int i7 = 0;
                while (i4 < i6) {
                    System.arraycopy(HEXDUMP_TABLE, (bArr[i4] & 255) << 1, cArr, i7, 2);
                    i4++;
                    i7 += 2;
                }
                return new String(cArr);
            }
        }
    }

    public static void copy(AsciiString asciiString, int i4, ByteBuf byteBuf, int i5) {
        if (!MathUtil.isOutOfBounds(i4, i5, asciiString.length())) {
            ((ByteBuf) ObjectUtil.checkNotNull(byteBuf, "dst")).writeBytes(asciiString.array(), i4 + asciiString.arrayOffset(), i5);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i4 + ") <= srcIdx + length(" + i5 + ") <= srcLen(" + asciiString.length() + ')');
    }

    public static String hexDump(byte[] bArr, int i4, int i5) {
        return HexUtil.hexDump(bArr, i4, i5);
    }

    public static boolean equals(ByteBuf byteBuf, ByteBuf byteBuf2) {
        int readableBytes = byteBuf.readableBytes();
        if (readableBytes != byteBuf2.readableBytes()) {
            return false;
        }
        return equals(byteBuf, byteBuf.readerIndex(), byteBuf2, byteBuf2.readerIndex(), readableBytes);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int writeUtf8(AbstractByteBuf abstractByteBuf, int i4, CharSequence charSequence, int i5) {
        int i6 = 0;
        int i7 = i4;
        while (i6 < i5) {
            char charAt = charSequence.charAt(i6);
            if (charAt < '\u0080') {
                abstractByteBuf._setByte(i7, (byte) charAt);
                i7++;
            } else if (charAt < '\u0800') {
                int i8 = i7 + 1;
                abstractByteBuf._setByte(i7, (byte) ((charAt >> 6) | 192));
                i7 = i8 + 1;
                abstractByteBuf._setByte(i8, (byte) ((charAt & '?') | 128));
            } else {
                if (StringUtil.isSurrogate(charAt)) {
                    if (!Character.isHighSurrogate(charAt)) {
                        abstractByteBuf._setByte(i7, 63);
                        i7++;
                    } else {
                        i6++;
                        try {
                            char charAt2 = charSequence.charAt(i6);
                            if (!Character.isLowSurrogate(charAt2)) {
                                int i9 = i7 + 1;
                                abstractByteBuf._setByte(i7, 63);
                                i7 = i9 + 1;
                                abstractByteBuf._setByte(i9, Character.isHighSurrogate(charAt2) ? '?' : charAt2);
                            } else {
                                int codePoint = Character.toCodePoint(charAt, charAt2);
                                int i10 = i7 + 1;
                                abstractByteBuf._setByte(i7, (byte) ((codePoint >> 18) | 240));
                                int i11 = i10 + 1;
                                abstractByteBuf._setByte(i10, (byte) (((codePoint >> 12) & 63) | 128));
                                int i12 = i11 + 1;
                                abstractByteBuf._setByte(i11, (byte) (((codePoint >> 6) & 63) | 128));
                                i7 = i12 + 1;
                                abstractByteBuf._setByte(i12, (byte) ((codePoint & 63) | 128));
                            }
                        } catch (IndexOutOfBoundsException unused) {
                            abstractByteBuf._setByte(i7, 63);
                            i7++;
                        }
                    }
                } else {
                    int i13 = i7 + 1;
                    abstractByteBuf._setByte(i7, (byte) ((charAt >> '\f') | 224));
                    int i14 = i13 + 1;
                    abstractByteBuf._setByte(i13, (byte) ((63 & (charAt >> 6)) | 128));
                    abstractByteBuf._setByte(i14, (byte) ((charAt & '?') | 128));
                    i7 = i14 + 1;
                }
            }
            i6++;
        }
        return i7 - i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int writeAscii(AbstractByteBuf abstractByteBuf, int i4, CharSequence charSequence, int i5) {
        int i6 = 0;
        while (i6 < i5) {
            abstractByteBuf._setByte(i4, (byte) charSequence.charAt(i6));
            i6++;
            i4++;
        }
        return i5;
    }

    private static void decodeString(CharsetDecoder charsetDecoder, ByteBuffer byteBuffer, CharBuffer charBuffer) {
        try {
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, true);
            if (!decode.isUnderflow()) {
                decode.throwException();
            }
            CoderResult flush = charsetDecoder.flush(charBuffer);
            if (flush.isUnderflow()) {
                return;
            }
            flush.throwException();
        } catch (CharacterCodingException e4) {
            throw new IllegalStateException(e4);
        }
    }
}
