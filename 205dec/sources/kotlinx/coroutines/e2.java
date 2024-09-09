package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlinx.coroutines.CoroutineExceptionHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Job.kt */
@Metadata(bv = {}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 +2\u00020\u0001:\u0001\tJ\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'J\b\u0010\u0006\u001a\u00020\u0005H&J\u001a\u0010\t\u001a\u00020\b2\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003H&J\b\u0010\n\u001a\u00020\bH\u0017J\u0014\u0010\f\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u000bH'J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH'J\u0013\u0010\u0011\u001a\u00020\bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0019\u001a\u00020\u00182'\u0010\u0017\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0013j\u0002`\u0016H&JE\u0010\u001c\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u00052'\u0010\u0017\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0013j\u0002`\u0016H'J\u0011\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0097\u0002R\u0014\u0010\u001f\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b!\u0010 R\u0014\u0010\"\u001a\u00020\u00058&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010 R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00000#8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006,"}, d2 = {"Lkotlinx/coroutines/e2;", "Lkotlin/coroutines/f$b;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "l", "", CampaignEx.JSON_NATIVE_VIDEO_START, "cause", "Lkotlin/f1;", "b", "cancel", "", "a", "Lkotlinx/coroutines/w;", "child", "Lkotlinx/coroutines/u;", "R", "A", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/i1;", "m", "onCancelling", "invokeImmediately", "z", "other", "s", "isActive", "()Z", "isCompleted", "isCancelled", "Lkotlin/sequences/m;", "h", "()Lkotlin/sequences/m;", "children", "Lkotlinx/coroutines/selects/c;", "M", "()Lkotlinx/coroutines/selects/c;", "onJoin", "i0", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface e2 extends f.b {

    /* renamed from: i0  reason: collision with root package name */
    public static final b f59626i0 = b.f59627a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: Job.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static final class a {
        public static /* synthetic */ void b(e2 e2Var, CancellationException cancellationException, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    cancellationException = null;
                }
                e2Var.b(cancellationException);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static /* synthetic */ boolean c(e2 e2Var, Throwable th, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    th = null;
                }
                return e2Var.a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        public static <R> R d(@NotNull e2 e2Var, R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
            return (R) f.b.a.a(e2Var, r3, pVar);
        }

        @Nullable
        public static <E extends f.b> E e(@NotNull e2 e2Var, @NotNull f.c<E> cVar) {
            return (E) f.b.a.b(e2Var, cVar);
        }

        public static /* synthetic */ i1 f(e2 e2Var, boolean z3, boolean z4, d2.l lVar, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    z3 = false;
                }
                if ((i4 & 2) != 0) {
                    z4 = true;
                }
                return e2Var.z(z3, z4, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        @NotNull
        public static kotlin.coroutines.f g(@NotNull e2 e2Var, @NotNull f.c<?> cVar) {
            return f.b.a.c(e2Var, cVar);
        }

        @NotNull
        public static kotlin.coroutines.f h(@NotNull e2 e2Var, @NotNull kotlin.coroutines.f fVar) {
            return f.b.a.d(e2Var, fVar);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        public static e2 i(@NotNull e2 e2Var, @NotNull e2 e2Var2) {
            return e2Var2;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Job.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/e2$b;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/e2;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements f.c<e2> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f59627a = new b();

        static {
            CoroutineExceptionHandler.b bVar = CoroutineExceptionHandler.f59029h0;
        }

        private b() {
        }
    }

    @Nullable
    Object A(@NotNull kotlin.coroutines.c<? super kotlin.f1> cVar);

    @NotNull
    kotlinx.coroutines.selects.c M();

    @InternalCoroutinesApi
    @NotNull
    u R(@NotNull w wVar);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean a(@Nullable Throwable th);

    void b(@Nullable CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    @NotNull
    kotlin.sequences.m<e2> h();

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @InternalCoroutinesApi
    @NotNull
    CancellationException l();

    @NotNull
    i1 m(@NotNull d2.l<? super Throwable, kotlin.f1> lVar);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    @NotNull
    e2 s(@NotNull e2 e2Var);

    boolean start();

    @InternalCoroutinesApi
    @NotNull
    i1 z(boolean z3, boolean z4, @NotNull d2.l<? super Throwable, kotlin.f1> lVar);
}
