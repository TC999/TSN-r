package com.bytedance.embedapplog;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface IDataObserver {
    void onIdLoaded(String str, String str2, String str3);

    void onRemoteAbConfigGet(boolean z3, JSONObject jSONObject);

    void onRemoteConfigGet(boolean z3, JSONObject jSONObject);

    void onRemoteIdGet(boolean z3, String str, String str2, String str3, String str4, String str5, String str6);
}
