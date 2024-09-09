package kotlin.reflect.jvm.internal.impl.renderer;

import d2.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.k1;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.p;
import kotlin.r;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j;
import kotlin.reflect.jvm.internal.impl.descriptors.k;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.n;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.resolve.constants.q;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.l1;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.m1;
import kotlin.reflect.jvm.internal.impl.types.t0;
import kotlin.reflect.jvm.internal.impl.types.v;
import kotlin.reflect.jvm.internal.impl.types.w;
import kotlin.reflect.jvm.internal.impl.types.y0;
import kotlin.text.z;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorRendererImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c extends kotlin.reflect.jvm.internal.impl.renderer.b implements kotlin.reflect.jvm.internal.impl.renderer.d {
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.renderer.e f57746l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final p f57747m;

    /* compiled from: DescriptorRendererImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class a implements m<f1, StringBuilder> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f57748a;

        /* compiled from: DescriptorRendererImpl.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public /* synthetic */ class C1163a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f57749a;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                iArr[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                iArr[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                f57749a = iArr;
            }
        }

        public a(c this$0) {
            f0.p(this$0, "this$0");
            this.f57748a = this$0;
        }

        private final void t(o0 o0Var, StringBuilder sb, String str) {
            int i4 = C1163a.f57749a[this.f57748a.o0().ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    return;
                }
                p(o0Var, sb);
                return;
            }
            this.f57748a.U0(o0Var, sb);
            sb.append(f0.C(str, " for "));
            c cVar = this.f57748a;
            p0 V = o0Var.V();
            f0.o(V, "descriptor.correspondingProperty");
            cVar.B1(V, sb);
        }

        public void A(@NotNull d1 descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            this.f57748a.T1(descriptor, true, builder, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 a(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder sb) {
            n(dVar, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 b(l0 l0Var, StringBuilder sb) {
            s(l0Var, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 c(p0 p0Var, StringBuilder sb) {
            u(p0Var, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 d(z0 z0Var, StringBuilder sb) {
            y(z0Var, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 e(r0 r0Var, StringBuilder sb) {
            w(r0Var, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 f(d1 d1Var, StringBuilder sb) {
            A(d1Var, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 g(q0 q0Var, StringBuilder sb) {
            v(q0Var, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 h(g0 g0Var, StringBuilder sb) {
            r(g0Var, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 i(w wVar, StringBuilder sb) {
            p(wVar, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 j(j jVar, StringBuilder sb) {
            o(jVar, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 k(d0 d0Var, StringBuilder sb) {
            q(d0Var, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 l(s0 s0Var, StringBuilder sb) {
            x(s0Var, sb);
            return f1.f55527a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
        public /* bridge */ /* synthetic */ f1 m(a1 a1Var, StringBuilder sb) {
            z(a1Var, sb);
            return f1.f55527a;
        }

        public void n(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            this.f57748a.a1(descriptor, builder);
        }

        public void o(@NotNull j constructorDescriptor, @NotNull StringBuilder builder) {
            f0.p(constructorDescriptor, "constructorDescriptor");
            f0.p(builder, "builder");
            this.f57748a.f1(constructorDescriptor, builder);
        }

        public void p(@NotNull w descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            this.f57748a.j1(descriptor, builder);
        }

        public void q(@NotNull d0 descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            this.f57748a.t1(descriptor, builder, true);
        }

        public void r(@NotNull g0 descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            this.f57748a.x1(descriptor, builder);
        }

        public void s(@NotNull l0 descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            this.f57748a.z1(descriptor, builder);
        }

        public void u(@NotNull p0 descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            this.f57748a.B1(descriptor, builder);
        }

        public void v(@NotNull q0 descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            t(descriptor, builder, "getter");
        }

        public void w(@NotNull r0 descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            t(descriptor, builder, "setter");
        }

        public void x(@NotNull s0 descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            builder.append(descriptor.getName());
        }

        public void y(@NotNull z0 descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            this.f57748a.J1(descriptor, builder);
        }

        public void z(@NotNull a1 descriptor, @NotNull StringBuilder builder) {
            f0.p(descriptor, "descriptor");
            f0.p(builder, "builder");
            this.f57748a.O1(descriptor, builder, true);
        }
    }

    /* compiled from: DescriptorRendererImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57750a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f57751b;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            iArr[RenderingFormat.HTML.ordinal()] = 2;
            f57750a = iArr;
            int[] iArr2 = new int[ParameterNameRenderingPolicy.values().length];
            iArr2[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            iArr2[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            iArr2[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            f57751b = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorRendererImpl.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1164c extends Lambda implements l<kotlin.reflect.jvm.internal.impl.types.a1, CharSequence> {
        C1164c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull kotlin.reflect.jvm.internal.impl.types.a1 it) {
            f0.p(it, "it");
            if (it.b()) {
                return "*";
            }
            c cVar = c.this;
            e0 type = it.getType();
            f0.o(type, "it.type");
            String y3 = cVar.y(type);
            if (it.c() == Variance.INVARIANT) {
                return y3;
            }
            return it.c() + ' ' + y3;
        }
    }

    /* compiled from: DescriptorRendererImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.a<c> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DescriptorRendererImpl.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends Lambda implements l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f57754a = new a();

            a() {
                super(1);
            }

            public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
                List l4;
                Set<kotlin.reflect.jvm.internal.impl.name.c> C;
                f0.p(withOptions, "$this$withOptions");
                Set<kotlin.reflect.jvm.internal.impl.name.c> i4 = withOptions.i();
                l4 = x.l(j.a.C);
                C = k1.C(i4, l4);
                withOptions.l(C);
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
                a(dVar);
                return f1.f55527a;
            }
        }

        d() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final c invoke() {
            return (c) c.this.A(a.f57754a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorRendererImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends Lambda implements l<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>, CharSequence> {
        e() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> it) {
            f0.p(it, "it");
            return c.this.e1(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorRendererImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f extends Lambda implements l<d1, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f57756a = new f();

        f() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(d1 d1Var) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorRendererImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g extends Lambda implements l<e0, CharSequence> {
        g() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(e0 it) {
            c cVar = c.this;
            f0.o(it, "it");
            return cVar.y(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorRendererImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class h extends Lambda implements l<e0, Object> {

        /* renamed from: a  reason: collision with root package name */
        public static final h f57758a = new h();

        h() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Object invoke(@NotNull e0 it) {
            f0.p(it, "it");
            return it instanceof t0 ? ((t0) it).Q0() : it;
        }
    }

    public c(@NotNull kotlin.reflect.jvm.internal.impl.renderer.e options) {
        p a4;
        f0.p(options, "options");
        this.f57746l = options;
        options.m0();
        a4 = r.a(new d());
        this.f57747m = a4;
    }

    private final void A1(StringBuilder sb, n0 n0Var) {
        StringBuilder sb2;
        n0 c4 = n0Var.c();
        if (c4 == null) {
            sb2 = null;
        } else {
            A1(sb, c4);
            sb.append('.');
            kotlin.reflect.jvm.internal.impl.name.f name = n0Var.b().getName();
            f0.o(name, "possiblyInnerType.classifierDescriptor.name");
            sb.append(x(name, false));
            sb2 = sb;
        }
        if (sb2 == null) {
            y0 j4 = n0Var.b().j();
            f0.o(j4, "possiblyInnerType.classi\u2026escriptor.typeConstructor");
            sb.append(L1(j4));
        }
        sb.append(K1(n0Var.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(p0 p0Var, StringBuilder sb) {
        if (!B0()) {
            if (!A0()) {
                C1(p0Var, sb);
                s visibility = p0Var.getVisibility();
                f0.o(visibility, "property.visibility");
                W1(visibility, sb);
                boolean z3 = false;
                s1(sb, h0().contains(DescriptorRendererModifier.CONST) && p0Var.isConst(), "const");
                o1(p0Var, sb);
                r1(p0Var, sb);
                w1(p0Var, sb);
                if (h0().contains(DescriptorRendererModifier.LATEINIT) && p0Var.v0()) {
                    z3 = true;
                }
                s1(sb, z3, "lateinit");
                n1(p0Var, sb);
            }
            S1(this, p0Var, sb, false, 4, null);
            List<a1> typeParameters = p0Var.getTypeParameters();
            f0.o(typeParameters, "property.typeParameters");
            Q1(typeParameters, sb, true);
            D1(p0Var, sb);
        }
        t1(p0Var, sb, true);
        sb.append(": ");
        e0 type = p0Var.getType();
        f0.o(type, "property.type");
        sb.append(y(type));
        E1(p0Var, sb);
        l1(p0Var, sb);
        List<a1> typeParameters2 = p0Var.getTypeParameters();
        f0.o(typeParameters2, "property.typeParameters");
        X1(typeParameters2, sb);
    }

    private final void C1(p0 p0Var, StringBuilder sb) {
        Object S4;
        if (h0().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Y0(this, sb, p0Var, null, 2, null);
            u u02 = p0Var.u0();
            if (u02 != null) {
                X0(sb, u02, AnnotationUseSiteTarget.FIELD);
            }
            u R = p0Var.R();
            if (R != null) {
                X0(sb, R, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (o0() == PropertyAccessorRenderingPolicy.NONE) {
                q0 getter = p0Var.getGetter();
                if (getter != null) {
                    X0(sb, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                r0 setter = p0Var.getSetter();
                if (setter == null) {
                    return;
                }
                X0(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                List<d1> h4 = setter.h();
                f0.o(h4, "setter.valueParameters");
                S4 = kotlin.collections.f0.S4(h4);
                d1 it = (d1) S4;
                f0.o(it, "it");
                X0(sb, it, AnnotationUseSiteTarget.SETTER_PARAMETER);
            }
        }
    }

    private final void D1(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder sb) {
        s0 Q = aVar.Q();
        if (Q != null) {
            X0(sb, Q, AnnotationUseSiteTarget.RECEIVER);
            e0 type = Q.getType();
            f0.o(type, "receiver.type");
            String y3 = y(type);
            if (Z1(type) && !h1.m(type)) {
                y3 = '(' + y3 + ')';
            }
            sb.append(y3);
            sb.append(".");
        }
    }

    private final void E1(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, StringBuilder sb) {
        s0 Q;
        if (p0() && (Q = aVar.Q()) != null) {
            sb.append(" on ");
            e0 type = Q.getType();
            f0.o(type, "receiver.type");
            sb.append(y(type));
        }
    }

    private final void F1(StringBuilder sb, m0 m0Var) {
        if (!f0.g(m0Var, h1.f58383b) && !h1.l(m0Var)) {
            if (kotlin.reflect.jvm.internal.impl.types.w.t(m0Var)) {
                if (E0()) {
                    String fVar = ((w.f) m0Var.H0()).e().getName().toString();
                    f0.o(fVar, "type.constructor as Unin\u2026escriptor.name.toString()");
                    sb.append(h1(fVar));
                    return;
                }
                sb.append("???");
                return;
            } else if (kotlin.reflect.jvm.internal.impl.types.g0.a(m0Var)) {
                g1(sb, m0Var);
                return;
            } else if (Z1(m0Var)) {
                k1(sb, m0Var);
                return;
            } else {
                g1(sb, m0Var);
                return;
            }
        }
        sb.append("???");
    }

    private final void G1(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    private final void H1(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder sb) {
        if (L0() || kotlin.reflect.jvm.internal.impl.builtins.h.l0(dVar.q())) {
            return;
        }
        Collection<e0> j4 = dVar.j().j();
        f0.o(j4, "klass.typeConstructor.supertypes");
        if (j4.isEmpty()) {
            return;
        }
        if (j4.size() == 1 && kotlin.reflect.jvm.internal.impl.builtins.h.b0(j4.iterator().next())) {
            return;
        }
        G1(sb);
        sb.append(": ");
        kotlin.collections.f0.V2(j4, sb, ", ", null, null, 0, null, new g(), 60, null);
    }

    private final void I1(kotlin.reflect.jvm.internal.impl.descriptors.w wVar, StringBuilder sb) {
        s1(sb, wVar.isSuspend(), "suspend");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(z0 z0Var, StringBuilder sb) {
        Y0(this, sb, z0Var, null, 2, null);
        s visibility = z0Var.getVisibility();
        f0.o(visibility, "typeAlias.visibility");
        W1(visibility, sb);
        o1(z0Var, sb);
        sb.append(m1("typealias"));
        sb.append(" ");
        t1(z0Var, sb, true);
        List<a1> r3 = z0Var.r();
        f0.o(r3, "typeAlias.declaredTypeParameters");
        Q1(r3, sb, false);
        Z0(z0Var, sb);
        sb.append(" = ");
        sb.append(y(z0Var.r0()));
    }

    private final void M1(StringBuilder sb, e0 e0Var, y0 y0Var) {
        n0 a4 = b1.a(e0Var);
        if (a4 == null) {
            sb.append(L1(y0Var));
            sb.append(K1(e0Var.G0()));
            return;
        }
        A1(sb, a4);
    }

    private final void N(StringBuilder sb, k kVar) {
        k b4;
        String name;
        if ((kVar instanceof g0) || (kVar instanceof l0) || (b4 = kVar.b()) == null || (b4 instanceof d0)) {
            return;
        }
        sb.append(" ");
        sb.append(p1("defined in"));
        sb.append(" ");
        kotlin.reflect.jvm.internal.impl.name.d m4 = kotlin.reflect.jvm.internal.impl.resolve.d.m(b4);
        f0.o(m4, "getFqName(containingDeclaration)");
        sb.append(m4.e() ? "root package" : w(m4));
        if (J0() && (b4 instanceof g0) && (kVar instanceof n) && (name = ((n) kVar).getSource().b().getName()) != null) {
            sb.append(" ");
            sb.append(p1("in file"));
            sb.append(" ");
            sb.append(name);
        }
    }

    private final String N0() {
        return R(">");
    }

    static /* synthetic */ void N1(c cVar, StringBuilder sb, e0 e0Var, y0 y0Var, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            y0Var = e0Var.H0();
        }
        cVar.M1(sb, e0Var, y0Var);
    }

    private final void O(StringBuilder sb, List<? extends kotlin.reflect.jvm.internal.impl.types.a1> list) {
        kotlin.collections.f0.V2(list, sb, ", ", null, null, 0, null, new C1164c(), 60, null);
    }

    private final boolean O0(e0 e0Var) {
        return kotlin.reflect.jvm.internal.impl.builtins.g.o(e0Var) || !e0Var.getAnnotations().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(a1 a1Var, StringBuilder sb, boolean z3) {
        if (z3) {
            sb.append(R0());
        }
        if (H0()) {
            sb.append("/*");
            sb.append(a1Var.f());
            sb.append("*/ ");
        }
        s1(sb, a1Var.l(), "reified");
        String label = a1Var.o().getLabel();
        boolean z4 = true;
        s1(sb, label.length() > 0, label);
        Y0(this, sb, a1Var, null, 2, null);
        t1(a1Var, sb, z3);
        int size = a1Var.getUpperBounds().size();
        if ((size > 1 && !z3) || size == 1) {
            e0 upperBound = a1Var.getUpperBounds().iterator().next();
            if (!kotlin.reflect.jvm.internal.impl.builtins.h.h0(upperBound)) {
                sb.append(" : ");
                f0.o(upperBound, "upperBound");
                sb.append(y(upperBound));
            }
        } else if (z3) {
            for (e0 upperBound2 : a1Var.getUpperBounds()) {
                if (!kotlin.reflect.jvm.internal.impl.builtins.h.h0(upperBound2)) {
                    if (z4) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    f0.o(upperBound2, "upperBound");
                    sb.append(y(upperBound2));
                    z4 = false;
                }
            }
        }
        if (z3) {
            sb.append(N0());
        }
    }

    private final String P() {
        int i4 = b.f57750a[C0().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return "&rarr;";
            }
            throw new NoWhenBranchMatchedException();
        }
        return R("->");
    }

    private final Modality P0(a0 a0Var) {
        if (a0Var instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.d) a0Var).i() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        k b4 = a0Var.b();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
        if (dVar != null && (a0Var instanceof CallableMemberDescriptor)) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) a0Var;
            Collection<? extends CallableMemberDescriptor> d4 = callableMemberDescriptor.d();
            f0.o(d4, "this.overriddenDescriptors");
            if (!(!d4.isEmpty()) || dVar.s() == Modality.FINAL) {
                if (dVar.i() == ClassKind.INTERFACE && !f0.g(callableMemberDescriptor.getVisibility(), kotlin.reflect.jvm.internal.impl.descriptors.r.f56527a)) {
                    Modality s3 = callableMemberDescriptor.s();
                    Modality modality = Modality.ABSTRACT;
                    return s3 == modality ? modality : Modality.OPEN;
                }
                return Modality.FINAL;
            }
            return Modality.OPEN;
        }
        return Modality.FINAL;
    }

    private final void P1(StringBuilder sb, List<? extends a1> list) {
        Iterator<? extends a1> it = list.iterator();
        while (it.hasNext()) {
            O1(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    private final boolean Q(String str, String str2) {
        String k22;
        boolean J1;
        k22 = kotlin.text.w.k2(str2, "?", "", false, 4, null);
        if (!f0.g(str, k22)) {
            J1 = kotlin.text.w.J1(str2, "?", false, 2, null);
            if (!J1 || !f0.g(f0.C(str, "?"), str2)) {
                if (!f0.g('(' + str + ")?", str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private final boolean Q0(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        return f0.g(cVar.e(), j.a.D);
    }

    private final void Q1(List<? extends a1> list, StringBuilder sb, boolean z3) {
        if (!M0() && (!list.isEmpty())) {
            sb.append(R0());
            P1(sb, list);
            sb.append(N0());
            if (z3) {
                sb.append(" ");
            }
        }
    }

    private final String R(String str) {
        return C0().escape(str);
    }

    private final String R0() {
        return R("<");
    }

    private final void R1(kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, StringBuilder sb, boolean z3) {
        if (z3 || !(f1Var instanceof d1)) {
            sb.append(m1(f1Var.O() ? "var" : "val"));
            sb.append(" ");
        }
    }

    private final boolean S0(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.d().isEmpty();
    }

    static /* synthetic */ void S1(c cVar, kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, StringBuilder sb, boolean z3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z3 = false;
        }
        cVar.R1(f1Var, sb, z3);
    }

    private final void T0(StringBuilder sb, kotlin.reflect.jvm.internal.impl.types.a aVar) {
        RenderingFormat C0 = C0();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (C0 == renderingFormat) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        v1(sb, aVar.I());
        sb.append(" */");
        if (C0() == renderingFormat) {
            sb.append("</i></font>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008e, code lost:
        if ((j() ? r10.x0() : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.a(r10)) != false) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void T1(kotlin.reflect.jvm.internal.impl.descriptors.d1 r10, boolean r11, java.lang.StringBuilder r12, boolean r13) {
        /*
            r9 = this;
            if (r13 == 0) goto L10
            java.lang.String r0 = "value-parameter"
            java.lang.String r0 = r9.m1(r0)
            r12.append(r0)
            java.lang.String r0 = " "
            r12.append(r0)
        L10:
            boolean r0 = r9.H0()
            if (r0 == 0) goto L27
            java.lang.String r0 = "/*"
            r12.append(r0)
            int r0 = r10.f()
            r12.append(r0)
        */
        //  java.lang.String r0 = "*/ "
        /*
            r12.append(r0)
        L27:
            r4 = 0
            r5 = 2
            r6 = 0
            r1 = r9
            r2 = r12
            r3 = r10
            Y0(r1, r2, r3, r4, r5, r6)
            boolean r0 = r10.p0()
            java.lang.String r1 = "crossinline"
            r9.s1(r12, r0, r1)
            boolean r0 = r10.n0()
            java.lang.String r1 = "noinline"
            r9.s1(r12, r0, r1)
            boolean r0 = r9.w0()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L65
            kotlin.reflect.jvm.internal.impl.descriptors.a r0 = r10.b()
            boolean r3 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.c
            if (r3 == 0) goto L55
            kotlin.reflect.jvm.internal.impl.descriptors.c r0 = (kotlin.reflect.jvm.internal.impl.descriptors.c) r0
            goto L56
        L55:
            r0 = 0
        L56:
            if (r0 != 0) goto L5a
        L58:
            r0 = 0
            goto L61
        L5a:
            boolean r0 = r0.b0()
            if (r0 != r1) goto L58
            r0 = 1
        L61:
            if (r0 == 0) goto L65
            r8 = 1
            goto L66
        L65:
            r8 = 0
        L66:
            if (r8 == 0) goto L71
            boolean r0 = r9.S()
            java.lang.String r3 = "actual"
            r9.s1(r12, r0, r3)
        L71:
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r3.V1(r4, r5, r6, r7, r8)
            d2.l r11 = r9.Y()
            if (r11 == 0) goto L91
            boolean r11 = r9.j()
            if (r11 == 0) goto L8a
            boolean r11 = r10.x0()
            goto L8e
        L8a:
            boolean r11 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.a(r10)
        L8e:
            if (r11 == 0) goto L91
            goto L92
        L91:
            r1 = 0
        L92:
            if (r1 == 0) goto La8
            d2.l r11 = r9.Y()
            kotlin.jvm.internal.f0.m(r11)
            java.lang.Object r10 = r11.invoke(r10)
            java.lang.String r11 = " = "
            java.lang.String r10 = kotlin.jvm.internal.f0.C(r11, r10)
            r12.append(r10)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.c.T1(kotlin.reflect.jvm.internal.impl.descriptors.d1, boolean, java.lang.StringBuilder, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(o0 o0Var, StringBuilder sb) {
        o1(o0Var, sb);
    }

    private final void U1(Collection<? extends d1> collection, boolean z3, StringBuilder sb) {
        boolean a22 = a2(z3);
        int size = collection.size();
        G0().b(size, sb);
        int i4 = 0;
        for (d1 d1Var : collection) {
            G0().a(d1Var, i4, size, sb);
            T1(d1Var, a22, sb, false);
            G0().c(d1Var, i4, size, sb);
            i4++;
        }
        G0().d(size, sb);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void V0(kotlin.reflect.jvm.internal.impl.descriptors.w r6, java.lang.StringBuilder r7) {
        /*
            r5 = this;
            boolean r0 = r6.isOperator()
            java.lang.String r1 = "functionDescriptor.overriddenDescriptors"
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L3a
            java.util.Collection r0 = r6.d()
            kotlin.jvm.internal.f0.o(r0, r1)
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L19
        L17:
            r0 = 1
            goto L30
        L19:
            java.util.Iterator r0 = r0.iterator()
        L1d:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L17
            java.lang.Object r4 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.w r4 = (kotlin.reflect.jvm.internal.impl.descriptors.w) r4
            boolean r4 = r4.isOperator()
            if (r4 == 0) goto L1d
            r0 = 0
        L30:
            if (r0 != 0) goto L38
            boolean r0 = r5.T()
            if (r0 == 0) goto L3a
        L38:
            r0 = 1
            goto L3b
        L3a:
            r0 = 0
        L3b:
            boolean r4 = r6.isInfix()
            if (r4 == 0) goto L70
            java.util.Collection r4 = r6.d()
            kotlin.jvm.internal.f0.o(r4, r1)
            boolean r1 = r4.isEmpty()
            if (r1 == 0) goto L50
        L4e:
            r1 = 1
            goto L67
        L50:
            java.util.Iterator r1 = r4.iterator()
        L54:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L4e
            java.lang.Object r4 = r1.next()
            kotlin.reflect.jvm.internal.impl.descriptors.w r4 = (kotlin.reflect.jvm.internal.impl.descriptors.w) r4
            boolean r4 = r4.isInfix()
            if (r4 == 0) goto L54
            r1 = 0
        L67:
            if (r1 != 0) goto L6f
            boolean r1 = r5.T()
            if (r1 == 0) goto L70
        L6f:
            r2 = 1
        L70:
            boolean r1 = r6.E()
            java.lang.String r3 = "tailrec"
            r5.s1(r7, r1, r3)
            r5.I1(r6, r7)
            boolean r6 = r6.isInline()
            java.lang.String r1 = "inline"
            r5.s1(r7, r6, r1)
            java.lang.String r6 = "infix"
            r5.s1(r7, r2, r6)
            java.lang.String r6 = "operator"
            r5.s1(r7, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.c.V0(kotlin.reflect.jvm.internal.impl.descriptors.w, java.lang.StringBuilder):void");
    }

    private final void V1(kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, boolean z3, StringBuilder sb, boolean z4, boolean z5) {
        e0 type = f1Var.getType();
        f0.o(type, "variable.type");
        d1 d1Var = f1Var instanceof d1 ? (d1) f1Var : null;
        e0 t02 = d1Var != null ? d1Var.t0() : null;
        e0 e0Var = t02 == null ? type : t02;
        s1(sb, t02 != null, "vararg");
        if (z5 || (z4 && !B0())) {
            R1(f1Var, sb, z5);
        }
        if (z3) {
            t1(f1Var, sb, z4);
            sb.append(": ");
        }
        sb.append(y(e0Var));
        l1(f1Var, sb);
        if (!H0() || t02 == null) {
            return;
        }
        sb.append(" /*");
        sb.append(y(type));
        sb.append("*/");
    }

    private final List<String> W0(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        int Z;
        int Z2;
        List o4;
        List<String> b5;
        kotlin.reflect.jvm.internal.impl.descriptors.c F;
        int Z3;
        Map<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> a4 = cVar.a();
        List list = null;
        kotlin.reflect.jvm.internal.impl.descriptors.d f4 = t0() ? kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(cVar) : null;
        if (f4 != null && (F = f4.F()) != null) {
            List<d1> valueParameters = F.h();
            f0.o(valueParameters, "valueParameters");
            ArrayList<d1> arrayList = new ArrayList();
            for (Object obj : valueParameters) {
                if (((d1) obj).x0()) {
                    arrayList.add(obj);
                }
            }
            Z3 = y.Z(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(Z3);
            for (d1 d1Var : arrayList) {
                arrayList2.add(d1Var.getName());
            }
            list = arrayList2;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.F();
        }
        ArrayList<kotlin.reflect.jvm.internal.impl.name.f> arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            kotlin.reflect.jvm.internal.impl.name.f it = (kotlin.reflect.jvm.internal.impl.name.f) obj2;
            f0.o(it, "it");
            if (!a4.containsKey(it)) {
                arrayList3.add(obj2);
            }
        }
        Z = y.Z(arrayList3, 10);
        ArrayList arrayList4 = new ArrayList(Z);
        for (kotlin.reflect.jvm.internal.impl.name.f fVar : arrayList3) {
            arrayList4.add(f0.C(fVar.b(), " = ..."));
        }
        Set<Map.Entry<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> entrySet = a4.entrySet();
        Z2 = y.Z(entrySet, 10);
        ArrayList arrayList5 = new ArrayList(Z2);
        Iterator<T> it2 = entrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            kotlin.reflect.jvm.internal.impl.name.f fVar2 = (kotlin.reflect.jvm.internal.impl.name.f) entry.getKey();
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar = (kotlin.reflect.jvm.internal.impl.resolve.constants.g) entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(fVar2.b());
            sb.append(" = ");
            sb.append(!list.contains(fVar2) ? e1(gVar) : "...");
            arrayList5.add(sb.toString());
        }
        o4 = kotlin.collections.f0.o4(arrayList4, arrayList5);
        b5 = kotlin.collections.f0.b5(o4);
        return b5;
    }

    private final boolean W1(s sVar, StringBuilder sb) {
        if (h0().contains(DescriptorRendererModifier.VISIBILITY)) {
            if (i0()) {
                sVar = sVar.f();
            }
            if (v0() || !f0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f56538l)) {
                sb.append(m1(sVar.c()));
                sb.append(" ");
                return true;
            }
            return false;
        }
        return false;
    }

    private final void X0(StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, AnnotationUseSiteTarget annotationUseSiteTarget) {
        boolean H1;
        if (h0().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Set<kotlin.reflect.jvm.internal.impl.name.c> i4 = aVar instanceof e0 ? i() : a0();
            l<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> U = U();
            for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : aVar.getAnnotations()) {
                H1 = kotlin.collections.f0.H1(i4, cVar.e());
                if (!H1 && !Q0(cVar) && (U == null || U.invoke(cVar).booleanValue())) {
                    sb.append(t(cVar, annotationUseSiteTarget));
                    if (Z()) {
                        sb.append('\n');
                        f0.o(sb, "append('\\n')");
                    } else {
                        sb.append(" ");
                    }
                }
            }
        }
    }

    private final void X1(List<? extends a1> list, StringBuilder sb) {
        List<e0> N1;
        if (M0()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (a1 a1Var : list) {
            List<e0> upperBounds = a1Var.getUpperBounds();
            f0.o(upperBounds, "typeParameter.upperBounds");
            N1 = kotlin.collections.f0.N1(upperBounds, 1);
            for (e0 it : N1) {
                StringBuilder sb2 = new StringBuilder();
                kotlin.reflect.jvm.internal.impl.name.f name = a1Var.getName();
                f0.o(name, "typeParameter.name");
                sb2.append(x(name, false));
                sb2.append(" : ");
                f0.o(it, "it");
                sb2.append(y(it));
                arrayList.add(sb2.toString());
            }
        }
        if (!arrayList.isEmpty()) {
            sb.append(" ");
            sb.append(m1("where"));
            sb.append(" ");
            kotlin.collections.f0.V2(arrayList, sb, ", ", null, null, 0, null, null, 124, null);
        }
    }

    static /* synthetic */ void Y0(c cVar, StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, AnnotationUseSiteTarget annotationUseSiteTarget, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        cVar.X0(sb, aVar, annotationUseSiteTarget);
    }

    private final String Y1(String str, String str2, String str3, String str4, String str5) {
        boolean u22;
        boolean u23;
        u22 = kotlin.text.w.u2(str, str2, false, 2, null);
        if (u22) {
            u23 = kotlin.text.w.u2(str3, str4, false, 2, null);
            if (u23) {
                String substring = str.substring(str2.length());
                f0.o(substring, "this as java.lang.String).substring(startIndex)");
                String substring2 = str3.substring(str4.length());
                f0.o(substring2, "this as java.lang.String).substring(startIndex)");
                String C = f0.C(str5, substring);
                if (f0.g(substring, substring2)) {
                    return C;
                }
                if (Q(substring, substring2)) {
                    return f0.C(C, "!");
                }
            }
        }
        return null;
    }

    private final void Z0(kotlin.reflect.jvm.internal.impl.descriptors.g gVar, StringBuilder sb) {
        List<a1> r3 = gVar.r();
        f0.o(r3, "classifier.declaredTypeParameters");
        List<a1> parameters = gVar.j().getParameters();
        f0.o(parameters, "classifier.typeConstructor.parameters");
        if (H0() && gVar.n() && parameters.size() > r3.size()) {
            sb.append(" /*captured type parameters: ");
            P1(sb, parameters.subList(r3.size(), parameters.size()));
            sb.append("*/");
        }
    }

    private final boolean Z1(e0 e0Var) {
        boolean z3;
        if (kotlin.reflect.jvm.internal.impl.builtins.g.m(e0Var)) {
            List<kotlin.reflect.jvm.internal.impl.types.a1> G0 = e0Var.G0();
            if (!(G0 instanceof Collection) || !G0.isEmpty()) {
                for (kotlin.reflect.jvm.internal.impl.types.a1 a1Var : G0) {
                    if (a1Var.b()) {
                        z3 = false;
                        break;
                    }
                }
            }
            z3 = true;
            return z3;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder sb) {
        kotlin.reflect.jvm.internal.impl.descriptors.c F;
        boolean z3 = dVar.i() == ClassKind.ENUM_ENTRY;
        if (!B0()) {
            Y0(this, sb, dVar, null, 2, null);
            if (!z3) {
                s visibility = dVar.getVisibility();
                f0.o(visibility, "klass.visibility");
                W1(visibility, sb);
            }
            if ((dVar.i() != ClassKind.INTERFACE || dVar.s() != Modality.ABSTRACT) && (!dVar.i().isSingleton() || dVar.s() != Modality.FINAL)) {
                Modality s3 = dVar.s();
                f0.o(s3, "klass.modality");
                q1(s3, sb, P0(dVar));
            }
            o1(dVar, sb);
            s1(sb, h0().contains(DescriptorRendererModifier.INNER) && dVar.n(), "inner");
            s1(sb, h0().contains(DescriptorRendererModifier.DATA) && dVar.y(), "data");
            s1(sb, h0().contains(DescriptorRendererModifier.INLINE) && dVar.isInline(), "inline");
            s1(sb, h0().contains(DescriptorRendererModifier.VALUE) && dVar.v(), "value");
            s1(sb, h0().contains(DescriptorRendererModifier.FUN) && dVar.t(), "fun");
            b1(dVar, sb);
        }
        if (!kotlin.reflect.jvm.internal.impl.resolve.d.x(dVar)) {
            if (!B0()) {
                G1(sb);
            }
            t1(dVar, sb, true);
        } else {
            d1(dVar, sb);
        }
        if (z3) {
            return;
        }
        List<a1> r3 = dVar.r();
        f0.o(r3, "klass.declaredTypeParameters");
        Q1(r3, sb, false);
        Z0(dVar, sb);
        if (!dVar.i().isSingleton() && W() && (F = dVar.F()) != null) {
            sb.append(" ");
            Y0(this, sb, F, null, 2, null);
            s visibility2 = F.getVisibility();
            f0.o(visibility2, "primaryConstructor.visibility");
            W1(visibility2, sb);
            sb.append(m1("constructor"));
            List<d1> h4 = F.h();
            f0.o(h4, "primaryConstructor.valueParameters");
            U1(h4, F.e0(), sb);
        }
        H1(dVar, sb);
        X1(r3, sb);
    }

    private final boolean a2(boolean z3) {
        int i4 = b.f57751b[l0().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 == 3) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            } else if (z3) {
                return false;
            }
        }
        return true;
    }

    private final c b0() {
        return (c) this.f57747m.getValue();
    }

    private final void b1(kotlin.reflect.jvm.internal.impl.descriptors.d dVar, StringBuilder sb) {
        sb.append(m1(kotlin.reflect.jvm.internal.impl.renderer.b.f57723a.a(dVar)));
    }

    private final void d1(k kVar, StringBuilder sb) {
        if (q0()) {
            if (B0()) {
                sb.append("companion object");
            }
            G1(sb);
            k b4 = kVar.b();
            if (b4 != null) {
                sb.append("of ");
                kotlin.reflect.jvm.internal.impl.name.f name = b4.getName();
                f0.o(name, "containingDeclaration.name");
                sb.append(x(name, false));
            }
        }
        if (H0() || !f0.g(kVar.getName(), kotlin.reflect.jvm.internal.impl.name.h.f57580d)) {
            if (!B0()) {
                G1(sb);
            }
            kotlin.reflect.jvm.internal.impl.name.f name2 = kVar.getName();
            f0.o(name2, "descriptor.name");
            sb.append(x(name2, true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e1(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar) {
        String c4;
        String X2;
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) {
            X2 = kotlin.collections.f0.X2(((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar).a(), ", ", "{", "}", 0, null, new e(), 24, null);
            return X2;
        } else if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a) {
            c4 = kotlin.text.x.c4(kotlin.reflect.jvm.internal.impl.renderer.b.u(this, ((kotlin.reflect.jvm.internal.impl.resolve.constants.a) gVar).a(), null, 2, null), "@");
            return c4;
        } else if (gVar instanceof q) {
            q.b a4 = ((q) gVar).a();
            if (a4 instanceof q.b.a) {
                return ((q.b.a) a4).getType() + "::class";
            } else if (a4 instanceof q.b.C1167b) {
                q.b.C1167b c1167b = (q.b.C1167b) a4;
                String b4 = c1167b.b().b().b();
                f0.o(b4, "classValue.classId.asSingleFqName().asString()");
                int i4 = 0;
                while (i4 < c1167b.a()) {
                    i4++;
                    b4 = "kotlin.Array<" + b4 + '>';
                }
                return f0.C(b4, "::class");
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            return gVar.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f1(kotlin.reflect.jvm.internal.impl.descriptors.j r18, java.lang.StringBuilder r19) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.c.f1(kotlin.reflect.jvm.internal.impl.descriptors.j, java.lang.StringBuilder):void");
    }

    private final void g1(StringBuilder sb, e0 e0Var) {
        Y0(this, sb, e0Var, null, 2, null);
        kotlin.reflect.jvm.internal.impl.types.n nVar = e0Var instanceof kotlin.reflect.jvm.internal.impl.types.n ? (kotlin.reflect.jvm.internal.impl.types.n) e0Var : null;
        m0 T0 = nVar != null ? nVar.T0() : null;
        if (kotlin.reflect.jvm.internal.impl.types.g0.a(e0Var)) {
            if ((e0Var instanceof kotlin.reflect.jvm.internal.impl.types.k1) && n0()) {
                sb.append(((kotlin.reflect.jvm.internal.impl.types.k1) e0Var).Q0());
            } else if ((e0Var instanceof v) && !g0()) {
                sb.append(((v) e0Var).Q0());
            } else {
                sb.append(e0Var.H0().toString());
            }
            sb.append(K1(e0Var.G0()));
        } else if (e0Var instanceof t0) {
            sb.append(((t0) e0Var).Q0().toString());
        } else if (T0 instanceof t0) {
            sb.append(((t0) T0).Q0().toString());
        } else {
            N1(this, sb, e0Var, null, 2, null);
        }
        if (e0Var.I0()) {
            sb.append("?");
        }
        if (kotlin.reflect.jvm.internal.impl.types.p0.c(e0Var)) {
            sb.append(" & Any");
        }
    }

    private final String h1(String str) {
        int i4 = b.f57750a[C0().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return "<font color=red><b>" + str + "</b></font>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final String i1(List<kotlin.reflect.jvm.internal.impl.name.f> list) {
        return R(kotlin.reflect.jvm.internal.impl.renderer.h.c(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(kotlin.reflect.jvm.internal.impl.descriptors.w wVar, StringBuilder sb) {
        if (!B0()) {
            if (!A0()) {
                Y0(this, sb, wVar, null, 2, null);
                s visibility = wVar.getVisibility();
                f0.o(visibility, "function.visibility");
                W1(visibility, sb);
                r1(wVar, sb);
                if (c0()) {
                    o1(wVar, sb);
                }
                w1(wVar, sb);
                if (c0()) {
                    V0(wVar, sb);
                } else {
                    I1(wVar, sb);
                }
                n1(wVar, sb);
                if (H0()) {
                    if (wVar.z0()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (wVar.B0()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(m1("fun"));
            sb.append(" ");
            List<a1> typeParameters = wVar.getTypeParameters();
            f0.o(typeParameters, "function.typeParameters");
            Q1(typeParameters, sb, true);
            D1(wVar, sb);
        }
        t1(wVar, sb, true);
        List<d1> h4 = wVar.h();
        f0.o(h4, "function.valueParameters");
        U1(h4, wVar.e0(), sb);
        E1(wVar, sb);
        e0 returnType = wVar.getReturnType();
        if (!K0() && (F0() || returnType == null || !kotlin.reflect.jvm.internal.impl.builtins.h.A0(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : y(returnType));
        }
        List<a1> typeParameters2 = wVar.getTypeParameters();
        f0.o(typeParameters2, "function.typeParameters");
        X1(typeParameters2, sb);
    }

    private final void k1(StringBuilder sb, e0 e0Var) {
        kotlin.reflect.jvm.internal.impl.name.f fVar;
        char n7;
        int i32;
        int i33;
        int length = sb.length();
        Y0(b0(), sb, e0Var, null, 2, null);
        boolean z3 = true;
        boolean z4 = sb.length() != length;
        boolean o4 = kotlin.reflect.jvm.internal.impl.builtins.g.o(e0Var);
        boolean I0 = e0Var.I0();
        e0 h4 = kotlin.reflect.jvm.internal.impl.builtins.g.h(e0Var);
        boolean z5 = I0 || (z4 && h4 != null);
        if (z5) {
            if (o4) {
                sb.insert(length, '(');
            } else {
                if (z4) {
                    n7 = z.n7(sb);
                    kotlin.text.b.r(n7);
                    i32 = kotlin.text.x.i3(sb);
                    if (sb.charAt(i32 - 1) != ')') {
                        i33 = kotlin.text.x.i3(sb);
                        sb.insert(i33, "()");
                    }
                }
                sb.append("(");
            }
        }
        s1(sb, o4, "suspend");
        if (h4 != null) {
            if ((!Z1(h4) || h4.I0()) && !O0(h4)) {
                z3 = false;
            }
            if (z3) {
                sb.append("(");
            }
            u1(sb, h4);
            if (z3) {
                sb.append(")");
            }
            sb.append(".");
        }
        sb.append("(");
        int i4 = 0;
        for (kotlin.reflect.jvm.internal.impl.types.a1 a1Var : kotlin.reflect.jvm.internal.impl.builtins.g.j(e0Var)) {
            int i5 = i4 + 1;
            if (i4 > 0) {
                sb.append(", ");
            }
            if (m0()) {
                e0 type = a1Var.getType();
                f0.o(type, "typeProjection.type");
                fVar = kotlin.reflect.jvm.internal.impl.builtins.g.c(type);
            } else {
                fVar = null;
            }
            if (fVar != null) {
                sb.append(x(fVar, false));
                sb.append(": ");
            }
            sb.append(z(a1Var));
            i4 = i5;
        }
        sb.append(") ");
        sb.append(P());
        sb.append(" ");
        u1(sb, kotlin.reflect.jvm.internal.impl.builtins.g.i(e0Var));
        if (z5) {
            sb.append(")");
        }
        if (I0) {
            sb.append("?");
        }
    }

    private final void l1(kotlin.reflect.jvm.internal.impl.descriptors.f1 f1Var, StringBuilder sb) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> m02;
        if (!f0() || (m02 = f1Var.m0()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(R(e1(m02)));
    }

    private final String m1(String str) {
        int i4 = b.f57750a[C0().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                if (V()) {
                    return str;
                }
                return "<b>" + str + "</b>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final void n1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (h0().contains(DescriptorRendererModifier.MEMBER_KIND) && H0() && callableMemberDescriptor.i() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb.append("/*");
            sb.append(s2.a.f(callableMemberDescriptor.i().name()));
            sb.append("*/ ");
        }
    }

    private final void o1(a0 a0Var, StringBuilder sb) {
        s1(sb, a0Var.isExternal(), "external");
        boolean z3 = true;
        s1(sb, h0().contains(DescriptorRendererModifier.EXPECT) && a0Var.i0(), "expect");
        s1(sb, (h0().contains(DescriptorRendererModifier.ACTUAL) && a0Var.X()) ? false : false, "actual");
    }

    private final void q1(Modality modality, StringBuilder sb, Modality modality2) {
        if (u0() || modality != modality2) {
            s1(sb, h0().contains(DescriptorRendererModifier.MODALITY), s2.a.f(modality.name()));
        }
    }

    private final void r1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (kotlin.reflect.jvm.internal.impl.resolve.d.J(callableMemberDescriptor) && callableMemberDescriptor.s() == Modality.FINAL) {
            return;
        }
        if (k0() == OverrideRenderingPolicy.RENDER_OVERRIDE && callableMemberDescriptor.s() == Modality.OPEN && S0(callableMemberDescriptor)) {
            return;
        }
        Modality s3 = callableMemberDescriptor.s();
        f0.o(s3, "callable.modality");
        q1(s3, sb, P0(callableMemberDescriptor));
    }

    private final void s1(StringBuilder sb, boolean z3, String str) {
        if (z3) {
            sb.append(m1(str));
            sb.append(" ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(k kVar, StringBuilder sb, boolean z3) {
        kotlin.reflect.jvm.internal.impl.name.f name = kVar.getName();
        f0.o(name, "descriptor.name");
        sb.append(x(name, z3));
    }

    private final void u1(StringBuilder sb, e0 e0Var) {
        l1 K0 = e0Var.K0();
        kotlin.reflect.jvm.internal.impl.types.a aVar = K0 instanceof kotlin.reflect.jvm.internal.impl.types.a ? (kotlin.reflect.jvm.internal.impl.types.a) K0 : null;
        if (aVar != null) {
            if (x0()) {
                v1(sb, aVar.I());
                return;
            }
            v1(sb, aVar.T0());
            if (y0()) {
                T0(sb, aVar);
                return;
            }
            return;
        }
        v1(sb, e0Var);
    }

    private final void v1(StringBuilder sb, e0 e0Var) {
        if ((e0Var instanceof m1) && j() && !((m1) e0Var).M0()) {
            sb.append("<Not computed yet>");
            return;
        }
        l1 K0 = e0Var.K0();
        if (K0 instanceof kotlin.reflect.jvm.internal.impl.types.y) {
            sb.append(((kotlin.reflect.jvm.internal.impl.types.y) K0).R0(this, this));
        } else if (K0 instanceof m0) {
            F1(sb, (m0) K0);
        }
    }

    private final void w1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (h0().contains(DescriptorRendererModifier.OVERRIDE) && S0(callableMemberDescriptor) && k0() != OverrideRenderingPolicy.RENDER_OPEN) {
            s1(sb, true, "override");
            if (H0()) {
                sb.append("/*");
                sb.append(callableMemberDescriptor.d().size());
                sb.append("*/ ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(g0 g0Var, StringBuilder sb) {
        y1(g0Var.e(), "package-fragment", sb);
        if (j()) {
            sb.append(" in ");
            t1(g0Var.b(), sb, false);
        }
    }

    private final void y1(kotlin.reflect.jvm.internal.impl.name.c cVar, String str, StringBuilder sb) {
        sb.append(m1(str));
        kotlin.reflect.jvm.internal.impl.name.d j4 = cVar.j();
        f0.o(j4, "fqName.toUnsafe()");
        String w3 = w(j4);
        if (w3.length() > 0) {
            sb.append(" ");
            sb.append(w3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(l0 l0Var, StringBuilder sb) {
        y1(l0Var.e(), "package", sb);
        if (j()) {
            sb.append(" in context of ");
            t1(l0Var.y0(), sb, false);
        }
    }

    public boolean A0() {
        return this.f57746l.Z();
    }

    public boolean B0() {
        return this.f57746l.a0();
    }

    @NotNull
    public RenderingFormat C0() {
        return this.f57746l.b0();
    }

    @NotNull
    public l<e0, e0> D0() {
        return this.f57746l.c0();
    }

    public boolean E0() {
        return this.f57746l.d0();
    }

    public boolean F0() {
        return this.f57746l.e0();
    }

    @NotNull
    public b.l G0() {
        return this.f57746l.f0();
    }

    public boolean H0() {
        return this.f57746l.g0();
    }

    public boolean I0() {
        return this.f57746l.h0();
    }

    public boolean J0() {
        return this.f57746l.i0();
    }

    public boolean K0() {
        return this.f57746l.j0();
    }

    @NotNull
    public String K1(@NotNull List<? extends kotlin.reflect.jvm.internal.impl.types.a1> typeArguments) {
        f0.p(typeArguments, "typeArguments");
        if (typeArguments.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(R0());
        O(sb, typeArguments);
        sb.append(N0());
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean L0() {
        return this.f57746l.k0();
    }

    @NotNull
    public String L1(@NotNull y0 typeConstructor) {
        f0.p(typeConstructor, "typeConstructor");
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = typeConstructor.b();
        if (b4 instanceof a1 ? true : b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? true : b4 instanceof z0) {
            return c1(b4);
        }
        if (b4 == null) {
            if (typeConstructor instanceof kotlin.reflect.jvm.internal.impl.types.d0) {
                return ((kotlin.reflect.jvm.internal.impl.types.d0) typeConstructor).g(h.f57758a);
            }
            return typeConstructor.toString();
        }
        throw new IllegalStateException(f0.C("Unexpected classifier: ", b4.getClass()).toString());
    }

    public boolean M0() {
        return this.f57746l.l0();
    }

    public boolean S() {
        return this.f57746l.t();
    }

    public boolean T() {
        return this.f57746l.u();
    }

    @Nullable
    public l<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> U() {
        return this.f57746l.v();
    }

    public boolean V() {
        return this.f57746l.w();
    }

    public boolean W() {
        return this.f57746l.x();
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.renderer.a X() {
        return this.f57746l.y();
    }

    @Nullable
    public l<d1, String> Y() {
        return this.f57746l.z();
    }

    public boolean Z() {
        return this.f57746l.A();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void a(boolean z3) {
        this.f57746l.a(z3);
    }

    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.c> a0() {
        return this.f57746l.B();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void b(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        f0.p(parameterNameRenderingPolicy, "<set-?>");
        this.f57746l.b(parameterNameRenderingPolicy);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void c(boolean z3) {
        this.f57746l.c(z3);
    }

    public boolean c0() {
        return this.f57746l.C();
    }

    @NotNull
    public String c1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f klass) {
        f0.p(klass, "klass");
        if (kotlin.reflect.jvm.internal.impl.types.w.r(klass)) {
            return klass.j().toString();
        }
        return X().a(klass, this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public boolean d() {
        return this.f57746l.d();
    }

    public boolean d0() {
        return this.f57746l.D();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void e(boolean z3) {
        this.f57746l.e(z3);
    }

    public boolean e0() {
        return this.f57746l.E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void f(boolean z3) {
        this.f57746l.f(z3);
    }

    public boolean f0() {
        return this.f57746l.F();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void g(@NotNull RenderingFormat renderingFormat) {
        f0.p(renderingFormat, "<set-?>");
        this.f57746l.g(renderingFormat);
    }

    public boolean g0() {
        return this.f57746l.G();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void h(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        f0.p(annotationArgumentsRenderingPolicy, "<set-?>");
        this.f57746l.h(annotationArgumentsRenderingPolicy);
    }

    @NotNull
    public Set<DescriptorRendererModifier> h0() {
        return this.f57746l.H();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.c> i() {
        return this.f57746l.i();
    }

    public boolean i0() {
        return this.f57746l.I();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public boolean j() {
        return this.f57746l.j();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.renderer.e j0() {
        return this.f57746l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    @NotNull
    public AnnotationArgumentsRenderingPolicy k() {
        return this.f57746l.k();
    }

    @NotNull
    public OverrideRenderingPolicy k0() {
        return this.f57746l.J();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void l(@NotNull Set<kotlin.reflect.jvm.internal.impl.name.c> set) {
        f0.p(set, "<set-?>");
        this.f57746l.l(set);
    }

    @NotNull
    public ParameterNameRenderingPolicy l0() {
        return this.f57746l.K();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void m(@NotNull Set<? extends DescriptorRendererModifier> set) {
        f0.p(set, "<set-?>");
        this.f57746l.m(set);
    }

    public boolean m0() {
        return this.f57746l.L();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void n(boolean z3) {
        this.f57746l.n(z3);
    }

    public boolean n0() {
        return this.f57746l.M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void o(@NotNull kotlin.reflect.jvm.internal.impl.renderer.a aVar) {
        f0.p(aVar, "<set-?>");
        this.f57746l.o(aVar);
    }

    @NotNull
    public PropertyAccessorRenderingPolicy o0() {
        return this.f57746l.N();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void p(boolean z3) {
        this.f57746l.p(z3);
    }

    public boolean p0() {
        return this.f57746l.O();
    }

    @NotNull
    public String p1(@NotNull String message) {
        f0.p(message, "message");
        int i4 = b.f57750a[C0().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return "<i>" + message + "</i>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return message;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void q(boolean z3) {
        this.f57746l.q(z3);
    }

    public boolean q0() {
        return this.f57746l.P();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void r(boolean z3) {
        this.f57746l.r(z3);
    }

    public boolean r0() {
        return this.f57746l.Q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    @NotNull
    public String s(@NotNull k declarationDescriptor) {
        f0.p(declarationDescriptor, "declarationDescriptor");
        StringBuilder sb = new StringBuilder();
        declarationDescriptor.C(new a(this), sb);
        if (I0()) {
            N(sb, declarationDescriptor);
        }
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean s0() {
        return this.f57746l.R();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    @NotNull
    public String t(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotation, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget) {
        f0.p(annotation, "annotation");
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (annotationUseSiteTarget != null) {
            sb.append(f0.C(annotationUseSiteTarget.getRenderName(), ":"));
        }
        e0 type = annotation.getType();
        sb.append(y(type));
        if (d0()) {
            List<String> W0 = W0(annotation);
            if (e0() || (!W0.isEmpty())) {
                kotlin.collections.f0.V2(W0, sb, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (H0() && (kotlin.reflect.jvm.internal.impl.types.g0.a(type) || (type.H0().b() instanceof f0.b))) {
            sb.append(" /* annotation class not found */");
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean t0() {
        return this.f57746l.S();
    }

    public boolean u0() {
        return this.f57746l.T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    @NotNull
    public String v(@NotNull String lowerRendered, @NotNull String upperRendered, @NotNull kotlin.reflect.jvm.internal.impl.builtins.h builtIns) {
        String x5;
        String x52;
        boolean u22;
        kotlin.jvm.internal.f0.p(lowerRendered, "lowerRendered");
        kotlin.jvm.internal.f0.p(upperRendered, "upperRendered");
        kotlin.jvm.internal.f0.p(builtIns, "builtIns");
        if (Q(lowerRendered, upperRendered)) {
            u22 = kotlin.text.w.u2(upperRendered, "(", false, 2, null);
            if (u22) {
                return '(' + lowerRendered + ")!";
            }
            return kotlin.jvm.internal.f0.C(lowerRendered, "!");
        }
        kotlin.reflect.jvm.internal.impl.renderer.a X = X();
        kotlin.reflect.jvm.internal.impl.descriptors.d w3 = builtIns.w();
        kotlin.jvm.internal.f0.o(w3, "builtIns.collection");
        x5 = kotlin.text.x.x5(X.a(w3, this), "Collection", null, 2, null);
        String C = kotlin.jvm.internal.f0.C(x5, "Mutable");
        String Y1 = Y1(lowerRendered, C, upperRendered, x5, x5 + "(Mutable)");
        if (Y1 != null) {
            return Y1;
        }
        String Y12 = Y1(lowerRendered, kotlin.jvm.internal.f0.C(x5, "MutableMap.MutableEntry"), upperRendered, kotlin.jvm.internal.f0.C(x5, "Map.Entry"), kotlin.jvm.internal.f0.C(x5, "(Mutable)Map.(Mutable)Entry"));
        if (Y12 != null) {
            return Y12;
        }
        kotlin.reflect.jvm.internal.impl.renderer.a X2 = X();
        kotlin.reflect.jvm.internal.impl.descriptors.d j4 = builtIns.j();
        kotlin.jvm.internal.f0.o(j4, "builtIns.array");
        x52 = kotlin.text.x.x5(X2.a(j4, this), "Array", null, 2, null);
        String Y13 = Y1(lowerRendered, kotlin.jvm.internal.f0.C(x52, R("Array<")), upperRendered, kotlin.jvm.internal.f0.C(x52, R("Array<out ")), kotlin.jvm.internal.f0.C(x52, R("Array<(out) ")));
        if (Y13 != null) {
            return Y13;
        }
        return '(' + lowerRendered + ".." + upperRendered + ')';
    }

    public boolean v0() {
        return this.f57746l.U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    @NotNull
    public String w(@NotNull kotlin.reflect.jvm.internal.impl.name.d fqName) {
        kotlin.jvm.internal.f0.p(fqName, "fqName");
        List<kotlin.reflect.jvm.internal.impl.name.f> h4 = fqName.h();
        kotlin.jvm.internal.f0.o(h4, "fqName.pathSegments()");
        return i1(h4);
    }

    public boolean w0() {
        return this.f57746l.V();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    @NotNull
    public String x(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, boolean z3) {
        kotlin.jvm.internal.f0.p(name, "name");
        String R = R(kotlin.reflect.jvm.internal.impl.renderer.h.b(name));
        if (V() && C0() == RenderingFormat.HTML && z3) {
            return "<b>" + R + "</b>";
        }
        return R;
    }

    public boolean x0() {
        return this.f57746l.W();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    @NotNull
    public String y(@NotNull e0 type) {
        kotlin.jvm.internal.f0.p(type, "type");
        StringBuilder sb = new StringBuilder();
        u1(sb, D0().invoke(type));
        String sb2 = sb.toString();
        kotlin.jvm.internal.f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean y0() {
        return this.f57746l.X();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.b
    @NotNull
    public String z(@NotNull kotlin.reflect.jvm.internal.impl.types.a1 typeProjection) {
        List<? extends kotlin.reflect.jvm.internal.impl.types.a1> l4;
        kotlin.jvm.internal.f0.p(typeProjection, "typeProjection");
        StringBuilder sb = new StringBuilder();
        l4 = x.l(typeProjection);
        O(sb, l4);
        String sb2 = sb.toString();
        kotlin.jvm.internal.f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean z0() {
        return this.f57746l.Y();
    }
}
