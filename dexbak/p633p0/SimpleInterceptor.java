package p633p0;

import android.content.Context;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import okhttp3.Interceptor;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\n"}, m12616d2 = {"Lp0/b;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "simpleinterceptor-release_release"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: p0.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SimpleInterceptor implements Interceptor {
    public SimpleInterceptor(@Nullable Context context) {
    }

    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        C14342f0.m8183q(chain, "chain");
        return chain.proceed(chain.request());
    }
}
