package com.bytedance.sdk.openadsdk.live;

import android.os.Bundle;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public interface ILiveAdCustomConfig {
    String convertToEnterFromMerge(int i4);

    String convertToEnterMethod(int i4, boolean z3);

    Object invoke(int i4, Bundle bundle);

    void onEventV3(String str, JSONObject jSONObject);

    int openLR(String str);
}
