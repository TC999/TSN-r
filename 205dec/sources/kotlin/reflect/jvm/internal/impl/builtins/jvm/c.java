package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaToKotlinClassMap.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f56159a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final String f56160b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final String f56161c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final String f56162d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final String f56163e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.b f56164f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f56165g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.b f56166h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.b f56167i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.b f56168j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.b> f56169k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.b> f56170l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.c> f56171m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private static final HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.c> f56172n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private static final List<a> f56173o;

    /* compiled from: JavaToKotlinClassMap.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.name.b f56174a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.name.b f56175b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.name.b f56176c;

        public a(@NotNull kotlin.reflect.jvm.internal.impl.name.b javaClass, @NotNull kotlin.reflect.jvm.internal.impl.name.b kotlinReadOnly, @NotNull kotlin.reflect.jvm.internal.impl.name.b kotlinMutable) {
            f0.p(javaClass, "javaClass");
            f0.p(kotlinReadOnly, "kotlinReadOnly");
            f0.p(kotlinMutable, "kotlinMutable");
            this.f56174a = javaClass;
            this.f56175b = kotlinReadOnly;
            this.f56176c = kotlinMutable;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b a() {
            return this.f56174a;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b b() {
            return this.f56175b;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b c() {
            return this.f56176c;
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.name.b d() {
            return this.f56174a;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(this.f56174a, aVar.f56174a) && f0.g(this.f56175b, aVar.f56175b) && f0.g(this.f56176c, aVar.f56176c);
            }
            return false;
        }

        public int hashCode() {
            return (((this.f56174a.hashCode() * 31) + this.f56175b.hashCode()) * 31) + this.f56176c.hashCode();
        }

        @NotNull
        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.f56174a + ", kotlinReadOnly=" + this.f56175b + ", kotlinMutable=" + this.f56176c + ')';
        }
    }

    static {
        List<a> M;
        c cVar = new c();
        f56159a = cVar;
        StringBuilder sb = new StringBuilder();
        FunctionClassKind functionClassKind = FunctionClassKind.Function;
        sb.append(functionClassKind.getPackageFqName().toString());
        sb.append('.');
        sb.append(functionClassKind.getClassNamePrefix());
        f56160b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        FunctionClassKind functionClassKind2 = FunctionClassKind.KFunction;
        sb2.append(functionClassKind2.getPackageFqName().toString());
        sb2.append('.');
        sb2.append(functionClassKind2.getClassNamePrefix());
        f56161c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        FunctionClassKind functionClassKind3 = FunctionClassKind.SuspendFunction;
        sb3.append(functionClassKind3.getPackageFqName().toString());
        sb3.append('.');
        sb3.append(functionClassKind3.getClassNamePrefix());
        f56162d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        FunctionClassKind functionClassKind4 = FunctionClassKind.KSuspendFunction;
        sb4.append(functionClassKind4.getPackageFqName().toString());
        sb4.append('.');
        sb4.append(functionClassKind4.getClassNamePrefix());
        f56163e = sb4.toString();
        kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.functions.FunctionN"));
        f0.o(m4, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f56164f = m4;
        kotlin.reflect.jvm.internal.impl.name.c b4 = m4.b();
        f0.o(b4, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f56165g = b4;
        kotlin.reflect.jvm.internal.impl.name.b m5 = kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.reflect.KFunction"));
        f0.o(m5, "topLevel(FqName(\"kotlin.reflect.KFunction\"))");
        f56166h = m5;
        kotlin.reflect.jvm.internal.impl.name.b m6 = kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.reflect.KClass"));
        f0.o(m6, "topLevel(FqName(\"kotlin.reflect.KClass\"))");
        f56167i = m6;
        f56168j = cVar.h(Class.class);
        f56169k = new HashMap<>();
        f56170l = new HashMap<>();
        f56171m = new HashMap<>();
        f56172n = new HashMap<>();
        kotlin.reflect.jvm.internal.impl.name.b m7 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.O);
        f0.o(m7, "topLevel(FqNames.iterable)");
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = j.a.W;
        kotlin.reflect.jvm.internal.impl.name.c h4 = m7.h();
        kotlin.reflect.jvm.internal.impl.name.c h5 = m7.h();
        f0.o(h5, "kotlinReadOnly.packageFqName");
        kotlin.reflect.jvm.internal.impl.name.c g4 = kotlin.reflect.jvm.internal.impl.name.e.g(cVar2, h5);
        kotlin.reflect.jvm.internal.impl.name.b bVar = new kotlin.reflect.jvm.internal.impl.name.b(h4, g4, false);
        kotlin.reflect.jvm.internal.impl.name.b m8 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.N);
        f0.o(m8, "topLevel(FqNames.iterator)");
        kotlin.reflect.jvm.internal.impl.name.c cVar3 = j.a.V;
        kotlin.reflect.jvm.internal.impl.name.c h6 = m8.h();
        kotlin.reflect.jvm.internal.impl.name.c h7 = m8.h();
        f0.o(h7, "kotlinReadOnly.packageFqName");
        kotlin.reflect.jvm.internal.impl.name.b bVar2 = new kotlin.reflect.jvm.internal.impl.name.b(h6, kotlin.reflect.jvm.internal.impl.name.e.g(cVar3, h7), false);
        kotlin.reflect.jvm.internal.impl.name.b m9 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.P);
        f0.o(m9, "topLevel(FqNames.collection)");
        kotlin.reflect.jvm.internal.impl.name.c cVar4 = j.a.X;
        kotlin.reflect.jvm.internal.impl.name.c h8 = m9.h();
        kotlin.reflect.jvm.internal.impl.name.c h9 = m9.h();
        f0.o(h9, "kotlinReadOnly.packageFqName");
        kotlin.reflect.jvm.internal.impl.name.b bVar3 = new kotlin.reflect.jvm.internal.impl.name.b(h8, kotlin.reflect.jvm.internal.impl.name.e.g(cVar4, h9), false);
        kotlin.reflect.jvm.internal.impl.name.b m10 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.Q);
        f0.o(m10, "topLevel(FqNames.list)");
        kotlin.reflect.jvm.internal.impl.name.c cVar5 = j.a.Y;
        kotlin.reflect.jvm.internal.impl.name.c h10 = m10.h();
        kotlin.reflect.jvm.internal.impl.name.c h11 = m10.h();
        f0.o(h11, "kotlinReadOnly.packageFqName");
        kotlin.reflect.jvm.internal.impl.name.b bVar4 = new kotlin.reflect.jvm.internal.impl.name.b(h10, kotlin.reflect.jvm.internal.impl.name.e.g(cVar5, h11), false);
        kotlin.reflect.jvm.internal.impl.name.b m11 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.S);
        f0.o(m11, "topLevel(FqNames.set)");
        kotlin.reflect.jvm.internal.impl.name.c cVar6 = j.a.f56092a0;
        kotlin.reflect.jvm.internal.impl.name.c h12 = m11.h();
        kotlin.reflect.jvm.internal.impl.name.c h13 = m11.h();
        f0.o(h13, "kotlinReadOnly.packageFqName");
        kotlin.reflect.jvm.internal.impl.name.b bVar5 = new kotlin.reflect.jvm.internal.impl.name.b(h12, kotlin.reflect.jvm.internal.impl.name.e.g(cVar6, h13), false);
        kotlin.reflect.jvm.internal.impl.name.b m12 = kotlin.reflect.jvm.internal.impl.name.b.m(j.a.R);
        f0.o(m12, "topLevel(FqNames.listIterator)");
        kotlin.reflect.jvm.internal.impl.name.c cVar7 = j.a.Z;
        kotlin.reflect.jvm.internal.impl.name.c h14 = m12.h();
        kotlin.reflect.jvm.internal.impl.name.c h15 = m12.h();
        f0.o(h15, "kotlinReadOnly.packageFqName");
        kotlin.reflect.jvm.internal.impl.name.b bVar6 = new kotlin.reflect.jvm.internal.impl.name.b(h14, kotlin.reflect.jvm.internal.impl.name.e.g(cVar7, h15), false);
        kotlin.reflect.jvm.internal.impl.name.c cVar8 = j.a.T;
        kotlin.reflect.jvm.internal.impl.name.b m13 = kotlin.reflect.jvm.internal.impl.name.b.m(cVar8);
        f0.o(m13, "topLevel(FqNames.map)");
        kotlin.reflect.jvm.internal.impl.name.c cVar9 = j.a.f56094b0;
        kotlin.reflect.jvm.internal.impl.name.c h16 = m13.h();
        kotlin.reflect.jvm.internal.impl.name.c h17 = m13.h();
        f0.o(h17, "kotlinReadOnly.packageFqName");
        kotlin.reflect.jvm.internal.impl.name.b bVar7 = new kotlin.reflect.jvm.internal.impl.name.b(h16, kotlin.reflect.jvm.internal.impl.name.e.g(cVar9, h17), false);
        kotlin.reflect.jvm.internal.impl.name.b d4 = kotlin.reflect.jvm.internal.impl.name.b.m(cVar8).d(j.a.U.g());
        f0.o(d4, "topLevel(FqNames.map).cr\u2026mes.mapEntry.shortName())");
        kotlin.reflect.jvm.internal.impl.name.c cVar10 = j.a.f56096c0;
        kotlin.reflect.jvm.internal.impl.name.c h18 = d4.h();
        kotlin.reflect.jvm.internal.impl.name.c h19 = d4.h();
        f0.o(h19, "kotlinReadOnly.packageFqName");
        M = CollectionsKt__CollectionsKt.M(new a(cVar.h(Iterable.class), m7, bVar), new a(cVar.h(Iterator.class), m8, bVar2), new a(cVar.h(Collection.class), m9, bVar3), new a(cVar.h(List.class), m10, bVar4), new a(cVar.h(Set.class), m11, bVar5), new a(cVar.h(ListIterator.class), m12, bVar6), new a(cVar.h(Map.class), m13, bVar7), new a(cVar.h(Map.Entry.class), d4, new kotlin.reflect.jvm.internal.impl.name.b(h18, kotlin.reflect.jvm.internal.impl.name.e.g(cVar10, h19), false)));
        f56173o = M;
        cVar.g(Object.class, j.a.f56093b);
        cVar.g(String.class, j.a.f56105h);
        cVar.g(CharSequence.class, j.a.f56103g);
        cVar.f(Throwable.class, j.a.f56131u);
        cVar.g(Cloneable.class, j.a.f56097d);
        cVar.g(Number.class, j.a.f56125r);
        cVar.f(Comparable.class, j.a.f56133v);
        cVar.g(Enum.class, j.a.f56127s);
        cVar.f(Annotation.class, j.a.E);
        for (a aVar : M) {
            f56159a.e(aVar);
        }
        JvmPrimitiveType[] values = JvmPrimitiveType.values();
        int length = values.length;
        int i4 = 0;
        while (i4 < length) {
            JvmPrimitiveType jvmPrimitiveType = values[i4];
            i4++;
            c cVar11 = f56159a;
            kotlin.reflect.jvm.internal.impl.name.b m14 = kotlin.reflect.jvm.internal.impl.name.b.m(jvmPrimitiveType.getWrapperFqName());
            f0.o(m14, "topLevel(jvmType.wrapperFqName)");
            PrimitiveType primitiveType = jvmPrimitiveType.getPrimitiveType();
            f0.o(primitiveType, "jvmType.primitiveType");
            kotlin.reflect.jvm.internal.impl.name.b m15 = kotlin.reflect.jvm.internal.impl.name.b.m(j.c(primitiveType));
            f0.o(m15, "topLevel(StandardNames.g\u2026e(jvmType.primitiveType))");
            cVar11.b(m14, m15);
        }
        for (kotlin.reflect.jvm.internal.impl.name.b bVar8 : kotlin.reflect.jvm.internal.impl.builtins.c.f56021a.a()) {
            c cVar12 = f56159a;
            kotlin.reflect.jvm.internal.impl.name.b m16 = kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.internal." + bVar8.j().b() + "CompanionObject"));
            f0.o(m16, "topLevel(FqName(\"kotlin.\u2026g() + \"CompanionObject\"))");
            kotlin.reflect.jvm.internal.impl.name.b d5 = bVar8.d(kotlin.reflect.jvm.internal.impl.name.h.f57580d);
            f0.o(d5, "classId.createNestedClas\u2026AME_FOR_COMPANION_OBJECT)");
            cVar12.b(m16, d5);
        }
        for (int i5 = 0; i5 < 23; i5++) {
            c cVar13 = f56159a;
            kotlin.reflect.jvm.internal.impl.name.b m17 = kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c(f0.C("kotlin.jvm.functions.Function", Integer.valueOf(i5))));
            f0.o(m17, "topLevel(FqName(\"kotlin.\u2026m.functions.Function$i\"))");
            cVar13.b(m17, j.a(i5));
            cVar13.d(new kotlin.reflect.jvm.internal.impl.name.c(f0.C(f56161c, Integer.valueOf(i5))), f56166h);
        }
        for (int i6 = 0; i6 < 22; i6++) {
            FunctionClassKind functionClassKind5 = FunctionClassKind.KSuspendFunction;
            f56159a.d(new kotlin.reflect.jvm.internal.impl.name.c(f0.C(functionClassKind5.getPackageFqName().toString() + '.' + functionClassKind5.getClassNamePrefix(), Integer.valueOf(i6))), f56166h);
        }
        c cVar14 = f56159a;
        kotlin.reflect.jvm.internal.impl.name.c l4 = j.a.f56095c.l();
        f0.o(l4, "nothing.toSafe()");
        cVar14.d(l4, cVar14.h(Void.class));
    }

    private c() {
    }

    private final void b(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.reflect.jvm.internal.impl.name.b bVar2) {
        c(bVar, bVar2);
        kotlin.reflect.jvm.internal.impl.name.c b4 = bVar2.b();
        f0.o(b4, "kotlinClassId.asSingleFqName()");
        d(b4, bVar);
    }

    private final void c(kotlin.reflect.jvm.internal.impl.name.b bVar, kotlin.reflect.jvm.internal.impl.name.b bVar2) {
        HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.b> hashMap = f56169k;
        kotlin.reflect.jvm.internal.impl.name.d j4 = bVar.b().j();
        f0.o(j4, "javaClassId.asSingleFqName().toUnsafe()");
        hashMap.put(j4, bVar2);
    }

    private final void d(kotlin.reflect.jvm.internal.impl.name.c cVar, kotlin.reflect.jvm.internal.impl.name.b bVar) {
        HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.b> hashMap = f56170l;
        kotlin.reflect.jvm.internal.impl.name.d j4 = cVar.j();
        f0.o(j4, "kotlinFqNameUnsafe.toUnsafe()");
        hashMap.put(j4, bVar);
    }

    private final void e(a aVar) {
        kotlin.reflect.jvm.internal.impl.name.b a4 = aVar.a();
        kotlin.reflect.jvm.internal.impl.name.b b4 = aVar.b();
        kotlin.reflect.jvm.internal.impl.name.b c4 = aVar.c();
        b(a4, b4);
        kotlin.reflect.jvm.internal.impl.name.c b5 = c4.b();
        f0.o(b5, "mutableClassId.asSingleFqName()");
        d(b5, a4);
        kotlin.reflect.jvm.internal.impl.name.c b6 = b4.b();
        f0.o(b6, "readOnlyClassId.asSingleFqName()");
        kotlin.reflect.jvm.internal.impl.name.c b7 = c4.b();
        f0.o(b7, "mutableClassId.asSingleFqName()");
        HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.c> hashMap = f56171m;
        kotlin.reflect.jvm.internal.impl.name.d j4 = c4.b().j();
        f0.o(j4, "mutableClassId.asSingleFqName().toUnsafe()");
        hashMap.put(j4, b6);
        HashMap<kotlin.reflect.jvm.internal.impl.name.d, kotlin.reflect.jvm.internal.impl.name.c> hashMap2 = f56172n;
        kotlin.reflect.jvm.internal.impl.name.d j5 = b6.j();
        f0.o(j5, "readOnlyFqName.toUnsafe()");
        hashMap2.put(j5, b7);
    }

    private final void f(Class<?> cls, kotlin.reflect.jvm.internal.impl.name.c cVar) {
        kotlin.reflect.jvm.internal.impl.name.b h4 = h(cls);
        kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(cVar);
        f0.o(m4, "topLevel(kotlinFqName)");
        b(h4, m4);
    }

    private final void g(Class<?> cls, kotlin.reflect.jvm.internal.impl.name.d dVar) {
        kotlin.reflect.jvm.internal.impl.name.c l4 = dVar.l();
        f0.o(l4, "kotlinFqName.toSafe()");
        f(cls, l4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.name.b h(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c(cls.getCanonicalName()));
            f0.o(m4, "topLevel(FqName(clazz.canonicalName))");
            return m4;
        }
        kotlin.reflect.jvm.internal.impl.name.b d4 = h(declaringClass).d(kotlin.reflect.jvm.internal.impl.name.f.f(cls.getSimpleName()));
        f0.o(d4, "classId(outer).createNes\u2026tifier(clazz.simpleName))");
        return d4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
        r5 = kotlin.text.v.X0(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean k(kotlin.reflect.jvm.internal.impl.name.d r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r5 = r5.b()
            java.lang.String r0 = "kotlinFqName.asString()"
            kotlin.jvm.internal.f0.o(r5, r0)
            java.lang.String r0 = ""
            java.lang.String r5 = kotlin.text.n.n5(r5, r6, r0)
            int r6 = r5.length()
            r0 = 1
            r1 = 0
            if (r6 <= 0) goto L19
            r6 = 1
            goto L1a
        L19:
            r6 = 0
        L1a:
            if (r6 == 0) goto L37
            r6 = 48
            r2 = 2
            r3 = 0
            boolean r6 = kotlin.text.n.d5(r5, r6, r1, r2, r3)
            if (r6 != 0) goto L37
            java.lang.Integer r5 = kotlin.text.n.X0(r5)
            if (r5 == 0) goto L35
            int r5 = r5.intValue()
            r6 = 23
            if (r5 < r6) goto L35
            goto L36
        L35:
            r0 = 0
        L36:
            return r0
        L37:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.jvm.c.k(kotlin.reflect.jvm.internal.impl.name.d, java.lang.String):boolean");
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.c i() {
        return f56165g;
    }

    @NotNull
    public final List<a> j() {
        return f56173o;
    }

    public final boolean l(@Nullable kotlin.reflect.jvm.internal.impl.name.d dVar) {
        return f56171m.containsKey(dVar);
    }

    public final boolean m(@Nullable kotlin.reflect.jvm.internal.impl.name.d dVar) {
        return f56172n.containsKey(dVar);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.b n(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        return f56169k.get(fqName.j());
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.b o(@NotNull kotlin.reflect.jvm.internal.impl.name.d kotlinFqName) {
        f0.p(kotlinFqName, "kotlinFqName");
        if (!k(kotlinFqName, f56160b) && !k(kotlinFqName, f56162d)) {
            if (!k(kotlinFqName, f56161c) && !k(kotlinFqName, f56163e)) {
                return f56170l.get(kotlinFqName);
            }
            return f56166h;
        }
        return f56164f;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.c p(@Nullable kotlin.reflect.jvm.internal.impl.name.d dVar) {
        return f56171m.get(dVar);
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.c q(@Nullable kotlin.reflect.jvm.internal.impl.name.d dVar) {
        return f56172n.get(dVar);
    }
}
