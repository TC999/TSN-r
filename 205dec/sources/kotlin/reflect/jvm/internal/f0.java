package kotlin.reflect.jvm.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.z0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.PropertyReference;
import kotlin.jvm.internal.RepeatableContainer;
import kotlin.l0;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.l;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.constants.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: util.kt */
@Metadata(bv = {}, d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u0000H\u0000\u001a(\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002\u001a.\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007H\u0002\u001a\u0014\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0000\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u0010*\u00020\u000fH\u0000\u001a\u0012\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\u00020\u0012H\u0000\u001a\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013*\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001a\u000e\u0010\u0018\u001a\u0004\u0018\u00010\u0014*\u00020\u0017H\u0002\u001a\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001a*\u0006\u0012\u0002\b\u00030\u00192\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a*\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u001e*\u0004\u0018\u00010\u001aH\u0000\u001a\u0014\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010 *\u0004\u0018\u00010\u001aH\u0000\u001a\u0014\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\"*\u0004\u0018\u00010\u001aH\u0000\u001a\u0012\u0010&\u001a\u0004\u0018\u00010\u001a2\u0006\u0010%\u001a\u00020$H\u0000\u001an\u00107\u001a\u00028\u0001\"\b\b\u0000\u0010(*\u00020'\"\b\b\u0001\u0010**\u00020)2\n\u0010+\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010,\u001a\u00028\u00002\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u0002012\u001d\u00106\u001a\u0019\u0012\u0004\u0012\u000204\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000103\u00a2\u0006\u0002\b5H\u0000\u00a2\u0006\u0004\b7\u00108\u001a'\u0010<\u001a\u00028\u0000\"\u0004\b\u0000\u001092\f\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000:H\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b<\u0010=\"\u001a\u0010B\u001a\u00020>8\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u001d\u0010?\u001a\u0004\b@\u0010A\"\u0018\u0010G\u001a\u00020D*\u00020C8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bE\u0010F\"\u001a\u0010K\u001a\u0004\u0018\u00010H*\u00020)8@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\bI\u0010J\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006L"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/d;", "Ljava/lang/Class;", "p", "Ljava/lang/ClassLoader;", "classLoader", "Lkotlin/reflect/jvm/internal/impl/name/b;", "kotlinClassId", "", "arrayDimensions", "m", "", "packageName", "className", "l", "f", "Lkotlin/reflect/jvm/internal/impl/descriptors/s;", "Lkotlin/reflect/KVisibility;", CampaignEx.JSON_KEY_AD_Q, "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/a;", "", "", "e", "s", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/c;", "o", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/g;", "", "r", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/b;", "a", "Lkotlin/reflect/jvm/internal/j;", "c", "Lkotlin/reflect/jvm/internal/s;", "d", "Lkotlin/reflect/jvm/internal/f;", "b", "Ljava/lang/reflect/Type;", "type", "g", "Lkotlin/reflect/jvm/internal/impl/protobuf/n;", "M", "Lkotlin/reflect/jvm/internal/impl/descriptors/a;", "D", "moduleAnchor", "proto", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/c;", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/g;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/a;", "metadataVersion", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/u;", "Lkotlin/ExtensionFunctionType;", "createDescriptor", "deserializeToDescriptor", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Ld2/p;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "R", "Lkotlin/Function0;", "block", "reflectionCall", "(Ld2/a;)Ljava/lang/Object;", "Lkotlin/reflect/jvm/internal/impl/name/c;", "Lkotlin/reflect/jvm/internal/impl/name/c;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "JVM_STATIC", "Lkotlin/reflect/r;", "", "k", "(Lkotlin/reflect/r;)Z", "isInlineClassType", "Lkotlin/reflect/jvm/internal/impl/descriptors/s0;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "instanceReceiverParameter", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f55954a = new kotlin.reflect.jvm.internal.impl.name.c("kotlin.jvm.JvmStatic");

    /* compiled from: util.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f55955a;

        static {
            int[] iArr = new int[PrimitiveType.values().length];
            iArr[PrimitiveType.BOOLEAN.ordinal()] = 1;
            iArr[PrimitiveType.CHAR.ordinal()] = 2;
            iArr[PrimitiveType.BYTE.ordinal()] = 3;
            iArr[PrimitiveType.SHORT.ordinal()] = 4;
            iArr[PrimitiveType.INT.ordinal()] = 5;
            iArr[PrimitiveType.FLOAT.ordinal()] = 6;
            iArr[PrimitiveType.LONG.ordinal()] = 7;
            iArr[PrimitiveType.DOUBLE.ordinal()] = 8;
            f55955a = iArr;
        }
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=boolean[], code=short[], for r7v15, types: [boolean[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=byte[], code=short[], for r7v19, types: [byte[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=char[], code=short[], for r7v17, types: [char[]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v13, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v23, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v25, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v27, types: [long[]] */
    /* JADX WARN: Type inference failed for: r7v30, types: [double[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.Object a(kotlin.reflect.jvm.internal.impl.resolve.constants.b r6, java.lang.ClassLoader r7) {
        /*
            Method dump skipped, instructions count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.f0.a(kotlin.reflect.jvm.internal.impl.resolve.constants.b, java.lang.ClassLoader):java.lang.Object");
    }

    @Nullable
    public static final f<?> b(@Nullable Object obj) {
        f<?> fVar = obj instanceof f ? (f) obj : null;
        if (fVar == null) {
            j c4 = c(obj);
            return c4 == null ? d(obj) : c4;
        }
        return fVar;
    }

    @Nullable
    public static final j c(@Nullable Object obj) {
        j jVar = obj instanceof j ? (j) obj : null;
        if (jVar == null) {
            FunctionReference functionReference = obj instanceof FunctionReference ? (FunctionReference) obj : null;
            kotlin.reflect.c compute = functionReference == null ? null : functionReference.compute();
            if (compute instanceof j) {
                return (j) compute;
            }
            return null;
        }
        return jVar;
    }

    @Nullable
    public static final s<?> d(@Nullable Object obj) {
        s<?> sVar = obj instanceof s ? (s) obj : null;
        if (sVar == null) {
            PropertyReference propertyReference = obj instanceof PropertyReference ? (PropertyReference) obj : null;
            kotlin.reflect.c compute = propertyReference == null ? null : propertyReference.compute();
            if (compute instanceof s) {
                return (s) compute;
            }
            return null;
        }
        return sVar;
    }

    @NotNull
    public static final List<Annotation> e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.annotations.a aVar) {
        kotlin.jvm.internal.f0.p(aVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.annotations.f annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar : annotations) {
            v0 source = cVar.getSource();
            Annotation annotation = null;
            if (source instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.b) {
                annotation = ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.b) source).d();
            } else if (source instanceof l.a) {
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.p c4 = ((l.a) source).c();
                kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e eVar = c4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e ? (kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.e) c4 : null;
                if (eVar != null) {
                    annotation = eVar.P();
                }
            } else {
                annotation = o(cVar);
            }
            if (annotation != null) {
                arrayList.add(annotation);
            }
        }
        return s(arrayList);
    }

    @NotNull
    public static final Class<?> f(@NotNull Class<?> cls) {
        kotlin.jvm.internal.f0.p(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    @Nullable
    public static final Object g(@NotNull Type type) {
        kotlin.jvm.internal.f0.p(type, "type");
        if ((type instanceof Class) && ((Class) type).isPrimitive()) {
            if (kotlin.jvm.internal.f0.g(type, Boolean.TYPE)) {
                return Boolean.FALSE;
            }
            if (kotlin.jvm.internal.f0.g(type, Character.TYPE)) {
                return (char) 0;
            }
            if (kotlin.jvm.internal.f0.g(type, Byte.TYPE)) {
                return (byte) 0;
            }
            if (kotlin.jvm.internal.f0.g(type, Short.TYPE)) {
                return (short) 0;
            }
            if (kotlin.jvm.internal.f0.g(type, Integer.TYPE)) {
                return 0;
            }
            if (kotlin.jvm.internal.f0.g(type, Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (kotlin.jvm.internal.f0.g(type, Long.TYPE)) {
                return 0L;
            }
            if (kotlin.jvm.internal.f0.g(type, Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            if (kotlin.jvm.internal.f0.g(type, Void.TYPE)) {
                throw new IllegalStateException("Parameter with void type is illegal");
            }
            throw new UnsupportedOperationException(kotlin.jvm.internal.f0.C("Unknown primitive: ", type));
        }
        return null;
    }

    @NotNull
    public static final <M extends kotlin.reflect.jvm.internal.impl.protobuf.n, D extends kotlin.reflect.jvm.internal.impl.descriptors.a> D h(@NotNull Class<?> moduleAnchor, @NotNull M proto, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.c nameResolver, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.g typeTable, @NotNull kotlin.reflect.jvm.internal.impl.metadata.deserialization.a metadataVersion, @NotNull d2.p<? super kotlin.reflect.jvm.internal.impl.serialization.deserialization.u, ? super M, ? extends D> createDescriptor) {
        List<ProtoBuf.TypeParameter> typeParameterList;
        kotlin.jvm.internal.f0.p(moduleAnchor, "moduleAnchor");
        kotlin.jvm.internal.f0.p(proto, "proto");
        kotlin.jvm.internal.f0.p(nameResolver, "nameResolver");
        kotlin.jvm.internal.f0.p(typeTable, "typeTable");
        kotlin.jvm.internal.f0.p(metadataVersion, "metadataVersion");
        kotlin.jvm.internal.f0.p(createDescriptor, "createDescriptor");
        kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k b4 = x.b(moduleAnchor);
        if (proto instanceof ProtoBuf.Function) {
            typeParameterList = ((ProtoBuf.Function) proto).getTypeParameterList();
        } else if (!(proto instanceof ProtoBuf.Property)) {
            throw new IllegalStateException(kotlin.jvm.internal.f0.C("Unsupported message: ", proto).toString());
        } else {
            typeParameterList = ((ProtoBuf.Property) proto).getTypeParameterList();
        }
        List<ProtoBuf.TypeParameter> typeParameters = typeParameterList;
        kotlin.reflect.jvm.internal.impl.serialization.deserialization.i a4 = b4.a();
        kotlin.reflect.jvm.internal.impl.descriptors.d0 b5 = b4.b();
        kotlin.reflect.jvm.internal.impl.metadata.deserialization.h b6 = kotlin.reflect.jvm.internal.impl.metadata.deserialization.h.f57484b.b();
        kotlin.jvm.internal.f0.o(typeParameters, "typeParameters");
        return createDescriptor.invoke(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.u(new kotlin.reflect.jvm.internal.impl.serialization.deserialization.k(a4, nameResolver, b5, typeTable, b6, metadataVersion, null, null, typeParameters)), proto);
    }

    @Nullable
    public static final s0 i(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        kotlin.jvm.internal.f0.p(aVar, "<this>");
        if (aVar.M() != null) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.d) aVar.b()).E0();
        }
        return null;
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c j() {
        return f55954a;
    }

    public static final boolean k(@NotNull kotlin.reflect.r rVar) {
        kotlin.jvm.internal.f0.p(rVar, "<this>");
        u uVar = rVar instanceof u ? (u) rVar : null;
        return uVar != null && kotlin.reflect.jvm.internal.impl.resolve.e.c(uVar.getType());
    }

    private static final Class<?> l(ClassLoader classLoader, String str, String str2, int i4) {
        String j22;
        String g22;
        if (kotlin.jvm.internal.f0.g(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        j22 = kotlin.text.w.j2(str2, '.', '$', false, 4, null);
        sb.append(j22);
        String sb2 = sb.toString();
        if (i4 > 0) {
            StringBuilder sb3 = new StringBuilder();
            g22 = kotlin.text.w.g2("[", i4);
            sb3.append(g22);
            sb3.append('L');
            sb3.append(sb2);
            sb3.append(';');
            sb2 = sb3.toString();
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.e.a(classLoader, sb2);
    }

    private static final Class<?> m(ClassLoader classLoader, kotlin.reflect.jvm.internal.impl.name.b bVar, int i4) {
        kotlin.reflect.jvm.internal.impl.builtins.jvm.c cVar = kotlin.reflect.jvm.internal.impl.builtins.jvm.c.f56159a;
        kotlin.reflect.jvm.internal.impl.name.d j4 = bVar.b().j();
        kotlin.jvm.internal.f0.o(j4, "kotlinClassId.asSingleFqName().toUnsafe()");
        kotlin.reflect.jvm.internal.impl.name.b o4 = cVar.o(j4);
        if (o4 != null) {
            bVar = o4;
        }
        String b4 = bVar.h().b();
        kotlin.jvm.internal.f0.o(b4, "javaClassId.packageFqName.asString()");
        String b5 = bVar.i().b();
        kotlin.jvm.internal.f0.o(b5, "javaClassId.relativeClassName.asString()");
        return l(classLoader, b4, b5, i4);
    }

    static /* synthetic */ Class n(ClassLoader classLoader, kotlin.reflect.jvm.internal.impl.name.b bVar, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return m(classLoader, bVar, i4);
    }

    private static final Annotation o(kotlin.reflect.jvm.internal.impl.descriptors.annotations.c cVar) {
        Map B0;
        kotlin.reflect.jvm.internal.impl.descriptors.d f4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.f(cVar);
        Class<?> p3 = f4 == null ? null : p(f4);
        if (!(p3 instanceof Class)) {
            p3 = null;
        }
        if (p3 == null) {
            return null;
        }
        Set<Map.Entry<kotlin.reflect.jvm.internal.impl.name.f, kotlin.reflect.jvm.internal.impl.resolve.constants.g<?>>> entrySet = cVar.a().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            kotlin.reflect.jvm.internal.impl.name.f fVar = (kotlin.reflect.jvm.internal.impl.name.f) entry.getKey();
            ClassLoader classLoader = p3.getClassLoader();
            kotlin.jvm.internal.f0.o(classLoader, "annotationClass.classLoader");
            Object r3 = r((kotlin.reflect.jvm.internal.impl.resolve.constants.g) entry.getValue(), classLoader);
            Pair a4 = r3 == null ? null : l0.a(fVar.b(), r3);
            if (a4 != null) {
                arrayList.add(a4);
            }
        }
        B0 = z0.B0(arrayList);
        return (Annotation) kotlin.reflect.jvm.internal.calls.a.g(p3, B0, null, 4, null);
    }

    @Nullable
    public static final Class<?> p(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        kotlin.jvm.internal.f0.p(dVar, "<this>");
        v0 source = dVar.getSource();
        kotlin.jvm.internal.f0.o(source, "source");
        if (source instanceof kotlin.reflect.jvm.internal.impl.load.kotlin.r) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.f) ((kotlin.reflect.jvm.internal.impl.load.kotlin.r) source).d()).a();
        }
        if (source instanceof l.a) {
            return ((kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.l) ((l.a) source).c()).r();
        }
        kotlin.reflect.jvm.internal.impl.name.b h4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.h(dVar);
        if (h4 == null) {
            return null;
        }
        return m(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.f(dVar.getClass()), h4, 0);
    }

    @Nullable
    public static final KVisibility q(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.s sVar) {
        kotlin.jvm.internal.f0.p(sVar, "<this>");
        if (kotlin.jvm.internal.f0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f56531e)) {
            return KVisibility.PUBLIC;
        }
        if (kotlin.jvm.internal.f0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f56529c)) {
            return KVisibility.PROTECTED;
        }
        if (kotlin.jvm.internal.f0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f56530d)) {
            return KVisibility.INTERNAL;
        }
        if (kotlin.jvm.internal.f0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f56527a) ? true : kotlin.jvm.internal.f0.g(sVar, kotlin.reflect.jvm.internal.impl.descriptors.r.f56528b)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    private static final Object r(kotlin.reflect.jvm.internal.impl.resolve.constants.g<?> gVar, ClassLoader classLoader) {
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.a) {
            return o(((kotlin.reflect.jvm.internal.impl.resolve.constants.a) gVar).a());
        }
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.b) {
            return a((kotlin.reflect.jvm.internal.impl.resolve.constants.b) gVar, classLoader);
        }
        if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.j) {
            Pair<? extends kotlin.reflect.jvm.internal.impl.name.b, ? extends kotlin.reflect.jvm.internal.impl.name.f> a4 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.j) gVar).a();
            kotlin.reflect.jvm.internal.impl.name.f component2 = a4.component2();
            Class n4 = n(classLoader, a4.component1(), 0, 4, null);
            if (n4 == null) {
                return null;
            }
            return e0.a(n4, component2.b());
        } else if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.q) {
            q.b a5 = ((kotlin.reflect.jvm.internal.impl.resolve.constants.q) gVar).a();
            if (a5 instanceof q.b.C1167b) {
                q.b.C1167b c1167b = (q.b.C1167b) a5;
                return m(classLoader, c1167b.b(), c1167b.a());
            } else if (a5 instanceof q.b.a) {
                kotlin.reflect.jvm.internal.impl.descriptors.f b4 = ((q.b.a) a5).getType().H0().b();
                kotlin.reflect.jvm.internal.impl.descriptors.d dVar = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? (kotlin.reflect.jvm.internal.impl.descriptors.d) b4 : null;
                if (dVar == null) {
                    return null;
                }
                return p(dVar);
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            if (gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.k ? true : gVar instanceof kotlin.reflect.jvm.internal.impl.resolve.constants.s) {
                return null;
            }
            return gVar.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<Annotation> s(List<? extends Annotation> list) {
        boolean z3;
        List l4;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (Annotation annotation : list) {
                if (kotlin.jvm.internal.f0.g(c2.a.c(c2.a.a(annotation)).getSimpleName(), "Container")) {
                    z3 = true;
                    break;
                }
            }
        }
        z3 = false;
        if (z3) {
            ArrayList arrayList = new ArrayList();
            for (Annotation annotation2 : list) {
                Class c4 = c2.a.c(c2.a.a(annotation2));
                if (kotlin.jvm.internal.f0.g(c4.getSimpleName(), "Container") && c4.getAnnotation(RepeatableContainer.class) != null) {
                    Object invoke = c4.getDeclaredMethod("value", new Class[0]).invoke(annotation2, new Object[0]);
                    if (invoke == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                    }
                    l4 = kotlin.collections.o.t((Annotation[]) invoke);
                } else {
                    l4 = kotlin.collections.x.l(annotation2);
                }
                kotlin.collections.c0.o0(arrayList, l4);
            }
            return arrayList;
        }
        return list;
    }
}
