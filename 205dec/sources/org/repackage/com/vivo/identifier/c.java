package org.repackage.com.vivo.identifier;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.acse.ottn.f3;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import xyz.adscope.ad.model.http.request.ad.constant.AdRequestConstant;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: IdentifierIdClient.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class c {
    private static boolean A = false;
    private static int B = 13;
    private static d C = null;
    private static d D = null;
    private static d E = null;
    private static d F = null;
    private static HandlerThread G = null;
    private static Handler H = null;
    private static String I = null;
    private static String J = null;
    private static String K = null;

    /* renamed from: L  reason: collision with root package name */
    private static String f61640L = null;
    private static String M = null;
    private static String N = null;
    private static String O = null;
    private static volatile c P = null;
    private static volatile org.repackage.com.vivo.identifier.b Q = null;
    private static int R = 0;
    private static int S = 0;
    private static int T = 0;
    private static int U = 0;
    private static int V = 0;
    private static int W = 0;
    private static int X = 0;
    private static int Y = 0;
    private static int Z = 0;

    /* renamed from: a0  reason: collision with root package name */
    private static int f61641a0 = 0;

    /* renamed from: b  reason: collision with root package name */
    private static final String f61642b = "VMS_SDK_Client";

    /* renamed from: b0  reason: collision with root package name */
    private static int f61643b0 = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final String f61644c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: c0  reason: collision with root package name */
    private static int f61645c0 = 0;

    /* renamed from: d  reason: collision with root package name */
    private static final String f61646d = "persist.sys.identifierid.supported";

    /* renamed from: e  reason: collision with root package name */
    public static final String f61647e = "persist.sys.identifierid";

    /* renamed from: f  reason: collision with root package name */
    private static final String f61648f = "com.vivo.vms";

    /* renamed from: g  reason: collision with root package name */
    private static final String f61649g = "appid";

    /* renamed from: h  reason: collision with root package name */
    private static final String f61650h = "type";

    /* renamed from: i  reason: collision with root package name */
    private static final String f61651i = "OAID";

    /* renamed from: j  reason: collision with root package name */
    private static final String f61652j = "VAID";

    /* renamed from: k  reason: collision with root package name */
    private static final String f61653k = "OAIDSTATUS";

    /* renamed from: l  reason: collision with root package name */
    private static Object f61654l = new Object();

    /* renamed from: m  reason: collision with root package name */
    private static final int f61655m = 0;

    /* renamed from: n  reason: collision with root package name */
    private static final int f61656n = 1;

    /* renamed from: o  reason: collision with root package name */
    private static final int f61657o = 2;

    /* renamed from: p  reason: collision with root package name */
    private static final int f61658p = 3;

    /* renamed from: q  reason: collision with root package name */
    private static final int f61659q = 4;

    /* renamed from: r  reason: collision with root package name */
    private static final int f61660r = 5;

    /* renamed from: s  reason: collision with root package name */
    private static final int f61661s = 6;

    /* renamed from: t  reason: collision with root package name */
    private static final int f61662t = 7;

    /* renamed from: u  reason: collision with root package name */
    private static final int f61663u = 8;

    /* renamed from: v  reason: collision with root package name */
    private static final int f61664v = 9;

    /* renamed from: w  reason: collision with root package name */
    private static final int f61665w = 10;

    /* renamed from: x  reason: collision with root package name */
    private static final int f61666x = 11;

    /* renamed from: y  reason: collision with root package name */
    private static final int f61667y = 2000;

    /* renamed from: z  reason: collision with root package name */
    private static Context f61668z;

    /* renamed from: a  reason: collision with root package name */
    private final int f61669a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IdentifierIdClient.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.R + c.S + c.X + c.f61641a0 + c.T + c.U + c.Z + c.f61641a0 + c.V + c.W + c.f61643b0 + c.f61645c0 > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(AdRequestConstant.AD_REQUEST_DEVICE_EXT_OAID_KEY, c.this.g(c.R, c.S, c.X, c.Y));
                contentValues.put("vaid", c.this.g(c.T, c.U, c.Z, c.f61641a0));
                contentValues.put("aaid", c.this.g(c.V, c.W, c.f61643b0, c.f61645c0));
                c.Q.c(7, "vivo", new ContentValues[]{contentValues});
                int unused = c.R = c.S = c.T = c.U = c.V = c.W = 0;
                int unused2 = c.X = c.Y = c.Z = c.f61641a0 = c.f61643b0 = c.f61645c0 = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: IdentifierIdClient.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                int i4 = message.getData().getInt("type");
                try {
                    String a4 = c.Q.a(i4, message.getData().getString("appid"));
                    if (i4 == 0) {
                        String unused = c.I = a4;
                        c.z(8, c.I);
                    } else if (i4 == 1) {
                        if (a4 != null) {
                            String unused2 = c.J = a4;
                        } else {
                            Log.e("VMS_SDK_Client", "get vaid failed");
                        }
                        c.z(9, c.J);
                    } else if (i4 == 2) {
                        if (a4 != null) {
                            String unused3 = c.K = a4;
                        } else {
                            Log.e("VMS_SDK_Client", "get aaid failed");
                        }
                        c.z(10, c.K);
                    } else if (i4 != 3) {
                        if (i4 == 4) {
                            String unused4 = c.M = a4;
                        } else if (i4 == 5) {
                            if (a4 != null) {
                                String unused5 = c.N = a4;
                            } else {
                                Log.e("VMS_SDK_Client", "get guid failed");
                            }
                        }
                    } else if (a4 != null) {
                        String unused6 = c.f61640L = a4;
                    } else {
                        Log.e("VMS_SDK_Client", "get udid failed");
                    }
                } catch (Exception e4) {
                    Log.e("VMS_SDK_Client", "readException:" + e4.toString());
                }
                synchronized (c.f61654l) {
                    c.f61654l.notify();
                }
                return;
            }
            Log.e("VMS_SDK_Client", "message type valid");
        }
    }

    private c() {
        d();
        Q = new org.repackage.com.vivo.identifier.b(f61668z);
        this.f61669a = w(f61668z);
    }

    private void D(int i4, String str) {
        l(i4, str);
    }

    private void H(int i4, String str) {
        synchronized (f61654l) {
            l(i4, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f61654l.wait(2000L);
            } catch (InterruptedException unused) {
                Log.e("VMS_SDK_Client", "queryId: lock error");
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                Log.d("VMS_SDK_Client", "query timeout");
            }
        }
    }

    private void c() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new a(), 600L, 600L, TimeUnit.SECONDS);
    }

    private static void d() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        G = handlerThread;
        handlerThread.start();
        H = new b(G.getLooper());
    }

    private static void e() {
        A = "1".equals(i("persist.sys.identifierid.supported", "0")) || "1".equals(i("persist.sys.identifierid", "0"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String g(int i4, int i5, int i6, int i7) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i4);
        stringBuffer.append(",");
        stringBuffer.append(i5);
        stringBuffer.append(";");
        stringBuffer.append(i6);
        stringBuffer.append(",");
        stringBuffer.append(i7);
        return stringBuffer.toString();
    }

    private static String i(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e4) {
                Log.e("VMS_SDK_Client", "getProperty: invoke is error" + e4.getMessage());
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c k(Context context) {
        if (f61668z == null) {
            if (context == null) {
                return null;
            }
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext != null) {
                context = origApplicationContext;
            }
            f61668z = context;
        }
        if (P == null) {
            synchronized (c.class) {
                if (P == null) {
                    P = new c();
                    P.c();
                }
            }
        }
        return P;
    }

    private static synchronized void m(Context context, int i4, String str) {
        synchronized (c.class) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 == 2) {
                        if (E == null) {
                            E = new d(P, 2, str);
                            ContentResolver contentResolver = context.getContentResolver();
                            contentResolver.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, E);
                        }
                    }
                } else if (D == null) {
                    D = new d(P, 1, str);
                    ContentResolver contentResolver2 = context.getContentResolver();
                    contentResolver2.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, D);
                }
            } else if (C == null) {
                C = new d(P, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, C);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean n() {
        if (!A) {
            e();
        }
        return A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c t(Context context) {
        if (n()) {
            return k(context);
        }
        return null;
    }

    private static int w(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.vivo.vms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(int i4, String str) {
        if (i4 == 0) {
            if (str == null) {
                S++;
            } else {
                R++;
            }
        } else if (i4 == 1) {
            if (str == null) {
                U++;
            } else {
                T++;
            }
        } else if (i4 == 2) {
            if (str == null) {
                W++;
            } else {
                V++;
            }
        } else {
            switch (i4) {
                case 8:
                    if (str == null) {
                        Y++;
                        return;
                    } else {
                        X++;
                        return;
                    }
                case 9:
                    if (str == null) {
                        f61641a0++;
                        return;
                    } else {
                        Z++;
                        return;
                    }
                case 10:
                    if (str == null) {
                        f61645c0++;
                        return;
                    } else {
                        f61643b0++;
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String B() {
        String str = I;
        if (str != null) {
            z(0, str);
            return I;
        }
        D(0, null);
        if (C == null) {
            m(f61668z, 0, null);
        }
        z(0, I);
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String F() {
        String str = J;
        if (str != null) {
            z(1, str);
            return J;
        }
        H(1, "vivo");
        if (D == null) {
            m(f61668z, 1, "vivo");
        }
        z(1, J);
        return J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String J() {
        String str = J;
        if (str != null) {
            z(1, str);
            return J;
        }
        D(1, "vivo");
        if (D == null) {
            m(f61668z, 1, "vivo");
        }
        z(1, J);
        return J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String M() {
        String str = K;
        if (str != null) {
            z(2, str);
            return K;
        }
        H(2, "vivo");
        if (E == null) {
            m(f61668z, 2, "vivo");
        }
        z(2, K);
        return K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String O() {
        String str = K;
        if (str != null) {
            z(2, str);
            return K;
        }
        D(2, "vivo");
        if (E == null) {
            m(f61668z, 2, "vivo");
        }
        z(2, K);
        return K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Q() {
        H(4, null);
        return M;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String S() {
        String str = N;
        if (str != null) {
            return str;
        }
        H(5, "vivo");
        return N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String U() {
        String str = N;
        if (str != null) {
            return str;
        }
        D(5, "vivo");
        return N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(int i4, String str) {
        Message obtainMessage = H.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i4);
        if (i4 == 1 || i4 == 2 || i4 == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        H.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(List<String> list) {
        if (this.f61669a < B) {
            return false;
        }
        if (list != null && list.size() != 0) {
            try {
                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
                for (int i4 = 0; i4 < list.size(); i4++) {
                    ContentValues contentValues = new ContentValues();
                    String[] split = list.get(i4).split(":");
                    if (split.length != 2) {
                        return false;
                    }
                    String str = split[0];
                    String str2 = split[1];
                    contentValues.put("packageName", str);
                    contentValues.put("uid", str2);
                    contentValues.put("value", format);
                    contentValuesArr[i4] = contentValues;
                }
                return Q.c(6, "vivo", contentValuesArr);
            } catch (Exception unused) {
                Log.e("VMS_SDK_Client", "insert OAIDBLACK failure");
                return false;
            }
        }
        Log.e("VMS_SDK_Client", "List is null when insert OAIDBLACK");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String q() {
        String str = f61640L;
        if (str != null) {
            return str;
        }
        H(3, null);
        return f61640L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List s(List<String> list) {
        if (this.f61669a < B) {
            return null;
        }
        if (list != null && list.size() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i4 = 0; i4 < list.size(); i4++) {
                    String[] split = list.get(i4).split(":");
                    if (split.length == 2) {
                        arrayList.add(Boolean.valueOf(Q.b(6, "vivo", split[0], split[1])));
                    }
                }
                return arrayList;
            } catch (Exception unused) {
                Log.e("VMS_SDK_Client", "delete OAIDBLACK failure");
                return null;
            }
        }
        Log.e("VMS_SDK_Client", "List is null when delete OAIDBLACK");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String x() {
        String str = I;
        if (str != null) {
            z(0, str);
            return I;
        }
        H(0, null);
        if (C == null) {
            m(f61668z, 0, null);
        }
        z(0, I);
        return I;
    }
}
