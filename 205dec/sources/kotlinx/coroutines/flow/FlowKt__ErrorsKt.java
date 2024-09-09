package kotlinx.coroutines.flow;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.e2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Errors.kt */
@Metadata(bv = {}, d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aj\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012B\u0010\f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0002\u00a2\u0006\u0002\b\u000b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u001aB\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0007\u001ae\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u001423\b\u0002\u0010\u0012\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0017\u0010\u0018\u001a>\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u00192\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010H\u0007\u001a\u007f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012W\u0010\u0012\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001b\u00a2\u0006\u0002\b\u000b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001e\u001a3\u0010 \u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!\u001a\u001b\u0010$\u001a\u00020\u0011*\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0002\u00a2\u0006\u0004\b$\u0010%\u001a\u001d\u0010'\u001a\u00020\u0011*\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002\u00a2\u0006\u0004\b'\u0010(*\\\b\u0007\u00104\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u00102\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110\u0010B6\b)\u0012\n\b*\u0012\u0006\b\n0+8,\u0012\b\b-\u0012\u0004\b\b(.\u0012\u001c\b/\u0012\u0018\b\u000bB\u0014\b0\u0012\u0006\b1\u0012\u0002\b\f\u0012\b\b2\u0012\u0004\b\b(3\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/i;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "action", "b", "(Lkotlinx/coroutines/flow/h;Ld2/q;)Lkotlinx/coroutines/flow/h;", "fallback", "Lkotlin/Function1;", "", "predicate", "f", "", "retries", "Lkotlin/Function2;", "i", "(Lkotlinx/coroutines/flow/h;JLd2/p;)Lkotlinx/coroutines/flow/h;", "", "h", "Lkotlin/Function4;", "attempt", "l", "(Lkotlinx/coroutines/flow/h;Ld2/r;)Lkotlinx/coroutines/flow/h;", "collector", "c", "(Lkotlinx/coroutines/flow/h;Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "coroutineContext", "d", "(Ljava/lang/Throwable;Lkotlin/coroutines/f;)Z", "other", "e", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)Z", "Lkotlin/Deprecated;", "level", "Lkotlin/DeprecationLevel;", "ERROR", "message", "Use (Throwable) -> Boolean functional type", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "(Throwable) -> Boolean", "ExceptionPredicate", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final /* synthetic */ class FlowKt__ErrorsKt {

    /* compiled from: Errors.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004H\u0080@"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "", "continuation", "", "catchImpl"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", i = {0, 0, 0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT}, m = "catchImpl", n = {"$this$catchImpl", "collector", "fromDownstream", "$this$collect$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f59702a;

        /* renamed from: b */
        int f59703b;

        /* renamed from: c */
        Object f59704c;

        /* renamed from: d */
        Object f59705d;

        /* renamed from: e */
        Object f59706e;

        /* renamed from: f */
        Object f59707f;

        a(kotlin.coroutines.c cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f59702a = obj;
            this.f59703b |= Integer.MIN_VALUE;
            return k.x(null, null, this);
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "it", "", "a", "(Ljava/lang/Throwable;)Z"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.l<Throwable, Boolean> {

        /* renamed from: a */
        public static final b f59708a = new b();

        b() {
            super(1);
        }

        public final boolean a(@NotNull Throwable th) {
            return true;
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(a(th));
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "", "e", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$onErrorCollect$2", f = "Errors.kt", i = {0, 0, 0, 0}, l = {227}, m = "invokeSuspend", n = {"$this$catch", "e", "$this$emitAll$iv", "flow$iv"}, s = {"L$0", "L$1", "L$2", "L$3"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends SuspendLambda implements d2.q<i<? super T>, Throwable, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a */
        private i f59709a;

        /* renamed from: b */
        private Throwable f59710b;

        /* renamed from: c */
        Object f59711c;

        /* renamed from: d */
        Object f59712d;

        /* renamed from: e */
        Object f59713e;

        /* renamed from: f */
        Object f59714f;

        /* renamed from: g */
        int f59715g;

        /* renamed from: h */
        final /* synthetic */ d2.l f59716h;

        /* renamed from: i */
        final /* synthetic */ h f59717i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(d2.l lVar, h hVar, kotlin.coroutines.c cVar) {
            super(3, cVar);
            this.f59716h = lVar;
            this.f59717i = hVar;
        }

        @NotNull
        public final kotlin.coroutines.c<f1> e(@NotNull i<? super T> iVar, @NotNull Throwable th, @NotNull kotlin.coroutines.c<? super f1> cVar) {
            c cVar2 = new c(this.f59716h, this.f59717i, cVar);
            cVar2.f59709a = iVar;
            cVar2.f59710b = th;
            return cVar2;
        }

        @Override // d2.q
        public final Object invoke(Object obj, Throwable th, kotlin.coroutines.c<? super f1> cVar) {
            return ((c) e((i) obj, th, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f59715g;
            if (i4 == 0) {
                kotlin.d0.n(obj);
                i<? super T> iVar = this.f59709a;
                Throwable th = this.f59710b;
                if (((Boolean) this.f59716h.invoke(th)).booleanValue()) {
                    h hVar = this.f59717i;
                    this.f59711c = iVar;
                    this.f59712d = th;
                    this.f59713e = iVar;
                    this.f59714f = hVar;
                    this.f59715g = 1;
                    if (hVar.e(iVar, this) == h4) {
                        return h4;
                    }
                } else {
                    throw th;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                h hVar2 = (h) this.f59714f;
                i iVar2 = (i) this.f59713e;
                Throwable th2 = (Throwable) this.f59712d;
                i iVar3 = (i) this.f59711c;
                kotlin.d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$1", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends SuspendLambda implements d2.p<Throwable, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a */
        private Throwable f59718a;

        /* renamed from: b */
        int f59719b;

        d(kotlin.coroutines.c cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            d dVar = new d(cVar);
            dVar.f59718a = (Throwable) obj;
            return dVar;
        }

        @Override // d2.p
        public final Object invoke(Throwable th, kotlin.coroutines.c<? super Boolean> cVar) {
            return ((d) create(th, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f59719b == 0) {
                kotlin.d0.n(obj);
                return kotlin.coroutines.jvm.internal.a.a(true);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {0, 0, 0}, l = {124}, m = "invokeSuspend", n = {"$this$retryWhen", "cause", "attempt"}, s = {"L$0", "L$1", "J$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e<T> extends SuspendLambda implements d2.r<i<? super T>, Throwable, Long, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a */
        private i f59720a;

        /* renamed from: b */
        private Throwable f59721b;

        /* renamed from: c */
        private long f59722c;

        /* renamed from: d */
        Object f59723d;

        /* renamed from: e */
        Object f59724e;

        /* renamed from: f */
        long f59725f;

        /* renamed from: g */
        int f59726g;

        /* renamed from: h */
        final /* synthetic */ long f59727h;

        /* renamed from: i */
        final /* synthetic */ d2.p f59728i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(long j4, d2.p pVar, kotlin.coroutines.c cVar) {
            super(4, cVar);
            this.f59727h = j4;
            this.f59728i = pVar;
        }

        @NotNull
        public final kotlin.coroutines.c<f1> e(@NotNull i<? super T> iVar, @NotNull Throwable th, long j4, @NotNull kotlin.coroutines.c<? super Boolean> cVar) {
            e eVar = new e(this.f59727h, this.f59728i, cVar);
            eVar.f59720a = iVar;
            eVar.f59721b = th;
            eVar.f59722c = j4;
            return eVar;
        }

        @Override // d2.r
        public final Object invoke(Object obj, Throwable th, Long l4, kotlin.coroutines.c<? super Boolean> cVar) {
            return ((e) e((i) obj, th, l4.longValue(), cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0045, code lost:
            if (((java.lang.Boolean) r9).booleanValue() != false) goto L8;
         */
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
                int r1 = r8.f59726g
                r2 = 1
                if (r1 == 0) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r8.f59724e
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                java.lang.Object r0 = r8.f59723d
                kotlinx.coroutines.flow.i r0 = (kotlinx.coroutines.flow.i) r0
                kotlin.d0.n(r9)
                goto L3f
            L17:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1f:
                kotlin.d0.n(r9)
                kotlinx.coroutines.flow.i r9 = r8.f59720a
                java.lang.Throwable r1 = r8.f59721b
                long r3 = r8.f59722c
                long r5 = r8.f59727h
                int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r7 >= 0) goto L48
                d2.p r5 = r8.f59728i
                r8.f59723d = r9
                r8.f59724e = r1
                r8.f59725f = r3
                r8.f59726g = r2
                java.lang.Object r9 = r5.invoke(r1, r8)
                if (r9 != r0) goto L3f
                return r0
            L3f:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto L48
                goto L49
            L48:
                r2 = 0
            L49:
                java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.a.a(r2)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "", "it", "", "a", "(Ljava/lang/Throwable;)Z"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f extends Lambda implements d2.l<Throwable, Boolean> {

        /* renamed from: a */
        public static final f f59729a = new f();

        f() {
            super(1);
        }

        public final boolean a(@NotNull Throwable th) {
            return true;
        }

        @Override // d2.l
        public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
            return Boolean.valueOf(a(th));
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\t\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u008a@\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"T", "Lkotlinx/coroutines/flow/i;", "", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", f = "Errors.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g<T> extends SuspendLambda implements d2.r<i<? super T>, Throwable, Long, kotlin.coroutines.c<? super Boolean>, Object> {

        /* renamed from: a */
        private i f59730a;

        /* renamed from: b */
        private Throwable f59731b;

        /* renamed from: c */
        private long f59732c;

        /* renamed from: d */
        int f59733d;

        /* renamed from: e */
        final /* synthetic */ int f59734e;

        /* renamed from: f */
        final /* synthetic */ d2.l f59735f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i4, d2.l lVar, kotlin.coroutines.c cVar) {
            super(4, cVar);
            this.f59734e = i4;
            this.f59735f = lVar;
        }

        @NotNull
        public final kotlin.coroutines.c<f1> e(@NotNull i<? super T> iVar, @NotNull Throwable th, long j4, @NotNull kotlin.coroutines.c<? super Boolean> cVar) {
            g gVar = new g(this.f59734e, this.f59735f, cVar);
            gVar.f59730a = iVar;
            gVar.f59731b = th;
            gVar.f59732c = j4;
            return gVar;
        }

        @Override // d2.r
        public final Object invoke(Object obj, Throwable th, Long l4, kotlin.coroutines.c<? super Boolean> cVar) {
            return ((g) e((i) obj, th, l4.longValue(), cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f59733d == 0) {
                kotlin.d0.n(obj);
                return kotlin.coroutines.jvm.internal.a.a(((Boolean) this.f59735f.invoke(this.f59731b)).booleanValue() && this.f59732c < ((long) this.f59734e));
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use (Throwable) -> Boolean functional type", replaceWith = @ReplaceWith(expression = "(Throwable) -> Boolean", imports = {}))
    public static /* synthetic */ void a() {
    }

    @NotNull
    public static final <T> h<T> b(@NotNull h<? extends T> hVar, @NotNull d2.q<? super i<? super T>, ? super Throwable, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar) {
        return new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(hVar, qVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0044  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object c(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.h<? extends T> r5, @org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.i<? super T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.c<? super java.lang.Throwable> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$a r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt.a) r0
            int r1 = r0.f59703b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f59703b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$a r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f59702a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.a.h()
            int r2 = r0.f59703b
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 != r4) goto L3c
            java.lang.Object r5 = r0.f59707f
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.h) r5
            java.lang.Object r5 = r0.f59706e
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r0.f59705d
            kotlinx.coroutines.flow.i r6 = (kotlinx.coroutines.flow.i) r6
            java.lang.Object r6 = r0.f59704c
            kotlinx.coroutines.flow.h r6 = (kotlinx.coroutines.flow.h) r6
            kotlin.d0.n(r7)     // Catch: java.lang.Throwable -> L3a
            goto L64
        L3a:
            r6 = move-exception
            goto L67
        L3c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L44:
            kotlin.d0.n(r7)
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r7.element = r3
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1 r2 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$$inlined$collect$1     // Catch: java.lang.Throwable -> L65
            r2.<init>(r6, r7)     // Catch: java.lang.Throwable -> L65
            r0.f59704c = r5     // Catch: java.lang.Throwable -> L65
            r0.f59705d = r6     // Catch: java.lang.Throwable -> L65
            r0.f59706e = r7     // Catch: java.lang.Throwable -> L65
            r0.f59707f = r5     // Catch: java.lang.Throwable -> L65
            r0.f59703b = r4     // Catch: java.lang.Throwable -> L65
            java.lang.Object r5 = r5.e(r2, r0)     // Catch: java.lang.Throwable -> L65
            if (r5 != r1) goto L64
            return r1
        L64:
            return r3
        L65:
            r6 = move-exception
            r5 = r7
        L67:
            T r5 = r5.element
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            boolean r5 = e(r6, r5)
            if (r5 != 0) goto L7c
            kotlin.coroutines.f r5 = r0.getContext()
            boolean r5 = d(r6, r5)
            if (r5 != 0) goto L7c
            return r6
        L7c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt.c(kotlinx.coroutines.flow.h, kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }

    private static final boolean d(Throwable th, kotlin.coroutines.f fVar) {
        e2 e2Var = (e2) fVar.get(e2.f59626i0);
        if (e2Var == null || !e2Var.isCancelled()) {
            return false;
        }
        return e(th, e2Var.l());
    }

    private static final boolean e(Throwable th, Throwable th2) {
        return th2 != null && kotlin.jvm.internal.f0.g(th2, th);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emitAll(fallback) else throw e }", imports = {}))
    @NotNull
    public static final <T> h<T> f(@NotNull h<? extends T> hVar, @NotNull h<? extends T> hVar2, @NotNull d2.l<? super Throwable, Boolean> lVar) {
        return k.w(hVar, new c(lVar, hVar2, null));
    }

    public static /* synthetic */ h g(h hVar, h hVar2, d2.l lVar, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            lVar = b.f59708a;
        }
        return k.o1(hVar, hVar2, lVar);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "binary compatibility with retries: Int preview version")
    @FlowPreview
    @NotNull
    public static final /* synthetic */ <T> h<T> h(@NotNull h<? extends T> hVar, int i4, @NotNull d2.l<? super Throwable, Boolean> lVar) {
        if (i4 > 0) {
            return k.J1(hVar, new g(i4, lVar, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + i4).toString());
    }

    @NotNull
    public static final <T> h<T> i(@NotNull h<? extends T> hVar, long j4, @NotNull d2.p<? super Throwable, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> pVar) {
        if (j4 > 0) {
            return k.J1(hVar, new e(j4, pVar, null));
        }
        throw new IllegalArgumentException(("Expected positive amount of retries, but had " + j4).toString());
    }

    public static /* synthetic */ h j(h hVar, int i4, d2.l lVar, int i5, Object obj) {
        h h4;
        if ((i5 & 1) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        if ((i5 & 2) != 0) {
            lVar = f.f59729a;
        }
        h4 = h(hVar, i4, lVar);
        return h4;
    }

    public static /* synthetic */ h k(h hVar, long j4, d2.p pVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = Long.MAX_VALUE;
        }
        if ((i4 & 2) != 0) {
            pVar = new d(null);
        }
        return k.G1(hVar, j4, pVar);
    }

    @NotNull
    public static final <T> h<T> l(@NotNull h<? extends T> hVar, @NotNull d2.r<? super i<? super T>, ? super Throwable, ? super Long, ? super kotlin.coroutines.c<? super Boolean>, ? extends Object> rVar) {
        return new FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(hVar, rVar);
    }
}
