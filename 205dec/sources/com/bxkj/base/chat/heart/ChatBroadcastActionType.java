package com.bxkj.base.chat.heart;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
@Retention(RetentionPolicy.SOURCE)
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public @interface ChatBroadcastActionType {
    public static final String NOTIFY_CONNECT_CLOSE = "NOTIFY_CONNECT_CLOSE";
    public static final String NOTIFY_HEART_CALLBACK_SUCCESS = "NOTIFY_HEART_CALLBACK_SUCCESS";
    public static final String NOTIFY_RECEIVER_MESSAGE = "NOTIFY_RECEIVER_MESSAGE";
    public static final String NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS = "NOTIFY_SEND_MESSAGE_CALLBACK_SUCCESS";
}
