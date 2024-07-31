package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.AbstractC14213q0;

/* compiled from: ProgressionIterators.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007R\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0007\u001a\u0004\b\u0006\u0010\u000e¨\u0006\u0014"}, m12616d2 = {"Lkotlin/ranges/j;", "Lkotlin/collections/q0;", "", "hasNext", "", "nextInt", "a", "I", "finalElement", "b", "Z", "c", "next", "d", "()I", "step", "first", "last", "<init>", "(III)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14412j extends AbstractC14213q0 {

    /* renamed from: a */
    private final int f41296a;

    /* renamed from: b */
    private boolean f41297b;

    /* renamed from: c */
    private int f41298c;

    /* renamed from: d */
    private final int f41299d;

    public C14412j(int i, int i2, int i3) {
        this.f41299d = i3;
        this.f41296a = i2;
        boolean z = true;
        if (i3 <= 0 ? i < i2 : i > i2) {
            z = false;
        }
        this.f41297b = z;
        this.f41298c = z ? i : i2;
    }

    /* renamed from: a */
    public final int m7599a() {
        return this.f41299d;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f41297b;
    }

    @Override // kotlin.collections.AbstractC14213q0
    public int nextInt() {
        int i = this.f41298c;
        if (i == this.f41296a) {
            if (this.f41297b) {
                this.f41297b = false;
            } else {
                throw new NoSuchElementException();
            }
        } else {
            this.f41298c = this.f41299d + i;
        }
        return i;
    }
}
