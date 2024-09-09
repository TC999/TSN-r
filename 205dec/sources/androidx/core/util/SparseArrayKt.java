package androidx.core.util;

import android.util.SparseArray;
import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.a;
import d2.p;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.r0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: SparseArray.kt */
@Metadata(bv = {}, d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0005\u001a!\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\n\u001a0\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\n\u00a2\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\u0002\u001a!\u0010\f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b\u001a(\u0010\r\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0086\b\u00a2\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000H\u0086\b\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a6\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\b\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0015\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b\u001a\u0019\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086\b\u001a-\u0010\u0017\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a$\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u001aQ\u0010\u001e\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u001aH\u0086\b\u001a\u0016\u0010 \u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001\"\"\u0010%\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\u00a8\u0006&"}, d2 = {"T", "Landroid/util/SparseArray;", "", DomainCampaignEx.LOOPBACK_KEY, "", "contains", "value", "Lkotlin/f1;", f3.f5659h, "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "other", "plus", "containsKey", "containsValue", "(Landroid/util/SparseArray;Ljava/lang/Object;)Z", "defaultValue", "getOrDefault", "(Landroid/util/SparseArray;ILjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/SparseArray;ILd2/a;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "(Landroid/util/SparseArray;ILjava/lang/Object;)Z", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Lkotlin/collections/r0;", "keyIterator", "", "valueIterator", "getSize", "(Landroid/util/SparseArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class SparseArrayKt {
    public static final <T> boolean contains(@NotNull SparseArray<T> contains, int i4) {
        f0.q(contains, "$this$contains");
        return contains.indexOfKey(i4) >= 0;
    }

    public static final <T> boolean containsKey(@NotNull SparseArray<T> containsKey, int i4) {
        f0.q(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(i4) >= 0;
    }

    public static final <T> boolean containsValue(@NotNull SparseArray<T> containsValue, T t3) {
        f0.q(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(t3) >= 0;
    }

    public static final <T> void forEach(@NotNull SparseArray<T> forEach, @NotNull p<? super Integer, ? super T, f1> action) {
        f0.q(forEach, "$this$forEach");
        f0.q(action, "action");
        int size = forEach.size();
        for (int i4 = 0; i4 < size; i4++) {
            action.invoke(Integer.valueOf(forEach.keyAt(i4)), forEach.valueAt(i4));
        }
    }

    public static final <T> T getOrDefault(@NotNull SparseArray<T> getOrDefault, int i4, T t3) {
        f0.q(getOrDefault, "$this$getOrDefault");
        T t4 = getOrDefault.get(i4);
        return t4 != null ? t4 : t3;
    }

    public static final <T> T getOrElse(@NotNull SparseArray<T> getOrElse, int i4, @NotNull a<? extends T> defaultValue) {
        f0.q(getOrElse, "$this$getOrElse");
        f0.q(defaultValue, "defaultValue");
        T t3 = getOrElse.get(i4);
        return t3 != null ? t3 : defaultValue.invoke();
    }

    public static final <T> int getSize(@NotNull SparseArray<T> size) {
        f0.q(size, "$this$size");
        return size.size();
    }

    public static final <T> boolean isEmpty(@NotNull SparseArray<T> isEmpty) {
        f0.q(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    public static final <T> boolean isNotEmpty(@NotNull SparseArray<T> isNotEmpty) {
        f0.q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @NotNull
    public static final <T> r0 keyIterator(@NotNull final SparseArray<T> keyIterator) {
        f0.q(keyIterator, "$this$keyIterator");
        return new r0() { // from class: androidx.core.util.SparseArrayKt$keyIterator$1
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
                SparseArray sparseArray = keyIterator;
                int i4 = this.index;
                this.index = i4 + 1;
                return sparseArray.keyAt(i4);
            }

            public final void setIndex(int i4) {
                this.index = i4;
            }
        };
    }

    @NotNull
    public static final <T> SparseArray<T> plus(@NotNull SparseArray<T> plus, @NotNull SparseArray<T> other) {
        f0.q(plus, "$this$plus");
        f0.q(other, "other");
        SparseArray<T> sparseArray = new SparseArray<>(plus.size() + other.size());
        putAll(sparseArray, plus);
        putAll(sparseArray, other);
        return sparseArray;
    }

    public static final <T> void putAll(@NotNull SparseArray<T> putAll, @NotNull SparseArray<T> other) {
        f0.q(putAll, "$this$putAll");
        f0.q(other, "other");
        int size = other.size();
        for (int i4 = 0; i4 < size; i4++) {
            putAll.put(other.keyAt(i4), other.valueAt(i4));
        }
    }

    public static final <T> boolean remove(@NotNull SparseArray<T> remove, int i4, T t3) {
        f0.q(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(i4);
        if (indexOfKey < 0 || !f0.g(t3, remove.valueAt(indexOfKey))) {
            return false;
        }
        remove.removeAt(indexOfKey);
        return true;
    }

    public static final <T> void set(@NotNull SparseArray<T> set, int i4, T t3) {
        f0.q(set, "$this$set");
        set.put(i4, t3);
    }

    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull SparseArray<T> valueIterator) {
        f0.q(valueIterator, "$this$valueIterator");
        return new SparseArrayKt$valueIterator$1(valueIterator);
    }
}
