package kotlin.sequences;

import cn.jpush.android.api.InAppSlotParams;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.o0;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0004H\u0096\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkotlin/sequences/k;", "T", "Lkotlin/sequences/m;", "Lkotlin/collections/o0;", "", "iterator", "a", "Lkotlin/sequences/m;", InAppSlotParams.SLOT_KEY.SEQ, "<init>", "(Lkotlin/sequences/m;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k<T> implements m<o0<? extends T>> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m<T> f58808a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"kotlin/sequences/k$a", "", "Lkotlin/collections/o0;", "e", "", "hasNext", "a", "Ljava/util/Iterator;", "d", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "()I", "f", "(I)V", "index", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<o0<? extends T>>, e2.a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f58809a;

        /* renamed from: b  reason: collision with root package name */
        private int f58810b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ k<T> f58811c;

        a(k<T> kVar) {
            this.f58811c = kVar;
            this.f58809a = ((k) kVar).f58808a.iterator();
        }

        public final int a() {
            return this.f58810b;
        }

        @NotNull
        public final Iterator<T> d() {
            return this.f58809a;
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: e */
        public o0<T> next() {
            int i4 = this.f58810b;
            this.f58810b = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            return new o0<>(i4, this.f58809a.next());
        }

        public final void f(int i4) {
            this.f58810b = i4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f58809a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(@NotNull m<? extends T> sequence) {
        f0.p(sequence, "sequence");
        this.f58808a = sequence;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<o0<T>> iterator() {
        return new a(this);
    }
}
