package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, m12616d2 = {"Lkotlin/sequences/u;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "Lkotlin/sequences/e;", "", "n", "a", "b", "", "iterator", "Lkotlin/sequences/m;", "sequence", "I", "startIndex", "c", "endIndex", "f", "()I", "count", "<init>", "(Lkotlin/sequences/m;II)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.u */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14532u<T> implements Sequence<T>, InterfaceC14500e<T> {

    /* renamed from: a */
    private final Sequence<T> f41503a;

    /* renamed from: b */
    private final int f41504b;

    /* renamed from: c */
    private final int f41505c;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002J\u0010\u0010\u0006\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, m12616d2 = {"kotlin/sequences/u$a", "", "Lkotlin/f1;", "a", "", "hasNext", "next", "()Ljava/lang/Object;", "Ljava/util/Iterator;", "c", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "d", "()I", "e", "(I)V", "position", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.u$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14533a implements Iterator<T>, KMarkers {
        @NotNull

        /* renamed from: a */
        private final Iterator<T> f41506a;

        /* renamed from: b */
        private int f41507b;

        C14533a() {
            this.f41506a = C14532u.this.f41503a.iterator();
        }

        /* renamed from: a */
        private final void m6962a() {
            while (this.f41507b < C14532u.this.f41504b && this.f41506a.hasNext()) {
                this.f41506a.next();
                this.f41507b++;
            }
        }

        @NotNull
        /* renamed from: c */
        public final Iterator<T> m6961c() {
            return this.f41506a;
        }

        /* renamed from: d */
        public final int m6960d() {
            return this.f41507b;
        }

        /* renamed from: e */
        public final void m6959e(int i) {
            this.f41507b = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            m6962a();
            return this.f41507b < C14532u.this.f41505c && this.f41506a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            m6962a();
            if (this.f41507b < C14532u.this.f41505c) {
                this.f41507b++;
                return this.f41506a.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14532u(@NotNull Sequence<? extends T> sequence, int i, int i2) {
        C14342f0.m8184p(sequence, "sequence");
        this.f41503a = sequence;
        this.f41504b = i;
        this.f41505c = i2;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("startIndex should be non-negative, but is " + i).toString());
        }
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("endIndex should be non-negative, but is " + i2).toString());
        }
        if (i2 >= i) {
            return;
        }
        throw new IllegalArgumentException(("endIndex should be not less than startIndex, but was " + i2 + " < " + i).toString());
    }

    /* renamed from: f */
    private final int m6963f() {
        return this.f41505c - this.f41504b;
    }

    @Override // kotlin.sequences.InterfaceC14500e
    @NotNull
    /* renamed from: a */
    public Sequence<T> mo6958a(int i) {
        Sequence<T> m6988j;
        if (i >= m6963f()) {
            m6988j = C14520s.m6988j();
            return m6988j;
        }
        return new C14532u(this.f41503a, this.f41504b + i, this.f41505c);
    }

    @Override // kotlin.sequences.InterfaceC14500e
    @NotNull
    /* renamed from: b */
    public Sequence<T> mo6957b(int i) {
        if (i >= m6963f()) {
            return this;
        }
        Sequence<T> sequence = this.f41503a;
        int i2 = this.f41504b;
        return new C14532u(sequence, i2, i + i2);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new C14533a();
    }
}
