package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u0015\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005J\u0018\u0010\u000b\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u0005H\u0096\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, m12616d2 = {"Lkotlin/collections/a1;", ExifInterface.LONGITUDE_EAST, "Lkotlin/collections/d;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "", "fromIndex", "toIndex", "Lkotlin/f1;", "a", "index", "get", "(I)Ljava/lang/Object;", "I", "b", "_size", "", "c", "Ljava/util/List;", "list", "getSize", "()I", "size", "<init>", "(Ljava/util/List;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.a1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SlidingWindow<E> extends AbstractList<E> implements RandomAccess {

    /* renamed from: a */
    private int f40829a;

    /* renamed from: b */
    private int f40830b;

    /* renamed from: c */
    private final List<E> f40831c;

    /* JADX WARN: Multi-variable type inference failed */
    public SlidingWindow(@NotNull List<? extends E> list) {
        C14342f0.m8184p(list, "list");
        this.f40831c = list;
    }

    /* renamed from: a */
    public final void m12439a(int i, int i2) {
        AbstractList.Companion.m12302d(i, i2, this.f40831c.size());
        this.f40829a = i;
        this.f40830b = i2 - i;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public E get(int i) {
        AbstractList.Companion.m12304b(i, this.f40830b);
        return this.f40831c.get(this.f40829a + i);
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f40830b;
    }
}
