package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.j1;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.renderer.a;
import kotlin.reflect.jvm.internal.impl.types.a1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorRenderer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b {
    @NotNull

    /* renamed from: a */
    public static final k f57723a;
    @JvmField
    @NotNull

    /* renamed from: b */
    public static final b f57724b;
    @JvmField
    @NotNull

    /* renamed from: c */
    public static final b f57725c;
    @JvmField
    @NotNull

    /* renamed from: d */
    public static final b f57726d;
    @JvmField
    @NotNull

    /* renamed from: e */
    public static final b f57727e;
    @JvmField
    @NotNull

    /* renamed from: f */
    public static final b f57728f;
    @JvmField
    @NotNull

    /* renamed from: g */
    public static final b f57729g;
    @JvmField
    @NotNull

    /* renamed from: h */
    public static final b f57730h;
    @JvmField
    @NotNull

    /* renamed from: i */
    public static final b f57731i;
    @JvmField
    @NotNull

    /* renamed from: j */
    public static final b f57732j;
    @JvmField
    @NotNull

    /* renamed from: k */
    public static final b f57733k;

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a */
        public static final a f57734a = new a();

        a() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            Set<? extends DescriptorRendererModifier> k4;
            f0.p(withOptions, "$this$withOptions");
            withOptions.c(false);
            k4 = j1.k();
            withOptions.m(k4);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.b$b */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1162b extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a */
        public static final C1162b f57735a = new C1162b();

        C1162b() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            Set<? extends DescriptorRendererModifier> k4;
            f0.p(withOptions, "$this$withOptions");
            withOptions.c(false);
            k4 = j1.k();
            withOptions.m(k4);
            withOptions.e(true);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a */
        public static final c f57736a = new c();

        c() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            f0.p(withOptions, "$this$withOptions");
            withOptions.c(false);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a */
        public static final d f57737a = new d();

        d() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            Set<? extends DescriptorRendererModifier> k4;
            f0.p(withOptions, "$this$withOptions");
            k4 = j1.k();
            withOptions.m(k4);
            withOptions.o(a.b.f57721a);
            withOptions.b(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a */
        public static final e f57738a = new e();

        e() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            f0.p(withOptions, "$this$withOptions");
            withOptions.p(true);
            withOptions.o(a.C1161a.f57720a);
            withOptions.m(DescriptorRendererModifier.ALL);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class f extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a */
        public static final f f57739a = new f();

        f() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            f0.p(withOptions, "$this$withOptions");
            withOptions.m(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class g extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a */
        public static final g f57740a = new g();

        g() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            f0.p(withOptions, "$this$withOptions");
            withOptions.m(DescriptorRendererModifier.ALL);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class h extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a */
        public static final h f57741a = new h();

        h() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            f0.p(withOptions, "$this$withOptions");
            withOptions.g(RenderingFormat.HTML);
            withOptions.m(DescriptorRendererModifier.ALL);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class i extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a */
        public static final i f57742a = new i();

        i() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            Set<? extends DescriptorRendererModifier> k4;
            f0.p(withOptions, "$this$withOptions");
            withOptions.c(false);
            k4 = j1.k();
            withOptions.m(k4);
            withOptions.o(a.b.f57721a);
            withOptions.r(true);
            withOptions.b(ParameterNameRenderingPolicy.NONE);
            withOptions.f(true);
            withOptions.q(true);
            withOptions.e(true);
            withOptions.a(true);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class j extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.renderer.d, f1> {

        /* renamed from: a */
        public static final j f57743a = new j();

        j() {
            super(1);
        }

        public final void a(@NotNull kotlin.reflect.jvm.internal.impl.renderer.d withOptions) {
            f0.p(withOptions, "$this$withOptions");
            withOptions.o(a.b.f57721a);
            withOptions.b(ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(kotlin.reflect.jvm.internal.impl.renderer.d dVar) {
            a(dVar);
            return f1.f55527a;
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class k {

        /* compiled from: DescriptorRenderer.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public /* synthetic */ class a {

            /* renamed from: a */
            public static final /* synthetic */ int[] f57744a;

            static {
                int[] iArr = new int[ClassKind.values().length];
                iArr[ClassKind.CLASS.ordinal()] = 1;
                iArr[ClassKind.INTERFACE.ordinal()] = 2;
                iArr[ClassKind.ENUM_CLASS.ordinal()] = 3;
                iArr[ClassKind.OBJECT.ordinal()] = 4;
                iArr[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                iArr[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                f57744a = iArr;
            }
        }

        private k() {
        }

        public /* synthetic */ k(u uVar) {
            this();
        }

        @NotNull
        public final String a(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.g classifier) {
            f0.p(classifier, "classifier");
            if (classifier instanceof z0) {
                return "typealias";
            }
            if (classifier instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) classifier;
                if (dVar.a0()) {
                    return "companion object";
                }
                switch (a.f57744a[dVar.i().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            throw new AssertionError(f0.C("Unexpected classifier: ", classifier));
        }

        @NotNull
        public final b b(@NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.renderer.d, f1> changeOptions) {
            f0.p(changeOptions, "changeOptions");
            kotlin.reflect.jvm.internal.impl.renderer.e eVar = new kotlin.reflect.jvm.internal.impl.renderer.e();
            changeOptions.invoke(eVar);
            eVar.n0();
            return new kotlin.reflect.jvm.internal.impl.renderer.c(eVar);
        }
    }

    /* compiled from: DescriptorRenderer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface l {

        /* compiled from: DescriptorRenderer.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a implements l {
            @NotNull

            /* renamed from: a */
            public static final a f57745a = new a();

            private a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.b.l
            public void a(@NotNull d1 parameter, int i4, int i5, @NotNull StringBuilder builder) {
                f0.p(parameter, "parameter");
                f0.p(builder, "builder");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.b.l
            public void b(int i4, @NotNull StringBuilder builder) {
                f0.p(builder, "builder");
                builder.append("(");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.b.l
            public void c(@NotNull d1 parameter, int i4, int i5, @NotNull StringBuilder builder) {
                f0.p(parameter, "parameter");
                f0.p(builder, "builder");
                if (i4 != i5 - 1) {
                    builder.append(", ");
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.b.l
            public void d(int i4, @NotNull StringBuilder builder) {
                f0.p(builder, "builder");
                builder.append(")");
            }
        }

        void a(@NotNull d1 d1Var, int i4, int i5, @NotNull StringBuilder sb);

        void b(int i4, @NotNull StringBuilder sb);

        void c(@NotNull d1 d1Var, int i4, int i5, @NotNull StringBuilder sb);

        void d(int i4, @NotNull StringBuilder sb);
    }

    static {
        k kVar = new k(null);
        f57723a = kVar;
        f57724b = kVar.b(c.f57736a);
        f57725c = kVar.b(a.f57734a);
        f57726d = kVar.b(C1162b.f57735a);
        f57727e = kVar.b(d.f57737a);
        f57728f = kVar.b(i.f57742a);
        f57729g = kVar.b(f.f57739a);
        f57730h = kVar.b(g.f57740a);
        f57731i = kVar.b(j.f57743a);
        f57732j = kVar.b(e.f57738a);
        f57733k = kVar.b(h.f57741a);
    }

    public static /* synthetic */ String u(b bVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, AnnotationUseSiteTarget annotationUseSiteTarget, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 2) != 0) {
                annotationUseSiteTarget = null;
            }
            return bVar.t(cVar, annotationUseSiteTarget);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    @NotNull
    public final b A(@NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.renderer.d, f1> changeOptions) {
        f0.p(changeOptions, "changeOptions");
        kotlin.reflect.jvm.internal.impl.renderer.e s3 = ((kotlin.reflect.jvm.internal.impl.renderer.c) this).j0().s();
        changeOptions.invoke(s3);
        s3.n0();
        return new kotlin.reflect.jvm.internal.impl.renderer.c(s3);
    }

    @NotNull
    public abstract String s(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar);

    @NotNull
    public abstract String t(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, @Nullable AnnotationUseSiteTarget annotationUseSiteTarget);

    @NotNull
    public abstract String v(@NotNull String str, @NotNull String str2, @NotNull kotlin.reflect.jvm.internal.impl.builtins.h hVar);

    @NotNull
    public abstract String w(@NotNull kotlin.reflect.jvm.internal.impl.name.d dVar);

    @NotNull
    public abstract String x(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, boolean z3);

    @NotNull
    public abstract String y(@NotNull e0 e0Var);

    @NotNull
    public abstract String z(@NotNull a1 a1Var);
}
