package com.tsn.chat.utils;

import com.tsn.chat.model.RequestMessage;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: NettySendMessageUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {
    public static Object a(RequestMessage requestMessage) {
        b.f52403a.writeAndFlush(requestMessage);
        return "response time out!";
    }
}
