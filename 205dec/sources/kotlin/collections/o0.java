package kotlin.collections;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: IndexedValue.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0004\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010\u0005\u001a\u00028\u0000H\u00c6\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006J*\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00028\u0000H\u00c6\u0001\u00a2\u0006\u0004\b\t\u0010\nJ\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\t\u0010\r\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u0007\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006\u00a8\u0006\u0018"}, d2 = {"Lkotlin/collections/o0;", "T", "", "", "a", "b", "()Ljava/lang/Object;", "index", "value", "c", "(ILjava/lang/Object;)Lkotlin/collections/o0;", "", "toString", "hashCode", "other", "", "equals", "I", "e", "()I", "Ljava/lang/Object;", "f", "<init>", "(ILjava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o0<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f55387a;

    /* renamed from: b  reason: collision with root package name */
    private final T f55388b;

    public o0(int i4, T t3) {
        this.f55387a = i4;
        this.f55388b = t3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ o0 d(o0 o0Var, int i4, Object obj, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            i4 = o0Var.f55387a;
        }
        if ((i5 & 2) != 0) {
            obj = o0Var.f55388b;
        }
        return o0Var.c(i4, obj);
    }

    public final int a() {
        return this.f55387a;
    }

    public final T b() {
        return this.f55388b;
    }

    @NotNull
    public final o0<T> c(int i4, T t3) {
        return new o0<>(i4, t3);
    }

    public final int e() {
        return this.f55387a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o0) {
            o0 o0Var = (o0) obj;
            return this.f55387a == o0Var.f55387a && kotlin.jvm.internal.f0.g(this.f55388b, o0Var.f55388b);
        }
        return false;
    }

    public final T f() {
        return this.f55388b;
    }

    public int hashCode() {
        int i4 = this.f55387a * 31;
        T t3 = this.f55388b;
        return i4 + (t3 == null ? 0 : t3.hashCode());
    }

    @NotNull
    public String toString() {
        return "IndexedValue(index=" + this.f55387a + ", value=" + this.f55388b + ')';
    }
}
