package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.types.b0;
import kotlin.reflect.jvm.internal.impl.types.d0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.p0;
import kotlin.reflect.jvm.internal.impl.types.t0;
import org.jetbrains.annotations.NotNull;

/* compiled from: IntersectionType.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final w f58309a = new w();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: IntersectionType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f58310a = new c("START", 0);

        /* renamed from: b  reason: collision with root package name */
        public static final a f58311b = new C1181a("ACCEPT_NULL", 1);

        /* renamed from: c  reason: collision with root package name */
        public static final a f58312c = new d("UNKNOWN", 2);

        /* renamed from: d  reason: collision with root package name */
        public static final a f58313d = new b("NOT_NULL", 3);

        /* renamed from: e  reason: collision with root package name */
        private static final /* synthetic */ a[] f58314e = a();

        /* compiled from: IntersectionType.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.types.checker.w$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1181a extends a {
            C1181a(String str, int i4) {
                super(str, i4, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.w.a
            @NotNull
            public a b(@NotNull l1 nextType) {
                f0.p(nextType, "nextType");
                return d(nextType);
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class b extends a {
            b(String str, int i4) {
                super(str, i4, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.w.a
            @NotNull
            /* renamed from: e */
            public b b(@NotNull l1 nextType) {
                f0.p(nextType, "nextType");
                return this;
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class c extends a {
            c(String str, int i4) {
                super(str, i4, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.w.a
            @NotNull
            public a b(@NotNull l1 nextType) {
                f0.p(nextType, "nextType");
                return d(nextType);
            }
        }

        /* compiled from: IntersectionType.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class d extends a {
            d(String str, int i4) {
                super(str, i4, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.w.a
            @NotNull
            public a b(@NotNull l1 nextType) {
                f0.p(nextType, "nextType");
                a d4 = d(nextType);
                return d4 == a.f58311b ? this : d4;
            }
        }

        private a(String str, int i4) {
        }

        public /* synthetic */ a(String str, int i4, kotlin.jvm.internal.u uVar) {
            this(str, i4);
        }

        private static final /* synthetic */ a[] a() {
            return new a[]{f58310a, f58311b, f58312c, f58313d};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f58314e.clone();
        }

        @NotNull
        public abstract a b(@NotNull l1 l1Var);

        @NotNull
        protected final a d(@NotNull l1 l1Var) {
            f0.p(l1Var, "<this>");
            return l1Var.I0() ? f58311b : ((l1Var instanceof kotlin.reflect.jvm.internal.impl.types.n) && (((kotlin.reflect.jvm.internal.impl.types.n) l1Var).T0() instanceof t0)) ? f58313d : l1Var instanceof t0 ? f58312c : o.f58302a.a(l1Var) ? f58313d : f58312c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.a<String> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Set<m0> f58315a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        b(Set<? extends m0> set) {
            super(0);
            this.f58315a = set;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final String invoke() {
            String X2;
            X2 = kotlin.collections.f0.X2(this.f58315a, null, null, null, 0, null, null, 63, null);
            return f0.C("This collections cannot be empty! input types: ", X2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class c extends FunctionReference implements d2.p<e0, e0, Boolean> {
        c(Object obj) {
            super(2, obj);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: d */
        public final Boolean invoke(@NotNull e0 p02, @NotNull e0 p12) {
            f0.p(p02, "p0");
            f0.p(p12, "p1");
            return Boolean.valueOf(((w) this.receiver).e(p02, p12));
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "isStrictSupertype";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(w.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "isStrictSupertype(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionType.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class d extends FunctionReference implements d2.p<e0, e0, Boolean> {
        d(Object obj) {
            super(2, obj);
        }

        @Override // d2.p
        @NotNull
        /* renamed from: d */
        public final Boolean invoke(@NotNull e0 p02, @NotNull e0 p12) {
            f0.p(p02, "p0");
            f0.p(p12, "p1");
            return Boolean.valueOf(((m) this.receiver).b(p02, p12));
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "equalTypes";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(m.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "equalTypes(Lorg/jetbrains/kotlin/types/KotlinType;Lorg/jetbrains/kotlin/types/KotlinType;)Z";
        }
    }

    private w() {
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0051 A[EDGE_INSN: B:27:0x0051->B:18:0x0051 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.Collection<kotlin.reflect.jvm.internal.impl.types.m0> b(java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.m0> r8, d2.p<? super kotlin.reflect.jvm.internal.impl.types.m0, ? super kotlin.reflect.jvm.internal.impl.types.m0, java.lang.Boolean> r9) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.Iterator r8 = r0.iterator()
            java.lang.String r1 = "filteredTypes.iterator()"
            kotlin.jvm.internal.f0.o(r8, r1)
        Le:
            boolean r1 = r8.hasNext()
            if (r1 == 0) goto L57
            java.lang.Object r1 = r8.next()
            kotlin.reflect.jvm.internal.impl.types.m0 r1 = (kotlin.reflect.jvm.internal.impl.types.m0) r1
            boolean r2 = r0.isEmpty()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L24
        L22:
            r3 = 0
            goto L51
        L24:
            java.util.Iterator r2 = r0.iterator()
        L28:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L22
            java.lang.Object r5 = r2.next()
            kotlin.reflect.jvm.internal.impl.types.m0 r5 = (kotlin.reflect.jvm.internal.impl.types.m0) r5
            if (r5 == r1) goto L4e
            java.lang.String r6 = "lower"
            kotlin.jvm.internal.f0.o(r5, r6)
            java.lang.String r6 = "upper"
            kotlin.jvm.internal.f0.o(r1, r6)
            java.lang.Object r5 = r9.invoke(r5, r1)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L4e
            r5 = 1
            goto L4f
        L4e:
            r5 = 0
        L4f:
            if (r5 == 0) goto L28
        L51:
            if (r3 == 0) goto Le
            r8.remove()
            goto Le
        L57:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.checker.w.b(java.util.Collection, d2.p):java.util.Collection");
    }

    private final m0 d(Set<? extends m0> set) {
        Object Q4;
        Object Q42;
        if (set.size() == 1) {
            Q42 = kotlin.collections.f0.Q4(set);
            return (m0) Q42;
        }
        new b(set);
        Collection<m0> b4 = b(set, new c(this));
        b4.isEmpty();
        m0 b5 = kotlin.reflect.jvm.internal.impl.resolve.constants.n.f57838f.b(b4);
        if (b5 == null) {
            Collection<m0> b6 = b(b4, new d(l.f58296b.a()));
            b6.isEmpty();
            if (b6.size() < 2) {
                Q4 = kotlin.collections.f0.Q4(b6);
                return (m0) Q4;
            }
            return new d0(set).e();
        }
        return b5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(e0 e0Var, e0 e0Var2) {
        m a4 = l.f58296b.a();
        return a4.d(e0Var, e0Var2) && !a4.d(e0Var2, e0Var);
    }

    @NotNull
    public final m0 c(@NotNull List<? extends m0> types) {
        int Z;
        f0.p(types, "types");
        types.size();
        ArrayList<l1> arrayList = new ArrayList();
        for (m0 m0Var : types) {
            if (m0Var.H0() instanceof d0) {
                Collection<e0> j4 = m0Var.H0().j();
                f0.o(j4, "type.constructor.supertypes");
                Z = kotlin.collections.y.Z(j4, 10);
                ArrayList arrayList2 = new ArrayList(Z);
                for (e0 it : j4) {
                    f0.o(it, "it");
                    m0 d4 = b0.d(it);
                    if (m0Var.I0()) {
                        d4 = d4.O0(true);
                    }
                    arrayList2.add(d4);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(m0Var);
            }
        }
        a aVar = a.f58310a;
        for (l1 l1Var : arrayList) {
            aVar = aVar.b(l1Var);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            m0 m0Var2 = (m0) it2.next();
            if (aVar == a.f58313d) {
                if (m0Var2 instanceof i) {
                    m0Var2 = p0.k((i) m0Var2);
                }
                m0Var2 = p0.i(m0Var2, false, 1, null);
            }
            linkedHashSet.add(m0Var2);
        }
        return d(linkedHashSet);
    }
}
