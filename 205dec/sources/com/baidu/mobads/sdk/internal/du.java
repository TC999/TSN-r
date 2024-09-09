package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class du {

    /* renamed from: a  reason: collision with root package name */
    private Boolean f12825a;

    public du(Context context, Activity activity, Boolean bool) {
        this.f12825a = bool;
        a().booleanValue();
    }

    public Boolean a() {
        return this.f12825a;
    }

    protected HashMap<String, String> b() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("xyz", "hihihi");
        return hashMap;
    }

    public String c() {
        return null;
    }
}
