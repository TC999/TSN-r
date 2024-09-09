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
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003\u001a\"\u0010\n\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0003\u001a\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002\"\u001e\u0010\u0012\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0012\u001a\u00020\u0003*\u00020\b8BX\u0083\u0004\u00a2\u0006\f\u0012\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0016"}, d2 = {"Lkotlin/reflect/r;", "", "forceWrapper", "Ljava/lang/reflect/Type;", "c", "Ljava/lang/Class;", "jClass", "", "Lkotlin/reflect/t;", "arguments", "e", "type", "", "j", "f", "(Lkotlin/reflect/r;)Ljava/lang/reflect/Type;", "getJavaType$annotations", "(Lkotlin/reflect/r;)V", "javaType", "g", "(Lkotlin/reflect/t;)Ljava/lang/reflect/Type;", "(Lkotlin/reflect/t;)V", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class a0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypesJVM.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u00002\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Ljava/lang/Class;", "p1", "kotlin.jvm.PlatformType", "e", "(Ljava/lang/Class;)Ljava/lang/Class;"}, k = 3, mv = {1, 5, 1})
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final /* synthetic */ class a extends FunctionReferenceImpl implements l1.l<Class<? extends Object>, Class<?>> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f55833a = new a();

        a() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // l1.l
        /* renamed from: e */
        public final Class<?> invoke(@NotNull Class<?> p12) {
            f0.p(p12, "p1");
            return p12.getComponentType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r3v10, types: [kotlin.reflect.y, java.lang.reflect.Type] */
    @ExperimentalStdlibApi
    public static final Type c(r rVar, boolean z3) {
        int i4;
        g o4 = rVar.o();
        if (o4 instanceof s) {
            return new y((s) o4);
        }
        if (o4 instanceof d) {
            d dVar = (d) o4;
            Class e4 = z3 ? k1.a.e(dVar) : k1.a.c(dVar);
            List<t> arguments = rVar.getArguments();
            if (arguments.isEmpty()) {
                return e4;
            }
            if (e4.isArray()) {
                Class<?> componentType = e4.getComponentType();
                f0.o(componentType, "jClass.componentType");
                if (componentType.isPrimitive()) {
                    return e4;
                }
                t tVar = (t) kotlin.collections.v.X4(arguments);
                if (tVar != null) {
                    KVariance a4 = tVar.a();
                    r b4 = tVar.b();
                    if (a4 == null || (i4 = z.a[a4.ordinal()]) == 1) {
                        return e4;
                    }
                    if (i4 != 2 && i4 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    f0.m(b4);
                    Type d4 = d(b4, false, 1, null);
                    return d4 instanceof Class ? e4 : new kotlin.reflect.a(d4);
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + rVar);
            }
            return e(e4, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + rVar);
    }

    static /* synthetic */ Type d(r rVar, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        return c(rVar, z3);
    }

    @ExperimentalStdlibApi
    private static final Type e(Class<?> cls, List<t> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass != null) {
            if (Modifier.isStatic(cls.getModifiers())) {
                ArrayList arrayList = new ArrayList(kotlin.collections.v.Y(list, 10));
                for (t tVar : list) {
                    arrayList.add(g(tVar));
                }
                return new v(cls, declaringClass, arrayList);
            }
            int length = cls.getTypeParameters().length;
            Type e4 = e(declaringClass, list.subList(length, list.size()));
            List<t> subList = list.subList(0, length);
            ArrayList arrayList2 = new ArrayList(kotlin.collections.v.Y(subList, 10));
            for (t tVar2 : subList) {
                arrayList2.add(g(tVar2));
            }
            return new v(cls, e4, arrayList2);
        }
        ArrayList arrayList3 = new ArrayList(kotlin.collections.v.Y(list, 10));
        for (t tVar3 : list) {
            arrayList3.add(g(tVar3));
        }
        return new v(cls, null, arrayList3);
    }

    @NotNull
    public static final Type f(@NotNull r javaType) {
        Type k4;
        f0.p(javaType, "$this$javaType");
        return (!(javaType instanceof g0) || (k4 = ((g0) javaType).k()) == null) ? d(javaType, false, 1, null) : k4;
    }

    private static final Type g(t tVar) {
        KVariance g4 = tVar.g();
        if (g4 != null) {
            r type = tVar.getType();
            f0.m(type);
            int i4 = z.b[g4.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        return new b0(c(type, true), null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return new b0(null, c(type, true));
            }
            return c(type, true);
        }
        return b0.f55835d.a();
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = "1.4")
    @ExperimentalStdlibApi
    public static /* synthetic */ void h(r rVar) {
    }

    @ExperimentalStdlibApi
    private static /* synthetic */ void i(t tVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(Type type) {
        String name;
        Object Y0;
        int Z;
        String g22;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                kotlin.sequences.m o4 = kotlin.sequences.p.o(type, a.f55833a);
                StringBuilder sb = new StringBuilder();
                Y0 = SequencesKt___SequencesKt.Y0(o4);
                sb.append(((Class) Y0).getName());
                Z = SequencesKt___SequencesKt.Z(o4);
                g22 = kotlin.text.w.g2("[]", Z);
                sb.append(g22);
                name = sb.toString();
            } else {
                name = cls.getName();
            }
            f0.o(name, "if (type.isArray) {\n    \u2026\n        } else type.name");
            return name;
        }
        return type.toString();
    }
}
