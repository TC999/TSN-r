package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.RouteInfo;
import java.lang.reflect.Method;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class as extends RouteInfo {

    /* renamed from: a  reason: collision with root package name */
    private w f12416a;

    public as(String str) {
        setPath(str);
        b();
    }

    private void b() {
        RouteInfo routeInfo;
        try {
            Method declaredMethod = Class.forName(x.au + getPath()).getDeclaredMethod("getRoutesMap", new Class[0]);
            declaredMethod.setAccessible(true);
            HashMap hashMap = (HashMap) declaredMethod.invoke(null, new Object[0]);
            if (hashMap == null || hashMap.size() <= 0 || (routeInfo = (RouteInfo) hashMap.get(getPath())) == null) {
                return;
            }
            this.f12416a = (w) routeInfo.getDestination().getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable unused) {
        }
    }

    public Object a() {
        return this.f12416a;
    }
}
