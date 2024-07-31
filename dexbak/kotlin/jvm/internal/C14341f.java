package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.AbstractC14213q0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ArrayIterators.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016R\u0016\u0010\b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlin/jvm/internal/f;", "Lkotlin/collections/q0;", "", "hasNext", "", "nextInt", "a", "I", "index", "", "b", "[I", "array", "<init>", "([I)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.f */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14341f extends AbstractC14213q0 {

    /* renamed from: a */
    private int f41133a;

    /* renamed from: b */
    private final int[] f41134b;

    public C14341f(@NotNull int[] array) {
        C14342f0.m8184p(array, "array");
        this.f41134b = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f41133a < this.f41134b.length;
    }

    @Override // kotlin.collections.AbstractC14213q0
    public int nextInt() {
        try {
            int[] iArr = this.f41134b;
            int i = this.f41133a;
            this.f41133a = i + 1;
            return iArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f41133a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
