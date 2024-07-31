package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15284p;
import p620m1.KMarkers;

/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B/\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, m12616d2 = {"Lkotlin/sequences/x;", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlin/sequences/m;", "", "iterator", "a", "Lkotlin/sequences/m;", "sequence", "Lkotlin/Function2;", "", "transformer", "<init>", "(Lkotlin/sequences/m;Ll1/p;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.x */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14538x<T, R> implements Sequence<R> {

    /* renamed from: a */
    private final Sequence<T> f41520a;

    /* renamed from: b */
    private final InterfaceC15284p<Integer, T, R> f41521b;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\"\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, m12616d2 = {"kotlin/sequences/x$a", "", "next", "()Ljava/lang/Object;", "", "hasNext", "a", "Ljava/util/Iterator;", "c", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "()I", "d", "(I)V", "index", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.x$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14539a implements Iterator<R>, KMarkers {
        @NotNull

        /* renamed from: a */
        private final Iterator<T> f41522a;

        /* renamed from: b */
        private int f41523b;

        C14539a() {
            this.f41522a = C14538x.this.f41520a.iterator();
        }

        /* renamed from: a */
        public final int m6941a() {
            return this.f41523b;
        }

        @NotNull
        /* renamed from: c */
        public final Iterator<T> m6940c() {
            return this.f41522a;
        }

        /* renamed from: d */
        public final void m6939d(int i) {
            this.f41523b = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41522a.hasNext();
        }

        @Override // java.util.Iterator
        public R next() {
            InterfaceC15284p interfaceC15284p = C14538x.this.f41521b;
            int i = this.f41523b;
            this.f41523b = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.m12460W();
            }
            return (R) interfaceC15284p.invoke(Integer.valueOf(i), this.f41522a.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14538x(@NotNull Sequence<? extends T> sequence, @NotNull InterfaceC15284p<? super Integer, ? super T, ? extends R> transformer) {
        C14342f0.m8184p(sequence, "sequence");
        C14342f0.m8184p(transformer, "transformer");
        this.f41520a = sequence;
        this.f41521b = transformer;
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<R> iterator() {
        return new C14539a();
    }
}
