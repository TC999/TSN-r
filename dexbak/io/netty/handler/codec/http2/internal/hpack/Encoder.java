package io.netty.handler.codec.http2.internal.hpack;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.http2.internal.hpack.HpackUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.MathUtil;
import java.util.Arrays;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Encoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private int capacity;
    private final byte hashMask;
    private final HeaderEntry head;
    private final HeaderEntry[] headerFields;
    private final HuffmanEncoder huffmanEncoder;
    private int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.http2.internal.hpack.Encoder$1 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C138761 {

        /* renamed from: $SwitchMap$io$netty$handler$codec$http2$internal$hpack$HpackUtil$IndexType */
        static final /* synthetic */ int[] f40238xcc45a163;

        static {
            int[] iArr = new int[HpackUtil.IndexType.values().length];
            f40238xcc45a163 = iArr;
            try {
                iArr[HpackUtil.IndexType.INCREMENTAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40238xcc45a163[HpackUtil.IndexType.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40238xcc45a163[HpackUtil.IndexType.NEVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class HeaderEntry extends HeaderField {
        HeaderEntry after;
        HeaderEntry before;
        int hash;
        int index;
        HeaderEntry next;

        HeaderEntry(int i, CharSequence charSequence, CharSequence charSequence2, int i2, HeaderEntry headerEntry) {
            super(charSequence, charSequence2);
            this.index = i2;
            this.hash = i;
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

    public Encoder(int i) {
        this(i, 16);
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

    private static void encodeInteger(ByteBuf byteBuf, int i, int i2, int i3) {
        int i4 = 255 >>> (8 - i2);
        if (i3 < i4) {
            byteBuf.writeByte(i | i3);
            return;
        }
        byteBuf.writeByte(i | i4);
        int i5 = i3 - i4;
        while ((i5 & (-128)) != 0) {
            byteBuf.writeByte((i5 & 127) | 128);
            i5 >>>= 7;
        }
        byteBuf.writeByte(i5);
    }

    private void encodeLiteral(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, HpackUtil.IndexType indexType, int i) {
        boolean z = i != -1;
        int i2 = C138761.f40238xcc45a163[indexType.ordinal()];
        if (i2 == 1) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 64, 6, i);
        } else if (i2 == 2) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 0, 4, i);
        } else if (i2 == 3) {
            if (!z) {
                i = 0;
            }
            encodeInteger(byteBuf, 16, 4, i);
        } else {
            throw new Error("should not reach here");
        }
        if (!z) {
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

    private void ensureCapacity(int i) {
        while (this.size + i > this.capacity && length() != 0) {
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

    private int index(int i) {
        return i & this.hashMask;
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

    public void encodeHeader(ByteBuf byteBuf, CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (z) {
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

    HeaderField getHeaderField(int i) {
        HeaderEntry headerEntry = this.head;
        while (true) {
            int i2 = i - 1;
            if (i < 0) {
                return headerEntry;
            }
            headerEntry = headerEntry.before;
            i = i2;
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

    public void setMaxHeaderTableSize(ByteBuf byteBuf, int i) {
        if (i >= 0) {
            if (this.capacity == i) {
                return;
            }
            this.capacity = i;
            ensureCapacity(0);
            encodeInteger(byteBuf, 32, 5, i);
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i);
    }

    int size() {
        return this.size;
    }

    public Encoder(int i, int i2) {
        AsciiString asciiString = AsciiString.EMPTY_STRING;
        HeaderEntry headerEntry = new HeaderEntry(-1, asciiString, asciiString, Integer.MAX_VALUE, null);
        this.head = headerEntry;
        this.huffmanEncoder = new HuffmanEncoder();
        if (i >= 0) {
            this.capacity = i;
            HeaderEntry[] headerEntryArr = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(i2, 128)))];
            this.headerFields = headerEntryArr;
            this.hashMask = (byte) (headerEntryArr.length - 1);
            headerEntry.after = headerEntry;
            headerEntry.before = headerEntry;
            return;
        }
        throw new IllegalArgumentException("Illegal Capacity: " + i);
    }

    private int getIndex(int i) {
        if (i == -1) {
            return -1;
        }
        return (i - this.head.before.index) + 1;
    }
}
