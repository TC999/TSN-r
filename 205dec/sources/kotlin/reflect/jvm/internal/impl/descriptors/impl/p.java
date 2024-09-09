package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FunctionDescriptorImpl.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class p extends k implements kotlin.reflect.jvm.internal.impl.descriptors.w {
    private final CallableMemberDescriptor.Kind A;
    @Nullable
    private kotlin.reflect.jvm.internal.impl.descriptors.w B;
    protected Map<a.InterfaceC1126a<?>, Object> C;

    /* renamed from: e  reason: collision with root package name */
    private List<a1> f56427e;

    /* renamed from: f  reason: collision with root package name */
    private List<d1> f56428f;

    /* renamed from: g  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.types.e0 f56429g;

    /* renamed from: h  reason: collision with root package name */
    private s0 f56430h;

    /* renamed from: i  reason: collision with root package name */
    private s0 f56431i;

    /* renamed from: j  reason: collision with root package name */
    private Modality f56432j;

    /* renamed from: k  reason: collision with root package name */
    private kotlin.reflect.jvm.internal.impl.descriptors.s f56433k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f56434l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f56435m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f56436n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f56437o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f56438p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f56439q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f56440r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f56441s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f56442t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f56443u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f56444v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f56445w;

    /* renamed from: x  reason: collision with root package name */
    private Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w> f56446x;

    /* renamed from: y  reason: collision with root package name */
    private volatile d2.a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.w>> f56447y;

    /* renamed from: z  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.w f56448z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FunctionDescriptorImpl.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements d2.a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.w>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f1 f56449a;

        a(f1 f1Var) {
            this.f56449a = f1Var;
        }

        @Override // d2.a
        /* renamed from: a */
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.w> invoke() {
            kotlin.reflect.jvm.internal.impl.utils.e eVar = new kotlin.reflect.jvm.internal.impl.utils.e();
            for (kotlin.reflect.jvm.internal.impl.descriptors.w wVar : p.this.d()) {
                eVar.add(wVar.c(this.f56449a));
            }
            return eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FunctionDescriptorImpl.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b implements d2.a<List<kotlin.reflect.jvm.internal.impl.descriptors.f1>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f56451a;

        b(List list) {
            this.f56451a = list;
        }

        @Override // d2.a
        /* renamed from: a */
        public List<kotlin.reflect.jvm.internal.impl.descriptors.f1> invoke() {
            return this.f56451a;
        }
    }

    /* compiled from: FunctionDescriptorImpl.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class c implements w.a<kotlin.reflect.jvm.internal.impl.descriptors.w> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.types.d1 f56452a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.descriptors.k f56453b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        protected Modality f56454c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.descriptors.s f56455d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.descriptors.w f56456e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        protected CallableMemberDescriptor.Kind f56457f;
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        protected List<d1> f56458g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        protected s0 f56459h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        protected s0 f56460i;
        @NotNull

        /* renamed from: j  reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.types.e0 f56461j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        protected kotlin.reflect.jvm.internal.impl.name.f f56462k;

        /* renamed from: l  reason: collision with root package name */
        protected boolean f56463l;

        /* renamed from: m  reason: collision with root package name */
        protected boolean f56464m;

        /* renamed from: n  reason: collision with root package name */
        protected boolean f56465n;

        /* renamed from: o  reason: collision with root package name */
        protected boolean f56466o;

        /* renamed from: p  reason: collision with root package name */
        private boolean f56467p;

        /* renamed from: q  reason: collision with root package name */
        private List<a1> f56468q;

        /* renamed from: r  reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f56469r;

        /* renamed from: s  reason: collision with root package name */
        private boolean f56470s;

        /* renamed from: t  reason: collision with root package name */
        private Map<a.InterfaceC1126a<?>, Object> f56471t;

        /* renamed from: u  reason: collision with root package name */
        private Boolean f56472u;

        /* renamed from: v  reason: collision with root package name */
        protected boolean f56473v;

        /* renamed from: w  reason: collision with root package name */
        final /* synthetic */ p f56474w;

        public c(@NotNull p pVar, @NotNull kotlin.reflect.jvm.internal.impl.types.d1 d1Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @NotNull Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable List<d1> list, @NotNull s0 s0Var, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var, kotlin.reflect.jvm.internal.impl.name.f fVar) {
            if (d1Var == null) {
                u(0);
            }
            if (kVar == null) {
                u(1);
            }
            if (modality == null) {
                u(2);
            }
            if (sVar == null) {
                u(3);
            }
            if (kind == null) {
                u(4);
            }
            if (list == null) {
                u(5);
            }
            if (e0Var == null) {
                u(6);
            }
            this.f56474w = pVar;
            this.f56456e = null;
            this.f56460i = pVar.f56431i;
            this.f56463l = true;
            this.f56464m = false;
            this.f56465n = false;
            this.f56466o = false;
            this.f56467p = pVar.z0();
            this.f56468q = null;
            this.f56469r = null;
            this.f56470s = pVar.B0();
            this.f56471t = new LinkedHashMap();
            this.f56472u = null;
            this.f56473v = false;
            this.f56452a = d1Var;
            this.f56453b = kVar;
            this.f56454c = modality;
            this.f56455d = sVar;
            this.f56457f = kind;
            this.f56458g = list;
            this.f56459h = s0Var;
            this.f56461j = e0Var;
            this.f56462k = fVar;
        }

        private static /* synthetic */ void u(int i4) {
            String str;
            int i5;
            switch (i4) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i4) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i5 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i5 = 3;
                    break;
            }
            Object[] objArr = new Object[i5];
            switch (i4) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = "owner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                case 18:
                case 20:
                    objArr[0] = "parameters";
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i4) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i4) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i4) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    throw new IllegalStateException(format);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: B */
        public c s(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar) {
            if (fVar == null) {
                u(32);
            }
            this.f56469r = fVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: C */
        public c o(boolean z3) {
            this.f56463l = z3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: D */
        public c c(@Nullable s0 s0Var) {
            this.f56460i = s0Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: E */
        public c a() {
            this.f56466o = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: F */
        public c e(@Nullable s0 s0Var) {
            this.f56459h = s0Var;
            return this;
        }

        public c G(boolean z3) {
            this.f56472u = Boolean.valueOf(z3);
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: H */
        public c d() {
            this.f56470s = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: I */
        public c i() {
            this.f56467p = true;
            return this;
        }

        @NotNull
        public c J(boolean z3) {
            this.f56473v = z3;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: K */
        public c r(@NotNull CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                u(13);
            }
            this.f56457f = kind;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: L */
        public c k(@NotNull Modality modality) {
            if (modality == null) {
                u(9);
            }
            this.f56454c = modality;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: M */
        public c j(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
            if (fVar == null) {
                u(16);
            }
            this.f56462k = fVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: N */
        public c n(@Nullable CallableMemberDescriptor callableMemberDescriptor) {
            this.f56456e = (kotlin.reflect.jvm.internal.impl.descriptors.w) callableMemberDescriptor;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: O */
        public c q(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            if (kVar == null) {
                u(7);
            }
            this.f56453b = kVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: P */
        public c l() {
            this.f56465n = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: Q */
        public c m(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
            if (e0Var == null) {
                u(22);
            }
            this.f56461j = e0Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: R */
        public c t() {
            this.f56464m = true;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: S */
        public c f(@NotNull kotlin.reflect.jvm.internal.impl.types.d1 d1Var) {
            if (d1Var == null) {
                u(34);
            }
            this.f56452a = d1Var;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: T */
        public c p(@NotNull List<a1> list) {
            if (list == null) {
                u(20);
            }
            this.f56468q = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: U */
        public c b(@NotNull List<d1> list) {
            if (list == null) {
                u(18);
            }
            this.f56458g = list;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        /* renamed from: V */
        public c h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
            if (sVar == null) {
                u(11);
            }
            this.f56455d = sVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.w build() {
            return this.f56474w.H0(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.w.a
        @NotNull
        public <V> w.a<kotlin.reflect.jvm.internal.impl.descriptors.w> g(@NotNull a.InterfaceC1126a<V> interfaceC1126a, V v3) {
            if (interfaceC1126a == null) {
                u(36);
            }
            this.f56471t.put(interfaceC1126a, v3);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.w wVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar2, @NotNull CallableMemberDescriptor.Kind kind, @NotNull v0 v0Var) {
        super(kVar, fVar, fVar2, v0Var);
        if (kVar == null) {
            B(0);
        }
        if (fVar == null) {
            B(1);
        }
        if (fVar2 == null) {
            B(2);
        }
        if (kind == null) {
            B(3);
        }
        if (v0Var == null) {
            B(4);
        }
        this.f56433k = kotlin.reflect.jvm.internal.impl.descriptors.r.f56535i;
        this.f56434l = false;
        this.f56435m = false;
        this.f56436n = false;
        this.f56437o = false;
        this.f56438p = false;
        this.f56439q = false;
        this.f56440r = false;
        this.f56441s = false;
        this.f56442t = false;
        this.f56443u = false;
        this.f56444v = true;
        this.f56445w = false;
        this.f56446x = null;
        this.f56447y = null;
        this.B = null;
        this.C = null;
        this.f56448z = wVar == null ? this : wVar;
        this.A = kind;
    }

    private static /* synthetic */ void B(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i5 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = "source";
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i4) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i4) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @NotNull
    private v0 I0(boolean z3, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.w wVar) {
        v0 v0Var;
        if (z3) {
            if (wVar == null) {
                wVar = h0();
            }
            v0Var = wVar.getSource();
        } else {
            v0Var = v0.f56634a;
        }
        if (v0Var == null) {
            B(25);
        }
        return v0Var;
    }

    @Nullable
    public static List<d1> J0(kotlin.reflect.jvm.internal.impl.descriptors.w wVar, @NotNull List<d1> list, @NotNull f1 f1Var) {
        if (list == null) {
            B(26);
        }
        if (f1Var == null) {
            B(27);
        }
        return K0(wVar, list, f1Var, false, false, null);
    }

    @Nullable
    public static List<d1> K0(kotlin.reflect.jvm.internal.impl.descriptors.w wVar, @NotNull List<d1> list, @NotNull f1 f1Var, boolean z3, boolean z4, @Nullable boolean[] zArr) {
        if (list == null) {
            B(28);
        }
        if (f1Var == null) {
            B(29);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (d1 d1Var : list) {
            kotlin.reflect.jvm.internal.impl.types.e0 type = d1Var.getType();
            Variance variance = Variance.IN_VARIANCE;
            kotlin.reflect.jvm.internal.impl.types.e0 p3 = f1Var.p(type, variance);
            kotlin.reflect.jvm.internal.impl.types.e0 t02 = d1Var.t0();
            kotlin.reflect.jvm.internal.impl.types.e0 p4 = t02 == null ? null : f1Var.p(t02, variance);
            if (p3 == null) {
                return null;
            }
            if ((p3 != d1Var.getType() || t02 != p4) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(l0.G0(wVar, z3 ? null : d1Var, d1Var.f(), d1Var.getAnnotations(), d1Var.getName(), p3, d1Var.x0(), d1Var.p0(), d1Var.n0(), p4, z4 ? d1Var.getSource() : v0.f56634a, d1Var instanceof l0.b ? new b(((l0.b) d1Var).J0()) : null));
        }
        return arrayList;
    }

    private void O0() {
        d2.a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.w>> aVar = this.f56447y;
        if (aVar != null) {
            this.f56446x = aVar.invoke();
            this.f56447y = null;
        }
    }

    private void V0(boolean z3) {
        this.f56442t = z3;
    }

    private void W0(boolean z3) {
        this.f56441s = z3;
    }

    private void Y0(@Nullable kotlin.reflect.jvm.internal.impl.descriptors.w wVar) {
        this.B = wVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void A0(@NotNull Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            B(15);
        }
        this.f56446x = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((kotlin.reflect.jvm.internal.impl.descriptors.w) it.next()).B0()) {
                this.f56442t = true;
                return;
            }
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean B0() {
        return this.f56442t;
    }

    public <R, D> R C(kotlin.reflect.jvm.internal.impl.descriptors.m<R, D> mVar, D d4) {
        return mVar.i(this, d4);
    }

    public boolean E() {
        return this.f56438p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    /* renamed from: F0 */
    public kotlin.reflect.jvm.internal.impl.descriptors.w P(kotlin.reflect.jvm.internal.impl.descriptors.k kVar, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, CallableMemberDescriptor.Kind kind, boolean z3) {
        kotlin.reflect.jvm.internal.impl.descriptors.w build = x().q(kVar).k(modality).h(sVar).r(kind).o(z3).build();
        if (build == null) {
            B(24);
        }
        return build;
    }

    @NotNull
    protected abstract p G0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.k kVar, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.w wVar, @NotNull CallableMemberDescriptor.Kind kind, @Nullable kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2, @NotNull v0 v0Var);

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.w H0(@NotNull c cVar) {
        f0 f0Var;
        s0 s0Var;
        kotlin.reflect.jvm.internal.impl.types.e0 p3;
        if (cVar == null) {
            B(23);
        }
        boolean[] zArr = new boolean[1];
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f a4 = cVar.f56469r != null ? kotlin.reflect.jvm.internal.impl.descriptors.annotations.h.a(getAnnotations(), cVar.f56469r) : getAnnotations();
        kotlin.reflect.jvm.internal.impl.descriptors.k kVar = cVar.f56453b;
        kotlin.reflect.jvm.internal.impl.descriptors.w wVar = cVar.f56456e;
        p G0 = G0(kVar, wVar, cVar.f56457f, cVar.f56462k, a4, I0(cVar.f56465n, wVar));
        List<a1> typeParameters = cVar.f56468q == null ? getTypeParameters() : cVar.f56468q;
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        f1 c4 = kotlin.reflect.jvm.internal.impl.types.r.c(typeParameters, cVar.f56452a, G0, arrayList, zArr);
        if (c4 == null) {
            return null;
        }
        s0 s0Var2 = cVar.f56459h;
        if (s0Var2 != null) {
            kotlin.reflect.jvm.internal.impl.types.e0 p4 = c4.p(s0Var2.getType(), Variance.IN_VARIANCE);
            if (p4 == null) {
                return null;
            }
            f0 f0Var2 = new f0(G0, new kotlin.reflect.jvm.internal.impl.resolve.scopes.receivers.b(G0, p4, cVar.f56459h.getValue()), cVar.f56459h.getAnnotations());
            zArr[0] = (p4 != cVar.f56459h.getType()) | zArr[0];
            f0Var = f0Var2;
        } else {
            f0Var = null;
        }
        s0 s0Var3 = cVar.f56460i;
        if (s0Var3 != null) {
            s0 c5 = s0Var3.c(c4);
            if (c5 == null) {
                return null;
            }
            zArr[0] = zArr[0] | (c5 != cVar.f56460i);
            s0Var = c5;
        } else {
            s0Var = null;
        }
        List<d1> K0 = K0(G0, cVar.f56458g, c4, cVar.f56466o, cVar.f56465n, zArr);
        if (K0 == null || (p3 = c4.p(cVar.f56461j, Variance.OUT_VARIANCE)) == null) {
            return null;
        }
        zArr[0] = zArr[0] | (p3 != cVar.f56461j);
        if (zArr[0] || !cVar.f56473v) {
            G0.M0(f0Var, s0Var, arrayList, K0, p3, cVar.f56454c, cVar.f56455d);
            G0.a1(this.f56434l);
            G0.X0(this.f56435m);
            G0.S0(this.f56436n);
            G0.Z0(this.f56437o);
            G0.d1(this.f56438p);
            G0.c1(this.f56443u);
            G0.R0(this.f56439q);
            G0.Q0(this.f56440r);
            G0.T0(this.f56444v);
            G0.W0(cVar.f56467p);
            G0.V0(cVar.f56470s);
            G0.U0(cVar.f56472u != null ? cVar.f56472u.booleanValue() : this.f56445w);
            if (!cVar.f56471t.isEmpty() || this.C != null) {
                Map<a.InterfaceC1126a<?>, Object> map = cVar.f56471t;
                Map<a.InterfaceC1126a<?>, Object> map2 = this.C;
                if (map2 != null) {
                    for (Map.Entry<a.InterfaceC1126a<?>, Object> entry : map2.entrySet()) {
                        if (!map.containsKey(entry.getKey())) {
                            map.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (map.size() == 1) {
                    G0.C = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
                } else {
                    G0.C = map;
                }
            }
            if (cVar.f56464m || q0() != null) {
                G0.Y0((q0() != null ? q0() : this).c(c4));
            }
            if (cVar.f56463l && !h0().d().isEmpty()) {
                if (cVar.f56452a.f()) {
                    d2.a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.w>> aVar = this.f56447y;
                    if (aVar != null) {
                        G0.f56447y = aVar;
                    } else {
                        G0.A0(d());
                    }
                } else {
                    G0.f56447y = new a(c4);
                }
            }
            return G0;
        }
        return this;
    }

    public boolean L0() {
        return this.f56444v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public s0 M() {
        return this.f56431i;
    }

    @NotNull
    public p M0(@Nullable s0 s0Var, @Nullable s0 s0Var2, @NotNull List<? extends a1> list, @NotNull List<d1> list2, @Nullable kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @Nullable Modality modality, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        List<a1> G5;
        List<d1> G52;
        if (list == null) {
            B(5);
        }
        if (list2 == null) {
            B(6);
        }
        if (sVar == null) {
            B(7);
        }
        G5 = kotlin.collections.f0.G5(list);
        this.f56427e = G5;
        G52 = kotlin.collections.f0.G5(list2);
        this.f56428f = G52;
        this.f56429g = e0Var;
        this.f56432j = modality;
        this.f56433k = sVar;
        this.f56430h = s0Var;
        this.f56431i = s0Var2;
        for (int i4 = 0; i4 < list.size(); i4++) {
            a1 a1Var = list.get(i4);
            if (a1Var.f() != i4) {
                throw new IllegalStateException(a1Var + " index is " + a1Var.f() + " but position is " + i4);
            }
        }
        for (int i5 = 0; i5 < list2.size(); i5++) {
            d1 d1Var = list2.get(i5);
            if (d1Var.f() != i5 + 0) {
                throw new IllegalStateException(d1Var + "index is " + d1Var.f() + " but position is " + i5);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public c N0(@NotNull f1 f1Var) {
        if (f1Var == null) {
            B(22);
        }
        return new c(this, f1Var.j(), b(), s(), getVisibility(), i(), h(), Q(), getReturnType(), null);
    }

    public <V> void P0(a.InterfaceC1126a<V> interfaceC1126a, Object obj) {
        if (this.C == null) {
            this.C = new LinkedHashMap();
        }
        this.C.put(interfaceC1126a, obj);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @Nullable
    public s0 Q() {
        return this.f56430h;
    }

    public void Q0(boolean z3) {
        this.f56440r = z3;
    }

    public void R0(boolean z3) {
        this.f56439q = z3;
    }

    public void S0(boolean z3) {
        this.f56436n = z3;
    }

    public void T0(boolean z3) {
        this.f56444v = z3;
    }

    public void U0(boolean z3) {
        this.f56445w = z3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean X() {
        return this.f56440r;
    }

    public void X0(boolean z3) {
        this.f56435m = z3;
    }

    public void Z0(boolean z3) {
        this.f56437o = z3;
    }

    public void a1(boolean z3) {
        this.f56434l = z3;
    }

    public void b1(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var) {
        if (e0Var == null) {
            B(10);
        }
        this.f56429g = e0Var;
    }

    public void c1(boolean z3) {
        this.f56443u = z3;
    }

    @NotNull
    public Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w> d() {
        O0();
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.w> collection = this.f56446x;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            B(12);
        }
        return collection;
    }

    public void d1(boolean z3) {
        this.f56438p = z3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public boolean e0() {
        return this.f56445w;
    }

    public void e1(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        if (sVar == null) {
            B(9);
        }
        this.f56433k = sVar;
    }

    public kotlin.reflect.jvm.internal.impl.types.e0 getReturnType() {
        return this.f56429g;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<a1> getTypeParameters() {
        List<a1> list = this.f56427e;
        if (list != null) {
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = this.f56433k;
        if (sVar == null) {
            B(14);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    @NotNull
    public List<d1> h() {
        List<d1> list = this.f56428f;
        if (list == null) {
            B(17);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @NotNull
    public CallableMemberDescriptor.Kind i() {
        CallableMemberDescriptor.Kind kind = this.A;
        if (kind == null) {
            B(19);
        }
        return kind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean i0() {
        return this.f56439q;
    }

    public boolean isExternal() {
        return this.f56436n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean isInfix() {
        if (this.f56435m) {
            return true;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.w wVar : h0().d()) {
            if (wVar.isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.f56437o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean isOperator() {
        if (this.f56434l) {
            return true;
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.w wVar : h0().d()) {
            if (wVar.isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean isSuspend() {
        return this.f56443u;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.w q0() {
        return this.B;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        Modality modality = this.f56432j;
        if (modality == null) {
            B(13);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V s0(a.InterfaceC1126a<V> interfaceC1126a) {
        Map<a.InterfaceC1126a<?>, Object> map = this.C;
        if (map == null) {
            return null;
        }
        return (V) map.get(interfaceC1126a);
    }

    @NotNull
    public w.a<? extends kotlin.reflect.jvm.internal.impl.descriptors.w> x() {
        c N0 = N0(f1.f58353b);
        if (N0 == null) {
            B(21);
        }
        return N0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w
    public boolean z0() {
        return this.f56441s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w, kotlin.reflect.jvm.internal.impl.descriptors.x0
    public kotlin.reflect.jvm.internal.impl.descriptors.w c(@NotNull f1 f1Var) {
        if (f1Var == null) {
            B(20);
        }
        return f1Var.k() ? this : N0(f1Var).n(h0()).l().J(true).build();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.k
    @NotNull
    /* renamed from: a */
    public kotlin.reflect.jvm.internal.impl.descriptors.w h0() {
        kotlin.reflect.jvm.internal.impl.descriptors.w wVar = this.f56448z;
        kotlin.reflect.jvm.internal.impl.descriptors.w a4 = wVar == this ? this : wVar.a();
        if (a4 == null) {
            B(18);
        }
        return a4;
    }
}
