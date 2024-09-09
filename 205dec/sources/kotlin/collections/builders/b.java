package kotlin.collections.builders;

import com.acse.ottn.f3;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ListBuilder.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a#\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\n\u001a\u00020\t\"\u0004\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\f\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0002\u00a2\u0006\u0004\b\f\u0010\r\u001a;\u0010\u0011\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0013\u001a\u00020\u0001H\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0018\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0016\u001a\u00020\u0001H\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019\u001a/\u0010\u001c\u001a\u00020\u0017\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u0001H\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u00a8\u0006\u001e"}, d2 = {"E", "", "size", "", "d", "(I)[Ljava/lang/Object;", "T", "offset", "length", "", "j", "([Ljava/lang/Object;II)Ljava/lang/String;", "i", "([Ljava/lang/Object;II)I", "", "other", "", "h", "([Ljava/lang/Object;IILjava/util/List;)Z", "newSize", "e", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "index", "Lkotlin/f1;", "f", "([Ljava/lang/Object;I)V", "fromIndex", "toIndex", "g", "([Ljava/lang/Object;II)V", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b {

    /* compiled from: ListBuilder.kt */
    @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\b\u0016\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0012\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0004\u001a\u00020\u0003H\u0016J\t\u0010\u0005\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u000f\u0010\t\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00028\u0001H\u0096\u0002\u00a2\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\b\u0010\u0011\u001a\u00020\rH\u0016R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lkotlin/collections/builders/b$a;", "E", "", "", "hasPrevious", "hasNext", "", "previousIndex", "nextIndex", "previous", "()Ljava/lang/Object;", "next", "element", "Lkotlin/f1;", f3.f5659h, "(Ljava/lang/Object;)V", "add", "remove", "Lkotlin/collections/builders/b;", "a", "Lkotlin/collections/builders/b;", "list", "b", "I", "index", "c", "lastIndex", "<init>", "(Lkotlin/collections/builders/b;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    private static final class a<E> implements ListIterator<E>, m1.f {

        /* renamed from: a  reason: collision with root package name */
        private final b<E> f55274a;

        /* renamed from: b  reason: collision with root package name */
        private int f55275b;

        /* renamed from: c  reason: collision with root package name */
        private int f55276c;

        public a(@NotNull b<E> list, int i4) {
            f0.p(list, "list");
            this.f55274a = list;
            this.f55275b = i4;
            this.f55276c = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e4) {
            b<E> bVar = this.f55274a;
            int i4 = this.f55275b;
            this.f55275b = i4 + 1;
            bVar.add(i4, e4);
            this.f55276c = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f55275b < b.e(this.f55274a);
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f55275b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.f55275b < b.e(this.f55274a)) {
                int i4 = this.f55275b;
                this.f55275b = i4 + 1;
                this.f55276c = i4;
                return (E) b.d(this.f55274a)[b.f(this.f55274a) + this.f55276c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f55275b;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i4 = this.f55275b;
            if (i4 > 0) {
                int i5 = i4 - 1;
                this.f55275b = i5;
                this.f55276c = i5;
                return (E) b.d(this.f55274a)[b.f(this.f55274a) + this.f55276c];
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f55275b - 1;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.collections.builders.b<E>, kotlin.collections.g] */
        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i4 = this.f55276c;
            if (i4 != -1) {
                this.f55274a.remove(i4);
                this.f55275b = this.f55276c;
                this.f55276c = -1;
                return;
            }
            throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
        }

        @Override // java.util.ListIterator
        public void set(E e4) {
            int i4 = this.f55276c;
            if (i4 != -1) {
                this.f55274a.set(i4, e4);
                return;
            }
            throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
        }
    }

    @NotNull
    public static final <E> E[] d(int i4) {
        if (i4 >= 0) {
            return (E[]) new Object[i4];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    @NotNull
    public static final <T> T[] e(@NotNull T[] tArr, int i4) {
        f0.p(tArr, "<this>");
        T[] tArr2 = (T[]) Arrays.copyOf(tArr, i4);
        f0.o(tArr2, "copyOf(this, newSize)");
        return tArr2;
    }

    public static final <E> void f(@NotNull E[] eArr, int i4) {
        f0.p(eArr, "<this>");
        eArr[i4] = null;
    }

    public static final <E> void g(@NotNull E[] eArr, int i4, int i5) {
        f0.p(eArr, "<this>");
        while (i4 < i5) {
            f(eArr, i4);
            i4++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean h(T[] tArr, int i4, int i5, List<?> list) {
        if (i5 != list.size()) {
            return false;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!f0.g(tArr[i4 + i6], list.get(i6))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> int i(T[] tArr, int i4, int i5) {
        int i6 = 1;
        for (int i7 = 0; i7 < i5; i7++) {
            T t3 = tArr[i4 + i7];
            i6 = (i6 * 31) + (t3 == null ? 0 : t3.hashCode());
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> String j(T[] tArr, int i4, int i5) {
        StringBuilder sb = new StringBuilder((i5 * 3) + 2);
        sb.append("[");
        for (int i6 = 0; i6 < i5; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            sb.append(tArr[i4 + i6]);
        }
        sb.append("]");
        String sb2 = sb.toString();
        f0.o(sb2, "sb.toString()");
        return sb2;
    }
}
