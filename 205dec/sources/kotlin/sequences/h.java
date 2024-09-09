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
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B3\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u0010"}, d2 = {"Lkotlin/sequences/h;", "T", "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", InAppSlotParams.SLOT_KEY.SEQ, "", "b", "Z", "sendWhen", "Lkotlin/Function1;", "predicate", "<init>", "(Lkotlin/sequences/m;ZLd2/l;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h<T> implements m<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m<T> f58790a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f58791b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d2.l<T, Boolean> f58792c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0019\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"kotlin/sequences/h$a", "", "Lkotlin/f1;", "a", "next", "()Ljava/lang/Object;", "", "hasNext", "Ljava/util/Iterator;", "d", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "f", "()I", "h", "(I)V", "nextState", "c", "Ljava/lang/Object;", "e", "g", "(Ljava/lang/Object;)V", "nextItem", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<T>, e2.a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<T> f58793a;

        /* renamed from: b  reason: collision with root package name */
        private int f58794b = -1;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private T f58795c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h<T> f58796d;

        a(h<T> hVar) {
            this.f58796d = hVar;
            this.f58793a = ((h) hVar).f58790a.iterator();
        }

        private final void a() {
            while (this.f58793a.hasNext()) {
                T next = this.f58793a.next();
                if (((Boolean) ((h) this.f58796d).f58792c.invoke(next)).booleanValue() == ((h) this.f58796d).f58791b) {
                    this.f58795c = next;
                    this.f58794b = 1;
                    return;
                }
            }
            this.f58794b = 0;
        }

        @NotNull
        public final Iterator<T> d() {
            return this.f58793a;
        }

        @Nullable
        public final T e() {
            return this.f58795c;
        }

        public final int f() {
            return this.f58794b;
        }

        public final void g(@Nullable T t3) {
            this.f58795c = t3;
        }

        public final void h(int i4) {
            this.f58794b = i4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f58794b == -1) {
                a();
            }
            return this.f58794b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f58794b == -1) {
                a();
            }
            if (this.f58794b != 0) {
                T t3 = this.f58795c;
                this.f58795c = null;
                this.f58794b = -1;
                return t3;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(@NotNull m<? extends T> sequence, boolean z3, @NotNull d2.l<? super T, Boolean> predicate) {
        f0.p(sequence, "sequence");
        f0.p(predicate, "predicate");
        this.f58790a = sequence;
        this.f58791b = z3;
        this.f58792c = predicate;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }

    public /* synthetic */ h(m mVar, boolean z3, d2.l lVar, int i4, kotlin.jvm.internal.u uVar) {
        this(mVar, (i4 & 2) != 0 ? true : z3, lVar);
    }
}
