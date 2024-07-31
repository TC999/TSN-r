package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import com.kuaishou.weapon.p205p0.C7304t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.builders.C14132d;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000`\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u001a2\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\u001aI\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012#\u0010\n\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0081\bø\u0001\u0000\u001aQ\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\r\u001a\u00020\f2#\u0010\n\u001a\u001f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\u0081\bø\u0001\u0000\u001a \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001H\u0001\u001a(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\r\u001a\u00020\fH\u0001\u001a4\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007H\u0001\u001aE\u0010\u0017\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u0014\u001a\u00028\u00002\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u0015H\u0086\bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a:\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u001a@\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001c\u001a[\u0010!\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\"\u000e\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0019\"\u0004\b\u0001\u0010\u00012*\u0010 \u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u001f\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b!\u0010\"\u001ac\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u001c2*\u0010 \u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00020\u001f\"\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007¢\u0006\u0004\b#\u0010$\u001a\u0019\u0010'\u001a\u00020&*\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%0\u0004H\u0087\b\u001a1\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0081\b\u001a2\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0000\u001a\u0010\u0010+\u001a\u00020\f2\u0006\u0010*\u001a\u00020\fH\u0001\"\u0014\u0010.\u001a\u00020\f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b,\u0010-\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006/"}, m12616d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/Pair;", "pair", "", "k", "Lkotlin/Function1;", "", "Lkotlin/f1;", "Lkotlin/ExtensionFunctionType;", "builderAction", "f", "", "capacity", "e", "g", "h", "builder", "d", "Ljava/util/concurrent/ConcurrentMap;", DomainCampaignEx.LOOPBACK_KEY, "Lkotlin/Function0;", "defaultValue", "i", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Ll1/a;)Ljava/lang/Object;", "", "Ljava/util/SortedMap;", CampaignEx.JSON_KEY_AD_Q, "Ljava/util/Comparator;", "comparator", "r", "", "pairs", "m", "([Lkotlin/Pair;)Ljava/util/SortedMap;", C7304t.f25048d, "(Ljava/util/Comparator;[Lkotlin/Pair;)Ljava/util/SortedMap;", "", "Ljava/util/Properties;", "n", "p", "o", "expectedSize", "j", "a", "I", "INT_MAX_POWER_OF_TWO", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/MapsKt")
/* renamed from: kotlin.collections.x0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MapsJVM extends C14235w0 {

    /* renamed from: a */
    private static final int f40985a = 1073741824;

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    /* renamed from: d */
    public static final <K, V> Map<K, V> m8950d(@NotNull Map<K, V> builder) {
        C14342f0.m8184p(builder, "builder");
        return ((C14132d) builder).m12350n();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @PublishedApi
    /* renamed from: e */
    private static final <K, V> Map<K, V> m8949e(int i, InterfaceC15280l<? super Map<K, V>, Unit> interfaceC15280l) {
        Map m8946h = m8946h(i);
        interfaceC15280l.invoke(m8946h);
        return m8950d(m8946h);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @InlineOnly
    @PublishedApi
    /* renamed from: f */
    private static final <K, V> Map<K, V> m8948f(InterfaceC15280l<? super Map<K, V>, Unit> interfaceC15280l) {
        Map m8947g = m8947g();
        interfaceC15280l.invoke(m8947g);
        return m8950d(m8947g);
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    /* renamed from: g */
    public static final <K, V> Map<K, V> m8947g() {
        return new C14132d();
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    @PublishedApi
    /* renamed from: h */
    public static final <K, V> Map<K, V> m8946h(int i) {
        return new C14132d(i);
    }

    /* renamed from: i */
    public static final <K, V> V m8945i(@NotNull ConcurrentMap<K, V> getOrPut, K k, @NotNull InterfaceC15269a<? extends V> defaultValue) {
        C14342f0.m8184p(getOrPut, "$this$getOrPut");
        C14342f0.m8184p(defaultValue, "defaultValue");
        V v = getOrPut.get(k);
        if (v != null) {
            return v;
        }
        V invoke = defaultValue.invoke();
        V putIfAbsent = getOrPut.putIfAbsent(k, invoke);
        return putIfAbsent != null ? putIfAbsent : invoke;
    }

    @PublishedApi
    /* renamed from: j */
    public static int m8944j(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    @NotNull
    /* renamed from: k */
    public static final <K, V> Map<K, V> m8943k(@NotNull Tuples<? extends K, ? extends V> pair) {
        C14342f0.m8184p(pair, "pair");
        Map<K, V> singletonMap = Collections.singletonMap(pair.getFirst(), pair.getSecond());
        C14342f0.m8185o(singletonMap, "java.util.Collections.si…(pair.first, pair.second)");
        return singletonMap;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @NotNull
    /* renamed from: l */
    public static final <K, V> SortedMap<K, V> m8942l(@NotNull Comparator<? super K> comparator, @NotNull Tuples<? extends K, ? extends V>... pairs) {
        C14342f0.m8184p(comparator, "comparator");
        C14342f0.m8184p(pairs, "pairs");
        TreeMap treeMap = new TreeMap(comparator);
        C14239y0.m8866y0(treeMap, pairs);
        return treeMap;
    }

    @NotNull
    /* renamed from: m */
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m8941m(@NotNull Tuples<? extends K, ? extends V>... pairs) {
        C14342f0.m8184p(pairs, "pairs");
        TreeMap treeMap = new TreeMap();
        C14239y0.m8866y0(treeMap, pairs);
        return treeMap;
    }

    @InlineOnly
    /* renamed from: n */
    private static final Properties m8940n(Map<String, String> map) {
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    @NotNull
    /* renamed from: o */
    public static final <K, V> Map<K, V> m8939o(@NotNull Map<? extends K, ? extends V> toSingletonMap) {
        C14342f0.m8184p(toSingletonMap, "$this$toSingletonMap");
        Map.Entry<? extends K, ? extends V> next = toSingletonMap.entrySet().iterator().next();
        Map<K, V> singletonMap = Collections.singletonMap(next.getKey(), next.getValue());
        C14342f0.m8185o(singletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return singletonMap;
    }

    @InlineOnly
    /* renamed from: p */
    private static final <K, V> Map<K, V> m8938p(Map<K, ? extends V> map) {
        return m8939o(map);
    }

    @NotNull
    /* renamed from: q */
    public static final <K extends Comparable<? super K>, V> SortedMap<K, V> m8937q(@NotNull Map<? extends K, ? extends V> toSortedMap) {
        C14342f0.m8184p(toSortedMap, "$this$toSortedMap");
        return new TreeMap(toSortedMap);
    }

    @NotNull
    /* renamed from: r */
    public static final <K, V> SortedMap<K, V> m8936r(@NotNull Map<? extends K, ? extends V> toSortedMap, @NotNull Comparator<? super K> comparator) {
        C14342f0.m8184p(toSortedMap, "$this$toSortedMap");
        C14342f0.m8184p(comparator, "comparator");
        TreeMap treeMap = new TreeMap(comparator);
        treeMap.putAll(toSortedMap);
        return treeMap;
    }
}
