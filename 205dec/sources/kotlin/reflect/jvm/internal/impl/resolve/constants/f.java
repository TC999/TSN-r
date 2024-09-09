package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassLiteralValue.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.b f57828a;

    /* renamed from: b  reason: collision with root package name */
    private final int f57829b;

    public f(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, int i4) {
        f0.p(classId, "classId");
        this.f57828a = classId;
        this.f57829b = i4;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b a() {
        return this.f57828a;
    }

    public final int b() {
        return this.f57829b;
    }

    public final int c() {
        return this.f57829b;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.b d() {
        return this.f57828a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return f0.g(this.f57828a, fVar.f57828a) && this.f57829b == fVar.f57829b;
        }
        return false;
    }

    public int hashCode() {
        return (this.f57828a.hashCode() * 31) + this.f57829b;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int c4 = c();
        int i4 = 0;
        int i5 = 0;
        while (i5 < c4) {
            i5++;
            sb.append("kotlin/Array<");
        }
        sb.append(d());
        int c5 = c();
        while (i4 < c5) {
            i4++;
            sb.append(">");
        }
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
