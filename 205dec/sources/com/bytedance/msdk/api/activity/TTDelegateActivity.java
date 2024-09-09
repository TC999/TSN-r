package com.bytedance.msdk.api.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.f;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.k;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.core.t.ux;
import com.bytedance.msdk.f.ls;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTDelegateActivity extends Activity {

    /* renamed from: c  reason: collision with root package name */
    private Intent f27437c;

    /* renamed from: com.bytedance.msdk.api.activity.TTDelegateActivity$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class AnonymousClass3 extends f {
        AnonymousClass3() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.f
        public void onDenied(String str) {
            Logger.d("TMe", "-------=----- onDenied: " + str);
            "android.permission.READ_PHONE_STATE".equals(str);
            TTDelegateActivity.this.b.execute(new updateDeviceInfoRunnable());
            TTDelegateActivity.this.finish();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.f
        public void onGranted() {
            Logger.d("TMe", "-------=----- onGranted");
            TTDelegateActivity.this.b.execute(new updateDeviceInfoRunnable());
            TTDelegateActivity.this.finish();
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            ls.k(com.bytedance.msdk.core.c.getContext());
        }
    }

    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public static class updateDeviceInfoRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            k.t(a.d());
        }
    }

    static {
        StubApp.interface11(15182);
    }

    private void c() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    private void w() {
        try {
            int intExtra = this.f27437c.getIntExtra("type", 0);
            if (intExtra == 1) {
                c(intExtra, this.f27437c.getIntArrayExtra(INTENT_PERMISSIONS));
            } else if (intExtra == 2) {
                c(this.f27437c.getStringExtra(PERMISSION_ID_KEY), this.f27437c.getStringArrayExtra("permission_content_key"));
            } else if (intExtra != 3) {
                finish();
            } else {
                c(intExtra, (int[]) null);
            }
        } catch (Exception unused) {
            finish();
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (com.bytedance.msdk.core.c.getContext() == null) {
            com.bytedance.msdk.core.c.c(this);
        }
        try {
            setIntent(intent);
            this.f27437c = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i4, @NonNull String[] strArr, @NonNull int[] iArr);

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            w();
        }
    }

    private void c(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    ux.c().c(this, strArr, new com.bytedance.msdk.core.t.f() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.1
                        @Override // com.bytedance.msdk.core.t.f
                        public void c() {
                            com.bytedance.msdk.core.t.c.c(str);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // com.bytedance.msdk.core.t.f
                        public void c(String str2) {
                            com.bytedance.msdk.core.t.c.c(str, str2);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            }
            xv.c("TTMediationSDK", "\u5df2\u7ecf\u6709\u6743\u9650");
            finish();
            return;
        }
        finish();
    }

    private void c(int i4, int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ArrayList arrayList = new ArrayList();
                if (i4 != 1) {
                    if (i4 == 3) {
                        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                        arrayList.add("android.permission.READ_PHONE_STATE");
                        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                    }
                } else if (iArr != null && iArr.length > 0) {
                    for (int i5 : iArr) {
                        if (i5 == 1) {
                            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
                            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
                        } else if (i5 == 2) {
                            arrayList.add("android.permission.READ_PHONE_STATE");
                        } else if (i5 == 3) {
                            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
                        }
                    }
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                ux.c().c(this, strArr, new com.bytedance.msdk.core.t.f() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.2
                    @Override // com.bytedance.msdk.core.t.f
                    public void c() {
                        xv.c("TMe", "-------=----- onGranted");
                        com.bytedance.msdk.adapter.sr.f.sr(new c());
                        TTDelegateActivity.this.finish();
                    }

                    @Override // com.bytedance.msdk.core.t.f
                    public void c(String str) {
                        xv.c("TMe", "-------=----- onDenied: " + str);
                        "android.permission.READ_PHONE_STATE".equals(str);
                        com.bytedance.msdk.adapter.sr.f.sr(new c());
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
                finish();
                return;
            }
        }
        xv.c("TTMediationSDK", "\u5df2\u7ecf\u6709Read phone state\u6743\u9650");
        finish();
    }
}
