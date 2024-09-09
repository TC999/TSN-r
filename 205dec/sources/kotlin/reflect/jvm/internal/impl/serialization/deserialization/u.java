package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.f0;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.x;
import kotlin.reflect.jvm.internal.impl.types.e0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MemberDeserializer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final k f58166a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.serialization.deserialization.d f58167b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MemberDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.n f58169b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AnnotatedCallableKind f58170c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind) {
            super(0);
            this.f58169b = nVar;
            this.f58170c = annotatedCallableKind;
        }

        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> G5;
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> F;
            u uVar = u.this;
            x c4 = uVar.c(uVar.f58166a.e());
            if (c4 == null) {
                G5 = null;
            } else {
                u uVar2 = u.this;
                G5 = f0.G5(uVar2.f58166a.c().d().e(c4, this.f58169b, this.f58170c));
            }
            if (G5 == null) {
                F = CollectionsKt__CollectionsKt.F();
                return F;
            }
            return G5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MemberDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f58172b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ProtoBuf.Property f58173c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(boolean z3, ProtoBuf.Property property) {
            super(0);
            this.f58172b = z3;
            this.f58173c = property;
        }

        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> G5;
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> F;
            u uVar = u.this;
            x c4 = uVar.c(uVar.f58166a.e());
            if (c4 == null) {
                G5 = null;
            } else {
                boolean z3 = this.f58172b;
                u uVar2 = u.this;
                ProtoBuf.Property property = this.f58173c;
                if (z3) {
                    G5 = f0.G5(uVar2.f58166a.c().d().j(c4, property));
                } else {
                    G5 = f0.G5(uVar2.f58166a.c().d().h(c4, property));
                }
            }
            if (G5 == null) {
                F = CollectionsKt__CollectionsKt.F();
                return F;
            }
            return G5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MemberDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.n f58175b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AnnotatedCallableKind f58176c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind) {
            super(0);
            this.f58175b = nVar;
            this.f58176c = annotatedCallableKind;
        }

        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            List<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> i4;
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> F;
            u uVar = u.this;
            x c4 = uVar.c(uVar.f58166a.e());
            if (c4 == null) {
                i4 = null;
            } else {
                u uVar2 = u.this;
                i4 = uVar2.f58166a.c().d().i(c4, this.f58175b, this.f58176c);
            }
            if (i4 == null) {
                F = CollectionsKt__CollectionsKt.F();
                return F;
            }
            return i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MemberDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ProtoBuf.Property f58178b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i f58179c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i iVar) {
            super(0);
            this.f58178b = property;
            this.f58179c = iVar;
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> invoke() {
            u uVar = u.this;
            x c4 = uVar.c(uVar.f58166a.e());
            kotlin.jvm.internal.f0.m(c4);
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.b<kotlin.reflect.jvm.internal.impl.descriptors.annotations.c, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d4 = u.this.f58166a.c().d();
            ProtoBuf.Property property = this.f58178b;
            e0 returnType = this.f58179c.getReturnType();
            kotlin.jvm.internal.f0.o(returnType, "property.returnType");
            return d4.g(c4, property, returnType);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MemberDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends Lambda implements d2.a<List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x f58181b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.protobuf.n f58182c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AnnotatedCallableKind f58183d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f58184e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ProtoBuf.ValueParameter f58185f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(x xVar, kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind, int i4, ProtoBuf.ValueParameter valueParameter) {
            super(0);
            this.f58181b = xVar;
            this.f58182c = nVar;
            this.f58183d = annotatedCallableKind;
            this.f58184e = i4;
            this.f58185f = valueParameter;
        }

        @Override // d2.a
        @NotNull
        public final List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> invoke() {
            List<? extends kotlin.reflect.jvm.internal.impl.descriptors.annotations.c> G5;
            G5 = f0.G5(u.this.f58166a.c().d().a(this.f58181b, this.f58182c, this.f58183d, this.f58184e, this.f58185f));
            return G5;
        }
    }

    public u(@NotNull k c4) {
        kotlin.jvm.internal.f0.p(c4, "c");
        this.f58166a = c4;
        this.f58167b = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.d(c4.c().p(), c4.c().q());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x c(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
        if (kVar instanceof g0) {
            return new x.b(((g0) kVar).e(), this.f58166a.g(), this.f58166a.j(), this.f58166a.d());
        }
        if (kVar instanceof kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e) {
            return ((kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.e) kVar).Y0();
        }
        return null;
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f d(kotlin.reflect.jvm.internal.impl.protobuf.n nVar, int i4, AnnotatedCallableKind annotatedCallableKind) {
        if (!kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57453c.d(i4).booleanValue()) {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m(this.f58166a.h(), new a(nVar, annotatedCallableKind));
    }

    private final s0 e() {
        kotlin.reflect.jvm.internal.impl.descriptors.k e4 = this.f58166a.e();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = e4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) e4 : null;
        if (dVar == null) {
            return null;
        }
        return dVar.E0();
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f f(ProtoBuf.Property property, boolean z3) {
        if (!kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57453c.d(property.getFlags()).booleanValue()) {
            return kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        }
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.m(this.f58166a.h(), new b(z3, property));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.annotations.f g(kotlin.reflect.jvm.internal.impl.protobuf.n nVar, AnnotatedCallableKind annotatedCallableKind) {
        return new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.b(this.f58166a.h(), new c(nVar, annotatedCallableKind));
    }

    private final void h(kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j jVar, s0 s0Var, s0 s0Var2, List<? extends a1> list, List<? extends d1> list2, e0 e0Var, Modality modality, kotlin.reflect.jvm.internal.impl.descriptors.s sVar, Map<? extends a.InterfaceC1126a<?>, ?> map) {
        jVar.j1(s0Var, s0Var2, list, list2, e0Var, modality, sVar, map);
    }

    private final int k(int i4) {
        return (i4 & 63) + ((i4 >> 8) << 6);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.descriptors.d1> n(java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter> r26, kotlin.reflect.jvm.internal.impl.protobuf.n r27, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind r28) {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.u.n(java.util.List, kotlin.reflect.jvm.internal.impl.protobuf.n, kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotatedCallableKind):java.util.List");
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.c i(@NotNull ProtoBuf.Constructor proto, boolean z3) {
        List F;
        kotlin.jvm.internal.f0.p(proto, "proto");
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) this.f58166a.e();
        int flags = proto.getFlags();
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d dVar2 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.d(dVar, null, d(proto, flags, annotatedCallableKind), z3, CallableMemberDescriptor.Kind.DECLARATION, proto, this.f58166a.g(), this.f58166a.j(), this.f58166a.k(), this.f58166a.d(), null, 1024, null);
        k kVar = this.f58166a;
        F = CollectionsKt__CollectionsKt.F();
        u f4 = k.b(kVar, dVar2, F, null, null, null, null, 60, null).f();
        List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        kotlin.jvm.internal.f0.o(valueParameterList, "proto.valueParameterList");
        dVar2.k1(f4.n(valueParameterList, proto, annotatedCallableKind), z.a(y.f58199a, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57454d.d(proto.getFlags())));
        dVar2.b1(dVar.q());
        dVar2.T0(!kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57464n.d(proto.getFlags()).booleanValue());
        return dVar2;
    }

    @NotNull
    public final u0 j(@NotNull ProtoBuf.Function proto) {
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f b4;
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.h k4;
        Map<? extends a.InterfaceC1126a<?>, ?> z3;
        kotlin.jvm.internal.f0.p(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : k(proto.getOldFlags());
        AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.FUNCTION;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f d4 = d(proto, flags, annotatedCallableKind);
        if (kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.d(proto)) {
            b4 = g(proto, annotatedCallableKind);
        } else {
            b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        }
        if (kotlin.jvm.internal.f0.g(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(this.f58166a.e()).c(v.b(this.f58166a.g(), proto.getName())), a0.f57959a)) {
            k4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.h.f57484b.b();
        } else {
            k4 = this.f58166a.k();
        }
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.h hVar = k4;
        kotlin.reflect.jvm.internal.impl.descriptors.k e4 = this.f58166a.e();
        kotlin.reflect.jvm.internal.impl.name.f b5 = v.b(this.f58166a.g(), proto.getName());
        y yVar = y.f58199a;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j jVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.j(e4, null, d4, b5, z.b(yVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57465o.d(flags)), proto, this.f58166a.g(), this.f58166a.j(), hVar, this.f58166a.d(), null, 1024, null);
        k kVar = this.f58166a;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        kotlin.jvm.internal.f0.o(typeParameterList, "proto.typeParameterList");
        k b6 = k.b(kVar, jVar, typeParameterList, null, null, null, null, 60, null);
        ProtoBuf.Type h4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.h(proto, this.f58166a.j());
        s0 f4 = h4 == null ? null : kotlin.reflect.jvm.internal.impl.resolve.c.f(jVar, b6.i().p(h4), b4);
        s0 e5 = e();
        List<a1> j4 = b6.i().j();
        u f5 = b6.f();
        List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
        kotlin.jvm.internal.f0.o(valueParameterList, "proto.valueParameterList");
        List<d1> n4 = f5.n(valueParameterList, proto, annotatedCallableKind);
        e0 p3 = b6.i().p(kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.j(proto, this.f58166a.j()));
        Modality b7 = yVar.b(kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57455e.d(flags));
        kotlin.reflect.jvm.internal.impl.descriptors.s a4 = z.a(yVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57454d.d(flags));
        z3 = z0.z();
        h(jVar, f4, e5, j4, n4, p3, b7, a4, z3);
        Boolean d5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57466p.d(flags);
        kotlin.jvm.internal.f0.o(d5, "IS_OPERATOR.get(flags)");
        jVar.a1(d5.booleanValue());
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57467q.d(flags);
        kotlin.jvm.internal.f0.o(d6, "IS_INFIX.get(flags)");
        jVar.X0(d6.booleanValue());
        Boolean d7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57470t.d(flags);
        kotlin.jvm.internal.f0.o(d7, "IS_EXTERNAL_FUNCTION.get(flags)");
        jVar.S0(d7.booleanValue());
        Boolean d8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57468r.d(flags);
        kotlin.jvm.internal.f0.o(d8, "IS_INLINE.get(flags)");
        jVar.Z0(d8.booleanValue());
        Boolean d9 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57469s.d(flags);
        kotlin.jvm.internal.f0.o(d9, "IS_TAILREC.get(flags)");
        jVar.d1(d9.booleanValue());
        Boolean d10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57471u.d(flags);
        kotlin.jvm.internal.f0.o(d10, "IS_SUSPEND.get(flags)");
        jVar.c1(d10.booleanValue());
        Boolean d11 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57472v.d(flags);
        kotlin.jvm.internal.f0.o(d11, "IS_EXPECT_FUNCTION.get(flags)");
        jVar.R0(d11.booleanValue());
        jVar.T0(!kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57473w.d(flags).booleanValue());
        Pair<a.InterfaceC1126a<?>, Object> a5 = this.f58166a.c().h().a(proto, jVar, this.f58166a.j(), b6.i());
        if (a5 != null) {
            jVar.P0(a5.getFirst(), a5.getSecond());
        }
        return jVar;
    }

    @NotNull
    public final p0 l(@NotNull ProtoBuf.Property proto) {
        ProtoBuf.Property property;
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f b4;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i iVar;
        s0 f4;
        b.d<ProtoBuf.Modality> dVar;
        b.d<ProtoBuf.Visibility> dVar2;
        k kVar;
        y yVar;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i iVar2;
        d0 d0Var;
        d0 d0Var2;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i iVar3;
        ProtoBuf.Property property2;
        int i4;
        boolean z3;
        kotlin.reflect.jvm.internal.impl.descriptors.impl.e0 e0Var;
        List F;
        List<ProtoBuf.ValueParameter> l4;
        Object S4;
        d0 b5;
        kotlin.jvm.internal.f0.p(proto, "proto");
        int flags = proto.hasFlags() ? proto.getFlags() : k(proto.getOldFlags());
        kotlin.reflect.jvm.internal.impl.descriptors.k e4 = this.f58166a.e();
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f d4 = d(proto, flags, AnnotatedCallableKind.PROPERTY);
        y yVar2 = y.f58199a;
        b.d<ProtoBuf.Modality> dVar3 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57455e;
        Modality b6 = yVar2.b(dVar3.d(flags));
        b.d<ProtoBuf.Visibility> dVar4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57454d;
        kotlin.reflect.jvm.internal.impl.descriptors.s a4 = z.a(yVar2, dVar4.d(flags));
        Boolean d5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57474x.d(flags);
        kotlin.jvm.internal.f0.o(d5, "IS_VAR.get(flags)");
        boolean booleanValue = d5.booleanValue();
        kotlin.reflect.jvm.internal.impl.name.f b7 = v.b(this.f58166a.g(), proto.getName());
        CallableMemberDescriptor.Kind b8 = z.b(yVar2, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57465o.d(flags));
        Boolean d6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.B.d(flags);
        kotlin.jvm.internal.f0.o(d6, "IS_LATEINIT.get(flags)");
        boolean booleanValue2 = d6.booleanValue();
        Boolean d7 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.A.d(flags);
        kotlin.jvm.internal.f0.o(d7, "IS_CONST.get(flags)");
        boolean booleanValue3 = d7.booleanValue();
        Boolean d8 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.D.d(flags);
        kotlin.jvm.internal.f0.o(d8, "IS_EXTERNAL_PROPERTY.get(flags)");
        boolean booleanValue4 = d8.booleanValue();
        Boolean d9 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.E.d(flags);
        kotlin.jvm.internal.f0.o(d9, "IS_DELEGATED.get(flags)");
        boolean booleanValue5 = d9.booleanValue();
        Boolean d10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.F.d(flags);
        kotlin.jvm.internal.f0.o(d10, "IS_EXPECT_PROPERTY.get(flags)");
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i iVar4 = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.i(e4, null, d4, b6, a4, booleanValue, b7, b8, booleanValue2, booleanValue3, booleanValue4, booleanValue5, d10.booleanValue(), proto, this.f58166a.g(), this.f58166a.j(), this.f58166a.k(), this.f58166a.d());
        k kVar2 = this.f58166a;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        kotlin.jvm.internal.f0.o(typeParameterList, "proto.typeParameterList");
        k b9 = k.b(kVar2, iVar4, typeParameterList, null, null, null, null, 60, null);
        Boolean d11 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57475y.d(flags);
        kotlin.jvm.internal.f0.o(d11, "HAS_GETTER.get(flags)");
        boolean booleanValue6 = d11.booleanValue();
        if (booleanValue6 && kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.e(proto)) {
            property = proto;
            b4 = g(property, AnnotatedCallableKind.PROPERTY_GETTER);
        } else {
            property = proto;
            b4 = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b();
        }
        e0 p3 = b9.i().p(kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.k(property, this.f58166a.j()));
        List<a1> j4 = b9.i().j();
        s0 e5 = e();
        ProtoBuf.Type i5 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.i(property, this.f58166a.j());
        if (i5 == null) {
            iVar = iVar4;
            f4 = null;
        } else {
            iVar = iVar4;
            f4 = kotlin.reflect.jvm.internal.impl.resolve.c.f(iVar, b9.i().p(i5), b4);
        }
        iVar.W0(p3, j4, e5, f4);
        Boolean d12 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57453c.d(flags);
        kotlin.jvm.internal.f0.o(d12, "HAS_ANNOTATIONS.get(flags)");
        int b10 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.b(d12.booleanValue(), dVar4.d(flags), dVar3.d(flags), false, false, false);
        if (booleanValue6) {
            int getterFlags = proto.hasGetterFlags() ? proto.getGetterFlags() : b10;
            Boolean d13 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.J.d(getterFlags);
            kotlin.jvm.internal.f0.o(d13, "IS_NOT_DEFAULT.get(getterFlags)");
            boolean booleanValue7 = d13.booleanValue();
            Boolean d14 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.K.d(getterFlags);
            kotlin.jvm.internal.f0.o(d14, "IS_EXTERNAL_ACCESSOR.get(getterFlags)");
            boolean booleanValue8 = d14.booleanValue();
            Boolean d15 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57450L.d(getterFlags);
            kotlin.jvm.internal.f0.o(d15, "IS_INLINE_ACCESSOR.get(getterFlags)");
            boolean booleanValue9 = d15.booleanValue();
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f d16 = d(property, getterFlags, AnnotatedCallableKind.PROPERTY_GETTER);
            if (booleanValue7) {
                dVar = dVar3;
                yVar = yVar2;
                kVar = b9;
                dVar2 = dVar4;
                iVar2 = iVar;
                b5 = new d0(iVar, d16, yVar2.b(dVar3.d(getterFlags)), z.a(yVar2, dVar4.d(getterFlags)), !booleanValue7, booleanValue8, booleanValue9, iVar.i(), null, v0.f56634a);
            } else {
                dVar = dVar3;
                dVar2 = dVar4;
                kVar = b9;
                yVar = yVar2;
                iVar2 = iVar;
                b5 = kotlin.reflect.jvm.internal.impl.resolve.c.b(iVar2, d16);
                kotlin.jvm.internal.f0.o(b5, "{\n                Descri\u2026nnotations)\n            }");
            }
            b5.L0(iVar2.getReturnType());
            d0Var = b5;
        } else {
            dVar = dVar3;
            dVar2 = dVar4;
            kVar = b9;
            yVar = yVar2;
            iVar2 = iVar;
            d0Var = null;
        }
        Boolean d17 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57476z.d(flags);
        kotlin.jvm.internal.f0.o(d17, "HAS_SETTER.get(flags)");
        if (d17.booleanValue()) {
            if (proto.hasSetterFlags()) {
                b10 = proto.getSetterFlags();
            }
            int i6 = b10;
            Boolean d18 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.J.d(i6);
            kotlin.jvm.internal.f0.o(d18, "IS_NOT_DEFAULT.get(setterFlags)");
            boolean booleanValue10 = d18.booleanValue();
            Boolean d19 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.K.d(i6);
            kotlin.jvm.internal.f0.o(d19, "IS_EXTERNAL_ACCESSOR.get(setterFlags)");
            boolean booleanValue11 = d19.booleanValue();
            Boolean d20 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57450L.d(i6);
            kotlin.jvm.internal.f0.o(d20, "IS_INLINE_ACCESSOR.get(setterFlags)");
            boolean booleanValue12 = d20.booleanValue();
            AnnotatedCallableKind annotatedCallableKind = AnnotatedCallableKind.PROPERTY_SETTER;
            kotlin.reflect.jvm.internal.impl.descriptors.annotations.f d21 = d(property, i6, annotatedCallableKind);
            if (booleanValue10) {
                y yVar3 = yVar;
                d0Var2 = d0Var;
                kotlin.reflect.jvm.internal.impl.descriptors.impl.e0 e0Var2 = new kotlin.reflect.jvm.internal.impl.descriptors.impl.e0(iVar2, d21, yVar3.b(dVar.d(i6)), z.a(yVar3, dVar2.d(i6)), !booleanValue10, booleanValue11, booleanValue12, iVar2.i(), null, v0.f56634a);
                F = CollectionsKt__CollectionsKt.F();
                iVar3 = iVar2;
                z3 = true;
                property2 = property;
                i4 = flags;
                u f5 = k.b(kVar, e0Var2, F, null, null, null, null, 60, null).f();
                l4 = kotlin.collections.x.l(proto.getSetterValueParameter());
                S4 = f0.S4(f5.n(l4, property2, annotatedCallableKind));
                e0Var2.M0((d1) S4);
                e0Var = e0Var2;
            } else {
                d0Var2 = d0Var;
                iVar3 = iVar2;
                property2 = property;
                i4 = flags;
                z3 = true;
                e0Var = kotlin.reflect.jvm.internal.impl.resolve.c.c(iVar3, d21, kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b());
                kotlin.jvm.internal.f0.o(e0Var, "{\n                Descri\u2026          )\n            }");
            }
        } else {
            d0Var2 = d0Var;
            iVar3 = iVar2;
            property2 = property;
            i4 = flags;
            z3 = true;
            e0Var = null;
        }
        Boolean d22 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.C.d(i4);
        kotlin.jvm.internal.f0.o(d22, "HAS_CONSTANT.get(flags)");
        if (d22.booleanValue()) {
            iVar3.G0(this.f58166a.h().i(new d(property2, iVar3)));
        }
        iVar3.Q0(d0Var2, e0Var, new kotlin.reflect.jvm.internal.impl.descriptors.impl.o(f(property2, false), iVar3), new kotlin.reflect.jvm.internal.impl.descriptors.impl.o(f(property2, z3), iVar3));
        return iVar3;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.z0 m(@NotNull ProtoBuf.TypeAlias proto) {
        int Z;
        kotlin.jvm.internal.f0.p(proto, "proto");
        f.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0;
        List<ProtoBuf.Annotation> annotationList = proto.getAnnotationList();
        kotlin.jvm.internal.f0.o(annotationList, "proto.annotationList");
        Z = kotlin.collections.y.Z(annotationList, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (ProtoBuf.Annotation it : annotationList) {
            kotlin.reflect.jvm.internal.impl.serialization.deserialization.d dVar = this.f58167b;
            kotlin.jvm.internal.f0.o(it, "it");
            arrayList.add(dVar.a(it, this.f58166a.g()));
        }
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.k kVar = new kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.k(this.f58166a.h(), this.f58166a.e(), aVar.a(arrayList), v.b(this.f58166a.g(), proto.getName()), z.a(y.f58199a, kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.f57454d.d(proto.getFlags())), proto, this.f58166a.g(), this.f58166a.j(), this.f58166a.k(), this.f58166a.d());
        k kVar2 = this.f58166a;
        List<ProtoBuf.TypeParameter> typeParameterList = proto.getTypeParameterList();
        kotlin.jvm.internal.f0.o(typeParameterList, "proto.typeParameterList");
        k b4 = k.b(kVar2, kVar, typeParameterList, null, null, null, null, 60, null);
        kVar.L0(b4.i().j(), b4.i().l(kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.o(proto, this.f58166a.j()), false), b4.i().l(kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.b(proto, this.f58166a.j()), false));
        return kVar;
    }
}
