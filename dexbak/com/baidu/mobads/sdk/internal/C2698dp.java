package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.sdk.internal.dp */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2698dp {

    /* renamed from: a */
    private Boolean f9015a;

    public C2698dp(Context context, Activity activity, Boolean bool) {
        this.f9015a = bool;
        m50484a().booleanValue();
    }

    /* renamed from: a */
    public Boolean m50484a() {
        return this.f9015a;
    }

    /* renamed from: b */
    protected HashMap<String, String> m50483b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    /* renamed from: c */
    public String m50482c() {
        return "http://211.151.146.65:8080/wlantest/shanghai_sun/mock_ad_server_intersitial_video.json";
    }
}
