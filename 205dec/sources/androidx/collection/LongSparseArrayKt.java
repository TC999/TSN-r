package androidx.collection;

import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.a;
import d2.p;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.s0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: LongSparseArray.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\n\u001a0\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\n\u00a2\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002\u001a0\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00028\u0000H\u0086\b\u00a2\u0006\u0004\b\r\u0010\u000e\u001a6\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH\u0086\b\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b\u001a/\u0010\u0013\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001aQ\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0015H\u0086\b\u001a\u0016\u0010\u001b\u001a\u00020\u001a\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001c\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\"\"\u0010!\u001a\u00020\u001e\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006\""}, d2 = {"T", "Landroidx/collection/LongSparseArray;", "", DomainCampaignEx.LOOPBACK_KEY, "", "contains", "value", "Lkotlin/f1;", f3.f5659h, "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)V", "other", "plus", "defaultValue", "getOrDefault", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroidx/collection/LongSparseArray;JLd2/a;)Ljava/lang/Object;", "isNotEmpty", "remove", "(Landroidx/collection/LongSparseArray;JLjava/lang/Object;)Z", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Lkotlin/collections/s0;", "keyIterator", "", "valueIterator", "", "getSize", "(Landroidx/collection/LongSparseArray;)I", "size", "collection-ktx"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class LongSparseArrayKt {
    public static final <T> boolean contains(@NotNull LongSparseArray<T> receiver$0, long j4) {
        f0.q(receiver$0, "receiver$0");
        return receiver$0.containsKey(j4);
    }

    public static final <T> void forEach(@NotNull LongSparseArray<T> receiver$0, @NotNull p<? super Long, ? super T, f1> action) {
        f0.q(receiver$0, "receiver$0");
        f0.q(action, "action");
        int size = receiver$0.size();
        for (int i4 = 0; i4 < size; i4++) {
            action.invoke(Long.valueOf(receiver$0.keyAt(i4)), receiver$0.valueAt(i4));
        }
    }

    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> receiver$0, long j4, T t3) {
        f0.q(receiver$0, "receiver$0");
        return receiver$0.get(j4, t3);
    }

    public static final <T> T getOrElse(@NotNull LongSparseArray<T> receiver$0, long j4, @NotNull a<? extends T> defaultValue) {
        f0.q(receiver$0, "receiver$0");
        f0.q(defaultValue, "defaultValue");
        T t3 = receiver$0.get(j4);
        return t3 != null ? t3 : defaultValue.invoke();
    }

    public static final <T> int getSize(@NotNull LongSparseArray<T> receiver$0) {
        f0.q(receiver$0, "receiver$0");
        return receiver$0.size();
    }

    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> receiver$0) {
        f0.q(receiver$0, "receiver$0");
        return !receiver$0.isEmpty();
    }

    @NotNull
    public static final <T> s0 keyIterator(@NotNull final LongSparseArray<T> receiver$0) {
        f0.q(receiver$0, "receiver$0");
        return new s0() { // from class: androidx.collection.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < receiver$0.size();
            }

            @Override // kotlin.collections.s0
            public long nextLong() {
                LongSparseArray longSparseArray = receiver$0;
                int i4 = this.index;
                this.index = i4 + 1;
                return longSparseArray.keyAt(i4);
            }

            public final void setIndex(int i4) {
                this.index = i4;
            }
        };
    }

    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> receiver$0, @NotNull LongSparseArray<T> other) {
        f0.q(receiver$0, "receiver$0");
        f0.q(other, "other");
        LongSparseArray<T> longSparseArray = new LongSparseArray<>(receiver$0.size() + other.size());
        longSparseArray.putAll(receiver$0);
        longSparseArray.putAll(other);
        return longSparseArray;
    }

    @Deprecated(message = "Replaced with member function. Remove extension import!")
    public static final <T> boolean remove(@NotNull LongSparseArray<T> receiver$0, long j4, T t3) {
        f0.q(receiver$0, "receiver$0");
        return receiver$0.remove(j4, t3);
    }

    public static final <T> void set(@NotNull LongSparseArray<T> receiver$0, long j4, T t3) {
        f0.q(receiver$0, "receiver$0");
        receiver$0.put(j4, t3);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> receiver$0) {
        f0.q(receiver$0, "receiver$0");
        return new LongSparseArrayKt$valueIterator$1(receiver$0);
    }
}
