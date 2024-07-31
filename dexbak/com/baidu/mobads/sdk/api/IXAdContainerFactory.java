package com.baidu.mobads.sdk.api;

import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IXAdContainerFactory {
    Object getRemoteParam(String str, Object... objArr);

    double getRemoteVersion();

    void initCommonModuleObj(Object obj);

    void initConfig(JSONObject jSONObject);

    void onTaskDistribute(String str, JSONObject jSONObject);
}
