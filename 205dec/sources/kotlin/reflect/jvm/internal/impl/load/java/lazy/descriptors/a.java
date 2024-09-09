package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y;
import kotlin.collections.y0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.sequences.SequencesKt___SequencesKt;
import m2.n;
import m2.p;
import m2.q;
import m2.r;
import m2.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeclaredMemberIndex.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a implements b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final m2.g f56776a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.l<q, Boolean> f56777b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final d2.l<r, Boolean> f56778c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, List<r>> f56779d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, n> f56780e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.name.f, w> f56781f;

    /* compiled from: DeclaredMemberIndex.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1137a extends Lambda implements d2.l<r, Boolean> {
        C1137a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull r m4) {
            f0.p(m4, "m");
            return Boolean.valueOf(((Boolean) a.this.f56777b.invoke(m4)).booleanValue() && !p.c(m4));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull m2.g jClass, @NotNull d2.l<? super q, Boolean> memberFilter) {
        kotlin.sequences.m l12;
        kotlin.sequences.m i02;
        kotlin.sequences.m l13;
        kotlin.sequences.m i03;
        int Z;
        int j4;
        int n4;
        f0.p(jClass, "jClass");
        f0.p(memberFilter, "memberFilter");
        this.f56776a = jClass;
        this.f56777b = memberFilter;
        C1137a c1137a = new C1137a();
        this.f56778c = c1137a;
        l12 = kotlin.collections.f0.l1(jClass.z());
        i02 = SequencesKt___SequencesKt.i0(l12, c1137a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : i02) {
            kotlin.reflect.jvm.internal.impl.name.f name = ((r) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.f56779d = linkedHashMap;
        l13 = kotlin.collections.f0.l1(this.f56776a.w());
        i03 = SequencesKt___SequencesKt.i0(l13, this.f56777b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : i03) {
            linkedHashMap2.put(((n) obj3).getName(), obj3);
        }
        this.f56780e = linkedHashMap2;
        Collection<w> i4 = this.f56776a.i();
        d2.l<q, Boolean> lVar = this.f56777b;
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : i4) {
            if (((Boolean) lVar.invoke(obj4)).booleanValue()) {
                arrayList.add(obj4);
            }
        }
        Z = y.Z(arrayList, 10);
        j4 = y0.j(Z);
        n4 = kotlin.ranges.q.n(j4, 16);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(n4);
        for (Object obj5 : arrayList) {
            linkedHashMap3.put(((w) obj5).getName(), obj5);
        }
        this.f56781f = linkedHashMap3;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> a() {
        kotlin.sequences.m l12;
        kotlin.sequences.m<r> i02;
        l12 = kotlin.collections.f0.l1(this.f56776a.z());
        i02 = SequencesKt___SequencesKt.i0(l12, this.f56778c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (r rVar : i02) {
            linkedHashSet.add(rVar.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        return this.f56781f.keySet();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> c() {
        kotlin.sequences.m l12;
        kotlin.sequences.m<n> i02;
        l12 = kotlin.collections.f0.l1(this.f56776a.w());
        i02 = SequencesKt___SequencesKt.i0(l12, this.f56777b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (n nVar : i02) {
            linkedHashSet.add(nVar.getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    @NotNull
    public Collection<r> d(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        List F;
        f0.p(name, "name");
        List<r> list = this.f56779d.get(name);
        if (list == null) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    @Nullable
    public w e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(name, "name");
        return this.f56781f.get(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.b
    @Nullable
    public n f(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(name, "name");
        return this.f56780e.get(name);
    }
}
