package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.l0;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: reflectClassUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final List<kotlin.reflect.d<? extends Object>> f56585a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f56586b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f56587c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Class<? extends kotlin.k<?>>, Integer> f56588d;

    /* compiled from: reflectClassUtil.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<ParameterizedType, ParameterizedType> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56589a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final ParameterizedType invoke(@NotNull ParameterizedType it) {
            f0.p(it, "it");
            Type ownerType = it.getOwnerType();
            if (ownerType instanceof ParameterizedType) {
                return (ParameterizedType) ownerType;
            }
            return null;
        }
    }

    /* compiled from: reflectClassUtil.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l<ParameterizedType, kotlin.sequences.m<? extends Type>> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56590a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final kotlin.sequences.m<Type> invoke(@NotNull ParameterizedType it) {
            kotlin.sequences.m<Type> h5;
            f0.p(it, "it");
            Type[] actualTypeArguments = it.getActualTypeArguments();
            f0.o(actualTypeArguments, "it.actualTypeArguments");
            h5 = kotlin.collections.p.h5(actualTypeArguments);
            return h5;
        }
    }

    static {
        List<kotlin.reflect.d<? extends Object>> M;
        int Z;
        Map<Class<? extends Object>, Class<? extends Object>> B0;
        int Z2;
        Map<Class<? extends Object>, Class<? extends Object>> B02;
        List M2;
        int Z3;
        Map<Class<? extends kotlin.k<?>>, Integer> B03;
        int i4 = 0;
        M = CollectionsKt__CollectionsKt.M(n0.d(Boolean.TYPE), n0.d(Byte.TYPE), n0.d(Character.TYPE), n0.d(Double.TYPE), n0.d(Float.TYPE), n0.d(Integer.TYPE), n0.d(Long.TYPE), n0.d(Short.TYPE));
        f56585a = M;
        Z = kotlin.collections.y.Z(M, 10);
        ArrayList arrayList = new ArrayList(Z);
        Iterator<T> it = M.iterator();
        while (it.hasNext()) {
            kotlin.reflect.d dVar = (kotlin.reflect.d) it.next();
            arrayList.add(l0.a(c2.a.e(dVar), c2.a.f(dVar)));
        }
        B0 = z0.B0(arrayList);
        f56586b = B0;
        List<kotlin.reflect.d<? extends Object>> list = f56585a;
        Z2 = kotlin.collections.y.Z(list, 10);
        ArrayList arrayList2 = new ArrayList(Z2);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            kotlin.reflect.d dVar2 = (kotlin.reflect.d) it2.next();
            arrayList2.add(l0.a(c2.a.f(dVar2), c2.a.e(dVar2)));
        }
        B02 = z0.B0(arrayList2);
        f56587c = B02;
        M2 = CollectionsKt__CollectionsKt.M(d2.a.class, d2.l.class, d2.p.class, d2.q.class, d2.r.class, d2.s.class, d2.t.class, d2.u.class, d2.v.class, d2.w.class, d2.b.class, d2.c.class, d2.d.class, d2.e.class, d2.f.class, d2.g.class, d2.h.class, d2.i.class, d2.j.class, d2.k.class, d2.m.class, d2.n.class, d2.o.class);
        Z3 = kotlin.collections.y.Z(M2, 10);
        ArrayList arrayList3 = new ArrayList(Z3);
        for (Object obj : M2) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            arrayList3.add(l0.a((Class) obj, Integer.valueOf(i4)));
            i4 = i5;
        }
        B03 = z0.B0(arrayList3);
        f56588d = B03;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.b a(@NotNull Class<?> cls) {
        f0.p(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (!cls.isArray()) {
                if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                    String simpleName = cls.getSimpleName();
                    f0.o(simpleName, "simpleName");
                    if (!(simpleName.length() == 0)) {
                        Class<?> declaringClass = cls.getDeclaringClass();
                        kotlin.reflect.jvm.internal.impl.name.b m4 = declaringClass == null ? kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c(cls.getName())) : a(declaringClass).d(kotlin.reflect.jvm.internal.impl.name.f.f(cls.getSimpleName()));
                        f0.o(m4, "declaringClass?.classId?\u2026Id.topLevel(FqName(name))");
                        return m4;
                    }
                }
                kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c(cls.getName());
                return new kotlin.reflect.jvm.internal.impl.name.b(cVar.e(), kotlin.reflect.jvm.internal.impl.name.c.k(cVar.g()), true);
            }
            throw new IllegalArgumentException(f0.C("Can't compute ClassId for array type: ", cls));
        }
        throw new IllegalArgumentException(f0.C("Can't compute ClassId for primitive type: ", cls));
    }

    @NotNull
    public static final String b(@NotNull Class<?> cls) {
        String j22;
        String j23;
        f0.p(cls, "<this>");
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return "D";
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return "I";
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return "B";
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return "C";
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return "J";
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return "V";
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return "Z";
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return "F";
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return "S";
                    }
                    break;
            }
            throw new IllegalArgumentException(f0.C("Unsupported primitive type: ", cls));
        } else if (cls.isArray()) {
            String name2 = cls.getName();
            f0.o(name2, "name");
            j23 = kotlin.text.w.j2(name2, '.', '/', false, 4, null);
            return j23;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('L');
            String name3 = cls.getName();
            f0.o(name3, "name");
            j22 = kotlin.text.w.j2(name3, '.', '/', false, 4, null);
            sb.append(j22);
            sb.append(';');
            return sb.toString();
        }
    }

    @Nullable
    public static final Integer c(@NotNull Class<?> cls) {
        f0.p(cls, "<this>");
        return f56588d.get(cls);
    }

    @NotNull
    public static final List<Type> d(@NotNull Type type) {
        kotlin.sequences.m q3;
        kotlin.sequences.m A0;
        List<Type> V2;
        List<Type> ey;
        List<Type> F;
        f0.p(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() == null) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            f0.o(actualTypeArguments, "actualTypeArguments");
            ey = kotlin.collections.p.ey(actualTypeArguments);
            return ey;
        }
        q3 = kotlin.sequences.s.q(type, a.f56589a);
        A0 = SequencesKt___SequencesKt.A0(q3, b.f56590a);
        V2 = SequencesKt___SequencesKt.V2(A0);
        return V2;
    }

    @Nullable
    public static final Class<?> e(@NotNull Class<?> cls) {
        f0.p(cls, "<this>");
        return f56586b.get(cls);
    }

    @NotNull
    public static final ClassLoader f(@NotNull Class<?> cls) {
        f0.p(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
            f0.o(systemClassLoader, "getSystemClassLoader()");
            return systemClassLoader;
        }
        return classLoader;
    }

    @Nullable
    public static final Class<?> g(@NotNull Class<?> cls) {
        f0.p(cls, "<this>");
        return f56587c.get(cls);
    }

    public static final boolean h(@NotNull Class<?> cls) {
        f0.p(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
