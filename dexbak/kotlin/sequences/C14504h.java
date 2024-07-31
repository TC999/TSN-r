package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p620m1.KMarkers;

/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B3\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0010"}, m12616d2 = {"Lkotlin/sequences/h;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", "sequence", "", "b", "Z", "sendWhen", "Lkotlin/Function1;", "predicate", "<init>", "(Lkotlin/sequences/m;ZLl1/l;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14504h<T> implements Sequence<T> {

    /* renamed from: a */
    private final Sequence<T> f41439a;

    /* renamed from: b */
    private final boolean f41440b;

    /* renamed from: c */
    private final InterfaceC15280l<T, Boolean> f41441c;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0018\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0005\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, m12616d2 = {"kotlin/sequences/h$a", "", "Lkotlin/f1;", "a", "next", "()Ljava/lang/Object;", "", "hasNext", "Ljava/util/Iterator;", "c", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "e", "()I", "g", "(I)V", "nextState", "Ljava/lang/Object;", "d", "f", "(Ljava/lang/Object;)V", "nextItem", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.h$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14505a implements Iterator<T>, KMarkers {
        @NotNull

        /* renamed from: a */
        private final Iterator<T> f41442a;

        /* renamed from: b */
        private int f41443b = -1;
        @Nullable

        /* renamed from: c */
        private T f41444c;

        C14505a() {
            this.f41442a = C14504h.this.f41439a.iterator();
        }

        /* renamed from: a */
        private final void m7052a() {
            while (this.f41442a.hasNext()) {
                T next = this.f41442a.next();
                if (((Boolean) C14504h.this.f41441c.invoke(next)).booleanValue() == C14504h.this.f41440b) {
                    this.f41444c = next;
                    this.f41443b = 1;
                    return;
                }
            }
            this.f41443b = 0;
        }

        @NotNull
        /* renamed from: c */
        public final Iterator<T> m7051c() {
            return this.f41442a;
        }

        @Nullable
        /* renamed from: d */
        public final T m7050d() {
            return this.f41444c;
        }

        /* renamed from: e */
        public final int m7049e() {
            return this.f41443b;
        }

        /* renamed from: f */
        public final void m7048f(@Nullable T t) {
            this.f41444c = t;
        }

        /* renamed from: g */
        public final void m7047g(int i) {
            this.f41443b = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f41443b == -1) {
                m7052a();
            }
            return this.f41443b == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f41443b == -1) {
                m7052a();
            }
            if (this.f41443b != 0) {
                T t = this.f41444c;
                this.f41444c = null;
                this.f41443b = -1;
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
    public C14504h(@NotNull Sequence<? extends T> sequence, boolean z, @NotNull InterfaceC15280l<? super T, Boolean> predicate) {
        C14342f0.m8184p(sequence, "sequence");
        C14342f0.m8184p(predicate, "predicate");
        this.f41439a = sequence;
        this.f41440b = z;
        this.f41441c = predicate;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new C14505a();
    }

    public /* synthetic */ C14504h(Sequence sequence, boolean z, InterfaceC15280l interfaceC15280l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sequence, (i & 2) != 0 ? true : z, interfaceC15280l);
    }
}
