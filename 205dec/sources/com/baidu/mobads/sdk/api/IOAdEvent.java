package com.baidu.mobads.sdk.api;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public interface IOAdEvent {
    int getCode();

    Map<String, Object> getData();

    String getMessage();

    Object getTarget();

    String getType();

    void setTarget(Object obj);
}
