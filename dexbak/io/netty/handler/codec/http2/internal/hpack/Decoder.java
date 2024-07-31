package io.netty.handler.codec.http2.internal.hpack;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.internal.hpack.HpackUtil;
import io.netty.util.AsciiString;
import io.netty.util.internal.ThrowableUtil;
import kotlin.jvm.internal.C14354n;
import okio.Utf8;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Decoder {
    private static final Http2Exception DECODE_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception DECODE_ILLEGAL_INDEX_VALUE;
    private static final Http2Exception DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
    private static final Http2Exception INDEX_HEADER_ILLEGAL_INDEX_VALUE;
    private static final Http2Exception INVALID_MAX_DYNAMIC_TABLE_SIZE;
    private static final Http2Exception MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
    private static final byte READ_HEADER_REPRESENTATION = 0;
    private static final byte READ_INDEXED_HEADER = 2;
    private static final byte READ_INDEXED_HEADER_NAME = 3;
    private static final byte READ_LITERAL_HEADER_NAME = 6;
    private static final byte READ_LITERAL_HEADER_NAME_LENGTH = 5;
    private static final byte READ_LITERAL_HEADER_NAME_LENGTH_PREFIX = 4;
    private static final byte READ_LITERAL_HEADER_VALUE = 9;
    private static final byte READ_LITERAL_HEADER_VALUE_LENGTH = 8;
    private static final byte READ_LITERAL_HEADER_VALUE_LENGTH_PREFIX = 7;
    private static final byte READ_MAX_DYNAMIC_TABLE_SIZE = 1;
    private static final Http2Exception READ_NAME_ILLEGAL_INDEX_VALUE;
    private final DynamicTable dynamicTable;
    private int encoderMaxDynamicTableSize;
    private final HuffmanDecoder huffmanDecoder;
    private int maxDynamicTableSize;
    private boolean maxDynamicTableSizeChangeRequired = false;
    private final int maxHeadersLength;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http2.internal.hpack.Decoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C138751 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType */
        static final /* synthetic */ int[] f40237xcc45a163;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            f40237xcc45a163 = iArr;
            try {
                iArr[HpackUtil.IndexType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40237xcc45a163[HpackUtil.IndexType.NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40237xcc45a163[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        Http2Error http2Error = Http2Error.COMPRESSION_ERROR;
        DECODE_DECOMPRESSION_EXCEPTION = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(http2Error, "HPACK - decompression failure", new Object[0]), Decoder.class, "decode(...)");
        DECODE_ULE_128_DECOMPRESSION_EXCEPTION = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(http2Error, "HPACK - decompression failure", new Object[0]), Decoder.class, "decodeULE128(...)");
        DECODE_ILLEGAL_INDEX_VALUE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(http2Error, "HPACK - illegal index value", new Object[0]), Decoder.class, "decode(...)");
        INDEX_HEADER_ILLEGAL_INDEX_VALUE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(http2Error, "HPACK - illegal index value", new Object[0]), Decoder.class, "indexHeader(...)");
        READ_NAME_ILLEGAL_INDEX_VALUE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(http2Error, "HPACK - illegal index value", new Object[0]), Decoder.class, "readName(...)");
        INVALID_MAX_DYNAMIC_TABLE_SIZE = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(http2Error, "HPACK - invalid max dynamic table size", new Object[0]), Decoder.class, "setDynamicTableSize(...)");
        MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED = (Http2Exception) ThrowableUtil.unknownStackTrace(Http2Exception.connectionError(http2Error, "HPACK - max dynamic table size change required", new Object[0]), Decoder.class, "decode(...)");
    }

    public Decoder(int i, int i2, int i3) {
        this.dynamicTable = new DynamicTable(i2);
        this.maxHeadersLength = i;
        this.maxDynamicTableSize = i2;
        this.encoderMaxDynamicTableSize = i2;
        this.huffmanDecoder = new HuffmanDecoder(i3);
    }

    private int addHeader(Http2Headers http2Headers, CharSequence charSequence, CharSequence charSequence2, int i) throws Http2Exception {
        long length = i + charSequence.length() + charSequence2.length();
        if (length > this.maxHeadersLength) {
            maxHeaderSizeExceeded();
        }
        http2Headers.add((Http2Headers) charSequence, charSequence2);
        return (int) length;
    }

    private static int decodeULE128(ByteBuf byteBuf) throws Http2Exception {
        int writerIndex = byteBuf.writerIndex();
        int readerIndex = byteBuf.readerIndex();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (readerIndex >= writerIndex) {
                break;
            }
            byte b = byteBuf.getByte(readerIndex);
            if (i == 28 && (b & 248) != 0) {
                byteBuf.readerIndex(readerIndex + 1);
                break;
            } else if ((b & 128) == 0) {
                byteBuf.readerIndex(readerIndex + 1);
                return ((b & C14354n.f41155b) << i) | i2;
            } else {
                i2 |= (b & C14354n.f41155b) << i;
                readerIndex++;
                i += 7;
            }
        }
        throw DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
    }

    private int indexHeader(int i, Http2Headers http2Headers, int i2) throws Http2Exception {
        int i3 = StaticTable.length;
        if (i <= i3) {
            HeaderField entry = StaticTable.getEntry(i);
            return addHeader(http2Headers, entry.name, entry.value, i2);
        } else if (i - i3 <= this.dynamicTable.length()) {
            HeaderField entry2 = this.dynamicTable.getEntry(i - i3);
            return addHeader(http2Headers, entry2.name, entry2.value, i2);
        } else {
            throw INDEX_HEADER_ILLEGAL_INDEX_VALUE;
        }
    }

    private int insertHeader(Http2Headers http2Headers, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType, int i) throws Http2Exception {
        int addHeader = addHeader(http2Headers, charSequence, charSequence2, i);
        int i2 = C138751.f40237xcc45a163[indexType.ordinal()];
        if (i2 != 1 && i2 != 2) {
            if (i2 == 3) {
                this.dynamicTable.add(new HeaderField(charSequence, charSequence2));
            } else {
                throw new Error("should not reach here");
            }
        }
        return addHeader;
    }

    private void maxHeaderSizeExceeded() throws Http2Exception {
        throw Http2Exception.connectionError(Http2Error.ENHANCE_YOUR_CALM, "Header size exceeded max allowed bytes (%d)", Integer.valueOf(this.maxHeadersLength));
    }

    private static IllegalArgumentException notEnoughDataException(ByteBuf byteBuf) {
        return new IllegalArgumentException("decode only works with an entire header block! " + byteBuf);
    }

    private CharSequence readName(int i) throws Http2Exception {
        int i2 = StaticTable.length;
        if (i <= i2) {
            return StaticTable.getEntry(i).name;
        }
        if (i - i2 <= this.dynamicTable.length()) {
            return this.dynamicTable.getEntry(i - i2).name;
        }
        throw READ_NAME_ILLEGAL_INDEX_VALUE;
    }

    private CharSequence readStringLiteral(ByteBuf byteBuf, int i, boolean z) throws Http2Exception {
        if (z) {
            return this.huffmanDecoder.decode(byteBuf, i);
        }
        byte[] bArr = new byte[i];
        byteBuf.readBytes(bArr);
        return new AsciiString(bArr, false);
    }

    private void setDynamicTableSize(int i) throws Http2Exception {
        if (i <= this.maxDynamicTableSize) {
            this.encoderMaxDynamicTableSize = i;
            this.maxDynamicTableSizeChangeRequired = false;
            this.dynamicTable.setCapacity(i);
            return;
        }
        throw INVALID_MAX_DYNAMIC_TABLE_SIZE;
    }

    public void decode(ByteBuf byteBuf, Http2Headers http2Headers) throws Http2Exception {
        int i;
        boolean z;
        int i2;
        int i3;
        HpackUtil.IndexType indexType = HpackUtil.IndexType.NONE;
        CharSequence charSequence = null;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (byteBuf.isReadable()) {
            switch (i4) {
                case 0:
                    z = z2;
                    i = i5;
                    i2 = i6;
                    byte readByte = byteBuf.readByte();
                    if (this.maxDynamicTableSizeChangeRequired && (readByte & 224) != 32) {
                        throw MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
                    }
                    if (readByte < 0) {
                        int i9 = readByte & C14354n.f41155b;
                        if (i9 == 0) {
                            throw DECODE_ILLEGAL_INDEX_VALUE;
                        }
                        if (i9 != 127) {
                            i7 = indexHeader(i9, http2Headers, i7);
                        } else {
                            i4 = 2;
                        }
                        i8 = i9;
                        z2 = z;
                        i6 = i2;
                        i5 = i;
                        break;
                    } else if ((readByte & 64) == 64) {
                        indexType = HpackUtil.IndexType.INCREMENTAL;
                        i3 = readByte & Utf8.REPLACEMENT_BYTE;
                        if (i3 == 0) {
                            i8 = i3;
                            z2 = z;
                            i6 = i2;
                            i5 = i;
                            i4 = 4;
                            break;
                        } else if (i3 == 63) {
                            i8 = i3;
                            z2 = z;
                            i6 = i2;
                            i5 = i;
                            i4 = 3;
                            break;
                        } else {
                            charSequence = readName(i3);
                            i8 = i3;
                            z2 = z;
                            i6 = i2;
                            i5 = i;
                            i4 = 7;
                            break;
                        }
                    } else if ((readByte & 32) == 32) {
                        int i10 = readByte & 31;
                        if (i10 != 31) {
                            setDynamicTableSize(i10);
                            i8 = i10;
                            z2 = z;
                            i6 = i2;
                            i5 = i;
                            i4 = 0;
                            break;
                        } else {
                            i8 = i10;
                            z2 = z;
                            i6 = i2;
                            i5 = i;
                            i4 = 1;
                            break;
                        }
                    } else {
                        indexType = (readByte & 16) == 16 ? HpackUtil.IndexType.NEVER : HpackUtil.IndexType.NONE;
                        i3 = readByte & 15;
                        if (i3 == 0) {
                            i8 = i3;
                            z2 = z;
                            i6 = i2;
                            i5 = i;
                            i4 = 4;
                        } else if (i3 != 15) {
                            charSequence = readName(i3);
                            i8 = i3;
                            z2 = z;
                            i6 = i2;
                            i5 = i;
                            i4 = 7;
                        } else {
                            i8 = i3;
                            z2 = z;
                            i6 = i2;
                            i5 = i;
                            i4 = 3;
                        }
                    }
                    break;
                case 1:
                    z = z2;
                    i = i5;
                    i2 = i6;
                    int decodeULE128 = decodeULE128(byteBuf) + i8;
                    if (decodeULE128 >= 0) {
                        setDynamicTableSize(decodeULE128);
                        z2 = z;
                        i6 = i2;
                        i5 = i;
                        i4 = 0;
                        break;
                    } else {
                        throw DECODE_DECOMPRESSION_EXCEPTION;
                    }
                case 2:
                    z = z2;
                    i = i5;
                    i2 = i6;
                    int decodeULE1282 = decodeULE128(byteBuf) + i8;
                    if (decodeULE1282 >= 0) {
                        i7 = indexHeader(decodeULE1282, http2Headers, i7);
                        z2 = z;
                        i6 = i2;
                        i5 = i;
                        i4 = 0;
                        break;
                    } else {
                        throw DECODE_DECOMPRESSION_EXCEPTION;
                    }
                case 3:
                    z = z2;
                    i = i5;
                    i2 = i6;
                    int decodeULE1283 = decodeULE128(byteBuf) + i8;
                    if (decodeULE1283 >= 0) {
                        charSequence = readName(decodeULE1283);
                        z2 = z;
                        i6 = i2;
                        i5 = i;
                        i4 = 7;
                        break;
                    } else {
                        throw DECODE_DECOMPRESSION_EXCEPTION;
                    }
                case 4:
                    i = i5;
                    i2 = i6;
                    byte readByte2 = byteBuf.readByte();
                    z2 = (readByte2 & 128) == 128;
                    i6 = readByte2 & C14354n.f41155b;
                    if (i6 != 127) {
                        if (i6 > this.maxHeadersLength - i7) {
                            maxHeaderSizeExceeded();
                        }
                        i8 = i6;
                        i5 = i;
                        i4 = 6;
                        break;
                    } else {
                        i4 = 5;
                        i8 = i6;
                        i6 = i2;
                        i5 = i;
                        break;
                    }
                case 5:
                    boolean z3 = z2;
                    i = i5;
                    i6 = decodeULE128(byteBuf) + i8;
                    if (i6 >= 0) {
                        if (i6 > this.maxHeadersLength - i7) {
                            maxHeaderSizeExceeded();
                        }
                        z2 = z3;
                        i5 = i;
                        i4 = 6;
                        break;
                    } else {
                        throw DECODE_DECOMPRESSION_EXCEPTION;
                    }
                case 6:
                    z = z2;
                    i = i5;
                    i2 = i6;
                    if (byteBuf.readableBytes() >= i2) {
                        charSequence = readStringLiteral(byteBuf, i2, z);
                        z2 = z;
                        i6 = i2;
                        i5 = i;
                        i4 = 7;
                        break;
                    } else {
                        throw notEnoughDataException(byteBuf);
                    }
                case 7:
                    i = i5;
                    int i11 = i6;
                    byte readByte3 = byteBuf.readByte();
                    boolean z4 = (readByte3 & 128) == 128;
                    int i12 = readByte3 & C14354n.f41155b;
                    if (i12 == 0) {
                        i7 = insertHeader(http2Headers, charSequence, AsciiString.EMPTY_STRING, indexType, i7);
                        z2 = z4;
                        i6 = i11;
                        i8 = i12;
                        i5 = i;
                        i4 = 0;
                        break;
                    } else if (i12 == 127) {
                        i4 = 8;
                        z2 = z4;
                        i6 = i11;
                        i8 = i12;
                        i5 = i;
                        break;
                    } else {
                        if (i12 + i11 > this.maxHeadersLength - i7) {
                            maxHeaderSizeExceeded();
                        }
                        z2 = z4;
                        i6 = i11;
                        i5 = i12;
                        i8 = i5;
                        i4 = 9;
                        break;
                    }
                case 8:
                    boolean z5 = z2;
                    int i13 = i6;
                    i5 = decodeULE128(byteBuf) + i8;
                    if (i5 >= 0) {
                        if (i5 + i13 > this.maxHeadersLength - i7) {
                            maxHeaderSizeExceeded();
                        }
                        i6 = i13;
                        z2 = z5;
                        i4 = 9;
                        break;
                    } else {
                        throw DECODE_DECOMPRESSION_EXCEPTION;
                    }
                case 9:
                    if (byteBuf.readableBytes() >= i5) {
                        i = i5;
                        i7 = insertHeader(http2Headers, charSequence, readStringLiteral(byteBuf, i5, z2), indexType, i7);
                        i6 = i6;
                        z2 = z2;
                        i5 = i;
                        i4 = 0;
                        break;
                    } else {
                        throw notEnoughDataException(byteBuf);
                    }
                default:
                    throw new Error("should not reach here state: " + i4);
            }
        }
    }

    HeaderField getHeaderField(int i) {
        return this.dynamicTable.getEntry(i + 1);
    }

    public int getMaxHeaderTableSize() {
        return this.dynamicTable.capacity();
    }

    int length() {
        return this.dynamicTable.length();
    }

    public void setMaxHeaderTableSize(int i) {
        this.maxDynamicTableSize = i;
        if (i < this.encoderMaxDynamicTableSize) {
            this.maxDynamicTableSizeChangeRequired = true;
            this.dynamicTable.setCapacity(i);
        }
    }

    int size() {
        return this.dynamicTable.size();
    }
}
