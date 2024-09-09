package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.n.s;
import com.ss.android.socialbase.downloader.constants.n;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok extends Fragment {
    private Intent kf() {
        Context n4 = n();
        if (n4 == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = n4.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i4 = n4.getApplicationInfo().uid;
        intent.putExtra("uid", i4);
        intent.putExtra("app_uid", i4);
        return intent;
    }

    private Context n() {
        Context l4 = bl.l();
        return (l4 != null || getActivity() == null || getActivity().isFinishing()) ? l4 : StubApp.getOrigApplicationContext(getActivity().getApplicationContext());
    }

    public static Intent s() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    public Intent a() {
        Context n4 = n();
        if (n4 == null) {
            return null;
        }
        String packageName = n4.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(n.bl)) {
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
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + n4.getPackageName()));
    }

    public Intent bl() {
        Context n4 = n();
        if (n4 == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + n4.getPackageName()));
    }

    public void ok() {
        try {
            try {
                try {
                    startActivityForResult(kf(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(a(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(s(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(bl(), 1000);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        super.onActivityResult(i4, i5, intent);
        if (s.ok()) {
            s.ok(true);
        } else {
            s.ok(false);
        }
    }
}
