package com.beizi.p051ad.alipay.inter;

import java.util.Map;

/* renamed from: com.beizi.ad.alipay.inter.BaseListener */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface BaseListener {
    void failCallback(int i, String str);

    void successCallBack(Map<String, Object> map);
}
