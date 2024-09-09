package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.u1;
import kotlin.g1;
import kotlin.v0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ULongRange.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0011\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0015\u0010\u0005\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u001c\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0014"}, d2 = {"Lkotlin/ranges/v;", "Lkotlin/collections/u1;", "", "hasNext", "Lkotlin/v0;", "d", "()J", "a", "J", "finalElement", "b", "Z", "c", "step", "next", "first", "last", "", "<init>", "(JJJLkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class v extends u1 {

    /* renamed from: a  reason: collision with root package name */
    private final long f55826a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f55827b;

    /* renamed from: c  reason: collision with root package name */
    private final long f55828c;

    /* renamed from: d  reason: collision with root package name */
    private long f55829d;

    private v(long j4, long j5, long j6) {
        this.f55826a = j5;
        boolean z3 = true;
        int i4 = (j6 > 0L ? 1 : (j6 == 0L ? 0 : -1));
        int g4 = g1.g(j4, j5);
        if (i4 <= 0 ? g4 < 0 : g4 > 0) {
            z3 = false;
        }
        this.f55827b = z3;
        this.f55828c = v0.i(j6);
        this.f55829d = this.f55827b ? j4 : j5;
    }

    public /* synthetic */ v(long j4, long j5, long j6, kotlin.jvm.internal.u uVar) {
        this(j4, j5, j6);
    }

    @Override // kotlin.collections.u1
    public long d() {
        long j4 = this.f55829d;
        if (j4 == this.f55826a) {
            if (this.f55827b) {
                this.f55827b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f55829d = v0.i(this.f55828c + j4);
        }
        return j4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f55827b;
    }
}
