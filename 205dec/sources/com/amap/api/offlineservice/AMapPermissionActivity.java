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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapPermissionActivity extends Activity {
    protected String[] needPermissions = new String[0];

    /* renamed from: a  reason: collision with root package name */
    private boolean f10855a = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i4) {
            try {
                AMapPermissionActivity.this.finish();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface dialogInterface, int i4) {
            try {
                AMapPermissionActivity.this.b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @TargetApi(23)
    private List<String> b(String[] strArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (Build.VERSION.SDK_INT >= 23 && getApplicationInfo().targetSdkVersion >= 23) {
                for (String str : strArr) {
                    if (a(str) != 0 || b(str)) {
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
    public void onRequestPermissionsResult(int i4, String[] strArr, int[] iArr) {
        try {
            StubApp.interface22(i4, strArr, iArr);
            if (Build.VERSION.SDK_INT < 23 || i4 != 0 || a(iArr)) {
                return;
            }
            a();
            this.f10855a = false;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        try {
            super.onResume();
            if (Build.VERSION.SDK_INT < 23 || !this.f10855a) {
                return;
            }
            a(this.needPermissions);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @TargetApi(23)
    private void a(String... strArr) {
        List<String> b4;
        try {
            if (Build.VERSION.SDK_INT < 23 || getApplicationInfo().targetSdkVersion < 23 || (b4 = b(strArr)) == null) {
                return;
            }
            if (b4.size() > 0) {
                try {
                    getClass().getMethod("requestPermissions", String[].class, Integer.TYPE).invoke(this, (String[]) b4.toArray(new String[b4.size()]), 0);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean b(String str) {
        try {
            return ((Boolean) getClass().getMethod("shouldShowRequestPermissionRationale", String.class).invoke(this, str)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private int a(String str) {
        try {
            return ((Integer) getClass().getMethod("checkSelfPermission", String.class).invoke(this, str)).intValue();
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.parse("package:" + getPackageName()));
            startActivity(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean a(int[] iArr) {
        try {
            for (int i4 : iArr) {
                if (i4 != 0) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return true;
        }
    }

    private void a() {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("\u63d0\u793a");
            builder.setMessage("\u5f53\u524d\u5e94\u7528\u7f3a\u5c11\u5fc5\u8981\u6743\u9650\u3002\n\n\u8bf7\u70b9\u51fb\"\u8bbe\u7f6e\"-\"\u6743\u9650\"-\u6253\u5f00\u6240\u9700\u6743\u9650");
            builder.setNegativeButton("\u53d6\u6d88", new a());
            builder.setPositiveButton("\u8bbe\u7f6e", new b());
            builder.setCancelable(false);
            builder.show();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
