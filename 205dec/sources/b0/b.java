package b0;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6329136.dex
 */
/* compiled from: CountDistanceTime.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J'\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013\u00a8\u0006\u0018"}, d2 = {"Lb0/b;", "", "", "a", "b", "c", "count", "distance", "time", "d", "", "toString", "", "hashCode", "other", "", "equals", "J", "f", "()J", "g", "h", "<init>", "(JJJ)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final long f242a;

    /* renamed from: b  reason: collision with root package name */
    private final long f243b;

    /* renamed from: c  reason: collision with root package name */
    private final long f244c;

    public b(long j4, long j5, long j6) {
        this.f242a = j4;
        this.f243b = j5;
        this.f244c = j6;
    }

    public static /* synthetic */ b e(b bVar, long j4, long j5, long j6, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = bVar.f242a;
        }
        long j7 = j4;
        if ((i4 & 2) != 0) {
            j5 = bVar.f243b;
        }
        long j8 = j5;
        if ((i4 & 4) != 0) {
            j6 = bVar.f244c;
        }
        return bVar.d(j7, j8, j6);
    }

    public final long a() {
        return this.f242a;
    }

    public final long b() {
        return this.f243b;
    }

    public final long c() {
        return this.f244c;
    }

    @NotNull
    public final b d(long j4, long j5, long j6) {
        return new b(j4, j5, j6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.f242a == bVar.f242a && this.f243b == bVar.f243b && this.f244c == bVar.f244c;
        }
        return false;
    }

    public final long f() {
        return this.f242a;
    }

    public final long g() {
        return this.f243b;
    }

    public final long h() {
        return this.f244c;
    }

    public int hashCode() {
        return (((a.a(this.f242a) * 31) + a.a(this.f243b)) * 31) + a.a(this.f244c);
    }

    @NotNull
    public String toString() {
        return "CountDistanceTime(count=" + this.f242a + ", distance=" + this.f243b + ", time=" + this.f244c + ')';
    }
}
