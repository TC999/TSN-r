package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: MapWithDefault.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B>\u0012\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015\u0012!\u0010+\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b)\u0012\b\b*\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00028\u00010(¢\u0006\u0004\b,\u0010-J\u0013\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\u0006H\u0016J\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u001a\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00028\u00012\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0013R&\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00010\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R&\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&0\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010 ¨\u0006."}, m12616d2 = {"Lkotlin/collections/u0;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lkotlin/collections/t0;", "", AdnName.OTHER, "", "equals", "", TTDownloadField.TT_HASHCODE, "", "toString", "isEmpty", DomainCampaignEx.LOOPBACK_KEY, "containsKey", "(Ljava/lang/Object;)Z", DomainCampaignEx.LOOPBACK_VALUE, "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "b", "", "a", "Ljava/util/Map;", "getMap", "()Ljava/util/Map;", "map", "d", "()I", "size", "", "c", "()Ljava/util/Set;", "keys", "", "e", "()Ljava/util/Collection;", "values", "", "entries", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "default", "<init>", "(Ljava/util/Map;Ll1/l;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.u0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C14222u0<K, V> implements InterfaceC14219t0<K, V> {
    @NotNull

    /* renamed from: a */
    private final Map<K, V> f40974a;

    /* renamed from: b */
    private final InterfaceC15280l<K, V> f40975b;

    /* JADX WARN: Multi-variable type inference failed */
    public C14222u0(@NotNull Map<K, ? extends V> map, @NotNull InterfaceC15280l<? super K, ? extends V> interfaceC15280l) {
        C14342f0.m8184p(map, "map");
        C14342f0.m8184p(interfaceC15280l, "default");
        this.f40974a = map;
        this.f40975b = interfaceC15280l;
    }

    @NotNull
    /* renamed from: a */
    public Set<Map.Entry<K, V>> m9794a() {
        return getMap().entrySet();
    }

    @Override // kotlin.collections.InterfaceC14219t0
    /* renamed from: b */
    public V mo9793b(K k) {
        Map<K, V> map = getMap();
        V v = map.get(k);
        return (v != null || map.containsKey(k)) ? v : this.f40975b.invoke(k);
    }

    @NotNull
    /* renamed from: c */
    public Set<K> m9792c() {
        return getMap().keySet();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return getMap().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return getMap().containsValue(obj);
    }

    /* renamed from: d */
    public int m9791d() {
        return getMap().size();
    }

    @NotNull
    /* renamed from: e */
    public Collection<V> m9790e() {
        return getMap().values();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return m9794a();
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

    @Override // kotlin.collections.InterfaceC14219t0
    @NotNull
    public Map<K, V> getMap() {
        return this.f40974a;
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
        return m9792c();
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return m9791d();
    }

    @NotNull
    public String toString() {
        return getMap().toString();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return m9790e();
    }
}
