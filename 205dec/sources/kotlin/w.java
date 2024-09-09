package kotlin;

import kotlin.internal.InlineOnly;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FloorDivMod.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\u001a\u0015\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\r\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u000e\u001a\u00020\u0000*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0010\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0012\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0013\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\u0014\u001a\u00020\n*\u00020\u00052\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0016\u001a\u00020\u0000*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0018\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0019\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u001b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\u001c\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010\u001d\u001a\u00020\n*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u001e\u001a\u00020\u0000*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\b\u001a\u0015\u0010\u001f\u001a\u00020\n*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010 \u001a\u00020\u0005*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010!\u001a\u00020\n*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\"\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u0001\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010#\u001a\u00020\n*\u00020\n2\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010$\u001a\u00020\n*\u00020\n2\u0006\u0010\u0001\u001a\u00020\nH\u0087\b\u001a\u0015\u0010&\u001a\u00020%*\u00020%2\u0006\u0010\u0001\u001a\u00020%H\u0087\b\u001a\u0015\u0010(\u001a\u00020'*\u00020%2\u0006\u0010\u0001\u001a\u00020'H\u0087\b\u001a\u0015\u0010)\u001a\u00020'*\u00020'2\u0006\u0010\u0001\u001a\u00020%H\u0087\b\u001a\u0015\u0010*\u001a\u00020'*\u00020'2\u0006\u0010\u0001\u001a\u00020'H\u0087\b\u00a8\u0006+"}, d2 = {"", "other", "", "J", "Z", "", "L", "p0", "K", "h0", "", "S", "l0", "P", "c0", "R", "s0", "Q", "k0", "Y", "o0", "M", "a0", "O", "q0", "N", "i0", "T", "m0", "U", "b0", "X", "r0", "V", "j0", "W", "n0", "", "g0", "", "f0", "e0", "d0", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/NumbersKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class w extends v {
    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int J(byte b4, byte b5) {
        int i4 = b4 / b5;
        return ((b4 ^ b5) >= 0 || b5 * i4 == b4) ? i4 : i4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int K(byte b4, int i4) {
        int i5 = b4 / i4;
        return ((b4 ^ i4) >= 0 || i4 * i5 == b4) ? i5 : i5 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int L(byte b4, short s3) {
        int i4 = b4 / s3;
        return ((b4 ^ s3) >= 0 || s3 * i4 == b4) ? i4 : i4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int M(int i4, byte b4) {
        int i5 = i4 / b4;
        return ((i4 ^ b4) >= 0 || b4 * i5 == i4) ? i5 : i5 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int N(int i4, int i5) {
        int i6 = i4 / i5;
        return ((i4 ^ i5) >= 0 || i5 * i6 == i4) ? i6 : i6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int O(int i4, short s3) {
        int i5 = i4 / s3;
        return ((i4 ^ s3) >= 0 || s3 * i5 == i4) ? i5 : i5 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int P(short s3, byte b4) {
        int i4 = s3 / b4;
        return ((s3 ^ b4) >= 0 || b4 * i4 == s3) ? i4 : i4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int Q(short s3, int i4) {
        int i5 = s3 / i4;
        return ((s3 ^ i4) >= 0 || i4 * i5 == s3) ? i5 : i5 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int R(short s3, short s4) {
        int i4 = s3 / s4;
        return ((s3 ^ s4) >= 0 || s4 * i4 == s3) ? i4 : i4 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long S(byte b4, long j4) {
        long j5 = b4;
        long j6 = j5 / j4;
        return ((j5 ^ j4) >= 0 || j4 * j6 == j5) ? j6 : j6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long T(int i4, long j4) {
        long j5 = i4;
        long j6 = j5 / j4;
        return ((j5 ^ j4) >= 0 || j4 * j6 == j5) ? j6 : j6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long U(long j4, byte b4) {
        long j5 = b4;
        long j6 = j4 / j5;
        return ((j4 ^ j5) >= 0 || j5 * j6 == j4) ? j6 : j6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long V(long j4, int i4) {
        long j5 = i4;
        long j6 = j4 / j5;
        return ((j4 ^ j5) >= 0 || j5 * j6 == j4) ? j6 : j6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long W(long j4, long j5) {
        long j6 = j4 / j5;
        return ((j4 ^ j5) >= 0 || j5 * j6 == j4) ? j6 : j6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long X(long j4, short s3) {
        long j5 = s3;
        long j6 = j4 / j5;
        return ((j4 ^ j5) >= 0 || j5 * j6 == j4) ? j6 : j6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long Y(short s3, long j4) {
        long j5 = s3;
        long j6 = j5 / j4;
        return ((j5 ^ j4) >= 0 || j4 * j6 == j5) ? j6 : j6 - 1;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final byte Z(byte b4, byte b5) {
        int i4 = b4 % b5;
        return (byte) (i4 + (b5 & (((i4 ^ b5) & ((-i4) | i4)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final byte a0(int i4, byte b4) {
        int i5 = i4 % b4;
        return (byte) (i5 + (b4 & (((i5 ^ b4) & ((-i5) | i5)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final byte b0(long j4, byte b4) {
        long j5;
        long j6 = j4 % b4;
        return (byte) (j6 + (j5 & (((j6 ^ j5) & ((-j6) | j6)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final byte c0(short s3, byte b4) {
        int i4 = s3 % b4;
        return (byte) (i4 + (b4 & (((i4 ^ b4) & ((-i4) | i4)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final double d0(double d4, double d5) {
        double d6 = d4 % d5;
        if (d6 == 0.0d) {
            return d6;
        }
        return !(Math.signum(d6) == Math.signum(d5)) ? d6 + d5 : d6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final double e0(double d4, float f4) {
        double d5 = f4;
        Double.isNaN(d5);
        double d6 = d4 % d5;
        if (d6 == 0.0d) {
            return d6;
        }
        if (Math.signum(d6) == Math.signum(d5)) {
            return d6;
        }
        Double.isNaN(d5);
        return d6 + d5;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final double f0(float f4, double d4) {
        double d5 = f4;
        Double.isNaN(d5);
        double d6 = d5 % d4;
        if (d6 == 0.0d) {
            return d6;
        }
        return !(Math.signum(d6) == Math.signum(d4)) ? d6 + d4 : d6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final float g0(float f4, float f5) {
        float f6 = f4 % f5;
        if (f6 == 0.0f) {
            return f6;
        }
        return !(Math.signum(f6) == Math.signum(f5)) ? f6 + f5 : f6;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int h0(byte b4, int i4) {
        int i5 = b4 % i4;
        return i5 + (i4 & (((i5 ^ i4) & ((-i5) | i5)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int i0(int i4, int i5) {
        int i6 = i4 % i5;
        return i6 + (i5 & (((i6 ^ i5) & ((-i6) | i6)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int j0(long j4, int i4) {
        long j5 = i4;
        long j6 = j4 % j5;
        return (int) (j6 + (j5 & (((j6 ^ j5) & ((-j6) | j6)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final int k0(short s3, int i4) {
        int i5 = s3 % i4;
        return i5 + (i4 & (((i5 ^ i4) & ((-i5) | i5)) >> 31));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long l0(byte b4, long j4) {
        long j5 = b4 % j4;
        return j5 + (j4 & (((j5 ^ j4) & ((-j5) | j5)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long m0(int i4, long j4) {
        long j5 = i4 % j4;
        return j5 + (j4 & (((j5 ^ j4) & ((-j5) | j5)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long n0(long j4, long j5) {
        long j6 = j4 % j5;
        return j6 + (j5 & (((j6 ^ j5) & ((-j6) | j6)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final long o0(short s3, long j4) {
        long j5 = s3 % j4;
        return j5 + (j4 & (((j5 ^ j4) & ((-j5) | j5)) >> 63));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final short p0(byte b4, short s3) {
        int i4 = b4 % s3;
        return (short) (i4 + (s3 & (((i4 ^ s3) & ((-i4) | i4)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final short q0(int i4, short s3) {
        int i5 = i4 % s3;
        return (short) (i5 + (s3 & (((i5 ^ s3) & ((-i5) | i5)) >> 31)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final short r0(long j4, short s3) {
        long j5;
        long j6 = j4 % s3;
        return (short) (j6 + (j5 & (((j6 ^ j5) & ((-j6) | j6)) >> 63)));
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final short s0(short s3, short s4) {
        int i4 = s3 % s4;
        return (short) (i4 + (s4 & (((i4 ^ s4) & ((-i4) | i4)) >> 31)));
    }
}
