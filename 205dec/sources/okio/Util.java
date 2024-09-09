package okio;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import okio.internal.ByteStringKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: -Util.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a \u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\bH\u0000\u001a\f\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0000\u001a\u0015\u0010\u000b\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\f\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\r\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0080\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\b2\u0006\u0010\n\u001a\u00020\u0000H\u0080\f\u001a\u0019\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\bH\u0080\b\u001a\u0019\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0000H\u0080\b\u001a0\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0000\u001a\f\u0010\u0017\u001a\u00020\u0016*\u00020\tH\u0000\u001a\f\u0010\u0017\u001a\u00020\u0016*\u00020\bH\u0000\u001a\f\u0010\u0017\u001a\u00020\u0016*\u00020\u0000H\u0000\u00a8\u0006\u0018"}, d2 = {"", "size", "offset", "byteCount", "Lkotlin/f1;", "checkOffsetAndCount", "", "reverseBytes", "", "", "other", "shr", "shl", "and", "a", "b", "minOf", "", "aOffset", "bOffset", "", "arrayRangeEquals", "", "toHexString", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-Util")
/* renamed from: okio.-Util  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class Util {
    public static final int and(byte b4, int i4) {
        return b4 & i4;
    }

    public static final long and(byte b4, long j4) {
        return j4 & b4;
    }

    public static final long and(int i4, long j4) {
        return j4 & i4;
    }

    public static final boolean arrayRangeEquals(@NotNull byte[] a4, int i4, @NotNull byte[] b4, int i5, int i6) {
        f0.p(a4, "a");
        f0.p(b4, "b");
        for (int i7 = 0; i7 < i6; i7++) {
            if (a4[i7 + i4] != b4[i7 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException("size=" + j4 + " offset=" + j5 + " byteCount=" + j6);
        }
    }

    public static final long minOf(long j4, int i4) {
        return Math.min(j4, i4);
    }

    public static final int reverseBytes(int i4) {
        return ((i4 & 255) << 24) | (((-16777216) & i4) >>> 24) | ((16711680 & i4) >>> 8) | ((65280 & i4) << 8);
    }

    public static final long reverseBytes(long j4) {
        return ((j4 & 255) << 56) | (((-72057594037927936L) & j4) >>> 56) | ((71776119061217280L & j4) >>> 40) | ((280375465082880L & j4) >>> 24) | ((1095216660480L & j4) >>> 8) | ((4278190080L & j4) << 8) | ((16711680 & j4) << 24) | ((65280 & j4) << 40);
    }

    public static final short reverseBytes(short s3) {
        int i4 = s3 & 65535;
        return (short) (((i4 & 255) << 8) | ((65280 & i4) >>> 8));
    }

    public static final int shl(byte b4, int i4) {
        return b4 << i4;
    }

    public static final int shr(byte b4, int i4) {
        return b4 >> i4;
    }

    @NotNull
    public static final String toHexString(byte b4) {
        return new String(new char[]{ByteStringKt.getHEX_DIGIT_CHARS()[(b4 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[b4 & 15]});
    }

    public static final long minOf(int i4, long j4) {
        return Math.min(i4, j4);
    }

    @NotNull
    public static final String toHexString(int i4) {
        if (i4 == 0) {
            return "0";
        }
        int i5 = 0;
        char[] cArr = {ByteStringKt.getHEX_DIGIT_CHARS()[(i4 >> 28) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i4 >> 24) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i4 >> 20) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i4 >> 16) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i4 >> 12) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i4 >> 8) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[(i4 >> 4) & 15], ByteStringKt.getHEX_DIGIT_CHARS()[i4 & 15]};
        while (i5 < 8 && cArr[i5] == '0') {
            i5++;
        }
        return new String(cArr, i5, 8 - i5);
    }

    @NotNull
    public static final String toHexString(long j4) {
        if (j4 == 0) {
            return "0";
        }
        int i4 = 0;
        char[] cArr = {ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 60) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 56) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 52) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 48) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 44) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 40) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 36) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 32) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 28) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 24) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 20) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 16) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 12) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 8) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) ((j4 >> 4) & 15)], ByteStringKt.getHEX_DIGIT_CHARS()[(int) (j4 & 15)]};
        while (i4 < 16 && cArr[i4] == '0') {
            i4++;
        }
        return new String(cArr, i4, 16 - i4);
    }
}
