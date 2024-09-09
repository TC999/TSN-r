package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.c0;
import kotlin.collections.f0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;

/* compiled from: GivenFunctionsMemberScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class e extends i {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.n<Object>[] f57918d = {n0.u(new PropertyReference1Impl(n0.d(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.d f57919b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f57920c;

    /* compiled from: GivenFunctionsMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.k>> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.k> invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.k> o4;
            List<w> j4 = e.this.j();
            o4 = f0.o4(j4, e.this.k(j4));
            return o4;
        }
    }

    /* compiled from: GivenFunctionsMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends kotlin.reflect.jvm.internal.impl.resolve.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.k> f57922a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ e f57923b;

        b(ArrayList<kotlin.reflect.jvm.internal.impl.descriptors.k> arrayList, e eVar) {
            this.f57922a = arrayList;
            this.f57923b = eVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.h
        public void a(@NotNull CallableMemberDescriptor fakeOverride) {
            kotlin.jvm.internal.f0.p(fakeOverride, "fakeOverride");
            OverridingUtil.L(fakeOverride, null);
            this.f57922a.add(fakeOverride);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.g
        protected void e(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
            kotlin.jvm.internal.f0.p(fromSuper, "fromSuper");
            kotlin.jvm.internal.f0.p(fromCurrent, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.f57923b.m() + ": " + fromSuper + " vs " + fromCurrent).toString());
        }
    }

    public e(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d containingClass) {
        kotlin.jvm.internal.f0.p(storageManager, "storageManager");
        kotlin.jvm.internal.f0.p(containingClass, "containingClass");
        this.f57919b = containingClass;
        this.f57920c = storageManager.g(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<kotlin.reflect.jvm.internal.impl.descriptors.k> k(List<? extends w> list) {
        Collection<? extends CallableMemberDescriptor> F;
        ArrayList arrayList = new ArrayList(3);
        Collection<e0> j4 = this.f57919b.j().j();
        kotlin.jvm.internal.f0.o(j4, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        for (e0 e0Var : j4) {
            c0.o0(arrayList2, k.a.a(e0Var.p(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof CallableMemberDescriptor) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            kotlin.reflect.jvm.internal.impl.name.f name = ((CallableMemberDescriptor) obj2).getName();
            Object obj3 = linkedHashMap.get(name);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(name, obj3);
            }
            ((List) obj3).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            kotlin.reflect.jvm.internal.impl.name.f fVar = (kotlin.reflect.jvm.internal.impl.name.f) entry.getKey();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj4 : (List) entry.getValue()) {
                Boolean valueOf = Boolean.valueOf(((CallableMemberDescriptor) obj4) instanceof w);
                Object obj5 = linkedHashMap2.get(valueOf);
                if (obj5 == null) {
                    obj5 = new ArrayList();
                    linkedHashMap2.put(valueOf, obj5);
                }
                ((List) obj5).add(obj4);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list2 = (List) entry2.getValue();
                OverridingUtil overridingUtil = OverridingUtil.f57794d;
                if (booleanValue) {
                    F = new ArrayList<>();
                    for (Object obj6 : list) {
                        if (kotlin.jvm.internal.f0.g(((w) obj6).getName(), fVar)) {
                            F.add(obj6);
                        }
                    }
                } else {
                    F = CollectionsKt__CollectionsKt.F();
                }
                overridingUtil.w(fVar, list2, F, this.f57919b, new b(arrayList, this));
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.k> l() {
        return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f57920c, this, f57918d[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(location, "location");
        List<kotlin.reflect.jvm.internal.impl.descriptors.k> l4 = l();
        kotlin.reflect.jvm.internal.impl.utils.e eVar = new kotlin.reflect.jvm.internal.impl.utils.e();
        for (Object obj : l4) {
            if ((obj instanceof u0) && kotlin.jvm.internal.f0.g(((u0) obj).getName(), name)) {
                eVar.add(obj);
            }
        }
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(location, "location");
        List<kotlin.reflect.jvm.internal.impl.descriptors.k> l4 = l();
        kotlin.reflect.jvm.internal.impl.utils.e eVar = new kotlin.reflect.jvm.internal.impl.utils.e();
        for (Object obj : l4) {
            if ((obj instanceof p0) && kotlin.jvm.internal.f0.g(((p0) obj).getName(), name)) {
                eVar.add(obj);
            }
        }
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
        List F;
        kotlin.jvm.internal.f0.p(kindFilter, "kindFilter");
        kotlin.jvm.internal.f0.p(nameFilter, "nameFilter");
        if (kindFilter.a(d.f57903p.m())) {
            return l();
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @NotNull
    protected abstract List<w> j();

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.d m() {
        return this.f57919b;
    }
}
