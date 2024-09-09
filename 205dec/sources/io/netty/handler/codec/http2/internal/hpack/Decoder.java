package io.netty.handler.codec.http2.internal.hpack;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.Http2Error;
import io.netty.handler.codec.http2.Http2Exception;
import io.netty.handler.codec.http2.Http2Headers;
import io.netty.handler.codec.http2.internal.hpack.HpackUtil;
import io.netty.util.AsciiString;
import io.netty.util.internal.ThrowableUtil;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
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
    /* renamed from: io.netty.handler.codec.http2.internal.hpack.Decoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            $SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType = iArr;
            try {
                iArr[HpackUtil.IndexType.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType[HpackUtil.IndexType.NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 3;
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

    public Decoder(int i4, int i5, int i6) {
        this.dynamicTable = new DynamicTable(i5);
        this.maxHeadersLength = i4;
        this.maxDynamicTableSize = i5;
        this.encoderMaxDynamicTableSize = i5;
        this.huffmanDecoder = new HuffmanDecoder(i6);
    }

    private int addHeader(Http2Headers http2Headers, CharSequence charSequence, CharSequence charSequence2, int i4) throws Http2Exception {
        long length = i4 + charSequence.length() + charSequence2.length();
        if (length > this.maxHeadersLength) {
            maxHeaderSizeExceeded();
        }
        http2Headers.add((Http2Headers) charSequence, charSequence2);
        return (int) length;
    }

    private static int decodeULE128(ByteBuf byteBuf) throws Http2Exception {
        int writerIndex = byteBuf.writerIndex();
        int readerIndex = byteBuf.readerIndex();
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (readerIndex >= writerIndex) {
                break;
            }
            byte b4 = byteBuf.getByte(readerIndex);
            if (i4 == 28 && (b4 & 248) != 0) {
                byteBuf.readerIndex(readerIndex + 1);
                break;
            } else if ((b4 & 128) == 0) {
                byteBuf.readerIndex(readerIndex + 1);
                return ((b4 & Byte.MAX_VALUE) << i4) | i5;
            } else {
                i5 |= (b4 & Byte.MAX_VALUE) << i4;
                readerIndex++;
                i4 += 7;
            }
        }
        throw DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
    }

    private int indexHeader(int i4, Http2Headers http2Headers, int i5) throws Http2Exception {
        int i6 = StaticTable.length;
        if (i4 <= i6) {
            HeaderField entry = StaticTable.getEntry(i4);
            return addHeader(http2Headers, entry.name, entry.value, i5);
        } else if (i4 - i6 <= this.dynamicTable.length()) {
            HeaderField entry2 = this.dynamicTable.getEntry(i4 - i6);
            return addHeader(http2Headers, entry2.name, entry2.value, i5);
        } else {
            throw INDEX_HEADER_ILLEGAL_INDEX_VALUE;
        }
    }

    private int insertHeader(Http2Headers http2Headers, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType, int i4) throws Http2Exception {
        int addHeader = addHeader(http2Headers, charSequence, charSequence2, i4);
        int i5 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType[indexType.ordinal()];
        if (i5 != 1 && i5 != 2) {
            if (i5 == 3) {
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

    private CharSequence readName(int i4) throws Http2Exception {
        int i5 = StaticTable.length;
        if (i4 <= i5) {
            return StaticTable.getEntry(i4).name;
        }
        if (i4 - i5 <= this.dynamicTable.length()) {
            return this.dynamicTable.getEntry(i4 - i5).name;
        }
        throw READ_NAME_ILLEGAL_INDEX_VALUE;
    }

    private CharSequence readStringLiteral(ByteBuf byteBuf, int i4, boolean z3) throws Http2Exception {
        if (z3) {
            return this.huffmanDecoder.decode(byteBuf, i4);
        }
        byte[] bArr = new byte[i4];
        byteBuf.readBytes(bArr);
        return new AsciiString(bArr, false);
    }

    private void setDynamicTableSize(int i4) throws Http2Exception {
        if (i4 <= this.maxDynamicTableSize) {
            this.encoderMaxDynamicTableSize = i4;
            this.maxDynamicTableSizeChangeRequired = false;
            this.dynamicTable.setCapacity(i4);
            return;
        }
        throw INVALID_MAX_DYNAMIC_TABLE_SIZE;
    }

    public void decode(ByteBuf byteBuf, Http2Headers http2Headers) throws Http2Exception {
        int i4;
        boolean z3;
        int i5;
        int i6;
        HpackUtil.IndexType indexType = HpackUtil.IndexType.NONE;
        CharSequence charSequence = null;
        int i7 = 0;
        boolean z4 = false;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (byteBuf.isReadable()) {
            switch (i7) {
                case 0:
                    z3 = z4;
                    i4 = i8;
                    i5 = i9;
                    byte readByte = byteBuf.readByte();
                    if (this.maxDynamicTableSizeChangeRequired && (readByte & 224) != 32) {
                        throw MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
                    }
                    if (readByte < 0) {
                        int i12 = readByte & Byte.MAX_VALUE;
                        if (i12 == 0) {
                            throw DECODE_ILLEGAL_INDEX_VALUE;
                        }
                        if (i12 != 127) {
                            i10 = indexHeader(i12, http2Headers, i10);
                        } else {
                            i7 = 2;
                        }
                        i11 = i12;
                        z4 = z3;
                        i9 = i5;
                        i8 = i4;
                        break;
                    } else if ((readByte & 64) == 64) {
                        indexType = HpackUtil.IndexType.INCREMENTAL;
                        i6 = readByte & 63;
                        if (i6 == 0) {
                            i11 = i6;
                            z4 = z3;
                            i9 = i5;
                            i8 = i4;
                            i7 = 4;
                            break;
                        } else if (i6 == 63) {
                            i11 = i6;
                            z4 = z3;
                            i9 = i5;
                            i8 = i4;
                            i7 = 3;
                            break;
                        } else {
                            charSequence = readName(i6);
                            i11 = i6;
                            z4 = z3;
                            i9 = i5;
                            i8 = i4;
                            i7 = 7;
                            break;
                        }
                    } else if ((readByte & 32) == 32) {
                        int i13 = readByte & 31;
                        if (i13 != 31) {
                            setDynamicTableSize(i13);
                            i11 = i13;
                            z4 = z3;
                            i9 = i5;
                            i8 = i4;
                            i7 = 0;
                            break;
                        } else {
                            i11 = i13;
                            z4 = z3;
                            i9 = i5;
                            i8 = i4;
                            i7 = 1;
                            break;
                        }
                    } else {
                        indexType = (readByte & 16) == 16 ? HpackUtil.IndexType.NEVER : HpackUtil.IndexType.NONE;
                        i6 = readByte & 15;
                        if (i6 == 0) {
                            i11 = i6;
                            z4 = z3;
                            i9 = i5;
                            i8 = i4;
                            i7 = 4;
                        } else if (i6 != 15) {
                            charSequence = readName(i6);
                            i11 = i6;
                            z4 = z3;
                            i9 = i5;
                            i8 = i4;
                            i7 = 7;
                        } else {
                            i11 = i6;
                            z4 = z3;
                            i9 = i5;
                            i8 = i4;
                            i7 = 3;
                        }
                    }
                    break;
                case 1:
                    z3 = z4;
                    i4 = i8;
                    i5 = i9;
                    int decodeULE128 = decodeULE128(byteBuf) + i11;
                    if (decodeULE128 >= 0) {
                        setDynamicTableSize(decodeULE128);
                        z4 = z3;
                        i9 = i5;
                        i8 = i4;
                        i7 = 0;
                        break;
                    } else {
                        throw DECODE_DECOMPRESSION_EXCEPTION;
                    }
                case 2:
                    z3 = z4;
                    i4 = i8;
                    i5 = i9;
                    int decodeULE1282 = decodeULE128(byteBuf) + i11;
                    if (decodeULE1282 >= 0) {
                        i10 = indexHeader(decodeULE1282, http2Headers, i10);
                        z4 = z3;
                        i9 = i5;
                        i8 = i4;
                        i7 = 0;
                        break;
                    } else {
                        throw DECODE_DECOMPRESSION_EXCEPTION;
                    }
                case 3:
                    z3 = z4;
                    i4 = i8;
                    i5 = i9;
                    int decodeULE1283 = decodeULE128(byteBuf) + i11;
                    if (decodeULE1283 >= 0) {
                        charSequence = readName(decodeULE1283);
                        z4 = z3;
                        i9 = i5;
                        i8 = i4;
                        i7 = 7;
                        break;
                    } else {
                        throw DECODE_DECOMPRESSION_EXCEPTION;
                    }
                case 4:
                    i4 = i8;
                    i5 = i9;
                    byte readByte2 = byteBuf.readByte();
                    z4 = (readByte2 & 128) == 128;
                    i9 = readByte2 & Byte.MAX_VALUE;
                    if (i9 != 127) {
                        if (i9 > this.maxHeadersLength - i10) {
                            maxHeaderSizeExceeded();
                        }
                        i11 = i9;
                        i8 = i4;
                        i7 = 6;
                        break;
                    } else {
                        i7 = 5;
                        i11 = i9;
                        i9 = i5;
                        i8 = i4;
                        break;
                    }
                case 5:
                    boolean z5 = z4;
                    i4 = i8;
                    i9 = decodeULE128(byteBuf) + i11;
                    if (i9 >= 0) {
                        if (i9 > this.maxHeadersLength - i10) {
                            maxHeaderSizeExceeded();
                        }
                        z4 = z5;
                        i8 = i4;
                        i7 = 6;
                        break;
                    } else {
                        throw DECODE_DECOMPRESSION_EXCEPTION;
                    }
                case 6:
                    z3 = z4;
                    i4 = i8;
                    i5 = i9;
                    if (byteBuf.readableBytes() >= i5) {
                        charSequence = readStringLiteral(byteBuf, i5, z3);
                        z4 = z3;
                        i9 = i5;
                        i8 = i4;
                        i7 = 7;
                        break;
                    } else {
                        throw notEnoughDataException(byteBuf);
                    }
                case 7:
                    i4 = i8;
                    int i14 = i9;
                    byte readByte3 = byteBuf.readByte();
                    boolean z6 = (readByte3 & 128) == 128;
                    int i15 = readByte3 & Byte.MAX_VALUE;
                    if (i15 == 0) {
                        i10 = insertHeader(http2Headers, charSequence, AsciiString.EMPTY_STRING, indexType, i10);
                        z4 = z6;
                        i9 = i14;
                        i11 = i15;
                        i8 = i4;
                        i7 = 0;
                        break;
                    } else if (i15 == 127) {
                        i7 = 8;
                        z4 = z6;
                        i9 = i14;
                        i11 = i15;
                        i8 = i4;
                        break;
                    } else {
                        if (i15 + i14 > this.maxHeadersLength - i10) {
                            maxHeaderSizeExceeded();
                        }
                        z4 = z6;
                        i9 = i14;
                        i8 = i15;
                        i11 = i8;
                        i7 = 9;
                        break;
                    }
                case 8:
                    boolean z7 = z4;
                    int i16 = i9;
                    i8 = decodeULE128(byteBuf) + i11;
                    if (i8 >= 0) {
                        if (i8 + i16 > this.maxHeadersLength - i10) {
                            maxHeaderSizeExceeded();
                        }
                        i9 = i16;
                        z4 = z7;
                        i7 = 9;
                        break;
                    } else {
                        throw DECODE_DECOMPRESSION_EXCEPTION;
                    }
                case 9:
                    if (byteBuf.readableBytes() >= i8) {
                        i4 = i8;
                        i10 = insertHeader(http2Headers, charSequence, readStringLiteral(byteBuf, i8, z4), indexType, i10);
                        i9 = i9;
                        z4 = z4;
                        i8 = i4;
                        i7 = 0;
                        break;
                    } else {
                        throw notEnoughDataException(byteBuf);
                    }
                default:
                    throw new Error("should not reach here state: " + i7);
            }
        }
    }

    HeaderField getHeaderField(int i4) {
        return this.dynamicTable.getEntry(i4 + 1);
    }

    public int getMaxHeaderTableSize() {
        return this.dynamicTable.capacity();
    }

    int length() {
        return this.dynamicTable.length();
    }

    public void setMaxHeaderTableSize(int i4) {
        this.maxDynamicTableSize = i4;
        if (i4 < this.encoderMaxDynamicTableSize) {
            this.maxDynamicTableSizeChangeRequired = true;
            this.dynamicTable.setCapacity(i4);
        }
    }

    int size() {
        return this.dynamicTable.size();
    }
}
