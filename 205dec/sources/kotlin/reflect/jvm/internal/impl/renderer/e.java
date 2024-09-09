package kotlin.reflect.jvm.internal.impl.renderer;

import com.acse.ottn.f3;
import d2.l;
import java.lang.reflect.Field;
import java.util.Set;
import kotlin.collections.j1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.renderer.a;
import kotlin.reflect.jvm.internal.impl.renderer.b;
import kotlin.reflect.jvm.internal.impl.renderer.d;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.n;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorRendererOptionsImpl.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e implements d {
    static final /* synthetic */ n<Object>[] X = {n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "withDefinedIn", "getWithDefinedIn()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "modifiers", "getModifiers()Ljava/util/Set;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "startFromName", "getStartFromName()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "debugMode", "getDebugMode()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "verbose", "getVerbose()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "unitReturnType", "getUnitReturnType()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "withoutReturnType", "getWithoutReturnType()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "enhancedTypes", "getEnhancedTypes()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "renderDefaultModality", "getRenderDefaultModality()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "receiverAfterName", "getReceiverAfterName()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), n0.k(new MutablePropertyReference1Impl(n0.d(e.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    @NotNull
    private final kotlin.properties.f A;
    @NotNull
    private final kotlin.properties.f B;
    @NotNull
    private final kotlin.properties.f C;
    @NotNull
    private final kotlin.properties.f D;
    @NotNull
    private final kotlin.properties.f E;
    @NotNull
    private final kotlin.properties.f F;
    @NotNull
    private final kotlin.properties.f G;
    @NotNull
    private final kotlin.properties.f H;
    @NotNull
    private final kotlin.properties.f I;
    @NotNull
    private final kotlin.properties.f J;
    @NotNull
    private final kotlin.properties.f K;
    @NotNull

    /* renamed from: L  reason: collision with root package name */
    private final kotlin.properties.f f57759L;
    @NotNull
    private final kotlin.properties.f M;
    @NotNull
    private final kotlin.properties.f N;
    @NotNull
    private final kotlin.properties.f O;
    @NotNull
    private final kotlin.properties.f P;
    @NotNull
    private final kotlin.properties.f Q;
    @NotNull
    private final kotlin.properties.f R;
    @NotNull
    private final kotlin.properties.f S;
    @NotNull
    private final kotlin.properties.f T;
    @NotNull
    private final kotlin.properties.f U;
    @NotNull
    private final kotlin.properties.f V;
    @NotNull
    private final kotlin.properties.f W;

    /* renamed from: a  reason: collision with root package name */
    private boolean f57760a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.properties.f f57761b = o0(a.c.f57722a);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.properties.f f57762c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.properties.f f57763d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.properties.f f57764e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final kotlin.properties.f f57765f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.properties.f f57766g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.properties.f f57767h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final kotlin.properties.f f57768i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final kotlin.properties.f f57769j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.properties.f f57770k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final kotlin.properties.f f57771l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final kotlin.properties.f f57772m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final kotlin.properties.f f57773n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final kotlin.properties.f f57774o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final kotlin.properties.f f57775p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final kotlin.properties.f f57776q;
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    private final kotlin.properties.f f57777r;
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    private final kotlin.properties.f f57778s;
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private final kotlin.properties.f f57779t;
    @NotNull

    /* renamed from: u  reason: collision with root package name */
    private final kotlin.properties.f f57780u;
    @NotNull

    /* renamed from: v  reason: collision with root package name */
    private final kotlin.properties.f f57781v;
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    private final kotlin.properties.f f57782w;
    @NotNull

    /* renamed from: x  reason: collision with root package name */
    private final kotlin.properties.f f57783x;
    @NotNull

    /* renamed from: y  reason: collision with root package name */
    private final kotlin.properties.f f57784y;
    @NotNull

    /* renamed from: z  reason: collision with root package name */
    private final kotlin.properties.f f57785z;

    /* compiled from: DescriptorRendererOptionsImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements l<d1, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57786a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final String invoke(@NotNull d1 it) {
            f0.p(it, "it");
            return "...";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Delegates.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends kotlin.properties.c<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f57787b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f57788c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, e eVar) {
            super(obj);
            this.f57787b = obj;
            this.f57788c = eVar;
        }

        @Override // kotlin.properties.c
        protected boolean d(@NotNull n<?> property, T t3, T t4) {
            f0.p(property, "property");
            if (this.f57788c.m0()) {
                throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
            }
            return true;
        }
    }

    /* compiled from: DescriptorRendererOptionsImpl.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements l<e0, e0> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f57789a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final e0 invoke(@NotNull e0 it) {
            f0.p(it, "it");
            return it;
        }
    }

    public e() {
        Set k4;
        Boolean bool = Boolean.TRUE;
        this.f57762c = o0(bool);
        this.f57763d = o0(bool);
        this.f57764e = o0(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        Boolean bool2 = Boolean.FALSE;
        this.f57765f = o0(bool2);
        this.f57766g = o0(bool2);
        this.f57767h = o0(bool2);
        this.f57768i = o0(bool2);
        this.f57769j = o0(bool2);
        this.f57770k = o0(bool);
        this.f57771l = o0(bool2);
        this.f57772m = o0(bool2);
        this.f57773n = o0(bool2);
        this.f57774o = o0(bool);
        this.f57775p = o0(bool);
        this.f57776q = o0(bool2);
        this.f57777r = o0(bool2);
        this.f57778s = o0(bool2);
        this.f57779t = o0(bool2);
        this.f57780u = o0(bool2);
        this.f57781v = o0(bool2);
        this.f57782w = o0(bool2);
        this.f57783x = o0(c.f57789a);
        this.f57784y = o0(a.f57786a);
        this.f57785z = o0(bool);
        this.A = o0(OverrideRenderingPolicy.RENDER_OPEN);
        this.B = o0(b.l.a.f57745a);
        this.C = o0(RenderingFormat.PLAIN);
        this.D = o0(ParameterNameRenderingPolicy.ALL);
        this.E = o0(bool2);
        this.F = o0(bool2);
        this.G = o0(PropertyAccessorRenderingPolicy.DEBUG);
        this.H = o0(bool2);
        this.I = o0(bool2);
        k4 = j1.k();
        this.J = o0(k4);
        this.K = o0(f.f57790a.a());
        this.f57759L = o0(null);
        this.M = o0(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);
        this.N = o0(bool2);
        this.O = o0(bool);
        this.P = o0(bool);
        this.Q = o0(bool2);
        this.R = o0(bool);
        this.S = o0(bool);
        this.T = o0(bool2);
        this.U = o0(bool2);
        this.V = o0(bool2);
        this.W = o0(bool);
    }

    private final <T> kotlin.properties.f<e, T> o0(T t3) {
        kotlin.properties.a aVar = kotlin.properties.a.f55750a;
        return new b(t3, this);
    }

    public boolean A() {
        return ((Boolean) this.I.a(this, X[33])).booleanValue();
    }

    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.c> B() {
        return (Set) this.J.a(this, X[34]);
    }

    public boolean C() {
        return ((Boolean) this.R.a(this, X[42])).booleanValue();
    }

    public boolean D() {
        return d.a.a(this);
    }

    public boolean E() {
        return d.a.b(this);
    }

    public boolean F() {
        return ((Boolean) this.f57780u.a(this, X[19])).booleanValue();
    }

    public boolean G() {
        return ((Boolean) this.W.a(this, X[47])).booleanValue();
    }

    @NotNull
    public Set<DescriptorRendererModifier> H() {
        return (Set) this.f57764e.a(this, X[3]);
    }

    public boolean I() {
        return ((Boolean) this.f57773n.a(this, X[12])).booleanValue();
    }

    @NotNull
    public OverrideRenderingPolicy J() {
        return (OverrideRenderingPolicy) this.A.a(this, X[25]);
    }

    @NotNull
    public ParameterNameRenderingPolicy K() {
        return (ParameterNameRenderingPolicy) this.D.a(this, X[28]);
    }

    public boolean L() {
        return ((Boolean) this.S.a(this, X[43])).booleanValue();
    }

    public boolean M() {
        return ((Boolean) this.U.a(this, X[45])).booleanValue();
    }

    @NotNull
    public PropertyAccessorRenderingPolicy N() {
        return (PropertyAccessorRenderingPolicy) this.G.a(this, X[31]);
    }

    public boolean O() {
        return ((Boolean) this.E.a(this, X[29])).booleanValue();
    }

    public boolean P() {
        return ((Boolean) this.F.a(this, X[30])).booleanValue();
    }

    public boolean Q() {
        return ((Boolean) this.f57776q.a(this, X[15])).booleanValue();
    }

    public boolean R() {
        return ((Boolean) this.O.a(this, X[39])).booleanValue();
    }

    public boolean S() {
        return ((Boolean) this.H.a(this, X[32])).booleanValue();
    }

    public boolean T() {
        return ((Boolean) this.f57775p.a(this, X[14])).booleanValue();
    }

    public boolean U() {
        return ((Boolean) this.f57774o.a(this, X[13])).booleanValue();
    }

    public boolean V() {
        return ((Boolean) this.f57777r.a(this, X[16])).booleanValue();
    }

    public boolean W() {
        return ((Boolean) this.Q.a(this, X[41])).booleanValue();
    }

    public boolean X() {
        return ((Boolean) this.P.a(this, X[40])).booleanValue();
    }

    public boolean Y() {
        return ((Boolean) this.f57785z.a(this, X[24])).booleanValue();
    }

    public boolean Z() {
        return ((Boolean) this.f57766g.a(this, X[5])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void a(boolean z3) {
        this.f57765f.b(this, X[4], Boolean.valueOf(z3));
    }

    public boolean a0() {
        return ((Boolean) this.f57765f.a(this, X[4])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void b(@NotNull ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        f0.p(parameterNameRenderingPolicy, "<set-?>");
        this.D.b(this, X[28], parameterNameRenderingPolicy);
    }

    @NotNull
    public RenderingFormat b0() {
        return (RenderingFormat) this.C.a(this, X[27]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void c(boolean z3) {
        this.f57762c.b(this, X[1], Boolean.valueOf(z3));
    }

    @NotNull
    public l<e0, e0> c0() {
        return (l) this.f57783x.a(this, X[22]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public boolean d() {
        return ((Boolean) this.f57772m.a(this, X[11])).booleanValue();
    }

    public boolean d0() {
        return ((Boolean) this.f57779t.a(this, X[18])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void e(boolean z3) {
        this.f57782w.b(this, X[21], Boolean.valueOf(z3));
    }

    public boolean e0() {
        return ((Boolean) this.f57770k.a(this, X[9])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void f(boolean z3) {
        this.E.b(this, X[29], Boolean.valueOf(z3));
    }

    @NotNull
    public b.l f0() {
        return (b.l) this.B.a(this, X[26]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void g(@NotNull RenderingFormat renderingFormat) {
        f0.p(renderingFormat, "<set-?>");
        this.C.b(this, X[27], renderingFormat);
    }

    public boolean g0() {
        return ((Boolean) this.f57769j.a(this, X[8])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void h(@NotNull AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        f0.p(annotationArgumentsRenderingPolicy, "<set-?>");
        this.M.b(this, X[37], annotationArgumentsRenderingPolicy);
    }

    public boolean h0() {
        return ((Boolean) this.f57762c.a(this, X[1])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.c> i() {
        return (Set) this.K.a(this, X[35]);
    }

    public boolean i0() {
        return ((Boolean) this.f57763d.a(this, X[2])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public boolean j() {
        return ((Boolean) this.f57767h.a(this, X[6])).booleanValue();
    }

    public boolean j0() {
        return ((Boolean) this.f57771l.a(this, X[10])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    @NotNull
    public AnnotationArgumentsRenderingPolicy k() {
        return (AnnotationArgumentsRenderingPolicy) this.M.a(this, X[37]);
    }

    public boolean k0() {
        return ((Boolean) this.f57782w.a(this, X[21])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void l(@NotNull Set<kotlin.reflect.jvm.internal.impl.name.c> set) {
        f0.p(set, "<set-?>");
        this.K.b(this, X[35], set);
    }

    public boolean l0() {
        return ((Boolean) this.f57781v.a(this, X[20])).booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void m(@NotNull Set<? extends DescriptorRendererModifier> set) {
        f0.p(set, "<set-?>");
        this.f57764e.b(this, X[3], set);
    }

    public final boolean m0() {
        return this.f57760a;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void n(boolean z3) {
        this.f57769j.b(this, X[8], Boolean.valueOf(z3));
    }

    public final void n0() {
        this.f57760a = true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void o(@NotNull kotlin.reflect.jvm.internal.impl.renderer.a aVar) {
        f0.p(aVar, "<set-?>");
        this.f57761b.b(this, X[0], aVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void p(boolean z3) {
        this.f57767h.b(this, X[6], Boolean.valueOf(z3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void q(boolean z3) {
        this.F.b(this, X[30], Boolean.valueOf(z3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.d
    public void r(boolean z3) {
        this.f57781v.b(this, X[20], Boolean.valueOf(z3));
    }

    @NotNull
    public final e s() {
        e eVar = new e();
        Field[] declaredFields = e.class.getDeclaredFields();
        f0.o(declaredFields, "this::class.java.declaredFields");
        int length = declaredFields.length;
        int i4 = 0;
        while (i4 < length) {
            Field field = declaredFields[i4];
            i4++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                kotlin.properties.c cVar = obj instanceof kotlin.properties.c ? (kotlin.properties.c) obj : null;
                if (cVar != null) {
                    String name = field.getName();
                    f0.o(name, "field.name");
                    w.u2(name, "is", false, 2, null);
                    kotlin.reflect.d d4 = n0.d(e.class);
                    String name2 = field.getName();
                    String name3 = field.getName();
                    f0.o(name3, "field.name");
                    if (name3.length() > 0) {
                        char upperCase = Character.toUpperCase(name3.charAt(0));
                        String substring = name3.substring(1);
                        f0.o(substring, "this as java.lang.String).substring(startIndex)");
                        name3 = upperCase + substring;
                    }
                    field.set(eVar, eVar.o0(cVar.a(this, new PropertyReference1Impl(d4, name2, f0.C(f3.f5657f, name3)))));
                }
            }
        }
        return eVar;
    }

    public boolean t() {
        return ((Boolean) this.f57778s.a(this, X[17])).booleanValue();
    }

    public boolean u() {
        return ((Boolean) this.N.a(this, X[38])).booleanValue();
    }

    @Nullable
    public l<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, Boolean> v() {
        return (l) this.f57759L.a(this, X[36]);
    }

    public boolean w() {
        return ((Boolean) this.V.a(this, X[46])).booleanValue();
    }

    public boolean x() {
        return ((Boolean) this.f57768i.a(this, X[7])).booleanValue();
    }

    @NotNull
    public kotlin.reflect.jvm.internal.impl.renderer.a y() {
        return (kotlin.reflect.jvm.internal.impl.renderer.a) this.f57761b.a(this, X[0]);
    }

    @Nullable
    public l<d1, String> z() {
        return (l) this.f57784y.a(this, X[23]);
    }
}
