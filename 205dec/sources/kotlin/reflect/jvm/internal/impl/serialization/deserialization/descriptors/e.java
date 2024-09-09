package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.c0;
import kotlin.collections.k1;
import kotlin.collections.y;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.ranges.q;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.n;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.s;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.h;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.h;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.k;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.b0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.x;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.z;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedClassDescriptor.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e extends kotlin.reflect.jvm.internal.impl.descriptors.impl.a implements t {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final ProtoBuf.Class f58039g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a f58040h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final v0 f58041i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.name.b f58042j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final Modality f58043k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private final s f58044l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private final ClassKind f58045m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.k f58046n;
    @NotNull

    /* renamed from: o  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.resolve.scopes.i f58047o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    private final b f58048p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    private final t0<a> f58049q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private final c f58050r;
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.k f58051s;
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.descriptors.c> f58052t;
    @NotNull

    /* renamed from: u  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.c>> f58053u;
    @NotNull

    /* renamed from: v  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.j<kotlin.reflect.jvm.internal.impl.descriptors.d> f58054v;
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.d>> f58055w;
    @NotNull

    /* renamed from: x  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.j<x<m0>> f58056x;
    @NotNull

    /* renamed from: y  reason: collision with root package name */
    private final x.a f58057y;
    @NotNull

    /* renamed from: z  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f58058z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a extends DeserializedMemberScope {
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.types.checker.g f58059g;
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<kotlin.reflect.jvm.internal.impl.descriptors.k>> f58060h;
        @NotNull

        /* renamed from: i  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i<Collection<e0>> f58061i;

        /* renamed from: j  reason: collision with root package name */
        final /* synthetic */ e f58062j;

        /* compiled from: DeserializedClassDescriptor.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1174a extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.name.f>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ List<kotlin.reflect.jvm.internal.impl.name.f> f58063a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1174a(List<kotlin.reflect.jvm.internal.impl.name.f> list) {
                super(0);
                this.f58063a = list;
            }

            @Override // d2.a
            @NotNull
            public final List<? extends kotlin.reflect.jvm.internal.impl.name.f> invoke() {
                return this.f58063a;
            }
        }

        /* compiled from: DeserializedClassDescriptor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class b extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.k>> {
            b() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> invoke() {
                return a.this.l(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57902o, kotlin.reflect.jvm.internal.impl.resolve.scopes.h.f57927a.a(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
            }
        }

        /* compiled from: DeserializedClassDescriptor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends kotlin.reflect.jvm.internal.impl.resolve.g {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ List<D> f58065a;

            c(List<D> list) {
                this.f58065a = list;
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.h
            public void a(@NotNull CallableMemberDescriptor fakeOverride) {
                f0.p(fakeOverride, "fakeOverride");
                OverridingUtil.L(fakeOverride, null);
                this.f58065a.add(fakeOverride);
            }

            @Override // kotlin.reflect.jvm.internal.impl.resolve.g
            protected void e(@NotNull CallableMemberDescriptor fromSuper, @NotNull CallableMemberDescriptor fromCurrent) {
                f0.p(fromSuper, "fromSuper");
                f0.p(fromCurrent, "fromCurrent");
            }
        }

        /* compiled from: DeserializedClassDescriptor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class d extends Lambda implements d2.a<Collection<? extends e0>> {
            d() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Collection<e0> invoke() {
                return a.this.f58059g.g(a.this.D());
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e r8, kotlin.reflect.jvm.internal.impl.types.checker.g r9) {
            /*
                r7 = this;
                java.lang.String r0 = "this$0"
                kotlin.jvm.internal.f0.p(r8, r0)
                java.lang.String r0 = "kotlinTypeRefiner"
                kotlin.jvm.internal.f0.p(r9, r0)
                r7.f58062j = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.k r2 = r8.T0()
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.U0()
                java.util.List r3 = r0.getFunctionList()
                java.lang.String r0 = "classProto.functionList"
                kotlin.jvm.internal.f0.o(r3, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.U0()
                java.util.List r4 = r0.getPropertyList()
                java.lang.String r0 = "classProto.propertyList"
                kotlin.jvm.internal.f0.o(r4, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.U0()
                java.util.List r5 = r0.getTypeAliasList()
                java.lang.String r0 = "classProto.typeAliasList"
                kotlin.jvm.internal.f0.o(r5, r0)
                kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r0 = r8.U0()
                java.util.List r0 = r0.getNestedClassNameList()
                java.lang.String r1 = "classProto.nestedClassNameList"
                kotlin.jvm.internal.f0.o(r0, r1)
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.k r8 = r8.T0()
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.c r8 = r8.g()
                java.util.ArrayList r1 = new java.util.ArrayList
                r6 = 10
                int r6 = kotlin.collections.w.Z(r0, r6)
                r1.<init>(r6)
                java.util.Iterator r0 = r0.iterator()
            L5b:
                boolean r6 = r0.hasNext()
                if (r6 == 0) goto L73
                java.lang.Object r6 = r0.next()
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                kotlin.reflect.jvm.internal.impl.name.f r6 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.v.b(r8, r6)
                r1.add(r6)
                goto L5b
            L73:
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e$a$a r6 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e$a$a
                r6.<init>(r1)
                r1 = r7
                r1.<init>(r2, r3, r4, r5, r6)
                r7.f58059g = r9
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.k r8 = r7.r()
                kotlin.reflect.jvm.internal.impl.storage.n r8 = r8.h()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e$a$b r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e$a$b
                r9.<init>()
                kotlin.reflect.jvm.internal.impl.storage.i r8 = r8.g(r9)
                r7.f58060h = r8
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.k r8 = r7.r()
                kotlin.reflect.jvm.internal.impl.storage.n r8 = r8.h()
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e$a$d r9 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e$a$d
                r9.<init>()
                kotlin.reflect.jvm.internal.impl.storage.i r8 = r8.g(r9)
                r7.f58061i = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e.a.<init>(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e, kotlin.reflect.jvm.internal.impl.types.checker.g):void");
        }

        private final <D extends CallableMemberDescriptor> void C(kotlin.reflect.jvm.internal.impl.name.f fVar, Collection<? extends D> collection, List<D> list) {
            r().c().m().a().w(fVar, collection, new ArrayList(list), D(), new c(list));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final e D() {
            return this.f58062j;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
            f0.p(name, "name");
            f0.p(location, "location");
            e(name, location);
            return super.a(name, location);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
        @NotNull
        public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
            f0.p(name, "name");
            f0.p(location, "location");
            e(name, location);
            return super.c(name, location);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        public void e(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
            f0.p(name, "name");
            f0.p(location, "location");
            j2.a.a(r().c().o(), location, D(), name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @NotNull
        public Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> f(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
            f0.p(kindFilter, "kindFilter");
            f0.p(nameFilter, "nameFilter");
            return this.f58060h.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
        @Nullable
        public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
            kotlin.reflect.jvm.internal.impl.descriptors.d f4;
            f0.p(name, "name");
            f0.p(location, "location");
            e(name, location);
            c cVar = D().f58050r;
            return (cVar == null || (f4 = cVar.f(name)) == null) ? super.h(name, location) : f4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void k(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> result, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter) {
            f0.p(result, "result");
            f0.p(nameFilter, "nameFilter");
            c cVar = D().f58050r;
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> d4 = cVar == null ? null : cVar.d();
            if (d4 == null) {
                d4 = CollectionsKt__CollectionsKt.F();
            }
            result.addAll(d4);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void m(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull List<u0> functions) {
            f0.p(name, "name");
            f0.p(functions, "functions");
            ArrayList arrayList = new ArrayList();
            for (e0 e0Var : this.f58061i.invoke()) {
                arrayList.addAll(e0Var.p().a(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            functions.addAll(r().c().c().a(name, this.f58062j));
            C(name, arrayList, functions);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected void n(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull List<p0> descriptors) {
            f0.p(name, "name");
            f0.p(descriptors, "descriptors");
            ArrayList arrayList = new ArrayList();
            for (e0 e0Var : this.f58061i.invoke()) {
                arrayList.addAll(e0Var.p().c(name, NoLookupLocation.FOR_ALREADY_TRACKED));
            }
            C(name, arrayList, descriptors);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        protected kotlin.reflect.jvm.internal.impl.name.b o(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            f0.p(name, "name");
            kotlin.reflect.jvm.internal.impl.name.b d4 = this.f58062j.f58042j.d(name);
            f0.o(d4, "classId.createNestedClassId(name)");
            return d4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @Nullable
        protected Set<kotlin.reflect.jvm.internal.impl.name.f> u() {
            List<e0> j4 = D().f58048p.j();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (e0 e0Var : j4) {
                Set<kotlin.reflect.jvm.internal.impl.name.f> g4 = e0Var.p().g();
                if (g4 == null) {
                    return null;
                }
                c0.o0(linkedHashSet, g4);
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        protected Set<kotlin.reflect.jvm.internal.impl.name.f> v() {
            List<e0> j4 = D().f58048p.j();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (e0 e0Var : j4) {
                c0.o0(linkedHashSet, e0Var.p().b());
            }
            linkedHashSet.addAll(r().c().c().e(this.f58062j));
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        @NotNull
        protected Set<kotlin.reflect.jvm.internal.impl.name.f> w() {
            List<e0> j4 = D().f58048p.j();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (e0 e0Var : j4) {
                c0.o0(linkedHashSet, e0Var.p().d());
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
        protected boolean z(@NotNull u0 function) {
            f0.p(function, "function");
            return r().c().s().b(this.f58062j, function);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b extends kotlin.reflect.jvm.internal.impl.types.b {
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i<List<a1>> f58067d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ e f58068e;

        /* compiled from: DeserializedClassDescriptor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.a<List<? extends a1>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f58069a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(e eVar) {
                super(0);
                this.f58069a = eVar;
            }

            @Override // d2.a
            @NotNull
            public final List<? extends a1> invoke() {
                return b1.d(this.f58069a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e this$0) {
            super(this$0.T0().h());
            f0.p(this$0, "this$0");
            this.f58068e = this$0;
            this.f58067d = this$0.T0().h().g(new a(this$0));
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        public boolean c() {
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.y0
        @NotNull
        public List<a1> getParameters() {
            return this.f58067d.invoke();
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        @NotNull
        protected Collection<e0> i() {
            int Z;
            List<e0> o4;
            List G5;
            int Z2;
            List<ProtoBuf.Type> l4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.l(this.f58068e.U0(), this.f58068e.T0().j());
            e eVar = this.f58068e;
            Z = y.Z(l4, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (ProtoBuf.Type type : l4) {
                arrayList.add(eVar.T0().i().p(type));
            }
            o4 = kotlin.collections.f0.o4(arrayList, this.f58068e.T0().c().c().d(this.f58068e));
            ArrayList<f0.b> arrayList2 = new ArrayList();
            for (e0 e0Var : o4) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
                f0.b bVar = b4 instanceof f0.b ? (f0.b) b4 : null;
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                p i4 = this.f58068e.T0().c().i();
                e eVar2 = this.f58068e;
                Z2 = y.Z(arrayList2, 10);
                ArrayList arrayList3 = new ArrayList(Z2);
                for (f0.b bVar2 : arrayList2) {
                    kotlin.reflect.jvm.internal.impl.name.b h4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(bVar2);
                    arrayList3.add(h4 == null ? bVar2.getName().b() : h4.b().b());
                }
                i4.b(eVar2, arrayList3);
            }
            G5 = kotlin.collections.f0.G5(o4);
            return G5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.g
        @NotNull
        protected y0 o() {
            return y0.a.f56639a;
        }

        @NotNull
        public String toString() {
            String fVar = this.f58068e.getName().toString();
            kotlin.jvm.internal.f0.o(fVar, "name.toString()");
            return fVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.types.b
        @NotNull
        /* renamed from: v */
        public e u() {
            return this.f58068e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class c {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Map<kotlin.reflect.jvm.internal.impl.name.f, ProtoBuf.EnumEntry> f58070a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d> f58071b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i<Set<kotlin.reflect.jvm.internal.impl.name.f>> f58072c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ e f58073d;

        /* compiled from: DeserializedClassDescriptor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.descriptors.d> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ e f58075b;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: DeserializedClassDescriptor.kt */
            /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e$c$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class C1175a extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ e f58076a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ ProtoBuf.EnumEntry f58077b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1175a(e eVar, ProtoBuf.EnumEntry enumEntry) {
                    super(0);
                    this.f58076a = eVar;
                    this.f58077b = enumEntry;
                }

                @Override // d2.a
                @NotNull
                public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
                    List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> G5;
                    G5 = kotlin.collections.f0.G5(this.f58076a.T0().c().d().d(this.f58076a.Y0(), this.f58077b));
                    return G5;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(e eVar) {
                super(1);
                this.f58075b = eVar;
            }

            @Override // d2.l
            @Nullable
            /* renamed from: a */
            public final kotlin.reflect.jvm.internal.impl.descriptors.d invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
                kotlin.jvm.internal.f0.p(name, "name");
                ProtoBuf.EnumEntry enumEntry = (ProtoBuf.EnumEntry) c.this.f58070a.get(name);
                if (enumEntry == null) {
                    return null;
                }
                e eVar = this.f58075b;
                return n.G0(eVar.T0().h(), eVar, name, c.this.f58072c, new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b(eVar.T0().h(), new C1175a(eVar, enumEntry)), v0.f56634a);
            }
        }

        /* compiled from: DeserializedClassDescriptor.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class b extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {
            b() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
                return c.this.e();
            }
        }

        public c(e this$0) {
            int Z;
            int j4;
            int n4;
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            this.f58073d = this$0;
            List<ProtoBuf.EnumEntry> enumEntryList = this$0.U0().getEnumEntryList();
            kotlin.jvm.internal.f0.o(enumEntryList, "classProto.enumEntryList");
            Z = y.Z(enumEntryList, 10);
            j4 = kotlin.collections.y0.j(Z);
            n4 = q.n(j4, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
            for (Object obj : enumEntryList) {
                linkedHashMap.put(v.b(this$0.T0().g(), ((ProtoBuf.EnumEntry) obj).getName()), obj);
            }
            this.f58070a = linkedHashMap;
            this.f58071b = this.f58073d.T0().h().e(new a(this.f58073d));
            this.f58072c = this.f58073d.T0().h().g(new b());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Set<kotlin.reflect.jvm.internal.impl.name.f> e() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> C;
            HashSet hashSet = new HashSet();
            for (e0 e0Var : this.f58073d.j().j()) {
                for (kotlin.reflect.jvm.internal.impl.descriptors.k kVar : k.a.a(e0Var.p(), null, null, 3, null)) {
                    if ((kVar instanceof u0) || (kVar instanceof p0)) {
                        hashSet.add(kVar.getName());
                    }
                }
            }
            List<ProtoBuf.Function> functionList = this.f58073d.U0().getFunctionList();
            kotlin.jvm.internal.f0.o(functionList, "classProto.functionList");
            e eVar = this.f58073d;
            for (ProtoBuf.Function function : functionList) {
                hashSet.add(v.b(eVar.T0().g(), function.getName()));
            }
            List<ProtoBuf.Property> propertyList = this.f58073d.U0().getPropertyList();
            kotlin.jvm.internal.f0.o(propertyList, "classProto.propertyList");
            e eVar2 = this.f58073d;
            for (ProtoBuf.Property property : propertyList) {
                hashSet.add(v.b(eVar2.T0().g(), property.getName()));
            }
            C = k1.C(hashSet, hashSet);
            return C;
        }

        @NotNull
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> d() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> keySet = this.f58070a.keySet();
            ArrayList arrayList = new ArrayList();
            for (kotlin.reflect.jvm.internal.impl.name.f fVar : keySet) {
                kotlin.reflect.jvm.internal.impl.descriptors.d f4 = f(fVar);
                if (f4 != null) {
                    arrayList.add(f4);
                }
            }
            return arrayList;
        }

        @Nullable
        public final kotlin.reflect.jvm.internal.impl.descriptors.d f(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            kotlin.jvm.internal.f0.p(name, "name");
            return this.f58071b.invoke(name);
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {
        d() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> G5;
            G5 = kotlin.collections.f0.G5(e.this.T0().c().d().b(e.this.Y0()));
            return G5;
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class C1176e extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.descriptors.d> {
        C1176e() {
            super(0);
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.d invoke() {
            return e.this.N0();
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class f extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.c>> {
        f() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> invoke() {
            return e.this.O0();
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class g extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.descriptors.x<m0>> {
        g() {
            super(0);
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.x<m0> invoke() {
            return e.this.P0();
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    /* synthetic */ class h extends FunctionReference implements d2.l<kotlin.reflect.jvm.internal.impl.types.checker.g, a> {
        h(Object obj) {
            super(1, obj);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final a invoke(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g p02) {
            kotlin.jvm.internal.f0.p(p02, "p0");
            return new a((e) this.receiver, p02);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "<init>";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(a.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class i extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.descriptors.c> {
        i() {
            super(0);
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.descriptors.c invoke() {
            return e.this.Q0();
        }
    }

    /* compiled from: DeserializedClassDescriptor.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class j extends Lambda implements d2.a<Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.d>> {
        j() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> invoke() {
            return e.this.S0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.k outerContext, @NotNull ProtoBuf.Class classProto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @NotNull v0 sourceElement) {
        super(outerContext.h(), v.a(nameResolver, classProto.getFqName()).j());
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f mVar;
        kotlin.jvm.internal.f0.p(outerContext, "outerContext");
        kotlin.jvm.internal.f0.p(classProto, "classProto");
        kotlin.jvm.internal.f0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.f0.p(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.f0.p(sourceElement, "sourceElement");
        this.f58039g = classProto;
        this.f58040h = metadataVersion;
        this.f58041i = sourceElement;
        this.f58042j = v.a(nameResolver, classProto.getFqName());
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.y yVar = kotlin.reflect.jvm.internal.impl.serialization.deserialization.y.f58199a;
        this.f58043k = yVar.b(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57455e.d(classProto.getFlags()));
        this.f58044l = z.a(yVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57454d.d(classProto.getFlags()));
        ClassKind a4 = yVar.a(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57456f.d(classProto.getFlags()));
        this.f58045m = a4;
        List<ProtoBuf.TypeParameter> typeParameterList = classProto.getTypeParameterList();
        kotlin.jvm.internal.f0.o(typeParameterList, "classProto.typeParameterList");
        ProtoBuf.TypeTable typeTable = classProto.getTypeTable();
        kotlin.jvm.internal.f0.o(typeTable, "classProto.typeTable");
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar = new kotlin.reflect.jvm.internal.impl.metadata.deserialization.g(typeTable);
        h.a aVar = kotlin.reflect.jvm.internal.impl.metadata.deserialization.h.f57484b;
        ProtoBuf.VersionRequirementTable versionRequirementTable = classProto.getVersionRequirementTable();
        kotlin.jvm.internal.f0.o(versionRequirementTable, "classProto.versionRequirementTable");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.k a5 = outerContext.a(this, typeParameterList, nameResolver, gVar, aVar.a(versionRequirementTable), metadataVersion);
        this.f58046n = a5;
        ClassKind classKind = ClassKind.ENUM_CLASS;
        this.f58047o = a4 == classKind ? new kotlin.reflect.jvm.internal.impl.resolve.scopes.l(a5.h(), this) : h.c.f57931b;
        this.f58048p = new b(this);
        this.f58049q = t0.f56623e.a(this, a5.h(), a5.c().m().c(), new h(this));
        this.f58050r = a4 == classKind ? new c(this) : null;
        kotlin.reflect.jvm.internal.impl.descriptors.k e4 = outerContext.e();
        this.f58051s = e4;
        this.f58052t = a5.h().i(new i());
        this.f58053u = a5.h().g(new f());
        this.f58054v = a5.h().i(new C1176e());
        this.f58055w = a5.h().g(new j());
        this.f58056x = a5.h().i(new g());
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.c g4 = a5.g();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.g j4 = a5.j();
        e eVar = e4 instanceof e ? (e) e4 : null;
        this.f58057y = new x.a(classProto, g4, j4, sourceElement, eVar != null ? eVar.f58057y : null);
        if (!kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57453c.d(classProto.getFlags()).booleanValue()) {
            mVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        } else {
            mVar = new m(a5.h(), new d());
        }
        this.f58058z = mVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.d N0() {
        if (this.f58039g.hasCompanionObjectName()) {
            kotlin.reflect.jvm.internal.impl.descriptors.f h4 = V0().h(v.b(this.f58046n.g(), this.f58039g.getCompanionObjectName()), NoLookupLocation.FROM_DESERIALIZATION);
            if (h4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) {
                return (kotlin.reflect.jvm.internal.impl.descriptors.d) h4;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> O0() {
        List N;
        List o4;
        List o42;
        List<kotlin.reflect.jvm.internal.impl.descriptors.c> R0 = R0();
        N = CollectionsKt__CollectionsKt.N(F());
        o4 = kotlin.collections.f0.o4(R0, N);
        o42 = kotlin.collections.f0.o4(o4, this.f58046n.c().c().c(this));
        return o42;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.x<m0> P0() {
        Object m22;
        kotlin.reflect.jvm.internal.impl.name.f name;
        m0 n4;
        Object obj = null;
        if (kotlin.reflect.jvm.internal.impl.resolve.e.b(this)) {
            if (this.f58039g.hasInlineClassUnderlyingPropertyName()) {
                name = v.b(this.f58046n.g(), this.f58039g.getInlineClassUnderlyingPropertyName());
            } else if (!this.f58040h.c(1, 5, 1)) {
                kotlin.reflect.jvm.internal.impl.descriptors.c F = F();
                if (F != null) {
                    List<d1> h4 = F.h();
                    kotlin.jvm.internal.f0.o(h4, "constructor.valueParameters");
                    m22 = kotlin.collections.f0.m2(h4);
                    name = ((d1) m22).getName();
                    kotlin.jvm.internal.f0.o(name, "{\n                // Bef\u2026irst().name\n            }");
                } else {
                    throw new IllegalStateException(kotlin.jvm.internal.f0.C("Inline class has no primary constructor: ", this).toString());
                }
            } else {
                throw new IllegalStateException(kotlin.jvm.internal.f0.C("Inline class has no underlying property name in metadata: ", this).toString());
            }
            ProtoBuf.Type f4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.f(this.f58039g, this.f58046n.j());
            if (f4 == null) {
                Iterator<T> it = V0().c(name, NoLookupLocation.FROM_DESERIALIZATION).iterator();
                Object obj2 = null;
                boolean z3 = false;
                while (true) {
                    if (it.hasNext()) {
                        Object next = it.next();
                        if (((p0) next).Q() == null) {
                            if (z3) {
                                break;
                            }
                            obj2 = next;
                            z3 = true;
                        }
                    } else if (z3) {
                        obj = obj2;
                    }
                }
                p0 p0Var = (p0) obj;
                if (p0Var != null) {
                    n4 = (m0) p0Var.getType();
                } else {
                    throw new IllegalStateException(kotlin.jvm.internal.f0.C("Inline class has no underlying property: ", this).toString());
                }
            } else {
                n4 = b0.n(this.f58046n.i(), f4, false, 2, null);
            }
            return new kotlin.reflect.jvm.internal.impl.descriptors.x<>(name, n4);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final kotlin.reflect.jvm.internal.impl.descriptors.c Q0() {
        Object obj;
        if (this.f58045m.isSingleton()) {
            kotlin.reflect.jvm.internal.impl.descriptors.impl.f i4 = kotlin.reflect.jvm.internal.impl.resolve.c.i(this, v0.f56634a);
            i4.b1(q());
            return i4;
        }
        List<ProtoBuf.Constructor> constructorList = this.f58039g.getConstructorList();
        kotlin.jvm.internal.f0.o(constructorList, "classProto.constructorList");
        Iterator<T> it = constructorList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (!kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57463m.d(((ProtoBuf.Constructor) obj).getFlags()).booleanValue()) {
                break;
            }
        }
        ProtoBuf.Constructor constructor = (ProtoBuf.Constructor) obj;
        if (constructor == null) {
            return null;
        }
        return T0().f().i(constructor, true);
    }

    private final List<kotlin.reflect.jvm.internal.impl.descriptors.c> R0() {
        int Z;
        List<ProtoBuf.Constructor> constructorList = this.f58039g.getConstructorList();
        kotlin.jvm.internal.f0.o(constructorList, "classProto.constructorList");
        ArrayList<ProtoBuf.Constructor> arrayList = new ArrayList();
        for (Object obj : constructorList) {
            Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57463m.d(((ProtoBuf.Constructor) obj).getFlags());
            kotlin.jvm.internal.f0.o(d4, "IS_SECONDARY.get(it.flags)");
            if (d4.booleanValue()) {
                arrayList.add(obj);
            }
        }
        Z = y.Z(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(Z);
        for (ProtoBuf.Constructor it : arrayList) {
            u f4 = T0().f();
            kotlin.jvm.internal.f0.o(it, "it");
            arrayList2.add(f4.i(it, false));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> S0() {
        List F;
        if (this.f58043k != Modality.SEALED) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        List<Integer> fqNames = this.f58039g.getSealedSubclassFqNameList();
        kotlin.jvm.internal.f0.o(fqNames, "fqNames");
        if (!fqNames.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Integer index : fqNames) {
                kotlin.reflect.jvm.internal.impl.serialization.deserialization.i c4 = T0().c();
                kotlin.reflect.jvm.internal.impl.metadata.deserialization.c g4 = T0().g();
                kotlin.jvm.internal.f0.o(index, "index");
                kotlin.reflect.jvm.internal.impl.descriptors.d b4 = c4.b(v.a(g4, index.intValue()));
                if (b4 != null) {
                    arrayList.add(b4);
                }
            }
            return arrayList;
        }
        return kotlin.reflect.jvm.internal.impl.resolve.a.f57809a.a(this, false);
    }

    private final a V0() {
        return this.f58049q.c(this.f58046n.c().m().c());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.c F() {
        return this.f58052t.invoke();
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.k T0() {
        return this.f58046n;
    }

    @NotNull
    public final ProtoBuf.Class U0() {
        return this.f58039g;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.metadata.deserialization.a W0() {
        return this.f58040h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean X() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    /* renamed from: X0 */
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.i k0() {
        return this.f58047o;
    }

    @NotNull
    public final x.a Y0() {
        return this.f58057y;
    }

    public final boolean Z0(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        kotlin.jvm.internal.f0.p(name, "name");
        return V0().s().contains(name);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean a0() {
        return kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57456f.d(this.f58039g.getFlags()) == ProtoBuf.Class.Kind.COMPANION_OBJECT;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.l, kotlin.reflect.jvm.internal.impl.descriptors.k
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.k b() {
        return this.f58051s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.t
    @NotNull
    public kotlin.reflect.jvm.internal.impl.resolve.scopes.h f0(@NotNull kotlin.reflect.jvm.internal.impl.types.checker.g kotlinTypeRefiner) {
        kotlin.jvm.internal.f0.p(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this.f58049q.c(kotlinTypeRefiner);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g() {
        return this.f58053u.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.a
    @NotNull
    public kotlin.reflect.jvm.internal.impl.descriptors.annotations.f getAnnotations() {
        return this.f58058z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n
    @NotNull
    public v0 getSource() {
        return this.f58041i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.o, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public s getVisibility() {
        return this.f58044l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public ClassKind i() {
        return this.f58045m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean i0() {
        Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57460j.d(this.f58039g.getFlags());
        kotlin.jvm.internal.f0.o(d4, "IS_EXPECT_CLASS.get(classProto.flags)");
        return d4.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a0
    public boolean isExternal() {
        Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57459i.d(this.f58039g.getFlags());
        kotlin.jvm.internal.f0.o(d4, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return d4.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean isInline() {
        Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57461k.d(this.f58039g.getFlags());
        kotlin.jvm.internal.f0.o(d4, "IS_INLINE_CLASS.get(classProto.flags)");
        return d4.booleanValue() && this.f58040h.e(1, 4, 1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.f
    @NotNull
    public kotlin.reflect.jvm.internal.impl.types.y0 j() {
        return this.f58048p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.d l0() {
        return this.f58054v.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @NotNull
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> m() {
        return this.f58055w.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.g
    public boolean n() {
        Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57457g.d(this.f58039g.getFlags());
        kotlin.jvm.internal.f0.o(d4, "IS_INNER.get(classProto.flags)");
        return d4.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.g
    @NotNull
    public List<a1> r() {
        return this.f58046n.i().j();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d, kotlin.reflect.jvm.internal.impl.descriptors.a0
    @NotNull
    public Modality s() {
        return this.f58043k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean t() {
        Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57462l.d(this.f58039g.getFlags());
        kotlin.jvm.internal.f0.o(d4, "IS_FUN_INTERFACE.get(classProto.flags)");
        return d4.booleanValue();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("deserialized ");
        sb.append(i0() ? "expect " : "");
        sb.append("class ");
        sb.append(getName());
        return sb.toString();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean v() {
        Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57461k.d(this.f58039g.getFlags());
        kotlin.jvm.internal.f0.o(d4, "IS_INLINE_CLASS.get(classProto.flags)");
        return d4.booleanValue() && this.f58040h.c(1, 4, 2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    public boolean y() {
        Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57458h.d(this.f58039g.getFlags());
        kotlin.jvm.internal.f0.o(d4, "IS_DATA.get(classProto.flags)");
        return d4.booleanValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.d
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.x<m0> z() {
        return this.f58056x.invoke();
    }
}
