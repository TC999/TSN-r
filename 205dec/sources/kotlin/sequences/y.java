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
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B)\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J5\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0002\u0010\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00040\u0007H\u0000\u00a2\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lkotlin/sequences/y;", "T", "R", "Lkotlin/sequences/m;", "", "iterator", "E", "Lkotlin/Function1;", "e", "(Ld2/l;)Lkotlin/sequences/m;", "a", "Lkotlin/sequences/m;", InAppSlotParams.SLOT_KEY.SEQ, "transformer", "<init>", "(Lkotlin/sequences/m;Ld2/l;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y<T, R> implements m<R> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m<T> f58876a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.l<T, R> f58877b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\n"}, d2 = {"kotlin/sequences/y$a", "", "next", "()Ljava/lang/Object;", "", "hasNext", "a", "Ljava/util/Iterator;", "()Ljava/util/Iterator;", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<R>, e2.a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f58878a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ y<T, R> f58879b;

        a(y<T, R> yVar) {
            this.f58879b = yVar;
            this.f58878a = ((y) yVar).f58876a.iterator();
        }

        @NotNull
        public final Iterator<T> a() {
            return this.f58878a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f58878a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) ((y) this.f58879b).f58877b.invoke(this.f58878a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y(@NotNull m<? extends T> sequence, @NotNull d2.l<? super T, ? extends R> transformer) {
        f0.p(sequence, "sequence");
        f0.p(transformer, "transformer");
        this.f58876a = sequence;
        this.f58877b = transformer;
    }

    @NotNull
    public final <E> m<E> e(@NotNull d2.l<? super R, ? extends Iterator<? extends E>> iterator) {
        f0.p(iterator, "iterator");
        return new i(this.f58876a, this.f58877b, iterator);
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<R> iterator() {
        return new a(this);
    }
}
