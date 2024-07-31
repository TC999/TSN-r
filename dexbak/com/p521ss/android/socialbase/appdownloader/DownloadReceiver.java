package com.p521ss.android.socialbase.appdownloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12297bl;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12308s;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.AbstractC12645ok;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.ss.android.socialbase.appdownloader.DownloadReceiver */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: ok */
    private static final String f34626ok = DownloadReceiver.class.getSimpleName();

    /* renamed from: a */
    private Handler f34627a = new Handler(Looper.getMainLooper());

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        InterfaceC12297bl m18065ok = C12361s.m18068k().m18065ok();
        if (action.equals("android.intent.action.BOOT_COMPLETED") && (m18065ok == null || m18065ok.mo18391ok())) {
            if (C12409ok.m17899ok()) {
                C12409ok.m17896ok(f34626ok, "Received broadcast intent for android.intent.action.BOOT_COMPLETED");
            }
            m18485ok(context, action);
        } else if (action.equals("android.intent.action.MEDIA_MOUNTED")) {
            if (C12409ok.m17899ok()) {
                C12409ok.m17896ok(f34626ok, "Received broadcast intent for android.intent.action.MEDIA_MOUNTED");
            }
            m18485ok(context, action);
        } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
            C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    Uri data = intent.getData();
                    if (data == null) {
                        return;
                    }
                    String schemeSpecificPart = data.getSchemeSpecificPart();
                    InterfaceC12308s m18079a = C12361s.m18068k().m18079a();
                    if (m18079a != null) {
                        m18079a.mo18383ok(context, schemeSpecificPart);
                    }
                    List<DownloadInfo> successedDownloadInfosWithMimeType = Downloader.getInstance(context).getSuccessedDownloadInfosWithMimeType("application/vnd.android.package-archive");
                    if (successedDownloadInfosWithMimeType != null) {
                        for (final DownloadInfo downloadInfo : successedDownloadInfosWithMimeType) {
                            if (downloadInfo != null && C12293bl.m18411ok(downloadInfo, schemeSpecificPart)) {
                                InterfaceC12427ep downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
                                if (downloadNotificationEventListener != null && C12713kf.m16584kf(downloadNotificationEventListener.mo16631ok())) {
                                    downloadNotificationEventListener.mo16630ok(9, downloadInfo, schemeSpecificPart, "");
                                }
                                AbstractC12645ok m16877n = C12644a.m16876ok().m16877n(downloadInfo.getId());
                                if (m16877n != null) {
                                    m16877n.mo16858ok((BaseException) null, false);
                                }
                                if (C12534ok.m17599ok(downloadInfo.getId()).m17593ok("install_queue_enable", 0) == 1) {
                                    C12354p.m18098ok().m18092ok(downloadInfo, schemeSpecificPart);
                                }
                                DownloadReceiver.this.f34627a.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.1.1.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                try {
                                                    if (downloadInfo.isSavePathRedirected()) {
                                                        C12713kf.m16617a(downloadInfo);
                                                    }
                                                } catch (Throwable th) {
                                                    th.printStackTrace();
                                                }
                                            }
                                        });
                                    }
                                }, 1000L);
                                return;
                            }
                        }
                    }
                }
            });
        }
    }

    /* renamed from: ok */
    private void m18485ok(final Context context, final String str) {
        if (C12490bl.m17825e()) {
            C12490bl.m17778ok(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.DownloadReceiver.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, DownloadHandlerService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, 2000L, TimeUnit.MILLISECONDS);
        }
    }
}
