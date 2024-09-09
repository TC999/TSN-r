package kotlin.text;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: _OneToManyTitlecaseMappings.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0010\f\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000\u00a8\u0006\u0003"}, d2 = {"", "", "a", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e0 {
    @NotNull
    public static final String a(char c4) {
        String valueOf = String.valueOf(c4);
        Locale locale = Locale.ROOT;
        String upperCase = valueOf.toUpperCase(locale);
        f0.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        if (upperCase.length() > 1) {
            if (c4 == '\u0149') {
                return upperCase;
            }
            char charAt = upperCase.charAt(0);
            String substring = upperCase.substring(1);
            f0.o(substring, "this as java.lang.String).substring(startIndex)");
            String lowerCase = substring.toLowerCase(locale);
            f0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return charAt + lowerCase;
        }
        return String.valueOf(Character.toTitleCase(c4));
    }
}
