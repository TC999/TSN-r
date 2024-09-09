package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: StringNumberConversionsJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\n*\u00020\u0003H\u0087\b\u001a\u0016\u0010\f\u001a\u00020\n*\u0004\u0018\u00010\u0003H\u0087\b\u00a2\u0006\u0004\b\f\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0000*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0005*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0005*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\b*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0016*\u00020\u0003H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u0018*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0016*\u00020\u0003H\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001b\u001a\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0018*\u00020\u0003H\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\r\u0010\u001f\u001a\u00020\u001e*\u00020\u0003H\u0087\b\u001a\u0015\u0010 \u001a\u00020\u001e*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u000e\u0010!\u001a\u0004\u0018\u00010\u001e*\u00020\u0003H\u0007\u001a\u0016\u0010\"\u001a\u0004\u0018\u00010\u001e*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\r\u0010$\u001a\u00020#*\u00020\u0003H\u0087\b\u001a\u0015\u0010'\u001a\u00020#*\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0087\b\u001a\u000e\u0010(\u001a\u0004\u0018\u00010#*\u00020\u0003H\u0007\u001a\u0016\u0010)\u001a\u0004\u0018\u00010#*\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0007\u001a4\u0010.\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010*2\u0006\u0010+\u001a\u00020\u00032\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000,H\u0082\b\u00a2\u0006\u0004\b.\u0010/\u00a8\u00060"}, d2 = {"", "", "radix", "", "Q0", "", "T0", "R0", "", "S0", "", "C0", "D0", "(Ljava/lang/String;)Z", "E0", "F0", "O0", "P0", "K0", "L0", "M0", "N0", "", "I0", "", "G0", "J0", "(Ljava/lang/String;)Ljava/lang/Float;", "H0", "(Ljava/lang/String;)Ljava/lang/Double;", "Ljava/math/BigInteger;", "y0", "z0", "A0", "B0", "Ljava/math/BigDecimal;", "u0", "Ljava/math/MathContext;", "mathContext", "v0", "w0", "x0", "T", "str", "Lkotlin/Function1;", "parse", "t0", "(Ljava/lang/String;Ld2/l;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class u extends t {
    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigInteger A0(@NotNull String str) {
        f0.p(str, "<this>");
        return B0(str, 10);
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigInteger B0(@NotNull String str, int i4) {
        int a4;
        f0.p(str, "<this>");
        b.a(i4);
        int length = str.length();
        if (length != 0) {
            if (length != 1) {
                int i5 = str.charAt(0) == '-' ? 1 : 0;
                while (i5 < length) {
                    int i6 = i5 + 1;
                    if (b.b(str.charAt(i5), i4) < 0) {
                        return null;
                    }
                    i5 = i6;
                }
            } else if (b.b(str.charAt(0), i4) < 0) {
                return null;
            }
            a4 = b.a(i4);
            return new BigInteger(str, a4);
        }
        return null;
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    @InlineOnly
    private static final /* synthetic */ boolean C0(String str) {
        f0.p(str, "<this>");
        return Boolean.parseBoolean(str);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "toBooleanNullable")
    private static final boolean D0(String str) {
        return Boolean.parseBoolean(str);
    }

    @InlineOnly
    private static final byte E0(String str) {
        f0.p(str, "<this>");
        return Byte.parseByte(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte F0(String str, int i4) {
        int a4;
        f0.p(str, "<this>");
        a4 = b.a(i4);
        return Byte.parseByte(str, a4);
    }

    @InlineOnly
    private static final double G0(String str) {
        f0.p(str, "<this>");
        return Double.parseDouble(str);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Double H0(@NotNull String str) {
        f0.p(str, "<this>");
        try {
            if (m.f58960b.matches(str)) {
                return Double.valueOf(Double.parseDouble(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    private static final float I0(String str) {
        f0.p(str, "<this>");
        return Float.parseFloat(str);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    public static final Float J0(@NotNull String str) {
        f0.p(str, "<this>");
        try {
            if (m.f58960b.matches(str)) {
                return Float.valueOf(Float.parseFloat(str));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    private static final int K0(String str) {
        f0.p(str, "<this>");
        return Integer.parseInt(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int L0(String str, int i4) {
        int a4;
        f0.p(str, "<this>");
        a4 = b.a(i4);
        return Integer.parseInt(str, a4);
    }

    @InlineOnly
    private static final long M0(String str) {
        f0.p(str, "<this>");
        return Long.parseLong(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long N0(String str, int i4) {
        int a4;
        f0.p(str, "<this>");
        a4 = b.a(i4);
        return Long.parseLong(str, a4);
    }

    @InlineOnly
    private static final short O0(String str) {
        f0.p(str, "<this>");
        return Short.parseShort(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short P0(String str, int i4) {
        int a4;
        f0.p(str, "<this>");
        a4 = b.a(i4);
        return Short.parseShort(str, a4);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String Q0(byte b4, int i4) {
        int a4;
        int a5;
        a4 = b.a(i4);
        a5 = b.a(a4);
        String num = Integer.toString(b4, a5);
        f0.o(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String R0(int i4, int i5) {
        int a4;
        a4 = b.a(i5);
        String num = Integer.toString(i4, a4);
        f0.o(num, "toString(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String S0(long j4, int i4) {
        int a4;
        a4 = b.a(i4);
        String l4 = Long.toString(j4, a4);
        f0.o(l4, "toString(this, checkRadix(radix))");
        return l4;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final String T0(short s3, int i4) {
        int a4;
        int a5;
        a4 = b.a(i4);
        a5 = b.a(a4);
        String num = Integer.toString(s3, a5);
        f0.o(num, "toString(this, checkRadix(radix))");
        return num;
    }

    private static final <T> T t0(String str, d2.l<? super String, ? extends T> lVar) {
        try {
            if (m.f58960b.matches(str)) {
                return lVar.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal u0(String str) {
        f0.p(str, "<this>");
        return new BigDecimal(str);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal v0(String str, MathContext mathContext) {
        f0.p(str, "<this>");
        f0.p(mathContext, "mathContext");
        return new BigDecimal(str, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigDecimal w0(@NotNull String str) {
        f0.p(str, "<this>");
        try {
            if (m.f58960b.matches(str)) {
                return new BigDecimal(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    public static final BigDecimal x0(@NotNull String str, @NotNull MathContext mathContext) {
        f0.p(str, "<this>");
        f0.p(mathContext, "mathContext");
        try {
            if (m.f58960b.matches(str)) {
                return new BigDecimal(str, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger y0(String str) {
        f0.p(str, "<this>");
        return new BigInteger(str);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger z0(String str, int i4) {
        int a4;
        f0.p(str, "<this>");
        a4 = b.a(i4);
        return new BigInteger(str, a4);
    }
}
