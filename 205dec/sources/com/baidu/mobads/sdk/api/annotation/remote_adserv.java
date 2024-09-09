package com.baidu.mobads.sdk.api.annotation;

import com.baidu.mobads.sdk.api.AdservRemoteLoaderImpl;
import com.baidu.mobads.sdk.api.RouteInfo;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class remote_adserv {
    public static HashMap<String, RouteInfo> getRoutesMap() {
        HashMap<String, RouteInfo> hashMap = new HashMap<>();
        hashMap.put("remote_adserv", RouteInfo.build(AdservRemoteLoaderImpl.class, "remote_adserv"));
        return hashMap;
    }
}
