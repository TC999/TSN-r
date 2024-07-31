package kotlin.collections.builders;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p620m1.InterfaceC15303h;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010)\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001b\b\u0000\u0012\u0010\u0010\u0019\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u0016¢\u0006\u0004\b\u001d\u0010\u001eB\t\b\u0016¢\u0006\u0004\b\u001d\u0010\u001fB\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010!J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\f\u001a\u00020\u000bH\u0016J\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0096\u0002J\u0016\u0010\u0013\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0016\u0010\u0014\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0016\u0010\u0015\u001a\u00020\u00062\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016R\u001e\u0010\u0019\u001a\f\u0012\u0004\u0012\u00028\u0000\u0012\u0002\b\u00030\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u001b¨\u0006\""}, m12616d2 = {"Lkotlin/collections/builders/h;", ExifInterface.LONGITUDE_EAST, "", "Lkotlin/collections/i;", "", "c", "", "isEmpty", "element", "contains", "(Ljava/lang/Object;)Z", "Lkotlin/f1;", "clear", "add", "remove", "", "iterator", "", "elements", "addAll", "removeAll", "retainAll", "Lkotlin/collections/builders/d;", "a", "Lkotlin/collections/builders/d;", "backing", "", "()I", "size", "<init>", "(Lkotlin/collections/builders/d;)V", "()V", "initialCapacity", "(I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.builders.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SetBuilder<E> extends AbstractMutableSet<E> implements Set<E>, InterfaceC15303h {

    /* renamed from: a */
    private final C14132d<E, ?> f40867a;

    public SetBuilder(@NotNull C14132d<E, ?> backing) {
        C14342f0.m8184p(backing, "backing");
        this.f40867a = backing;
    }

    @Override // kotlin.collections.AbstractMutableSet
    /* renamed from: a */
    public int mo5121a() {
        return this.f40867a.size();
    }

    @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e) {
        return this.f40867a.m12352l(e) >= 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        C14342f0.m8184p(elements, "elements");
        this.f40867a.m12349o();
        return super.addAll(elements);
    }

    @NotNull
    /* renamed from: c */
    public final Set<E> m12319c() {
        this.f40867a.m12350n();
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f40867a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f40867a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f40867a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<E> iterator() {
        return this.f40867a.m12373F();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f40867a.m12366M(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        C14342f0.m8184p(elements, "elements");
        this.f40867a.m12349o();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        C14342f0.m8184p(elements, "elements");
        this.f40867a.m12349o();
        return super.retainAll(elements);
    }

    public SetBuilder() {
        this(new C14132d());
    }

    public SetBuilder(int i) {
        this(new C14132d(i));
    }
}
