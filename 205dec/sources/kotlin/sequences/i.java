package kotlin.sequences;

import cn.jpush.android.api.InAppSlotParams;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004BC\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00050\n\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0096\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lkotlin/sequences/i;", "T", "R", "E", "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", InAppSlotParams.SLOT_KEY.SEQ, "Lkotlin/Function1;", "transformer", "<init>", "(Lkotlin/sequences/m;Ld2/l;Ld2/l;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i<T, R, E> implements m<E> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m<T> f58797a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.l<T, R> f58798b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d2.l<R, Iterator<E>> f58799c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0002H\u0096\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"kotlin/sequences/i$a", "", "", "a", "next", "()Ljava/lang/Object;", "hasNext", "Ljava/util/Iterator;", "e", "()Ljava/util/Iterator;", "iterator", "b", "d", "f", "(Ljava/util/Iterator;)V", "itemIterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<E>, e2.a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f58800a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private Iterator<? extends E> f58801b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i<T, R, E> f58802c;

        a(i<T, R, E> iVar) {
            this.f58802c = iVar;
            this.f58800a = ((i) iVar).f58797a.iterator();
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final boolean a() {
            /*
                r5 = this;
                java.util.Iterator<? extends E> r0 = r5.f58801b
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L8
            L6:
                r0 = 0
                goto Lf
            L8:
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L6
                r0 = 1
            Lf:
                if (r0 == 0) goto L14
                r0 = 0
                r5.f58801b = r0
            L14:
                java.util.Iterator<? extends E> r0 = r5.f58801b
                if (r0 != 0) goto L45
                java.util.Iterator<T> r0 = r5.f58800a
                boolean r0 = r0.hasNext()
                if (r0 != 0) goto L21
                return r2
            L21:
                java.util.Iterator<T> r0 = r5.f58800a
                java.lang.Object r0 = r0.next()
                kotlin.sequences.i<T, R, E> r3 = r5.f58802c
                d2.l r3 = kotlin.sequences.i.c(r3)
                kotlin.sequences.i<T, R, E> r4 = r5.f58802c
                d2.l r4 = kotlin.sequences.i.e(r4)
                java.lang.Object r0 = r4.invoke(r0)
                java.lang.Object r0 = r3.invoke(r0)
                java.util.Iterator r0 = (java.util.Iterator) r0
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L14
                r5.f58801b = r0
            L45:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.i.a.a():boolean");
        }

        @Nullable
        public final Iterator<E> d() {
            return (Iterator<? extends E>) this.f58801b;
        }

        @NotNull
        public final Iterator<T> e() {
            return this.f58800a;
        }

        public final void f(@Nullable Iterator<? extends E> it) {
            this.f58801b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (a()) {
                Iterator<? extends E> it = this.f58801b;
                f0.m(it);
                return it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull m<? extends T> sequence, @NotNull d2.l<? super T, ? extends R> transformer, @NotNull d2.l<? super R, ? extends Iterator<? extends E>> iterator) {
        f0.p(sequence, "sequence");
        f0.p(transformer, "transformer");
        f0.p(iterator, "iterator");
        this.f58797a = sequence;
        this.f58798b = transformer;
        this.f58799c = iterator;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<E> iterator() {
        return new a(this);
    }
}
