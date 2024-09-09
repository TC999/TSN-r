package com.bytedance.pangle.sdk.component.log.impl.net;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface INetResponse {
    String getBody();

    int getCode();

    Map<String, String> getHeaders();

    String getMessage();

    boolean isSuccess();
}
