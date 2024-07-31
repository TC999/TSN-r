package androidx.core.util;

import android.util.SparseLongArray;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC14213q0;
import kotlin.collections.AbstractC14214r0;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\n\u001a\u001d\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\n\u001a\u0015\u0010\n\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\u0002\u001a\u0015\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u0005H\u0087\b\u001a#\u0010\u0010\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u0003*\u00020\u0000H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u0003*\u00020\u0000H\u0087\b\u001a\u001c\u0010\u0013\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0007\u001aE\u0010\u0019\u001a\u00020\u0007*\u00020\u000026\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0015H\u0087\b\u001a\f\u0010\u001b\u001a\u00020\u001a*\u00020\u0000H\u0007\u001a\f\u0010\u001d\u001a\u00020\u001c*\u00020\u0000H\u0007\"\u0016\u0010 \u001a\u00020\u0001*\u00020\u00008Ç\u0002¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006!"}, m12616d2 = {"Landroid/util/SparseLongArray;", "", DomainCampaignEx.LOOPBACK_KEY, "", "contains", "", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "set", AdnName.OTHER, "plus", "containsKey", "containsValue", "defaultValue", "getOrDefault", "Lkotlin/Function0;", "getOrElse", "isEmpty", "isNotEmpty", "remove", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", CcgConstant.f38549t, "forEach", "Lkotlin/collections/q0;", "keyIterator", "Lkotlin/collections/r0;", "valueIterator", "getSize", "(Landroid/util/SparseLongArray;)I", "size", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.util.SparseLongArrayKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SparseLongArray {
    @RequiresApi(18)
    public static final boolean contains(@NotNull android.util.SparseLongArray contains, int i) {
        C14342f0.m8183q(contains, "$this$contains");
        return contains.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsKey(@NotNull android.util.SparseLongArray containsKey, int i) {
        C14342f0.m8183q(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i) >= 0;
    }

    @RequiresApi(18)
    public static final boolean containsValue(@NotNull android.util.SparseLongArray containsValue, long j) {
        C14342f0.m8183q(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(j) >= 0;
    }

    @RequiresApi(18)
    public static final void forEach(@NotNull android.util.SparseLongArray forEach, @NotNull InterfaceC15284p<? super Integer, ? super Long, Unit> action) {
        C14342f0.m8183q(forEach, "$this$forEach");
        C14342f0.m8183q(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i)), Long.valueOf(forEach.valueAt(i)));
        }
    }

    @RequiresApi(18)
    public static final long getOrDefault(@NotNull android.util.SparseLongArray getOrDefault, int i, long j) {
        C14342f0.m8183q(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(i, j);
    }

    @RequiresApi(18)
    public static final long getOrElse(@NotNull android.util.SparseLongArray getOrElse, int i, @NotNull InterfaceC15269a<Long> defaultValue) {
        C14342f0.m8183q(getOrElse, "$this$getOrElse");
        C14342f0.m8183q(defaultValue, "defaultValue");
        int indexOfKey = getOrElse.indexOfKey(i);
        return indexOfKey >= 0 ? getOrElse.valueAt(indexOfKey) : defaultValue.invoke().longValue();
    }

    @RequiresApi(18)
    public static final int getSize(@NotNull android.util.SparseLongArray size) {
        C14342f0.m8183q(size, "$this$size");
        return size.size();
    }

    @RequiresApi(18)
    public static final boolean isEmpty(@NotNull android.util.SparseLongArray isEmpty) {
        C14342f0.m8183q(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    @RequiresApi(18)
    public static final boolean isNotEmpty(@NotNull android.util.SparseLongArray isNotEmpty) {
        C14342f0.m8183q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @RequiresApi(18)
    @NotNull
    public static final AbstractC14213q0 keyIterator(@NotNull final android.util.SparseLongArray keyIterator) {
        C14342f0.m8183q(keyIterator, "$this$keyIterator");
        return new AbstractC14213q0() { // from class: androidx.core.util.SparseLongArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < keyIterator.size();
            }

            @Override // kotlin.collections.AbstractC14213q0
            public int nextInt() {
                SparseLongArray sparseLongArray = keyIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @RequiresApi(18)
    @NotNull
    public static final android.util.SparseLongArray plus(@NotNull android.util.SparseLongArray plus, @NotNull android.util.SparseLongArray other) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(other, "other");
        android.util.SparseLongArray sparseLongArray = new android.util.SparseLongArray(plus.size() + other.size());
        putAll(sparseLongArray, plus);
        putAll(sparseLongArray, other);
        return sparseLongArray;
    }

    @RequiresApi(18)
    public static final void putAll(@NotNull android.util.SparseLongArray putAll, @NotNull android.util.SparseLongArray other) {
        C14342f0.m8183q(putAll, "$this$putAll");
        C14342f0.m8183q(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            putAll.put(other.keyAt(i), other.valueAt(i));
        }
    }

    @RequiresApi(18)
    public static final boolean remove(@NotNull android.util.SparseLongArray remove, int i, long j) {
        C14342f0.m8183q(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i);
        if (indexOfKey < 0 || j != remove.valueAt(indexOfKey)) {
            return false;
        }
        remove.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(18)
    public static final void set(@NotNull android.util.SparseLongArray set, int i, long j) {
        C14342f0.m8183q(set, "$this$set");
        set.put(i, j);
    }

    @RequiresApi(18)
    @NotNull
    public static final AbstractC14214r0 valueIterator(@NotNull final android.util.SparseLongArray valueIterator) {
        C14342f0.m8183q(valueIterator, "$this$valueIterator");
        return new AbstractC14214r0() { // from class: androidx.core.util.SparseLongArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < valueIterator.size();
            }

            @Override // kotlin.collections.AbstractC14214r0
            public long nextLong() {
                SparseLongArray sparseLongArray = valueIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseLongArray.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
