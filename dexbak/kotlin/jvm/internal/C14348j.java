package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.AbstractC14214r0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m12616d2 = {"Lkotlin/jvm/internal/j;", "Lkotlin/collections/r0;", "", "hasNext", "", "nextLong", "", "a", "I", "index", "", "b", "[J", "array", "<init>", "([J)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14348j extends AbstractC14214r0 {

    /* renamed from: a */
    private int f41142a;

    /* renamed from: b */
    private final long[] f41143b;

    public C14348j(@NotNull long[] array) {
        C14342f0.m8184p(array, "array");
        this.f41143b = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f41142a < this.f41143b.length;
    }

    @Override // kotlin.collections.AbstractC14214r0
    public long nextLong() {
        try {
            long[] jArr = this.f41143b;
            int i = this.f41142a;
            this.f41142a = i + 1;
            return jArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f41142a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
