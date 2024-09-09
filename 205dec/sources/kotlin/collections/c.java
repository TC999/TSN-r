package kotlin.collections;

import com.acse.ottn.f3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractList.kt */
@SinceKotlin(version = "1.1")
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0005\n\u0002\u0010*\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b'\u0018\u0000 \u001d*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004\u001e\u001f !B\t\b\u0004\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u00a6\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\r\u0010\fJ\u000e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0016J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\u0013\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0004H\u0016R\u0014\u0010\u001a\u001a\u00020\u00048&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\""}, d2 = {"Lkotlin/collections/c;", "E", "Lkotlin/collections/a;", "", "", "index", f3.f5657f, "(I)Ljava/lang/Object;", "", "iterator", "element", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "listIterator", "fromIndex", "toIndex", "subList", "", "other", "", "equals", "hashCode", "getSize", "()I", "size", "<init>", "()V", "Companion", "a", "b", "c", "d", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class c<E> extends kotlin.collections.a<E> implements List<E>, e2.a {
    @NotNull
    public static final a Companion = new a(null);

    /* compiled from: AbstractList.kt */
    @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\b\u0010\u0007J'\u0010\u000b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ'\u0010\u000f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\u000f\u0010\fJ\u001b\u0010\u0011\u001a\u00020\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J'\u0010\u0015\u001a\u00020\u00142\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00102\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0000\u00a2\u0006\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lkotlin/collections/c$a;", "", "", "index", "size", "Lkotlin/f1;", "b", "(II)V", "c", "fromIndex", "toIndex", "d", "(III)V", "startIndex", "endIndex", "a", "", "f", "(Ljava/util/Collection;)I", "other", "", "e", "(Ljava/util/Collection;Ljava/util/Collection;)Z", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public final void a(int i4, int i5, int i6) {
            if (i4 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("startIndex: " + i4 + ", endIndex: " + i5 + ", size: " + i6);
            } else if (i4 <= i5) {
            } else {
                throw new IllegalArgumentException("startIndex: " + i4 + " > endIndex: " + i5);
            }
        }

        public final void b(int i4, int i5) {
            if (i4 < 0 || i4 >= i5) {
                throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
            }
        }

        public final void c(int i4, int i5) {
            if (i4 < 0 || i4 > i5) {
                throw new IndexOutOfBoundsException("index: " + i4 + ", size: " + i5);
            }
        }

        public final void d(int i4, int i5, int i6) {
            if (i4 < 0 || i5 > i6) {
                throw new IndexOutOfBoundsException("fromIndex: " + i4 + ", toIndex: " + i5 + ", size: " + i6);
            } else if (i4 <= i5) {
            } else {
                throw new IllegalArgumentException("fromIndex: " + i4 + " > toIndex: " + i5);
            }
        }

        public final boolean e(@NotNull Collection<?> c4, @NotNull Collection<?> other) {
            kotlin.jvm.internal.f0.p(c4, "c");
            kotlin.jvm.internal.f0.p(other, "other");
            if (c4.size() != other.size()) {
                return false;
            }
            Iterator<?> it = other.iterator();
            Iterator<?> it2 = c4.iterator();
            while (it2.hasNext()) {
                if (!kotlin.jvm.internal.f0.g(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int f(@NotNull Collection<?> c4) {
            kotlin.jvm.internal.f0.p(c4, "c");
            Iterator<?> it = c4.iterator();
            int i4 = 1;
            while (it.hasNext()) {
                Object next = it.next();
                i4 = (i4 * 31) + (next == null ? 0 : next.hashCode());
            }
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0092\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\f\u001a\u00020\u00068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlin/collections/c$b;", "", "", "hasNext", "next", "()Ljava/lang/Object;", "", "a", "I", "()I", "d", "(I)V", "index", "<init>", "(Lkotlin/collections/c;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b implements Iterator<E>, e2.a {

        /* renamed from: a  reason: collision with root package name */
        private int f55289a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c<E> f55290b;

        public b(c this$0) {
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            this.f55290b = this$0;
        }

        protected final int a() {
            return this.f55289a;
        }

        protected final void d(int i4) {
            this.f55289a = i4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f55289a < this.f55290b.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                c<E> cVar = this.f55290b;
                int i4 = this.f55289a;
                this.f55289a = i4 + 1;
                return cVar.get(i4);
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0092\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000f\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lkotlin/collections/c$c;", "Lkotlin/collections/c$b;", "Lkotlin/collections/c;", "", "", "hasPrevious", "", "nextIndex", "previous", "()Ljava/lang/Object;", "previousIndex", "index", "<init>", "(Lkotlin/collections/c;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.collections.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private class C1090c extends c<E>.b implements ListIterator<E>, e2.a {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c<E> f55291c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1090c(c this$0, int i4) {
            super(this$0);
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            this.f55291c = this$0;
            c.Companion.c(i4, this$0.size());
            d(i4);
        }

        @Override // java.util.ListIterator
        public void add(E e4) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return a() > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return a();
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (hasPrevious()) {
                c<E> cVar = this.f55291c;
                d(a() - 1);
                return cVar.get(a());
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return a() - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e4) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* compiled from: AbstractList.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00010\u00022\u00060\u0003j\u0002`\u0004B%\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0013\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lkotlin/collections/c$d;", "E", "Lkotlin/collections/c;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "index", f3.f5657f, "(I)Ljava/lang/Object;", "a", "Lkotlin/collections/c;", "list", "b", "I", "fromIndex", "c", "_size", "getSize", "()I", "size", "toIndex", "<init>", "(Lkotlin/collections/c;II)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class d<E> extends c<E> implements RandomAccess {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final c<E> f55292a;

        /* renamed from: b  reason: collision with root package name */
        private final int f55293b;

        /* renamed from: c  reason: collision with root package name */
        private int f55294c;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@NotNull c<? extends E> list, int i4, int i5) {
            kotlin.jvm.internal.f0.p(list, "list");
            this.f55292a = list;
            this.f55293b = i4;
            c.Companion.d(i4, i5, list.size());
            this.f55294c = i5 - i4;
        }

        @Override // kotlin.collections.c, java.util.List
        public E get(int i4) {
            c.Companion.b(i4, this.f55294c);
            return this.f55292a.get(this.f55293b + i4);
        }

        @Override // kotlin.collections.c, kotlin.collections.a
        public int getSize() {
            return this.f55294c;
        }
    }

    @Override // java.util.List
    public void add(int i4, E e4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i4, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.e(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i4);

    @Override // kotlin.collections.a
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.f(this);
    }

    @Override // java.util.List
    public int indexOf(E e4) {
        int i4 = 0;
        for (E e5 : this) {
            if (kotlin.jvm.internal.f0.g(e5, e4)) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    @Override // kotlin.collections.a, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<E> iterator() {
        return new b(this);
    }

    @Override // java.util.List
    public int lastIndexOf(E e4) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kotlin.jvm.internal.f0.g(listIterator.previous(), e4)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new C1090c(this, 0);
    }

    @Override // java.util.List
    public E remove(int i4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i4, E e4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @NotNull
    public List<E> subList(int i4, int i5) {
        return new d(this, i4, i5);
    }

    @Override // java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i4) {
        return new C1090c(this, i4);
    }
}
