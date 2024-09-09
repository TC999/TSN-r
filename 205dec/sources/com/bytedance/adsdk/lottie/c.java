package com.bytedance.adsdk.lottie;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class c<E> implements Collection<E>, Set<E> {

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f25306e = new int[0];

    /* renamed from: f  reason: collision with root package name */
    private static final Object[] f25307f = new Object[0];

    /* renamed from: g  reason: collision with root package name */
    private static Object[] f25308g;

    /* renamed from: h  reason: collision with root package name */
    private static int f25309h;

    /* renamed from: i  reason: collision with root package name */
    private static Object[] f25310i;

    /* renamed from: j  reason: collision with root package name */
    private static int f25311j;

    /* renamed from: a  reason: collision with root package name */
    private int[] f25312a;

    /* renamed from: b  reason: collision with root package name */
    Object[] f25313b;

    /* renamed from: c  reason: collision with root package name */
    int f25314c;

    /* renamed from: d  reason: collision with root package name */
    private j<E, E> f25315d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class a extends j<E, E> {
        a() {
        }

        @Override // com.bytedance.adsdk.lottie.j
        protected int a() {
            return c.this.f25314c;
        }

        @Override // com.bytedance.adsdk.lottie.j
        protected int b(Object obj) {
            return c.this.c(obj);
        }

        @Override // com.bytedance.adsdk.lottie.j
        protected Object c(int i4, int i5) {
            return c.this.f25313b[i4];
        }

        @Override // com.bytedance.adsdk.lottie.j
        protected void d(int i4) {
            c.this.p(i4);
        }

        @Override // com.bytedance.adsdk.lottie.j
        protected Map<E, E> i() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // com.bytedance.adsdk.lottie.j
        protected void l() {
            c.this.clear();
        }
    }

    public c() {
        this(0);
    }

    private int a() {
        int i4 = this.f25314c;
        if (i4 == 0) {
            return -1;
        }
        int a4 = t.a(this.f25312a, i4, 0);
        if (a4 >= 0 && this.f25313b[a4] != null) {
            int i5 = a4 + 1;
            while (i5 < i4 && this.f25312a[i5] == 0) {
                if (this.f25313b[i5] == null) {
                    return i5;
                }
                i5++;
            }
            for (int i6 = a4 - 1; i6 >= 0 && this.f25312a[i6] == 0; i6--) {
                if (this.f25313b[i6] == null) {
                    return i6;
                }
            }
            return i5 ^ (-1);
        }
        return a4;
    }

    private int g(Object obj, int i4) {
        int i5 = this.f25314c;
        if (i5 == 0) {
            return -1;
        }
        int a4 = t.a(this.f25312a, i5, i4);
        if (a4 >= 0 && !obj.equals(this.f25313b[a4])) {
            int i6 = a4 + 1;
            while (i6 < i5 && this.f25312a[i6] == i4) {
                if (obj.equals(this.f25313b[i6])) {
                    return i6;
                }
                i6++;
            }
            for (int i7 = a4 - 1; i7 >= 0 && this.f25312a[i7] == i4; i7--) {
                if (obj.equals(this.f25313b[i7])) {
                    return i7;
                }
            }
            return i6 ^ (-1);
        }
        return a4;
    }

    private static void l(int[] iArr, Object[] objArr, int i4) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (f25311j < 10) {
                    objArr[0] = f25310i;
                    objArr[1] = iArr;
                    for (int i5 = i4 - 1; i5 >= 2; i5--) {
                        objArr[i5] = null;
                    }
                    f25310i = objArr;
                    f25311j++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (c.class) {
                if (f25309h < 10) {
                    objArr[0] = f25308g;
                    objArr[1] = iArr;
                    for (int i6 = i4 - 1; i6 >= 2; i6--) {
                        objArr[i6] = null;
                    }
                    f25308g = objArr;
                    f25309h++;
                }
            }
        }
    }

    private void m(int i4) {
        if (i4 == 8) {
            synchronized (c.class) {
                Object[] objArr = f25310i;
                if (objArr != null) {
                    this.f25313b = objArr;
                    f25310i = (Object[]) objArr[0];
                    this.f25312a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f25311j--;
                    return;
                }
            }
        } else if (i4 == 4) {
            synchronized (c.class) {
                Object[] objArr2 = f25308g;
                if (objArr2 != null) {
                    this.f25313b = objArr2;
                    f25308g = (Object[]) objArr2[0];
                    this.f25312a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f25309h--;
                    return;
                }
            }
        }
        this.f25312a = new int[i4];
        this.f25313b = new Object[i4];
    }

    private j<E, E> n() {
        if (this.f25315d == null) {
            this.f25315d = new a();
        }
        return this.f25315d;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e4) {
        int i4;
        int g4;
        if (e4 == null) {
            g4 = a();
            i4 = 0;
        } else {
            int hashCode = e4.hashCode();
            i4 = hashCode;
            g4 = g(e4, hashCode);
        }
        if (g4 >= 0) {
            return false;
        }
        int i5 = g4 ^ (-1);
        int i6 = this.f25314c;
        int[] iArr = this.f25312a;
        if (i6 >= iArr.length) {
            int i7 = 4;
            if (i6 >= 8) {
                i7 = (i6 >> 1) + i6;
            } else if (i6 >= 4) {
                i7 = 8;
            }
            Object[] objArr = this.f25313b;
            m(i7);
            int[] iArr2 = this.f25312a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f25313b, 0, objArr.length);
            }
            l(iArr, objArr, this.f25314c);
        }
        int i8 = this.f25314c;
        if (i5 < i8) {
            int[] iArr3 = this.f25312a;
            int i9 = i5 + 1;
            System.arraycopy(iArr3, i5, iArr3, i9, i8 - i5);
            Object[] objArr2 = this.f25313b;
            System.arraycopy(objArr2, i5, objArr2, i9, this.f25314c - i5);
        }
        this.f25312a[i5] = i4;
        this.f25313b[i5] = e4;
        this.f25314c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        k(this.f25314c + collection.size());
        boolean z3 = false;
        for (E e4 : collection) {
            z3 |= add(e4);
        }
        return z3;
    }

    public int c(Object obj) {
        return obj == null ? a() : g(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i4 = this.f25314c;
        if (i4 != 0) {
            l(this.f25312a, this.f25313b, i4);
            this.f25312a = f25306e;
            this.f25313b = f25307f;
            this.f25314c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return c(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i4 = 0; i4 < this.f25314c; i4++) {
                try {
                    if (!set.contains(o(i4))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f25312a;
        int i4 = this.f25314c;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 += iArr[i6];
        }
        return i5;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f25314c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return n().h().iterator();
    }

    public void k(int i4) {
        int[] iArr = this.f25312a;
        if (iArr.length < i4) {
            Object[] objArr = this.f25313b;
            m(i4);
            int i5 = this.f25314c;
            if (i5 > 0) {
                System.arraycopy(iArr, 0, this.f25312a, 0, i5);
                System.arraycopy(objArr, 0, this.f25313b, 0, this.f25314c);
            }
            l(iArr, objArr, this.f25314c);
        }
    }

    public E o(int i4) {
        return (E) this.f25313b[i4];
    }

    public E p(int i4) {
        Object[] objArr = this.f25313b;
        E e4 = (E) objArr[i4];
        int i5 = this.f25314c;
        if (i5 <= 1) {
            l(this.f25312a, objArr, i5);
            this.f25312a = f25306e;
            this.f25313b = f25307f;
            this.f25314c = 0;
        } else {
            int[] iArr = this.f25312a;
            if (iArr.length > 8 && i5 < iArr.length / 3) {
                m(i5 > 8 ? i5 + (i5 >> 1) : 8);
                this.f25314c--;
                if (i4 > 0) {
                    System.arraycopy(iArr, 0, this.f25312a, 0, i4);
                    System.arraycopy(objArr, 0, this.f25313b, 0, i4);
                }
                int i6 = this.f25314c;
                if (i4 < i6) {
                    int i7 = i4 + 1;
                    System.arraycopy(iArr, i7, this.f25312a, i4, i6 - i4);
                    System.arraycopy(objArr, i7, this.f25313b, i4, this.f25314c - i4);
                }
            } else {
                int i8 = i5 - 1;
                this.f25314c = i8;
                if (i4 < i8) {
                    int i9 = i4 + 1;
                    System.arraycopy(iArr, i9, iArr, i4, i8 - i4);
                    Object[] objArr2 = this.f25313b;
                    System.arraycopy(objArr2, i9, objArr2, i4, this.f25314c - i4);
                }
                this.f25313b[this.f25314c] = null;
            }
        }
        return e4;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int c4 = c(obj);
        if (c4 >= 0) {
            p(c4);
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= remove(it.next());
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z3 = false;
        for (int i4 = this.f25314c - 1; i4 >= 0; i4--) {
            if (!collection.contains(this.f25313b[i4])) {
                p(i4);
                z3 = true;
            }
        }
        return z3;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f25314c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i4 = this.f25314c;
        Object[] objArr = new Object[i4];
        System.arraycopy(this.f25313b, 0, objArr, 0, i4);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f25314c * 14);
        sb.append('{');
        for (int i4 = 0; i4 < this.f25314c; i4++) {
            if (i4 > 0) {
                sb.append(", ");
            }
            E o4 = o(i4);
            if (o4 != this) {
                sb.append(o4);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public c(int i4) {
        if (i4 == 0) {
            this.f25312a = f25306e;
            this.f25313b = f25307f;
        } else {
            m(i4);
        }
        this.f25314c = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f25314c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f25314c));
        }
        System.arraycopy(this.f25313b, 0, tArr, 0, this.f25314c);
        int length = tArr.length;
        int i4 = this.f25314c;
        if (length > i4) {
            tArr[i4] = null;
        }
        return tArr;
    }
}
