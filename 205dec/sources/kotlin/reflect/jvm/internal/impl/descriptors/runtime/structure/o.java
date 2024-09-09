package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReflectJavaConstructor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o extends t implements m2.k {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Constructor<?> f56612a;

    public o(@NotNull Constructor<?> member) {
        f0.p(member, "member");
        this.f56612a = member;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.t
    @NotNull
    /* renamed from: U */
    public Constructor<?> S() {
        return this.f56612a;
    }

    @Override // m2.z
    @NotNull
    public List<a0> getTypeParameters() {
        TypeVariable<Constructor<?>>[] typeParameters = S().getTypeParameters();
        f0.o(typeParameters, "member.typeParameters");
        ArrayList arrayList = new ArrayList(typeParameters.length);
        int length = typeParameters.length;
        int i4 = 0;
        while (i4 < length) {
            TypeVariable<Constructor<?>> typeVariable = typeParameters[i4];
            i4++;
            arrayList.add(new a0(typeVariable));
        }
        return arrayList;
    }

    @Override // m2.k
    @NotNull
    public List<m2.b0> h() {
        Object[] M1;
        Object[] M12;
        List<m2.b0> F;
        Type[] realTypes = S().getGenericParameterTypes();
        f0.o(realTypes, "types");
        if (realTypes.length == 0) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        Class<?> declaringClass = S().getDeclaringClass();
        if (declaringClass.getDeclaringClass() != null && !Modifier.isStatic(declaringClass.getModifiers())) {
            M12 = kotlin.collections.o.M1(realTypes, 1, realTypes.length);
            realTypes = (Type[]) M12;
        }
        Annotation[][] realAnnotations = S().getParameterAnnotations();
        if (realAnnotations.length >= realTypes.length) {
            if (realAnnotations.length > realTypes.length) {
                f0.o(realAnnotations, "annotations");
                M1 = kotlin.collections.o.M1(realAnnotations, realAnnotations.length - realTypes.length, realAnnotations.length);
                realAnnotations = (Annotation[][]) M1;
            }
            f0.o(realTypes, "realTypes");
            f0.o(realAnnotations, "realAnnotations");
            return T(realTypes, realAnnotations, S().isVarArgs());
        }
        throw new IllegalStateException(f0.C("Illegal generic signature: ", S()));
    }
}
