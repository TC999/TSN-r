package com.bumptech.glide.repackaged.com.google.common.collect;

import com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\4499832.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {

    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static class a<E> extends ImmutableCollection.a<E> {
        public a() {
            this(4);
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.a
        /* renamed from: f */
        public a<E> d(E e4) {
            super.a(e4);
            return this;
        }

        @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection.b
        /* renamed from: g */
        public a<E> b(Iterator<? extends E> it) {
            super.b(it);
            return this;
        }

        public ImmutableSet<E> h() {
            ImmutableSet<E> construct = ImmutableSet.construct(this.f17655b, this.f17654a);
            this.f17655b = construct.size();
            return construct;
        }

        a(int i4) {
            super(i4);
        }
    }

    static int chooseTableSize(int i4) {
        if (i4 < 751619276) {
            int highestOneBit = Integer.highestOneBit(i4 - 1) << 1;
            while (true) {
                double d4 = highestOneBit;
                Double.isNaN(d4);
                if (d4 * 0.7d >= i4) {
                    return highestOneBit;
                }
                highestOneBit <<= 1;
            }
        } else {
            com.bumptech.glide.repackaged.com.google.common.base.d.e(i4 < 1073741824, "collection too large");
            return 1073741824;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i4, Object... objArr) {
        if (i4 != 0) {
            if (i4 != 1) {
                int chooseTableSize = chooseTableSize(i4);
                Object[] objArr2 = new Object[chooseTableSize];
                int i5 = chooseTableSize - 1;
                int i6 = 0;
                int i7 = 0;
                for (int i8 = 0; i8 < i4; i8++) {
                    Object b4 = r.b(objArr[i8], i8);
                    int hashCode = b4.hashCode();
                    int a4 = h.a(hashCode);
                    while (true) {
                        int i9 = a4 & i5;
                        Object obj = objArr2[i9];
                        if (obj == null) {
                            objArr[i6] = b4;
                            objArr2[i9] = b4;
                            i7 += hashCode;
                            i6++;
                            break;
                        } else if (obj.equals(b4)) {
                            break;
                        } else {
                            a4++;
                        }
                    }
                }
                Arrays.fill(objArr, i6, i4, (Object) null);
                if (i6 == 1) {
                    return new d0(objArr[0], i7);
                }
                if (chooseTableSize != chooseTableSize(i6)) {
                    return construct(i6, objArr);
                }
                if (i6 < objArr.length) {
                    objArr = r.a(objArr, i6);
                }
                return new x(objArr, i7, objArr2, i5);
            }
            return of(objArr[0]);
        }
        return of();
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof ImmutableSortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        } else if (collection instanceof EnumSet) {
            return copyOfEnumSet((EnumSet) collection);
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    private static ImmutableSet copyOfEnumSet(EnumSet enumSet) {
        return j.a(EnumSet.copyOf(enumSet));
    }

    public static <E> ImmutableSet<E> of() {
        return x.f17715e;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return b0.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return b0.b(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.bumptech.glide.repackaged.com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract i0<E> iterator();

    public static <E> ImmutableSet<E> of(E e4) {
        return new d0(e4);
    }

    public static <E> ImmutableSet<E> of(E e4, E e5, E e6, E e7, E e8) {
        return construct(5, e4, e5, e6, e7, e8);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? copyOf((Collection) iterable) : copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().d(next).b(it).h();
    }
}
