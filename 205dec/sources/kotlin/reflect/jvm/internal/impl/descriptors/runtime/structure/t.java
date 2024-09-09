package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaMember.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class t extends p implements h, v, m2.q {
    @Override // m2.d
    public boolean B() {
        return h.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.v
    public int F() {
        return S().getModifiers();
    }

    @Override // m2.s
    public boolean O() {
        return v.a.d(this);
    }

    @Override // m2.d
    @Nullable
    /* renamed from: P */
    public e b(@NotNull kotlin.reflect.jvm.internal.impl.name.c cVar) {
        return h.a.a(this, cVar);
    }

    @Override // m2.d
    @NotNull
    /* renamed from: Q */
    public List<e> getAnnotations() {
        return h.a.b(this);
    }

    @Override // m2.q
    @NotNull
    /* renamed from: R */
    public l N() {
        Class<?> declaringClass = S().getDeclaringClass();
        f0.o(declaringClass, "member.declaringClass");
        return new l(declaringClass);
    }

    @NotNull
    public abstract Member S();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final List<m2.b0> T(@NotNull Type[] parameterTypes, @NotNull Annotation[][] parameterAnnotations, boolean z3) {
        Object H2;
        String str;
        boolean z4;
        int Td;
        f0.p(parameterTypes, "parameterTypes");
        f0.p(parameterAnnotations, "parameterAnnotations");
        ArrayList arrayList = new ArrayList(parameterTypes.length);
        List<String> c4 = c.f56578a.c(S());
        int size = c4 == null ? 0 : c4.size() - parameterTypes.length;
        int length = parameterTypes.length;
        int i4 = 0;
        while (i4 < length) {
            int i5 = i4 + 1;
            z a4 = z.f56622a.a(parameterTypes[i4]);
            if (c4 == null) {
                str = null;
            } else {
                H2 = kotlin.collections.f0.H2(c4, i4 + size);
                str = (String) H2;
                if (str == null) {
                    throw new IllegalStateException(("No parameter with index " + i4 + '+' + size + " (name=" + getName() + " type=" + a4 + ") in " + this).toString());
                }
            }
            if (z3) {
                Td = kotlin.collections.p.Td(parameterTypes);
                if (i4 == Td) {
                    z4 = true;
                    arrayList.add(new b0(a4, parameterAnnotations[i4], str, z4));
                    i4 = i5;
                }
            }
            z4 = false;
            arrayList.add(new b0(a4, parameterAnnotations[i4], str, z4));
            i4 = i5;
        }
        return arrayList;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof t) && f0.g(S(), ((t) obj).S());
    }

    @Override // m2.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        String name = S().getName();
        if (name == null) {
            return kotlin.reflect.jvm.internal.impl.name.h.f57578b;
        }
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(name);
        f0.o(f4, "member.name?.let { Name.\u2026ialNames.NO_NAME_PROVIDED");
        return f4;
    }

    @Override // m2.s
    @NotNull
    public i1 getVisibility() {
        return v.a.a(this);
    }

    public int hashCode() {
        return S().hashCode();
    }

    @Override // m2.s
    public boolean isAbstract() {
        return v.a.b(this);
    }

    @Override // m2.s
    public boolean isFinal() {
        return v.a.c(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.h
    @NotNull
    public AnnotatedElement r() {
        return (AnnotatedElement) S();
    }

    @NotNull
    public String toString() {
        return getClass().getName() + ": " + S();
    }
}
