package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.HpackUtil;
import io.netty.handler.codec.http2.Http2HeadersEncoder;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.MathUtil;
import java.util.Arrays;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class HpackEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int HUFF_CODE_THRESHOLD = 512;
    private final byte hashMask;
    private final HeaderEntry head;
    private final HeaderEntry[] headerFields;
    private final HpackHuffmanEncoder hpackHuffmanEncoder;
    private final int huffCodeThreshold;
    private final boolean ignoreMaxHeaderListSize;
    private long maxHeaderListSize;
    private long maxHeaderTableSize;
    private long size;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http2.HpackEncoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType = iArr;
            try {
                iArr[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[HpackUtil.IndexType.NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class HeaderEntry extends HpackHeaderField {
        HeaderEntry after;
        HeaderEntry before;
        int hash;
        int index;
        HeaderEntry next;

        HeaderEntry(int i4, CharSequence charSequence, CharSequence charSequence2, int i5, HeaderEntry headerEntry) {
            super(charSequence, charSequence2);
            this.index = i5;
            this.hash = i4;
            this.next = headerEntry;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addBefore(HeaderEntry headerEntry) {
            this.after = headerEntry;
            HeaderEntry headerEntry2 = headerEntry.before;
            this.before = headerEntry2;
            headerEntry2.after = this;
            this.after.before = this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void remove() {
            HeaderEntry headerEntry = this.before;
            headerEntry.after = this.after;
            this.after.before = headerEntry;
            this.before = null;
            this.after = null;
            this.next = null;
        }
    }

    HpackEncoder() {
        this(false);
    }

    private void add(CharSequence charSequence, CharSequence charSequence2, long j4) {
        if (j4 > this.maxHeaderTableSize) {
            clear();
            return;
        }
        while (this.maxHeaderTableSize - this.size < j4) {
            remove();
        }
        int hashCode = AsciiString.hashCode(charSequence);
        int index = index(hashCode);
        HeaderEntry headerEntry = new HeaderEntry(hashCode, charSequence, charSequence2, this.head.before.index - 1, this.headerFields[index]);
        this.headerFields[index] = headerEntry;
        headerEntry.addBefore(this.head);
        this.size += j4;
    }

    private void clear() {
        Arrays.fill(this.headerFields, (Object) null);
        HeaderEntry headerEntry = this.head;
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.size = 0L;
    }

    private void encodeHeader(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, boolean z3, long j4) {
        if (z3) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NEVER, getNameIndex(charSequence));
            return;
        }
        long j5 = this.maxHeaderTableSize;
        if (j5 == 0) {
            int index = HpackStaticTable.getIndex(charSequence, charSequence2);
            if (index == -1) {
                encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NONE, HpackStaticTable.getIndex(charSequence));
                return;
            }
            encodeInteger(byteBuf, 128, 7, index);
        } else if (j4 > j5) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NONE, getNameIndex(charSequence));
        } else {
            HeaderEntry entry = getEntry(charSequence, charSequence2);
            if (entry != null) {
                encodeInteger(byteBuf, 128, 7, getIndex(entry.index) + HpackStaticTable.length);
                return;
            }
            int index2 = HpackStaticTable.getIndex(charSequence, charSequence2);
            if (index2 != -1) {
                encodeInteger(byteBuf, 128, 7, index2);
                return;
            }
            ensureCapacity(j4);
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.INCREMENTAL, getNameIndex(charSequence));
            add(charSequence, charSequence2, j4);
        }
    }

    private void encodeHeadersEnforceMaxHeaderListSize(int i4, ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        long j4 = 0;
        for (Map.Entry<CharSequence, CharSequence> entry : http2Headers) {
            j4 += HpackHeaderField.sizeOf(entry.getKey(), entry.getValue());
            long j5 = this.maxHeaderListSize;
            if (j4 > j5) {
                Http2CodecUtil.headerListSizeExceeded(i4, j5, false);
            }
        }
        encodeHeadersIgnoreMaxHeaderListSize(byteBuf, http2Headers, sensitivityDetector);
    }

    private void encodeHeadersIgnoreMaxHeaderListSize(ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        for (Map.Entry<CharSequence, CharSequence> entry : http2Headers) {
            CharSequence key = entry.getKey();
            CharSequence value = entry.getValue();
            encodeHeader(byteBuf, key, value, sensitivityDetector.isSensitive(key, value), HpackHeaderField.sizeOf(key, value));
        }
    }

    private static void encodeInteger(ByteBuf byteBuf, int i4, int i5, int i6) {
        encodeInteger(byteBuf, i4, i5, i6);
    }

    private void encodeLiteral(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType, int i4) {
        boolean z3 = i4 != -1;
        int i5 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[indexType.ordinal()];
        if (i5 == 1) {
            if (!z3) {
                i4 = 0;
            }
            encodeInteger(byteBuf, 64, 6, i4);
        } else if (i5 == 2) {
            if (!z3) {
                i4 = 0;
            }
            encodeInteger(byteBuf, 0, 4, i4);
        } else if (i5 == 3) {
            if (!z3) {
                i4 = 0;
            }
            encodeInteger(byteBuf, 16, 4, i4);
        } else {
            throw new Error("should not reach here");
        }
        if (!z3) {
            encodeStringLiteral(byteBuf, charSequence);
        }
        encodeStringLiteral(byteBuf, charSequence2);
    }

    private void encodeStringLiteral(ByteBuf byteBuf, CharSequence charSequence) {
        int encodedLength;
        if (charSequence.length() >= this.huffCodeThreshold && (encodedLength = this.hpackHuffmanEncoder.getEncodedLength(charSequence)) < charSequence.length()) {
            encodeInteger(byteBuf, 128, 7, encodedLength);
            this.hpackHuffmanEncoder.encode(byteBuf, charSequence);
            return;
        }
        encodeInteger(byteBuf, 0, 7, charSequence.length());
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            byteBuf.writeBytes(asciiString.array(), asciiString.arrayOffset(), asciiString.length());
            return;
        }
        byteBuf.writeCharSequence(charSequence, CharsetUtil.ISO_8859_1);
    }

    private void ensureCapacity(long j4) {
        while (this.maxHeaderTableSize - this.size < j4 && length() != 0) {
            remove();
        }
    }

    private HeaderEntry getEntry(CharSequence charSequence, CharSequence charSequence2) {
        if (length() != 0 && charSequence != null && charSequence2 != null) {
            int hashCode = AsciiString.hashCode(charSequence);
            for (HeaderEntry headerEntry = this.headerFields[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
                if (headerEntry.hash == hashCode && (HpackUtil.equalsConstantTime(charSequence, headerEntry.name) & HpackUtil.equalsConstantTime(charSequence2, headerEntry.value)) != 0) {
                    return headerEntry;
                }
            }
        }
        return null;
    }

    private int getIndex(CharSequence charSequence) {
        if (length() != 0 && charSequence != null) {
            int hashCode = AsciiString.hashCode(charSequence);
            for (HeaderEntry headerEntry = this.headerFields[index(hashCode)]; headerEntry != null; headerEntry = headerEntry.next) {
                if (headerEntry.hash == hashCode && HpackUtil.equalsConstantTime(charSequence, headerEntry.name) != 0) {
                    return getIndex(headerEntry.index);
                }
            }
        }
        return -1;
    }

    private int getNameIndex(CharSequence charSequence) {
        int index = HpackStaticTable.getIndex(charSequence);
        if (index == -1) {
            int index2 = getIndex(charSequence);
            return index2 >= 0 ? index2 + HpackStaticTable.length : index2;
        }
        return index;
    }

    private int index(int i4) {
        return i4 & this.hashMask;
    }

    private HpackHeaderField remove() {
        if (this.size == 0) {
            return null;
        }
        HeaderEntry headerEntry = this.head.after;
        int index = index(headerEntry.hash);
        HeaderEntry headerEntry2 = this.headerFields[index];
        HeaderEntry headerEntry3 = headerEntry2;
        while (headerEntry2 != null) {
            HeaderEntry headerEntry4 = headerEntry2.next;
            if (headerEntry2 == headerEntry) {
                if (headerEntry3 == headerEntry) {
                    this.headerFields[index] = headerEntry4;
                } else {
                    headerEntry3.next = headerEntry4;
                }
                headerEntry.remove();
                this.size -= headerEntry.size();
                return headerEntry;
            }
            headerEntry3 = headerEntry2;
            headerEntry2 = headerEntry4;
        }
        return null;
    }

    public void encodeHeaders(int i4, ByteBuf byteBuf, Http2Headers http2Headers, Http2HeadersEncoder.SensitivityDetector sensitivityDetector) throws Http2Exception {
        if (this.ignoreMaxHeaderListSize) {
            encodeHeadersIgnoreMaxHeaderListSize(byteBuf, http2Headers, sensitivityDetector);
        } else {
            encodeHeadersEnforceMaxHeaderListSize(i4, byteBuf, http2Headers, sensitivityDetector);
        }
    }

    HpackHeaderField getHeaderField(int i4) {
        HeaderEntry headerEntry = this.head;
        while (true) {
            int i5 = i4 - 1;
            if (i4 < 0) {
                return headerEntry;
            }
            headerEntry = headerEntry.before;
            i4 = i5;
        }
    }

    public long getMaxHeaderListSize() {
        return this.maxHeaderListSize;
    }

    public long getMaxHeaderTableSize() {
        return this.maxHeaderTableSize;
    }

    int length() {
        if (this.size == 0) {
            return 0;
        }
        HeaderEntry headerEntry = this.head;
        return (headerEntry.after.index - headerEntry.before.index) + 1;
    }

    public void setMaxHeaderListSize(long j4) throws Http2Exception {
        if (j4 >= 0 && j4 <= 4294967295L) {
            this.maxHeaderListSize = j4;
            return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header List Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j4));
    }

    public void setMaxHeaderTableSize(ByteBuf byteBuf, long j4) throws Http2Exception {
        if (j4 >= 0 && j4 <= 4294967295L) {
            if (this.maxHeaderTableSize == j4) {
                return;
            }
            this.maxHeaderTableSize = j4;
            ensureCapacity(0L);
            encodeInteger(byteBuf, 32, 5, j4);
            return;
        }
        throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", 0L, 4294967295L, Long.valueOf(j4));
    }

    long size() {
        return this.size;
    }

    HpackEncoder(boolean z3) {
        this(z3, 16, 512);
    }

    private static void encodeInteger(ByteBuf byteBuf, int i4, int i5, long j4) {
        int i6 = 255 >>> (8 - i5);
        long j5 = i6;
        if (j4 < j5) {
            byteBuf.writeByte((int) (i4 | j4));
            return;
        }
        byteBuf.writeByte(i4 | i6);
        long j6 = j4 - j5;
        while (((-128) & j6) != 0) {
            byteBuf.writeByte((int) ((127 & j6) | 128));
            j6 >>>= 7;
        }
        byteBuf.writeByte((int) j6);
    }

    HpackEncoder(boolean z3, int i4, int i5) {
        AsciiString asciiString = AsciiString.EMPTY_STRING;
        HeaderEntry headerEntry = new HeaderEntry(-1, asciiString, asciiString, Integer.MAX_VALUE, null);
        this.head = headerEntry;
        this.hpackHuffmanEncoder = new HpackHuffmanEncoder();
        this.ignoreMaxHeaderListSize = z3;
        this.maxHeaderTableSize = 4096L;
        this.maxHeaderListSize = 4294967295L;
        HeaderEntry[] headerEntryArr = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i4, 128)))];
        this.headerFields = headerEntryArr;
        this.hashMask = (byte) (headerEntryArr.length - 1);
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.huffCodeThreshold = i5;
    }

    private int getIndex(int i4) {
        if (i4 == -1) {
            return -1;
        }
        return (i4 - this.head.before.index) + 1;
    }
}
