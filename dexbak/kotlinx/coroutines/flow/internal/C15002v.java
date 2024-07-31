package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.C14294d0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.ThreadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: ChannelFlow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/v;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "a", "Ljava/lang/Object;", "countOrElement", "Lkotlin/coroutines/f;", "c", "Lkotlin/coroutines/f;", "emitContext", "downstream", "<init>", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.v */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class C15002v<T> implements FlowCollector<T> {

    /* renamed from: a */
    private final Object f42857a;

    /* renamed from: b */
    private final InterfaceC15284p<T, InterfaceC14268c<? super Unit>, Object> f42858b;

    /* renamed from: c */
    private final CoroutineContext f42859c;

    /* compiled from: ChannelFlow.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", m8638f = "ChannelFlow.kt", m8637i = {0}, m8636l = {224}, m8635m = "invokeSuspend", m8634n = {"it"}, m8633s = {"L$0"})
    /* renamed from: kotlinx.coroutines.flow.internal.v$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15003a extends SuspendLambda implements InterfaceC15284p<T, InterfaceC14268c<? super Unit>, Object> {

        /* renamed from: a */
        private Object f42860a;

        /* renamed from: b */
        Object f42861b;

        /* renamed from: c */
        int f42862c;

        /* renamed from: d */
        final /* synthetic */ FlowCollector f42863d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15003a(FlowCollector flowCollector, InterfaceC14268c interfaceC14268c) {
            super(2, interfaceC14268c);
            this.f42863d = flowCollector;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final InterfaceC14268c<Unit> create(@Nullable Object obj, @NotNull InterfaceC14268c<?> interfaceC14268c) {
            C15003a c15003a = new C15003a(this.f42863d, interfaceC14268c);
            c15003a.f42860a = obj;
            return c15003a;
        }

        @Override // p617l1.InterfaceC15284p
        public final Object invoke(Object obj, InterfaceC14268c<? super Unit> interfaceC14268c) {
            return ((C15003a) create(obj, interfaceC14268c)).invokeSuspend(Unit.f41048a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object m8642h;
            m8642h = C14287b.m8642h();
            int i = this.f42862c;
            if (i == 0) {
                C14294d0.m8596n(obj);
                Object obj2 = this.f42860a;
                FlowCollector flowCollector = this.f42863d;
                this.f42861b = obj2;
                this.f42862c = 1;
                if (flowCollector.emit(obj2, this) == m8642h) {
                    return m8642h;
                }
            } else if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                C14294d0.m8596n(obj);
            }
            return Unit.f41048a;
        }
    }

    public C15002v(@NotNull FlowCollector<? super T> flowCollector, @NotNull CoroutineContext coroutineContext) {
        this.f42859c = coroutineContext;
        this.f42857a = ThreadContext.m4254b(coroutineContext);
        this.f42858b = new C15003a(flowCollector, null);
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    public Object emit(T t, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m4778c = C14983f.m4778c(this.f42859c, t, this.f42857a, this.f42858b, interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m4778c == m8642h ? m4778c : Unit.f41048a;
    }
}
