package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.ranges.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: InlineClassAwareCaller.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\f\b\u0000\u0010\u0002 \u0001*\u0004\u0018\u00010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001\tB%\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u001f\u0010 J\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00028\u00008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u001b\u00a8\u0006!"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/f;", "Ljava/lang/reflect/Member;", "M", "Lkotlin/reflect/jvm/internal/calls/c;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "a", "Lkotlin/reflect/jvm/internal/calls/c;", "caller", "", "b", "Z", "isDefault", "Lkotlin/reflect/jvm/internal/calls/f$a;", "c", "Lkotlin/reflect/jvm/internal/calls/f$a;", "data", "()Ljava/lang/reflect/Member;", "member", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "", "()Ljava/util/List;", "parameterTypes", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "descriptor", "<init>", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/c;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f<M extends Member> implements c<M> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final c<M> f55909a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f55910b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final a f55911c;

    /* compiled from: InlineClassAwareCaller.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0002\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u0086\u0002J\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0086\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0086\u0002R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001f\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u0007R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/f$a;", "", "Lkotlin/ranges/k;", "a", "", "Ljava/lang/reflect/Method;", "b", "()[Ljava/lang/reflect/Method;", "c", "Lkotlin/ranges/k;", "getArgumentRange", "()Lkotlin/ranges/k;", "argumentRange", "[Ljava/lang/reflect/Method;", "getUnbox", "unbox", "Ljava/lang/reflect/Method;", "getBox", "()Ljava/lang/reflect/Method;", "box", "<init>", "(Lkotlin/ranges/k;[Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final k f55912a;
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        private final Method[] f55913b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private final Method f55914c;

        public a(@NotNull k argumentRange, @NotNull Method[] unbox, @Nullable Method method) {
            f0.p(argumentRange, "argumentRange");
            f0.p(unbox, "unbox");
            this.f55912a = argumentRange;
            this.f55913b = unbox;
            this.f55914c = method;
        }

        @NotNull
        public final k a() {
            return this.f55912a;
        }

        @NotNull
        public final Method[] b() {
            return this.f55913b;
        }

        @Nullable
        public final Method c() {
            return this.f55914c;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004f, code lost:
        if ((r12 instanceof kotlin.reflect.jvm.internal.calls.b) != false) goto L24;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public f(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r11, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.calls.c<? extends M> r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.f.<init>(kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, kotlin.reflect.jvm.internal.calls.c, boolean):void");
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @NotNull
    public List<Type> a() {
        return this.f55909a.a();
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    public M b() {
        return this.f55909a.b();
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @Nullable
    public Object call(@NotNull Object[] args) {
        Object invoke;
        f0.p(args, "args");
        a aVar = this.f55911c;
        k a4 = aVar.a();
        Method[] b4 = aVar.b();
        Method c4 = aVar.c();
        Object[] copyOf = Arrays.copyOf(args, args.length);
        f0.o(copyOf, "copyOf(this, size)");
        int c5 = a4.c();
        int g4 = a4.g();
        if (c5 <= g4) {
            while (true) {
                int i4 = c5 + 1;
                Method method = b4[c5];
                Object obj = args[c5];
                if (method != null) {
                    if (obj != null) {
                        obj = method.invoke(obj, new Object[0]);
                    } else {
                        Class<?> returnType = method.getReturnType();
                        f0.o(returnType, "method.returnType");
                        obj = kotlin.reflect.jvm.internal.f0.g(returnType);
                    }
                }
                copyOf[c5] = obj;
                if (c5 == g4) {
                    break;
                }
                c5 = i4;
            }
        }
        Object call = this.f55909a.call(copyOf);
        return (c4 == null || (invoke = c4.invoke(null, call)) == null) ? call : invoke;
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @NotNull
    public Type getReturnType() {
        return this.f55909a.getReturnType();
    }
}
