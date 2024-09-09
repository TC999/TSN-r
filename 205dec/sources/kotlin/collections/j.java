package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Collections.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\t\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002J\u0017\u0010\u000e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\r0\f\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u001f\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0018\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lkotlin/collections/j;", "T", "", "", "isEmpty", "element", "contains", "(Ljava/lang/Object;)Z", "elements", "containsAll", "", "iterator", "", "", "toArray", "()[Ljava/lang/Object;", "a", "[Ljava/lang/Object;", "c", "values", "b", "Z", "g", "()Z", "isVarargs", "", "()I", "size", "<init>", "([Ljava/lang/Object;Z)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j<T> implements Collection<T>, e2.a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final T[] f55335a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f55336b;

    /* compiled from: AbstractSet.kt */
    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006J'\u0010\n\u001a\u00020\t2\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lkotlin/collections/j$a;", "", "", "c", "", "b", "(Ljava/util/Collection;)I", "", "other", "", "a", "(Ljava/util/Set;Ljava/util/Set;)Z", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a {
        private a() {
        }

        public final boolean a(@NotNull Set<?> c4, @NotNull Set<?> other) {
            kotlin.jvm.internal.f0.p(c4, "c");
            kotlin.jvm.internal.f0.p(other, "other");
            if (c4.size() != other.size()) {
                return false;
            }
            return c4.containsAll(other);
        }

        public final int b(@NotNull Collection<?> c4) {
            kotlin.jvm.internal.f0.p(c4, "c");
            Iterator<?> it = c4.iterator();
            int i4 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                i4 += next != null ? next.hashCode() : 0;
            }
            return i4;
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public j(@NotNull T[] values, boolean z3) {
        kotlin.jvm.internal.f0.p(values, "values");
        this.f55335a = values;
        this.f55336b = z3;
    }

    public int a() {
        return this.f55335a.length;
    }

    @Override // java.util.Collection
    public boolean add(T t3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public final T[] c() {
        return this.f55335a;
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        boolean P7;
        P7 = p.P7(this.f55335a, obj);
        return P7;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        kotlin.jvm.internal.f0.p(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator<T> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final boolean g() {
        return this.f55336b;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f55335a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return kotlin.jvm.internal.h.a(this.f55335a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    @NotNull
    public final Object[] toArray() {
        return x.i(this.f55335a, this.f55336b);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        return (T[]) kotlin.jvm.internal.t.b(this, array);
    }
}
