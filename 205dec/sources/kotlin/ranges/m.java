package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.s0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ProgressionIterators.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0007\u00a8\u0006\u0014"}, d2 = {"Lkotlin/ranges/m;", "Lkotlin/collections/s0;", "", "hasNext", "", "nextLong", "a", "J", "()J", "step", "b", "finalElement", "c", "Z", "d", "next", "first", "last", "<init>", "(JJJ)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m extends s0 {

    /* renamed from: a  reason: collision with root package name */
    private final long f55806a;

    /* renamed from: b  reason: collision with root package name */
    private final long f55807b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f55808c;

    /* renamed from: d  reason: collision with root package name */
    private long f55809d;

    public m(long j4, long j5, long j6) {
        this.f55806a = j6;
        this.f55807b = j5;
        boolean z3 = true;
        int i4 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        int i5 = (j4 > j5 ? 1 : (j4 == j5 ? 0 : -1));
        if (i4 <= 0 ? i5 < 0 : i5 > 0) {
            z3 = false;
        }
        this.f55808c = z3;
        this.f55809d = z3 ? j4 : j5;
    }

    public final long a() {
        return this.f55806a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f55808c;
    }

    @Override // kotlin.collections.s0
    public long nextLong() {
        long j4 = this.f55809d;
        if (j4 == this.f55807b) {
            if (this.f55808c) {
                this.f55808c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f55809d = this.f55806a + j4;
        }
        return j4;
    }
}
