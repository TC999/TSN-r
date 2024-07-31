package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

/* compiled from: Iterators.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u0015\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0005\u001a\u00020\u0004H\u0086\u0002J\u000f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086\u0002R\u0016\u0010\t\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\bR\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlin/collections/p0;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/collections/n0;", "", "hasNext", "a", "", "I", "index", "b", "Ljava/util/Iterator;", "iterator", "<init>", "(Ljava/util/Iterator;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.p0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14184p0<T> implements Iterator<IndexedValue<? extends T>>, KMarkers {

    /* renamed from: a */
    private int f40943a;

    /* renamed from: b */
    private final Iterator<T> f40944b;

    /* JADX WARN: Multi-variable type inference failed */
    public C14184p0(@NotNull Iterator<? extends T> iterator) {
        C14342f0.m8184p(iterator, "iterator");
        this.f40944b = iterator;
    }

    @Override // java.util.Iterator
    @NotNull
    /* renamed from: a */
    public final IndexedValue<T> next() {
        int i = this.f40943a;
        this.f40943a = i + 1;
        if (i < 0) {
            CollectionsKt__CollectionsKt.m12460W();
        }
        return new IndexedValue<>(i, this.f40944b.next());
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f40944b.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
