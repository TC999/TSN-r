package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: measureTime.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001a\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\u0006\u0010\t\u001a\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\b\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001d\u0010\t\u001a\u00020\u00058\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0019"}, d2 = {"Lkotlin/time/q;", "T", "", "a", "()Ljava/lang/Object;", "Lkotlin/time/d;", "b", "()J", "value", "duration", "c", "(Ljava/lang/Object;J)Lkotlin/time/q;", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "f", "J", "e", "<init>", "(Ljava/lang/Object;JLkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@ExperimentalTime
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class q<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f59017a;

    /* renamed from: b  reason: collision with root package name */
    private final long f59018b;

    private q(T t3, long j4) {
        this.f59017a = t3;
        this.f59018b = j4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ q d(q qVar, Object obj, long j4, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            obj = qVar.f59017a;
        }
        if ((i4 & 2) != 0) {
            j4 = qVar.f59018b;
        }
        return qVar.c(obj, j4);
    }

    public final T a() {
        return this.f59017a;
    }

    public final long b() {
        return this.f59018b;
    }

    @NotNull
    public final q<T> c(T t3, long j4) {
        return new q<>(t3, j4);
    }

    public final long e() {
        return this.f59018b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof q) {
                q qVar = (q) obj;
                return f0.g(this.f59017a, qVar.f59017a) && this.f59018b == qVar.f59018b;
            }
            return false;
        }
        return true;
    }

    public final T f() {
        return this.f59017a;
    }

    public int hashCode() {
        T t3 = this.f59017a;
        int hashCode = t3 != null ? t3.hashCode() : 0;
        long j4 = this.f59018b;
        return (hashCode * 31) + ((int) (j4 ^ (j4 >>> 32)));
    }

    @NotNull
    public String toString() {
        return "TimedValue(value=" + this.f59017a + ", duration=" + d.x0(this.f59018b) + ")";
    }

    public /* synthetic */ q(Object obj, long j4, u uVar) {
        this(obj, j4);
    }
}
