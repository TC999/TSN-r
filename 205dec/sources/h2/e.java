package h2;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformDependentTypeTransformer.kt */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface e {

    /* compiled from: PlatformDependentTypeTransformer.kt */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class a implements e {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f54738a = new a();

        private a() {
        }

        @Override // h2.e
        @NotNull
        public m0 a(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull m0 computedType) {
            f0.p(classId, "classId");
            f0.p(computedType, "computedType");
            return computedType;
        }
    }

    @NotNull
    m0 a(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull m0 m0Var);
}
