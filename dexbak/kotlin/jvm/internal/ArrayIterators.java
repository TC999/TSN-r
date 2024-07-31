package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.AbstractC14216s;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0016R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlin/jvm/internal/a;", "Lkotlin/collections/s;", "", "hasNext", "nextBoolean", "", "a", "I", "index", "", "b", "[Z", "array", "<init>", "([Z)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.jvm.internal.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class ArrayIterators extends AbstractC14216s {

    /* renamed from: a */
    private int f41117a;

    /* renamed from: b */
    private final boolean[] f41118b;

    public ArrayIterators(@NotNull boolean[] array) {
        C14342f0.m8184p(array, "array");
        this.f41118b = array;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f41117a < this.f41118b.length;
    }

    @Override // kotlin.collections.AbstractC14216s
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f41118b;
            int i = this.f41117a;
            this.f41117a = i + 1;
            return zArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f41117a--;
            throw new NoSuchElementException(e.getMessage());
        }
    }
}
