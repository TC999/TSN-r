package kotlinx.coroutines.channels;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.BuilderInference;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.f;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Broadcast.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\u009e\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042-\b\u0002\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112/\b\u0001\u0010\u0018\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013\u00a2\u0006\u0002\b\u0017\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"E", "Lkotlinx/coroutines/channels/d0;", "", "capacity", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlinx/coroutines/channels/j;", "b", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/b0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILkotlinx/coroutines/CoroutineStart;Ld2/l;Ld2/p;)Lkotlinx/coroutines/channels/j;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m {

    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(bv = {}, d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\t\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/n0$a", "Lkotlin/coroutines/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "handleException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends kotlin.coroutines.a implements CoroutineExceptionHandler {
        public a(f.c cVar) {
            super(cVar);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull kotlin.coroutines.f fVar, @NotNull Throwable th) {
        }
    }

    /* compiled from: Broadcast.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"E", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.l<Throwable, f1> {

        /* renamed from: a */
        final /* synthetic */ d0 f59452a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(d0 d0Var) {
            super(1);
            this.f59452a = d0Var;
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Throwable th) {
            invoke2(th);
            return f1.f55527a;
        }

        /* renamed from: invoke */
        public final void invoke2(@Nullable Throwable th) {
            r.r(this.f59452a, th);
        }
    }

    /* compiled from: Broadcast.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"E", "Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1, 1}, l = {51, 52}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast", "e"}, s = {"L$0", "L$0", "L$1"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<E> extends SuspendLambda implements d2.p<b0<? super E>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a */
        private b0 f59453a;

        /* renamed from: b */
        Object f59454b;

        /* renamed from: c */
        Object f59455c;

        /* renamed from: d */
        Object f59456d;

        /* renamed from: e */
        int f59457e;

        /* renamed from: f */
        final /* synthetic */ d0 f59458f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(d0 d0Var, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f59458f = d0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            c cVar2 = new c(this.f59458f, cVar);
            cVar2.f59453a = (b0) obj;
            return cVar2;
        }

        @Override // d2.p
        public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
            return ((c) create(obj, cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x0048 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x0055  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x006b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0068 -> B:36:0x003c). Please submit an issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.a.h()
                int r1 = r7.f59457e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L30
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r7.f59456d
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r4 = r7.f59454b
                kotlinx.coroutines.channels.b0 r4 = (kotlinx.coroutines.channels.b0) r4
                kotlin.d0.n(r8)
                r8 = r4
                goto L3b
            L1b:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L23:
                java.lang.Object r1 = r7.f59455c
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.p) r1
                java.lang.Object r4 = r7.f59454b
                kotlinx.coroutines.channels.b0 r4 = (kotlinx.coroutines.channels.b0) r4
                kotlin.d0.n(r8)
                r5 = r7
                goto L4d
            L30:
                kotlin.d0.n(r8)
                kotlinx.coroutines.channels.b0 r8 = r7.f59453a
                kotlinx.coroutines.channels.d0 r1 = r7.f59458f
                kotlinx.coroutines.channels.p r1 = r1.iterator()
            L3b:
                r4 = r7
            L3c:
                r4.f59454b = r8
                r4.f59455c = r1
                r4.f59457e = r3
                java.lang.Object r5 = r1.b(r4)
                if (r5 != r0) goto L49
                return r0
            L49:
                r6 = r4
                r4 = r8
                r8 = r5
                r5 = r6
            L4d:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 == 0) goto L6b
                java.lang.Object r8 = r1.next()
                r5.f59454b = r4
                r5.f59455c = r8
                r5.f59456d = r1
                r5.f59457e = r2
                java.lang.Object r8 = r4.O(r8, r5)
                if (r8 != r0) goto L68
                return r0
            L68:
                r8 = r4
                r4 = r5
                goto L3c
            L6b:
                kotlin.f1 r8 = kotlin.f1.f55527a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.m.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @NotNull
    public static final <E> j<E> a(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull CoroutineStart coroutineStart, @Nullable d2.l<? super Throwable, f1> lVar, @BuilderInference @NotNull d2.p<? super b0<? super E>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar) {
        l lVar2;
        kotlin.coroutines.f d4 = kotlinx.coroutines.k0.d(q0Var, fVar);
        j a4 = k.a(i4);
        if (coroutineStart.isLazy()) {
            lVar2 = new x(d4, a4, pVar);
        } else {
            lVar2 = new l(d4, a4, true);
        }
        if (lVar != null) {
            ((l2) lVar2).m(lVar);
        }
        ((kotlinx.coroutines.a) lVar2).r1(coroutineStart, lVar2, pVar);
        return lVar2;
    }

    @NotNull
    public static final <E> j<E> b(@NotNull d0<? extends E> d0Var, int i4, @NotNull CoroutineStart coroutineStart) {
        return c(r0.m(r0.m(w1.f60756a, kotlinx.coroutines.f1.g()), new a(CoroutineExceptionHandler.f59029h0)), null, i4, coroutineStart, new b(d0Var), new c(d0Var, null), 1, null);
    }

    public static /* synthetic */ j c(q0 q0Var, kotlin.coroutines.f fVar, int i4, CoroutineStart coroutineStart, d2.l lVar, d2.p pVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        kotlin.coroutines.f fVar2 = fVar;
        int i6 = (i5 & 2) != 0 ? 1 : i4;
        if ((i5 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i5 & 8) != 0) {
            lVar = null;
        }
        return a(q0Var, fVar2, i6, coroutineStart2, lVar, pVar);
    }

    public static /* synthetic */ j d(d0 d0Var, int i4, CoroutineStart coroutineStart, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = 1;
        }
        if ((i5 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return b(d0Var, i4, coroutineStart);
    }
}
