package kotlinx.coroutines.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThreadContext.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0081\b\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003HÂ\u0003J\u0017\u0010\u0006\u001a\u00020\u00002\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u000f¨\u0006\u0012"}, m12616d2 = {"Lkotlinx/coroutines/internal/q0;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/internal/p0;", "Ljava/lang/ThreadLocal;", "a", "threadLocal", "b", "", "toString", "", TTDownloadField.TT_HASHCODE, "", AdnName.OTHER, "", "equals", "Ljava/lang/ThreadLocal;", "<init>", "(Ljava/lang/ThreadLocal;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
@PublishedApi
/* renamed from: kotlinx.coroutines.internal.q0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15092q0 implements CoroutineContext.InterfaceC14277c<C15090p0<?>> {

    /* renamed from: a */
    private final ThreadLocal<?> f43077a;

    public C15092q0(@NotNull ThreadLocal<?> threadLocal) {
        this.f43077a = threadLocal;
    }

    /* renamed from: a */
    private final ThreadLocal<?> m4243a() {
        return this.f43077a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public static /* synthetic */ C15092q0 m4241c(C15092q0 c15092q0, ThreadLocal threadLocal, int i, Object obj) {
        if ((i & 1) != 0) {
            threadLocal = c15092q0.f43077a;
        }
        return c15092q0.m4242b(threadLocal);
    }

    @NotNull
    /* renamed from: b */
    public final C15092q0 m4242b(@NotNull ThreadLocal<?> threadLocal) {
        return new C15092q0(threadLocal);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof C15092q0) && C14342f0.m8193g(this.f43077a, ((C15092q0) obj).f43077a);
        }
        return true;
    }

    public int hashCode() {
        ThreadLocal<?> threadLocal = this.f43077a;
        if (threadLocal != null) {
            return threadLocal.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f43077a + ")";
    }
}
