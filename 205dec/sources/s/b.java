package s;

import com.bxkj.base.v2.http.interceptor.DynamicTimeout;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import retrofit2.Invocation;

/* compiled from: HttpTimeoutInterceptor.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Ls/b;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class b implements Interceptor {
    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        f0.p(chain, "chain");
        Request request = chain.request();
        Invocation invocation = (Invocation) request.tag(Invocation.class);
        Method method = invocation == null ? null : invocation.method();
        DynamicTimeout dynamicTimeout = method != null ? (DynamicTimeout) method.getAnnotation(DynamicTimeout.class) : null;
        if (dynamicTimeout != null && dynamicTimeout.timeout() > 0) {
            int timeout = dynamicTimeout.timeout();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            return chain.withConnectTimeout(timeout, timeUnit).withReadTimeout(dynamicTimeout.timeout(), timeUnit).withWriteTimeout(dynamicTimeout.timeout(), timeUnit).proceed(request);
        }
        return chain.proceed(request);
    }
}
