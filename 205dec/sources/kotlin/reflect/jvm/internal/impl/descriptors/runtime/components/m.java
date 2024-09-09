package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReflectKotlinClass.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class m {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final m f56562a = new m();

    private m() {
    }

    @NotNull
    public final String a(@NotNull Constructor<?> constructor) {
        f0.p(constructor, "constructor");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        f0.o(parameterTypes, "constructor.parameterTypes");
        int length = parameterTypes.length;
        int i4 = 0;
        while (i4 < length) {
            Class<?> parameterType = parameterTypes[i4];
            i4++;
            f0.o(parameterType, "parameterType");
            sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(parameterType));
        }
        sb.append(")V");
        String sb2 = sb.toString();
        f0.o(sb2, "sb.toString()");
        return sb2;
    }

    @NotNull
    public final String b(@NotNull Field field) {
        f0.p(field, "field");
        Class<?> type = field.getType();
        f0.o(type, "field.type");
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(type);
    }

    @NotNull
    public final String c(@NotNull Method method) {
        f0.p(method, "method");
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        f0.o(parameterTypes, "method.parameterTypes");
        int length = parameterTypes.length;
        int i4 = 0;
        while (i4 < length) {
            Class<?> parameterType = parameterTypes[i4];
            i4++;
            f0.o(parameterType, "parameterType");
            sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(parameterType));
        }
        sb.append(")");
        Class<?> returnType = method.getReturnType();
        f0.o(returnType, "method.returnType");
        sb.append(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(returnType));
        String sb2 = sb.toString();
        f0.o(sb2, "sb.toString()");
        return sb2;
    }
}
