package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.b;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JvmProtoBufUtil.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    @NotNull

    /* renamed from: a */
    public static final g f57549a = new g();
    @NotNull

    /* renamed from: b */
    private static final kotlin.reflect.jvm.internal.impl.protobuf.f f57550b;

    static {
        kotlin.reflect.jvm.internal.impl.protobuf.f d4 = kotlin.reflect.jvm.internal.impl.protobuf.f.d();
        JvmProtoBuf.a(d4);
        f0.o(d4, "newInstance().apply(JvmP\u2026f::registerAllExtensions)");
        f57550b = d4;
    }

    private g() {
    }

    public static /* synthetic */ d.a d(g gVar, ProtoBuf.Property property, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar, kotlin.reflect.jvm.internal.impl.metadata.deserialization.g gVar2, boolean z3, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z3 = true;
        }
        return gVar.c(property, cVar, gVar2, z3);
    }

    @JvmStatic
    public static final boolean f(@NotNull ProtoBuf.Property proto) {
        f0.p(proto, "proto");
        b.C1156b a4 = c.f57528a.a();
        Object extension = proto.getExtension(JvmProtoBuf.f57491e);
        f0.o(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean d4 = a4.d(((Number) extension).intValue());
        f0.o(d4, "JvmFlags.IS_MOVED_FROM_I\u2026nsion(JvmProtoBuf.flags))");
        return d4.booleanValue();
    }

    private final String g(ProtoBuf.Type type, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar) {
        if (type.hasClassName()) {
            return b.b(cVar.b(type.getClassName()));
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final Pair<f, ProtoBuf.Class> h(@NotNull byte[] bytes, @NotNull String[] strings) {
        f0.p(bytes, "bytes");
        f0.p(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new Pair<>(f57549a.k(byteArrayInputStream, strings), ProtoBuf.Class.parseFrom(byteArrayInputStream, f57550b));
    }

    @JvmStatic
    @NotNull
    public static final Pair<f, ProtoBuf.Class> i(@NotNull String[] data, @NotNull String[] strings) {
        f0.p(data, "data");
        f0.p(strings, "strings");
        byte[] e4 = a.e(data);
        f0.o(e4, "decodeBytes(data)");
        return h(e4, strings);
    }

    @JvmStatic
    @NotNull
    public static final Pair<f, ProtoBuf.Function> j(@NotNull String[] data, @NotNull String[] strings) {
        f0.p(data, "data");
        f0.p(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.e(data));
        return new Pair<>(f57549a.k(byteArrayInputStream, strings), ProtoBuf.Function.parseFrom(byteArrayInputStream, f57550b));
    }

    private final f k(InputStream inputStream, String[] strArr) {
        JvmProtoBuf.StringTableTypes parseDelimitedFrom = JvmProtoBuf.StringTableTypes.parseDelimitedFrom(inputStream, f57550b);
        f0.o(parseDelimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new f(parseDelimitedFrom, strArr);
    }

    @JvmStatic
    @NotNull
    public static final Pair<f, ProtoBuf.Package> l(@NotNull byte[] bytes, @NotNull String[] strings) {
        f0.p(bytes, "bytes");
        f0.p(strings, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        return new Pair<>(f57549a.k(byteArrayInputStream, strings), ProtoBuf.Package.parseFrom(byteArrayInputStream, f57550b));
    }

    @JvmStatic
    @NotNull
    public static final Pair<f, ProtoBuf.Package> m(@NotNull String[] data, @NotNull String[] strings) {
        f0.p(data, "data");
        f0.p(strings, "strings");
        byte[] e4 = a.e(data);
        f0.o(e4, "decodeBytes(data)");
        return l(e4, strings);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.protobuf.f a() {
        return f57550b;
    }

    @Nullable
    public final d.b b(@NotNull ProtoBuf.Constructor proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable) {
        int Z;
        String X2;
        f0.p(proto, "proto");
        f0.p(nameResolver, "nameResolver");
        f0.p(typeTable, "typeTable");
        GeneratedMessageLite.f<ProtoBuf.Constructor, JvmProtoBuf.JvmMethodSignature> constructorSignature = JvmProtoBuf.f57487a;
        f0.o(constructorSignature, "constructorSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.a(proto, constructorSignature);
        String string = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? "<init>" : nameResolver.getString(jvmMethodSignature.getName());
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            X2 = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
            f0.o(valueParameterList, "proto.valueParameterList");
            Z = y.Z(valueParameterList, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (ProtoBuf.ValueParameter it : valueParameterList) {
                g gVar = f57549a;
                f0.o(it, "it");
                String g4 = gVar.g(kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.n(it, typeTable), nameResolver);
                if (g4 == null) {
                    return null;
                }
                arrayList.add(g4);
            }
            X2 = kotlin.collections.f0.X2(arrayList, "", "(", ")V", 0, null, null, 56, null);
        }
        return new d.b(string, X2);
    }

    @Nullable
    public final d.a c(@NotNull ProtoBuf.Property proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, boolean z3) {
        String g4;
        f0.p(proto, "proto");
        f0.p(nameResolver, "nameResolver");
        f0.p(typeTable, "typeTable");
        GeneratedMessageLite.f<ProtoBuf.Property, JvmProtoBuf.JvmPropertySignature> propertySignature = JvmProtoBuf.f57490d;
        f0.o(propertySignature, "propertySignature");
        JvmProtoBuf.JvmPropertySignature jvmPropertySignature = (JvmProtoBuf.JvmPropertySignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.a(proto, propertySignature);
        if (jvmPropertySignature == null) {
            return null;
        }
        JvmProtoBuf.JvmFieldSignature field = jvmPropertySignature.hasField() ? jvmPropertySignature.getField() : null;
        if (field == null && z3) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? proto.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            g4 = g(kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.k(proto, typeTable), nameResolver);
            if (g4 == null) {
                return null;
            }
        } else {
            g4 = nameResolver.getString(field.getDesc());
        }
        return new d.a(nameResolver.getString(name), g4);
    }

    @Nullable
    public final d.b e(@NotNull ProtoBuf.Function proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable) {
        List N;
        int Z;
        List<ProtoBuf.Type> o4;
        int Z2;
        String X2;
        String C;
        f0.p(proto, "proto");
        f0.p(nameResolver, "nameResolver");
        f0.p(typeTable, "typeTable");
        GeneratedMessageLite.f<ProtoBuf.Function, JvmProtoBuf.JvmMethodSignature> methodSignature = JvmProtoBuf.f57488b;
        f0.o(methodSignature, "methodSignature");
        JvmProtoBuf.JvmMethodSignature jvmMethodSignature = (JvmProtoBuf.JvmMethodSignature) kotlin.reflect.jvm.internal.impl.metadata.deserialization.e.a(proto, methodSignature);
        int name = (jvmMethodSignature == null || !jvmMethodSignature.hasName()) ? proto.getName() : jvmMethodSignature.getName();
        if (jvmMethodSignature != null && jvmMethodSignature.hasDesc()) {
            C = nameResolver.getString(jvmMethodSignature.getDesc());
        } else {
            N = CollectionsKt__CollectionsKt.N(kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.h(proto, typeTable));
            List<ProtoBuf.ValueParameter> valueParameterList = proto.getValueParameterList();
            f0.o(valueParameterList, "proto.valueParameterList");
            Z = y.Z(valueParameterList, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (ProtoBuf.ValueParameter it : valueParameterList) {
                f0.o(it, "it");
                arrayList.add(kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.n(it, typeTable));
            }
            o4 = kotlin.collections.f0.o4(N, arrayList);
            Z2 = y.Z(o4, 10);
            ArrayList arrayList2 = new ArrayList(Z2);
            for (ProtoBuf.Type type : o4) {
                String g4 = f57549a.g(type, nameResolver);
                if (g4 == null) {
                    return null;
                }
                arrayList2.add(g4);
            }
            String g5 = g(kotlin.reflect.jvm.internal.impl.metadata.deserialization.f.j(proto, typeTable), nameResolver);
            if (g5 == null) {
                return null;
            }
            X2 = kotlin.collections.f0.X2(arrayList2, "", "(", ")", 0, null, null, 56, null);
            C = f0.C(X2, g5);
        }
        return new d.b(nameResolver.getString(name), C);
    }
}
