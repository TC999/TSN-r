package h2;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformDependentDeclarationFilter.kt */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public interface c {

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class a implements c {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f54735a = new a();

        private a() {
        }

        @Override // h2.c
        public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @NotNull u0 functionDescriptor) {
            f0.p(classDescriptor, "classDescriptor");
            f0.p(functionDescriptor, "functionDescriptor");
            return true;
        }
    }

    /* compiled from: PlatformDependentDeclarationFilter.kt */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class b implements c {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final b f54736a = new b();

        private b() {
        }

        @Override // h2.c
        public boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor, @NotNull u0 functionDescriptor) {
            f0.p(classDescriptor, "classDescriptor");
            f0.p(functionDescriptor, "functionDescriptor");
            return !functionDescriptor.getAnnotations().i(d.a());
        }
    }

    boolean b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull u0 u0Var);
}
