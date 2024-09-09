package kotlin.reflect.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.f0;
import kotlin.reflect.h;
import kotlin.reflect.i;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.f;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.s;
import kotlin.reflect.jvm.internal.u;
import kotlin.reflect.n;
import kotlin.reflect.p;
import kotlin.reflect.r;
import kotlin.reflect.y;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJvmMapping.kt */
@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0002\"\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0004*\u0006\u0012\u0002\b\u00030\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001b\u0010\u000b\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u00038F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\"\u001b\u0010\u000f\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\f8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u001b\u0010\u0013\u001a\u0004\u0018\u00010\b*\u0006\u0012\u0002\b\u00030\u00108F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"/\u0010\u001a\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0015\"\u0004\b\u0000\u0010\u0014*\b\u0012\u0004\u0012\u00028\u00000\u00108F\u00a2\u0006\f\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u001f\u001a\u00020\u001c*\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\"\u001b\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b \u0010!\"\u001b\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b#\u0010$\"-\u0010%\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010\"\b\b\u0000\u0010\u0014*\u00020&*\b\u0012\u0004\u0012\u00028\u00000\u00158F\u00a2\u0006\u0006\u001a\u0004\b'\u0010(\u00a8\u0006)"}, d2 = {"Ljava/lang/reflect/Member;", "Lkotlin/reflect/h;", "h", "Lkotlin/reflect/n;", "Ljava/lang/reflect/Field;", "c", "(Lkotlin/reflect/n;)Ljava/lang/reflect/Field;", "javaField", "Ljava/lang/reflect/Method;", "d", "(Lkotlin/reflect/n;)Ljava/lang/reflect/Method;", "javaGetter", "Lkotlin/reflect/j;", "f", "(Lkotlin/reflect/j;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/i;", "e", "(Lkotlin/reflect/i;)Ljava/lang/reflect/Method;", "javaMethod", "T", "Ljava/lang/reflect/Constructor;", "a", "(Lkotlin/reflect/i;)Ljava/lang/reflect/Constructor;", "getJavaConstructor$annotations", "(Lkotlin/reflect/i;)V", "javaConstructor", "Lkotlin/reflect/r;", "Ljava/lang/reflect/Type;", "g", "(Lkotlin/reflect/r;)Ljava/lang/reflect/Type;", "javaType", "k", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/n;", "kotlinProperty", "j", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/i;", "kotlinFunction", "", "i", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/i;", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
@JvmName(name = "ReflectJvmMapping")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {

    /* compiled from: ReflectJvmMapping.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f55857a;

        static {
            int[] iArr = new int[KotlinClassHeader.Kind.values().length];
            iArr[KotlinClassHeader.Kind.FILE_FACADE.ordinal()] = 1;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS.ordinal()] = 2;
            iArr[KotlinClassHeader.Kind.MULTIFILE_CLASS_PART.ordinal()] = 3;
            f55857a = iArr;
        }
    }

    @Nullable
    public static final <T> Constructor<T> a(@NotNull i<? extends T> iVar) {
        f0.p(iVar, "<this>");
        f<?> b4 = kotlin.reflect.jvm.internal.f0.b(iVar);
        Object b5 = b4 == null ? null : b4.F().b();
        if (b5 instanceof Constructor) {
            return (Constructor) b5;
        }
        return null;
    }

    public static /* synthetic */ void b(i iVar) {
    }

    @Nullable
    public static final Field c(@NotNull n<?> nVar) {
        f0.p(nVar, "<this>");
        s<?> d4 = kotlin.reflect.jvm.internal.f0.d(nVar);
        if (d4 == null) {
            return null;
        }
        return d4.R();
    }

    @Nullable
    public static final Method d(@NotNull n<?> nVar) {
        f0.p(nVar, "<this>");
        return e(nVar.getGetter());
    }

    @Nullable
    public static final Method e(@NotNull i<?> iVar) {
        f0.p(iVar, "<this>");
        f<?> b4 = kotlin.reflect.jvm.internal.f0.b(iVar);
        Object b5 = b4 == null ? null : b4.F().b();
        if (b5 instanceof Method) {
            return (Method) b5;
        }
        return null;
    }

    @Nullable
    public static final Method f(@NotNull j<?> jVar) {
        f0.p(jVar, "<this>");
        return e(jVar.getSetter());
    }

    @NotNull
    public static final Type g(@NotNull r rVar) {
        f0.p(rVar, "<this>");
        Type c4 = ((u) rVar).c();
        return c4 == null ? y.f(rVar) : c4;
    }

    private static final h h(Member member) {
        f.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f.f56550c;
        Class<?> declaringClass = member.getDeclaringClass();
        f0.o(declaringClass, "declaringClass");
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f a4 = aVar.a(declaringClass);
        KotlinClassHeader.Kind c4 = a4 == null ? null : a4.e().c();
        int i4 = c4 == null ? -1 : a.f55857a[c4.ordinal()];
        if (i4 == 1 || i4 == 2 || i4 == 3) {
            Class<?> declaringClass2 = member.getDeclaringClass();
            f0.o(declaringClass2, "declaringClass");
            return new kotlin.reflect.jvm.internal.n(declaringClass2, null, 2, null);
        }
        return null;
    }

    @Nullable
    public static final <T> i<T> i(@NotNull Constructor<T> constructor) {
        T t3;
        f0.p(constructor, "<this>");
        Class<T> declaringClass = constructor.getDeclaringClass();
        f0.o(declaringClass, "declaringClass");
        Iterator<T> it = c2.a.g(declaringClass).g().iterator();
        while (true) {
            if (!it.hasNext()) {
                t3 = null;
                break;
            }
            t3 = it.next();
            if (f0.g(a((i) t3), constructor)) {
                break;
            }
        }
        return (i) t3;
    }

    @Nullable
    public static final i<?> j(@NotNull Method method) {
        Object obj;
        boolean z3;
        f0.p(method, "<this>");
        Object obj2 = null;
        if (Modifier.isStatic(method.getModifiers())) {
            h h4 = h(method);
            if (h4 != null) {
                Collection<kotlin.reflect.c<?>> q3 = h4.q();
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : q3) {
                    if (obj3 instanceof i) {
                        arrayList.add(obj3);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (f0.g(e((i) next), method)) {
                        obj2 = next;
                        break;
                    }
                }
                return (i) obj2;
            }
            Class<?> declaringClass = method.getDeclaringClass();
            f0.o(declaringClass, "declaringClass");
            kotlin.reflect.d<?> g4 = kotlin.reflect.full.d.g(c2.a.g(declaringClass));
            if (g4 != null) {
                Iterator<T> it2 = kotlin.reflect.full.d.y(g4).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    Method e4 = e((i) obj);
                    if (e4 != null && f0.g(e4.getName(), method.getName()) && Arrays.equals(e4.getParameterTypes(), method.getParameterTypes()) && f0.g(e4.getReturnType(), method.getReturnType())) {
                        z3 = true;
                        continue;
                    } else {
                        z3 = false;
                        continue;
                    }
                    if (z3) {
                        break;
                    }
                }
                i<?> iVar = (i) obj;
                if (iVar != null) {
                    return iVar;
                }
            }
        }
        Class<?> declaringClass2 = method.getDeclaringClass();
        f0.o(declaringClass2, "declaringClass");
        Iterator<T> it3 = kotlin.reflect.full.d.y(c2.a.g(declaringClass2)).iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            if (f0.g(e((i) next2), method)) {
                obj2 = next2;
                break;
            }
        }
        return (i) obj2;
    }

    @Nullable
    public static final n<?> k(@NotNull Field field) {
        f0.p(field, "<this>");
        Object obj = null;
        if (field.isSynthetic()) {
            return null;
        }
        h h4 = h(field);
        if (h4 != null) {
            Collection<kotlin.reflect.c<?>> q3 = h4.q();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : q3) {
                if (obj2 instanceof n) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (f0.g(c((n) next), field)) {
                    obj = next;
                    break;
                }
            }
            return (n) obj;
        }
        Class<?> declaringClass = field.getDeclaringClass();
        f0.o(declaringClass, "declaringClass");
        Iterator it2 = kotlin.reflect.full.d.G(c2.a.g(declaringClass)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (f0.g(c((p) next2), field)) {
                obj = next2;
                break;
            }
        }
        return (n) obj;
    }
}
