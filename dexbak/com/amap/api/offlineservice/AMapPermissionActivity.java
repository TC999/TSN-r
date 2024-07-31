package com.amap.api.offlineservice;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AMapPermissionActivity extends Activity {
    protected String[] needPermissions = new String[0];

    /* renamed from: a */
    private boolean f7157a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.offlineservice.AMapPermissionActivity$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class DialogInterface$OnClickListenerC2290a implements DialogInterface.OnClickListener {
        DialogInterface$OnClickListenerC2290a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                AMapPermissionActivity.this.finish();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.amap.api.offlineservice.AMapPermissionActivity$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class DialogInterface$OnClickListenerC2291b implements DialogInterface.OnClickListener {
        DialogInterface$OnClickListenerC2291b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i) {
            try {
                AMapPermissionActivity.this.m51972b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @TargetApi(23)
    /* renamed from: b */
    private List<String> m51970b(String[] strArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
                for (String str : strArr) {
                    if (m51975a(str) != 0 || m51971b(str)) {
                        arrayList.add(str);
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.app.Activity
    @TargetApi(23)
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        try {
            StubApp.interface22(i, strArr, iArr);
            if (Build.VERSION.SDK_INT < 23 || i != 0 || m51974a(iArr)) {
                return;
            }
            m51977a();
            this.f7157a = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            if (Build.VERSION.SDK_INT < 23 || !this.f7157a) {
                return;
            }
            m51973a(this.needPermissions);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @TargetApi(23)
    /* renamed from: a */
    private void m51973a(String... strArr) {
        List<String> m51970b;
        try {
            if (Build.VERSION.SDK_INT < 23 || getApplicationInfo().targetSdkVersion < 23 || (m51970b = m51970b(strArr)) == null) {
                return;
            }
            if (m51970b.size() > 0) {
                try {
                    getClass().getMethod("requestPermissions", String[].class, Integer.TYPE).invoke(this, (String[]) m51970b.toArray(new String[m51970b.size()]), 0);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private boolean m51971b(String str) {
        try {
            return ((Boolean) getClass().getMethod("shouldShowRequestPermissionRationale", String.class).invoke(this, str)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private int m51975a(String str) {
        try {
            return ((Integer) getClass().getMethod("checkSelfPermission", String.class).invoke(this, str)).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m51972b() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private static boolean m51974a(int[] iArr) {
        try {
            for (int i : iArr) {
                if (i != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    /* renamed from: a */
    private void m51977a() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("提示");
            builder.setMessage("当前应用缺少必要权限。\n\n请点击\"设置\"-\"权限\"-打开所需权限");
            builder.setNegativeButton("取消", new DialogInterface$OnClickListenerC2290a());
            builder.setPositiveButton("设置", new DialogInterface$OnClickListenerC2291b());
            builder.setCancelable(false);
            builder.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
