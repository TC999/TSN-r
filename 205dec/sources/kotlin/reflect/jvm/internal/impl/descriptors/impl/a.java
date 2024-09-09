package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.f1;
import kotlin.reflect.jvm.internal.impl.types.h1;
import org.jetbrains.annotations.NotNull;

/* compiled from: AbstractClassDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a extends t {

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ boolean f56292f = false;

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.f f56293b;

    /* renamed from: c  reason: collision with root package name */
    protected final kotlin.reflect.jvm.internal.impl.storage.i<kotlin.reflect.jvm.internal.impl.types.m0> f56294c;

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> f56295d;

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<s0> f56296e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractClassDescriptor.java */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class C1128a implements d2.a<kotlin.reflect.jvm.internal.impl.types.m0> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractClassDescriptor.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1129a implements d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, kotlin.reflect.jvm.internal.impl.types.m0> {
            C1129a() {
            }

            @Override // d2.l
            /* renamed from: a */
            public kotlin.reflect.jvm.internal.impl.types.m0 invoke(kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
                kotlin.reflect.jvm.internal.impl.descriptors.f f4 = gVar.f(a.this);
                if (f4 == null) {
                    return a.this.f56294c.invoke();
                }
                if (f4 instanceof z0) {
                    return kotlin.reflect.jvm.internal.impl.types.f0.b((z0) f4, h1.h(f4.j().getParameters()));
                }
                if (f4 instanceof t) {
                    return h1.v(f4.j().a(gVar), ((t) f4).f0(gVar), this);
                }
                return f4.q();
            }
        }

        C1128a() {
        }

        @Override // d2.a
        /* renamed from: a */
        public kotlin.reflect.jvm.internal.impl.types.m0 invoke() {
            a aVar = a.this;
            return h1.u(aVar, aVar.W(), new C1129a());
        }
    }

    /* compiled from: AbstractClassDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class b implements d2.a<kotlin.reflect.jvm.internal.impl.resolve.scopes.h> {
        b() {
        }

        @Override // d2.a
        /* renamed from: a */
        public kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke() {
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.f(a.this.W());
        }
    }

    /* compiled from: AbstractClassDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class c implements d2.a<s0> {
        c() {
        }

        @Override // d2.a
        /* renamed from: a */
        public s0 invoke() {
            return new q(a.this);
        }
    }

    public a(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
        if (nVar == null) {
            h0(0);
        }
        if (fVar == null) {
            h0(1);
        }
        this.f56293b = fVar;
        this.f56294c = nVar.g(new C1128a());
        this.f56295d = nVar.g(new b());
        this.f56296e = nVar.g(new c());
    }

    private static /* synthetic */ void h0(int i4) {
        String str = (i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5 || i4 == 8 || i4 == 11 || i4 == 13 || i4 == 15 || i4 == 16 || i4 == 18 || i4 == 19) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i4 == 2 || i4 == 3 || i4 == 4 || i4 == 5 || i4 == 8 || i4 == 11 || i4 == 13 || i4 == 15 || i4 == 16 || i4 == 18 || i4 == 19) ? 2 : 3];
        switch (i4) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 6:
            case 12:
                objArr[0] = "typeArguments";
                break;
            case 7:
            case 10:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 9:
            case 14:
                objArr[0] = "typeSubstitution";
                break;
            case 17:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i4 == 2) {
            objArr[1] = "getName";
        } else if (i4 == 3) {
            objArr[1] = "getOriginal";
        } else if (i4 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i4 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i4 == 8 || i4 == 11 || i4 == 13 || i4 == 15) {
            objArr[1] = "getMemberScope";
        } else if (i4 == 16) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i4 == 18) {
            objArr[1] = "substitute";
        } else if (i4 != 19) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i4) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 8:
            case 11:
            case 13:
            case 15:
            case 16:
            case 18:
            case 19:
                break;
            case 6:
            case 7:
            case 9:
            case 10:
            case 12:
            case 14:
                objArr[2] = "getMemberScope";
                break;
            case 17:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 != 2 && i4 != 3 && i4 != 4 && i4 != 5 && i4 != 8 && i4 != 11 && i4 != 13 && i4 != 15 && i4 != 16 && i4 != 18 && i4 != 19) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h B(@NotNull d1 d1Var, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (d1Var == null) {
            h0(9);
        }
        if (gVar == null) {
            h0(10);
        }
        if (!d1Var.f()) {
            return new kotlin.reflect.jvm.internal.impl.resolve.scopes.m(f0(gVar), f1.g(d1Var));
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h f02 = f0(gVar);
        if (f02 == null) {
            h0(11);
        }
        return f02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
        return mVar.a(this, d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.x0
    @NotNull
    /* renamed from: C0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.d c(@NotNull f1 f1Var) {
        if (f1Var == null) {
            h0(17);
        }
        return f1Var.k() ? this : new s(this, f1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public s0 E0() {
        s0 invoke = this.f56296e.invoke();
        if (invoke == null) {
            h0(5);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h U() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h invoke = this.f56295d.invoke();
        if (invoke == null) {
            h0(4);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h W() {
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h f02 = f0(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(kotlin.reflect.jvm.internal.impl.resolve.d.g(this)));
        if (f02 == null) {
            h0(16);
        }
        return f02;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.d a() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.name.f getName() {
        kotlin.reflect.jvm.internal.impl.name.f fVar = this.f56293b;
        if (fVar == null) {
            h0(2);
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h o0(@NotNull d1 d1Var) {
        if (d1Var == null) {
            h0(14);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h B = B(d1Var, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.k(kotlin.reflect.jvm.internal.impl.resolve.d.g(this)));
        if (B == null) {
            h0(15);
        }
        return B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.m0 q() {
        kotlin.reflect.jvm.internal.impl.types.m0 invoke = this.f56294c.invoke();
        if (invoke == null) {
            h0(19);
        }
        return invoke;
    }
}
