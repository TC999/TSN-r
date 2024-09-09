package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.r0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ProgressionIterators.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lkotlin/ranges/j;", "Lkotlin/collections/r0;", "", "hasNext", "", "nextInt", "a", "I", "()I", "step", "b", "finalElement", "c", "Z", "d", "next", "first", "last", "<init>", "(III)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j extends r0 {

    /* renamed from: a  reason: collision with root package name */
    private final int f55796a;

    /* renamed from: b  reason: collision with root package name */
    private final int f55797b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f55798c;

    /* renamed from: d  reason: collision with root package name */
    private int f55799d;

    public j(int i4, int i5, int i6) {
        this.f55796a = i6;
        this.f55797b = i5;
        boolean z3 = true;
        if (i6 <= 0 ? i4 < i5 : i4 > i5) {
            z3 = false;
        }
        this.f55798c = z3;
        this.f55799d = z3 ? i4 : i5;
    }

    public final int a() {
        return this.f55796a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f55798c;
    }

    @Override // kotlin.collections.r0
    public int nextInt() {
        int i4 = this.f55799d;
        if (i4 == this.f55797b) {
            if (this.f55798c) {
                this.f55798c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f55799d = this.f55796a + i4;
        }
        return i4;
    }
}
