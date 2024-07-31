package kotlin.reflect;

import com.daimajia.numberprogressbar.BuildConfig;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.collections.C14236x;
import kotlin.collections._Collections;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.C14520s;
import kotlin.sequences.Sequence;
import kotlin.sequences._Sequences;
import kotlin.text.StringsJVM;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import p612k1.JvmClassMapping;
import p617l1.InterfaceC15280l;

/* compiled from: TypesJVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u001a\u0016\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0003\u001a\"\u0010\n\u001a\u00020\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0003\u001a\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0003H\u0002\"\u001e\u0010\u0012\u001a\u00020\u0003*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f\"\u001e\u0010\u0012\u001a\u00020\u0003*\u00020\b8BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, m12616d2 = {"Lkotlin/reflect/r;", "", "forceWrapper", "Ljava/lang/reflect/Type;", "c", "Ljava/lang/Class;", "jClass", "", "Lkotlin/reflect/t;", "arguments", "e", "type", "", "j", "f", "(Lkotlin/reflect/r;)Ljava/lang/reflect/Type;", "getJavaType$annotations", "(Lkotlin/reflect/r;)V", "javaType", "g", "(Lkotlin/reflect/t;)Ljava/lang/reflect/Type;", "(Lkotlin/reflect/t;)V", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.reflect.a0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14432a0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypesJVM.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u00002\n\u0010\u0001\u001a\u0006\u0012\u0002\b\u00030\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"Ljava/lang/Class;", "p1", "kotlin.jvm.PlatformType", "e", "(Ljava/lang/Class;)Ljava/lang/Class;"}, m12615k = 3, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.reflect.a0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final /* synthetic */ class C14433a extends FunctionReferenceImpl implements InterfaceC15280l<Class<? extends Object>, Class<?>> {

        /* renamed from: a */
        public static final C14433a f41334a = new C14433a();

        C14433a() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // p617l1.InterfaceC15280l
        /* renamed from: e */
        public final Class<?> invoke(@NotNull Class<?> p1) {
            C14342f0.m8184p(p1, "p1");
            return p1.getComponentType();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalStdlibApi
    /* renamed from: c */
    public static final Type m7376c(KType kType, boolean z) {
        Object m12159X4;
        int i;
        KClassifier mo7319o = kType.mo7319o();
        if (mo7319o instanceof KTypeParameter) {
            return new C14462y((KTypeParameter) mo7319o);
        }
        if (mo7319o instanceof KClass) {
            KClass kClass = (KClass) mo7319o;
            Class m12624e = z ? JvmClassMapping.m12624e(kClass) : JvmClassMapping.m12626c(kClass);
            List<KTypeProjection> arguments = kType.getArguments();
            if (arguments.isEmpty()) {
                return m12624e;
            }
            if (m12624e.isArray()) {
                Class<?> componentType = m12624e.getComponentType();
                C14342f0.m8185o(componentType, "jClass.componentType");
                if (componentType.isPrimitive()) {
                    return m12624e;
                }
                m12159X4 = _Collections.m12159X4(arguments);
                KTypeProjection kTypeProjection = (KTypeProjection) m12159X4;
                if (kTypeProjection != null) {
                    KVariance m7314a = kTypeProjection.m7314a();
                    KType m7313b = kTypeProjection.m7313b();
                    if (m7314a == null || (i = C14463z.f41349a[m7314a.ordinal()]) == 1) {
                        return m12624e;
                    }
                    if (i != 2 && i != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    C14342f0.m8187m(m7313b);
                    Type m7375d = m7375d(m7313b, false, 1, null);
                    return m7375d instanceof Class ? m12624e : new TypesJVM(m7375d);
                }
                throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + kType);
            }
            return m7374e(m12624e, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + kType);
    }

    /* renamed from: d */
    static /* synthetic */ Type m7375d(KType kType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return m7376c(kType, z);
    }

    @ExperimentalStdlibApi
    /* renamed from: e */
    private static final Type m7374e(Class<?> cls, List<KTypeProjection> list) {
        int m8957Y;
        int m8957Y2;
        int m8957Y3;
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass != null) {
            if (Modifier.isStatic(cls.getModifiers())) {
                m8957Y3 = C14236x.m8957Y(list, 10);
                ArrayList arrayList = new ArrayList(m8957Y3);
                for (KTypeProjection kTypeProjection : list) {
                    arrayList.add(m7372g(kTypeProjection));
                }
                return new C14459v(cls, declaringClass, arrayList);
            }
            int length = cls.getTypeParameters().length;
            Type m7374e = m7374e(declaringClass, list.subList(length, list.size()));
            List<KTypeProjection> subList = list.subList(0, length);
            m8957Y2 = C14236x.m8957Y(subList, 10);
            ArrayList arrayList2 = new ArrayList(m8957Y2);
            for (KTypeProjection kTypeProjection2 : subList) {
                arrayList2.add(m7372g(kTypeProjection2));
            }
            return new C14459v(cls, m7374e, arrayList2);
        }
        m8957Y = C14236x.m8957Y(list, 10);
        ArrayList arrayList3 = new ArrayList(m8957Y);
        for (KTypeProjection kTypeProjection3 : list) {
            arrayList3.add(m7372g(kTypeProjection3));
        }
        return new C14459v(cls, null, arrayList3);
    }

    @NotNull
    /* renamed from: f */
    public static final Type m7373f(@NotNull KType javaType) {
        Type m8172k;
        C14342f0.m8184p(javaType, "$this$javaType");
        return (!(javaType instanceof KTypeBase) || (m8172k = ((KTypeBase) javaType).m8172k()) == null) ? m7375d(javaType, false, 1, null) : m8172k;
    }

    /* renamed from: g */
    private static final Type m7372g(KTypeProjection kTypeProjection) {
        KVariance m7308g = kTypeProjection.m7308g();
        if (m7308g != null) {
            KType type = kTypeProjection.getType();
            C14342f0.m8187m(type);
            int i = C14463z.f41350b[m7308g.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        return new C14434b0(m7376c(type, true), null);
                    }
                    throw new NoWhenBranchMatchedException();
                }
                return new C14434b0(null, m7376c(type, true));
            }
            return m7376c(type, true);
        }
        return C14434b0.f41336d.m7366a();
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @ExperimentalStdlibApi
    /* renamed from: h */
    public static /* synthetic */ void m7371h(KType kType) {
    }

    @ExperimentalStdlibApi
    /* renamed from: i */
    private static /* synthetic */ void m7370i(KTypeProjection kTypeProjection) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static final String m7369j(Type type) {
        String name;
        Sequence m6983o;
        Object m7179Y0;
        int m7176Z;
        String m6576g2;
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.isArray()) {
                m6983o = C14520s.m6983o(type, C14433a.f41334a);
                StringBuilder sb = new StringBuilder();
                m7179Y0 = _Sequences.m7179Y0(m6983o);
                sb.append(((Class) m7179Y0).getName());
                m7176Z = _Sequences.m7176Z(m6983o);
                m6576g2 = StringsJVM.m6576g2(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, m7176Z);
                sb.append(m6576g2);
                name = sb.toString();
            } else {
                name = cls.getName();
            }
            C14342f0.m8185o(name, "if (type.isArray) {\n    …\n        } else type.name");
            return name;
        }
        return type.toString();
    }
}
