package com.beizi.fusion.alipay.inter;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface BaseListener {
    void failCallback(int i4, String str);

    void successCallBack(Map<String, Object> map);
}
