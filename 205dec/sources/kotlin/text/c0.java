package kotlin.text;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Typography.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\bY\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bZ\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0087T\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0004\u0012\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\u00020\u00028\u0006X\u0087T\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0004\u0012\u0004\b\u001f\u0010\u001cR\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0004R\u0014\u0010$\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b#\u0010\u0004R\u0014\u0010&\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u0004R\u0014\u0010(\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b'\u0010\u0004R\u0014\u0010*\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b)\u0010\u0004R\u0014\u0010,\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b+\u0010\u0004R\u0014\u0010.\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b-\u0010\u0004R\u0014\u00100\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b/\u0010\u0004R\u0014\u00102\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b1\u0010\u0004R\u0014\u00104\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b3\u0010\u0004R\u0014\u00106\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b5\u0010\u0004R\u0014\u00108\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b7\u0010\u0004R\u0014\u0010:\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b9\u0010\u0004R\u0014\u0010<\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b;\u0010\u0004R\u0014\u0010=\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0004R\u0014\u0010?\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b>\u0010\u0004R\u0014\u0010A\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b@\u0010\u0004R\u0014\u0010C\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bB\u0010\u0004R\u0014\u0010E\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bD\u0010\u0004R\u0014\u0010G\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bF\u0010\u0004R\u0014\u0010I\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bH\u0010\u0004R\u0014\u0010K\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bJ\u0010\u0004R\u0014\u0010M\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bL\u0010\u0004R\u0014\u0010O\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bN\u0010\u0004R\u0014\u0010Q\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bP\u0010\u0004R\u0014\u0010S\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\bR\u0010\u0004R\u001a\u0010V\u001a\u00020\u00028\u0006X\u0087T\u00a2\u0006\f\n\u0004\bT\u0010\u0004\u0012\u0004\bU\u0010\u001cR\u001a\u0010Y\u001a\u00020\u00028\u0006X\u0087T\u00a2\u0006\f\n\u0004\bW\u0010\u0004\u0012\u0004\bX\u0010\u001c\u00a8\u0006["}, d2 = {"Lkotlin/text/c0;", "", "", "b", "C", "quote", "c", "dollar", "d", "amp", "e", "less", "f", "greater", "g", "nbsp", "h", "times", "i", "cent", "j", "pound", "k", "section", "l", "copyright", "m", "getLeftGuillemet$annotations", "()V", "leftGuillemet", "n", "getRightGuillemet$annotations", "rightGuillemet", "o", "registered", "p", "degree", CampaignEx.JSON_KEY_AD_Q, "plusMinus", "r", "paragraph", "s", "middleDot", "t", "half", "u", "ndash", "v", "mdash", "w", "leftSingleQuote", "x", "rightSingleQuote", "y", "lowSingleQuote", "z", "leftDoubleQuote", "A", "rightDoubleQuote", "B", "lowDoubleQuote", "dagger", "D", "doubleDagger", "E", "bullet", "F", "ellipsis", "G", "prime", "H", "doublePrime", "I", "euro", "J", "tm", "K", "almostEqual", "L", "notEqual", "M", "lessOrEqual", "N", "greaterOrEqual", "O", "getLeftGuillemete$annotations", "leftGuillemete", "P", "getRightGuillemete$annotations", "rightGuillemete", "<init>", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c0 {
    public static final char A = '\u201d';
    public static final char B = '\u201e';
    public static final char C = '\u2020';
    public static final char D = '\u2021';
    public static final char E = '\u2022';
    public static final char F = '\u2026';
    public static final char G = '\u2032';
    public static final char H = '\u2033';
    public static final char I = '\u20ac';
    public static final char J = '\u2122';
    public static final char K = '\u2248';

    /* renamed from: L  reason: collision with root package name */
    public static final char f58902L = '\u2260';
    public static final char M = '\u2264';
    public static final char N = '\u2265';
    public static final char O = '\u00ab';
    public static final char P = '\u00bb';
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f58903a = new c0();

    /* renamed from: b  reason: collision with root package name */
    public static final char f58904b = '\"';

    /* renamed from: c  reason: collision with root package name */
    public static final char f58905c = '$';

    /* renamed from: d  reason: collision with root package name */
    public static final char f58906d = '&';

    /* renamed from: e  reason: collision with root package name */
    public static final char f58907e = '<';

    /* renamed from: f  reason: collision with root package name */
    public static final char f58908f = '>';

    /* renamed from: g  reason: collision with root package name */
    public static final char f58909g = '\u00a0';

    /* renamed from: h  reason: collision with root package name */
    public static final char f58910h = '\u00d7';

    /* renamed from: i  reason: collision with root package name */
    public static final char f58911i = '\u00a2';

    /* renamed from: j  reason: collision with root package name */
    public static final char f58912j = '\u00a3';

    /* renamed from: k  reason: collision with root package name */
    public static final char f58913k = '\u00a7';

    /* renamed from: l  reason: collision with root package name */
    public static final char f58914l = '\u00a9';

    /* renamed from: m  reason: collision with root package name */
    public static final char f58915m = '\u00ab';

    /* renamed from: n  reason: collision with root package name */
    public static final char f58916n = '\u00bb';

    /* renamed from: o  reason: collision with root package name */
    public static final char f58917o = '\u00ae';

    /* renamed from: p  reason: collision with root package name */
    public static final char f58918p = '\u00b0';

    /* renamed from: q  reason: collision with root package name */
    public static final char f58919q = '\u00b1';

    /* renamed from: r  reason: collision with root package name */
    public static final char f58920r = '\u00b6';

    /* renamed from: s  reason: collision with root package name */
    public static final char f58921s = '\u00b7';

    /* renamed from: t  reason: collision with root package name */
    public static final char f58922t = '\u00bd';

    /* renamed from: u  reason: collision with root package name */
    public static final char f58923u = '\u2013';

    /* renamed from: v  reason: collision with root package name */
    public static final char f58924v = '\u2014';

    /* renamed from: w  reason: collision with root package name */
    public static final char f58925w = '\u2018';

    /* renamed from: x  reason: collision with root package name */
    public static final char f58926x = '\u2019';

    /* renamed from: y  reason: collision with root package name */
    public static final char f58927y = '\u201a';

    /* renamed from: z  reason: collision with root package name */
    public static final char f58928z = '\u201c';

    private c0() {
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void a() {
    }

    @Deprecated(message = "This constant has a typo in the name. Use leftGuillemet instead.", replaceWith = @ReplaceWith(expression = "Typography.leftGuillemet", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.6")
    public static /* synthetic */ void b() {
    }

    @SinceKotlin(version = "1.6")
    public static /* synthetic */ void c() {
    }

    @Deprecated(message = "This constant has a typo in the name. Use rightGuillemet instead.", replaceWith = @ReplaceWith(expression = "Typography.rightGuillemet", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.6")
    public static /* synthetic */ void d() {
    }
}
