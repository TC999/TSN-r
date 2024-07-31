package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversionsJVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000R\n\u0002\u0010\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0007\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\t\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u000b\u001a\u00020\n*\u00020\u0003H\u0087\b\u001a\u0016\u0010\f\u001a\u00020\n*\u0004\u0018\u00010\u0003H\u0087\b¢\u0006\u0004\b\f\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0000*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u000f\u001a\u00020\u0000*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0005*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0005*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\b*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0015\u001a\u00020\b*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0016*\u00020\u0003H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u0018*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0016*\u00020\u0003H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0018*\u00020\u0003H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\r\u0010\u001f\u001a\u00020\u001e*\u00020\u0003H\u0087\b\u001a\u0015\u0010 \u001a\u00020\u001e*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u000e\u0010!\u001a\u0004\u0018\u00010\u001e*\u00020\u0003H\u0007\u001a\u0016\u0010\"\u001a\u0004\u0018\u00010\u001e*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007\u001a\r\u0010$\u001a\u00020#*\u00020\u0003H\u0087\b\u001a\u0015\u0010'\u001a\u00020#*\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0087\b\u001a\u000e\u0010(\u001a\u0004\u0018\u00010#*\u00020\u0003H\u0007\u001a\u0016\u0010)\u001a\u0004\u0018\u00010#*\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0007\u001a4\u0010.\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010*2\u0006\u0010+\u001a\u00020\u00032\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000,H\u0082\b¢\u0006\u0004\b.\u0010/¨\u00060"}, m12616d2 = {"", "", "radix", "", "Q0", "", "T0", "R0", "", "S0", "", "C0", "D0", "(Ljava/lang/String;)Z", "E0", "F0", "O0", "P0", "K0", "L0", "M0", "N0", "", "I0", "", "G0", "J0", "(Ljava/lang/String;)Ljava/lang/Float;", "H0", "(Ljava/lang/String;)Ljava/lang/Double;", "Ljava/math/BigInteger;", "y0", "z0", "A0", "B0", "Ljava/math/BigDecimal;", "u0", "Ljava/math/MathContext;", "mathContext", "v0", "w0", "x0", ExifInterface.GPS_DIRECTION_TRUE, "str", "Lkotlin/Function1;", "parse", "t0", "(Ljava/lang/String;Ll1/l;)Ljava/lang/Object;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.u */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C14578u extends StringBuilder {
    @SinceKotlin(version = "1.2")
    @Nullable
    /* renamed from: A0 */
    public static final BigInteger m6660A0(@NotNull String toBigIntegerOrNull) {
        C14342f0.m8184p(toBigIntegerOrNull, "$this$toBigIntegerOrNull");
        return m6659B0(toBigIntegerOrNull, 10);
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    /* renamed from: B0 */
    public static final BigInteger m6659B0(@NotNull String toBigIntegerOrNull, int i) {
        int m6893a;
        C14342f0.m8184p(toBigIntegerOrNull, "$this$toBigIntegerOrNull");
        CharJVM.m6893a(i);
        int length = toBigIntegerOrNull.length();
        if (length != 0) {
            if (length != 1) {
                for (int i2 = toBigIntegerOrNull.charAt(0) == '-' ? 1 : 0; i2 < length; i2++) {
                    if (CharJVM.m6892b(toBigIntegerOrNull.charAt(i2), i) < 0) {
                        return null;
                    }
                }
            } else if (CharJVM.m6892b(toBigIntegerOrNull.charAt(0), i) < 0) {
                return null;
            }
            m6893a = CharJVM.m6893a(i);
            return new BigInteger(toBigIntegerOrNull, m6893a);
        }
        return null;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "toBooleanNullable")
    /* renamed from: D0 */
    private static final boolean m6657D0(String str) {
        return Boolean.parseBoolean(str);
    }

    @InlineOnly
    /* renamed from: E0 */
    private static final byte m6656E0(String str) {
        return Byte.parseByte(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: F0 */
    private static final byte m6655F0(String str, int i) {
        int m6893a;
        m6893a = CharJVM.m6893a(i);
        return Byte.parseByte(str, m6893a);
    }

    @InlineOnly
    /* renamed from: G0 */
    private static final double m6654G0(String str) {
        return Double.parseDouble(str);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    /* renamed from: H0 */
    public static final Double m6653H0(@NotNull String toDoubleOrNull) {
        C14342f0.m8184p(toDoubleOrNull, "$this$toDoubleOrNull");
        try {
            if (StringNumberConversionsJVM.f41621a.matches(toDoubleOrNull)) {
                return Double.valueOf(Double.parseDouble(toDoubleOrNull));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    /* renamed from: I0 */
    private static final float m6652I0(String str) {
        return Float.parseFloat(str);
    }

    @SinceKotlin(version = "1.1")
    @Nullable
    /* renamed from: J0 */
    public static final Float m6651J0(@NotNull String toFloatOrNull) {
        C14342f0.m8184p(toFloatOrNull, "$this$toFloatOrNull");
        try {
            if (StringNumberConversionsJVM.f41621a.matches(toFloatOrNull)) {
                return Float.valueOf(Float.parseFloat(toFloatOrNull));
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @InlineOnly
    /* renamed from: K0 */
    private static final int m6650K0(String str) {
        return Integer.parseInt(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: L0 */
    private static final int m6649L0(String str, int i) {
        int m6893a;
        m6893a = CharJVM.m6893a(i);
        return Integer.parseInt(str, m6893a);
    }

    @InlineOnly
    /* renamed from: M0 */
    private static final long m6648M0(String str) {
        return Long.parseLong(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: N0 */
    private static final long m6647N0(String str, int i) {
        int m6893a;
        m6893a = CharJVM.m6893a(i);
        return Long.parseLong(str, m6893a);
    }

    @InlineOnly
    /* renamed from: O0 */
    private static final short m6646O0(String str) {
        return Short.parseShort(str);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: P0 */
    private static final short m6645P0(String str, int i) {
        int m6893a;
        m6893a = CharJVM.m6893a(i);
        return Short.parseShort(str, m6893a);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: Q0 */
    private static final String m6644Q0(byte b, int i) {
        int m6893a;
        int m6893a2;
        m6893a = CharJVM.m6893a(i);
        m6893a2 = CharJVM.m6893a(m6893a);
        String num = Integer.toString(b, m6893a2);
        C14342f0.m8185o(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: R0 */
    private static final String m6643R0(int i, int i2) {
        int m6893a;
        m6893a = CharJVM.m6893a(i2);
        String num = Integer.toString(i, m6893a);
        C14342f0.m8185o(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: S0 */
    private static final String m6642S0(long j, int i) {
        int m6893a;
        m6893a = CharJVM.m6893a(i);
        String l = Long.toString(j, m6893a);
        C14342f0.m8185o(l, "java.lang.Long.toString(this, checkRadix(radix))");
        return l;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: T0 */
    private static final String m6641T0(short s, int i) {
        int m6893a;
        int m6893a2;
        m6893a = CharJVM.m6893a(i);
        m6893a2 = CharJVM.m6893a(m6893a);
        String num = Integer.toString(s, m6893a2);
        C14342f0.m8185o(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        return num;
    }

    /* renamed from: t0 */
    private static final <T> T m6640t0(String str, InterfaceC15280l<? super String, ? extends T> interfaceC15280l) {
        try {
            if (StringNumberConversionsJVM.f41621a.matches(str)) {
                return interfaceC15280l.invoke(str);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: u0 */
    private static final BigDecimal m6639u0(String str) {
        return new BigDecimal(str);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: v0 */
    private static final BigDecimal m6638v0(String str, MathContext mathContext) {
        return new BigDecimal(str, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    /* renamed from: w0 */
    public static final BigDecimal m6637w0(@NotNull String toBigDecimalOrNull) {
        C14342f0.m8184p(toBigDecimalOrNull, "$this$toBigDecimalOrNull");
        try {
            if (StringNumberConversionsJVM.f41621a.matches(toBigDecimalOrNull)) {
                return new BigDecimal(toBigDecimalOrNull);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @Nullable
    /* renamed from: x0 */
    public static final BigDecimal m6636x0(@NotNull String toBigDecimalOrNull, @NotNull MathContext mathContext) {
        C14342f0.m8184p(toBigDecimalOrNull, "$this$toBigDecimalOrNull");
        C14342f0.m8184p(mathContext, "mathContext");
        try {
            if (StringNumberConversionsJVM.f41621a.matches(toBigDecimalOrNull)) {
                return new BigDecimal(toBigDecimalOrNull, mathContext);
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: y0 */
    private static final BigInteger m6635y0(String str) {
        return new BigInteger(str);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: z0 */
    private static final BigInteger m6634z0(String str, int i) {
        int m6893a;
        m6893a = CharJVM.m6893a(i);
        return new BigInteger(str, m6893a);
    }
}
