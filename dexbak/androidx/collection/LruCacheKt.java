package androidx.collection;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15286r;

/* compiled from: LruCache.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000:\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aø\u0001\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000328\b\u0006\u0010\n\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u00052%\b\u0006\u0010\f\u001a\u001f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000b2d\b\u0006\u0010\u0013\u001a^\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\rH\u0086\b¨\u0006\u0016"}, m12616d2 = {"", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "maxSize", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", DomainCampaignEx.LOOPBACK_KEY, DomainCampaignEx.LOOPBACK_VALUE, "sizeOf", "Lkotlin/Function1;", "create", "Lkotlin/Function4;", "", "evicted", "oldValue", "newValue", "Lkotlin/f1;", "onEntryRemoved", "Landroidx/collection/LruCache;", "lruCache", "collection-ktx"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class LruCacheKt {
    @NotNull
    public static final <K, V> LruCache<K, V> lruCache(int i, @NotNull InterfaceC15284p<? super K, ? super V, Integer> sizeOf, @NotNull InterfaceC15280l<? super K, ? extends V> create, @NotNull InterfaceC15286r<? super Boolean, ? super K, ? super V, ? super V, Unit> onEntryRemoved) {
        C14342f0.m8183q(sizeOf, "sizeOf");
        C14342f0.m8183q(create, "create");
        C14342f0.m8183q(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i, i);
    }

    @NotNull
    public static /* synthetic */ LruCache lruCache$default(int i, InterfaceC15284p interfaceC15284p, InterfaceC15280l interfaceC15280l, InterfaceC15286r interfaceC15286r, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            interfaceC15284p = new InterfaceC15284p<Object, Object, Integer>() { // from class: androidx.collection.LruCacheKt$lruCache$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final int invoke2(@NotNull Object obj2, @NotNull Object obj3) {
                    C14342f0.m8183q(obj2, "<anonymous parameter 0>");
                    C14342f0.m8183q(obj3, "<anonymous parameter 1>");
                    return 1;
                }

                @Override // p617l1.InterfaceC15284p
                public /* bridge */ /* synthetic */ Integer invoke(Object obj2, Object obj3) {
                    return Integer.valueOf(invoke2(obj2, obj3));
                }
            };
        }
        InterfaceC15284p sizeOf = interfaceC15284p;
        if ((i2 & 4) != 0) {
            interfaceC15280l = new InterfaceC15280l<Object, Object>() { // from class: androidx.collection.LruCacheKt$lruCache$2
                @Override // p617l1.InterfaceC15280l
                @Nullable
                public final Object invoke(@NotNull Object it) {
                    C14342f0.m8183q(it, "it");
                    return null;
                }
            };
        }
        InterfaceC15280l create = interfaceC15280l;
        if ((i2 & 8) != 0) {
            interfaceC15286r = new InterfaceC15286r<Boolean, Object, Object, Object, Unit>() { // from class: androidx.collection.LruCacheKt$lruCache$3
                @Override // p617l1.InterfaceC15286r
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Object obj2, Object obj3, Object obj4) {
                    invoke(bool.booleanValue(), obj2, obj3, obj4);
                    return Unit.f41048a;
                }

                public final void invoke(boolean z, @NotNull Object obj2, @NotNull Object obj3, @Nullable Object obj4) {
                    C14342f0.m8183q(obj2, "<anonymous parameter 1>");
                    C14342f0.m8183q(obj3, "<anonymous parameter 2>");
                }
            };
        }
        InterfaceC15286r onEntryRemoved = interfaceC15286r;
        C14342f0.m8183q(sizeOf, "sizeOf");
        C14342f0.m8183q(create, "create");
        C14342f0.m8183q(onEntryRemoved, "onEntryRemoved");
        return new LruCacheKt$lruCache$4(sizeOf, create, onEntryRemoved, i, i);
    }
}
