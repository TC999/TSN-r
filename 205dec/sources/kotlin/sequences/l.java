package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B=\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0096\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lkotlin/sequences/l;", "T1", "T2", "V", "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", "sequence1", "b", "sequence2", "Lkotlin/Function2;", "transform", "<init>", "(Lkotlin/sequences/m;Lkotlin/sequences/m;Ld2/p;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l<T1, T2, V> implements m<V> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m<T1> f58812a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final m<T2> f58813b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d2.p<T1, T2, V> f58814c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\b\u00a8\u0006\r"}, d2 = {"kotlin/sequences/l$a", "", "next", "()Ljava/lang/Object;", "", "hasNext", "a", "Ljava/util/Iterator;", "()Ljava/util/Iterator;", "iterator1", "b", "d", "iterator2", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<V>, e2.a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T1> f58815a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final Iterator<T2> f58816b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<T1, T2, V> f58817c;

        a(l<T1, T2, V> lVar) {
            this.f58817c = lVar;
            this.f58815a = ((l) lVar).f58812a.iterator();
            this.f58816b = ((l) lVar).f58813b.iterator();
        }

        @NotNull
        public final Iterator<T1> a() {
            return this.f58815a;
        }

        @NotNull
        public final Iterator<T2> d() {
            return this.f58816b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f58815a.hasNext() && this.f58816b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) ((l) this.f58817c).f58814c.invoke(this.f58815a.next(), this.f58816b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(@NotNull m<? extends T1> sequence1, @NotNull m<? extends T2> sequence2, @NotNull d2.p<? super T1, ? super T2, ? extends V> transform) {
        f0.p(sequence1, "sequence1");
        f0.p(sequence2, "sequence2");
        f0.p(transform, "transform");
        this.f58812a = sequence1;
        this.f58813b = sequence2;
        this.f58814c = transform;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<V> iterator() {
        return new a(this);
    }
}
