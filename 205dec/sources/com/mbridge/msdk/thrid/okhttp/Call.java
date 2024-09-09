package com.mbridge.msdk.thrid.okhttp;

import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Call extends Cloneable {

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface Factory {
        Call newCall(Request request);
    }

    void cancel();

    Call clone();

    void enqueue(Callback callback);

    Response execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    Request request();

    Timeout timeout();
}
