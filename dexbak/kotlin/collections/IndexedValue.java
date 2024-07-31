package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0004\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0005\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00028\u0000HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0017\u0010\u0007\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\b\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0018"}, m12616d2 = {"Lkotlin/collections/n0;", ExifInterface.GPS_DIRECTION_TRUE, "", "", "a", "b", "()Ljava/lang/Object;", "index", DomainCampaignEx.LOOPBACK_VALUE, "c", "(ILjava/lang/Object;)Lkotlin/collections/n0;", "", "toString", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "I", "e", "()I", "Ljava/lang/Object;", "f", "<init>", "(ILjava/lang/Object;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.collections.n0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class IndexedValue<T> {

    /* renamed from: a */
    private final int f40932a;

    /* renamed from: b */
    private final T f40933b;

    public IndexedValue(int i, T t) {
        this.f40932a = i;
        this.f40933b = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static /* synthetic */ IndexedValue m11794d(IndexedValue indexedValue, int i, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            i = indexedValue.f40932a;
        }
        if ((i2 & 2) != 0) {
            obj = indexedValue.f40933b;
        }
        return indexedValue.m11795c(i, obj);
    }

    /* renamed from: a */
    public final int m11797a() {
        return this.f40932a;
    }

    /* renamed from: b */
    public final T m11796b() {
        return this.f40933b;
    }

    @NotNull
    /* renamed from: c */
    public final IndexedValue<T> m11795c(int i, T t) {
        return new IndexedValue<>(i, t);
    }

    /* renamed from: e */
    public final int m11793e() {
        return this.f40932a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof IndexedValue) {
                IndexedValue indexedValue = (IndexedValue) obj;
                return this.f40932a == indexedValue.f40932a && C14342f0.m8193g(this.f40933b, indexedValue.f40933b);
            }
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final T m11792f() {
        return this.f40933b;
    }

    public int hashCode() {
        int i = this.f40932a * 31;
        T t = this.f40933b;
        return i + (t != null ? t.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "IndexedValue(index=" + this.f40932a + ", value=" + this.f40933b + ")";
    }
}
