package com.p521ss.android.socialbase.downloader.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.kuaishou.weapon.p205p0.C7282g;
import com.p521ss.android.socialbase.downloader.constants.C12415n;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12515s;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p555p.C12655h;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.stub.StubApp;
import java.util.ArrayList;

/* renamed from: com.ss.android.socialbase.downloader.notification.DownloadNotificationService */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloadNotificationService extends Service {

    /* renamed from: a */
    private static int f35617a;

    /* renamed from: bl */
    private static int f35618bl;

    /* renamed from: h */
    private static volatile long f35619h;

    /* renamed from: kf */
    private static volatile long f35620kf;

    /* renamed from: n */
    private static boolean f35621n;

    /* renamed from: ok */
    private static final String f35622ok;

    /* renamed from: p */
    private static boolean f35623p;

    /* renamed from: q */
    private static long f35624q;

    /* renamed from: s */
    private static boolean f35625s;

    /* renamed from: k */
    private C12655h f35626k;

    /* renamed from: r */
    private final SparseArray<Notification> f35627r = new SparseArray<>(2);

    static {
        StubApp.interface11(23250);
        f35622ok = DownloadNotificationService.class.getSimpleName();
        f35617a = -1;
        f35618bl = -1;
        f35625s = true;
        f35621n = false;
        f35624q = 900L;
    }

    /* renamed from: s */
    private void m16884s() {
        if (this.f35626k == null) {
            C12655h c12655h = new C12655h("DownloaderNotifyThread");
            this.f35626k = c12655h;
            c12655h.m16766ok();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        m16884s();
        C12490bl.m17799ok(this);
        C12534ok m17605bl = C12534ok.m17605bl();
        int m17593ok = m17605bl.m17593ok("download_service_foreground", 0);
        if ((m17593ok == 1 || m17593ok == 3) && f35617a == -1) {
            f35617a = 0;
        }
        if ((m17593ok == 2 || m17593ok == 3) && f35618bl == -1) {
            f35618bl = 0;
        }
        f35621n = m17605bl.m17606a("non_going_notification_foreground", false);
        f35623p = m17605bl.m17606a("notify_too_fast", false);
        long m17592ok = m17605bl.m17592ok("notification_time_window", 900L);
        f35624q = m17592ok;
        if (m17592ok < 0 || m17592ok > 1200) {
            f35624q = 900L;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C12655h c12655h = this.f35626k;
        if (c12655h != null) {
            try {
                c12655h.m16769a();
            } catch (Throwable unused) {
            }
            this.f35626k = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        m16888ok(intent);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35617a == 0) goto L31;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m16896a(android.app.NotificationManager r6, int r7, android.app.Notification r8) {
        /*
            r5 = this;
            boolean r0 = r5.m16891ok(r7, r8)
            if (r0 == 0) goto L85
            com.ss.android.socialbase.downloader.downloader.s r0 = com.p521ss.android.socialbase.downloader.downloader.C12515s.m17660ok()     // Catch: java.lang.Throwable -> L80
            int r0 = r0.m17659ok(r7)     // Catch: java.lang.Throwable -> L80
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L1a
            boolean r0 = com.p521ss.android.socialbase.downloader.p556q.C12713kf.m16605bl()     // Catch: java.lang.Throwable -> L80
            if (r0 != 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 != 0) goto L23
            int r3 = com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35617a     // Catch: java.lang.Throwable -> L80
            if (r3 != 0) goto L23
        L21:
            r1 = 1
            goto L2a
        L23:
            if (r0 == 0) goto L2a
            int r3 = com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35618bl     // Catch: java.lang.Throwable -> L80
            if (r3 != 0) goto L2a
            goto L21
        L2a:
            if (r1 == 0) goto L9a
            com.ss.android.socialbase.downloader.downloader.s r1 = com.p521ss.android.socialbase.downloader.downloader.C12515s.m17660ok()     // Catch: java.lang.Throwable -> L80
            com.ss.android.socialbase.downloader.downloader.z r1 = r1.m17672bl(r7)     // Catch: java.lang.Throwable -> L80
            boolean r2 = r1.mo17457h()     // Catch: java.lang.Throwable -> L80
            if (r2 == 0) goto L69
            boolean r2 = r1.mo17472a()     // Catch: java.lang.Throwable -> L80
            if (r2 != 0) goto L69
            java.lang.String r2 = com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35622ok     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r3.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "doNotify, startForeground, ======== id = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L80
            r3.append(r7)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = ", isIndependentProcess = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L80
            r3.append(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L80
            com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17901bl(r2, r3)     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L63
            com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35618bl = r7     // Catch: java.lang.Throwable -> L80
            goto L65
        L63:
            com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35617a = r7     // Catch: java.lang.Throwable -> L80
        L65:
            r1.mo17438ok(r7, r8)     // Catch: java.lang.Throwable -> L80
            goto L9a
        L69:
            java.lang.String r1 = com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35622ok     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r2.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L80
            r2.append(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L80
            com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17901bl(r1, r0)     // Catch: java.lang.Throwable -> L80
            goto L9a
        L80:
            r0 = move-exception
            r0.printStackTrace()
            goto L9a
        L85:
            int r0 = com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35617a
            if (r0 == r7) goto L8d
            int r0 = com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35618bl
            if (r0 != r7) goto L9a
        L8d:
            boolean r0 = com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35621n
            if (r0 == 0) goto L9a
            int r0 = r8.flags
            r0 = r0 & 2
            if (r0 != 0) goto L9a
            r5.m16897a(r6, r7)
        L9a:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La9
            long r2 = com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35620kf     // Catch: java.lang.Throwable -> La9
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto La6
            com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.f35620kf = r0     // Catch: java.lang.Throwable -> La9
        La6:
            r6.notify(r7, r8)     // Catch: java.lang.Throwable -> La9
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.notification.DownloadNotificationService.m16896a(android.app.NotificationManager, int, android.app.Notification):void");
    }

    /* renamed from: ok */
    private void m16888ok(final Intent intent) {
        C12655h c12655h;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (c12655h = this.f35626k) == null) {
            return;
        }
        c12655h.m16763ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectivityManager connectivityManager;
                NetworkInfo activeNetworkInfo;
                final NotificationManager notificationManager = (NotificationManager) DownloadNotificationService.this.getSystemService("notification");
                final int intExtra = intent.getIntExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA_ID", 0);
                if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_NOTIFY")) {
                    final Notification notification = (Notification) intent.getParcelableExtra("DOWNLOAD_NOTIFICATION_BUNDLE_EXTRA");
                    int intExtra2 = intent.getIntExtra("DOWNLOAD_NOTIFICATION_EXTRA_STATUS", 0);
                    if (intExtra == 0 || notification == null || notificationManager == null) {
                        return;
                    }
                    if (intExtra2 != 4) {
                        if (intExtra2 == -2 || intExtra2 == -3) {
                            if (!DownloadNotificationService.f35623p) {
                                if (DownloadNotificationService.this.f35626k != null) {
                                    DownloadNotificationService.this.f35626k.m16762ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            DownloadNotificationService.this.m16896a(notificationManager, intExtra, notification);
                                        }
                                    }, intExtra2 == -2 ? 50L : 200L);
                                    return;
                                }
                                return;
                            }
                            DownloadNotificationService.this.m16889ok(notificationManager, intExtra, notification);
                        } else if (DownloadNotificationService.f35623p) {
                            DownloadNotificationService.this.m16889ok(notificationManager, intExtra, notification);
                        } else {
                            DownloadNotificationService.this.m16896a(notificationManager, intExtra, notification);
                        }
                    } else if (Downloader.getInstance(C12490bl.m17807l()).isDownloading(intExtra)) {
                        DownloadInfo downloadInfo = Downloader.getInstance(C12490bl.m17807l()).getDownloadInfo(intExtra);
                        if (DownloadNotificationService.f35623p) {
                            if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.f35619h <= DownloadNotificationService.f35624q) {
                                return;
                            }
                            DownloadNotificationService.this.m16896a(notificationManager, intExtra, notification);
                            downloadInfo.setLastNotifyProgressTime();
                        } else if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                        } else {
                            DownloadNotificationService.this.m16896a(notificationManager, intExtra, notification);
                            downloadInfo.setLastNotifyProgressTime();
                        }
                    }
                } else if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                    if (intExtra != 0) {
                        DownloadNotificationService.this.m16897a(notificationManager, intExtra);
                    }
                } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        if (C12713kf.m16568ok((Context) DownloadNotificationService.this, C7282g.f24944b) && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(C12415n.f34990ok)) {
                                arrayList.add(C12415n.f34990ok);
                            }
                            arrayList.add("mime_type_plg");
                            Context origApplicationContext = StubApp.getOrigApplicationContext(DownloadNotificationService.this.getApplicationContext());
                            if (origApplicationContext != null) {
                                Downloader.getInstance(origApplicationContext).restartAllFailedDownloadTasks(arrayList);
                                Downloader.getInstance(origApplicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                    try {
                        Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m16889ok(final NotificationManager notificationManager, final int i, Notification notification) {
        synchronized (this.f35627r) {
            int indexOfKey = this.f35627r.indexOfKey(i);
            if (indexOfKey >= 0 && indexOfKey < this.f35627r.size()) {
                this.f35627r.setValueAt(indexOfKey, notification);
                return;
            }
            long currentTimeMillis = f35624q - (System.currentTimeMillis() - f35620kf);
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis > 20000) {
                currentTimeMillis = 20000;
            }
            long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
            f35619h = currentTimeMillis2;
            f35620kf = currentTimeMillis2;
            if (currentTimeMillis <= 0) {
                m16896a(notificationManager, i, notification);
            } else if (this.f35626k != null) {
                synchronized (this.f35627r) {
                    this.f35627r.put(i, notification);
                }
                this.f35626k.m16762ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.m16890ok(notificationManager, i);
                    }
                }, currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m16897a(NotificationManager notificationManager, int i) {
        boolean z;
        AbstractC12645ok abstractC12645ok;
        int m16864ok;
        int i2 = f35617a;
        if (i2 != i && f35618bl != i) {
            try {
                notificationManager.cancel(i);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z2 = true;
        if (i2 == i) {
            f35617a = 0;
            z = false;
        } else {
            f35618bl = 0;
            z = true;
        }
        try {
            InterfaceC12522z m17672bl = C12515s.m17660ok().m17672bl(i);
            if (!m17672bl.mo17472a()) {
                f35625s = false;
                C12409ok.m17894s(f35622ok, "try to stopForeground when is not Foreground, id = " + i + ", isIndependentProcess = " + z);
            }
            C12409ok.m17901bl(f35622ok, "doCancel, ========== stopForeground id = " + i + ", isIndependentProcess = " + z);
            m17672bl.mo17426ok(false, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            notificationManager.cancel(i);
        } catch (Throwable unused2) {
        }
        if (f35625s) {
            try {
                SparseArray<AbstractC12645ok> m16883a = C12644a.m16876ok().m16883a();
                if (m16883a != null) {
                    for (int size = m16883a.size() - 1; size >= 0; size--) {
                        abstractC12645ok = m16883a.valueAt(size);
                        if (abstractC12645ok != null && (m16864ok = abstractC12645ok.m16864ok()) != i && m16864ok != f35617a && m16864ok != f35618bl && abstractC12645ok.m16856p()) {
                            if ((C12515s.m17660ok().m17659ok(abstractC12645ok.m16864ok()) == 1 && !C12713kf.m16605bl()) == z) {
                                break;
                            }
                        }
                    }
                }
                abstractC12645ok = null;
                if (abstractC12645ok != null) {
                    int m16864ok2 = abstractC12645ok.m16864ok();
                    notificationManager.cancel(m16864ok2);
                    if (Downloader.getInstance(this).getStatus(m16864ok2) != 1) {
                        z2 = false;
                    }
                    C12409ok.m17901bl(f35622ok, "doCancel, updateNotification id = " + m16864ok2);
                    abstractC12645ok.mo16858ok((BaseException) null, z2);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m16890ok(NotificationManager notificationManager, int i) {
        Notification notification;
        synchronized (this.f35627r) {
            notification = this.f35627r.get(i);
            this.f35627r.remove(i);
        }
        if (notification != null) {
            m16896a(notificationManager, i, notification);
        }
    }

    /* renamed from: ok */
    private boolean m16891ok(int i, Notification notification) {
        int i2;
        int i3;
        if (!f35625s || (i2 = f35617a) == i || (i3 = f35618bl) == i) {
            return false;
        }
        if (i2 == 0 || i3 == 0) {
            if (f35621n && (notification.flags & 2) == 0) {
                return false;
            }
            return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
        }
        return false;
    }
}
