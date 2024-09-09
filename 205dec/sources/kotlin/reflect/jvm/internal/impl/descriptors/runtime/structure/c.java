package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectJavaMember.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class c {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final c f56578a = new c();
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static a f56579b;

    /* compiled from: ReflectJavaMember.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private final Method f56580a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private final Method f56581b;

        public a(@Nullable Method method, @Nullable Method method2) {
            this.f56580a = method;
            this.f56581b = method2;
        }

        @Nullable
        public final Method a() {
            return this.f56581b;
        }

        @Nullable
        public final Method b() {
            return this.f56580a;
        }
    }

    private c() {
    }

    @NotNull
    public final a a(@NotNull Member member) {
        f0.p(member, "member");
        Class<?> cls = member.getClass();
        try {
            return new a(cls.getMethod("getParameters", new Class[0]), d.f(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new a(null, null);
        }
    }

    @Nullable
    public final a b() {
        return f56579b;
    }

    @Nullable
    public final List<String> c(@NotNull Member member) {
        Method a4;
        f0.p(member, "member");
        a aVar = f56579b;
        if (aVar == null) {
            synchronized (this) {
                c cVar = f56578a;
                a b4 = cVar.b();
                if (b4 == null) {
                    b4 = cVar.a(member);
                    cVar.d(b4);
                }
                aVar = b4;
            }
        }
        Method b5 = aVar.b();
        if (b5 == null || (a4 = aVar.a()) == null) {
            return null;
        }
        Object invoke = b5.invoke(member, new Object[0]);
        if (invoke != null) {
            Object[] objArr = (Object[]) invoke;
            ArrayList arrayList = new ArrayList(objArr.length);
            int length = objArr.length;
            int i4 = 0;
            while (i4 < length) {
                Object obj = objArr[i4];
                i4++;
                Object invoke2 = a4.invoke(obj, new Object[0]);
                if (invoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
                arrayList.add((String) invoke2);
            }
            return arrayList;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<*>");
    }

    public final void d(@Nullable a aVar) {
        f56579b = aVar;
    }
}
