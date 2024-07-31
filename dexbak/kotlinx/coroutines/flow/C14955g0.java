package kotlinx.coroutines.flow;

import com.alibaba.fastjson.asm.Opcodes;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import java.util.List;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsJVM;
import kotlin.collections._Collections;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.boxing;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharingStarted.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011¨\u0006\u0017"}, m12616d2 = {"Lkotlinx/coroutines/flow/g0;", "Lkotlinx/coroutines/flow/d0;", "Lkotlinx/coroutines/flow/h0;", "", "subscriptionCount", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/SharingCommand;", "a", "", "toString", "", AdnName.OTHER, "", "equals", TTDownloadField.TT_HASHCODE, "", "b", "J", "stopTimeout", "c", "replayExpiration", "<init>", "(JJ)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.g0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14955g0 implements InterfaceC14948d0 {

    /* renamed from: b */
    private final long f42696b;

    /* renamed from: c */
    private final long f42697c;

    /* compiled from: SharingStarted.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, m12616d2 = {"Lkotlinx/coroutines/flow/i;", "Lkotlinx/coroutines/flow/SharingCommand;", "", "count", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", m8638f = "SharingStarted.kt", m8637i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, m8636l = {181, Opcodes.INVOKESPECIAL, Opcodes.INVOKEINTERFACE, 186, Opcodes.NEWARRAY}, m8635m = "invokeSuspend", m8634n = {"$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count", "$this$transformLatest", "count"}, m8633s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
    /* renamed from: kotlinx.coroutines.flow.g0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14956a extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super SharingStarted>, Integer, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private FlowCollector f42698a;

        /* renamed from: b */
        private int f42699b;

        /* renamed from: c */
        Object f42700c;

        /* renamed from: d */
        int f42701d;

        /* renamed from: e */
        int f42702e;

        C14956a(InterfaceC14268c interfaceC14268c) {
            super(3, interfaceC14268c);
        }

        @NotNull
        /* renamed from: d */
        public final InterfaceC14268c<Unit> m4811d(@NotNull FlowCollector<? super SharingStarted> flowCollector, int i, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            C14956a c14956a = new C14956a(interfaceC14268c);
            c14956a.f42698a = flowCollector;
            c14956a.f42699b = i;
            return c14956a;
        }

        @Override // p617l1.InterfaceC15285q
        public final Object invoke(FlowCollector<? super SharingStarted> flowCollector, Integer num, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C14956a) m4811d(flowCollector, num.intValue(), interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x007f  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a1 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00a2  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r1 = r10.f42702e
                r2 = 5
                r3 = 4
                r4 = 3
                r5 = 2
                r6 = 1
                if (r1 == 0) goto L47
                if (r1 == r6) goto L3f
                if (r1 == r5) goto L35
                if (r1 == r4) goto L2b
                if (r1 == r3) goto L20
                if (r1 != r2) goto L18
                goto L3f
            L18:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L20:
                int r1 = r10.f42701d
                java.lang.Object r3 = r10.f42700c
                kotlinx.coroutines.flow.i r3 = (kotlinx.coroutines.flow.FlowCollector) r3
                kotlin.C14294d0.m8596n(r11)
                goto La3
            L2b:
                int r1 = r10.f42701d
                java.lang.Object r4 = r10.f42700c
                kotlinx.coroutines.flow.i r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                kotlin.C14294d0.m8596n(r11)
                goto L8f
            L35:
                int r1 = r10.f42701d
                java.lang.Object r5 = r10.f42700c
                kotlinx.coroutines.flow.i r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                kotlin.C14294d0.m8596n(r11)
                goto L73
            L3f:
                java.lang.Object r0 = r10.f42700c
                kotlinx.coroutines.flow.i r0 = (kotlinx.coroutines.flow.FlowCollector) r0
                kotlin.C14294d0.m8596n(r11)
                goto Lb3
            L47:
                kotlin.C14294d0.m8596n(r11)
                kotlinx.coroutines.flow.i r11 = r10.f42698a
                int r1 = r10.f42699b
                if (r1 <= 0) goto L5f
                kotlinx.coroutines.flow.SharingCommand r2 = kotlinx.coroutines.flow.SharingStarted.START
                r10.f42700c = r11
                r10.f42701d = r1
                r10.f42702e = r6
                java.lang.Object r11 = r11.emit(r2, r10)
                if (r11 != r0) goto Lb3
                return r0
            L5f:
                kotlinx.coroutines.flow.g0 r6 = kotlinx.coroutines.flow.C14955g0.this
                long r6 = kotlinx.coroutines.flow.C14955g0.m4812c(r6)
                r10.f42700c = r11
                r10.f42701d = r1
                r10.f42702e = r5
                java.lang.Object r5 = kotlinx.coroutines.Delay.m5751b(r6, r10)
                if (r5 != r0) goto L72
                return r0
            L72:
                r5 = r11
            L73:
                kotlinx.coroutines.flow.g0 r11 = kotlinx.coroutines.flow.C14955g0.this
                long r6 = kotlinx.coroutines.flow.C14955g0.m4813b(r11)
                r8 = 0
                int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r11 <= 0) goto La4
                kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingStarted.STOP
                r10.f42700c = r5
                r10.f42701d = r1
                r10.f42702e = r4
                java.lang.Object r11 = r5.emit(r11, r10)
                if (r11 != r0) goto L8e
                return r0
            L8e:
                r4 = r5
            L8f:
                kotlinx.coroutines.flow.g0 r11 = kotlinx.coroutines.flow.C14955g0.this
                long r5 = kotlinx.coroutines.flow.C14955g0.m4813b(r11)
                r10.f42700c = r4
                r10.f42701d = r1
                r10.f42702e = r3
                java.lang.Object r11 = kotlinx.coroutines.Delay.m5751b(r5, r10)
                if (r11 != r0) goto La2
                return r0
            La2:
                r3 = r4
            La3:
                r5 = r3
            La4:
                kotlinx.coroutines.flow.SharingCommand r11 = kotlinx.coroutines.flow.SharingStarted.STOP_AND_RESET_REPLAY_CACHE
                r10.f42700c = r5
                r10.f42701d = r1
                r10.f42702e = r2
                java.lang.Object r11 = r5.emit(r11, r10)
                if (r11 != r0) goto Lb3
                return r0
            Lb3:
                kotlin.f1 r11 = kotlin.Unit.f41048a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.C14955g0.C14956a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: SharingStarted.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"<anonymous>", "", "it", "Lkotlinx/coroutines/flow/SharingCommand;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$2", m8638f = "SharingStarted.kt", m8637i = {}, m8636l = {}, m8635m = "invokeSuspend", m8634n = {}, m8633s = {})
    /* renamed from: kotlinx.coroutines.flow.g0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C14957b extends SuspendLambda implements InterfaceC15284p<SharingStarted, InterfaceC14268c<? super Boolean>, Object> {

        /* renamed from: a */
        private SharingStarted f42704a;

        /* renamed from: b */
        int f42705b;

        C14957b(InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C14957b c14957b = new C14957b(interfaceC14268c);
            c14957b.f42704a = (SharingStarted) obj;
            return c14957b;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(SharingStarted sharingStarted, InterfaceC14268c<? super Boolean> interfaceC14268c) {
            return ((C14957b) create(sharingStarted, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            C14287b.m8642h();
            if (this.f42705b == 0) {
                C14294d0.m8596n(obj);
                return boxing.m8631a(this.f42704a != SharingStarted.START);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public C14955g0(long j, long j2) {
        this.f42696b = j;
        this.f42697c = j2;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(("stopTimeout(" + j + " ms) cannot be negative").toString());
        }
        if (j2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j2 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.InterfaceC14948d0
    @NotNull
    /* renamed from: a */
    public InterfaceC14958h<SharingStarted> mo4814a(@NotNull StateFlow<Integer> stateFlow) {
        return C15006k.m4624l0(C15006k.m4608p0(C15006k.m4618m2(stateFlow, new C14956a(null)), new C14957b(null)));
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C14955g0) {
            C14955g0 c14955g0 = (C14955g0) obj;
            if (this.f42696b == c14955g0.f42696b && this.f42697c == c14955g0.f42697c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (Long.valueOf(this.f42696b).hashCode() * 31) + Long.valueOf(this.f42697c).hashCode();
    }

    @NotNull
    public String toString() {
        List m8966j;
        List m8975a;
        String m12151Z2;
        m8966j = CollectionsJVM.m8966j(2);
        if (this.f42696b > 0) {
            m8966j.add("stopTimeout=" + this.f42696b + "ms");
        }
        if (this.f42697c < Long.MAX_VALUE) {
            m8966j.add("replayExpiration=" + this.f42697c + "ms");
        }
        m8975a = CollectionsJVM.m8975a(m8966j);
        StringBuilder sb = new StringBuilder();
        sb.append("SharingStarted.WhileSubscribed(");
        m12151Z2 = _Collections.m12151Z2(m8975a, null, null, null, 0, null, null, 63, null);
        sb.append(m12151Z2);
        sb.append(')');
        return sb.toString();
    }
}
