package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlinx.coroutines.internal.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ChannelFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/internal/v;", "T", "Lkotlinx/coroutines/flow/i;", "value", "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "a", "Ljava/lang/Object;", "countOrElement", "Lkotlin/coroutines/f;", "c", "Lkotlin/coroutines/f;", "emitContext", "downstream", "<init>", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class v<T> implements kotlinx.coroutines.flow.i<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f60174a;

    /* renamed from: b  reason: collision with root package name */
    private final d2.p<T, kotlin.coroutines.c<? super f1>, Object> f60175b;

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.coroutines.f f60176c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ChannelFlow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.UndispatchedContextCollector$emitRef$1", f = "ChannelFlow.kt", i = {0}, l = {224}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends SuspendLambda implements d2.p<T, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private Object f60177a;

        /* renamed from: b  reason: collision with root package name */
        Object f60178b;

        /* renamed from: c  reason: collision with root package name */
        int f60179c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f60180d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlinx.coroutines.flow.i iVar, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f60180d = iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f60180d, cVar);
            aVar.f60177a = obj;
            return aVar;
        }

        @Override // d2.p
        public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(obj, cVar)).invokeSuspend(f1.f55527a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f60179c;
            if (i4 == 0) {
                d0.n(obj);
                Object obj2 = this.f60177a;
                kotlinx.coroutines.flow.i iVar = this.f60180d;
                this.f60178b = obj2;
                this.f60179c = 1;
                if (iVar.emit(obj2, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    public v(@NotNull kotlinx.coroutines.flow.i<? super T> iVar, @NotNull kotlin.coroutines.f fVar) {
        this.f60176c = fVar;
        this.f60174a = o0.b(fVar);
        this.f60175b = new a(iVar, null);
    }

    @Override // kotlinx.coroutines.flow.i
    @Nullable
    public Object emit(T t3, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object c4 = f.c(this.f60176c, t3, this.f60174a, this.f60175b, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return c4 == h4 ? c4 : f1.f55527a;
    }
}
