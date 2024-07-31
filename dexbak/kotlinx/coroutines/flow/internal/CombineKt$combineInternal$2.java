package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.InterfaceC14704h0;
import kotlinx.coroutines.channels.InterfaceC14722n;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.InterfaceC14958h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Combine.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", m8638f = "Combine.kt", m8637i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, m8636l = {57, 79, 82}, m8635m = "invokeSuspend", m8634n = {"$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "element", "results", "$this$flowScope", "size", "latestValues", "resultChannel", "nonClosed", "remainingAbsentValues", "lastReceivedEpoch", "currentEpoch", "element", "results"}, m8633s = {"L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "B$0", "L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "I$2", "L$5", "L$6", "L$0", "I$0", "L$1", "L$2", "L$3", "I$1", "L$4", "I$2", "L$5", "L$6"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CombineKt$combineInternal$2 extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

    /* renamed from: a */
    private CoroutineScope f42780a;

    /* renamed from: b */
    Object f42781b;

    /* renamed from: c */
    Object f42782c;

    /* renamed from: d */
    Object f42783d;

    /* renamed from: e */
    Object f42784e;

    /* renamed from: f */
    Object f42785f;

    /* renamed from: g */
    Object f42786g;

    /* renamed from: h */
    Object f42787h;

    /* renamed from: i */
    int f42788i;

    /* renamed from: j */
    int f42789j;

    /* renamed from: k */
    int f42790k;

    /* renamed from: l */
    byte f42791l;

    /* renamed from: m */
    int f42792m;

    /* renamed from: n */
    final /* synthetic */ FlowCollector f42793n;

    /* renamed from: o */
    final /* synthetic */ InterfaceC14958h[] f42794o;

    /* renamed from: p */
    final /* synthetic */ InterfaceC15269a f42795p;

    /* renamed from: q */
    final /* synthetic */ InterfaceC15285q f42796q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Combine.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", m8638f = "Combine.kt", m8637i = {0, 0}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION}, m8635m = "invokeSuspend", m8634n = {"$this$launch", "$this$collect$iv"}, m8633s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C149751 extends SuspendLambda implements InterfaceC15284p<CoroutineScope, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private CoroutineScope f42797a;

        /* renamed from: b */
        Object f42798b;

        /* renamed from: c */
        Object f42799c;

        /* renamed from: d */
        int f42800d;

        /* renamed from: f */
        final /* synthetic */ int f42802f;

        /* renamed from: g */
        final /* synthetic */ InterfaceC14722n f42803g;

        /* renamed from: h */
        final /* synthetic */ AtomicInteger f42804h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C149751(int i, InterfaceC14722n interfaceC14722n, AtomicInteger atomicInteger, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42802f = i;
            this.f42803g = interfaceC14722n;
            this.f42804h = atomicInteger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C149751 c149751 = new C149751(this.f42802f, this.f42803g, this.f42804h, interfaceC14268c);
            c149751.f42797a = (CoroutineScope) obj;
            return c149751;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C149751) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            AtomicInteger atomicInteger;
            m8642h = C14287b.m8642h();
            int i = this.f42800d;
            try {
                if (i == 0) {
                    C14294d0.m8596n(obj);
                    CoroutineScope coroutineScope = this.f42797a;
                    InterfaceC14958h interfaceC14958h = CombineKt$combineInternal$2.this.f42794o[this.f42802f];
                    CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1 = new CombineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1(this);
                    this.f42798b = coroutineScope;
                    this.f42799c = interfaceC14958h;
                    this.f42800d = 1;
                    if (interfaceC14958h.mo4470e(combineKt$combineInternal$2$1$invokeSuspend$$inlined$collect$1, this) == m8642h) {
                        return m8642h;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    InterfaceC14958h interfaceC14958h2 = (InterfaceC14958h) this.f42799c;
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.f42798b;
                    C14294d0.m8596n(obj);
                }
                if (atomicInteger.decrementAndGet() == 0) {
                    InterfaceC14704h0.C14705a.m5442a(this.f42803g, null, 1, null);
                }
                return Unit.f41048a;
            } finally {
                if (this.f42804h.decrementAndGet() == 0) {
                    InterfaceC14704h0.C14705a.m5442a(this.f42803g, null, 1, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2(FlowCollector flowCollector, InterfaceC14958h[] interfaceC14958hArr, InterfaceC15269a interfaceC15269a, InterfaceC15285q interfaceC15285q, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.f42793n = flowCollector;
        this.f42794o = interfaceC14958hArr;
        this.f42795p = interfaceC15269a;
        this.f42796q = interfaceC15285q;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.f42793n, this.f42794o, this.f42795p, this.f42796q, interfaceC14268c);
        combineKt$combineInternal$2.f42780a = (CoroutineScope) obj;
        return combineKt$combineInternal$2;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(CoroutineScope coroutineScope, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012b A[LOOP:0: B:26:0x012b->B:34:0x014c, LOOP_START, PHI: r2 r5 
      PHI: (r2v6 int) = (r2v5 int), (r2v7 int) binds: [B:25:0x0129, B:34:0x014c] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r5v8 kotlin.collections.n0) = (r5v7 kotlin.collections.n0), (r5v12 kotlin.collections.n0) binds: [B:25:0x0129, B:34:0x014c] A[DONT_GENERATE, DONT_INLINE]] */
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
