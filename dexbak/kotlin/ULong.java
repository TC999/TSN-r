package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.C14428w;
import okhttp3.internal.p629ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.5")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001:B\u0014\b\u0001\u0012\u0006\u0010\\\u001a\u00020Fø\u0001\u0000¢\u0006\u0004\b]\u00102J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0010J\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0012J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0014J\u001b\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0016J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0010J\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0012J\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0014J\u001b\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0016J\u001b\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0010J\u001b\u0010 \u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0012J\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\u0014J\u001b\u0010\"\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\"\u0010\u0016J\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b#\u0010\u0010J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b$\u0010\u0012J\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b%\u0010\u0014J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u0016J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0010J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0012J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\bø\u0001\u0000¢\u0006\u0004\b)\u0010\u0014J\u001b\u0010*\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010\u0016J\u001b\u0010+\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\bø\u0001\u0000¢\u0006\u0004\b/\u0010\fJ\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b0\u0010\u0016J\u0016\u00101\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102J\u0016\u00103\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b3\u00102J\u001b\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b5\u00106J\u001e\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0004H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b8\u0010\u0014J\u001e\u00109\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0004H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b9\u0010\u0014J\u001b\u0010:\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b:\u0010\u0016J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b;\u0010\u0016J\u001b\u0010<\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b<\u0010\u0016J\u0016\u0010=\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b=\u00102J\u0010\u0010?\u001a\u00020>H\u0087\b¢\u0006\u0004\b?\u0010@J\u0010\u0010B\u001a\u00020AH\u0087\b¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\bD\u0010EJ\u0010\u0010G\u001a\u00020FH\u0087\b¢\u0006\u0004\bG\u00102J\u0016\u0010H\u001a\u00020\u0002H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bH\u0010@J\u0016\u0010I\u001a\u00020\u0007H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bI\u0010CJ\u0016\u0010J\u001a\u00020\nH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bJ\u0010EJ\u0016\u0010K\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bK\u00102J\u0010\u0010M\u001a\u00020LH\u0087\b¢\u0006\u0004\bM\u0010NJ\u0010\u0010P\u001a\u00020OH\u0087\b¢\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u00020RH\u0016¢\u0006\u0004\bS\u0010TJ\u0010\u0010U\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bU\u0010EJ\u001a\u0010X\u001a\u00020W2\b\u0010\u0003\u001a\u0004\u0018\u00010VHÖ\u0003¢\u0006\u0004\bX\u0010YR\u001a\u0010\\\u001a\u00020F8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b:\u0010\u0011\u0012\u0004\bZ\u0010[\u0088\u0001\\\u0092\u0001\u00020Fø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006^"}, m12616d2 = {"Lkotlin/v0;", "", "Lkotlin/n0;", AdnName.OTHER, "", "c", "(JB)I", "Lkotlin/b1;", "g", "(JS)I", "Lkotlin/r0;", "f", "(JI)I", "e", "(JJ)I", "G", "(JB)J", "J", "(JS)J", "I", "(JI)J", "H", "(JJ)J", "x", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UMCommonContent.f37777aG, "y", "R", "U", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "j", "m", C7304t.f25048d, "k", "L", "O", "N", "M", "p", "s", "r", CampaignEx.JSON_KEY_AD_Q, "B", "(JB)B", ExifInterface.LONGITUDE_EAST, "(JS)S", "D", "C", "v", "(J)J", "i", "Lkotlin/ranges/w;", "K", "(JJ)Lkotlin/ranges/w;", "bitCount", "P", "Q", "a", "F", "h0", IAdInterListener.AdReqParam.WIDTH, "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(J)B", "", "a0", "(J)S", "Y", "(J)I", "", "Z", "c0", "f0", "d0", "e0", "", "X", "(J)F", "", ExifInterface.LONGITUDE_WEST, "(J)D", "", "b0", "(J)Ljava/lang/String;", "u", "", "", "n", "(JLjava/lang/Object;)Z", "getData$annotations", "()V", "data", "h", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@JvmInline
@WasExperimental(markerClass = {Unsigned.class})
/* renamed from: kotlin.v0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ULong implements Comparable<ULong> {

    /* renamed from: b */
    public static final long f41674b = 0;

    /* renamed from: c */
    public static final long f41675c = -1;

    /* renamed from: d */
    public static final int f41676d = 8;

    /* renamed from: e */
    public static final int f41677e = 64;
    @NotNull

    /* renamed from: f */
    public static final C14608a f41678f = new C14608a(null);

    /* renamed from: a */
    private final long f41679a;

    /* compiled from: ULong.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\f"}, m12616d2 = {"Lkotlin/v0$a;", "", "Lkotlin/v0;", "MAX_VALUE", "J", "MIN_VALUE", "", "SIZE_BITS", "I", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.v0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14608a {
        private C14608a() {
        }

        public /* synthetic */ C14608a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ ULong(long j) {
        this.f41679a = j;
    }

    @InlineOnly
    /* renamed from: A */
    private static final long m5929A(long j, short s) {
        return m5889h(j - m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: B */
    private static final byte m5928B(long j, byte b) {
        return UByte.m7776h((byte) UnsignedUtils.m8555i(j, m5889h(b & 255)));
    }

    @InlineOnly
    /* renamed from: C */
    private static final long m5927C(long j, long j2) {
        return UnsignedUtils.m8555i(j, j2);
    }

    @InlineOnly
    /* renamed from: D */
    private static final int m5926D(long j, int i) {
        return UInt.m7678h((int) UnsignedUtils.m8555i(j, m5889h(i & 4294967295L)));
    }

    @InlineOnly
    /* renamed from: E */
    private static final short m5925E(long j, short s) {
        return UShort.m12528h((short) UnsignedUtils.m8555i(j, m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX)));
    }

    @InlineOnly
    /* renamed from: F */
    private static final long m5924F(long j, long j2) {
        return m5889h(j | j2);
    }

    @InlineOnly
    /* renamed from: G */
    private static final long m5923G(long j, byte b) {
        return m5889h(j + m5889h(b & 255));
    }

    @InlineOnly
    /* renamed from: H */
    private static final long m5922H(long j, long j2) {
        return m5889h(j + j2);
    }

    @InlineOnly
    /* renamed from: I */
    private static final long m5921I(long j, int i) {
        return m5889h(j + m5889h(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: J */
    private static final long m5920J(long j, short s) {
        return m5889h(j + m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: K */
    private static final C14428w m5919K(long j, long j2) {
        return new C14428w(j, j2, null);
    }

    @InlineOnly
    /* renamed from: L */
    private static final long m5918L(long j, byte b) {
        return UnsignedUtils.m8555i(j, m5889h(b & 255));
    }

    @InlineOnly
    /* renamed from: M */
    private static final long m5917M(long j, long j2) {
        return UnsignedUtils.m8555i(j, j2);
    }

    @InlineOnly
    /* renamed from: N */
    private static final long m5916N(long j, int i) {
        return UnsignedUtils.m8555i(j, m5889h(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: O */
    private static final long m5915O(long j, short s) {
        return UnsignedUtils.m8555i(j, m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: P */
    private static final long m5914P(long j, int i) {
        return m5889h(j << i);
    }

    @InlineOnly
    /* renamed from: Q */
    private static final long m5913Q(long j, int i) {
        return m5889h(j >>> i);
    }

    @InlineOnly
    /* renamed from: R */
    private static final long m5912R(long j, byte b) {
        return m5889h(j * m5889h(b & 255));
    }

    @InlineOnly
    /* renamed from: S */
    private static final long m5911S(long j, long j2) {
        return m5889h(j * j2);
    }

    @InlineOnly
    /* renamed from: T */
    private static final long m5910T(long j, int i) {
        return m5889h(j * m5889h(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: U */
    private static final long m5909U(long j, short s) {
        return m5889h(j * m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @InlineOnly
    /* renamed from: V */
    private static final byte m5908V(long j) {
        return (byte) j;
    }

    @InlineOnly
    /* renamed from: W */
    private static final double m5907W(long j) {
        return UnsignedUtils.m8554j(j);
    }

    @InlineOnly
    /* renamed from: X */
    private static final float m5906X(long j) {
        return (float) UnsignedUtils.m8554j(j);
    }

    @InlineOnly
    /* renamed from: Y */
    private static final int m5905Y(long j) {
        return (int) j;
    }

    @InlineOnly
    /* renamed from: Z */
    private static final long m5904Z(long j) {
        return j;
    }

    @InlineOnly
    /* renamed from: a */
    private static final long m5903a(long j, long j2) {
        return m5889h(j & j2);
    }

    @InlineOnly
    /* renamed from: a0 */
    private static final short m5902a0(long j) {
        return (short) j;
    }

    /* renamed from: b */
    public static final /* synthetic */ ULong m5901b(long j) {
        return new ULong(j);
    }

    @NotNull
    /* renamed from: b0 */
    public static String m5900b0(long j) {
        return UnsignedUtils.m8553k(j);
    }

    @InlineOnly
    /* renamed from: c */
    private static final int m5899c(long j, byte b) {
        return UnsignedUtils.m8557g(j, m5889h(b & 255));
    }

    @InlineOnly
    /* renamed from: c0 */
    private static final byte m5898c0(long j) {
        return UByte.m7776h((byte) j);
    }

    @InlineOnly
    /* renamed from: d */
    private int m5897d(long j) {
        return m5895e(this.f41679a, j);
    }

    @InlineOnly
    /* renamed from: d0 */
    private static final int m5896d0(long j) {
        return UInt.m7678h((int) j);
    }

    @InlineOnly
    /* renamed from: e */
    private static int m5895e(long j, long j2) {
        return UnsignedUtils.m8557g(j, j2);
    }

    @InlineOnly
    /* renamed from: e0 */
    private static final long m5894e0(long j) {
        return j;
    }

    @InlineOnly
    /* renamed from: f */
    private static final int m5893f(long j, int i) {
        return UnsignedUtils.m8557g(j, m5889h(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: f0 */
    private static final short m5892f0(long j) {
        return UShort.m12528h((short) j);
    }

    @InlineOnly
    /* renamed from: g */
    private static final int m5891g(long j, short s) {
        return UnsignedUtils.m8557g(j, m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @PublishedApi
    /* renamed from: h */
    public static long m5889h(long j) {
        return j;
    }

    @InlineOnly
    /* renamed from: h0 */
    private static final long m5888h0(long j, long j2) {
        return m5889h(j ^ j2);
    }

    @InlineOnly
    /* renamed from: i */
    private static final long m5887i(long j) {
        return m5889h(j - 1);
    }

    @InlineOnly
    /* renamed from: j */
    private static final long m5886j(long j, byte b) {
        return UnsignedUtils.m8556h(j, m5889h(b & 255));
    }

    @InlineOnly
    /* renamed from: k */
    private static final long m5885k(long j, long j2) {
        return UnsignedUtils.m8556h(j, j2);
    }

    @InlineOnly
    /* renamed from: l */
    private static final long m5884l(long j, int i) {
        return UnsignedUtils.m8556h(j, m5889h(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: m */
    private static final long m5883m(long j, short s) {
        return UnsignedUtils.m8556h(j, m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    /* renamed from: n */
    public static boolean m5882n(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).m5890g0();
    }

    /* renamed from: o */
    public static final boolean m5881o(long j, long j2) {
        return j == j2;
    }

    @InlineOnly
    /* renamed from: p */
    private static final long m5880p(long j, byte b) {
        return UnsignedUtils.m8556h(j, m5889h(b & 255));
    }

    @InlineOnly
    /* renamed from: q */
    private static final long m5879q(long j, long j2) {
        return UnsignedUtils.m8556h(j, j2);
    }

    @InlineOnly
    /* renamed from: r */
    private static final long m5878r(long j, int i) {
        return UnsignedUtils.m8556h(j, m5889h(i & 4294967295L));
    }

    @InlineOnly
    /* renamed from: s */
    private static final long m5877s(long j, short s) {
        return UnsignedUtils.m8556h(j, m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    @PublishedApi
    /* renamed from: t */
    public static /* synthetic */ void m5876t() {
    }

    /* renamed from: u */
    public static int m5875u(long j) {
        return (int) (j ^ (j >>> 32));
    }

    @InlineOnly
    /* renamed from: v */
    private static final long m5874v(long j) {
        return m5889h(j + 1);
    }

    @InlineOnly
    /* renamed from: w */
    private static final long m5873w(long j) {
        return m5889h(j ^ (-1));
    }

    @InlineOnly
    /* renamed from: x */
    private static final long m5872x(long j, byte b) {
        return m5889h(j - m5889h(b & 255));
    }

    @InlineOnly
    /* renamed from: y */
    private static final long m5871y(long j, long j2) {
        return m5889h(j - j2);
    }

    @InlineOnly
    /* renamed from: z */
    private static final long m5870z(long j, int i) {
        return m5889h(j - m5889h(i & 4294967295L));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return m5897d(uLong.m5890g0());
    }

    public boolean equals(Object obj) {
        return m5882n(this.f41679a, obj);
    }

    /* renamed from: g0 */
    public final /* synthetic */ long m5890g0() {
        return this.f41679a;
    }

    public int hashCode() {
        return m5875u(this.f41679a);
    }

    @NotNull
    public String toString() {
        return m5900b0(this.f41679a);
    }
}
