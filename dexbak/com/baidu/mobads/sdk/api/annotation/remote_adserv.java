package com.baidu.mobads.sdk.api.annotation;

import com.baidu.mobads.sdk.api.AdservRemoteLoaderImpl;
import com.baidu.mobads.sdk.api.RouteInfo;
import com.baidu.mobads.sdk.internal.C2645c;
import java.util.HashMap;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class remote_adserv {
    public static HashMap<String, RouteInfo> getRoutesMap() {
        HashMap<String, RouteInfo> hashMap = new HashMap<>();
        hashMap.put(C2645c.InterfaceC2646a.f8795a, RouteInfo.build(AdservRemoteLoaderImpl.class, C2645c.InterfaceC2646a.f8795a));
        return hashMap;
    }
}
