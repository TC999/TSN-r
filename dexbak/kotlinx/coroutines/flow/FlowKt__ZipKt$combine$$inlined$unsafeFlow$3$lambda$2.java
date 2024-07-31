package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* compiled from: Zip.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2", m8638f = "Zip.kt", m8637i = {0, 0, 1, 1}, m8636l = {238, 238}, m8635m = "invokeSuspend", m8634n = {"$this$combineInternal", "it", "$this$combineInternal", "it"}, m8633s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2<R, T> extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super R>, T[], InterfaceC14268c<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* renamed from: p$ */
    private FlowCollector f42629p$;
    private Object[] p$0;
    final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2(InterfaceC14268c interfaceC14268c, FlowKt__ZipKt$combine$$inlined$unsafeFlow$3 flowKt__ZipKt$combine$$inlined$unsafeFlow$3) {
        super(3, interfaceC14268c);
        this.this$0 = flowKt__ZipKt$combine$$inlined$unsafeFlow$3;
    }

    @NotNull
    public final InterfaceC14268c<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull T[] tArr, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2 flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2(interfaceC14268c, this.this$0);
        flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2.f42629p$ = flowCollector;
        flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2.p$0 = tArr;
        return flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p617l1.InterfaceC15285q
    public final Object invoke(Object obj, Object obj2, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2) create((FlowCollector) obj, (Object[]) obj2, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        FlowCollector flowCollector;
        FlowCollector flowCollector2;
        Object[] objArr;
        m8642h = C14287b.m8642h();
        int i = this.label;
        if (i == 0) {
            C14294d0.m8596n(obj);
            flowCollector = this.f42629p$;
            Object[] objArr2 = this.p$0;
            InterfaceC15284p interfaceC15284p = this.this$0.f42628b;
            this.L$0 = flowCollector;
            this.L$1 = objArr2;
            this.L$2 = flowCollector;
            this.label = 1;
            Object invoke = interfaceC15284p.invoke(objArr2, this);
            if (invoke == m8642h) {
                return m8642h;
            }
            flowCollector2 = flowCollector;
            objArr = objArr2;
            obj = invoke;
        } else if (i != 1) {
            if (i == 2) {
                Object[] objArr3 = (Object[]) this.L$1;
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                C14294d0.m8596n(obj);
                return Unit.f41048a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            flowCollector = (FlowCollector) this.L$2;
            objArr = (Object[]) this.L$1;
            flowCollector2 = (FlowCollector) this.L$0;
            C14294d0.m8596n(obj);
        }
        this.L$0 = flowCollector2;
        this.L$1 = objArr;
        this.label = 2;
        if (flowCollector.emit(obj, this) == m8642h) {
            return m8642h;
        }
        return Unit.f41048a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        FlowCollector flowCollector = this.f42629p$;
        Object invoke = this.this$0.f42628b.invoke(this.p$0, this);
        InlineMarker.m8227e(0);
        flowCollector.emit(invoke, this);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        return Unit.f41048a;
    }
}
