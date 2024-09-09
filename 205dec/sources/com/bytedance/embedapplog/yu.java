package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class yu extends i {

    /* renamed from: f  reason: collision with root package name */
    private final n f26860f;
    private final Context ux;

    /* JADX INFO: Access modifiers changed from: package-private */
    public yu(Context context, n nVar) {
        super(false, false);
        this.ux = context;
        this.f26860f = nVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.i
    public boolean c(JSONObject jSONObject) {
        int i4;
        ApplicationInfo applicationInfo;
        int i5;
        String packageName = this.ux.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.f26860f.mt())) {
            jSONObject.put("package", packageName);
        } else {
            if (be.f26702w) {
                be.c("has zijie pkg", null);
            }
            jSONObject.put("package", this.f26860f.mt());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.ux.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i4 = packageInfo.versionCode;
            } catch (Throwable th) {
                be.w(th);
                return false;
            }
        } else {
            i4 = 0;
        }
        if (!TextUtils.isEmpty(this.f26860f.me())) {
            jSONObject.put("app_version", this.f26860f.me());
        } else {
            jSONObject.put("app_version", packageInfo != null ? packageInfo.versionName : "");
        }
        if (!TextUtils.isEmpty(this.f26860f.pr())) {
            jSONObject.put("app_version_minor", this.f26860f.pr());
        } else {
            jSONObject.put("app_version_minor", "");
        }
        if (this.f26860f.ba() != 0) {
            jSONObject.put("version_code", this.f26860f.ba());
        } else {
            jSONObject.put("version_code", i4);
        }
        if (this.f26860f.y() != 0) {
            jSONObject.put("update_version_code", this.f26860f.y());
        } else {
            jSONObject.put("update_version_code", i4);
        }
        if (this.f26860f.eq() != 0) {
            jSONObject.put("manifest_version_code", this.f26860f.eq());
        } else {
            jSONObject.put("manifest_version_code", i4);
        }
        if (!TextUtils.isEmpty(this.f26860f.z())) {
            jSONObject.put("app_name", this.f26860f.z());
        }
        if (!TextUtils.isEmpty(this.f26860f.wv())) {
            jSONObject.put("tweaked_channel", this.f26860f.wv());
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (i5 = applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.ux.getString(i5));
        return true;
    }
}
