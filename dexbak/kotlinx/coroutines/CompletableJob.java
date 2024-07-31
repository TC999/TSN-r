package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0007"}, m12616d2 = {"Lkotlinx/coroutines/b0;", "Lkotlinx/coroutines/e2;", "", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "", "exception", "c", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.b0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface CompletableJob extends Job {

    /* compiled from: CompletableJob.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.b0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C14627a {
        /* renamed from: b */
        public static <R> R m5728b(@NotNull CompletableJob completableJob, R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
            return (R) Job.C14776a.m5045d(completableJob, r, interfaceC15284p);
        }

        @Nullable
        /* renamed from: c */
        public static <E extends CoroutineContext.InterfaceC14275b> E m5727c(@NotNull CompletableJob completableJob, @NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
            return (E) Job.C14776a.m5044e(completableJob, interfaceC14277c);
        }

        @NotNull
        /* renamed from: d */
        public static CoroutineContext m5726d(@NotNull CompletableJob completableJob, @NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
            return Job.C14776a.m5042g(completableJob, interfaceC14277c);
        }

        @NotNull
        /* renamed from: e */
        public static CoroutineContext m5725e(@NotNull CompletableJob completableJob, @NotNull CoroutineContext coroutineContext) {
            return Job.C14776a.m5041h(completableJob, coroutineContext);
        }

        @Annotations(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        /* renamed from: f */
        public static Job m5724f(@NotNull CompletableJob completableJob, @NotNull Job job) {
            return Job.C14776a.m5040i(completableJob, job);
        }
    }

    /* renamed from: c */
    boolean mo4455c(@NotNull Throwable th);

    boolean complete();
}
