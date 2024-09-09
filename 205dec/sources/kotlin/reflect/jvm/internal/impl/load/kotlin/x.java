package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: descriptorBasedTypeSignatureMapping.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface x<T> {

    /* compiled from: descriptorBasedTypeSignatureMapping.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @Nullable
        public static <T> String a(@NotNull x<? extends T> xVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d classDescriptor) {
            f0.p(xVar, "this");
            f0.p(classDescriptor, "classDescriptor");
            return null;
        }

        @Nullable
        public static <T> e0 b(@NotNull x<? extends T> xVar, @NotNull e0 kotlinType) {
            f0.p(xVar, "this");
            f0.p(kotlinType, "kotlinType");
            return null;
        }
    }

    @Nullable
    T a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @Nullable
    String b(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @Nullable
    String c(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @Nullable
    e0 d(@NotNull e0 e0Var);

    void e(@NotNull e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar);

    @NotNull
    e0 f(@NotNull Collection<e0> collection);
}
