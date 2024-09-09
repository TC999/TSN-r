package com.bytedance.pangle.sdk.component.log.impl.net;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IPostExecutor {
    void addHeader(String str, String str2);

    void enqueue(INetCallback iNetCallback);

    INetResponse execute();

    void setJson(String str);

    void setRequestBody(String str, byte[] bArr);

    void setUrl(String str);
}
