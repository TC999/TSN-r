package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.RouteInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.sdk.internal.ap */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2600ap extends RouteInfo {

    /* renamed from: a */
    private InterfaceC2727w f8600a;

    public C2600ap(String str) {
        setPath(str);
        m50974b();
    }

    /* renamed from: b */
    private void m50974b() {
        RouteInfo routeInfo;
        try {
            Method declaredMethod = Class.forName(C2736x.f9297at + getPath()).getDeclaredMethod("getRoutesMap", new Class[0]);
            declaredMethod.setAccessible(true);
            HashMap hashMap = (HashMap) declaredMethod.invoke(null, new Object[0]);
            if (hashMap == null || hashMap.size() <= 0 || (routeInfo = (RouteInfo) hashMap.get(getPath())) == null) {
                return;
            }
            this.f8600a = (InterfaceC2727w) routeInfo.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public Object m50975a() {
        return this.f8600a;
    }
}
