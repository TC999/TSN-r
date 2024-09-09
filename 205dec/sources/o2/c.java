package o2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TargetPlatform.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c implements Collection<b>, e2.a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Set<b> f61577a;

    @Override // java.util.Collection
    /* renamed from: a */
    public boolean add(b bVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends b> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean c(@NotNull b element) {
        f0.p(element, "element");
        return this.f61577a.contains(element);
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof b) {
            return c((b) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@NotNull Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        return this.f61577a.containsAll(elements);
    }

    @Override // java.util.Collection
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && f0.g(this.f61577a, ((c) obj).f61577a);
    }

    @NotNull
    public final Set<b> g() {
        return this.f61577a;
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.f61577a.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f61577a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<b> iterator() {
        return this.f61577a.iterator();
    }

    public int k() {
        return this.f61577a.size();
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
        return k();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return t.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        f0.p(array, "array");
        return (T[]) t.b(this, array);
    }

    @NotNull
    public String toString() {
        return a.a(this);
    }
}
