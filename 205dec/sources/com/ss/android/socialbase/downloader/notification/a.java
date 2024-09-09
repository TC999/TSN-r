package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    private static volatile a bl;

    /* renamed from: n  reason: collision with root package name */
    private static final Object f50085n = new Object();
    private final long ok = 1000;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Integer, Long> f50086a = new HashMap();

    /* renamed from: s  reason: collision with root package name */
    private final Set<String> f50087s = new HashSet();
    private final SparseArray<ok> kf = new SparseArray<>();

    private a() {
    }

    static boolean a(int i4) {
        return i4 == 1 || i4 == 3;
    }

    static boolean bl(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && a(downloadInfo.getNotificationVisibility());
    }

    public static a ok() {
        if (bl == null) {
            synchronized (a.class) {
                if (bl == null) {
                    bl = new a();
                }
            }
        }
        return bl;
    }

    void a(DownloadInfo downloadInfo) {
        if (bl(downloadInfo)) {
            kf(downloadInfo.getId());
        }
    }

    public void kf(int i4) {
        s(i4);
        if (i4 != 0) {
            ok().bl(i4);
        }
    }

    public ok n(int i4) {
        ok okVar;
        if (i4 == 0) {
            return null;
        }
        synchronized (this.kf) {
            okVar = this.kf.get(i4);
        }
        return okVar;
    }

    public ok s(int i4) {
        ok okVar;
        if (i4 == 0) {
            return null;
        }
        synchronized (this.kf) {
            okVar = this.kf.get(i4);
            if (okVar != null) {
                this.kf.remove(i4);
                com.ss.android.socialbase.downloader.bl.ok.ok("removeNotificationId " + i4);
            }
        }
        return okVar;
    }

    public void bl(int i4) {
        Context l4 = bl.l();
        if (l4 == null || i4 == 0) {
            return;
        }
        try {
            Intent intent = new Intent(l4, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i4);
            l4.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<ok> a() {
        SparseArray<ok> sparseArray;
        synchronized (this.kf) {
            sparseArray = this.kf;
        }
        return sparseArray;
    }

    public void ok(int i4) {
        DownloadInfo downloadInfo = Downloader.getInstance(bl.l()).getDownloadInfo(i4);
        if (downloadInfo == null) {
            return;
        }
        ok(downloadInfo);
        a(downloadInfo);
    }

    void ok(DownloadInfo downloadInfo) {
        k m4 = bl.m();
        if (m4 != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                m4.ok(downloadInfo);
            } catch (SQLiteException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void ok(int i4, int i5, Notification notification) {
        Context l4 = bl.l();
        if (l4 == null || i4 == 0 || notification == null) {
            return;
        }
        if (i5 == 4) {
            synchronized (this.f50086a) {
                Long l5 = this.f50086a.get(Integer.valueOf(i4));
                long currentTimeMillis = System.currentTimeMillis();
                if (l5 != null && Math.abs(currentTimeMillis - l5.longValue()) < 1000) {
                    return;
                }
                this.f50086a.put(Integer.valueOf(i4), Long.valueOf(currentTimeMillis));
            }
        }
        try {
            Intent intent = new Intent(l4, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i5);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i4);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            l4.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void ok(ok okVar) {
        if (okVar == null) {
            return;
        }
        synchronized (this.kf) {
            this.kf.put(okVar.ok(), okVar);
        }
    }
}
