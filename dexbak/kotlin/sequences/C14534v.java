package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import com.beizi.fusion.widget.ScrollClickView;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

/* compiled from: Sequences.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0096\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\f¨\u0006\u0010"}, m12616d2 = {"Lkotlin/sequences/v;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/m;", "Lkotlin/sequences/e;", "", "n", "a", "b", "", "iterator", "Lkotlin/sequences/m;", "sequence", "I", "count", "<init>", "(Lkotlin/sequences/m;I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.sequences.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14534v<T> implements Sequence<T>, InterfaceC14500e<T> {

    /* renamed from: a */
    private final Sequence<T> f41509a;

    /* renamed from: b */
    private final int f41510b;

    /* compiled from: Sequences.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001b\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0007\u0010\u0010¨\u0006\u0012"}, m12616d2 = {"kotlin/sequences/v$a", "", "next", "()Ljava/lang/Object;", "", "hasNext", "", "a", "I", "c", "()I", "d", "(I)V", ScrollClickView.DIR_LEFT, "b", "Ljava/util/Iterator;", "()Ljava/util/Iterator;", "iterator", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.sequences.v$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14535a implements Iterator<T>, KMarkers {

        /* renamed from: a */
        private int f41511a;
        @NotNull

        /* renamed from: b */
        private final Iterator<T> f41512b;

        C14535a() {
            this.f41511a = C14534v.this.f41510b;
            this.f41512b = C14534v.this.f41509a.iterator();
        }

        @NotNull
        /* renamed from: a */
        public final Iterator<T> m6954a() {
            return this.f41512b;
        }

        /* renamed from: c */
        public final int m6953c() {
            return this.f41511a;
        }

        /* renamed from: d */
        public final void m6952d(int i) {
            this.f41511a = i;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f41511a > 0 && this.f41512b.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.f41511a;
            if (i != 0) {
                this.f41511a = i - 1;
                return this.f41512b.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C14534v(@NotNull Sequence<? extends T> sequence, int i) {
        C14342f0.m8184p(sequence, "sequence");
        this.f41509a = sequence;
        this.f41510b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override // kotlin.sequences.InterfaceC14500e
    @NotNull
    /* renamed from: a */
    public Sequence<T> mo6958a(int i) {
        Sequence<T> m6988j;
        int i2 = this.f41510b;
        if (i >= i2) {
            m6988j = C14520s.m6988j();
            return m6988j;
        }
        return new C14532u(this.f41509a, i, i2);
    }

    @Override // kotlin.sequences.InterfaceC14500e
    @NotNull
    /* renamed from: b */
    public Sequence<T> mo6957b(int i) {
        return i >= this.f41510b ? this : new C14534v(this.f41509a, i);
    }

    @Override // kotlin.sequences.Sequence
    @NotNull
    public Iterator<T> iterator() {
        return new C14535a();
    }
}
