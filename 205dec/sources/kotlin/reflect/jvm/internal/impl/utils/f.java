package kotlin.reflect.jvm.internal.impl.utils;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.j1;
import kotlin.collections.p;
import kotlin.f1;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SmartSet.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f<T> extends AbstractSet<T> {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final b f58554c = new b(null);
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Object f58555a;

    /* renamed from: b  reason: collision with root package name */
    private int f58556b;

    /* compiled from: SmartSet.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class a<T> implements Iterator<T>, e2.d {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f58557a;

        public a(@NotNull T[] array) {
            f0.p(array, "array");
            this.f58557a = h.a(array);
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: a */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f58557a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f58557a.next();
        }
    }

    /* compiled from: SmartSet.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }

        @JvmStatic
        @NotNull
        public final <T> f<T> a() {
            return new f<>(null);
        }

        @JvmStatic
        @NotNull
        public final <T> f<T> b(@NotNull Collection<? extends T> set) {
            f0.p(set, "set");
            f<T> fVar = new f<>(null);
            fVar.addAll(set);
            return fVar;
        }
    }

    /* compiled from: SmartSet.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class c<T> implements Iterator<T>, e2.d {

        /* renamed from: a  reason: collision with root package name */
        private final T f58558a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f58559b = true;

        public c(T t3) {
            this.f58558a = t3;
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: a */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f58559b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f58559b) {
                this.f58559b = false;
                return this.f58558a;
            }
            throw new NoSuchElementException();
        }
    }

    private f() {
    }

    public /* synthetic */ f(u uVar) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final <T> f<T> a() {
        return f58554c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t3) {
        boolean P7;
        Object[] objArr;
        LinkedHashSet o4;
        if (size() == 0) {
            this.f58555a = t3;
        } else if (size() == 1) {
            if (f0.g(this.f58555a, t3)) {
                return false;
            }
            this.f58555a = new Object[]{this.f58555a, t3};
        } else if (size() < 5) {
            Object obj = this.f58555a;
            if (obj != null) {
                Object[] objArr2 = (Object[]) obj;
                P7 = p.P7(objArr2, t3);
                if (P7) {
                    return false;
                }
                if (size() == 4) {
                    o4 = j1.o(Arrays.copyOf(objArr2, objArr2.length));
                    o4.add(t3);
                    f1 f1Var = f1.f55527a;
                    objArr = o4;
                } else {
                    Object[] copyOf = Arrays.copyOf(objArr2, size() + 1);
                    f0.o(copyOf, "copyOf(this, newSize)");
                    copyOf[copyOf.length - 1] = t3;
                    f1 f1Var2 = f1.f55527a;
                    objArr = copyOf;
                }
                this.f58555a = objArr;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            }
        } else {
            Object obj2 = this.f58555a;
            if (obj2 != null) {
                if (!t0.o(obj2).add(t3)) {
                    return false;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            }
        }
        g(size() + 1);
        return true;
    }

    public int c() {
        return this.f58556b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f58555a = null;
        g(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        boolean P7;
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return f0.g(this.f58555a, obj);
        }
        if (size() >= 5) {
            Object obj2 = this.f58555a;
            if (obj2 != null) {
                return ((Set) obj2).contains(obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
        }
        Object obj3 = this.f58555a;
        if (obj3 != null) {
            P7 = p.P7((Object[]) obj3, obj);
            return P7;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
    }

    public void g(int i4) {
        this.f58556b = i4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @NotNull
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.f58555a);
        }
        if (size() < 5) {
            Object obj = this.f58555a;
            if (obj != null) {
                return new a((Object[]) obj);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        }
        Object obj2 = this.f58555a;
        if (obj2 != null) {
            return t0.o(obj2).iterator();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return c();
    }
}
