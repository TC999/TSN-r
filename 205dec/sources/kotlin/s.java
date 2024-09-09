package kotlin;

import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Lazy.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a6\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0087\n\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"T", "value", "Lkotlin/p;", "e", "(Ljava/lang/Object;)Lkotlin/p;", "", "thisRef", "Lkotlin/reflect/n;", "property", "d", "(Lkotlin/p;Ljava/lang/Object;Lkotlin/reflect/n;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/LazyKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class s extends r {
    @InlineOnly
    private static final <T> T d(p<? extends T> pVar, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.f0.p(pVar, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        return pVar.getValue();
    }

    @NotNull
    public static <T> p<T> e(T t3) {
        return new InitializedLazyImpl(t3);
    }
}
