package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: GroupingJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0003\u001a0\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u001aZ\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\b\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0006\"\u0004\b\u0002\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u00020\tH\u0081\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\r"}, d2 = {"T", "K", "Lkotlin/collections/k0;", "", "", "a", "V", "R", "", "Lkotlin/Function1;", "", "f", "b", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/GroupingKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class m0 {
    @SinceKotlin(version = "1.1")
    @NotNull
    public static final <T, K> Map<K, Integer> a(@NotNull k0<T, ? extends K> k0Var) {
        kotlin.jvm.internal.f0.p(k0Var, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> b4 = k0Var.b();
        while (b4.hasNext()) {
            K a4 = k0Var.a(b4.next());
            Object obj = linkedHashMap.get(a4);
            if (obj == null && !linkedHashMap.containsKey(a4)) {
                obj = new Ref.IntRef();
            }
            Ref.IntRef intRef = (Ref.IntRef) obj;
            intRef.element++;
            linkedHashMap.put(a4, intRef);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            entry.setValue(Integer.valueOf(((Ref.IntRef) entry.getValue()).element));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @PublishedApi
    @InlineOnly
    private static final <K, V, R> Map<K, R> b(Map<K, V> map, d2.l<? super Map.Entry<? extends K, ? extends V>, ? extends R> f4) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(f4, "f");
        for (Map.Entry entry : map.entrySet()) {
            entry.setValue(f4.invoke(entry));
        }
        return map;
    }
}
