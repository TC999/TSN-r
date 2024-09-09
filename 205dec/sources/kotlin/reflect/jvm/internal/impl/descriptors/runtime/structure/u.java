package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.z;
import m2.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaMethod.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u extends t implements m2.r {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Method f56616a;

    public u(@NotNull Method member) {
        f0.p(member, "member");
        this.f56616a = member;
    }

    @Override // m2.r
    public boolean K() {
        return r.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.t
    @NotNull
    /* renamed from: U */
    public Method S() {
        return this.f56616a;
    }

    @Override // m2.r
    @NotNull
    /* renamed from: V */
    public z getReturnType() {
        z.a aVar = z.f56622a;
        Type genericReturnType = S().getGenericReturnType();
        f0.o(genericReturnType, "member.genericReturnType");
        return aVar.a(genericReturnType);
    }

    @Override // m2.z
    @NotNull
    public List<a0> getTypeParameters() {
        TypeVariable<Method>[] typeParameters = S().getTypeParameters();
        f0.o(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        int length = typeParameters.length;
        int i4 = 0;
        while (i4 < length) {
            TypeVariable<Method> typeVariable = typeParameters[i4];
            i4++;
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    @Override // m2.r
    @NotNull
    public List<m2.b0> h() {
        Type[] genericParameterTypes = S().getGenericParameterTypes();
        f0.o(genericParameterTypes, "member.genericParameterTypes");
        Annotation[][] parameterAnnotations = S().getParameterAnnotations();
        f0.o(parameterAnnotations, "member.parameterAnnotations");
        return T(genericParameterTypes, parameterAnnotations, S().isVarArgs());
    }

    @Override // m2.r
    @Nullable
    public m2.b n() {
        Object defaultValue = S().getDefaultValue();
        if (defaultValue == null) {
            return null;
        }
        return f.f56592b.a(defaultValue, null);
    }
}
