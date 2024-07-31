package androidx.collection;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15286r;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCache.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0007\u0010\bJ1\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00028\u00012\b\u0010\f\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m12616d2 = {"androidx/collection/LruCacheKt$lruCache$4", "Landroidx/collection/LruCache;", DomainCampaignEx.LOOPBACK_KEY, DomainCampaignEx.LOOPBACK_VALUE, "", "sizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "create", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "evicted", "oldValue", "newValue", "Lkotlin/f1;", "entryRemoved", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "collection-ktx"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    final /* synthetic */ InterfaceC15280l $create;
    final /* synthetic */ int $maxSize;
    final /* synthetic */ InterfaceC15286r $onEntryRemoved;
    final /* synthetic */ InterfaceC15284p $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(InterfaceC15284p interfaceC15284p, InterfaceC15280l interfaceC15280l, InterfaceC15286r interfaceC15286r, int i, int i2) {
        super(i2);
        this.$sizeOf = interfaceC15284p;
        this.$create = interfaceC15280l;
        this.$onEntryRemoved = interfaceC15286r;
        this.$maxSize = i;
    }

    @Override // androidx.collection.LruCache
    @Nullable
    protected V create(@NotNull K key) {
        C14342f0.m8183q(key, "key");
        return (V) this.$create.invoke(key);
    }

    @Override // androidx.collection.LruCache
    protected void entryRemoved(boolean z, @NotNull K key, @NotNull V oldValue, @Nullable V v) {
        C14342f0.m8183q(key, "key");
        C14342f0.m8183q(oldValue, "oldValue");
        this.$onEntryRemoved.invoke(Boolean.valueOf(z), key, oldValue, v);
    }

    @Override // androidx.collection.LruCache
    protected int sizeOf(@NotNull K key, @NotNull V value) {
        C14342f0.m8183q(key, "key");
        C14342f0.m8183q(value, "value");
        return ((Number) this.$sizeOf.invoke(key, value)).intValue();
    }
}
