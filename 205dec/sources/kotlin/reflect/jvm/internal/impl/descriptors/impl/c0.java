package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.d1;
import kotlin.reflect.jvm.internal.impl.types.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PropertyDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c0 extends n0 implements p0 {
    private kotlin.reflect.jvm.internal.impl.descriptors.u A;
    private kotlin.reflect.jvm.internal.impl.descriptors.u B;

    /* renamed from: j  reason: collision with root package name */
    private final Modality f56314j;

    /* renamed from: k  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.s f56315k;

    /* renamed from: l  reason: collision with root package name */
    private Collection<? extends p0> f56316l;

    /* renamed from: m  reason: collision with root package name */
    private final p0 f56317m;

    /* renamed from: n  reason: collision with root package name */
    private final CallableMemberDescriptor.Kind f56318n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f56319o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f56320p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f56321q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f56322r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f56323s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f56324t;

    /* renamed from: u  reason: collision with root package name */
    private s0 f56325u;

    /* renamed from: v  reason: collision with root package name */
    private s0 f56326v;

    /* renamed from: w  reason: collision with root package name */
    private List<a1> f56327w;

    /* renamed from: x  reason: collision with root package name */
    private d0 f56328x;

    /* renamed from: y  reason: collision with root package name */
    private r0 f56329y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f56330z;

    /* compiled from: PropertyDescriptorImpl.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.k f56331a;

        /* renamed from: b  reason: collision with root package name */
        private Modality f56332b;

        /* renamed from: c  reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.s f56333c;

        /* renamed from: f  reason: collision with root package name */
        private CallableMemberDescriptor.Kind f56336f;

        /* renamed from: i  reason: collision with root package name */
        private s0 f56339i;

        /* renamed from: k  reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.name.f f56341k;

        /* renamed from: l  reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.types.e0 f56342l;

        /* renamed from: d  reason: collision with root package name */
        private p0 f56334d = null;

        /* renamed from: e  reason: collision with root package name */
        private boolean f56335e = false;

        /* renamed from: g  reason: collision with root package name */
        private d1 f56337g = d1.f58327b;

        /* renamed from: h  reason: collision with root package name */
        private boolean f56338h = true;

        /* renamed from: j  reason: collision with root package name */
        private List<a1> f56340j = null;

        public a() {
            this.f56331a = c0.this.b();
            this.f56332b = c0.this.s();
            this.f56333c = c0.this.getVisibility();
            this.f56336f = c0.this.i();
            this.f56339i = c0.this.f56325u;
            this.f56341k = c0.this.getName();
            this.f56342l = c0.this.getType();
        }

        private static /* synthetic */ void a(int i4) {
            String str = (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 5 || i4 == 7 || i4 == 9 || i4 == 11 || i4 == 19 || i4 == 13 || i4 == 14 || i4 == 16 || i4 == 17) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i4 == 1 || i4 == 2 || i4 == 3 || i4 == 5 || i4 == 7 || i4 == 9 || i4 == 11 || i4 == 19 || i4 == 13 || i4 == 14 || i4 == 16 || i4 == 17) ? 2 : 3];
            switch (i4) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
                    break;
                case 4:
                    objArr[0] = "type";
                    break;
                case 6:
                    objArr[0] = "modality";
                    break;
                case 8:
                    objArr[0] = "visibility";
                    break;
                case 10:
                    objArr[0] = "kind";
                    break;
                case 12:
                    objArr[0] = "typeParameters";
                    break;
                case 15:
                    objArr[0] = "substitution";
                    break;
                case 18:
                    objArr[0] = "name";
                    break;
                default:
                    objArr[0] = "owner";
                    break;
            }
            if (i4 == 1) {
                objArr[1] = "setOwner";
            } else if (i4 == 2) {
                objArr[1] = "setOriginal";
            } else if (i4 == 3) {
                objArr[1] = "setPreserveSourceElement";
            } else if (i4 == 5) {
                objArr[1] = "setReturnType";
            } else if (i4 == 7) {
                objArr[1] = "setModality";
            } else if (i4 == 9) {
                objArr[1] = "setVisibility";
            } else if (i4 == 11) {
                objArr[1] = "setKind";
            } else if (i4 == 19) {
                objArr[1] = "setName";
            } else if (i4 == 13) {
                objArr[1] = "setTypeParameters";
            } else if (i4 == 14) {
                objArr[1] = "setDispatchReceiverParameter";
            } else if (i4 == 16) {
                objArr[1] = "setSubstitution";
            } else if (i4 != 17) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyDescriptorImpl$CopyConfiguration";
            } else {
                objArr[1] = "setCopyOverrides";
            }
            switch (i4) {
                case 1:
                case 2:
                case 3:
                case 5:
                case 7:
                case 9:
                case 11:
                case 13:
                case 14:
                case 16:
                case 17:
                case 19:
                    break;
                case 4:
                    objArr[2] = "setReturnType";
                    break;
                case 6:
                    objArr[2] = "setModality";
                    break;
                case 8:
                    objArr[2] = "setVisibility";
                    break;
                case 10:
                    objArr[2] = "setKind";
                    break;
                case 12:
                    objArr[2] = "setTypeParameters";
                    break;
                case 15:
                    objArr[2] = "setSubstitution";
                    break;
                case 18:
                    objArr[2] = "setName";
                    break;
                default:
                    objArr[2] = "setOwner";
                    break;
            }
            String format = String.format(str, objArr);
            if (i4 != 1 && i4 != 2 && i4 != 3 && i4 != 5 && i4 != 7 && i4 != 9 && i4 != 11 && i4 != 19 && i4 != 13 && i4 != 14 && i4 != 16 && i4 != 17) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Nullable
        public p0 n() {
            return c0.this.L0(this);
        }

        q0 o() {
            p0 p0Var = this.f56334d;
            if (p0Var == null) {
                return null;
            }
            return p0Var.getGetter();
        }

        r0 p() {
            p0 p0Var = this.f56334d;
            if (p0Var == null) {
                return null;
            }
            return p0Var.getSetter();
        }

        @NotNull
        public a q(boolean z3) {
            this.f56338h = z3;
            return this;
        }

        @NotNull
        public a r(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                a(10);
            }
            this.f56336f = kind;
            return this;
        }

        @NotNull
        public a s(@NotNull Modality modality) {
            if (modality == null) {
                a(6);
            }
            this.f56332b = modality;
            return this;
        }

        @NotNull
        public a t(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.f56334d = (p0) callableMemberDescriptor;
            return this;
        }

        @NotNull
        public a u(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (kVar == null) {
                a(0);
            }
            this.f56331a = kVar;
            return this;
        }

        @NotNull
        public a v(@NotNull d1 d1Var) {
            if (d1Var == null) {
                a(15);
            }
            this.f56337g = d1Var;
            return this;
        }

        @NotNull
        public a w(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
            if (sVar == null) {
                a(8);
            }
            this.f56333c = sVar;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable p0 p0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull v0 v0Var, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        super(kVar, fVar, fVar2, null, z3, v0Var);
        if (kVar == null) {
            B(0);
        }
        if (fVar == null) {
            B(1);
        }
        if (modality == null) {
            B(2);
        }
        if (sVar == null) {
            B(3);
        }
        if (fVar2 == null) {
            B(4);
        }
        if (kind == null) {
            B(5);
        }
        if (v0Var == null) {
            B(6);
        }
        this.f56316l = null;
        this.f56314j = modality;
        this.f56315k = sVar;
        this.f56317m = p0Var == null ? this : p0Var;
        this.f56318n = kind;
        this.f56319o = z4;
        this.f56320p = z5;
        this.f56321q = z6;
        this.f56322r = z7;
        this.f56323s = z8;
        this.f56324t = z9;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0113 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x011e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void B(int r11) {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.c0.B(int):void");
    }

    @NotNull
    public static c0 J0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull v0 v0Var, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        if (kVar == null) {
            B(7);
        }
        if (fVar == null) {
            B(8);
        }
        if (modality == null) {
            B(9);
        }
        if (sVar == null) {
            B(10);
        }
        if (fVar2 == null) {
            B(11);
        }
        if (kind == null) {
            B(12);
        }
        if (v0Var == null) {
            B(13);
        }
        return new c0(kVar, null, fVar, modality, sVar, z3, fVar2, kind, v0Var, z4, z5, z6, z7, z8, z9);
    }

    @NotNull
    private v0 N0(boolean z3, @Nullable p0 p0Var) {
        v0 v0Var;
        if (z3) {
            if (p0Var == null) {
                p0Var = h0();
            }
            v0Var = p0Var.getSource();
        } else {
            v0Var = v0.f56634a;
        }
        if (v0Var == null) {
            B(24);
        }
        return v0Var;
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.w O0(@NotNull f1 f1Var, @NotNull o0 o0Var) {
        if (f1Var == null) {
            B(26);
        }
        if (o0Var == null) {
            B(27);
        }
        if (o0Var.q0() != null) {
            return o0Var.q0().c(f1Var);
        }
        return null;
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.s T0(kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind) {
        return (kind == CallableMemberDescriptor.Kind.FAKE_OVERRIDE && kotlin.reflect.jvm.internal.impl.descriptors.r.g(sVar.f())) ? kotlin.reflect.jvm.internal.impl.descriptors.r.f56534h : sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    @NotNull
    public List<o0> A() {
        ArrayList arrayList = new ArrayList(2);
        d0 d0Var = this.f56328x;
        if (d0Var != null) {
            arrayList.add(d0Var);
        }
        r0 r0Var = this.f56329y;
        if (r0Var != null) {
            arrayList.add(r0Var);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    public void A0(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            B(36);
        }
        this.f56316l = collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k
    public <R, D> R C(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
        return mVar.c(this, d4);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g1
    public boolean D() {
        return this.f56324t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: I0 */
    public p0 P(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind, boolean z3) {
        p0 n4 = S0().u(kVar).t(null).s(modality).w(sVar).r(kind).q(z3).n();
        if (n4 == null) {
            B(38);
        }
        return n4;
    }

    @NotNull
    protected c0 K0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, @Nullable p0 p0Var, @NotNull CallableMemberDescriptor.Kind kind, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull v0 v0Var) {
        if (kVar == null) {
            B(28);
        }
        if (modality == null) {
            B(29);
        }
        if (sVar == null) {
            B(30);
        }
        if (kind == null) {
            B(31);
        }
        if (fVar == null) {
            B(32);
        }
        if (v0Var == null) {
            B(33);
        }
        return new c0(kVar, p0Var, getAnnotations(), modality, sVar, O(), fVar, kind, v0Var, v0(), isConst(), i0(), X(), isExternal(), D());
    }

    @Nullable
    protected p0 L0(@NotNull a aVar) {
        s0 s0Var;
        f0 f0Var;
        kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> jVar;
        if (aVar == null) {
            B(25);
        }
        c0 K0 = K0(aVar.f56331a, aVar.f56332b, aVar.f56333c, aVar.f56334d, aVar.f56336f, aVar.f56341k, N0(aVar.f56335e, aVar.f56334d));
        List<a1> typeParameters = aVar.f56340j == null ? getTypeParameters() : aVar.f56340j;
        ArrayList arrayList = new ArrayList(typeParameters.size());
        f1 b4 = kotlin.reflect.jvm.internal.impl.types.r.b(typeParameters, aVar.f56337g, K0, arrayList);
        kotlin.reflect.jvm.internal.impl.types.e0 e0Var = aVar.f56342l;
        Variance variance = Variance.OUT_VARIANCE;
        kotlin.reflect.jvm.internal.impl.types.e0 p3 = b4.p(e0Var, variance);
        if (p3 == null) {
            return null;
        }
        Variance variance2 = Variance.IN_VARIANCE;
        kotlin.reflect.jvm.internal.impl.types.e0 p4 = b4.p(e0Var, variance2);
        if (p4 != null) {
            K0.U0(p4);
        }
        s0 s0Var2 = aVar.f56339i;
        if (s0Var2 != null) {
            s0Var = s0Var2.c(b4);
            if (s0Var == null) {
                return null;
            }
        } else {
            s0Var = null;
        }
        s0 s0Var3 = this.f56326v;
        if (s0Var3 != null) {
            kotlin.reflect.jvm.internal.impl.types.e0 p5 = b4.p(s0Var3.getType(), variance2);
            if (p5 == null) {
                return null;
            }
            f0Var = new f0(K0, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.b(K0, p5, this.f56326v.getValue()), this.f56326v.getAnnotations());
        } else {
            f0Var = null;
        }
        K0.W0(p3, arrayList, s0Var, f0Var);
        d0 d0Var = this.f56328x == null ? null : new d0(K0, this.f56328x.getAnnotations(), aVar.f56332b, T0(this.f56328x.getVisibility(), aVar.f56336f), this.f56328x.H(), this.f56328x.isExternal(), this.f56328x.isInline(), aVar.f56336f, aVar.o(), v0.f56634a);
        if (d0Var != null) {
            kotlin.reflect.jvm.internal.impl.types.e0 returnType = this.f56328x.getReturnType();
            d0Var.I0(O0(b4, this.f56328x));
            d0Var.L0(returnType != null ? b4.p(returnType, variance) : null);
        }
        e0 e0Var2 = this.f56329y == null ? null : new e0(K0, this.f56329y.getAnnotations(), aVar.f56332b, T0(this.f56329y.getVisibility(), aVar.f56336f), this.f56329y.H(), this.f56329y.isExternal(), this.f56329y.isInline(), aVar.f56336f, aVar.p(), v0.f56634a);
        if (e0Var2 != null) {
            List<kotlin.reflect.jvm.internal.impl.descriptors.d1> K02 = p.K0(e0Var2, this.f56329y.h(), b4, false, false, null);
            if (K02 == null) {
                K0.V0(true);
                K02 = Collections.singletonList(e0.K0(e0Var2, kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(aVar.f56331a).H(), this.f56329y.h().get(0).getAnnotations()));
            }
            if (K02.size() == 1) {
                e0Var2.I0(O0(b4, this.f56329y));
                e0Var2.M0(K02.get(0));
            } else {
                throw new IllegalStateException();
            }
        }
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar = this.A;
        o oVar = uVar == null ? null : new o(uVar.getAnnotations(), K0);
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar2 = this.B;
        K0.Q0(d0Var, e0Var2, oVar, uVar2 != null ? new o(uVar2.getAnnotations(), K0) : null);
        if (aVar.f56338h) {
            kotlin.reflect.jvm.internal.impl.utils.f a4 = kotlin.reflect.jvm.internal.impl.utils.f.a();
            for (p0 p0Var : d()) {
                a4.add(p0Var.c(b4));
            }
            K0.A0(a4);
        }
        if (isConst() && (jVar = this.f56425h) != null) {
            K0.G0(jVar);
        }
        return K0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public s0 M() {
        return this.f56325u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    @Nullable
    /* renamed from: M0 */
    public d0 getGetter() {
        return this.f56328x;
    }

    public void P0(@Nullable d0 d0Var, @Nullable r0 r0Var) {
        Q0(d0Var, r0Var, null, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public s0 Q() {
        return this.f56326v;
    }

    public void Q0(@Nullable d0 d0Var, @Nullable r0 r0Var, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.u uVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.u uVar2) {
        this.f56328x = d0Var;
        this.f56329y = r0Var;
        this.A = uVar;
        this.B = uVar2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.u R() {
        return this.B;
    }

    public boolean R0() {
        return this.f56330z;
    }

    @NotNull
    public a S0() {
        return new a();
    }

    public void U0(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
        if (e0Var == null) {
            B(14);
        }
    }

    public void V0(boolean z3) {
        this.f56330z = z3;
    }

    public void W0(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @NotNull List<? extends a1> list, @Nullable s0 s0Var, @Nullable s0 s0Var2) {
        if (e0Var == null) {
            B(15);
        }
        if (list == null) {
            B(16);
        }
        F0(e0Var);
        this.f56327w = new ArrayList(list);
        this.f56326v = s0Var2;
        this.f56325u = s0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean X() {
        return this.f56322r;
    }

    public void X0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        if (sVar == null) {
            B(17);
        }
        this.f56315k = sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public Collection<? extends p0> d() {
        Collection<? extends p0> collection = this.f56316l;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            B(37);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.e0 getReturnType() {
        kotlin.reflect.jvm.internal.impl.types.e0 type = getType();
        if (type == null) {
            B(19);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    @Nullable
    public r0 getSetter() {
        return this.f56329y;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<a1> getTypeParameters() {
        List<a1> list = this.f56327w;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = this.f56315k;
        if (sVar == null) {
            B(21);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind i() {
        CallableMemberDescriptor.Kind kind = this.f56318n;
        if (kind == null) {
            B(35);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean i0() {
        return this.f56321q;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.f1
    public boolean isConst() {
        return this.f56320p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean isExternal() {
        return this.f56323s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        Modality modality = this.f56314j;
        if (modality == null) {
            B(20);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public <V> V s0(a.InterfaceC1126a<V> interfaceC1126a) {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p0
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.u u0() {
        return this.A;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f1
    public boolean v0() {
        return this.f56319o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.x0
    public p0 c(@NotNull f1 f1Var) {
        if (f1Var == null) {
            B(23);
        }
        return f1Var.k() ? this : S0().v(f1Var.j()).t(h0()).n();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.m0, kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: a */
    public p0 h0() {
        p0 p0Var = this.f56317m;
        p0 a4 = p0Var == this ? this : p0Var.a();
        if (a4 == null) {
            B(34);
        }
        return a4;
    }
}
