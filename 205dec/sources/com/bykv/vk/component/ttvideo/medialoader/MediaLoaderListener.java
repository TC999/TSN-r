package com.bykv.vk.component.ttvideo.medialoader;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface MediaLoaderListener {
    long getInt64Value(int i4, long j4);

    void onDataLoaderError(int i4, String str);

    void onLogInfo(int i4, String str, JSONObject jSONObject);

    void onNotify(int i4, long j4, long j5, String str);

    void onSwitchLoaderType(int i4, String str);
}
