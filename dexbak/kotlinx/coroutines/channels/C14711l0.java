package kotlinx.coroutines.channels;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C15247w1;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: TickerChannels.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007\u001a1\u0010\f\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\u001a1\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0082@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m12616d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlin/coroutines/f;", "context", "Lkotlinx/coroutines/channels/TickerMode;", RtspHeaders.Values.MODE, "Lkotlinx/coroutines/channels/d0;", "Lkotlin/f1;", "c", "Lkotlinx/coroutines/channels/h0;", "channel", "b", "(JJLkotlinx/coroutines/channels/h0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.l0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14711l0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TickerChannels.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0082@"}, m12616d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/f1;", "channel", "Lkotlin/coroutines/c;", "continuation", "", "fixedDelayTicker"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.channels.TickerChannelsKt", m8638f = "TickerChannels.kt", m8637i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, m8636l = {106, 108, 109}, m8635m = "fixedDelayTicker", m8634n = {"delayMillis", "initialDelayMillis", "channel", "delayMillis", "initialDelayMillis", "channel", "delayMillis", "initialDelayMillis", "channel"}, m8633s = {"J$0", "J$1", "L$0", "J$0", "J$1", "L$0", "J$0", "J$1", "L$0"})
    /* renamed from: kotlinx.coroutines.channels.l0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14712a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42086a;

        /* renamed from: b */
        int f42087b;

        /* renamed from: c */
        long f42088c;

        /* renamed from: d */
        long f42089d;

        /* renamed from: e */
        Object f42090e;

        C14712a(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42086a = obj;
            this.f42087b |= Integer.MIN_VALUE;
            return C14711l0.m5426a(0L, 0L, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TickerChannels.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0082@"}, m12616d2 = {"", "delayMillis", "initialDelayMillis", "Lkotlinx/coroutines/channels/h0;", "Lkotlin/f1;", "channel", "Lkotlin/coroutines/c;", "continuation", "", "fixedPeriodTicker"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.channels.TickerChannelsKt", m8638f = "TickerChannels.kt", m8637i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3}, m8636l = {84, 88, 94, 96}, m8635m = "fixedPeriodTicker", m8634n = {"delayMillis", "initialDelayMillis", "channel", "deadline", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "now", "nextDelay", "adjustedDelay", "delayMillis", "initialDelayMillis", "channel", "deadline", "delayNs", "now", "nextDelay"}, m8633s = {"J$0", "J$1", "L$0", "J$2", "J$0", "J$1", "L$0", "J$2", "J$3", "J$0", "J$1", "L$0", "J$2", "J$3", "J$4", "J$5", "J$6", "J$0", "J$1", "L$0", "J$2", "J$3", "J$4", "J$5"})
    /* renamed from: kotlinx.coroutines.channels.l0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14713b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42091a;

        /* renamed from: b */
        int f42092b;

        /* renamed from: c */
        long f42093c;

        /* renamed from: d */
        long f42094d;

        /* renamed from: e */
        long f42095e;

        /* renamed from: f */
        long f42096f;

        /* renamed from: g */
        long f42097g;

        /* renamed from: h */
        long f42098h;

        /* renamed from: i */
        long f42099i;

        /* renamed from: j */
        Object f42100j;

        C14713b(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42091a = obj;
            this.f42092b |= Integer.MIN_VALUE;
            return C14711l0.m5425b(0L, 0L, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TickerChannels.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, m12616d2 = {"Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", m8638f = "TickerChannels.kt", m8637i = {0, 1}, m8636l = {72, 73}, m8635m = "invokeSuspend", m8634n = {"$this$produce", "$this$produce"}, m8633s = {"L$0", "L$0"})
    /* renamed from: kotlinx.coroutines.channels.l0$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14714c extends SuspendLambda implements InterfaceC15284p<InterfaceC14686b0<? super Unit>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private InterfaceC14686b0 f42101a;

        /* renamed from: b */
        Object f42102b;

        /* renamed from: c */
        int f42103c;

        /* renamed from: d */
        final /* synthetic */ TickerChannels f42104d;

        /* renamed from: e */
        final /* synthetic */ long f42105e;

        /* renamed from: f */
        final /* synthetic */ long f42106f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14714c(TickerChannels tickerChannels, long j, long j2, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42104d = tickerChannels;
            this.f42105e = j;
            this.f42106f = j2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14714c c14714c = new C14714c(this.f42104d, this.f42105e, this.f42106f, interfaceC14268c);
            c14714c.f42101a = (InterfaceC14686b0) obj;
            return c14714c;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(InterfaceC14686b0<? super Unit> interfaceC14686b0, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14714c) create(interfaceC14686b0, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42103c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                InterfaceC14686b0 interfaceC14686b0 = this.f42101a;
                int i2 = C14710k0.f42084a[this.f42104d.ordinal()];
                if (i2 == 1) {
                    long j = this.f42105e;
                    long j2 = this.f42106f;
                    InterfaceC14704h0 channel = interfaceC14686b0.getChannel();
                    this.f42102b = interfaceC14686b0;
                    this.f42103c = 1;
                    if (C14711l0.m5425b(j, j2, channel, this) == m8642h) {
                        return m8642h;
                    }
                } else if (i2 == 2) {
                    long j3 = this.f42105e;
                    long j4 = this.f42106f;
                    InterfaceC14704h0 channel2 = interfaceC14686b0.getChannel();
                    this.f42102b = interfaceC14686b0;
                    this.f42103c = 2;
                    if (C14711l0.m5426a(j3, j4, channel2, this) == m8642h) {
                        return m8642h;
                    }
                }
            } else if (i != 1 && i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                InterfaceC14686b0 interfaceC14686b02 = (InterfaceC14686b0) this.f42102b;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0091 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x008f -> B:14:0x0036). Please submit an issue!!! */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final /* synthetic */ java.lang.Object m5426a(long r8, long r10, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.InterfaceC14704h0<? super kotlin.Unit> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r13) {
        /*
            boolean r0 = r13 instanceof kotlinx.coroutines.channels.C14711l0.C14712a
            if (r0 == 0) goto L13
            r0 = r13
            kotlinx.coroutines.channels.l0$a r0 = (kotlinx.coroutines.channels.C14711l0.C14712a) r0
            int r1 = r0.f42087b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42087b = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.l0$a r0 = new kotlinx.coroutines.channels.l0$a
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f42086a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42087b
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L5c
            if (r2 == r5) goto L4f
            if (r2 == r4) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r8 = r0.f42090e
            kotlinx.coroutines.channels.h0 r8 = (kotlinx.coroutines.channels.InterfaceC14704h0) r8
            long r9 = r0.f42089d
            long r11 = r0.f42088c
            kotlin.C14294d0.m8596n(r13)
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
            java.lang.Object r8 = r0.f42090e
            kotlinx.coroutines.channels.h0 r8 = (kotlinx.coroutines.channels.InterfaceC14704h0) r8
            long r9 = r0.f42089d
            long r11 = r0.f42088c
            kotlin.C14294d0.m8596n(r13)
            goto L83
        L4f:
            java.lang.Object r8 = r0.f42090e
            r12 = r8
            kotlinx.coroutines.channels.h0 r12 = (kotlinx.coroutines.channels.InterfaceC14704h0) r12
            long r10 = r0.f42089d
            long r8 = r0.f42088c
            kotlin.C14294d0.m8596n(r13)
            goto L6e
        L5c:
            kotlin.C14294d0.m8596n(r13)
            r0.f42088c = r8
            r0.f42089d = r10
            r0.f42090e = r12
            r0.f42087b = r5
            java.lang.Object r13 = kotlinx.coroutines.Delay.m5751b(r10, r0)
            if (r13 != r1) goto L6e
            return r1
        L6e:
            kotlin.f1 r13 = kotlin.Unit.f41048a
            r0.f42088c = r8
            r0.f42089d = r10
            r0.f42090e = r12
            r0.f42087b = r4
            java.lang.Object r13 = r12.mo5177P(r13, r0)
            if (r13 != r1) goto L7f
            return r1
        L7f:
            r6 = r8
            r8 = r12
            r9 = r10
            r11 = r6
        L83:
            r0.f42088c = r11
            r0.f42089d = r9
            r0.f42090e = r8
            r0.f42087b = r3
            java.lang.Object r13 = kotlinx.coroutines.Delay.m5751b(r11, r0)
            if (r13 != r1) goto L36
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.C14711l0.m5426a(long, long, kotlinx.coroutines.channels.h0, kotlin.coroutines.c):java.lang.Object");
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
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static final /* synthetic */ java.lang.Object m5425b(long r21, long r23, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.InterfaceC14704h0<? super kotlin.Unit> r25, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r26) {
        /*
            Method dump skipped, instructions count: 383
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.C14711l0.m5425b(long, long, kotlinx.coroutines.channels.h0, kotlin.coroutines.c):java.lang.Object");
    }

    @ObsoleteCoroutinesApi
    @NotNull
    /* renamed from: c */
    public static final InterfaceC14695d0<Unit> m5424c(long j, long j2, @NotNull CoroutineContext coroutineContext, @NotNull TickerChannels tickerChannels) {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
        }
        if (j2 >= 0) {
            return C14739z.m5164e(C15247w1.f43439a, Dispatchers.m5032g().plus(coroutineContext), 0, new C14714c(tickerChannels, j, j2, null));
        }
        throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
    }

    /* renamed from: d */
    public static /* synthetic */ InterfaceC14695d0 m5423d(long j, long j2, CoroutineContext coroutineContext, TickerChannels tickerChannels, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerChannels = TickerChannels.FIXED_PERIOD;
        }
        return m5424c(j, j2, coroutineContext, tickerChannels);
    }
}
