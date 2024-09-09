package kotlin.collections;

import com.acse.ottn.f3;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SlidingWindow.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e\u0012\u0006\u0010(\u001a\u00020\u0005\u00a2\u0006\u0004\b)\u0010*B\u0011\b\u0016\u0012\u0006\u0010 \u001a\u00020\u0005\u00a2\u0006\u0004\b)\u0010+J\u0015\u0010\u0007\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0082\bJ\u0018\u0010\t\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0005H\u0096\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0006\u001a\u00020\u000bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\fH\u0096\u0002J)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e\"\u0004\b\u0001\u0010\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000eH\u0014\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000eH\u0014\u00a2\u0006\u0004\b\u0010\u0010\u0013J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0014\u001a\u00020\u0005J\u0015\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0005R\u001c\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR$\u0010'\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00058\u0016@RX\u0096\u000e\u00a2\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lkotlin/collections/g1;", "T", "Lkotlin/collections/c;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "n", "m", "index", f3.f5657f, "(I)Ljava/lang/Object;", "", "", "iterator", "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "maxCapacity", "l", "element", "Lkotlin/f1;", "k", "(Ljava/lang/Object;)V", "o", "a", "[Ljava/lang/Object;", "buffer", "b", "I", "capacity", "c", "startIndex", "<set-?>", "d", "getSize", "()I", "size", "filledSize", "<init>", "([Ljava/lang/Object;I)V", "(I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class g1<T> extends c<T> implements RandomAccess {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f55325a;

    /* renamed from: b  reason: collision with root package name */
    private final int f55326b;

    /* renamed from: c  reason: collision with root package name */
    private int f55327c;

    /* renamed from: d  reason: collision with root package name */
    private int f55328d;

    /* compiled from: SlidingWindow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0006\u00a8\u0006\n"}, d2 = {"kotlin/collections/g1$a", "Lkotlin/collections/b;", "Lkotlin/f1;", "a", "", "c", "I", "count", "d", "index", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends b<T> {

        /* renamed from: c  reason: collision with root package name */
        private int f55329c;

        /* renamed from: d  reason: collision with root package name */
        private int f55330d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ g1<T> f55331e;

        a(g1<T> g1Var) {
            this.f55331e = g1Var;
            this.f55329c = g1Var.size();
            this.f55330d = ((g1) g1Var).f55327c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.b
        protected void a() {
            if (this.f55329c == 0) {
                d();
                return;
            }
            e(((g1) this.f55331e).f55325a[this.f55330d]);
            this.f55330d = (this.f55330d + 1) % ((g1) this.f55331e).f55326b;
            this.f55329c--;
        }
    }

    public g1(@NotNull Object[] buffer, int i4) {
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        this.f55325a = buffer;
        if (i4 >= 0) {
            if (i4 <= buffer.length) {
                this.f55326b = buffer.length;
                this.f55328d = i4;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i4 + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("ring buffer filled size should not be negative but it is ", Integer.valueOf(i4)).toString());
    }

    private final int m(int i4, int i5) {
        return (i4 + i5) % this.f55326b;
    }

    @Override // kotlin.collections.c, java.util.List
    public T get(int i4) {
        c.Companion.b(i4, size());
        return (T) this.f55325a[(this.f55327c + i4) % this.f55326b];
    }

    @Override // kotlin.collections.c, kotlin.collections.a
    public int getSize() {
        return this.f55328d;
    }

    @Override // kotlin.collections.c, kotlin.collections.a, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    public final void k(T t3) {
        if (!n()) {
            this.f55325a[(this.f55327c + size()) % this.f55326b] = t3;
            this.f55328d = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final g1<T> l(int i4) {
        int u3;
        Object[] array;
        int i5 = this.f55326b;
        u3 = kotlin.ranges.q.u(i5 + (i5 >> 1) + 1, i4);
        if (this.f55327c == 0) {
            array = Arrays.copyOf(this.f55325a, u3);
            kotlin.jvm.internal.f0.o(array, "copyOf(this, newSize)");
        } else {
            array = toArray(new Object[u3]);
        }
        return new g1<>(array, size());
    }

    public final boolean n() {
        return size() == this.f55326b;
    }

    public final void o(int i4) {
        if (i4 >= 0) {
            if (!(i4 <= size())) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i4 + ", size = " + size()).toString());
            } else if (i4 > 0) {
                int i5 = this.f55327c;
                int i6 = (i5 + i4) % this.f55326b;
                if (i5 > i6) {
                    o.n2(this.f55325a, null, i5, this.f55326b);
                    o.n2(this.f55325a, null, 0, i6);
                } else {
                    o.n2(this.f55325a, null, i5, i6);
                }
                this.f55327c = i6;
                this.f55328d = size() - i4;
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("n shouldn't be negative but it is ", Integer.valueOf(i4)).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.a, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        kotlin.jvm.internal.f0.p(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            kotlin.jvm.internal.f0.o(array, "copyOf(this, newSize)");
        }
        int size = size();
        int i4 = 0;
        int i5 = 0;
        for (int i6 = this.f55327c; i5 < size && i6 < this.f55326b; i6++) {
            array[i5] = this.f55325a[i6];
            i5++;
        }
        while (i5 < size) {
            array[i5] = this.f55325a[i4];
            i5++;
            i4++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    public g1(int i4) {
        this(new Object[i4], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.a, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
