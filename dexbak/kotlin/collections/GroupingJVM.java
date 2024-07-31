package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15280l;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0003\u001a0\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00040\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0002H\u0007\u001aZ\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00020\b\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u0006\"\u0004\b\u0002\u0010\u0007*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u001e\u0010\u000b\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\n\u0012\u0004\u0012\u00028\u00020\tH\u0081\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "K", "Lkotlin/collections/j0;", "", "", "a", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "R", "", "Lkotlin/Function1;", "", "f", "b", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/collections/GroupingKt")
/* renamed from: kotlin.collections.l0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class GroupingJVM {
    @SinceKotlin(version = "1.1")
    @NotNull
    /* renamed from: a */
    public static final <T, K> Map<K, Integer> m11923a(@NotNull Grouping<T, ? extends K> eachCount) {
        C14342f0.m8184p(eachCount, "$this$eachCount");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> mo6188b = eachCount.mo6188b();
        while (mo6188b.hasNext()) {
            K mo6189a = eachCount.mo6189a(mo6188b.next());
            Object obj = linkedHashMap.get(mo6189a);
            if (obj == null && !linkedHashMap.containsKey(mo6189a)) {
                obj = new Ref.IntRef();
            }
            Ref.IntRef intRef = (Ref.IntRef) obj;
            intRef.element++;
            linkedHashMap.put(mo6189a, intRef);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (entry == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
            TypeIntrinsics.m8014m(entry).setValue(Integer.valueOf(((Ref.IntRef) entry.getValue()).element));
        }
        return TypeIntrinsics.m8016k(linkedHashMap);
    }

    @PublishedApi
    @InlineOnly
    /* renamed from: b */
    private static final <K, V, R> Map<K, R> m11922b(Map<K, V> map, InterfaceC15280l<? super Map.Entry<? extends K, ? extends V>, ? extends R> interfaceC15280l) {
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
            }
            TypeIntrinsics.m8014m(entry).setValue(interfaceC15280l.invoke(entry));
        }
        return TypeIntrinsics.m8016k(map);
    }
}
