package kotlin.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MapAccessors.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\t\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\u0015\u0012\u0006\b\u0000\u0012\u00020\u0003\u0012\t\u0012\u00078\u0000\u00a2\u0006\u0002\b\u00040\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0087\n\u00a2\u0006\u0004\b\t\u0010\n\u001aO\u0010\f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\u0017\u0012\u0006\b\u0000\u0012\u00020\u0003\u0012\u000b\b\u0001\u0012\u00078\u0000\u00a2\u0006\u0002\b\u00040\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0087\n\u00a2\u0006\u0004\b\f\u0010\n\u001aH\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0003\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0087\n\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"V", "V1", "", "", "Lkotlin/internal/Exact;", "", "thisRef", "Lkotlin/reflect/n;", "property", "a", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/n;)Ljava/lang/Object;", "", "b", "value", "Lkotlin/f1;", "c", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/n;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "MapAccessorsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t0 {
    @InlineOnly
    private static final <V, V1 extends V> V1 a(Map<? super String, ? extends V> map, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        return (V1) x0.a(map, property.getName());
    }

    @InlineOnly
    @JvmName(name = "getVar")
    private static final <V, V1 extends V> V1 b(Map<? super String, ? extends V> map, Object obj, kotlin.reflect.n<?> property) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        return (V1) x0.a(map, property.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <V> void c(Map<? super String, ? super V> map, Object obj, kotlin.reflect.n<?> property, V v3) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(property, "property");
        map.put(property.getName(), v3);
    }
}
