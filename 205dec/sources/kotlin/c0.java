package kotlin;

import kotlin.internal.InlineOnly;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PropertyReferenceDelegates.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a6\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0087\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a>\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\t\u001a\u00028\u0000H\u0087\n\u00a2\u0006\u0004\b\u000b\u0010\f\u001a@\u0010\u000f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e2\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0087\n\u00a2\u0006\u0004\b\u000f\u0010\u0010\u001aH\u0010\u0012\u001a\u00020\n\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\t\u001a\u00028\u0001H\u0087\n\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"V", "Lkotlin/reflect/o;", "", "thisRef", "Lkotlin/reflect/n;", "property", "a", "(Lkotlin/reflect/o;Ljava/lang/Object;Lkotlin/reflect/n;)Ljava/lang/Object;", "Lkotlin/reflect/k;", "value", "Lkotlin/f1;", "c", "(Lkotlin/reflect/k;Ljava/lang/Object;Lkotlin/reflect/n;Ljava/lang/Object;)V", "T", "Lkotlin/reflect/p;", "b", "(Lkotlin/reflect/p;Ljava/lang/Object;Lkotlin/reflect/n;)Ljava/lang/Object;", "Lkotlin/reflect/l;", "d", "(Lkotlin/reflect/l;Ljava/lang/Object;Lkotlin/reflect/n;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c0 {
    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <V> V a(kotlin.reflect.o<? extends V> oVar, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.f0.p(oVar, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        return oVar.get();
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T, V> V b(kotlin.reflect.p<T, ? extends V> pVar, T t3, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.f0.p(pVar, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        return pVar.get(t3);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <V> void c(kotlin.reflect.k<V> kVar, Object obj, kotlin.reflect.n<?> property, V v3) {
        kotlin.jvm.internal.f0.p(kVar, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        kVar.set(v3);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    private static final <T, V> void d(kotlin.reflect.l<T, V> lVar, T t3, kotlin.reflect.n<?> property, V v3) {
        kotlin.jvm.internal.f0.p(lVar, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        lVar.set(t3, v3);
    }
}
