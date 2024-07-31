package p644t;

import androidx.exifinterface.media.ExifInterface;
import com.bxkj.base.p085v2.http.exception.ApiException;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0000HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J:\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00018\u0000HÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0010\u001a\u00020\tHÖ\u0001J\t\u0010\u0011\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0019\u0010\f\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, m12616d2 = {"Lt/a;", ExifInterface.GPS_DIRECTION_TRUE, "", "d", "()Ljava/lang/Object;", "a", "", "b", "()Ljava/lang/Integer;", "", "c", "code", "message", "data", "e", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)Lt/a;", "toString", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "Ljava/lang/Integer;", "g", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: t.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class PgyerApiResult<T> {
    @Nullable

    /* renamed from: a */
    private final Integer f47097a;
    @Nullable

    /* renamed from: b */
    private final String f47098b;
    @Nullable

    /* renamed from: c */
    private final T f47099c;

    public PgyerApiResult(@Nullable Integer num, @Nullable String str, @Nullable T t) {
        this.f47097a = num;
        this.f47098b = str;
        this.f47099c = t;
    }

    /* renamed from: d */
    private final T m313d() {
        return this.f47099c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    public static /* synthetic */ PgyerApiResult m311f(PgyerApiResult pgyerApiResult, Integer num, String str, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            num = pgyerApiResult.f47097a;
        }
        if ((i & 2) != 0) {
            str = pgyerApiResult.f47098b;
        }
        if ((i & 4) != 0) {
            obj = pgyerApiResult.f47099c;
        }
        return pgyerApiResult.m312e(num, str, obj);
    }

    @Nullable
    /* renamed from: a */
    public final T m316a() {
        Integer num = this.f47097a;
        if (num != null && num.intValue() == 0) {
            return this.f47099c;
        }
        throw new ApiException(this.f47097a, this.f47098b);
    }

    @Nullable
    /* renamed from: b */
    public final Integer m315b() {
        return this.f47097a;
    }

    @Nullable
    /* renamed from: c */
    public final String m314c() {
        return this.f47098b;
    }

    @NotNull
    /* renamed from: e */
    public final PgyerApiResult<T> m312e(@Nullable Integer num, @Nullable String str, @Nullable T t) {
        return new PgyerApiResult<>(num, str, t);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PgyerApiResult) {
            PgyerApiResult pgyerApiResult = (PgyerApiResult) obj;
            return C14342f0.m8193g(this.f47097a, pgyerApiResult.f47097a) && C14342f0.m8193g(this.f47098b, pgyerApiResult.f47098b) && C14342f0.m8193g(this.f47099c, pgyerApiResult.f47099c);
        }
        return false;
    }

    @Nullable
    /* renamed from: g */
    public final Integer m310g() {
        return this.f47097a;
    }

    @Nullable
    /* renamed from: h */
    public final String m309h() {
        return this.f47098b;
    }

    public int hashCode() {
        Integer num = this.f47097a;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f47098b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t = this.f47099c;
        return hashCode2 + (t != null ? t.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PgyerApiResult(code=" + this.f47097a + ", message=" + ((Object) this.f47098b) + ", data=" + this.f47099c + ')';
    }
}
