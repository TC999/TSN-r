package com.p521ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.ss.android.socialbase.downloader.notification.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12644a {

    /* renamed from: bl */
    private static volatile C12644a f35638bl;

    /* renamed from: n */
    private static final Object f35639n = new Object();

    /* renamed from: ok */
    private final long f35642ok = 1000;

    /* renamed from: a */
    private final Map<Integer, Long> f35640a = new HashMap();

    /* renamed from: s */
    private final Set<String> f35643s = new HashSet();

    /* renamed from: kf */
    private final SparseArray<AbstractC12645ok> f35641kf = new SparseArray<>();

    private C12644a() {
    }

    /* renamed from: a */
    static boolean m16882a(int i) {
        return i == 1 || i == 3;
    }

    /* renamed from: bl */
    static boolean m16879bl(DownloadInfo downloadInfo) {
        return downloadInfo.isDownloadOverStatus() && m16882a(downloadInfo.getNotificationVisibility());
    }

    /* renamed from: ok */
    public static C12644a m16876ok() {
        if (f35638bl == null) {
            synchronized (C12644a.class) {
                if (f35638bl == null) {
                    f35638bl = new C12644a();
                }
            }
        }
        return f35638bl;
    }

    /* renamed from: a */
    void m16881a(DownloadInfo downloadInfo) {
        if (m16879bl(downloadInfo)) {
            m16878kf(downloadInfo.getId());
        }
    }

    /* renamed from: kf */
    public void m16878kf(int i) {
        m16871s(i);
        if (i != 0) {
            m16876ok().m16880bl(i);
        }
    }

    /* renamed from: n */
    public AbstractC12645ok m16877n(int i) {
        AbstractC12645ok abstractC12645ok;
        if (i == 0) {
            return null;
        }
        synchronized (this.f35641kf) {
            abstractC12645ok = this.f35641kf.get(i);
        }
        return abstractC12645ok;
    }

    /* renamed from: s */
    public AbstractC12645ok m16871s(int i) {
        AbstractC12645ok abstractC12645ok;
        if (i == 0) {
            return null;
        }
        synchronized (this.f35641kf) {
            abstractC12645ok = this.f35641kf.get(i);
            if (abstractC12645ok != null) {
                this.f35641kf.remove(i);
                C12409ok.m17897ok("removeNotificationId " + i);
            }
        }
        return abstractC12645ok;
    }

    /* renamed from: bl */
    public void m16880bl(int i) {
        Context m17807l = C12490bl.m17807l();
        if (m17807l == null || i == 0) {
            return;
        }
        try {
            Intent intent = new Intent(m17807l, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL");
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            m17807l.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public SparseArray<AbstractC12645ok> m16883a() {
        SparseArray<AbstractC12645ok> sparseArray;
        synchronized (this.f35641kf) {
            sparseArray = this.f35641kf;
        }
        return sparseArray;
    }

    /* renamed from: ok */
    public void m16875ok(int i) {
        DownloadInfo downloadInfo = Downloader.getInstance(C12490bl.m17807l()).getDownloadInfo(i);
        if (downloadInfo == null) {
            return;
        }
        m16873ok(downloadInfo);
        m16881a(downloadInfo);
    }

    /* renamed from: ok */
    void m16873ok(DownloadInfo downloadInfo) {
        InterfaceC12501k m17806m = C12490bl.m17806m();
        if (m17806m != null && downloadInfo.isDownloadOverStatus()) {
            downloadInfo.setNotificationVisibility(3);
            try {
                m17806m.mo17488ok(downloadInfo);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: ok */
    public void m16874ok(int i, int i2, Notification notification) {
        Context m17807l = C12490bl.m17807l();
        if (m17807l == null || i == 0 || notification == null) {
            return;
        }
        if (i2 == 4) {
            synchronized (this.f35640a) {
                Long l = this.f35640a.get(Integer.valueOf(i));
                long currentTimeMillis = System.currentTimeMillis();
                if (l != null && Math.abs(currentTimeMillis - l.longValue()) < 1000) {
                    return;
                }
                this.f35640a.put(Integer.valueOf(i), Long.valueOf(currentTimeMillis));
            }
        }
        try {
            Intent intent = new Intent(m17807l, DownloadNotificationService.class);
            intent.setAction("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY");
            intent.putExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", i2);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", i);
            intent.putExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA", notification);
            m17807l.startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: ok */
    public void m16872ok(AbstractC12645ok abstractC12645ok) {
        if (abstractC12645ok == null) {
            return;
        }
        synchronized (this.f35641kf) {
            this.f35641kf.put(abstractC12645ok.m16864ok(), abstractC12645ok);
        }
    }
}
