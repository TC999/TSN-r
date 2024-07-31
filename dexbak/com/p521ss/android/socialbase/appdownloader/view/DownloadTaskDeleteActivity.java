package com.p521ss.android.socialbase.appdownloader.view;

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
import com.p521ss.android.socialbase.appdownloader.C12360q;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12297bl;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12306r;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s;
import com.p521ss.android.socialbase.appdownloader.p547s.C12371ok;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.stub.StubApp;

/* renamed from: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloadTaskDeleteActivity extends Activity {

    /* renamed from: a */
    private Intent f34870a;

    /* renamed from: ok */
    private InterfaceC12306r f34871ok;

    static {
        StubApp.interface11(22964);
    }

    /* renamed from: a */
    private void m18015a() {
        Intent intent;
        if (this.f34871ok != null || (intent = this.f34870a) == null) {
            return;
        }
        try {
            final boolean z = false;
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
            String format = String.format(getString(C12360q.m18083ok(this, "tt_appdownloader_notification_download_delete")), title);
            InterfaceC12297bl m18065ok = C12361s.m18068k().m18065ok();
            InterfaceC12299j mo18390ok = m18065ok != null ? m18065ok.mo18390ok(this) : null;
            if (mo18390ok == null) {
                mo18390ok = new C12371ok(this);
            }
            int m18083ok = C12360q.m18083ok(this, "tt_appdownloader_tip");
            int m18083ok2 = C12360q.m18083ok(this, "tt_appdownloader_label_ok");
            int m18083ok3 = C12360q.m18083ok(this, "tt_appdownloader_label_cancel");
            if (C12534ok.m17599ok(downloadInfo.getId()).m17593ok("cancel_with_net_opt", 0) == 1 && C12713kf.m16530p() && downloadInfo.getCurBytes() != downloadInfo.getTotalBytes()) {
                z = true;
            }
            if (z) {
                m18083ok2 = C12360q.m18083ok(this, "tt_appdownloader_label_reserve_wifi");
                m18083ok3 = C12360q.m18083ok(this, "tt_appdownloader_label_cancel_directly");
                format = getResources().getString(C12360q.m18083ok(this, "tt_appdownloader_resume_in_wifi"));
            }
            mo18390ok.mo18021ok(m18083ok).mo18018ok(format).mo18020ok(m18083ok2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (!z) {
                        DownloadTaskDeleteActivity.this.m18012ok(downloadInfo, intExtra);
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
            }).mo18023a(m18083ok3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (z) {
                        DownloadTaskDeleteActivity.this.m18012ok(downloadInfo, intExtra);
                    }
                    DownloadTaskDeleteActivity.this.finish();
                }
            }).mo18019ok(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    DownloadTaskDeleteActivity.this.finish();
                }
            });
            this.f34871ok = mo18390ok.mo18022ok();
        } catch (Exception e) {
            e.printStackTrace();
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
        this.f34870a = getIntent();
        m18015a();
        InterfaceC12306r interfaceC12306r = this.f34871ok;
        if (interfaceC12306r != null && !interfaceC12306r.mo18017a()) {
            this.f34871ok.mo18016ok();
        } else if (this.f34871ok == null) {
            finish();
        }
    }

    /* renamed from: ok */
    private void m18014ok() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m18012ok(DownloadInfo downloadInfo, int i) {
        InterfaceC12308s m18079a = C12361s.m18068k().m18079a();
        if (m18079a != null) {
            m18079a.mo18382ok(downloadInfo);
        }
        InterfaceC12427ep downloadNotificationEventListener = Downloader.getInstance(C12490bl.m17807l()).getDownloadNotificationEventListener(i);
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.mo16630ok(10, downloadInfo, "", "");
        }
        if (C12490bl.m17807l() != null) {
            Downloader.getInstance(C12490bl.m17807l()).cancel(i);
        }
    }
}
