package kotlin.jvm.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.SinceKotlin;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.y0;
import kotlin.collections.z0;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ClassReference.kt */
@Metadata(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b!\u0018\u0000 X2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0010B\u0013\u0012\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u000f\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0017J\u0013\u0010\n\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001e\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u000f8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u001e\u0010\u001e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001b0\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR \u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u001f0\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u001dR\u001e\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\u001dR\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020%0$8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010+\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*R \u00100\u001a\b\u0012\u0004\u0012\u00020,0$8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b.\u0010/\u001a\u0004\b-\u0010'R \u00104\u001a\b\u0012\u0004\u0012\u0002010$8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b3\u0010/\u001a\u0004\b2\u0010'R(\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010$8VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b6\u0010/\u001a\u0004\b5\u0010'R\u001c\u0010<\u001a\u0004\u0018\u0001088VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b;\u0010/\u001a\u0004\b9\u0010:R\u001a\u0010=\u001a\u00020\u00078VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\b?\u0010/\u001a\u0004\b=\u0010>R\u001a\u0010@\u001a\u00020\u00078VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bA\u0010/\u001a\u0004\b@\u0010>R\u001a\u0010B\u001a\u00020\u00078VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bC\u0010/\u001a\u0004\bB\u0010>R\u001a\u0010F\u001a\u00020\u00078VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bE\u0010/\u001a\u0004\bD\u0010>R\u001a\u0010I\u001a\u00020\u00078VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bH\u0010/\u001a\u0004\bG\u0010>R\u001a\u0010L\u001a\u00020\u00078VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bK\u0010/\u001a\u0004\bJ\u0010>R\u001a\u0010O\u001a\u00020\u00078VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bN\u0010/\u001a\u0004\bM\u0010>R\u001a\u0010R\u001a\u00020\u00078VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bQ\u0010/\u001a\u0004\bP\u0010>R\u001a\u0010U\u001a\u00020\u00078VX\u0097\u0004\u00a2\u0006\f\u0012\u0004\bT\u0010/\u001a\u0004\bS\u0010>\u00a8\u0006Y"}, d2 = {"Lkotlin/jvm/internal/s;", "Lkotlin/reflect/d;", "", "Lkotlin/jvm/internal/r;", "", "s", "value", "", "C", "other", "equals", "", "hashCode", "", "toString", "Ljava/lang/Class;", "a", "Ljava/lang/Class;", "d", "()Ljava/lang/Class;", "jClass", "E", "()Ljava/lang/String;", "simpleName", "D", "qualifiedName", "", "Lkotlin/reflect/c;", CampaignEx.JSON_KEY_AD_Q, "()Ljava/util/Collection;", "members", "Lkotlin/reflect/i;", "g", "constructors", "z", "nestedClasses", "", "", "getAnnotations", "()Ljava/util/List;", "annotations", "A", "()Ljava/lang/Object;", "objectInstance", "Lkotlin/reflect/s;", "getTypeParameters", "getTypeParameters$annotations", "()V", "typeParameters", "Lkotlin/reflect/r;", "j", "getSupertypes$annotations", "supertypes", "m", "getSealedSubclasses$annotations", "sealedSubclasses", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "visibility", "isFinal", "()Z", "isFinal$annotations", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "p", "isSealed$annotations", "isSealed", "y", "isData$annotations", "isData", "n", "isInner$annotations", "isInner", "B", "isCompanion$annotations", "isCompanion", "t", "isFun$annotations", "isFun", "v", "isValue$annotations", "isValue", "<init>", "(Ljava/lang/Class;)V", "b", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s implements kotlin.reflect.d<Object>, r {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final a f55673b = new a(null);
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Map<Class<? extends kotlin.k<?>>, Integer> f55674c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f55675d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<String, String> f55676e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, String> f55677f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final Map<String, String> f55678g;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f55679a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ClassReference.kt */
    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002R,\u0010\r\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u000b0\u0002\u0012\u0004\u0012\u00020\f0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR0\u0010\u0011\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R0\u0010\u0014\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u000fj\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R \u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lkotlin/jvm/internal/s$a;", "", "Ljava/lang/Class;", "jClass", "", "b", "a", "value", "", "c", "", "Lkotlin/k;", "", "FUNCTION_CLASSES", "Ljava/util/Map;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "classFqNames", "Ljava/util/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @Nullable
        public final String a(@NotNull Class<?> jClass) {
            String str;
            f0.p(jClass, "jClass");
            String str2 = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (jClass.isArray()) {
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive() && (str = (String) s.f55677f.get(componentType.getName())) != null) {
                    str2 = f0.C(str, "Array");
                }
                return str2 == null ? "kotlin.Array" : str2;
            }
            String str3 = (String) s.f55677f.get(jClass.getName());
            return str3 == null ? jClass.getCanonicalName() : str3;
        }

        @Nullable
        public final String b(@NotNull Class<?> jClass) {
            String str;
            String p5;
            String p52;
            String o5;
            f0.p(jClass, "jClass");
            String str2 = null;
            if (!jClass.isAnonymousClass()) {
                if (jClass.isLocalClass()) {
                    String name = jClass.getSimpleName();
                    Method enclosingMethod = jClass.getEnclosingMethod();
                    if (enclosingMethod == null) {
                        Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
                        if (enclosingConstructor == null) {
                            f0.o(name, "name");
                            o5 = kotlin.text.x.o5(name, '$', null, 2, null);
                            return o5;
                        }
                        f0.o(name, "name");
                        p52 = kotlin.text.x.p5(name, f0.C(enclosingConstructor.getName(), "$"), null, 2, null);
                        return p52;
                    }
                    f0.o(name, "name");
                    p5 = kotlin.text.x.p5(name, f0.C(enclosingMethod.getName(), "$"), null, 2, null);
                    return p5;
                } else if (jClass.isArray()) {
                    Class<?> componentType = jClass.getComponentType();
                    if (componentType.isPrimitive() && (str = (String) s.f55678g.get(componentType.getName())) != null) {
                        str2 = f0.C(str, "Array");
                    }
                    if (str2 == null) {
                        return "Array";
                    }
                } else {
                    String str3 = (String) s.f55678g.get(jClass.getName());
                    return str3 == null ? jClass.getSimpleName() : str3;
                }
            }
            return str2;
        }

        public final boolean c(@Nullable Object obj, @NotNull Class<?> jClass) {
            f0.p(jClass, "jClass");
            Integer num = (Integer) s.f55674c.get(jClass);
            if (num == null) {
                if (jClass.isPrimitive()) {
                    jClass = c2.a.e(c2.a.g(jClass));
                }
                return jClass.isInstance(obj);
            }
            return t0.B(obj, num.intValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        List M;
        int Z;
        Map<Class<? extends kotlin.k<?>>, Integer> B0;
        int j4;
        String s5;
        String s52;
        int i4 = 0;
        M = CollectionsKt__CollectionsKt.M(d2.a.class, d2.l.class, d2.p.class, d2.q.class, d2.r.class, d2.s.class, d2.t.class, d2.u.class, d2.v.class, d2.w.class, d2.b.class, d2.c.class, d2.d.class, d2.e.class, d2.f.class, d2.g.class, d2.h.class, d2.i.class, d2.j.class, d2.k.class, d2.m.class, d2.n.class, d2.o.class);
        Z = kotlin.collections.y.Z(M, 10);
        ArrayList arrayList = new ArrayList(Z);
        for (Object obj : M) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt__CollectionsKt.X();
            }
            arrayList.add(kotlin.l0.a((Class) obj, Integer.valueOf(i4)));
            i4 = i5;
        }
        B0 = z0.B0(arrayList);
        f55674c = B0;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("boolean", "kotlin.Boolean");
        hashMap.put("char", "kotlin.Char");
        hashMap.put("byte", "kotlin.Byte");
        hashMap.put("short", "kotlin.Short");
        hashMap.put("int", "kotlin.Int");
        hashMap.put("float", "kotlin.Float");
        hashMap.put("long", "kotlin.Long");
        hashMap.put("double", "kotlin.Double");
        f55675d = hashMap;
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("java.lang.Boolean", "kotlin.Boolean");
        hashMap2.put("java.lang.Character", "kotlin.Char");
        hashMap2.put("java.lang.Byte", "kotlin.Byte");
        hashMap2.put("java.lang.Short", "kotlin.Short");
        hashMap2.put("java.lang.Integer", "kotlin.Int");
        hashMap2.put("java.lang.Float", "kotlin.Float");
        hashMap2.put("java.lang.Long", "kotlin.Long");
        hashMap2.put("java.lang.Double", "kotlin.Double");
        f55676e = hashMap2;
        HashMap<String, String> hashMap3 = new HashMap<>();
        hashMap3.put("java.lang.Object", "kotlin.Any");
        hashMap3.put("java.lang.String", "kotlin.String");
        hashMap3.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap3.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap3.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap3.put("java.lang.Number", "kotlin.Number");
        hashMap3.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap3.put("java.lang.Enum", "kotlin.Enum");
        hashMap3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap3.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap3.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap3.put("java.util.List", "kotlin.collections.List");
        hashMap3.put("java.util.Set", "kotlin.collections.Set");
        hashMap3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap3.put("java.util.Map", "kotlin.collections.Map");
        hashMap3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap3.putAll(hashMap);
        hashMap3.putAll(hashMap2);
        Collection<String> values = hashMap.values();
        f0.o(values, "primitiveFqNames.values");
        for (String kotlinName : values) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            f0.o(kotlinName, "kotlinName");
            s52 = kotlin.text.x.s5(kotlinName, '.', null, 2, null);
            sb.append(s52);
            sb.append("CompanionObject");
            Pair a4 = kotlin.l0.a(sb.toString(), f0.C(kotlinName, ".Companion"));
            hashMap3.put(a4.getFirst(), a4.getSecond());
        }
        for (Map.Entry<Class<? extends kotlin.k<?>>, Integer> entry : f55674c.entrySet()) {
            hashMap3.put(entry.getKey().getName(), f0.C("kotlin.Function", Integer.valueOf(entry.getValue().intValue())));
        }
        f55677f = hashMap3;
        j4 = y0.j(hashMap3.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(j4);
        for (Map.Entry entry2 : hashMap3.entrySet()) {
            Object key = entry2.getKey();
            s5 = kotlin.text.x.s5((String) entry2.getValue(), '.', null, 2, null);
            linkedHashMap.put(key, s5);
        }
        f55678g = linkedHashMap;
    }

    public s(@NotNull Class<?> jClass) {
        f0.p(jClass, "jClass");
        this.f55679a = jClass;
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void F() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void G() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void H() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void I() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void J() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void K() {
    }

    @SinceKotlin(version = "1.4")
    public static /* synthetic */ void L() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void M() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void N() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void O() {
    }

    @SinceKotlin(version = "1.5")
    public static /* synthetic */ void P() {
    }

    private final Void s() {
        throw new KotlinReflectionNotSupportedError();
    }

    @SinceKotlin(version = "1.3")
    public static /* synthetic */ void u() {
    }

    @SinceKotlin(version = "1.1")
    public static /* synthetic */ void x() {
    }

    @Override // kotlin.reflect.d
    @Nullable
    public Object A() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean B() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @SinceKotlin(version = "1.1")
    public boolean C(@Nullable Object obj) {
        return f55673b.c(obj, d());
    }

    @Override // kotlin.reflect.d
    @Nullable
    public String D() {
        return f55673b.a(d());
    }

    @Override // kotlin.reflect.d
    @Nullable
    public String E() {
        return f55673b.b(d());
    }

    @Override // kotlin.jvm.internal.r
    @NotNull
    public Class<?> d() {
        return this.f55679a;
    }

    @Override // kotlin.reflect.d
    public boolean equals(@Nullable Object obj) {
        return (obj instanceof s) && f0.g(c2.a.e(this), c2.a.e((kotlin.reflect.d) obj));
    }

    @Override // kotlin.reflect.d
    @NotNull
    public Collection<kotlin.reflect.i<Object>> g() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.b
    @NotNull
    public List<Annotation> getAnnotations() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.s> getTypeParameters() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @Nullable
    public KVisibility getVisibility() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public int hashCode() {
        return c2.a.e(this).hashCode();
    }

    @Override // kotlin.reflect.d
    public boolean isAbstract() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean isFinal() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean isOpen() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.r> j() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public List<kotlin.reflect.d<? extends Object>> m() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean n() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean p() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d, kotlin.reflect.h
    @NotNull
    public Collection<kotlin.reflect.c<?>> q() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean t() {
        s();
        throw new KotlinNothingValueException();
    }

    @NotNull
    public String toString() {
        return f0.C(d().toString(), " (Kotlin reflection is not available)");
    }

    @Override // kotlin.reflect.d
    public boolean v() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    public boolean y() {
        s();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.d
    @NotNull
    public Collection<kotlin.reflect.d<?>> z() {
        s();
        throw new KotlinNothingValueException();
    }
}
