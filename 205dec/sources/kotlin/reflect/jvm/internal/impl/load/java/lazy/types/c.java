package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.collections.i1;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.r0;
import kotlin.reflect.jvm.internal.impl.types.s0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaTypeResolver.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @NotNull

    /* renamed from: a */
    private static final kotlin.reflect.jvm.internal.impl.name.c f56950a = new kotlin.reflect.jvm.internal.impl.name.c("java.lang.Class");

    public static final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.c a() {
        return f56950a;
    }

    @NotNull
    public static final a1 b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 typeParameter, @NotNull a attr) {
        f0.p(typeParameter, "typeParameter");
        f0.p(attr, "attr");
        if (attr.e() == TypeUsage.SUPERTYPE) {
            return new c1(s0.b(typeParameter));
        }
        return new r0(typeParameter);
    }

    @NotNull
    public static final a c(@NotNull TypeUsage typeUsage, boolean z3, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var) {
        f0.p(typeUsage, "<this>");
        return new a(typeUsage, null, z3, a1Var == null ? null : i1.f(a1Var), null, 18, null);
    }

    public static /* synthetic */ a d(TypeUsage typeUsage, boolean z3, kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        if ((i4 & 2) != 0) {
            a1Var = null;
        }
        return c(typeUsage, z3, a1Var);
    }
}
