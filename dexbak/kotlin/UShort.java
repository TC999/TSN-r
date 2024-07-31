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
import okhttp3.internal.p629ws.WebSocketProtocol;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.5")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00014B\u0014\b\u0001\u0012\u0006\u0010V\u001a\u00020;ø\u0001\u0000¢\u0006\u0004\bW\u0010/J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006J\u001b\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\bJ\u001b\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u001b\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0006J\u001b\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\bJ\u001b\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u000bJ\u001b\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013J\u001b\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0006J\u001b\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\bJ\u001b\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0013J\u001b\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0006J\u001b\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\bJ\u001b\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u000bJ\u001b\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0013J\u001b\u0010 \u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0006J\u001b\u0010!\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\bJ\u001b\u0010\"\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\nø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000bJ\u001b\u0010#\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b#\u0010\u0013J\u001b\u0010$\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u0006J\u001b\u0010%\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010\bJ\u001b\u0010&\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u000bJ\u001b\u0010'\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0013J\u001b\u0010(\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010\u000bJ\u001b\u0010-\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0013J\u0016\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010/J\u001b\u00102\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b4\u0010+J\u001b\u00105\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b5\u0010+J\u001b\u00106\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b6\u0010+J\u0016\u00107\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b7\u0010/J\u0010\u00109\u001a\u000208H\u0087\b¢\u0006\u0004\b9\u0010:J\u0010\u0010<\u001a\u00020;H\u0087\b¢\u0006\u0004\b<\u0010/J\u0010\u0010=\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\b=\u0010>J\u0010\u0010@\u001a\u00020?H\u0087\b¢\u0006\u0004\b@\u0010AJ\u0016\u0010B\u001a\u00020\u0002H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010:J\u0016\u0010C\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010/J\u0016\u0010D\u001a\u00020\tH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bD\u0010>J\u0016\u0010E\u001a\u00020\fH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010AJ\u0010\u0010G\u001a\u00020FH\u0087\b¢\u0006\u0004\bG\u0010HJ\u0010\u0010J\u001a\u00020IH\u0087\b¢\u0006\u0004\bJ\u0010KJ\u000f\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bO\u0010>J\u001a\u0010R\u001a\u00020Q2\b\u0010\u0003\u001a\u0004\u0018\u00010PHÖ\u0003¢\u0006\u0004\bR\u0010SR\u001a\u0010V\u001a\u00020;8\u0000X\u0081\u0004¢\u0006\f\n\u0004\b4\u0010\u0019\u0012\u0004\bT\u0010U\u0088\u0001V\u0092\u0001\u00020;ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006Y"}, m12616d2 = {"Lkotlin/b1;", "", "Lkotlin/n0;", AdnName.OTHER, "", "c", "(SB)I", "g", "(SS)I", "Lkotlin/r0;", "e", "(SI)I", "Lkotlin/v0;", "d", "(SJ)I", "G", "J", "I", "H", "(SJ)J", "x", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UMCommonContent.f37777aG, "y", "P", ExifInterface.LATITUDE_SOUTH, "R", "Q", "j", "m", C7304t.f25048d, "k", "L", "O", "N", "M", "p", "s", "r", CampaignEx.JSON_KEY_AD_Q, "B", "(SB)B", ExifInterface.LONGITUDE_EAST, "(SS)S", "D", "C", "v", "(S)S", "i", "Lkotlin/ranges/t;", "K", "(SS)Lkotlin/ranges/t;", "a", "F", "f0", IAdInterListener.AdReqParam.WIDTH, "", ExifInterface.GPS_DIRECTION_TRUE, "(S)B", "", "Y", ExifInterface.LONGITUDE_WEST, "(S)I", "", "X", "(S)J", "a0", "d0", "b0", "c0", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(S)F", "", "U", "(S)D", "", "Z", "(S)Ljava/lang/String;", "u", "", "", "n", "(SLjava/lang/Object;)Z", "getData$annotations", "()V", "data", "h", "f", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@JvmInline
@WasExperimental(markerClass = {Unsigned.class})
/* renamed from: kotlin.b1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UShort implements Comparable<UShort> {

    /* renamed from: b */
    public static final short f40819b = 0;

    /* renamed from: c */
    public static final short f40820c = -1;

    /* renamed from: d */
    public static final int f40821d = 2;

    /* renamed from: e */
    public static final int f40822e = 16;
    @NotNull

    /* renamed from: f */
    public static final C14126a f40823f = new C14126a(null);

    /* renamed from: a */
    private final short f40824a;

    /* compiled from: UShort.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\f"}, m12616d2 = {"Lkotlin/b1$a;", "", "Lkotlin/b1;", "MAX_VALUE", ExifInterface.LATITUDE_SOUTH, "MIN_VALUE", "", "SIZE_BITS", "I", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.b1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14126a {
        private C14126a() {
        }

        public /* synthetic */ C14126a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ UShort(short s) {
        this.f40824a = s;
    }

    @InlineOnly
    /* renamed from: A */
    private static final int m12567A(short s, short s2) {
        return UInt.m7678h(UInt.m7678h(s & f40820c) - UInt.m7678h(s2 & f40820c));
    }

    @InlineOnly
    /* renamed from: B */
    private static final byte m12566B(short s, byte b) {
        return UByte.m7776h((byte) UnsignedUtils.m8559e(UInt.m7678h(s & f40820c), UInt.m7678h(b & UByte.f41242c)));
    }

    @InlineOnly
    /* renamed from: C */
    private static final long m12565C(short s, long j) {
        return UnsignedUtils.m8555i(ULong.m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    @InlineOnly
    /* renamed from: D */
    private static final int m12564D(short s, int i) {
        return UnsignedUtils.m8559e(UInt.m7678h(s & f40820c), i);
    }

    @InlineOnly
    /* renamed from: E */
    private static final short m12563E(short s, short s2) {
        return m12528h((short) UnsignedUtils.m8559e(UInt.m7678h(s & f40820c), UInt.m7678h(s2 & f40820c)));
    }

    @InlineOnly
    /* renamed from: F */
    private static final short m12562F(short s, short s2) {
        return m12528h((short) (s | s2));
    }

    @InlineOnly
    /* renamed from: G */
    private static final int m12561G(short s, byte b) {
        return UInt.m7678h(UInt.m7678h(s & f40820c) + UInt.m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: H */
    private static final long m12560H(short s, long j) {
        return ULong.m5889h(ULong.m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j);
    }

    @InlineOnly
    /* renamed from: I */
    private static final int m12559I(short s, int i) {
        return UInt.m7678h(UInt.m7678h(s & f40820c) + i);
    }

    @InlineOnly
    /* renamed from: J */
    private static final int m12558J(short s, short s2) {
        return UInt.m7678h(UInt.m7678h(s & f40820c) + UInt.m7678h(s2 & f40820c));
    }

    @InlineOnly
    /* renamed from: K */
    private static final C14424t m12557K(short s, short s2) {
        return new C14424t(UInt.m7678h(s & f40820c), UInt.m7678h(s2 & f40820c), null);
    }

    @InlineOnly
    /* renamed from: L */
    private static final int m12556L(short s, byte b) {
        return UnsignedUtils.m8559e(UInt.m7678h(s & f40820c), UInt.m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: M */
    private static final long m12555M(short s, long j) {
        return UnsignedUtils.m8555i(ULong.m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    @InlineOnly
    /* renamed from: N */
    private static final int m12554N(short s, int i) {
        return UnsignedUtils.m8559e(UInt.m7678h(s & f40820c), i);
    }

    @InlineOnly
    /* renamed from: O */
    private static final int m12553O(short s, short s2) {
        return UnsignedUtils.m8559e(UInt.m7678h(s & f40820c), UInt.m7678h(s2 & f40820c));
    }

    @InlineOnly
    /* renamed from: P */
    private static final int m12552P(short s, byte b) {
        return UInt.m7678h(UInt.m7678h(s & f40820c) * UInt.m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: Q */
    private static final long m12551Q(short s, long j) {
        return ULong.m5889h(ULong.m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j);
    }

    @InlineOnly
    /* renamed from: R */
    private static final int m12550R(short s, int i) {
        return UInt.m7678h(UInt.m7678h(s & f40820c) * i);
    }

    @InlineOnly
    /* renamed from: S */
    private static final int m12549S(short s, short s2) {
        return UInt.m7678h(UInt.m7678h(s & f40820c) * UInt.m7678h(s2 & f40820c));
    }

    @InlineOnly
    /* renamed from: T */
    private static final byte m12548T(short s) {
        return (byte) s;
    }

    @InlineOnly
    /* renamed from: U */
    private static final double m12547U(short s) {
        return s & f40820c;
    }

    @InlineOnly
    /* renamed from: V */
    private static final float m12546V(short s) {
        return s & f40820c;
    }

    @InlineOnly
    /* renamed from: W */
    private static final int m12545W(short s) {
        return s & f40820c;
    }

    @InlineOnly
    /* renamed from: X */
    private static final long m12544X(short s) {
        return s & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    @InlineOnly
    /* renamed from: Y */
    private static final short m12543Y(short s) {
        return s;
    }

    @NotNull
    /* renamed from: Z */
    public static String m12542Z(short s) {
        return String.valueOf(s & f40820c);
    }

    @InlineOnly
    /* renamed from: a */
    private static final short m12541a(short s, short s2) {
        return m12528h((short) (s & s2));
    }

    @InlineOnly
    /* renamed from: a0 */
    private static final byte m12540a0(short s) {
        return UByte.m7776h((byte) s);
    }

    /* renamed from: b */
    public static final /* synthetic */ UShort m12539b(short s) {
        return new UShort(s);
    }

    @InlineOnly
    /* renamed from: b0 */
    private static final int m12538b0(short s) {
        return UInt.m7678h(s & f40820c);
    }

    @InlineOnly
    /* renamed from: c */
    private static final int m12537c(short s, byte b) {
        return C14342f0.m8180t(s & f40820c, b & UByte.f41242c);
    }

    @InlineOnly
    /* renamed from: c0 */
    private static final long m12536c0(short s) {
        return ULong.m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    @InlineOnly
    /* renamed from: d */
    private static final int m12535d(short s, long j) {
        return UnsignedUtils.m8557g(ULong.m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    @InlineOnly
    /* renamed from: d0 */
    private static final short m12534d0(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: e */
    private static final int m12533e(short s, int i) {
        return UnsignedUtils.m8561c(UInt.m7678h(s & f40820c), i);
    }

    @InlineOnly
    /* renamed from: f */
    private int m12531f(short s) {
        return m12529g(this.f40824a, s);
    }

    @InlineOnly
    /* renamed from: f0 */
    private static final short m12530f0(short s, short s2) {
        return m12528h((short) (s ^ s2));
    }

    @InlineOnly
    /* renamed from: g */
    private static int m12529g(short s, short s2) {
        return C14342f0.m8180t(s & f40820c, s2 & f40820c);
    }

    @PublishedApi
    /* renamed from: h */
    public static short m12528h(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: i */
    private static final short m12527i(short s) {
        return m12528h((short) (s - 1));
    }

    @InlineOnly
    /* renamed from: j */
    private static final int m12526j(short s, byte b) {
        return UnsignedUtils.m8560d(UInt.m7678h(s & f40820c), UInt.m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: k */
    private static final long m12525k(short s, long j) {
        return UnsignedUtils.m8556h(ULong.m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    @InlineOnly
    /* renamed from: l */
    private static final int m12524l(short s, int i) {
        return UnsignedUtils.m8560d(UInt.m7678h(s & f40820c), i);
    }

    @InlineOnly
    /* renamed from: m */
    private static final int m12523m(short s, short s2) {
        return UnsignedUtils.m8560d(UInt.m7678h(s & f40820c), UInt.m7678h(s2 & f40820c));
    }

    /* renamed from: n */
    public static boolean m12522n(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m12532e0();
    }

    /* renamed from: o */
    public static final boolean m12521o(short s, short s2) {
        return s == s2;
    }

    @InlineOnly
    /* renamed from: p */
    private static final int m12520p(short s, byte b) {
        return UnsignedUtils.m8560d(UInt.m7678h(s & f40820c), UInt.m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: q */
    private static final long m12519q(short s, long j) {
        return UnsignedUtils.m8556h(ULong.m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    @InlineOnly
    /* renamed from: r */
    private static final int m12518r(short s, int i) {
        return UnsignedUtils.m8560d(UInt.m7678h(s & f40820c), i);
    }

    @InlineOnly
    /* renamed from: s */
    private static final int m12517s(short s, short s2) {
        return UnsignedUtils.m8560d(UInt.m7678h(s & f40820c), UInt.m7678h(s2 & f40820c));
    }

    @PublishedApi
    /* renamed from: t */
    public static /* synthetic */ void m12516t() {
    }

    /* renamed from: u */
    public static int m12515u(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: v */
    private static final short m12514v(short s) {
        return m12528h((short) (s + 1));
    }

    @InlineOnly
    /* renamed from: w */
    private static final short m12513w(short s) {
        return m12528h((short) (s ^ (-1)));
    }

    @InlineOnly
    /* renamed from: x */
    private static final int m12512x(short s, byte b) {
        return UInt.m7678h(UInt.m7678h(s & f40820c) - UInt.m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: y */
    private static final long m12511y(short s, long j) {
        return ULong.m5889h(ULong.m5889h(s & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j);
    }

    @InlineOnly
    /* renamed from: z */
    private static final int m12510z(short s, int i) {
        return UInt.m7678h(UInt.m7678h(s & f40820c) - i);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return m12531f(uShort.m12532e0());
    }

    /* renamed from: e0 */
    public final /* synthetic */ short m12532e0() {
        return this.f40824a;
    }

    public boolean equals(Object obj) {
        return m12522n(this.f40824a, obj);
    }

    public int hashCode() {
        return m12515u(this.f40824a);
    }

    @NotNull
    public String toString() {
        return m12542Z(this.f40824a);
    }
}
