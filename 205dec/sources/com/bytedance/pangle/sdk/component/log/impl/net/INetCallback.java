package com.bytedance.pangle.sdk.component.log.impl.net;

import java.io.IOException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface INetCallback {
    void onFailure(INetExecutor iNetExecutor, IOException iOException);

    void onResponse(INetExecutor iNetExecutor, INetResponse iNetResponse);
}
