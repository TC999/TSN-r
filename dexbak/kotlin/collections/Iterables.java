package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;
import p620m1.KMarkers;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0002B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0004H\u0096\u0002¨\u0006\n"}, m12616d2 = {"Lkotlin/collections/o0;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlin/collections/n0;", "", "iterator", "Lkotlin/Function0;", "iteratorFactory", "<init>", "(Ll1/a;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.o0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Iterables<T> implements Iterable<IndexedValue<? extends T>>, KMarkers {

    /* renamed from: a */
    private final InterfaceC15269a<Iterator<T>> f40934a;

    /* JADX WARN: Multi-variable type inference failed */
    public Iterables(@NotNull InterfaceC15269a<? extends Iterator<? extends T>> iteratorFactory) {
        C14342f0.m8184p(iteratorFactory, "iteratorFactory");
        this.f40934a = iteratorFactory;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<IndexedValue<T>> iterator() {
        return new C14184p0(this.f40934a.invoke());
    }
}
