package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0010\f\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¨\u0006\u0003"}, m12616d2 = {"", "", "a", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.text.e0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class _OneToManyTitlecaseMappings {
    @NotNull
    /* renamed from: a */
    public static final String m6829a(char c) {
        String valueOf = String.valueOf(c);
        if (valueOf != null) {
            Locale locale = Locale.ROOT;
            String upperCase = valueOf.toUpperCase(locale);
            C14342f0.m8185o(upperCase, "(this as java.lang.Strin….toUpperCase(Locale.ROOT)");
            if (upperCase.length() > 1) {
                if (c == 329) {
                    return upperCase;
                }
                char charAt = upperCase.charAt(0);
                String substring = upperCase.substring(1);
                C14342f0.m8185o(substring, "(this as java.lang.String).substring(startIndex)");
                if (substring != null) {
                    String lowerCase = substring.toLowerCase(locale);
                    C14342f0.m8185o(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                    return String.valueOf(charAt) + lowerCase;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            return String.valueOf(Character.toTitleCase(c));
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
