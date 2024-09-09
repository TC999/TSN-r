package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: constantValues.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j extends g<Pair<? extends kotlin.reflect.jvm.internal.impl.name.b, ? extends kotlin.reflect.jvm.internal.impl.name.f>> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.b f57834b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.f f57835c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull kotlin.reflect.jvm.internal.impl.name.b enumClassId, @NotNull kotlin.reflect.jvm.internal.impl.name.f enumEntryName) {
        super(l0.a(enumClassId, enumEntryName));
        f0.p(enumClassId, "enumClassId");
        f0.p(enumEntryName, "enumEntryName");
        this.f57834b = enumClassId;
        this.f57835c = enumEntryName;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.f b() {
        return this.f57835c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public e0 getType(@NotNull d0 module) {
        f0.p(module, "module");
        kotlin.reflect.jvm.internal.impl.descriptors.d a4 = kotlin.reflect.jvm.internal.impl.descriptors.v.a(module, this.f57834b);
        if (a4 == null || !kotlin.reflect.jvm.internal.impl.resolve.d.A(a4)) {
            a4 = null;
        }
        if (a4 == null) {
            m0 j4 = kotlin.reflect.jvm.internal.impl.types.w.j("Containing class for error-class based enum entry " + this.f57834b + '.' + this.f57835c);
            f0.o(j4, "createErrorType(\"Contain\u2026mClassId.$enumEntryName\")");
            return j4;
        }
        m0 q3 = a4.q();
        f0.o(q3, "module.findClassAcrossMo\u2026mClassId.$enumEntryName\")");
        return q3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.constants.g
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f57834b.j());
        sb.append('.');
        sb.append(this.f57835c);
        return sb.toString();
    }
}
