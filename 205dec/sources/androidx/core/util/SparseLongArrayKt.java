package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.a;
import d2.p;
import kotlin.Metadata;
import kotlin.collections.r0;
import kotlin.collections.s0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SparseLongArray.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u001d\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0002\u001a\u0015\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0005H\u0087\b\u001a#\u0010\u0010\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u0003*\u00020\u0000H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0003*\u00020\u0000H\u0087\b\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0007\u001aE\u0010\u0019\u001a\u00020\u0007*\u00020\u000026\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0015H\u0087\b\u001a\f\u0010\u001b\u001a\u00020\u001a*\u00020\u0000H\u0007\u001a\f\u0010\u001d\u001a\u00020\u001c*\u00020\u0000H\u0007\"\u0016\u0010 \u001a\u00020\u0001*\u00020\u00008\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006!"}, d2 = {"Landroid/util/SparseLongArray;", "", DomainCampaignEx.LOOPBACK_KEY, "", "contains", "", "value", "Lkotlin/f1;", f3.f5659h, "other", "plus", "containsKey", "containsValue", "defaultValue", "getOrDefault", "Lkotlin/Function0;", "getOrElse", "isEmpty", "isNotEmpty", "remove", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Lkotlin/collections/r0;", "keyIterator", "Lkotlin/collections/s0;", "valueIterator", "getSize", "(Landroid/util/SparseLongArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class SparseLongArrayKt {
    @RequiresApi(18)
    public static final boolean contains(@NotNull SparseLongArray contains, int i4) {
        f0.q(contains, "$this$contains");
        return contains.indexOfKey(i4) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(@NotNull SparseLongArray containsKey, int i4) {
        f0.q(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i4) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(@NotNull SparseLongArray containsValue, long j4) {
        f0.q(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(j4) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(@NotNull SparseLongArray forEach, @NotNull p<? super Integer, ? super Long, f1> action) {
        f0.q(forEach, "$this$forEach");
        f0.q(action, "action");
        int size = forEach.size();
        for (int i4 = 0; i4 < size; i4++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i4)), Long.valueOf(forEach.valueAt(i4)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(@NotNull SparseLongArray getOrDefault, int i4, long j4) {
        f0.q(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(i4, j4);
    }

    @RequiresApi(18)
    public static final long getOrElse(@NotNull SparseLongArray getOrElse, int i4, @NotNull a<Long> defaultValue) {
        f0.q(getOrElse, "$this$getOrElse");
        f0.q(defaultValue, "defaultValue");
        int indexOfKey = getOrElse.indexOfKey(i4);
        return indexOfKey >= 0 ? getOrElse.valueAt(indexOfKey) : defaultValue.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(@NotNull SparseLongArray size) {
        f0.q(size, "$this$size");
        return size.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(@NotNull SparseLongArray isEmpty) {
        f0.q(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(@NotNull SparseLongArray isNotEmpty) {
        f0.q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @RequiresApi(18)
    @NotNull
    public static final r0 keyIterator(@NotNull final SparseLongArray keyIterator) {
        f0.q(keyIterator, "$this$keyIterator");
        return new r0() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < keyIterator.size();
            }

            @Override // kotlin.collections.r0
            public int nextInt() {
                SparseLongArray sparseLongArray = keyIterator;
                int i4 = this.index;
                this.index = i4 + 1;
                return sparseLongArray.keyAt(i4);
            }

            public final void setIndex(int i4) {
                this.index = i4;
            }
        };
    }

    @RequiresApi(18)
    @NotNull
    public static final SparseLongArray plus(@NotNull SparseLongArray plus, @NotNull SparseLongArray other) {
        f0.q(plus, "$this$plus");
        f0.q(other, "other");
        SparseLongArray sparseLongArray = new SparseLongArray(plus.size() + other.size());
        putAll(sparseLongArray, plus);
        putAll(sparseLongArray, other);
        return sparseLongArray;
    }

    @RequiresApi(18)
    public static final void putAll(@NotNull SparseLongArray putAll, @NotNull SparseLongArray other) {
        f0.q(putAll, "$this$putAll");
        f0.q(other, "other");
        int size = other.size();
        for (int i4 = 0; i4 < size; i4++) {
            putAll.put(other.keyAt(i4), other.valueAt(i4));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(@NotNull SparseLongArray remove, int i4, long j4) {
        f0.q(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i4);
        if (indexOfKey < 0 || j4 != remove.valueAt(indexOfKey)) {
            return false;
        }
        remove.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(@NotNull SparseLongArray set, int i4, long j4) {
        f0.q(set, "$this$set");
        set.put(i4, j4);
    }

    @RequiresApi(18)
    @NotNull
    public static final s0 valueIterator(@NotNull final SparseLongArray valueIterator) {
        f0.q(valueIterator, "$this$valueIterator");
        return new s0() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < valueIterator.size();
            }

            @Override // kotlin.collections.s0
            public long nextLong() {
                SparseLongArray sparseLongArray = valueIterator;
                int i4 = this.index;
                this.index = i4 + 1;
                return sparseLongArray.valueAt(i4);
            }

            public final void setIndex(int i4) {
                this.index = i4;
            }
        };
    }
}
