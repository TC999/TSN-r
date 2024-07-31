package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Map;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import kotlin.reflect.InterfaceC14446n;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\t\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\u0015\u0012\u0006\b\u0000\u0012\u00020\u0003\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\u00040\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0087\n¢\u0006\u0004\b\t\u0010\n\u001aO\u0010\f\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0001*\u00028\u0000*\u0017\u0012\u0006\b\u0000\u0012\u00020\u0003\u0012\u000b\b\u0001\u0012\u00078\u0000¢\u0006\u0002\b\u00040\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0087\n¢\u0006\u0004\b\f\u0010\n\u001aH\u0010\u000f\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0000*\u0012\u0012\u0006\b\u0000\u0012\u00020\u0003\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, m12616d2 = {ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "V1", "", "", "Lkotlin/internal/Exact;", "", "thisRef", "Lkotlin/reflect/n;", "property", "a", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/n;)Ljava/lang/Object;", "", "b", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "c", "(Ljava/util/Map;Ljava/lang/Object;Lkotlin/reflect/n;Ljava/lang/Object;)V", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
@JvmName(name = "MapAccessorsKt")
/* renamed from: kotlin.collections.s0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class MapAccessors {
    @InlineOnly
    /* renamed from: a */
    private static final <V, V1 extends V> V1 m9801a(Map<? super String, ? extends V> getValue, Object obj, InterfaceC14446n<?> interfaceC14446n) {
        C14342f0.m8184p(getValue, "$this$getValue");
        return (V1) C14235w0.m8961a(getValue, interfaceC14446n.getName());
    }

    @InlineOnly
    @JvmName(name = "getVar")
    /* renamed from: b */
    private static final <V, V1 extends V> V1 m9800b(Map<? super String, ? extends V> getValue, Object obj, InterfaceC14446n<?> interfaceC14446n) {
        C14342f0.m8184p(getValue, "$this$getValue");
        return (V1) C14235w0.m8961a(getValue, interfaceC14446n.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    /* renamed from: c */
    private static final <V> void m9799c(Map<? super String, ? super V> setValue, Object obj, InterfaceC14446n<?> interfaceC14446n, V v) {
        C14342f0.m8184p(setValue, "$this$setValue");
        setValue.put(interfaceC14446n.getName(), v);
    }
}
