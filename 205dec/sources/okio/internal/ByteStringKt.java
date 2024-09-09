package okio.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.jvm.internal.f0;
import kotlin.text.w;
import okio.Base64;
import okio.Buffer;
import okio.ByteString;
import okio.Platform;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ByteString.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0019\n\u0002\b\u0005\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0080\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0080\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0000*\u00020\u0000H\u0080\b\u001a\r\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0080\b\u001a\u0015\u0010\u000e\u001a\u00020\r*\u00020\u00002\u0006\u0010\f\u001a\u00020\bH\u0080\b\u001a\r\u0010\u000f\u001a\u00020\b*\u00020\u0000H\u0080\b\u001a\r\u0010\u0011\u001a\u00020\u0010*\u00020\u0000H\u0080\b\u001a\r\u0010\u0012\u001a\u00020\u0010*\u00020\u0000H\u0080\b\u001a-\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0080\b\u001a-\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0010H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0000H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u0017*\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0010H\u0080\b\u001a\u001d\u0010\u001e\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\bH\u0080\b\u001a\u001d\u0010\u001f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\bH\u0080\b\u001a\u001d\u0010\u001f\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\bH\u0080\b\u001a\u0017\u0010!\u001a\u00020\u0017*\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010 H\u0080\b\u001a\r\u0010\"\u001a\u00020\b*\u00020\u0000H\u0080\b\u001a\u0015\u0010#\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0000H\u0080\b\u001a\u0011\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0010H\u0080\b\u001a\u001d\u0010&\u001a\u00020\u0000*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0080\b\u001a\r\u0010'\u001a\u00020\u0000*\u00020\u0001H\u0080\b\u001a\u000f\u0010(\u001a\u0004\u0018\u00010\u0000*\u00020\u0001H\u0080\b\u001a\r\u0010)\u001a\u00020\u0000*\u00020\u0001H\u0080\b\u001a$\u0010-\u001a\u00020,*\u00020\u00002\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0000\u001a\u0010\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020.H\u0002\u001a\r\u00101\u001a\u00020\u0001*\u00020\u0000H\u0080\b\u001a\u0018\u00104\u001a\u00020\b2\u0006\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\bH\u0002\"\u001a\u00106\u001a\u0002058\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109\u00a8\u0006:"}, d2 = {"Lokio/ByteString;", "", "commonUtf8", "commonBase64", "commonBase64Url", "commonHex", "commonToAsciiLowercase", "commonToAsciiUppercase", "", "beginIndex", "endIndex", "commonSubstring", "pos", "", "commonGetByte", "commonGetSize", "", "commonToByteArray", "commonInternalArray", "offset", "other", "otherOffset", "byteCount", "", "commonRangeEquals", "prefix", "commonStartsWith", "suffix", "commonEndsWith", "fromIndex", "commonIndexOf", "commonLastIndexOf", "", "commonEquals", "commonHashCode", "commonCompareTo", "data", "commonOf", "commonToByteString", "commonEncodeUtf8", "commonDecodeBase64", "commonDecodeHex", "Lokio/Buffer;", "buffer", "Lkotlin/f1;", "commonWrite", "", "c", "decodeHexDigit", "commonToString", "s", "codePointCount", "codePointIndexToCharIndex", "", "HEX_DIGIT_CHARS", "[C", "getHEX_DIGIT_CHARS", "()[C", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ByteStringKt {
    @NotNull
    private static final char[] HEX_DIGIT_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:304:0x0068, code lost:
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final int codePointIndexToCharIndex(byte[] r19, int r20) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.ByteStringKt.codePointIndexToCharIndex(byte[], int):int");
    }

    @NotNull
    public static final String commonBase64(@NotNull ByteString commonBase64) {
        f0.p(commonBase64, "$this$commonBase64");
        return Base64.encodeBase64$default(commonBase64.getData$okio(), null, 1, null);
    }

    @NotNull
    public static final String commonBase64Url(@NotNull ByteString commonBase64Url) {
        f0.p(commonBase64Url, "$this$commonBase64Url");
        return Base64.encodeBase64(commonBase64Url.getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public static final int commonCompareTo(@NotNull ByteString commonCompareTo, @NotNull ByteString other) {
        f0.p(commonCompareTo, "$this$commonCompareTo");
        f0.p(other, "other");
        int size = commonCompareTo.size();
        int size2 = other.size();
        int min = Math.min(size, size2);
        for (int i4 = 0; i4 < min; i4++) {
            int i5 = commonCompareTo.getByte(i4) & 255;
            int i6 = other.getByte(i4) & 255;
            if (i5 != i6) {
                return i5 < i6 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    @Nullable
    public static final ByteString commonDecodeBase64(@NotNull String commonDecodeBase64) {
        f0.p(commonDecodeBase64, "$this$commonDecodeBase64");
        byte[] decodeBase64ToArray = Base64.decodeBase64ToArray(commonDecodeBase64);
        if (decodeBase64ToArray != null) {
            return new ByteString(decodeBase64ToArray);
        }
        return null;
    }

    @NotNull
    public static final ByteString commonDecodeHex(@NotNull String commonDecodeHex) {
        f0.p(commonDecodeHex, "$this$commonDecodeHex");
        if (commonDecodeHex.length() % 2 == 0) {
            int length = commonDecodeHex.length() / 2;
            byte[] bArr = new byte[length];
            for (int i4 = 0; i4 < length; i4++) {
                int i5 = i4 * 2;
                bArr[i4] = (byte) ((decodeHexDigit(commonDecodeHex.charAt(i5)) << 4) + decodeHexDigit(commonDecodeHex.charAt(i5 + 1)));
            }
            return new ByteString(bArr);
        }
        throw new IllegalArgumentException(("Unexpected hex string: " + commonDecodeHex).toString());
    }

    @NotNull
    public static final ByteString commonEncodeUtf8(@NotNull String commonEncodeUtf8) {
        f0.p(commonEncodeUtf8, "$this$commonEncodeUtf8");
        ByteString byteString = new ByteString(Platform.asUtf8ToByteArray(commonEncodeUtf8));
        byteString.setUtf8$okio(commonEncodeUtf8);
        return byteString;
    }

    public static final boolean commonEndsWith(@NotNull ByteString commonEndsWith, @NotNull ByteString suffix) {
        f0.p(commonEndsWith, "$this$commonEndsWith");
        f0.p(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.size(), suffix, 0, suffix.size());
    }

    public static final boolean commonEquals(@NotNull ByteString commonEquals, @Nullable Object obj) {
        f0.p(commonEquals, "$this$commonEquals");
        if (obj == commonEquals) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == commonEquals.getData$okio().length && byteString.rangeEquals(0, commonEquals.getData$okio(), 0, commonEquals.getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public static final byte commonGetByte(@NotNull ByteString commonGetByte, int i4) {
        f0.p(commonGetByte, "$this$commonGetByte");
        return commonGetByte.getData$okio()[i4];
    }

    public static final int commonGetSize(@NotNull ByteString commonGetSize) {
        f0.p(commonGetSize, "$this$commonGetSize");
        return commonGetSize.getData$okio().length;
    }

    public static final int commonHashCode(@NotNull ByteString commonHashCode) {
        f0.p(commonHashCode, "$this$commonHashCode");
        int hashCode$okio = commonHashCode.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(commonHashCode.getData$okio());
        commonHashCode.setHashCode$okio(hashCode);
        return hashCode;
    }

    @NotNull
    public static final String commonHex(@NotNull ByteString commonHex) {
        byte[] data$okio;
        f0.p(commonHex, "$this$commonHex");
        char[] cArr = new char[commonHex.getData$okio().length * 2];
        int i4 = 0;
        for (byte b4 : commonHex.getData$okio()) {
            int i5 = i4 + 1;
            cArr[i4] = getHEX_DIGIT_CHARS()[(b4 >> 4) & 15];
            i4 = i5 + 1;
            cArr[i5] = getHEX_DIGIT_CHARS()[b4 & 15];
        }
        return new String(cArr);
    }

    public static final int commonIndexOf(@NotNull ByteString commonIndexOf, @NotNull byte[] other, int i4) {
        f0.p(commonIndexOf, "$this$commonIndexOf");
        f0.p(other, "other");
        int length = commonIndexOf.getData$okio().length - other.length;
        int max = Math.max(i4, 0);
        if (max <= length) {
            while (!Util.arrayRangeEquals(commonIndexOf.getData$okio(), max, other, 0, other.length)) {
                if (max == length) {
                    return -1;
                }
                max++;
            }
            return max;
        }
        return -1;
    }

    @NotNull
    public static final byte[] commonInternalArray(@NotNull ByteString commonInternalArray) {
        f0.p(commonInternalArray, "$this$commonInternalArray");
        return commonInternalArray.getData$okio();
    }

    public static final int commonLastIndexOf(@NotNull ByteString commonLastIndexOf, @NotNull ByteString other, int i4) {
        f0.p(commonLastIndexOf, "$this$commonLastIndexOf");
        f0.p(other, "other");
        return commonLastIndexOf.lastIndexOf(other.internalArray$okio(), i4);
    }

    @NotNull
    public static final ByteString commonOf(@NotNull byte[] data) {
        f0.p(data, "data");
        byte[] copyOf = Arrays.copyOf(data, data.length);
        f0.o(copyOf, "java.util.Arrays.copyOf(this, size)");
        return new ByteString(copyOf);
    }

    public static final boolean commonRangeEquals(@NotNull ByteString commonRangeEquals, int i4, @NotNull ByteString other, int i5, int i6) {
        f0.p(commonRangeEquals, "$this$commonRangeEquals");
        f0.p(other, "other");
        return other.rangeEquals(i5, commonRangeEquals.getData$okio(), i4, i6);
    }

    public static final boolean commonStartsWith(@NotNull ByteString commonStartsWith, @NotNull ByteString prefix) {
        f0.p(commonStartsWith, "$this$commonStartsWith");
        f0.p(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.size());
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull ByteString commonSubstring, int i4, int i5) {
        byte[] G1;
        f0.p(commonSubstring, "$this$commonSubstring");
        if (i4 >= 0) {
            if (!(i5 <= commonSubstring.getData$okio().length)) {
                throw new IllegalArgumentException(("endIndex > length(" + commonSubstring.getData$okio().length + ')').toString());
            }
            if (i5 - i4 >= 0) {
                if (i4 == 0 && i5 == commonSubstring.getData$okio().length) {
                    return commonSubstring;
                }
                G1 = o.G1(commonSubstring.getData$okio(), i4, i5);
                return new ByteString(G1);
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    @NotNull
    public static final ByteString commonToAsciiLowercase(@NotNull ByteString commonToAsciiLowercase) {
        byte b4;
        f0.p(commonToAsciiLowercase, "$this$commonToAsciiLowercase");
        for (int i4 = 0; i4 < commonToAsciiLowercase.getData$okio().length; i4++) {
            byte b5 = commonToAsciiLowercase.getData$okio()[i4];
            byte b6 = (byte) 65;
            if (b5 >= b6 && b5 <= (b4 = (byte) 90)) {
                byte[] data$okio = commonToAsciiLowercase.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                f0.o(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i4] = (byte) (b5 + 32);
                for (int i5 = i4 + 1; i5 < copyOf.length; i5++) {
                    byte b7 = copyOf[i5];
                    if (b7 >= b6 && b7 <= b4) {
                        copyOf[i5] = (byte) (b7 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return commonToAsciiLowercase;
    }

    @NotNull
    public static final ByteString commonToAsciiUppercase(@NotNull ByteString commonToAsciiUppercase) {
        byte b4;
        f0.p(commonToAsciiUppercase, "$this$commonToAsciiUppercase");
        for (int i4 = 0; i4 < commonToAsciiUppercase.getData$okio().length; i4++) {
            byte b5 = commonToAsciiUppercase.getData$okio()[i4];
            byte b6 = (byte) 97;
            if (b5 >= b6 && b5 <= (b4 = (byte) 122)) {
                byte[] data$okio = commonToAsciiUppercase.getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                f0.o(copyOf, "java.util.Arrays.copyOf(this, size)");
                copyOf[i4] = (byte) (b5 - 32);
                for (int i5 = i4 + 1; i5 < copyOf.length; i5++) {
                    byte b7 = copyOf[i5];
                    if (b7 >= b6 && b7 <= b4) {
                        copyOf[i5] = (byte) (b7 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return commonToAsciiUppercase;
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull ByteString commonToByteArray) {
        f0.p(commonToByteArray, "$this$commonToByteArray");
        byte[] data$okio = commonToByteArray.getData$okio();
        byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
        f0.o(copyOf, "java.util.Arrays.copyOf(this, size)");
        return copyOf;
    }

    @NotNull
    public static final ByteString commonToByteString(@NotNull byte[] commonToByteString, int i4, int i5) {
        byte[] G1;
        f0.p(commonToByteString, "$this$commonToByteString");
        Util.checkOffsetAndCount(commonToByteString.length, i4, i5);
        G1 = o.G1(commonToByteString, i4, i5 + i4);
        return new ByteString(G1);
    }

    @NotNull
    public static final String commonToString(@NotNull ByteString byteString) {
        String k22;
        String k23;
        String k24;
        byte[] G1;
        ByteString commonToString = byteString;
        f0.p(commonToString, "$this$commonToString");
        if (byteString.getData$okio().length == 0) {
            return "[size=0]";
        }
        int codePointIndexToCharIndex = codePointIndexToCharIndex(byteString.getData$okio(), 64);
        if (codePointIndexToCharIndex == -1) {
            if (byteString.getData$okio().length <= 64) {
                return "[hex=" + byteString.hex() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(byteString.getData$okio().length);
            sb.append(" hex=");
            if (64 <= byteString.getData$okio().length) {
                if (64 != byteString.getData$okio().length) {
                    G1 = o.G1(byteString.getData$okio(), 0, 64);
                    commonToString = new ByteString(G1);
                }
                sb.append(commonToString.hex());
                sb.append("\u2026]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + byteString.getData$okio().length + ')').toString());
        }
        String utf8 = byteString.utf8();
        if (utf8 != null) {
            String substring = utf8.substring(0, codePointIndexToCharIndex);
            f0.o(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            k22 = w.k2(substring, "\\", "\\\\", false, 4, null);
            k23 = w.k2(k22, "\n", "\\n", false, 4, null);
            k24 = w.k2(k23, "\r", "\\r", false, 4, null);
            if (codePointIndexToCharIndex < utf8.length()) {
                return "[size=" + byteString.getData$okio().length + " text=" + k24 + "\u2026]";
            }
            return "[text=" + k24 + ']';
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public static final String commonUtf8(@NotNull ByteString commonUtf8) {
        f0.p(commonUtf8, "$this$commonUtf8");
        String utf8$okio = commonUtf8.getUtf8$okio();
        if (utf8$okio == null) {
            String utf8String = Platform.toUtf8String(commonUtf8.internalArray$okio());
            commonUtf8.setUtf8$okio(utf8String);
            return utf8String;
        }
        return utf8$okio;
    }

    public static final void commonWrite(@NotNull ByteString commonWrite, @NotNull Buffer buffer, int i4, int i5) {
        f0.p(commonWrite, "$this$commonWrite");
        f0.p(buffer, "buffer");
        buffer.write(commonWrite.getData$okio(), i4, i5);
    }

    public static final int decodeHexDigit(char c4) {
        if ('0' <= c4 && '9' >= c4) {
            return c4 - '0';
        }
        char c5 = 'a';
        if ('a' > c4 || 'f' < c4) {
            c5 = 'A';
            if ('A' > c4 || 'F' < c4) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c4);
            }
        }
        return (c4 - c5) + 10;
    }

    @NotNull
    public static final char[] getHEX_DIGIT_CHARS() {
        return HEX_DIGIT_CHARS;
    }

    public static final boolean commonEndsWith(@NotNull ByteString commonEndsWith, @NotNull byte[] suffix) {
        f0.p(commonEndsWith, "$this$commonEndsWith");
        f0.p(suffix, "suffix");
        return commonEndsWith.rangeEquals(commonEndsWith.size() - suffix.length, suffix, 0, suffix.length);
    }

    public static final int commonLastIndexOf(@NotNull ByteString commonLastIndexOf, @NotNull byte[] other, int i4) {
        f0.p(commonLastIndexOf, "$this$commonLastIndexOf");
        f0.p(other, "other");
        for (int min = Math.min(i4, commonLastIndexOf.getData$okio().length - other.length); min >= 0; min--) {
            if (Util.arrayRangeEquals(commonLastIndexOf.getData$okio(), min, other, 0, other.length)) {
                return min;
            }
        }
        return -1;
    }

    public static final boolean commonRangeEquals(@NotNull ByteString commonRangeEquals, int i4, @NotNull byte[] other, int i5, int i6) {
        f0.p(commonRangeEquals, "$this$commonRangeEquals");
        f0.p(other, "other");
        return i4 >= 0 && i4 <= commonRangeEquals.getData$okio().length - i6 && i5 >= 0 && i5 <= other.length - i6 && Util.arrayRangeEquals(commonRangeEquals.getData$okio(), i4, other, i5, i6);
    }

    public static final boolean commonStartsWith(@NotNull ByteString commonStartsWith, @NotNull byte[] prefix) {
        f0.p(commonStartsWith, "$this$commonStartsWith");
        f0.p(prefix, "prefix");
        return commonStartsWith.rangeEquals(0, prefix, 0, prefix.length);
    }
}
