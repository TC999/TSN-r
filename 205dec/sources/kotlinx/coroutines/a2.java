package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Interruptible.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u001a1\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a+\u0010\b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0007\u001a\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002\u00a2\u0006\u0004\b\b\u0010\t\"\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\f\"\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\f\"\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"T", "Lkotlin/coroutines/f;", "context", "Lkotlin/Function0;", "block", "b", "(Lkotlin/coroutines/f;Ld2/a;Lkotlin/coroutines/c;)Ljava/lang/Object;", "coroutineContext", "d", "(Lkotlin/coroutines/f;Ld2/a;)Ljava/lang/Object;", "", "a", "I", "WORKING", "FINISHED", "c", "INTERRUPTING", "INTERRUPTED", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a2 {

    /* renamed from: a  reason: collision with root package name */
    private static final int f59033a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final int f59034b = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f59035c = 2;

    /* renamed from: d  reason: collision with root package name */
    private static final int f59036d = 3;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Interruptible.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.InterruptibleKt$runInterruptible$2", f = "Interruptible.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super T>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private q0 f59037a;

        /* renamed from: b  reason: collision with root package name */
        int f59038b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d2.a f59039c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(d2.a aVar, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f59039c = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<kotlin.f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f59039c, cVar);
            aVar.f59037a = (q0) obj;
            return aVar;
        }

        @Override // d2.p
        public final Object invoke(q0 q0Var, Object obj) {
            return ((a) create(q0Var, (kotlin.coroutines.c) obj)).invokeSuspend(kotlin.f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            kotlin.coroutines.intrinsics.b.h();
            if (this.f59038b == 0) {
                kotlin.d0.n(obj);
                return a2.d(this.f59037a.getCoroutineContext(), this.f59039c);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Nullable
    public static final <T> Object b(@NotNull kotlin.coroutines.f fVar, @NotNull d2.a<? extends T> aVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        return h.i(fVar, new a(aVar, null), cVar);
    }

    public static /* synthetic */ Object c(kotlin.coroutines.f fVar, d2.a aVar, kotlin.coroutines.c cVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            fVar = EmptyCoroutineContext.INSTANCE;
        }
        return b(fVar, aVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> T d(kotlin.coroutines.f fVar, d2.a<? extends T> aVar) {
        try {
            n3 n3Var = new n3(h2.C(fVar));
            n3Var.d();
            T invoke = aVar.invoke();
            n3Var.a();
            return invoke;
        } catch (InterruptedException e4) {
            throw new CancellationException("Blocking call was interrupted due to parent cancellation").initCause(e4);
        }
    }
}
