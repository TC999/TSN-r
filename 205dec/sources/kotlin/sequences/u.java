package kotlin.sequences;

import cn.jpush.android.api.InAppSlotParams;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lkotlin/sequences/u;", "T", "Lkotlin/sequences/m;", "Lkotlin/sequences/e;", "", "n", "a", "b", "", "iterator", "Lkotlin/sequences/m;", InAppSlotParams.SLOT_KEY.SEQ, "I", "startIndex", "c", "endIndex", "f", "()I", "count", "<init>", "(Lkotlin/sequences/m;II)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u<T> implements m<T>, e<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m<T> f58854a;

    /* renamed from: b  reason: collision with root package name */
    private final int f58855b;

    /* renamed from: c  reason: collision with root package name */
    private final int f58856c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002J\u0010\u0010\u0006\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"kotlin/sequences/u$a", "", "Lkotlin/f1;", "a", "", "hasNext", "next", "()Ljava/lang/Object;", "Ljava/util/Iterator;", "d", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "e", "()I", "f", "(I)V", "position", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<T>, e2.a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f58857a;

        /* renamed from: b  reason: collision with root package name */
        private int f58858b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ u<T> f58859c;

        a(u<T> uVar) {
            this.f58859c = uVar;
            this.f58857a = ((u) uVar).f58854a.iterator();
        }

        private final void a() {
            while (this.f58858b < ((u) this.f58859c).f58855b && this.f58857a.hasNext()) {
                this.f58857a.next();
                this.f58858b++;
            }
        }

        @NotNull
        public final Iterator<T> d() {
            return this.f58857a;
        }

        public final int e() {
            return this.f58858b;
        }

        public final void f(int i4) {
            this.f58858b = i4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f58858b < ((u) this.f58859c).f58856c && this.f58857a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            if (this.f58858b < ((u) this.f58859c).f58856c) {
                this.f58858b++;
                return this.f58857a.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(@NotNull m<? extends T> sequence, int i4, int i5) {
        f0.p(sequence, "sequence");
        this.f58854a = sequence;
        this.f58855b = i4;
        this.f58856c = i5;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(f0.C("startIndex should be non-negative, but is ", Integer.valueOf(i4)).toString());
        }
        if (!(i5 >= 0)) {
            throw new IllegalArgumentException(f0.C("endIndex should be non-negative, but is ", Integer.valueOf(i5)).toString());
        }
        if (i5 >= i4) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i5 + " < " + i4).toString());
    }

    private final int f() {
        return this.f58856c - this.f58855b;
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> a(int i4) {
        m<T> j4;
        if (i4 >= f()) {
            j4 = s.j();
            return j4;
        }
        return new u(this.f58854a, this.f58855b + i4, this.f58856c);
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> b(int i4) {
        if (i4 >= f()) {
            return this;
        }
        m<T> mVar = this.f58854a;
        int i5 = this.f58855b;
        return new u(mVar, i5, i4 + i5);
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
