package kotlin.collections;

import java.util.Iterator;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UShort;
import p620m1.KMarkers;

/* compiled from: UIterators.kt */
@Annotations(level = DeprecationLevel.ERROR, message = "This class is not going to be stabilized and is to be removed soon.")
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u0003\u001a\u00020\u0002H\u0086\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u0002H&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\b"}, m12616d2 = {"Lkotlin/collections/u1;", "", "Lkotlin/b1;", "a", "()S", "c", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.u1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC14223u1 implements Iterator<UShort>, KMarkers {
    /* renamed from: a */
    public final short m9789a() {
        return mo9788c();
    }

    /* renamed from: c */
    public abstract short mo9788c();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ UShort next() {
        return UShort.m12539b(m9789a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
