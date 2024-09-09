package com.bytedance.pangle.sdk.component.log.impl.net;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IGetExecutor {
    void addHeader(String str, String str2);

    INetResponse execute();

    void setUrl(String str);
}
