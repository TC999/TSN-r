package com.baidu.mobads.sdk.api;

import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface IOAdEvent {
    int getCode();

    Map<String, Object> getData();

    String getMessage();

    Object getTarget();

    String getType();

    void setTarget(Object obj);
}
