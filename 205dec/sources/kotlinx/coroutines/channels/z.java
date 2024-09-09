package kotlinx.coroutines.channels;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Produce.kt */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a+\u0010\u0004\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001ag\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f\u00a2\u0006\u0002\b\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012\u001a\u00a0\u0001\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u00132-\b\u0002\u0010\u001b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\u0004\u0018\u0001`\u001a2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f\u00a2\u0006\u0002\b\u000fH\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001d\u001a\u00aa\u0001\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0010\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010\u0014\u001a\u00020\u00132-\b\u0002\u0010\u001b\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0016\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015j\u0004\u0018\u0001`\u001a2/\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f\u00a2\u0006\u0002\b\u000fH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lkotlinx/coroutines/channels/b0;", "Lkotlin/Function0;", "Lkotlin/f1;", "block", "a", "(Lkotlinx/coroutines/channels/b0;Ld2/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "E", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "Lkotlinx/coroutines/channels/d0;", "c", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILd2/p;)Lkotlinx/coroutines/channels/d0;", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "d", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILkotlinx/coroutines/CoroutineStart;Ld2/l;Ld2/p;)Lkotlinx/coroutines/channels/d0;", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "e", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlinx/coroutines/CoroutineStart;Ld2/l;Ld2/p;)Lkotlinx/coroutines/channels/d0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z {

    /* compiled from: Produce.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u0006\u0012\u0002\b\u00030\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0087@"}, d2 = {"Lkotlinx/coroutines/channels/b0;", "Lkotlin/Function0;", "Lkotlin/f1;", "block", "Lkotlin/coroutines/c;", "continuation", "", "awaitClose"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.channels.ProduceKt", f = "Produce.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME}, m = "awaitClose", n = {"$this$awaitClose", "block"}, s = {"L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f59505a;

        /* renamed from: b */
        int f59506b;

        /* renamed from: c */
        Object f59507c;

        /* renamed from: d */
        Object f59508d;

        a(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59505a = obj;
            this.f59506b |= Integer.MIN_VALUE;
            return z.a(null, null, this);
        }
    }

    /* compiled from: Produce.kt */
    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/f1;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.a<f1> {

        /* renamed from: a */
        public static final b f59509a = new b();

        b() {
            super(0);
        }

        @Override // d2.a
        public /* bridge */ /* synthetic */ f1 invoke() {
            invoke2();
            return f1.f55527a;
        }

        /* renamed from: invoke */
        public final void invoke2() {
        }
    }

    /* compiled from: Produce.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<Throwable, f1> {

        /* renamed from: a */
        final /* synthetic */ kotlinx.coroutines.o f59510a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(kotlinx.coroutines.o oVar) {
            super(1);
            this.f59510a = oVar;
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
            invoke2(th);
            return f1.f55527a;
        }

        /* renamed from: invoke */
        public final void invoke2(@Nullable Throwable th) {
            kotlinx.coroutines.o oVar = this.f59510a;
            f1 f1Var = f1.f55527a;
            Result.a aVar = Result.Companion;
            oVar.resumeWith(Result.m119constructorimpl(f1Var));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x003c  */
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.b0<?> r4, @org.jetbrains.annotations.NotNull d2.a<kotlin.f1> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super kotlin.f1> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.channels.z.a
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.channels.z$a r0 = (kotlinx.coroutines.channels.z.a) r0
            int r1 = r0.f59506b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59506b = r1
            goto L18
        L13:
            kotlinx.coroutines.channels.z$a r0 = new kotlinx.coroutines.channels.z$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f59505a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59506b
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.f59508d
            r5 = r4
            d2.a r5 = (d2.a) r5
            java.lang.Object r4 = r0.f59507c
            kotlinx.coroutines.channels.b0 r4 = (kotlinx.coroutines.channels.b0) r4
            kotlin.d0.n(r6)     // Catch: java.lang.Throwable -> L32
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
            kotlin.d0.n(r6)
            kotlin.coroutines.f r6 = r0.getContext()
            kotlinx.coroutines.e2$b r2 = kotlinx.coroutines.e2.f59626i0
            kotlin.coroutines.f$b r6 = r6.get(r2)
            kotlinx.coroutines.e2 r6 = (kotlinx.coroutines.e2) r6
            if (r6 != r4) goto L4f
            r6 = 1
            goto L50
        L4f:
            r6 = 0
        L50:
            if (r6 == 0) goto L86
            r0.f59507c = r4     // Catch: java.lang.Throwable -> L32
            r0.f59508d = r5     // Catch: java.lang.Throwable -> L32
            r0.f59506b = r3     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.p r6 = new kotlinx.coroutines.p     // Catch: java.lang.Throwable -> L32
            kotlin.coroutines.c r2 = kotlin.coroutines.intrinsics.a.d(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.H()     // Catch: java.lang.Throwable -> L32
            kotlinx.coroutines.channels.z$c r2 = new kotlinx.coroutines.channels.z$c     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.f(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.y()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = kotlin.coroutines.intrinsics.a.h()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L79
            kotlin.coroutines.jvm.internal.e.c(r0)     // Catch: java.lang.Throwable -> L32
        L79:
            if (r4 != r1) goto L7c
            return r1
        L7c:
            r5.invoke()
            kotlin.f1 r4 = kotlin.f1.f55527a
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
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.z.a(kotlinx.coroutines.channels.b0, d2.a, kotlin.coroutines.c):java.lang.Object");
    }

    public static /* synthetic */ Object b(b0 b0Var, d2.a aVar, kotlin.coroutines.c cVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            aVar = b.f59509a;
        }
        return a(b0Var, aVar, cVar);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <E> d0<E> c(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar, int i4, @BuilderInference @NotNull d2.p<? super b0<? super E>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return e(q0Var, fVar, i4, BufferOverflow.SUSPEND, CoroutineStart.DEFAULT, null, pVar);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final <E> d0<E> d(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull CoroutineStart coroutineStart, @Nullable d2.l<? super Throwable, f1> lVar, @BuilderInference @NotNull d2.p<? super b0<? super E>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        return e(q0Var, fVar, i4, BufferOverflow.SUSPEND, coroutineStart, lVar, pVar);
    }

    @NotNull
    public static final <E> d0<E> e(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow, @NotNull CoroutineStart coroutineStart, @Nullable d2.l<? super Throwable, f1> lVar, @BuilderInference @NotNull d2.p<? super b0<? super E>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        a0 a0Var = new a0(kotlinx.coroutines.k0.d(q0Var, fVar), q.d(i4, bufferOverflow, null, 4, null));
        if (lVar != null) {
            a0Var.m(lVar);
        }
        a0Var.r1(coroutineStart, a0Var, pVar);
        return a0Var;
    }

    public static /* synthetic */ d0 f(q0 q0Var, kotlin.coroutines.f fVar, int i4, d2.p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return c(q0Var, fVar, i4, pVar);
    }

    public static /* synthetic */ d0 g(q0 q0Var, kotlin.coroutines.f fVar, int i4, CoroutineStart coroutineStart, d2.l lVar, d2.p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        kotlin.coroutines.f fVar2 = fVar;
        int i6 = (i5 & 2) != 0 ? 0 : i4;
        if ((i5 & 4) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i5 & 8) != 0) {
            lVar = null;
        }
        return d(q0Var, fVar2, i6, coroutineStart2, lVar, pVar);
    }

    public static /* synthetic */ d0 h(q0 q0Var, kotlin.coroutines.f fVar, int i4, BufferOverflow bufferOverflow, CoroutineStart coroutineStart, d2.l lVar, d2.p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        kotlin.coroutines.f fVar2 = fVar;
        int i6 = (i5 & 2) != 0 ? 0 : i4;
        if ((i5 & 4) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        BufferOverflow bufferOverflow2 = bufferOverflow;
        if ((i5 & 8) != 0) {
            coroutineStart = CoroutineStart.DEFAULT;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i5 & 16) != 0) {
            lVar = null;
        }
        return e(q0Var, fVar2, i6, bufferOverflow2, coroutineStart2, lVar, pVar);
    }
}
