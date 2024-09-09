package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: IncompatibleVersionErrorData.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f58161a;

    /* renamed from: b  reason: collision with root package name */
    private final T f58162b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f58163c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.b f58164d;

    public r(T t3, T t4, @NotNull String filePath, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        f0.p(filePath, "filePath");
        f0.p(classId, "classId");
        this.f58161a = t3;
        this.f58162b = t4;
        this.f58163c = filePath;
        this.f58164d = classId;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            return f0.g(this.f58161a, rVar.f58161a) && f0.g(this.f58162b, rVar.f58162b) && f0.g(this.f58163c, rVar.f58163c) && f0.g(this.f58164d, rVar.f58164d);
        }
        return false;
    }

    public int hashCode() {
        T t3 = this.f58161a;
        int hashCode = (t3 == null ? 0 : t3.hashCode()) * 31;
        T t4 = this.f58162b;
        return ((((hashCode + (t4 != null ? t4.hashCode() : 0)) * 31) + this.f58163c.hashCode()) * 31) + this.f58164d.hashCode();
    }

    @NotNull
    public String toString() {
        return "IncompatibleVersionErrorData(actualVersion=" + this.f58161a + ", expectedVersion=" + this.f58162b + ", filePath=" + this.f58163c + ", classId=" + this.f58164d + ')';
    }
}
