package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.downloader.xv;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {
    private static final Object ux = new Object();
    private static volatile w xv;

    /* renamed from: c  reason: collision with root package name */
    private final long f50098c = 1000;

    /* renamed from: w  reason: collision with root package name */
    private final Map<Integer, Long> f50100w = new HashMap();
    private final Set<String> sr = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<c> f50099f = new SparseArray<>();

    private w() {
    }

    public static w c() {
        if (xv == null) {
            synchronized (w.class) {
                if (xv == null) {
                    xv = new w();
                }
            }
        }
        return xv;
    }

    static boolean w(int i4) {
        return i4 == 1 || i4 == 3;
    }

    static boolean xv(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && w(downloadInfo.getNotificationVisibility());
    }

    public void f(int i4) {
        sr(i4);
        if (i4 != 0) {
            c().xv(i4);
        }
    }

    public c sr(int i4) {
        c cVar;
        if (i4 == 0) {
            return null;
        }
        synchronized (this.f50099f) {
            cVar = this.f50099f.get(i4);
            if (cVar != null) {
                this.f50099f.remove(i4);
                com.ss.android.socialbase.downloader.xv.c.c("removeNotificationId " + i4);
            }
        }
        return cVar;
    }

    public c ux(int i4) {
        c cVar;
        if (i4 == 0) {
            return null;
        }
        synchronized (this.f50099f) {
            cVar = this.f50099f.get(i4);
        }
        return cVar;
    }

    void w(DownloadInfo downloadInfo) {
        if (xv(downloadInfo)) {
            f(downloadInfo.getId());
        }
    }

    public void xv(int i4) {
        Context gw = xv.gw();
        if (gw == null || i4 == 0) {
            return;
        }
        try {
            Intent intent = new Intent(gw, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i4);
            gw.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    SparseArray<c> w() {
        SparseArray<c> sparseArray;
        synchronized (this.f50099f) {
            sparseArray = this.f50099f;
        }
        return sparseArray;
    }

    public void c(int i4) {
        DownloadInfo downloadInfo = Downloader.getInstance(xv.gw()).getDownloadInfo(i4);
        if (downloadInfo == null) {
            return;
        }
        c(downloadInfo);
        w(downloadInfo);
    }

    void c(DownloadInfo downloadInfo) {
        p gb = xv.gb();
        if (gb != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                gb.c(downloadInfo);
            } catch (SQLiteException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void c(int i4, int i5, Notification notification) {
        Context gw = xv.gw();
        if (gw == null || i4 == 0 || notification == null) {
            return;
        }
        if (i5 == 4) {
            synchronized (this.f50100w) {
                Long l4 = this.f50100w.get(Integer.valueOf(i4));
                long currentTimeMillis = System.currentTimeMillis();
                if (l4 != null && Math.abs(currentTimeMillis - l4.longValue()) < 1000) {
                    return;
                }
                this.f50100w.put(Integer.valueOf(i4), Long.valueOf(currentTimeMillis));
            }
        }
        try {
            Intent intent = new Intent(gw, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i5);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i4);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            gw.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        synchronized (this.f50099f) {
            this.f50099f.put(cVar.c(), cVar);
        }
    }
}
