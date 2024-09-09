package h1;

import android.content.Context;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SimpleInterceptor.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lh1/b;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "simpleinterceptor-release_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public final class b implements Interceptor {
    public b(@Nullable Context context) {
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        f0.q(chain, "chain");
        return chain.proceed(chain.request());
    }
}
