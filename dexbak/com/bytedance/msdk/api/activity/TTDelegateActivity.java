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
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.CommonPermissionUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.PermissionsManager;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.PermissionsResultAction;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.ActivityUtil;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IdUtils;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.api.TTAdConstant;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class TTDelegateActivity extends Activity {
    public static final String INTENT_PERMISSIONS = "permissions";
    public static final String INTENT_TYPE = "type";
    public static final int INTENT_TYPE_ALL_PERMISSIONS_CHECK = 3;
    public static final int INTENT_TYPE_PERMISSIONS_CHECK = 1;
    public static final int INTENT_TYPE_REQUEST_PERMISSION = 2;
    public static final String PERMISSION_CONTENT_KEY = "permission_content_key";
    public static final String PERMISSION_ID_KEY = "permission_id_key";

    /* renamed from: a */
    private Intent f21706a;

    /* renamed from: b */
    ExecutorService f21707b = Executors.newSingleThreadExecutor();

    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class updateDeviceInfoRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            IdUtils.m59175t(InternalContainer.m59945d());
        }
    }

    static {
        StubApp.interface11(13202);
    }

    /* renamed from: a */
    private void m37455a() {
        try {
            int intExtra = this.f21706a.getIntExtra("type", 0);
            if (intExtra == 1) {
                m37454b(intExtra, this.f21706a.getIntArrayExtra(INTENT_PERMISSIONS));
            } else if (intExtra == 2) {
                m37453c(this.f21706a.getStringExtra(PERMISSION_ID_KEY), this.f21706a.getStringArrayExtra(PERMISSION_CONTENT_KEY));
            } else if (intExtra != 3) {
                finish();
            } else {
                m37454b(intExtra, null);
            }
        } catch (Exception unused) {
            finish();
        }
    }

    /* renamed from: b */
    private void m37454b(int i, int[] iArr) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ArrayList arrayList = new ArrayList();
                if (i != 1) {
                    if (i == 3) {
                        arrayList.add(C7282g.f24950h);
                        arrayList.add(C7282g.f24949g);
                        arrayList.add(C7282g.f24945c);
                        arrayList.add(C7282g.f24952j);
                    }
                } else if (iArr != null && iArr.length > 0) {
                    for (int i2 : iArr) {
                        if (i2 == 1) {
                            arrayList.add(C7282g.f24950h);
                            arrayList.add(C7282g.f24949g);
                        } else if (i2 == 2) {
                            arrayList.add(C7282g.f24945c);
                        } else if (i2 == 3) {
                            arrayList.add(C7282g.f24952j);
                        }
                    }
                }
                String[] strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
                PermissionsManager.m59824a().m59823a(this, strArr, new PermissionsResultAction() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.3
                    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.PermissionsResultAction
                    public void onDenied(String str) {
                        Logger.m37562d("TMe", "-------=----- onDenied: " + str);
                        C7282g.f24945c.equals(str);
                        TTDelegateActivity.this.f21707b.execute(new updateDeviceInfoRunnable());
                        TTDelegateActivity.this.finish();
                    }

                    @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.PermissionsResultAction
                    public void onGranted() {
                        Logger.m37562d("TMe", "-------=----- onGranted");
                        TTDelegateActivity.this.f21707b.execute(new updateDeviceInfoRunnable());
                        TTDelegateActivity.this.finish();
                    }
                });
                return;
            } catch (Exception unused) {
                finish();
                return;
            }
        }
        Logger.m37562d(TTAdConstant.TAG, "已经有Read phone state权限");
        finish();
    }

    /* renamed from: c */
    private void m37453c(final String str, String[] strArr) {
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    PermissionsManager.m59824a().m59823a(this, strArr, new PermissionsResultAction() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.2
                        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.PermissionsResultAction
                        public void onDenied(String str2) {
                            CommonPermissionUtils.m59833a(str, str2);
                            TTDelegateActivity.this.finish();
                        }

                        @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.PermissionsResultAction
                        public void onGranted() {
                            CommonPermissionUtils.m59834a(str);
                            TTDelegateActivity.this.finish();
                        }
                    });
                    return;
                } catch (Exception unused) {
                    finish();
                    return;
                }
            }
            Logger.m37562d(TTAdConstant.TAG, "已经有权限");
            finish();
            return;
        }
        finish();
    }

    /* renamed from: d */
    private void m37452d() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    public static void requestPermission(String str, String[] strArr) {
        Intent intent = new Intent(InternalContainer.m59945d(), TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 2);
        intent.putExtra(PERMISSION_ID_KEY, str);
        intent.putExtra(PERMISSION_CONTENT_KEY, strArr);
        if (InternalContainer.m59945d() != null) {
            ActivityUtil.m59251a(InternalContainer.m59945d(), intent, new ActivityUtil.InterfaceC0981a() { // from class: com.bytedance.msdk.api.activity.TTDelegateActivity.1
                @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.ActivityUtil.InterfaceC0981a
                public void startActivityFail(Throwable th) {
                    Logger.m37558e("requestPermission->startActivity error :" + th.toString());
                }

                @Override // bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.ActivityUtil.InterfaceC0981a
                public void startActivitySuccess() {
                }
            });
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
        if (InternalContainer.m59945d() == null) {
            InternalContainer.m59947b(this);
        }
        try {
            setIntent(intent);
            this.f21706a = intent;
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Activity
    public native void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr);

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (getIntent() != null) {
            m37455a();
        }
    }
}
