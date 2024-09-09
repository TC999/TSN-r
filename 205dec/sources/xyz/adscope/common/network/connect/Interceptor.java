package xyz.adscope.common.network.connect;

import xyz.adscope.common.network.Response;
import xyz.adscope.common.network.connect.http.Chain;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface Interceptor {
    Response intercept(Chain chain);
}
