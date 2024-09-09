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
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkotlin/sequences/v;", "T", "Lkotlin/sequences/m;", "Lkotlin/sequences/e;", "", "n", "a", "b", "", "iterator", "Lkotlin/sequences/m;", InAppSlotParams.SLOT_KEY.SEQ, "I", "count", "<init>", "(Lkotlin/sequences/m;I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v<T> implements m<T>, e<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m<T> f58860a;

    /* renamed from: b  reason: collision with root package name */
    private final int f58861b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Sequences.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0012"}, d2 = {"kotlin/sequences/v$a", "", "next", "()Ljava/lang/Object;", "", "hasNext", "", "a", "I", "d", "()I", "e", "(I)V", "left", "b", "Ljava/util/Iterator;", "()Ljava/util/Iterator;", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements Iterator<T>, e2.a {

        /* renamed from: a  reason: collision with root package name */
        private int f58862a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final Iterator<T> f58863b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ v<T> f58864c;

        a(v<T> vVar) {
            this.f58864c = vVar;
            this.f58862a = ((v) vVar).f58861b;
            this.f58863b = ((v) vVar).f58860a.iterator();
        }

        @NotNull
        public final Iterator<T> a() {
            return this.f58863b;
        }

        public final int d() {
            return this.f58862a;
        }

        public final void e(int i4) {
            this.f58862a = i4;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f58862a > 0 && this.f58863b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i4 = this.f58862a;
            if (i4 != 0) {
                this.f58862a = i4 - 1;
                return this.f58863b.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public v(@NotNull m<? extends T> sequence, int i4) {
        f0.p(sequence, "sequence");
        this.f58860a = sequence;
        this.f58861b = i4;
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i4 + '.').toString());
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> a(int i4) {
        m<T> j4;
        int i5 = this.f58861b;
        if (i4 >= i5) {
            j4 = s.j();
            return j4;
        }
        return new u(this.f58860a, i4, i5);
    }

    @Override // kotlin.sequences.e
    @NotNull
    public m<T> b(int i4) {
        return i4 >= this.f58861b ? this : new v(this.f58860a, i4);
    }

    @Override // kotlin.sequences.m
    @NotNull
    public Iterator<T> iterator() {
        return new a(this);
    }
}
