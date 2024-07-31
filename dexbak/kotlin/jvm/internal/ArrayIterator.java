package kotlin.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\u000e¨\u0006\u0012"}, m12616d2 = {"Lkotlin/jvm/internal/g;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "hasNext", "next", "()Ljava/lang/Object;", "", "a", "I", "index", "", "b", "[Ljava/lang/Object;", "()[Ljava/lang/Object;", "array", "<init>", "([Ljava/lang/Object;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class ArrayIterator<T> implements Iterator<T>, KMarkers {

    /* renamed from: a */
    private int f41135a;
    @NotNull

    /* renamed from: b */
    private final T[] f41136b;

    public ArrayIterator(@NotNull T[] array) {
        C14342f0.m8184p(array, "array");
        this.f41136b = array;
    }

    @NotNull
    /* renamed from: a */
    public final T[] m8173a() {
        return this.f41136b;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f41135a < this.f41136b.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f41136b;
            int i = this.f41135a;
            this.f41135a = i + 1;
            return tArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f41135a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
