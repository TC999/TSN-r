package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Ranges.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0016B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0010\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00038VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lkotlin/ranges/k;", "Lkotlin/ranges/i;", "Lkotlin/ranges/g;", "", "value", "", "n", "isEmpty", "", "other", "equals", "hashCode", "", "toString", "p", "()Ljava/lang/Integer;", CampaignEx.JSON_NATIVE_VIDEO_START, "o", "endInclusive", "<init>", "(II)V", "e", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k extends i implements g<Integer> {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final a f55800e = new a(null);
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final k f55801f = new k(1, 0);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Ranges.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkotlin/ranges/k$a;", "", "Lkotlin/ranges/k;", "EMPTY", "Lkotlin/ranges/k;", "a", "()Lkotlin/ranges/k;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final k a() {
            return k.f55801f;
        }
    }

    public k(int i4, int i5) {
        super(i4, i5, 1);
    }

    @Override // kotlin.ranges.g
    public /* bridge */ /* synthetic */ boolean contains(Integer num) {
        return n(num.intValue());
    }

    @Override // kotlin.ranges.i
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof k) {
            if (!isEmpty() || !((k) obj).isEmpty()) {
                k kVar = (k) obj;
                if (c() != kVar.c() || g() != kVar.g()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.ranges.i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (c() * 31) + g();
    }

    @Override // kotlin.ranges.i, kotlin.ranges.g
    public boolean isEmpty() {
        return c() > g();
    }

    public boolean n(int i4) {
        return c() <= i4 && i4 <= g();
    }

    @Override // kotlin.ranges.g
    @NotNull
    /* renamed from: o */
    public Integer getEndInclusive() {
        return Integer.valueOf(g());
    }

    @Override // kotlin.ranges.g
    @NotNull
    /* renamed from: p */
    public Integer getStart() {
        return Integer.valueOf(c());
    }

    @Override // kotlin.ranges.i
    @NotNull
    public String toString() {
        return c() + ".." + g();
    }
}
