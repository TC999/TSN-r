package kotlin.collections;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: MapWithDefault.kt */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B>\u0012\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d\u0012!\u00103\u001a\u001d\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b1\u0012\b\b2\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u000100\u00a2\u0006\u0004\b4\u00105J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u00002\u0006\u0010\u0010\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0013J\u001e\u0010\u001a\u001a\u00020\u00192\u0014\u0010\u0018\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0016J\u0017\u0010\u001c\u001a\u00028\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u0013R&\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b#\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00028\u00000&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010(R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00010*8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b+\u0010,R&\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010.0&8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010(\u00a8\u00066"}, d2 = {"Lkotlin/collections/d1;", "K", "V", "Lkotlin/collections/c1;", "", "other", "", "equals", "", "hashCode", "", "toString", "isEmpty", DomainCampaignEx.LOOPBACK_KEY, "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", f3.f5657f, "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "remove", "", "from", "Lkotlin/f1;", "putAll", "clear", "v", "", "a", "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "map", "d", "()I", "size", "", "c", "()Ljava/util/Set;", "keys", "", "e", "()Ljava/util/Collection;", "values", "", "entries", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "default", "<init>", "(Ljava/util/Map;Ld2/l;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class d1<K, V> implements c1<K, V> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Map<K, V> f55303a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.l<K, V> f55304b;

    /* JADX WARN: Multi-variable type inference failed */
    public d1(@NotNull Map<K, V> map, @NotNull d2.l<? super K, ? extends V> lVar) {
        kotlin.jvm.internal.f0.p(map, "map");
        kotlin.jvm.internal.f0.p(lVar, "default");
        this.f55303a = map;
        this.f55304b = lVar;
    }

    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return getMap().entrySet();
    }

    @NotNull
    public Set<K> c() {
        return getMap().keySet();
    }

    @Override // java.util.Map
    public void clear() {
        getMap().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return getMap().containsValue(obj);
    }

    public int d() {
        return getMap().size();
    }

    @NotNull
    public Collection<V> e() {
        return getMap().values();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return getMap().equals(obj);
    }

    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        return getMap().get(obj);
    }

    @Override // kotlin.collections.c1, kotlin.collections.u0
    @NotNull
    public Map<K, V> getMap() {
        return this.f55303a;
    }

    @Override // java.util.Map
    public int hashCode() {
        return getMap().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return getMap().isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return c();
    }

    @Override // java.util.Map
    @Nullable
    public V put(K k4, V v3) {
        return getMap().put(k4, v3);
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        kotlin.jvm.internal.f0.p(from, "from");
        getMap().putAll(from);
    }

    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        return getMap().remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @NotNull
    public String toString() {
        return getMap().toString();
    }

    @Override // kotlin.collections.u0
    public V v(K k4) {
        Map<K, V> map = getMap();
        V v3 = map.get(k4);
        return (v3 != null || map.containsKey(k4)) ? v3 : this.f55304b.invoke(k4);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return e();
    }
}
