package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.C14424t;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.5")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00014B\u0014\b\u0001\u0012\u0006\u0010V\u001a\u000208ø\u0001\u0000¢\u0006\u0004\bW\u0010/J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\bJ\u001b\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u001b\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0005J\u001b\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\bJ\u001b\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u000bJ\u001b\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013J\u001b\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\bJ\u001b\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0013J\u001b\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0005J\u001b\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\bJ\u001b\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u000bJ\u001b\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0013J\u001b\u0010 \u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0005J\u001b\u0010!\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\bJ\u001b\u0010\"\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000bJ\u001b\u0010#\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b#\u0010\u0013J\u001b\u0010$\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u0005J\u001b\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010\bJ\u001b\u0010&\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u000bJ\u001b\u0010'\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0013J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010\u000bJ\u001b\u0010-\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0013J\u0016\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010/J\u001b\u00102\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b4\u0010)J\u001b\u00105\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b5\u0010)J\u001b\u00106\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b6\u0010)J\u0016\u00107\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u0010/J\u0010\u00109\u001a\u000208H\u0087\b¢\u0006\u0004\b9\u0010/J\u0010\u0010;\u001a\u00020:H\u0087\b¢\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b=\u0010>J\u0010\u0010@\u001a\u00020?H\u0087\b¢\u0006\u0004\b@\u0010AJ\u0016\u0010B\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010/J\u0016\u0010C\u001a\u00020\u0006H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010<J\u0016\u0010D\u001a\u00020\tH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010>J\u0016\u0010E\u001a\u00020\fH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010AJ\u0010\u0010G\u001a\u00020FH\u0087\b¢\u0006\u0004\bG\u0010HJ\u0010\u0010J\u001a\u00020IH\u0087\b¢\u0006\u0004\bJ\u0010KJ\u000f\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\bO\u0010>J\u001a\u0010R\u001a\u00020Q2\b\u0010\u0002\u001a\u0004\u0018\u00010PHÖ\u0003¢\u0006\u0004\bR\u0010SR\u001a\u0010V\u001a\u0002088\u0000X\u0081\u0004¢\u0006\f\n\u0004\b4\u0010(\u0012\u0004\bT\u0010U\u0088\u0001V\u0092\u0001\u000208ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006X"}, m12616d2 = {"Lkotlin/n0;", "", AdnName.OTHER, "", "d", "(BB)I", "Lkotlin/b1;", "g", "(BS)I", "Lkotlin/r0;", "f", "(BI)I", "Lkotlin/v0;", "e", "(BJ)I", "G", "J", "I", "H", "(BJ)J", "x", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UMCommonContent.f37777aG, "y", "P", ExifInterface.LATITUDE_SOUTH, "R", "Q", "j", "m", C7304t.f25048d, "k", "L", "O", "N", "M", "p", "s", "r", CampaignEx.JSON_KEY_AD_Q, "B", "(BB)B", ExifInterface.LONGITUDE_EAST, "(BS)S", "D", "C", "v", "(B)B", "i", "Lkotlin/ranges/t;", "K", "(BB)Lkotlin/ranges/t;", "a", "F", "f0", IAdInterListener.AdReqParam.WIDTH, "", ExifInterface.GPS_DIRECTION_TRUE, "", "Y", "(B)S", ExifInterface.LONGITUDE_WEST, "(B)I", "", "X", "(B)J", "a0", "d0", "b0", "c0", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(B)F", "", "U", "(B)D", "", "Z", "(B)Ljava/lang/String;", "u", "", "", "n", "(BLjava/lang/Object;)Z", "getData$annotations", "()V", "data", "h", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@JvmInline
@WasExperimental(markerClass = {Unsigned.class})
/* renamed from: kotlin.n0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UByte implements Comparable<UByte> {

    /* renamed from: b */
    public static final byte f41241b = 0;

    /* renamed from: c */
    public static final byte f41242c = -1;

    /* renamed from: d */
    public static final int f41243d = 1;

    /* renamed from: e */
    public static final int f41244e = 8;
    @NotNull

    /* renamed from: f */
    public static final C14377a f41245f = new C14377a(null);

    /* renamed from: a */
    private final byte f41246a;

    /* compiled from: UByte.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\f"}, m12616d2 = {"Lkotlin/n0$a;", "", "Lkotlin/n0;", "MAX_VALUE", "B", "MIN_VALUE", "", "SIZE_BITS", "I", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.n0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14377a {
        private C14377a() {
        }

        public /* synthetic */ C14377a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ UByte(byte b) {
        this.f41246a = b;
    }

    @InlineOnly
    /* renamed from: A */
    private static final int m7815A(byte b, short s) {
        return UInt.m7678h(UInt.m7678h(b & f41242c) - UInt.m7678h(s & UShort.f40820c));
    }

    @InlineOnly
    /* renamed from: B */
    private static final byte m7814B(byte b, byte b2) {
        return m7776h((byte) UnsignedUtils.m8559e(UInt.m7678h(b & f41242c), UInt.m7678h(b2 & f41242c)));
    }

    @InlineOnly
    /* renamed from: C */
    private static final long m7813C(byte b, long j) {
        return UnsignedUtils.m8555i(ULong.m5889h(b & 255), j);
    }

    @InlineOnly
    /* renamed from: D */
    private static final int m7812D(byte b, int i) {
        return UnsignedUtils.m8559e(UInt.m7678h(b & f41242c), i);
    }

    @InlineOnly
    /* renamed from: E */
    private static final short m7811E(byte b, short s) {
        return UShort.m12528h((short) UnsignedUtils.m8559e(UInt.m7678h(b & f41242c), UInt.m7678h(s & UShort.f40820c)));
    }

    @InlineOnly
    /* renamed from: F */
    private static final byte m7810F(byte b, byte b2) {
        return m7776h((byte) (b | b2));
    }

    @InlineOnly
    /* renamed from: G */
    private static final int m7809G(byte b, byte b2) {
        return UInt.m7678h(UInt.m7678h(b & f41242c) + UInt.m7678h(b2 & f41242c));
    }

    @InlineOnly
    /* renamed from: H */
    private static final long m7808H(byte b, long j) {
        return ULong.m5889h(ULong.m5889h(b & 255) + j);
    }

    @InlineOnly
    /* renamed from: I */
    private static final int m7807I(byte b, int i) {
        return UInt.m7678h(UInt.m7678h(b & f41242c) + i);
    }

    @InlineOnly
    /* renamed from: J */
    private static final int m7806J(byte b, short s) {
        return UInt.m7678h(UInt.m7678h(b & f41242c) + UInt.m7678h(s & UShort.f40820c));
    }

    @InlineOnly
    /* renamed from: K */
    private static final C14424t m7805K(byte b, byte b2) {
        return new C14424t(UInt.m7678h(b & f41242c), UInt.m7678h(b2 & f41242c), null);
    }

    @InlineOnly
    /* renamed from: L */
    private static final int m7804L(byte b, byte b2) {
        return UnsignedUtils.m8559e(UInt.m7678h(b & f41242c), UInt.m7678h(b2 & f41242c));
    }

    @InlineOnly
    /* renamed from: M */
    private static final long m7803M(byte b, long j) {
        return UnsignedUtils.m8555i(ULong.m5889h(b & 255), j);
    }

    @InlineOnly
    /* renamed from: N */
    private static final int m7802N(byte b, int i) {
        return UnsignedUtils.m8559e(UInt.m7678h(b & f41242c), i);
    }

    @InlineOnly
    /* renamed from: O */
    private static final int m7801O(byte b, short s) {
        return UnsignedUtils.m8559e(UInt.m7678h(b & f41242c), UInt.m7678h(s & UShort.f40820c));
    }

    @InlineOnly
    /* renamed from: P */
    private static final int m7800P(byte b, byte b2) {
        return UInt.m7678h(UInt.m7678h(b & f41242c) * UInt.m7678h(b2 & f41242c));
    }

    @InlineOnly
    /* renamed from: Q */
    private static final long m7799Q(byte b, long j) {
        return ULong.m5889h(ULong.m5889h(b & 255) * j);
    }

    @InlineOnly
    /* renamed from: R */
    private static final int m7798R(byte b, int i) {
        return UInt.m7678h(UInt.m7678h(b & f41242c) * i);
    }

    @InlineOnly
    /* renamed from: S */
    private static final int m7797S(byte b, short s) {
        return UInt.m7678h(UInt.m7678h(b & f41242c) * UInt.m7678h(s & UShort.f40820c));
    }

    @InlineOnly
    /* renamed from: T */
    private static final byte m7796T(byte b) {
        return b;
    }

    @InlineOnly
    /* renamed from: U */
    private static final double m7795U(byte b) {
        return b & f41242c;
    }

    @InlineOnly
    /* renamed from: V */
    private static final float m7794V(byte b) {
        return b & f41242c;
    }

    @InlineOnly
    /* renamed from: W */
    private static final int m7793W(byte b) {
        return b & f41242c;
    }

    @InlineOnly
    /* renamed from: X */
    private static final long m7792X(byte b) {
        return b & 255;
    }

    @InlineOnly
    /* renamed from: Y */
    private static final short m7791Y(byte b) {
        return (short) (b & 255);
    }

    @NotNull
    /* renamed from: Z */
    public static String m7790Z(byte b) {
        return String.valueOf(b & f41242c);
    }

    @InlineOnly
    /* renamed from: a */
    private static final byte m7789a(byte b, byte b2) {
        return m7776h((byte) (b & b2));
    }

    @InlineOnly
    /* renamed from: a0 */
    private static final byte m7788a0(byte b) {
        return b;
    }

    /* renamed from: b */
    public static final /* synthetic */ UByte m7787b(byte b) {
        return new UByte(b);
    }

    @InlineOnly
    /* renamed from: b0 */
    private static final int m7786b0(byte b) {
        return UInt.m7678h(b & f41242c);
    }

    @InlineOnly
    /* renamed from: c */
    private int m7785c(byte b) {
        return m7783d(this.f41246a, b);
    }

    @InlineOnly
    /* renamed from: c0 */
    private static final long m7784c0(byte b) {
        return ULong.m5889h(b & 255);
    }

    @InlineOnly
    /* renamed from: d */
    private static int m7783d(byte b, byte b2) {
        return C14342f0.m8180t(b & f41242c, b2 & f41242c);
    }

    @InlineOnly
    /* renamed from: d0 */
    private static final short m7782d0(byte b) {
        return UShort.m12528h((short) (b & 255));
    }

    @InlineOnly
    /* renamed from: e */
    private static final int m7781e(byte b, long j) {
        return UnsignedUtils.m8557g(ULong.m5889h(b & 255), j);
    }

    @InlineOnly
    /* renamed from: f */
    private static final int m7779f(byte b, int i) {
        return UnsignedUtils.m8561c(UInt.m7678h(b & f41242c), i);
    }

    @InlineOnly
    /* renamed from: f0 */
    private static final byte m7778f0(byte b, byte b2) {
        return m7776h((byte) (b ^ b2));
    }

    @InlineOnly
    /* renamed from: g */
    private static final int m7777g(byte b, short s) {
        return C14342f0.m8180t(b & f41242c, s & UShort.f40820c);
    }

    @PublishedApi
    /* renamed from: h */
    public static byte m7776h(byte b) {
        return b;
    }

    @InlineOnly
    /* renamed from: i */
    private static final byte m7775i(byte b) {
        return m7776h((byte) (b - 1));
    }

    @InlineOnly
    /* renamed from: j */
    private static final int m7774j(byte b, byte b2) {
        return UnsignedUtils.m8560d(UInt.m7678h(b & f41242c), UInt.m7678h(b2 & f41242c));
    }

    @InlineOnly
    /* renamed from: k */
    private static final long m7773k(byte b, long j) {
        return UnsignedUtils.m8556h(ULong.m5889h(b & 255), j);
    }

    @InlineOnly
    /* renamed from: l */
    private static final int m7772l(byte b, int i) {
        return UnsignedUtils.m8560d(UInt.m7678h(b & f41242c), i);
    }

    @InlineOnly
    /* renamed from: m */
    private static final int m7771m(byte b, short s) {
        return UnsignedUtils.m8560d(UInt.m7678h(b & f41242c), UInt.m7678h(s & UShort.f40820c));
    }

    /* renamed from: n */
    public static boolean m7770n(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m7780e0();
    }

    /* renamed from: o */
    public static final boolean m7769o(byte b, byte b2) {
        return b == b2;
    }

    @InlineOnly
    /* renamed from: p */
    private static final int m7768p(byte b, byte b2) {
        return UnsignedUtils.m8560d(UInt.m7678h(b & f41242c), UInt.m7678h(b2 & f41242c));
    }

    @InlineOnly
    /* renamed from: q */
    private static final long m7767q(byte b, long j) {
        return UnsignedUtils.m8556h(ULong.m5889h(b & 255), j);
    }

    @InlineOnly
    /* renamed from: r */
    private static final int m7766r(byte b, int i) {
        return UnsignedUtils.m8560d(UInt.m7678h(b & f41242c), i);
    }

    @InlineOnly
    /* renamed from: s */
    private static final int m7765s(byte b, short s) {
        return UnsignedUtils.m8560d(UInt.m7678h(b & f41242c), UInt.m7678h(s & UShort.f40820c));
    }

    @PublishedApi
    /* renamed from: t */
    public static /* synthetic */ void m7764t() {
    }

    /* renamed from: u */
    public static int m7763u(byte b) {
        return b;
    }

    @InlineOnly
    /* renamed from: v */
    private static final byte m7762v(byte b) {
        return m7776h((byte) (b + 1));
    }

    @InlineOnly
    /* renamed from: w */
    private static final byte m7761w(byte b) {
        return m7776h((byte) (b ^ (-1)));
    }

    @InlineOnly
    /* renamed from: x */
    private static final int m7760x(byte b, byte b2) {
        return UInt.m7678h(UInt.m7678h(b & f41242c) - UInt.m7678h(b2 & f41242c));
    }

    @InlineOnly
    /* renamed from: y */
    private static final long m7759y(byte b, long j) {
        return ULong.m5889h(ULong.m5889h(b & 255) - j);
    }

    @InlineOnly
    /* renamed from: z */
    private static final int m7758z(byte b, int i) {
        return UInt.m7678h(UInt.m7678h(b & f41242c) - i);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return m7785c(uByte.m7780e0());
    }

    /* renamed from: e0 */
    public final /* synthetic */ byte m7780e0() {
        return this.f41246a;
    }

    public boolean equals(Object obj) {
        return m7770n(this.f41246a, obj);
    }

    public int hashCode() {
        return m7763u(this.f41246a);
    }

    @NotNull
    public String toString() {
        return m7790Z(this.f41246a);
    }
}
