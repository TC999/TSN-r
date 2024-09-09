package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.os.Looper;
import android.view.View;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ia extends com.bytedance.sdk.component.adexpress.w.c<BackupView> {

    /* renamed from: c  reason: collision with root package name */
    private BackupView f34082c;

    /* renamed from: f  reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.w.bk f34083f;
    private com.bytedance.sdk.component.adexpress.w.xv sr;
    private com.bytedance.sdk.component.adexpress.w.r ux;

    /* renamed from: w  reason: collision with root package name */
    private View f34084w;
    private ThemeStatusBroadcastReceiver xv;

    public ia(View view, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, com.bytedance.sdk.component.adexpress.w.bk bkVar) {
        this.f34084w = view;
        this.xv = themeStatusBroadcastReceiver;
        this.f34083f = bkVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        com.bytedance.sdk.component.adexpress.w.xv xvVar = this.sr;
        boolean z3 = false;
        if (xvVar != null && xvVar.c((NativeExpressView) this.f34084w, 0)) {
            z3 = true;
        }
        if (!z3) {
            this.ux.c(107, (String) null);
            return;
        }
        this.f34083f.ux().ys();
        BackupView backupView = (BackupView) this.f34084w.findViewWithTag("tt_express_backup_fl_tag_26");
        this.f34082c = backupView;
        if (backupView != null) {
            backupView.setThemeChangeReceiver(this.xv);
            com.bytedance.sdk.component.adexpress.w.t tVar = new com.bytedance.sdk.component.adexpress.w.t();
            BackupView backupView2 = this.f34082c;
            float realWidth = backupView2 == null ? 0.0f : backupView2.getRealWidth();
            BackupView backupView3 = this.f34082c;
            float realHeight = backupView3 != null ? backupView3.getRealHeight() : 0.0f;
            tVar.c(true);
            tVar.c(realWidth);
            tVar.w(realHeight);
            this.ux.c(this.f34082c, tVar);
            return;
        }
        this.ux.c(107, (String) null);
    }

    @Override // com.bytedance.sdk.component.adexpress.w.sr
    public void c(com.bytedance.sdk.component.adexpress.w.r rVar) {
        this.ux = rVar;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            w();
        } else {
            com.bytedance.sdk.openadsdk.core.q.f().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.ia.1
                @Override // java.lang.Runnable
                public void run() {
                    ia.this.w();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.w.sr
    /* renamed from: c */
    public BackupView r() {
        return this.f34082c;
    }

    @Override // com.bytedance.sdk.component.adexpress.w.c
    public void c(com.bytedance.sdk.component.adexpress.w.xv xvVar) {
        this.sr = xvVar;
    }
}
