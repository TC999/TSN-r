package androidx.core.util;

import android.util.SparseBooleanArray;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC14213q0;
import kotlin.collections.AbstractC14216s;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u001d\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002\u001a\u0015\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0086\b\u001a#\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0086\b\u001a\r\u0010\u0010\u001a\u00020\u0003*\u00020\u0000H\u0086\b\u001a\r\u0010\u0011\u001a\u00020\u0003*\u00020\u0000H\u0086\b\u001a\u001a\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0013\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000\u001aE\u0010\u0018\u001a\u00020\u0006*\u00020\u000026\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0014H\u0086\b\u001a\n\u0010\u001a\u001a\u00020\u0019*\u00020\u0000\u001a\n\u0010\u001c\u001a\u00020\u001b*\u00020\u0000\"\u0016\u0010\u001f\u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, m12616d2 = {"Landroid/util/SparseBooleanArray;", "", DomainCampaignEx.LOOPBACK_KEY, "", "contains", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "set", AdnName.OTHER, "plus", "containsKey", "containsValue", "defaultValue", "getOrDefault", "Lkotlin/Function0;", "getOrElse", "isEmpty", "isNotEmpty", "remove", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", CcgConstant.f38549t, "forEach", "Lkotlin/collections/q0;", "keyIterator", "Lkotlin/collections/s;", "valueIterator", "getSize", "(Landroid/util/SparseBooleanArray;)I", "size", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.util.SparseBooleanArrayKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class SparseBooleanArray {
    public static final boolean contains(@NotNull android.util.SparseBooleanArray contains, int i) {
        C14342f0.m8183q(contains, "$this$contains");
        return contains.indexOfKey(i) >= 0;
    }

    public static final boolean containsKey(@NotNull android.util.SparseBooleanArray containsKey, int i) {
        C14342f0.m8183q(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i) >= 0;
    }

    public static final boolean containsValue(@NotNull android.util.SparseBooleanArray containsValue, boolean z) {
        C14342f0.m8183q(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(z) >= 0;
    }

    public static final void forEach(@NotNull android.util.SparseBooleanArray forEach, @NotNull InterfaceC15284p<? super Integer, ? super Boolean, Unit> action) {
        C14342f0.m8183q(forEach, "$this$forEach");
        C14342f0.m8183q(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i)), Boolean.valueOf(forEach.valueAt(i)));
        }
    }

    public static final boolean getOrDefault(@NotNull android.util.SparseBooleanArray getOrDefault, int i, boolean z) {
        C14342f0.m8183q(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(i, z);
    }

    public static final boolean getOrElse(@NotNull android.util.SparseBooleanArray getOrElse, int i, @NotNull InterfaceC15269a<Boolean> defaultValue) {
        C14342f0.m8183q(getOrElse, "$this$getOrElse");
        C14342f0.m8183q(defaultValue, "defaultValue");
        int indexOfKey = getOrElse.indexOfKey(i);
        return indexOfKey >= 0 ? getOrElse.valueAt(indexOfKey) : defaultValue.invoke().booleanValue();
    }

    public static final int getSize(@NotNull android.util.SparseBooleanArray size) {
        C14342f0.m8183q(size, "$this$size");
        return size.size();
    }

    public static final boolean isEmpty(@NotNull android.util.SparseBooleanArray isEmpty) {
        C14342f0.m8183q(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull android.util.SparseBooleanArray isNotEmpty) {
        C14342f0.m8183q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @NotNull
    public static final AbstractC14213q0 keyIterator(@NotNull final android.util.SparseBooleanArray keyIterator) {
        C14342f0.m8183q(keyIterator, "$this$keyIterator");
        return new AbstractC14213q0() { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
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
                SparseBooleanArray sparseBooleanArray = keyIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @NotNull
    public static final android.util.SparseBooleanArray plus(@NotNull android.util.SparseBooleanArray plus, @NotNull android.util.SparseBooleanArray other) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(other, "other");
        android.util.SparseBooleanArray sparseBooleanArray = new android.util.SparseBooleanArray(plus.size() + other.size());
        putAll(sparseBooleanArray, plus);
        putAll(sparseBooleanArray, other);
        return sparseBooleanArray;
    }

    public static final void putAll(@NotNull android.util.SparseBooleanArray putAll, @NotNull android.util.SparseBooleanArray other) {
        C14342f0.m8183q(putAll, "$this$putAll");
        C14342f0.m8183q(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            putAll.put(other.keyAt(i), other.valueAt(i));
        }
    }

    public static final boolean remove(@NotNull android.util.SparseBooleanArray remove, int i, boolean z) {
        C14342f0.m8183q(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i);
        if (indexOfKey < 0 || z != remove.valueAt(indexOfKey)) {
            return false;
        }
        remove.delete(i);
        return true;
    }

    public static final void set(@NotNull android.util.SparseBooleanArray set, int i, boolean z) {
        C14342f0.m8183q(set, "$this$set");
        set.put(i, z);
    }

    @NotNull
    public static final AbstractC14216s valueIterator(@NotNull final android.util.SparseBooleanArray valueIterator) {
        C14342f0.m8183q(valueIterator, "$this$valueIterator");
        return new AbstractC14216s() { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < valueIterator.size();
            }

            @Override // kotlin.collections.AbstractC14216s
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray = valueIterator;
                int i = this.index;
                this.index = i + 1;
                return sparseBooleanArray.valueAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }
}
