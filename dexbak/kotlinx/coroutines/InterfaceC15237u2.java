package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: Job.kt */
@Annotations(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\f\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H'¨\u0006\u0005"}, m12616d2 = {"Lkotlinx/coroutines/u2;", "Lkotlinx/coroutines/e2;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.u2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface InterfaceC15237u2 extends Job {

    /* compiled from: Job.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.u2$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C15238a {
        /* renamed from: b */
        public static <R> R m3549b(@NotNull InterfaceC15237u2 interfaceC15237u2, R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
            return (R) Job.C14776a.m5045d(interfaceC15237u2, r, interfaceC15284p);
        }

        @Nullable
        /* renamed from: c */
        public static <E extends CoroutineContext.InterfaceC14275b> E m3548c(@NotNull InterfaceC15237u2 interfaceC15237u2, @NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
            return (E) Job.C14776a.m5044e(interfaceC15237u2, interfaceC14277c);
        }

        @NotNull
        /* renamed from: d */
        public static CoroutineContext m3547d(@NotNull InterfaceC15237u2 interfaceC15237u2, @NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
            return Job.C14776a.m5042g(interfaceC15237u2, interfaceC14277c);
        }

        @NotNull
        /* renamed from: e */
        public static CoroutineContext m3546e(@NotNull InterfaceC15237u2 interfaceC15237u2, @NotNull CoroutineContext coroutineContext) {
            return Job.C14776a.m5041h(interfaceC15237u2, coroutineContext);
        }

        @Annotations(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        /* renamed from: f */
        public static Job m3545f(@NotNull InterfaceC15237u2 interfaceC15237u2, @NotNull Job job) {
            return Job.C14776a.m5040i(interfaceC15237u2, job);
        }
    }

    @InternalCoroutinesApi
    @NotNull
    /* renamed from: A */
    CancellationException mo3551A();
}
