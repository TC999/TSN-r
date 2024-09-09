package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.types.d1;
import org.jetbrains.annotations.NotNull;

/* compiled from: ModuleAwareClassDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class t implements kotlin.reflect.jvm.internal.impl.descriptors.d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f56494a = new a(null);

    /* compiled from: ModuleAwareClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull d1 typeSubstitution, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.f0.p(dVar, "<this>");
            kotlin.jvm.internal.f0.p(typeSubstitution, "typeSubstitution");
            kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            t tVar = dVar instanceof t ? (t) dVar : null;
            if (tVar == null) {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h o02 = dVar.o0(typeSubstitution);
                kotlin.jvm.internal.f0.o(o02, "this.getMemberScope(\n   \u2026ubstitution\n            )");
                return o02;
            }
            return tVar.B(typeSubstitution, kotlinTypeRefiner);
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.resolve.scopes.h b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
            kotlin.jvm.internal.f0.p(dVar, "<this>");
            kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
            t tVar = dVar instanceof t ? (t) dVar : null;
            if (tVar == null) {
                kotlin.reflect.jvm.internal.impl.resolve.scopes.h W = dVar.W();
                kotlin.jvm.internal.f0.o(W, "this.unsubstitutedMemberScope");
                return W;
            }
            return tVar.f0(kotlinTypeRefiner);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.h B(@NotNull d1 d1Var, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public abstract kotlin.reflect.jvm.internal.impl.resolve.scopes.h f0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar);
}
