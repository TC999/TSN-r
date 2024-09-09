package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.util.Set;
import kotlin.collections.j1;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReflectKotlinClass.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final Set<Class<?>> f56555a;

    static {
        Set<Class<?>> u3;
        u3 = j1.u(Integer.class, Character.class, Byte.class, Long.class, Short.class, Boolean.class, Double.class, Float.class, int[].class, char[].class, byte[].class, long[].class, short[].class, boolean[].class, double[].class, float[].class, Class.class, String.class);
        f56555a = u3;
    }
}
