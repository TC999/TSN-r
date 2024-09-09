package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.r0;
import kotlin.collections.y0;
import kotlin.collections.z0;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.constants.k;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;

/* compiled from: AnnotationDeserializer.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final d0 f57983a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final f0 f57984b;

    /* compiled from: AnnotationDeserializer.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f57985a;

        static {
            int[] iArr = new int[ProtoBuf.Annotation.Argument.Value.Type.values().length];
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BYTE.ordinal()] = 1;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.CHAR.ordinal()] = 2;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.SHORT.ordinal()] = 3;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.INT.ordinal()] = 4;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.LONG.ordinal()] = 5;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.FLOAT.ordinal()] = 6;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.DOUBLE.ordinal()] = 7;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.BOOLEAN.ordinal()] = 8;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.STRING.ordinal()] = 9;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.CLASS.ordinal()] = 10;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ENUM.ordinal()] = 11;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ANNOTATION.ordinal()] = 12;
            iArr[ProtoBuf.Annotation.Argument.Value.Type.ARRAY.ordinal()] = 13;
            f57985a = iArr;
        }
    }

    public d(@NotNull d0 module, @NotNull f0 notFoundClasses) {
        kotlin.jvm.internal.f0.p(module, "module");
        kotlin.jvm.internal.f0.p(notFoundClasses, "notFoundClasses");
        this.f57983a = module;
        this.f57984b = notFoundClasses;
    }

    private final boolean b(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar, e0 e0Var, ProtoBuf.Annotation.Argument.Value value) {
        kotlin.ranges.k G;
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        int i4 = type == null ? -1 : a.f57985a[type.ordinal()];
        if (i4 == 10) {
            kotlin.reflect.jvm.internal.impl.descriptors.f b4 = e0Var.H0().b();
            kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
            if (dVar != null && !kotlin.reflect.jvm.internal.impl.builtins.h.j0(dVar)) {
                return false;
            }
        } else if (i4 != 13) {
            return kotlin.jvm.internal.f0.g(gVar.getType(this.f57983a), e0Var);
        } else {
            if ((gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) && ((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar).a().size() == value.getArrayElementList().size()) {
                e0 k4 = c().k(e0Var);
                kotlin.jvm.internal.f0.o(k4, "builtIns.getArrayElementType(expectedType)");
                kotlin.reflect.jvm.internal.impl.resolve.constants.b bVar = (kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar;
                G = CollectionsKt__CollectionsKt.G(bVar.a());
                if (!(G instanceof Collection) || !((Collection) G).isEmpty()) {
                    Iterator<Integer> it = G.iterator();
                    while (it.hasNext()) {
                        int nextInt = ((r0) it).nextInt();
                        ProtoBuf.Annotation.Argument.Value arrayElement = value.getArrayElement(nextInt);
                        kotlin.jvm.internal.f0.o(arrayElement, "value.getArrayElement(i)");
                        if (!b(bVar.a().get(nextInt), k4, arrayElement)) {
                            return false;
                        }
                    }
                }
            } else {
                throw new IllegalStateException(kotlin.jvm.internal.f0.C("Deserialized ArrayValue should have the same number of elements as the original array value: ", gVar).toString());
            }
        }
        return true;
    }

    private final kotlin.reflect.jvm.internal.impl.builtins.h c() {
        return this.f57983a.k();
    }

    private final Pair<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d(ProtoBuf.Annotation.Argument argument, Map<kotlin.reflect.jvm.internal.impl.name.f, ? extends d1> map, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar) {
        d1 d1Var = map.get(v.b(cVar, argument.getNameId()));
        if (d1Var == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.name.f b4 = v.b(cVar, argument.getNameId());
        e0 type = d1Var.getType();
        kotlin.jvm.internal.f0.o(type, "parameter.type");
        ProtoBuf.Annotation.Argument.Value value = argument.getValue();
        kotlin.jvm.internal.f0.o(value, "proto.value");
        return new Pair<>(b4, g(type, value, cVar));
    }

    private final kotlin.reflect.jvm.internal.impl.descriptors.d e(kotlin.reflect.jvm.internal.impl.name.b bVar) {
        return kotlin.reflect.jvm.internal.impl.descriptors.v.c(this.f57983a, bVar, this.f57984b);
    }

    private final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> g(e0 e0Var, ProtoBuf.Annotation.Argument.Value value, kotlin.reflect.jvm.internal.impl.metadata.deserialization.c cVar) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> f4 = f(e0Var, value, cVar);
        if (!b(f4, e0Var, value)) {
            f4 = null;
        }
        if (f4 == null) {
            k.a aVar = kotlin.reflect.jvm.internal.impl.resolve.constants.k.f57836b;
            return aVar.a("Unexpected argument value: actual type " + value.getType() + " != expected type " + e0Var);
        }
        return f4;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.annotations.c a(@NotNull ProtoBuf.Annotation proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver) {
        Map z3;
        Object T4;
        int Z;
        int j4;
        int n4;
        kotlin.jvm.internal.f0.p(proto, "proto");
        kotlin.jvm.internal.f0.p(nameResolver, "nameResolver");
        kotlin.reflect.jvm.internal.impl.descriptors.d e4 = e(v.a(nameResolver, proto.getId()));
        z3 = z0.z();
        if (proto.getArgumentCount() != 0 && !kotlin.reflect.jvm.internal.impl.types.w.r(e4) && kotlin.reflect.jvm.internal.impl.resolve.d.t(e4)) {
            Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g4 = e4.g();
            kotlin.jvm.internal.f0.o(g4, "annotationClass.constructors");
            T4 = kotlin.collections.f0.T4(g4);
            kotlin.reflect.jvm.internal.impl.descriptors.c cVar = (kotlin.reflect.jvm.internal.impl.descriptors.c) T4;
            if (cVar != null) {
                List<d1> h4 = cVar.h();
                kotlin.jvm.internal.f0.o(h4, "constructor.valueParameters");
                Z = kotlin.collections.y.Z(h4, 10);
                j4 = y0.j(Z);
                n4 = kotlin.ranges.q.n(j4, 16);
                LinkedHashMap linkedHashMap = new LinkedHashMap(n4);
                for (Object obj : h4) {
                    linkedHashMap.put(((d1) obj).getName(), obj);
                }
                List<ProtoBuf.Annotation.Argument> argumentList = proto.getArgumentList();
                kotlin.jvm.internal.f0.o(argumentList, "proto.argumentList");
                ArrayList arrayList = new ArrayList();
                for (ProtoBuf.Annotation.Argument it : argumentList) {
                    kotlin.jvm.internal.f0.o(it, "it");
                    Pair<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>> d4 = d(it, linkedHashMap, nameResolver);
                    if (d4 != null) {
                        arrayList.add(d4);
                    }
                }
                z3 = z0.B0(arrayList);
            }
        }
        return new kotlin.reflect.jvm.internal.impl.descriptors.annotations.d(e4.q(), z3, v0.f56634a);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> f(@NotNull e0 expectedType, @NotNull ProtoBuf.Annotation.Argument.Value value, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver) {
        kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> eVar;
        int Z;
        kotlin.jvm.internal.f0.p(expectedType, "expectedType");
        kotlin.jvm.internal.f0.p(value, "value");
        kotlin.jvm.internal.f0.p(nameResolver, "nameResolver");
        Boolean d4 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.b.O.d(value.getFlags());
        kotlin.jvm.internal.f0.o(d4, "IS_UNSIGNED.get(value.flags)");
        boolean booleanValue = d4.booleanValue();
        ProtoBuf.Annotation.Argument.Value.Type type = value.getType();
        switch (type == null ? -1 : a.f57985a[type.ordinal()]) {
            case 1:
                byte intValue = (byte) value.getIntValue();
                return booleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.w(intValue) : new kotlin.reflect.jvm.internal.impl.resolve.constants.d(intValue);
            case 2:
                eVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.e((char) value.getIntValue());
                break;
            case 3:
                short intValue2 = (short) value.getIntValue();
                return booleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.z(intValue2) : new kotlin.reflect.jvm.internal.impl.resolve.constants.u(intValue2);
            case 4:
                int intValue3 = (int) value.getIntValue();
                if (booleanValue) {
                    eVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.x(intValue3);
                    break;
                } else {
                    eVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.m(intValue3);
                    break;
                }
            case 5:
                long intValue4 = value.getIntValue();
                return booleanValue ? new kotlin.reflect.jvm.internal.impl.resolve.constants.y(intValue4) : new kotlin.reflect.jvm.internal.impl.resolve.constants.r(intValue4);
            case 6:
                eVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.l(value.getFloatValue());
                break;
            case 7:
                eVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.i(value.getDoubleValue());
                break;
            case 8:
                eVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.c(value.getIntValue() != 0);
                break;
            case 9:
                eVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.v(nameResolver.getString(value.getStringValue()));
                break;
            case 10:
                eVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.q(v.a(nameResolver, value.getClassId()), value.getArrayDimensionCount());
                break;
            case 11:
                eVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.j(v.a(nameResolver, value.getClassId()), v.b(nameResolver, value.getEnumValueId()));
                break;
            case 12:
                ProtoBuf.Annotation annotation = value.getAnnotation();
                kotlin.jvm.internal.f0.o(annotation, "value.annotation");
                eVar = new kotlin.reflect.jvm.internal.impl.resolve.constants.a(a(annotation, nameResolver));
                break;
            case 13:
                List<ProtoBuf.Annotation.Argument.Value> arrayElementList = value.getArrayElementList();
                kotlin.jvm.internal.f0.o(arrayElementList, "value.arrayElementList");
                Z = kotlin.collections.y.Z(arrayElementList, 10);
                ArrayList arrayList = new ArrayList(Z);
                for (ProtoBuf.Annotation.Argument.Value it : arrayElementList) {
                    m0 i4 = c().i();
                    kotlin.jvm.internal.f0.o(i4, "builtIns.anyType");
                    kotlin.jvm.internal.f0.o(it, "it");
                    arrayList.add(f(i4, it, nameResolver));
                }
                return new l(arrayList, expectedType);
            default:
                throw new IllegalStateException(("Unsupported annotation argument type: " + value.getType() + " (expected " + expectedType + ')').toString());
        }
        return eVar;
    }
}
