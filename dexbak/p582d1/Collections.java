package p582d1;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001aC\u0010\u0006\u001a\u00028\u0001\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000\"\u0004\b\u0001\u0010\u0002*\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0001H\u0087\b¢\u0006\u0004\b\u0006\u0010\u0007\u001aJ\u0010\u000b\u001a\u00020\n\"\t\b\u0000\u0010\u0001¢\u0006\u0002\b\u0000\"\t\b\u0001\u0010\u0002¢\u0006\u0002\b\u0000*\u0012\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0006\b\u0001\u0012\u00028\u00010\b2\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0087\b¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, m12616d2 = {"Lkotlin/internal/OnlyInputTypes;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", DomainCampaignEx.LOOPBACK_KEY, "defaultValue", "a", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", DomainCampaignEx.LOOPBACK_VALUE, "", "b", "(Ljava/util/Map;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib-jdk8"}, m12615k = 2, m12614mv = {1, 5, 1}, m12613pn = "kotlin.collections")
@JvmName(name = "CollectionsJDK8Kt")
/* renamed from: d1.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class Collections {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: a */
    private static final <K, V> V m12841a(Map<? extends K, ? extends V> map, K k, V v) {
        if (map != null) {
            return map.getOrDefault(k, v);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.Map<K, V>");
    }

    @SinceKotlin(version = "1.2")
    @InlineOnly
    /* renamed from: b */
    private static final <K, V> boolean m12840b(Map<? extends K, ? extends V> map, K k, V v) {
        if (map != null) {
            return TypeIntrinsics.m8016k(map).remove(k, v);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    }
}
