package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p620m1.KMarkers;

/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\r"}, m12616d2 = {"Lkotlin/sequences/w;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", "sequence", "Lkotlin/Function1;", "", "predicate", "<init>", "(Lkotlin/sequences/m;Ll1/l;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.w */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14536w<T> implements Sequence<T> {

    /* renamed from: a */
    private final Sequence<T> f41514a;

    /* renamed from: b */
    private final InterfaceC15280l<T, Boolean> f41515b;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, m12616d2 = {"kotlin/sequences/w$a", "", "Lkotlin/f1;", "a", "next", "()Ljava/lang/Object;", "", "hasNext", "Ljava/util/Iterator;", "c", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "e", "()I", "g", "(I)V", "nextState", "Ljava/lang/Object;", "d", "f", "(Ljava/lang/Object;)V", "nextItem", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.w$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14537a implements Iterator<T>, KMarkers {
        @NotNull

        /* renamed from: a */
        private final Iterator<T> f41516a;

        /* renamed from: b */
        private int f41517b = -1;
        @Nullable

        /* renamed from: c */
        private T f41518c;

        C14537a() {
            this.f41516a = C14536w.this.f41514a.iterator();
        }

        /* renamed from: a */
        private final void m6949a() {
            if (this.f41516a.hasNext()) {
                T next = this.f41516a.next();
                if (((Boolean) C14536w.this.f41515b.invoke(next)).booleanValue()) {
                    this.f41517b = 1;
                    this.f41518c = next;
                    return;
                }
            }
            this.f41517b = 0;
        }

        @NotNull
        /* renamed from: c */
        public final Iterator<T> m6948c() {
            return this.f41516a;
        }

        @Nullable
        /* renamed from: d */
        public final T m6947d() {
            return this.f41518c;
        }

        /* renamed from: e */
        public final int m6946e() {
            return this.f41517b;
        }

        /* renamed from: f */
        public final void m6945f(@Nullable T t) {
            this.f41518c = t;
        }

        /* renamed from: g */
        public final void m6944g(int i) {
            this.f41517b = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f41517b == -1) {
                m6949a();
            }
            return this.f41517b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f41517b == -1) {
                m6949a();
            }
            if (this.f41517b != 0) {
                T t = this.f41518c;
                this.f41518c = null;
                this.f41517b = -1;
                return t;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14536w(@NotNull Sequence<? extends T> sequence, @NotNull InterfaceC15280l<? super T, Boolean> predicate) {
        C14342f0.m8184p(sequence, "sequence");
        C14342f0.m8184p(predicate, "predicate");
        this.f41514a = sequence;
        this.f41515b = predicate;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new C14537a();
    }
}
