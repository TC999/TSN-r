package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import com.acse.ottn.f3;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.a;
import d2.p;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.s0;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: LongSparseArray.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u001a0\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0087\n\u00a2\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\u0002\u001a!\u0010\f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a(\u0010\r\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0087\b\u00a2\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000H\u0087\b\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a6\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0087\b\u00a2\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0015\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b\u001a\u0019\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b\u001a/\u0010\u0017\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a&\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001aQ\u0010\u001e\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u001aH\u0087\b\u001a\u0018\u0010 \u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\"\"\u0010&\u001a\u00020#\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018\u00c7\u0002\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006'"}, d2 = {"T", "Landroid/util/LongSparseArray;", "", DomainCampaignEx.LOOPBACK_KEY, "", "contains", "value", "Lkotlin/f1;", f3.f5659h, "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "other", "plus", "containsKey", "containsValue", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "defaultValue", "getOrDefault", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/LongSparseArray;JLd2/a;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "action", "forEach", "Lkotlin/collections/s0;", "keyIterator", "", "valueIterator", "", "getSize", "(Landroid/util/LongSparseArray;)I", "size", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class LongSparseArrayKt {
    @RequiresApi(16)
    public static final <T> boolean contains(@NotNull LongSparseArray<T> contains, long j4) {
        f0.q(contains, "$this$contains");
        return contains.indexOfKey(j4) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(@NotNull LongSparseArray<T> containsKey, long j4) {
        f0.q(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(j4) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(@NotNull LongSparseArray<T> containsValue, T t3) {
        f0.q(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(t3) >= 0;
    }

    @RequiresApi(16)
    public static final <T> void forEach(@NotNull LongSparseArray<T> forEach, @NotNull p<? super Long, ? super T, f1> action) {
        f0.q(forEach, "$this$forEach");
        f0.q(action, "action");
        int size = forEach.size();
        for (int i4 = 0; i4 < size; i4++) {
            action.invoke(Long.valueOf(forEach.keyAt(i4)), forEach.valueAt(i4));
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(@NotNull LongSparseArray<T> getOrDefault, long j4, T t3) {
        f0.q(getOrDefault, "$this$getOrDefault");
        T t4 = getOrDefault.get(j4);
        return t4 != null ? t4 : t3;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(@NotNull LongSparseArray<T> getOrElse, long j4, @NotNull a<? extends T> defaultValue) {
        f0.q(getOrElse, "$this$getOrElse");
        f0.q(defaultValue, "defaultValue");
        T t3 = getOrElse.get(j4);
        return t3 != null ? t3 : defaultValue.invoke();
    }

    @RequiresApi(16)
    public static final <T> int getSize(@NotNull LongSparseArray<T> size) {
        f0.q(size, "$this$size");
        return size.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(@NotNull LongSparseArray<T> isEmpty) {
        f0.q(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(@NotNull LongSparseArray<T> isNotEmpty) {
        f0.q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> s0 keyIterator(@NotNull final LongSparseArray<T> keyIterator) {
        f0.q(keyIterator, "$this$keyIterator");
        return new s0() { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < keyIterator.size();
            }

            @Override // kotlin.collections.s0
            public long nextLong() {
                LongSparseArray longSparseArray = keyIterator;
                int i4 = this.index;
                this.index = i4 + 1;
                return longSparseArray.keyAt(i4);
            }

            public final void setIndex(int i4) {
                this.index = i4;
            }
        };
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> LongSparseArray<T> plus(@NotNull LongSparseArray<T> plus, @NotNull LongSparseArray<T> other) {
        f0.q(plus, "$this$plus");
        f0.q(other, "other");
        LongSparseArray<T> longSparseArray = new LongSparseArray<>(plus.size() + other.size());
        putAll(longSparseArray, plus);
        putAll(longSparseArray, other);
        return longSparseArray;
    }

    @RequiresApi(16)
    public static final <T> void putAll(@NotNull LongSparseArray<T> putAll, @NotNull LongSparseArray<T> other) {
        f0.q(putAll, "$this$putAll");
        f0.q(other, "other");
        int size = other.size();
        for (int i4 = 0; i4 < size; i4++) {
            putAll.put(other.keyAt(i4), other.valueAt(i4));
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(@NotNull LongSparseArray<T> remove, long j4, T t3) {
        f0.q(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(j4);
        if (indexOfKey < 0 || !f0.g(t3, remove.valueAt(indexOfKey))) {
            return false;
        }
        remove.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(@NotNull LongSparseArray<T> set, long j4, T t3) {
        f0.q(set, "$this$set");
        set.put(j4, t3);
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull LongSparseArray<T> valueIterator) {
        f0.q(valueIterator, "$this$valueIterator");
        return new LongSparseArrayKt$valueIterator$1(valueIterator);
    }
}
