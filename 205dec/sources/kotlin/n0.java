package kotlin;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UByte.kt */
@SinceKotlin(version = "1.5")
@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087@\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00014B\u0014\b\u0001\u0012\u0006\u0010V\u001a\u000208\u00f8\u0001\u0000\u00a2\u0006\u0004\bW\u0010/J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\n\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\tH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\bJ\u001b\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u000bJ\u001b\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0005J\u001b\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\bJ\u001b\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u000bJ\u001b\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0013J\u001b\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0005J\u001b\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\bJ\u001b\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0013J\u001b\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0005J\u001b\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\bJ\u001b\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u000bJ\u001b\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u0013J\u001b\u0010 \u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0005J\u001b\u0010!\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\bJ\u001b\u0010\"\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010\u000bJ\u001b\u0010#\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\u0013J\u001b\u0010$\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\u0005J\u001b\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010\bJ\u001b\u0010&\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u000bJ\u001b\u0010'\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0013J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\u000bJ\u001b\u0010-\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010\u0013J\u0016\u0010.\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b0\u0010/J\u001b\u00102\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103J\u001b\u00104\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b4\u0010)J\u001b\u00105\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u0010)J\u001b\u00106\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b6\u0010)J\u0016\u00107\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b7\u0010/J\u0010\u00109\u001a\u000208H\u0087\b\u00a2\u0006\u0004\b9\u0010/J\u0010\u0010;\u001a\u00020:H\u0087\b\u00a2\u0006\u0004\b;\u0010<J\u0010\u0010=\u001a\u00020\u0003H\u0087\b\u00a2\u0006\u0004\b=\u0010>J\u0010\u0010@\u001a\u00020?H\u0087\b\u00a2\u0006\u0004\b@\u0010AJ\u0016\u0010B\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bB\u0010/J\u0016\u0010C\u001a\u00020\u0006H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bC\u0010<J\u0016\u0010D\u001a\u00020\tH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bD\u0010>J\u0016\u0010E\u001a\u00020\fH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bE\u0010AJ\u0010\u0010G\u001a\u00020FH\u0087\b\u00a2\u0006\u0004\bG\u0010HJ\u0010\u0010J\u001a\u00020IH\u0087\b\u00a2\u0006\u0004\bJ\u0010KJ\u000f\u0010M\u001a\u00020LH\u0016\u00a2\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\u0003H\u00d6\u0001\u00a2\u0006\u0004\bO\u0010>J\u001a\u0010R\u001a\u00020Q2\b\u0010\u0002\u001a\u0004\u0018\u00010PH\u00d6\u0003\u00a2\u0006\u0004\bR\u0010SR\u001a\u0010V\u001a\u0002088\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b4\u0010\u0017\u0012\u0004\bT\u0010U\u0088\u0001V\u0092\u0001\u000208\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006Y"}, d2 = {"Lkotlin/n0;", "", "other", "", "e", "(BB)I", "Lkotlin/b1;", "h", "(BS)I", "Lkotlin/r0;", "g", "(BI)I", "Lkotlin/v0;", "f", "(BJ)I", "L", "O", "N", "M", "(BJ)J", "A", "D", "C", "B", "U", "X", "W", "V", "k", "n", "m", "l", "Q", "T", "S", "R", CampaignEx.JSON_KEY_AD_Q, "t", "s", "r", "E", "(BB)B", "H", "(BS)S", "G", "F", "y", "(B)B", "j", "Lkotlin/ranges/t;", "P", "(BB)Lkotlin/ranges/t;", "a", "K", "k0", "z", "", "Y", "", "d0", "(B)S", "b0", "(B)I", "", "c0", "(B)J", "f0", "i0", "g0", "h0", "", "a0", "(B)F", "", "Z", "(B)D", "", "e0", "(B)Ljava/lang/String;", "w", "", "", "o", "(BLjava/lang/Object;)Z", "getData$annotations", "()V", "data", "i", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n0 implements Comparable<n0> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f55741b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static final byte f55742c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final byte f55743d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f55744e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final int f55745f = 8;

    /* renamed from: a  reason: collision with root package name */
    private final byte f55746a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: UByte.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\f"}, d2 = {"Lkotlin/n0$a;", "", "Lkotlin/n0;", "MAX_VALUE", "B", "MIN_VALUE", "", "SIZE_BITS", "I", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ n0(byte b4) {
        this.f55746a = b4;
    }

    @InlineOnly
    private static final int A(byte b4, byte b5) {
        return r0.i(r0.i(b4 & 255) - r0.i(b5 & 255));
    }

    @InlineOnly
    private static final long B(byte b4, long j4) {
        return v0.i(v0.i(b4 & 255) - j4);
    }

    @InlineOnly
    private static final int C(byte b4, int i4) {
        return r0.i(r0.i(b4 & 255) - i4);
    }

    @InlineOnly
    private static final int D(byte b4, short s3) {
        return r0.i(r0.i(b4 & 255) - r0.i(s3 & 65535));
    }

    @InlineOnly
    private static final byte E(byte b4, byte b5) {
        return i((byte) g1.e(r0.i(b4 & 255), r0.i(b5 & 255)));
    }

    @InlineOnly
    private static final long F(byte b4, long j4) {
        return g1.i(v0.i(b4 & 255), j4);
    }

    @InlineOnly
    private static final int G(byte b4, int i4) {
        return g1.e(r0.i(b4 & 255), i4);
    }

    @InlineOnly
    private static final short H(byte b4, short s3) {
        return b1.i((short) g1.e(r0.i(b4 & 255), r0.i(s3 & 65535)));
    }

    @InlineOnly
    private static final byte K(byte b4, byte b5) {
        return i((byte) (b4 | b5));
    }

    @InlineOnly
    private static final int L(byte b4, byte b5) {
        return r0.i(r0.i(b4 & 255) + r0.i(b5 & 255));
    }

    @InlineOnly
    private static final long M(byte b4, long j4) {
        return v0.i(v0.i(b4 & 255) + j4);
    }

    @InlineOnly
    private static final int N(byte b4, int i4) {
        return r0.i(r0.i(b4 & 255) + i4);
    }

    @InlineOnly
    private static final int O(byte b4, short s3) {
        return r0.i(r0.i(b4 & 255) + r0.i(s3 & 65535));
    }

    @InlineOnly
    private static final kotlin.ranges.t P(byte b4, byte b5) {
        return new kotlin.ranges.t(r0.i(b4 & 255), r0.i(b5 & 255), null);
    }

    @InlineOnly
    private static final int Q(byte b4, byte b5) {
        return g1.e(r0.i(b4 & 255), r0.i(b5 & 255));
    }

    @InlineOnly
    private static final long R(byte b4, long j4) {
        return g1.i(v0.i(b4 & 255), j4);
    }

    @InlineOnly
    private static final int S(byte b4, int i4) {
        return g1.e(r0.i(b4 & 255), i4);
    }

    @InlineOnly
    private static final int T(byte b4, short s3) {
        return g1.e(r0.i(b4 & 255), r0.i(s3 & 65535));
    }

    @InlineOnly
    private static final int U(byte b4, byte b5) {
        return r0.i(r0.i(b4 & 255) * r0.i(b5 & 255));
    }

    @InlineOnly
    private static final long V(byte b4, long j4) {
        return v0.i(v0.i(b4 & 255) * j4);
    }

    @InlineOnly
    private static final int W(byte b4, int i4) {
        return r0.i(r0.i(b4 & 255) * i4);
    }

    @InlineOnly
    private static final int X(byte b4, short s3) {
        return r0.i(r0.i(b4 & 255) * r0.i(s3 & 65535));
    }

    @InlineOnly
    private static final byte Y(byte b4) {
        return b4;
    }

    @InlineOnly
    private static final double Z(byte b4) {
        return b4 & 255;
    }

    @InlineOnly
    private static final byte a(byte b4, byte b5) {
        return i((byte) (b4 & b5));
    }

    @InlineOnly
    private static final float a0(byte b4) {
        return b4 & 255;
    }

    public static final /* synthetic */ n0 b(byte b4) {
        return new n0(b4);
    }

    @InlineOnly
    private static final int b0(byte b4) {
        return b4 & 255;
    }

    @InlineOnly
    private static final long c0(byte b4) {
        return b4 & 255;
    }

    @InlineOnly
    private int d(byte b4) {
        return kotlin.jvm.internal.f0.t(j0() & 255, b4 & 255);
    }

    @InlineOnly
    private static final short d0(byte b4) {
        return (short) (b4 & 255);
    }

    @InlineOnly
    private static int e(byte b4, byte b5) {
        return kotlin.jvm.internal.f0.t(b4 & 255, b5 & 255);
    }

    @NotNull
    public static String e0(byte b4) {
        return String.valueOf(b4 & 255);
    }

    @InlineOnly
    private static final int f(byte b4, long j4) {
        return g1.g(v0.i(b4 & 255), j4);
    }

    @InlineOnly
    private static final byte f0(byte b4) {
        return b4;
    }

    @InlineOnly
    private static final int g(byte b4, int i4) {
        return g1.c(r0.i(b4 & 255), i4);
    }

    @InlineOnly
    private static final int g0(byte b4) {
        return r0.i(b4 & 255);
    }

    @InlineOnly
    private static final int h(byte b4, short s3) {
        return kotlin.jvm.internal.f0.t(b4 & 255, s3 & 65535);
    }

    @InlineOnly
    private static final long h0(byte b4) {
        return v0.i(b4 & 255);
    }

    @PublishedApi
    public static byte i(byte b4) {
        return b4;
    }

    @InlineOnly
    private static final short i0(byte b4) {
        return b1.i((short) (b4 & 255));
    }

    @InlineOnly
    private static final byte j(byte b4) {
        return i((byte) (b4 - 1));
    }

    @InlineOnly
    private static final int k(byte b4, byte b5) {
        return g1.d(r0.i(b4 & 255), r0.i(b5 & 255));
    }

    @InlineOnly
    private static final byte k0(byte b4, byte b5) {
        return i((byte) (b4 ^ b5));
    }

    @InlineOnly
    private static final long l(byte b4, long j4) {
        return g1.h(v0.i(b4 & 255), j4);
    }

    @InlineOnly
    private static final int m(byte b4, int i4) {
        return g1.d(r0.i(b4 & 255), i4);
    }

    @InlineOnly
    private static final int n(byte b4, short s3) {
        return g1.d(r0.i(b4 & 255), r0.i(s3 & 65535));
    }

    public static boolean o(byte b4, Object obj) {
        return (obj instanceof n0) && b4 == ((n0) obj).j0();
    }

    public static final boolean p(byte b4, byte b5) {
        return b4 == b5;
    }

    @InlineOnly
    private static final int q(byte b4, byte b5) {
        return g1.d(r0.i(b4 & 255), r0.i(b5 & 255));
    }

    @InlineOnly
    private static final long r(byte b4, long j4) {
        return g1.h(v0.i(b4 & 255), j4);
    }

    @InlineOnly
    private static final int s(byte b4, int i4) {
        return g1.d(r0.i(b4 & 255), i4);
    }

    @InlineOnly
    private static final int t(byte b4, short s3) {
        return g1.d(r0.i(b4 & 255), r0.i(s3 & 65535));
    }

    @PublishedApi
    public static /* synthetic */ void u() {
    }

    public static int w(byte b4) {
        return b4;
    }

    @InlineOnly
    private static final byte y(byte b4) {
        return i((byte) (b4 + 1));
    }

    @InlineOnly
    private static final byte z(byte b4) {
        return i((byte) (b4 ^ (-1)));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(n0 n0Var) {
        return kotlin.jvm.internal.f0.t(j0() & 255, n0Var.j0() & 255);
    }

    public boolean equals(Object obj) {
        return o(this.f55746a, obj);
    }

    public int hashCode() {
        return w(this.f55746a);
    }

    public final /* synthetic */ byte j0() {
        return this.f55746a;
    }

    @NotNull
    public String toString() {
        return e0(this.f55746a);
    }
}
