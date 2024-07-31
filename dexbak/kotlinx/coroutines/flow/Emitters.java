package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.p518qq.p519e.comm.adevent.AdEventType;
import com.umeng.ccg.CcgConstant;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\u001au\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0005\u0010\f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\u0002\b\u000bH\u0086\bø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001au\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022D\b\u0005\u0010\f\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\u0002\b\u000bH\u0081\bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u000e\u001aU\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022-\u0010\u0011\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001al\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022D\u0010\u0011\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u000e\u001aU\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00022-\u0010\u0011\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0010¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0013\u001as\u0010\u0018\u001a\u00020\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042D\u0010\u0011\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0003¢\u0006\u0002\b\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/ParameterName;", "name", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", "transform", "e", "(Lkotlinx/coroutines/flow/h;Ll1/q;)Lkotlinx/coroutines/flow/h;", "f", "Lkotlin/Function2;", CcgConstant.f38549t, "d", "(Lkotlinx/coroutines/flow/h;Ll1/p;)Lkotlinx/coroutines/flow/h;", "", "cause", "b", "c", "a", "(Lkotlinx/coroutines/flow/i;Ll1/q;Ljava/lang/Throwable;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class Emitters {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Emitters.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\r\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012D\u0010\u000b\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0015\u0012\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0002¢\u0006\u0002\b\n2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "", "Lkotlin/ExtensionFunctionType;", CcgConstant.f38549t, "continuation", "invokeSafely"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", m8638f = "Emitters.kt", m8637i = {0, 0, 0}, m8636l = {AdEventType.VIDEO_CLICKED}, m8635m = "invokeSafely$FlowKt__EmittersKt", m8634n = {"$this$invokeSafely", CcgConstant.f38549t, "cause"}, m8633s = {"L$0", "L$1", "L$2"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14799a extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42332a;

        /* renamed from: b */
        int f42333b;

        /* renamed from: c */
        Object f42334c;

        /* renamed from: d */
        Object f42335d;

        /* renamed from: e */
        Object f42336e;

        C14799a(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42332a = obj;
            this.f42333b |= Integer.MIN_VALUE;
            return Emitters.m4999a(null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ <T> java.lang.Object m4999a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r4, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15285q<? super kotlinx.coroutines.flow.FlowCollector<? super T>, ? super java.lang.Throwable, ? super kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.Nullable java.lang.Throwable r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.Emitters.C14799a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__EmittersKt$a r0 = (kotlinx.coroutines.flow.Emitters.C14799a) r0
            int r1 = r0.f42333b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42333b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$a r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f42332a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42333b
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r4 = r0.f42336e
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r4 = r0.f42335d
            l1.q r4 = (p617l1.InterfaceC15285q) r4
            java.lang.Object r4 = r0.f42334c
            kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.C14294d0.m8596n(r7)     // Catch: java.lang.Throwable -> L53
            goto L50
        L36:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3e:
            kotlin.C14294d0.m8596n(r7)
            r0.f42334c = r4     // Catch: java.lang.Throwable -> L53
            r0.f42335d = r5     // Catch: java.lang.Throwable -> L53
            r0.f42336e = r6     // Catch: java.lang.Throwable -> L53
            r0.f42333b = r3     // Catch: java.lang.Throwable -> L53
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L53
            if (r4 != r1) goto L50
            return r1
        L50:
            kotlin.f1 r4 = kotlin.Unit.f41048a
            return r4
        L53:
            r4 = move-exception
            if (r6 == 0) goto L5b
            if (r6 == r4) goto L5b
            kotlin.Exceptions.m8551a(r4, r6)
        L5b:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Emitters.m4999a(kotlinx.coroutines.flow.i, l1.q, java.lang.Throwable, kotlin.coroutines.c):java.lang.Object");
    }

    @NotNull
    /* renamed from: b */
    public static final <T> InterfaceC14958h<T> m4998b(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15285q<? super FlowCollector<? super T>, ? super Throwable, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(interfaceC14958h, interfaceC15285q);
    }

    @NotNull
    /* renamed from: c */
    public static final <T> InterfaceC14958h<T> m4997c(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: d */
    public static final <T> InterfaceC14958h<T> m4996d(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(interfaceC14958h, interfaceC15284p);
    }

    @NotNull
    /* renamed from: e */
    public static final <T, R> InterfaceC14958h<R> m4995e(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15285q<? super FlowCollector<? super R>, ? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return C15006k.m4707N0(new FlowKt__EmittersKt$transform$1(interfaceC14958h, interfaceC15285q, null));
    }

    @PublishedApi
    @NotNull
    /* renamed from: f */
    public static final <T, R> InterfaceC14958h<R> m4994f(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15285q<? super FlowCollector<? super R>, ? super T, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15285q) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(interfaceC14958h, interfaceC15285q);
    }
}
