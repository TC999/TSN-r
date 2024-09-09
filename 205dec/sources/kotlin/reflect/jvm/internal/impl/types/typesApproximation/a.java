package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CapturedTypeApproximation.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f58420a;

    /* renamed from: b  reason: collision with root package name */
    private final T f58421b;

    public a(T t3, T t4) {
        this.f58420a = t3;
        this.f58421b = t4;
    }

    public final T a() {
        return this.f58420a;
    }

    public final T b() {
        return this.f58421b;
    }

    public final T c() {
        return this.f58420a;
    }

    public final T d() {
        return this.f58421b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f0.g(this.f58420a, aVar.f58420a) && f0.g(this.f58421b, aVar.f58421b);
        }
        return false;
    }

    public int hashCode() {
        T t3 = this.f58420a;
        int hashCode = (t3 == null ? 0 : t3.hashCode()) * 31;
        T t4 = this.f58421b;
        return hashCode + (t4 != null ? t4.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ApproximationBounds(lower=" + this.f58420a + ", upper=" + this.f58421b + ')';
    }
}
