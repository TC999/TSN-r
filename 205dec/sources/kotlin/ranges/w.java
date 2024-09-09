package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.g1;
import kotlin.v0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ULongRange.kt */
@SinceKotlin(version = "1.5")
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B\u001a\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0019"}, d2 = {"Lkotlin/ranges/w;", "Lkotlin/ranges/u;", "Lkotlin/ranges/g;", "Lkotlin/v0;", "value", "", "m", "(J)Z", "isEmpty", "", "other", "equals", "", "hashCode", "", "toString", "o", "()J", CampaignEx.JSON_NATIVE_VIDEO_START, "n", "endInclusive", "<init>", "(JJLkotlin/jvm/internal/u;)V", "e", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w extends u implements g<v0> {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f55830e = new a(null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final w f55831f = new w(-1, 0, null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ULongRange.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkotlin/ranges/w$a;", "", "Lkotlin/ranges/w;", "EMPTY", "Lkotlin/ranges/w;", "a", "()Lkotlin/ranges/w;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final w a() {
            return w.f55831f;
        }
    }

    private w(long j4, long j5) {
        super(j4, j5, 1L, null);
    }

    public /* synthetic */ w(long j4, long j5, kotlin.jvm.internal.u uVar) {
        this(j4, j5);
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean contains(v0 v0Var) {
        return m(v0Var.l0());
    }

    @Override // kotlin.ranges.u
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof w) {
            if (!isEmpty() || !((w) obj).isEmpty()) {
                w wVar = (w) obj;
                if (c() != wVar.c() || g() != wVar.g()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ v0 getEndInclusive() {
        return v0.b(n());
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ v0 getStart() {
        return v0.b(o());
    }

    @Override // kotlin.ranges.u
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return ((int) v0.i(g() ^ v0.i(g() >>> 32))) + (((int) v0.i(c() ^ v0.i(c() >>> 32))) * 31);
    }

    @Override // kotlin.ranges.u, kotlin.ranges.g
    public boolean isEmpty() {
        return g1.g(c(), g()) > 0;
    }

    public boolean m(long j4) {
        return g1.g(c(), j4) <= 0 && g1.g(j4, g()) <= 0;
    }

    public long n() {
        return g();
    }

    public long o() {
        return c();
    }

    @Override // kotlin.ranges.u
    @NotNull
    public String toString() {
        return ((Object) v0.g0(c())) + ".." + ((Object) v0.g0(g()));
    }
}
