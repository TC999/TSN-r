package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AnnotationDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface c {

    /* compiled from: AnnotationDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @Nullable
        public static kotlin.reflect.jvm.internal.impl.name.c a(@NotNull c cVar) {
            f0.p(cVar, "this");
            kotlin.reflect.jvm.internal.impl.descriptors.d f4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(cVar);
            if (f4 == null) {
                return null;
            }
            if (w.r(f4)) {
                f4 = null;
            }
            if (f4 == null) {
                return null;
            }
            return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(f4);
        }
    }

    @NotNull
    Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a();

    @Nullable
    kotlin.reflect.jvm.internal.impl.name.c e();

    @NotNull
    v0 getSource();

    @NotNull
    e0 getType();
}
