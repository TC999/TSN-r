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

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: Zip.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
@DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1", m8638f = "Zip.kt", m8637i = {0}, m8636l = {UMSLNetWorkSender.f38894a}, m8635m = "invokeSuspend", m8634n = {"$this$flow"}, m8633s = {"L$0"})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__ZipKt$combineTransformUnsafe$1<R> extends SuspendLambda implements InterfaceC15284p<FlowCollector<? super R>, InterfaceC14268c<? super Unit>, Object> {
    final /* synthetic */ InterfaceC14958h[] $flows;
    final /* synthetic */ InterfaceC15285q $transform;
    Object L$0;
    int label;

    /* renamed from: p$ */
    private FlowCollector f42656p$;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Zip.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/i;", "", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1", m8638f = "Zip.kt", m8637i = {0, 0}, m8636l = {UMSLNetWorkSender.f38894a}, m8635m = "invokeSuspend", m8634n = {"$this$combineInternal", "it"}, m8633s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1 */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C149391<T> extends SuspendLambda implements InterfaceC15285q<FlowCollector<? super R>, T[], InterfaceC14268c<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        /* renamed from: p$ */
        private FlowCollector f42657p$;
        private Object[] p$0;

        public C149391(InterfaceC14268c interfaceC14268c) {
            super(3, interfaceC14268c);
        }

        @NotNull
        public final InterfaceC14268c<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull T[] tArr, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            C149391 c149391 = new C149391(interfaceC14268c);
            c149391.f42657p$ = flowCollector;
            c149391.p$0 = tArr;
            return c149391;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p617l1.InterfaceC15285q
        public final Object invoke(Object obj, Object obj2, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C149391) create((FlowCollector) obj, (Object[]) obj2, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.label;
            if (i == 0) {
                C14294d0.m8596n(obj);
                FlowCollector flowCollector = this.f42657p$;
                Object[] objArr = this.p$0;
                InterfaceC15285q interfaceC15285q = FlowKt__ZipKt$combineTransformUnsafe$1.this.$transform;
                this.L$0 = flowCollector;
                this.L$1 = objArr;
                this.label = 1;
                if (interfaceC15285q.invoke(flowCollector, objArr, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                Object[] objArr2 = (Object[]) this.L$1;
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            FlowKt__ZipKt$combineTransformUnsafe$1.this.$transform.invoke(this.f42657p$, this.p$0, this);
            return Unit.f41048a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransformUnsafe$1(InterfaceC14958h[] interfaceC14958hArr, InterfaceC15285q interfaceC15285q, InterfaceC14268c interfaceC14268c) {
        super(2, interfaceC14268c);
        this.$flows = interfaceC14958hArr;
        this.$transform = interfaceC15285q;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
        FlowKt__ZipKt$combineTransformUnsafe$1 flowKt__ZipKt$combineTransformUnsafe$1 = new FlowKt__ZipKt$combineTransformUnsafe$1(this.$flows, this.$transform, interfaceC14268c);
        flowKt__ZipKt$combineTransformUnsafe$1.f42656p$ = (FlowCollector) obj;
        return flowKt__ZipKt$combineTransformUnsafe$1;
    }

    @Override // p617l1.InterfaceC15284p
    public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
        return ((FlowKt__ZipKt$combineTransformUnsafe$1) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m8642h;
        m8642h = C14287b.m8642h();
        int i = this.label;
        if (i == 0) {
            C14294d0.m8596n(obj);
            FlowCollector flowCollector = this.f42656p$;
            InterfaceC14958h[] interfaceC14958hArr = this.$flows;
            InterfaceC15269a m4858a = Zip.m4858a();
            C149391 c149391 = new C149391(null);
            this.L$0 = flowCollector;
            this.label = 1;
            if (Combine.m4805a(flowCollector, interfaceC14958hArr, m4858a, c149391, this) == m8642h) {
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

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        FlowCollector flowCollector = this.f42656p$;
        InterfaceC14958h[] interfaceC14958hArr = this.$flows;
        InterfaceC15269a m4858a = Zip.m4858a();
        C149391 c149391 = new C149391(null);
        InlineMarker.m8227e(0);
        Combine.m4805a(flowCollector, interfaceC14958hArr, m4858a, c149391, this);
        InlineMarker.m8227e(2);
        InlineMarker.m8227e(1);
        return Unit.f41048a;
    }
}
