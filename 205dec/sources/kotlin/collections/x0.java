package kotlin.collections;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MapWithDefault.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\u001a3\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0001\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001aQ\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00028\u00010\u0006\u001aZ\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00028\u00010\u0006H\u0007\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"K", "V", "", DomainCampaignEx.LOOPBACK_KEY, "a", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "defaultValue", "b", "", "c", "(Ljava/util/Map;Ld2/l;)Ljava/util/Map;", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/MapsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class x0 {
    @PublishedApi
    @JvmName(name = "getOrImplicitDefaultNullable")
    public static final <K, V> V a(@NotNull Map<K, ? extends V> map, K k4) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        if (map instanceof u0) {
            return (V) ((u0) map).v(k4);
        }
        V v3 = map.get(k4);
        if (v3 != null || map.containsKey(k4)) {
            return v3;
        }
        throw new NoSuchElementException("Key " + k4 + " is missing in the map.");
    }

    @NotNull
    public static final <K, V> Map<K, V> b(@NotNull Map<K, ? extends V> map, @NotNull d2.l<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return map instanceof u0 ? b(((u0) map).getMap(), defaultValue) : new v0(map, defaultValue);
    }

    @JvmName(name = "withDefaultMutable")
    @NotNull
    public static final <K, V> Map<K, V> c(@NotNull Map<K, V> map, @NotNull d2.l<? super K, ? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        return map instanceof c1 ? c(((c1) map).getMap(), defaultValue) : new d1(map, defaultValue);
    }
}
