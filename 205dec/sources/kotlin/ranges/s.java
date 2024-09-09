package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.t1;
import kotlin.g1;
import kotlin.r0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: UIntRange.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\"\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\r\u001a\u00020\u0011\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0015\u0010\u0005\u001a\u00020\u0004H\u0016\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00048\u0002X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u00048\u0002X\u0082\u0004\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u001c\u0010\u000e\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006\u0014"}, d2 = {"Lkotlin/ranges/s;", "Lkotlin/collections/t1;", "", "hasNext", "Lkotlin/r0;", "d", "()I", "a", "I", "finalElement", "b", "Z", "c", "step", "next", "first", "last", "", "<init>", "(IIILkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class s extends t1 {

    /* renamed from: a  reason: collision with root package name */
    private final int f55816a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f55817b;

    /* renamed from: c  reason: collision with root package name */
    private final int f55818c;

    /* renamed from: d  reason: collision with root package name */
    private int f55819d;

    private s(int i4, int i5, int i6) {
        this.f55816a = i5;
        boolean z3 = true;
        int c4 = g1.c(i4, i5);
        if (i6 <= 0 ? c4 < 0 : c4 > 0) {
            z3 = false;
        }
        this.f55817b = z3;
        this.f55818c = r0.i(i6);
        this.f55819d = this.f55817b ? i4 : i5;
    }

    public /* synthetic */ s(int i4, int i5, int i6, kotlin.jvm.internal.u uVar) {
        this(i4, i5, i6);
    }

    @Override // kotlin.collections.t1
    public int d() {
        int i4 = this.f55819d;
        if (i4 == this.f55816a) {
            if (this.f55817b) {
                this.f55817b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f55819d = r0.i(this.f55818c + i4);
        }
        return i4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f55817b;
    }
}
