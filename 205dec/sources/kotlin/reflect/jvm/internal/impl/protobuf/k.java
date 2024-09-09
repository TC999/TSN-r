package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: LazyStringArrayList.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class k extends AbstractList<String> implements RandomAccess, l {

    /* renamed from: b  reason: collision with root package name */
    public static final l f57671b = new k().j();

    /* renamed from: a  reason: collision with root package name */
    private final List<Object> f57672a;

    public k() {
        this.f57672a = new ArrayList();
    }

    private static d c(Object obj) {
        if (obj instanceof d) {
            return (d) obj;
        }
        if (obj instanceof String) {
            return d.m((String) obj);
        }
        return d.k((byte[]) obj);
    }

    private static String g(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            return ((d) obj).A();
        }
        return h.b((byte[]) obj);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public void add(int i4, String str) {
        this.f57672a.add(i4, str);
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f57672a.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public List<?> d() {
        return Collections.unmodifiableList(this.f57672a);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public d e(int i4) {
        Object obj = this.f57672a.get(i4);
        d c4 = c(obj);
        if (c4 != obj) {
            this.f57672a.set(i4, c4);
        }
        return c4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public void f(d dVar) {
        this.f57672a.add(dVar);
        ((AbstractList) this).modCount++;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.l
    public l j() {
        return new t(this);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: k */
    public String get(int i4) {
        Object obj = this.f57672a.get(i4);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            String A = dVar.A();
            if (dVar.r()) {
                this.f57672a.set(i4, A);
            }
            return A;
        }
        byte[] bArr = (byte[]) obj;
        String b4 = h.b(bArr);
        if (h.a(bArr)) {
            this.f57672a.set(i4, b4);
        }
        return b4;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: l */
    public String remove(int i4) {
        Object remove = this.f57672a.remove(i4);
        ((AbstractList) this).modCount++;
        return g(remove);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: m */
    public String set(int i4, String str) {
        return g(this.f57672a.set(i4, str));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f57672a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i4, Collection<? extends String> collection) {
        if (collection instanceof l) {
            collection = ((l) collection).d();
        }
        boolean addAll = this.f57672a.addAll(i4, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    public k(l lVar) {
        this.f57672a = new ArrayList(lVar.size());
        addAll(lVar);
    }
}
