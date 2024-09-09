package kotlin.comparisons;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: _ComparisonsJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0017\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0017\u001a/\u0010\u0004\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010\t\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0019\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u0019\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH\u0087\b\u001a\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b\u001a7\u0010\u0013\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a!\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0087\b\u001a!\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0087\b\u001a!\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0087\b\u001a!\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0087\b\u001a!\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\b\u001a!\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0087\b\u001a;\u0010\u001d\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001b\"\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010 \u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u001c\u001a\u00020\u001f\"\u00020\u0006H\u0007\u001a\u001c\u0010\u0001\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\n\u0010\u001c\u001a\u00020!\"\u00020\bH\u0007\u001a\u001c\u0010#\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\n\u0010\u001c\u001a\u00020\"\"\u00020\nH\u0007\u001a\u001c\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u001c\u001a\u00020$\"\u00020\fH\u0007\u001a\u001c\u0010'\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\n\u0010\u001c\u001a\u00020&\"\u00020\u000eH\u0007\u001a\u001c\u0010)\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\n\u0010\u001c\u001a\u00020(\"\u00020\u0010H\u0007\u001a/\u0010*\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b*\u0010\u0005\u001a\u0019\u0010+\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b\u001a\u0019\u0010,\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0019\u0010-\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u001a\u0019\u0010.\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u0019\u0010/\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH\u0087\b\u001a\u0019\u00100\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b\u001a7\u00101\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b1\u0010\u0014\u001a!\u00102\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0087\b\u001a!\u00103\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0087\b\u001a!\u00104\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0087\b\u001a!\u00105\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0087\b\u001a!\u00106\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\b\u001a!\u00107\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0087\b\u001a;\u00108\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001b\"\u00028\u0000H\u0007\u00a2\u0006\u0004\b8\u0010\u001e\u001a\u001c\u00109\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u001c\u001a\u00020\u001f\"\u00020\u0006H\u0007\u001a\u001c\u0010:\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\n\u0010\u001c\u001a\u00020!\"\u00020\bH\u0007\u001a\u001c\u0010;\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\n\u0010\u001c\u001a\u00020\"\"\u00020\nH\u0007\u001a\u001c\u0010<\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u001c\u001a\u00020$\"\u00020\fH\u0007\u001a\u001c\u0010=\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\n\u0010\u001c\u001a\u00020&\"\u00020\u000eH\u0007\u001a\u001c\u0010>\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\n\u0010\u001c\u001a\u00020(\"\u00020\u0010H\u0007\u00a8\u0006?"}, d2 = {"", "T", "a", "b", "O", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "z", "", "R", "", "I", "", "L", "", "F", "", "C", "c", "P", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "A", "S", "J", "M", "G", "D", "", "other", "Q", "(Ljava/lang/Comparable;[Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "B", "", "", "K", "", "N", "", "H", "", "E", "j0", "U", "m0", "d0", "g0", "a0", "X", "k0", "V", "n0", "e0", "h0", "b0", "Y", "l0", "W", "o0", "f0", "i0", "c0", "Z", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c extends b {
    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte A(byte b4, byte b5, byte b6) {
        return (byte) Math.max((int) b4, Math.max((int) b5, (int) b6));
    }

    @SinceKotlin(version = "1.4")
    public static final byte B(byte b4, @NotNull byte... other) {
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            byte b5 = other[i4];
            i4++;
            b4 = (byte) Math.max((int) b4, (int) b5);
        }
        return b4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double C(double d4, double d5) {
        return Math.max(d4, d5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double D(double d4, double d5, double d6) {
        return Math.max(d4, Math.max(d5, d6));
    }

    @SinceKotlin(version = "1.4")
    public static final double E(double d4, @NotNull double... other) {
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            double d5 = other[i4];
            i4++;
            d4 = Math.max(d4, d5);
        }
        return d4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float F(float f4, float f5) {
        return Math.max(f4, f5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float G(float f4, float f5, float f6) {
        return Math.max(f4, Math.max(f5, f6));
    }

    @SinceKotlin(version = "1.4")
    public static final float H(float f4, @NotNull float... other) {
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            float f5 = other[i4];
            i4++;
            f4 = Math.max(f4, f5);
        }
        return f4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int I(int i4, int i5) {
        return Math.max(i4, i5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int J(int i4, int i5, int i6) {
        return Math.max(i4, Math.max(i5, i6));
    }

    @SinceKotlin(version = "1.4")
    public static final int K(int i4, @NotNull int... other) {
        f0.p(other, "other");
        int length = other.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = other[i5];
            i5++;
            i4 = Math.max(i4, i6);
        }
        return i4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long L(long j4, long j5) {
        return Math.max(j4, j5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long M(long j4, long j5, long j6) {
        return Math.max(j4, Math.max(j5, j6));
    }

    @SinceKotlin(version = "1.4")
    public static final long N(long j4, @NotNull long... other) {
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            long j5 = other[i4];
            i4++;
            j4 = Math.max(j4, j5);
        }
        return j4;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static <T extends Comparable<? super T>> T O(@NotNull T a4, @NotNull T b4) {
        f0.p(a4, "a");
        f0.p(b4, "b");
        return a4.compareTo(b4) >= 0 ? a4 : b4;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T P(@NotNull T a4, @NotNull T b4, @NotNull T c4) {
        f0.p(a4, "a");
        f0.p(b4, "b");
        f0.p(c4, "c");
        return (T) a.O(a4, a.O(b4, c4));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T extends Comparable<? super T>> T Q(@NotNull T a4, @NotNull T... other) {
        f0.p(a4, "a");
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            T t3 = other[i4];
            i4++;
            a4 = (T) a.O(a4, t3);
        }
        return a4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short R(short s3, short s4) {
        return (short) Math.max((int) s3, (int) s4);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short S(short s3, short s4, short s5) {
        return (short) Math.max((int) s3, Math.max((int) s4, (int) s5));
    }

    @SinceKotlin(version = "1.4")
    public static final short T(short s3, @NotNull short... other) {
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            short s4 = other[i4];
            i4++;
            s3 = (short) Math.max((int) s3, (int) s4);
        }
        return s3;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte U(byte b4, byte b5) {
        return (byte) Math.min((int) b4, (int) b5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte V(byte b4, byte b5, byte b6) {
        return (byte) Math.min((int) b4, Math.min((int) b5, (int) b6));
    }

    @SinceKotlin(version = "1.4")
    public static final byte W(byte b4, @NotNull byte... other) {
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            byte b5 = other[i4];
            i4++;
            b4 = (byte) Math.min((int) b4, (int) b5);
        }
        return b4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double X(double d4, double d5) {
        return Math.min(d4, d5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double Y(double d4, double d5, double d6) {
        return Math.min(d4, Math.min(d5, d6));
    }

    @SinceKotlin(version = "1.4")
    public static final double Z(double d4, @NotNull double... other) {
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            double d5 = other[i4];
            i4++;
            d4 = Math.min(d4, d5);
        }
        return d4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float a0(float f4, float f5) {
        return Math.min(f4, f5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float b0(float f4, float f5, float f6) {
        return Math.min(f4, Math.min(f5, f6));
    }

    @SinceKotlin(version = "1.4")
    public static final float c0(float f4, @NotNull float... other) {
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            float f5 = other[i4];
            i4++;
            f4 = Math.min(f4, f5);
        }
        return f4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int d0(int i4, int i5) {
        return Math.min(i4, i5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int e0(int i4, int i5, int i6) {
        return Math.min(i4, Math.min(i5, i6));
    }

    @SinceKotlin(version = "1.4")
    public static final int f0(int i4, @NotNull int... other) {
        f0.p(other, "other");
        int length = other.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = other[i5];
            i5++;
            i4 = Math.min(i4, i6);
        }
        return i4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long g0(long j4, long j5) {
        return Math.min(j4, j5);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long h0(long j4, long j5, long j6) {
        return Math.min(j4, Math.min(j5, j6));
    }

    @SinceKotlin(version = "1.4")
    public static final long i0(long j4, @NotNull long... other) {
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            long j5 = other[i4];
            i4++;
            j4 = Math.min(j4, j5);
        }
        return j4;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T j0(@NotNull T a4, @NotNull T b4) {
        f0.p(a4, "a");
        f0.p(b4, "b");
        return a4.compareTo(b4) <= 0 ? a4 : b4;
    }

    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T extends Comparable<? super T>> T k0(@NotNull T a4, @NotNull T b4, @NotNull T c4) {
        f0.p(a4, "a");
        f0.p(b4, "b");
        f0.p(c4, "c");
        return (T) j0(a4, j0(b4, c4));
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <T extends Comparable<? super T>> T l0(@NotNull T a4, @NotNull T... other) {
        f0.p(a4, "a");
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            T t3 = other[i4];
            i4++;
            a4 = (T) j0(a4, t3);
        }
        return a4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short m0(short s3, short s4) {
        return (short) Math.min((int) s3, (int) s4);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short n0(short s3, short s4, short s5) {
        return (short) Math.min((int) s3, Math.min((int) s4, (int) s5));
    }

    @SinceKotlin(version = "1.4")
    public static final short o0(short s3, @NotNull short... other) {
        f0.p(other, "other");
        int length = other.length;
        int i4 = 0;
        while (i4 < length) {
            short s4 = other[i4];
            i4++;
            s3 = (short) Math.min((int) s3, (int) s4);
        }
        return s3;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte z(byte b4, byte b5) {
        return (byte) Math.max((int) b4, (int) b5);
    }
}
