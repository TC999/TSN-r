package com.p521ss.android.socialbase.downloader.downloader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import java.util.concurrent.TimeUnit;

/* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadReceiver */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloadReceiver extends BroadcastReceiver {

    /* renamed from: ok */
    private static final String f35046ok = DownloadReceiver.class.getSimpleName();

    /* renamed from: a */
    private void m17844a(final Context context, final String str) {
        C12490bl.m17779ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Intent intent = new Intent(context, DownloadNotificationService.class);
                    intent.setAction(str);
                    context.startService(intent);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    /* renamed from: ok */
    private void m17843ok(final Context context, final String str) {
        if (C12490bl.m17825e()) {
            C12490bl.m17778ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadReceiver.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Intent intent = new Intent(context, DownloadNotificationService.class);
                        intent.setAction(str);
                        context.startService(intent);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }, 2000L, TimeUnit.MILLISECONDS);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            return;
        }
        if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            if (C12409ok.m17899ok()) {
                C12409ok.m17896ok(f35046ok, "Received broadcast intent for android.net.conn.CONNECTIVITY_CHANGE");
            }
            m17843ok(context, action);
        } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
            m17844a(context, action);
        }
    }
}
