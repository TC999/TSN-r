package kotlin;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: LazyJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B!\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0012\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lkotlin/j0;", "T", "Lkotlin/p;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "isInitialized", "", "toString", "b", "Ljava/lang/Object;", "_value", "c", "lock", "getValue", "()Ljava/lang/Object;", "value", "Lkotlin/Function0;", "initializer", "<init>", "(Ld2/a;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class j0<T> implements p<T>, Serializable {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private d2.a<? extends T> f55603a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f55604b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Object f55605c;

    public j0(@NotNull d2.a<? extends T> initializer, @Nullable Object obj) {
        kotlin.jvm.internal.f0.p(initializer, "initializer");
        this.f55603a = initializer;
        this.f55604b = z0.f59028a;
        this.f55605c = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.p
    public T getValue() {
        T t3;
        T t4 = (T) this.f55604b;
        z0 z0Var = z0.f59028a;
        if (t4 != z0Var) {
            return t4;
        }
        synchronized (this.f55605c) {
            t3 = (T) this.f55604b;
            if (t3 == z0Var) {
                d2.a<? extends T> aVar = this.f55603a;
                kotlin.jvm.internal.f0.m(aVar);
                t3 = aVar.invoke();
                this.f55604b = t3;
                this.f55603a = null;
            }
        }
        return t3;
    }

    @Override // kotlin.p
    public boolean isInitialized() {
        return this.f55604b != z0.f59028a;
    }

    @NotNull
    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ j0(d2.a aVar, Object obj, int i4, kotlin.jvm.internal.u uVar) {
        this(aVar, (i4 & 2) != 0 ? null : obj);
    }
}
