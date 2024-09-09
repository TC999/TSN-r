package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Ranges.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u0014\u0010\u0011\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lkotlin/ranges/n;", "Lkotlin/ranges/l;", "Lkotlin/ranges/g;", "", "value", "", "n", "isEmpty", "", "other", "equals", "", "hashCode", "", "toString", "p", "()Ljava/lang/Long;", CampaignEx.JSON_NATIVE_VIDEO_START, "o", "endInclusive", "<init>", "(JJ)V", "e", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n extends l implements g<Long> {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f55810e = new a(null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final n f55811f = new n(1, 0);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Ranges.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkotlin/ranges/n$a;", "", "Lkotlin/ranges/n;", "EMPTY", "Lkotlin/ranges/n;", "a", "()Lkotlin/ranges/n;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final n a() {
            return n.f55811f;
        }
    }

    public n(long j4, long j5) {
        super(j4, j5, 1L);
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean contains(Long l4) {
        return n(l4.longValue());
    }

    @Override // kotlin.ranges.l
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof n) {
            if (!isEmpty() || !((n) obj).isEmpty()) {
                n nVar = (n) obj;
                if (c() != nVar.c() || g() != nVar.g()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.l
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (c() ^ (c() >>> 32))) + (g() ^ (g() >>> 32)));
    }

    @Override // kotlin.ranges.l, kotlin.ranges.g
    public boolean isEmpty() {
        return c() > g();
    }

    public boolean n(long j4) {
        return c() <= j4 && j4 <= g();
    }

    @Override // kotlin.ranges.g
    @NotNull
    /* renamed from: o */
    public Long getEndInclusive() {
        return Long.valueOf(g());
    }

    @Override // kotlin.ranges.g
    @NotNull
    /* renamed from: p */
    public Long getStart() {
        return Long.valueOf(c());
    }

    @Override // kotlin.ranges.l
    @NotNull
    public String toString() {
        return c() + ".." + g();
    }
}
