package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MapWithDefault.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\u001a3\u0010\u0004\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001aQ\u0010\n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00028\u00010\u0006\u001aZ\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000b2!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00028\u00010\u0006H\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, m12616d2 = {"K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", DomainCampaignEx.LOOPBACK_KEY, "a", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "defaultValue", "b", "", "c", "(Ljava/util/Map;Ll1/l;)Ljava/util/Map;", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/MapsKt")
/* renamed from: kotlin.collections.w0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14235w0 {
    @PublishedApi
    @JvmName(name = "getOrImplicitDefaultNullable")
    /* renamed from: a */
    public static final <K, V> V m8961a(@NotNull Map<K, ? extends V> getOrImplicitDefault, K k) {
        C14342f0.m8184p(getOrImplicitDefault, "$this$getOrImplicitDefault");
        if (getOrImplicitDefault instanceof InterfaceC14219t0) {
            return (V) ((InterfaceC14219t0) getOrImplicitDefault).mo9793b(k);
        }
        V v = getOrImplicitDefault.get(k);
        if (v != null || getOrImplicitDefault.containsKey(k)) {
            return v;
        }
        throw new NoSuchElementException("Key " + k + " is missing in the map.");
    }

    @NotNull
    /* renamed from: b */
    public static final <K, V> Map<K, V> m8960b(@NotNull Map<K, ? extends V> withDefault, @NotNull InterfaceC15280l<? super K, ? extends V> defaultValue) {
        C14342f0.m8184p(withDefault, "$this$withDefault");
        C14342f0.m8184p(defaultValue, "defaultValue");
        return withDefault instanceof InterfaceC14219t0 ? m8960b(((InterfaceC14219t0) withDefault).getMap(), defaultValue) : new C14222u0(withDefault, defaultValue);
    }

    @JvmName(name = "withDefaultMutable")
    @NotNull
    /* renamed from: c */
    public static final <K, V> Map<K, V> m8959c(@NotNull Map<K, V> withDefault, @NotNull InterfaceC15280l<? super K, ? extends V> defaultValue) {
        C14342f0.m8184p(withDefault, "$this$withDefault");
        C14342f0.m8184p(defaultValue, "defaultValue");
        return withDefault instanceof MapWithDefault ? m8959c(((MapWithDefault) withDefault).getMap(), defaultValue) : new C14142c1(withDefault, defaultValue);
    }
}
