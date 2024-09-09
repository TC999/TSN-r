package kotlin.text;

import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: RegexExtensionsJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u00a8\u0006\u0003"}, d2 = {"Ljava/util/regex/Pattern;", "Lkotlin/text/Regex;", "s", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/StringsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class q extends p {
    @InlineOnly
    private static final Regex s(Pattern pattern) {
        f0.p(pattern, "<this>");
        return new Regex(pattern);
    }
}
