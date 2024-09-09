package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Iterables.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u0087\b\u00f8\u0001\u0000\u001a!\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0001\u00a2\u0006\u0004\b\u0007\u0010\b\u001a \u0010\n\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0001\u001a\"\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0004\u001a@\u0010\u000f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u000b0\u000e\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\r*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e0\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0010"}, d2 = {"T", "Lkotlin/Function0;", "", "iterator", "", "Y", "", "a0", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "default", "Z", "", "b0", "R", "Lkotlin/Pair;", "c0", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/CollectionsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class y extends CollectionsKt__CollectionsKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Iterables.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0010\u001c\n\u0002\u0010(\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002\u00a8\u0006\u0004"}, d2 = {"kotlin/collections/y$a", "", "", "iterator", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements Iterable<T>, e2.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.a<Iterator<T>> f55463a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(d2.a<? extends Iterator<? extends T>> aVar) {
            this.f55463a = aVar;
        }

        @Override // java.lang.Iterable
        @NotNull
        public Iterator<T> iterator() {
            return this.f55463a.invoke();
        }
    }

    @InlineOnly
    private static final <T> Iterable<T> Y(d2.a<? extends Iterator<? extends T>> iterator) {
        kotlin.jvm.internal.f0.p(iterator, "iterator");
        return new a(iterator);
    }

    @PublishedApi
    public static <T> int Z(@NotNull Iterable<? extends T> iterable, int i4) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).size() : i4;
    }

    @PublishedApi
    @Nullable
    public static final <T> Integer a0(@NotNull Iterable<? extends T> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        if (iterable instanceof Collection) {
            return Integer.valueOf(((Collection) iterable).size());
        }
        return null;
    }

    @NotNull
    public static final <T> List<T> b0(@NotNull Iterable<? extends Iterable<? extends T>> iterable) {
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        ArrayList arrayList = new ArrayList();
        for (Iterable<? extends T> iterable2 : iterable) {
            c0.o0(arrayList, iterable2);
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> Pair<List<T>, List<R>> c0(@NotNull Iterable<? extends Pair<? extends T, ? extends R>> iterable) {
        int Z;
        kotlin.jvm.internal.f0.p(iterable, "<this>");
        Z = Z(iterable, 10);
        ArrayList arrayList = new ArrayList(Z);
        ArrayList arrayList2 = new ArrayList(Z);
        for (Pair<? extends T, ? extends R> pair : iterable) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return kotlin.l0.a(arrayList, arrayList2);
    }
}
