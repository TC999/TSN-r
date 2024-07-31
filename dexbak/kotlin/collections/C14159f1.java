package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.kuaishou.weapon.p205p0.C7304t;
import java.util.Arrays;
import java.util.Iterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.ranges._Ranges;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SlidingWindow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000e\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000f\u0012\u0006\u0010)\u001a\u00020\u0005¢\u0006\u0004\b*\u0010+B\u0011\b\u0016\u0012\u0006\u0010\u001e\u001a\u00020\u0005¢\u0006\u0004\b*\u0010,J\u0015\u0010\u0007\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0082\bJ\u0018\u0010\t\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\f\u001a\u00020\u000bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0002J)\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0001\u0010\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000fH\u0014¢\u0006\u0004\b\u0011\u0010\u0014J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0015\u001a\u00020\u0005J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00028\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\u001e\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001dR$\u0010%\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00058\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010$R\u001c\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'¨\u0006-"}, m12616d2 = {"Lkotlin/collections/f1;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/collections/d;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "n", "k", "index", "get", "(I)Ljava/lang/Object;", "", C7304t.f25048d, "", "iterator", "", "array", "toArray", "([Ljava/lang/Object;)[Ljava/lang/Object;", "", "()[Ljava/lang/Object;", "maxCapacity", "j", "element", "Lkotlin/f1;", "i", "(Ljava/lang/Object;)V", "m", "a", "I", "capacity", "b", "startIndex", "<set-?>", "c", "getSize", "()I", "size", "d", "[Ljava/lang/Object;", "buffer", "filledSize", "<init>", "([Ljava/lang/Object;I)V", "(I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.f1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14159f1<T> extends AbstractList<T> implements RandomAccess {

    /* renamed from: a */
    private final int f40893a;

    /* renamed from: b */
    private int f40894b;

    /* renamed from: c */
    private int f40895c;

    /* renamed from: d */
    private final Object[] f40896d;

    /* compiled from: SlidingWindow.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\u0007\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0006¨\u0006\n"}, m12616d2 = {"kotlin/collections/f1$a", "Lkotlin/collections/c;", "Lkotlin/f1;", "a", "", "c", "I", "count", "d", "index", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.f1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14160a extends AbstractIterator<T> {

        /* renamed from: c */
        private int f40897c;

        /* renamed from: d */
        private int f40898d;

        C14160a() {
            this.f40897c = C14159f1.this.size();
            this.f40898d = C14159f1.this.f40894b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.collections.AbstractIterator
        /* renamed from: a */
        protected void mo7072a() {
            if (this.f40897c == 0) {
                m12318c();
                return;
            }
            m12317d(C14159f1.this.f40896d[this.f40898d]);
            this.f40898d = (this.f40898d + 1) % C14159f1.this.f40893a;
            this.f40897c--;
        }
    }

    public C14159f1(@NotNull Object[] buffer, int i) {
        C14342f0.m8184p(buffer, "buffer");
        this.f40896d = buffer;
        if (i >= 0) {
            if (i <= buffer.length) {
                this.f40893a = buffer.length;
                this.f40895c = i;
                return;
            }
            throw new IllegalArgumentException(("ring buffer filled size: " + i + " cannot be larger than the buffer size: " + buffer.length).toString());
        }
        throw new IllegalArgumentException(("ring buffer filled size should not be negative but it is " + i).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public final int m12012k(int i, int i2) {
        return (i + i2) % this.f40893a;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public T get(int i) {
        AbstractList.Companion.m12304b(i, size());
        return (T) this.f40896d[(this.f40894b + i) % this.f40893a];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f40895c;
    }

    /* renamed from: i */
    public final void m12014i(T t) {
        if (!m12011l()) {
            this.f40896d[(this.f40894b + size()) % this.f40893a] = t;
            this.f40895c = size() + 1;
            return;
        }
        throw new IllegalStateException("ring buffer is full");
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    @NotNull
    public Iterator<T> iterator() {
        return new C14160a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    /* renamed from: j */
    public final C14159f1<T> m12013j(int i) {
        int m7460u;
        Object[] array;
        int i2 = this.f40893a;
        m7460u = _Ranges.m7460u(i2 + (i2 >> 1) + 1, i);
        if (this.f40894b == 0) {
            array = Arrays.copyOf(this.f40896d, m7460u);
            C14342f0.m8185o(array, "java.util.Arrays.copyOf(this, newSize)");
        } else {
            array = toArray(new Object[m7460u]);
        }
        return new C14159f1<>(array, size());
    }

    /* renamed from: l */
    public final boolean m12011l() {
        return size() == this.f40893a;
    }

    /* renamed from: m */
    public final void m12010m(int i) {
        if (i >= 0) {
            if (!(i <= size())) {
                throw new IllegalArgumentException(("n shouldn't be greater than the buffer size: n = " + i + ", size = " + size()).toString());
            } else if (i > 0) {
                int i2 = this.f40894b;
                int i3 = (i2 + i) % this.f40893a;
                if (i2 > i3) {
                    _ArraysJvm.m11568n2(this.f40896d, null, i2, this.f40893a);
                    _ArraysJvm.m11568n2(this.f40896d, null, 0, i3);
                } else {
                    _ArraysJvm.m11568n2(this.f40896d, null, i2, i3);
                }
                this.f40894b = i3;
                this.f40895c = size() - i;
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException(("n shouldn't be negative but it is " + i).toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public <T> T[] toArray(@NotNull T[] array) {
        C14342f0.m8184p(array, "array");
        if (array.length < size()) {
            array = (T[]) Arrays.copyOf(array, size());
            C14342f0.m8185o(array, "java.util.Arrays.copyOf(this, newSize)");
        }
        int size = size();
        int i = 0;
        int i2 = 0;
        for (int i3 = this.f40894b; i2 < size && i3 < this.f40893a; i3++) {
            array[i2] = this.f40896d[i3];
            i2++;
        }
        while (i2 < size) {
            array[i2] = this.f40896d[i];
            i2++;
            i++;
        }
        if (array.length > size()) {
            array[size()] = null;
        }
        return array;
    }

    public C14159f1(int i) {
        this(new Object[i], 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    @NotNull
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
