package kotlin;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UInt.kt */
@SinceKotlin(version = "1.5")
@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 \\2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00017B\u0014\b\u0001\u0012\u0006\u0010Z\u001a\u00020\u0004\u00f8\u0001\u0000\u00a2\u0006\u0004\b[\u0010/J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0006J\u001b\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\tJ\u001b\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u000bJ\u001b\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0006J\u001b\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\tJ\u001b\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u000bJ\u001b\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0013J\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0006J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\tJ\u001b\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u000bJ\u001b\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0013J\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0006J\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\tJ\u001b\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u000bJ\u001b\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u0013J\u001b\u0010 \u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0006J\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\tJ\u001b\u0010\"\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010\u000bJ\u001b\u0010#\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\u0013J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\u0006J\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010\tJ\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u000bJ\u001b\u0010'\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0013J\u001b\u0010(\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b,\u0010\u000bJ\u001b\u0010-\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010\u0013J\u0016\u0010.\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b.\u0010/J\u0016\u00100\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b0\u0010/J\u001b\u00102\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b2\u00103J\u001e\u00105\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0004H\u0087\f\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b5\u0010\u000bJ\u001e\u00106\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0004H\u0087\f\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b6\u0010\u000bJ\u001b\u00107\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b7\u0010\u000bJ\u001b\u00108\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b8\u0010\u000bJ\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b9\u0010\u000bJ\u0016\u0010:\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b:\u0010/J\u0010\u0010<\u001a\u00020;H\u0087\b\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010?\u001a\u00020>H\u0087\b\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010A\u001a\u00020\u0004H\u0087\b\u00a2\u0006\u0004\bA\u0010/J\u0010\u0010C\u001a\u00020BH\u0087\b\u00a2\u0006\u0004\bC\u0010DJ\u0016\u0010E\u001a\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bE\u0010=J\u0016\u0010F\u001a\u00020\u0007H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bF\u0010@J\u0016\u0010G\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bG\u0010/J\u0016\u0010H\u001a\u00020\fH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bH\u0010DJ\u0010\u0010J\u001a\u00020IH\u0087\b\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010M\u001a\u00020LH\u0087\b\u00a2\u0006\u0004\bM\u0010NJ\u000f\u0010P\u001a\u00020OH\u0016\u00a2\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\bR\u0010/J\u001a\u0010U\u001a\u00020T2\b\u0010\u0003\u001a\u0004\u0018\u00010SH\u00d6\u0003\u00a2\u0006\u0004\bU\u0010VR\u001a\u0010Z\u001a\u00020\u00048\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b7\u0010W\u0012\u0004\bX\u0010Y\u0088\u0001Z\u0092\u0001\u00020\u0004\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006]"}, d2 = {"Lkotlin/r0;", "", "Lkotlin/n0;", "other", "", "d", "(IB)I", "Lkotlin/b1;", "h", "(IS)I", "g", "(II)I", "Lkotlin/v0;", "e", "(IJ)I", "L", "O", "N", "M", "(IJ)J", "A", "D", "C", "B", "W", "Z", "Y", "X", "k", "n", "m", "l", "Q", "T", "S", "R", CampaignEx.JSON_KEY_AD_Q, "t", "s", "r", "E", "(IB)B", "H", "(IS)S", "G", "F", "y", "(I)I", "j", "Lkotlin/ranges/t;", "P", "(II)Lkotlin/ranges/t;", "bitCount", "U", "V", "a", "K", "m0", "z", "", "a0", "(I)B", "", "f0", "(I)S", "d0", "", "e0", "(I)J", "h0", "k0", "i0", "j0", "", "c0", "(I)F", "", "b0", "(I)D", "", "g0", "(I)Ljava/lang/String;", "w", "", "", "o", "(ILjava/lang/Object;)Z", "I", "getData$annotations", "()V", "data", "i", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r0 implements Comparable<r0> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f55758b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static final int f55759c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f55760d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f55761e = 4;

    /* renamed from: f  reason: collision with root package name */
    public static final int f55762f = 32;

    /* renamed from: a  reason: collision with root package name */
    private final int f55763a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: UInt.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u000b"}, d2 = {"Lkotlin/r0$a;", "", "Lkotlin/r0;", "MAX_VALUE", "I", "MIN_VALUE", "", "SIZE_BITS", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ r0(int i4) {
        this.f55763a = i4;
    }

    @InlineOnly
    private static final int A(int i4, byte b4) {
        return i(i4 - i(b4 & 255));
    }

    @InlineOnly
    private static final long B(int i4, long j4) {
        return v0.i(v0.i(i4 & 4294967295L) - j4);
    }

    @InlineOnly
    private static final int C(int i4, int i5) {
        return i(i4 - i5);
    }

    @InlineOnly
    private static final int D(int i4, short s3) {
        return i(i4 - i(s3 & 65535));
    }

    @InlineOnly
    private static final byte E(int i4, byte b4) {
        return n0.i((byte) g1.e(i4, i(b4 & 255)));
    }

    @InlineOnly
    private static final long F(int i4, long j4) {
        return g1.i(v0.i(i4 & 4294967295L), j4);
    }

    @InlineOnly
    private static final int G(int i4, int i5) {
        return g1.e(i4, i5);
    }

    @InlineOnly
    private static final short H(int i4, short s3) {
        return b1.i((short) g1.e(i4, i(s3 & 65535)));
    }

    @InlineOnly
    private static final int K(int i4, int i5) {
        return i(i4 | i5);
    }

    @InlineOnly
    private static final int L(int i4, byte b4) {
        return i(i4 + i(b4 & 255));
    }

    @InlineOnly
    private static final long M(int i4, long j4) {
        return v0.i(v0.i(i4 & 4294967295L) + j4);
    }

    @InlineOnly
    private static final int N(int i4, int i5) {
        return i(i4 + i5);
    }

    @InlineOnly
    private static final int O(int i4, short s3) {
        return i(i4 + i(s3 & 65535));
    }

    @InlineOnly
    private static final kotlin.ranges.t P(int i4, int i5) {
        return new kotlin.ranges.t(i4, i5, null);
    }

    @InlineOnly
    private static final int Q(int i4, byte b4) {
        return g1.e(i4, i(b4 & 255));
    }

    @InlineOnly
    private static final long R(int i4, long j4) {
        return g1.i(v0.i(i4 & 4294967295L), j4);
    }

    @InlineOnly
    private static final int S(int i4, int i5) {
        return g1.e(i4, i5);
    }

    @InlineOnly
    private static final int T(int i4, short s3) {
        return g1.e(i4, i(s3 & 65535));
    }

    @InlineOnly
    private static final int U(int i4, int i5) {
        return i(i4 << i5);
    }

    @InlineOnly
    private static final int V(int i4, int i5) {
        return i(i4 >>> i5);
    }

    @InlineOnly
    private static final int W(int i4, byte b4) {
        return i(i4 * i(b4 & 255));
    }

    @InlineOnly
    private static final long X(int i4, long j4) {
        return v0.i(v0.i(i4 & 4294967295L) * j4);
    }

    @InlineOnly
    private static final int Y(int i4, int i5) {
        return i(i4 * i5);
    }

    @InlineOnly
    private static final int Z(int i4, short s3) {
        return i(i4 * i(s3 & 65535));
    }

    @InlineOnly
    private static final int a(int i4, int i5) {
        return i(i4 & i5);
    }

    @InlineOnly
    private static final byte a0(int i4) {
        return (byte) i4;
    }

    public static final /* synthetic */ r0 b(int i4) {
        return new r0(i4);
    }

    @InlineOnly
    private static final double b0(int i4) {
        return g1.f(i4);
    }

    @InlineOnly
    private static final float c0(int i4) {
        return (float) g1.f(i4);
    }

    @InlineOnly
    private static final int d(int i4, byte b4) {
        return g1.c(i4, i(b4 & 255));
    }

    @InlineOnly
    private static final int d0(int i4) {
        return i4;
    }

    @InlineOnly
    private static final int e(int i4, long j4) {
        return g1.g(v0.i(i4 & 4294967295L), j4);
    }

    @InlineOnly
    private static final long e0(int i4) {
        return i4 & 4294967295L;
    }

    @InlineOnly
    private int f(int i4) {
        return g1.c(l0(), i4);
    }

    @InlineOnly
    private static final short f0(int i4) {
        return (short) i4;
    }

    @InlineOnly
    private static int g(int i4, int i5) {
        return g1.c(i4, i5);
    }

    @NotNull
    public static String g0(int i4) {
        return String.valueOf(i4 & 4294967295L);
    }

    @InlineOnly
    private static final int h(int i4, short s3) {
        return g1.c(i4, i(s3 & 65535));
    }

    @InlineOnly
    private static final byte h0(int i4) {
        return n0.i((byte) i4);
    }

    @PublishedApi
    public static int i(int i4) {
        return i4;
    }

    @InlineOnly
    private static final int i0(int i4) {
        return i4;
    }

    @InlineOnly
    private static final int j(int i4) {
        return i(i4 - 1);
    }

    @InlineOnly
    private static final long j0(int i4) {
        return v0.i(i4 & 4294967295L);
    }

    @InlineOnly
    private static final int k(int i4, byte b4) {
        return g1.d(i4, i(b4 & 255));
    }

    @InlineOnly
    private static final short k0(int i4) {
        return b1.i((short) i4);
    }

    @InlineOnly
    private static final long l(int i4, long j4) {
        return g1.h(v0.i(i4 & 4294967295L), j4);
    }

    @InlineOnly
    private static final int m(int i4, int i5) {
        return g1.d(i4, i5);
    }

    @InlineOnly
    private static final int m0(int i4, int i5) {
        return i(i4 ^ i5);
    }

    @InlineOnly
    private static final int n(int i4, short s3) {
        return g1.d(i4, i(s3 & 65535));
    }

    public static boolean o(int i4, Object obj) {
        return (obj instanceof r0) && i4 == ((r0) obj).l0();
    }

    public static final boolean p(int i4, int i5) {
        return i4 == i5;
    }

    @InlineOnly
    private static final int q(int i4, byte b4) {
        return g1.d(i4, i(b4 & 255));
    }

    @InlineOnly
    private static final long r(int i4, long j4) {
        return g1.h(v0.i(i4 & 4294967295L), j4);
    }

    @InlineOnly
    private static final int s(int i4, int i5) {
        return g1.d(i4, i5);
    }

    @InlineOnly
    private static final int t(int i4, short s3) {
        return g1.d(i4, i(s3 & 65535));
    }

    @PublishedApi
    public static /* synthetic */ void u() {
    }

    public static int w(int i4) {
        return i4;
    }

    @InlineOnly
    private static final int y(int i4) {
        return i(i4 + 1);
    }

    @InlineOnly
    private static final int z(int i4) {
        return i(i4 ^ (-1));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(r0 r0Var) {
        return g1.c(l0(), r0Var.l0());
    }

    public boolean equals(Object obj) {
        return o(this.f55763a, obj);
    }

    public int hashCode() {
        return w(this.f55763a);
    }

    public final /* synthetic */ int l0() {
        return this.f55763a;
    }

    @NotNull
    public String toString() {
        return g0(this.f55763a);
    }
}
