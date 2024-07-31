package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\r\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\b\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\n\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\u0015\u0010\f\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\u0015\u0010\r\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\f\u001a\u0015\u0010\u0010\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\f\u001a\u0015\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0087\f\u001a\r\u0010\u0012\u001a\u00020\u0000*\u00020\u000eH\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0000*\u00020\u0013H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0015*\u00020\u0000H\u0087\b\u001a!\u0010\u001a\u001a\u00020\u0015*\u00020\u00002\b\b\u0002\u0010\u0017\u001a\u00020\u000e2\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0087\b¨\u0006\u001b"}, m12616d2 = {"Ljava/math/BigInteger;", AdnName.OTHER, "x", "v", "B", "s", "y", "H", UMCommonContent.f37782aL, "r", "u", CampaignEx.JSON_KEY_AD_Q, IAdInterListener.AdReqParam.WIDTH, "I", "", "n", UMCommonContent.f37777aG, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "F", "", "G", "Ljava/math/BigDecimal;", "C", "scale", "Ljava/math/MathContext;", "mathContext", "D", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/NumbersKt")
/* renamed from: kotlin.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class BigIntegers extends BigDecimals {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: A */
    private static final BigInteger m5948A(BigInteger bigInteger, int i) {
        BigInteger shiftRight = bigInteger.shiftRight(i);
        C14342f0.m8185o(shiftRight, "this.shiftRight(n)");
        return shiftRight;
    }

    @InlineOnly
    /* renamed from: B */
    private static final BigInteger m5947B(BigInteger times, BigInteger bigInteger) {
        C14342f0.m8184p(times, "$this$times");
        BigInteger multiply = times.multiply(bigInteger);
        C14342f0.m8185o(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: C */
    private static final BigDecimal m5946C(BigInteger bigInteger) {
        return new BigDecimal(bigInteger);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: D */
    private static final BigDecimal m5945D(BigInteger bigInteger, int i, MathContext mathContext) {
        return new BigDecimal(bigInteger, i, mathContext);
    }

    /* renamed from: E */
    static /* synthetic */ BigDecimal m5944E(BigInteger bigInteger, int i, MathContext mathContext, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            mathContext = MathContext.UNLIMITED;
            C14342f0.m8185o(mathContext, "MathContext.UNLIMITED");
        }
        return new BigDecimal(bigInteger, i, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: F */
    private static final BigInteger m5943F(int i) {
        BigInteger valueOf = BigInteger.valueOf(i);
        C14342f0.m8185o(valueOf, "BigInteger.valueOf(this.toLong())");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: G */
    private static final BigInteger m5942G(long j) {
        BigInteger valueOf = BigInteger.valueOf(j);
        C14342f0.m8185o(valueOf, "BigInteger.valueOf(this)");
        return valueOf;
    }

    @InlineOnly
    /* renamed from: H */
    private static final BigInteger m5941H(BigInteger unaryMinus) {
        C14342f0.m8184p(unaryMinus, "$this$unaryMinus");
        BigInteger negate = unaryMinus.negate();
        C14342f0.m8185o(negate, "this.negate()");
        return negate;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: I */
    private static final BigInteger m5940I(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger xor = bigInteger.xor(bigInteger2);
        C14342f0.m8185o(xor, "this.xor(other)");
        return xor;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: q */
    private static final BigInteger m5939q(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger and = bigInteger.and(bigInteger2);
        C14342f0.m8185o(and, "this.and(other)");
        return and;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: r */
    private static final BigInteger m5938r(BigInteger dec) {
        C14342f0.m8184p(dec, "$this$dec");
        BigInteger subtract = dec.subtract(BigInteger.ONE);
        C14342f0.m8185o(subtract, "this.subtract(BigInteger.ONE)");
        return subtract;
    }

    @InlineOnly
    /* renamed from: s */
    private static final BigInteger m5937s(BigInteger div, BigInteger bigInteger) {
        C14342f0.m8184p(div, "$this$div");
        BigInteger divide = div.divide(bigInteger);
        C14342f0.m8185o(divide, "this.divide(other)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: t */
    private static final BigInteger m5936t(BigInteger inc) {
        C14342f0.m8184p(inc, "$this$inc");
        BigInteger add = inc.add(BigInteger.ONE);
        C14342f0.m8185o(add, "this.add(BigInteger.ONE)");
        return add;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: u */
    private static final BigInteger m5935u(BigInteger bigInteger) {
        BigInteger not = bigInteger.not();
        C14342f0.m8185o(not, "this.not()");
        return not;
    }

    @InlineOnly
    /* renamed from: v */
    private static final BigInteger m5934v(BigInteger minus, BigInteger bigInteger) {
        C14342f0.m8184p(minus, "$this$minus");
        BigInteger subtract = minus.subtract(bigInteger);
        C14342f0.m8185o(subtract, "this.subtract(other)");
        return subtract;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: w */
    private static final BigInteger m5933w(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger or = bigInteger.or(bigInteger2);
        C14342f0.m8185o(or, "this.or(other)");
        return or;
    }

    @InlineOnly
    /* renamed from: x */
    private static final BigInteger m5932x(BigInteger plus, BigInteger bigInteger) {
        C14342f0.m8184p(plus, "$this$plus");
        BigInteger add = plus.add(bigInteger);
        C14342f0.m8185o(add, "this.add(other)");
        return add;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    /* renamed from: y */
    private static final BigInteger m5931y(BigInteger rem, BigInteger bigInteger) {
        C14342f0.m8184p(rem, "$this$rem");
        BigInteger remainder = rem.remainder(bigInteger);
        C14342f0.m8185o(remainder, "this.remainder(other)");
        return remainder;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: z */
    private static final BigInteger m5930z(BigInteger bigInteger, int i) {
        BigInteger shiftLeft = bigInteger.shiftLeft(i);
        C14342f0.m8185o(shiftLeft, "this.shiftLeft(n)");
        return shiftLeft;
    }
}
