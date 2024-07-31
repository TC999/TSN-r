package kotlinx.coroutines;

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
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¨\u0006\u0006"}, m12616d2 = {"Lkotlinx/coroutines/w;", "Lkotlinx/coroutines/e2;", "Lkotlinx/coroutines/u2;", "parentJob", "Lkotlin/f1;", "n", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.w */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface InterfaceC15244w extends Job {

    /* compiled from: Job.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.w$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C15245a {
        /* renamed from: b */
        public static <R> R m3527b(@NotNull InterfaceC15244w interfaceC15244w, R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
            return (R) Job.C14776a.m5045d(interfaceC15244w, r, interfaceC15284p);
        }

        @Nullable
        /* renamed from: c */
        public static <E extends CoroutineContext.InterfaceC14275b> E m3526c(@NotNull InterfaceC15244w interfaceC15244w, @NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
            return (E) Job.C14776a.m5044e(interfaceC15244w, interfaceC14277c);
        }

        @NotNull
        /* renamed from: d */
        public static CoroutineContext m3525d(@NotNull InterfaceC15244w interfaceC15244w, @NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
            return Job.C14776a.m5042g(interfaceC15244w, interfaceC14277c);
        }

        @NotNull
        /* renamed from: e */
        public static CoroutineContext m3524e(@NotNull InterfaceC15244w interfaceC15244w, @NotNull CoroutineContext coroutineContext) {
            return Job.C14776a.m5041h(interfaceC15244w, coroutineContext);
        }

        @Annotations(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
        @NotNull
        /* renamed from: f */
        public static Job m3523f(@NotNull InterfaceC15244w interfaceC15244w, @NotNull Job job) {
            return Job.C14776a.m5040i(interfaceC15244w, job);
        }
    }

    @InternalCoroutinesApi
    /* renamed from: n */
    void mo3529n(@NotNull InterfaceC15237u2 interfaceC15237u2);
}
