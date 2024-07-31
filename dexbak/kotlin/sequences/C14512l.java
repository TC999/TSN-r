package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;
import p620m1.KMarkers;

/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004B=\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00020\u0005H\u0096\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\b¨\u0006\u0010"}, m12616d2 = {"Lkotlin/sequences/l;", "T1", "T2", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", "sequence1", "b", "sequence2", "Lkotlin/Function2;", "transform", "<init>", "(Lkotlin/sequences/m;Lkotlin/sequences/m;Ll1/p;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14512l<T1, T2, V> implements Sequence<V> {

    /* renamed from: a */
    private final Sequence<T1> f41461a;

    /* renamed from: b */
    private final Sequence<T2> f41462b;

    /* renamed from: c */
    private final InterfaceC15284p<T1, T2, V> f41463c;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\b¨\u0006\r"}, m12616d2 = {"kotlin/sequences/l$a", "", "next", "()Ljava/lang/Object;", "", "hasNext", "a", "Ljava/util/Iterator;", "()Ljava/util/Iterator;", "iterator1", "b", "c", "iterator2", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.l$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14513a implements Iterator<V>, KMarkers {
        @NotNull

        /* renamed from: a */
        private final Iterator<T1> f41464a;
        @NotNull

        /* renamed from: b */
        private final Iterator<T2> f41465b;

        C14513a() {
            this.f41464a = C14512l.this.f41461a.iterator();
            this.f41465b = C14512l.this.f41462b.iterator();
        }

        @NotNull
        /* renamed from: a */
        public final Iterator<T1> m7024a() {
            return this.f41464a;
        }

        @NotNull
        /* renamed from: c */
        public final Iterator<T2> m7023c() {
            return this.f41465b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41464a.hasNext() && this.f41465b.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            return (V) C14512l.this.f41463c.invoke(this.f41464a.next(), this.f41465b.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14512l(@NotNull Sequence<? extends T1> sequence1, @NotNull Sequence<? extends T2> sequence2, @NotNull InterfaceC15284p<? super T1, ? super T2, ? extends V> transform) {
        C14342f0.m8184p(sequence1, "sequence1");
        C14342f0.m8184p(sequence2, "sequence2");
        C14342f0.m8184p(transform, "transform");
        this.f41461a = sequence1;
        this.f41462b = sequence2;
        this.f41463c = transform;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<V> iterator() {
        return new C14513a();
    }
}
