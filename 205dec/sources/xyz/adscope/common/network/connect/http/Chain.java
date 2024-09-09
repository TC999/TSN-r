package xyz.adscope.common.network.connect.http;

import xyz.adscope.common.network.Request;
import xyz.adscope.common.network.Response;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public interface Chain {
    Call call();

    @Deprecated
    Call newCall();

    Response proceed(Request request);

    Request request();
}
