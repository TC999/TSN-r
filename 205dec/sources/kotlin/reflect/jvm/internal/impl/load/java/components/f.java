package kotlin.reflect.jvm.internal.impl.load.java.components;

import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import m2.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaPropertyInitializerEvaluator.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface f {

    /* compiled from: JavaPropertyInitializerEvaluator.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements f {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f56701a = new a();

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.components.f
        @Nullable
        public kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> a(@NotNull n field, @NotNull p0 descriptor) {
            f0.p(field, "field");
            f0.p(descriptor, "descriptor");
            return null;
        }
    }

    @Nullable
    kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> a(@NotNull n nVar, @NotNull p0 p0Var);
}
