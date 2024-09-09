package kotlin.reflect.jvm.internal.calls;

import d2.l;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.y;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import kotlin.p;
import kotlin.r;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import org.jetbrains.annotations.NotNull;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0000*\u0004\u0018\u00010\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002\u001a$\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0002\u001aK\u0010\u0012\u001a\u00028\u0000\"\b\b\u0000\u0010\u000b*\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00000\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016\u00b2\u0006\u0016\u0010\u0014\u001a\u00020\u0004\"\b\b\u0000\u0010\u000b*\u00020\u00008\nX\u008a\u0084\u0002\u00b2\u0006\u0016\u0010\u0015\u001a\u00020\u0006\"\b\b\u0000\u0010\u000b*\u00020\u00008\nX\u008a\u0084\u0002"}, d2 = {"", "Ljava/lang/Class;", "expectedType", "l", "", "index", "", "name", "expectedJvmType", "", "k", "T", "annotationClass", "", "values", "", "Ljava/lang/reflect/Method;", "methods", "f", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "hashCode", "toString", "kotlin-reflection"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* compiled from: AnnotationConstructorCaller.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "T", "", "a", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0})
    /* renamed from: kotlin.reflect.jvm.internal.calls.a$a */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1107a extends Lambda implements d2.a<Integer> {

        /* renamed from: a */
        final /* synthetic */ Map<String, Object> f55887a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C1107a(Map<String, ? extends Object> map) {
            super(0);
            this.f55887a = map;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final Integer invoke() {
            int hashCode;
            Iterator<T> it = this.f55887a.entrySet().iterator();
            int i4 = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    hashCode = Arrays.hashCode((boolean[]) value);
                } else if (value instanceof char[]) {
                    hashCode = Arrays.hashCode((char[]) value);
                } else if (value instanceof byte[]) {
                    hashCode = Arrays.hashCode((byte[]) value);
                } else if (value instanceof short[]) {
                    hashCode = Arrays.hashCode((short[]) value);
                } else if (value instanceof int[]) {
                    hashCode = Arrays.hashCode((int[]) value);
                } else if (value instanceof float[]) {
                    hashCode = Arrays.hashCode((float[]) value);
                } else if (value instanceof long[]) {
                    hashCode = Arrays.hashCode((long[]) value);
                } else if (value instanceof double[]) {
                    hashCode = Arrays.hashCode((double[]) value);
                } else {
                    hashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
                }
                i4 += hashCode ^ (str.hashCode() * 127);
            }
            return Integer.valueOf(i4);
        }
    }

    /* compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n\u00a2\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "T", "<anonymous parameter 0>", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements InvocationHandler {

        /* renamed from: a */
        final /* synthetic */ Class<T> f55888a;

        /* renamed from: b */
        final /* synthetic */ Map<String, Object> f55889b;

        /* renamed from: c */
        final /* synthetic */ p<String> f55890c;

        /* renamed from: d */
        final /* synthetic */ p<Integer> f55891d;

        /* renamed from: e */
        final /* synthetic */ List<Method> f55892e;

        b(Class<T> cls, Map<String, ? extends Object> map, p<String> pVar, p<Integer> pVar2, List<Method> list) {
            this.f55888a = cls;
            this.f55889b = map;
            this.f55890c = pVar;
            this.f55891d = pVar2;
            this.f55892e = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] args) {
            List ey;
            Object Cs;
            String name = method.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != -1776922004) {
                    if (hashCode != 147696667) {
                        if (hashCode == 1444986633 && name.equals("annotationType")) {
                            return this.f55888a;
                        }
                    } else if (name.equals("hashCode")) {
                        return Integer.valueOf(a.i(this.f55891d));
                    }
                } else if (name.equals("toString")) {
                    return a.j(this.f55890c);
                }
            }
            if (f0.g(name, "equals")) {
                if (args != null && args.length == 1) {
                    Class<T> cls = this.f55888a;
                    List<Method> list = this.f55892e;
                    Map<String, Object> map = this.f55889b;
                    f0.o(args, "args");
                    Cs = kotlin.collections.p.Cs(args);
                    return Boolean.valueOf(a.h(cls, list, map, Cs));
                }
            }
            if (this.f55889b.containsKey(name)) {
                return this.f55889b.get(name);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Method is not supported: ");
            sb.append(method);
            sb.append(" (args: ");
            if (args == null) {
                args = new Object[0];
            }
            ey = kotlin.collections.p.ey(args);
            sb.append(ey);
            sb.append(')');
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    /* compiled from: AnnotationConstructorCaller.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "T", "", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.a<String> {

        /* renamed from: a */
        final /* synthetic */ Class<T> f55893a;

        /* renamed from: b */
        final /* synthetic */ Map<String, Object> f55894b;

        /* compiled from: AnnotationConstructorCaller.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00000\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "T", "", "", "entry", "", "a", "(Ljava/util/Map$Entry;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: kotlin.reflect.jvm.internal.calls.a$c$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1108a extends Lambda implements l<Map.Entry<? extends String, ? extends Object>, CharSequence> {

            /* renamed from: a */
            public static final C1108a f55895a = new C1108a();

            C1108a() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final CharSequence invoke(@NotNull Map.Entry<String, ? extends Object> entry) {
                String obj;
                f0.p(entry, "entry");
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    obj = Arrays.toString((boolean[]) value);
                    f0.o(obj, "toString(this)");
                } else if (value instanceof char[]) {
                    obj = Arrays.toString((char[]) value);
                    f0.o(obj, "toString(this)");
                } else if (value instanceof byte[]) {
                    obj = Arrays.toString((byte[]) value);
                    f0.o(obj, "toString(this)");
                } else if (value instanceof short[]) {
                    obj = Arrays.toString((short[]) value);
                    f0.o(obj, "toString(this)");
                } else if (value instanceof int[]) {
                    obj = Arrays.toString((int[]) value);
                    f0.o(obj, "toString(this)");
                } else if (value instanceof float[]) {
                    obj = Arrays.toString((float[]) value);
                    f0.o(obj, "toString(this)");
                } else if (value instanceof long[]) {
                    obj = Arrays.toString((long[]) value);
                    f0.o(obj, "toString(this)");
                } else if (value instanceof double[]) {
                    obj = Arrays.toString((double[]) value);
                    f0.o(obj, "toString(this)");
                } else if (value instanceof Object[]) {
                    obj = Arrays.toString((Object[]) value);
                    f0.o(obj, "toString(this)");
                } else {
                    obj = value.toString();
                }
                return key + '=' + obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Class<T> cls, Map<String, ? extends Object> map) {
            super(0);
            this.f55893a = cls;
            this.f55894b = map;
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final String invoke() {
            Class<T> cls = this.f55893a;
            Map<String, Object> map = this.f55894b;
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            sb.append(cls.getCanonicalName());
            kotlin.collections.f0.V2(map.entrySet(), sb, ", ", "(", ")", 0, null, C1108a.f55895a, 48, null);
            String sb2 = sb.toString();
            f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    @NotNull
    public static final <T> T f(@NotNull Class<T> annotationClass, @NotNull Map<String, ? extends Object> values, @NotNull List<Method> methods) {
        p a4;
        p a5;
        f0.p(annotationClass, "annotationClass");
        f0.p(values, "values");
        f0.p(methods, "methods");
        a4 = r.a(new C1107a(values));
        a5 = r.a(new c(annotationClass, values));
        T t3 = (T) Proxy.newProxyInstance(annotationClass.getClassLoader(), new Class[]{annotationClass}, new b(annotationClass, values, a5, a4, methods));
        if (t3 != null) {
            return t3;
        }
        throw new NullPointerException("null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
    }

    public static /* synthetic */ Object g(Class cls, Map map, List list, int i4, Object obj) {
        int Z;
        if ((i4 & 4) != 0) {
            Set<String> keySet = map.keySet();
            Z = y.Z(keySet, 10);
            ArrayList arrayList = new ArrayList(Z);
            for (String str : keySet) {
                arrayList.add(cls.getDeclaredMethod(str, new Class[0]));
            }
            list = arrayList;
        }
        return f(cls, map, list);
    }

    public static final <T> boolean h(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object obj) {
        boolean g4;
        boolean z3;
        Annotation annotation = obj instanceof Annotation ? (Annotation) obj : null;
        if (f0.g(annotation != null ? c2.a.c(c2.a.a(annotation)) : null, cls)) {
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (Method method : list) {
                    Object obj2 = map.get(method.getName());
                    Object invoke = method.invoke(obj, new Object[0]);
                    if (obj2 instanceof boolean[]) {
                        boolean[] zArr = (boolean[]) obj2;
                        if (invoke != null) {
                            g4 = Arrays.equals(zArr, (boolean[]) invoke);
                            continue;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.BooleanArray");
                        }
                    } else if (obj2 instanceof char[]) {
                        char[] cArr = (char[]) obj2;
                        if (invoke != null) {
                            g4 = Arrays.equals(cArr, (char[]) invoke);
                            continue;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharArray");
                        }
                    } else if (obj2 instanceof byte[]) {
                        byte[] bArr = (byte[]) obj2;
                        if (invoke != null) {
                            g4 = Arrays.equals(bArr, (byte[]) invoke);
                            continue;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.ByteArray");
                        }
                    } else if (obj2 instanceof short[]) {
                        short[] sArr = (short[]) obj2;
                        if (invoke != null) {
                            g4 = Arrays.equals(sArr, (short[]) invoke);
                            continue;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.ShortArray");
                        }
                    } else if (obj2 instanceof int[]) {
                        int[] iArr = (int[]) obj2;
                        if (invoke != null) {
                            g4 = Arrays.equals(iArr, (int[]) invoke);
                            continue;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.IntArray");
                        }
                    } else if (obj2 instanceof float[]) {
                        float[] fArr = (float[]) obj2;
                        if (invoke != null) {
                            g4 = Arrays.equals(fArr, (float[]) invoke);
                            continue;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.FloatArray");
                        }
                    } else if (obj2 instanceof long[]) {
                        long[] jArr = (long[]) obj2;
                        if (invoke != null) {
                            g4 = Arrays.equals(jArr, (long[]) invoke);
                            continue;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.LongArray");
                        }
                    } else if (obj2 instanceof double[]) {
                        double[] dArr = (double[]) obj2;
                        if (invoke != null) {
                            g4 = Arrays.equals(dArr, (double[]) invoke);
                            continue;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.DoubleArray");
                        }
                    } else if (obj2 instanceof Object[]) {
                        Object[] objArr = (Object[]) obj2;
                        if (invoke != null) {
                            g4 = Arrays.equals(objArr, (Object[]) invoke);
                            continue;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
                        }
                    } else {
                        g4 = f0.g(obj2, invoke);
                        continue;
                    }
                    if (!g4) {
                        z3 = false;
                        break;
                    }
                }
            }
            z3 = true;
            if (z3) {
                return true;
            }
        }
        return false;
    }

    public static final int i(p<Integer> pVar) {
        return pVar.getValue().intValue();
    }

    public static final String j(p<String> pVar) {
        return pVar.getValue();
    }

    public static final Void k(int i4, String str, Class<?> cls) {
        kotlin.reflect.d d4;
        String D;
        if (f0.g(cls, Class.class)) {
            d4 = n0.d(kotlin.reflect.d.class);
        } else {
            d4 = (cls.isArray() && f0.g(cls.getComponentType(), Class.class)) ? n0.d(kotlin.reflect.d[].class) : c2.a.g(cls);
        }
        if (f0.g(d4.D(), n0.d(Object[].class).D())) {
            StringBuilder sb = new StringBuilder();
            sb.append((Object) d4.D());
            sb.append('<');
            Class<?> componentType = c2.a.c(d4).getComponentType();
            f0.o(componentType, "kotlinClass.java.componentType");
            sb.append((Object) c2.a.g(componentType).D());
            sb.append('>');
            D = sb.toString();
        } else {
            D = d4.D();
        }
        throw new IllegalArgumentException("Argument #" + i4 + ' ' + str + " is not of the required type " + ((Object) D));
    }

    public static final Object l(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof kotlin.reflect.d) {
            obj = c2.a.c((kotlin.reflect.d) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (!(objArr instanceof kotlin.reflect.d[])) {
                obj = objArr;
            } else if (obj != null) {
                kotlin.reflect.d[] dVarArr = (kotlin.reflect.d[]) obj;
                ArrayList arrayList = new ArrayList(dVarArr.length);
                int length = dVarArr.length;
                int i4 = 0;
                while (i4 < length) {
                    kotlin.reflect.d dVar = dVarArr[i4];
                    i4++;
                    arrayList.add(c2.a.c(dVar));
                }
                obj = arrayList.toArray(new Class[0]);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
