package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.z0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.c1;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.g0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.types.n;
import kotlin.reflect.jvm.internal.impl.types.p0;
import kotlin.reflect.jvm.internal.impl.types.q0;
import kotlin.reflect.jvm.internal.impl.types.r0;
import kotlin.reflect.jvm.internal.impl.types.y0;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeDeserializer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b0 {
    @NotNull

    /* renamed from: a */
    private final k f57961a;
    @Nullable

    /* renamed from: b */
    private final b0 f57962b;
    @NotNull

    /* renamed from: c */
    private final String f57963c;
    @NotNull

    /* renamed from: d */
    private final String f57964d;
    @NotNull

    /* renamed from: e */
    private final d2.l<Integer, kotlin.reflect.jvm.internal.impl.descriptors.f> f57965e;
    @NotNull

    /* renamed from: f */
    private final d2.l<Integer, kotlin.reflect.jvm.internal.impl.descriptors.f> f57966f;
    @NotNull

    /* renamed from: g */
    private final Map<Integer, a1> f57967g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<Integer, kotlin.reflect.jvm.internal.impl.descriptors.f> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a() {
            super(1);
            b0.this = r1;
        }

        @Nullable
        public final kotlin.reflect.jvm.internal.impl.descriptors.f a(int i4) {
            return b0.this.d(i4);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.f invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

        /* renamed from: b */
        final /* synthetic */ ProtoBuf.Type f57970b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ProtoBuf.Type type) {
            super(0);
            b0.this = r1;
            this.f57970b = type;
        }

        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            return b0.this.f57961a.c().d().c(this.f57970b, b0.this.f57961a.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<Integer, kotlin.reflect.jvm.internal.impl.descriptors.f> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(1);
            b0.this = r1;
        }

        @Nullable
        public final kotlin.reflect.jvm.internal.impl.descriptors.f a(int i4) {
            return b0.this.f(i4);
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.f invoke(Integer num) {
            return a(num.intValue());
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class d extends FunctionReference implements d2.l<kotlin.reflect.jvm.internal.impl.name.b, kotlin.reflect.jvm.internal.impl.name.b> {

        /* renamed from: a */
        public static final d f57972a = new d();

        d() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: d */
        public final kotlin.reflect.jvm.internal.impl.name.b invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.b p02) {
            f0.p(p02, "p0");
            return p02.g();
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "getOuterClassId";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.d(kotlin.reflect.jvm.internal.impl.name.b.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends Lambda implements d2.l<ProtoBuf.Type, ProtoBuf.Type> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            b0.this = r1;
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final ProtoBuf.Type invoke(@NotNull ProtoBuf.Type it) {
            f0.p(it, "it");
            return kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.g(it, b0.this.f57961a.j());
        }
    }

    /* compiled from: TypeDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f extends Lambda implements d2.l<ProtoBuf.Type, Integer> {

        /* renamed from: a */
        public static final f f57974a = new f();

        f() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Integer invoke(@NotNull ProtoBuf.Type it) {
            f0.p(it, "it");
            return Integer.valueOf(it.getArgumentCount());
        }
    }

    public b0(@NotNull k c4, @Nullable b0 b0Var, @NotNull List<ProtoBuf.TypeParameter> typeParameterProtos, @NotNull String debugName, @NotNull String containerPresentableName) {
        Map<Integer, a1> linkedHashMap;
        f0.p(c4, "c");
        f0.p(typeParameterProtos, "typeParameterProtos");
        f0.p(debugName, "debugName");
        f0.p(containerPresentableName, "containerPresentableName");
        this.f57961a = c4;
        this.f57962b = b0Var;
        this.f57963c = debugName;
        this.f57964d = containerPresentableName;
        this.f57965e = c4.h().e(new a());
        this.f57966f = c4.h().e(new c());
        if (typeParameterProtos.isEmpty()) {
            linkedHashMap = z0.z();
        } else {
            linkedHashMap = new LinkedHashMap<>();
            int i4 = 0;
            for (ProtoBuf.TypeParameter typeParameter : typeParameterProtos) {
                linkedHashMap.put(Integer.valueOf(typeParameter.getId()), new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.l(this.f57961a, typeParameter, i4));
                i4++;
            }
        }
        this.f57967g = linkedHashMap;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.f d(int i4) {
        kotlin.reflect.jvm.internal.impl.name.b a4 = v.a(this.f57961a.g(), i4);
        if (a4.k()) {
            return this.f57961a.c().b(a4);
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.v.b(this.f57961a.c().p(), a4);
    }

    private final m0 e(int i4) {
        if (v.a(this.f57961a.g(), i4).k()) {
            return this.f57961a.c().n().a();
        }
        return null;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.f f(int i4) {
        kotlin.reflect.jvm.internal.impl.name.b a4 = v.a(this.f57961a.g(), i4);
        if (a4.k()) {
            return null;
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.v.d(this.f57961a.c().p(), a4);
    }

    private final m0 g(e0 e0Var, e0 e0Var2) {
        List<kotlin.reflect.jvm.internal.impl.types.a1> O1;
        int Z;
        kotlin.reflect.jvm.internal.impl.builtins.h h4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.h(e0Var);
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = e0Var.getAnnotations();
        e0 h5 = kotlin.reflect.jvm.internal.impl.builtins.g.h(e0Var);
        O1 = kotlin.collections.f0.O1(kotlin.reflect.jvm.internal.impl.builtins.g.j(e0Var), 1);
        Z = kotlin.collections.y.Z(O1, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (kotlin.reflect.jvm.internal.impl.types.a1 a1Var : O1) {
            arrayList.add(a1Var.getType());
        }
        return kotlin.reflect.jvm.internal.impl.builtins.g.a(h4, annotations, h5, arrayList, null, e0Var2, true).O0(e0Var.I0());
    }

    private final m0 h(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, y0 y0Var, List<? extends kotlin.reflect.jvm.internal.impl.types.a1> list, boolean z3) {
        int size;
        int size2 = y0Var.getParameters().size() - list.size();
        m0 m0Var = null;
        if (size2 == 0) {
            m0Var = i(fVar, y0Var, list, z3);
        } else if (size2 == 1 && (size = list.size() - 1) >= 0) {
            y0 j4 = y0Var.k().X(size).j();
            f0.o(j4, "functionTypeConstructor.\u2026on(arity).typeConstructor");
            m0Var = kotlin.reflect.jvm.internal.impl.types.f0.j(fVar, j4, list, z3, null, 16, null);
        }
        if (m0Var == null) {
            m0 n4 = kotlin.reflect.jvm.internal.impl.types.w.n(f0.C("Bad suspend function in metadata with constructor: ", y0Var), list);
            f0.o(n4, "createErrorTypeWithArgum\u2026      arguments\n        )");
            return n4;
        }
        return m0Var;
    }

    private final m0 i(kotlin.reflect.jvm.internal.impl.descriptors.annotations.f fVar, y0 y0Var, List<? extends kotlin.reflect.jvm.internal.impl.types.a1> list, boolean z3) {
        m0 j4 = kotlin.reflect.jvm.internal.impl.types.f0.j(fVar, y0Var, list, z3, null, 16, null);
        if (kotlin.reflect.jvm.internal.impl.builtins.g.n(j4)) {
            return o(j4);
        }
        return null;
    }

    private final a1 k(int i4) {
        a1 a1Var = this.f57967g.get(Integer.valueOf(i4));
        if (a1Var == null) {
            b0 b0Var = this.f57962b;
            if (b0Var == null) {
                return null;
            }
            return b0Var.k(i4);
        }
        return a1Var;
    }

    private static final List<ProtoBuf.Type.Argument> m(ProtoBuf.Type type, b0 b0Var) {
        List<ProtoBuf.Type.Argument> o4;
        List<ProtoBuf.Type.Argument> argumentList = type.getArgumentList();
        f0.o(argumentList, "argumentList");
        ProtoBuf.Type g4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.g(type, b0Var.f57961a.j());
        List<ProtoBuf.Type.Argument> m4 = g4 == null ? null : m(g4, b0Var);
        if (m4 == null) {
            m4 = CollectionsKt__CollectionsKt.F();
        }
        o4 = kotlin.collections.f0.o4(argumentList, m4);
        return o4;
    }

    public static /* synthetic */ m0 n(b0 b0Var, ProtoBuf.Type type, boolean z3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z3 = true;
        }
        return b0Var.l(type, z3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0042, code lost:
        if (kotlin.jvm.internal.f0.g(r2, r3) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final kotlin.reflect.jvm.internal.impl.types.m0 o(kotlin.reflect.jvm.internal.impl.types.e0 r6) {
        /*
            r5 = this;
            java.util.List r0 = kotlin.reflect.jvm.internal.impl.builtins.g.j(r6)
            java.lang.Object r0 = kotlin.collections.w.g3(r0)
            kotlin.reflect.jvm.internal.impl.types.a1 r0 = (kotlin.reflect.jvm.internal.impl.types.a1) r0
            r1 = 0
            if (r0 != 0) goto Le
            return r1
        Le:
            kotlin.reflect.jvm.internal.impl.types.e0 r0 = r0.getType()
            java.lang.String r2 = "funType.getValueParamete\u2026ll()?.type ?: return null"
            kotlin.jvm.internal.f0.o(r0, r2)
            kotlin.reflect.jvm.internal.impl.types.y0 r2 = r0.H0()
            kotlin.reflect.jvm.internal.impl.descriptors.f r2 = r2.b()
            if (r2 != 0) goto L23
            r2 = r1
            goto L27
        L23:
            kotlin.reflect.jvm.internal.impl.name.c r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(r2)
        L27:
            java.util.List r3 = r0.G0()
            int r3 = r3.size()
            r4 = 1
            if (r3 != r4) goto L7e
            kotlin.reflect.jvm.internal.impl.name.c r3 = kotlin.reflect.jvm.internal.impl.builtins.j.f56079h
            boolean r3 = kotlin.jvm.internal.f0.g(r2, r3)
            if (r3 != 0) goto L45
            kotlin.reflect.jvm.internal.impl.name.c r3 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.c0.a()
            boolean r2 = kotlin.jvm.internal.f0.g(r2, r3)
            if (r2 != 0) goto L45
            goto L7e
        L45:
            java.util.List r0 = r0.G0()
            java.lang.Object r0 = kotlin.collections.w.S4(r0)
            kotlin.reflect.jvm.internal.impl.types.a1 r0 = (kotlin.reflect.jvm.internal.impl.types.a1) r0
            kotlin.reflect.jvm.internal.impl.types.e0 r0 = r0.getType()
            java.lang.String r2 = "continuationArgumentType.arguments.single().type"
            kotlin.jvm.internal.f0.o(r0, r2)
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.k r2 = r5.f57961a
            kotlin.reflect.jvm.internal.impl.descriptors.k r2 = r2.e()
            boolean r3 = r2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a
            if (r3 != 0) goto L63
            r2 = r1
        L63:
            kotlin.reflect.jvm.internal.impl.descriptors.a r2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) r2
            if (r2 != 0) goto L68
            goto L6c
        L68:
            kotlin.reflect.jvm.internal.impl.name.c r1 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(r2)
        L6c:
            kotlin.reflect.jvm.internal.impl.name.c r2 = kotlin.reflect.jvm.internal.impl.serialization.deserialization.a0.f57959a
            boolean r1 = kotlin.jvm.internal.f0.g(r1, r2)
            if (r1 == 0) goto L79
            kotlin.reflect.jvm.internal.impl.types.m0 r6 = r5.g(r6, r0)
            return r6
        L79:
            kotlin.reflect.jvm.internal.impl.types.m0 r6 = r5.g(r6, r0)
            return r6
        L7e:
            kotlin.reflect.jvm.internal.impl.types.m0 r6 = (kotlin.reflect.jvm.internal.impl.types.m0) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.b0.o(kotlin.reflect.jvm.internal.impl.types.e0):kotlin.reflect.jvm.internal.impl.types.m0");
    }

    private final kotlin.reflect.jvm.internal.impl.types.a1 q(a1 a1Var, ProtoBuf.Type.Argument argument) {
        if (argument.getProjection() == ProtoBuf.Type.Argument.Projection.STAR) {
            if (a1Var == null) {
                return new q0(this.f57961a.c().p().k());
            }
            return new r0(a1Var);
        }
        y yVar = y.f58199a;
        ProtoBuf.Type.Argument.Projection projection = argument.getProjection();
        f0.o(projection, "typeArgumentProto.projection");
        Variance c4 = yVar.c(projection);
        ProtoBuf.Type m4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.m(argument, this.f57961a.j());
        return m4 == null ? new c1(kotlin.reflect.jvm.internal.impl.types.w.j("No type recorded")) : new c1(c4, p(m4));
    }

    private final y0 r(ProtoBuf.Type type) {
        kotlin.reflect.jvm.internal.impl.descriptors.f invoke;
        Object obj;
        if (type.hasClassName()) {
            invoke = this.f57965e.invoke(Integer.valueOf(type.getClassName()));
            if (invoke == null) {
                invoke = s(this, type, type.getClassName());
            }
        } else if (type.hasTypeParameter()) {
            invoke = k(type.getTypeParameter());
            if (invoke == null) {
                y0 k4 = kotlin.reflect.jvm.internal.impl.types.w.k("Unknown type parameter " + type.getTypeParameter() + ". Please try recompiling module containing \"" + this.f57964d + '\"');
                f0.o(k4, "createErrorTypeConstruct\u2026\\\"\"\n                    )");
                return k4;
            }
        } else if (type.hasTypeParameterName()) {
            String string = this.f57961a.g().getString(type.getTypeParameterName());
            Iterator<T> it = j().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (f0.g(((a1) obj).getName().b(), string)) {
                    break;
                }
            }
            invoke = (a1) obj;
            if (invoke == null) {
                y0 k5 = kotlin.reflect.jvm.internal.impl.types.w.k("Deserialized type parameter " + string + " in " + this.f57961a.e());
                f0.o(k5, "createErrorTypeConstruct\u2026.containingDeclaration}\")");
                return k5;
            }
        } else if (type.hasTypeAliasName()) {
            invoke = this.f57966f.invoke(Integer.valueOf(type.getTypeAliasName()));
            if (invoke == null) {
                invoke = s(this, type, type.getTypeAliasName());
            }
        } else {
            y0 k6 = kotlin.reflect.jvm.internal.impl.types.w.k("Unknown type");
            f0.o(k6, "createErrorTypeConstructor(\"Unknown type\")");
            return k6;
        }
        y0 j4 = invoke.j();
        f0.o(j4, "classifier.typeConstructor");
        return j4;
    }

    private static final kotlin.reflect.jvm.internal.impl.descriptors.d s(b0 b0Var, ProtoBuf.Type type, int i4) {
        kotlin.sequences.m q3;
        kotlin.sequences.m d12;
        List<Integer> W2;
        kotlin.sequences.m q4;
        int Z;
        kotlin.reflect.jvm.internal.impl.name.b a4 = v.a(b0Var.f57961a.g(), i4);
        q3 = kotlin.sequences.s.q(type, new e());
        d12 = SequencesKt___SequencesKt.d1(q3, f.f57974a);
        W2 = SequencesKt___SequencesKt.W2(d12);
        q4 = kotlin.sequences.s.q(a4, d.f57972a);
        Z = SequencesKt___SequencesKt.Z(q4);
        while (W2.size() < Z) {
            W2.add(0);
        }
        return b0Var.f57961a.c().q().d(a4, W2);
    }

    @NotNull
    public final List<a1> j() {
        List<a1> G5;
        G5 = kotlin.collections.f0.G5(this.f57967g.values());
        return G5;
    }

    @NotNull
    public final m0 l(@NotNull ProtoBuf.Type proto, boolean z3) {
        m0 e4;
        int Z;
        List<? extends kotlin.reflect.jvm.internal.impl.types.a1> G5;
        m0 j4;
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> k4;
        Object H2;
        f0.p(proto, "proto");
        if (proto.hasClassName()) {
            e4 = e(proto.getClassName());
        } else {
            e4 = proto.hasTypeAliasName() ? e(proto.getTypeAliasName()) : null;
        }
        if (e4 != null) {
            return e4;
        }
        y0 r3 = r(proto);
        if (kotlin.reflect.jvm.internal.impl.types.w.r(r3.b())) {
            m0 o4 = kotlin.reflect.jvm.internal.impl.types.w.o(r3.toString(), r3);
            f0.o(o4, "createErrorTypeWithCusto\u2026.toString(), constructor)");
            return o4;
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b bVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b(this.f57961a.h(), new b(proto));
        List<ProtoBuf.Type.Argument> m4 = m(proto, this);
        Z = kotlin.collections.y.Z(m4, 10);
        ArrayList arrayList = new ArrayList(Z);
        int i4 = 0;
        for (Object obj : m4) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            List<a1> parameters = r3.getParameters();
            f0.o(parameters, "constructor.parameters");
            H2 = kotlin.collections.f0.H2(parameters, i4);
            arrayList.add(q((a1) H2, (ProtoBuf.Type.Argument) obj));
            i4 = i5;
        }
        G5 = kotlin.collections.f0.G5(arrayList);
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = r3.b();
        if (z3 && (b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.z0)) {
            kotlin.reflect.jvm.internal.impl.types.f0 f0Var = kotlin.reflect.jvm.internal.impl.types.f0.f58339a;
            m0 b5 = kotlin.reflect.jvm.internal.impl.types.f0.b((kotlin.reflect.jvm.internal.impl.descriptors.z0) b4, G5);
            m0 O0 = b5.O0(g0.b(b5) || proto.getNullable());
            f.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0;
            k4 = kotlin.collections.f0.k4(bVar, b5.getAnnotations());
            j4 = O0.P0(aVar.a(k4));
        } else {
            Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57451a.d(proto.getFlags());
            f0.o(d4, "SUSPEND_TYPE.get(proto.flags)");
            if (d4.booleanValue()) {
                j4 = h(bVar, r3, G5, proto.getNullable());
            } else {
                j4 = kotlin.reflect.jvm.internal.impl.types.f0.j(bVar, r3, G5, proto.getNullable(), null, 16, null);
                Boolean d5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57452b.d(proto.getFlags());
                f0.o(d5, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
                if (d5.booleanValue()) {
                    kotlin.reflect.jvm.internal.impl.types.n c4 = n.a.c(kotlin.reflect.jvm.internal.impl.types.n.f58394d, j4, false, 2, null);
                    if (c4 == null) {
                        throw new IllegalStateException(("null DefinitelyNotNullType for '" + j4 + '\'').toString());
                    }
                    j4 = c4;
                }
            }
        }
        ProtoBuf.Type a4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.a(proto, this.f57961a.j());
        if (a4 != null) {
            j4 = p0.j(j4, l(a4, false));
        }
        if (proto.hasClassName()) {
            return this.f57961a.c().t().a(v.a(this.f57961a.g(), proto.getClassName()), j4);
        }
        return j4;
    }

    @NotNull
    public final e0 p(@NotNull ProtoBuf.Type proto) {
        f0.p(proto, "proto");
        if (proto.hasFlexibleTypeCapabilitiesId()) {
            String string = this.f57961a.g().getString(proto.getFlexibleTypeCapabilitiesId());
            m0 n4 = n(this, proto, false, 2, null);
            ProtoBuf.Type c4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.c(proto, this.f57961a.j());
            f0.m(c4);
            return this.f57961a.c().l().a(proto, string, n4, n(this, c4, false, 2, null));
        }
        return l(proto, true);
    }

    @NotNull
    public String toString() {
        String str = this.f57963c;
        b0 b0Var = this.f57962b;
        return f0.C(str, b0Var == null ? "" : f0.C(". Child of ", b0Var.f57963c));
    }
}
