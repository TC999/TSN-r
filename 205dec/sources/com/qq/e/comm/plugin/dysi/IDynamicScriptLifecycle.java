package com.qq.e.comm.plugin.dysi;

import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface IDynamicScriptLifecycle {
    void onAppBackground();

    void onAppForeground();

    void onBindData(JSONObject jSONObject);

    void onStartAnimation(String str);

    void onViewCreate();

    void onViewDestroy();
}
