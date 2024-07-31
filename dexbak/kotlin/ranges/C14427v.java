package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.ULong;
import kotlin.UnsignedUtils;
import kotlin.collections.AbstractC14220t1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ULongRange.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0015\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u001c\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\r\u0010\b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0014"}, m12616d2 = {"Lkotlin/ranges/v;", "Lkotlin/collections/t1;", "", "hasNext", "Lkotlin/v0;", "c", "()J", "a", "J", "finalElement", "b", "Z", "step", "d", "next", "first", "last", "", "<init>", "(JJJLkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14427v extends AbstractC14220t1 {

    /* renamed from: a */
    private final long f41326a;

    /* renamed from: b */
    private boolean f41327b;

    /* renamed from: c */
    private final long f41328c;

    /* renamed from: d */
    private long f41329d;

    private C14427v(long j, long j2, long j3) {
        this.f41326a = j2;
        boolean z = true;
        int i = (j3 > 0L ? 1 : (j3 == 0L ? 0 : -1));
        int m8557g = UnsignedUtils.m8557g(j, j2);
        if (i <= 0 ? m8557g < 0 : m8557g > 0) {
            z = false;
        }
        this.f41327b = z;
        this.f41328c = ULong.m5889h(j3);
        this.f41329d = this.f41327b ? j : j2;
    }

    @Override // kotlin.collections.AbstractC14220t1
    /* renamed from: c */
    public long mo5814c() {
        long j = this.f41329d;
        if (j == this.f41326a) {
            if (this.f41327b) {
                this.f41327b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f41329d = ULong.m5889h(this.f41328c + j);
        }
        return j;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f41327b;
    }

    public /* synthetic */ C14427v(long j, long j2, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3);
    }
}
