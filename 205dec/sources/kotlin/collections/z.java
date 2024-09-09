package kotlin.collections;

import java.util.Enumeration;
import java.util.Iterator;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: IteratorsJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u001f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002\u00a8\u0006\u0004"}, d2 = {"T", "Ljava/util/Enumeration;", "", "d0", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class z extends y {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: IteratorsJVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u0096\u0002J\u0010\u0010\u0004\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"kotlin/collections/z$a", "", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements Iterator<T>, e2.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Enumeration<T> f55465a;

        a(Enumeration<T> enumeration) {
            this.f55465a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f55465a.hasMoreElements();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f55465a.nextElement();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    @NotNull
    public static <T> Iterator<T> d0(@NotNull Enumeration<T> enumeration) {
        kotlin.jvm.internal.f0.p(enumeration, "<this>");
        return new a(enumeration);
    }
}
