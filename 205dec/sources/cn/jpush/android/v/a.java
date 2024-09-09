package cn.jpush.android.v;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cn.jpush.android.ad.f;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.data.JPushLocalNotification;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile a f4450a;

    /* renamed from: e  reason: collision with root package name */
    private static final Object f4451e = new Object();

    /* renamed from: b  reason: collision with root package name */
    private Handler f4452b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4453c;

    /* renamed from: d  reason: collision with root package name */
    private String f4454d;

    private a(Context context) {
        this.f4452b = null;
        this.f4453c = null;
        this.f4454d = "";
        Logger.d("JPushLocalNotificationCenter", "Constructor : JPushLocalNotificationCenter");
        this.f4452b = new Handler(Looper.getMainLooper());
        this.f4453c = context;
        this.f4454d = context.getPackageName();
    }

    public static a a(Context context) {
        Logger.v("JPushLocalNotificationCenter", "getInstance");
        if (f4450a == null) {
            synchronized (f4451e) {
                if (f4450a == null) {
                    f4450a = new a(context);
                }
            }
        }
        return f4450a;
    }

    private synchronized void a(final long j4, long j5, int i4) {
        Logger.d("JPushLocalNotificationCenter", "LocalNotification scheduleReadiedLN");
        if (this.f4452b != null) {
            Runnable runnable = new Runnable() { // from class: cn.jpush.android.v.a.2
                @Override // java.lang.Runnable
                public void run() {
                    long a4;
                    int i5;
                    int i6;
                    int i7;
                    String d4;
                    long f4;
                    long e4;
                    try {
                        b a5 = b.a(a.this.f4453c);
                        c a6 = a5.a(j4, 0);
                        if (a6 != null) {
                            if (a6.c() == 1) {
                                Logger.d("JPushLocalNotificationCenter", "remove ");
                                a4 = a6.a();
                                i5 = 0;
                                i6 = 1;
                                i7 = 0;
                                d4 = a6.d();
                                f4 = a6.f();
                                e4 = a6.e();
                            } else if (a6.b() > 1) {
                                Logger.d("JPushLocalNotificationCenter", "repeat add");
                                a5.b(a6.a(), a6.b() - 1, 0, 0, a6.d(), a6.f(), a6.e());
                                return;
                            } else if (a6.b() != 1) {
                                Logger.d("JPushLocalNotificationCenter", "already triggered");
                                return;
                            } else {
                                Logger.d("JPushLocalNotificationCenter", "send broadcast");
                                if (a6.f() > System.currentTimeMillis()) {
                                    Logger.d("JPushLocalNotificationCenter", "repeat add");
                                    return;
                                }
                                a aVar = a.this;
                                aVar.a(aVar.f4453c, a6.d());
                                a4 = a6.a();
                                i5 = 0;
                                i6 = 0;
                                i7 = 0;
                                d4 = a6.d();
                                f4 = a6.f();
                                e4 = a6.e();
                            }
                            a5.b(a4, i5, i6, i7, d4, f4, e4);
                        }
                    } catch (Exception e5) {
                        Logger.e("JPushLocalNotificationCenter", "exception:" + e5.getMessage());
                    }
                }
            };
            if (j5 <= 0) {
                Logger.d("JPushLocalNotificationCenter", "post right now ");
                this.f4452b.post(runnable);
            } else {
                Logger.d("JPushLocalNotificationCenter", "post delayed : " + j5);
                this.f4452b.postDelayed(runnable, j5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void e(Context context) {
        Cursor a4;
        Logger.d("JPushLocalNotificationCenter", "triggerLNKillProcess");
        b a5 = b.a(context);
        if (a5.a(false)) {
            Cursor cursor = null;
            try {
                try {
                    a4 = a5.a(1, System.currentTimeMillis());
                    try {
                    } catch (Exception e4) {
                        e = e4;
                        cursor = a4;
                        Logger.ww("JPushLocalNotificationCenter", "triggerLNKillProcess: " + e.getMessage());
                        if (cursor != null) {
                            cursor.close();
                        }
                        a5.b(false);
                    } catch (Throwable th) {
                        th = th;
                        cursor = a4;
                        if (cursor != null) {
                            cursor.close();
                        }
                        a5.b(false);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e5) {
                e = e5;
            }
            if (a4.moveToFirst()) {
                do {
                    c a6 = b.a(a4);
                    if (a6 != null) {
                        a(context, a6.d());
                        a5.b(a6.a(), 0, 0, 0, a6.d(), a6.f(), a6.e());
                    }
                } while (a4.moveToNext());
                a4.close();
                a5.b(false);
            } else {
                a4.close();
                a5.b(false);
            }
        } else {
            Logger.e("JPushLocalNotificationCenter", "init LocalNotification cast expt: db open failed");
        }
    }

    public void a(Context context, String str) {
        Logger.d("JPushLocalNotificationCenter", "start LocalNotification broadCastToPushService");
        Bundle bundle = new Bundle();
        bundle.putString("local_notify_msg", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "show_local_notify", bundle);
        Logger.d("JPushLocalNotificationCenter", "end LocalNotification broadCastToPushService");
    }

    public synchronized boolean a(Context context, long j4) {
        c a4;
        Logger.dd("JPushLocalNotificationCenter", "remove LocalNotification ");
        long j5 = (int) j4;
        try {
            b a5 = b.a(context);
            if (a5.a(j5, 0) != null) {
                Logger.d("JPushLocalNotificationCenter", "remove local count : " + a4.b());
                a5.a(j5);
                JPushInterface.clearNotificationById(this.f4453c, (int) j5);
                return true;
            }
            return false;
        } catch (Exception e4) {
            Logger.e("JPushLocalNotificationCenter", "exception:" + e4.getMessage());
            return false;
        }
    }

    public synchronized boolean a(Context context, JPushLocalNotification jPushLocalNotification) {
        Logger.dd("JPushLocalNotificationCenter", "add LocalNotification");
        long currentTimeMillis = System.currentTimeMillis();
        long broadcastTime = jPushLocalNotification.getBroadcastTime() - currentTimeMillis;
        if (cn.jpush.android.cache.a.d(context)) {
            Logger.d("JPushLocalNotificationCenter", "push has stopped");
        }
        long notificationId = jPushLocalNotification.getNotificationId();
        try {
            b a4 = b.a(context);
            if (a4.a(notificationId, 0) != null) {
                a4.b(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            } else {
                a4.a(notificationId, 1, 0, 0, jPushLocalNotification.toJSON(), jPushLocalNotification.getBroadcastTime(), currentTimeMillis);
            }
        } catch (Exception e4) {
            Logger.e("JPushLocalNotificationCenter", "exception:" + e4.getMessage());
        }
        if (broadcastTime < 300000) {
            a(jPushLocalNotification.getNotificationId(), broadcastTime, 0);
            return true;
        }
        return true;
    }

    public synchronized void b(Context context) {
        Logger.dd("JPushLocalNotificationCenter", "clear all local notification ");
        int[] a4 = b.a(context).a();
        if (a4 != null && a4.length > 0) {
            Logger.d("JPushLocalNotificationCenter", " success");
            for (int i4 : a4) {
                JPushInterface.clearNotificationById(this.f4453c, i4);
            }
        }
    }

    public synchronized void c(Context context) {
        long currentTimeMillis;
        Logger.d("JPushLocalNotificationCenter", "init LocalNotification");
        b a4 = b.a(context);
        if (a4.a(false)) {
            Cursor cursor = null;
            try {
                currentTimeMillis = System.currentTimeMillis();
                cursor = a4.a(currentTimeMillis, 300000L);
            } catch (Exception e4) {
                Logger.e("JPushLocalNotificationCenter", "init LocalNotification cast expt:" + e4);
                if (cursor != null) {
                    cursor.close();
                }
            }
            if (cursor.moveToFirst()) {
                do {
                    c a5 = b.a(cursor);
                    if (a5 != null) {
                        a(a5.a(), a5.f() - currentTimeMillis, 0);
                    }
                } while (cursor.moveToNext());
                cursor.close();
                a4.b(false);
            } else {
                cursor.close();
                a4.b(false);
            }
        } else {
            Logger.e("JPushLocalNotificationCenter", "init LocalNotification cast expt: db open failed");
        }
    }

    public void d(final Context context) {
        Logger.d("JPushLocalNotificationCenter", "LocalNotification onHeartBeat");
        JCoreHelper.futureExecutor(context, "JPushLocalNotificationCenter", new f("JPushLocationNotificationCenter#onHeartBeat") { // from class: cn.jpush.android.v.a.1
            @Override // cn.jpush.android.ad.f
            public void a() {
                a.this.e(context);
                a.this.c(context);
            }
        });
    }
}
