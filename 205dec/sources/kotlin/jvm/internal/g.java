package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ArrayIterator.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0015\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lkotlin/jvm/internal/g;", "T", "", "", "hasNext", "next", "()Ljava/lang/Object;", "", "a", "[Ljava/lang/Object;", "()[Ljava/lang/Object;", "array", "", "b", "I", "index", "<init>", "([Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class g<T> implements Iterator<T>, e2.a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final T[] f55625a;

    /* renamed from: b  reason: collision with root package name */
    private int f55626b;

    public g(@NotNull T[] array) {
        f0.p(array, "array");
        this.f55625a = array;
    }

    @NotNull
    public final T[] a() {
        return this.f55625a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f55626b < this.f55625a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f55625a;
            int i4 = this.f55626b;
            this.f55626b = i4 + 1;
            return tArr[i4];
        } catch (ArrayIndexOutOfBoundsException e4) {
            this.f55626b--;
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
