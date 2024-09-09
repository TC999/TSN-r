package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Set;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReflectKotlinClass.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f56548a = new c();

    private c() {
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.f a(Class<?> cls) {
        int i4 = 0;
        while (cls.isArray()) {
            i4++;
            cls = cls.getComponentType();
            f0.o(cls, "currentClass.componentType");
        }
        if (cls.isPrimitive()) {
            if (f0.g(cls, Void.TYPE)) {
                kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.f56101f.l());
                f0.o(m4, "topLevel(StandardNames.FqNames.unit.toSafe())");
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.f(m4, i4);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            f0.o(primitiveType, "get(currentClass.name).primitiveType");
            if (i4 > 0) {
                kotlin.reflect.jvm.internal.impl.name.b m5 = kotlin.reflect.jvm.internal.impl.name.b.m(primitiveType.getArrayTypeFqName());
                f0.o(m5, "topLevel(primitiveType.arrayTypeFqName)");
                return new kotlin.reflect.jvm.internal.impl.resolve.constants.f(m5, i4 - 1);
            }
            kotlin.reflect.jvm.internal.impl.name.b m6 = kotlin.reflect.jvm.internal.impl.name.b.m(primitiveType.getTypeFqName());
            f0.o(m6, "topLevel(primitiveType.typeFqName)");
            return new kotlin.reflect.jvm.internal.impl.resolve.constants.f(m6, i4);
        }
        kotlin.reflect.jvm.internal.impl.name.b a4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(cls);
        kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f56159a;
        kotlin.reflect.jvm.internal.impl.name.c b4 = a4.b();
        f0.o(b4, "javaClassId.asSingleFqName()");
        kotlin.reflect.jvm.internal.impl.name.b n4 = cVar.n(b4);
        if (n4 != null) {
            a4 = n4;
        }
        return new kotlin.reflect.jvm.internal.impl.resolve.constants.f(a4, i4);
    }

    private final void c(Class<?> cls, p.d dVar) {
        Constructor<?>[] constructorArr;
        int i4;
        int i5;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        f0.o(declaredConstructors, "klass.declaredConstructors");
        int length = declaredConstructors.length;
        int i6 = 0;
        while (i6 < length) {
            Constructor<?> constructor = declaredConstructors[i6];
            int i7 = i6 + 1;
            kotlin.reflect.jvm.internal.impl.name.f fVar = kotlin.reflect.jvm.internal.impl.name.h.f57585i;
            m mVar = m.f56562a;
            f0.o(constructor, "constructor");
            p.e b4 = dVar.b(fVar, mVar.a(constructor));
            if (b4 == null) {
                constructorArr = declaredConstructors;
                i4 = length;
                i5 = i7;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                f0.o(declaredAnnotations, "constructor.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i8 = 0;
                while (i8 < length2) {
                    Annotation annotation = declaredAnnotations[i8];
                    i8++;
                    f0.o(annotation, "annotation");
                    f(b4, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                f0.o(parameterAnnotations, "parameterAnnotations");
                if (!(parameterAnnotations.length == 0)) {
                    int length3 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length4 = parameterAnnotations.length;
                    int i9 = 0;
                    while (i9 < length4) {
                        Annotation[] annotations = parameterAnnotations[i9];
                        int i10 = i9 + 1;
                        f0.o(annotations, "annotations");
                        int length5 = annotations.length;
                        int i11 = 0;
                        while (i11 < length5) {
                            Annotation annotation2 = annotations[i11];
                            i11++;
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            Class<?> c4 = c2.a.c(c2.a.a(annotation2));
                            int i12 = length;
                            int i13 = i7;
                            kotlin.reflect.jvm.internal.impl.name.b a4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(c4);
                            int i14 = length3;
                            f0.o(annotation2, "annotation");
                            p.a a5 = b4.a(i9 + length3, a4, new b(annotation2));
                            if (a5 != null) {
                                f56548a.h(a5, annotation2, c4);
                            }
                            length = i12;
                            declaredConstructors = constructorArr2;
                            i7 = i13;
                            length3 = i14;
                        }
                        i9 = i10;
                    }
                }
                constructorArr = declaredConstructors;
                i4 = length;
                i5 = i7;
                b4.visitEnd();
            }
            length = i4;
            declaredConstructors = constructorArr;
            i6 = i5;
        }
    }

    private final void d(Class<?> cls, p.d dVar) {
        Field[] declaredFields = cls.getDeclaredFields();
        f0.o(declaredFields, "klass.declaredFields");
        int length = declaredFields.length;
        int i4 = 0;
        while (i4 < length) {
            Field field = declaredFields[i4];
            i4++;
            kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(field.getName());
            f0.o(f4, "identifier(field.name)");
            m mVar = m.f56562a;
            f0.o(field, "field");
            p.c a4 = dVar.a(f4, mVar.b(field), null);
            if (a4 != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                f0.o(declaredAnnotations, "field.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i5 = 0;
                while (i5 < length2) {
                    Annotation annotation = declaredAnnotations[i5];
                    i5++;
                    f0.o(annotation, "annotation");
                    f(a4, annotation);
                }
                a4.visitEnd();
            }
        }
    }

    private final void e(Class<?> cls, p.d dVar) {
        Method[] methodArr;
        int i4;
        Method[] declaredMethods = cls.getDeclaredMethods();
        f0.o(declaredMethods, "klass.declaredMethods");
        int length = declaredMethods.length;
        int i5 = 0;
        while (i5 < length) {
            Method method = declaredMethods[i5];
            i5++;
            kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(method.getName());
            f0.o(f4, "identifier(method.name)");
            m mVar = m.f56562a;
            f0.o(method, "method");
            p.e b4 = dVar.b(f4, mVar.c(method));
            if (b4 == null) {
                methodArr = declaredMethods;
                i4 = length;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                f0.o(declaredAnnotations, "method.declaredAnnotations");
                int length2 = declaredAnnotations.length;
                int i6 = 0;
                while (i6 < length2) {
                    Annotation annotation = declaredAnnotations[i6];
                    i6++;
                    f0.o(annotation, "annotation");
                    f(b4, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                f0.o(parameterAnnotations, "method.parameterAnnotations");
                int length3 = parameterAnnotations.length;
                int i7 = 0;
                while (i7 < length3) {
                    Annotation[] annotations = parameterAnnotations[i7];
                    int i8 = i7 + 1;
                    f0.o(annotations, "annotations");
                    int length4 = annotations.length;
                    int i9 = 0;
                    while (i9 < length4) {
                        Annotation annotation2 = annotations[i9];
                        i9++;
                        Class<?> c4 = c2.a.c(c2.a.a(annotation2));
                        Method[] methodArr2 = declaredMethods;
                        kotlin.reflect.jvm.internal.impl.name.b a4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(c4);
                        int i10 = length;
                        f0.o(annotation2, "annotation");
                        p.a a5 = b4.a(i7, a4, new b(annotation2));
                        if (a5 != null) {
                            f56548a.h(a5, annotation2, c4);
                        }
                        declaredMethods = methodArr2;
                        length = i10;
                    }
                    i7 = i8;
                }
                methodArr = declaredMethods;
                i4 = length;
                b4.visitEnd();
            }
            declaredMethods = methodArr;
            length = i4;
        }
    }

    private final void f(p.c cVar, Annotation annotation) {
        Class<?> c4 = c2.a.c(c2.a.a(annotation));
        p.a b4 = cVar.b(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(c4), new b(annotation));
        if (b4 == null) {
            return;
        }
        f56548a.h(b4, annotation, c4);
    }

    private final void g(p.a aVar, kotlin.reflect.jvm.internal.impl.name.f fVar, Object obj) {
        Set set;
        Object Cs;
        Class<?> cls = obj.getClass();
        if (f0.g(cls, Class.class)) {
            aVar.c(fVar, a((Class) obj));
            return;
        }
        set = i.f56555a;
        if (set.contains(cls)) {
            aVar.d(fVar, obj);
        } else if (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.h(cls)) {
            if (!cls.isEnum()) {
                cls = cls.getEnclosingClass();
            }
            f0.o(cls, "if (clazz.isEnum) clazz else clazz.enclosingClass");
            kotlin.reflect.jvm.internal.impl.name.b a4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(cls);
            kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(((Enum) obj).name());
            f0.o(f4, "identifier((value as Enum<*>).name)");
            aVar.a(fVar, a4, f4);
        } else if (Annotation.class.isAssignableFrom(cls)) {
            Class<?>[] interfaces = cls.getInterfaces();
            f0.o(interfaces, "clazz.interfaces");
            Cs = kotlin.collections.p.Cs(interfaces);
            Class<?> annotationClass = (Class) Cs;
            f0.o(annotationClass, "annotationClass");
            p.a b4 = aVar.b(fVar, kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(annotationClass));
            if (b4 == null) {
                return;
            }
            h(b4, (Annotation) obj, annotationClass);
        } else if (cls.isArray()) {
            p.b e4 = aVar.e(fVar);
            if (e4 == null) {
                return;
            }
            Class<?> componentType = cls.getComponentType();
            int i4 = 0;
            if (componentType.isEnum()) {
                f0.o(componentType, "componentType");
                kotlin.reflect.jvm.internal.impl.name.b a5 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(componentType);
                Object[] objArr = (Object[]) obj;
                int length = objArr.length;
                while (i4 < length) {
                    Object obj2 = objArr[i4];
                    i4++;
                    if (obj2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Enum<*>");
                    }
                    kotlin.reflect.jvm.internal.impl.name.f f5 = kotlin.reflect.jvm.internal.impl.name.f.f(((Enum) obj2).name());
                    f0.o(f5, "identifier((element as Enum<*>).name)");
                    e4.c(a5, f5);
                }
            } else if (f0.g(componentType, Class.class)) {
                Object[] objArr2 = (Object[]) obj;
                int length2 = objArr2.length;
                while (i4 < length2) {
                    Object obj3 = objArr2[i4];
                    i4++;
                    if (obj3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
                    }
                    e4.d(a((Class) obj3));
                }
            } else if (Annotation.class.isAssignableFrom(componentType)) {
                Object[] objArr3 = (Object[]) obj;
                int length3 = objArr3.length;
                while (i4 < length3) {
                    Object obj4 = objArr3[i4];
                    i4++;
                    f0.o(componentType, "componentType");
                    p.a a6 = e4.a(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.a(componentType));
                    if (a6 != null) {
                        if (obj4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Annotation");
                        }
                        h(a6, (Annotation) obj4, componentType);
                    }
                }
            } else {
                Object[] objArr4 = (Object[]) obj;
                int length4 = objArr4.length;
                while (i4 < length4) {
                    Object obj5 = objArr4[i4];
                    i4++;
                    e4.b(obj5);
                }
            }
            e4.visitEnd();
        } else {
            throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
        }
    }

    private final void h(p.a aVar, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        f0.o(declaredMethods, "annotationType.declaredMethods");
        int length = declaredMethods.length;
        int i4 = 0;
        while (i4 < length) {
            Method method = declaredMethods[i4];
            i4++;
            try {
                Object invoke = method.invoke(annotation, new Object[0]);
                f0.m(invoke);
                kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(method.getName());
                f0.o(f4, "identifier(method.name)");
                g(aVar, f4, invoke);
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.visitEnd();
    }

    public final void b(@NotNull Class<?> klass, @NotNull p.c visitor) {
        f0.p(klass, "klass");
        f0.p(visitor, "visitor");
        Annotation[] declaredAnnotations = klass.getDeclaredAnnotations();
        f0.o(declaredAnnotations, "klass.declaredAnnotations");
        int length = declaredAnnotations.length;
        int i4 = 0;
        while (i4 < length) {
            Annotation annotation = declaredAnnotations[i4];
            i4++;
            f0.o(annotation, "annotation");
            f(visitor, annotation);
        }
        visitor.visitEnd();
    }

    public final void i(@NotNull Class<?> klass, @NotNull p.d memberVisitor) {
        f0.p(klass, "klass");
        f0.p(memberVisitor, "memberVisitor");
        e(klass, memberVisitor);
        c(klass, memberVisitor);
        d(klass, memberVisitor);
    }
}
