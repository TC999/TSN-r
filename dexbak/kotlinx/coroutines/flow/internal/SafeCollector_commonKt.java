package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Inference;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.InterfaceC14958h;
import kotlinx.coroutines.internal.Scopes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: SafeCollector.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u0005*\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0080\u0010\u001aP\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\b2/\b\u0005\u0010\u000e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\t¢\u0006\u0002\b\rH\u0081\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "Lkotlin/coroutines/f;", "currentContext", "Lkotlin/f1;", "a", "Lkotlinx/coroutines/e2;", "collectJob", "b", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/i;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/flow/h;", "c", "(Ll1/p;)Lkotlinx/coroutines/flow/h;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SafeCollector_commonKt {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, m12616d2 = {"", "count", "Lkotlin/coroutines/f$b;", "element", "a", "(ILkotlin/coroutines/f$b;)I"}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14977a extends Lambda implements InterfaceC15284p<Integer, CoroutineContext.InterfaceC14275b, Integer> {

        /* renamed from: a */
        final /* synthetic */ SafeCollector f42806a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C14977a(SafeCollector safeCollector) {
            super(2);
            this.f42806a = safeCollector;
        }

        /* renamed from: a */
        public final int m4798a(int i, @NotNull CoroutineContext.InterfaceC14275b interfaceC14275b) {
            CoroutineContext.InterfaceC14277c<?> key = interfaceC14275b.getKey();
            CoroutineContext.InterfaceC14275b interfaceC14275b2 = this.f42806a.collectContext.get(key);
            if (key != Job.f42281m0) {
                if (interfaceC14275b != interfaceC14275b2) {
                    return Integer.MIN_VALUE;
                }
                return i + 1;
            }
            Job job = (Job) interfaceC14275b2;
            Job m4801b = SafeCollector_commonKt.m4801b((Job) interfaceC14275b, job);
            if (m4801b == job) {
                return job == null ? i : i + 1;
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + m4801b + ", expected child of " + job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // p617l1.InterfaceC15284p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.InterfaceC14275b interfaceC14275b) {
            return Integer.valueOf(m4798a(num.intValue(), interfaceC14275b));
        }
    }

    @JvmName(name = "checkContext")
    /* renamed from: a */
    public static final void m4802a(@NotNull SafeCollector<?> safeCollector, @NotNull CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new C14977a(safeCollector))).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @Nullable
    /* renamed from: b */
    public static final Job m4801b(@Nullable Job job, @Nullable Job job2) {
        while (job != null) {
            if (job == job2 || !(job instanceof Scopes)) {
                return job;
            }
            job = ((Scopes) job).m4359s1();
        }
        return null;
    }

    @PublishedApi
    @NotNull
    /* renamed from: c */
    public static final <T> InterfaceC14958h<T> m4800c(@Inference @NotNull InterfaceC15284p<? super FlowCollector<? super T>, ? super InterfaceC14268c<? super Unit>, ? extends Object> interfaceC15284p) {
        return new SafeCollector_commonKt$unsafeFlow$1(interfaceC15284p);
    }
}
