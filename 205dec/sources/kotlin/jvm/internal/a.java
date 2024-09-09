package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ArrayIterators.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlin/jvm/internal/a;", "Lkotlin/collections/r;", "", "hasNext", "nextBoolean", "", "a", "[Z", "array", "", "b", "I", "index", "<init>", "([Z)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class a extends kotlin.collections.r {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final boolean[] f55607a;

    /* renamed from: b  reason: collision with root package name */
    private int f55608b;

    public a(@NotNull boolean[] array) {
        f0.p(array, "array");
        this.f55607a = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f55608b < this.f55607a.length;
    }

    @Override // kotlin.collections.r
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f55607a;
            int i4 = this.f55608b;
            this.f55608b = i4 + 1;
            return zArr[i4];
        } catch (ArrayIndexOutOfBoundsException e4) {
            this.f55608b--;
            throw new NoSuchElementException(e4.getMessage());
        }
    }
}
