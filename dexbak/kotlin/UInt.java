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
import kotlin.ranges.C14424t;
import org.jetbrains.annotations.NotNull;

@SinceKotlin(version = "1.5")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087@\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00017B\u0014\b\u0001\u0012\u0006\u0010Y\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\bZ\u0010/J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0006J\u001b\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\tJ\u001b\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000bJ\u001b\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0006J\u001b\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\tJ\u001b\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u000bJ\u001b\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013J\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0006J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\tJ\u001b\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0013J\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0006J\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\tJ\u001b\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u000bJ\u001b\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0013J\u001b\u0010 \u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0006J\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\nø\u0001\u0000¢\u0006\u0004\b!\u0010\tJ\u001b\u0010\"\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\"\u0010\u000bJ\u001b\u0010#\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\nø\u0001\u0000¢\u0006\u0004\b#\u0010\u0013J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b$\u0010\u0006J\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b%\u0010\tJ\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b&\u0010\u000bJ\u001b\u0010'\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b'\u0010\u0013J\u001b\u0010(\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\bø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b,\u0010\u000bJ\u001b\u0010-\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b-\u0010\u0013J\u0016\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u0010/J\u001b\u00102\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b2\u00103J\u001e\u00105\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0004H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u0010\u000bJ\u001e\u00106\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0004H\u0087\fø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u0010\u000bJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b7\u0010\u000bJ\u001b\u00108\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b8\u0010\u000bJ\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b9\u0010\u000bJ\u0016\u0010:\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b:\u0010/J\u0010\u0010<\u001a\u00020;H\u0087\b¢\u0006\u0004\b<\u0010=J\u0010\u0010?\u001a\u00020>H\u0087\b¢\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\bA\u0010/J\u0010\u0010C\u001a\u00020BH\u0087\b¢\u0006\u0004\bC\u0010DJ\u0016\u0010E\u001a\u00020\u0002H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bE\u0010=J\u0016\u0010F\u001a\u00020\u0007H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010@J\u0016\u0010G\u001a\u00020\u0000H\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bG\u0010/J\u0016\u0010H\u001a\u00020\fH\u0087\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bH\u0010DJ\u0010\u0010J\u001a\u00020IH\u0087\b¢\u0006\u0004\bJ\u0010KJ\u0010\u0010M\u001a\u00020LH\u0087\b¢\u0006\u0004\bM\u0010NJ\u000f\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bR\u0010/J\u001a\u0010U\u001a\u00020T2\b\u0010\u0003\u001a\u0004\u0018\u00010SHÖ\u0003¢\u0006\u0004\bU\u0010VR\u001a\u0010Y\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\f\n\u0004\b7\u0010\u0011\u0012\u0004\bW\u0010X\u0088\u0001Y\u0092\u0001\u00020\u0004ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006["}, m12616d2 = {"Lkotlin/r0;", "", "Lkotlin/n0;", AdnName.OTHER, "", "c", "(IB)I", "Lkotlin/b1;", "g", "(IS)I", "f", "(II)I", "Lkotlin/v0;", "d", "(IJ)I", "G", "J", "I", "H", "(IJ)J", "x", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, UMCommonContent.f37777aG, "y", "R", "U", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH, "j", "m", C7304t.f25048d, "k", "L", "O", "N", "M", "p", "s", "r", CampaignEx.JSON_KEY_AD_Q, "B", "(IB)B", ExifInterface.LONGITUDE_EAST, "(IS)S", "D", "C", "v", "(I)I", "i", "Lkotlin/ranges/t;", "K", "(II)Lkotlin/ranges/t;", "bitCount", "P", "Q", "a", "F", "h0", IAdInterListener.AdReqParam.WIDTH, "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(I)B", "", "a0", "(I)S", "Y", "", "Z", "(I)J", "c0", "f0", "d0", "e0", "", "X", "(I)F", "", ExifInterface.LONGITUDE_WEST, "(I)D", "", "b0", "(I)Ljava/lang/String;", "u", "", "", "n", "(ILjava/lang/Object;)Z", "getData$annotations", "()V", "data", "h", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@JvmInline
@WasExperimental(markerClass = {Unsigned.class})
/* renamed from: kotlin.r0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UInt implements Comparable<UInt> {

    /* renamed from: b */
    public static final int f41258b = 0;

    /* renamed from: c */
    public static final int f41259c = -1;

    /* renamed from: d */
    public static final int f41260d = 4;

    /* renamed from: e */
    public static final int f41261e = 32;
    @NotNull

    /* renamed from: f */
    public static final C14390a f41262f = new C14390a(null);

    /* renamed from: a */
    private final int f41263a;

    /* compiled from: UInt.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0086Tø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u000b"}, m12616d2 = {"Lkotlin/r0$a;", "", "Lkotlin/r0;", "MAX_VALUE", "I", "MIN_VALUE", "", "SIZE_BITS", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.r0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14390a {
        private C14390a() {
        }

        public /* synthetic */ C14390a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ UInt(int i) {
        this.f41263a = i;
    }

    @InlineOnly
    /* renamed from: A */
    private static final int m7718A(int i, short s) {
        return m7678h(i - m7678h(s & UShort.f40820c));
    }

    @InlineOnly
    /* renamed from: B */
    private static final byte m7717B(int i, byte b) {
        return UByte.m7776h((byte) UnsignedUtils.m8559e(i, m7678h(b & UByte.f41242c)));
    }

    @InlineOnly
    /* renamed from: C */
    private static final long m7716C(int i, long j) {
        return UnsignedUtils.m8555i(ULong.m5889h(i & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: D */
    private static final int m7715D(int i, int i2) {
        return UnsignedUtils.m8559e(i, i2);
    }

    @InlineOnly
    /* renamed from: E */
    private static final short m7714E(int i, short s) {
        return UShort.m12528h((short) UnsignedUtils.m8559e(i, m7678h(s & UShort.f40820c)));
    }

    @InlineOnly
    /* renamed from: F */
    private static final int m7713F(int i, int i2) {
        return m7678h(i | i2);
    }

    @InlineOnly
    /* renamed from: G */
    private static final int m7712G(int i, byte b) {
        return m7678h(i + m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: H */
    private static final long m7711H(int i, long j) {
        return ULong.m5889h(ULong.m5889h(i & 4294967295L) + j);
    }

    @InlineOnly
    /* renamed from: I */
    private static final int m7710I(int i, int i2) {
        return m7678h(i + i2);
    }

    @InlineOnly
    /* renamed from: J */
    private static final int m7709J(int i, short s) {
        return m7678h(i + m7678h(s & UShort.f40820c));
    }

    @InlineOnly
    /* renamed from: K */
    private static final C14424t m7708K(int i, int i2) {
        return new C14424t(i, i2, null);
    }

    @InlineOnly
    /* renamed from: L */
    private static final int m7707L(int i, byte b) {
        return UnsignedUtils.m8559e(i, m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: M */
    private static final long m7706M(int i, long j) {
        return UnsignedUtils.m8555i(ULong.m5889h(i & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: N */
    private static final int m7705N(int i, int i2) {
        return UnsignedUtils.m8559e(i, i2);
    }

    @InlineOnly
    /* renamed from: O */
    private static final int m7704O(int i, short s) {
        return UnsignedUtils.m8559e(i, m7678h(s & UShort.f40820c));
    }

    @InlineOnly
    /* renamed from: P */
    private static final int m7703P(int i, int i2) {
        return m7678h(i << i2);
    }

    @InlineOnly
    /* renamed from: Q */
    private static final int m7702Q(int i, int i2) {
        return m7678h(i >>> i2);
    }

    @InlineOnly
    /* renamed from: R */
    private static final int m7701R(int i, byte b) {
        return m7678h(i * m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: S */
    private static final long m7700S(int i, long j) {
        return ULong.m5889h(ULong.m5889h(i & 4294967295L) * j);
    }

    @InlineOnly
    /* renamed from: T */
    private static final int m7699T(int i, int i2) {
        return m7678h(i * i2);
    }

    @InlineOnly
    /* renamed from: U */
    private static final int m7698U(int i, short s) {
        return m7678h(i * m7678h(s & UShort.f40820c));
    }

    @InlineOnly
    /* renamed from: V */
    private static final byte m7697V(int i) {
        return (byte) i;
    }

    @InlineOnly
    /* renamed from: W */
    private static final double m7696W(int i) {
        return UnsignedUtils.m8558f(i);
    }

    @InlineOnly
    /* renamed from: X */
    private static final float m7695X(int i) {
        return (float) UnsignedUtils.m8558f(i);
    }

    @InlineOnly
    /* renamed from: Y */
    private static final int m7694Y(int i) {
        return i;
    }

    @InlineOnly
    /* renamed from: Z */
    private static final long m7693Z(int i) {
        return i & 4294967295L;
    }

    @InlineOnly
    /* renamed from: a */
    private static final int m7692a(int i, int i2) {
        return m7678h(i & i2);
    }

    @InlineOnly
    /* renamed from: a0 */
    private static final short m7691a0(int i) {
        return (short) i;
    }

    /* renamed from: b */
    public static final /* synthetic */ UInt m7690b(int i) {
        return new UInt(i);
    }

    @NotNull
    /* renamed from: b0 */
    public static String m7689b0(int i) {
        return String.valueOf(i & 4294967295L);
    }

    @InlineOnly
    /* renamed from: c */
    private static final int m7688c(int i, byte b) {
        return UnsignedUtils.m8561c(i, m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: c0 */
    private static final byte m7687c0(int i) {
        return UByte.m7776h((byte) i);
    }

    @InlineOnly
    /* renamed from: d */
    private static final int m7686d(int i, long j) {
        return UnsignedUtils.m8557g(ULong.m5889h(i & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: d0 */
    private static final int m7685d0(int i) {
        return i;
    }

    @InlineOnly
    /* renamed from: e */
    private int m7684e(int i) {
        return m7682f(this.f41263a, i);
    }

    @InlineOnly
    /* renamed from: e0 */
    private static final long m7683e0(int i) {
        return ULong.m5889h(i & 4294967295L);
    }

    @InlineOnly
    /* renamed from: f */
    private static int m7682f(int i, int i2) {
        return UnsignedUtils.m8561c(i, i2);
    }

    @InlineOnly
    /* renamed from: f0 */
    private static final short m7681f0(int i) {
        return UShort.m12528h((short) i);
    }

    @InlineOnly
    /* renamed from: g */
    private static final int m7680g(int i, short s) {
        return UnsignedUtils.m8561c(i, m7678h(s & UShort.f40820c));
    }

    @PublishedApi
    /* renamed from: h */
    public static int m7678h(int i) {
        return i;
    }

    @InlineOnly
    /* renamed from: h0 */
    private static final int m7677h0(int i, int i2) {
        return m7678h(i ^ i2);
    }

    @InlineOnly
    /* renamed from: i */
    private static final int m7676i(int i) {
        return m7678h(i - 1);
    }

    @InlineOnly
    /* renamed from: j */
    private static final int m7675j(int i, byte b) {
        return UnsignedUtils.m8560d(i, m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: k */
    private static final long m7674k(int i, long j) {
        return UnsignedUtils.m8556h(ULong.m5889h(i & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: l */
    private static final int m7673l(int i, int i2) {
        return UnsignedUtils.m8560d(i, i2);
    }

    @InlineOnly
    /* renamed from: m */
    private static final int m7672m(int i, short s) {
        return UnsignedUtils.m8560d(i, m7678h(s & UShort.f40820c));
    }

    /* renamed from: n */
    public static boolean m7671n(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m7679g0();
    }

    /* renamed from: o */
    public static final boolean m7670o(int i, int i2) {
        return i == i2;
    }

    @InlineOnly
    /* renamed from: p */
    private static final int m7669p(int i, byte b) {
        return UnsignedUtils.m8560d(i, m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: q */
    private static final long m7668q(int i, long j) {
        return UnsignedUtils.m8556h(ULong.m5889h(i & 4294967295L), j);
    }

    @InlineOnly
    /* renamed from: r */
    private static final int m7667r(int i, int i2) {
        return UnsignedUtils.m8560d(i, i2);
    }

    @InlineOnly
    /* renamed from: s */
    private static final int m7666s(int i, short s) {
        return UnsignedUtils.m8560d(i, m7678h(s & UShort.f40820c));
    }

    @PublishedApi
    /* renamed from: t */
    public static /* synthetic */ void m7665t() {
    }

    /* renamed from: u */
    public static int m7664u(int i) {
        return i;
    }

    @InlineOnly
    /* renamed from: v */
    private static final int m7663v(int i) {
        return m7678h(i + 1);
    }

    @InlineOnly
    /* renamed from: w */
    private static final int m7662w(int i) {
        return m7678h(i ^ (-1));
    }

    @InlineOnly
    /* renamed from: x */
    private static final int m7661x(int i, byte b) {
        return m7678h(i - m7678h(b & UByte.f41242c));
    }

    @InlineOnly
    /* renamed from: y */
    private static final long m7660y(int i, long j) {
        return ULong.m5889h(ULong.m5889h(i & 4294967295L) - j);
    }

    @InlineOnly
    /* renamed from: z */
    private static final int m7659z(int i, int i2) {
        return m7678h(i - i2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return m7684e(uInt.m7679g0());
    }

    public boolean equals(Object obj) {
        return m7671n(this.f41263a, obj);
    }

    /* renamed from: g0 */
    public final /* synthetic */ int m7679g0() {
        return this.f41263a;
    }

    public int hashCode() {
        return m7664u(this.f41263a);
    }

    @NotNull
    public String toString() {
        return m7689b0(this.f41263a);
    }
}
