package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a#\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001aG\u0010\n\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\t\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "", "a", "(Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "b", "(Lkotlinx/coroutines/flow/h;Ll1/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.FlowKt__CountKt */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class Count {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Collect.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14795a<T> implements FlowCollector<T> {

        /* renamed from: a */
        final /* synthetic */ Ref.IntRef f42318a;

        public C14795a(Ref.IntRef intRef) {
            this.f42318a = intRef;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
            this.f42318a.element++;
            return Unit.f41048a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Count.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/coroutines/c;", "", "continuation", "", "count"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__CountKt", m8638f = "Count.kt", m8637i = {0, 0, 0}, m8636l = {39}, m8635m = "count", m8634n = {"$this$count", "i", "$this$collect$iv"}, m8633s = {"L$0", "L$1", "L$2"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14796b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42319a;

        /* renamed from: b */
        int f42320b;

        /* renamed from: c */
        Object f42321c;

        /* renamed from: d */
        Object f42322d;

        /* renamed from: e */
        Object f42323e;

        C14796b(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42319a = obj;
            this.f42320b |= Integer.MIN_VALUE;
            return C15006k.m4656d0(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Count.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "", "predicate", "", "continuation", "count"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__CountKt", m8638f = "Count.kt", m8637i = {0, 0, 0, 0}, m8636l = {42}, m8635m = "count", m8634n = {"$this$count", "predicate", "i", "$this$collect$iv"}, m8633s = {"L$0", "L$1", "L$2", "L$3"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CountKt$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14797c extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42324a;

        /* renamed from: b */
        int f42325b;

        /* renamed from: c */
        Object f42326c;

        /* renamed from: d */
        Object f42327d;

        /* renamed from: e */
        Object f42328e;

        /* renamed from: f */
        Object f42329f;

        C14797c(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42324a = obj;
            this.f42325b |= Integer.MIN_VALUE;
            return C15006k.m4652e0(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m5001a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.lang.Integer> r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.Count.C14796b
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.FlowKt__CountKt$b r0 = (kotlinx.coroutines.flow.Count.C14796b) r0
            int r1 = r0.f42320b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42320b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$b r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f42319a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42320b
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.f42323e
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.InterfaceC14958h) r4
            java.lang.Object r4 = r0.f42322d
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r0 = r0.f42321c
            kotlinx.coroutines.flow.h r0 = (kotlinx.coroutines.flow.InterfaceC14958h) r0
            kotlin.C14294d0.m8596n(r5)
            goto L5d
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            kotlin.C14294d0.m8596n(r5)
            kotlin.jvm.internal.Ref$IntRef r5 = new kotlin.jvm.internal.Ref$IntRef
            r5.<init>()
            r2 = 0
            r5.element = r2
            kotlinx.coroutines.flow.FlowKt__CountKt$a r2 = new kotlinx.coroutines.flow.FlowKt__CountKt$a
            r2.<init>(r5)
            r0.f42321c = r4
            r0.f42322d = r5
            r0.f42323e = r4
            r0.f42320b = r3
            java.lang.Object r4 = r4.mo4470e(r2, r0)
            if (r4 != r1) goto L5c
            return r1
        L5c:
            r4 = r5
        L5d:
            int r4 = r4.element
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.boxing.m8626f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Count.m5001a(kotlinx.coroutines.flow.h, kotlin.coroutines.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m5000b(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull p617l1.InterfaceC15284p<? super T, ? super kotlin.coroutines.InterfaceC14268c<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super java.lang.Integer> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.Count.C14797c
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.FlowKt__CountKt$c r0 = (kotlinx.coroutines.flow.Count.C14797c) r0
            int r1 = r0.f42325b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42325b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__CountKt$c r0 = new kotlinx.coroutines.flow.FlowKt__CountKt$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f42324a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42325b
            r3 = 1
            if (r2 == 0) goto L41
            if (r2 != r3) goto L39
            java.lang.Object r4 = r0.f42329f
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.InterfaceC14958h) r4
            java.lang.Object r4 = r0.f42328e
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r5 = r0.f42327d
            l1.p r5 = (p617l1.InterfaceC15284p) r5
            java.lang.Object r5 = r0.f42326c
            kotlinx.coroutines.flow.h r5 = (kotlinx.coroutines.flow.InterfaceC14958h) r5
            kotlin.C14294d0.m8596n(r6)
            goto L63
        L39:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L41:
            kotlin.C14294d0.m8596n(r6)
            kotlin.jvm.internal.Ref$IntRef r6 = new kotlin.jvm.internal.Ref$IntRef
            r6.<init>()
            r2 = 0
            r6.element = r2
            kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2 r2 = new kotlinx.coroutines.flow.FlowKt__CountKt$count$$inlined$collect$2
            r2.<init>(r5, r6)
            r0.f42326c = r4
            r0.f42327d = r5
            r0.f42328e = r6
            r0.f42329f = r4
            r0.f42325b = r3
            java.lang.Object r4 = r4.mo4470e(r2, r0)
            if (r4 != r1) goto L62
            return r1
        L62:
            r4 = r6
        L63:
            int r4 = r4.element
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.boxing.m8626f(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Count.m5000b(kotlinx.coroutines.flow.h, l1.p, kotlin.coroutines.c):java.lang.Object");
    }
}
