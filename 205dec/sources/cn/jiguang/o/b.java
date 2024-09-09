package cn.jiguang.o;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.acse.ottn.f3;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static Context f3749a;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f3750b;

    /* renamed from: c  reason: collision with root package name */
    private static b f3751c;

    /* renamed from: d  reason: collision with root package name */
    private static a f3752d;

    /* renamed from: e  reason: collision with root package name */
    private static Object f3753e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static HandlerThread f3754f;

    /* renamed from: g  reason: collision with root package name */
    private static Handler f3755g;

    /* renamed from: h  reason: collision with root package name */
    private static String f3756h;

    /* renamed from: i  reason: collision with root package name */
    private static String f3757i;

    /* renamed from: j  reason: collision with root package name */
    private static String f3758j;

    /* renamed from: k  reason: collision with root package name */
    private static String f3759k;

    private b() {
    }

    public static b a(Context context) {
        if (f3751c == null) {
            f3751c = new b();
            f3749a = context;
            f();
            f3752d = new a(f3749a);
            a();
        }
        return f3751c;
    }

    public static String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void a() {
        f3750b = "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    private void b(int i4, String str) {
        Message obtainMessage = f3755g.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i4);
        if (i4 == 1 || i4 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        f3755g.sendMessage(obtainMessage);
    }

    private static void f() {
        HandlerThread handlerThread = new HandlerThread("jg_vvdb_thread");
        f3754f = handlerThread;
        handlerThread.start();
        f3755g = new Handler(f3754f.getLooper()) { // from class: cn.jiguang.o.b.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 11) {
                    cn.jiguang.w.a.b("VivoIdManager", "message type valid");
                    return;
                }
                try {
                    String unused = b.f3756h = b.f3752d.a(message.getData().getInt("type"), message.getData().getString("appid"));
                } catch (Throwable th) {
                    String unused2 = b.f3756h = "";
                    cn.jiguang.w.a.f("VivoIdManager", "vv getIds, exception" + th.getMessage());
                }
                synchronized (b.f3753e) {
                    b.f3753e.notify();
                }
            }
        };
    }

    public void a(int i4, String str) {
        String str2;
        String str3;
        synchronized (f3753e) {
            b(i4, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f3753e.wait(2000L);
            } catch (InterruptedException e4) {
                cn.jiguang.w.a.f("VivoIdManager", "lock wait error: " + e4.getMessage());
            }
            if (SystemClock.uptimeMillis() - uptimeMillis < 2000) {
                if (i4 == 0) {
                    f3757i = f3756h;
                } else if (i4 == 1) {
                    String str4 = f3756h;
                    if (str4 == null) {
                        str2 = "VivoIdManager";
                        str3 = "get vaid failed";
                    } else {
                        f3758j = str4;
                    }
                } else if (i4 == 2) {
                    String str5 = f3756h;
                    if (str5 == null) {
                        str2 = "VivoIdManager";
                        str3 = "get aaid failed";
                    } else {
                        f3759k = str5;
                    }
                }
                f3756h = null;
            } else {
                str2 = "VivoIdManager";
                str3 = "query timeout";
            }
            cn.jiguang.w.a.b(str2, str3);
        }
    }

    public boolean b() {
        return f3750b;
    }

    public String c() {
        if (b()) {
            String str = f3757i;
            if (str != null) {
                return str;
            }
            a(0, (String) null);
            return f3757i;
        }
        return null;
    }
}
