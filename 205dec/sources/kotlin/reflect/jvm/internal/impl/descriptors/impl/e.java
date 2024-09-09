package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractTypeParameterDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class e extends k implements a1 {

    /* renamed from: e  reason: collision with root package name */
    private final Variance f56352e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f56353f;

    /* renamed from: g  reason: collision with root package name */
    private final int f56354g;

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<y0> f56355h;

    /* renamed from: i  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<kotlin.reflect.jvm.internal.impl.types.m0> f56356i;

    /* renamed from: j  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.n f56357j;

    /* compiled from: AbstractTypeParameterDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements d2.a<y0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.storage.n f56358a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.y0 f56359b;

        a(kotlin.reflect.jvm.internal.impl.storage.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.y0 y0Var) {
            this.f56358a = nVar;
            this.f56359b = y0Var;
        }

        @Override // d2.a
        /* renamed from: a */
        public y0 invoke() {
            return new c(e.this, this.f56358a, this.f56359b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractTypeParameterDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b implements d2.a<kotlin.reflect.jvm.internal.impl.types.m0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.name.f f56361a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractTypeParameterDescriptor.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements d2.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {
            a() {
            }

            @Override // d2.a
            /* renamed from: a */
            public kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
                return kotlin.reflect.jvm.internal.impl.resolve.scopes.n.k("Scope for type parameter " + b.this.f56361a.b(), e.this.getUpperBounds());
            }
        }

        b(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            this.f56361a = fVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public kotlin.reflect.jvm.internal.impl.types.m0 invoke() {
            return kotlin.reflect.jvm.internal.impl.types.f0.l(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b(), e.this.j(), Collections.emptyList(), false, new kotlin.reflect.jvm.internal.impl.resolve.scopes.g(new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTypeParameterDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class c extends kotlin.reflect.jvm.internal.impl.types.g {

        /* renamed from: d  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.descriptors.y0 f56364d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ e f56365e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull e eVar, kotlin.reflect.jvm.internal.impl.storage.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.y0 y0Var) {
            super(nVar);
            if (nVar == null) {
                t(0);
            }
            this.f56365e = eVar;
            this.f56364d = y0Var;
        }

        private static /* synthetic */ void t(int i4) {
            String str = (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5 || i4 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i4 == 1 || i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5 || i4 == 8) ? 2 : 3];
            switch (i4) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i4 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i4 == 2) {
                objArr[1] = "getParameters";
            } else if (i4 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i4 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i4 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i4 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i4) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i4 != 1 && i4 != 2 && i4 != 3 && i4 != 4 && i4 != 5 && i4 != 8) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.l, kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.descriptors.f b() {
            e eVar = this.f56365e;
            if (eVar == null) {
                t(3);
            }
            return eVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        public boolean c() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.l
        protected boolean f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
            if (fVar == null) {
                t(9);
            }
            return (fVar instanceof a1) && kotlin.reflect.jvm.internal.impl.resolve.b.f57810a.f(this.f56365e, (a1) fVar, true);
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public List<a1> getParameters() {
            List<a1> emptyList = Collections.emptyList();
            if (emptyList == null) {
                t(2);
            }
            return emptyList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        @NotNull
        protected Collection<kotlin.reflect.jvm.internal.impl.types.e0> i() {
            List<kotlin.reflect.jvm.internal.impl.types.e0> G0 = this.f56365e.G0();
            if (G0 == null) {
                t(1);
            }
            return G0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public kotlin.reflect.jvm.internal.impl.builtins.h k() {
            kotlin.reflect.jvm.internal.impl.builtins.h g4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(this.f56365e);
            if (g4 == null) {
                t(4);
            }
            return g4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        @Nullable
        protected kotlin.reflect.jvm.internal.impl.types.e0 l() {
            return kotlin.reflect.jvm.internal.impl.types.w.j("Cyclic upper bounds");
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        @NotNull
        protected kotlin.reflect.jvm.internal.impl.descriptors.y0 o() {
            kotlin.reflect.jvm.internal.impl.descriptors.y0 y0Var = this.f56364d;
            if (y0Var == null) {
                t(5);
            }
            return y0Var;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        @NotNull
        protected List<kotlin.reflect.jvm.internal.impl.types.e0> q(@NotNull List<kotlin.reflect.jvm.internal.impl.types.e0> list) {
            if (list == null) {
                t(7);
            }
            List<kotlin.reflect.jvm.internal.impl.types.e0> C0 = this.f56365e.C0(list);
            if (C0 == null) {
                t(8);
            }
            return C0;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        protected void s(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
            if (e0Var == null) {
                t(6);
            }
            this.f56365e.F0(e0Var);
        }

        public String toString() {
            return this.f56365e.getName().toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull Variance variance, boolean z3, int i4, @NotNull v0 v0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.y0 y0Var) {
        super(kVar, fVar, fVar2, v0Var);
        if (nVar == null) {
            B(0);
        }
        if (kVar == null) {
            B(1);
        }
        if (fVar == null) {
            B(2);
        }
        if (fVar2 == null) {
            B(3);
        }
        if (variance == null) {
            B(4);
        }
        if (v0Var == null) {
            B(5);
        }
        if (y0Var == null) {
            B(6);
        }
        this.f56352e = variance;
        this.f56353f = z3;
        this.f56354g = i4;
        this.f56355h = nVar.g(new a(nVar, y0Var));
        this.f56356i = nVar.g(new b(fVar2));
        this.f56357j = nVar;
    }

    private static /* synthetic */ void B(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i5 = 2;
                break;
            case 12:
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i4) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i4) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
        return mVar.m(this, d4);
    }

    @NotNull
    protected List<kotlin.reflect.jvm.internal.impl.types.e0> C0(@NotNull List<kotlin.reflect.jvm.internal.impl.types.e0> list) {
        if (list == null) {
            B(12);
        }
        if (list == null) {
            B(13);
        }
        return list;
    }

    protected abstract void F0(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var);

    @NotNull
    protected abstract List<kotlin.reflect.jvm.internal.impl.types.e0> G0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    @NotNull
    public kotlin.reflect.jvm.internal.impl.storage.n N() {
        kotlin.reflect.jvm.internal.impl.storage.n nVar = this.f56357j;
        if (nVar == null) {
            B(14);
        }
        return nVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    public boolean S() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    public int f() {
        return this.f56354g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    @NotNull
    public List<kotlin.reflect.jvm.internal.impl.types.e0> getUpperBounds() {
        List<kotlin.reflect.jvm.internal.impl.types.e0> j4 = ((c) j()).j();
        if (j4 == null) {
            B(8);
        }
        return j4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1, kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public final y0 j() {
        y0 invoke = this.f56355h.invoke();
        if (invoke == null) {
            B(9);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    public boolean l() {
        return this.f56353f;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a1
    @NotNull
    public Variance o() {
        Variance variance = this.f56352e;
        if (variance == null) {
            B(7);
        }
        return variance;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.m0 q() {
        kotlin.reflect.jvm.internal.impl.types.m0 invoke = this.f56356i.invoke();
        if (invoke == null) {
            B(10);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: a */
    public a1 h0() {
        a1 a1Var = (a1) super.a();
        if (a1Var == null) {
            B(11);
        }
        return a1Var;
    }
}
