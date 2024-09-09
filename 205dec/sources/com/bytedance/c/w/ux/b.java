package com.bytedance.c.w.ux;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.api.plugin.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f26574a;

    public b(Context context) {
        this.f26574a = w.w(context, "npth", 0);
    }

    public String a() {
        String d4 = com.bytedance.c.w.d.a().d();
        return (TextUtils.isEmpty(d4) || "0".equals(d4)) ? this.f26574a.getString("device_id", "0") : d4;
    }

    public void b(String str) {
        this.f26574a.edit().putString("device_id", str).apply();
    }
}
