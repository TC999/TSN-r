package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: SafeCollector.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1<T> implements InterfaceC14958h<T> {

    /* renamed from: a */
    final /* synthetic */ InterfaceC14958h f42343a;

    /* renamed from: b */
    final /* synthetic */ InterfaceC15284p f42344b;

    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0096@¨\u0006\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1$collect$1", "collect"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", m8638f = "Emitters.kt", m8637i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m8636l = {116, 120}, m8635m = "collect", m8634n = {"this", "collector", "continuation", "$receiver", "safeCollector", "this", "collector", "continuation", "$receiver", "safeCollector"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C148031 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C148031(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this.mo4470e(null, this);
        }
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(InterfaceC14958h interfaceC14958h, InterfaceC15284p interfaceC15284p) {
        this.f42343a = interfaceC14958h;
        this.f42344b = interfaceC15284p;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a7 A[RETURN] */
    @Override // kotlinx.coroutines.flow.InterfaceC14958h
    @org.jetbrains.annotations.Nullable
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object mo4470e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.C148031
            if (r0 == 0) goto L13
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.C148031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L62
            if (r2 == r4) goto L48
            if (r2 != r3) goto L40
            java.lang.Object r8 = r0.L$4
            kotlinx.coroutines.flow.internal.SafeCollector r8 = (kotlinx.coroutines.flow.internal.SafeCollector) r8
            java.lang.Object r8 = r0.L$3
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r8 = r0.L$2
            kotlin.coroutines.c r8 = (kotlin.coroutines.InterfaceC14268c) r8
            java.lang.Object r8 = r0.L$1
            kotlinx.coroutines.flow.i r8 = (kotlinx.coroutines.flow.FlowCollector) r8
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r8 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r8
            kotlin.C14294d0.m8596n(r9)
            goto La8
        L40:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L48:
            java.lang.Object r8 = r0.L$4
            kotlinx.coroutines.flow.internal.SafeCollector r8 = (kotlinx.coroutines.flow.internal.SafeCollector) r8
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.flow.i r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r4 = r0.L$2
            kotlin.coroutines.c r4 = (kotlin.coroutines.InterfaceC14268c) r4
            java.lang.Object r5 = r0.L$1
            kotlinx.coroutines.flow.i r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            java.lang.Object r6 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r6 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r6
            kotlin.C14294d0.m8596n(r9)     // Catch: java.lang.Throwable -> L60
            goto L90
        L60:
            r9 = move-exception
            goto Lad
        L62:
            kotlin.C14294d0.m8596n(r9)
            kotlin.coroutines.f r9 = r0.getContext()
            kotlinx.coroutines.flow.internal.SafeCollector r2 = new kotlinx.coroutines.flow.internal.SafeCollector
            r2.<init>(r8, r9)
            l1.p r9 = r7.f42344b     // Catch: java.lang.Throwable -> Lab
            r0.L$0 = r7     // Catch: java.lang.Throwable -> Lab
            r0.L$1 = r8     // Catch: java.lang.Throwable -> Lab
            r0.L$2 = r0     // Catch: java.lang.Throwable -> Lab
            r0.L$3 = r8     // Catch: java.lang.Throwable -> Lab
            r0.L$4 = r2     // Catch: java.lang.Throwable -> Lab
            r0.label = r4     // Catch: java.lang.Throwable -> Lab
            r4 = 6
            kotlin.jvm.internal.InlineMarker.m8227e(r4)     // Catch: java.lang.Throwable -> Lab
            java.lang.Object r9 = r9.invoke(r2, r0)     // Catch: java.lang.Throwable -> Lab
            r4 = 7
            kotlin.jvm.internal.InlineMarker.m8227e(r4)     // Catch: java.lang.Throwable -> Lab
            if (r9 != r1) goto L8b
            return r1
        L8b:
            r6 = r7
            r5 = r8
            r4 = r0
            r8 = r2
            r2 = r5
        L90:
            r8.releaseIntercepted()
            kotlinx.coroutines.flow.h r9 = r6.f42343a
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r4
            r0.L$3 = r2
            r0.L$4 = r8
            r0.label = r3
            java.lang.Object r8 = r9.mo4470e(r2, r0)
            if (r8 != r1) goto La8
            return r1
        La8:
            kotlin.f1 r8 = kotlin.Unit.f41048a
            return r8
        Lab:
            r9 = move-exception
            r8 = r2
        Lad:
            r8.releaseIntercepted()
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.mo4470e(kotlinx.coroutines.flow.i, kotlin.coroutines.c):java.lang.Object");
    }
}
