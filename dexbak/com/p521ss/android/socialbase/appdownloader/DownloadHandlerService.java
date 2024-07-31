package com.p521ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s;
import com.p521ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12515s;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.AbstractC12645ok;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;

/* renamed from: com.ss.android.socialbase.appdownloader.DownloadHandlerService */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloadHandlerService extends Service {

    /* renamed from: ok */
    private static final String f34621ok;

    static {
        StubApp.interface11(22864);
        f34621ok = DownloadHandlerService.class.getSimpleName();
    }

    /* renamed from: a */
    private void m18492a(@NonNull DownloadInfo downloadInfo, InterfaceC12308s interfaceC12308s, InterfaceC12427ep interfaceC12427ep) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        startActivity(intent);
        C12644a.m16876ok().m16875ok(id);
        downloadInfo.updateDownloadTime();
        if (interfaceC12308s != null) {
            interfaceC12308s.mo18386ok(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (interfaceC12427ep != null) {
            interfaceC12427ep.mo16630ok(7, downloadInfo, "", "");
        }
    }

    /* renamed from: ok */
    private boolean m18487ok(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        InterfaceC12308s m18079a = C12361s.m18068k().m18079a();
        InterfaceC12427ep downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        boolean z = true;
        if (intent.getBooleanExtra("extra_from_notification", false) && C12534ok.m17599ok(intExtra).m17607a("notification_opt_2") == 1) {
            C12644a.m16876ok().m16878kf(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            m18486ok(downloadInfo, m18079a, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            m18488ok(this, downloadInfo, m18079a, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            m18488ok(this, downloadInfo, m18079a, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && C12534ok.m17599ok(intExtra).m17593ok("no_hide_notification", 0) == 0) {
                if (!((C12534ok.m17599ok(intExtra).m17607a("enable_notification_ui") < 2 || downloadInfo.getStatus() != -1) ? false : false)) {
                    C12644a.m16876ok().m16875ok(intExtra);
                    C12644a.m16876ok().m16878kf(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            m18492a(downloadInfo, m18079a, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            C12644a.m16876ok().m16875ok(intExtra);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(C12490bl.m17807l()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            return true;
        }
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C12490bl.m17799ok(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        if (C12409ok.m17899ok()) {
            C12409ok.m17904a(f34621ok, "onStartCommand");
        }
        m18487ok(intent);
        stopSelf();
        return 2;
    }

    /* renamed from: ok */
    private static void m18489ok(Context context, DownloadInfo downloadInfo) {
        if (C12713kf.m16620a(StubApp.getOrigApplicationContext(context.getApplicationContext())) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    /* renamed from: ok */
    private static void m18490ok(Context context, final InterfaceC12308s interfaceC12308s, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final InterfaceC12427ep downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (interfaceC12308s == null && downloadNotificationEventListener == null) {
            return;
        }
        C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo m18412ok;
                try {
                    File file = new File(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                    if (file.exists()) {
                        try {
                            String str = (C12490bl.m17807l() == null || (m18412ok = C12293bl.m18412ok(DownloadInfo.this, file)) == null) ? "" : m18412ok.packageName;
                            InterfaceC12308s interfaceC12308s2 = interfaceC12308s;
                            if (interfaceC12308s2 != null) {
                                interfaceC12308s2.mo18386ok(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                            }
                            InterfaceC12427ep interfaceC12427ep = downloadNotificationEventListener;
                            if (interfaceC12427ep != null) {
                                interfaceC12427ep.mo16630ok(3, DownloadInfo.this, str, "");
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m18486ok(@androidx.annotation.NonNull com.p521ss.android.socialbase.downloader.model.DownloadInfo r8, com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s r9, com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep r10) {
        /*
            r7 = this;
            int r1 = r8.getId()
            com.ss.android.socialbase.downloader.downloader.s r0 = com.p521ss.android.socialbase.downloader.downloader.C12515s.m17660ok()
            com.ss.android.socialbase.downloader.depend.v r0 = r0.m17634z(r1)
            if (r0 == 0) goto L17
            boolean r0 = r0.mo16678ok(r8)     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r0 = move-exception
            r0.printStackTrace()
        L17:
            r0 = 0
        L18:
            if (r0 != 0) goto L51
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity> r2 = com.p521ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.class
            r0.<init>(r7, r2)
            java.lang.String r2 = "extra_click_download_ids"
            r0.putExtra(r2, r1)
            r2 = 268435456(0x10000000, float:2.524355E-29)
            r0.addFlags(r2)
            r7.startActivity(r0)
            com.ss.android.socialbase.downloader.notification.a r0 = com.p521ss.android.socialbase.downloader.notification.C12644a.m16876ok()
            r0.m16875ok(r1)
            r8.updateDownloadTime()
            if (r9 == 0) goto L49
            r2 = 7
            int r4 = r8.getStatus()
            long r5 = r8.getDownloadTime()
            java.lang.String r3 = ""
            r0 = r9
            r0.mo18386ok(r1, r2, r3, r4, r5)
        L49:
            if (r10 == 0) goto L51
            r9 = 7
            java.lang.String r0 = ""
            r10.mo16630ok(r9, r8, r0, r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.appdownloader.DownloadHandlerService.m18486ok(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.appdownloader.bl.s, com.ss.android.socialbase.downloader.depend.ep):void");
    }

    /* renamed from: ok */
    private static void m18491ok(Context context, int i, boolean z) {
        boolean z2;
        InterfaceC12480v m17634z;
        DownloadInfo downloadInfo;
        if (z && (m17634z = C12515s.m17660ok().m17634z(i)) != null) {
            try {
                downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (downloadInfo != null) {
                z2 = m17634z.mo16680a(downloadInfo);
                if (z2 && C12293bl.m18422ok(context, i, true) == 0) {
                    Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z2 = false;
        if (z2) {
            return;
        }
        Toast.makeText(context, "Open Fail!", 0).show();
    }

    /* renamed from: ok */
    public static void m18488ok(Context context, DownloadInfo downloadInfo, InterfaceC12308s interfaceC12308s, InterfaceC12427ep interfaceC12427ep) {
        AbstractC12645ok m16877n;
        int id = downloadInfo.getId();
        InterfaceC12480v m17634z = C12515s.m17660ok().m17634z(id);
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && m17634z != null && C12293bl.m18419ok(context, downloadInfo) && m17634z.mo16679bl(downloadInfo)) {
            return;
        }
        boolean z = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (C12534ok.m17599ok(id).m17607a("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                return;
            case -3:
                m18491ok(C12490bl.m17807l(), id, true);
                m18490ok(context, interfaceC12308s, downloadInfo);
                if (C12534ok.m17599ok(id).m17593ok("notification_click_install_auto_cancel", 1) != 0 || (m16877n = C12644a.m16876ok().m16877n(id)) == null) {
                    z = true;
                } else {
                    m16877n.m16867h();
                    m16877n.m16862ok(-3, null, false, true);
                }
                if (z) {
                    C12644a.m16876ok().m16875ok(id);
                    return;
                }
                return;
            case -2:
                if (C12515s.m17660ok().m17662n(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    C12293bl.m18409ok(downloadInfo, true, false);
                }
                if (interfaceC12308s != null) {
                    interfaceC12308s.mo18386ok(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (interfaceC12427ep != null) {
                    interfaceC12427ep.mo16630ok(6, downloadInfo, "", "");
                    return;
                }
                return;
            case 0:
            default:
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                Downloader.getInstance(context).pause(id);
                m18489ok(context, downloadInfo);
                if (interfaceC12308s != null) {
                    interfaceC12308s.mo18386ok(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (interfaceC12427ep != null) {
                    interfaceC12427ep.mo16630ok(5, downloadInfo, "", "");
                    return;
                }
                return;
        }
    }
}
