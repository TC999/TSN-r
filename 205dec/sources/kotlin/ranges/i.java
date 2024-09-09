package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.collections.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Progressions.kt */
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0016\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB!\b\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\u00a8\u0006\u001c"}, d2 = {"Lkotlin/ranges/i;", "", "", "Lkotlin/collections/r0;", "l", "", "isEmpty", "", "other", "equals", "hashCode", "", "toString", "a", "I", "c", "()I", "first", "b", "g", "last", "k", "step", CampaignEx.JSON_NATIVE_VIDEO_START, "endInclusive", "<init>", "(III)V", "d", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class i implements Iterable<Integer>, e2.a {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f55792d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f55793a;

    /* renamed from: b  reason: collision with root package name */
    private final int f55794b;

    /* renamed from: c  reason: collision with root package name */
    private final int f55795c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Progressions.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lkotlin/ranges/i$a;", "", "", "rangeStart", "rangeEnd", "step", "Lkotlin/ranges/i;", "a", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final i a(int i4, int i5, int i6) {
            return new i(i4, i5, i6);
        }
    }

    public i(int i4, int i5, int i6) {
        if (i6 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i6 != Integer.MIN_VALUE) {
            this.f55793a = i4;
            this.f55794b = kotlin.internal.c.c(i4, i5, i6);
            this.f55795c = i6;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public final int c() {
        return this.f55793a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (this.f55793a != iVar.f55793a || this.f55794b != iVar.f55794b || this.f55795c != iVar.f55795c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f55794b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f55793a * 31) + this.f55794b) * 31) + this.f55795c;
    }

    public boolean isEmpty() {
        if (this.f55795c > 0) {
            if (this.f55793a > this.f55794b) {
                return true;
            }
        } else if (this.f55793a < this.f55794b) {
            return true;
        }
        return false;
    }

    public final int k() {
        return this.f55795c;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: l */
    public r0 iterator() {
        return new j(this.f55793a, this.f55794b, this.f55795c);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i4;
        if (this.f55795c > 0) {
            sb = new StringBuilder();
            sb.append(this.f55793a);
            sb.append("..");
            sb.append(this.f55794b);
            sb.append(" step ");
            i4 = this.f55795c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f55793a);
            sb.append(" downTo ");
            sb.append(this.f55794b);
            sb.append(" step ");
            i4 = -this.f55795c;
        }
        sb.append(i4);
        return sb.toString();
    }
}
