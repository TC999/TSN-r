package com.beizi.ad.alipay.inter;

import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface Callback {
    void failCallback(int i4, String str);

    void successCallback(JSONObject jSONObject);
}
