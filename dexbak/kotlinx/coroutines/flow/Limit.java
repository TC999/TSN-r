package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.internal.C14994m;
import kotlinx.coroutines.flow.internal.FlowExceptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a$\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002\u001a+\u0010\u0010\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001aJ\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u000b\u001at\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0013*\b\u0012\u0004\u0012\u00028\u00000\u00012D\b\u0001\u0010\u0018\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\r\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0014¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aX\u0010\u001b\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000123\b\u0004\u0010\t\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0080Hø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "", "count", "c", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "d", "(Lkotlinx/coroutines/flow/h;Ll1/p;)Lkotlinx/coroutines/flow/h;", "f", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "g", "R", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "transform", "h", "(Lkotlinx/coroutines/flow/h;Ll1/q;)Lkotlinx/coroutines/flow/h;", "a", "(Lkotlinx/coroutines/flow/h;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class Limit {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14818a<T> implements InterfaceC14958h<T> {

        /* renamed from: a */
        final /* synthetic */ InterfaceC14958h f42392a;

        /* renamed from: b */
        final /* synthetic */ int f42393b;

        /* compiled from: Collect.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__LimitKt$$special$$inlined$collect$1"}, m12615k = 1, m12614mv = {1, 4, 0})
        /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14819a implements FlowCollector<T> {

            /* renamed from: a */
            final /* synthetic */ FlowCollector f42394a;

            /* renamed from: b */
            final /* synthetic */ Ref.IntRef f42395b;

            /* renamed from: c */
            final /* synthetic */ C14818a f42396c;

            public C14819a(FlowCollector flowCollector, Ref.IntRef intRef, C14818a c14818a) {
                this.f42394a = flowCollector;
                this.f42395b = intRef;
                this.f42396c = c14818a;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            @Nullable
            public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
                Object m8642h;
                Ref.IntRef intRef = this.f42395b;
                int i = intRef.element;
                if (i >= this.f42396c.f42393b) {
                    Object emit = this.f42394a.emit(obj, interfaceC14268c);
                    m8642h = C14287b.m8642h();
                    if (emit == m8642h) {
                        return emit;
                    }
                } else {
                    intRef.element = i + 1;
                }
                return Unit.f41048a;
            }
        }

        public C14818a(InterfaceC14958h interfaceC14958h, int i) {
            this.f42392a = interfaceC14958h;
            this.f42393b = i;
        }

        @Override // kotlinx.coroutines.flow.InterfaceC14958h
        @Nullable
        /* renamed from: e */
        public Object mo4470e(@NotNull FlowCollector flowCollector, @NotNull InterfaceC14268c interfaceC14268c) {
            Object m8642h;
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = 0;
            Object mo4470e = this.f42392a.mo4470e(new C14819a(flowCollector, intRef, this), interfaceC14268c);
            m8642h = C14287b.m8642h();
            return mo4470e == m8642h ? mo4470e : Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Limit.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0007\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u00002\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0082@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/coroutines/c;", "Lkotlin/f1;", "continuation", "", "emitAbort"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__LimitKt", m8638f = "Limit.kt", m8637i = {0, 0}, m8636l = {73}, m8635m = "emitAbort$FlowKt__LimitKt", m8634n = {"$this$emitAbort", DomainCampaignEx.LOOPBACK_VALUE}, m8633s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14820b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42397a;

        /* renamed from: b */
        int f42398b;

        /* renamed from: c */
        Object f42399c;

        /* renamed from: d */
        Object f42400d;

        C14820b(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42397a = obj;
            this.f42398b |= Integer.MIN_VALUE;
            return Limit.m4969e(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m4973a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15284p<? super T, ? super kotlin.coroutines.InterfaceC14268c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r4 = r0.L$2
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r4 = (kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1) r4
            java.lang.Object r5 = r0.L$1
            l1.p r5 = (p617l1.InterfaceC15284p) r5
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.InterfaceC14958h) r5
            kotlin.C14294d0.m8596n(r6)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L35
            goto L5b
        L35:
            r5 = move-exception
            goto L58
        L37:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3f:
            kotlin.C14294d0.m8596n(r6)
            kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1 r6 = new kotlinx.coroutines.flow.FlowKt__LimitKt$collectWhile$collector$1
            r6.<init>(r5)
            r0.L$0 = r4     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L56
            r0.L$1 = r5     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L56
            r0.L$2 = r6     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L56
            r0.label = r3     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L56
            java.lang.Object r4 = r4.mo4470e(r6, r0)     // Catch: kotlinx.coroutines.flow.internal.FlowExceptions -> L56
            if (r4 != r1) goto L5b
            return r1
        L56:
            r5 = move-exception
            r4 = r6
        L58:
            kotlinx.coroutines.flow.internal.C14994m.m4762b(r5, r4)
        L5b:
            kotlin.f1 r4 = kotlin.Unit.f41048a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Limit.m4973a(kotlinx.coroutines.flow.h, l1.p, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: b */
    private static final Object m4972b(@NotNull InterfaceC14958h interfaceC14958h, @NotNull InterfaceC15284p interfaceC15284p, @NotNull InterfaceC14268c interfaceC14268c) {
        FlowKt__LimitKt$collectWhile$collector$1 flowKt__LimitKt$collectWhile$collector$1 = new FlowKt__LimitKt$collectWhile$collector$1(interfaceC15284p);
        try {
            InlineMarker.m8227e(0);
            interfaceC14958h.mo4470e(flowKt__LimitKt$collectWhile$collector$1, interfaceC14268c);
            InlineMarker.m8227e(2);
            InlineMarker.m8227e(1);
        } catch (FlowExceptions e) {
            C14994m.m4762b(e, flowKt__LimitKt$collectWhile$collector$1);
        }
        return Unit.f41048a;
    }

    @NotNull
    /* renamed from: c */
    public static final <T> InterfaceC14958h<T> m4971c(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        if (i >= 0) {
            return new C14818a(interfaceC14958h, i);
        }
        throw new IllegalArgumentException(("Drop count should be non-negative, but had " + i).toString());
    }

    @NotNull
    /* renamed from: d */
    public static final <T> InterfaceC14958h<T> m4970d(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p) {
        return new FlowKt__LimitKt$dropWhile$$inlined$unsafeFlow$1(interfaceC14958h, interfaceC15284p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ <T> java.lang.Object m4969e(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r4, T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.Limit.C14820b
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__LimitKt$b r0 = (kotlinx.coroutines.flow.Limit.C14820b) r0
            int r1 = r0.f42398b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42398b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__LimitKt$b r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f42397a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42398b
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.f42399c
            kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            kotlin.C14294d0.m8596n(r6)
            goto L45
        L35:
            kotlin.C14294d0.m8596n(r6)
            r0.f42399c = r4
            r0.f42400d = r5
            r0.f42398b = r3
            java.lang.Object r5 = r4.emit(r5, r0)
            if (r5 != r1) goto L45
            return r1
        L45:
            kotlinx.coroutines.flow.internal.AbortFlowException r5 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Limit.m4969e(kotlinx.coroutines.flow.i, java.lang.Object, kotlin.coroutines.c):java.lang.Object");
    }

    @NotNull
    /* renamed from: f */
    public static final <T> InterfaceC14958h<T> m4968f(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i) {
        if (i > 0) {
            return new FlowKt__LimitKt$take$$inlined$unsafeFlow$1(interfaceC14958h, i);
        }
        throw new IllegalArgumentException(("Requested element count " + i + " should be positive").toString());
    }

    @NotNull
    /* renamed from: g */
    public static final <T> InterfaceC14958h<T> m4967g(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull InterfaceC15284p<? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15284p) {
        return new FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1(interfaceC14958h, interfaceC15284p);
    }

    @ExperimentalCoroutinesApi
    @NotNull
    /* renamed from: h */
    public static final <T, R> InterfaceC14958h<R> m4966h(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @Inference @NotNull InterfaceC15285q<? super FlowCollector<? super R>, ? super T, ? super InterfaceC14268c<? super Boolean>, ? extends Object> interfaceC15285q) {
        return C15006k.m4707N0(new FlowKt__LimitKt$transformWhile$1(interfaceC14958h, interfaceC15285q, null));
    }
}
