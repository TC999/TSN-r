package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Iterables.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0004H\u0096\u0002\u00a8\u0006\n"}, d2 = {"Lkotlin/collections/p0;", "T", "", "Lkotlin/collections/o0;", "", "iterator", "Lkotlin/Function0;", "iteratorFactory", "<init>", "(Ld2/a;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p0<T> implements Iterable<o0<? extends T>>, e2.a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final d2.a<Iterator<T>> f55418a;

    /* JADX WARN: Multi-variable type inference failed */
    public p0(@NotNull d2.a<? extends Iterator<? extends T>> iteratorFactory) {
        kotlin.jvm.internal.f0.p(iteratorFactory, "iteratorFactory");
        this.f55418a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<o0<T>> iterator() {
        return new q0(this.f55418a.invoke());
    }
}
