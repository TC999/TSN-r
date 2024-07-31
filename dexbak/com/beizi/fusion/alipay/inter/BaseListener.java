package com.beizi.fusion.alipay.inter;

import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface BaseListener {
    void failCallback(int i, String str);

    void successCallBack(Map<String, Object> map);
}
