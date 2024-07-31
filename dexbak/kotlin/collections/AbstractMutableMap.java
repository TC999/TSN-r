package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.Nullable;
import p620m1.InterfaceC15301g;

@SinceKotlin(version = "1.1")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\t\b\u0004¢\u0006\u0004\b\t\u0010\nJ!\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, m12616d2 = {"Lkotlin/collections/h;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "Ljava/util/AbstractMap;", DomainCampaignEx.LOOPBACK_KEY, DomainCampaignEx.LOOPBACK_VALUE, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractMutableMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, InterfaceC15301g {
    /* renamed from: a */
    public abstract Set mo5141a();

    /* renamed from: c */
    public /* bridge */ Set mo5140c() {
        return super.keySet();
    }

    /* renamed from: d */
    public /* bridge */ int mo5139d() {
        return super.size();
    }

    /* renamed from: e */
    public /* bridge */ Collection m12002e() {
        return super.values();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return mo5141a();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return mo5140c();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public abstract V put(K k, V v);

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return mo5139d();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<V> values() {
        return m12002e();
    }
}
