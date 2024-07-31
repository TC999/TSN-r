package p641s;

import com.bxkj.base.p085v2.http.interceptor.DynamicTimeout;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import retrofit2.Invocation;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\b"}, m12616d2 = {"Ls/b;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "<init>", "()V", "base_release"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: s.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class HttpTimeoutInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) throws IOException {
        C14342f0.m8184p(chain, "chain");
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
