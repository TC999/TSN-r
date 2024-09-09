package t;

import com.bxkj.base.v2.http.exception.ApiException;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: PgyerApiResult.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00018\u0000H\u00c2\u0003\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\n\u001a\u0004\u0018\u00010\tH\u00c6\u0003J:\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00018\u0000H\u00c6\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0010\u001a\u00020\tH\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\u0016\u0010\bR\u0019\u0010\f\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lt/a;", "T", "", "d", "()Ljava/lang/Object;", "a", "", "b", "()Ljava/lang/Integer;", "", "c", "code", "message", "data", "e", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)Lt/a;", "toString", "hashCode", "other", "", "equals", "Ljava/lang/Integer;", "g", "Ljava/lang/String;", "h", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Object;)V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class a<T> {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Integer f64372a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final String f64373b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final T f64374c;

    public a(@Nullable Integer num, @Nullable String str, @Nullable T t3) {
        this.f64372a = num;
        this.f64373b = str;
        this.f64374c = t3;
    }

    private final T d() {
        return this.f64374c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a f(a aVar, Integer num, String str, Object obj, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            num = aVar.f64372a;
        }
        if ((i4 & 2) != 0) {
            str = aVar.f64373b;
        }
        if ((i4 & 4) != 0) {
            obj = aVar.f64374c;
        }
        return aVar.e(num, str, obj);
    }

    @Nullable
    public final T a() {
        Integer num = this.f64372a;
        if (num != null && num.intValue() == 0) {
            return this.f64374c;
        }
        throw new ApiException(this.f64372a, this.f64373b);
    }

    @Nullable
    public final Integer b() {
        return this.f64372a;
    }

    @Nullable
    public final String c() {
        return this.f64373b;
    }

    @NotNull
    public final a<T> e(@Nullable Integer num, @Nullable String str, @Nullable T t3) {
        return new a<>(num, str, t3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f0.g(this.f64372a, aVar.f64372a) && f0.g(this.f64373b, aVar.f64373b) && f0.g(this.f64374c, aVar.f64374c);
        }
        return false;
    }

    @Nullable
    public final Integer g() {
        return this.f64372a;
    }

    @Nullable
    public final String h() {
        return this.f64373b;
    }

    public int hashCode() {
        Integer num = this.f64372a;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.f64373b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        T t3 = this.f64374c;
        return hashCode2 + (t3 != null ? t3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "PgyerApiResult(code=" + this.f64372a + ", message=" + ((Object) this.f64373b) + ", data=" + this.f64374c + ')';
    }
}
