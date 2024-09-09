package xyz.adscope.common.network.connect.http;

import java.io.IOException;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.Interceptor;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class RetryInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public int f64890a;

    public RetryInterceptor(int i4) {
        this.f64890a = i4;
    }

    @Override // xyz.adscope.common.network.connect.Interceptor
    public Response intercept(Chain chain) {
        try {
            return chain.proceed(chain.request());
        } catch (IOException e4) {
            int i4 = this.f64890a;
            if (i4 > 0) {
                this.f64890a = i4 - 1;
                return intercept(chain);
            }
            throw e4;
        }
    }
}
