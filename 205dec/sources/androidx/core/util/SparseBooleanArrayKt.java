package androidx.core.util;

import android.util.SparseBooleanArray;
import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.a;
import d2.p;
import kotlin.Metadata;
import kotlin.collections.r;
import kotlin.collections.r0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SparseBooleanArray.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0015\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\u001d\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\t\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000H\u0086\u0002\u001a\u0015\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\b\u001a\u0015\u0010\u000b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0003H\u0086\b\u001a\u001d\u0010\r\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0003H\u0086\b\u001a#\u0010\u000f\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0086\b\u001a\r\u0010\u0010\u001a\u00020\u0003*\u00020\u0000H\u0086\b\u001a\r\u0010\u0011\u001a\u00020\u0003*\u00020\u0000H\u0086\b\u001a\u001a\u0010\u0012\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003\u001a\u0012\u0010\u0013\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0000\u001aE\u0010\u0018\u001a\u00020\u0006*\u00020\u000026\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0014H\u0086\b\u001a\n\u0010\u001a\u001a\u00020\u0019*\u00020\u0000\u001a\n\u0010\u001c\u001a\u00020\u001b*\u00020\u0000\"\u0016\u0010\u001f\u001a\u00020\u0001*\u00020\u00008\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006 "}, d2 = {"Landroid/util/SparseBooleanArray;", "", DomainCampaignEx.LOOPBACK_KEY, "", "contains", "value", "Lkotlin/f1;", f3.f5659h, "other", "plus", "containsKey", "containsValue", "defaultValue", "getOrDefault", "Lkotlin/Function0;", "getOrElse", "isEmpty", "isNotEmpty", "remove", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Lkotlin/collections/r0;", "keyIterator", "Lkotlin/collections/r;", "valueIterator", "getSize", "(Landroid/util/SparseBooleanArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class SparseBooleanArrayKt {
    public static final boolean contains(@NotNull SparseBooleanArray contains, int i4) {
        f0.q(contains, "$this$contains");
        return contains.indexOfKey(i4) >= 0;
    }

    public static final boolean containsKey(@NotNull SparseBooleanArray containsKey, int i4) {
        f0.q(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i4) >= 0;
    }

    public static final boolean containsValue(@NotNull SparseBooleanArray containsValue, boolean z3) {
        f0.q(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(z3) >= 0;
    }

    public static final void forEach(@NotNull SparseBooleanArray forEach, @NotNull p<? super Integer, ? super Boolean, f1> action) {
        f0.q(forEach, "$this$forEach");
        f0.q(action, "action");
        int size = forEach.size();
        for (int i4 = 0; i4 < size; i4++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i4)), Boolean.valueOf(forEach.valueAt(i4)));
        }
    }

    public static final boolean getOrDefault(@NotNull SparseBooleanArray getOrDefault, int i4, boolean z3) {
        f0.q(getOrDefault, "$this$getOrDefault");
        return getOrDefault.get(i4, z3);
    }

    public static final boolean getOrElse(@NotNull SparseBooleanArray getOrElse, int i4, @NotNull a<Boolean> defaultValue) {
        f0.q(getOrElse, "$this$getOrElse");
        f0.q(defaultValue, "defaultValue");
        int indexOfKey = getOrElse.indexOfKey(i4);
        return indexOfKey >= 0 ? getOrElse.valueAt(indexOfKey) : defaultValue.invoke().booleanValue();
    }

    public static final int getSize(@NotNull SparseBooleanArray size) {
        f0.q(size, "$this$size");
        return size.size();
    }

    public static final boolean isEmpty(@NotNull SparseBooleanArray isEmpty) {
        f0.q(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final boolean isNotEmpty(@NotNull SparseBooleanArray isNotEmpty) {
        f0.q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @NotNull
    public static final r0 keyIterator(@NotNull final SparseBooleanArray keyIterator) {
        f0.q(keyIterator, "$this$keyIterator");
        return new r0() { // from class: androidx.core.util.SparseBooleanArrayKt$keyIterator$1
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
                SparseBooleanArray sparseBooleanArray = keyIterator;
                int i4 = this.index;
                this.index = i4 + 1;
                return sparseBooleanArray.keyAt(i4);
            }

            public final void setIndex(int i4) {
                this.index = i4;
            }
        };
    }

    @NotNull
    public static final SparseBooleanArray plus(@NotNull SparseBooleanArray plus, @NotNull SparseBooleanArray other) {
        f0.q(plus, "$this$plus");
        f0.q(other, "other");
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(plus.size() + other.size());
        putAll(sparseBooleanArray, plus);
        putAll(sparseBooleanArray, other);
        return sparseBooleanArray;
    }

    public static final void putAll(@NotNull SparseBooleanArray putAll, @NotNull SparseBooleanArray other) {
        f0.q(putAll, "$this$putAll");
        f0.q(other, "other");
        int size = other.size();
        for (int i4 = 0; i4 < size; i4++) {
            putAll.put(other.keyAt(i4), other.valueAt(i4));
        }
    }

    public static final boolean remove(@NotNull SparseBooleanArray remove, int i4, boolean z3) {
        f0.q(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i4);
        if (indexOfKey < 0 || z3 != remove.valueAt(indexOfKey)) {
            return false;
        }
        remove.delete(i4);
        return true;
    }

    public static final void set(@NotNull SparseBooleanArray set, int i4, boolean z3) {
        f0.q(set, "$this$set");
        set.put(i4, z3);
    }

    @NotNull
    public static final r valueIterator(@NotNull final SparseBooleanArray valueIterator) {
        f0.q(valueIterator, "$this$valueIterator");
        return new r() { // from class: androidx.core.util.SparseBooleanArrayKt$valueIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < valueIterator.size();
            }

            @Override // kotlin.collections.r
            public boolean nextBoolean() {
                SparseBooleanArray sparseBooleanArray = valueIterator;
                int i4 = this.index;
                this.index = i4 + 1;
                return sparseBooleanArray.valueAt(i4);
            }

            public final void setIndex(int i4) {
                this.index = i4;
            }
        };
    }
}
