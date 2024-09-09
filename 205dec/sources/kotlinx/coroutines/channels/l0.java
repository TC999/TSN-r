package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import kotlinx.coroutines.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TickerChannels.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007\u001a1\u0010\f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\r\u001a1\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlin/coroutines/f;", "context", "Lkotlinx/coroutines/channels/TickerMode;", "mode", "Lkotlinx/coroutines/channels/d0;", "Lkotlin/f1;", "c", "Lkotlinx/coroutines/channels/h0;", "channel", "b", "(JJLkotlinx/coroutines/channels/h0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: TickerChannels.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0082@"}, d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/f1;", "channel", "Lkotlin/coroutines/c;", "continuation", "", "fixedDelayTicker"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {106, 108, 109}, m = "fixedDelayTicker", n = {"delayMillis", "initialDelayMillis", "channel", "delayMillis", "initialDelayMillis", "channel", "delayMillis", "initialDelayMillis", "channel"}, s = {"J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59431a;

        /* renamed from: b  reason: collision with root package name */
        int f59432b;

        /* renamed from: c  reason: collision with root package name */
        long f59433c;

        /* renamed from: d  reason: collision with root package name */
        long f59434d;

        /* renamed from: e  reason: collision with root package name */
        Object f59435e;

        a(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59431a = obj;
            this.f59432b |= Integer.MIN_VALUE;
            return l0.a(0L, 0L, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: TickerChannels.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0082@"}, d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/f1;", "channel", "Lkotlin/coroutines/c;", "continuation", "", "fixedPeriodTicker"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt", f = "TickerChannels.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, l = {84, 88, 94, 96}, m = "fixedPeriodTicker", n = {"delayMillis", "initialDelayMillis", "channel", "deadline", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "now", "nextDelay", "adjustedDelay", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "now", "nextDelay"}, s = {"J$0", "J$1", "L$0", "J$2", "J$0", "J$1", "L$0", "J$2", "J$3", "J$0", "J$1", "L$0", "J$2", "J$3", "J$4", "J$5", "J$6", "J$0", "J$1", "L$0", "J$2", "J$3", "J$4", "J$5"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends ContinuationImpl {

        /* renamed from: a  reason: collision with root package name */
        /* synthetic */ Object f59436a;

        /* renamed from: b  reason: collision with root package name */
        int f59437b;

        /* renamed from: c  reason: collision with root package name */
        long f59438c;

        /* renamed from: d  reason: collision with root package name */
        long f59439d;

        /* renamed from: e  reason: collision with root package name */
        long f59440e;

        /* renamed from: f  reason: collision with root package name */
        long f59441f;

        /* renamed from: g  reason: collision with root package name */
        long f59442g;

        /* renamed from: h  reason: collision with root package name */
        long f59443h;

        /* renamed from: i  reason: collision with root package name */
        long f59444i;

        /* renamed from: j  reason: collision with root package name */
        Object f59445j;

        b(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59436a = obj;
            this.f59437b |= Integer.MIN_VALUE;
            return l0.b(0L, 0L, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: TickerChannels.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", f = "TickerChannels.kt", i = {0, 1}, l = {72, 73}, m = "invokeSuspend", n = {"$this$produce", "$this$produce"}, s = {"L$0", "L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends SuspendLambda implements d2.p<b0<? super f1>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private b0 f59446a;

        /* renamed from: b  reason: collision with root package name */
        Object f59447b;

        /* renamed from: c  reason: collision with root package name */
        int f59448c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ TickerMode f59449d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f59450e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f59451f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(TickerMode tickerMode, long j4, long j5, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f59449d = tickerMode;
            this.f59450e = j4;
            this.f59451f = j5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(this.f59449d, this.f59450e, this.f59451f, cVar);
            cVar2.f59446a = (b0) obj;
            return cVar2;
        }

        @Override // d2.p
        public final Object invoke(b0<? super f1> b0Var, kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(b0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f59448c;
            if (i4 == 0) {
                kotlin.d0.n(obj);
                b0 b0Var = this.f59446a;
                int i5 = k0.f59429a[this.f59449d.ordinal()];
                if (i5 == 1) {
                    long j4 = this.f59450e;
                    long j5 = this.f59451f;
                    h0 channel = b0Var.getChannel();
                    this.f59447b = b0Var;
                    this.f59448c = 1;
                    if (l0.b(j4, j5, channel, this) == h4) {
                        return h4;
                    }
                } else if (i5 == 2) {
                    long j6 = this.f59450e;
                    long j7 = this.f59451f;
                    h0 channel2 = b0Var.getChannel();
                    this.f59447b = b0Var;
                    this.f59448c = 2;
                    if (l0.a(j6, j7, channel2, this) == h4) {
                        return h4;
                    }
                }
            } else if (i4 != 1 && i4 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                b0 b0Var2 = (b0) this.f59447b;
                kotlin.d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008f -> B:14:0x0036). Please submit an issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final /* synthetic */ java.lang.Object a(long r8, long r10, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.h0<? super kotlin.f1> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r13) {
        /*
            boolean r0 = r13 instanceof kotlinx.coroutines.channels.l0.a
            if (r0 == 0) goto L13
            r0 = r13
            kotlinx.coroutines.channels.l0$a r0 = (kotlinx.coroutines.channels.l0.a) r0
            int r1 = r0.f59432b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59432b = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.l0$a r0 = new kotlinx.coroutines.channels.l0$a
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f59431a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59432b
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5c
            if (r2 == r5) goto L4f
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r8 = r0.f59435e
            kotlinx.coroutines.channels.h0 r8 = (kotlinx.coroutines.channels.h0) r8
            long r9 = r0.f59434d
            long r11 = r0.f59433c
            kotlin.d0.n(r13)
        L36:
            r6 = r11
            r12 = r8
            r10 = r9
            r8 = r6
            goto L6e
        L3b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L43:
            java.lang.Object r8 = r0.f59435e
            kotlinx.coroutines.channels.h0 r8 = (kotlinx.coroutines.channels.h0) r8
            long r9 = r0.f59434d
            long r11 = r0.f59433c
            kotlin.d0.n(r13)
            goto L83
        L4f:
            java.lang.Object r8 = r0.f59435e
            r12 = r8
            kotlinx.coroutines.channels.h0 r12 = (kotlinx.coroutines.channels.h0) r12
            long r10 = r0.f59434d
            long r8 = r0.f59433c
            kotlin.d0.n(r13)
            goto L6e
        L5c:
            kotlin.d0.n(r13)
            r0.f59433c = r8
            r0.f59434d = r10
            r0.f59435e = r12
            r0.f59432b = r5
            java.lang.Object r13 = kotlinx.coroutines.a1.b(r10, r0)
            if (r13 != r1) goto L6e
            return r1
        L6e:
            kotlin.f1 r13 = kotlin.f1.f55527a
            r0.f59433c = r8
            r0.f59434d = r10
            r0.f59435e = r12
            r0.f59432b = r4
            java.lang.Object r13 = r12.O(r13, r0)
            if (r13 != r1) goto L7f
            return r1
        L7f:
            r6 = r8
            r8 = r12
            r9 = r10
            r11 = r6
        L83:
            r0.f59433c = r11
            r0.f59434d = r9
            r0.f59435e = r8
            r0.f59432b = r3
            java.lang.Object r13 = kotlinx.coroutines.a1.b(r11, r0)
            if (r13 != r1) goto L36
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.l0.a(long, long, kotlinx.coroutines.channels.h0, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0140 -> B:55:0x0177). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x016f -> B:54:0x0172). Please submit an issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final /* synthetic */ java.lang.Object b(long r21, long r23, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.h0<? super kotlin.f1> r25, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r26) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.l0.b(long, long, kotlinx.coroutines.channels.h0, kotlin.coroutines.c):java.lang.Object");
    }

    @ObsoleteCoroutinesApi
    @NotNull
    public static final d0<f1> c(long j4, long j5, @NotNull kotlin.coroutines.f fVar, @NotNull TickerMode tickerMode) {
        if (!(j4 >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j4 + " ms").toString());
        }
        if (j5 >= 0) {
            return z.c(w1.f60756a, kotlinx.coroutines.f1.g().plus(fVar), 0, new c(tickerMode, j4, j5, null));
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j5 + " ms").toString());
    }

    public static /* synthetic */ d0 d(long j4, long j5, kotlin.coroutines.f fVar, TickerMode tickerMode, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j5 = j4;
        }
        if ((i4 & 4) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i4 & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return c(j4, j5, fVar, tickerMode);
    }
}
