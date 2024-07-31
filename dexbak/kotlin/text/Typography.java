package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\f\n\u0002\bQ\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\bQ\u0010RR\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0004R\u0014\u0010#\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0014\u0010%\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u0004R\u0014\u0010'\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u0004R\u0014\u0010)\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b(\u0010\u0004R\u0014\u0010+\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b*\u0010\u0004R\u0014\u0010-\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010\u0004R\u0014\u0010/\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b.\u0010\u0004R\u0014\u00101\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b0\u0010\u0004R\u0014\u00103\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b2\u0010\u0004R\u0014\u00105\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b4\u0010\u0004R\u0014\u00107\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b6\u0010\u0004R\u0014\u00109\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b8\u0010\u0004R\u0014\u0010;\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b:\u0010\u0004R\u0014\u0010<\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0004R\u0014\u0010>\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b=\u0010\u0004R\u0014\u0010@\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b?\u0010\u0004R\u0014\u0010B\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bA\u0010\u0004R\u0014\u0010D\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bC\u0010\u0004R\u0014\u0010F\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bE\u0010\u0004R\u0014\u0010H\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bG\u0010\u0004R\u0014\u0010J\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bI\u0010\u0004R\u0014\u0010L\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bK\u0010\u0004R\u0014\u0010N\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bM\u0010\u0004R\u0014\u0010P\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\bO\u0010\u0004¨\u0006S"}, m12616d2 = {"Lkotlin/text/c0;", "", "", "a", "C", "quote", "b", "dollar", "c", "amp", "d", "less", "e", "greater", "f", "nbsp", "g", "times", "h", "cent", "i", "pound", "j", "section", "k", "copyright", C7304t.f25048d, "leftGuillemete", "m", "rightGuillemete", "n", "registered", "o", "degree", "p", "plusMinus", CampaignEx.JSON_KEY_AD_Q, "paragraph", "r", "middleDot", "s", "half", UMCommonContent.f37782aL, "ndash", "u", "mdash", "v", "leftSingleQuote", IAdInterListener.AdReqParam.WIDTH, "rightSingleQuote", "x", "lowSingleQuote", "y", "leftDoubleQuote", UMCommonContent.f37777aG, "rightDoubleQuote", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "lowDoubleQuote", "B", "dagger", "doubleDagger", "D", "bullet", ExifInterface.LONGITUDE_EAST, "ellipsis", "F", "prime", "G", "doublePrime", "H", "euro", "I", "tm", "J", "almostEqual", "K", "notEqual", "L", "lessOrEqual", "M", "greaterOrEqual", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.text.c0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Typography {

    /* renamed from: A */
    public static final char f41551A = 8222;

    /* renamed from: B */
    public static final char f41552B = 8224;

    /* renamed from: C */
    public static final char f41553C = 8225;

    /* renamed from: D */
    public static final char f41554D = 8226;

    /* renamed from: E */
    public static final char f41555E = 8230;

    /* renamed from: F */
    public static final char f41556F = 8242;

    /* renamed from: G */
    public static final char f41557G = 8243;

    /* renamed from: H */
    public static final char f41558H = 8364;

    /* renamed from: I */
    public static final char f41559I = 8482;

    /* renamed from: J */
    public static final char f41560J = 8776;

    /* renamed from: K */
    public static final char f41561K = 8800;

    /* renamed from: L */
    public static final char f41562L = 8804;

    /* renamed from: M */
    public static final char f41563M = 8805;
    @NotNull

    /* renamed from: N */
    public static final Typography f41564N = new Typography();

    /* renamed from: a */
    public static final char f41565a = '\"';

    /* renamed from: b */
    public static final char f41566b = '$';

    /* renamed from: c */
    public static final char f41567c = '&';

    /* renamed from: d */
    public static final char f41568d = '<';

    /* renamed from: e */
    public static final char f41569e = '>';

    /* renamed from: f */
    public static final char f41570f = 160;

    /* renamed from: g */
    public static final char f41571g = 215;

    /* renamed from: h */
    public static final char f41572h = 162;

    /* renamed from: i */
    public static final char f41573i = 163;

    /* renamed from: j */
    public static final char f41574j = 167;

    /* renamed from: k */
    public static final char f41575k = 169;

    /* renamed from: l */
    public static final char f41576l = 171;

    /* renamed from: m */
    public static final char f41577m = 187;

    /* renamed from: n */
    public static final char f41578n = 174;

    /* renamed from: o */
    public static final char f41579o = 176;

    /* renamed from: p */
    public static final char f41580p = 177;

    /* renamed from: q */
    public static final char f41581q = 182;

    /* renamed from: r */
    public static final char f41582r = 183;

    /* renamed from: s */
    public static final char f41583s = 189;

    /* renamed from: t */
    public static final char f41584t = 8211;

    /* renamed from: u */
    public static final char f41585u = 8212;

    /* renamed from: v */
    public static final char f41586v = 8216;

    /* renamed from: w */
    public static final char f41587w = 8217;

    /* renamed from: x */
    public static final char f41588x = 8218;

    /* renamed from: y */
    public static final char f41589y = 8220;

    /* renamed from: z */
    public static final char f41590z = 8221;

    private Typography() {
    }
}
