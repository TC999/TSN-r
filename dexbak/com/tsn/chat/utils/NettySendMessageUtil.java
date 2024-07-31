package com.tsn.chat.utils;

import com.tsn.chat.model.RequestMessage;

/* renamed from: com.tsn.chat.utils.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NettySendMessageUtil {
    /* renamed from: a */
    public static Object m14858a(RequestMessage requestMessage) {
        Global.f37505a.writeAndFlush(requestMessage);
        return "response time out!";
    }
}
