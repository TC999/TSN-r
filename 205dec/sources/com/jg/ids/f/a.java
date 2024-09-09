package com.jg.ids.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import com.jg.ids.g;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class a extends g {

    /* renamed from: b  reason: collision with root package name */
    private String f37823b;

    public a(Context context) {
        super(context);
    }

    @Override // com.jg.ids.g
    protected final Intent a() {
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f37823b);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.g
    public final void a(IBinder iBinder) {
        if (this.f37822a != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    String string = Settings.Global.getString(this.f37822a.getContentResolver(), "pps_oaid");
                    if (!TextUtils.isEmpty(string)) {
                        c(string);
                        return;
                    }
                }
                b a4 = c.a(iBinder);
                if (!a4.b()) {
                    String a5 = a4.a();
                    if (!TextUtils.isEmpty(a5)) {
                        c(a5);
                    }
                }
                b();
            } catch (Exception e4) {
            }
        }
    }

    @Override // com.jg.ids.f, com.jg.ids.i
    public final boolean d() {
        boolean z3 = true;
        if (this.f37822a == null) {
            return false;
        }
        try {
            PackageManager packageManager = this.f37822a.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f37823b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f37823b = "com.huawei.hwid.tv";
            } else {
                this.f37823b = "com.huawei.hms";
                if (packageManager.getPackageInfo(this.f37823b, 0) == null) {
                    z3 = false;
                }
            }
        } catch (Exception e4) {
            z3 = false;
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jg.ids.f
    public final boolean c() {
        return TextUtils.isEmpty(a(this.f37822a));
    }
}
