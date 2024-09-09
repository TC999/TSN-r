package kotlin;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BigIntegers.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\r\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\b\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\n\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\u0015\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\u0015\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\f\u001a\u0015\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\f\u001a\r\u0010\u0012\u001a\u00020\u0000*\u00020\u000eH\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0000*\u00020\u0013H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0015*\u00020\u0000H\u0087\b\u001a!\u0010\u001a\u001a\u00020\u0015*\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0087\b\u00a8\u0006\u001b"}, d2 = {"Ljava/math/BigInteger;", "other", "x", "v", "B", "s", "y", "H", "t", "r", "u", CampaignEx.JSON_KEY_AD_Q, "w", "I", "", "n", "z", "A", "F", "", "G", "Ljava/math/BigDecimal;", "C", "scale", "Ljava/math/MathContext;", "mathContext", "D", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/NumbersKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class v extends u {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger A(BigInteger bigInteger, int i4) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        BigInteger shiftRight = bigInteger.shiftRight(i4);
        kotlin.jvm.internal.f0.o(shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    @InlineOnly
    private static final BigInteger B(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigInteger multiply = bigInteger.multiply(other);
        kotlin.jvm.internal.f0.o(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal C(BigInteger bigInteger) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        return new BigDecimal(bigInteger);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigDecimal D(BigInteger bigInteger, int i4, MathContext mathContext) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        kotlin.jvm.internal.f0.p(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i4, mathContext);
    }

    static /* synthetic */ BigDecimal E(BigInteger bigInteger, int i4, MathContext mathContext, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 0;
        }
        if ((i5 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            kotlin.jvm.internal.f0.o(mathContext, "UNLIMITED");
        }
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        kotlin.jvm.internal.f0.p(mathContext, "mathContext");
        return new BigDecimal(bigInteger, i4, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger F(int i4) {
        BigInteger valueOf = BigInteger.valueOf(i4);
        kotlin.jvm.internal.f0.o(valueOf, "valueOf(this.toLong())");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger G(long j4) {
        BigInteger valueOf = BigInteger.valueOf(j4);
        kotlin.jvm.internal.f0.o(valueOf, "valueOf(this)");
        return valueOf;
    }

    @InlineOnly
    private static final BigInteger H(BigInteger bigInteger) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        BigInteger negate = bigInteger.negate();
        kotlin.jvm.internal.f0.o(negate, "this.negate()");
        return negate;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger I(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigInteger xor = bigInteger.xor(other);
        kotlin.jvm.internal.f0.o(xor, "this.xor(other)");
        return xor;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger q(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigInteger and = bigInteger.and(other);
        kotlin.jvm.internal.f0.o(and, "this.and(other)");
        return and;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger r(BigInteger bigInteger) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        BigInteger subtract = bigInteger.subtract(BigInteger.ONE);
        kotlin.jvm.internal.f0.o(subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    @InlineOnly
    private static final BigInteger s(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigInteger divide = bigInteger.divide(other);
        kotlin.jvm.internal.f0.o(divide, "this.divide(other)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger t(BigInteger bigInteger) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        BigInteger add = bigInteger.add(BigInteger.ONE);
        kotlin.jvm.internal.f0.o(add, "this.add(BigInteger.ONE)");
        return add;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger u(BigInteger bigInteger) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        BigInteger not = bigInteger.not();
        kotlin.jvm.internal.f0.o(not, "this.not()");
        return not;
    }

    @InlineOnly
    private static final BigInteger v(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigInteger subtract = bigInteger.subtract(other);
        kotlin.jvm.internal.f0.o(subtract, "this.subtract(other)");
        return subtract;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger w(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigInteger or = bigInteger.or(other);
        kotlin.jvm.internal.f0.o(or, "this.or(other)");
        return or;
    }

    @InlineOnly
    private static final BigInteger x(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigInteger add = bigInteger.add(other);
        kotlin.jvm.internal.f0.o(add, "this.add(other)");
        return add;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final BigInteger y(BigInteger bigInteger, BigInteger other) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        kotlin.jvm.internal.f0.p(other, "other");
        BigInteger remainder = bigInteger.remainder(other);
        kotlin.jvm.internal.f0.o(remainder, "this.remainder(other)");
        return remainder;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    private static final BigInteger z(BigInteger bigInteger, int i4) {
        kotlin.jvm.internal.f0.p(bigInteger, "<this>");
        BigInteger shiftLeft = bigInteger.shiftLeft(i4);
        kotlin.jvm.internal.f0.o(shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }
}
