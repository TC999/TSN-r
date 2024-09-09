package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: UnmodifiableLazyStringList.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class t extends AbstractList<String> implements RandomAccess, l {

    /* renamed from: a  reason: collision with root package name */
    private final l f57714a;

    /* compiled from: UnmodifiableLazyStringList.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements ListIterator<String> {

        /* renamed from: a  reason: collision with root package name */
        ListIterator<String> f57715a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f57716b;

        a(int i4) {
            this.f57716b = i4;
            this.f57715a = t.this.f57714a.listIterator(i4);
        }

        @Override // java.util.ListIterator
        /* renamed from: a */
        public void add(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* renamed from: b */
        public String next() {
            return this.f57715a.next();
        }

        @Override // java.util.ListIterator
        /* renamed from: d */
        public String previous() {
            return this.f57715a.previous();
        }

        @Override // java.util.ListIterator
        /* renamed from: e */
        public void set(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f57715a.hasNext();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f57715a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f57715a.nextIndex();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f57715a.previousIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: UnmodifiableLazyStringList.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class b implements Iterator<String> {

        /* renamed from: a  reason: collision with root package name */
        Iterator<String> f57718a;

        b() {
            this.f57718a = t.this.f57714a.iterator();
        }

        @Override // java.util.Iterator
        /* renamed from: a */
        public String next() {
            return this.f57718a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f57718a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public t(l lVar) {
        this.f57714a = lVar;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: c */
    public String get(int i4) {
        return this.f57714a.get(i4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public List<?> d() {
        return this.f57714a.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public d e(int i4) {
        return this.f57714a.e(i4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void f(d dVar) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public l j() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(int i4) {
        return new a(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f57714a.size();
    }
}
