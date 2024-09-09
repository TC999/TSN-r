package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.b0;
import kotlin.collections.c0;
import kotlin.collections.k1;
import kotlin.collections.y;
import kotlin.collections.y0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.ranges.q;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.resolve.f;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.u;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.v;
import kotlin.reflect.n;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.sequences.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DeserializedMemberScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class DeserializedMemberScope extends kotlin.reflect.jvm.internal.impl.resolve.scopes.i {

    /* renamed from: f  reason: collision with root package name */
    static final /* synthetic */ n<Object>[] f57986f = {n0.u(new PropertyReference1Impl(n0.d(DeserializedMemberScope.class), "classNames", "getClassNames$deserialization()Ljava/util/Set;")), n0.u(new PropertyReference1Impl(n0.d(DeserializedMemberScope.class), "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;"))};
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.k f57987b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final a f57988c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.i f57989d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.j f57990e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class OptimizedImplementation implements a {

        /* renamed from: j  reason: collision with root package name */
        static final /* synthetic */ n<Object>[] f57991j = {n0.u(new PropertyReference1Impl(n0.d(OptimizedImplementation.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), n0.u(new PropertyReference1Impl(n0.d(OptimizedImplementation.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> f57992a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> f57993b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> f57994c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<u0>> f57995d;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.g<kotlin.reflect.jvm.internal.impl.name.f, Collection<p0>> f57996e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.h<kotlin.reflect.jvm.internal.impl.name.f, z0> f57997f;
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f57998g;
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f57999h;

        /* renamed from: i  reason: collision with root package name */
        final /* synthetic */ DeserializedMemberScope f58000i;

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DeserializedMemberScope f58002b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.f58002b = deserializedMemberScope;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
                Set<kotlin.reflect.jvm.internal.impl.name.f> C;
                C = k1.C(OptimizedImplementation.this.f57992a.keySet(), this.f58002b.v());
                return C;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class b extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends u0>> {
            b() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final Collection<u0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f it) {
                f0.p(it, "it");
                return OptimizedImplementation.this.m(it);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class c extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, Collection<? extends p0>> {
            c() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final Collection<p0> invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f it) {
                f0.p(it, "it");
                return OptimizedImplementation.this.n(it);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class d extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.name.f, z0> {
            d() {
                super(1);
            }

            @Override // d2.l
            @Nullable
            /* renamed from: a */
            public final z0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.f it) {
                f0.p(it, "it");
                return OptimizedImplementation.this.o(it);
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class e extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DeserializedMemberScope f58007b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            e(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.f58007b = deserializedMemberScope;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
                Set<kotlin.reflect.jvm.internal.impl.name.f> C;
                C = k1.C(OptimizedImplementation.this.f57993b.keySet(), this.f58007b.w());
                return C;
            }
        }

        public OptimizedImplementation(@NotNull DeserializedMemberScope this$0, @NotNull List<ProtoBuf.Function> functionList, @NotNull List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
            Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> z3;
            f0.p(this$0, "this$0");
            f0.p(functionList, "functionList");
            f0.p(propertyList, "propertyList");
            f0.p(typeAliasList, "typeAliasList");
            this.f58000i = this$0;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : functionList) {
                kotlin.reflect.jvm.internal.impl.name.f b4 = v.b(this$0.f57987b.g(), ((ProtoBuf.Function) ((kotlin.reflect.jvm.internal.impl.protobuf.n) obj)).getName());
                Object obj2 = linkedHashMap.get(b4);
                if (obj2 == null) {
                    obj2 = new ArrayList();
                    linkedHashMap.put(b4, obj2);
                }
                ((List) obj2).add(obj);
            }
            this.f57992a = p(linkedHashMap);
            DeserializedMemberScope deserializedMemberScope = this.f58000i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj3 : propertyList) {
                kotlin.reflect.jvm.internal.impl.name.f b5 = v.b(deserializedMemberScope.f57987b.g(), ((ProtoBuf.Property) ((kotlin.reflect.jvm.internal.impl.protobuf.n) obj3)).getName());
                Object obj4 = linkedHashMap2.get(b5);
                if (obj4 == null) {
                    obj4 = new ArrayList();
                    linkedHashMap2.put(b5, obj4);
                }
                ((List) obj4).add(obj3);
            }
            this.f57993b = p(linkedHashMap2);
            if (this.f58000i.r().c().g().c()) {
                DeserializedMemberScope deserializedMemberScope2 = this.f58000i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj5 : typeAliasList) {
                    kotlin.reflect.jvm.internal.impl.name.f b6 = v.b(deserializedMemberScope2.f57987b.g(), ((ProtoBuf.TypeAlias) ((kotlin.reflect.jvm.internal.impl.protobuf.n) obj5)).getName());
                    Object obj6 = linkedHashMap3.get(b6);
                    if (obj6 == null) {
                        obj6 = new ArrayList();
                        linkedHashMap3.put(b6, obj6);
                    }
                    ((List) obj6).add(obj5);
                }
                z3 = p(linkedHashMap3);
            } else {
                z3 = kotlin.collections.z0.z();
            }
            this.f57994c = z3;
            this.f57995d = this.f58000i.r().h().c(new b());
            this.f57996e = this.f58000i.r().h().c(new c());
            this.f57997f = this.f58000i.r().h().e(new d());
            this.f57998g = this.f58000i.r().h().g(new a(this.f58000i));
            this.f57999h = this.f58000i.r().h().g(new e(this.f58000i));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<u0> m(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            kotlin.sequences.m o4;
            List<ProtoBuf.Function> V2;
            Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> map = this.f57992a;
            p<ProtoBuf.Function> PARSER = ProtoBuf.Function.PARSER;
            f0.o(PARSER, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.f58000i;
            byte[] bArr = map.get(fVar);
            if (bArr == null) {
                V2 = CollectionsKt__CollectionsKt.F();
            } else {
                o4 = s.o(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(PARSER, new ByteArrayInputStream(bArr), this.f58000i));
                V2 = SequencesKt___SequencesKt.V2(o4);
            }
            ArrayList arrayList = new ArrayList(V2.size());
            for (ProtoBuf.Function it : V2) {
                u f4 = deserializedMemberScope.r().f();
                f0.o(it, "it");
                u0 j4 = f4.j(it);
                if (!deserializedMemberScope.z(j4)) {
                    j4 = null;
                }
                if (j4 != null) {
                    arrayList.add(j4);
                }
            }
            deserializedMemberScope.m(fVar, arrayList);
            return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Collection<p0> n(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            kotlin.sequences.m o4;
            List<ProtoBuf.Property> V2;
            Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> map = this.f57993b;
            p<ProtoBuf.Property> PARSER = ProtoBuf.Property.PARSER;
            f0.o(PARSER, "PARSER");
            DeserializedMemberScope deserializedMemberScope = this.f58000i;
            byte[] bArr = map.get(fVar);
            if (bArr == null) {
                V2 = CollectionsKt__CollectionsKt.F();
            } else {
                o4 = s.o(new DeserializedMemberScope$OptimizedImplementation$computeDescriptors$1$1(PARSER, new ByteArrayInputStream(bArr), this.f58000i));
                V2 = SequencesKt___SequencesKt.V2(o4);
            }
            ArrayList arrayList = new ArrayList(V2.size());
            for (ProtoBuf.Property it : V2) {
                u f4 = deserializedMemberScope.r().f();
                f0.o(it, "it");
                p0 l4 = f4.l(it);
                if (l4 != null) {
                    arrayList.add(l4);
                }
            }
            deserializedMemberScope.n(fVar, arrayList);
            return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final z0 o(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            ProtoBuf.TypeAlias parseDelimitedFrom;
            byte[] bArr = this.f57994c.get(fVar);
            if (bArr == null || (parseDelimitedFrom = ProtoBuf.TypeAlias.parseDelimitedFrom(new ByteArrayInputStream(bArr), this.f58000i.r().c().j())) == null) {
                return null;
            }
            return this.f58000i.r().f().m(parseDelimitedFrom);
        }

        private final Map<kotlin.reflect.jvm.internal.impl.name.f, byte[]> p(Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends Collection<? extends kotlin.reflect.jvm.internal.impl.protobuf.a>> map) {
            int j4;
            int Z;
            j4 = y0.j(map.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(j4);
            Iterator<T> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable<kotlin.reflect.jvm.internal.impl.protobuf.a> iterable = (Iterable) entry.getValue();
                Z = y.Z(iterable, 10);
                ArrayList arrayList = new ArrayList(Z);
                for (kotlin.reflect.jvm.internal.impl.protobuf.a aVar : iterable) {
                    aVar.writeDelimitedTo(byteArrayOutputStream);
                    arrayList.add(f1.f55527a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
            List F;
            f0.p(name, "name");
            f0.p(location, "location");
            if (b().contains(name)) {
                return this.f57995d.invoke(name);
            }
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f57998g, this, f57991j[0]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
            List F;
            f0.p(name, "name");
            f0.p(location, "location");
            if (d().contains(name)) {
                return this.f57996e.invoke(name);
            }
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f57999h, this, f57991j[1]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> e() {
            return this.f57994c.keySet();
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @Nullable
        public z0 f(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            f0.p(name, "name");
            return this.f57997f.invoke(name);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        public void g(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> result, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter, @NotNull k2.b location) {
            f0.p(result, "result");
            f0.p(kindFilter, "kindFilter");
            f0.p(nameFilter, "nameFilter");
            f0.p(location, "location");
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c.i())) {
                Set<kotlin.reflect.jvm.internal.impl.name.f> d4 = d();
                ArrayList arrayList = new ArrayList();
                for (kotlin.reflect.jvm.internal.impl.name.f fVar : d4) {
                    if (nameFilter.invoke(fVar).booleanValue()) {
                        arrayList.addAll(c(fVar, location));
                    }
                }
                f.b INSTANCE = f.b.f57870a;
                f0.o(INSTANCE, "INSTANCE");
                b0.n0(arrayList, INSTANCE);
                result.addAll(arrayList);
            }
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c.d())) {
                Set<kotlin.reflect.jvm.internal.impl.name.f> b4 = b();
                ArrayList arrayList2 = new ArrayList();
                for (kotlin.reflect.jvm.internal.impl.name.f fVar2 : b4) {
                    if (nameFilter.invoke(fVar2).booleanValue()) {
                        arrayList2.addAll(a(fVar2, location));
                    }
                }
                f.b INSTANCE2 = f.b.f57870a;
                f0.o(INSTANCE2, "INSTANCE");
                b0.n0(arrayList2, INSTANCE2);
                result.addAll(arrayList2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface a {
        @NotNull
        Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar);

        @NotNull
        Set<kotlin.reflect.jvm.internal.impl.name.f> b();

        @NotNull
        Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull k2.b bVar);

        @NotNull
        Set<kotlin.reflect.jvm.internal.impl.name.f> d();

        @NotNull
        Set<kotlin.reflect.jvm.internal.impl.name.f> e();

        @Nullable
        z0 f(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

        void g(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> collection, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d dVar, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar, @NotNull k2.b bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b implements a {

        /* renamed from: o  reason: collision with root package name */
        static final /* synthetic */ n<Object>[] f58008o = {n0.u(new PropertyReference1Impl(n0.d(b.class), "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;")), n0.u(new PropertyReference1Impl(n0.d(b.class), "declaredProperties", "getDeclaredProperties()Ljava/util/List;")), n0.u(new PropertyReference1Impl(n0.d(b.class), "allTypeAliases", "getAllTypeAliases()Ljava/util/List;")), n0.u(new PropertyReference1Impl(n0.d(b.class), "allFunctions", "getAllFunctions()Ljava/util/List;")), n0.u(new PropertyReference1Impl(n0.d(b.class), "allProperties", "getAllProperties()Ljava/util/List;")), n0.u(new PropertyReference1Impl(n0.d(b.class), "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;")), n0.u(new PropertyReference1Impl(n0.d(b.class), "functionsByName", "getFunctionsByName()Ljava/util/Map;")), n0.u(new PropertyReference1Impl(n0.d(b.class), "propertiesByName", "getPropertiesByName()Ljava/util/Map;")), n0.u(new PropertyReference1Impl(n0.d(b.class), "functionNames", "getFunctionNames()Ljava/util/Set;")), n0.u(new PropertyReference1Impl(n0.d(b.class), "variableNames", "getVariableNames()Ljava/util/Set;"))};
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final List<ProtoBuf.Function> f58009a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final List<ProtoBuf.Property> f58010b;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final List<ProtoBuf.TypeAlias> f58011c;
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f58012d;
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f58013e;
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f58014f;
        @NotNull

        /* renamed from: g  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f58015g;
        @NotNull

        /* renamed from: h  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f58016h;
        @NotNull

        /* renamed from: i  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f58017i;
        @NotNull

        /* renamed from: j  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f58018j;
        @NotNull

        /* renamed from: k  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f58019k;
        @NotNull

        /* renamed from: l  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f58020l;
        @NotNull

        /* renamed from: m  reason: collision with root package name */
        private final kotlin.reflect.jvm.internal.impl.storage.i f58021m;

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ DeserializedMemberScope f58022n;

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.a<List<? extends u0>> {
            a() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            public final List<? extends u0> invoke() {
                List<? extends u0> o4;
                o4 = kotlin.collections.f0.o4(b.this.D(), b.this.t());
                return o4;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope$b$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1173b extends Lambda implements d2.a<List<? extends p0>> {
            C1173b() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            public final List<? extends p0> invoke() {
                List<? extends p0> o4;
                o4 = kotlin.collections.f0.o4(b.this.E(), b.this.u());
                return o4;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class c extends Lambda implements d2.a<List<? extends z0>> {
            c() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            public final List<? extends z0> invoke() {
                return b.this.z();
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class d extends Lambda implements d2.a<List<? extends u0>> {
            d() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            public final List<? extends u0> invoke() {
                return b.this.v();
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class e extends Lambda implements d2.a<List<? extends p0>> {
            e() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            public final List<? extends p0> invoke() {
                return b.this.y();
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class f extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DeserializedMemberScope f58029b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            f(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.f58029b = deserializedMemberScope;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
                Set<kotlin.reflect.jvm.internal.impl.name.f> C;
                b bVar = b.this;
                List<kotlin.reflect.jvm.internal.impl.protobuf.n> list = bVar.f58009a;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                DeserializedMemberScope deserializedMemberScope = bVar.f58022n;
                for (kotlin.reflect.jvm.internal.impl.protobuf.n nVar : list) {
                    linkedHashSet.add(v.b(deserializedMemberScope.f57987b.g(), ((ProtoBuf.Function) nVar).getName()));
                }
                C = k1.C(linkedHashSet, this.f58029b.v());
                return C;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class g extends Lambda implements d2.a<Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends List<? extends u0>>> {
            g() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Map<kotlin.reflect.jvm.internal.impl.name.f, List<u0>> invoke() {
                List A = b.this.A();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : A) {
                    kotlin.reflect.jvm.internal.impl.name.f name = ((u0) obj).getName();
                    f0.o(name, "it.name");
                    Object obj2 = linkedHashMap.get(name);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(name, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class h extends Lambda implements d2.a<Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends List<? extends p0>>> {
            h() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Map<kotlin.reflect.jvm.internal.impl.name.f, List<p0>> invoke() {
                List B = b.this.B();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj : B) {
                    kotlin.reflect.jvm.internal.impl.name.f name = ((p0) obj).getName();
                    f0.o(name, "it.name");
                    Object obj2 = linkedHashMap.get(name);
                    if (obj2 == null) {
                        obj2 = new ArrayList();
                        linkedHashMap.put(name, obj2);
                    }
                    ((List) obj2).add(obj);
                }
                return linkedHashMap;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class i extends Lambda implements d2.a<Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends z0>> {
            i() {
                super(0);
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Map<kotlin.reflect.jvm.internal.impl.name.f, z0> invoke() {
                int Z;
                int j4;
                int n4;
                List C = b.this.C();
                Z = y.Z(C, 10);
                j4 = y0.j(Z);
                n4 = q.n(j4, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
                for (Object obj : C) {
                    kotlin.reflect.jvm.internal.impl.name.f name = ((z0) obj).getName();
                    f0.o(name, "it.name");
                    linkedHashMap.put(name, obj);
                }
                return linkedHashMap;
            }
        }

        /* compiled from: DeserializedMemberScope.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class j extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ DeserializedMemberScope f58034b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            j(DeserializedMemberScope deserializedMemberScope) {
                super(0);
                this.f58034b = deserializedMemberScope;
            }

            @Override // d2.a
            @NotNull
            /* renamed from: a */
            public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
                Set<kotlin.reflect.jvm.internal.impl.name.f> C;
                b bVar = b.this;
                List<kotlin.reflect.jvm.internal.impl.protobuf.n> list = bVar.f58010b;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                DeserializedMemberScope deserializedMemberScope = bVar.f58022n;
                for (kotlin.reflect.jvm.internal.impl.protobuf.n nVar : list) {
                    linkedHashSet.add(v.b(deserializedMemberScope.f57987b.g(), ((ProtoBuf.Property) nVar).getName()));
                }
                C = k1.C(linkedHashSet, this.f58034b.w());
                return C;
            }
        }

        public b(@NotNull DeserializedMemberScope this$0, @NotNull List<ProtoBuf.Function> functionList, @NotNull List<ProtoBuf.Property> propertyList, List<ProtoBuf.TypeAlias> typeAliasList) {
            f0.p(this$0, "this$0");
            f0.p(functionList, "functionList");
            f0.p(propertyList, "propertyList");
            f0.p(typeAliasList, "typeAliasList");
            this.f58022n = this$0;
            this.f58009a = functionList;
            this.f58010b = propertyList;
            this.f58011c = this$0.r().c().g().c() ? typeAliasList : CollectionsKt__CollectionsKt.F();
            this.f58012d = this$0.r().h().g(new d());
            this.f58013e = this$0.r().h().g(new e());
            this.f58014f = this$0.r().h().g(new c());
            this.f58015g = this$0.r().h().g(new a());
            this.f58016h = this$0.r().h().g(new C1173b());
            this.f58017i = this$0.r().h().g(new i());
            this.f58018j = this$0.r().h().g(new g());
            this.f58019k = this$0.r().h().g(new h());
            this.f58020l = this$0.r().h().g(new f(this$0));
            this.f58021m = this$0.r().h().g(new j(this$0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> A() {
            return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58015g, this, f58008o[3]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<p0> B() {
            return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58016h, this, f58008o[4]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<z0> C() {
            return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58014f, this, f58008o[2]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> D() {
            return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58012d, this, f58008o[0]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<p0> E() {
            return (List) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58013e, this, f58008o[1]);
        }

        private final Map<kotlin.reflect.jvm.internal.impl.name.f, Collection<u0>> F() {
            return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58018j, this, f58008o[6]);
        }

        private final Map<kotlin.reflect.jvm.internal.impl.name.f, Collection<p0>> G() {
            return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58019k, this, f58008o[7]);
        }

        private final Map<kotlin.reflect.jvm.internal.impl.name.f, z0> H() {
            return (Map) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58017i, this, f58008o[5]);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> t() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> v3 = this.f58022n.v();
            ArrayList arrayList = new ArrayList();
            for (kotlin.reflect.jvm.internal.impl.name.f fVar : v3) {
                c0.o0(arrayList, w(fVar));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<p0> u() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> w3 = this.f58022n.w();
            ArrayList arrayList = new ArrayList();
            for (kotlin.reflect.jvm.internal.impl.name.f fVar : w3) {
                c0.o0(arrayList, x(fVar));
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<u0> v() {
            List<ProtoBuf.Function> list = this.f58009a;
            DeserializedMemberScope deserializedMemberScope = this.f58022n;
            ArrayList arrayList = new ArrayList();
            for (kotlin.reflect.jvm.internal.impl.protobuf.n nVar : list) {
                u0 j4 = deserializedMemberScope.f57987b.f().j((ProtoBuf.Function) nVar);
                if (!deserializedMemberScope.z(j4)) {
                    j4 = null;
                }
                if (j4 != null) {
                    arrayList.add(j4);
                }
            }
            return arrayList;
        }

        private final List<u0> w(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            List<u0> D = D();
            DeserializedMemberScope deserializedMemberScope = this.f58022n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : D) {
                if (f0.g(((kotlin.reflect.jvm.internal.impl.descriptors.k) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.m(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        private final List<p0> x(kotlin.reflect.jvm.internal.impl.name.f fVar) {
            List<p0> E = E();
            DeserializedMemberScope deserializedMemberScope = this.f58022n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : E) {
                if (f0.g(((kotlin.reflect.jvm.internal.impl.descriptors.k) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            deserializedMemberScope.n(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<p0> y() {
            List<ProtoBuf.Property> list = this.f58010b;
            DeserializedMemberScope deserializedMemberScope = this.f58022n;
            ArrayList arrayList = new ArrayList();
            for (kotlin.reflect.jvm.internal.impl.protobuf.n nVar : list) {
                p0 l4 = deserializedMemberScope.f57987b.f().l((ProtoBuf.Property) nVar);
                if (l4 != null) {
                    arrayList.add(l4);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<z0> z() {
            List<ProtoBuf.TypeAlias> list = this.f58011c;
            DeserializedMemberScope deserializedMemberScope = this.f58022n;
            ArrayList arrayList = new ArrayList();
            for (kotlin.reflect.jvm.internal.impl.protobuf.n nVar : list) {
                z0 m4 = deserializedMemberScope.f57987b.f().m((ProtoBuf.TypeAlias) nVar);
                if (m4 != null) {
                    arrayList.add(m4);
                }
            }
            return arrayList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
            List F;
            List F2;
            f0.p(name, "name");
            f0.p(location, "location");
            if (!b().contains(name)) {
                F2 = CollectionsKt__CollectionsKt.F();
                return F2;
            }
            Collection<u0> collection = F().get(name);
            if (collection == null) {
                F = CollectionsKt__CollectionsKt.F();
                return F;
            }
            return collection;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
            return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58020l, this, f58008o[8]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
            List F;
            List F2;
            f0.p(name, "name");
            f0.p(location, "location");
            if (!d().contains(name)) {
                F2 = CollectionsKt__CollectionsKt.F();
                return F2;
            }
            Collection<p0> collection = G().get(name);
            if (collection == null) {
                F = CollectionsKt__CollectionsKt.F();
                return F;
            }
            return collection;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f58021m, this, f58008o[9]);
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @NotNull
        public Set<kotlin.reflect.jvm.internal.impl.name.f> e() {
            List<ProtoBuf.TypeAlias> list = this.f58011c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            DeserializedMemberScope deserializedMemberScope = this.f58022n;
            for (kotlin.reflect.jvm.internal.impl.protobuf.n nVar : list) {
                linkedHashSet.add(v.b(deserializedMemberScope.f57987b.g(), ((ProtoBuf.TypeAlias) nVar).getName()));
            }
            return linkedHashSet;
        }

        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        @Nullable
        public z0 f(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            f0.p(name, "name");
            return H().get(name);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope.a
        public void g(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> result, @NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter, @NotNull k2.b location) {
            f0.p(result, "result");
            f0.p(kindFilter, "kindFilter");
            f0.p(nameFilter, "nameFilter");
            f0.p(location, "location");
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c.i())) {
                for (Object obj : B()) {
                    kotlin.reflect.jvm.internal.impl.name.f name = ((p0) obj).getName();
                    f0.o(name, "it.name");
                    if (nameFilter.invoke(name).booleanValue()) {
                        result.add(obj);
                    }
                }
            }
            if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c.d())) {
                for (Object obj2 : A()) {
                    kotlin.reflect.jvm.internal.impl.name.f name2 = ((u0) obj2).getName();
                    f0.o(name2, "it.name");
                    if (nameFilter.invoke(name2).booleanValue()) {
                        result.add(obj2);
                    }
                }
            }
        }
    }

    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d2.a<Collection<kotlin.reflect.jvm.internal.impl.name.f>> f58035a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        c(d2.a<? extends Collection<kotlin.reflect.jvm.internal.impl.name.f>> aVar) {
            super(0);
            this.f58035a = aVar;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
            Set<kotlin.reflect.jvm.internal.impl.name.f> L5;
            L5 = kotlin.collections.f0.L5(this.f58035a.invoke());
            return L5;
        }
    }

    /* compiled from: DeserializedMemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.a<Set<? extends kotlin.reflect.jvm.internal.impl.name.f>> {
        d() {
            super(0);
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final Set<kotlin.reflect.jvm.internal.impl.name.f> invoke() {
            Set C;
            Set<kotlin.reflect.jvm.internal.impl.name.f> C2;
            Set<kotlin.reflect.jvm.internal.impl.name.f> u3 = DeserializedMemberScope.this.u();
            if (u3 == null) {
                return null;
            }
            C = k1.C(DeserializedMemberScope.this.s(), DeserializedMemberScope.this.f57988c.e());
            C2 = k1.C(C, u3);
            return C2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DeserializedMemberScope(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.k c4, @NotNull List<ProtoBuf.Function> functionList, @NotNull List<ProtoBuf.Property> propertyList, @NotNull List<ProtoBuf.TypeAlias> typeAliasList, @NotNull d2.a<? extends Collection<kotlin.reflect.jvm.internal.impl.name.f>> classNames) {
        f0.p(c4, "c");
        f0.p(functionList, "functionList");
        f0.p(propertyList, "propertyList");
        f0.p(typeAliasList, "typeAliasList");
        f0.p(classNames, "classNames");
        this.f57987b = c4;
        this.f57988c = p(functionList, propertyList, typeAliasList);
        this.f57989d = c4.h().g(new c(classNames));
        this.f57990e = c4.h().i(new d());
    }

    private final a p(List<ProtoBuf.Function> list, List<ProtoBuf.Property> list2, List<ProtoBuf.TypeAlias> list3) {
        if (this.f57987b.c().g().a()) {
            return new b(this, list, list2, list3);
        }
        return new OptimizedImplementation(this, list, list2, list3);
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d q(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        return this.f57987b.c().b(o(fVar));
    }

    private final Set<kotlin.reflect.jvm.internal.impl.name.f> t() {
        return (Set) kotlin.reflect.jvm.internal.impl.storage.m.b(this.f57990e, this, f57986f[1]);
    }

    private final z0 x(kotlin.reflect.jvm.internal.impl.name.f fVar) {
        return this.f57988c.f(fVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @NotNull
    public Collection<u0> a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        return this.f57988c.a(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> b() {
        return this.f57988c.b();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Collection<p0> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        return this.f57988c.c(name, location);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @NotNull
    public Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
        return this.f57988c.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.h
    @Nullable
    public Set<kotlin.reflect.jvm.internal.impl.name.f> g() {
        return t();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.i, kotlin.reflect.jvm.internal.impl.resolve.scopes.k
    @Nullable
    public kotlin.reflect.jvm.internal.impl.descriptors.f h(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull k2.b location) {
        f0.p(name, "name");
        f0.p(location, "location");
        if (y(name)) {
            return q(name);
        }
        if (this.f57988c.e().contains(name)) {
            return x(name);
        }
        return null;
    }

    protected abstract void k(@NotNull Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> collection, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> lVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final Collection<kotlin.reflect.jvm.internal.impl.descriptors.k> l(@NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.d kindFilter, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.f, Boolean> nameFilter, @NotNull k2.b location) {
        f0.p(kindFilter, "kindFilter");
        f0.p(nameFilter, "nameFilter");
        f0.p(location, "location");
        ArrayList arrayList = new ArrayList(0);
        d.a aVar = kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c;
        if (kindFilter.a(aVar.g())) {
            k(arrayList, nameFilter);
        }
        this.f57988c.g(arrayList, kindFilter, nameFilter, location);
        if (kindFilter.a(aVar.c())) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar : s()) {
                if (nameFilter.invoke(fVar).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, q(fVar));
                }
            }
        }
        if (kindFilter.a(kotlin.reflect.jvm.internal.impl.resolve.scopes.d.f57890c.h())) {
            for (kotlin.reflect.jvm.internal.impl.name.f fVar2 : this.f57988c.e()) {
                if (nameFilter.invoke(fVar2).booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.utils.a.a(arrayList, this.f57988c.f(fVar2));
                }
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
    }

    protected void m(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull List<u0> functions) {
        f0.p(name, "name");
        f0.p(functions, "functions");
    }

    protected void n(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull List<p0> descriptors) {
        f0.p(name, "name");
        f0.p(descriptors, "descriptors");
    }

    @NotNull
    protected abstract kotlin.reflect.jvm.internal.impl.name.b o(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public final kotlin.reflect.jvm.internal.impl.serialization.deserialization.k r() {
        return this.f57987b;
    }

    @NotNull
    public final Set<kotlin.reflect.jvm.internal.impl.name.f> s() {
        return (Set) kotlin.reflect.jvm.internal.impl.storage.m.a(this.f57989d, this, f57986f[0]);
    }

    @Nullable
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> u();

    @NotNull
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> v();

    @NotNull
    protected abstract Set<kotlin.reflect.jvm.internal.impl.name.f> w();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean y(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
        f0.p(name, "name");
        return s().contains(name);
    }

    protected boolean z(@NotNull u0 function) {
        f0.p(function, "function");
        return true;
    }
}
