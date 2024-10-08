package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface Interceptor {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        @Nullable
        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i, TimeUnit timeUnit);

        Chain withReadTimeout(int i, TimeUnit timeUnit);

        Chain withWriteTimeout(int i, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    Response intercept(Chain chain) throws IOException;
}
