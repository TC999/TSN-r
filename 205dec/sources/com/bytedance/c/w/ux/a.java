package com.bytedance.c.w.ux;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.c.w.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f26571a;

    /* renamed from: b  reason: collision with root package name */
    private com.bytedance.c.w.g f26572b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Object> f26573c;

    public a(@NonNull Context context, @NonNull com.bytedance.c.w.g gVar) {
        this.f26571a = context;
        this.f26572b = gVar;
    }

    public static boolean b(Map<String, Object> map) {
        return map == null || map.isEmpty() || !((map.containsKey("app_version") || map.containsKey("version_name")) && map.containsKey("version_code") && map.containsKey("update_version_code"));
    }

    @Nullable
    public Map<String, Object> a() {
        Map<String, Object> c4 = this.f26572b.c();
        if (c4 == null) {
            c4 = new HashMap<>(4);
        }
        if (b(c4)) {
            try {
                PackageInfo packageInfo = this.f26571a.getPackageManager().getPackageInfo(this.f26571a.getPackageName(), 128);
                c4.put("version_name", packageInfo.versionName);
                c4.put("version_code", Integer.valueOf(packageInfo.versionCode));
                if (c4.get("update_version_code") == null) {
                    Bundle bundle = packageInfo.applicationInfo.metaData;
                    Object obj = bundle != null ? bundle.get("UPDATE_VERSION_CODE") : null;
                    if (obj == null) {
                        obj = c4.get("version_code");
                    }
                    c4.put("update_version_code", obj);
                }
            } catch (Throwable unused) {
                c4.put("version_name", b.e.j(this.f26571a));
                c4.put("version_code", Integer.valueOf(b.e.g(this.f26571a)));
                if (c4.get("update_version_code") == null) {
                    c4.put("update_version_code", c4.get("version_code"));
                }
            }
        }
        return c4;
    }

    public String c() {
        return b.e.i(this.f26571a);
    }

    public String d() {
        return this.f26572b.w();
    }

    @Nullable
    public Map<String, Object> e() {
        if (this.f26573c == null) {
            this.f26573c = this.f26572b.r();
        }
        return this.f26573c;
    }

    @NonNull
    public com.bytedance.c.w.g f() {
        return this.f26572b;
    }
}
