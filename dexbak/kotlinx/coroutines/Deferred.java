package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.InterfaceC15195d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00028\u0000H'¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\b\u001a\u0004\u0018\u00010\u0007H'R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/x0;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/e2;", "m", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "g", "()Ljava/lang/Object;", "", "j", "Lkotlinx/coroutines/selects/d;", "D", "()Lkotlinx/coroutines/selects/d;", "onAwait", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.x0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface Deferred<T> extends Job {

    /* compiled from: Deferred.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.x0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C15252a {
        /* renamed from: b */
        public static <T, R> R m3508b(@NotNull Deferred<? extends T> deferred, R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
            return (R) Job.C14776a.m5045d(deferred, r, interfaceC15284p);
        }

        @Nullable
        /* renamed from: c */
        public static <T, E extends CoroutineContext.InterfaceC14275b> E m3507c(@NotNull Deferred<? extends T> deferred, @NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
            return (E) Job.C14776a.m5044e(deferred, interfaceC14277c);
        }

        @NotNull
        /* renamed from: d */
        public static <T> CoroutineContext m3506d(@NotNull Deferred<? extends T> deferred, @NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
            return Job.C14776a.m5042g(deferred, interfaceC14277c);
        }

        @NotNull
        /* renamed from: e */
        public static <T> CoroutineContext m3505e(@NotNull Deferred<? extends T> deferred, @NotNull CoroutineContext coroutineContext) {
            return Job.C14776a.m5041h(deferred, coroutineContext);
        }

        @Annotations(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        /* renamed from: f */
        public static <T> Job m3504f(@NotNull Deferred<? extends T> deferred, @NotNull Job job) {
            return Job.C14776a.m5040i(deferred, job);
        }
    }

    @NotNull
    /* renamed from: D */
    InterfaceC15195d<T> mo3494D();

    @ExperimentalCoroutinesApi
    /* renamed from: g */
    T mo3492g();

    @ExperimentalCoroutinesApi
    @Nullable
    /* renamed from: j */
    Throwable m3510j();

    @Nullable
    /* renamed from: m */
    Object mo3490m(@NotNull InterfaceC14268c<? super T> interfaceC14268c);
}
