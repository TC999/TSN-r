package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: _StringsJvm.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0010\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u0000\u001a+\u0010\n\u001a\u00020\b*\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\r\u001a\u00020\f*\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000f"}, d2 = {"", "", "index", "", "W5", "Ljava/util/SortedSet;", "Z5", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "X5", "(Ljava/lang/CharSequence;Ld2/l;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "Y5", "(Ljava/lang/CharSequence;Ld2/l;)Ljava/math/BigInteger;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class y extends x {
    @InlineOnly
    private static final char W5(CharSequence charSequence, int i4) {
        f0.p(charSequence, "<this>");
        return charSequence.charAt(i4);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    private static final BigDecimal X5(CharSequence charSequence, d2.l<? super Character, ? extends BigDecimal> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        BigDecimal valueOf = BigDecimal.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        int i4 = 0;
        while (i4 < charSequence.length()) {
            char charAt = charSequence.charAt(i4);
            i4++;
            valueOf = valueOf.add(selector.invoke(Character.valueOf(charAt)));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    private static final BigInteger Y5(CharSequence charSequence, d2.l<? super Character, ? extends BigInteger> selector) {
        f0.p(charSequence, "<this>");
        f0.p(selector, "selector");
        BigInteger valueOf = BigInteger.valueOf(0L);
        f0.o(valueOf, "valueOf(this.toLong())");
        int i4 = 0;
        while (i4 < charSequence.length()) {
            char charAt = charSequence.charAt(i4);
            i4++;
            valueOf = valueOf.add(selector.invoke(Character.valueOf(charAt)));
            f0.o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    public static final SortedSet<Character> Z5(@NotNull CharSequence charSequence) {
        f0.p(charSequence, "<this>");
        return (SortedSet) z.Y8(charSequence, new TreeSet());
    }
}
