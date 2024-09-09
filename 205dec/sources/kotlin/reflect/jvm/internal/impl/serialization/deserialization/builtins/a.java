package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import kotlin.jvm.internal.f0;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;

/* compiled from: BuiltInSerializerProtocol.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a extends q2.a {
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    public static final a f57975n = new a();

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private a() {
        /*
            r14 = this;
            kotlin.reflect.jvm.internal.impl.protobuf.f r1 = kotlin.reflect.jvm.internal.impl.protobuf.f.d()
            n2.b.a(r1)
            kotlin.f1 r0 = kotlin.f1.f55527a
            java.lang.String r0 = "newInstance().apply(Buil\u2026f::registerAllExtensions)"
            kotlin.jvm.internal.f0.o(r1, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package, java.lang.Integer> r2 = n2.b.f61498a
            java.lang.String r0 = "packageFqName"
            kotlin.jvm.internal.f0.o(r2, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r3 = n2.b.f61500c
            java.lang.String r0 = "constructorAnnotation"
            kotlin.jvm.internal.f0.o(r3, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r4 = n2.b.f61499b
            java.lang.String r0 = "classAnnotation"
            kotlin.jvm.internal.f0.o(r4, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r5 = n2.b.f61501d
            java.lang.String r0 = "functionAnnotation"
            kotlin.jvm.internal.f0.o(r5, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r6 = n2.b.f61502e
            java.lang.String r0 = "propertyAnnotation"
            kotlin.jvm.internal.f0.o(r6, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r7 = n2.b.f61503f
            java.lang.String r0 = "propertyGetterAnnotation"
            kotlin.jvm.internal.f0.o(r7, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r8 = n2.b.f61504g
            java.lang.String r0 = "propertySetterAnnotation"
            kotlin.jvm.internal.f0.o(r8, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r9 = n2.b.f61506i
            java.lang.String r0 = "enumEntryAnnotation"
            kotlin.jvm.internal.f0.o(r9, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property, kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value> r10 = n2.b.f61505h
            java.lang.String r0 = "compileTimeValue"
            kotlin.jvm.internal.f0.o(r10, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r11 = n2.b.f61507j
            java.lang.String r0 = "parameterAnnotation"
            kotlin.jvm.internal.f0.o(r11, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r12 = n2.b.f61508k
            java.lang.String r0 = "typeAnnotation"
            kotlin.jvm.internal.f0.o(r12, r0)
            kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite$f<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter, java.util.List<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation>> r13 = n2.b.f61509l
            java.lang.String r0 = "typeParameterAnnotation"
            kotlin.jvm.internal.f0.o(r13, r0)
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.a.<init>():void");
    }

    private final String o(kotlin.reflect.jvm.internal.impl.name.c cVar) {
        if (cVar.d()) {
            return "default-package";
        }
        String b4 = cVar.g().b();
        f0.o(b4, "fqName.shortName().asString()");
        return b4;
    }

    @NotNull
    public final String m(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        f0.p(fqName, "fqName");
        return f0.C(o(fqName), ".kotlin_builtins");
    }

    @NotNull
    public final String n(@NotNull kotlin.reflect.jvm.internal.impl.name.c fqName) {
        String j22;
        f0.p(fqName, "fqName");
        StringBuilder sb = new StringBuilder();
        String b4 = fqName.b();
        f0.o(b4, "fqName.asString()");
        j22 = w.j2(b4, '.', '/', false, 4, null);
        sb.append(j22);
        sb.append('/');
        sb.append(m(fqName));
        return sb.toString();
    }
}
