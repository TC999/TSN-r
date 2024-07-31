package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a.\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u001a!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/y;", "Lkotlin/Result;", CommonNetImpl.RESULT, "", "d", "(Lkotlinx/coroutines/y;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/e2;", "parent", "b", DomainCampaignEx.LOOPBACK_VALUE, "a", "(Ljava/lang/Object;)Lkotlinx/coroutines/y;", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.a0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableDeferred {
    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC15255y<T> m5756a(T t) {
        C15261z c15261z = new C15261z(null);
        c15261z.mo3488y(t);
        return c15261z;
    }

    @NotNull
    /* renamed from: b */
    public static final <T> InterfaceC15255y<T> m5755b(@Nullable Job job) {
        return new C15261z(job);
    }

    /* renamed from: c */
    public static /* synthetic */ InterfaceC15255y m5754c(Job job, int i, Object obj) {
        if ((i & 1) != 0) {
            job = null;
        }
        return m5755b(job);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static final <T> boolean m5753d(@NotNull InterfaceC15255y<T> interfaceC15255y, @NotNull Object obj) {
        Throwable m60151exceptionOrNullimpl = Result.m60151exceptionOrNullimpl(obj);
        return m60151exceptionOrNullimpl == null ? interfaceC15255y.mo3488y(obj) : interfaceC15255y.mo3493c(m60151exceptionOrNullimpl);
    }
}
