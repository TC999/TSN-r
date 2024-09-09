package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class q extends i {

    /* renamed from: f  reason: collision with root package name */
    private final n f26784f;
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context, n nVar) {
        super(true, false);
        this.ux = context;
        this.f26784f = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    @SuppressLint({"MissingPermission"})
    public boolean c(JSONObject jSONObject) {
        jSONObject.put("os", "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", g.xv());
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put("cpu_abi", Build.CPU_ABI);
        jSONObject.put("build_serial", this.f26784f.m() ? c(this.ux) : this.f26784f.x());
        return true;
    }

    private static String c(Context context) {
        String str = null;
        if (context == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            try {
                str = Build.getSerial();
            } catch (Throwable unused) {
            }
        }
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) {
            str = Build.SERIAL;
        }
        return (TextUtils.isEmpty(str) || TextUtils.equals(str, "unknown")) ? "" : str;
    }
}
