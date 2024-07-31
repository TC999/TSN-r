package p000XI.p001CA.p002XI;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.stub.StubApp;

/* renamed from: XI.CA.XI.K0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C0000K0 {

    /* renamed from: CA */
    public static C0003kM f0CA;

    /* renamed from: CV */
    public static volatile C0002XI f1CV;

    /* renamed from: FL */
    public static Handler f2FL;

    /* renamed from: J9 */
    public static HandlerThread f3J9;

    /* renamed from: K0 */
    public static boolean f4K0;

    /* renamed from: WI */
    public static String f5WI;

    /* renamed from: XI */
    public static Context f6XI;

    /* renamed from: bs */
    public static String f7bs;

    /* renamed from: cs */
    public static String f8cs;

    /* renamed from: kM */
    public static C0003kM f9kM;

    /* renamed from: q6 */
    public static volatile C0000K0 f10q6;

    /* renamed from: vs */
    public static Object f11vs = new Object();

    /* renamed from: xo */
    public static C0003kM f12xo;

    /* renamed from: XI.CA.XI.K0$XI */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class HandlerC0001XI extends Handler {
        public HandlerC0001XI(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                int i = message.getData().getInt("type");
                try {
                    String m60072XI = C0000K0.f1CV.m60072XI(i, message.getData().getString("appid"));
                    if (i == 0) {
                        C0000K0.f5WI = m60072XI;
                    } else if (i != 1) {
                        if (i == 2 && m60072XI != null) {
                            C0000K0.f8cs = m60072XI;
                        }
                    } else if (m60072XI != null) {
                        C0000K0.f7bs = m60072XI;
                    }
                } catch (Exception e) {
                    e.toString();
                }
                Context context = C0000K0.f6XI;
                synchronized (C0000K0.f11vs) {
                    C0000K0.f11vs.notify();
                }
            }
        }
    }

    public C0000K0() {
        m60076XI();
        f1CV = new C0002XI(f6XI);
    }

    /* renamed from: K0 */
    public static boolean m60078K0() {
        String str = "0";
        if (!f4K0 && Build.VERSION.SDK_INT >= 28) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                str = (String) cls.getMethod("get", String.class, String.class).invoke(cls, "persist.sys.identifierid.supported", "0");
            } catch (Throwable unused) {
            }
            f4K0 = "1".equals(str);
        }
        return f4K0;
    }

    /* renamed from: XI */
    public static C0000K0 m60074XI(Context context) {
        if (m60078K0()) {
            if (f6XI == null) {
                if (context == null) {
                    return null;
                }
                Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
                if (origApplicationContext != null) {
                    context = origApplicationContext;
                }
                f6XI = context;
            }
            if (f10q6 == null) {
                synchronized (C0000K0.class) {
                    if (f10q6 == null) {
                        f10q6 = new C0000K0();
                    }
                }
            }
            return f10q6;
        }
        return null;
    }

    /* renamed from: XI */
    public static void m60076XI() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        f3J9 = handlerThread;
        handlerThread.start();
        f2FL = new HandlerC0001XI(f3J9.getLooper());
    }

    /* renamed from: XI */
    public static synchronized void m60073XI(Context context, int i, String str) {
        ContentResolver contentResolver;
        Uri parse;
        C0003kM c0003kM;
        synchronized (C0000K0.class) {
            String packageName = context.getPackageName();
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 && f0CA == null) {
                        int i2 = Build.VERSION.SDK_INT;
                        if (i2 >= 29) {
                            f0CA = new C0003kM(f10q6, 2, packageName);
                            contentResolver = context.getContentResolver();
                            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + packageName);
                            c0003kM = f0CA;
                        } else if (i2 == 28) {
                            f0CA = new C0003kM(f10q6, 2, str);
                            contentResolver = context.getContentResolver();
                            parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/AAID_" + str);
                            c0003kM = f0CA;
                        }
                        contentResolver.registerContentObserver(parse, false, c0003kM);
                    }
                } else if (f12xo == null) {
                    int i3 = Build.VERSION.SDK_INT;
                    if (i3 >= 29) {
                        f12xo = new C0003kM(f10q6, 1, packageName);
                        contentResolver = context.getContentResolver();
                        parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + packageName);
                        c0003kM = f12xo;
                    } else if (i3 == 28) {
                        f12xo = new C0003kM(f10q6, 1, str);
                        contentResolver = context.getContentResolver();
                        parse = Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str);
                        c0003kM = f12xo;
                    }
                    contentResolver.registerContentObserver(parse, false, c0003kM);
                }
            } else if (f9kM == null) {
                f9kM = new C0003kM(f10q6, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f9kM);
            }
        }
    }

    /* renamed from: K0 */
    public void m60077K0(int i, String str) {
        Message obtainMessage = f2FL.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        if (i == 1 || i == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        f2FL.sendMessage(obtainMessage);
    }

    /* renamed from: XI */
    public final void m60075XI(int i, String str) {
        synchronized (f11vs) {
            m60077K0(i, str);
            SystemClock.uptimeMillis();
            try {
                f11vs.wait(2000L);
            } catch (InterruptedException unused) {
            }
            SystemClock.uptimeMillis();
        }
    }
}
