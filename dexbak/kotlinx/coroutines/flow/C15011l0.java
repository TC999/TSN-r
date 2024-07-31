package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: Share.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BG\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u000f\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000b¢\u0006\u0002\b\u000eø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m12616d2 = {"Lkotlinx/coroutines/flow/l0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", DomainCampaignEx.LOOPBACK_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", CcgConstant.f38549t, "<init>", "(Lkotlinx/coroutines/flow/i;Ll1/p;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.l0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15011l0<T> implements FlowCollector<T> {

    /* renamed from: a */
    private final FlowCollector<T> f42877a;

    /* renamed from: b */
    private final InterfaceC15284p<FlowCollector<? super T>, InterfaceC14268c<? super Unit>, Object> f42878b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Share.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "onSubscription"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.SubscribedFlowCollector", m8638f = "Share.kt", m8637i = {0, 0, 1, 1}, m8636l = {407, TTAdConstant.IMAGE_CODE}, m8635m = "onSubscription", m8634n = {"this", "safeCollector", "this", "safeCollector"}, m8633s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.l0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15012a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42879a;

        /* renamed from: b */
        int f42880b;

        /* renamed from: d */
        Object f42882d;

        /* renamed from: e */
        Object f42883e;

        C15012a(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42879a = obj;
            this.f42880b |= Integer.MIN_VALUE;
            return C15011l0.this.m4559a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C15011l0(@NotNull FlowCollector<? super T> flowCollector, @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        this.f42877a = flowCollector;
        this.f42878b = interfaceC15284p;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0072  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m4559a(@org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.C15011l0.C15012a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.l0$a r0 = (kotlinx.coroutines.flow.C15011l0.C15012a) r0
            int r1 = r0.f42880b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42880b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.l0$a r0 = new kotlinx.coroutines.flow.l0$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f42879a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42880b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r1 = r0.f42883e
            kotlinx.coroutines.flow.internal.SafeCollector r1 = (kotlinx.coroutines.flow.internal.SafeCollector) r1
            java.lang.Object r0 = r0.f42882d
            kotlinx.coroutines.flow.l0 r0 = (kotlinx.coroutines.flow.C15011l0) r0
            kotlin.C14294d0.m8596n(r7)
            goto L81
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L3c:
            java.lang.Object r2 = r0.f42883e
            kotlinx.coroutines.flow.internal.SafeCollector r2 = (kotlinx.coroutines.flow.internal.SafeCollector) r2
            java.lang.Object r4 = r0.f42882d
            kotlinx.coroutines.flow.l0 r4 = (kotlinx.coroutines.flow.C15011l0) r4
            kotlin.C14294d0.m8596n(r7)     // Catch: java.lang.Throwable -> L48
            goto L69
        L48:
            r7 = move-exception
            goto L86
        L4a:
            kotlin.C14294d0.m8596n(r7)
            kotlinx.coroutines.flow.i<T> r7 = r6.f42877a
            kotlin.coroutines.f r2 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r5 = new kotlinx.coroutines.flow.internal.SafeCollector
            r5.<init>(r7, r2)
            l1.p<kotlinx.coroutines.flow.i<? super T>, kotlin.coroutines.c<? super kotlin.f1>, java.lang.Object> r7 = r6.f42878b     // Catch: java.lang.Throwable -> L84
            r0.f42882d = r6     // Catch: java.lang.Throwable -> L84
            r0.f42883e = r5     // Catch: java.lang.Throwable -> L84
            r0.f42880b = r4     // Catch: java.lang.Throwable -> L84
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L84
            if (r7 != r1) goto L67
            return r1
        L67:
            r4 = r6
            r2 = r5
        L69:
            r2.releaseIntercepted()
            kotlinx.coroutines.flow.i<T> r7 = r4.f42877a
            boolean r5 = r7 instanceof kotlinx.coroutines.flow.C15011l0
            if (r5 == 0) goto L81
            kotlinx.coroutines.flow.l0 r7 = (kotlinx.coroutines.flow.C15011l0) r7
            r0.f42882d = r4
            r0.f42883e = r2
            r0.f42880b = r3
            java.lang.Object r7 = r7.m4559a(r0)
            if (r7 != r1) goto L81
            return r1
        L81:
            kotlin.f1 r7 = kotlin.Unit.f41048a
            return r7
        L84:
            r7 = move-exception
            r2 = r5
        L86:
            r2.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C15011l0.m4559a(kotlin.coroutines.c):java.lang.Object");
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        return this.f42877a.emit(t, interfaceC14268c);
    }
}
