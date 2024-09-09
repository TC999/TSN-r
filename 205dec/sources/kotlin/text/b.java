package kotlin.text;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CharJVM.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0000\u001a\r\u0010\u000b\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\f\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\r\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u000e\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0087\b\u001a\u0014\u0010\u0013\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0007\u001a\r\u0010\u0014\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0000H\u0087\b\u001a\u0014\u0010\u0017\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0007\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u001a\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\u0014\u0010\u001b\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0007\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u001d\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH\u0000\u001a\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0001\"\u0015\u0010&\u001a\u00020#*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\"\u0015\u0010*\u001a\u00020'*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u0006+"}, d2 = {"", "", "e", "l", "m", "f", "i", "h", "j", "k", "r", CampaignEx.JSON_KEY_AD_Q, "o", "z", "C", "", "A", "Ljava/util/Locale;", "locale", "B", "x", "u", "s", "t", "p", "y", "w", "v", "g", "n", "char", "", "radix", "b", "a", "Lkotlin/text/CharCategory;", "c", "(C)Lkotlin/text/CharCategory;", "category", "Lkotlin/text/CharDirectionality;", "d", "(C)Lkotlin/text/CharDirectionality;", "directionality", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/text/CharsKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String A(char c4) {
        String upperCase = String.valueOf(c4).toUpperCase(Locale.ROOT);
        f0.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String B(char c4, @NotNull Locale locale) {
        f0.p(locale, "locale");
        String upperCase = String.valueOf(c4).toUpperCase(locale);
        f0.o(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char C(char c4) {
        return Character.toUpperCase(c4);
    }

    @PublishedApi
    public static int a(int i4) {
        boolean z3 = false;
        if (2 <= i4 && i4 < 37) {
            z3 = true;
        }
        if (z3) {
            return i4;
        }
        throw new IllegalArgumentException("radix " + i4 + " was not in valid range " + new kotlin.ranges.k(2, 36));
    }

    public static final int b(char c4, int i4) {
        return Character.digit((int) c4, i4);
    }

    @NotNull
    public static final CharCategory c(char c4) {
        return CharCategory.Companion.a(Character.getType(c4));
    }

    @NotNull
    public static final CharDirectionality d(char c4) {
        return CharDirectionality.Companion.b(Character.getDirectionality(c4));
    }

    @InlineOnly
    private static final boolean e(char c4) {
        return Character.isDefined(c4);
    }

    @InlineOnly
    private static final boolean f(char c4) {
        return Character.isDigit(c4);
    }

    @InlineOnly
    private static final boolean g(char c4) {
        return Character.isHighSurrogate(c4);
    }

    @InlineOnly
    private static final boolean h(char c4) {
        return Character.isISOControl(c4);
    }

    @InlineOnly
    private static final boolean i(char c4) {
        return Character.isIdentifierIgnorable(c4);
    }

    @InlineOnly
    private static final boolean j(char c4) {
        return Character.isJavaIdentifierPart(c4);
    }

    @InlineOnly
    private static final boolean k(char c4) {
        return Character.isJavaIdentifierStart(c4);
    }

    @InlineOnly
    private static final boolean l(char c4) {
        return Character.isLetter(c4);
    }

    @InlineOnly
    private static final boolean m(char c4) {
        return Character.isLetterOrDigit(c4);
    }

    @InlineOnly
    private static final boolean n(char c4) {
        return Character.isLowSurrogate(c4);
    }

    @InlineOnly
    private static final boolean o(char c4) {
        return Character.isLowerCase(c4);
    }

    @InlineOnly
    private static final boolean p(char c4) {
        return Character.isTitleCase(c4);
    }

    @InlineOnly
    private static final boolean q(char c4) {
        return Character.isUpperCase(c4);
    }

    public static boolean r(char c4) {
        return Character.isWhitespace(c4) || Character.isSpaceChar(c4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final String s(char c4) {
        String lowerCase = String.valueOf(c4).toLowerCase(Locale.ROOT);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String t(char c4, @NotNull Locale locale) {
        f0.p(locale, "locale");
        String lowerCase = String.valueOf(c4).toLowerCase(locale);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char u(char c4) {
        return Character.toLowerCase(c4);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    public static final String v(char c4, @NotNull Locale locale) {
        f0.p(locale, "locale");
        String B = B(c4, locale);
        if (B.length() <= 1) {
            String upperCase = String.valueOf(c4).toUpperCase(Locale.ROOT);
            f0.o(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return !f0.g(B, upperCase) ? B : String.valueOf(Character.toTitleCase(c4));
        } else if (c4 == '\u0149') {
            return B;
        } else {
            char charAt = B.charAt(0);
            String substring = B.substring(1);
            f0.o(substring, "this as java.lang.String).substring(startIndex)");
            String lowerCase = substring.toLowerCase(Locale.ROOT);
            f0.o(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return charAt + lowerCase;
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    private static final char w(char c4) {
        return Character.toTitleCase(c4);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final char x(char c4) {
        return Character.toLowerCase(c4);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final char y(char c4) {
        return Character.toTitleCase(c4);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    private static final char z(char c4) {
        return Character.toUpperCase(c4);
    }
}
