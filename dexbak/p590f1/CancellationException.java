package p590f1;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.daimajia.numberprogressbar.BuildConfig;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a!\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00060\u0004j\u0002`\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0087\b*\u001a\b\u0007\u0010\u000b\"\u00020\u00042\u00020\u0004B\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¨\u0006\f"}, m12616d2 = {"", "message", "", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlin/coroutines/cancellation/CancellationException;", "a", "b", "Lkotlin/SinceKotlin;", ConstantHelper.LOG_VS, BuildConfig.VERSION_NAME, "CancellationException", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: f1.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class CancellationException {
    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: a */
    private static final java.util.concurrent.CancellationException m12752a(String str, Throwable th) {
        java.util.concurrent.CancellationException cancellationException = new java.util.concurrent.CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    @InlineOnly
    /* renamed from: b */
    private static final java.util.concurrent.CancellationException m12751b(Throwable th) {
        java.util.concurrent.CancellationException cancellationException = new java.util.concurrent.CancellationException(th != null ? th.toString() : null);
        cancellationException.initCause(th);
        return cancellationException;
    }

    @SinceKotlin(version = BuildConfig.VERSION_NAME)
    /* renamed from: c */
    public static /* synthetic */ void m12750c() {
    }
}
