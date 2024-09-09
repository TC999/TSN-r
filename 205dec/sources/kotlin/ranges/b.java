package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ProgressionIterators.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\b\u00a8\u0006\u0015"}, d2 = {"Lkotlin/ranges/b;", "Lkotlin/collections/u;", "", "hasNext", "", "d", "", "a", "I", "e", "()I", "step", "b", "finalElement", "c", "Z", "next", "first", "last", "<init>", "(CCI)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b extends kotlin.collections.u {

    /* renamed from: a  reason: collision with root package name */
    private final int f55780a;

    /* renamed from: b  reason: collision with root package name */
    private final int f55781b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f55782c;

    /* renamed from: d  reason: collision with root package name */
    private int f55783d;

    public b(char c4, char c5, int i4) {
        this.f55780a = i4;
        this.f55781b = c5;
        boolean z3 = true;
        if (i4 <= 0 ? f0.t(c4, c5) < 0 : f0.t(c4, c5) > 0) {
            z3 = false;
        }
        this.f55782c = z3;
        this.f55783d = z3 ? c4 : c5;
    }

    @Override // kotlin.collections.u
    public char d() {
        int i4 = this.f55783d;
        if (i4 == this.f55781b) {
            if (this.f55782c) {
                this.f55782c = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f55783d = this.f55780a + i4;
        }
        return (char) i4;
    }

    public final int e() {
        return this.f55780a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f55782c;
    }
}
