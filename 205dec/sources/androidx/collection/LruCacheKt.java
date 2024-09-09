package androidx.collection;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.l;
import d2.p;
import d2.r;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: LruCache.kt */
@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u00f8\u0001\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000328\b\u0006\u0010\n\u001a2\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u00052%\b\u0006\u0010\f\u001a\u001f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000b2d\b\u0006\u0010\u0013\u001a^\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00018\u0001\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0086\b\u00a8\u0006\u0016"}, d2 = {"", "K", "V", "", "maxSize", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", DomainCampaignEx.LOOPBACK_KEY, "value", "sizeOf", "Lkotlin/Function1;", "create", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "Lkotlin/f1;", "onEntryRemoved", "Landroidx/collection/LruCache;", "lruCache", "collection-ktx"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class LruCacheKt {
    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i4, @NotNull p<? super K, ? super V, Integer> sizeOf, @NotNull l<? super K, ? extends V> create, @NotNull r<? super Boolean, ? super K, ? super V, ? super V, f1> onEntryRemoved) {
        f0.q(sizeOf, "sizeOf");
        f0.q(create, "create");
        f0.q(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i4, i4);
    }

    @NotNull
    public static /* synthetic */ LruCache lruCache$default(int i4, p pVar, l lVar, r rVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            pVar = new p<Object, Object, Integer>() { // from class: androidx.collection.LruCacheKt$lruCache$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final int invoke2(@NotNull Object obj2, @NotNull Object obj3) {
                    f0.q(obj2, "<anonymous parameter 0>");
                    f0.q(obj3, "<anonymous parameter 1>");
                    return 1;
                }

                @Override // d2.p
                public /* bridge */ /* synthetic */ Integer invoke(Object obj2, Object obj3) {
                    return Integer.valueOf(invoke2(obj2, obj3));
                }
            };
        }
        p sizeOf = pVar;
        if ((i5 & 4) != 0) {
            lVar = new l<Object, Object>() { // from class: androidx.collection.LruCacheKt$lruCache$2
                @Override // d2.l
                @Nullable
                public final Object invoke(@NotNull Object it) {
                    f0.q(it, "it");
                    return null;
                }
            };
        }
        l create = lVar;
        if ((i5 & 8) != 0) {
            rVar = new r<Boolean, Object, Object, Object, f1>() { // from class: androidx.collection.LruCacheKt$lruCache$3
                @Override // d2.r
                public /* bridge */ /* synthetic */ f1 invoke(Boolean bool, Object obj2, Object obj3, Object obj4) {
                    invoke(bool.booleanValue(), obj2, obj3, obj4);
                    return f1.f55527a;
                }

                public final void invoke(boolean z3, @NotNull Object obj2, @NotNull Object obj3, @Nullable Object obj4) {
                    f0.q(obj2, "<anonymous parameter 1>");
                    f0.q(obj3, "<anonymous parameter 2>");
                }
            };
        }
        r onEntryRemoved = rVar;
        f0.q(sizeOf, "sizeOf");
        f0.q(create, "create");
        f0.q(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i4, i4);
    }
}
