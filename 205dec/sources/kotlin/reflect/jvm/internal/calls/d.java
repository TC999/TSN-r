package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.o;
import kotlin.collections.p;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.r0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.calls.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CallerImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000 \u0015*\n\b\u0000\u0010\u0002 \u0001*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003:\b\b\n\u0013\u0007\u0015 !\"B5\b\u0004\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\f\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0012\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0004R\u0017\u0010\f\u001a\u00028\u00008\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00188\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\b\u0010\u001a\u0082\u0001\u0007#$%&'()\u00a8\u0006*"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d;", "Ljava/lang/reflect/Member;", "M", "Lkotlin/reflect/jvm/internal/calls/c;", "", "obj", "Lkotlin/f1;", "d", "a", "Ljava/lang/reflect/Member;", "b", "()Ljava/lang/reflect/Member;", "member", "Ljava/lang/reflect/Type;", "Ljava/lang/reflect/Type;", "getReturnType", "()Ljava/lang/reflect/Type;", "returnType", "Ljava/lang/Class;", "c", "Ljava/lang/Class;", "e", "()Ljava/lang/Class;", "instanceClass", "", "Ljava/util/List;", "()Ljava/util/List;", "parameterTypes", "", "valueParameterTypes", "<init>", "(Ljava/lang/reflect/Member;Ljava/lang/reflect/Type;Ljava/lang/Class;[Ljava/lang/reflect/Type;)V", "f", "g", "h", "Lkotlin/reflect/jvm/internal/calls/d$e;", "Lkotlin/reflect/jvm/internal/calls/d$c;", "Lkotlin/reflect/jvm/internal/calls/d$b;", "Lkotlin/reflect/jvm/internal/calls/d$a;", "Lkotlin/reflect/jvm/internal/calls/d$h;", "Lkotlin/reflect/jvm/internal/calls/d$f;", "Lkotlin/reflect/jvm/internal/calls/d$g;", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class d<M extends Member> implements kotlin.reflect.jvm.internal.calls.c<M> {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final C1109d f55896e = new C1109d(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final M f55897a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Type f55898b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Class<?> f55899c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final List<Type> f55900d;

    /* compiled from: CallerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00012\u00020\u0003B\u001d\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$a;", "Lkotlin/reflect/jvm/internal/calls/d;", "Ljava/lang/reflect/Constructor;", "Lkotlin/reflect/jvm/internal/calls/b;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "f", "Ljava/lang/Object;", "boundReceiver", "constructor", "<init>", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends d<Constructor<?>> implements kotlin.reflect.jvm.internal.calls.b {
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private final Object f55901f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8, @org.jetbrains.annotations.Nullable java.lang.Object r9) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                kotlin.jvm.internal.f0.p(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                kotlin.jvm.internal.f0.o(r3, r0)
                java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
                java.lang.String r1 = "constructor.genericParameterTypes"
                kotlin.jvm.internal.f0.o(r0, r1)
                int r1 = r0.length
                r2 = 2
                if (r1 > r2) goto L1f
                r0 = 0
                java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r0]
                goto L26
            L1f:
                int r1 = r0.length
                r2 = 1
                int r1 = r1 - r2
                java.lang.Object[] r0 = kotlin.collections.l.M1(r0, r2, r1)
            L26:
                r5 = r0
                java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
                r6 = 0
                r4 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r7.f55901f = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.d.a.<init>(java.lang.reflect.Constructor, java.lang.Object):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.c
        @Nullable
        public Object call(@NotNull Object[] args) {
            f0.p(args, "args");
            c(args);
            r0 r0Var = new r0(3);
            r0Var.a(this.f55901f);
            r0Var.b(args);
            r0Var.a(null);
            return b().newInstance(r0Var.d(new Object[r0Var.c()]));
        }
    }

    /* compiled from: CallerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$b;", "Lkotlin/reflect/jvm/internal/calls/d;", "Ljava/lang/reflect/Constructor;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "constructor", "<init>", "(Ljava/lang/reflect/Constructor;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends d<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public b(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                kotlin.jvm.internal.f0.p(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                kotlin.jvm.internal.f0.o(r3, r0)
                java.lang.reflect.Type[] r0 = r8.getGenericParameterTypes()
                java.lang.String r1 = "constructor.genericParameterTypes"
                kotlin.jvm.internal.f0.o(r0, r1)
                int r1 = r0.length
                r2 = 0
                r4 = 1
                if (r1 > r4) goto L1f
                java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r2]
                goto L25
            L1f:
                int r1 = r0.length
                int r1 = r1 - r4
                java.lang.Object[] r0 = kotlin.collections.l.M1(r0, r2, r1)
            L25:
                r5 = r0
                java.lang.reflect.Type[] r5 = (java.lang.reflect.Type[]) r5
                r6 = 0
                r4 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.d.b.<init>(java.lang.reflect.Constructor):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.c
        @Nullable
        public Object call(@NotNull Object[] args) {
            f0.p(args, "args");
            c(args);
            r0 r0Var = new r0(2);
            r0Var.b(args);
            r0Var.a(null);
            return b().newInstance(r0Var.d(new Object[r0Var.c()]));
        }
    }

    /* compiled from: CallerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\u0018\u00002\u00020\u00012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002B\u001d\u0012\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$c;", "Lkotlin/reflect/jvm/internal/calls/b;", "Lkotlin/reflect/jvm/internal/calls/d;", "Ljava/lang/reflect/Constructor;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "f", "Ljava/lang/Object;", "boundReceiver", "constructor", "<init>", "(Ljava/lang/reflect/Constructor;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends d<Constructor<?>> implements kotlin.reflect.jvm.internal.calls.b {
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private final Object f55902f;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public c(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8, @org.jetbrains.annotations.Nullable java.lang.Object r9) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                kotlin.jvm.internal.f0.p(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                kotlin.jvm.internal.f0.o(r3, r0)
                java.lang.reflect.Type[] r5 = r8.getGenericParameterTypes()
                java.lang.String r0 = "constructor.genericParameterTypes"
                kotlin.jvm.internal.f0.o(r5, r0)
                r4 = 0
                r6 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                r7.f55902f = r9
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.d.c.<init>(java.lang.reflect.Constructor, java.lang.Object):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.c
        @Nullable
        public Object call(@NotNull Object[] args) {
            f0.p(args, "args");
            c(args);
            r0 r0Var = new r0(2);
            r0Var.a(this.f55902f);
            r0Var.b(args);
            return b().newInstance(r0Var.d(new Object[r0Var.c()]));
        }
    }

    /* compiled from: CallerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ*\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0001\u0010\u0002\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0003H\u0086\b\u00a2\u0006\u0004\b\u0004\u0010\u0005J*\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0001\u0010\u0002\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0003H\u0086\b\u00a2\u0006\u0004\b\u0006\u0010\u0005J*\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0003\"\u0006\b\u0001\u0010\u0002\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u00028\u00010\u0003H\u0086\b\u00a2\u0006\u0004\b\u0007\u0010\u0005\u00a8\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$d;", "", "T", "", "dropFirst", "([Ljava/lang/Object;)[Ljava/lang/Object;", "dropFirstAndLast", "dropLast", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.reflect.jvm.internal.calls.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1109d {
        private C1109d() {
        }

        public /* synthetic */ C1109d(u uVar) {
            this();
        }
    }

    /* compiled from: CallerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$e;", "Lkotlin/reflect/jvm/internal/calls/d;", "Ljava/lang/reflect/Constructor;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "constructor", "<init>", "(Ljava/lang/reflect/Constructor;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e extends d<Constructor<?>> {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public e(@org.jetbrains.annotations.NotNull java.lang.reflect.Constructor<?> r8) {
            /*
                r7 = this;
                java.lang.String r0 = "constructor"
                kotlin.jvm.internal.f0.p(r8, r0)
                java.lang.Class r3 = r8.getDeclaringClass()
                java.lang.String r0 = "constructor.declaringClass"
                kotlin.jvm.internal.f0.o(r3, r0)
                java.lang.Class r0 = r8.getDeclaringClass()
                java.lang.Class r1 = r0.getDeclaringClass()
                if (r1 == 0) goto L24
                int r0 = r0.getModifiers()
                boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
                if (r0 != 0) goto L24
                r4 = r1
                goto L26
            L24:
                r0 = 0
                r4 = r0
            L26:
                java.lang.reflect.Type[] r5 = r8.getGenericParameterTypes()
                java.lang.String r0 = "constructor.genericParameterTypes"
                kotlin.jvm.internal.f0.o(r5, r0)
                r6 = 0
                r1 = r7
                r2 = r8
                r1.<init>(r2, r3, r4, r5, r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.d.e.<init>(java.lang.reflect.Constructor):void");
        }

        @Override // kotlin.reflect.jvm.internal.calls.c
        @Nullable
        public Object call(@NotNull Object[] args) {
            f0.p(args, "args");
            c(args);
            return b().newInstance(Arrays.copyOf(args, args.length));
        }
    }

    /* compiled from: CallerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\r\u000e\u000f\u0010\u0011B\u0019\b\u0004\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\u0012\u0013\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$f;", "Lkotlin/reflect/jvm/internal/calls/d;", "Ljava/lang/reflect/Field;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "field", "", "requiresInstance", "<init>", "(Ljava/lang/reflect/Field;Z)V", "a", "b", "c", "d", "e", "Lkotlin/reflect/jvm/internal/calls/d$f$e;", "Lkotlin/reflect/jvm/internal/calls/d$f$c;", "Lkotlin/reflect/jvm/internal/calls/d$f$d;", "Lkotlin/reflect/jvm/internal/calls/d$f$a;", "Lkotlin/reflect/jvm/internal/calls/d$f$b;", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class f extends d<Field> {

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$f$a;", "Lkotlin/reflect/jvm/internal/calls/b;", "Lkotlin/reflect/jvm/internal/calls/d$f;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "f", "Ljava/lang/Object;", "boundReceiver", "Ljava/lang/reflect/Field;", "field", "<init>", "(Ljava/lang/reflect/Field;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends f implements kotlin.reflect.jvm.internal.calls.b {
            @Nullable

            /* renamed from: f  reason: collision with root package name */
            private final Object f55903f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull Field field, @Nullable Object obj) {
                super(field, false, null);
                f0.p(field, "field");
                this.f55903f = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.d.f, kotlin.reflect.jvm.internal.calls.c
            @Nullable
            public Object call(@NotNull Object[] args) {
                f0.p(args, "args");
                c(args);
                return b().get(this.f55903f);
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$f$b;", "Lkotlin/reflect/jvm/internal/calls/b;", "Lkotlin/reflect/jvm/internal/calls/d$f;", "Ljava/lang/reflect/Field;", "field", "<init>", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends f implements kotlin.reflect.jvm.internal.calls.b {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull Field field) {
                super(field, false, null);
                f0.p(field, "field");
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$f$c;", "Lkotlin/reflect/jvm/internal/calls/d$f;", "Ljava/lang/reflect/Field;", "field", "<init>", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@NotNull Field field) {
                super(field, true, null);
                f0.p(field, "field");
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$f$d;", "Lkotlin/reflect/jvm/internal/calls/d$f;", "", "args", "Lkotlin/f1;", "c", "([Ljava/lang/Object;)V", "Ljava/lang/reflect/Field;", "field", "<init>", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* renamed from: kotlin.reflect.jvm.internal.calls.d$f$d  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1110d extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1110d(@NotNull Field field) {
                super(field, true, null);
                f0.p(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.d
            public void c(@NotNull Object[] args) {
                Object Kb;
                f0.p(args, "args");
                super.c(args);
                Kb = p.Kb(args);
                d(Kb);
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$f$e;", "Lkotlin/reflect/jvm/internal/calls/d$f;", "Ljava/lang/reflect/Field;", "field", "<init>", "(Ljava/lang/reflect/Field;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class e extends f {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(@NotNull Field field) {
                super(field, false, null);
                f0.p(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private f(java.lang.reflect.Field r7, boolean r8) {
            /*
                r6 = this;
                java.lang.reflect.Type r2 = r7.getGenericType()
                java.lang.String r0 = "field.genericType"
                kotlin.jvm.internal.f0.o(r2, r0)
                if (r8 == 0) goto L10
                java.lang.Class r8 = r7.getDeclaringClass()
                goto L11
            L10:
                r8 = 0
            L11:
                r3 = r8
                r8 = 0
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r8]
                r5 = 0
                r0 = r6
                r1 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.d.f.<init>(java.lang.reflect.Field, boolean):void");
        }

        public /* synthetic */ f(Field field, boolean z3, u uVar) {
            this(field, z3);
        }

        @Override // kotlin.reflect.jvm.internal.calls.c
        @Nullable
        public Object call(@NotNull Object[] args) {
            f0.p(args, "args");
            c(args);
            return b().get(e() != null ? p.ob(args) : null);
        }
    }

    /* compiled from: CallerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0005\u0013\u0014\u0006\u0015\u0016B!\b\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\u0004\u0018\u00010\b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0001\u0005\u0017\u0018\u0019\u001a\u001b\u00a8\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$g;", "Lkotlin/reflect/jvm/internal/calls/d;", "Ljava/lang/reflect/Field;", "", "args", "Lkotlin/f1;", "c", "([Ljava/lang/Object;)V", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "", "f", "Z", "notNull", "field", "requiresInstance", "<init>", "(Ljava/lang/reflect/Field;ZZ)V", "a", "b", "d", "e", "Lkotlin/reflect/jvm/internal/calls/d$g$e;", "Lkotlin/reflect/jvm/internal/calls/d$g$c;", "Lkotlin/reflect/jvm/internal/calls/d$g$d;", "Lkotlin/reflect/jvm/internal/calls/d$g$a;", "Lkotlin/reflect/jvm/internal/calls/d$g$b;", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class g extends d<Field> {

        /* renamed from: f  reason: collision with root package name */
        private final boolean f55904f;

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$g$a;", "Lkotlin/reflect/jvm/internal/calls/b;", "Lkotlin/reflect/jvm/internal/calls/d$g;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "g", "Ljava/lang/Object;", "boundReceiver", "Ljava/lang/reflect/Field;", "field", "", "notNull", "<init>", "(Ljava/lang/reflect/Field;ZLjava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends g implements kotlin.reflect.jvm.internal.calls.b {
            @Nullable

            /* renamed from: g  reason: collision with root package name */
            private final Object f55905g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull Field field, boolean z3, @Nullable Object obj) {
                super(field, z3, false, null);
                f0.p(field, "field");
                this.f55905g = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.d.g, kotlin.reflect.jvm.internal.calls.c
            @NotNull
            public Object call(@NotNull Object[] args) {
                Object ob;
                f0.p(args, "args");
                c(args);
                Object obj = this.f55905g;
                ob = p.ob(args);
                b().set(obj, ob);
                return f1.f55527a;
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$g$b;", "Lkotlin/reflect/jvm/internal/calls/b;", "Lkotlin/reflect/jvm/internal/calls/d$g;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/reflect/Field;", "field", "", "notNull", "<init>", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends g implements kotlin.reflect.jvm.internal.calls.b {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull Field field, boolean z3) {
                super(field, z3, false, null);
                f0.p(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.d.g, kotlin.reflect.jvm.internal.calls.c
            @NotNull
            public Object call(@NotNull Object[] args) {
                Object Xg;
                f0.p(args, "args");
                c(args);
                Xg = p.Xg(args);
                b().set(null, Xg);
                return f1.f55527a;
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$g$c;", "Lkotlin/reflect/jvm/internal/calls/d$g;", "Ljava/lang/reflect/Field;", "field", "", "notNull", "<init>", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(@NotNull Field field, boolean z3) {
                super(field, z3, true, null);
                f0.p(field, "field");
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$g$d;", "Lkotlin/reflect/jvm/internal/calls/d$g;", "", "args", "Lkotlin/f1;", "c", "([Ljava/lang/Object;)V", "Ljava/lang/reflect/Field;", "field", "", "notNull", "<init>", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* renamed from: kotlin.reflect.jvm.internal.calls.d$g$d  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1111d extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1111d(@NotNull Field field, boolean z3) {
                super(field, z3, true, null);
                f0.p(field, "field");
            }

            @Override // kotlin.reflect.jvm.internal.calls.d.g, kotlin.reflect.jvm.internal.calls.d
            public void c(@NotNull Object[] args) {
                Object Kb;
                f0.p(args, "args");
                super.c(args);
                Kb = p.Kb(args);
                d(Kb);
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$g$e;", "Lkotlin/reflect/jvm/internal/calls/d$g;", "Ljava/lang/reflect/Field;", "field", "", "notNull", "<init>", "(Ljava/lang/reflect/Field;Z)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class e extends g {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(@NotNull Field field, boolean z3) {
                super(field, z3, false, null);
                f0.p(field, "field");
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private g(java.lang.reflect.Field r7, boolean r8, boolean r9) {
            /*
                r6 = this;
                java.lang.Class r2 = java.lang.Void.TYPE
                java.lang.String r0 = "TYPE"
                kotlin.jvm.internal.f0.o(r2, r0)
                if (r9 == 0) goto Le
                java.lang.Class r9 = r7.getDeclaringClass()
                goto Lf
            Le:
                r9 = 0
            Lf:
                r3 = r9
                r9 = 1
                java.lang.reflect.Type[] r4 = new java.lang.reflect.Type[r9]
                r9 = 0
                java.lang.reflect.Type r0 = r7.getGenericType()
                java.lang.String r1 = "field.genericType"
                kotlin.jvm.internal.f0.o(r0, r1)
                r4[r9] = r0
                r5 = 0
                r0 = r6
                r1 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                r6.f55904f = r8
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.d.g.<init>(java.lang.reflect.Field, boolean, boolean):void");
        }

        public /* synthetic */ g(Field field, boolean z3, boolean z4, u uVar) {
            this(field, z3, z4);
        }

        @Override // kotlin.reflect.jvm.internal.calls.d
        public void c(@NotNull Object[] args) {
            Object Xg;
            f0.p(args, "args");
            super.c(args);
            if (this.f55904f) {
                Xg = p.Xg(args);
                if (Xg == null) {
                    throw new IllegalArgumentException("null is not allowed as a value for this property.");
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.calls.c
        @Nullable
        public Object call(@NotNull Object[] args) {
            Object Xg;
            f0.p(args, "args");
            c(args);
            Field b4 = b();
            Object ob = e() != null ? p.ob(args) : null;
            Xg = p.Xg(args);
            b4.set(ob, Xg);
            return f1.f55527a;
        }
    }

    private d(M m4, Type type, Class<?> cls, Type[] typeArr) {
        List<Type> M;
        this.f55897a = m4;
        this.f55898b = type;
        this.f55899c = cls;
        if (cls == null) {
            M = p.ey(typeArr);
        } else {
            r0 r0Var = new r0(2);
            r0Var.a(cls);
            r0Var.b(typeArr);
            M = CollectionsKt__CollectionsKt.M(r0Var.d(new Type[r0Var.c()]));
        }
        this.f55900d = M;
    }

    public /* synthetic */ d(Member member, Type type, Class cls, Type[] typeArr, u uVar) {
        this(member, type, cls, typeArr);
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @NotNull
    public List<Type> a() {
        return this.f55900d;
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @NotNull
    public final M b() {
        return this.f55897a;
    }

    public void c(@NotNull Object[] objArr) {
        c.a.a(this, objArr);
    }

    protected final void d(@Nullable Object obj) {
        if (obj == null || !this.f55897a.getDeclaringClass().isInstance(obj)) {
            throw new IllegalArgumentException("An object member requires the object instance passed as the first argument.");
        }
    }

    @Nullable
    public final Class<?> e() {
        return this.f55899c;
    }

    @Override // kotlin.reflect.jvm.internal.calls.c
    @NotNull
    public final Type getReturnType() {
        return this.f55898b;
    }

    /* compiled from: CallerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u0012\u0013\u0014\u0015\u0016\u0007B+\b\u0004\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0004\u00a2\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u0082\u0001\u0006\u0017\u0018\u0019\u001a\u001b\u001c\u00a8\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$h;", "Lkotlin/reflect/jvm/internal/calls/d;", "Ljava/lang/reflect/Method;", "", "instance", "", "args", "f", "(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;", "", "Z", "isVoidMethod", "method", "requiresInstance", "Ljava/lang/reflect/Type;", "parameterTypes", "<init>", "(Ljava/lang/reflect/Method;Z[Ljava/lang/reflect/Type;)V", "a", "b", "c", "d", "e", "Lkotlin/reflect/jvm/internal/calls/d$h$f;", "Lkotlin/reflect/jvm/internal/calls/d$h$d;", "Lkotlin/reflect/jvm/internal/calls/d$h$e;", "Lkotlin/reflect/jvm/internal/calls/d$h$c;", "Lkotlin/reflect/jvm/internal/calls/d$h$a;", "Lkotlin/reflect/jvm/internal/calls/d$h$b;", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class h extends d<Method> {

        /* renamed from: f  reason: collision with root package name */
        private final boolean f55906f;

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$h$a;", "Lkotlin/reflect/jvm/internal/calls/b;", "Lkotlin/reflect/jvm/internal/calls/d$h;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "g", "Ljava/lang/Object;", "boundReceiver", "Ljava/lang/reflect/Method;", "method", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a extends h implements kotlin.reflect.jvm.internal.calls.b {
            @Nullable

            /* renamed from: g  reason: collision with root package name */
            private final Object f55907g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(@NotNull Method method, @Nullable Object obj) {
                super(method, false, null, 4, null);
                f0.p(method, "method");
                this.f55907g = obj;
            }

            @Override // kotlin.reflect.jvm.internal.calls.c
            @Nullable
            public Object call(@NotNull Object[] args) {
                f0.p(args, "args");
                c(args);
                return f(this.f55907g, args);
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$h$b;", "Lkotlin/reflect/jvm/internal/calls/b;", "Lkotlin/reflect/jvm/internal/calls/d$h;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/reflect/Method;", "method", "<init>", "(Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends h implements kotlin.reflect.jvm.internal.calls.b {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(@NotNull Method method) {
                super(method, false, null, 4, null);
                f0.p(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.c
            @Nullable
            public Object call(@NotNull Object[] args) {
                f0.p(args, "args");
                c(args);
                return f(null, args);
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\n\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$h$c;", "Lkotlin/reflect/jvm/internal/calls/b;", "Lkotlin/reflect/jvm/internal/calls/d$h;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "g", "Ljava/lang/Object;", "boundReceiver", "Ljava/lang/reflect/Method;", "method", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class c extends h implements kotlin.reflect.jvm.internal.calls.b {
            @Nullable

            /* renamed from: g  reason: collision with root package name */
            private final Object f55908g;

            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public c(@org.jetbrains.annotations.NotNull java.lang.reflect.Method r5, @org.jetbrains.annotations.Nullable java.lang.Object r6) {
                /*
                    r4 = this;
                    java.lang.String r0 = "method"
                    kotlin.jvm.internal.f0.p(r5, r0)
                    java.lang.reflect.Type[] r0 = r5.getGenericParameterTypes()
                    java.lang.String r1 = "method.genericParameterTypes"
                    kotlin.jvm.internal.f0.o(r0, r1)
                    int r1 = r0.length
                    r2 = 1
                    r3 = 0
                    if (r1 > r2) goto L16
                    java.lang.reflect.Type[] r0 = new java.lang.reflect.Type[r3]
                    goto L1b
                L16:
                    int r1 = r0.length
                    java.lang.Object[] r0 = kotlin.collections.l.M1(r0, r2, r1)
                L1b:
                    java.lang.reflect.Type[] r0 = (java.lang.reflect.Type[]) r0
                    r1 = 0
                    r4.<init>(r5, r3, r0, r1)
                    r4.f55908g = r6
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.d.h.c.<init>(java.lang.reflect.Method, java.lang.Object):void");
            }

            @Override // kotlin.reflect.jvm.internal.calls.c
            @Nullable
            public Object call(@NotNull Object[] args) {
                f0.p(args, "args");
                c(args);
                r0 r0Var = new r0(2);
                r0Var.a(this.f55908g);
                r0Var.b(args);
                return f(null, r0Var.d(new Object[r0Var.c()]));
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$h$d;", "Lkotlin/reflect/jvm/internal/calls/d$h;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/reflect/Method;", "method", "<init>", "(Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* renamed from: kotlin.reflect.jvm.internal.calls.d$h$d  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1112d extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C1112d(@NotNull Method method) {
                super(method, false, null, 6, null);
                f0.p(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.c
            @Nullable
            public Object call(@NotNull Object[] args) {
                f0.p(args, "args");
                c(args);
                return f(args[0], args.length <= 1 ? new Object[0] : o.M1(args, 1, args.length));
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$h$e;", "Lkotlin/reflect/jvm/internal/calls/d$h;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/reflect/Method;", "method", "<init>", "(Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class e extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public e(@NotNull Method method) {
                super(method, true, null, 4, null);
                f0.p(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.c
            @Nullable
            public Object call(@NotNull Object[] args) {
                Object Kb;
                f0.p(args, "args");
                c(args);
                Kb = p.Kb(args);
                d(Kb);
                return f(null, args.length <= 1 ? new Object[0] : o.M1(args, 1, args.length));
            }
        }

        /* compiled from: CallerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/d$h$f;", "Lkotlin/reflect/jvm/internal/calls/d$h;", "", "args", "", "call", "([Ljava/lang/Object;)Ljava/lang/Object;", "Ljava/lang/reflect/Method;", "method", "<init>", "(Ljava/lang/reflect/Method;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class f extends h {
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(@NotNull Method method) {
                super(method, false, null, 6, null);
                f0.p(method, "method");
            }

            @Override // kotlin.reflect.jvm.internal.calls.c
            @Nullable
            public Object call(@NotNull Object[] args) {
                f0.p(args, "args");
                c(args);
                return f(null, args);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public /* synthetic */ h(java.lang.reflect.Method r1, boolean r2, java.lang.reflect.Type[] r3, int r4, kotlin.jvm.internal.u r5) {
            /*
                r0 = this;
                r5 = r4 & 2
                if (r5 == 0) goto Le
                int r2 = r1.getModifiers()
                boolean r2 = java.lang.reflect.Modifier.isStatic(r2)
                r2 = r2 ^ 1
            Le:
                r4 = r4 & 4
                if (r4 == 0) goto L1b
                java.lang.reflect.Type[] r3 = r1.getGenericParameterTypes()
                java.lang.String r4 = "class Method(\n        me\u2026        }\n        }\n    }"
                kotlin.jvm.internal.f0.o(r3, r4)
            L1b:
                r4 = 0
                r0.<init>(r1, r2, r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.d.h.<init>(java.lang.reflect.Method, boolean, java.lang.reflect.Type[], int, kotlin.jvm.internal.u):void");
        }

        public /* synthetic */ h(Method method, boolean z3, Type[] typeArr, u uVar) {
            this(method, z3, typeArr);
        }

        @Nullable
        protected final Object f(@Nullable Object obj, @NotNull Object[] args) {
            f0.p(args, "args");
            return this.f55906f ? f1.f55527a : b().invoke(obj, Arrays.copyOf(args, args.length));
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private h(java.lang.reflect.Method r7, boolean r8, java.lang.reflect.Type[] r9) {
            /*
                r6 = this;
                java.lang.reflect.Type r2 = r7.getGenericReturnType()
                java.lang.String r0 = "method.genericReturnType"
                kotlin.jvm.internal.f0.o(r2, r0)
                if (r8 == 0) goto L10
                java.lang.Class r8 = r7.getDeclaringClass()
                goto L11
            L10:
                r8 = 0
            L11:
                r3 = r8
                r5 = 0
                r0 = r6
                r1 = r7
                r4 = r9
                r0.<init>(r1, r2, r3, r4, r5)
                java.lang.reflect.Type r7 = r6.getReturnType()
                java.lang.Class r8 = java.lang.Void.TYPE
                boolean r7 = kotlin.jvm.internal.f0.g(r7, r8)
                r6.f55906f = r7
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.d.h.<init>(java.lang.reflect.Method, boolean, java.lang.reflect.Type[]):void");
        }
    }
}
