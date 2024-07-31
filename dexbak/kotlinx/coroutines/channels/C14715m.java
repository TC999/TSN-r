package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.AbstractC14266a;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.C15117k0;
import kotlinx.coroutines.C15125l2;
import kotlinx.coroutines.C15162r0;
import kotlinx.coroutines.C15247w1;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;
import p617l1.InterfaceC15284p;

/* compiled from: Broadcast.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u001a\u009e\u0001\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u0004\b\u0000\u0010\u0000*\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042-\b\u0002\u0010\u0012\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000bj\u0004\u0018\u0001`\u00112/\b\u0001\u0010\u0018\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0013¢\u0006\u0002\b\u0017ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/d0;", "", "capacity", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlinx/coroutines/channels/j;", "b", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "Lkotlinx/coroutines/CompletionHandler;", "onCompletion", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/b0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "a", "(Lkotlinx/coroutines/q0;Lkotlin/coroutines/f;ILkotlinx/coroutines/CoroutineStart;Ll1/l;Ll1/p;)Lkotlinx/coroutines/channels/j;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14715m {

    /* compiled from: CoroutineExceptionHandler.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\t¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/n0$a", "Lkotlin/coroutines/a;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "Lkotlin/coroutines/f;", "context", "", "exception", "Lkotlin/f1;", "handleException", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.m$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14716a extends AbstractC14266a implements CoroutineExceptionHandler {
        public C14716a(CoroutineContext.InterfaceC14277c interfaceC14277c) {
            super(interfaceC14277c);
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(@NotNull CoroutineContext coroutineContext, @NotNull Throwable th) {
        }
    }

    /* compiled from: Broadcast.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Throwable;)V", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.m$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14717b extends Lambda implements InterfaceC15280l<Throwable, Unit> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC14695d0 f42107a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14717b(InterfaceC14695d0 interfaceC14695d0) {
            super(1);
            this.f42107a = interfaceC14695d0;
        }

        @Override // p617l1.InterfaceC15280l
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.f41048a;
        }

        /* renamed from: invoke */
        public final void invoke2(@Nullable Throwable th) {
            C14729r.m5239r(this.f42107a, th);
        }
    }

    /* compiled from: Broadcast.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", m8638f = "Broadcast.kt", m8637i = {0, 1, 1}, m8636l = {51, 52}, m8635m = "invokeSuspend", m8634n = {"$this$broadcast", "$this$broadcast", "e"}, m8633s = {"L$0", "L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.channels.m$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14718c<E> extends SuspendLambda implements InterfaceC15284p<InterfaceC14686b0<? super E>, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private InterfaceC14686b0 f42108a;

        /* renamed from: b */
        Object f42109b;

        /* renamed from: c */
        Object f42110c;

        /* renamed from: d */
        Object f42111d;

        /* renamed from: e */
        int f42112e;

        /* renamed from: f */
        final /* synthetic */ InterfaceC14695d0 f42113f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14718c(InterfaceC14695d0 interfaceC14695d0, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42113f = interfaceC14695d0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14718c c14718c = new C14718c(this.f42113f, interfaceC14268c);
            c14718c.f42108a = (InterfaceC14686b0) obj;
            return c14718c;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14718c) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
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
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r7.f42112e
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L30
                if (r1 == r3) goto L23
                if (r1 != r2) goto L1b
                java.lang.Object r1 = r7.f42111d
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.InterfaceC14725p) r1
                java.lang.Object r4 = r7.f42109b
                kotlinx.coroutines.channels.b0 r4 = (kotlinx.coroutines.channels.InterfaceC14686b0) r4
                kotlin.C14294d0.m8596n(r8)
                r8 = r4
                goto L3b
            L1b:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L23:
                java.lang.Object r1 = r7.f42110c
                kotlinx.coroutines.channels.p r1 = (kotlinx.coroutines.channels.InterfaceC14725p) r1
                java.lang.Object r4 = r7.f42109b
                kotlinx.coroutines.channels.b0 r4 = (kotlinx.coroutines.channels.InterfaceC14686b0) r4
                kotlin.C14294d0.m8596n(r8)
                r5 = r7
                goto L4d
            L30:
                kotlin.C14294d0.m8596n(r8)
                kotlinx.coroutines.channels.b0 r8 = r7.f42108a
                kotlinx.coroutines.channels.d0 r1 = r7.f42113f
                kotlinx.coroutines.channels.p r1 = r1.iterator()
            L3b:
                r4 = r7
            L3c:
                r4.f42109b = r8
                r4.f42110c = r1
                r4.f42112e = r3
                java.lang.Object r5 = r1.mo5387b(r4)
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
                r5.f42109b = r4
                r5.f42110c = r8
                r5.f42111d = r1
                r5.f42112e = r2
                java.lang.Object r8 = r4.mo5177P(r8, r5)
                if (r8 != r0) goto L68
                return r0
            L68:
                r8 = r4
                r4 = r5
                goto L3c
            L6b:
                kotlin.f1 r8 = kotlin.Unit.f41048a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.C14715m.C14718c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @NotNull
    /* renamed from: a */
    public static final <E> BroadcastChannel<E> m5422a(@NotNull CoroutineScope coroutineScope, @NotNull CoroutineContext coroutineContext, int i, @NotNull CoroutineStart coroutineStart, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l, @Inference @NotNull InterfaceC15284p<? super InterfaceC14686b0<? super E>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        Broadcast broadcast;
        CoroutineContext m4086d = C15117k0.m4086d(coroutineScope, coroutineContext);
        BroadcastChannel m5432a = C14709k.m5432a(i);
        if (coroutineStart.isLazy()) {
            broadcast = new C14738x(m4086d, m5432a, interfaceC15284p);
        } else {
            broadcast = new Broadcast(m4086d, m5432a, true);
        }
        if (interfaceC15280l != null) {
            ((C15125l2) broadcast).mo3818w(interfaceC15280l);
        }
        ((AbstractCoroutine) broadcast).m5758q1(coroutineStart, broadcast, interfaceC15284p);
        return broadcast;
    }

    @NotNull
    /* renamed from: b */
    public static final <E> BroadcastChannel<E> m5421b(@NotNull InterfaceC14695d0<? extends E> interfaceC14695d0, int i, @NotNull CoroutineStart coroutineStart) {
        return m5420c(C15162r0.m3834m(C15162r0.m3834m(C15247w1.f43439a, Dispatchers.m5032g()), new C14716a(CoroutineExceptionHandler.f41684l0)), null, i, coroutineStart, new C14717b(interfaceC14695d0), new C14718c(interfaceC14695d0, null), 1, null);
    }

    /* renamed from: c */
    public static /* synthetic */ BroadcastChannel m5420c(CoroutineScope coroutineScope, CoroutineContext coroutineContext, int i, CoroutineStart coroutineStart, InterfaceC15280l interfaceC15280l, InterfaceC15284p interfaceC15284p, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        int i3 = (i2 & 2) != 0 ? 1 : i;
        if ((i2 & 4) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        CoroutineStart coroutineStart2 = coroutineStart;
        if ((i2 & 8) != 0) {
            interfaceC15280l = null;
        }
        return m5422a(coroutineScope, coroutineContext2, i3, coroutineStart2, interfaceC15280l, interfaceC15284p);
    }

    /* renamed from: d */
    public static /* synthetic */ BroadcastChannel m5419d(InterfaceC14695d0 interfaceC14695d0, int i, CoroutineStart coroutineStart, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return m5421b(interfaceC14695d0, i, coroutineStart);
    }
}
