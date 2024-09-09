package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ds {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f12816a;

    public ds(Context context, Activity activity, Boolean bool) {
        this.f12816a = bool;
        a().booleanValue();
    }

    public Boolean a() {
        return this.f12816a;
    }

    protected HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    public String c() {
        return "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }
}
