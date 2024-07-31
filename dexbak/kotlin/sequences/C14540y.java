package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;
import p620m1.KMarkers;

/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B)\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002J5\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0003\"\u0004\b\u0002\u0010\u00062\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00040\u0007H\u0000¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u0010"}, m12616d2 = {"Lkotlin/sequences/y;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/sequences/m;", "", "iterator", ExifInterface.LONGITUDE_EAST, "Lkotlin/Function1;", "e", "(Ll1/l;)Lkotlin/sequences/m;", "a", "Lkotlin/sequences/m;", "sequence", "transformer", "<init>", "(Lkotlin/sequences/m;Ll1/l;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14540y<T, R> implements Sequence<R> {

    /* renamed from: a */
    private final Sequence<T> f41525a;

    /* renamed from: b */
    private final InterfaceC15280l<T, R> f41526b;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b¨\u0006\n"}, m12616d2 = {"kotlin/sequences/y$a", "", "next", "()Ljava/lang/Object;", "", "hasNext", "a", "Ljava/util/Iterator;", "()Ljava/util/Iterator;", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.y$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14541a implements Iterator<R>, KMarkers {
        @NotNull

        /* renamed from: a */
        private final Iterator<T> f41527a;

        C14541a() {
            this.f41527a = C14540y.this.f41525a.iterator();
        }

        @NotNull
        /* renamed from: a */
        public final Iterator<T> m6935a() {
            return this.f41527a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41527a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            return (R) C14540y.this.f41526b.invoke(this.f41527a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14540y(@NotNull Sequence<? extends T> sequence, @NotNull InterfaceC15280l<? super T, ? extends R> transformer) {
        C14342f0.m8184p(sequence, "sequence");
        C14342f0.m8184p(transformer, "transformer");
        this.f41525a = sequence;
        this.f41526b = transformer;
    }

    @NotNull
    /* renamed from: e */
    public final <E> Sequence<E> m6936e(@NotNull InterfaceC15280l<? super R, ? extends Iterator<? extends E>> iterator) {
        C14342f0.m8184p(iterator, "iterator");
        return new C14506i(this.f41525a, this.f41526b, iterator);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<R> iterator() {
        return new C14541a();
    }
}
