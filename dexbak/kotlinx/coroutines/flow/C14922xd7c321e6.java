package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.commonsdk.stateless.UMSLNetWorkSender;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.Combine;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;
import p617l1.InterfaceC15284p;
import p617l1.InterfaceC15285q;
import p617l1.InterfaceC15286r;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Zip.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1", m8638f = "Zip.kt", m8637i = {0}, m8636l = {UMSLNetWorkSender.f38894a}, m8635m = "invokeSuspend", m8634n = {"$this$flow"}, m8633s = {"L$0"})
/* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14922xd7c321e6<R> extends SuspendLambda implements InterfaceC15284p<FlowCollector<? super R>, InterfaceC14268c<? super Unit>, Object> {
    final /* synthetic */ InterfaceC14958h[] $flows;
    final /* synthetic */ InterfaceC15286r $transform$inlined;
    Object L$0;
    int label;

    /* renamed from: p$ */
    private FlowCollector f42633p$;

    /* compiled from: Zip.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\t\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1$1", m8638f = "Zip.kt", m8637i = {0, 0, 0, 0, 0}, m8636l = {335}, m8635m = "invokeSuspend", m8634n = {"$this$combineInternal", "it", "continuation", "args", "$receiver"}, m8633s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$1$1 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C149231 extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super R>, Object[], InterfaceC14268c<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;

        /* renamed from: p$ */
        private FlowCollector f42634p$;
        private Object[] p$0;

        public C149231(InterfaceC14268c interfaceC14268c) {
            super(3, interfaceC14268c);
        }

        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull Object[] objArr, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            C149231 c149231 = new C149231(interfaceC14268c);
            c149231.f42634p$ = flowCollector;
            c149231.p$0 = objArr;
            return c149231;
        }

        @Override // p617l1.InterfaceC15285q
        public final Object invoke(Object obj, Object[] objArr, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C149231) create((FlowCollector) obj, objArr, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.label;
            if (i == 0) {
                C14294d0.m8596n(obj);
                FlowCollector flowCollector = this.f42634p$;
                Object[] objArr = this.p$0;
                InterfaceC15286r interfaceC15286r = C14922xd7c321e6.this.$transform$inlined;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                this.L$0 = flowCollector;
                this.L$1 = objArr;
                this.L$2 = this;
                this.L$3 = objArr;
                this.L$4 = flowCollector;
                this.label = 1;
                InlineMarker.m8227e(6);
                Object invoke = interfaceC15286r.invoke(flowCollector, obj2, obj3, this);
                InlineMarker.m8227e(7);
                if (invoke == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                FlowCollector flowCollector2 = (FlowCollector) this.L$4;
                Object[] objArr2 = (Object[]) this.L$3;
                InterfaceC14268c interfaceC14268c = (InterfaceC14268c) this.L$2;
                Object[] objArr3 = (Object[]) this.L$1;
                FlowCollector flowCollector3 = (FlowCollector) this.L$0;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14922xd7c321e6(InterfaceC14958h[] interfaceC14958hArr, InterfaceC14268c interfaceC14268c, InterfaceC15286r interfaceC15286r) {
        super(2, interfaceC14268c);
        this.$flows = interfaceC14958hArr;
        this.$transform$inlined = interfaceC15286r;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        C14922xd7c321e6 c14922xd7c321e6 = new C14922xd7c321e6(this.$flows, interfaceC14268c, this.$transform$inlined);
        c14922xd7c321e6.f42633p$ = (FlowCollector) obj;
        return c14922xd7c321e6;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((C14922xd7c321e6) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        m8642h = C14287b.m8642h();
        int i = this.label;
        if (i == 0) {
            C14294d0.m8596n(obj);
            FlowCollector flowCollector = this.f42633p$;
            InterfaceC14958h[] interfaceC14958hArr = this.$flows;
            InterfaceC15269a m4858a = Zip.m4858a();
            C149231 c149231 = new C149231(null);
            this.L$0 = flowCollector;
            this.label = 1;
            if (Combine.m4805a(flowCollector, interfaceC14958hArr, m4858a, c149231, this) == m8642h) {
                return m8642h;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            C14294d0.m8596n(obj);
        }
        return Unit.f41048a;
    }
}
