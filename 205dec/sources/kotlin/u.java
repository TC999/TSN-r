package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BigDecimals.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\r\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\b\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\u000b\u001a\u00020\u0000*\u00020\nH\u0087\b\u001a\u0015\u0010\u000e\u001a\u00020\u0000*\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0000*\u00020\u000fH\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0000*\u00020\u000f2\u0006\u0010\r\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0000*\u00020\u0012H\u0087\b\u001a\u0015\u0010\u0014\u001a\u00020\u0000*\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0000*\u00020\u0015H\u0087\b\u001a\u0015\u0010\u0017\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\r\u001a\u00020\fH\u0087\b\u00a8\u0006\u0018"}, d2 = {"Ljava/math/BigDecimal;", "other", "e", "d", "g", "b", "f", "p", "c", "a", "", "l", "Ljava/math/MathContext;", "mathContext", "m", "", "n", "o", "", "j", "k", "", "h", "i", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/NumbersKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class u {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal a(BigDecimal bigDecimal) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        BigDecimal subtract = bigDecimal.subtract(BigDecimal.ONE);
        kotlin.jvm.internal.f0.o(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    @InlineOnly
    private static final BigDecimal b(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigDecimal divide = bigDecimal.divide(other, RoundingMode.HALF_EVEN);
        kotlin.jvm.internal.f0.o(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal c(BigDecimal bigDecimal) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        BigDecimal add = bigDecimal.add(BigDecimal.ONE);
        kotlin.jvm.internal.f0.o(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    @InlineOnly
    private static final BigDecimal d(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigDecimal subtract = bigDecimal.subtract(other);
        kotlin.jvm.internal.f0.o(subtract, "this.subtract(other)");
        return subtract;
    }

    @InlineOnly
    private static final BigDecimal e(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigDecimal add = bigDecimal.add(other);
        kotlin.jvm.internal.f0.o(add, "this.add(other)");
        return add;
    }

    @InlineOnly
    private static final BigDecimal f(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigDecimal remainder = bigDecimal.remainder(other);
        kotlin.jvm.internal.f0.o(remainder, "this.remainder(other)");
        return remainder;
    }

    @InlineOnly
    private static final BigDecimal g(BigDecimal bigDecimal, BigDecimal other) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigDecimal multiply = bigDecimal.multiply(other);
        kotlin.jvm.internal.f0.o(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal h(double d4) {
        return new BigDecimal(String.valueOf(d4));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal i(double d4, MathContext mathContext) {
        kotlin.jvm.internal.f0.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(d4), mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal j(float f4) {
        return new BigDecimal(String.valueOf(f4));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal k(float f4, MathContext mathContext) {
        kotlin.jvm.internal.f0.p(mathContext, "mathContext");
        return new BigDecimal(String.valueOf(f4), mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal l(int i4) {
        BigDecimal valueOf = BigDecimal.valueOf(i4);
        kotlin.jvm.internal.f0.o(valueOf, "valueOf(this.toLong())");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal m(int i4, MathContext mathContext) {
        kotlin.jvm.internal.f0.p(mathContext, "mathContext");
        return new BigDecimal(i4, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal n(long j4) {
        BigDecimal valueOf = BigDecimal.valueOf(j4);
        kotlin.jvm.internal.f0.o(valueOf, "valueOf(this)");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal o(long j4, MathContext mathContext) {
        kotlin.jvm.internal.f0.p(mathContext, "mathContext");
        return new BigDecimal(j4, mathContext);
    }

    @InlineOnly
    private static final BigDecimal p(BigDecimal bigDecimal) {
        kotlin.jvm.internal.f0.p(bigDecimal, "<this>");
        BigDecimal negate = bigDecimal.negate();
        kotlin.jvm.internal.f0.o(negate, "this.negate()");
        return negate;
    }
}
