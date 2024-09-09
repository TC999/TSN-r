package kotlin.sequences;

import cn.jpush.android.api.InAppSlotParams;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkotlin/sequences/d;", "T", "Lkotlin/sequences/m;", "Lkotlin/sequences/e;", "", "n", "a", "b", "", "iterator", "Lkotlin/sequences/m;", InAppSlotParams.SLOT_KEY.SEQ, "I", "count", "<init>", "(Lkotlin/sequences/m;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d<T> implements m<T>, e<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m<T> f58778a;

    /* renamed from: b  reason: collision with root package name */
    private final int f58779b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"kotlin/sequences/d$a", "", "Lkotlin/f1;", "a", "next", "()Ljava/lang/Object;", "", "hasNext", "Ljava/util/Iterator;", "d", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "e", "()I", "f", "(I)V", "left", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<T>, e2.a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f58780a;

        /* renamed from: b  reason: collision with root package name */
        private int f58781b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d<T> f58782c;

        a(d<T> dVar) {
            this.f58782c = dVar;
            this.f58780a = ((d) dVar).f58778a.iterator();
            this.f58781b = ((d) dVar).f58779b;
        }

        private final void a() {
            while (this.f58781b > 0 && this.f58780a.hasNext()) {
                this.f58780a.next();
                this.f58781b--;
            }
        }

        @NotNull
        public final Iterator<T> d() {
            return this.f58780a;
        }

        public final int e() {
            return this.f58781b;
        }

        public final void f(int i4) {
            this.f58781b = i4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.f58780a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.f58780a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull m<? extends T> sequence, int i4) {
        f0.p(sequence, "sequence");
        this.f58778a = sequence;
        this.f58779b = i4;
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i4 + '.').toString());
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> a(int i4) {
        int i5 = this.f58779b + i4;
        return i5 < 0 ? new d(this, i4) : new d(this.f58778a, i5);
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> b(int i4) {
        int i5 = this.f58779b;
        int i6 = i5 + i4;
        return i6 < 0 ? new v(this, i4) : new u(this.f58778a, i5, i6);
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
