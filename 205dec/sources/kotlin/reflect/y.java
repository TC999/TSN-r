package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.g0;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: TypesJVM.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003\u001a\"\u0010\n\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0003\u001a\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002\"\u001e\u0010\u0012\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0012\u001a\u00020\u0003*\u00020\b8BX\u0083\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lkotlin/reflect/r;", "", "forceWrapper", "Ljava/lang/reflect/Type;", "c", "Ljava/lang/Class;", "jClass", "", "Lkotlin/reflect/t;", "arguments", "e", "type", "", "j", "f", "(Lkotlin/reflect/r;)Ljava/lang/reflect/Type;", "getJavaType$annotations", "(Lkotlin/reflect/r;)V", "javaType", "g", "(Lkotlin/reflect/t;)Ljava/lang/reflect/Type;", "(Lkotlin/reflect/t;)V", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y {

    /* compiled from: TypesJVM.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f58696a;

        static {
            int[] iArr = new int[KVariance.values().length];
            iArr[KVariance.IN.ordinal()] = 1;
            iArr[KVariance.INVARIANT.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            f58696a = iArr;
        }
    }

    /* compiled from: TypesJVM.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b extends FunctionReferenceImpl implements d2.l<Class<?>, Class<?>> {

        /* renamed from: a */
        public static final b f58697a = new b();

        b() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // d2.l
        /* renamed from: d */
        public final Class<?> invoke(@NotNull Class<?> p02) {
            f0.p(p02, "p0");
            return p02.getComponentType();
        }
    }

    public static final /* synthetic */ String b(Type type) {
        return j(type);
    }

    @ExperimentalStdlibApi
    public static final Type c(r rVar, boolean z3) {
        Object V4;
        g a4 = rVar.a();
        if (a4 instanceof s) {
            return new x((s) a4);
        }
        if (a4 instanceof d) {
            d dVar = (d) a4;
            Class e4 = z3 ? c2.a.e(dVar) : c2.a.c(dVar);
            List<t> arguments = rVar.getArguments();
            if (arguments.isEmpty()) {
                return e4;
            }
            if (e4.isArray()) {
                if (e4.getComponentType().isPrimitive()) {
                    return e4;
                }
                V4 = kotlin.collections.f0.V4(arguments);
                t tVar = (t) V4;
                if (tVar != null) {
                    KVariance a5 = tVar.a();
                    r b4 = tVar.b();
                    int i4 = a5 == null ? -1 : a.f58696a[a5.ordinal()];
                    if (i4 == -1 || i4 == 1) {
                        return e4;
                    }
                    if (i4 != 2 && i4 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f0.m(b4);
                    Type d4 = d(b4, false, 1, null);
                    return d4 instanceof Class ? e4 : new kotlin.reflect.a(d4);
                }
                throw new IllegalArgumentException(f0.C("kotlin.Array must have exactly one type argument: ", rVar));
            }
            return e(e4, arguments);
        }
        throw new UnsupportedOperationException(f0.C("Unsupported type classifier: ", rVar));
    }

    static /* synthetic */ Type d(r rVar, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        return c(rVar, z3);
    }

    @ExperimentalStdlibApi
    private static final Type e(Class<?> cls, List<t> list) {
        int Z;
        int Z2;
        int Z3;
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            Z3 = kotlin.collections.y.Z(list, 10);
            ArrayList arrayList = new ArrayList(Z3);
            for (t tVar : list) {
                arrayList.add(g(tVar));
            }
            return new u(cls, null, arrayList);
        } else if (Modifier.isStatic(cls.getModifiers())) {
            Z2 = kotlin.collections.y.Z(list, 10);
            ArrayList arrayList2 = new ArrayList(Z2);
            for (t tVar2 : list) {
                arrayList2.add(g(tVar2));
            }
            return new u(cls, declaringClass, arrayList2);
        } else {
            int length = cls.getTypeParameters().length;
            Type e4 = e(declaringClass, list.subList(length, list.size()));
            List<t> subList = list.subList(0, length);
            Z = kotlin.collections.y.Z(subList, 10);
            ArrayList arrayList3 = new ArrayList(Z);
            for (t tVar3 : subList) {
                arrayList3.add(g(tVar3));
            }
            return new u(cls, e4, arrayList3);
        }
    }

    @NotNull
    public static final Type f(@NotNull r rVar) {
        Type c4;
        f0.p(rVar, "<this>");
        return (!(rVar instanceof g0) || (c4 = ((g0) rVar).c()) == null) ? d(rVar, false, 1, null) : c4;
    }

    private static final Type g(t tVar) {
        KVariance g4 = tVar.g();
        if (g4 == null) {
            return z.f58698c.a();
        }
        r type = tVar.getType();
        f0.m(type);
        int i4 = a.f58696a[g4.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return new z(c(type, true), null);
                }
                throw new NoWhenBranchMatchedException();
            }
            return c(type, true);
        }
        return new z(null, c(type, true));
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static /* synthetic */ void h(r rVar) {
    }

    @ExperimentalStdlibApi
    private static /* synthetic */ void i(t tVar) {
    }

    public static final String j(Type type) {
        String name;
        kotlin.sequences.m q3;
        Object Y0;
        int Z;
        String g22;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                q3 = kotlin.sequences.s.q(type, b.f58697a);
                Y0 = SequencesKt___SequencesKt.Y0(q3);
                String name2 = ((Class) Y0).getName();
                Z = SequencesKt___SequencesKt.Z(q3);
                g22 = kotlin.text.w.g2("[]", Z);
                name = f0.C(name2, g22);
            } else {
                name = cls.getName();
            }
            f0.o(name, "{\n        if (type.isArr\u2026   } else type.name\n    }");
            return name;
        }
        return type.toString();
    }
}
