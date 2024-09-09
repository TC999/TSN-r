package io.netty.handler.codec.http2.internal.hpack;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.internal.hpack.HpackUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.MathUtil;
import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Encoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int capacity;
    private final byte hashMask;
    private final HeaderEntry head;
    private final HeaderEntry[] headerFields;
    private final HuffmanEncoder huffmanEncoder;
    private int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http2.internal.hpack.Encoder$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            $SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType = iArr;
            try {
                iArr[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType[HpackUtil.IndexType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType[HpackUtil.IndexType.NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class HeaderEntry extends HeaderField {
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

    public Encoder(int i4) {
        this(i4, 16);
    }

    private void add(CharSequence charSequence, CharSequence charSequence2) {
        int sizeOf = HeaderField.sizeOf(charSequence, charSequence2);
        if (sizeOf > this.capacity) {
            clear();
            return;
        }
        while (this.size + sizeOf > this.capacity) {
            remove();
        }
        int hashCode = AsciiString.hashCode(charSequence);
        int index = index(hashCode);
        HeaderEntry headerEntry = new HeaderEntry(hashCode, charSequence, charSequence2, this.head.before.index - 1, this.headerFields[index]);
        this.headerFields[index] = headerEntry;
        headerEntry.addBefore(this.head);
        this.size += sizeOf;
    }

    private void clear() {
        Arrays.fill(this.headerFields, (Object) null);
        HeaderEntry headerEntry = this.head;
        headerEntry.after = headerEntry;
        headerEntry.before = headerEntry;
        this.size = 0;
    }

    private static void encodeInteger(ByteBuf byteBuf, int i4, int i5, int i6) {
        int i7 = 255 >>> (8 - i5);
        if (i6 < i7) {
            byteBuf.writeByte(i4 | i6);
            return;
        }
        byteBuf.writeByte(i4 | i7);
        int i8 = i6 - i7;
        while ((i8 & (-128)) != 0) {
            byteBuf.writeByte((i8 & 127) | 128);
            i8 >>>= 7;
        }
        byteBuf.writeByte(i8);
    }

    private void encodeLiteral(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType, int i4) {
        boolean z3 = i4 != -1;
        int i5 = AnonymousClass1.$SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType[indexType.ordinal()];
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
        int encodedLength = this.huffmanEncoder.getEncodedLength(charSequence);
        if (encodedLength < charSequence.length()) {
            encodeInteger(byteBuf, 128, 7, encodedLength);
            this.huffmanEncoder.encode(byteBuf, charSequence);
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

    private void ensureCapacity(int i4) {
        while (this.size + i4 > this.capacity && length() != 0) {
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
        int index = StaticTable.getIndex(charSequence);
        if (index == -1) {
            int index2 = getIndex(charSequence);
            return index2 >= 0 ? index2 + StaticTable.length : index2;
        }
        return index;
    }

    private int index(int i4) {
        return i4 & this.hashMask;
    }

    private HeaderField remove() {
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

    public void encodeHeader(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, boolean z3) {
        if (z3) {
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NEVER, getNameIndex(charSequence));
        } else if (this.capacity == 0) {
            int index = StaticTable.getIndex(charSequence, charSequence2);
            if (index == -1) {
                encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NONE, StaticTable.getIndex(charSequence));
                return;
            }
            encodeInteger(byteBuf, 128, 7, index);
        } else {
            int sizeOf = HeaderField.sizeOf(charSequence, charSequence2);
            if (sizeOf > this.capacity) {
                encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.NONE, getNameIndex(charSequence));
                return;
            }
            HeaderEntry entry = getEntry(charSequence, charSequence2);
            if (entry != null) {
                encodeInteger(byteBuf, 128, 7, getIndex(entry.index) + StaticTable.length);
                return;
            }
            int index2 = StaticTable.getIndex(charSequence, charSequence2);
            if (index2 != -1) {
                encodeInteger(byteBuf, 128, 7, index2);
                return;
            }
            ensureCapacity(sizeOf);
            encodeLiteral(byteBuf, charSequence, charSequence2, HpackUtil.IndexType.INCREMENTAL, getNameIndex(charSequence));
            add(charSequence, charSequence2);
        }
    }

    HeaderField getHeaderField(int i4) {
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

    public int getMaxHeaderTableSize() {
        return this.capacity;
    }

    int length() {
        if (this.size == 0) {
            return 0;
        }
        HeaderEntry headerEntry = this.head;
        return (headerEntry.after.index - headerEntry.before.index) + 1;
    }

    public void setMaxHeaderTableSize(ByteBuf byteBuf, int i4) {
        if (i4 >= 0) {
            if (this.capacity == i4) {
                return;
            }
            this.capacity = i4;
            ensureCapacity(0);
            encodeInteger(byteBuf, 32, 5, i4);
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i4);
    }

    int size() {
        return this.size;
    }

    public Encoder(int i4, int i5) {
        AsciiString asciiString = AsciiString.EMPTY_STRING;
        HeaderEntry headerEntry = new HeaderEntry(-1, asciiString, asciiString, Integer.MAX_VALUE, null);
        this.head = headerEntry;
        this.huffmanEncoder = new HuffmanEncoder();
        if (i4 >= 0) {
            this.capacity = i4;
            HeaderEntry[] headerEntryArr = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i5, 128)))];
            this.headerFields = headerEntryArr;
            this.hashMask = (byte) (headerEntryArr.length - 1);
            headerEntry.after = headerEntry;
            headerEntry.before = headerEntry;
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i4);
    }

    private int getIndex(int i4) {
        if (i4 == -1) {
            return -1;
        }
        return (i4 - this.head.before.index) + 1;
    }
}
