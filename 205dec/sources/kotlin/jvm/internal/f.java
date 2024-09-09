package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ArrayIterators.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlin/jvm/internal/f;", "Lkotlin/collections/r0;", "", "hasNext", "", "nextInt", "", "a", "[I", "array", "b", "I", "index", "<init>", "([I)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class f extends kotlin.collections.r0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final int[] f55623a;

    /* renamed from: b  reason: collision with root package name */
    private int f55624b;

    public f(@NotNull int[] array) {
        f0.p(array, "array");
        this.f55623a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f55624b < this.f55623a.length;
    }

    @Override // kotlin.collections.r0
    public int nextInt() {
        try {
            int[] iArr = this.f55623a;
            int i4 = this.f55624b;
            this.f55624b = i4 + 1;
            return iArr[i4];
        } catch (ArrayIndexOutOfBoundsException e4) {
            this.f55624b--;
            throw new NoSuchElementException(e4.getMessage());
        }
    }
}
