package com.bytedance.sdk.openadsdk;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6465380.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public interface TTClientBidding {
    void loss(Double d4, String str, String str2);

    void setAdInteractionListener(TTAdInteractionListener tTAdInteractionListener);

    void setPrice(Double d4);

    void win(Double d4);
}
