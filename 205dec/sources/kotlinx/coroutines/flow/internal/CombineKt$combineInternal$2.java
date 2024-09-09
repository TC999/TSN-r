package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlinx.coroutines.channels.h0;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Combine.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "T", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {57, 79, 82}, m = "invokeSuspend", n = {"$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "element", "results", "$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "element", "results"}, s = {"L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "B$0", "L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "I$2", "L$5", "L$6", "L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "I$2", "L$5", "L$6"})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

    /* renamed from: a  reason: collision with root package name */
    private q0 f60097a;

    /* renamed from: b  reason: collision with root package name */
    Object f60098b;

    /* renamed from: c  reason: collision with root package name */
    Object f60099c;

    /* renamed from: d  reason: collision with root package name */
    Object f60100d;

    /* renamed from: e  reason: collision with root package name */
    Object f60101e;

    /* renamed from: f  reason: collision with root package name */
    Object f60102f;

    /* renamed from: g  reason: collision with root package name */
    Object f60103g;

    /* renamed from: h  reason: collision with root package name */
    Object f60104h;

    /* renamed from: i  reason: collision with root package name */
    int f60105i;

    /* renamed from: j  reason: collision with root package name */
    int f60106j;

    /* renamed from: k  reason: collision with root package name */
    int f60107k;

    /* renamed from: l  reason: collision with root package name */
    byte f60108l;

    /* renamed from: m  reason: collision with root package name */
    int f60109m;

    /* renamed from: n  reason: collision with root package name */
    final /* synthetic */ kotlinx.coroutines.flow.i f60110n;

    /* renamed from: o  reason: collision with root package name */
    final /* synthetic */ kotlinx.coroutines.flow.h[] f60111o;

    /* renamed from: p  reason: collision with root package name */
    final /* synthetic */ d2.a f60112p;

    /* renamed from: q  reason: collision with root package name */
    final /* synthetic */ d2.q f60113q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Combine.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"R", "T", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$launch", "$this$collect$iv"}, s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private q0 f60114a;

        /* renamed from: b  reason: collision with root package name */
        Object f60115b;

        /* renamed from: c  reason: collision with root package name */
        Object f60116c;

        /* renamed from: d  reason: collision with root package name */
        int f60117d;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ int f60119f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.n f60120g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f60121h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i4, kotlinx.coroutines.channels.n nVar, AtomicInteger atomicInteger, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f60119f = i4;
            this.f60120g = nVar;
            this.f60121h = atomicInteger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f60119f, this.f60120g, this.f60121h, cVar);
            anonymousClass1.f60114a = (q0) obj;
            return anonymousClass1;
        }

        @Override // d2.p
        public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
            return ((AnonymousClass1) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            AtomicInteger atomicInteger;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f60117d;
            try {
                if (i4 == 0) {
                    d0.n(obj);
                    q0 q0Var = this.f60114a;
                    kotlinx.coroutines.flow.h hVar = CombineKt$combineInternal$2.this.f60111o[this.f60119f];
                    CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 = new CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(this);
                    this.f60115b = q0Var;
                    this.f60116c = hVar;
                    this.f60117d = 1;
                    if (hVar.e(combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1, this) == h4) {
                        return h4;
                    }
                } else if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    kotlinx.coroutines.flow.h hVar2 = (kotlinx.coroutines.flow.h) this.f60116c;
                    q0 q0Var2 = (q0) this.f60115b;
                    d0.n(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    h0.a.a(this.f60120g, null, 1, null);
                }
                return f1.f55527a;
            } finally {
                if (this.f60121h.decrementAndGet() == 0) {
                    h0.a.a(this.f60120g, null, 1, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(kotlinx.coroutines.flow.i iVar, kotlinx.coroutines.flow.h[] hVarArr, d2.a aVar, d2.q qVar, kotlin.coroutines.c cVar) {
        super(2, cVar);
        this.f60110n = iVar;
        this.f60111o = hVarArr;
        this.f60112p = aVar;
        this.f60113q = qVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.f60110n, this.f60111o, this.f60112p, this.f60113q, cVar);
        combineKt$combineInternal$2.f60097a = (q0) obj;
        return combineKt$combineInternal$2;
    }

    @Override // d2.p
    public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
        return ((CombineKt$combineInternal$2) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012b A[LOOP:0: B:26:0x012b->B:34:0x014c, LOOP_START, PHI: r2 r5 
      PHI: (r2v6 int) = (r2v5 int), (r2v7 int) binds: [B:25:0x0129, B:34:0x014c] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r5v8 kotlin.collections.o0) = (r5v7 kotlin.collections.o0), (r5v12 kotlin.collections.o0) binds: [B:25:0x0129, B:34:0x014c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01c9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0181 -> B:49:0x01c5). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x01b7 -> B:46:0x01ba). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01c2 -> B:48:0x01c3). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 460
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
