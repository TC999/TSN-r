package com.ss.android.socialbase.downloader.notification;

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
import com.ss.android.socialbase.downloader.constants.n;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.downloader.s;
import com.ss.android.socialbase.downloader.downloader.z;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.p.h;
import com.ss.android.socialbase.downloader.q.kf;
import com.stub.StubApp;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DownloadNotificationService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static int f50073a;
    private static int bl;

    /* renamed from: h  reason: collision with root package name */
    private static volatile long f50074h;
    private static volatile long kf;

    /* renamed from: n  reason: collision with root package name */
    private static boolean f50075n;
    private static final String ok;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f50076p;

    /* renamed from: q  reason: collision with root package name */
    private static long f50077q;

    /* renamed from: s  reason: collision with root package name */
    private static boolean f50078s;

    /* renamed from: k  reason: collision with root package name */
    private h f50079k;

    /* renamed from: r  reason: collision with root package name */
    private final SparseArray<Notification> f50080r = new SparseArray<>(2);

    static {
        StubApp.interface11(23250);
        ok = DownloadNotificationService.class.getSimpleName();
        f50073a = -1;
        bl = -1;
        f50078s = true;
        f50075n = false;
        f50077q = 900L;
    }

    private void s() {
        if (this.f50079k == null) {
            h hVar = new h("DownloaderNotifyThread");
            this.f50079k = hVar;
            hVar.ok();
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        s();
        bl.ok(this);
        com.ss.android.socialbase.downloader.h.ok bl2 = com.ss.android.socialbase.downloader.h.ok.bl();
        int ok2 = bl2.ok("download_service_foreground", 0);
        if ((ok2 == 1 || ok2 == 3) && f50073a == -1) {
            f50073a = 0;
        }
        if ((ok2 == 2 || ok2 == 3) && bl == -1) {
            bl = 0;
        }
        f50075n = bl2.a("non_going_notification_foreground", false);
        f50076p = bl2.a("notify_too_fast", false);
        long ok3 = bl2.ok("notification_time_window", 900L);
        f50077q = ok3;
        if (ok3 < 0 || ok3 > 1200) {
            f50077q = 900L;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        h hVar = this.f50079k;
        if (hVar != null) {
            try {
                hVar.a();
            } catch (Throwable unused) {
            }
            this.f50079k = null;
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        ok(intent);
        return 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001f, code lost:
        if (com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f50073a == 0) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.app.NotificationManager r6, int r7, android.app.Notification r8) {
        /*
            r5 = this;
            boolean r0 = r5.ok(r7, r8)
            if (r0 == 0) goto L85
            com.ss.android.socialbase.downloader.downloader.s r0 = com.ss.android.socialbase.downloader.downloader.s.ok()     // Catch: java.lang.Throwable -> L80
            int r0 = r0.ok(r7)     // Catch: java.lang.Throwable -> L80
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L1a
            boolean r0 = com.ss.android.socialbase.downloader.q.kf.bl()     // Catch: java.lang.Throwable -> L80
            if (r0 != 0) goto L1a
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            if (r0 != 0) goto L23
            int r3 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f50073a     // Catch: java.lang.Throwable -> L80
            if (r3 != 0) goto L23
        L21:
            r1 = 1
            goto L2a
        L23:
            if (r0 == 0) goto L2a
            int r3 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.bl     // Catch: java.lang.Throwable -> L80
            if (r3 != 0) goto L2a
            goto L21
        L2a:
            if (r1 == 0) goto L9a
            com.ss.android.socialbase.downloader.downloader.s r1 = com.ss.android.socialbase.downloader.downloader.s.ok()     // Catch: java.lang.Throwable -> L80
            com.ss.android.socialbase.downloader.downloader.z r1 = r1.bl(r7)     // Catch: java.lang.Throwable -> L80
            boolean r2 = r1.h()     // Catch: java.lang.Throwable -> L80
            if (r2 == 0) goto L69
            boolean r2 = r1.a()     // Catch: java.lang.Throwable -> L80
            if (r2 != 0) goto L69
            java.lang.String r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.ok     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r3.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "doNotify, startForeground, ======== id = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L80
            r3.append(r7)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = ", isIndependentProcess = "
            r3.append(r4)     // Catch: java.lang.Throwable -> L80
            r3.append(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L80
            com.ss.android.socialbase.downloader.bl.ok.bl(r2, r3)     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L63
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.bl = r7     // Catch: java.lang.Throwable -> L80
            goto L65
        L63:
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f50073a = r7     // Catch: java.lang.Throwable -> L80
        L65:
            r1.ok(r7, r8)     // Catch: java.lang.Throwable -> L80
            goto L9a
        L69:
            java.lang.String r1 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.ok     // Catch: java.lang.Throwable -> L80
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L80
            r2.<init>()     // Catch: java.lang.Throwable -> L80
            java.lang.String r3 = "doNotify: canStartForeground = true, but proxy can not startForeground, isIndependentProcess = "
            r2.append(r3)     // Catch: java.lang.Throwable -> L80
            r2.append(r0)     // Catch: java.lang.Throwable -> L80
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L80
            com.ss.android.socialbase.downloader.bl.ok.bl(r1, r0)     // Catch: java.lang.Throwable -> L80
            goto L9a
        L80:
            r0 = move-exception
            r0.printStackTrace()
            goto L9a
        L85:
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f50073a
            if (r0 == r7) goto L8d
            int r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.bl
            if (r0 != r7) goto L9a
        L8d:
            boolean r0 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.f50075n
            if (r0 == 0) goto L9a
            int r0 = r8.flags
            r0 = r0 & 2
            if (r0 != 0) goto L9a
            r5.a(r6, r7)
        L9a:
            long r0 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> La9
            long r2 = com.ss.android.socialbase.downloader.notification.DownloadNotificationService.kf     // Catch: java.lang.Throwable -> La9
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto La6
            com.ss.android.socialbase.downloader.notification.DownloadNotificationService.kf = r0     // Catch: java.lang.Throwable -> La9
        La6:
            r6.notify(r7, r8)     // Catch: java.lang.Throwable -> La9
        La9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.a(android.app.NotificationManager, int, android.app.Notification):void");
    }

    private void ok(final Intent intent) {
        h hVar;
        if (intent == null) {
            return;
        }
        final String action = intent.getAction();
        if (TextUtils.isEmpty(action) || (hVar = this.f50079k) == null) {
            return;
        }
        hVar.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1
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
                            if (!DownloadNotificationService.f50076p) {
                                if (DownloadNotificationService.this.f50079k != null) {
                                    DownloadNotificationService.this.f50079k.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                                        }
                                    }, intExtra2 == -2 ? 50L : 200L);
                                    return;
                                }
                                return;
                            }
                            DownloadNotificationService.this.ok(notificationManager, intExtra, notification);
                        } else if (DownloadNotificationService.f50076p) {
                            DownloadNotificationService.this.ok(notificationManager, intExtra, notification);
                        } else {
                            DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                        }
                    } else if (Downloader.getInstance(bl.l()).isDownloading(intExtra)) {
                        DownloadInfo downloadInfo = Downloader.getInstance(bl.l()).getDownloadInfo(intExtra);
                        if (DownloadNotificationService.f50076p) {
                            if (downloadInfo == null || !downloadInfo.canNotifyProgress() || System.currentTimeMillis() - DownloadNotificationService.f50074h <= DownloadNotificationService.f50077q) {
                                return;
                            }
                            DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                            downloadInfo.setLastNotifyProgressTime();
                        } else if (downloadInfo == null || !downloadInfo.canNotifyProgress()) {
                        } else {
                            DownloadNotificationService.this.a(notificationManager, intExtra, notification);
                            downloadInfo.setLastNotifyProgressTime();
                        }
                    }
                } else if (action.equals("android.ss.intent.action.DOWNLOAD_NOTIFICATION_CANCEL")) {
                    if (intExtra != 0) {
                        DownloadNotificationService.this.a(notificationManager, intExtra);
                    }
                } else if (action.equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                    try {
                        if (kf.ok((Context) DownloadNotificationService.this, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) DownloadNotificationService.this.getSystemService("connectivity")) != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                            ArrayList arrayList = new ArrayList();
                            if (!TextUtils.isEmpty(n.ok)) {
                                arrayList.add(n.ok);
                            }
                            arrayList.add("mime_type_plg");
                            Context origApplicationContext = StubApp.getOrigApplicationContext(DownloadNotificationService.this.getApplicationContext());
                            if (origApplicationContext != null) {
                                Downloader.getInstance(origApplicationContext).restartAllFailedDownloadTasks(arrayList);
                                Downloader.getInstance(origApplicationContext).restartAllPauseReserveOnWifiDownloadTasks(arrayList);
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                } else if (action.equals("android.intent.action.MEDIA_UNMOUNTED") || action.equals("android.intent.action.MEDIA_REMOVED") || action.equals("android.intent.action.MEDIA_BAD_REMOVAL") || action.equals("android.intent.action.MEDIA_EJECT")) {
                    try {
                        Downloader.getInstance(DownloadNotificationService.this).pauseAll();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(final NotificationManager notificationManager, final int i4, Notification notification) {
        synchronized (this.f50080r) {
            int indexOfKey = this.f50080r.indexOfKey(i4);
            if (indexOfKey >= 0 && indexOfKey < this.f50080r.size()) {
                this.f50080r.setValueAt(indexOfKey, notification);
                return;
            }
            long currentTimeMillis = f50077q - (System.currentTimeMillis() - kf);
            if (currentTimeMillis <= 0) {
                currentTimeMillis = 0;
            }
            if (currentTimeMillis > 20000) {
                currentTimeMillis = 20000;
            }
            long currentTimeMillis2 = System.currentTimeMillis() + currentTimeMillis;
            f50074h = currentTimeMillis2;
            kf = currentTimeMillis2;
            if (currentTimeMillis <= 0) {
                a(notificationManager, i4, notification);
            } else if (this.f50079k != null) {
                synchronized (this.f50080r) {
                    this.f50080r.put(i4, notification);
                }
                this.f50079k.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.notification.DownloadNotificationService.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DownloadNotificationService.this.ok(notificationManager, i4);
                    }
                }, currentTimeMillis);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(NotificationManager notificationManager, int i4) {
        boolean z3;
        ok okVar;
        int ok2;
        int i5 = f50073a;
        if (i5 != i4 && bl != i4) {
            try {
                notificationManager.cancel(i4);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        boolean z4 = true;
        if (i5 == i4) {
            f50073a = 0;
            z3 = false;
        } else {
            bl = 0;
            z3 = true;
        }
        try {
            z bl2 = s.ok().bl(i4);
            if (!bl2.a()) {
                f50078s = false;
                com.ss.android.socialbase.downloader.bl.ok.s(ok, "try to stopForeground when is not Foreground, id = " + i4 + ", isIndependentProcess = " + z3);
            }
            com.ss.android.socialbase.downloader.bl.ok.bl(ok, "doCancel, ========== stopForeground id = " + i4 + ", isIndependentProcess = " + z3);
            bl2.ok(false, true);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            notificationManager.cancel(i4);
        } catch (Throwable unused2) {
        }
        if (f50078s) {
            try {
                SparseArray<ok> a4 = a.ok().a();
                if (a4 != null) {
                    for (int size = a4.size() - 1; size >= 0; size--) {
                        okVar = a4.valueAt(size);
                        if (okVar != null && (ok2 = okVar.ok()) != i4 && ok2 != f50073a && ok2 != bl && okVar.p()) {
                            if ((s.ok().ok(okVar.ok()) == 1 && !kf.bl()) == z3) {
                                break;
                            }
                        }
                    }
                }
                okVar = null;
                if (okVar != null) {
                    int ok3 = okVar.ok();
                    notificationManager.cancel(ok3);
                    if (Downloader.getInstance(this).getStatus(ok3) != 1) {
                        z4 = false;
                    }
                    com.ss.android.socialbase.downloader.bl.ok.bl(ok, "doCancel, updateNotification id = " + ok3);
                    okVar.ok((BaseException) null, z4);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(NotificationManager notificationManager, int i4) {
        Notification notification;
        synchronized (this.f50080r) {
            notification = this.f50080r.get(i4);
            this.f50080r.remove(i4);
        }
        if (notification != null) {
            a(notificationManager, i4, notification);
        }
    }

    private boolean ok(int i4, Notification notification) {
        int i5;
        int i6;
        if (!f50078s || (i5 = f50073a) == i4 || (i6 = bl) == i4) {
            return false;
        }
        if (i5 == 0 || i6 == 0) {
            if (f50075n && (notification.flags & 2) == 0) {
                return false;
            }
            return Build.VERSION.SDK_INT < 26 || !TextUtils.isEmpty(notification.getChannelId());
        }
        return false;
    }
}
