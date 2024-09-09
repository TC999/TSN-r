package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.load.kotlin.p;
import kotlin.reflect.jvm.internal.impl.load.kotlin.s;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.resolve.constants.q;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.x;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a<A, C> implements kotlin.reflect.jvm.internal.impl.serialization.deserialization.b<A, C> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final n f57139a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.storage.g<p, b<A, C>> f57140b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum EnumC1144a {
        PROPERTY,
        BACKING_FIELD,
        DELEGATE_FIELD
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<A, C> {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Map<s, List<A>> f57145a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final Map<s, C> f57146b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull Map<s, ? extends List<? extends A>> memberAnnotations, @NotNull Map<s, ? extends C> propertyConstants) {
            f0.p(memberAnnotations, "memberAnnotations");
            f0.p(propertyConstants, "propertyConstants");
            this.f57145a = memberAnnotations;
            this.f57146b = propertyConstants;
        }

        @NotNull
        public final Map<s, List<A>> a() {
            return this.f57145a;
        }

        @NotNull
        public final Map<s, C> b() {
            return this.f57146b;
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57147a;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 1;
            iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 2;
            iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 3;
            f57147a = iArr;
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d implements p.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a<A, C> f57148a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ HashMap<s, List<A>> f57149b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ HashMap<s, C> f57150c;

        /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.kotlin.a$d$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class C1145a extends b implements p.e {

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ d f57151d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1145a(@NotNull d this$0, s signature) {
                super(this$0, signature);
                f0.p(this$0, "this$0");
                f0.p(signature, "signature");
                this.f57151d = this$0;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.e
            @Nullable
            public p.a a(int i4, @NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull v0 source) {
                f0.p(classId, "classId");
                f0.p(source, "source");
                s e4 = s.f57258b.e(c(), i4);
                List<A> list = this.f57151d.f57149b.get(e4);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f57151d.f57149b.put(e4, list);
                }
                return this.f57151d.f57148a.z(classId, source, list);
            }
        }

        /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class b implements p.c {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final s f57152a;
            @NotNull

            /* renamed from: b  reason: collision with root package name */
            private final ArrayList<A> f57153b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d f57154c;

            public b(@NotNull d this$0, s signature) {
                f0.p(this$0, "this$0");
                f0.p(signature, "signature");
                this.f57154c = this$0;
                this.f57152a = signature;
                this.f57153b = new ArrayList<>();
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.c
            @Nullable
            public p.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull v0 source) {
                f0.p(classId, "classId");
                f0.p(source, "source");
                return this.f57154c.f57148a.z(classId, source, this.f57153b);
            }

            @NotNull
            protected final s c() {
                return this.f57152a;
            }

            @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.c
            public void visitEnd() {
                if (!this.f57153b.isEmpty()) {
                    this.f57154c.f57149b.put(this.f57152a, this.f57153b);
                }
            }
        }

        d(a<A, C> aVar, HashMap<s, List<A>> hashMap, HashMap<s, C> hashMap2) {
            this.f57148a = aVar;
            this.f57149b = hashMap;
            this.f57150c = hashMap2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.d
        @Nullable
        public p.c a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull String desc, @Nullable Object obj) {
            C B;
            f0.p(name, "name");
            f0.p(desc, "desc");
            s.a aVar = s.f57258b;
            String b4 = name.b();
            f0.o(b4, "name.asString()");
            s a4 = aVar.a(b4, desc);
            if (obj != null && (B = this.f57148a.B(desc, obj)) != null) {
                this.f57150c.put(a4, B);
            }
            return new b(this, a4);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.d
        @Nullable
        public p.e b(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull String desc) {
            f0.p(name, "name");
            f0.p(desc, "desc");
            s.a aVar = s.f57258b;
            String b4 = name.b();
            f0.o(b4, "name.asString()");
            return new C1145a(this, aVar.d(b4, desc));
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e implements p.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a<A, C> f57155a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList<A> f57156b;

        e(a<A, C> aVar, ArrayList<A> arrayList) {
            this.f57155a = aVar;
            this.f57156b = arrayList;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.c
        @Nullable
        public p.a b(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId, @NotNull v0 source) {
            f0.p(classId, "classId");
            f0.p(source, "source");
            return this.f57155a.z(classId, source, this.f57156b);
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.kotlin.p.c
        public void visitEnd() {
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class f extends Lambda implements d2.l<p, b<? extends A, ? extends C>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a<A, C> f57157a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(a<A, C> aVar) {
            super(1);
            this.f57157a = aVar;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final b<A, C> invoke(@NotNull p kotlinClass) {
            f0.p(kotlinClass, "kotlinClass");
            return this.f57157a.A(kotlinClass);
        }
    }

    public a(@NotNull kotlin.reflect.jvm.internal.impl.storage.n storageManager, @NotNull n kotlinClassFinder) {
        f0.p(storageManager, "storageManager");
        f0.p(kotlinClassFinder, "kotlinClassFinder");
        this.f57139a = kotlinClassFinder;
        this.f57140b = storageManager.c(new f(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b<A, C> A(p pVar) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        pVar.d(new d(this, hashMap, hashMap2), q(pVar));
        return new b<>(hashMap, hashMap2);
    }

    private final List<A> C(kotlin.reflect.jvm.internal.impl.serialization.deserialization.x xVar, ProtoBuf.Property property, EnumC1144a enumC1144a) {
        boolean V2;
        List<A> F;
        List<A> F2;
        List<A> F3;
        Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.A.d(property.getFlags());
        f0.o(d4, "IS_CONST.get(proto.flags)");
        boolean booleanValue = d4.booleanValue();
        boolean f4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f(property);
        if (enumC1144a == EnumC1144a.PROPERTY) {
            s u3 = u(this, property, xVar.b(), xVar.d(), false, true, false, 40, null);
            if (u3 == null) {
                F3 = CollectionsKt__CollectionsKt.F();
                return F3;
            }
            return o(this, xVar, u3, true, false, Boolean.valueOf(booleanValue), f4, 8, null);
        }
        s u4 = u(this, property, xVar.b(), xVar.d(), true, false, false, 48, null);
        if (u4 == null) {
            F2 = CollectionsKt__CollectionsKt.F();
            return F2;
        }
        V2 = kotlin.text.x.V2(u4.a(), "$delegate", false, 2, null);
        if (V2 != (enumC1144a == EnumC1144a.DELEGATE_FIELD)) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        return n(xVar, u4, true, true, Boolean.valueOf(booleanValue), f4);
    }

    private final p E(x.a aVar) {
        v0 c4 = aVar.c();
        r rVar = c4 instanceof r ? (r) c4 : null;
        if (rVar == null) {
            return null;
        }
        return rVar.d();
    }

    private final int m(kotlin.reflect.jvm.internal.impl.serialization.deserialization.x xVar, kotlin.reflect.jvm.internal.impl.protobuf.n nVar) {
        if (nVar instanceof ProtoBuf.Function) {
            if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.d((ProtoBuf.Function) nVar)) {
                return 1;
            }
        } else if (nVar instanceof ProtoBuf.Property) {
            if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.e((ProtoBuf.Property) nVar)) {
                return 1;
            }
        } else if (nVar instanceof ProtoBuf.Constructor) {
            x.a aVar = (x.a) xVar;
            if (aVar.g() == ProtoBuf.Class.Kind.ENUM_CLASS) {
                return 2;
            }
            if (aVar.i()) {
                return 1;
            }
        } else {
            throw new UnsupportedOperationException(f0.C("Unsupported message: ", nVar.getClass()));
        }
        return 0;
    }

    private final List<A> n(kotlin.reflect.jvm.internal.impl.serialization.deserialization.x xVar, s sVar, boolean z3, boolean z4, Boolean bool, boolean z5) {
        List<A> F;
        List<A> F2;
        p p3 = p(xVar, v(xVar, z3, z4, bool, z5));
        if (p3 == null) {
            F2 = CollectionsKt__CollectionsKt.F();
            return F2;
        }
        List<A> list = this.f57140b.invoke(p3).a().get(sVar);
        if (list == null) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        return list;
    }

    static /* synthetic */ List o(a aVar, kotlin.reflect.jvm.internal.impl.serialization.deserialization.x xVar, s sVar, boolean z3, boolean z4, Boolean bool, boolean z5, int i4, Object obj) {
        if (obj == null) {
            return aVar.n(xVar, sVar, (i4 & 4) != 0 ? false : z3, (i4 & 8) != 0 ? false : z4, (i4 & 16) != 0 ? null : bool, (i4 & 32) != 0 ? false : z5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
    }

    private final p p(kotlin.reflect.jvm.internal.impl.serialization.deserialization.x xVar, p pVar) {
        if (pVar != null) {
            return pVar;
        }
        if (xVar instanceof x.a) {
            return E((x.a) xVar);
        }
        return null;
    }

    private final s r(kotlin.reflect.jvm.internal.impl.protobuf.n nVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar, AnnotatedCallableKind annotatedCallableKind, boolean z3) {
        if (nVar instanceof ProtoBuf.Constructor) {
            s.a aVar = s.f57258b;
            d.b b4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f57549a.b((ProtoBuf.Constructor) nVar, cVar, gVar);
            if (b4 == null) {
                return null;
            }
            return aVar.b(b4);
        } else if (nVar instanceof ProtoBuf.Function) {
            s.a aVar2 = s.f57258b;
            d.b e4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f57549a.e((ProtoBuf.Function) nVar, cVar, gVar);
            if (e4 == null) {
                return null;
            }
            return aVar2.b(e4);
        } else if (nVar instanceof ProtoBuf.Property) {
            GeneratedMessageLite.f<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f57490d;
            f0.o(propertySignature, "propertySignature");
            JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.a((GeneratedMessageLite.ExtendableMessage) nVar, propertySignature);
            if (jvmPropertySignature == null) {
                return null;
            }
            int i4 = c.f57147a[annotatedCallableKind.ordinal()];
            if (i4 == 1) {
                if (jvmPropertySignature.hasGetter()) {
                    s.a aVar3 = s.f57258b;
                    JvmProtoBuf.JvmMethodSignature getter = jvmPropertySignature.getGetter();
                    f0.o(getter, "signature.getter");
                    return aVar3.c(cVar, getter);
                }
                return null;
            } else if (i4 != 2) {
                if (i4 != 3) {
                    return null;
                }
                return t((ProtoBuf.Property) nVar, cVar, gVar, true, true, z3);
            } else if (jvmPropertySignature.hasSetter()) {
                s.a aVar4 = s.f57258b;
                JvmProtoBuf.JvmMethodSignature setter = jvmPropertySignature.getSetter();
                f0.o(setter, "signature.setter");
                return aVar4.c(cVar, setter);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    static /* synthetic */ s s(a aVar, kotlin.reflect.jvm.internal.impl.protobuf.n nVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar, AnnotatedCallableKind annotatedCallableKind, boolean z3, int i4, Object obj) {
        if (obj == null) {
            return aVar.r(nVar, cVar, gVar, annotatedCallableKind, (i4 & 16) != 0 ? false : z3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
    }

    private final s t(ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar, boolean z3, boolean z4, boolean z5) {
        GeneratedMessageLite.f<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f57490d;
        f0.o(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.a(property, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        if (z3) {
            d.a c4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f57549a.c(property, cVar, gVar, z5);
            if (c4 == null) {
                return null;
            }
            return s.f57258b.b(c4);
        } else if (z4 && jvmPropertySignature.hasSyntheticMethod()) {
            s.a aVar = s.f57258b;
            JvmProtoBuf.JvmMethodSignature syntheticMethod = jvmPropertySignature.getSyntheticMethod();
            f0.o(syntheticMethod, "signature.syntheticMethod");
            return aVar.c(cVar, syntheticMethod);
        } else {
            return null;
        }
    }

    static /* synthetic */ s u(a aVar, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar, boolean z3, boolean z4, boolean z5, int i4, Object obj) {
        if (obj == null) {
            return aVar.t(property, cVar, gVar, (i4 & 8) != 0 ? false : z3, (i4 & 16) != 0 ? false : z4, (i4 & 32) != 0 ? true : z5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPropertySignature");
    }

    private final p v(kotlin.reflect.jvm.internal.impl.serialization.deserialization.x xVar, boolean z3, boolean z4, Boolean bool, boolean z5) {
        x.a h4;
        String j22;
        if (z3) {
            if (bool != null) {
                if (xVar instanceof x.a) {
                    x.a aVar = (x.a) xVar;
                    if (aVar.g() == ProtoBuf.Class.Kind.INTERFACE) {
                        n nVar = this.f57139a;
                        kotlin.reflect.jvm.internal.impl.name.b d4 = aVar.e().d(kotlin.reflect.jvm.internal.impl.name.f.f("DefaultImpls"));
                        f0.o(d4, "container.classId.create\u2026EFAULT_IMPLS_CLASS_NAME))");
                        return o.a(nVar, d4);
                    }
                }
                if (bool.booleanValue() && (xVar instanceof x.b)) {
                    v0 c4 = xVar.c();
                    j jVar = c4 instanceof j ? (j) c4 : null;
                    kotlin.reflect.jvm.internal.impl.resolve.jvm.d e4 = jVar == null ? null : jVar.e();
                    if (e4 != null) {
                        n nVar2 = this.f57139a;
                        String f4 = e4.f();
                        f0.o(f4, "facadeClassName.internalName");
                        j22 = kotlin.text.w.j2(f4, '/', '.', false, 4, null);
                        kotlin.reflect.jvm.internal.impl.name.b m4 = kotlin.reflect.jvm.internal.impl.name.b.m(new kotlin.reflect.jvm.internal.impl.name.c(j22));
                        f0.o(m4, "topLevel(FqName(facadeCl\u2026lName.replace('/', '.')))");
                        return o.a(nVar2, m4);
                    }
                }
            } else {
                throw new IllegalStateException(("isConst should not be null for property (container=" + xVar + ')').toString());
            }
        }
        if (z4 && (xVar instanceof x.a)) {
            x.a aVar2 = (x.a) xVar;
            if (aVar2.g() == ProtoBuf.Class.Kind.COMPANION_OBJECT && (h4 = aVar2.h()) != null && (h4.g() == ProtoBuf.Class.Kind.CLASS || h4.g() == ProtoBuf.Class.Kind.ENUM_CLASS || (z5 && (h4.g() == ProtoBuf.Class.Kind.INTERFACE || h4.g() == ProtoBuf.Class.Kind.ANNOTATION_CLASS)))) {
                return E(h4);
            }
        }
        if ((xVar instanceof x.b) && (xVar.c() instanceof j)) {
            v0 c5 = xVar.c();
            if (c5 != null) {
                j jVar2 = (j) c5;
                p f5 = jVar2.f();
                return f5 == null ? o.a(this.f57139a, jVar2.d()) : f5;
            }
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final p.a z(kotlin.reflect.jvm.internal.impl.name.b bVar, v0 v0Var, List<A> list) {
        if (kotlin.reflect.jvm.internal.impl.a.f56011a.b().contains(bVar)) {
            return null;
        }
        return y(bVar, v0Var, list);
    }

    @Nullable
    protected abstract C B(@NotNull String str, @NotNull Object obj);

    @NotNull
    protected abstract A D(@NotNull ProtoBuf.Annotation annotation, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar);

    @Nullable
    protected abstract C F(@NotNull C c4);

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<A> a(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.x container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n callableProto, @NotNull AnnotatedCallableKind kind, int i4, @NotNull ProtoBuf.ValueParameter proto) {
        List<A> F;
        f0.p(container, "container");
        f0.p(callableProto, "callableProto");
        f0.p(kind, "kind");
        f0.p(proto, "proto");
        s s3 = s(this, callableProto, container.b(), container.d(), kind, false, 16, null);
        if (s3 != null) {
            return o(this, container, s.f57258b.e(s3, i4 + m(container, callableProto)), false, false, null, false, 60, null);
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<A> b(@NotNull x.a container) {
        f0.p(container, "container");
        p E = E(container);
        if (E != null) {
            ArrayList arrayList = new ArrayList(1);
            E.f(new e(this, arrayList), q(E));
            return arrayList;
        }
        throw new IllegalStateException(f0.C("Class for loading annotations is not found: ", container.a()).toString());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<A> c(@NotNull ProtoBuf.Type proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver) {
        int Z;
        f0.p(proto, "proto");
        f0.p(nameResolver, "nameResolver");
        Object extension = proto.getExtension(JvmProtoBuf.f57492f);
        f0.o(extension, "proto.getExtension(JvmProtoBuf.typeAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        Z = kotlin.collections.y.Z(iterable, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (ProtoBuf.Annotation it : iterable) {
            f0.o(it, "it");
            arrayList.add(D(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<A> d(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.x container, @NotNull ProtoBuf.EnumEntry proto) {
        f0.p(container, "container");
        f0.p(proto, "proto");
        s.a aVar = s.f57258b;
        String string = container.b().getString(proto.getName());
        String c4 = ((x.a) container).e().c();
        f0.o(c4, "container as ProtoContai\u2026Class).classId.asString()");
        return o(this, container, aVar.a(string, kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.b.b(c4)), false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<A> e(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.x container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n proto, @NotNull AnnotatedCallableKind kind) {
        List<A> F;
        f0.p(container, "container");
        f0.p(proto, "proto");
        f0.p(kind, "kind");
        if (kind == AnnotatedCallableKind.PROPERTY) {
            return C(container, (ProtoBuf.Property) proto, EnumC1144a.PROPERTY);
        }
        s s3 = s(this, proto, container.b(), container.d(), kind, false, 16, null);
        if (s3 == null) {
            F = CollectionsKt__CollectionsKt.F();
            return F;
        }
        return o(this, container, s3, false, false, null, false, 60, null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<A> f(@NotNull ProtoBuf.TypeParameter proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver) {
        int Z;
        f0.p(proto, "proto");
        f0.p(nameResolver, "nameResolver");
        Object extension = proto.getExtension(JvmProtoBuf.f57494h);
        f0.o(extension, "proto.getExtension(JvmPr\u2026.typeParameterAnnotation)");
        Iterable<ProtoBuf.Annotation> iterable = (Iterable) extension;
        Z = kotlin.collections.y.Z(iterable, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (ProtoBuf.Annotation it : iterable) {
            f0.o(it, "it");
            arrayList.add(D(it, nameResolver));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @Nullable
    public C g(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.x container, @NotNull ProtoBuf.Property proto, @NotNull e0 expectedType) {
        C c4;
        f0.p(container, "container");
        f0.p(proto, "proto");
        f0.p(expectedType, "expectedType");
        p p3 = p(container, v(container, true, true, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.A.d(proto.getFlags()), kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f(proto)));
        if (p3 == null) {
            return null;
        }
        s r3 = r(proto, container.b(), container.d(), AnnotatedCallableKind.PROPERTY, p3.e().d().d(kotlin.reflect.jvm.internal.impl.load.kotlin.f.f57187b.a()));
        if (r3 == null || (c4 = this.f57140b.invoke(p3).b().get(r3)) == null) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.builtins.l.d(expectedType) ? F(c4) : c4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<A> h(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.x container, @NotNull ProtoBuf.Property proto) {
        f0.p(container, "container");
        f0.p(proto, "proto");
        return C(container, proto, EnumC1144a.BACKING_FIELD);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<A> i(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.x container, @NotNull kotlin.reflect.jvm.internal.impl.protobuf.n proto, @NotNull AnnotatedCallableKind kind) {
        List<A> F;
        f0.p(container, "container");
        f0.p(proto, "proto");
        f0.p(kind, "kind");
        s s3 = s(this, proto, container.b(), container.d(), kind, false, 16, null);
        if (s3 != null) {
            return o(this, container, s.f57258b.e(s3, 0), false, false, null, false, 60, null);
        }
        F = CollectionsKt__CollectionsKt.F();
        return F;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.b
    @NotNull
    public List<A> j(@NotNull kotlin.reflect.jvm.internal.impl.serialization.deserialization.x container, @NotNull ProtoBuf.Property proto) {
        f0.p(container, "container");
        f0.p(proto, "proto");
        return C(container, proto, EnumC1144a.DELEGATE_FIELD);
    }

    @Nullable
    protected byte[] q(@NotNull p kotlinClass) {
        f0.p(kotlinClass, "kotlinClass");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean w(@NotNull kotlin.reflect.jvm.internal.impl.name.b classId) {
        p a4;
        f0.p(classId, "classId");
        return classId.g() != null && f0.g(classId.j().b(), "Container") && (a4 = o.a(this.f57139a, classId)) != null && kotlin.reflect.jvm.internal.impl.a.f56011a.c(a4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean x(@NotNull kotlin.reflect.jvm.internal.impl.name.b annotationClassId, @NotNull Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> arguments) {
        f0.p(annotationClassId, "annotationClassId");
        f0.p(arguments, "arguments");
        if (f0.g(annotationClassId, kotlin.reflect.jvm.internal.impl.a.f56011a.a())) {
            kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar = arguments.get(kotlin.reflect.jvm.internal.impl.name.f.f("value"));
            kotlin.reflect.jvm.internal.impl.resolve.constants.q qVar = gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.q ? (kotlin.reflect.jvm.internal.impl.resolve.constants.q) gVar : null;
            if (qVar == null) {
                return false;
            }
            q.b a4 = qVar.a();
            q.b.C1167b c1167b = a4 instanceof q.b.C1167b ? (q.b.C1167b) a4 : null;
            if (c1167b == null) {
                return false;
            }
            return w(c1167b.b());
        }
        return false;
    }

    @Nullable
    protected abstract p.a y(@NotNull kotlin.reflect.jvm.internal.impl.name.b bVar, @NotNull v0 v0Var, @NotNull List<A> list);
}
