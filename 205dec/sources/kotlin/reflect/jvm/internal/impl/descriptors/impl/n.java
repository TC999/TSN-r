package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.types.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EnumEntrySyntheticClassDescriptor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class n extends g {

    /* renamed from: n  reason: collision with root package name */
    static final /* synthetic */ boolean f56405n = false;

    /* renamed from: j  reason: collision with root package name */
    private final y0 f56406j;

    /* renamed from: k  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.h f56407k;

    /* renamed from: l  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> f56408l;

    /* renamed from: m  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f56409m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: EnumEntrySyntheticClassDescriptor.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends kotlin.reflect.jvm.internal.impl.resolve.scopes.i {

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ boolean f56410f = false;

        /* renamed from: b  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends u0>> f56411b;

        /* renamed from: c  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends p0>> f56412c;

        /* renamed from: d  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> f56413d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ n f56414e;

        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.impl.n$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class C1130a implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends u0>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f56415a;

            C1130a(n nVar) {
                this.f56415a = nVar;
            }

            @Override // d2.l
            /* renamed from: a */
            public Collection<? extends u0> invoke(kotlin.reflect.jvm.internal.impl.name.f fVar) {
                return a.this.n(fVar);
            }
        }

        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class b implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends p0>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f56417a;

            b(n nVar) {
                this.f56417a = nVar;
            }

            @Override // d2.l
            /* renamed from: a */
            public Collection<? extends p0> invoke(kotlin.reflect.jvm.internal.impl.name.f fVar) {
                return a.this.o(fVar);
            }
        }

        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class c implements d2.a<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ n f56419a;

            c(n nVar) {
                this.f56419a = nVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> invoke() {
                return a.this.m();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: EnumEntrySyntheticClassDescriptor.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class d extends kotlin.reflect.jvm.internal.impl.resolve.g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Set f56421a;

            d(Set set) {
                this.f56421a = set;
            }

            private static /* synthetic */ void f(int i4) {
                Object[] objArr = new Object[3];
                if (i4 == 1) {
                    objArr[0] = "fromSuper";
                } else if (i4 != 2) {
                    objArr[0] = "fakeOverride";
                } else {
                    objArr[0] = "fromCurrent";
                }
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor$EnumEntryScope$4";
                if (i4 == 1 || i4 == 2) {
                    objArr[2] = "conflict";
                } else {
                    objArr[2] = "addFakeOverride";
                }
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.h
            public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    f(0);
                }
                OverridingUtil.L(callableMemberDescriptor, null);
                this.f56421a.add(callableMemberDescriptor);
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.g
            protected void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
                if (callableMemberDescriptor == null) {
                    f(1);
                }
                if (callableMemberDescriptor2 == null) {
                    f(2);
                }
            }
        }

        public a(@NotNull n nVar, kotlin.reflect.jvm.internal.impl.storage.n nVar2) {
            if (nVar2 == null) {
                i(0);
            }
            this.f56414e = nVar;
            this.f56411b = nVar2.c(new C1130a(nVar));
            this.f56412c = nVar2.c(new b(nVar));
            this.f56413d = nVar2.g(new c(nVar));
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0022  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003c  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x0041  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x0090  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00a0  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00a5  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00b5 A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00be  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static /* synthetic */ void i(int r13) {
            /*
                Method dump skipped, instructions count: 346
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.n.a.i(int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> m() {
            HashSet hashSet = new HashSet();
            for (kotlin.reflect.jvm.internal.impl.name.f fVar : (Set) this.f56414e.f56408l.invoke()) {
                NoLookupLocation noLookupLocation = NoLookupLocation.FOR_NON_TRACKED_SCOPE;
                hashSet.addAll(a(fVar, noLookupLocation));
                hashSet.addAll(c(fVar, noLookupLocation));
            }
            return hashSet;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NotNull
        public Collection<? extends u0> n(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
            if (fVar == null) {
                i(8);
            }
            return q(fVar, p().a(fVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @NotNull
        public Collection<? extends p0> o(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
            if (fVar == null) {
                i(4);
            }
            return q(fVar, p().c(fVar, NoLookupLocation.FOR_NON_TRACKED_SCOPE));
        }

        @NotNull
        private kotlin.reflect.jvm.internal.impl.resolve.scopes.h p() {
            kotlin.reflect.jvm.internal.impl.resolve.scopes.h p3 = this.f56414e.j().j().iterator().next().p();
            if (p3 == null) {
                i(9);
            }
            return p3;
        }

        @NotNull
        private <D extends CallableMemberDescriptor> Collection<? extends D> q(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<? extends D> collection) {
            if (fVar == null) {
                i(10);
            }
            if (collection == null) {
                i(11);
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            OverridingUtil.f57794d.w(fVar, collection, Collections.emptySet(), this.f56414e, new d(linkedHashSet));
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Collection<? extends u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
            if (fVar == null) {
                i(5);
            }
            if (bVar == null) {
                i(6);
            }
            Collection<? extends u0> invoke = this.f56411b.invoke(fVar);
            if (invoke == null) {
                i(7);
            }
            return invoke;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> set = (Set) this.f56414e.f56408l.invoke();
            if (set == null) {
                i(17);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Collection<? extends p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar) {
            if (fVar == null) {
                i(1);
            }
            if (bVar == null) {
                i(2);
            }
            Collection<? extends p0> invoke = this.f56412c.invoke(fVar);
            if (invoke == null) {
                i(3);
            }
            return invoke;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> set = (Set) this.f56414e.f56408l.invoke();
            if (set == null) {
                i(19);
            }
            return set;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar) {
            if (dVar == null) {
                i(13);
            }
            if (lVar == null) {
                i(14);
            }
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> invoke = this.f56413d.invoke();
            if (invoke == null) {
                i(15);
            }
            return invoke;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> emptySet = Collections.emptySet();
            if (emptySet == null) {
                i(18);
            }
            return emptySet;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private n(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.types.e0 e0Var, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> iVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2, @NotNull v0 v0Var) {
        super(nVar, dVar, fVar, v0Var, false);
        if (nVar == null) {
            h0(6);
        }
        if (dVar == null) {
            h0(7);
        }
        if (e0Var == null) {
            h0(8);
        }
        if (fVar == null) {
            h0(9);
        }
        if (iVar == null) {
            h0(10);
        }
        if (fVar2 == null) {
            h0(11);
        }
        if (v0Var == null) {
            h0(12);
        }
        this.f56409m = fVar2;
        this.f56406j = new kotlin.reflect.jvm.internal.impl.types.k(this, Collections.emptyList(), Collections.singleton(e0Var), nVar);
        this.f56407k = new a(this, nVar);
        this.f56408l = iVar;
    }

    @NotNull
    public static n G0(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> iVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar2, @NotNull v0 v0Var) {
        if (nVar == null) {
            h0(0);
        }
        if (dVar == null) {
            h0(1);
        }
        if (fVar == null) {
            h0(2);
        }
        if (iVar == null) {
            h0(3);
        }
        if (fVar2 == null) {
            h0(4);
        }
        if (v0Var == null) {
            h0(5);
        }
        return new n(nVar, dVar, dVar.q(), fVar, iVar, fVar2, v0Var);
    }

    private static /* synthetic */ void h0(int i4) {
        String str;
        int i5;
        switch (i4) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i4) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                i5 = 2;
                break;
            default:
                i5 = 3;
                break;
        }
        Object[] objArr = new Object[i5];
        switch (i4) {
            case 1:
                objArr[0] = "enumClass";
                break;
            case 2:
            case 9:
                objArr[0] = "name";
                break;
            case 3:
            case 10:
                objArr[0] = "enumMemberNames";
                break;
            case 4:
            case 11:
                objArr[0] = "annotations";
                break;
            case 5:
            case 12:
                objArr[0] = "source";
                break;
            case 6:
            default:
                objArr[0] = "storageManager";
                break;
            case 7:
                objArr[0] = "containingClass";
                break;
            case 8:
                objArr[0] = "supertype";
                break;
            case 13:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i4) {
            case 14:
                objArr[1] = "getUnsubstitutedMemberScope";
                break;
            case 15:
                objArr[1] = "getStaticScope";
                break;
            case 16:
                objArr[1] = "getConstructors";
                break;
            case 17:
                objArr[1] = "getTypeConstructor";
                break;
            case 18:
                objArr[1] = "getKind";
                break;
            case 19:
                objArr[1] = "getModality";
                break;
            case 20:
                objArr[1] = "getVisibility";
                break;
            case 21:
                objArr[1] = "getAnnotations";
                break;
            case 22:
                objArr[1] = "getDeclaredTypeParameters";
                break;
            case 23:
                objArr[1] = "getSealedSubclasses";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/EnumEntrySyntheticClassDescriptor";
                break;
        }
        switch (i4) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                objArr[2] = "<init>";
                break;
            case 13:
                objArr[2] = "getUnsubstitutedMemberScope";
                break;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                break;
            default:
                objArr[2] = "create";
                break;
        }
        String format = String.format(str, objArr);
        switch (i4) {
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c F() {
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

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h f0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g gVar) {
        if (gVar == null) {
            h0(13);
        }
        kotlin.reflect.jvm.internal.impl.resolve.scopes.h hVar = this.f56407k;
        if (hVar == null) {
            h0(14);
        }
        return hVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            h0(16);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar = this.f56409m;
        if (fVar == null) {
            h0(21);
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.s getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.s sVar = kotlin.reflect.jvm.internal.impl.descriptors.r.f56531e;
        if (sVar == null) {
            h0(20);
        }
        return sVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind i() {
        ClassKind classKind = ClassKind.ENUM_ENTRY;
        if (classKind == null) {
            h0(18);
        }
        return classKind;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean i0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public y0 j() {
        y0 y0Var = this.f56406j;
        if (y0Var == null) {
            h0(17);
        }
        return y0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h k0() {
        h.c cVar = h.c.f57931b;
        if (cVar == null) {
            h0(15);
        }
        return cVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d l0() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> m() {
        List emptyList = Collections.emptyList();
        if (emptyList == null) {
            h0(23);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean n() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<a1> r() {
        List<a1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            h0(22);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        Modality modality = Modality.FINAL;
        if (modality == null) {
            h0(19);
        }
        return modality;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean t() {
        return false;
    }

    public String toString() {
        return "enum entry " + getName();
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
    public kotlin.reflect.jvm.internal.impl.descriptors.x<kotlin.reflect.jvm.internal.impl.types.m0> z() {
        return null;
    }
}
