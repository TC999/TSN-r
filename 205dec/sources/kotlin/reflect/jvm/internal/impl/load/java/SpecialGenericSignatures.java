package kotlin.reflect.jvm.internal.impl.load.java;

import com.acse.ottn.f3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.j1;
import kotlin.collections.k1;
import kotlin.collections.y0;
import kotlin.collections.z0;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SpecialGenericSignatures.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class SpecialGenericSignatures {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f56640a = new a(null);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final List<a.C1132a> f56641b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final List<String> f56642c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final List<String> f56643d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final Map<a.C1132a, TypeSafeBarrierDescription> f56644e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, TypeSafeBarrierDescription> f56645f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final Set<kotlin.reflect.jvm.internal.impl.name.f> f56646g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    private static final Set<String> f56647h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private static final a.C1132a f56648i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final Map<a.C1132a, kotlin.reflect.jvm.internal.impl.name.f> f56649j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private static final Map<String, kotlin.reflect.jvm.internal.impl.name.f> f56650k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final List<kotlin.reflect.jvm.internal.impl.name.f> f56651l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    private static final Map<kotlin.reflect.jvm.internal.impl.name.f, List<kotlin.reflect.jvm.internal.impl.name.f>> f56652m;

    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        @Nullable
        private final String valueParametersSignature;

        SpecialSignatureInfo(String str, boolean z3) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class TypeSafeBarrierDescription {
        @Nullable
        private final Object defaultValue;
        public static final TypeSafeBarrierDescription NULL = new TypeSafeBarrierDescription("NULL", 0, null);
        public static final TypeSafeBarrierDescription INDEX = new TypeSafeBarrierDescription("INDEX", 1, -1);
        public static final TypeSafeBarrierDescription FALSE = new TypeSafeBarrierDescription("FALSE", 2, Boolean.FALSE);
        public static final TypeSafeBarrierDescription MAP_GET_OR_DEFAULT = new a("MAP_GET_OR_DEFAULT", 3);
        private static final /* synthetic */ TypeSafeBarrierDescription[] $VALUES = $values();

        /* compiled from: SpecialGenericSignatures.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends TypeSafeBarrierDescription {
            a(String str, int i4) {
                super(str, i4, null, null);
            }
        }

        private static final /* synthetic */ TypeSafeBarrierDescription[] $values() {
            return new TypeSafeBarrierDescription[]{NULL, INDEX, FALSE, MAP_GET_OR_DEFAULT};
        }

        private TypeSafeBarrierDescription(String str, int i4, Object obj) {
            this.defaultValue = obj;
        }

        public /* synthetic */ TypeSafeBarrierDescription(String str, int i4, Object obj, kotlin.jvm.internal.u uVar) {
            this(str, i4, obj);
        }

        public static TypeSafeBarrierDescription valueOf(String str) {
            return (TypeSafeBarrierDescription) Enum.valueOf(TypeSafeBarrierDescription.class, str);
        }

        public static TypeSafeBarrierDescription[] values() {
            return (TypeSafeBarrierDescription[]) $VALUES.clone();
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* compiled from: SpecialGenericSignatures.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1132a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final kotlin.reflect.jvm.internal.impl.name.f f56653a;
            @NotNull

            /* renamed from: b  reason: collision with root package name */
            private final String f56654b;

            public C1132a(@NotNull kotlin.reflect.jvm.internal.impl.name.f name, @NotNull String signature) {
                f0.p(name, "name");
                f0.p(signature, "signature");
                this.f56653a = name;
                this.f56654b = signature;
            }

            @NotNull
            public final kotlin.reflect.jvm.internal.impl.name.f a() {
                return this.f56653a;
            }

            @NotNull
            public final String b() {
                return this.f56654b;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof C1132a) {
                    C1132a c1132a = (C1132a) obj;
                    return f0.g(this.f56653a, c1132a.f56653a) && f0.g(this.f56654b, c1132a.f56654b);
                }
                return false;
            }

            public int hashCode() {
                return (this.f56653a.hashCode() * 31) + this.f56654b.hashCode();
            }

            @NotNull
            public String toString() {
                return "NameAndSignature(name=" + this.f56653a + ", signature=" + this.f56654b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C1132a m(String str, String str2, String str3, String str4) {
            kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(str2);
            f0.o(f4, "identifier(name)");
            kotlin.reflect.jvm.internal.impl.load.kotlin.w wVar = kotlin.reflect.jvm.internal.impl.load.kotlin.w.f57261a;
            return new C1132a(f4, wVar.k(str, str2 + '(' + str3 + ')' + str4));
        }

        @NotNull
        public final List<kotlin.reflect.jvm.internal.impl.name.f> b(@NotNull kotlin.reflect.jvm.internal.impl.name.f name) {
            List<kotlin.reflect.jvm.internal.impl.name.f> F;
            f0.p(name, "name");
            List<kotlin.reflect.jvm.internal.impl.name.f> list = f().get(name);
            if (list == null) {
                F = CollectionsKt__CollectionsKt.F();
                return F;
            }
            return list;
        }

        @NotNull
        public final List<String> c() {
            return SpecialGenericSignatures.f56642c;
        }

        @NotNull
        public final Set<kotlin.reflect.jvm.internal.impl.name.f> d() {
            return SpecialGenericSignatures.f56646g;
        }

        @NotNull
        public final Set<String> e() {
            return SpecialGenericSignatures.f56647h;
        }

        @NotNull
        public final Map<kotlin.reflect.jvm.internal.impl.name.f, List<kotlin.reflect.jvm.internal.impl.name.f>> f() {
            return SpecialGenericSignatures.f56652m;
        }

        @NotNull
        public final List<kotlin.reflect.jvm.internal.impl.name.f> g() {
            return SpecialGenericSignatures.f56651l;
        }

        @NotNull
        public final C1132a h() {
            return SpecialGenericSignatures.f56648i;
        }

        @NotNull
        public final Map<String, TypeSafeBarrierDescription> i() {
            return SpecialGenericSignatures.f56645f;
        }

        @NotNull
        public final Map<String, kotlin.reflect.jvm.internal.impl.name.f> j() {
            return SpecialGenericSignatures.f56650k;
        }

        public final boolean k(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
            f0.p(fVar, "<this>");
            return g().contains(fVar);
        }

        @NotNull
        public final SpecialSignatureInfo l(@NotNull String builtinSignature) {
            Object K;
            f0.p(builtinSignature, "builtinSignature");
            if (c().contains(builtinSignature)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            K = z0.K(i(), builtinSignature);
            if (((TypeSafeBarrierDescription) K) == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    static {
        Set<String> u3;
        int Z;
        int Z2;
        int Z3;
        Map<a.C1132a, TypeSafeBarrierDescription> W;
        int j4;
        Set<a.C1132a> C;
        int Z4;
        Set<kotlin.reflect.jvm.internal.impl.name.f> L5;
        int Z5;
        Set<String> L52;
        Map<a.C1132a, kotlin.reflect.jvm.internal.impl.name.f> W2;
        int j5;
        int Z6;
        int Z7;
        u3 = j1.u("containsAll", "removeAll", "retainAll");
        Z = kotlin.collections.y.Z(u3, 10);
        ArrayList<a.C1132a> arrayList = new ArrayList(Z);
        for (String str : u3) {
            a aVar = f56640a;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            f0.o(desc, "BOOLEAN.desc");
            arrayList.add(aVar.m("java/util/Collection", str, "Ljava/util/Collection;", desc));
        }
        f56641b = arrayList;
        Z2 = kotlin.collections.y.Z(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(Z2);
        for (a.C1132a c1132a : arrayList) {
            arrayList2.add(c1132a.b());
        }
        f56642c = arrayList2;
        List<a.C1132a> list = f56641b;
        Z3 = kotlin.collections.y.Z(list, 10);
        ArrayList arrayList3 = new ArrayList(Z3);
        for (a.C1132a c1132a2 : list) {
            arrayList3.add(c1132a2.a().b());
        }
        f56643d = arrayList3;
        kotlin.reflect.jvm.internal.impl.load.kotlin.w wVar = kotlin.reflect.jvm.internal.impl.load.kotlin.w.f57261a;
        a aVar2 = f56640a;
        String i4 = wVar.i("Collection");
        JvmPrimitiveType jvmPrimitiveType = JvmPrimitiveType.BOOLEAN;
        String desc2 = jvmPrimitiveType.getDesc();
        f0.o(desc2, "BOOLEAN.desc");
        a.C1132a m4 = aVar2.m(i4, "contains", "Ljava/lang/Object;", desc2);
        TypeSafeBarrierDescription typeSafeBarrierDescription = TypeSafeBarrierDescription.FALSE;
        String i5 = wVar.i("Collection");
        String desc3 = jvmPrimitiveType.getDesc();
        f0.o(desc3, "BOOLEAN.desc");
        String i6 = wVar.i("Map");
        String desc4 = jvmPrimitiveType.getDesc();
        f0.o(desc4, "BOOLEAN.desc");
        String i7 = wVar.i("Map");
        String desc5 = jvmPrimitiveType.getDesc();
        f0.o(desc5, "BOOLEAN.desc");
        String i8 = wVar.i("Map");
        String desc6 = jvmPrimitiveType.getDesc();
        f0.o(desc6, "BOOLEAN.desc");
        a.C1132a m5 = aVar2.m(wVar.i("Map"), f3.f5657f, "Ljava/lang/Object;", "Ljava/lang/Object;");
        TypeSafeBarrierDescription typeSafeBarrierDescription2 = TypeSafeBarrierDescription.NULL;
        String i9 = wVar.i("List");
        JvmPrimitiveType jvmPrimitiveType2 = JvmPrimitiveType.INT;
        String desc7 = jvmPrimitiveType2.getDesc();
        f0.o(desc7, "INT.desc");
        a.C1132a m6 = aVar2.m(i9, "indexOf", "Ljava/lang/Object;", desc7);
        TypeSafeBarrierDescription typeSafeBarrierDescription3 = TypeSafeBarrierDescription.INDEX;
        String i10 = wVar.i("List");
        String desc8 = jvmPrimitiveType2.getDesc();
        f0.o(desc8, "INT.desc");
        W = z0.W(l0.a(m4, typeSafeBarrierDescription), l0.a(aVar2.m(i5, "remove", "Ljava/lang/Object;", desc3), typeSafeBarrierDescription), l0.a(aVar2.m(i6, "containsKey", "Ljava/lang/Object;", desc4), typeSafeBarrierDescription), l0.a(aVar2.m(i7, "containsValue", "Ljava/lang/Object;", desc5), typeSafeBarrierDescription), l0.a(aVar2.m(i8, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), typeSafeBarrierDescription), l0.a(aVar2.m(wVar.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), l0.a(m5, typeSafeBarrierDescription2), l0.a(aVar2.m(wVar.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), typeSafeBarrierDescription2), l0.a(m6, typeSafeBarrierDescription3), l0.a(aVar2.m(i10, "lastIndexOf", "Ljava/lang/Object;", desc8), typeSafeBarrierDescription3));
        f56644e = W;
        j4 = y0.j(W.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(j4);
        Iterator<T> it = W.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(((a.C1132a) entry.getKey()).b(), entry.getValue());
        }
        f56645f = linkedHashMap;
        C = k1.C(f56644e.keySet(), f56641b);
        Z4 = kotlin.collections.y.Z(C, 10);
        ArrayList arrayList4 = new ArrayList(Z4);
        for (a.C1132a c1132a3 : C) {
            arrayList4.add(c1132a3.a());
        }
        L5 = kotlin.collections.f0.L5(arrayList4);
        f56646g = L5;
        Z5 = kotlin.collections.y.Z(C, 10);
        ArrayList arrayList5 = new ArrayList(Z5);
        for (a.C1132a c1132a4 : C) {
            arrayList5.add(c1132a4.b());
        }
        L52 = kotlin.collections.f0.L5(arrayList5);
        f56647h = L52;
        a aVar3 = f56640a;
        JvmPrimitiveType jvmPrimitiveType3 = JvmPrimitiveType.INT;
        String desc9 = jvmPrimitiveType3.getDesc();
        f0.o(desc9, "INT.desc");
        a.C1132a m7 = aVar3.m("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        f56648i = m7;
        kotlin.reflect.jvm.internal.impl.load.kotlin.w wVar2 = kotlin.reflect.jvm.internal.impl.load.kotlin.w.f57261a;
        String h4 = wVar2.h("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        f0.o(desc10, "BYTE.desc");
        String h5 = wVar2.h("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        f0.o(desc11, "SHORT.desc");
        String h6 = wVar2.h("Number");
        String desc12 = jvmPrimitiveType3.getDesc();
        f0.o(desc12, "INT.desc");
        String h7 = wVar2.h("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        f0.o(desc13, "LONG.desc");
        String h8 = wVar2.h("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        f0.o(desc14, "FLOAT.desc");
        String h9 = wVar2.h("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        f0.o(desc15, "DOUBLE.desc");
        String h10 = wVar2.h("CharSequence");
        String desc16 = jvmPrimitiveType3.getDesc();
        f0.o(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        f0.o(desc17, "CHAR.desc");
        W2 = z0.W(l0.a(aVar3.m(h4, "toByte", "", desc10), kotlin.reflect.jvm.internal.impl.name.f.f("byteValue")), l0.a(aVar3.m(h5, "toShort", "", desc11), kotlin.reflect.jvm.internal.impl.name.f.f("shortValue")), l0.a(aVar3.m(h6, "toInt", "", desc12), kotlin.reflect.jvm.internal.impl.name.f.f("intValue")), l0.a(aVar3.m(h7, "toLong", "", desc13), kotlin.reflect.jvm.internal.impl.name.f.f("longValue")), l0.a(aVar3.m(h8, "toFloat", "", desc14), kotlin.reflect.jvm.internal.impl.name.f.f("floatValue")), l0.a(aVar3.m(h9, "toDouble", "", desc15), kotlin.reflect.jvm.internal.impl.name.f.f("doubleValue")), l0.a(m7, kotlin.reflect.jvm.internal.impl.name.f.f("remove")), l0.a(aVar3.m(h10, f3.f5657f, desc16, desc17), kotlin.reflect.jvm.internal.impl.name.f.f("charAt")));
        f56649j = W2;
        j5 = y0.j(W2.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(j5);
        Iterator<T> it2 = W2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            linkedHashMap2.put(((a.C1132a) entry2.getKey()).b(), entry2.getValue());
        }
        f56650k = linkedHashMap2;
        Set<a.C1132a> keySet = f56649j.keySet();
        Z6 = kotlin.collections.y.Z(keySet, 10);
        ArrayList arrayList6 = new ArrayList(Z6);
        for (a.C1132a c1132a5 : keySet) {
            arrayList6.add(c1132a5.a());
        }
        f56651l = arrayList6;
        Set<Map.Entry<a.C1132a, kotlin.reflect.jvm.internal.impl.name.f>> entrySet = f56649j.entrySet();
        Z7 = kotlin.collections.y.Z(entrySet, 10);
        ArrayList<Pair> arrayList7 = new ArrayList(Z7);
        Iterator<T> it3 = entrySet.iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            arrayList7.add(new Pair(((a.C1132a) entry3.getKey()).a(), entry3.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        for (Pair pair : arrayList7) {
            kotlin.reflect.jvm.internal.impl.name.f fVar = (kotlin.reflect.jvm.internal.impl.name.f) pair.getSecond();
            Object obj = linkedHashMap3.get(fVar);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap3.put(fVar, obj);
            }
            ((List) obj).add((kotlin.reflect.jvm.internal.impl.name.f) pair.getFirst());
        }
        f56652m = linkedHashMap3;
    }
}
