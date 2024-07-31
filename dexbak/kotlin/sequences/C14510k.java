package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0004H\u0096\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, m12616d2 = {"Lkotlin/sequences/k;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "Lkotlin/collections/n0;", "", "iterator", "a", "Lkotlin/sequences/m;", "sequence", "<init>", "(Lkotlin/sequences/m;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14510k<T> implements Sequence<IndexedValue<? extends T>> {

    /* renamed from: a */
    private final Sequence<T> f41457a;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, m12616d2 = {"kotlin/sequences/k$a", "", "Lkotlin/collections/n0;", "d", "", "hasNext", "a", "Ljava/util/Iterator;", "c", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "()I", "e", "(I)V", "index", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.k$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14511a implements Iterator<IndexedValue<? extends T>>, KMarkers {
        @NotNull

        /* renamed from: a */
        private final Iterator<T> f41458a;

        /* renamed from: b */
        private int f41459b;

        C14511a() {
            this.f41458a = C14510k.this.f41457a.iterator();
        }

        /* renamed from: a */
        public final int m7031a() {
            return this.f41459b;
        }

        @NotNull
        /* renamed from: c */
        public final Iterator<T> m7030c() {
            return this.f41458a;
        }

        @Override // java.util.Iterator
        @NotNull
        /* renamed from: d */
        public IndexedValue<T> next() {
            int i = this.f41459b;
            this.f41459b = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.m12460W();
            }
            return new IndexedValue<>(i, this.f41458a.next());
        }

        /* renamed from: e */
        public final void m7028e(int i) {
            this.f41459b = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41458a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14510k(@NotNull Sequence<? extends T> sequence) {
        C14342f0.m8184p(sequence, "sequence");
        this.f41457a = sequence;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<IndexedValue<T>> iterator() {
        return new C14511a();
    }
}
