package kotlin;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmInline;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ULong.kt */
@SinceKotlin(version = "1.5")
@Metadata(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 _2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001:B\u0014\b\u0001\u0012\u0006\u0010]\u001a\u00020F\u00f8\u0001\u0000\u00a2\u0006\u0004\b^\u00102J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0097\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0010J\u001b\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0012J\u001b\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u0014J\u001b\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001a\u0010\u0016J\u001b\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0010J\u001b\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u0012J\u001b\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u0014J\u001b\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001e\u0010\u0016J\u001b\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001f\u0010\u0010J\u001b\u0010 \u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010\u0012J\u001b\u0010!\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b!\u0010\u0014J\u001b\u0010\"\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b\"\u0010\u0016J\u001b\u0010#\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b#\u0010\u0010J\u001b\u0010$\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010\u0012J\u001b\u0010%\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b%\u0010\u0014J\u001b\u0010&\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b&\u0010\u0016J\u001b\u0010'\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0010J\u001b\u0010(\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010\u0012J\u001b\u0010)\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b)\u0010\u0014J\u001b\u0010*\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010\u0016J\u001b\u0010+\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b+\u0010,J\u001b\u0010-\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b-\u0010.J\u001b\u0010/\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b/\u0010\fJ\u001b\u00100\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b0\u0010\u0016J\u0016\u00101\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b1\u00102J\u0016\u00103\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b3\u00102J\u001b\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\n\u00f8\u0001\u0000\u00a2\u0006\u0004\b5\u00106J\u001e\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0004H\u0087\f\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b8\u0010\u0014J\u001e\u00109\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0004H\u0087\f\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b9\u0010\u0014J\u001b\u0010:\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b:\u0010\u0016J\u001b\u0010;\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b;\u0010\u0016J\u001b\u0010<\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\f\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010\u0016J\u0016\u0010=\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b=\u00102J\u0010\u0010?\u001a\u00020>H\u0087\b\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010B\u001a\u00020AH\u0087\b\u00a2\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0004H\u0087\b\u00a2\u0006\u0004\bD\u0010EJ\u0010\u0010G\u001a\u00020FH\u0087\b\u00a2\u0006\u0004\bG\u00102J\u0016\u0010H\u001a\u00020\u0002H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bH\u0010@J\u0016\u0010I\u001a\u00020\u0007H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bI\u0010CJ\u0016\u0010J\u001a\u00020\nH\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bJ\u0010EJ\u0016\u0010K\u001a\u00020\u0000H\u0087\b\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bK\u00102J\u0010\u0010M\u001a\u00020LH\u0087\b\u00a2\u0006\u0004\bM\u0010NJ\u0010\u0010P\u001a\u00020OH\u0087\b\u00a2\u0006\u0004\bP\u0010QJ\u000f\u0010S\u001a\u00020RH\u0016\u00a2\u0006\u0004\bS\u0010TJ\u0010\u0010U\u001a\u00020\u0004H\u00d6\u0001\u00a2\u0006\u0004\bU\u0010EJ\u001a\u0010X\u001a\u00020W2\b\u0010\u0003\u001a\u0004\u0018\u00010VH\u00d6\u0003\u00a2\u0006\u0004\bX\u0010YR\u001a\u0010]\u001a\u00020F8\u0000X\u0081\u0004\u00a2\u0006\f\n\u0004\b:\u0010Z\u0012\u0004\b[\u0010\\\u0088\u0001]\u0092\u0001\u00020F\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006`"}, d2 = {"Lkotlin/v0;", "", "Lkotlin/n0;", "other", "", "d", "(JB)I", "Lkotlin/b1;", "h", "(JS)I", "Lkotlin/r0;", "g", "(JI)I", "f", "(JJ)I", "L", "(JB)J", "O", "(JS)J", "N", "(JI)J", "M", "(JJ)J", "A", "D", "C", "B", "W", "Z", "Y", "X", "k", "n", "m", "l", "Q", "T", "S", "R", CampaignEx.JSON_KEY_AD_Q, "t", "s", "r", "E", "(JB)B", "H", "(JS)S", "G", "F", "y", "(J)J", "j", "Lkotlin/ranges/w;", "P", "(JJ)Lkotlin/ranges/w;", "bitCount", "U", "V", "a", "K", "m0", "z", "", "a0", "(J)B", "", "f0", "(J)S", "d0", "(J)I", "", "e0", "h0", "k0", "i0", "j0", "", "c0", "(J)F", "", "b0", "(J)D", "", "g0", "(J)Ljava/lang/String;", "w", "", "", "o", "(JLjava/lang/Object;)Z", "J", "getData$annotations", "()V", "data", "i", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v0 implements Comparable<v0> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f59019b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    public static final long f59020c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final long f59021d = -1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f59022e = 8;

    /* renamed from: f  reason: collision with root package name */
    public static final int f59023f = 64;

    /* renamed from: a  reason: collision with root package name */
    private final long f59024a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ULong.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\f"}, d2 = {"Lkotlin/v0$a;", "", "Lkotlin/v0;", "MAX_VALUE", "J", "MIN_VALUE", "", "SIZE_BITS", "I", "SIZE_BYTES", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    @PublishedApi
    private /* synthetic */ v0(long j4) {
        this.f59024a = j4;
    }

    @InlineOnly
    private static final long A(long j4, byte b4) {
        return i(j4 - i(b4 & 255));
    }

    @InlineOnly
    private static final long B(long j4, long j5) {
        return i(j4 - j5);
    }

    @InlineOnly
    private static final long C(long j4, int i4) {
        return i(j4 - i(i4 & 4294967295L));
    }

    @InlineOnly
    private static final long D(long j4, short s3) {
        return i(j4 - i(s3 & 65535));
    }

    @InlineOnly
    private static final byte E(long j4, byte b4) {
        return n0.i((byte) g1.i(j4, i(b4 & 255)));
    }

    @InlineOnly
    private static final long F(long j4, long j5) {
        return g1.i(j4, j5);
    }

    @InlineOnly
    private static final int G(long j4, int i4) {
        return r0.i((int) g1.i(j4, i(i4 & 4294967295L)));
    }

    @InlineOnly
    private static final short H(long j4, short s3) {
        return b1.i((short) g1.i(j4, i(s3 & 65535)));
    }

    @InlineOnly
    private static final long K(long j4, long j5) {
        return i(j4 | j5);
    }

    @InlineOnly
    private static final long L(long j4, byte b4) {
        return i(j4 + i(b4 & 255));
    }

    @InlineOnly
    private static final long M(long j4, long j5) {
        return i(j4 + j5);
    }

    @InlineOnly
    private static final long N(long j4, int i4) {
        return i(j4 + i(i4 & 4294967295L));
    }

    @InlineOnly
    private static final long O(long j4, short s3) {
        return i(j4 + i(s3 & 65535));
    }

    @InlineOnly
    private static final kotlin.ranges.w P(long j4, long j5) {
        return new kotlin.ranges.w(j4, j5, null);
    }

    @InlineOnly
    private static final long Q(long j4, byte b4) {
        return g1.i(j4, i(b4 & 255));
    }

    @InlineOnly
    private static final long R(long j4, long j5) {
        return g1.i(j4, j5);
    }

    @InlineOnly
    private static final long S(long j4, int i4) {
        return g1.i(j4, i(i4 & 4294967295L));
    }

    @InlineOnly
    private static final long T(long j4, short s3) {
        return g1.i(j4, i(s3 & 65535));
    }

    @InlineOnly
    private static final long U(long j4, int i4) {
        return i(j4 << i4);
    }

    @InlineOnly
    private static final long V(long j4, int i4) {
        return i(j4 >>> i4);
    }

    @InlineOnly
    private static final long W(long j4, byte b4) {
        return i(j4 * i(b4 & 255));
    }

    @InlineOnly
    private static final long X(long j4, long j5) {
        return i(j4 * j5);
    }

    @InlineOnly
    private static final long Y(long j4, int i4) {
        return i(j4 * i(i4 & 4294967295L));
    }

    @InlineOnly
    private static final long Z(long j4, short s3) {
        return i(j4 * i(s3 & 65535));
    }

    @InlineOnly
    private static final long a(long j4, long j5) {
        return i(j4 & j5);
    }

    @InlineOnly
    private static final byte a0(long j4) {
        return (byte) j4;
    }

    public static final /* synthetic */ v0 b(long j4) {
        return new v0(j4);
    }

    @InlineOnly
    private static final double b0(long j4) {
        return g1.j(j4);
    }

    @InlineOnly
    private static final float c0(long j4) {
        return (float) g1.j(j4);
    }

    @InlineOnly
    private static final int d(long j4, byte b4) {
        return g1.g(j4, i(b4 & 255));
    }

    @InlineOnly
    private static final int d0(long j4) {
        return (int) j4;
    }

    @InlineOnly
    private int e(long j4) {
        return g1.g(l0(), j4);
    }

    @InlineOnly
    private static final long e0(long j4) {
        return j4;
    }

    @InlineOnly
    private static int f(long j4, long j5) {
        return g1.g(j4, j5);
    }

    @InlineOnly
    private static final short f0(long j4) {
        return (short) j4;
    }

    @InlineOnly
    private static final int g(long j4, int i4) {
        return g1.g(j4, i(i4 & 4294967295L));
    }

    @NotNull
    public static String g0(long j4) {
        return g1.k(j4);
    }

    @InlineOnly
    private static final int h(long j4, short s3) {
        return g1.g(j4, i(s3 & 65535));
    }

    @InlineOnly
    private static final byte h0(long j4) {
        return n0.i((byte) j4);
    }

    @PublishedApi
    public static long i(long j4) {
        return j4;
    }

    @InlineOnly
    private static final int i0(long j4) {
        return r0.i((int) j4);
    }

    @InlineOnly
    private static final long j(long j4) {
        return i(j4 - 1);
    }

    @InlineOnly
    private static final long j0(long j4) {
        return j4;
    }

    @InlineOnly
    private static final long k(long j4, byte b4) {
        return g1.h(j4, i(b4 & 255));
    }

    @InlineOnly
    private static final short k0(long j4) {
        return b1.i((short) j4);
    }

    @InlineOnly
    private static final long l(long j4, long j5) {
        return g1.h(j4, j5);
    }

    @InlineOnly
    private static final long m(long j4, int i4) {
        return g1.h(j4, i(i4 & 4294967295L));
    }

    @InlineOnly
    private static final long m0(long j4, long j5) {
        return i(j4 ^ j5);
    }

    @InlineOnly
    private static final long n(long j4, short s3) {
        return g1.h(j4, i(s3 & 65535));
    }

    public static boolean o(long j4, Object obj) {
        return (obj instanceof v0) && j4 == ((v0) obj).l0();
    }

    public static final boolean p(long j4, long j5) {
        return j4 == j5;
    }

    @InlineOnly
    private static final long q(long j4, byte b4) {
        return g1.h(j4, i(b4 & 255));
    }

    @InlineOnly
    private static final long r(long j4, long j5) {
        return g1.h(j4, j5);
    }

    @InlineOnly
    private static final long s(long j4, int i4) {
        return g1.h(j4, i(i4 & 4294967295L));
    }

    @InlineOnly
    private static final long t(long j4, short s3) {
        return g1.h(j4, i(s3 & 65535));
    }

    @PublishedApi
    public static /* synthetic */ void u() {
    }

    public static int w(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    @InlineOnly
    private static final long y(long j4) {
        return i(j4 + 1);
    }

    @InlineOnly
    private static final long z(long j4) {
        return i(j4 ^ (-1));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(v0 v0Var) {
        return g1.g(l0(), v0Var.l0());
    }

    public boolean equals(Object obj) {
        return o(this.f59024a, obj);
    }

    public int hashCode() {
        return w(this.f59024a);
    }

    public final /* synthetic */ long l0() {
        return this.f59024a;
    }

    @NotNull
    public String toString() {
        return g0(this.f59024a);
    }
}
