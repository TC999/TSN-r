package com.mbridge.msdk.thrid.okhttp;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, Response response) throws IOException;
}
