package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

/* compiled from: Iterators.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0010\u0005\n\u0002\b\u0006\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0002H&¨\u0006\b"}, m12616d2 = {"Lkotlin/collections/t;", "", "", "a", "()Ljava/lang/Byte;", "c", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.t */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14218t implements Iterator<Byte>, KMarkers {
    @Override // java.util.Iterator
    @NotNull
    /* renamed from: a */
    public final Byte next() {
        return Byte.valueOf(mo8232c());
    }

    /* renamed from: c */
    public abstract byte mo8232c();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
