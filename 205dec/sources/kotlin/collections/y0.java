package kotlin.collections;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.collections.builders.MapBuilder;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MapsJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u001a2\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u001aI\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012#\u0010\n\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0081\b\u00f8\u0001\u0000\u001aQ\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\r\u001a\u00020\f2#\u0010\n\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\b\tH\u0081\b\u00f8\u0001\u0000\u001a \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0001\u001a(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\r\u001a\u00020\fH\u0001\u001a4\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0001\u001aE\u0010\u0017\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u0014\u001a\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a:\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u001a@\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001c\u001a[\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0001\u0010\u00012*\u0010 \u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u001f\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u00a2\u0006\u0004\b!\u0010\"\u001ac\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001c2*\u0010 \u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u001f\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u00a2\u0006\u0004\b#\u0010$\u001a\u0019\u0010'\u001a\u00020&*\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\u0004H\u0087\b\u001a1\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0081\b\u001a2\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0000\u001a\u0010\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020\fH\u0001\"\u0014\u0010.\u001a\u00020\f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b,\u0010-\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006/"}, d2 = {"K", "V", "Lkotlin/Pair;", "pair", "", "k", "Lkotlin/Function1;", "", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "f", "", "capacity", "e", "g", "h", "builder", "d", "Ljava/util/concurrent/ConcurrentMap;", DomainCampaignEx.LOOPBACK_KEY, "Lkotlin/Function0;", "defaultValue", "i", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Ld2/a;)Ljava/lang/Object;", "", "Ljava/util/SortedMap;", CampaignEx.JSON_KEY_AD_Q, "Ljava/util/Comparator;", "comparator", "r", "", "pairs", "m", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "l", "(Ljava/util/Comparator;[Lkotlin/Pair;)Ljava/util/SortedMap;", "", "Ljava/util/Properties;", "n", "p", "o", "expectedSize", "j", "a", "I", "INT_MAX_POWER_OF_TWO", "kotlin-stdlib"}, k = 5, mv = {1, 6, 0}, xs = "kotlin/collections/MapsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class y0 extends x0 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f55464a = 1073741824;

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <K, V> Map<K, V> d(@NotNull Map<K, V> builder) {
        kotlin.jvm.internal.f0.p(builder, "builder");
        return ((MapBuilder) builder).build();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <K, V> Map<K, V> e(int i4, d2.l<? super Map<K, V>, kotlin.f1> builderAction) {
        Map h4;
        Map<K, V> d4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        h4 = h(i4);
        builderAction.invoke(h4);
        d4 = d(h4);
        return d4;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @InlineOnly
    private static final <K, V> Map<K, V> f(d2.l<? super Map<K, V>, kotlin.f1> builderAction) {
        Map g4;
        Map<K, V> d4;
        kotlin.jvm.internal.f0.p(builderAction, "builderAction");
        g4 = g();
        builderAction.invoke(g4);
        d4 = d(g4);
        return d4;
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <K, V> Map<K, V> g() {
        return new MapBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    @NotNull
    public static <K, V> Map<K, V> h(int i4) {
        return new MapBuilder(i4);
    }

    public static final <K, V> V i(@NotNull ConcurrentMap<K, V> concurrentMap, K k4, @NotNull d2.a<? extends V> defaultValue) {
        kotlin.jvm.internal.f0.p(concurrentMap, "<this>");
        kotlin.jvm.internal.f0.p(defaultValue, "defaultValue");
        V v3 = concurrentMap.get(k4);
        if (v3 == null) {
            V invoke = defaultValue.invoke();
            V putIfAbsent = concurrentMap.putIfAbsent(k4, invoke);
            return putIfAbsent == null ? invoke : putIfAbsent;
        }
        return v3;
    }

    @PublishedApi
    public static int j(int i4) {
        if (i4 < 0) {
            return i4;
        }
        if (i4 < 3) {
            return i4 + 1;
        }
        if (i4 < 1073741824) {
            return (int) ((i4 / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    public static <K, V> Map<K, V> k(@NotNull Pair<? extends K, ? extends V> pair) {
        kotlin.jvm.internal.f0.p(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        kotlin.jvm.internal.f0.o(singletonMap, "singletonMap(pair.first, pair.second)");
        return singletonMap;
    }

    @SinceKotlin(version = "1.4")
    @NotNull
    public static final <K, V> SortedMap<K, V> l(@NotNull Comparator<? super K> comparator, @NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        z0.y0(treeMap, pairs);
        return treeMap;
    }

    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m(@NotNull Pair<? extends K, ? extends V>... pairs) {
        kotlin.jvm.internal.f0.p(pairs, "pairs");
        TreeMap treeMap = new TreeMap();
        z0.y0(treeMap, pairs);
        return treeMap;
    }

    @InlineOnly
    private static final Properties n(Map<String, String> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    @NotNull
    public static final <K, V> Map<K, V> o(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        Map.Entry<? extends K, ? extends V> next = map.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        kotlin.jvm.internal.f0.o(singletonMap, "with(entries.iterator().\u2026ingletonMap(key, value) }");
        return singletonMap;
    }

    @InlineOnly
    private static final <K, V> Map<K, V> p(Map<K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return o(map);
    }

    @NotNull
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> q(@NotNull Map<? extends K, ? extends V> map) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        return new TreeMap(map);
    }

    @NotNull
    public static <K, V> SortedMap<K, V> r(@NotNull Map<? extends K, ? extends V> map, @NotNull Comparator<? super K> comparator) {
        kotlin.jvm.internal.f0.p(map, "<this>");
        kotlin.jvm.internal.f0.p(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(map);
        return treeMap;
    }
}
