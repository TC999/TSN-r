package kotlin.reflect.full;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KAnnotatedElements.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u000b\b\u00c2\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004R$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkotlin/reflect/full/a;", "", "Lkotlin/reflect/full/a$a;", "a", "Ljava/lang/Class;", "", "klass", "c", "b", "Lkotlin/reflect/full/a$a;", "()Lkotlin/reflect/full/a$a;", "d", "(Lkotlin/reflect/full/a$a;)V", "cache", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f55838a = new a();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static C1105a f55839b;

    /* compiled from: KAnnotatedElements.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0010\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\r\u0010\u000eR!\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0004\u0010\u0006R\u0019\u0010\f\u001a\u0004\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lkotlin/reflect/full/a$a;", "", "Ljava/lang/Class;", "", "a", "Ljava/lang/Class;", "()Ljava/lang/Class;", "repeatableClass", "Ljava/lang/reflect/Method;", "b", "Ljava/lang/reflect/Method;", "()Ljava/lang/reflect/Method;", "valueMethod", "<init>", "(Ljava/lang/Class;Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.reflect.full.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1105a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final Class<? extends Annotation> f55840a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final Method f55841b;

        public C1105a(@Nullable Class<? extends Annotation> cls, @Nullable Method method) {
            this.f55840a = cls;
            this.f55841b = method;
        }

        @Nullable
        public final Class<? extends Annotation> a() {
            return this.f55840a;
        }

        @Nullable
        public final Method b() {
            return this.f55841b;
        }
    }

    private a() {
    }

    private final C1105a a() {
        try {
            Class<?> cls = Class.forName("java.lang.annotation.Repeatable");
            return new C1105a(cls, cls.getMethod("value", new Class[0]));
        } catch (ClassNotFoundException unused) {
            return new C1105a(null, null);
        }
    }

    @Nullable
    public final C1105a b() {
        return f55839b;
    }

    @Nullable
    public final Class<? extends Annotation> c(@NotNull Class<? extends Annotation> klass) {
        Annotation annotation;
        Method b4;
        f0.p(klass, "klass");
        C1105a c1105a = f55839b;
        if (c1105a == null) {
            synchronized (this) {
                a aVar = f55838a;
                C1105a b5 = aVar.b();
                if (b5 == null) {
                    b5 = aVar.a();
                    aVar.d(b5);
                }
                c1105a = b5;
            }
        }
        Class a4 = c1105a.a();
        if (a4 == null || (annotation = klass.getAnnotation(a4)) == null || (b4 = c1105a.b()) == null) {
            return null;
        }
        Object invoke = b4.invoke(annotation, new Object[0]);
        if (invoke != null) {
            return (Class) invoke;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<out kotlin.Annotation>");
    }

    public final void d(@Nullable C1105a c1105a) {
        f55839b = c1105a;
    }
}
