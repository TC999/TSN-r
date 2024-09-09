package kotlin.collections.builders;

import com.acse.ottn.f3;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.k;
import kotlin.collections.o;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ListBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0012\n\u0002\u0010)\n\u0000\n\u0002\u0010+\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u00028\u00000\u00052\u00060\u0006j\u0002`\u0007:\u0001ZBO\b\u0002\u0012\f\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000=\u0012\u0006\u0010H\u001a\u00020\n\u0012\u0006\u0010J\u001a\u00020\n\u0012\u0006\u0010K\u001a\u00020\u0013\u0012\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010O\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u00a2\u0006\u0004\bU\u0010VB\t\b\u0016\u00a2\u0006\u0004\bU\u0010WB\u0011\b\u0016\u0012\u0006\u0010X\u001a\u00020\n\u00a2\u0006\u0004\bU\u0010YJ\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0014\u0010\u0014\u001a\u00020\u00132\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011H\u0002J\u0018\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u001f\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u000f\u001a\u00020\nH\u0002J\u0017\u0010\u001d\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010!\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002J.\u0010#\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\"\u001a\u00020\u0013H\u0002J\f\u0010$\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011J\b\u0010%\u001a\u00020\u0013H\u0016J\u0018\u0010'\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\nH\u0096\u0002\u00a2\u0006\u0004\b'\u0010\u001eJ \u0010(\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b*\u0010+J\u0017\u0010,\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b,\u0010+J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0096\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/H\u0016J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000/2\u0006\u0010&\u001a\u00020\nH\u0016J\u0017\u00101\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b1\u00102J\u001f\u00101\u001a\u00020\f2\u0006\u0010&\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b1\u0010\u0019J\u0016\u00103\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u001e\u00103\u001a\u00020\u00132\u0006\u0010&\u001a\u00020\n2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\b\u00104\u001a\u00020\fH\u0016J\u0017\u00105\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b5\u0010\u001eJ\u0017\u00106\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b6\u00102J\u0016\u00107\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u00108\u001a\u00020\u00132\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u001e\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0016J)\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00010=\"\u0004\b\u0001\u0010<2\f\u0010>\u001a\b\u0012\u0004\u0012\u00028\u00010=H\u0016\u00a2\u0006\u0004\b?\u0010@J\u0017\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0=H\u0016\u00a2\u0006\u0004\b?\u0010AJ\u0013\u0010B\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010C\u001a\u00020\nH\u0016J\b\u0010E\u001a\u00020DH\u0016R\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010H\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010J\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010IR\u0016\u0010K\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001c\u0010M\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bM\u0010NR\u001c\u0010O\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010NR\u0014\u0010P\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010QR\u0014\u0010T\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bR\u0010S\u00a8\u0006["}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", "", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/f;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "writeReplace", "", "minCapacity", "Lkotlin/f1;", "ensureCapacity", "checkIsMutable", "n", "ensureExtraCapacity", "", "other", "", "contentEquals", "i", "insertAtInternal", "element", "addAtInternal", "(ILjava/lang/Object;)V", "", "elements", "addAllInternal", "removeAtInternal", "(I)Ljava/lang/Object;", "rangeOffset", "rangeLength", "removeRangeInternal", "retain", "retainOrRemoveAllInternal", "build", "isEmpty", "index", f3.f5657f, f3.f5659h, "(ILjava/lang/Object;)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "iterator", "", "listIterator", "add", "(Ljava/lang/Object;)Z", "addAll", "clear", "removeAt", "remove", "removeAll", "retainAll", "fromIndex", "toIndex", "subList", "T", "", "destination", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "()[Ljava/lang/Object;", "equals", "hashCode", "", "toString", "array", "[Ljava/lang/Object;", "offset", "I", "length", "isReadOnly", "Z", "backing", "Lkotlin/collections/builders/ListBuilder;", "root", "isEffectivelyReadOnly", "()Z", "getSize", "()I", "size", "<init>", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "()V", "initialCapacity", "(I)V", "a", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ListBuilder<E> extends kotlin.collections.f<E> implements List<E>, RandomAccess, Serializable, e2.e {
    @NotNull
    private E[] array;
    @Nullable
    private final ListBuilder<E> backing;
    private boolean isReadOnly;
    private int length;
    private int offset;
    @Nullable
    private final ListBuilder<E> root;

    /* compiled from: ListBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\b\u0016\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\t\u0010\u0005\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\b\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lkotlin/collections/builders/ListBuilder$a;", "E", "", "", "hasPrevious", "hasNext", "", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "element", "Lkotlin/f1;", f3.f5659h, "(Ljava/lang/Object;)V", "add", "remove", "Lkotlin/collections/builders/ListBuilder;", "a", "Lkotlin/collections/builders/ListBuilder;", "list", "b", "I", "index", "c", "lastIndex", "<init>", "(Lkotlin/collections/builders/ListBuilder;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class a<E> implements ListIterator<E>, e2.f {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final ListBuilder<E> f55266a;

        /* renamed from: b  reason: collision with root package name */
        private int f55267b;

        /* renamed from: c  reason: collision with root package name */
        private int f55268c;

        public a(@NotNull ListBuilder<E> list, int i4) {
            f0.p(list, "list");
            this.f55266a = list;
            this.f55267b = i4;
            this.f55268c = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e4) {
            ListBuilder<E> listBuilder = this.f55266a;
            int i4 = this.f55267b;
            this.f55267b = i4 + 1;
            listBuilder.add(i4, e4);
            this.f55268c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f55267b < ((ListBuilder) this.f55266a).length;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f55267b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.f55267b < ((ListBuilder) this.f55266a).length) {
                int i4 = this.f55267b;
                this.f55267b = i4 + 1;
                this.f55268c = i4;
                return (E) ((ListBuilder) this.f55266a).array[((ListBuilder) this.f55266a).offset + this.f55268c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f55267b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i4 = this.f55267b;
            if (i4 > 0) {
                int i5 = i4 - 1;
                this.f55267b = i5;
                this.f55268c = i5;
                return (E) ((ListBuilder) this.f55266a).array[((ListBuilder) this.f55266a).offset + this.f55268c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f55267b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i4 = this.f55268c;
            if (i4 != -1) {
                this.f55266a.remove(i4);
                this.f55267b = this.f55268c;
                this.f55268c = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E e4) {
            int i4 = this.f55268c;
            if (i4 != -1) {
                this.f55266a.set(i4, e4);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    private ListBuilder(E[] eArr, int i4, int i5, boolean z3, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.array = eArr;
        this.offset = i4;
        this.length = i5;
        this.isReadOnly = z3;
        this.backing = listBuilder;
        this.root = listBuilder2;
    }

    private final void addAllInternal(int i4, Collection<? extends E> collection, int i5) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAllInternal(i4, collection, i5);
            this.array = this.backing.array;
            this.length += i5;
            return;
        }
        insertAtInternal(i4, i5);
        Iterator<? extends E> it = collection.iterator();
        for (int i6 = 0; i6 < i5; i6++) {
            this.array[i4 + i6] = it.next();
        }
    }

    private final void addAtInternal(int i4, E e4) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.addAtInternal(i4, e4);
            this.array = this.backing.array;
            this.length++;
            return;
        }
        insertAtInternal(i4, 1);
        this.array[i4] = e4;
    }

    private final void checkIsMutable() {
        if (isEffectivelyReadOnly()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean contentEquals(List<?> list) {
        boolean h4;
        h4 = b.h(this.array, this.offset, this.length, list);
        return h4;
    }

    private final void ensureCapacity(int i4) {
        if (this.backing != null) {
            throw new IllegalStateException();
        }
        if (i4 >= 0) {
            E[] eArr = this.array;
            if (i4 > eArr.length) {
                this.array = (E[]) b.e(this.array, k.f55337d.a(eArr.length, i4));
                return;
            }
            return;
        }
        throw new OutOfMemoryError();
    }

    private final void ensureExtraCapacity(int i4) {
        ensureCapacity(this.length + i4);
    }

    private final void insertAtInternal(int i4, int i5) {
        ensureExtraCapacity(i5);
        E[] eArr = this.array;
        o.c1(eArr, eArr, i4 + i5, i4, this.offset + this.length);
        this.length += i5;
    }

    private final boolean isEffectivelyReadOnly() {
        ListBuilder<E> listBuilder;
        return this.isReadOnly || ((listBuilder = this.root) != null && listBuilder.isReadOnly);
    }

    private final E removeAtInternal(int i4) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            this.length--;
            return listBuilder.removeAtInternal(i4);
        }
        E[] eArr = this.array;
        E e4 = eArr[i4];
        o.c1(eArr, eArr, i4, i4 + 1, this.offset + this.length);
        b.f(this.array, (this.offset + this.length) - 1);
        this.length--;
        return e4;
    }

    private final void removeRangeInternal(int i4, int i5) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            listBuilder.removeRangeInternal(i4, i5);
        } else {
            E[] eArr = this.array;
            o.c1(eArr, eArr, i4, i4 + i5, this.length);
            E[] eArr2 = this.array;
            int i6 = this.length;
            b.g(eArr2, i6 - i5, i6);
        }
        this.length -= i5;
    }

    private final int retainOrRemoveAllInternal(int i4, int i5, Collection<? extends E> collection, boolean z3) {
        ListBuilder<E> listBuilder = this.backing;
        if (listBuilder != null) {
            int retainOrRemoveAllInternal = listBuilder.retainOrRemoveAllInternal(i4, i5, collection, z3);
            this.length -= retainOrRemoveAllInternal;
            return retainOrRemoveAllInternal;
        }
        int i6 = 0;
        int i7 = 0;
        while (i6 < i5) {
            int i8 = i4 + i6;
            if (collection.contains(this.array[i8]) == z3) {
                E[] eArr = this.array;
                i6++;
                eArr[i7 + i4] = eArr[i8];
                i7++;
            } else {
                i6++;
            }
        }
        int i9 = i5 - i7;
        E[] eArr2 = this.array;
        o.c1(eArr2, eArr2, i4 + i7, i5 + i4, this.length);
        E[] eArr3 = this.array;
        int i10 = this.length;
        b.g(eArr3, i10 - i9, i10);
        this.length -= i9;
        return i9;
    }

    private final Object writeReplace() {
        if (isEffectivelyReadOnly()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e4) {
        checkIsMutable();
        addAtInternal(this.offset + this.length, e4);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(@NotNull Collection<? extends E> elements) {
        f0.p(elements, "elements");
        checkIsMutable();
        int size = elements.size();
        addAllInternal(this.offset + this.length, elements, size);
        return size > 0;
    }

    @NotNull
    public final List<E> build() {
        if (this.backing == null) {
            checkIsMutable();
            this.isReadOnly = true;
            return this;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        checkIsMutable();
        removeRangeInternal(this.offset, this.length);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        return obj == this || ((obj instanceof List) && contentEquals((List) obj));
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i4) {
        kotlin.collections.c.Companion.b(i4, this.length);
        return this.array[this.offset + i4];
    }

    @Override // kotlin.collections.f
    public int getSize() {
        return this.length;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i4;
        i4 = b.i(this.array, this.offset, this.length);
        return i4;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        for (int i4 = 0; i4 < this.length; i4++) {
            if (f0.g(this.array[this.offset + i4], obj)) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @NotNull
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        for (int i4 = this.length - 1; i4 >= 0; i4--) {
            if (f0.g(this.array[this.offset + i4], obj)) {
                return i4;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        checkIsMutable();
        int indexOf = indexOf(obj);
        if (indexOf >= 0) {
            remove(indexOf);
        }
        return indexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(@NotNull Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, false) > 0;
    }

    @Override // kotlin.collections.f
    public E removeAt(int i4) {
        checkIsMutable();
        kotlin.collections.c.Companion.b(i4, this.length);
        return removeAtInternal(this.offset + i4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(@NotNull Collection<? extends Object> elements) {
        f0.p(elements, "elements");
        checkIsMutable();
        return retainOrRemoveAllInternal(this.offset, this.length, elements, true) > 0;
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public E set(int i4, E e4) {
        checkIsMutable();
        kotlin.collections.c.Companion.b(i4, this.length);
        E[] eArr = this.array;
        int i5 = this.offset;
        E e5 = eArr[i5 + i4];
        eArr[i5 + i4] = e4;
        return e5;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public List<E> subList(int i4, int i5) {
        kotlin.collections.c.Companion.d(i4, i5, this.length);
        E[] eArr = this.array;
        int i6 = this.offset + i4;
        int i7 = i5 - i4;
        boolean z3 = this.isReadOnly;
        ListBuilder<E> listBuilder = this.root;
        return new ListBuilder(eArr, i6, i7, z3, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public <T> T[] toArray(@NotNull T[] destination) {
        f0.p(destination, "destination");
        int length = destination.length;
        int i4 = this.length;
        if (length < i4) {
            E[] eArr = this.array;
            int i5 = this.offset;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i5, i4 + i5, destination.getClass());
            f0.o(tArr, "copyOfRange(array, offse\u2026h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.array;
        int i6 = this.offset;
        o.c1(eArr2, destination, 0, i6, i4 + i6);
        int length2 = destination.length;
        int i7 = this.length;
        if (length2 > i7) {
            destination[i7] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    @NotNull
    public String toString() {
        String j4;
        j4 = b.j(this.array, this.offset, this.length);
        return j4;
    }

    @Override // java.util.AbstractList, java.util.List
    @NotNull
    public ListIterator<E> listIterator(int i4) {
        kotlin.collections.c.Companion.c(i4, this.length);
        return new a(this, i4);
    }

    @Override // kotlin.collections.f, java.util.AbstractList, java.util.List
    public void add(int i4, E e4) {
        checkIsMutable();
        kotlin.collections.c.Companion.c(i4, this.length);
        addAtInternal(this.offset + i4, e4);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i4, @NotNull Collection<? extends E> elements) {
        f0.p(elements, "elements");
        checkIsMutable();
        kotlin.collections.c.Companion.c(i4, this.length);
        int size = elements.size();
        addAllInternal(this.offset + i4, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    @NotNull
    public Object[] toArray() {
        Object[] M1;
        E[] eArr = this.array;
        int i4 = this.offset;
        M1 = o.M1(eArr, i4, this.length + i4);
        return M1;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i4) {
        this(b.d(i4), 0, 0, false, null, null);
    }
}
