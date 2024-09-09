package s2;

import java.util.Iterator;
import java.util.Locale;
import kotlin.jvm.internal.f0;
import kotlin.ranges.k;
import kotlin.text.x;
import org.jetbrains.annotations.NotNull;

/* compiled from: capitalizeDecapitalize.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull String str) {
        f0.p(str, "<this>");
        boolean z3 = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('a' <= charAt && charAt < '{') {
            z3 = true;
        }
        if (z3) {
            char upperCase = Character.toUpperCase(charAt);
            String substring = str.substring(1);
            f0.o(substring, "this as java.lang.String).substring(startIndex)");
            return upperCase + substring;
        }
        return str;
    }

    @NotNull
    public static final String b(@NotNull String str) {
        f0.p(str, "<this>");
        boolean z3 = false;
        if (str.length() == 0) {
            return str;
        }
        char charAt = str.charAt(0);
        if ('A' <= charAt && charAt < '[') {
            z3 = true;
        }
        if (z3) {
            char lowerCase = Character.toLowerCase(charAt);
            String substring = str.substring(1);
            f0.o(substring, "this as java.lang.String).substring(startIndex)");
            return lowerCase + substring;
        }
        return str;
    }

    @NotNull
    public static final String c(@NotNull String str, boolean z3) {
        k h32;
        Integer num;
        f0.p(str, "<this>");
        if ((str.length() == 0) || !d(str, 0, z3)) {
            return str;
        }
        if (str.length() == 1 || !d(str, 1, z3)) {
            if (z3) {
                return b(str);
            }
            if (str.length() > 0) {
                char lowerCase = Character.toLowerCase(str.charAt(0));
                String substring = str.substring(1);
                f0.o(substring, "this as java.lang.String).substring(startIndex)");
                return lowerCase + substring;
            }
            return str;
        }
        h32 = x.h3(str);
        Iterator<Integer> it = h32.iterator();
        while (true) {
            if (!it.hasNext()) {
                num = null;
                break;
            }
            num = it.next();
            if (!d(str, num.intValue(), z3)) {
                break;
            }
        }
        Integer num2 = num;
        if (num2 == null) {
            return e(str, z3);
        }
        int intValue = num2.intValue() - 1;
        String substring2 = str.substring(0, intValue);
        f0.o(substring2, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        String e4 = e(substring2, z3);
        String substring3 = str.substring(intValue);
        f0.o(substring3, "this as java.lang.String).substring(startIndex)");
        return f0.C(e4, substring3);
    }

    private static final boolean d(String str, int i4, boolean z3) {
        char charAt = str.charAt(i4);
        if (z3) {
            return 'A' <= charAt && charAt < '[';
        }
        return Character.isUpperCase(charAt);
    }

    private static final String e(String str, boolean z3) {
        if (z3) {
            return f(str);
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @NotNull
    public static final String f(@NotNull String str) {
        f0.p(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            i4++;
            if ('A' <= charAt && charAt < '[') {
                charAt = Character.toLowerCase(charAt);
            }
            sb.append(charAt);
        }
        String sb2 = sb.toString();
        f0.o(sb2, "builder.toString()");
        return sb2;
    }
}
