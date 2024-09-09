package xyz.adscope.common.network.connect.http;

import android.text.TextUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.RequestBody;
import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.StringBody;
import xyz.adscope.common.network.UrlBody;
import xyz.adscope.common.network.connect.Interceptor;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class LoggerInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final String f64888a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f64889b;

    public LoggerInterceptor(String str, boolean z3) {
        this.f64888a = str;
        this.f64889b = z3;
    }

    @Override // xyz.adscope.common.network.connect.Interceptor
    public Response intercept(Chain chain) {
        Request request = chain.request();
        boolean z3 = this.f64889b;
        Response proceed = chain.proceed(request);
        if (z3) {
            String url = request.url().toString();
            StringBuilder sb = new StringBuilder(String.format(" \nPrint Request: %1$s.", url));
            sb.append(String.format("\nMethod: %1$s.", request.method().name()));
            for (Map.Entry<String, List<String>> entry : request.headers().entrySet()) {
                sb.append(String.format("\n%1$s: %2$s.", entry.getKey(), TextUtils.join(";", entry.getValue())));
            }
            if (request.method().allowBody()) {
                RequestBody body = request.body();
                if ((body instanceof StringBody) || (body instanceof UrlBody)) {
                    sb.append(String.format(" \nRequest Body: %1$s.", body.toString()));
                }
            }
            sb.append(String.format(" \nPrint Response: %1$s.", url));
            sb.append(String.format(Locale.getDefault(), "\nCode: %1$d", Integer.valueOf(proceed.code())));
            for (Map.Entry<String, List<String>> entry2 : proceed.headers().entrySet()) {
                sb.append(String.format("\n%1$s: %2$s.", entry2.getKey(), TextUtils.join(";", entry2.getValue())));
            }
            LogUtil.i(this.f64888a, sb.toString());
        }
        return proceed;
    }
}
