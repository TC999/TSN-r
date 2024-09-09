package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.Collection;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KotlinTypeRefiner.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class g extends kotlin.reflect.jvm.internal.impl.types.i {

    /* compiled from: KotlinTypeRefiner.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends g {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f58278a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
            f0.p(classId, "classId");
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        @NotNull
        public <S extends kotlin.reflect.jvm.internal.impl.resolve.scopes.h> S c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @NotNull d2.a<? extends S> compute) {
            f0.p(classDescriptor, "classDescriptor");
            f0.p(compute, "compute");
            return compute.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public boolean d(@NotNull d0 moduleDescriptor) {
            f0.p(moduleDescriptor, "moduleDescriptor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        public boolean e(@NotNull y0 typeConstructor) {
            f0.p(typeConstructor, "typeConstructor");
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        @NotNull
        public Collection<e0> g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            f0.p(classDescriptor, "classDescriptor");
            Collection<e0> j4 = classDescriptor.j().j();
            f0.o(j4, "classDescriptor.typeConstructor.supertypes");
            return j4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.i
        @NotNull
        /* renamed from: h */
        public e0 a(@NotNull r2.g type) {
            f0.p(type, "type");
            return (e0) type;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.g
        @Nullable
        /* renamed from: i */
        public kotlin.reflect.jvm.internal.impl.descriptors.d f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k descriptor) {
            f0.p(descriptor, "descriptor");
            return null;
        }
    }

    @Nullable
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.d b(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar);

    @NotNull
    public abstract <S extends kotlin.reflect.jvm.internal.impl.resolve.scopes.h> S c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull d2.a<? extends S> aVar);

    public abstract boolean d(@NotNull d0 d0Var);

    public abstract boolean e(@NotNull y0 y0Var);

    @Nullable
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.f f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar);

    @NotNull
    public abstract Collection<e0> g(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @NotNull
    public abstract e0 h(@NotNull r2.g gVar);
}
