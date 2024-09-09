package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.h0;
import kotlin.reflect.jvm.internal.impl.descriptors.j0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedClassDataFinder.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m implements f {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final h0 f58149a;

    public m(@NotNull h0 packageFragmentProvider) {
        f0.p(packageFragmentProvider, "packageFragmentProvider");
        this.f58149a = packageFragmentProvider;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.f
    @Nullable
    public e a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        e a4;
        f0.p(classId, "classId");
        h0 h0Var = this.f58149a;
        kotlin.reflect.jvm.internal.impl.name.c h4 = classId.h();
        f0.o(h4, "classId.packageFqName");
        for (g0 g0Var : j0.c(h0Var, h4)) {
            if ((g0Var instanceof n) && (a4 = ((n) g0Var).C0().a(classId)) != null) {
                return a4;
            }
        }
        return null;
    }
}
