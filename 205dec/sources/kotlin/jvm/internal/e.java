package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ArrayIterators.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\u0006\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkotlin/jvm/internal/e;", "Lkotlin/collections/j0;", "", "hasNext", "", "d", "", "a", "[F", "array", "", "b", "I", "index", "<init>", "([F)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class e extends kotlin.collections.j0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final float[] f55620a;

    /* renamed from: b  reason: collision with root package name */
    private int f55621b;

    public e(@NotNull float[] array) {
        f0.p(array, "array");
        this.f55620a = array;
    }

    @Override // kotlin.collections.j0
    public float d() {
        try {
            float[] fArr = this.f55620a;
            int i4 = this.f55621b;
            this.f55621b = i4 + 1;
            return fArr[i4];
        } catch (ArrayIndexOutOfBoundsException e4) {
            this.f55621b--;
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f55621b < this.f55620a.length;
    }
}