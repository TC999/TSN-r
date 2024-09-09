package kotlin.sequences;

import cn.jpush.android.api.InAppSlotParams;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B/\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t\u00a2\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lkotlin/sequences/x;", "T", "R", "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", InAppSlotParams.SLOT_KEY.SEQ, "Lkotlin/Function2;", "", "transformer", "<init>", "(Lkotlin/sequences/m;Ld2/p;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class x<T, R> implements m<R> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m<T> f58871a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.p<Integer, T, R> f58872b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"kotlin/sequences/x$a", "", "next", "()Ljava/lang/Object;", "", "hasNext", "a", "Ljava/util/Iterator;", "d", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "()I", "e", "(I)V", "index", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<R>, e2.a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f58873a;

        /* renamed from: b  reason: collision with root package name */
        private int f58874b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ x<T, R> f58875c;

        a(x<T, R> xVar) {
            this.f58875c = xVar;
            this.f58873a = ((x) xVar).f58871a.iterator();
        }

        public final int a() {
            return this.f58874b;
        }

        @NotNull
        public final Iterator<T> d() {
            return this.f58873a;
        }

        public final void e(int i4) {
            this.f58874b = i4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f58873a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            d2.p pVar = ((x) this.f58875c).f58872b;
            int i4 = this.f58874b;
            this.f58874b = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            return (R) pVar.invoke(Integer.valueOf(i4), this.f58873a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(@NotNull m<? extends T> sequence, @NotNull d2.p<? super Integer, ? super T, ? extends R> transformer) {
        f0.p(sequence, "sequence");
        f0.p(transformer, "transformer");
        this.f58871a = sequence;
        this.f58872b = transformer;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<R> iterator() {
        return new a(this);
    }
}
