package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p620m1.KMarkers;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002¨\u0006\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/Enumeration;", "", "f0", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/CollectionsKt")
/* renamed from: kotlin.collections.y */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class IteratorsJVM extends C14236x {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: IteratorsJVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {"kotlin/collections/y$a", "", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.collections.y$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14238a<T> implements Iterator<T>, KMarkers {

        /* renamed from: a */
        final /* synthetic */ Enumeration f40986a;

        C14238a(Enumeration<T> enumeration) {
            this.f40986a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f40986a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return (T) this.f40986a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    /* renamed from: f0 */
    public static <T> Iterator<T> m8935f0(@NotNull Enumeration<T> iterator) {
        C14342f0.m8184p(iterator, "$this$iterator");
        return new C14238a(iterator);
    }
}
