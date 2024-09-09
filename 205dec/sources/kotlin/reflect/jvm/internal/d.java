package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: RuntimeTypeMapper.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0005\u0003\u0006\u0007\b\tB\t\b\u0004\u00a2\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0003\u001a\u00020\u0002H&\u0082\u0001\u0005\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/d;", "", "", "a", "<init>", "()V", "b", "c", "d", "e", "Lkotlin/reflect/jvm/internal/d$e;", "Lkotlin/reflect/jvm/internal/d$d;", "Lkotlin/reflect/jvm/internal/d$c;", "Lkotlin/reflect/jvm/internal/d$b;", "Lkotlin/reflect/jvm/internal/d$a;", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class d {

    /* compiled from: RuntimeTypeMapper.kt */
    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R%\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\n0\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/d$a;", "Lkotlin/reflect/jvm/internal/d;", "", "a", "Ljava/lang/Class;", "Ljava/lang/Class;", "getJClass", "()Ljava/lang/Class;", "jClass", "", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "b", "Ljava/util/List;", "()Ljava/util/List;", "methods", "<init>", "(Ljava/lang/Class;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends d {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Class<?> f55920a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final List<Method> f55921b;

        /* compiled from: RuntimeTypeMapper.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/reflect/Method;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
        /* renamed from: kotlin.reflect.jvm.internal.d$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1113a extends Lambda implements d2.l<Method, CharSequence> {

            /* renamed from: a  reason: collision with root package name */
            public static final C1113a f55922a = new C1113a();

            C1113a() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final CharSequence invoke(Method method) {
                Class<?> returnType = method.getReturnType();
                kotlin.jvm.internal.f0.o(returnType, "it.returnType");
                return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(returnType);
            }
        }

        /* compiled from: Comparisons.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", "a", "b", "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/b$b", "<anonymous>"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b<T> implements Comparator {
            @Override // java.util.Comparator
            public final int compare(T t3, T t4) {
                int g4;
                g4 = kotlin.comparisons.b.g(((Method) t3).getName(), ((Method) t4).getName());
                return g4;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull Class<?> jClass) {
            super(null);
            List<Method> hv;
            kotlin.jvm.internal.f0.p(jClass, "jClass");
            this.f55920a = jClass;
            Method[] declaredMethods = jClass.getDeclaredMethods();
            kotlin.jvm.internal.f0.o(declaredMethods, "jClass.declaredMethods");
            hv = kotlin.collections.p.hv(declaredMethods, new b());
            this.f55921b = hv;
        }

        @Override // kotlin.reflect.jvm.internal.d
        @NotNull
        public String a() {
            String X2;
            X2 = kotlin.collections.f0.X2(this.f55921b, "", "<init>(", ")V", 0, null, C1113a.f55922a, 24, null);
            return X2;
        }

        @NotNull
        public final List<Method> b() {
            return this.f55921b;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001b\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/d$b;", "Lkotlin/reflect/jvm/internal/d;", "", "a", "Ljava/lang/reflect/Constructor;", "Ljava/lang/reflect/Constructor;", "b", "()Ljava/lang/reflect/Constructor;", "constructor", "<init>", "(Ljava/lang/reflect/Constructor;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends d {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Constructor<?> f55923a;

        /* compiled from: RuntimeTypeMapper.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\u0010\u0002\u001a\u0012\u0012\u0002\b\u0003 \u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Ljava/lang/Class;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Class;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.l<Class<?>, CharSequence> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f55924a = new a();

            a() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final CharSequence invoke(Class<?> it) {
                kotlin.jvm.internal.f0.o(it, "it");
                return kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.b(it);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull Constructor<?> constructor) {
            super(null);
            kotlin.jvm.internal.f0.p(constructor, "constructor");
            this.f55923a = constructor;
        }

        @Override // kotlin.reflect.jvm.internal.d
        @NotNull
        public String a() {
            String Ig;
            Class<?>[] parameterTypes = this.f55923a.getParameterTypes();
            kotlin.jvm.internal.f0.o(parameterTypes, "constructor.parameterTypes");
            Ig = kotlin.collections.p.Ig(parameterTypes, "", "<init>(", ")V", 0, null, a.f55924a, 24, null);
            return Ig;
        }

        @NotNull
        public final Constructor<?> b() {
            return this.f55923a;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/d$c;", "Lkotlin/reflect/jvm/internal/d;", "", "a", "Ljava/lang/reflect/Method;", "Ljava/lang/reflect/Method;", "b", "()Ljava/lang/reflect/Method;", "method", "<init>", "(Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends d {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final Method f55925a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull Method method) {
            super(null);
            kotlin.jvm.internal.f0.p(method, "method");
            this.f55925a = method;
        }

        @Override // kotlin.reflect.jvm.internal.d
        @NotNull
        public String a() {
            String b4;
            b4 = c0.b(this.f55925a);
            return b4;
        }

        @NotNull
        public final Method b() {
            return this.f55925a;
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\r\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkotlin/reflect/jvm/internal/d$d;", "Lkotlin/reflect/jvm/internal/d;", "", "a", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/d$b;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/d$b;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "signature", "b", "Ljava/lang/String;", "_signature", "()Ljava/lang/String;", "constructorDesc", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.reflect.jvm.internal.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1114d extends d {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final d.b f55926a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f55927b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1114d(@NotNull d.b signature) {
            super(null);
            kotlin.jvm.internal.f0.p(signature, "signature");
            this.f55926a = signature;
            this.f55927b = signature.a();
        }

        @Override // kotlin.reflect.jvm.internal.d
        @NotNull
        public String a() {
            return this.f55927b;
        }

        @NotNull
        public final String b() {
            return this.f55926a.b();
        }
    }

    /* compiled from: RuntimeTypeMapper.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0011\u0010\u000e\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000f\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lkotlin/reflect/jvm/internal/d$e;", "Lkotlin/reflect/jvm/internal/d;", "", "a", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/d$b;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/d$b;", "getSignature", "()Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;", "signature", "b", "Ljava/lang/String;", "_signature", "c", "()Ljava/lang/String;", "methodName", "methodDesc", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/deserialization/JvmMemberSignature$Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends d {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final d.b f55928a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final String f55929b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(@NotNull d.b signature) {
            super(null);
            kotlin.jvm.internal.f0.p(signature, "signature");
            this.f55928a = signature;
            this.f55929b = signature.a();
        }

        @Override // kotlin.reflect.jvm.internal.d
        @NotNull
        public String a() {
            return this.f55929b;
        }

        @NotNull
        public final String b() {
            return this.f55928a.b();
        }

        @NotNull
        public final String c() {
            return this.f55928a.c();
        }
    }

    private d() {
    }

    public /* synthetic */ d(kotlin.jvm.internal.u uVar) {
        this();
    }

    @NotNull
    public abstract String a();
}
