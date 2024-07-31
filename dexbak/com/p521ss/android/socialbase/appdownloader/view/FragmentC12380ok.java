package com.p521ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.p521ss.android.socialbase.appdownloader.p545n.C12336s;
import com.p521ss.android.socialbase.downloader.constants.C12415n;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.stub.StubApp;

/* renamed from: com.ss.android.socialbase.appdownloader.view.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FragmentC12380ok extends Fragment {
    /* renamed from: kf */
    private Intent m18004kf() {
        Context m18003n = m18003n();
        if (m18003n == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = m18003n.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = m18003n.getApplicationInfo().uid;
        intent.putExtra("uid", i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    /* renamed from: n */
    private Context m18003n() {
        Context m17807l = C12490bl.m17807l();
        return (m17807l != null || getActivity() == null || getActivity().isFinishing()) ? m17807l : StubApp.getOrigApplicationContext(getActivity().getApplicationContext());
    }

    /* renamed from: s */
    public static Intent m18001s() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    /* renamed from: a */
    public Intent m18006a() {
        Context m18003n = m18003n();
        if (m18003n == null) {
            return null;
        }
        String packageName = m18003n.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(C12415n.f34986bl)) {
                Intent intent = new Intent();
                intent.putExtra(TTDownloadField.TT_PACKAGE_NAME, packageName);
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
                intent3.putExtra(TTDownloadField.TT_PACKAGE_NAME, packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + m18003n.getPackageName()));
    }

    /* renamed from: bl */
    public Intent m18005bl() {
        Context m18003n = m18003n();
        if (m18003n == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + m18003n.getPackageName()));
    }

    /* renamed from: ok */
    public void m18002ok() {
        try {
            try {
                try {
                    startActivityForResult(m18004kf(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(m18006a(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(m18001s(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(m18005bl(), 1000);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (C12336s.m18119ok()) {
            C12336s.m18116ok(true);
        } else {
            C12336s.m18116ok(false);
        }
    }
}
