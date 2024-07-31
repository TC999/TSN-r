package kotlin.text;

import com.daimajia.numberprogressbar.BuildConfig;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0010\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u0000\u001a+\u0010\n\u001a\u00020\b*\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a+\u0010\r\u001a\u00020\f*\u00020\u00002\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, m12616d2 = {"", "", "index", "", "W5", "Ljava/util/SortedSet;", "Z5", "Lkotlin/Function1;", "Ljava/math/BigDecimal;", "selector", "X5", "(Ljava/lang/CharSequence;Ll1/l;)Ljava/math/BigDecimal;", "Ljava/math/BigInteger;", "Y5", "(Ljava/lang/CharSequence;Ll1/l;)Ljava/math/BigInteger;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class _StringsJvm extends C14579x {
    @InlineOnly
    /* renamed from: W5 */
    private static final char m6366W5(CharSequence charSequence, int i) {
        return charSequence.charAt(i);
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigDecimal")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: X5 */
    private static final BigDecimal m6365X5(CharSequence charSequence, InterfaceC15280l<? super Character, ? extends BigDecimal> interfaceC15280l) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        C14342f0.m8185o(valueOf, "BigDecimal.valueOf(this.toLong())");
        for (int i = 0; i < charSequence.length(); i++) {
            valueOf = valueOf.add(interfaceC15280l.invoke(Character.valueOf(charSequence.charAt(i))));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    @JvmName(name = "sumOfBigInteger")
    @OverloadResolutionByLambdaReturnType
    /* renamed from: Y5 */
    private static final BigInteger m6364Y5(CharSequence charSequence, InterfaceC15280l<? super Character, ? extends BigInteger> interfaceC15280l) {
        BigInteger valueOf = BigInteger.valueOf(0);
        C14342f0.m8185o(valueOf, "BigInteger.valueOf(this.toLong())");
        for (int i = 0; i < charSequence.length(); i++) {
            valueOf = valueOf.add(interfaceC15280l.invoke(Character.valueOf(charSequence.charAt(i))));
            C14342f0.m8185o(valueOf, "this.add(other)");
        }
        return valueOf;
    }

    @NotNull
    /* renamed from: Z5 */
    public static final SortedSet<Character> m6363Z5(@NotNull CharSequence toSortedSet) {
        C14342f0.m8184p(toSortedSet, "$this$toSortedSet");
        return (SortedSet) _Strings.m6288Y8(toSortedSet, new TreeSet());
    }
}
