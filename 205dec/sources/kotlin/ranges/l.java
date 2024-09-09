package kotlin.ranges;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.collections.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Progressions.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0016\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000eB!\b\u0000\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016R\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lkotlin/ranges/l;", "", "", "Lkotlin/collections/s0;", "l", "", "isEmpty", "", "other", "equals", "", "hashCode", "", "toString", "a", "J", "c", "()J", "first", "b", "g", "last", "k", "step", CampaignEx.JSON_NATIVE_VIDEO_START, "endInclusive", "<init>", "(JJJ)V", "d", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class l implements Iterable<Long>, e2.a {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f55802d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final long f55803a;

    /* renamed from: b  reason: collision with root package name */
    private final long f55804b;

    /* renamed from: c  reason: collision with root package name */
    private final long f55805c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Progressions.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002\u00a8\u0006\n"}, d2 = {"Lkotlin/ranges/l$a;", "", "", "rangeStart", "rangeEnd", "step", "Lkotlin/ranges/l;", "a", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final l a(long j4, long j5, long j6) {
            return new l(j4, j5, j6);
        }
    }

    public l(long j4, long j5, long j6) {
        if (j6 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j6 != Long.MIN_VALUE) {
            this.f55803a = j4;
            this.f55804b = kotlin.internal.c.d(j4, j5, j6);
            this.f55805c = j6;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
    }

    public final long c() {
        return this.f55803a;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof l) {
            if (!isEmpty() || !((l) obj).isEmpty()) {
                l lVar = (l) obj;
                if (this.f55803a != lVar.f55803a || this.f55804b != lVar.f55804b || this.f55805c != lVar.f55805c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long g() {
        return this.f55804b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        long j4 = 31;
        long j5 = this.f55803a;
        long j6 = this.f55804b;
        long j7 = j4 * (((j5 ^ (j5 >>> 32)) * j4) + (j6 ^ (j6 >>> 32)));
        long j8 = this.f55805c;
        return (int) (j7 + (j8 ^ (j8 >>> 32)));
    }

    public boolean isEmpty() {
        int i4 = (this.f55805c > 0L ? 1 : (this.f55805c == 0L ? 0 : -1));
        long j4 = this.f55803a;
        long j5 = this.f55804b;
        if (i4 > 0) {
            if (j4 > j5) {
                return true;
            }
        } else if (j4 < j5) {
            return true;
        }
        return false;
    }

    public final long k() {
        return this.f55805c;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: l */
    public s0 iterator() {
        return new m(this.f55803a, this.f55804b, this.f55805c);
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        long j4;
        if (this.f55805c > 0) {
            sb = new StringBuilder();
            sb.append(this.f55803a);
            sb.append("..");
            sb.append(this.f55804b);
            sb.append(" step ");
            j4 = this.f55805c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f55803a);
            sb.append(" downTo ");
            sb.append(this.f55804b);
            sb.append(" step ");
            j4 = -this.f55805c;
        }
        sb.append(j4);
        return sb.toString();
    }
}
