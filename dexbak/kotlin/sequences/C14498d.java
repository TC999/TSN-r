package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.beizi.fusion.widget.ScrollClickView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\f¨\u0006\u0010"}, m12616d2 = {"Lkotlin/sequences/d;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "Lkotlin/sequences/e;", "", "n", "a", "b", "", "iterator", "Lkotlin/sequences/m;", "sequence", "I", "count", "<init>", "(Lkotlin/sequences/m;I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14498d<T> implements Sequence<T>, InterfaceC14500e<T> {

    /* renamed from: a */
    private final Sequence<T> f41427a;

    /* renamed from: b */
    private final int f41428b;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\u0007\u001a\u00020\u0006H\u0096\u0002R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, m12616d2 = {"kotlin/sequences/d$a", "", "Lkotlin/f1;", "a", "next", "()Ljava/lang/Object;", "", "hasNext", "Ljava/util/Iterator;", "c", "()Ljava/util/Iterator;", "iterator", "", "b", "I", "d", "()I", "e", "(I)V", ScrollClickView.DIR_LEFT, "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14499a implements Iterator<T>, KMarkers {
        @NotNull

        /* renamed from: a */
        private final Iterator<T> f41429a;

        /* renamed from: b */
        private int f41430b;

        C14499a() {
            this.f41429a = C14498d.this.f41427a.iterator();
            this.f41430b = C14498d.this.f41428b;
        }

        /* renamed from: a */
        private final void m7069a() {
            while (this.f41430b > 0 && this.f41429a.hasNext()) {
                this.f41429a.next();
                this.f41430b--;
            }
        }

        @NotNull
        /* renamed from: c */
        public final Iterator<T> m7068c() {
            return this.f41429a;
        }

        /* renamed from: d */
        public final int m7067d() {
            return this.f41430b;
        }

        /* renamed from: e */
        public final void m7066e(int i) {
            this.f41430b = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            m7069a();
            return this.f41429a.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            m7069a();
            return this.f41429a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14498d(@NotNull Sequence<? extends T> sequence, int i) {
        C14342f0.m8184p(sequence, "sequence");
        this.f41427a = sequence;
        this.f41428b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // kotlin.sequences.InterfaceC14500e
    @NotNull
    /* renamed from: a */
    public Sequence<T> mo6958a(int i) {
        int i2 = this.f41428b + i;
        return i2 < 0 ? new C14498d(this, i) : new C14498d(this.f41427a, i2);
    }

    @Override // kotlin.sequences.InterfaceC14500e
    @NotNull
    /* renamed from: b */
    public Sequence<T> mo6957b(int i) {
        int i2 = this.f41428b;
        int i3 = i2 + i;
        return i3 < 0 ? new C14534v(this, i) : new C14532u(this.f41427a, i2, i3);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new C14499a();
    }
}
