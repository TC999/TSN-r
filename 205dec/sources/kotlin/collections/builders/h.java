package kotlin.collections.builders;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.i;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: SetBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001b\b\u0000\u0012\u0010\u0010\u0019\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eB\t\b\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001a\u00a2\u0006\u0004\b\u001d\u0010!J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0016J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0016\u0010\u0014\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0016\u0010\u0015\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016R\u001e\u0010\u0019\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u001b\u00a8\u0006\""}, d2 = {"Lkotlin/collections/builders/h;", "E", "", "Lkotlin/collections/i;", "", "c", "", "isEmpty", "element", "contains", "(Ljava/lang/Object;)Z", "Lkotlin/f1;", "clear", "add", "remove", "", "iterator", "", "elements", "addAll", "removeAll", "retainAll", "Lkotlin/collections/builders/d;", "a", "Lkotlin/collections/builders/d;", "backing", "", "()I", "size", "<init>", "(Lkotlin/collections/builders/d;)V", "()V", "initialCapacity", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class h<E> extends i<E> implements Set<E>, m1.h {

    /* renamed from: a  reason: collision with root package name */
    private final d<E, ?> f55288a;

    public h(@NotNull d<E, ?> backing) {
        f0.p(backing, "backing");
        this.f55288a = backing;
    }

    public int a() {
        return this.f55288a.size();
    }

    @Override // kotlin.collections.a, java.util.Collection
    public boolean add(E e4) {
        return this.f55288a.l(e4) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.a, java.util.Collection
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        f0.p(elements, "elements");
        this.f55288a.o();
        return super/*java.util.AbstractSet*/.addAll(elements);
    }

    @NotNull
    public final Set<E> c() {
        this.f55288a.n();
        return this;
    }

    @Override // kotlin.collections.a, java.util.Collection
    public void clear() {
        this.f55288a.clear();
    }

    @Override // kotlin.collections.a, java.util.Collection
    public boolean contains(Object obj) {
        return this.f55288a.containsKey(obj);
    }

    @Override // kotlin.collections.a, java.util.Collection
    public boolean isEmpty() {
        return this.f55288a.isEmpty();
    }

    @Override // kotlin.collections.i, kotlin.collections.a, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return this.f55288a.F();
    }

    @Override // kotlin.collections.a, java.util.Collection
    public boolean remove(Object obj) {
        return this.f55288a.M(obj) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.a, java.util.Collection
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f55288a.o();
        return super/*java.util.AbstractSet*/.removeAll(elements);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.a, java.util.Collection
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        this.f55288a.o();
        return super/*java.util.AbstractSet*/.retainAll(elements);
    }

    public h() {
        this(new d());
    }

    public h(int i4) {
        this(new d(i4));
    }
}
