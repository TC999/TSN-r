package androidx.core.util;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.ccg.CcgConstant;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractC14214r0;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u001a!\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\n\u001a0\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0087\n¢\u0006\u0004\b\b\u0010\t\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\u0002\u001a!\u0010\f\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a(\u0010\r\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0006\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\r\u0010\u000e\u001a0\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00028\u0000H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a6\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0087\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0019\u0010\u0015\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b\u001a\u0019\u0010\u0016\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0087\b\u001a/\u0010\u0017\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a&\u0010\u0019\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001aQ\u0010\u001e\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0003\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u001aH\u0087\b\u001a\u0018\u0010 \u001a\u00020\u001f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0007\"\"\u0010&\u001a\u00020#\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00018Ç\u0002¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006'"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroid/util/LongSparseArray;", "", DomainCampaignEx.LOOPBACK_KEY, "", "contains", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "set", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", AdnName.OTHER, "plus", "containsKey", "containsValue", "(Landroid/util/LongSparseArray;Ljava/lang/Object;)Z", "defaultValue", "getOrDefault", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function0;", "getOrElse", "(Landroid/util/LongSparseArray;JLl1/a;)Ljava/lang/Object;", "isEmpty", "isNotEmpty", "remove", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)Z", "putAll", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", CcgConstant.f38549t, "forEach", "Lkotlin/collections/r0;", "keyIterator", "", "valueIterator", "", "getSize", "(Landroid/util/LongSparseArray;)I", "size", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.util.LongSparseArrayKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class LongSparseArray {
    @RequiresApi(16)
    public static final <T> boolean contains(@NotNull android.util.LongSparseArray<T> contains, long j) {
        C14342f0.m8183q(contains, "$this$contains");
        return contains.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsKey(@NotNull android.util.LongSparseArray<T> containsKey, long j) {
        C14342f0.m8183q(containsKey, "$this$containsKey");
        return containsKey.indexOfKey(j) >= 0;
    }

    @RequiresApi(16)
    public static final <T> boolean containsValue(@NotNull android.util.LongSparseArray<T> containsValue, T t) {
        C14342f0.m8183q(containsValue, "$this$containsValue");
        return containsValue.indexOfValue(t) >= 0;
    }

    @RequiresApi(16)
    public static final <T> void forEach(@NotNull android.util.LongSparseArray<T> forEach, @NotNull InterfaceC15284p<? super Long, ? super T, Unit> action) {
        C14342f0.m8183q(forEach, "$this$forEach");
        C14342f0.m8183q(action, "action");
        int size = forEach.size();
        for (int i = 0; i < size; i++) {
            action.invoke(Long.valueOf(forEach.keyAt(i)), forEach.valueAt(i));
        }
    }

    @RequiresApi(16)
    public static final <T> T getOrDefault(@NotNull android.util.LongSparseArray<T> getOrDefault, long j, T t) {
        C14342f0.m8183q(getOrDefault, "$this$getOrDefault");
        T t2 = getOrDefault.get(j);
        return t2 != null ? t2 : t;
    }

    @RequiresApi(16)
    public static final <T> T getOrElse(@NotNull android.util.LongSparseArray<T> getOrElse, long j, @NotNull InterfaceC15269a<? extends T> defaultValue) {
        C14342f0.m8183q(getOrElse, "$this$getOrElse");
        C14342f0.m8183q(defaultValue, "defaultValue");
        T t = getOrElse.get(j);
        return t != null ? t : defaultValue.invoke();
    }

    @RequiresApi(16)
    public static final <T> int getSize(@NotNull android.util.LongSparseArray<T> size) {
        C14342f0.m8183q(size, "$this$size");
        return size.size();
    }

    @RequiresApi(16)
    public static final <T> boolean isEmpty(@NotNull android.util.LongSparseArray<T> isEmpty) {
        C14342f0.m8183q(isEmpty, "$this$isEmpty");
        return isEmpty.size() == 0;
    }

    @RequiresApi(16)
    public static final <T> boolean isNotEmpty(@NotNull android.util.LongSparseArray<T> isNotEmpty) {
        C14342f0.m8183q(isNotEmpty, "$this$isNotEmpty");
        return isNotEmpty.size() != 0;
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> AbstractC14214r0 keyIterator(@NotNull final android.util.LongSparseArray<T> keyIterator) {
        C14342f0.m8183q(keyIterator, "$this$keyIterator");
        return new AbstractC14214r0() { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
            private int index;

            public final int getIndex() {
                return this.index;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < keyIterator.size();
            }

            @Override // kotlin.collections.AbstractC14214r0
            public long nextLong() {
                LongSparseArray longSparseArray = keyIterator;
                int i = this.index;
                this.index = i + 1;
                return longSparseArray.keyAt(i);
            }

            public final void setIndex(int i) {
                this.index = i;
            }
        };
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> android.util.LongSparseArray<T> plus(@NotNull android.util.LongSparseArray<T> plus, @NotNull android.util.LongSparseArray<T> other) {
        C14342f0.m8183q(plus, "$this$plus");
        C14342f0.m8183q(other, "other");
        android.util.LongSparseArray<T> longSparseArray = new android.util.LongSparseArray<>(plus.size() + other.size());
        putAll(longSparseArray, plus);
        putAll(longSparseArray, other);
        return longSparseArray;
    }

    @RequiresApi(16)
    public static final <T> void putAll(@NotNull android.util.LongSparseArray<T> putAll, @NotNull android.util.LongSparseArray<T> other) {
        C14342f0.m8183q(putAll, "$this$putAll");
        C14342f0.m8183q(other, "other");
        int size = other.size();
        for (int i = 0; i < size; i++) {
            putAll.put(other.keyAt(i), other.valueAt(i));
        }
    }

    @RequiresApi(16)
    public static final <T> boolean remove(@NotNull android.util.LongSparseArray<T> remove, long j, T t) {
        C14342f0.m8183q(remove, "$this$remove");
        int indexOfKey = remove.indexOfKey(j);
        if (indexOfKey < 0 || !C14342f0.m8193g(t, remove.valueAt(indexOfKey))) {
            return false;
        }
        remove.removeAt(indexOfKey);
        return true;
    }

    @RequiresApi(16)
    public static final <T> void set(@NotNull android.util.LongSparseArray<T> set, long j, T t) {
        C14342f0.m8183q(set, "$this$set");
        set.put(j, t);
    }

    @RequiresApi(16)
    @NotNull
    public static final <T> Iterator<T> valueIterator(@NotNull android.util.LongSparseArray<T> valueIterator) {
        C14342f0.m8183q(valueIterator, "$this$valueIterator");
        return new LongSparseArrayKt$valueIterator$1(valueIterator);
    }
}
