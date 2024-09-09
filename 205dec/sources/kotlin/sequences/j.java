package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Sequences.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B-\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0096\u0002\u00a8\u0006\f"}, d2 = {"Lkotlin/sequences/j;", "", "T", "Lkotlin/sequences/m;", "", "iterator", "Lkotlin/Function0;", "getInitialValue", "Lkotlin/Function1;", "getNextValue", "<init>", "(Ld2/a;Ld2/l;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j<T> implements m<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final d2.a<T> f58803a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.l<T, T> f58804b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R$\u0010\f\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u000bR\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"kotlin/sequences/j$a", "", "Lkotlin/f1;", "a", "next", "()Ljava/lang/Object;", "", "hasNext", "Ljava/lang/Object;", "d", "f", "(Ljava/lang/Object;)V", "nextItem", "", "b", "I", "e", "()I", "g", "(I)V", "nextState", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<T>, e2.a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private T f58805a;

        /* renamed from: b  reason: collision with root package name */
        private int f58806b = -2;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ j<T> f58807c;

        a(j<T> jVar) {
            this.f58807c = jVar;
        }

        private final void a() {
            T t3;
            if (this.f58806b == -2) {
                t3 = (T) ((j) this.f58807c).f58803a.invoke();
            } else {
                d2.l lVar = ((j) this.f58807c).f58804b;
                T t4 = this.f58805a;
                f0.m(t4);
                t3 = (T) lVar.invoke(t4);
            }
            this.f58805a = t3;
            this.f58806b = t3 == null ? 0 : 1;
        }

        @Nullable
        public final T d() {
            return this.f58805a;
        }

        public final int e() {
            return this.f58806b;
        }

        public final void f(@Nullable T t3) {
            this.f58805a = t3;
        }

        public final void g(int i4) {
            this.f58806b = i4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f58806b < 0) {
                a();
            }
            return this.f58806b == 1;
        }

        @Override // java.util.Iterator
        @NotNull
        public T next() {
            if (this.f58806b < 0) {
                a();
            }
            if (this.f58806b != 0) {
                T t3 = this.f58805a;
                if (t3 != null) {
                    this.f58806b = -1;
                    return t3;
                }
                throw new NullPointerException("null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(@NotNull d2.a<? extends T> getInitialValue, @NotNull d2.l<? super T, ? extends T> getNextValue) {
        f0.p(getInitialValue, "getInitialValue");
        f0.p(getNextValue, "getNextValue");
        this.f58803a = getInitialValue;
        this.f58804b = getNextValue;
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
