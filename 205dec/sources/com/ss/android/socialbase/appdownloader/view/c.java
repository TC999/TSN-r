package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.ux.sr;
import com.ss.android.socialbase.downloader.constants.ux;
import com.ss.android.socialbase.downloader.downloader.xv;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c extends Fragment {
    private Intent f() {
        Context ux = ux();
        if (ux == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = ux.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i4 = ux.getApplicationInfo().uid;
        intent.putExtra("uid", i4);
        intent.putExtra("app_uid", i4);
        return intent;
    }

    public static Intent sr() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    private Context ux() {
        Context gw = xv.gw();
        return (gw != null || getActivity() == null || getActivity().isFinishing()) ? gw : StubApp.getOrigApplicationContext(getActivity().getApplicationContext());
    }

    public void c() {
        try {
            try {
                try {
                    startActivityForResult(f(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(w(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(sr(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(xv(), 1000);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (sr.c()) {
            sr.c(true);
        } else {
            sr.c(false);
        }
    }

    public Intent w() {
        Context ux = ux();
        if (ux == null) {
            return null;
        }
        String packageName = ux.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(ux.xv)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            } else if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                } else {
                    intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                }
                return intent2;
            } else if (lowerCase.contains("meizu") && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra("packageName", packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + ux.getPackageName()));
    }

    public Intent xv() {
        Context ux = ux();
        if (ux == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + ux.getPackageName()));
    }
}
