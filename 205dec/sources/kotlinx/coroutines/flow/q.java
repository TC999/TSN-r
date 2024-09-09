package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Share.kt */
@Metadata(bv = {}, d1 = {"\u0000l\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a6\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u001a-\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b\u000b\u0010\f\u001aM\u0010\u0014\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00028\u0000H\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a1\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u001aC\u0010\u001d\u001a\u00020\u0013\"\u0004\b\u0000\u0010\u0000*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00160\u001bH\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0010\u001a\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000 \u001aU\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\b2-\u0010'\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000#\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130$\u0012\u0006\u0012\u0004\u0018\u00010%0\"\u00a2\u0006\u0002\b&\u00f8\u0001\u0000\u00a2\u0006\u0004\b(\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/q0;", "scope", "Lkotlinx/coroutines/flow/d0;", "started", "", "replay", "Lkotlinx/coroutines/flow/x;", "g", "Lkotlinx/coroutines/flow/c0;", "c", "(Lkotlinx/coroutines/flow/h;I)Lkotlinx/coroutines/flow/c0;", "Lkotlin/coroutines/f;", "context", "upstream", "Lkotlinx/coroutines/flow/s;", "shared", "initialValue", "Lkotlin/f1;", "d", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/s;Lkotlinx/coroutines/flow/d0;Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/h0;", "j", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/q0;Lkotlinx/coroutines/flow/d0;Ljava/lang/Object;)Lkotlinx/coroutines/flow/h0;", "i", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/q0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/y;", "result", "e", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/y;)V", "a", "Lkotlinx/coroutines/flow/t;", "b", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "action", "f", "(Lkotlinx/coroutines/flow/x;Ld2/p;)Lkotlinx/coroutines/flow/x;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final /* synthetic */ class q {

    /* compiled from: Share.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", i = {0, 1, 2, 3}, l = {206, 210, 211, 217}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "$this$launch"}, s = {"L$0", "L$0", "L$0", "L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a */
        private q0 f60286a;

        /* renamed from: b */
        Object f60287b;

        /* renamed from: c */
        int f60288c;

        /* renamed from: d */
        final /* synthetic */ d0 f60289d;

        /* renamed from: e */
        final /* synthetic */ h f60290e;

        /* renamed from: f */
        final /* synthetic */ s f60291f;

        /* renamed from: g */
        final /* synthetic */ Object f60292g;

        /* compiled from: Share.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: kotlinx.coroutines.flow.q$a$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1218a extends SuspendLambda implements d2.p<Integer, kotlin.coroutines.c<? super Boolean>, Object> {

            /* renamed from: a */
            private int f60293a;

            /* renamed from: b */
            int f60294b;

            C1218a(kotlin.coroutines.c cVar) {
                super(2, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                C1218a c1218a = new C1218a(cVar);
                Number number = (Number) obj;
                number.intValue();
                c1218a.f60293a = number.intValue();
                return c1218a;
            }

            @Override // d2.p
            public final Object invoke(Integer num, kotlin.coroutines.c<? super Boolean> cVar) {
                return ((C1218a) create(num, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.b.h();
                if (this.f60294b == 0) {
                    kotlin.d0.n(obj);
                    return kotlin.coroutines.jvm.internal.a.a(this.f60293a > 0);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: Share.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlinx/coroutines/flow/SharingCommand;", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", i = {0}, l = {219}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends SuspendLambda implements d2.p<SharingCommand, kotlin.coroutines.c<? super f1>, Object> {

            /* renamed from: a */
            private SharingCommand f60295a;

            /* renamed from: b */
            Object f60296b;

            /* renamed from: c */
            int f60297c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(kotlin.coroutines.c cVar) {
                super(2, cVar);
                a.this = r1;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
                b bVar = new b(cVar);
                bVar.f60295a = (SharingCommand) obj;
                return bVar;
            }

            @Override // d2.p
            public final Object invoke(SharingCommand sharingCommand, kotlin.coroutines.c<? super f1> cVar) {
                return ((b) create(sharingCommand, cVar)).invokeSuspend(f1.f55527a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object h4;
                h4 = kotlin.coroutines.intrinsics.b.h();
                int i4 = this.f60297c;
                if (i4 == 0) {
                    kotlin.d0.n(obj);
                    SharingCommand sharingCommand = this.f60295a;
                    int i5 = j.f60181a[sharingCommand.ordinal()];
                    if (i5 == 1) {
                        a aVar = a.this;
                        h hVar = aVar.f60290e;
                        s sVar = aVar.f60291f;
                        this.f60296b = sharingCommand;
                        this.f60297c = 1;
                        if (hVar.e(sVar, this) == h4) {
                            return h4;
                        }
                    } else if (i5 == 3) {
                        a aVar2 = a.this;
                        Object obj2 = aVar2.f60292g;
                        if (obj2 == a0.f59989a) {
                            aVar2.f60291f.f();
                        } else {
                            aVar2.f60291f.b(obj2);
                        }
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    SharingCommand sharingCommand2 = (SharingCommand) this.f60296b;
                    kotlin.d0.n(obj);
                }
                return f1.f55527a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(d0 d0Var, h hVar, s sVar, Object obj, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f60289d = d0Var;
            this.f60290e = hVar;
            this.f60291f = sVar;
            this.f60292g = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f60289d, this.f60290e, this.f60291f, this.f60292g, cVar);
            aVar.f60286a = (q0) obj;
            return aVar;
        }

        @Override // d2.p
        public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:56:0x0078 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
            /*
                r8 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r8.f60288c
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2d
                if (r1 == r5) goto L25
                if (r1 == r4) goto L1d
                if (r1 == r3) goto L25
                if (r1 != r2) goto L15
                goto L25
            L15:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1d:
                java.lang.Object r1 = r8.f60287b
                kotlinx.coroutines.q0 r1 = (kotlinx.coroutines.q0) r1
                kotlin.d0.n(r9)
                goto L6a
            L25:
                java.lang.Object r0 = r8.f60287b
                kotlinx.coroutines.q0 r0 = (kotlinx.coroutines.q0) r0
                kotlin.d0.n(r9)
                goto L99
            L2d:
                kotlin.d0.n(r9)
                kotlinx.coroutines.q0 r1 = r8.f60286a
                kotlinx.coroutines.flow.d0 r9 = r8.f60289d
                kotlinx.coroutines.flow.d0$a r6 = kotlinx.coroutines.flow.d0.f60004a
                kotlinx.coroutines.flow.d0 r7 = r6.c()
                if (r9 != r7) goto L4b
                kotlinx.coroutines.flow.h r9 = r8.f60290e
                kotlinx.coroutines.flow.s r2 = r8.f60291f
                r8.f60287b = r1
                r8.f60288c = r5
                java.lang.Object r9 = r9.e(r2, r8)
                if (r9 != r0) goto L99
                return r0
            L4b:
                kotlinx.coroutines.flow.d0 r9 = r8.f60289d
                kotlinx.coroutines.flow.d0 r5 = r6.d()
                r6 = 0
                if (r9 != r5) goto L79
                kotlinx.coroutines.flow.s r9 = r8.f60291f
                kotlinx.coroutines.flow.h0 r9 = r9.c()
                kotlinx.coroutines.flow.q$a$a r2 = new kotlinx.coroutines.flow.q$a$a
                r2.<init>(r6)
                r8.f60287b = r1
                r8.f60288c = r4
                java.lang.Object r9 = kotlinx.coroutines.flow.k.y0(r9, r2, r8)
                if (r9 != r0) goto L6a
                return r0
            L6a:
                kotlinx.coroutines.flow.h r9 = r8.f60290e
                kotlinx.coroutines.flow.s r2 = r8.f60291f
                r8.f60287b = r1
                r8.f60288c = r3
                java.lang.Object r9 = r9.e(r2, r8)
                if (r9 != r0) goto L99
                return r0
            L79:
                kotlinx.coroutines.flow.d0 r9 = r8.f60289d
                kotlinx.coroutines.flow.s r3 = r8.f60291f
                kotlinx.coroutines.flow.h0 r3 = r3.c()
                kotlinx.coroutines.flow.h r9 = r9.a(r3)
                kotlinx.coroutines.flow.h r9 = kotlinx.coroutines.flow.k.l0(r9)
                kotlinx.coroutines.flow.q$a$b r3 = new kotlinx.coroutines.flow.q$a$b
                r3.<init>(r6)
                r8.f60287b = r1
                r8.f60288c = r2
                java.lang.Object r9 = kotlinx.coroutines.flow.k.E(r9, r3, r8)
                if (r9 != r0) goto L99
                return r0
            L99:
                kotlin.f1 r9 = kotlin.f1.f55527a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.q.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Share.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {0, 0, 0}, l = {415}, m = "invokeSuspend", n = {"$this$launch", "state", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a */
        private q0 f60299a;

        /* renamed from: b */
        Object f60300b;

        /* renamed from: c */
        Object f60301c;

        /* renamed from: d */
        Object f60302d;

        /* renamed from: e */
        int f60303e;

        /* renamed from: f */
        final /* synthetic */ h f60304f;

        /* renamed from: g */
        final /* synthetic */ kotlinx.coroutines.y f60305g;

        /* compiled from: Collect.kt */
        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class a<T> implements i<T> {

            /* renamed from: b */
            final /* synthetic */ q0 f60307b;

            /* renamed from: c */
            final /* synthetic */ Ref.ObjectRef f60308c;

            public a(q0 q0Var, Ref.ObjectRef objectRef) {
                b.this = r1;
                this.f60307b = q0Var;
                this.f60308c = objectRef;
            }

            /* JADX WARN: Type inference failed for: r3v1, types: [kotlinx.coroutines.flow.t, T] */
            @Override // kotlinx.coroutines.flow.i
            @Nullable
            public Object emit(Object obj, @NotNull kotlin.coroutines.c cVar) {
                f1 f1Var;
                Object h4;
                Ref.ObjectRef objectRef = this.f60308c;
                t tVar = (t) objectRef.element;
                if (tVar != null) {
                    tVar.setValue(obj);
                    f1Var = f1.f55527a;
                } else {
                    ?? r3 = (T) j0.a(obj);
                    b.this.f60305g.v(k.m(r3));
                    f1 f1Var2 = f1.f55527a;
                    objectRef.element = r3;
                    f1Var = f1Var2;
                }
                h4 = kotlin.coroutines.intrinsics.b.h();
                return f1Var == h4 ? f1Var : f1.f55527a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(h hVar, kotlinx.coroutines.y yVar, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f60304f = hVar;
            this.f60305g = yVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            b bVar = new b(this.f60304f, this.f60305g, cVar);
            bVar.f60299a = (q0) obj;
            return bVar;
        }

        @Override // d2.p
        public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f60303e;
            try {
                if (i4 == 0) {
                    kotlin.d0.n(obj);
                    q0 q0Var = this.f60299a;
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = null;
                    h hVar = this.f60304f;
                    a aVar = new a(q0Var, objectRef);
                    this.f60300b = q0Var;
                    this.f60301c = objectRef;
                    this.f60302d = hVar;
                    this.f60303e = 1;
                    if (hVar.e(aVar, this) == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    h hVar2 = (h) this.f60302d;
                    Ref.ObjectRef objectRef2 = (Ref.ObjectRef) this.f60301c;
                    q0 q0Var2 = (q0) this.f60300b;
                    kotlin.d0.n(obj);
                }
                return f1.f55527a;
            } catch (Throwable th) {
                this.f60305g.c(th);
                throw th;
            }
        }
    }

    @NotNull
    public static final <T> x<T> a(@NotNull s<T> sVar) {
        return new u(sVar);
    }

    @NotNull
    public static final <T> h0<T> b(@NotNull t<T> tVar) {
        return new v(tVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x002d, code lost:
        if (r3 == 0) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final <T> kotlinx.coroutines.flow.c0<T> c(kotlinx.coroutines.flow.h<? extends T> r7, int r8) {
        /*
            kotlinx.coroutines.channels.n$b r0 = kotlinx.coroutines.channels.n.f59462j0
            int r0 = r0.a()
            int r0 = kotlin.ranges.o.n(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.e
            if (r1 == 0) goto L3d
            r1 = r7
            kotlinx.coroutines.flow.internal.e r1 = (kotlinx.coroutines.flow.internal.e) r1
            kotlinx.coroutines.flow.h r2 = r1.l()
            if (r2 == 0) goto L3d
            kotlinx.coroutines.flow.c0 r7 = new kotlinx.coroutines.flow.c0
            int r3 = r1.f60132b
            r4 = -3
            r5 = 0
            if (r3 == r4) goto L27
            r4 = -2
            if (r3 == r4) goto L27
            if (r3 == 0) goto L27
            r0 = r3
            goto L35
        L27:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.f60133c
            kotlinx.coroutines.channels.BufferOverflow r6 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            if (r4 != r6) goto L30
            if (r3 != 0) goto L35
            goto L34
        L30:
            if (r8 != 0) goto L34
            r0 = 1
            goto L35
        L34:
            r0 = 0
        L35:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.f60133c
            kotlin.coroutines.f r1 = r1.f60131a
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3d:
            kotlinx.coroutines.flow.c0 r8 = new kotlinx.coroutines.flow.c0
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.SUSPEND
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.INSTANCE
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.q.c(kotlinx.coroutines.flow.h, int):kotlinx.coroutines.flow.c0");
    }

    private static final <T> void d(q0 q0Var, kotlin.coroutines.f fVar, h<? extends T> hVar, s<T> sVar, d0 d0Var, T t3) {
        kotlinx.coroutines.j.f(q0Var, fVar, null, new a(d0Var, hVar, sVar, t3, null), 2, null);
    }

    private static final <T> void e(q0 q0Var, kotlin.coroutines.f fVar, h<? extends T> hVar, kotlinx.coroutines.y<h0<T>> yVar) {
        kotlinx.coroutines.j.f(q0Var, fVar, null, new b(hVar, yVar, null), 2, null);
    }

    @NotNull
    public static final <T> x<T> f(@NotNull x<? extends T> xVar, @NotNull d2.p<? super i<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return new m0(xVar, pVar);
    }

    @NotNull
    public static final <T> x<T> g(@NotNull h<? extends T> hVar, @NotNull q0 q0Var, @NotNull d0 d0Var, int i4) {
        c0 c4 = c(hVar, i4);
        s a4 = a0.a(i4, c4.f59999b, c4.f60000c);
        d(q0Var, c4.f60001d, c4.f59998a, a4, d0Var, a0.f59989a);
        return k.l(a4);
    }

    public static /* synthetic */ x h(h hVar, q0 q0Var, d0 d0Var, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return k.Q1(hVar, q0Var, d0Var, i4);
    }

    @Nullable
    public static final <T> Object i(@NotNull h<? extends T> hVar, @NotNull q0 q0Var, @NotNull kotlin.coroutines.c<? super h0<? extends T>> cVar) {
        c0 c4 = c(hVar, 1);
        kotlinx.coroutines.y c5 = kotlinx.coroutines.a0.c(null, 1, null);
        e(q0Var, c4.f60001d, c4.f59998a, c5);
        return c5.k(cVar);
    }

    @NotNull
    public static final <T> h0<T> j(@NotNull h<? extends T> hVar, @NotNull q0 q0Var, @NotNull d0 d0Var, T t3) {
        c0 c4 = c(hVar, 1);
        t a4 = j0.a(t3);
        d(q0Var, c4.f60001d, c4.f59998a, a4, d0Var, t3);
        return k.m(a4);
    }
}
