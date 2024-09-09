package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: measureTime.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001a\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\u0006\u0010\t\u001a\u00020\u0005\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u0005H\u00c6\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\u0005H\u00c6\u0001\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\b\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001d\u0010\t\u001a\u00020\u00058\u0006\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0019"}, d2 = {"Lkotlin/time/p;", "T", "", "a", "()Ljava/lang/Object;", "Lkotlin/time/d;", "b", "()J", "value", "duration", "c", "(Ljava/lang/Object;J)Lkotlin/time/p;", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/Object;", "f", "J", "e", "<init>", "(Ljava/lang/Object;JLkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalTime
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f59015a;

    /* renamed from: b  reason: collision with root package name */
    private final long f59016b;

    private p(T t3, long j4) {
        this.f59015a = t3;
        this.f59016b = j4;
    }

    public /* synthetic */ p(Object obj, long j4, u uVar) {
        this(obj, j4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ p d(p pVar, Object obj, long j4, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            obj = pVar.f59015a;
        }
        if ((i4 & 2) != 0) {
            j4 = pVar.f59016b;
        }
        return pVar.c(obj, j4);
    }

    public final T a() {
        return this.f59015a;
    }

    public final long b() {
        return this.f59016b;
    }

    @NotNull
    public final p<T> c(T t3, long j4) {
        return new p<>(t3, j4, null);
    }

    public final long e() {
        return this.f59016b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return f0.g(this.f59015a, pVar.f59015a) && d.o(this.f59016b, pVar.f59016b);
        }
        return false;
    }

    public final T f() {
        return this.f59015a;
    }

    public int hashCode() {
        T t3 = this.f59015a;
        return ((t3 == null ? 0 : t3.hashCode()) * 31) + d.a0(this.f59016b);
    }

    @NotNull
    public String toString() {
        return "TimedValue(value=" + this.f59015a + ", duration=" + ((Object) d.v0(this.f59016b)) + ')';
    }
}
