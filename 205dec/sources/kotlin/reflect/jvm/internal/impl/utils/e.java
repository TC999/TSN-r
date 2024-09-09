package kotlin.reflect.jvm.internal.impl.utils;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.jetbrains.annotations.NotNull;

/* compiled from: SmartList.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class e<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a  reason: collision with root package name */
    private int f58548a;

    /* renamed from: b  reason: collision with root package name */
    private Object f58549b;

    /* compiled from: SmartList.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static class b<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private static final b f58550a = new b();

        private b() {
        }

        public static <T> b<T> a() {
            return f58550a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public T next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new IllegalStateException();
        }
    }

    /* compiled from: SmartList.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private class c extends d<E> {

        /* renamed from: b  reason: collision with root package name */
        private final int f58551b;

        public c() {
            super();
            this.f58551b = ((AbstractList) e.this).modCount;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.e.d
        protected void a() {
            if (((AbstractList) e.this).modCount == this.f58551b) {
                return;
            }
            throw new ConcurrentModificationException("ModCount: " + ((AbstractList) e.this).modCount + "; expected: " + this.f58551b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.e.d
        protected E b() {
            return (E) e.this.f58549b;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            e.this.clear();
        }
    }

    /* compiled from: SmartList.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static abstract class d<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f58553a;

        private d() {
        }

        protected abstract void a();

        protected abstract T b();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return !this.f58553a;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (!this.f58553a) {
                this.f58553a = true;
                a();
                return b();
            }
            throw new NoSuchElementException();
        }
    }

    private static /* synthetic */ void a(int i4) {
        String str = (i4 == 2 || i4 == 3 || i4 == 5 || i4 == 6 || i4 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 2 || i4 == 3 || i4 == 5 || i4 == 6 || i4 == 7) ? 2 : 3];
        switch (i4) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
                break;
            case 4:
                objArr[0] = "a";
                break;
            default:
                objArr[0] = "elements";
                break;
        }
        if (i4 == 2 || i4 == 3) {
            objArr[1] = "iterator";
        } else if (i4 == 5 || i4 == 6 || i4 == 7) {
            objArr[1] = "toArray";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/SmartList";
        }
        switch (i4) {
            case 2:
            case 3:
            case 5:
            case 6:
            case 7:
                break;
            case 4:
                objArr[2] = "toArray";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 2 && i4 != 3 && i4 != 5 && i4 != 6 && i4 != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e4) {
        int i4 = this.f58548a;
        if (i4 == 0) {
            this.f58549b = e4;
        } else if (i4 == 1) {
            this.f58549b = new Object[]{this.f58549b, e4};
        } else {
            Object[] objArr = (Object[]) this.f58549b;
            int length = objArr.length;
            if (i4 >= length) {
                int i5 = ((length * 3) / 2) + 1;
                int i6 = i4 + 1;
                if (i5 < i6) {
                    i5 = i6;
                }
                Object[] objArr2 = new Object[i5];
                this.f58549b = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, length);
                objArr = objArr2;
            }
            objArr[this.f58548a] = e4;
        }
        this.f58548a++;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f58549b = null;
        this.f58548a = 0;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i4) {
        int i5;
        if (i4 >= 0 && i4 < (i5 = this.f58548a)) {
            if (i5 == 1) {
                return (E) this.f58549b;
            }
            return (E) ((Object[]) this.f58549b)[i4];
        }
        throw new IndexOutOfBoundsException("Index: " + i4 + ", Size: " + this.f58548a);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        int i4 = this.f58548a;
        if (i4 == 0) {
            b a4 = b.a();
            if (a4 == null) {
                a(2);
            }
            return a4;
        } else if (i4 == 1) {
            return new c();
        } else {
            Iterator<E> it = super.iterator();
            if (it == null) {
                a(3);
            }
            return it;
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i4) {
        int i5;
        E e4;
        if (i4 >= 0 && i4 < (i5 = this.f58548a)) {
            if (i5 == 1) {
                e4 = (E) this.f58549b;
                this.f58549b = null;
            } else {
                Object[] objArr = (Object[]) this.f58549b;
                Object obj = objArr[i4];
                if (i5 == 2) {
                    this.f58549b = objArr[1 - i4];
                } else {
                    int i6 = (i5 - i4) - 1;
                    if (i6 > 0) {
                        System.arraycopy(objArr, i4 + 1, objArr, i4, i6);
                    }
                    objArr[this.f58548a - 1] = null;
                }
                e4 = (E) obj;
            }
            this.f58548a--;
            ((AbstractList) this).modCount++;
            return e4;
        }
        throw new IndexOutOfBoundsException("Index: " + i4 + ", Size: " + this.f58548a);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i4, E e4) {
        int i5;
        if (i4 < 0 || i4 >= (i5 = this.f58548a)) {
            throw new IndexOutOfBoundsException("Index: " + i4 + ", Size: " + this.f58548a);
        } else if (i5 == 1) {
            E e5 = (E) this.f58549b;
            this.f58549b = e4;
            return e5;
        } else {
            Object[] objArr = (Object[]) this.f58549b;
            E e6 = (E) objArr[i4];
            objArr[i4] = e4;
            return e6;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f58548a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] tArr) {
        if (tArr == 0) {
            a(4);
        }
        int length = tArr.length;
        int i4 = this.f58548a;
        if (i4 == 1) {
            if (length != 0) {
                tArr[0] = this.f58549b;
            } else {
                T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
                tArr2[0] = this.f58549b;
                return tArr2;
            }
        } else if (length < i4) {
            T[] tArr3 = (T[]) Arrays.copyOf((Object[]) this.f58549b, i4, tArr.getClass());
            if (tArr3 == null) {
                a(6);
            }
            return tArr3;
        } else if (i4 != 0) {
            System.arraycopy(this.f58549b, 0, tArr, 0, i4);
        }
        int i5 = this.f58548a;
        if (length > i5) {
            tArr[i5] = 0;
        }
        return tArr;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i4, E e4) {
        int i5;
        if (i4 >= 0 && i4 <= (i5 = this.f58548a)) {
            if (i5 == 0) {
                this.f58549b = e4;
            } else if (i5 == 1 && i4 == 0) {
                this.f58549b = new Object[]{e4, this.f58549b};
            } else {
                Object[] objArr = new Object[i5 + 1];
                if (i5 == 1) {
                    objArr[0] = this.f58549b;
                } else {
                    Object[] objArr2 = (Object[]) this.f58549b;
                    System.arraycopy(objArr2, 0, objArr, 0, i4);
                    System.arraycopy(objArr2, i4, objArr, i4 + 1, this.f58548a - i4);
                }
                objArr[i4] = e4;
                this.f58549b = objArr;
            }
            this.f58548a++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("Index: " + i4 + ", Size: " + this.f58548a);
    }
}
