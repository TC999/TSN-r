package cn.jiguang.k;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import cn.jiguang.ah.d;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f3691a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3692b;

    /* renamed from: c  reason: collision with root package name */
    private static b f3693c;

    /* renamed from: d  reason: collision with root package name */
    private static a f3694d;

    /* renamed from: e  reason: collision with root package name */
    private static Object f3695e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static HandlerThread f3696f;

    /* renamed from: g  reason: collision with root package name */
    private static Handler f3697g;

    /* renamed from: h  reason: collision with root package name */
    private static String f3698h;

    /* renamed from: i  reason: collision with root package name */
    private static String f3699i;

    /* renamed from: j  reason: collision with root package name */
    private static String f3700j;

    /* renamed from: k  reason: collision with root package name */
    private static String f3701k;

    private b() {
    }

    public static b a(Context context) {
        if (f3693c == null) {
            f3693c = new b();
            f3691a = context;
            f();
            f3694d = new a(f3691a);
            a();
        }
        return f3693c;
    }

    public static void a() {
        Context context = null;
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
            method.setAccessible(true);
            context = (Context) method.invoke(null, new Object[0]);
        } catch (Exception e4) {
            cn.jiguang.w.a.f("MeizuIdManager", "ActivityThread:currentApplication --> " + e4.toString());
        }
        if (context != null) {
            PackageManager packageManager = context.getPackageManager();
            String f4 = d.f("rIjLIWp9yd1+l2BByOWYjPjGCBlvF2tDounrABnhodw=");
            if (packageManager != null && packageManager.resolveContentProvider(f4, 0) != null) {
                try {
                    Cursor query = context.getContentResolver().query(Uri.parse(d.f("SyfFpc71r1BITMlIo0m1Vt2cR3sdiPGnMd0WMSsF4yU8+J95KN/jHVtZShu2ONYO")), null, null, new String[]{"supported"}, null);
                    if (query != null) {
                        query.moveToFirst();
                        int columnIndex = query.getColumnIndex("value");
                        if (columnIndex >= 0) {
                            f3692b = "0".equals(query.getString(columnIndex));
                        } else {
                            f3692b = false;
                        }
                        query.close();
                    }
                } catch (Throwable unused) {
                    cn.jiguang.w.a.b("MeizuIdManager", "mz not support");
                }
                cn.jiguang.w.a.b("MeizuIdManager", "check meizu supported:" + f3692b);
            }
        }
        f3692b = false;
        cn.jiguang.w.a.b("MeizuIdManager", "check meizu supported:" + f3692b);
    }

    private void b(int i4) {
        String str;
        Message obtainMessage = f3697g.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        if (i4 == 0) {
            str = "ggTIEepvzybHoO4C7/s5eQ==";
        } else if (i4 != 1) {
            if (i4 == 2) {
                str = "bRmfYSLDPlLJ9XQro1+/dQ==";
            }
            obtainMessage.setData(bundle);
            f3697g.sendMessage(obtainMessage);
        } else {
            str = "QlAKJNz4iTmDadRoCSAs4A==";
        }
        bundle.putString("type", d.f(str));
        obtainMessage.setData(bundle);
        f3697g.sendMessage(obtainMessage);
    }

    private static void f() {
        HandlerThread handlerThread = new HandlerThread("jg_mzdb_thread");
        f3696f = handlerThread;
        handlerThread.start();
        f3697g = new Handler(f3696f.getLooper()) { // from class: cn.jiguang.k.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    cn.jiguang.w.a.b("MeizuIdManager", "message type valid");
                    return;
                }
                try {
                    String unused = b.f3698h = b.f3694d.a(message.getData().getString("type"));
                } catch (Throwable th) {
                    String unused2 = b.f3698h = "";
                    cn.jiguang.w.a.b("MeizuIdManager", "getID exception, " + th.getMessage());
                }
                synchronized (b.f3695e) {
                    b.f3695e.notify();
                }
            }
        };
    }

    public void a(int i4) {
        String str;
        String str2;
        synchronized (f3695e) {
            b(i4);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f3695e.wait(2000L);
            } catch (InterruptedException e4) {
                cn.jiguang.w.a.f("MeizuIdManager", "lock wait err: " + e4.getMessage());
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                str = "MeizuIdManager";
                str2 = "query timeout";
            } else if (i4 == 0) {
                f3699i = f3698h;
                f3698h = null;
                str = "MeizuIdManager";
                str2 = "query aaid: " + f3699i;
            } else if (i4 == 1) {
                String str3 = f3698h;
                if (str3 == null) {
                    str = "MeizuIdManager";
                    str2 = "get ids-va failed";
                } else {
                    f3700j = str3;
                    f3698h = null;
                    str = "MeizuIdManager";
                    str2 = "query aaid: " + f3700j;
                }
            } else if (i4 == 2) {
                String str4 = f3698h;
                if (str4 == null) {
                    str = "MeizuIdManager";
                    str2 = "get ids-aa failed";
                } else {
                    f3701k = str4;
                    f3698h = null;
                    str = "MeizuIdManager";
                    str2 = "query aaid: " + f3701k;
                }
            }
            cn.jiguang.w.a.b(str, str2);
        }
    }

    public boolean b() {
        return f3692b;
    }

    public String c() {
        if (b()) {
            String str = f3699i;
            if (str != null) {
                return str;
            }
            a(0);
            return f3699i;
        }
        return null;
    }
}
