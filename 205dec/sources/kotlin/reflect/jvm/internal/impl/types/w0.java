package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeAliasExpansionReportStrategy.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface w0 {

    /* compiled from: TypeAliasExpansionReportStrategy.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements w0 {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f58454a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w0
        public void a(@NotNull f1 substitutor, @NotNull e0 unsubstitutedArgument, @NotNull e0 argument, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 typeParameter) {
            kotlin.jvm.internal.f0.p(substitutor, "substitutor");
            kotlin.jvm.internal.f0.p(unsubstitutedArgument, "unsubstitutedArgument");
            kotlin.jvm.internal.f0.p(argument, "argument");
            kotlin.jvm.internal.f0.p(typeParameter, "typeParameter");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w0
        public void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.z0 typeAlias) {
            kotlin.jvm.internal.f0.p(typeAlias, "typeAlias");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w0
        public void c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotation) {
            kotlin.jvm.internal.f0.p(annotation, "annotation");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.w0
        public void d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.z0 typeAlias, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var, @NotNull e0 substitutedArgument) {
            kotlin.jvm.internal.f0.p(typeAlias, "typeAlias");
            kotlin.jvm.internal.f0.p(substitutedArgument, "substitutedArgument");
        }
    }

    void a(@NotNull f1 f1Var, @NotNull e0 e0Var, @NotNull e0 e0Var2, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var);

    void b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var);

    void c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar);

    void d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.z0 z0Var, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var, @NotNull e0 e0Var);
}
