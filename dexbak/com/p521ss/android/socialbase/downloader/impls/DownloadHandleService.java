package com.p521ss.android.socialbase.downloader.impls;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12515s;
import com.stub.StubApp;

/* renamed from: com.ss.android.socialbase.downloader.impls.DownloadHandleService */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloadHandleService extends Service {

    /* renamed from: ok */
    private static final String f35201ok;

    static {
        StubApp.interface11(23138);
        f35201ok = DownloadHandleService.class.getSimpleName();
    }

    /* renamed from: ok */
    private void m17587ok(Intent intent) {
        final int intExtra;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (intExtra = intent.getIntExtra("extra_download_id", 0)) == 0) {
            return;
        }
        if (action.equals("com.ss.android.downloader.action.DOWNLOAD_WAKEUP")) {
            C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.DownloadHandleService.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C12515s.m17660ok().m17637t(intExtra);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else if (action.equals("com.ss.android.downloader.action.PROCESS_NOTIFY")) {
            C12515s.m17660ok().m17635x(intExtra);
        } else if (action.equals("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY")) {
            C12490bl.m17841a();
        }
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
        m17587ok(intent);
        return 2;
    }
}
