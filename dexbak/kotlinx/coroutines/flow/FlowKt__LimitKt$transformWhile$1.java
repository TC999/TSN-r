package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.alibaba.fastjson.asm.Opcodes;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.internal.C14994m;
import kotlinx.coroutines.flow.internal.FlowExceptions;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Limit.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", m8638f = "Limit.kt", m8637i = {0, 0, 0}, m8636l = {Opcodes.IFNE}, m8635m = "invokeSuspend", m8634n = {"$this$flow", "$this$collectWhile$iv", "collector$iv"}, m8633s = {"L$0", "L$1", "L$2"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__LimitKt$transformWhile$1<R> extends SuspendLambda implements InterfaceC15284p<FlowCollector<? super R>, InterfaceC14268c<? super Unit>, Object> {

    /* renamed from: a */
    private FlowCollector f42418a;

    /* renamed from: b */
    Object f42419b;

    /* renamed from: c */
    Object f42420c;

    /* renamed from: d */
    Object f42421d;

    /* renamed from: e */
    int f42422e;

    /* renamed from: f */
    final /* synthetic */ InterfaceC14958h f42423f;

    /* renamed from: g */
    final /* synthetic */ InterfaceC15285q f42424g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__LimitKt$transformWhile$1(InterfaceC14958h interfaceC14958h, InterfaceC15285q interfaceC15285q, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.f42423f = interfaceC14958h;
        this.f42424g = interfaceC15285q;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        FlowKt__LimitKt$transformWhile$1 flowKt__LimitKt$transformWhile$1 = new FlowKt__LimitKt$transformWhile$1(this.f42423f, this.f42424g, interfaceC14268c);
        flowKt__LimitKt$transformWhile$1.f42418a = (FlowCollector) obj;
        return flowKt__LimitKt$transformWhile$1;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((FlowKt__LimitKt$transformWhile$1) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        C14826xdf1aa1b6 c14826xdf1aa1b6;
        m8642h = C14287b.m8642h();
        int i = this.f42422e;
        if (i == 0) {
            C14294d0.m8596n(obj);
            FlowCollector flowCollector = this.f42418a;
            InterfaceC14958h interfaceC14958h = this.f42423f;
            C14826xdf1aa1b6 c14826xdf1aa1b62 = new C14826xdf1aa1b6(this, flowCollector);
            try {
                this.f42419b = flowCollector;
                this.f42420c = interfaceC14958h;
                this.f42421d = c14826xdf1aa1b62;
                this.f42422e = 1;
                if (interfaceC14958h.mo4470e(c14826xdf1aa1b62, this) == m8642h) {
                    return m8642h;
                }
            } catch (FlowExceptions e) {
                e = e;
                c14826xdf1aa1b6 = c14826xdf1aa1b62;
                C14994m.m4762b(e, c14826xdf1aa1b6);
                return Unit.f41048a;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            c14826xdf1aa1b6 = (C14826xdf1aa1b6) this.f42421d;
            InterfaceC14958h interfaceC14958h2 = (InterfaceC14958h) this.f42420c;
            FlowCollector flowCollector2 = (FlowCollector) this.f42419b;
            try {
                C14294d0.m8596n(obj);
            } catch (FlowExceptions e2) {
                e = e2;
                C14994m.m4762b(e, c14826xdf1aa1b6);
                return Unit.f41048a;
            }
        }
        return Unit.f41048a;
    }
}
