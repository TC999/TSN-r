package kotlin.reflect.jvm.internal.impl.resolve;

import d2.p;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.f0;
import kotlin.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.o;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.checker.e;
import kotlin.reflect.jvm.internal.impl.types.checker.f;
import kotlin.reflect.jvm.internal.impl.types.checker.g;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class OverridingUtil {

    /* renamed from: c  reason: collision with root package name */
    private static final List<ExternalOverridabilityCondition> f57793c;

    /* renamed from: d  reason: collision with root package name */
    public static final OverridingUtil f57794d;

    /* renamed from: e  reason: collision with root package name */
    private static final e.a f57795e;

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ boolean f57796f = false;

    /* renamed from: a  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.types.checker.g f57797a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a f57798b;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class OverrideCompatibilityInfo {

        /* renamed from: c  reason: collision with root package name */
        private static final OverrideCompatibilityInfo f57799c = new OverrideCompatibilityInfo(Result.OVERRIDABLE, "SUCCESS");

        /* renamed from: a  reason: collision with root package name */
        private final Result f57800a;

        /* renamed from: b  reason: collision with root package name */
        private final String f57801b;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public enum Result {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public OverrideCompatibilityInfo(@NotNull Result result, @NotNull String str) {
            if (result == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.f57800a = result;
            this.f57801b = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x005a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void a(int r10) {
            /*
                r0 = 4
                r1 = 3
                r2 = 2
                r3 = 1
                if (r10 == r3) goto Lf
                if (r10 == r2) goto Lf
                if (r10 == r1) goto Lf
                if (r10 == r0) goto Lf
                java.lang.String r4 = "@NotNull method %s.%s must not return null"
                goto L11
            Lf:
                java.lang.String r4 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            L11:
                if (r10 == r3) goto L1b
                if (r10 == r2) goto L1b
                if (r10 == r1) goto L1b
                if (r10 == r0) goto L1b
                r5 = 2
                goto L1c
            L1b:
                r5 = 3
            L1c:
                java.lang.Object[] r5 = new java.lang.Object[r5]
                java.lang.String r6 = "success"
                java.lang.String r7 = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo"
                r8 = 0
                if (r10 == r3) goto L31
                if (r10 == r2) goto L31
                if (r10 == r1) goto L2e
                if (r10 == r0) goto L31
                r5[r8] = r7
                goto L35
            L2e:
                r5[r8] = r6
                goto L35
            L31:
                java.lang.String r9 = "debugMessage"
                r5[r8] = r9
            L35:
                switch(r10) {
                    case 1: goto L45;
                    case 2: goto L45;
                    case 3: goto L45;
                    case 4: goto L45;
                    case 5: goto L40;
                    case 6: goto L3b;
                    default: goto L38;
                }
            L38:
                r5[r3] = r6
                goto L47
            L3b:
                java.lang.String r6 = "getDebugMessage"
                r5[r3] = r6
                goto L47
            L40:
                java.lang.String r6 = "getResult"
                r5[r3] = r6
                goto L47
            L45:
                r5[r3] = r7
            L47:
                if (r10 == r3) goto L5a
                if (r10 == r2) goto L55
                if (r10 == r1) goto L50
                if (r10 == r0) goto L50
                goto L5e
            L50:
                java.lang.String r6 = "<init>"
                r5[r2] = r6
                goto L5e
            L55:
                java.lang.String r6 = "conflict"
                r5[r2] = r6
                goto L5e
            L5a:
                java.lang.String r6 = "incompatible"
                r5[r2] = r6
            L5e:
                java.lang.String r4 = java.lang.String.format(r4, r5)
                if (r10 == r3) goto L70
                if (r10 == r2) goto L70
                if (r10 == r1) goto L70
                if (r10 == r0) goto L70
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                r10.<init>(r4)
                goto L75
            L70:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                r10.<init>(r4)
            L75:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.OverrideCompatibilityInfo.a(int):void");
        }

        @NotNull
        public static OverrideCompatibilityInfo b(@NotNull String str) {
            if (str == null) {
                a(2);
            }
            return new OverrideCompatibilityInfo(Result.CONFLICT, str);
        }

        @NotNull
        public static OverrideCompatibilityInfo d(@NotNull String str) {
            if (str == null) {
                a(1);
            }
            return new OverrideCompatibilityInfo(Result.INCOMPATIBLE, str);
        }

        @NotNull
        public static OverrideCompatibilityInfo e() {
            OverrideCompatibilityInfo overrideCompatibilityInfo = f57799c;
            if (overrideCompatibilityInfo == null) {
                a(0);
            }
            return overrideCompatibilityInfo;
        }

        @NotNull
        public Result c() {
            Result result = this.f57800a;
            if (result == null) {
                a(5);
            }
            return result;
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements e.a {
        a() {
        }

        private static /* synthetic */ void b(int i4) {
            Object[] objArr = new Object[3];
            if (i4 != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.checker.e.a
        public boolean a(@NotNull y0 y0Var, @NotNull y0 y0Var2) {
            if (y0Var == null) {
                b(0);
            }
            if (y0Var2 == null) {
                b(1);
            }
            return y0Var.equals(y0Var2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [D] */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b<D> implements p<D, D, Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> {
        b() {
        }

        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/Pair<Lkotlin/reflect/jvm/internal/impl/descriptors/a;Lkotlin/reflect/jvm/internal/impl/descriptors/a;>; */
        @Override // d2.p
        /* renamed from: a */
        public Pair invoke(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            return new Pair(aVar, aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c implements d2.l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.k f57802a;

        c(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            this.f57802a = kVar;
        }

        @Override // d2.l
        /* renamed from: a */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(callableMemberDescriptor.b() == this.f57802a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class d implements d2.l<CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a> {
        d() {
        }

        @Override // d2.l
        /* renamed from: a */
        public CallableMemberDescriptor invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class e implements d2.l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.d f57803a;

        e(kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
            this.f57803a = dVar;
        }

        @Override // d2.l
        /* renamed from: a */
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return Boolean.valueOf(!r.g(callableMemberDescriptor.getVisibility()) && r.h(callableMemberDescriptor, this.f57803a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class f implements d2.l<CallableMemberDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.a> {
        f() {
        }

        @Override // d2.l
        /* renamed from: a */
        public kotlin.reflect.jvm.internal.impl.descriptors.a invoke(CallableMemberDescriptor callableMemberDescriptor) {
            return callableMemberDescriptor;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class g implements d2.l<CallableMemberDescriptor, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.resolve.h f57804a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CallableMemberDescriptor f57805b;

        g(kotlin.reflect.jvm.internal.impl.resolve.h hVar, CallableMemberDescriptor callableMemberDescriptor) {
            this.f57804a = hVar;
            this.f57805b = callableMemberDescriptor;
        }

        @Override // d2.l
        /* renamed from: a */
        public f1 invoke(CallableMemberDescriptor callableMemberDescriptor) {
            this.f57804a.b(this.f57805b, callableMemberDescriptor);
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f57806a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f57807b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f57808c;

        static {
            int[] iArr = new int[Modality.values().length];
            f57808c = iArr;
            try {
                iArr[Modality.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57808c[Modality.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f57808c[Modality.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f57808c[Modality.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[OverrideCompatibilityInfo.Result.values().length];
            f57807b = iArr2;
            try {
                iArr2[OverrideCompatibilityInfo.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f57807b[OverrideCompatibilityInfo.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f57807b[OverrideCompatibilityInfo.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[ExternalOverridabilityCondition.Result.values().length];
            f57806a = iArr3;
            try {
                iArr3[ExternalOverridabilityCondition.Result.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f57806a[ExternalOverridabilityCondition.Result.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f57806a[ExternalOverridabilityCondition.Result.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f57806a[ExternalOverridabilityCondition.Result.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        List<ExternalOverridabilityCondition> G5;
        G5 = f0.G5(ServiceLoader.load(ExternalOverridabilityCondition.class, ExternalOverridabilityCondition.class.getClassLoader()));
        f57793c = G5;
        a aVar = new a();
        f57795e = aVar;
        f57794d = new OverridingUtil(aVar, g.a.f58278a);
    }

    private OverridingUtil(@NotNull e.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (aVar == null) {
            a(4);
        }
        if (gVar == null) {
            a(5);
        }
        this.f57798b = aVar;
        this.f57797a = gVar;
    }

    @NotNull
    public static Set<CallableMemberDescriptor> A(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(13);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f(callableMemberDescriptor, linkedHashSet);
        return linkedHashSet;
    }

    private static boolean B(@Nullable o0 o0Var, @Nullable o0 o0Var2) {
        if (o0Var == null || o0Var2 == null) {
            return true;
        }
        return I(o0Var, o0Var2);
    }

    public static boolean C(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        if (aVar == null) {
            a(67);
        }
        if (aVar2 == null) {
            a(68);
        }
        e0 returnType = aVar.getReturnType();
        e0 returnType2 = aVar2.getReturnType();
        if (I(aVar, aVar2)) {
            Pair<kotlin.reflect.jvm.internal.impl.types.checker.m, TypeCheckerState> l4 = f57794d.l(aVar.getTypeParameters(), aVar2.getTypeParameters());
            if (aVar instanceof w) {
                return H(aVar, returnType, aVar2, returnType2, l4);
            }
            if (aVar instanceof p0) {
                p0 p0Var = (p0) aVar;
                p0 p0Var2 = (p0) aVar2;
                if (B(p0Var.getSetter(), p0Var2.getSetter())) {
                    if (p0Var.O() && p0Var2.O()) {
                        return l4.getFirst().e(l4.getSecond(), returnType.K0(), returnType2.K0());
                    }
                    return (p0Var.O() || !p0Var2.O()) && H(aVar, returnType, aVar2, returnType2, l4);
                }
                return false;
            }
            throw new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
        }
        return false;
    }

    private static boolean D(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.a> collection) {
        if (aVar == null) {
            a(71);
        }
        if (collection == null) {
            a(72);
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 : collection) {
            if (!C(aVar, aVar2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean H(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, @NotNull e0 e0Var2, @NotNull Pair<kotlin.reflect.jvm.internal.impl.types.checker.m, TypeCheckerState> pair) {
        if (aVar == null) {
            a(73);
        }
        if (e0Var == null) {
            a(74);
        }
        if (aVar2 == null) {
            a(75);
        }
        if (e0Var2 == null) {
            a(76);
        }
        if (pair == null) {
            a(77);
        }
        return pair.getFirst().g(pair.getSecond(), e0Var.K0(), e0Var2.K0());
    }

    private static boolean I(@NotNull o oVar, @NotNull o oVar2) {
        if (oVar == null) {
            a(69);
        }
        if (oVar2 == null) {
            a(70);
        }
        Integer d4 = r.d(oVar.getVisibility(), oVar2.getVisibility());
        return d4 == null || d4.intValue() >= 0;
    }

    public static boolean J(@NotNull a0 a0Var, @NotNull a0 a0Var2) {
        if (a0Var == null) {
            a(57);
        }
        if (a0Var2 == null) {
            a(58);
        }
        return !r.g(a0Var2.getVisibility()) && r.h(a0Var2, a0Var);
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> boolean K(@NotNull D d4, @NotNull D d5, boolean z3, boolean z4) {
        if (d4 == null) {
            a(11);
        }
        if (d5 == null) {
            a(12);
        }
        if (d4.equals(d5) || !kotlin.reflect.jvm.internal.impl.resolve.b.f57810a.d(d4.a(), d5.a(), z3, z4)) {
            kotlin.reflect.jvm.internal.impl.descriptors.a a4 = d5.a();
            for (kotlin.reflect.jvm.internal.impl.descriptors.a aVar : kotlin.reflect.jvm.internal.impl.resolve.d.d(d4)) {
                if (kotlin.reflect.jvm.internal.impl.resolve.b.f57810a.d(a4, aVar, z3, z4)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static void L(@NotNull CallableMemberDescriptor callableMemberDescriptor, @Nullable d2.l<CallableMemberDescriptor, f1> lVar) {
        s sVar;
        if (callableMemberDescriptor == null) {
            a(107);
        }
        for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.d()) {
            if (callableMemberDescriptor2.getVisibility() == r.f56533g) {
                L(callableMemberDescriptor2, lVar);
            }
        }
        if (callableMemberDescriptor.getVisibility() != r.f56533g) {
            return;
        }
        s h4 = h(callableMemberDescriptor);
        if (h4 == null) {
            if (lVar != null) {
                lVar.invoke(callableMemberDescriptor);
            }
            sVar = r.f56531e;
        } else {
            sVar = h4;
        }
        if (callableMemberDescriptor instanceof c0) {
            ((c0) callableMemberDescriptor).X0(sVar);
            for (o0 o0Var : ((p0) callableMemberDescriptor).A()) {
                L(o0Var, h4 == null ? null : lVar);
            }
        } else if (callableMemberDescriptor instanceof kotlin.reflect.jvm.internal.impl.descriptors.impl.p) {
            ((kotlin.reflect.jvm.internal.impl.descriptors.impl.p) callableMemberDescriptor).e1(sVar);
        } else {
            b0 b0Var = (b0) callableMemberDescriptor;
            b0Var.J0(sVar);
            if (sVar != b0Var.V().getVisibility()) {
                b0Var.H0(false);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static <H> H M(@NotNull Collection<H> collection, @NotNull d2.l<H, kotlin.reflect.jvm.internal.impl.descriptors.a> lVar) {
        List i32;
        Object k22;
        Object k23;
        Object k24;
        Object k25;
        if (collection == null) {
            a(78);
        }
        if (lVar == 0) {
            a(79);
        }
        if (collection.size() == 1) {
            k25 = f0.k2(collection);
            H h4 = (H) k25;
            if (h4 == null) {
                a(80);
            }
            return h4;
        }
        ArrayList arrayList = new ArrayList(2);
        i32 = f0.i3(collection, lVar);
        k22 = f0.k2(collection);
        H h5 = (H) k22;
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) lVar.invoke(h5);
        for (H h6 : collection) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) lVar.invoke(h6);
            if (D(aVar2, i32)) {
                arrayList.add(h6);
            }
            if (C(aVar2, aVar) && !C(aVar, aVar2)) {
                h5 = h6;
            }
        }
        if (arrayList.isEmpty()) {
            if (h5 == null) {
                a(81);
            }
            return h5;
        } else if (arrayList.size() == 1) {
            k24 = f0.k2(arrayList);
            H h7 = (H) k24;
            if (h7 == null) {
                a(82);
            }
            return h7;
        } else {
            H h8 = null;
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (!kotlin.reflect.jvm.internal.impl.types.b0.b(((kotlin.reflect.jvm.internal.impl.descriptors.a) lVar.invoke(next)).getReturnType())) {
                    h8 = next;
                    break;
                }
            }
            if (h8 != null) {
                return h8;
            }
            k23 = f0.k2(arrayList);
            H h9 = (H) k23;
            if (h9 == null) {
                a(84);
            }
            return h9;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x024f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0163 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r24) {
        /*
            Method dump skipped, instructions count: 1316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.a(int):void");
    }

    private static boolean b(@NotNull Collection<CallableMemberDescriptor> collection) {
        boolean h12;
        if (collection == null) {
            a(63);
        }
        if (collection.size() < 2) {
            return true;
        }
        h12 = f0.h1(collection, new c(collection.iterator().next().b()));
        return h12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 r5, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1 r6, @org.jetbrains.annotations.NotNull kotlin.Pair<kotlin.reflect.jvm.internal.impl.types.checker.m, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState> r7) {
        /*
            r4 = this;
            if (r5 != 0) goto L7
            r0 = 49
            a(r0)
        L7:
            if (r6 != 0) goto Le
            r0 = 50
            a(r0)
        Le:
            if (r7 != 0) goto L15
            r0 = 51
            a(r0)
        L15:
            java.util.List r5 = r5.getUpperBounds()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.util.List r6 = r6.getUpperBounds()
            r0.<init>(r6)
            int r6 = r5.size()
            int r1 = r0.size()
            r2 = 0
            if (r6 == r1) goto L2e
            return r2
        L2e:
            java.util.Iterator r5 = r5.iterator()
        L32:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L59
            java.lang.Object r6 = r5.next()
            kotlin.reflect.jvm.internal.impl.types.e0 r6 = (kotlin.reflect.jvm.internal.impl.types.e0) r6
            java.util.ListIterator r1 = r0.listIterator()
        L42:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L58
            java.lang.Object r3 = r1.next()
            kotlin.reflect.jvm.internal.impl.types.e0 r3 = (kotlin.reflect.jvm.internal.impl.types.e0) r3
            boolean r3 = r4.d(r6, r3, r7)
            if (r3 == 0) goto L42
            r1.remove()
            goto L32
        L58:
            return r2
        L59:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.c(kotlin.reflect.jvm.internal.impl.descriptors.a1, kotlin.reflect.jvm.internal.impl.descriptors.a1, kotlin.Pair):boolean");
    }

    private boolean d(@NotNull e0 e0Var, @NotNull e0 e0Var2, @NotNull Pair<kotlin.reflect.jvm.internal.impl.types.checker.m, TypeCheckerState> pair) {
        if (e0Var == null) {
            a(46);
        }
        if (e0Var2 == null) {
            a(47);
        }
        if (pair == null) {
            a(48);
        }
        if (g0.a(e0Var) && g0.a(e0Var2)) {
            return true;
        }
        return pair.getFirst().e(pair.getSecond(), e0Var.K0(), e0Var2.K0());
    }

    @Nullable
    private static OverrideCompatibilityInfo e(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        if ((aVar.Q() == null) != (aVar2.Q() == null)) {
            return OverrideCompatibilityInfo.d("Receiver presence mismatch");
        }
        if (aVar.h().size() != aVar2.h().size()) {
            return OverrideCompatibilityInfo.d("Value parameter number mismatch");
        }
        return null;
    }

    private static void f(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Set<CallableMemberDescriptor> set) {
        if (callableMemberDescriptor == null) {
            a(15);
        }
        if (set == null) {
            a(16);
        }
        if (callableMemberDescriptor.i().isReal()) {
            set.add(callableMemberDescriptor);
        } else if (!callableMemberDescriptor.d().isEmpty()) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : callableMemberDescriptor.d()) {
                f(callableMemberDescriptor2, set);
            }
        } else {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + callableMemberDescriptor);
        }
    }

    private static List<e0> g(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        s0 Q = aVar.Q();
        ArrayList arrayList = new ArrayList();
        if (Q != null) {
            arrayList.add(Q.getType());
        }
        for (d1 d1Var : aVar.h()) {
            arrayList.add(d1Var.getType());
        }
        return arrayList;
    }

    @Nullable
    private static s h(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        if (callableMemberDescriptor == null) {
            a(108);
        }
        Collection<? extends CallableMemberDescriptor> d4 = callableMemberDescriptor.d();
        s v3 = v(d4);
        if (v3 == null) {
            return null;
        }
        if (callableMemberDescriptor.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
            for (CallableMemberDescriptor callableMemberDescriptor2 : d4) {
                if (callableMemberDescriptor2.s() != Modality.ABSTRACT && !callableMemberDescriptor2.getVisibility().equals(v3)) {
                    return null;
                }
            }
            return v3;
        }
        return v3.f();
    }

    @NotNull
    public static OverridingUtil i(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar, @NotNull e.a aVar) {
        if (gVar == null) {
            a(2);
        }
        if (aVar == null) {
            a(3);
        }
        return new OverridingUtil(aVar, gVar);
    }

    private static void j(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.h hVar) {
        if (collection == null) {
            a(85);
        }
        if (dVar == null) {
            a(86);
        }
        if (hVar == null) {
            a(87);
        }
        Collection<CallableMemberDescriptor> u3 = u(dVar, collection);
        boolean isEmpty = u3.isEmpty();
        if (!isEmpty) {
            collection = u3;
        }
        CallableMemberDescriptor P = ((CallableMemberDescriptor) M(collection, new d())).P(dVar, o(collection, dVar), isEmpty ? r.f56534h : r.f56533g, CallableMemberDescriptor.Kind.FAKE_OVERRIDE, false);
        hVar.d(P, collection);
        hVar.a(P);
    }

    private static void k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull Collection<CallableMemberDescriptor> collection, @NotNull kotlin.reflect.jvm.internal.impl.resolve.h hVar) {
        if (dVar == null) {
            a(64);
        }
        if (collection == null) {
            a(65);
        }
        if (hVar == null) {
            a(66);
        }
        if (b(collection)) {
            for (CallableMemberDescriptor callableMemberDescriptor : collection) {
                j(Collections.singleton(callableMemberDescriptor), dVar, hVar);
            }
            return;
        }
        LinkedList linkedList = new LinkedList(collection);
        while (!linkedList.isEmpty()) {
            j(r(n.a(linkedList), linkedList, hVar), dVar, hVar);
        }
    }

    @NotNull
    private Pair<kotlin.reflect.jvm.internal.impl.types.checker.m, TypeCheckerState> l(@NotNull List<a1> list, @NotNull List<a1> list2) {
        if (list == null) {
            a(40);
        }
        if (list2 == null) {
            a(41);
        }
        return new Pair<>(new kotlin.reflect.jvm.internal.impl.types.checker.m(this.f57797a, f.a.f58277a), m(list, list2));
    }

    @NotNull
    private TypeCheckerState m(@NotNull List<a1> list, @NotNull List<a1> list2) {
        if (list == null) {
            a(42);
        }
        if (list2 == null) {
            a(43);
        }
        if (list.isEmpty()) {
            TypeCheckerState A0 = new i(null, this.f57798b, this.f57797a).A0(true, true);
            if (A0 == null) {
                a(44);
            }
            return A0;
        }
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < list.size(); i4++) {
            hashMap.put(list.get(i4).j(), list2.get(i4).j());
        }
        TypeCheckerState A02 = new i(hashMap, this.f57798b, this.f57797a).A0(true, true);
        if (A02 == null) {
            a(45);
        }
        return A02;
    }

    @NotNull
    public static OverridingUtil n(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            a(1);
        }
        return new OverridingUtil(f57795e, gVar);
    }

    @NotNull
    private static Modality o(@NotNull Collection<CallableMemberDescriptor> collection, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (collection == null) {
            a(88);
        }
        if (dVar == null) {
            a(89);
        }
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            int i4 = h.f57808c[callableMemberDescriptor.s().ordinal()];
            if (i4 == 1) {
                Modality modality = Modality.FINAL;
                if (modality == null) {
                    a(90);
                }
                return modality;
            } else if (i4 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + callableMemberDescriptor);
            } else if (i4 == 3) {
                z4 = true;
            } else if (i4 == 4) {
                z5 = true;
            }
        }
        if (dVar.i0() && dVar.s() != Modality.ABSTRACT && dVar.s() != Modality.SEALED) {
            z3 = true;
        }
        if (z4 && !z5) {
            Modality modality2 = Modality.OPEN;
            if (modality2 == null) {
                a(91);
            }
            return modality2;
        } else if (!z4 && z5) {
            Modality s3 = z3 ? dVar.s() : Modality.ABSTRACT;
            if (s3 == null) {
                a(92);
            }
            return s3;
        } else {
            HashSet hashSet = new HashSet();
            for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
                hashSet.addAll(A(callableMemberDescriptor2));
            }
            return z(s(hashSet), z3, dVar.s());
        }
    }

    private Collection<CallableMemberDescriptor> p(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.h hVar) {
        if (callableMemberDescriptor == null) {
            a(59);
        }
        if (collection == null) {
            a(60);
        }
        if (dVar == null) {
            a(61);
        }
        if (hVar == null) {
            a(62);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        kotlin.reflect.jvm.internal.impl.utils.f a4 = kotlin.reflect.jvm.internal.impl.utils.f.a();
        for (CallableMemberDescriptor callableMemberDescriptor2 : collection) {
            OverrideCompatibilityInfo.Result c4 = E(callableMemberDescriptor2, callableMemberDescriptor, dVar).c();
            boolean J = J(callableMemberDescriptor, callableMemberDescriptor2);
            int i4 = h.f57807b[c4.ordinal()];
            if (i4 == 1) {
                if (J) {
                    a4.add(callableMemberDescriptor2);
                }
                arrayList.add(callableMemberDescriptor2);
            } else if (i4 == 2) {
                if (J) {
                    hVar.c(callableMemberDescriptor2, callableMemberDescriptor);
                }
                arrayList.add(callableMemberDescriptor2);
            }
        }
        hVar.d(callableMemberDescriptor, a4);
        return arrayList;
    }

    @NotNull
    public static <H> Collection<H> q(@NotNull H h4, @NotNull Collection<H> collection, @NotNull d2.l<H, kotlin.reflect.jvm.internal.impl.descriptors.a> lVar, @NotNull d2.l<H, f1> lVar2) {
        if (h4 == null) {
            a(99);
        }
        if (collection == null) {
            a(100);
        }
        if (lVar == null) {
            a(101);
        }
        if (lVar2 == null) {
            a(102);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h4);
        kotlin.reflect.jvm.internal.impl.descriptors.a invoke = lVar.invoke(h4);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.a invoke2 = lVar.invoke(next);
            if (h4 == next) {
                it.remove();
            } else {
                OverrideCompatibilityInfo.Result y3 = y(invoke, invoke2);
                if (y3 == OverrideCompatibilityInfo.Result.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (y3 == OverrideCompatibilityInfo.Result.CONFLICT) {
                    lVar2.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> r(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Queue<CallableMemberDescriptor> queue, @NotNull kotlin.reflect.jvm.internal.impl.resolve.h hVar) {
        if (callableMemberDescriptor == null) {
            a(104);
        }
        if (queue == null) {
            a(105);
        }
        if (hVar == null) {
            a(106);
        }
        return q(callableMemberDescriptor, queue, new f(), new g(hVar, callableMemberDescriptor));
    }

    @NotNull
    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> s(@NotNull Set<D> set) {
        if (set == null) {
            a(6);
        }
        return t(set, !set.isEmpty() && kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.q(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.l(set.iterator().next())), null, new b());
    }

    @NotNull
    public static <D> Set<D> t(@NotNull Set<D> set, boolean z3, @Nullable d2.a<?> aVar, @NotNull p<? super D, ? super D, Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> pVar) {
        if (set == null) {
            a(7);
        }
        if (pVar == null) {
            a(8);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (aVar != null) {
                aVar.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (it.hasNext()) {
                    Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a> invoke = pVar.invoke(obj, (Object) it.next());
                    kotlin.reflect.jvm.internal.impl.descriptors.a component1 = invoke.component1();
                    kotlin.reflect.jvm.internal.impl.descriptors.a component2 = invoke.component2();
                    if (K(component1, component2, z3, true)) {
                        it.remove();
                    } else if (K(component2, component1, z3, true)) {
                        break;
                    }
                } else {
                    linkedHashSet.add(obj);
                    break;
                }
            }
        }
        return linkedHashSet;
    }

    @NotNull
    private static Collection<CallableMemberDescriptor> u(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull Collection<CallableMemberDescriptor> collection) {
        List X1;
        if (dVar == null) {
            a(96);
        }
        if (collection == null) {
            a(97);
        }
        X1 = f0.X1(collection, new e(dVar));
        if (X1 == null) {
            a(98);
        }
        return X1;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static kotlin.reflect.jvm.internal.impl.descriptors.s v(@org.jetbrains.annotations.NotNull java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor> r5) {
        /*
            if (r5 != 0) goto L7
            r0 = 109(0x6d, float:1.53E-43)
            a(r0)
        L7:
            boolean r0 = r5.isEmpty()
            if (r0 == 0) goto L10
            kotlin.reflect.jvm.internal.impl.descriptors.s r5 = kotlin.reflect.jvm.internal.impl.descriptors.r.f56538l
            return r5
        L10:
            java.util.Iterator r0 = r5.iterator()
            r1 = 0
        L15:
            r2 = r1
        L16:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L38
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r3
            kotlin.reflect.jvm.internal.impl.descriptors.s r3 = r3.getVisibility()
            if (r2 != 0) goto L2a
        L28:
            r2 = r3
            goto L16
        L2a:
            java.lang.Integer r4 = kotlin.reflect.jvm.internal.impl.descriptors.r.d(r3, r2)
            if (r4 != 0) goto L31
            goto L15
        L31:
            int r4 = r4.intValue()
            if (r4 <= 0) goto L16
            goto L28
        L38:
            if (r2 != 0) goto L3b
            return r1
        L3b:
            java.util.Iterator r5 = r5.iterator()
        L3f:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L5c
            java.lang.Object r0 = r5.next()
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.s r0 = r0.getVisibility()
            java.lang.Integer r0 = kotlin.reflect.jvm.internal.impl.descriptors.r.d(r2, r0)
            if (r0 == 0) goto L5b
            int r0 = r0.intValue()
            if (r0 >= 0) goto L3f
        L5b:
            return r1
        L5c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil.v(java.util.Collection):kotlin.reflect.jvm.internal.impl.descriptors.s");
    }

    @Nullable
    public static OverrideCompatibilityInfo x(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        boolean z3;
        if (aVar == null) {
            a(38);
        }
        if (aVar2 == null) {
            a(39);
        }
        boolean z4 = aVar instanceof w;
        if ((!z4 || (aVar2 instanceof w)) && (!((z3 = aVar instanceof p0)) || (aVar2 instanceof p0))) {
            if (!z4 && !z3) {
                throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + aVar);
            } else if (!aVar.getName().equals(aVar2.getName())) {
                return OverrideCompatibilityInfo.d("Name mismatch");
            } else {
                OverrideCompatibilityInfo e4 = e(aVar, aVar2);
                if (e4 != null) {
                    return e4;
                }
                return null;
            }
        }
        return OverrideCompatibilityInfo.d("Member kind mismatch");
    }

    @Nullable
    public static OverrideCompatibilityInfo.Result y(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        OverridingUtil overridingUtil = f57794d;
        OverrideCompatibilityInfo.Result c4 = overridingUtil.E(aVar2, aVar, null).c();
        OverrideCompatibilityInfo.Result c5 = overridingUtil.E(aVar, aVar2, null).c();
        OverrideCompatibilityInfo.Result result = OverrideCompatibilityInfo.Result.OVERRIDABLE;
        if (c4 == result && c5 == result) {
            return result;
        }
        OverrideCompatibilityInfo.Result result2 = OverrideCompatibilityInfo.Result.CONFLICT;
        return (c4 == result2 || c5 == result2) ? result2 : OverrideCompatibilityInfo.Result.INCOMPATIBLE;
    }

    @NotNull
    private static Modality z(@NotNull Collection<CallableMemberDescriptor> collection, boolean z3, @NotNull Modality modality) {
        if (collection == null) {
            a(93);
        }
        if (modality == null) {
            a(94);
        }
        Modality modality2 = Modality.ABSTRACT;
        for (CallableMemberDescriptor callableMemberDescriptor : collection) {
            Modality s3 = (z3 && callableMemberDescriptor.s() == Modality.ABSTRACT) ? modality : callableMemberDescriptor.s();
            if (s3.compareTo(modality2) < 0) {
                modality2 = s3;
            }
        }
        if (modality2 == null) {
            a(95);
        }
        return modality2;
    }

    @NotNull
    public OverrideCompatibilityInfo E(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (aVar == null) {
            a(17);
        }
        if (aVar2 == null) {
            a(18);
        }
        OverrideCompatibilityInfo F = F(aVar, aVar2, dVar, false);
        if (F == null) {
            a(19);
        }
        return F;
    }

    @NotNull
    public OverrideCompatibilityInfo F(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, @Nullable kotlin.reflect.jvm.internal.impl.descriptors.d dVar, boolean z3) {
        if (aVar == null) {
            a(20);
        }
        if (aVar2 == null) {
            a(21);
        }
        OverrideCompatibilityInfo G = G(aVar, aVar2, z3);
        boolean z4 = G.c() == OverrideCompatibilityInfo.Result.OVERRIDABLE;
        for (ExternalOverridabilityCondition externalOverridabilityCondition : f57793c) {
            if (externalOverridabilityCondition.a() != ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY && (!z4 || externalOverridabilityCondition.a() != ExternalOverridabilityCondition.Contract.SUCCESS_ONLY)) {
                int i4 = h.f57806a[externalOverridabilityCondition.b(aVar, aVar2, dVar).ordinal()];
                if (i4 == 1) {
                    z4 = true;
                } else if (i4 == 2) {
                    OverrideCompatibilityInfo b4 = OverrideCompatibilityInfo.b("External condition failed");
                    if (b4 == null) {
                        a(22);
                    }
                    return b4;
                } else if (i4 == 3) {
                    OverrideCompatibilityInfo d4 = OverrideCompatibilityInfo.d("External condition");
                    if (d4 == null) {
                        a(23);
                    }
                    return d4;
                }
            }
        }
        if (z4) {
            for (ExternalOverridabilityCondition externalOverridabilityCondition2 : f57793c) {
                if (externalOverridabilityCondition2.a() == ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY) {
                    int i5 = h.f57806a[externalOverridabilityCondition2.b(aVar, aVar2, dVar).ordinal()];
                    if (i5 == 1) {
                        throw new IllegalStateException("Contract violation in " + externalOverridabilityCondition2.getClass().getName() + " condition. It's not supposed to end with success");
                    } else if (i5 == 2) {
                        OverrideCompatibilityInfo b5 = OverrideCompatibilityInfo.b("External condition failed");
                        if (b5 == null) {
                            a(25);
                        }
                        return b5;
                    } else if (i5 == 3) {
                        OverrideCompatibilityInfo d5 = OverrideCompatibilityInfo.d("External condition");
                        if (d5 == null) {
                            a(26);
                        }
                        return d5;
                    }
                }
            }
            OverrideCompatibilityInfo e4 = OverrideCompatibilityInfo.e();
            if (e4 == null) {
                a(27);
            }
            return e4;
        }
        return G;
    }

    @NotNull
    public OverrideCompatibilityInfo G(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z3) {
        if (aVar == null) {
            a(28);
        }
        if (aVar2 == null) {
            a(29);
        }
        OverrideCompatibilityInfo x3 = x(aVar, aVar2);
        if (x3 != null) {
            return x3;
        }
        List<e0> g4 = g(aVar);
        List<e0> g5 = g(aVar2);
        List<a1> typeParameters = aVar.getTypeParameters();
        List<a1> typeParameters2 = aVar2.getTypeParameters();
        int i4 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i4 < g4.size()) {
                if (!kotlin.reflect.jvm.internal.impl.types.checker.e.f58276a.b(g4.get(i4), g5.get(i4))) {
                    OverrideCompatibilityInfo d4 = OverrideCompatibilityInfo.d("Type parameter number mismatch");
                    if (d4 == null) {
                        a(31);
                    }
                    return d4;
                }
                i4++;
            }
            OverrideCompatibilityInfo b4 = OverrideCompatibilityInfo.b("Type parameter number mismatch");
            if (b4 == null) {
                a(32);
            }
            return b4;
        }
        Pair<kotlin.reflect.jvm.internal.impl.types.checker.m, TypeCheckerState> l4 = l(typeParameters, typeParameters2);
        for (int i5 = 0; i5 < typeParameters.size(); i5++) {
            if (!c(typeParameters.get(i5), typeParameters2.get(i5), l4)) {
                OverrideCompatibilityInfo d5 = OverrideCompatibilityInfo.d("Type parameter bounds mismatch");
                if (d5 == null) {
                    a(33);
                }
                return d5;
            }
        }
        for (int i6 = 0; i6 < g4.size(); i6++) {
            if (!d(g4.get(i6), g5.get(i6), l4)) {
                OverrideCompatibilityInfo d6 = OverrideCompatibilityInfo.d("Value parameter type mismatch");
                if (d6 == null) {
                    a(34);
                }
                return d6;
            }
        }
        if ((aVar instanceof w) && (aVar2 instanceof w) && ((w) aVar).isSuspend() != ((w) aVar2).isSuspend()) {
            OverrideCompatibilityInfo b5 = OverrideCompatibilityInfo.b("Incompatible suspendability");
            if (b5 == null) {
                a(35);
            }
            return b5;
        }
        if (z3) {
            e0 returnType = aVar.getReturnType();
            e0 returnType2 = aVar2.getReturnType();
            if (returnType != null && returnType2 != null) {
                if (g0.a(returnType2) && g0.a(returnType)) {
                    i4 = 1;
                }
                if (i4 == 0 && !l4.getFirst().g(l4.getSecond(), returnType2.K0(), returnType.K0())) {
                    OverrideCompatibilityInfo b6 = OverrideCompatibilityInfo.b("Return type mismatch");
                    if (b6 == null) {
                        a(36);
                    }
                    return b6;
                }
            }
        }
        OverrideCompatibilityInfo e4 = OverrideCompatibilityInfo.e();
        if (e4 == null) {
            a(37);
        }
        return e4;
    }

    public void w(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<? extends CallableMemberDescriptor> collection, @NotNull Collection<? extends CallableMemberDescriptor> collection2, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.resolve.h hVar) {
        if (fVar == null) {
            a(52);
        }
        if (collection == null) {
            a(53);
        }
        if (collection2 == null) {
            a(54);
        }
        if (dVar == null) {
            a(55);
        }
        if (hVar == null) {
            a(56);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        for (CallableMemberDescriptor callableMemberDescriptor : collection2) {
            linkedHashSet.removeAll(p(callableMemberDescriptor, collection, dVar, hVar));
        }
        k(dVar, linkedHashSet, hVar);
    }
}
