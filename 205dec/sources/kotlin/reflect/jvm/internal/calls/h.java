package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.o;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.calls.c;
import kotlin.reflect.jvm.internal.calls.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InternalUnderlyingValOfInlineClass.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002\t\u000eB\u001f\b\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0004\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u0017\u0010\u0015\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0001\u0002\u001b\u001c\u00a8\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/h;", "Lkotlin/reflect/jvm/internal/calls/c;", "Ljava/lang/reflect/Method;", "", "instance", "", "args", "c", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "a", "Ljava/lang/reflect/Method;", "unboxMethod", "", "Ljava/lang/reflect/Type;", "b", "Ljava/util/List;", "()Ljava/util/List;", "parameterTypes", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "e", "()Ljava/lang/reflect/Method;", "member", "<init>", "(Ljava/lang/reflect/Method;Ljava/util/List;)V", "Lkotlin/reflect/jvm/internal/calls/h$b;", "Lkotlin/reflect/jvm/internal/calls/h$a;", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class h implements c<Method> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Method f55915a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<Type> f55916b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Type f55917c;

    /* compiled from: InternalUnderlyingValOfInlineClass.kt */
    @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/h$a;", "Lkotlin/reflect/jvm/internal/calls/h;", "Lkotlin/reflect/jvm/internal/calls/b;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "d", "Ljava/lang/Object;", "boundReceiver", "Ljava/lang/reflect/Method;", "unboxMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends h implements kotlin.reflect.jvm.internal.calls.b {
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final Object f55918d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r3, @org.jetbrains.annotations.Nullable java.lang.Object r4) {
            /*
                r2 = this;
                java.lang.String r0 = "unboxMethod"
                kotlin.jvm.internal.f0.p(r3, r0)
                java.util.List r0 = kotlin.collections.w.F()
                r1 = 0
                r2.<init>(r3, r0, r1)
                r2.f55918d = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.a.<init>(java.lang.reflect.Method, java.lang.Object):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.c
        @Nullable
        public Object call(@NotNull Object[] args) {
            f0.p(args, "args");
            d(args);
            return c(this.f55918d, args);
        }
    }

    /* compiled from: InternalUnderlyingValOfInlineClass.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/h$b;", "Lkotlin/reflect/jvm/internal/calls/h;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/reflect/Method;", "unboxMethod", "<init>", "(Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends h {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r3) {
            /*
                r2 = this;
                java.lang.String r0 = "unboxMethod"
                kotlin.jvm.internal.f0.p(r3, r0)
                java.lang.Class r0 = r3.getDeclaringClass()
                java.util.List r0 = kotlin.collections.w.l(r0)
                r1 = 0
                r2.<init>(r3, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.h.b.<init>(java.lang.reflect.Method):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.c
        @Nullable
        public Object call(@NotNull Object[] args) {
            f0.p(args, "args");
            d(args);
            Object obj = args[0];
            d.C1109d c1109d = d.f55896e;
            return c(obj, args.length <= 1 ? new Object[0] : o.M1(args, 1, args.length));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private h(Method method, List<? extends Type> list) {
        this.f55915a = method;
        this.f55916b = list;
        Class<?> returnType = method.getReturnType();
        f0.o(returnType, "unboxMethod.returnType");
        this.f55917c = returnType;
    }

    public /* synthetic */ h(Method method, List list, u uVar) {
        this(method, list);
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @NotNull
    public final List<Type> a() {
        return this.f55916b;
    }

    @Nullable
    protected final Object c(@Nullable Object obj, @NotNull Object[] args) {
        f0.p(args, "args");
        return this.f55915a.invoke(obj, Arrays.copyOf(args, args.length));
    }

    public void d(@NotNull Object[] objArr) {
        c.a.a(this, objArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @Nullable
    /* renamed from: e */
    public final Method b() {
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @NotNull
    public final Type getReturnType() {
        return this.f55917c;
    }
}
