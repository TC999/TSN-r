package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.bl.bl;
import com.ss.android.socialbase.appdownloader.bl.j;
import com.ss.android.socialbase.appdownloader.bl.r;
import com.ss.android.socialbase.appdownloader.q;
import com.ss.android.socialbase.appdownloader.s;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.q.kf;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DownloadTaskDeleteActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private Intent f49239a;
    private r ok;

    static {
        StubApp.interface11(22964);
    }

    private void a() {
        Intent intent;
        if (this.ok != null || (intent = this.f49239a) == null) {
            return;
        }
        try {
            final boolean z3 = false;
            final int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
            final DownloadInfo downloadInfo = Downloader.getInstance(StubApp.getOrigApplicationContext(getApplicationContext())).getDownloadInfo(intExtra);
            if (downloadInfo == null) {
                return;
            }
            String title = downloadInfo.getTitle();
            if (TextUtils.isEmpty(title)) {
                Log.w("DeleteActivity", "Missing appName; skipping handle");
                return;
            }
            String format = String.format(getString(q.ok(this, "tt_appdownloader_notification_download_delete")), title);
            bl ok = s.k().ok();
            j ok2 = ok != null ? ok.ok(this) : null;
            if (ok2 == null) {
                ok2 = new com.ss.android.socialbase.appdownloader.s.ok(this);
            }
            int ok3 = q.ok(this, "tt_appdownloader_tip");
            int ok4 = q.ok(this, "tt_appdownloader_label_ok");
            int ok5 = q.ok(this, "tt_appdownloader_label_cancel");
            if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("cancel_with_net_opt", 0) == 1 && kf.p() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                z3 = true;
            }
            if (z3) {
                ok4 = q.ok(this, "tt_appdownloader_label_reserve_wifi");
                ok5 = q.ok(this, "tt_appdownloader_label_cancel_directly");
                format = getResources().getString(q.ok(this, "tt_appdownloader_resume_in_wifi"));
            }
            ok2.ok(ok3).ok(format).ok(ok4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (!z3) {
                        DownloadTaskDeleteActivity.this.ok(downloadInfo, intExtra);
                    } else {
                        downloadInfo.setOnlyWifi(true);
                        Downloader.getInstance(DownloadTaskDeleteActivity.this).pause(downloadInfo.getId());
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Downloader.getInstance(DownloadTaskDeleteActivity.this).resume(downloadInfo.getId());
                            }
                        }, 100L);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).a(ok5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (z3) {
                        DownloadTaskDeleteActivity.this.ok(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).ok(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    DownloadTaskDeleteActivity.this.finish();
                }
            });
            this.ok = ok2.ok();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f49239a = getIntent();
        a();
        r rVar = this.ok;
        if (rVar != null && !rVar.a()) {
            this.ok.ok();
        } else if (this.ok == null) {
            finish();
        }
    }

    private void ok() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(DownloadInfo downloadInfo, int i4) {
        com.ss.android.socialbase.appdownloader.bl.s a4 = s.k().a();
        if (a4 != null) {
            a4.ok(downloadInfo);
        }
        ep downloadNotificationEventListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getDownloadNotificationEventListener(i4);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.ok(10, downloadInfo, "", "");
        }
        if (com.ss.android.socialbase.downloader.downloader.bl.l() != null) {
            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).cancel(i4);
        }
    }
}
