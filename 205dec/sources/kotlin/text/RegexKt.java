package kotlin.text;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Regex.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0002\u001a-\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0014\b\u0000\u0010\u0005\u0018\u0001*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0082\b\u001a\u001e\u0010\u000e\u001a\u0004\u0018\u00010\r*\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002\u001a\u0016\u0010\u000f\u001a\u0004\u0018\u00010\r*\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002\u001a\f\u0010\u0012\u001a\u00020\u0011*\u00020\u0010H\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0011*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0002H\u0002\u00a8\u0006\u0015"}, d2 = {"", "Lkotlin/text/g;", "", "k", "", "T", "value", "", "g", "Ljava/util/regex/Matcher;", "from", "", "input", "Lkotlin/text/k;", "f", "h", "Ljava/util/regex/MatchResult;", "Lkotlin/ranges/k;", "i", "groupIndex", "j", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class RegexKt {
    public static final /* synthetic */ k a(Matcher matcher, int i4, CharSequence charSequence) {
        return f(matcher, i4, charSequence);
    }

    public static final /* synthetic */ k b(Matcher matcher, CharSequence charSequence) {
        return h(matcher, charSequence);
    }

    public static final /* synthetic */ int e(Iterable iterable) {
        return k(iterable);
    }

    public static final k f(Matcher matcher, int i4, CharSequence charSequence) {
        if (matcher.find(i4)) {
            return new l(matcher, charSequence);
        }
        return null;
    }

    private static final /* synthetic */ <T extends Enum<T> & g> Set<T> g(final int i4) {
        f0.y(4, "T");
        EnumSet allOf = EnumSet.allOf(Enum.class);
        f0.o(allOf, "");
        f0.w();
        kotlin.collections.c0.N0(allOf, new d2.l<T, Boolean>() { // from class: kotlin.text.RegexKt$fromInt$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Boolean; */
            @Override // d2.l
            @NotNull
            public final Boolean invoke(Enum r3) {
                g gVar = (g) r3;
                return Boolean.valueOf((i4 & gVar.getMask()) == gVar.getValue());
            }
        });
        Set<T> unmodifiableSet = Collections.unmodifiableSet(allOf);
        f0.o(unmodifiableSet, "unmodifiableSet(EnumSet.\u2026mask == it.value }\n    })");
        return unmodifiableSet;
    }

    public static final k h(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new l(matcher, charSequence);
        }
        return null;
    }

    public static final kotlin.ranges.k i(MatchResult matchResult) {
        kotlin.ranges.k n12;
        n12 = kotlin.ranges.q.n1(matchResult.start(), matchResult.end());
        return n12;
    }

    public static final kotlin.ranges.k j(MatchResult matchResult, int i4) {
        kotlin.ranges.k n12;
        n12 = kotlin.ranges.q.n1(matchResult.start(i4), matchResult.end(i4));
        return n12;
    }

    public static final int k(Iterable<? extends g> iterable) {
        int i4 = 0;
        for (g gVar : iterable) {
            i4 |= gVar.getValue();
        }
        return i4;
    }
}
