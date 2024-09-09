package com.ss.android.socialbase.appdownloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.text.TextUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.stub.StubApp;
import java.io.File;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DownloadHandlerService extends Service {
    private static final String ok;

    static {
        StubApp.interface11(22864);
        ok = DownloadHandlerService.class.getSimpleName();
    }

    private void a(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.bl.s sVar, ep epVar) {
        int id = downloadInfo.getId();
        Intent intent = new Intent(this, DownloadTaskDeleteActivity.class);
        intent.putExtra("extra_click_download_ids", id);
        intent.addFlags(268435456);
        startActivity(intent);
        com.ss.android.socialbase.downloader.notification.a.ok().ok(id);
        downloadInfo.updateDownloadTime();
        if (sVar != null) {
            sVar.ok(id, 7, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
        }
        if (epVar != null) {
            epVar.ok(7, downloadInfo, "", "");
        }
    }

    private boolean ok(Intent intent) {
        if (intent == null) {
            return false;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        int intExtra = intent.getIntExtra("extra_click_download_ids", 0);
        intent.getIntExtra("extra_click_download_type", 0);
        com.ss.android.socialbase.appdownloader.bl.s a4 = s.k().a();
        ep downloadNotificationEventListener = Downloader.getInstance(this).getDownloadNotificationEventListener(intExtra);
        boolean z3 = true;
        if (intent.getBooleanExtra("extra_from_notification", false) && com.ss.android.socialbase.downloader.h.ok.ok(intExtra).a("notification_opt_2") == 1) {
            com.ss.android.socialbase.downloader.notification.a.ok().kf(intExtra);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(this).getDownloadInfo(intExtra);
        if (downloadInfo == null) {
            return false;
        }
        if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_CONTENT")) {
            ok(downloadInfo, a4, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_OPEN")) {
            ok(this, downloadInfo, a4, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_CLICK_BTN")) {
            if (downloadInfo.getStatus() == 0) {
                return false;
            }
            ok(this, downloadInfo, a4, downloadNotificationEventListener);
            if (downloadInfo.isDownloadOverStatus() && com.ss.android.socialbase.downloader.h.ok.ok(intExtra).ok("no_hide_notification", 0) == 0) {
                if (!((com.ss.android.socialbase.downloader.h.ok.ok(intExtra).a("enable_notification_ui") < 2 || downloadInfo.getStatus() != -1) ? false : false)) {
                    com.ss.android.socialbase.downloader.notification.a.ok().ok(intExtra);
                    com.ss.android.socialbase.downloader.notification.a.ok().kf(intExtra);
                }
            }
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_DELETE")) {
            a(downloadInfo, a4, downloadNotificationEventListener);
        } else if (action.equals("android.ss.intent.action.DOWNLOAD_HIDE")) {
            com.ss.android.socialbase.downloader.notification.a.ok().ok(intExtra);
        } else if (action.equals("android.intent.action.BOOT_COMPLETED") || action.equals("android.intent.action.MEDIA_MOUNTED")) {
            com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add("application/vnd.android.package-archive");
                        arrayList.add("mime_type_plg");
                        Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).restartAllFailedDownloadTasks(arrayList);
                    } catch (Exception e4) {
                        e4.printStackTrace();
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
        com.ss.android.socialbase.downloader.downloader.bl.ok(this);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        super.onStartCommand(intent, i4, i5);
        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "onStartCommand");
        }
        ok(intent);
        stopSelf();
        return 2;
    }

    private static void ok(Context context, DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.q.kf.a(StubApp.getOrigApplicationContext(context.getApplicationContext())) && downloadInfo.isPauseReserveOnWifi()) {
            downloadInfo.stopPauseReserveOnWifi();
        }
    }

    private static void ok(Context context, final com.ss.android.socialbase.appdownloader.bl.s sVar, final DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        final ep downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (sVar == null && downloadNotificationEventListener == null) {
            return;
        }
        com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadHandlerService.2
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo ok2;
                try {
                    File file = new File(DownloadInfo.this.getSavePath(), DownloadInfo.this.getName());
                    if (file.exists()) {
                        try {
                            String str = (com.ss.android.socialbase.downloader.downloader.bl.l() == null || (ok2 = bl.ok(DownloadInfo.this, file)) == null) ? "" : ok2.packageName;
                            com.ss.android.socialbase.appdownloader.bl.s sVar2 = sVar;
                            if (sVar2 != null) {
                                sVar2.ok(DownloadInfo.this.getId(), 3, str, -3, DownloadInfo.this.getDownloadTime());
                            }
                            ep epVar = downloadNotificationEventListener;
                            if (epVar != null) {
                                epVar.ok(3, DownloadInfo.this, str, "");
                            }
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void ok(@androidx.annotation.NonNull com.ss.android.socialbase.downloader.model.DownloadInfo r8, com.ss.android.socialbase.appdownloader.bl.s r9, com.ss.android.socialbase.downloader.depend.ep r10) {
        /*
            r7 = this;
            int r1 = r8.getId()
            com.ss.android.socialbase.downloader.downloader.s r0 = com.ss.android.socialbase.downloader.downloader.s.ok()
            com.ss.android.socialbase.downloader.depend.v r0 = r0.z(r1)
            if (r0 == 0) goto L17
            boolean r0 = r0.ok(r8)     // Catch: java.lang.Throwable -> L13
            goto L18
        L13:
            r0 = move-exception
            r0.printStackTrace()
        L17:
            r0 = 0
        L18:
            if (r0 != 0) goto L51
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity> r2 = com.ss.android.socialbase.appdownloader.view.DownloadTaskDeleteActivity.class
            r0.<init>(r7, r2)
            java.lang.String r2 = "extra_click_download_ids"
            r0.putExtra(r2, r1)
            r2 = 268435456(0x10000000, float:2.524355E-29)
            r0.addFlags(r2)
            r7.startActivity(r0)
            com.ss.android.socialbase.downloader.notification.a r0 = com.ss.android.socialbase.downloader.notification.a.ok()
            r0.ok(r1)
            r8.updateDownloadTime()
            if (r9 == 0) goto L49
            r2 = 7
            int r4 = r8.getStatus()
            long r5 = r8.getDownloadTime()
            java.lang.String r3 = ""
            r0 = r9
            r0.ok(r1, r2, r3, r4, r5)
        L49:
            if (r10 == 0) goto L51
            r9 = 7
            java.lang.String r0 = ""
            r10.ok(r9, r8, r0, r0)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.DownloadHandlerService.ok(com.ss.android.socialbase.downloader.model.DownloadInfo, com.ss.android.socialbase.appdownloader.bl.s, com.ss.android.socialbase.downloader.depend.ep):void");
    }

    private static void ok(Context context, int i4, boolean z3) {
        boolean z4;
        v z5;
        DownloadInfo downloadInfo;
        if (z3 && (z5 = com.ss.android.socialbase.downloader.downloader.s.ok().z(i4)) != null) {
            try {
                downloadInfo = Downloader.getInstance(context).getDownloadInfo(i4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (downloadInfo != null) {
                z4 = z5.a(downloadInfo);
                if (z4 && bl.ok(context, i4, true) == 0) {
                    Toast.makeText(context, "Open Fail!", 0).show();
                }
                return;
            }
        }
        z4 = false;
        if (z4) {
            return;
        }
        Toast.makeText(context, "Open Fail!", 0).show();
    }

    public static void ok(Context context, DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.bl.s sVar, ep epVar) {
        com.ss.android.socialbase.downloader.notification.ok n4;
        int id = downloadInfo.getId();
        v z3 = com.ss.android.socialbase.downloader.downloader.s.ok().z(id);
        if ("application/vnd.android.package-archive".equals(downloadInfo.getMimeType()) && z3 != null && bl.ok(context, downloadInfo) && z3.bl(downloadInfo)) {
            return;
        }
        boolean z4 = false;
        switch (downloadInfo.getStatus()) {
            case -4:
            case -1:
                if (com.ss.android.socialbase.downloader.h.ok.ok(id).a("enable_notification_ui") >= 2 && downloadInfo.isOnlyWifi()) {
                    downloadInfo.setOnlyWifi(false);
                }
                Downloader.getInstance(context).restart(id);
                return;
            case -3:
                ok(com.ss.android.socialbase.downloader.downloader.bl.l(), id, true);
                ok(context, sVar, downloadInfo);
                if (com.ss.android.socialbase.downloader.h.ok.ok(id).ok("notification_click_install_auto_cancel", 1) != 0 || (n4 = com.ss.android.socialbase.downloader.notification.a.ok().n(id)) == null) {
                    z4 = true;
                } else {
                    n4.h();
                    n4.ok(-3, null, false, true);
                }
                if (z4) {
                    com.ss.android.socialbase.downloader.notification.a.ok().ok(id);
                    return;
                }
                return;
            case -2:
                if (com.ss.android.socialbase.downloader.downloader.s.ok().n(id)) {
                    Downloader.getInstance(context).resume(id);
                } else {
                    bl.ok(downloadInfo, true, false);
                }
                if (sVar != null) {
                    sVar.ok(id, 6, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (epVar != null) {
                    epVar.ok(6, downloadInfo, "", "");
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
                ok(context, downloadInfo);
                if (sVar != null) {
                    sVar.ok(id, 5, "", downloadInfo.getStatus(), downloadInfo.getDownloadTime());
                }
                if (epVar != null) {
                    epVar.ok(5, downloadInfo, "", "");
                    return;
                }
                return;
        }
    }
}
