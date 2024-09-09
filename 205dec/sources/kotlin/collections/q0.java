package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Iterators.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0005\u001a\u00020\u0004H\u0086\u0002J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlin/collections/q0;", "T", "", "Lkotlin/collections/o0;", "", "hasNext", "a", "Ljava/util/Iterator;", "iterator", "", "b", "I", "index", "<init>", "(Ljava/util/Iterator;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q0<T> implements Iterator<o0<? extends T>>, e2.a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Iterator<T> f55448a;

    /* renamed from: b  reason: collision with root package name */
    private int f55449b;

    /* JADX WARN: Multi-variable type inference failed */
    public q0(@NotNull Iterator<? extends T> iterator) {
        kotlin.jvm.internal.f0.p(iterator, "iterator");
        this.f55448a = iterator;
    }

    @Override // java.util.Iterator
    @NotNull
    /* renamed from: a */
    public final o0<T> next() {
        int i4 = this.f55449b;
        this.f55449b = i4 + 1;
        if (i4 < 0) {
            CollectionsKt__CollectionsKt.X();
        }
        return new o0<>(i4, this.f55448a.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f55448a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
