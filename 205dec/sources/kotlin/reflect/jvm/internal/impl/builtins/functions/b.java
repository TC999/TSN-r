package kotlin.reflect.jvm.internal.impl.builtins.functions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.r0;
import kotlin.collections.x;
import kotlin.collections.y;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.ranges.k;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.v;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.name.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.storage.n;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FunctionClassDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b extends kotlin.reflect.jvm.internal.impl.descriptors.impl.a {
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    public static final a f56029n = new a(null);
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.b f56030o = new kotlin.reflect.jvm.internal.impl.name.b(j.f56084m, f.f("Function"));
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.b f56031p = new kotlin.reflect.jvm.internal.impl.name.b(j.f56081j, f.f("KFunction"));
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final n f56032g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final g0 f56033h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final FunctionClassKind f56034i;

    /* renamed from: j  reason: collision with root package name */
    private final int f56035j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final C1123b f56036k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final c f56037l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final List<a1> f56038m;

    /* compiled from: FunctionClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* compiled from: FunctionClassDescriptor.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.functions.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private final class C1123b extends kotlin.reflect.jvm.internal.impl.types.b {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ b f56039d;

        /* compiled from: FunctionClassDescriptor.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.functions.b$b$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public /* synthetic */ class a {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f56040a;

            static {
                int[] iArr = new int[FunctionClassKind.values().length];
                iArr[FunctionClassKind.Function.ordinal()] = 1;
                iArr[FunctionClassKind.KFunction.ordinal()] = 2;
                iArr[FunctionClassKind.SuspendFunction.ordinal()] = 3;
                iArr[FunctionClassKind.KSuspendFunction.ordinal()] = 4;
                f56040a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1123b(b this$0) {
            super(this$0.f56032g);
            f0.p(this$0, "this$0");
            this.f56039d = this$0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        public boolean c() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public List<a1> getParameters() {
            return this.f56039d.f56038m;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        @NotNull
        protected Collection<e0> i() {
            List<kotlin.reflect.jvm.internal.impl.name.b> l4;
            int Z;
            List G5;
            List<a1> v5;
            int Z2;
            int i4 = a.f56040a[this.f56039d.P0().ordinal()];
            if (i4 == 1) {
                l4 = x.l(b.f56030o);
            } else if (i4 == 2) {
                l4 = CollectionsKt__CollectionsKt.M(b.f56031p, new kotlin.reflect.jvm.internal.impl.name.b(j.f56084m, FunctionClassKind.Function.numberedClassName(this.f56039d.L0())));
            } else if (i4 == 3) {
                l4 = x.l(b.f56030o);
            } else if (i4 != 4) {
                throw new NoWhenBranchMatchedException();
            } else {
                l4 = CollectionsKt__CollectionsKt.M(b.f56031p, new kotlin.reflect.jvm.internal.impl.name.b(j.f56076e, FunctionClassKind.SuspendFunction.numberedClassName(this.f56039d.L0())));
            }
            d0 b4 = this.f56039d.f56033h.b();
            Z = y.Z(l4, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (kotlin.reflect.jvm.internal.impl.name.b bVar : l4) {
                kotlin.reflect.jvm.internal.impl.descriptors.d a4 = v.a(b4, bVar);
                if (a4 != null) {
                    v5 = kotlin.collections.f0.v5(getParameters(), a4.j().getParameters().size());
                    Z2 = y.Z(v5, 10);
                    ArrayList arrayList2 = new ArrayList(Z2);
                    for (a1 a1Var : v5) {
                        arrayList2.add(new c1(a1Var.q()));
                    }
                    arrayList.add(kotlin.reflect.jvm.internal.impl.types.f0.g(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), a4, arrayList2));
                } else {
                    throw new IllegalStateException(("Built-in class " + bVar + " not found").toString());
                }
            }
            G5 = kotlin.collections.f0.G5(arrayList);
            return G5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        @NotNull
        protected y0 o() {
            return y0.a.f56639a;
        }

        @NotNull
        public String toString() {
            return u().toString();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b
        @NotNull
        /* renamed from: v */
        public b u() {
            return this.f56039d;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull n storageManager, @NotNull g0 containingDeclaration, @NotNull FunctionClassKind functionKind, int i4) {
        super(storageManager, functionKind.numberedClassName(i4));
        int Z;
        List<a1> G5;
        f0.p(storageManager, "storageManager");
        f0.p(containingDeclaration, "containingDeclaration");
        f0.p(functionKind, "functionKind");
        this.f56032g = storageManager;
        this.f56033h = containingDeclaration;
        this.f56034i = functionKind;
        this.f56035j = i4;
        this.f56036k = new C1123b(this);
        this.f56037l = new c(storageManager, this);
        ArrayList arrayList = new ArrayList();
        k kVar = new k(1, i4);
        Z = y.Z(kVar, 10);
        ArrayList arrayList2 = new ArrayList(Z);
        Iterator<Integer> it = kVar.iterator();
        while (it.hasNext()) {
            F0(arrayList, this, Variance.IN_VARIANCE, f0.C("P", Integer.valueOf(((r0) it).nextInt())));
            arrayList2.add(f1.f55527a);
        }
        F0(arrayList, this, Variance.OUT_VARIANCE, "R");
        G5 = kotlin.collections.f0.G5(arrayList);
        this.f56038m = G5;
    }

    private static final void F0(ArrayList<a1> arrayList, b bVar, Variance variance, String str) {
        arrayList.add(k0.M0(bVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), false, variance, f.f(str), arrayList.size(), bVar.f56032g));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.c F() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.c) T0();
    }

    public final int L0() {
        return this.f56035j;
    }

    @Nullable
    public Void M0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: N0 */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.c> g() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.c> F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    /* renamed from: O0 */
    public g0 b() {
        return this.f56033h;
    }

    @NotNull
    public final FunctionClassKind P0() {
        return this.f56034i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: Q0 */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.d> m() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.d> F;
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: R0 */
    public h.c k0() {
        return h.c.f57931b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    @NotNull
    /* renamed from: S0 */
    public c f0(@NotNull g kotlinTypeRefiner) {
        f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f56037l;
    }

    @Nullable
    public Void T0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean X() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean a0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public v0 getSource() {
        v0 NO_SOURCE = v0.f56634a;
        f0.o(NO_SOURCE, "NO_SOURCE");
        return NO_SOURCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public s getVisibility() {
        s PUBLIC = r.f56531e;
        f0.o(PUBLIC, "PUBLIC");
        return PUBLIC;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind i() {
        return ClassKind.INTERFACE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean isExternal() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.y0 j() {
        return this.f56036k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d l0() {
        return (kotlin.reflect.jvm.internal.impl.descriptors.d) M0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean n() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<a1> r() {
        return this.f56038m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        return Modality.ABSTRACT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean t() {
        return false;
    }

    @NotNull
    public String toString() {
        String b4 = getName().b();
        f0.o(b4, "name.asString()");
        return b4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean v() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean y() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.x<m0> z() {
        return null;
    }
}
