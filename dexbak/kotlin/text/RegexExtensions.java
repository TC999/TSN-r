package kotlin.text;

import com.umeng.analytics.pro.UMCommonContent;
import java.util.Set;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0003\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0087\b\u001a\u001b\u0010\b\u001a\u00020\u0001*\u00020\u00002\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006H\u0087\b¨\u0006\t"}, m12616d2 = {"", "Lkotlin/text/Regex;", UMCommonContent.f37782aL, "Lkotlin/text/RegexOption;", "option", "v", "", "options", "u", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/StringsKt")
/* renamed from: kotlin.text.r */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class RegexExtensions extends RegexExtensionsJVM {
    @InlineOnly
    /* renamed from: t */
    private static final Regex m6712t(String str) {
        return new Regex(str);
    }

    @InlineOnly
    /* renamed from: u */
    private static final Regex m6711u(String str, Set<? extends RegexOption> set) {
        return new Regex(str, set);
    }

    @InlineOnly
    /* renamed from: v */
    private static final Regex m6710v(String str, RegexOption regexOption) {
        return new Regex(str, regexOption);
    }
}
