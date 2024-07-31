package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.Locale;
import kotlin.Annotations;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges.C14413k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u00002\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\r\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\t\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0000\u001a\r\u0010\u000b\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\f\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\r\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u000e\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\u0087\b\u001a\u0014\u0010\u0013\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0007\u001a\r\u0010\u0014\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0000H\u0087\b\u001a\u0014\u0010\u0017\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0007\u001a\r\u0010\u0018\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\r\u0010\u001a\u001a\u00020\u0000*\u00020\u0000H\u0087\b\u001a\u0014\u0010\u001b\u001a\u00020\u000f*\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0007\u001a\r\u0010\u001c\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\r\u0010\u001d\u001a\u00020\u0001*\u00020\u0000H\u0087\b\u001a\u0018\u0010!\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u001fH\u0000\u001a\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0001\"\u0015\u0010&\u001a\u00020#*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b$\u0010%\"\u0015\u0010*\u001a\u00020'*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006+"}, m12616d2 = {"", "", "e", C7304t.f25048d, "m", "f", "i", "h", "j", "k", "r", CampaignEx.JSON_KEY_AD_Q, "o", UMCommonContent.f37777aG, "C", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/Locale;", "locale", "B", "x", "u", "s", UMCommonContent.f37782aL, "p", "y", IAdInterListener.AdReqParam.WIDTH, "v", "g", "n", "char", "", "radix", "b", "a", "Lkotlin/text/CharCategory;", "c", "(C)Lkotlin/text/CharCategory;", "category", "Lkotlin/text/CharDirectionality;", "d", "(C)Lkotlin/text/CharDirectionality;", "directionality", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/text/CharsKt")
/* renamed from: kotlin.text.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CharJVM {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: A */
    private static final String m6896A(char c) {
        String valueOf = String.valueOf(c);
        if (valueOf != null) {
            String upperCase = valueOf.toUpperCase(Locale.ROOT);
            C14342f0.m8185o(upperCase, "(this as java.lang.Strin….toUpperCase(Locale.ROOT)");
            return upperCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: B */
    public static final String m6895B(char c, @NotNull Locale locale) {
        C14342f0.m8184p(locale, "locale");
        String valueOf = String.valueOf(c);
        if (valueOf != null) {
            String upperCase = valueOf.toUpperCase(locale);
            C14342f0.m8185o(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            return upperCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: C */
    private static final char m6894C(char c) {
        return Character.toUpperCase(c);
    }

    @PublishedApi
    /* renamed from: a */
    public static int m6893a(int i) {
        if (2 > i || 36 < i) {
            throw new IllegalArgumentException("radix " + i + " was not in valid range " + new C14413k(2, 36));
        }
        return i;
    }

    /* renamed from: b */
    public static final int m6892b(char c, int i) {
        return Character.digit((int) c, i);
    }

    @NotNull
    /* renamed from: c */
    public static final CharCategoryJVM m6891c(char c) {
        return CharCategoryJVM.Companion.m6922a(Character.getType(c));
    }

    @NotNull
    /* renamed from: d */
    public static final CharDirectionality m6890d(char c) {
        return CharDirectionality.Companion.m6919b(Character.getDirectionality(c));
    }

    @InlineOnly
    /* renamed from: e */
    private static final boolean m6889e(char c) {
        return Character.isDefined(c);
    }

    @InlineOnly
    /* renamed from: f */
    private static final boolean m6888f(char c) {
        return Character.isDigit(c);
    }

    @InlineOnly
    /* renamed from: g */
    private static final boolean m6887g(char c) {
        return Character.isHighSurrogate(c);
    }

    @InlineOnly
    /* renamed from: h */
    private static final boolean m6886h(char c) {
        return Character.isISOControl(c);
    }

    @InlineOnly
    /* renamed from: i */
    private static final boolean m6885i(char c) {
        return Character.isIdentifierIgnorable(c);
    }

    @InlineOnly
    /* renamed from: j */
    private static final boolean m6884j(char c) {
        return Character.isJavaIdentifierPart(c);
    }

    @InlineOnly
    /* renamed from: k */
    private static final boolean m6883k(char c) {
        return Character.isJavaIdentifierStart(c);
    }

    @InlineOnly
    /* renamed from: l */
    private static final boolean m6882l(char c) {
        return Character.isLetter(c);
    }

    @InlineOnly
    /* renamed from: m */
    private static final boolean m6881m(char c) {
        return Character.isLetterOrDigit(c);
    }

    @InlineOnly
    /* renamed from: n */
    private static final boolean m6880n(char c) {
        return Character.isLowSurrogate(c);
    }

    @InlineOnly
    /* renamed from: o */
    private static final boolean m6879o(char c) {
        return Character.isLowerCase(c);
    }

    @InlineOnly
    /* renamed from: p */
    private static final boolean m6878p(char c) {
        return Character.isTitleCase(c);
    }

    @InlineOnly
    /* renamed from: q */
    private static final boolean m6877q(char c) {
        return Character.isUpperCase(c);
    }

    /* renamed from: r */
    public static final boolean m6876r(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: s */
    private static final String m6875s(char c) {
        String valueOf = String.valueOf(c);
        if (valueOf != null) {
            String lowerCase = valueOf.toLowerCase(Locale.ROOT);
            C14342f0.m8185o(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
            return lowerCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: t */
    public static final String m6874t(char c, @NotNull Locale locale) {
        C14342f0.m8184p(locale, "locale");
        String valueOf = String.valueOf(c);
        if (valueOf != null) {
            String lowerCase = valueOf.toLowerCase(locale);
            C14342f0.m8185o(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            return lowerCase;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: u */
    private static final char m6873u(char c) {
        return Character.toLowerCase(c);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @NotNull
    /* renamed from: v */
    public static final String m6872v(char c, @NotNull Locale locale) {
        C14342f0.m8184p(locale, "locale");
        String m6895B = m6895B(c, locale);
        if (m6895B.length() <= 1) {
            String valueOf = String.valueOf(c);
            if (valueOf != null) {
                String upperCase = valueOf.toUpperCase(Locale.ROOT);
                C14342f0.m8185o(upperCase, "(this as java.lang.Strin….toUpperCase(Locale.ROOT)");
                return C14342f0.m8193g(m6895B, upperCase) ^ true ? m6895B : String.valueOf(Character.toTitleCase(c));
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } else if (c == 329) {
            return m6895B;
        } else {
            char charAt = m6895B.charAt(0);
            String substring = m6895B.substring(1);
            C14342f0.m8185o(substring, "(this as java.lang.String).substring(startIndex)");
            if (substring != null) {
                String lowerCase = substring.toLowerCase(Locale.ROOT);
                C14342f0.m8185o(lowerCase, "(this as java.lang.Strin….toLowerCase(Locale.ROOT)");
                return String.valueOf(charAt) + lowerCase;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: w */
    private static final char m6871w(char c) {
        return Character.toTitleCase(c);
    }

    @Annotations(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    /* renamed from: x */
    private static final char m6870x(char c) {
        return Character.toLowerCase(c);
    }

    @Annotations(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    /* renamed from: y */
    private static final char m6869y(char c) {
        return Character.toTitleCase(c);
    }

    @Annotations(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    @InlineOnly
    /* renamed from: z */
    private static final char m6868z(char c) {
        return Character.toUpperCase(c);
    }
}
