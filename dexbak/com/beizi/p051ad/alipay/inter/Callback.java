package com.beizi.p051ad.alipay.inter;

import org.json.JSONObject;

/* renamed from: com.beizi.ad.alipay.inter.Callback */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface Callback {
    void failCallback(int i, String str);

    void successCallback(JSONObject jSONObject);
}
