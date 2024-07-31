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
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004BC\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\u00050\n¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0096\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, m12616d2 = {"Lkotlin/sequences/i;", ExifInterface.GPS_DIRECTION_TRUE, "R", ExifInterface.LONGITUDE_EAST, "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", "sequence", "Lkotlin/Function1;", "transformer", "<init>", "(Lkotlin/sequences/m;Ll1/l;Ll1/l;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14506i<T, R, E> implements Sequence<E> {

    /* renamed from: a */
    private final Sequence<T> f41446a;

    /* renamed from: b */
    private final InterfaceC15280l<T, R> f41447b;

    /* renamed from: c */
    private final InterfaceC15280l<R, Iterator<E>> f41448c;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0002H\u0096\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0007\u001a\u0004\b\b\u0010\tR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, m12616d2 = {"kotlin/sequences/i$a", "", "", "a", "next", "()Ljava/lang/Object;", "hasNext", "Ljava/util/Iterator;", "d", "()Ljava/util/Iterator;", "iterator", "b", "c", "e", "(Ljava/util/Iterator;)V", "itemIterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.i$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14507a implements Iterator<E>, KMarkers {
        @NotNull

        /* renamed from: a */
        private final Iterator<T> f41449a;
        @Nullable

        /* renamed from: b */
        private Iterator<? extends E> f41450b;

        C14507a() {
            this.f41449a = C14506i.this.f41446a.iterator();
        }

        /* renamed from: a */
        private final boolean m7043a() {
            Iterator<? extends E> it = this.f41450b;
            if (it != null && !it.hasNext()) {
                this.f41450b = null;
            }
            while (true) {
                if (this.f41450b == null) {
                    if (!this.f41449a.hasNext()) {
                        return false;
                    }
                    Iterator<? extends E> it2 = (Iterator) C14506i.this.f41448c.invoke(C14506i.this.f41447b.invoke(this.f41449a.next()));
                    if (it2.hasNext()) {
                        this.f41450b = it2;
                        break;
                    }
                } else {
                    break;
                }
            }
            return true;
        }

        @Nullable
        /* renamed from: c */
        public final Iterator<E> m7042c() {
            return (Iterator<? extends E>) this.f41450b;
        }

        @NotNull
        /* renamed from: d */
        public final Iterator<T> m7041d() {
            return this.f41449a;
        }

        /* renamed from: e */
        public final void m7040e(@Nullable Iterator<? extends E> it) {
            this.f41450b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return m7043a();
        }

        @Override // java.util.Iterator
        public E next() {
            if (m7043a()) {
                Iterator<? extends E> it = this.f41450b;
                C14342f0.m8187m(it);
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
    public C14506i(@NotNull Sequence<? extends T> sequence, @NotNull InterfaceC15280l<? super T, ? extends R> transformer, @NotNull InterfaceC15280l<? super R, ? extends Iterator<? extends E>> iterator) {
        C14342f0.m8184p(sequence, "sequence");
        C14342f0.m8184p(transformer, "transformer");
        C14342f0.m8184p(iterator, "iterator");
        this.f41446a = sequence;
        this.f41447b = transformer;
        this.f41448c = iterator;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<E> iterator() {
        return new C14507a();
    }
}
