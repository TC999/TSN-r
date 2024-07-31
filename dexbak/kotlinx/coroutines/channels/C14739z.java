package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.C15117k0;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InterfaceC15146o;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: Produce.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0004\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001ag\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a \u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00132-\b\u0002\u0010\u001b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\u0004\u0018\u0001`\u001a2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001d\u001aª\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u0014\u001a\u00020\u00132-\b\u0002\u0010\u001b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\u0004\u0018\u0001`\u001a2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\u0002\b\u000fH\u0000ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, m12616d2 = {"Lkotlinx/coroutines/channels/b0;", "Lkotlin/Function0;", "Lkotlin/f1;", "block", "a", "(Lkotlinx/coroutines/channels/b0;Ll1/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "Lkotlinx/coroutines/channels/d0;", "e", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILl1/p;)Lkotlinx/coroutines/channels/d0;", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "c", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILkotlinx/coroutines/CoroutineStart;Ll1/l;Ll1/p;)Lkotlinx/coroutines/channels/d0;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "d", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Ll1/l;Ll1/p;)Lkotlinx/coroutines/channels/d0;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.z */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14739z {

    /* compiled from: Produce.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0087@"}, m12616d2 = {"Lkotlinx/coroutines/channels/b0;", "Lkotlin/Function0;", "Lkotlin/f1;", "block", "Lkotlin/coroutines/c;", "continuation", "", "awaitClose"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.channels.ProduceKt", m8638f = "Produce.kt", m8637i = {0, 0}, m8636l = {157}, m8635m = "awaitClose", m8634n = {"$this$awaitClose", "block"}, m8633s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.channels.z$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14740a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42160a;

        /* renamed from: b */
        int f42161b;

        /* renamed from: c */
        Object f42162c;

        /* renamed from: d */
        Object f42163d;

        C14740a(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42160a = obj;
            this.f42161b |= Integer.MIN_VALUE;
            return C14739z.m5168a(null, null, this);
        }
    }

    /* compiled from: Produce.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, m12616d2 = {"Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.z$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14741b extends Lambda implements InterfaceC15269a<Unit> {

        /* renamed from: a */
        public static final C14741b f42164a = new C14741b();

        C14741b() {
            super(0);
        }

        @Override // p617l1.InterfaceC15269a
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f41048a;
        }

        /* renamed from: invoke */
        public final void invoke2() {
        }
    }

    /* compiled from: Produce.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {"", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.z$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14742c extends Lambda implements InterfaceC15280l<Throwable, Unit> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC15146o f42165a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14742c(InterfaceC15146o interfaceC15146o) {
            super(1);
            this.f42165a = interfaceC15146o;
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f41048a;
        }

        /* renamed from: invoke */
        public final void invoke2(@Nullable Throwable th) {
            InterfaceC15146o interfaceC15146o = this.f42165a;
            Unit unit = Unit.f41048a;
            Result.C14124a c14124a = Result.Companion;
            interfaceC15146o.resumeWith(Result.m60148constructorimpl(unit));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x003c  */
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m5168a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.InterfaceC14686b0<?> r4, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15269a<kotlin.Unit> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.C14739z.C14740a
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.z$a r0 = (kotlinx.coroutines.channels.C14739z.C14740a) r0
            int r1 = r0.f42161b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42161b = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.z$a r0 = new kotlinx.coroutines.channels.z$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f42160a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42161b
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.f42163d
            r5 = r4
            l1.a r5 = (p617l1.InterfaceC15269a) r5
            java.lang.Object r4 = r0.f42162c
            kotlinx.coroutines.channels.b0 r4 = (kotlinx.coroutines.channels.InterfaceC14686b0) r4
            kotlin.C14294d0.m8596n(r6)     // Catch: java.lang.Throwable -> L32
            goto L7c
        L32:
            r4 = move-exception
            goto L82
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            kotlin.C14294d0.m8596n(r6)
            kotlin.coroutines.f r6 = r0.getContext()
            kotlinx.coroutines.e2$b r2 = kotlinx.coroutines.Job.f42281m0
            kotlin.coroutines.f$b r6 = r6.get(r2)
            kotlinx.coroutines.e2 r6 = (kotlinx.coroutines.Job) r6
            if (r6 != r4) goto L4f
            r6 = 1
            goto L50
        L4f:
            r6 = 0
        L50:
            if (r6 == 0) goto L86
            r0.f42162c = r4     // Catch: java.lang.Throwable -> L32
            r0.f42163d = r5     // Catch: java.lang.Throwable -> L32
            r0.f42161b = r3     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.p r6 = new kotlinx.coroutines.p     // Catch: java.lang.Throwable -> L32
            kotlin.coroutines.c r2 = kotlin.coroutines.intrinsics.C14286a.m8644d(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.mo3915J()     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.channels.z$c r2 = new kotlinx.coroutines.channels.z$c     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.mo5200C(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.m3883y()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = kotlin.coroutines.intrinsics.C14286a.m8643h()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L79
            kotlin.coroutines.jvm.internal.DebugProbes.m8616c(r0)     // Catch: java.lang.Throwable -> L32
        L79:
            if (r4 != r1) goto L7c
            return r1
        L7c:
            r5.invoke()
            kotlin.f1 r4 = kotlin.Unit.f41048a
            return r4
        L82:
            r5.invoke()
            throw r4
        L86:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.C14739z.m5168a(kotlinx.coroutines.channels.b0, l1.a, kotlin.coroutines.c):java.lang.Object");
    }

    /* renamed from: b */
    public static /* synthetic */ Object m5167b(InterfaceC14686b0 interfaceC14686b0, InterfaceC15269a interfaceC15269a, InterfaceC14268c interfaceC14268c, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC15269a = C14741b.f42164a;
        }
        return m5168a(interfaceC14686b0, interfaceC15269a, interfaceC14268c);
    }

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: c */
    public static final <E> InterfaceC14695d0<E> m5166c(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i, @NotNull CoroutineStart coroutineStart, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, @Inference @NotNull InterfaceC15284p<? super InterfaceC14686b0<? super E>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return m5165d(coroutineScope, coroutineContext, i, BufferOverflow.SUSPEND, coroutineStart, interfaceC15280l, interfaceC15284p);
    }

    @NotNull
    /* renamed from: d */
    public static final <E> InterfaceC14695d0<E> m5165d(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i, @NotNull BufferOverflow bufferOverflow, @NotNull CoroutineStart coroutineStart, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, @Inference @NotNull InterfaceC15284p<? super InterfaceC14686b0<? super E>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        Produce produce = new Produce(C15117k0.m4086d(coroutineScope, coroutineContext), C14728q.m5382d(i, bufferOverflow, null, 4, null));
        if (interfaceC15280l != null) {
            produce.mo3818w(interfaceC15280l);
        }
        produce.m5758q1(coroutineStart, produce, interfaceC15284p);
        return produce;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: e */
    public static final <E> InterfaceC14695d0<E> m5164e(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i, @Inference @NotNull InterfaceC15284p<? super InterfaceC14686b0<? super E>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return m5165d(coroutineScope, coroutineContext, i, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, interfaceC15284p);
    }

    /* renamed from: f */
    public static /* synthetic */ InterfaceC14695d0 m5163f(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, InterfaceC15280l interfaceC15280l, InterfaceC15284p interfaceC15284p, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i3 = (i2 & 2) != 0 ? 0 : i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            interfaceC15280l = null;
        }
        return m5166c(coroutineScope, coroutineContext2, i3, coroutineStart2, interfaceC15280l, interfaceC15284p);
    }

    /* renamed from: g */
    public static /* synthetic */ InterfaceC14695d0 m5162g(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, InterfaceC15280l interfaceC15280l, InterfaceC15284p interfaceC15284p, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i3 = (i2 & 2) != 0 ? 0 : i;
        if ((i2 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i2 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 16) != 0) {
            interfaceC15280l = null;
        }
        return m5165d(coroutineScope, coroutineContext2, i3, bufferOverflow2, coroutineStart2, interfaceC15280l, interfaceC15284p);
    }

    /* renamed from: h */
    public static /* synthetic */ InterfaceC14695d0 m5161h(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, InterfaceC15284p interfaceC15284p, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m5164e(coroutineScope, coroutineContext, i, interfaceC15284p);
    }
}
