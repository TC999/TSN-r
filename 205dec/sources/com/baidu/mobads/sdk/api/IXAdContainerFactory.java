package com.baidu.mobads.sdk.api;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IXAdContainerFactory {
    Object getRemoteParam(String str, Object... objArr);

    double getRemoteVersion();

    void initCommonModuleObj(Object obj);

    void initConfig(JSONObject jSONObject);

    void onTaskDistribute(String str, JSONObject jSONObject);
}
