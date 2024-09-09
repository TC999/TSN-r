package kotlin.text;

import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: RegexExtensions.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b\u001a\u001b\u0010\b\u001a\u00020\u0001*\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0087\b\u00a8\u0006\t"}, d2 = {"", "Lkotlin/text/Regex;", "t", "Lkotlin/text/RegexOption;", "option", "v", "", "options", "u", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class r extends q {
    @InlineOnly
    private static final Regex t(String str) {
        f0.p(str, "<this>");
        return new Regex(str);
    }

    @InlineOnly
    private static final Regex u(String str, Set<? extends RegexOption> options) {
        f0.p(str, "<this>");
        f0.p(options, "options");
        return new Regex(str, options);
    }

    @InlineOnly
    private static final Regex v(String str, RegexOption option) {
        f0.p(str, "<this>");
        f0.p(option, "option");
        return new Regex(str, option);
    }
}
