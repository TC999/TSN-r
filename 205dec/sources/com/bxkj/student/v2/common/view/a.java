package com.bxkj.student.v2.common.view;

import d2.p;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.flow.a0;
import kotlinx.coroutines.flow.k;
import kotlinx.coroutines.flow.s;
import kotlinx.coroutines.flow.x;
import kotlinx.coroutines.h3;
import kotlinx.coroutines.j;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: CountdownService.kt */
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000bR\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/bxkj/student/v2/common/view/a;", "", "Lkotlin/f1;", "f", "c", "Lkotlinx/coroutines/flow/s;", "Lcom/bxkj/student/v2/common/view/a$a;", "b", "Lkotlinx/coroutines/flow/s;", "_countdownEvent", "", "J", "DELAY_SENCOND", "Lkotlinx/coroutines/flow/x;", "d", "Lkotlinx/coroutines/flow/x;", "()Lkotlinx/coroutines/flow/x;", "countdownEvent", "Lkotlinx/coroutines/q0;", "e", "Lkotlinx/coroutines/q0;", "()Lkotlinx/coroutines/q0;", "scope", "Lkotlinx/coroutines/e2;", "Lkotlinx/coroutines/e2;", "job", "<init>", "()V", "a", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f23523a = new a();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final s<AbstractC0294a> f23524b;

    /* renamed from: c  reason: collision with root package name */
    private static final long f23525c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final x<AbstractC0294a> f23526d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final q0 f23527e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static e2 f23528f;

    /* compiled from: CountdownService.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lcom/bxkj/student/v2/common/view/a$a;", "", "<init>", "()V", "a", "b", "c", "d", "Lcom/bxkj/student/v2/common/view/a$a$c;", "Lcom/bxkj/student/v2/common/view/a$a$d;", "Lcom/bxkj/student/v2/common/view/a$a$b;", "Lcom/bxkj/student/v2/common/view/a$a$a;", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.bxkj.student.v2.common.view.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static abstract class AbstractC0294a {

        /* compiled from: CountdownService.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/bxkj/student/v2/common/view/a$a$a;", "Lcom/bxkj/student/v2/common/view/a$a;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.common.view.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class C0295a extends AbstractC0294a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final C0295a f23529a = new C0295a();

            private C0295a() {
                super(null);
            }
        }

        /* compiled from: CountdownService.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/bxkj/student/v2/common/view/a$a$b;", "Lcom/bxkj/student/v2/common/view/a$a;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.common.view.a$a$b */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class b extends AbstractC0294a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final b f23530a = new b();

            private b() {
                super(null);
            }
        }

        /* compiled from: CountdownService.kt */
        @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/bxkj/student/v2/common/view/a$a$c;", "Lcom/bxkj/student/v2/common/view/a$a;", "<init>", "()V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.common.view.a$a$c */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class c extends AbstractC0294a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            public static final c f23531a = new c();

            private c() {
                super(null);
            }
        }

        /* compiled from: CountdownService.kt */
        @Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/bxkj/student/v2/common/view/a$a$d;", "Lcom/bxkj/student/v2/common/view/a$a;", "", "a", "remainingSeconds", "b", "", "toString", "", "hashCode", "", "other", "", "equals", "J", "d", "()J", "<init>", "(J)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.bxkj.student.v2.common.view.a$a$d */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class d extends AbstractC0294a {

            /* renamed from: a  reason: collision with root package name */
            private final long f23532a;

            public d(long j4) {
                super(null);
                this.f23532a = j4;
            }

            public static /* synthetic */ d c(d dVar, long j4, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    j4 = dVar.f23532a;
                }
                return dVar.b(j4);
            }

            public final long a() {
                return this.f23532a;
            }

            @NotNull
            public final d b(long j4) {
                return new d(j4);
            }

            public final long d() {
                return this.f23532a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && this.f23532a == ((d) obj).f23532a;
            }

            public int hashCode() {
                return b0.a.a(this.f23532a);
            }

            @NotNull
            public String toString() {
                return "Ticked(remainingSeconds=" + this.f23532a + ')';
            }
        }

        private AbstractC0294a() {
        }

        public /* synthetic */ AbstractC0294a(u uVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CountdownService.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.bxkj.student.v2.common.view.CountdownService$startCountdown$1", f = "CountdownService.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class b extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f23533a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CountdownService.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.bxkj.student.v2.common.view.CountdownService$startCountdown$1$1", f = "CountdownService.kt", i = {1, 2, 3}, l = {38, 41, 44, 46}, m = "invokeSuspend", n = {"remainingSeconds", "remainingSeconds", "remainingSeconds"}, s = {"J$0", "J$0", "J$0"})
        /* renamed from: com.bxkj.student.v2.common.view.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public static final class C0296a extends SuspendLambda implements p<q0, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a  reason: collision with root package name */
            long f23534a;

            /* renamed from: b  reason: collision with root package name */
            int f23535b;

            C0296a(kotlin.coroutines.c<? super C0296a> cVar) {
                super(2, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                return new C0296a(cVar);
            }

            @Override // d2.p
            @Nullable
            public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
                return ((C0296a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
            }

            /* JADX WARN: Removed duplicated region for block: B:21:0x0051  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x0065  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x0089 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:32:0x008a  */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0087 -> B:19:0x004d). Please submit an issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
                /*
                    r11 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                    int r1 = r11.f23535b
                    r2 = 0
                    r4 = 4
                    r5 = 3
                    r6 = 2
                    r7 = 1
                    if (r1 == 0) goto L36
                    if (r1 == r7) goto L32
                    if (r1 == r6) goto L2b
                    if (r1 == r5) goto L24
                    if (r1 != r4) goto L1c
                    long r7 = r11.f23534a
                    kotlin.d0.n(r12)
                    goto L4c
                L1c:
                    java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r12.<init>(r0)
                    throw r12
                L24:
                    long r7 = r11.f23534a
                    kotlin.d0.n(r12)
                    r12 = r11
                    goto L76
                L2b:
                    long r7 = r11.f23534a
                    kotlin.d0.n(r12)
                    r12 = r11
                    goto L5e
                L32:
                    kotlin.d0.n(r12)
                    goto L48
                L36:
                    kotlin.d0.n(r12)
                    kotlinx.coroutines.flow.s r12 = com.bxkj.student.v2.common.view.a.b()
                    com.bxkj.student.v2.common.view.a$a$c r1 = com.bxkj.student.v2.common.view.a.AbstractC0294a.c.f23531a
                    r11.f23535b = r7
                    java.lang.Object r12 = r12.emit(r1, r11)
                    if (r12 != r0) goto L48
                    return r0
                L48:
                    long r7 = com.bxkj.student.v2.common.view.a.a()
                L4c:
                    r12 = r11
                L4d:
                    int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                    if (r1 <= 0) goto L8a
                    r9 = 1000(0x3e8, double:4.94E-321)
                    r12.f23534a = r7
                    r12.f23535b = r6
                    java.lang.Object r1 = kotlinx.coroutines.a1.b(r9, r12)
                    if (r1 != r0) goto L5e
                    return r0
                L5e:
                    r9 = -1
                    long r7 = r7 + r9
                    int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
                    if (r1 != 0) goto L76
                    kotlinx.coroutines.flow.s r1 = com.bxkj.student.v2.common.view.a.b()
                    com.bxkj.student.v2.common.view.a$a$b r9 = com.bxkj.student.v2.common.view.a.AbstractC0294a.b.f23530a
                    r12.f23534a = r7
                    r12.f23535b = r5
                    java.lang.Object r1 = r1.emit(r9, r12)
                    if (r1 != r0) goto L76
                    return r0
                L76:
                    kotlinx.coroutines.flow.s r1 = com.bxkj.student.v2.common.view.a.b()
                    com.bxkj.student.v2.common.view.a$a$d r9 = new com.bxkj.student.v2.common.view.a$a$d
                    r9.<init>(r7)
                    r12.f23534a = r7
                    r12.f23535b = r4
                    java.lang.Object r1 = r1.emit(r9, r12)
                    if (r1 != r0) goto L4d
                    return r0
                L8a:
                    kotlin.f1 r12 = kotlin.f1.f55527a
                    return r12
                */
                throw new UnsupportedOperationException("Method not decompiled: com.bxkj.student.v2.common.view.a.b.C0296a.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        b(kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            return new b(cVar);
        }

        @Override // d2.p
        @Nullable
        public final Object invoke(@NotNull q0 q0Var, @Nullable kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f23533a;
            if (i4 == 0) {
                d0.n(obj);
                C0296a c0296a = new C0296a(null);
                this.f23533a = 1;
                if (h3.e(c0296a, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    static {
        s<AbstractC0294a> a4 = a0.a(0, 1, BufferOverflow.DROP_LATEST);
        f23524b = a4;
        f23525c = 5L;
        f23526d = k.l(a4);
        f23527e = r0.a(kotlinx.coroutines.f1.a());
    }

    private a() {
    }

    public final void c() {
        e2 e2Var = f23528f;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        f23524b.b(AbstractC0294a.C0295a.f23529a);
    }

    @NotNull
    public final x<AbstractC0294a> d() {
        return f23526d;
    }

    @NotNull
    public final q0 e() {
        return f23527e;
    }

    public final void f() {
        e2 f4;
        e2 e2Var = f23528f;
        if (e2Var != null) {
            e2.a.b(e2Var, null, 1, null);
        }
        f4 = j.f(f23527e, null, null, new b(null), 3, null);
        f23528f = f4;
    }
}
