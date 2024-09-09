package io.netty.util;

import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.InternalThreadLocalMap;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class AsciiString implements CharSequence, Comparable<CharSequence> {
    public static final int INDEX_NOT_FOUND = -1;
    private static final char MAX_CHAR_VALUE = '\u00ff';
    private int hash;
    private final int length;
    private final int offset;
    private String string;
    private final byte[] value;
    public static final AsciiString EMPTY_STRING = cached("");
    public static final HashingStrategy<CharSequence> CASE_INSENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.1
        @Override // io.netty.util.HashingStrategy
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEqualsIgnoreCase(charSequence, charSequence2);
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }
    };
    public static final HashingStrategy<CharSequence> CASE_SENSITIVE_HASHER = new HashingStrategy<CharSequence>() { // from class: io.netty.util.AsciiString.2
        @Override // io.netty.util.HashingStrategy
        public boolean equals(CharSequence charSequence, CharSequence charSequence2) {
            return AsciiString.contentEquals(charSequence, charSequence2);
        }

        @Override // io.netty.util.HashingStrategy
        public int hashCode(CharSequence charSequence) {
            return AsciiString.hashCode(charSequence);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AsciiCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final AsciiCaseInsensitiveCharEqualityComparator INSTANCE = new AsciiCaseInsensitiveCharEqualityComparator();

        private AsciiCaseInsensitiveCharEqualityComparator() {
        }

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char c4, char c5) {
            return AsciiString.equalsIgnoreCase(c4, c5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface CharEqualityComparator {
        boolean equals(char c4, char c5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class DefaultCharEqualityComparator implements CharEqualityComparator {
        static final DefaultCharEqualityComparator INSTANCE = new DefaultCharEqualityComparator();

        private DefaultCharEqualityComparator() {
        }

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char c4, char c5) {
            return c4 == c5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6400276.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class GeneralCaseInsensitiveCharEqualityComparator implements CharEqualityComparator {
        static final GeneralCaseInsensitiveCharEqualityComparator INSTANCE = new GeneralCaseInsensitiveCharEqualityComparator();

        private GeneralCaseInsensitiveCharEqualityComparator() {
        }

        @Override // io.netty.util.AsciiString.CharEqualityComparator
        public boolean equals(char c4, char c5) {
            return Character.toUpperCase(c4) == Character.toUpperCase(c5) || Character.toLowerCase(c4) == Character.toLowerCase(c5);
        }
    }

    public AsciiString(byte[] bArr) {
        this(bArr, true);
    }

    public static char b2c(byte b4) {
        return (char) (b4 & 255);
    }

    public static byte c2b(char c4) {
        if (c4 > '\u00ff') {
            c4 = '?';
        }
        return (byte) c4;
    }

    private static byte c2b0(char c4) {
        return (byte) c4;
    }

    public static AsciiString cached(String str) {
        AsciiString asciiString = new AsciiString(str);
        asciiString.string = str;
        return asciiString;
    }

    public static boolean containsAllContentEqualsIgnoreCase(Collection<CharSequence> collection, Collection<CharSequence> collection2) {
        for (CharSequence charSequence : collection2) {
            if (!containsContentEqualsIgnoreCase(collection, charSequence)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containsContentEqualsIgnoreCase(Collection<CharSequence> collection, CharSequence charSequence) {
        for (CharSequence charSequence2 : collection) {
            if (contentEqualsIgnoreCase(charSequence, charSequence2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, AsciiCaseInsensitiveCharEqualityComparator.INSTANCE);
    }

    private static boolean equalsIgnoreCase(byte b4, byte b5) {
        return b4 == b5 || toLowerCase(b4) == toLowerCase(b5);
    }

    private int forEachByte0(int i4, int i5, ByteProcessor byteProcessor) throws Exception {
        int i6 = this.offset;
        int i7 = i6 + i4 + i5;
        for (int i8 = i6 + i4; i8 < i7; i8++) {
            if (!byteProcessor.process(this.value[i8])) {
                return i8 - this.offset;
            }
        }
        return -1;
    }

    private int forEachByteDesc0(int i4, int i5, ByteProcessor byteProcessor) throws Exception {
        int i6 = this.offset;
        int i7 = i6 + i4;
        for (int i8 = ((i6 + i4) + i5) - 1; i8 >= i7; i8--) {
            if (!byteProcessor.process(this.value[i8])) {
                return i8 - this.offset;
            }
        }
        return -1;
    }

    public static int indexOfIgnoreCase(CharSequence charSequence, CharSequence charSequence2, int i4) {
        if (charSequence != null && charSequence2 != null) {
            if (i4 < 0) {
                i4 = 0;
            }
            int length = charSequence2.length();
            int length2 = (charSequence.length() - length) + 1;
            if (i4 > length2) {
                return -1;
            }
            if (length == 0) {
                return i4;
            }
            while (i4 < length2) {
                if (regionMatches(charSequence, true, i4, charSequence2, 0, length)) {
                    return i4;
                }
                i4++;
            }
        }
        return -1;
    }

    public static int indexOfIgnoreCaseAscii(CharSequence charSequence, CharSequence charSequence2, int i4) {
        if (charSequence != null && charSequence2 != null) {
            if (i4 < 0) {
                i4 = 0;
            }
            int length = charSequence2.length();
            int length2 = (charSequence.length() - length) + 1;
            if (i4 > length2) {
                return -1;
            }
            if (length == 0) {
                return i4;
            }
            while (i4 < length2) {
                if (regionMatchesAscii(charSequence, true, i4, charSequence2, 0, length)) {
                    return i4;
                }
                i4++;
            }
        }
        return -1;
    }

    private static boolean isLowerCase(byte b4) {
        return b4 >= 97 && b4 <= 122;
    }

    public static boolean isUpperCase(byte b4) {
        return b4 >= 65 && b4 <= 90;
    }

    public static boolean isUpperCase(char c4) {
        return c4 >= 'A' && c4 <= 'Z';
    }

    public static AsciiString of(CharSequence charSequence) {
        return charSequence instanceof AsciiString ? (AsciiString) charSequence : new AsciiString(charSequence);
    }

    public static boolean regionMatchesAscii(CharSequence charSequence, boolean z3, int i4, CharSequence charSequence2, int i5, int i6) {
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if (!z3 && (charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(false, i4, (String) charSequence2, i5, i6);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).regionMatches(z3, i4, charSequence2, i5, i6);
        }
        return regionMatchesCharSequences(charSequence, i4, charSequence2, i5, i6, z3 ? AsciiCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    private static boolean regionMatchesCharSequences(CharSequence charSequence, int i4, CharSequence charSequence2, int i5, int i6, CharEqualityComparator charEqualityComparator) {
        if (i4 < 0 || i6 > charSequence.length() - i4 || i5 < 0 || i6 > charSequence2.length() - i5) {
            return false;
        }
        int i7 = i6 + i4;
        while (i4 < i7) {
            int i8 = i4 + 1;
            int i9 = i5 + 1;
            if (!charEqualityComparator.equals(charSequence.charAt(i4), charSequence2.charAt(i5))) {
                return false;
            }
            i4 = i8;
            i5 = i9;
        }
        return true;
    }

    private static AsciiString[] toAsciiStringArray(String[] strArr) {
        AsciiString[] asciiStringArr = new AsciiString[strArr.length];
        for (int i4 = 0; i4 < strArr.length; i4++) {
            asciiStringArr[i4] = new AsciiString(strArr[i4]);
        }
        return asciiStringArr;
    }

    public static CharSequence trim(CharSequence charSequence) {
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).trim();
        }
        if (charSequence instanceof String) {
            return ((String) charSequence).trim();
        }
        int i4 = 0;
        int length = charSequence.length() - 1;
        while (i4 <= length && charSequence.charAt(i4) <= ' ') {
            i4++;
        }
        int i5 = length;
        while (i5 >= i4 && charSequence.charAt(i5) <= ' ') {
            i5--;
        }
        return (i4 == 0 && i5 == length) ? charSequence : charSequence.subSequence(i4, i5);
    }

    public byte[] array() {
        return this.value;
    }

    public void arrayChanged() {
        this.string = null;
        this.hash = 0;
    }

    public int arrayOffset() {
        return this.offset;
    }

    public byte byteAt(int i4) {
        if (i4 >= 0 && i4 < this.length) {
            if (PlatformDependent.hasUnsafe()) {
                return PlatformDependent.getByte(this.value, i4 + this.offset);
            }
            return this.value[i4 + this.offset];
        }
        throw new IndexOutOfBoundsException("index: " + i4 + " must be in the range [0," + this.length + ")");
    }

    @Override // java.lang.CharSequence
    public char charAt(int i4) {
        return b2c(byteAt(i4));
    }

    public AsciiString concat(CharSequence charSequence) {
        int length = length();
        int length2 = charSequence.length();
        if (length2 == 0) {
            return this;
        }
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            if (isEmpty()) {
                return asciiString;
            }
            byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length + length2);
            System.arraycopy(this.value, arrayOffset(), allocateUninitializedArray, 0, length);
            System.arraycopy(asciiString.value, asciiString.arrayOffset(), allocateUninitializedArray, length, length2);
            return new AsciiString(allocateUninitializedArray, false);
        } else if (isEmpty()) {
            return new AsciiString(charSequence);
        } else {
            byte[] allocateUninitializedArray2 = PlatformDependent.allocateUninitializedArray(length2 + length);
            System.arraycopy(this.value, arrayOffset(), allocateUninitializedArray2, 0, length);
            int i4 = 0;
            while (length < allocateUninitializedArray2.length) {
                allocateUninitializedArray2[length] = c2b(charSequence.charAt(i4));
                length++;
                i4++;
            }
            return new AsciiString(allocateUninitializedArray2, false);
        }
    }

    public boolean contains(CharSequence charSequence) {
        return indexOf(charSequence) >= 0;
    }

    public boolean contentEquals(CharSequence charSequence) {
        if (this == charSequence) {
            return true;
        }
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (charSequence instanceof AsciiString) {
            return equals(charSequence);
        }
        int arrayOffset = arrayOffset();
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (b2c(this.value[arrayOffset]) != charSequence.charAt(i4)) {
                return false;
            }
            arrayOffset++;
        }
        return true;
    }

    public boolean contentEqualsIgnoreCase(CharSequence charSequence) {
        if (this == charSequence) {
            return true;
        }
        if (charSequence == null || charSequence.length() != length()) {
            return false;
        }
        if (charSequence instanceof AsciiString) {
            AsciiString asciiString = (AsciiString) charSequence;
            int arrayOffset = arrayOffset();
            int arrayOffset2 = asciiString.arrayOffset();
            while (arrayOffset < length()) {
                if (!equalsIgnoreCase(this.value[arrayOffset], asciiString.value[arrayOffset2])) {
                    return false;
                }
                arrayOffset++;
                arrayOffset2++;
            }
            return true;
        }
        int arrayOffset3 = arrayOffset();
        int i4 = 0;
        while (arrayOffset3 < length()) {
            if (!equalsIgnoreCase(b2c(this.value[arrayOffset3]), charSequence.charAt(i4))) {
                return false;
            }
            arrayOffset3++;
            i4++;
        }
        return true;
    }

    public void copy(int i4, byte[] bArr, int i5, int i6) {
        if (!MathUtil.isOutOfBounds(i4, i6, length())) {
            System.arraycopy(this.value, i4 + this.offset, ObjectUtil.checkNotNull(bArr, "dst"), i5, i6);
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i4 + ") <= srcIdx + length(" + i6 + ") <= srcLen(" + length() + ')');
    }

    public boolean endsWith(CharSequence charSequence) {
        int length = charSequence.length();
        return regionMatches(length() - length, charSequence, 0, length);
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != AsciiString.class) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        AsciiString asciiString = (AsciiString) obj;
        return length() == asciiString.length() && hashCode() == asciiString.hashCode() && PlatformDependent.equals(array(), arrayOffset(), asciiString.array(), asciiString.arrayOffset(), length());
    }

    public int forEachByte(ByteProcessor byteProcessor) throws Exception {
        return forEachByte0(0, length(), byteProcessor);
    }

    public int forEachByteDesc(ByteProcessor byteProcessor) throws Exception {
        return forEachByteDesc0(0, length(), byteProcessor);
    }

    public int hashCode() {
        int i4 = this.hash;
        if (i4 == 0) {
            int hashCodeAscii = PlatformDependent.hashCodeAscii(this.value, this.offset, this.length);
            this.hash = hashCodeAscii;
            return hashCodeAscii;
        }
        return i4;
    }

    public int indexOf(CharSequence charSequence) {
        return indexOf(charSequence, 0);
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public boolean isEntireArrayUsed() {
        return this.offset == 0 && this.length == this.value.length;
    }

    public int lastIndexOf(CharSequence charSequence) {
        return lastIndexOf(charSequence, this.length);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.length;
    }

    public boolean matches(String str) {
        return Pattern.matches(str, this);
    }

    public boolean parseBoolean() {
        return this.length >= 1 && this.value[this.offset] != 0;
    }

    public char parseChar() {
        return parseChar(0);
    }

    public double parseDouble() {
        return parseDouble(0, length());
    }

    public float parseFloat() {
        return parseFloat(0, length());
    }

    public int parseInt() {
        return parseInt(0, length(), 10);
    }

    public long parseLong() {
        return parseLong(0, length(), 10);
    }

    public short parseShort() {
        return parseShort(0, length(), 10);
    }

    public boolean regionMatches(int i4, CharSequence charSequence, int i5, int i6) {
        if (charSequence != null) {
            if (i5 >= 0 && charSequence.length() - i5 >= i6) {
                int length = length();
                if (i4 >= 0 && length - i4 >= i6) {
                    if (i6 <= 0) {
                        return true;
                    }
                    int i7 = i6 + i5;
                    int arrayOffset = i4 + arrayOffset();
                    while (i5 < i7) {
                        if (b2c(this.value[arrayOffset]) != charSequence.charAt(i5)) {
                            return false;
                        }
                        i5++;
                        arrayOffset++;
                    }
                    return true;
                }
            }
            return false;
        }
        throw new NullPointerException("string");
    }

    public AsciiString replace(char c4, char c5) {
        if (c4 > '\u00ff') {
            return this;
        }
        byte c2b0 = c2b0(c4);
        byte c2b = c2b(c5);
        int i4 = this.offset;
        int i5 = this.length + i4;
        while (i4 < i5) {
            if (this.value[i4] == c2b0) {
                byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length());
                byte[] bArr = this.value;
                int i6 = this.offset;
                System.arraycopy(bArr, i6, allocateUninitializedArray, 0, i4 - i6);
                allocateUninitializedArray[i4 - this.offset] = c2b;
                while (true) {
                    i4++;
                    if (i4 < i5) {
                        byte b4 = this.value[i4];
                        int i7 = i4 - this.offset;
                        if (b4 == c2b0) {
                            b4 = c2b;
                        }
                        allocateUninitializedArray[i7] = b4;
                    } else {
                        return new AsciiString(allocateUninitializedArray, false);
                    }
                }
            } else {
                i4++;
            }
        }
        return this;
    }

    public AsciiString[] split(String str, int i4) {
        return toAsciiStringArray(Pattern.compile(str).split(this, i4));
    }

    public boolean startsWith(CharSequence charSequence) {
        return startsWith(charSequence, 0);
    }

    public byte[] toByteArray() {
        return toByteArray(0, length());
    }

    public char[] toCharArray() {
        return toCharArray(0, length());
    }

    public AsciiString toLowerCase() {
        boolean z3;
        int length = length() + arrayOffset();
        int arrayOffset = arrayOffset();
        while (true) {
            if (arrayOffset >= length) {
                z3 = true;
                break;
            }
            byte b4 = this.value[arrayOffset];
            if (b4 >= 65 && b4 <= 90) {
                z3 = false;
                break;
            }
            arrayOffset++;
        }
        if (z3) {
            return this;
        }
        byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length());
        int arrayOffset2 = arrayOffset();
        int i4 = 0;
        while (i4 < allocateUninitializedArray.length) {
            allocateUninitializedArray[i4] = toLowerCase(this.value[arrayOffset2]);
            i4++;
            arrayOffset2++;
        }
        return new AsciiString(allocateUninitializedArray, false);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        String str = this.string;
        if (str == null) {
            String asciiString = toString(0);
            this.string = asciiString;
            return asciiString;
        }
        return str;
    }

    public AsciiString toUpperCase() {
        boolean z3;
        int length = length() + arrayOffset();
        int arrayOffset = arrayOffset();
        while (true) {
            if (arrayOffset >= length) {
                z3 = true;
                break;
            }
            byte b4 = this.value[arrayOffset];
            if (b4 >= 97 && b4 <= 122) {
                z3 = false;
                break;
            }
            arrayOffset++;
        }
        if (z3) {
            return this;
        }
        byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(length());
        int arrayOffset2 = arrayOffset();
        int i4 = 0;
        while (i4 < allocateUninitializedArray.length) {
            allocateUninitializedArray[i4] = toUpperCase(this.value[arrayOffset2]);
            i4++;
            arrayOffset2++;
        }
        return new AsciiString(allocateUninitializedArray, false);
    }

    public AsciiString(byte[] bArr, boolean z3) {
        this(bArr, 0, bArr.length, z3);
    }

    public static boolean contains(CharSequence charSequence, CharSequence charSequence2) {
        return contains(charSequence, charSequence2, DefaultCharEqualityComparator.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean equalsIgnoreCase(char c4, char c5) {
        return c4 == c5 || toLowerCase(c4) == toLowerCase(c5);
    }

    @Override // java.lang.Comparable
    public int compareTo(CharSequence charSequence) {
        int i4 = 0;
        if (this == charSequence) {
            return 0;
        }
        int length = length();
        int length2 = charSequence.length();
        int min = Math.min(length, length2);
        int arrayOffset = arrayOffset();
        while (i4 < min) {
            int b2c = b2c(this.value[arrayOffset]) - charSequence.charAt(i4);
            if (b2c != 0) {
                return b2c;
            }
            i4++;
            arrayOffset++;
        }
        return length - length2;
    }

    public int forEachByte(int i4, int i5, ByteProcessor byteProcessor) throws Exception {
        if (!MathUtil.isOutOfBounds(i4, i5, length())) {
            return forEachByte0(i4, i5, byteProcessor);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= index(" + i4 + ") <= start + length(" + i5 + ") <= length(" + length() + ')');
    }

    public int forEachByteDesc(int i4, int i5, ByteProcessor byteProcessor) throws Exception {
        if (!MathUtil.isOutOfBounds(i4, i5, length())) {
            return forEachByteDesc0(i4, i5, byteProcessor);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= index(" + i4 + ") <= start + length(" + i5 + ") <= length(" + length() + ')');
    }

    public int indexOf(CharSequence charSequence, int i4) {
        char charAt;
        int length = charSequence.length();
        if (i4 < 0) {
            i4 = 0;
        }
        if (length <= 0) {
            int i5 = this.length;
            return i4 < i5 ? i4 : i5;
        } else if (length <= this.length - i4 && (charAt = charSequence.charAt(0)) <= '\u00ff') {
            byte c2b0 = c2b0(charAt);
            int i6 = this.offset;
            int i7 = (this.length + i6) - length;
            for (int i8 = i4 + i6; i8 <= i7; i8++) {
                if (this.value[i8] == c2b0) {
                    int i9 = i8;
                    int i10 = 0;
                    do {
                        i10++;
                        if (i10 >= length) {
                            break;
                        }
                        i9++;
                    } while (b2c(this.value[i9]) == charSequence.charAt(i10));
                    if (i10 == length) {
                        return i8 - this.offset;
                    }
                }
            }
            return -1;
        } else {
            return -1;
        }
    }

    public int lastIndexOf(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        int min = Math.min(i4, this.length - length);
        if (min < 0) {
            return -1;
        }
        if (length == 0) {
            return min;
        }
        char charAt = charSequence.charAt(0);
        if (charAt > '\u00ff') {
            return -1;
        }
        byte c2b0 = c2b0(charAt);
        for (int i5 = this.offset + min; i5 >= 0; i5--) {
            if (this.value[i5] == c2b0) {
                int i6 = i5;
                int i7 = 0;
                do {
                    i7++;
                    if (i7 >= length) {
                        break;
                    }
                    i6++;
                } while (b2c(this.value[i6]) == charSequence.charAt(i7));
                if (i7 == length) {
                    return i5 - this.offset;
                }
            }
        }
        return -1;
    }

    public char parseChar(int i4) {
        if (i4 + 1 < length()) {
            int i5 = i4 + this.offset;
            return (char) (b2c(this.value[i5 + 1]) | (b2c(this.value[i5]) << '\b'));
        }
        throw new IndexOutOfBoundsException("2 bytes required to convert to character. index " + i4 + " would go out of bounds.");
    }

    public double parseDouble(int i4, int i5) {
        return Double.parseDouble(toString(i4, i5));
    }

    public float parseFloat(int i4, int i5) {
        return Float.parseFloat(toString(i4, i5));
    }

    public int parseInt(int i4) {
        return parseInt(0, length(), i4);
    }

    public long parseLong(int i4) {
        return parseLong(0, length(), i4);
    }

    public short parseShort(int i4) {
        return parseShort(0, length(), i4);
    }

    public AsciiString[] split(char c4) {
        ArrayList arrayList = InternalThreadLocalMap.get().arrayList();
        int length = length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (charAt(i5) == c4) {
                if (i4 == i5) {
                    arrayList.add(EMPTY_STRING);
                } else {
                    arrayList.add(new AsciiString(this.value, arrayOffset() + i4, i5 - i4, false));
                }
                i4 = i5 + 1;
            }
        }
        if (i4 == 0) {
            arrayList.add(this);
        } else if (i4 != length) {
            arrayList.add(new AsciiString(this.value, arrayOffset() + i4, length - i4, false));
        } else {
            for (int size = arrayList.size() - 1; size >= 0 && ((AsciiString) arrayList.get(size)).isEmpty(); size--) {
                arrayList.remove(size);
            }
        }
        return (AsciiString[]) arrayList.toArray(new AsciiString[0]);
    }

    public boolean startsWith(CharSequence charSequence, int i4) {
        return regionMatches(i4, charSequence, 0, charSequence.length());
    }

    public AsciiString subSequence(int i4) {
        return subSequence(i4, length());
    }

    public byte[] toByteArray(int i4, int i5) {
        byte[] bArr = this.value;
        int i6 = this.offset;
        return Arrays.copyOfRange(bArr, i4 + i6, i5 + i6);
    }

    public char[] toCharArray(int i4, int i5) {
        int i6 = i5 - i4;
        if (i6 == 0) {
            return EmptyArrays.EMPTY_CHARS;
        }
        if (!MathUtil.isOutOfBounds(i4, i6, length())) {
            char[] cArr = new char[i6];
            int i7 = 0;
            int arrayOffset = i4 + arrayOffset();
            while (i7 < i6) {
                cArr[i7] = b2c(this.value[arrayOffset]);
                i7++;
                arrayOffset++;
            }
            return cArr;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i4 + ") <= srcIdx + length(" + i6 + ") <= srcLen(" + length() + ')');
    }

    public AsciiString(byte[] bArr, int i4, int i5, boolean z3) {
        if (z3) {
            this.value = Arrays.copyOfRange(bArr, i4, i4 + i5);
            this.offset = 0;
        } else if (!MathUtil.isOutOfBounds(i4, i5, bArr.length)) {
            this.value = bArr;
            this.offset = i4;
        } else {
            throw new IndexOutOfBoundsException("expected: 0 <= start(" + i4 + ") <= start + length(" + i5 + ") <= value.length(" + bArr.length + ')');
        }
        this.length = i5;
    }

    private static boolean contains(CharSequence charSequence, CharSequence charSequence2, CharEqualityComparator charEqualityComparator) {
        if (charSequence != null && charSequence2 != null && charSequence.length() >= charSequence2.length()) {
            if (charSequence2.length() == 0) {
                return true;
            }
            int i4 = 0;
            for (int i5 = 0; i5 < charSequence.length(); i5++) {
                if (charEqualityComparator.equals(charSequence2.charAt(i4), charSequence.charAt(i5))) {
                    i4++;
                    if (i4 == charSequence2.length()) {
                        return true;
                    }
                } else if (charSequence.length() - i5 < charSequence2.length()) {
                    return false;
                } else {
                    i4 = 0;
                }
            }
        }
        return false;
    }

    public int parseInt(int i4, int i5) {
        return parseInt(i4, i5, 10);
    }

    public long parseLong(int i4, int i5) {
        return parseLong(i4, i5, 10);
    }

    public short parseShort(int i4, int i5) {
        return parseShort(i4, i5, 10);
    }

    @Override // java.lang.CharSequence
    public AsciiString subSequence(int i4, int i5) {
        return subSequence(i4, i5, true);
    }

    public static int hashCode(CharSequence charSequence) {
        if (charSequence == null) {
            return 0;
        }
        if (charSequence instanceof AsciiString) {
            return charSequence.hashCode();
        }
        return PlatformDependent.hashCodeAscii(charSequence);
    }

    public int parseInt(int i4, int i5, int i6) {
        if (i6 < 2 || i6 > 36) {
            throw new NumberFormatException();
        }
        if (i4 != i5) {
            boolean z3 = byteAt(i4) == 45;
            if (z3) {
                int i7 = i4 + 1;
                if (i7 == i5) {
                    throw new NumberFormatException(subSequence(i4, i5, false).toString());
                }
                i4 = i7;
            }
            return parseInt(i4, i5, i6, z3);
        }
        throw new NumberFormatException();
    }

    public long parseLong(int i4, int i5, int i6) {
        if (i6 < 2 || i6 > 36) {
            throw new NumberFormatException();
        }
        if (i4 != i5) {
            boolean z3 = byteAt(i4) == 45;
            if (z3) {
                int i7 = i4 + 1;
                if (i7 == i5) {
                    throw new NumberFormatException(subSequence(i4, i5, false).toString());
                }
                i4 = i7;
            }
            return parseLong(i4, i5, i6, z3);
        }
        throw new NumberFormatException();
    }

    public short parseShort(int i4, int i5, int i6) {
        int parseInt = parseInt(i4, i5, i6);
        short s3 = (short) parseInt;
        if (s3 == parseInt) {
            return s3;
        }
        throw new NumberFormatException(subSequence(i4, i5, false).toString());
    }

    public AsciiString subSequence(int i4, int i5, boolean z3) {
        int i6 = i5 - i4;
        if (!MathUtil.isOutOfBounds(i4, i6, length())) {
            if (i4 == 0 && i5 == length()) {
                return this;
            }
            if (i5 == i4) {
                return EMPTY_STRING;
            }
            return new AsciiString(this.value, i4 + this.offset, i6, z3);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i4 + ") <= end (" + i5 + ") <= length(" + length() + ')');
    }

    public String toString(int i4) {
        return toString(i4, length());
    }

    public void copy(int i4, char[] cArr, int i5, int i6) {
        if (cArr != null) {
            if (!MathUtil.isOutOfBounds(i4, i6, length())) {
                int i7 = i6 + i5;
                int arrayOffset = i4 + arrayOffset();
                while (i5 < i7) {
                    cArr[i5] = b2c(this.value[arrayOffset]);
                    i5++;
                    arrayOffset++;
                }
                return;
            }
            throw new IndexOutOfBoundsException("expected: 0 <= srcIdx(" + i4 + ") <= srcIdx + length(" + i6 + ") <= srcLen(" + length() + ')');
        }
        throw new NullPointerException("dst");
    }

    public String toString(int i4, int i5) {
        int i6 = i5 - i4;
        if (i6 == 0) {
            return "";
        }
        if (!MathUtil.isOutOfBounds(i4, i6, length())) {
            return new String(this.value, 0, i4 + this.offset, i6);
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i4 + ") <= srcIdx + length(" + i6 + ") <= srcLen(" + length() + ')');
    }

    public static boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        } else if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).contentEquals(charSequence2);
        } else {
            if (charSequence2 instanceof AsciiString) {
                return ((AsciiString) charSequence2).contentEquals(charSequence);
            }
            if (charSequence.length() != charSequence2.length()) {
                return false;
            }
            for (int i4 = 0; i4 < charSequence.length(); i4++) {
                if (charSequence.charAt(i4) != charSequence2.charAt(i4)) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean regionMatches(boolean z3, int i4, CharSequence charSequence, int i5, int i6) {
        if (z3) {
            if (charSequence != null) {
                int length = length();
                if (i4 < 0 || i6 > length - i4 || i5 < 0 || i6 > charSequence.length() - i5) {
                    return false;
                }
                int arrayOffset = i4 + arrayOffset();
                int i7 = i6 + arrayOffset;
                while (arrayOffset < i7) {
                    int i8 = arrayOffset + 1;
                    int i9 = i5 + 1;
                    if (!equalsIgnoreCase(b2c(this.value[arrayOffset]), charSequence.charAt(i5))) {
                        return false;
                    }
                    i5 = i9;
                    arrayOffset = i8;
                }
                return true;
            }
            throw new NullPointerException("string");
        }
        return regionMatches(i4, charSequence, i5, i6);
    }

    public static boolean contentEqualsIgnoreCase(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence == null || charSequence2 == null) {
            return charSequence == charSequence2;
        } else if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).contentEqualsIgnoreCase(charSequence2);
        } else {
            if (charSequence2 instanceof AsciiString) {
                return ((AsciiString) charSequence2).contentEqualsIgnoreCase(charSequence);
            }
            if (charSequence.length() != charSequence2.length()) {
                return false;
            }
            for (int i4 = 0; i4 < charSequence.length(); i4++) {
                if (!equalsIgnoreCase(charSequence.charAt(i4), charSequence2.charAt(i4))) {
                    return false;
                }
            }
            return true;
        }
    }

    private static byte toLowerCase(byte b4) {
        return isUpperCase(b4) ? (byte) (b4 + 32) : b4;
    }

    private static byte toUpperCase(byte b4) {
        return isLowerCase(b4) ? (byte) (b4 - 32) : b4;
    }

    private int parseInt(int i4, int i5, int i6, boolean z3) {
        int i7 = Integer.MIN_VALUE / i6;
        int i8 = i4;
        int i9 = 0;
        while (i8 < i5) {
            int i10 = i8 + 1;
            int digit = Character.digit((char) (this.value[i8 + this.offset] & 255), i6);
            if (digit == -1) {
                throw new NumberFormatException(subSequence(i4, i5, false).toString());
            }
            if (i7 > i9) {
                throw new NumberFormatException(subSequence(i4, i5, false).toString());
            }
            int i11 = (i9 * i6) - digit;
            if (i11 > i9) {
                throw new NumberFormatException(subSequence(i4, i5, false).toString());
            }
            i9 = i11;
            i8 = i10;
        }
        if (z3 || (i9 = -i9) >= 0) {
            return i9;
        }
        throw new NumberFormatException(subSequence(i4, i5, false).toString());
    }

    private long parseLong(int i4, int i5, int i6, boolean z3) {
        long j4 = i6;
        long j5 = Long.MIN_VALUE / j4;
        int i7 = i4;
        long j6 = 0;
        while (i7 < i5) {
            int i8 = i7 + 1;
            int digit = Character.digit((char) (this.value[i7 + this.offset] & 255), i6);
            if (digit == -1) {
                throw new NumberFormatException(subSequence(i4, i5, false).toString());
            }
            if (j5 > j6) {
                throw new NumberFormatException(subSequence(i4, i5, false).toString());
            }
            long j7 = (j6 * j4) - digit;
            if (j7 > j6) {
                throw new NumberFormatException(subSequence(i4, i5, false).toString());
            }
            j6 = j7;
            i7 = i8;
        }
        if (!z3) {
            j6 = -j6;
            if (j6 < 0) {
                throw new NumberFormatException(subSequence(i4, i5, false).toString());
            }
        }
        return j6;
    }

    public static char toLowerCase(char c4) {
        return isUpperCase(c4) ? (char) (c4 + ' ') : c4;
    }

    public AsciiString trim() {
        int arrayOffset = arrayOffset();
        int arrayOffset2 = (arrayOffset() + length()) - 1;
        while (arrayOffset <= arrayOffset2 && this.value[arrayOffset] <= 32) {
            arrayOffset++;
        }
        int i4 = arrayOffset2;
        while (i4 >= arrayOffset && this.value[i4] <= 32) {
            i4--;
        }
        return (arrayOffset == 0 && i4 == arrayOffset2) ? this : new AsciiString(this.value, arrayOffset, (i4 - arrayOffset) + 1, false);
    }

    public AsciiString(ByteBuffer byteBuffer) {
        this(byteBuffer, true);
    }

    public int indexOf(char c4, int i4) {
        if (c4 > '\u00ff') {
            return -1;
        }
        if (i4 < 0) {
            i4 = 0;
        }
        byte c2b0 = c2b0(c4);
        int i5 = this.offset;
        int i6 = this.length + i5;
        for (int i7 = i4 + i5; i7 < i6; i7++) {
            if (this.value[i7] == c2b0) {
                return i7 - this.offset;
            }
        }
        return -1;
    }

    public AsciiString(ByteBuffer byteBuffer, boolean z3) {
        this(byteBuffer, byteBuffer.position(), byteBuffer.remaining(), z3);
    }

    public static boolean regionMatches(CharSequence charSequence, boolean z3, int i4, CharSequence charSequence2, int i5, int i6) {
        if (charSequence == null || charSequence2 == null) {
            return false;
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return ((String) charSequence).regionMatches(z3, i4, (String) charSequence2, i5, i6);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).regionMatches(z3, i4, charSequence2, i5, i6);
        }
        return regionMatchesCharSequences(charSequence, i4, charSequence2, i5, i6, z3 ? GeneralCaseInsensitiveCharEqualityComparator.INSTANCE : DefaultCharEqualityComparator.INSTANCE);
    }

    public AsciiString(ByteBuffer byteBuffer, int i4, int i5, boolean z3) {
        if (!MathUtil.isOutOfBounds(i4, i5, byteBuffer.capacity())) {
            if (!byteBuffer.hasArray()) {
                byte[] allocateUninitializedArray = PlatformDependent.allocateUninitializedArray(i5);
                this.value = allocateUninitializedArray;
                int position = byteBuffer.position();
                byteBuffer.get(allocateUninitializedArray, 0, i5);
                byteBuffer.position(position);
                this.offset = 0;
            } else if (z3) {
                int arrayOffset = byteBuffer.arrayOffset() + i4;
                this.value = Arrays.copyOfRange(byteBuffer.array(), arrayOffset, arrayOffset + i5);
                this.offset = 0;
            } else {
                this.value = byteBuffer.array();
                this.offset = i4;
            }
            this.length = i5;
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i4 + ") <= start + length(" + i5 + ") <= value.capacity(" + byteBuffer.capacity() + ')');
    }

    public static int indexOf(CharSequence charSequence, char c4, int i4) {
        if (charSequence instanceof String) {
            return ((String) charSequence).indexOf(c4, i4);
        }
        if (charSequence instanceof AsciiString) {
            return ((AsciiString) charSequence).indexOf(c4, i4);
        }
        if (charSequence == null) {
            return -1;
        }
        int length = charSequence.length();
        if (i4 < 0) {
            i4 = 0;
        }
        while (i4 < length) {
            if (charSequence.charAt(i4) == c4) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public AsciiString(char[] cArr) {
        this(cArr, 0, cArr.length);
    }

    public AsciiString(char[] cArr, int i4, int i5) {
        if (!MathUtil.isOutOfBounds(i4, i5, cArr.length)) {
            this.value = PlatformDependent.allocateUninitializedArray(i5);
            int i6 = 0;
            while (i6 < i5) {
                this.value[i6] = c2b(cArr[i4]);
                i6++;
                i4++;
            }
            this.offset = 0;
            this.length = i5;
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i4 + ") <= start + length(" + i5 + ") <= value.length(" + cArr.length + ')');
    }

    public AsciiString(char[] cArr, Charset charset) {
        this(cArr, charset, 0, cArr.length);
    }

    public AsciiString(char[] cArr, Charset charset, int i4, int i5) {
        CharBuffer wrap = CharBuffer.wrap(cArr, i4, i5);
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        ByteBuffer allocate = ByteBuffer.allocate((int) (encoder.maxBytesPerChar() * i5));
        encoder.encode(wrap, allocate, true);
        int arrayOffset = allocate.arrayOffset();
        byte[] copyOfRange = Arrays.copyOfRange(allocate.array(), arrayOffset, allocate.position() + arrayOffset);
        this.value = copyOfRange;
        this.offset = 0;
        this.length = copyOfRange.length;
    }

    public AsciiString(CharSequence charSequence) {
        this(charSequence, 0, charSequence.length());
    }

    public AsciiString(CharSequence charSequence, int i4, int i5) {
        if (!MathUtil.isOutOfBounds(i4, i5, charSequence.length())) {
            this.value = PlatformDependent.allocateUninitializedArray(i5);
            int i6 = 0;
            while (i6 < i5) {
                this.value[i6] = c2b(charSequence.charAt(i4));
                i6++;
                i4++;
            }
            this.offset = 0;
            this.length = i5;
            return;
        }
        throw new IndexOutOfBoundsException("expected: 0 <= start(" + i4 + ") <= start + length(" + i5 + ") <= value.length(" + charSequence.length() + ')');
    }

    public AsciiString(CharSequence charSequence, Charset charset) {
        this(charSequence, charset, 0, charSequence.length());
    }

    public AsciiString(CharSequence charSequence, Charset charset, int i4, int i5) {
        CharBuffer wrap = CharBuffer.wrap(charSequence, i4, i4 + i5);
        CharsetEncoder encoder = CharsetUtil.encoder(charset);
        ByteBuffer allocate = ByteBuffer.allocate((int) (encoder.maxBytesPerChar() * i5));
        encoder.encode(wrap, allocate, true);
        int arrayOffset = allocate.arrayOffset();
        byte[] copyOfRange = Arrays.copyOfRange(allocate.array(), arrayOffset, allocate.position() + arrayOffset);
        this.value = copyOfRange;
        this.offset = 0;
        this.length = copyOfRange.length;
    }
}
