package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.WasExperimental;
import kotlin.g1;
import kotlin.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UIntRange.kt */
@SinceKotlin(version = "1.5")
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0018B\u001a\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001a\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\u00020\u00038VX\u0096\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011\u00f8\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0019"}, d2 = {"Lkotlin/ranges/t;", "Lkotlin/ranges/r;", "Lkotlin/ranges/g;", "Lkotlin/r0;", "value", "", "m", "(I)Z", "isEmpty", "", "other", "equals", "", "hashCode", "", "toString", "o", "()I", CampaignEx.JSON_NATIVE_VIDEO_START, "n", "endInclusive", "<init>", "(IILkotlin/jvm/internal/u;)V", "e", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t extends r implements g<r0> {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f55820e = new a(null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final t f55821f = new t(-1, 0, null);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: UIntRange.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkotlin/ranges/t$a;", "", "Lkotlin/ranges/t;", "EMPTY", "Lkotlin/ranges/t;", "a", "()Lkotlin/ranges/t;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final t a() {
            return t.f55821f;
        }
    }

    private t(int i4, int i5) {
        super(i4, i5, 1, null);
    }

    public /* synthetic */ t(int i4, int i5, kotlin.jvm.internal.u uVar) {
        this(i4, i5);
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean contains(r0 r0Var) {
        return m(r0Var.l0());
    }

    @Override // kotlin.ranges.r
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof t) {
            if (!isEmpty() || !((t) obj).isEmpty()) {
                t tVar = (t) obj;
                if (c() != tVar.c() || g() != tVar.g()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ r0 getEndInclusive() {
        return r0.b(n());
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ r0 getStart() {
        return r0.b(o());
    }

    @Override // kotlin.ranges.r
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (c() * 31) + g();
    }

    @Override // kotlin.ranges.r, kotlin.ranges.g
    public boolean isEmpty() {
        return g1.c(c(), g()) > 0;
    }

    public boolean m(int i4) {
        return g1.c(c(), i4) <= 0 && g1.c(i4, g()) <= 0;
    }

    public int n() {
        return g();
    }

    public int o() {
        return c();
    }

    @Override // kotlin.ranges.r
    @NotNull
    public String toString() {
        return ((Object) r0.g0(c())) + ".." + ((Object) r0.g0(g()));
    }
}
