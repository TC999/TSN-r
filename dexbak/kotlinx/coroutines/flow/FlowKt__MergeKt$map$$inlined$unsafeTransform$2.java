package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__MergeKt$map$$inlined$unsafeTransform$2<R> implements InterfaceC14958h<R> {

    /* renamed from: a */
    final /* synthetic */ InterfaceC14958h f42447a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC15284p f42448b;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Collect.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C148392<T> implements FlowCollector<T> {

        /* renamed from: a */
        final /* synthetic */ FlowCollector f42449a;

        /* renamed from: b */
        final /* synthetic */ FlowKt__MergeKt$map$$inlined$unsafeTransform$2 f42450b;

        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0096@¨\u0006\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1$1", "emit"}, m12615k = 3, m12614mv = {1, 4, 0})
        @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2", m8638f = "Transform.kt", m8637i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, m8636l = {TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE}, m8635m = "emit", m8634n = {"this", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "$receiver", "this", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "continuation", DomainCampaignEx.LOOPBACK_VALUE, "$receiver"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C148401 extends ContinuationImpl {
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            Object L$6;
            Object L$7;
            int label;
            /* synthetic */ Object result;

            public C148401(InterfaceC14268c interfaceC14268c) {
                super(interfaceC14268c);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return C148392.this.emit(null, this);
            }
        }

        public C148392(FlowCollector flowCollector, FlowKt__MergeKt$map$$inlined$unsafeTransform$2 flowKt__MergeKt$map$$inlined$unsafeTransform$2) {
            this.f42449a = flowCollector;
            this.f42450b = flowKt__MergeKt$map$$inlined$unsafeTransform$2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Nullable
        /* renamed from: a */
        public Object m4948a(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
            InlineMarker.m8227e(4);
            new C148401(interfaceC14268c);
            InlineMarker.m8227e(5);
            FlowCollector flowCollector = this.f42449a;
            Object invoke = this.f42450b.f42448b.invoke(obj, interfaceC14268c);
            InlineMarker.m8227e(0);
            Object emit = flowCollector.emit(invoke, interfaceC14268c);
            InlineMarker.m8227e(2);
            InlineMarker.m8227e(1);
            return emit;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0063  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00a4 A[RETURN] */
        @Override // kotlinx.coroutines.flow.FlowCollector
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Object emit(java.lang.Object r11, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c r12) {
            /*
                r10 = this;
                boolean r0 = r12 instanceof kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.C148392.C148401
                if (r0 == 0) goto L13
                r0 = r12
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.C148392.C148401) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1
                r0.<init>(r12)
            L18:
                java.lang.Object r12 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L63
                if (r2 == r4) goto L45
                if (r2 != r3) goto L3d
                java.lang.Object r11 = r0.L$6
                kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                java.lang.Object r11 = r0.L$4
                kotlin.coroutines.c r11 = (kotlin.coroutines.InterfaceC14268c) r11
                java.lang.Object r11 = r0.L$2
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.C148392.C148401) r11
                java.lang.Object r11 = r0.L$0
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2 r11 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.C148392) r11
                kotlin.C14294d0.m8596n(r12)
                goto La5
            L3d:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L45:
                java.lang.Object r11 = r0.L$7
                kotlinx.coroutines.flow.i r11 = (kotlinx.coroutines.flow.FlowCollector) r11
                java.lang.Object r2 = r0.L$6
                kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                java.lang.Object r4 = r0.L$5
                java.lang.Object r5 = r0.L$4
                kotlin.coroutines.c r5 = (kotlin.coroutines.InterfaceC14268c) r5
                java.lang.Object r6 = r0.L$3
                java.lang.Object r7 = r0.L$2
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2$1 r7 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.C148392.C148401) r7
                java.lang.Object r8 = r0.L$1
                java.lang.Object r9 = r0.L$0
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2$2 r9 = (kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.C148392) r9
                kotlin.C14294d0.m8596n(r12)
                goto L8e
            L63:
                kotlin.C14294d0.m8596n(r12)
                kotlinx.coroutines.flow.i r12 = r10.f42449a
                kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2 r2 = r10.f42450b
                l1.p r2 = r2.f42448b
                r0.L$0 = r10
                r0.L$1 = r11
                r0.L$2 = r0
                r0.L$3 = r11
                r0.L$4 = r0
                r0.L$5 = r11
                r0.L$6 = r12
                r0.L$7 = r12
                r0.label = r4
                java.lang.Object r2 = r2.invoke(r11, r0)
                if (r2 != r1) goto L85
                return r1
            L85:
                r9 = r10
                r4 = r11
                r6 = r4
                r8 = r6
                r11 = r12
                r5 = r0
                r7 = r5
                r12 = r2
                r2 = r11
            L8e:
                r0.L$0 = r9
                r0.L$1 = r8
                r0.L$2 = r7
                r0.L$3 = r6
                r0.L$4 = r5
                r0.L$5 = r4
                r0.L$6 = r2
                r0.label = r3
                java.lang.Object r11 = r11.emit(r12, r0)
                if (r11 != r1) goto La5
                return r1
            La5:
                kotlin.f1 r11 = kotlin.Unit.f41048a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.C148392.emit(java.lang.Object, kotlin.coroutines.c):java.lang.Object");
        }
    }

    public FlowKt__MergeKt$map$$inlined$unsafeTransform$2(InterfaceC14958h interfaceC14958h, InterfaceC15284p interfaceC15284p) {
        this.f42447a = interfaceC14958h;
        this.f42448b = interfaceC15284p;
    }

    @Override // kotlinx.coroutines.flow.InterfaceC14958h
    @Nullable
    /* renamed from: e */
    public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
        Object m8642h;
        Object mo4470e = this.f42447a.mo4470e(new C148392(flowCollector, this), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return mo4470e == m8642h ? mo4470e : Unit.f41048a;
    }

    @Nullable
    /* renamed from: f */
    public Object m4949f(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(4);
        new ContinuationImpl(interfaceC14268c) { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$map$$inlined$unsafeTransform$2.1
            int label;
            /* synthetic */ Object result;

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return FlowKt__MergeKt$map$$inlined$unsafeTransform$2.this.mo4470e(null, this);
            }
        };
        InlineMarker.m8227e(5);
        InterfaceC14958h interfaceC14958h = this.f42447a;
        C148392 c148392 = new C148392(flowCollector, this);
        InlineMarker.m8227e(0);
        interfaceC14958h.mo4470e(c148392, interfaceC14268c);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        return Unit.f41048a;
    }
}
