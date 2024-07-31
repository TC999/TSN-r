package kotlin;

import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u0015\u0010\u0002\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\u0015\u0010\u0006\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0087\n\u001a\r\u0010\u0007\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\b\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\t\u001a\u00020\u0000*\u00020\u0000H\u0087\n\u001a\r\u0010\u000b\u001a\u00020\u0000*\u00020\nH\u0087\b\u001a\u0015\u0010\u000e\u001a\u00020\u0000*\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u0000*\u00020\u000fH\u0087\b\u001a\u0015\u0010\u0011\u001a\u00020\u0000*\u00020\u000f2\u0006\u0010\r\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u0000*\u00020\u0012H\u0087\b\u001a\u0015\u0010\u0014\u001a\u00020\u0000*\u00020\u00122\u0006\u0010\r\u001a\u00020\fH\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0000*\u00020\u0015H\u0087\b\u001a\u0015\u0010\u0017\u001a\u00020\u0000*\u00020\u00152\u0006\u0010\r\u001a\u00020\fH\u0087\b¨\u0006\u0018"}, m12616d2 = {"Ljava/math/BigDecimal;", AdnName.OTHER, "e", "d", "g", "b", "f", "p", "c", "a", "", C7304t.f25048d, "Ljava/math/MathContext;", "mathContext", "m", "", "n", "o", "", "j", "k", "", "h", "i", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/NumbersKt")
/* renamed from: kotlin.u */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class BigDecimals {
    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: a */
    private static final BigDecimal m5970a(BigDecimal dec) {
        C14342f0.m8184p(dec, "$this$dec");
        BigDecimal subtract = dec.subtract(BigDecimal.ONE);
        C14342f0.m8185o(subtract, "this.subtract(BigDecimal.ONE)");
        return subtract;
    }

    @InlineOnly
    /* renamed from: b */
    private static final BigDecimal m5969b(BigDecimal div, BigDecimal bigDecimal) {
        C14342f0.m8184p(div, "$this$div");
        BigDecimal divide = div.divide(bigDecimal, RoundingMode.HALF_EVEN);
        C14342f0.m8185o(divide, "this.divide(other, RoundingMode.HALF_EVEN)");
        return divide;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: c */
    private static final BigDecimal m5968c(BigDecimal inc) {
        C14342f0.m8184p(inc, "$this$inc");
        BigDecimal add = inc.add(BigDecimal.ONE);
        C14342f0.m8185o(add, "this.add(BigDecimal.ONE)");
        return add;
    }

    @InlineOnly
    /* renamed from: d */
    private static final BigDecimal m5967d(BigDecimal minus, BigDecimal bigDecimal) {
        C14342f0.m8184p(minus, "$this$minus");
        BigDecimal subtract = minus.subtract(bigDecimal);
        C14342f0.m8185o(subtract, "this.subtract(other)");
        return subtract;
    }

    @InlineOnly
    /* renamed from: e */
    private static final BigDecimal m5966e(BigDecimal plus, BigDecimal bigDecimal) {
        C14342f0.m8184p(plus, "$this$plus");
        BigDecimal add = plus.add(bigDecimal);
        C14342f0.m8185o(add, "this.add(other)");
        return add;
    }

    @InlineOnly
    /* renamed from: f */
    private static final BigDecimal m5965f(BigDecimal rem, BigDecimal bigDecimal) {
        C14342f0.m8184p(rem, "$this$rem");
        BigDecimal remainder = rem.remainder(bigDecimal);
        C14342f0.m8185o(remainder, "this.remainder(other)");
        return remainder;
    }

    @InlineOnly
    /* renamed from: g */
    private static final BigDecimal m5964g(BigDecimal times, BigDecimal bigDecimal) {
        C14342f0.m8184p(times, "$this$times");
        BigDecimal multiply = times.multiply(bigDecimal);
        C14342f0.m8185o(multiply, "this.multiply(other)");
        return multiply;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: h */
    private static final BigDecimal m5963h(double d) {
        return new BigDecimal(String.valueOf(d));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: i */
    private static final BigDecimal m5962i(double d, MathContext mathContext) {
        return new BigDecimal(String.valueOf(d), mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: j */
    private static final BigDecimal m5961j(float f) {
        return new BigDecimal(String.valueOf(f));
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: k */
    private static final BigDecimal m5960k(float f, MathContext mathContext) {
        return new BigDecimal(String.valueOf(f), mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: l */
    private static final BigDecimal m5959l(int i) {
        BigDecimal valueOf = BigDecimal.valueOf(i);
        C14342f0.m8185o(valueOf, "BigDecimal.valueOf(this.toLong())");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: m */
    private static final BigDecimal m5958m(int i, MathContext mathContext) {
        return new BigDecimal(i, mathContext);
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: n */
    private static final BigDecimal m5957n(long j) {
        BigDecimal valueOf = BigDecimal.valueOf(j);
        C14342f0.m8185o(valueOf, "BigDecimal.valueOf(this)");
        return valueOf;
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: o */
    private static final BigDecimal m5956o(long j, MathContext mathContext) {
        return new BigDecimal(j, mathContext);
    }

    @InlineOnly
    /* renamed from: p */
    private static final BigDecimal m5955p(BigDecimal unaryMinus) {
        C14342f0.m8184p(unaryMinus, "$this$unaryMinus");
        BigDecimal negate = unaryMinus.negate();
        C14342f0.m8185o(negate, "this.negate()");
        return negate;
    }
}
