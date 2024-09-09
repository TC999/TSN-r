package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.f1;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Channels.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a%\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0002\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"E", "Lkotlinx/coroutines/channels/h0;", "element", "Lkotlin/f1;", "a", "(Lkotlinx/coroutines/channels/h0;Ljava/lang/Object;)V", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final /* synthetic */ class s {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Channels.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"E", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$sendBlocking$1", f = "Channels.kt", i = {0}, l = {25}, m = "invokeSuspend", n = {"$this$runBlocking"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private q0 f59483a;

        /* renamed from: b  reason: collision with root package name */
        Object f59484b;

        /* renamed from: c  reason: collision with root package name */
        int f59485c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h0 f59486d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Object f59487e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(h0 h0Var, Object obj, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f59486d = h0Var;
            this.f59487e = obj;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f59486d, this.f59487e, cVar);
            aVar.f59483a = (q0) obj;
            return aVar;
        }

        @Override // d2.p
        public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f59485c;
            if (i4 == 0) {
                kotlin.d0.n(obj);
                q0 q0Var = this.f59483a;
                h0 h0Var = this.f59486d;
                Object obj2 = this.f59487e;
                this.f59484b = q0Var;
                this.f59485c = 1;
                if (h0Var.O(obj2, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q0 q0Var2 = (q0) this.f59484b;
                kotlin.d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> void a(@NotNull h0<? super E> h0Var, E e4) {
        if (h0Var.offer(e4)) {
            return;
        }
        kotlinx.coroutines.h.h(null, new a(h0Var, e4, null), 1, null);
    }
}
