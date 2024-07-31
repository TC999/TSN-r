package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.AbstractC14214r0;

/* compiled from: ProgressionIterators.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0014"}, m12616d2 = {"Lkotlin/ranges/m;", "Lkotlin/collections/r0;", "", "hasNext", "", "nextLong", "a", "J", "finalElement", "b", "Z", "c", "next", "d", "()J", "step", "first", "last", "<init>", "(JJJ)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14417m extends AbstractC14214r0 {

    /* renamed from: a */
    private final long f41306a;

    /* renamed from: b */
    private boolean f41307b;

    /* renamed from: c */
    private long f41308c;

    /* renamed from: d */
    private final long f41309d;

    public C14417m(long j, long j2, long j3) {
        this.f41309d = j3;
        this.f41306a = j2;
        boolean z = true;
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        int i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i <= 0 ? i2 < 0 : i2 > 0) {
            z = false;
        }
        this.f41307b = z;
        this.f41308c = z ? j : j2;
    }

    /* renamed from: a */
    public final long m7588a() {
        return this.f41309d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f41307b;
    }

    @Override // kotlin.collections.AbstractC14214r0
    public long nextLong() {
        long j = this.f41308c;
        if (j == this.f41306a) {
            if (this.f41307b) {
                this.f41307b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f41308c = this.f41309d + j;
        }
        return j;
    }
}
