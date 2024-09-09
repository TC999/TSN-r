package kotlin;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Tuples.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00028\u00002\u0006\u0010\u0002\u001a\u00028\u0001H\u0086\u0004\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0003\u001a(\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\t\u00a8\u0006\u000b"}, d2 = {"A", "B", "that", "Lkotlin/Pair;", "a", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "T", "", "b", "Lkotlin/Triple;", "c", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "TuplesKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l0 {
    @NotNull
    public static final <A, B> Pair<A, B> a(A a4, B b4) {
        return new Pair<>(a4, b4);
    }

    @NotNull
    public static final <T> List<T> b(@NotNull Pair<? extends T, ? extends T> pair) {
        List<T> M;
        kotlin.jvm.internal.f0.p(pair, "<this>");
        M = CollectionsKt__CollectionsKt.M(pair.getFirst(), pair.getSecond());
        return M;
    }

    @NotNull
    public static final <T> List<T> c(@NotNull Triple<? extends T, ? extends T, ? extends T> triple) {
        List<T> M;
        kotlin.jvm.internal.f0.p(triple, "<this>");
        M = CollectionsKt__CollectionsKt.M(triple.getFirst(), triple.getSecond(), triple.getThird());
        return M;
    }
}
