package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.ReportLevel;
import kotlin.reflect.jvm.internal.impl.load.java.u;
import kotlin.reflect.jvm.internal.impl.load.java.v;
import kotlin.reflect.jvm.internal.impl.load.java.z;
import kotlin.reflect.jvm.internal.impl.types.a0;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.h1;
import kotlin.reflect.jvm.internal.impl.types.l0;
import kotlin.reflect.jvm.internal.impl.types.l1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: signatureEnhancement.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.b f57048a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final u f57049b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.c f57050c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final e0 f57051a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f57052b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f57053c;

        public a(@NotNull e0 type, boolean z3, boolean z4) {
            f0.p(type, "type");
            this.f57051a = type;
            this.f57052b = z3;
            this.f57053c = z4;
        }

        public final boolean a() {
            return this.f57053c;
        }

        public final boolean b() {
            return this.f57052b;
        }

        @NotNull
        public final e0 getType() {
            return this.f57051a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<CallableMemberDescriptor, e0> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f57069a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final e0 invoke(@NotNull CallableMemberDescriptor it) {
            f0.p(it, "it");
            s0 Q = it.Q();
            f0.m(Q);
            e0 type = Q.getType();
            f0.o(type, "it.extensionReceiverParameter!!.type");
            return type;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends Lambda implements d2.l<CallableMemberDescriptor, e0> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f57070a = new d();

        d() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final e0 invoke(@NotNull CallableMemberDescriptor it) {
            f0.p(it, "it");
            e0 returnType = it.getReturnType();
            f0.m(returnType);
            f0.o(returnType, "it.returnType!!");
            return returnType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends Lambda implements d2.l<CallableMemberDescriptor, e0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d1 f57071a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(d1 d1Var) {
            super(1);
            this.f57071a = d1Var;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final e0 invoke(@NotNull CallableMemberDescriptor it) {
            f0.p(it, "it");
            e0 type = it.h().get(this.f57071a.f()).getType();
            f0.o(type, "it.valueParameters[p.index].type");
            return type;
        }
    }

    /* compiled from: signatureEnhancement.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class f extends Lambda implements d2.l<l1, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final f f57072a = new f();

        f() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull l1 it) {
            f0.p(it, "it");
            return Boolean.valueOf(it instanceof l0);
        }
    }

    public i(@NotNull kotlin.reflect.jvm.internal.impl.load.java.b annotationTypeQualifierResolver, @NotNull u javaTypeEnhancementState, @NotNull kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.c typeEnhancement) {
        f0.p(annotationTypeQualifierResolver, "annotationTypeQualifierResolver");
        f0.p(javaTypeEnhancementState, "javaTypeEnhancementState");
        f0.p(typeEnhancement, "typeEnhancement");
        this.f57048a = annotationTypeQualifierResolver;
        this.f57049b = javaTypeEnhancementState;
        this.f57050c = typeEnhancement;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f c(kotlin.reflect.jvm.internal.impl.name.c cVar, kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar2, boolean z3) {
        ReportLevel invoke = this.f57049b.c().invoke(cVar);
        if (invoke.isIgnore()) {
            return null;
        }
        boolean z4 = invoke.isWarning() || z3;
        if (z.l().contains(cVar)) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NULLABLE, z4);
        }
        if (z.k().contains(cVar)) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NOT_NULL, z4);
        }
        if (f0.g(cVar, z.g())) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NULLABLE, z4);
        }
        if (f0.g(cVar, z.h())) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.FORCE_FLEXIBILITY, z4);
        }
        if (f0.g(cVar, z.f())) {
            return j(cVar2, z4);
        }
        if (f0.g(cVar, z.d())) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NULLABLE, z4);
        }
        if (f0.g(cVar, z.c())) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NOT_NULL, z4);
        }
        if (f0.g(cVar, z.a())) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NOT_NULL, z4);
        }
        if (f0.g(cVar, z.b())) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NULLABLE, z4);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x018f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> D d(D r18, kotlin.reflect.jvm.internal.impl.load.java.lazy.h r19) {
        /*
            Method dump skipped, instructions count: 554
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i.d(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.load.java.lazy.h):kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor");
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, boolean z3, boolean z4) {
        kotlin.reflect.jvm.internal.impl.name.c e4 = cVar.e();
        if (e4 == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f c4 = c(e4, cVar, (cVar instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.e) && (((kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.e) cVar).j() || z4) && !z3);
        if (c4 == null) {
            return null;
        }
        return (!c4.d() && (cVar instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.g) && ((kotlin.reflect.jvm.internal.impl.load.java.descriptors.g) cVar).d()) ? kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f.b(c4, null, true, 1, null) : c4;
    }

    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f j(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar, boolean z3) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> b4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.b(cVar);
        kotlin.reflect.jvm.internal.impl.resolve.constants.j jVar = b4 instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.j ? (kotlin.reflect.jvm.internal.impl.resolve.constants.j) b4 : null;
        if (jVar == null) {
            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NOT_NULL, z3);
        }
        String b5 = jVar.b().b();
        switch (b5.hashCode()) {
            case 73135176:
                if (!b5.equals("MAYBE")) {
                    return null;
                }
                break;
            case 74175084:
                if (!b5.equals("NEVER")) {
                    return null;
                }
                break;
            case 433141802:
                if (b5.equals("UNKNOWN")) {
                    return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.FORCE_FLEXIBILITY, z3);
                }
                return null;
            case 1933739535:
                if (b5.equals("ALWAYS")) {
                    return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NOT_NULL, z3);
                }
                return null;
            default:
                return null;
        }
        return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NULLABLE, z3);
    }

    private final <D extends CallableMemberDescriptor> kotlin.reflect.jvm.internal.impl.descriptors.annotations.f k(D d4, kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar) {
        int Z;
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> k4;
        kotlin.reflect.jvm.internal.impl.descriptors.f a4 = q.a(d4);
        if (a4 == null) {
            return d4.getAnnotations();
        }
        kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f fVar = a4 instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f ? (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.f) a4 : null;
        List<m2.a> L0 = fVar != null ? fVar.L0() : null;
        if (L0 == null || L0.isEmpty()) {
            return d4.getAnnotations();
        }
        Z = y.Z(L0, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (m2.a aVar : L0) {
            arrayList.add(new kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.e(hVar, aVar, true));
        }
        f.a aVar2 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0;
        k4 = kotlin.collections.f0.k4(d4.getAnnotations(), arrayList);
        return aVar2.a(k4);
    }

    private final b l(CallableMemberDescriptor callableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, boolean z3, kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, d2.l<? super CallableMemberDescriptor, ? extends e0> lVar) {
        int Z;
        e0 invoke = lVar.invoke(callableMemberDescriptor);
        Collection<? extends CallableMemberDescriptor> d4 = callableMemberDescriptor.d();
        f0.o(d4, "this.overriddenDescriptors");
        Z = y.Z(d4, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (CallableMemberDescriptor it : d4) {
            f0.o(it, "it");
            arrayList.add(lVar.invoke(it));
        }
        return new b(aVar, invoke, arrayList, z3, kotlin.reflect.jvm.internal.impl.load.java.lazy.a.h(hVar, lVar.invoke(callableMemberDescriptor).getAnnotations()), annotationQualifierApplicabilityType, false, false, 192, null);
    }

    private final b m(CallableMemberDescriptor callableMemberDescriptor, d1 d1Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, d2.l<? super CallableMemberDescriptor, ? extends e0> lVar) {
        if (d1Var != null) {
            hVar = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.h(hVar, d1Var.getAnnotations());
        }
        return l(callableMemberDescriptor, d1Var, false, hVar, AnnotationQualifierApplicabilityType.VALUE_PARAMETER, lVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final <D extends CallableMemberDescriptor> Collection<D> e(@NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h c4, @NotNull Collection<? extends D> platformSignatures) {
        int Z;
        f0.p(c4, "c");
        f0.p(platformSignatures, "platformSignatures");
        Z = y.Z(platformSignatures, 10);
        ArrayList arrayList = new ArrayList(Z);
        Iterator<T> it = platformSignatures.iterator();
        while (it.hasNext()) {
            arrayList.add(d((CallableMemberDescriptor) it.next(), c4));
        }
        return arrayList;
    }

    @NotNull
    public final e0 f(@NotNull e0 type, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h context) {
        List F;
        f0.p(type, "type");
        f0.p(context, "context");
        F = CollectionsKt__CollectionsKt.F();
        return b.h(new b(null, type, F, false, context, AnnotationQualifierApplicabilityType.TYPE_USE, false, true, 64, null), null, false, 3, null).getType();
    }

    @NotNull
    public final List<e0> g(@NotNull a1 typeParameter, @NotNull List<? extends e0> bounds, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h context) {
        int Z;
        List F;
        Iterator it;
        f0.p(typeParameter, "typeParameter");
        f0.p(bounds, "bounds");
        f0.p(context, "context");
        Z = y.Z(bounds, 10);
        ArrayList arrayList = new ArrayList(Z);
        Iterator it2 = bounds.iterator();
        while (it2.hasNext()) {
            e0 e0Var = (e0) it2.next();
            if (kotlin.reflect.jvm.internal.impl.types.typeUtil.a.b(e0Var, f.f57072a)) {
                it = it2;
            } else {
                F = CollectionsKt__CollectionsKt.F();
                it = it2;
                e0Var = b.h(new b(typeParameter, e0Var, F, false, context, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, true, false, 128, null), null, false, 3, null).getType();
            }
            arrayList.add(e0Var);
            it2 = it;
        }
        return arrayList;
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f h(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.c annotationDescriptor, boolean z3, boolean z4) {
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f i4;
        f0.p(annotationDescriptor, "annotationDescriptor");
        kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f i5 = i(annotationDescriptor, z3, z4);
        if (i5 == null) {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.c m4 = this.f57048a.m(annotationDescriptor);
            if (m4 == null) {
                return null;
            }
            ReportLevel j4 = this.f57048a.j(annotationDescriptor);
            if (j4.isIgnore() || (i4 = i(m4, z3, z4)) == null) {
                return null;
            }
            return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f.b(i4, null, j4.isWarning(), 1, null);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.a f57054a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final e0 f57055b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final Collection<e0> f57056c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f57057d;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.load.java.lazy.h f57058e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final AnnotationQualifierApplicabilityType f57059f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f57060g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f57061h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: signatureEnhancement.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends Lambda implements d2.l<Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d[] f57063a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d[] dVarArr) {
                super(1);
                this.f57063a = dVarArr;
            }

            @NotNull
            public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d a(int i4) {
                int Td;
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d[] dVarArr = this.f57063a;
                if (i4 >= 0) {
                    Td = kotlin.collections.p.Td(dVarArr);
                    if (i4 <= Td) {
                        return dVarArr[i4];
                    }
                }
                return kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d.f56999e.a();
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d invoke(Integer num) {
                return a(num.intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: signatureEnhancement.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public /* synthetic */ class C1142b extends FunctionReference implements d2.l<l1, Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public static final C1142b f57064a = new C1142b();

            C1142b() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: d */
            public final Boolean invoke(@NotNull l1 p02) {
                f0.p(p02, "p0");
                return Boolean.valueOf(b.g(p02));
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
            @NotNull
            public final String getName() {
                return "containsFunctionN";
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final kotlin.reflect.h getOwner() {
                return n0.d(f0.a.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final String getSignature() {
                return "enhance$containsFunctionN(Lorg/jetbrains/kotlin/types/UnwrappedType;)Z";
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: signatureEnhancement.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends Lambda implements d2.l<e0, Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public static final c f57065a = new c();

            c() {
                super(1);
            }

            @Override // d2.l
            /* renamed from: a */
            public final Boolean invoke(e0 e0Var) {
                return Boolean.valueOf(e0Var instanceof l0);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: signatureEnhancement.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public /* synthetic */ class d extends FunctionReference implements d2.l<l1, Boolean> {

            /* renamed from: a  reason: collision with root package name */
            public static final d f57066a = new d();

            d() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: d */
            public final Boolean invoke(@NotNull l1 p02) {
                f0.p(p02, "p0");
                return Boolean.valueOf(b.g(p02));
            }

            @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
            @NotNull
            public final String getName() {
                return "containsFunctionN";
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final kotlin.reflect.h getOwner() {
                return n0.d(f0.a.class);
            }

            @Override // kotlin.jvm.internal.CallableReference
            @NotNull
            public final String getSignature() {
                return "enhance$containsFunctionN(Lorg/jetbrains/kotlin/types/UnwrappedType;)Z";
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: signatureEnhancement.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class e extends Lambda implements d2.l<Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f57067a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d2.l<Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d> f57068b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            e(n nVar, d2.l<? super Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d> lVar) {
                super(1);
                this.f57067a = nVar;
                this.f57068b = lVar;
            }

            @NotNull
            public final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d a(int i4) {
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d dVar = this.f57067a.a().get(Integer.valueOf(i4));
                return dVar == null ? this.f57068b.invoke(Integer.valueOf(i4)) : dVar;
            }

            @Override // d2.l
            public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d invoke(Integer num) {
                return a(num.intValue());
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(@Nullable i this$0, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, @NotNull e0 fromOverride, Collection<? extends e0> fromOverridden, @NotNull boolean z3, @NotNull kotlin.reflect.jvm.internal.impl.load.java.lazy.h containerContext, AnnotationQualifierApplicabilityType containerApplicabilityType, boolean z4, boolean z5) {
            f0.p(this$0, "this$0");
            f0.p(fromOverride, "fromOverride");
            f0.p(fromOverridden, "fromOverridden");
            f0.p(containerContext, "containerContext");
            f0.p(containerApplicabilityType, "containerApplicabilityType");
            i.this = this$0;
            this.f57054a = aVar;
            this.f57055b = fromOverride;
            this.f57056c = fromOverridden;
            this.f57057d = z3;
            this.f57058e = containerContext;
            this.f57059f = containerApplicabilityType;
            this.f57060g = z4;
            this.f57061h = z5;
        }

        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f b(a1 a1Var) {
            boolean z3;
            boolean b4;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            if (a1Var instanceof kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.m) {
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.m mVar = (kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.m) a1Var;
                List<e0> upperBounds = mVar.getUpperBounds();
                f0.o(upperBounds, "upperBounds");
                boolean z8 = false;
                boolean z9 = true;
                if (!(upperBounds instanceof Collection) || !upperBounds.isEmpty()) {
                    for (e0 e0Var : upperBounds) {
                        if (!g0.a(e0Var)) {
                            z3 = false;
                            break;
                        }
                    }
                }
                z3 = true;
                if (!z3) {
                    List<e0> upperBounds2 = mVar.getUpperBounds();
                    f0.o(upperBounds2, "upperBounds");
                    if (!(upperBounds2 instanceof Collection) || !upperBounds2.isEmpty()) {
                        for (e0 e0Var2 : upperBounds2) {
                            b4 = k.b(e0Var2);
                            if (!b4) {
                                z4 = false;
                                break;
                            }
                        }
                    }
                    z4 = true;
                    if (z4) {
                        List<e0> upperBounds3 = mVar.getUpperBounds();
                        f0.o(upperBounds3, "upperBounds");
                        if (!(upperBounds3 instanceof Collection) || !upperBounds3.isEmpty()) {
                            for (e0 e0Var3 : upperBounds3) {
                                if (!(e0Var3 instanceof a0) || g0.b(((a0) e0Var3).f0())) {
                                    z5 = false;
                                    continue;
                                } else {
                                    z5 = true;
                                    continue;
                                }
                                if (z5) {
                                    z6 = true;
                                    break;
                                }
                            }
                        }
                        z6 = false;
                        if (z6) {
                            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NOT_NULL, true);
                        }
                        List<e0> upperBounds4 = mVar.getUpperBounds();
                        f0.o(upperBounds4, "upperBounds");
                        if (!(upperBounds4 instanceof Collection) || !upperBounds4.isEmpty()) {
                            Iterator<T> it = upperBounds4.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                e0 e0Var4 = (e0) it.next();
                                if ((e0Var4 instanceof a0) && g0.b(((a0) e0Var4).f0())) {
                                    z7 = true;
                                    continue;
                                } else {
                                    z7 = false;
                                    continue;
                                }
                                if (z7) {
                                    z8 = true;
                                    break;
                                }
                            }
                        }
                        if (z8) {
                            return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(NullabilityQualifier.NULLABLE, true);
                        }
                        return null;
                    }
                    List<e0> upperBounds5 = mVar.getUpperBounds();
                    f0.o(upperBounds5, "upperBounds");
                    if (!(upperBounds5 instanceof Collection) || !upperBounds5.isEmpty()) {
                        for (e0 it2 : upperBounds5) {
                            f0.o(it2, "it");
                            if (!g0.b(it2)) {
                                break;
                            }
                        }
                    }
                    z9 = false;
                    return new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(z9 ? NullabilityQualifier.NOT_NULL : NullabilityQualifier.NULLABLE, false, 2, null);
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0065  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final d2.l<java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d> c(boolean r18) {
            /*
                r17 = this;
                r8 = r17
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.e0> r0 = r8.f57056c
                java.util.ArrayList r9 = new java.util.ArrayList
                r1 = 10
                int r1 = kotlin.collections.w.Z(r0, r1)
                r9.<init>(r1)
                java.util.Iterator r0 = r0.iterator()
            L13:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L27
                java.lang.Object r1 = r0.next()
                kotlin.reflect.jvm.internal.impl.types.e0 r1 = (kotlin.reflect.jvm.internal.impl.types.e0) r1
                java.util.List r1 = r8.q(r1)
                r9.add(r1)
                goto L13
            L27:
                kotlin.reflect.jvm.internal.impl.types.e0 r0 = r8.f57055b
                java.util.List r10 = r8.q(r0)
                boolean r0 = r8.f57057d
                r12 = 1
                if (r0 == 0) goto L60
                java.util.Collection<kotlin.reflect.jvm.internal.impl.types.e0> r0 = r8.f57056c
                boolean r1 = r0 instanceof java.util.Collection
                if (r1 == 0) goto L40
                boolean r1 = r0.isEmpty()
                if (r1 == 0) goto L40
            L3e:
                r0 = 0
                goto L5c
            L40:
                java.util.Iterator r0 = r0.iterator()
            L44:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L3e
                java.lang.Object r1 = r0.next()
                kotlin.reflect.jvm.internal.impl.types.e0 r1 = (kotlin.reflect.jvm.internal.impl.types.e0) r1
                kotlin.reflect.jvm.internal.impl.types.checker.e r2 = kotlin.reflect.jvm.internal.impl.types.checker.e.f58276a
                kotlin.reflect.jvm.internal.impl.types.e0 r3 = r8.f57055b
                boolean r1 = r2.b(r1, r3)
                r1 = r1 ^ r12
                if (r1 == 0) goto L44
                r0 = 1
            L5c:
                if (r0 == 0) goto L60
                r13 = 1
                goto L61
            L60:
                r13 = 0
            L61:
                if (r13 == 0) goto L65
                r14 = 1
                goto L6a
            L65:
                int r0 = r10.size()
                r14 = r0
            L6a:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d[] r15 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d[r14]
                r7 = 0
            L6d:
                if (r7 >= r14) goto Lc4
                if (r7 != 0) goto L73
                r4 = 1
                goto L74
            L73:
                r4 = 0
            L74:
                java.lang.Object r0 = r10.get(r7)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l r0 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l) r0
                kotlin.reflect.jvm.internal.impl.types.e0 r1 = r0.a()
                kotlin.reflect.jvm.internal.impl.load.java.p r3 = r0.b()
                kotlin.reflect.jvm.internal.impl.descriptors.a1 r5 = r0.c()
                boolean r6 = r0.d()
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Iterator r0 = r9.iterator()
            L93:
                boolean r16 = r0.hasNext()
                if (r16 == 0) goto Lb6
                java.lang.Object r16 = r0.next()
                r11 = r16
                java.util.List r11 = (java.util.List) r11
                java.lang.Object r11 = kotlin.collections.w.H2(r11, r7)
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l r11 = (kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.l) r11
                if (r11 != 0) goto Lab
                r11 = 0
                goto Laf
            Lab:
                kotlin.reflect.jvm.internal.impl.types.e0 r11 = r11.getType()
            Laf:
                if (r11 != 0) goto Lb2
                goto L93
            Lb2:
                r2.add(r11)
                goto L93
            Lb6:
                r0 = r17
                r11 = r7
                r7 = r18
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d r0 = r0.e(r1, r2, r3, r4, r5, r6, r7)
                r15[r11] = r0
                int r7 = r11 + 1
                goto L6d
            Lc4:
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i$b$a r0 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i$b$a
                r0.<init>(r15)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i.b.c(boolean):d2.l");
        }

        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f d(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar, kotlin.reflect.jvm.internal.impl.load.java.p pVar, a1 a1Var) {
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f b4;
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar2 = null;
            if (fVar == null) {
                fVar = pVar == null ? null : pVar.d();
            }
            if (a1Var != null && (b4 = b(a1Var)) != null) {
                if (b4.c() == NullabilityQualifier.NULLABLE) {
                    b4 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f.b(b4, NullabilityQualifier.FORCE_FLEXIBILITY, false, 2, null);
                }
                fVar2 = b4;
            }
            return o(fVar2, fVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:81:0x013c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d e(kotlin.reflect.jvm.internal.impl.types.e0 r16, java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.types.e0> r17, kotlin.reflect.jvm.internal.impl.load.java.p r18, boolean r19, kotlin.reflect.jvm.internal.impl.descriptors.a1 r20, boolean r21, boolean r22) {
            /*
                Method dump skipped, instructions count: 322
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i.b.e(kotlin.reflect.jvm.internal.impl.types.e0, java.util.Collection, kotlin.reflect.jvm.internal.impl.load.java.p, boolean, kotlin.reflect.jvm.internal.impl.descriptors.a1, boolean, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean g(l1 l1Var) {
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = l1Var.H0().b();
            if (b4 == null) {
                return false;
            }
            kotlin.reflect.jvm.internal.impl.name.f name = b4.getName();
            kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f56159a;
            return f0.g(name, cVar.i().g()) && f0.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(b4), cVar.i());
        }

        public static /* synthetic */ a h(b bVar, n nVar, boolean z3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                nVar = null;
            }
            if ((i4 & 2) != 0) {
                z3 = false;
            }
            return bVar.f(nVar, z3);
        }

        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, boolean z3, boolean z4) {
            i iVar = i.this;
            Iterator<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> it = fVar.iterator();
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar2 = null;
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f h4 = iVar.h(it.next(), z3, z4);
                if (fVar2 != null) {
                    if (h4 != null && !f0.g(h4, fVar2) && (!h4.d() || fVar2.d())) {
                        if (h4.d() || !fVar2.d()) {
                            return null;
                        }
                    }
                }
                fVar2 = h4;
            }
            return fVar2;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d j(kotlin.reflect.jvm.internal.impl.types.e0 r12) {
            /*
                r11 = this;
                boolean r0 = kotlin.reflect.jvm.internal.impl.types.b0.b(r12)
                if (r0 == 0) goto L18
                kotlin.reflect.jvm.internal.impl.types.y r0 = kotlin.reflect.jvm.internal.impl.types.b0.a(r12)
                kotlin.Pair r1 = new kotlin.Pair
                kotlin.reflect.jvm.internal.impl.types.m0 r2 = r0.P0()
                kotlin.reflect.jvm.internal.impl.types.m0 r0 = r0.Q0()
                r1.<init>(r2, r0)
                goto L1d
            L18:
                kotlin.Pair r1 = new kotlin.Pair
                r1.<init>(r12, r12)
            L1d:
                java.lang.Object r0 = r1.component1()
                kotlin.reflect.jvm.internal.impl.types.e0 r0 = (kotlin.reflect.jvm.internal.impl.types.e0) r0
                java.lang.Object r1 = r1.component2()
                kotlin.reflect.jvm.internal.impl.types.e0 r1 = (kotlin.reflect.jvm.internal.impl.types.e0) r1
                kotlin.reflect.jvm.internal.impl.builtins.jvm.d r2 = kotlin.reflect.jvm.internal.impl.builtins.jvm.d.f56177a
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d r10 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d
                boolean r3 = r0.I0()
                r4 = 0
                if (r3 == 0) goto L38
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NULLABLE
            L36:
                r5 = r3
                goto L42
            L38:
                boolean r3 = r1.I0()
                if (r3 != 0) goto L41
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier r3 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL
                goto L36
            L41:
                r5 = r4
            L42:
                boolean r0 = r2.f(r0)
                if (r0 == 0) goto L4b
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.READ_ONLY
                goto L55
            L4b:
                boolean r0 = r2.d(r1)
                if (r0 == 0) goto L54
                kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier r0 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.MutabilityQualifier.MUTABLE
                goto L55
            L54:
                r0 = r4
            L55:
                kotlin.reflect.jvm.internal.impl.types.l1 r1 = r12.K0()
                boolean r1 = r1 instanceof kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.e
                if (r1 != 0) goto L69
                kotlin.reflect.jvm.internal.impl.types.l1 r12 = r12.K0()
                boolean r12 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.n
                if (r12 == 0) goto L66
                goto L69
            L66:
                r12 = 0
                r6 = 0
                goto L6b
            L69:
                r12 = 1
                r6 = 1
            L6b:
                r7 = 0
                r8 = 8
                r9 = 0
                r3 = r10
                r4 = r5
                r5 = r0
                r3.<init>(r4, r5, r6, r7, r8, r9)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i.b.j(kotlin.reflect.jvm.internal.impl.types.e0):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d");
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x00d6, code lost:
            if (r1.c() == kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier.NOT_NULL) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00d9, code lost:
            r12 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00e8, code lost:
            if ((r13 != null && r13.c()) != false) goto L64;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d k(kotlin.reflect.jvm.internal.impl.types.e0 r11, boolean r12, kotlin.reflect.jvm.internal.impl.load.java.p r13, kotlin.reflect.jvm.internal.impl.descriptors.a1 r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 295
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.i.b.k(kotlin.reflect.jvm.internal.impl.types.e0, boolean, kotlin.reflect.jvm.internal.impl.load.java.p, kotlin.reflect.jvm.internal.impl.descriptors.a1, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d");
        }

        private static final <T> T l(List<kotlin.reflect.jvm.internal.impl.name.c> list, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, T t3) {
            boolean z3;
            boolean z4 = true;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (kotlin.reflect.jvm.internal.impl.name.c cVar : list) {
                    if (fVar.b(cVar) != null) {
                        z3 = true;
                        continue;
                    } else {
                        z3 = false;
                        continue;
                    }
                    if (z3) {
                        break;
                    }
                }
            }
            z4 = false;
            if (z4) {
                return t3;
            }
            return null;
        }

        private static final <T> T m(T t3, T t4) {
            if (t3 == null || t4 == null || f0.g(t3, t4)) {
                return t3 == null ? t4 : t3;
            }
            return null;
        }

        private final boolean n() {
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar = this.f57054a;
            if (!(aVar instanceof d1)) {
                aVar = null;
            }
            d1 d1Var = (d1) aVar;
            return (d1Var != null ? d1Var.t0() : null) != null;
        }

        private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f o(kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f fVar2) {
            return fVar == null ? fVar2 : fVar2 == null ? fVar : (!fVar.d() || fVar2.d()) ? (fVar.d() || !fVar2.d()) ? (fVar.c().compareTo(fVar2.c()) >= 0 && fVar.c().compareTo(fVar2.c()) > 0) ? fVar : fVar2 : fVar : fVar2;
        }

        private final Pair<kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f, Boolean> p(e0 e0Var) {
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
            a1 a1Var = b4 instanceof a1 ? (a1) b4 : null;
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f b5 = a1Var == null ? null : b(a1Var);
            if (b5 == null) {
                return new Pair<>(null, Boolean.FALSE);
            }
            NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
            return new Pair<>(new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.f(nullabilityQualifier, b5.d()), Boolean.valueOf(b5.c() == nullabilityQualifier));
        }

        private final List<l> q(e0 e0Var) {
            ArrayList arrayList = new ArrayList(1);
            r(this, arrayList, e0Var, this.f57058e, null);
            return arrayList;
        }

        private static final void r(b bVar, ArrayList<l> arrayList, e0 e0Var, kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, a1 a1Var) {
            AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType;
            kotlin.reflect.jvm.internal.impl.load.java.p a4;
            List<Pair> T5;
            kotlin.reflect.jvm.internal.impl.load.java.lazy.h h4 = kotlin.reflect.jvm.internal.impl.load.java.lazy.a.h(hVar, e0Var.getAnnotations());
            v b4 = h4.b();
            if (b4 == null) {
                a4 = null;
            } else {
                if (bVar.f57060g) {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS;
                } else {
                    annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.TYPE_USE;
                }
                a4 = b4.a(annotationQualifierApplicabilityType);
            }
            arrayList.add(new l(e0Var, a4, a1Var, false));
            if (bVar.f57061h && (e0Var instanceof l0)) {
                return;
            }
            List<kotlin.reflect.jvm.internal.impl.types.a1> G0 = e0Var.G0();
            List<a1> parameters = e0Var.H0().getParameters();
            f0.o(parameters, "type.constructor.parameters");
            T5 = kotlin.collections.f0.T5(G0, parameters);
            for (Pair pair : T5) {
                kotlin.reflect.jvm.internal.impl.types.a1 a1Var2 = (kotlin.reflect.jvm.internal.impl.types.a1) pair.component1();
                a1 a1Var3 = (a1) pair.component2();
                if (a1Var2.b()) {
                    e0 type = a1Var2.getType();
                    f0.o(type, "arg.type");
                    arrayList.add(new l(type, a4, a1Var3, true));
                } else {
                    e0 type2 = a1Var2.getType();
                    f0.o(type2, "arg.type");
                    r(bVar, arrayList, type2, h4, a1Var3);
                }
            }
        }

        @NotNull
        public final a f(@Nullable n nVar, boolean z3) {
            boolean c4;
            d2.l<Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.d> c5 = c(z3);
            e eVar = nVar == null ? null : new e(nVar, c5);
            if (this.f57061h) {
                c4 = h1.e(this.f57055b, C1142b.f57064a, c.f57065a);
            } else {
                c4 = h1.c(this.f57055b, d.f57066a);
            }
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.c cVar = i.this.f57050c;
            e0 e0Var = this.f57055b;
            if (eVar != null) {
                c5 = eVar;
            }
            e0 a4 = cVar.a(e0Var, c5, this.f57061h);
            if (a4 == null) {
                return new a(this.f57055b, false, c4);
            }
            return new a(a4, true, c4);
        }

        public /* synthetic */ b(kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar, e0 e0Var, Collection collection, boolean z3, kotlin.reflect.jvm.internal.impl.load.java.lazy.h hVar, AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType, boolean z4, boolean z5, int i4, kotlin.jvm.internal.u uVar) {
            this(i.this, aVar, e0Var, collection, z3, hVar, annotationQualifierApplicabilityType, (i4 & 64) != 0 ? false : z4, (i4 & 128) != 0 ? false : z5);
        }
    }
}
