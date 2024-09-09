package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: MapBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001b\b\u0000\u0012\u0010\u0010\u0019\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0014\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\bJ\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0011\u0010\bJ\u0016\u0010\u0012\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u0016\u0010\u0013\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016R!\u0010\u0019\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lkotlin/collections/builders/g;", "V", "", "Lkotlin/collections/f;", "", "isEmpty", "element", "contains", "(Ljava/lang/Object;)Z", "add", "", "elements", "addAll", "Lkotlin/f1;", "clear", "", "iterator", "remove", "removeAll", "retainAll", "Lkotlin/collections/builders/d;", "a", "Lkotlin/collections/builders/d;", "c", "()Lkotlin/collections/builders/d;", "backing", "", "()I", "size", "<init>", "(Lkotlin/collections/builders/d;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class g<V> extends kotlin.collections.f<V> implements Collection<V>, m1.b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final d<?, V> f55287a;

    public g(@NotNull d<?, V> backing) {
        f0.p(backing, "backing");
        this.f55287a = backing;
    }

    public int a() {
        return this.f55287a.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends V> elements) {
        f0.p(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @NotNull
    public final d<?, V> c() {
        return this.f55287a;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f55287a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f55287a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f55287a.isEmpty();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<V> iterator() {
        return this.f55287a.P();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        return this.f55287a.O(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f55287a.o();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f55287a.o();
        return super.retainAll(elements);
    }
}
