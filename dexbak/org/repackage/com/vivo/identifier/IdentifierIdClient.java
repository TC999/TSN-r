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
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.stub.StubApp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* renamed from: org.repackage.com.vivo.identifier.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class IdentifierIdClient {

    /* renamed from: A */
    private static boolean f44214A = false;

    /* renamed from: B */
    private static int f44215B = 13;

    /* renamed from: C */
    private static IdentifierIdObserver f44216C = null;

    /* renamed from: D */
    private static IdentifierIdObserver f44217D = null;

    /* renamed from: E */
    private static IdentifierIdObserver f44218E = null;

    /* renamed from: F */
    private static IdentifierIdObserver f44219F = null;

    /* renamed from: G */
    private static HandlerThread f44220G = null;

    /* renamed from: H */
    private static Handler f44221H = null;

    /* renamed from: I */
    private static String f44222I = null;

    /* renamed from: J */
    private static String f44223J = null;

    /* renamed from: K */
    private static String f44224K = null;

    /* renamed from: L */
    private static String f44225L = null;

    /* renamed from: M */
    private static String f44226M = null;

    /* renamed from: N */
    private static String f44227N = null;

    /* renamed from: O */
    private static String f44228O = null;

    /* renamed from: P */
    private static volatile IdentifierIdClient f44229P = null;

    /* renamed from: Q */
    private static volatile DataBaseOperation f44230Q = null;

    /* renamed from: R */
    private static int f44231R = 0;

    /* renamed from: S */
    private static int f44232S = 0;

    /* renamed from: T */
    private static int f44233T = 0;

    /* renamed from: U */
    private static int f44234U = 0;

    /* renamed from: V */
    private static int f44235V = 0;

    /* renamed from: W */
    private static int f44236W = 0;

    /* renamed from: X */
    private static int f44237X = 0;

    /* renamed from: Y */
    private static int f44238Y = 0;

    /* renamed from: Z */
    private static int f44239Z = 0;

    /* renamed from: a0 */
    private static int f44240a0 = 0;

    /* renamed from: b */
    private static final String f44241b = "VMS_SDK_Client";

    /* renamed from: b0 */
    private static int f44242b0 = 0;

    /* renamed from: c */
    private static final String f44243c = "content://com.vivo.vms.IdProvider/IdentifierId";

    /* renamed from: c0 */
    private static int f44244c0 = 0;

    /* renamed from: d */
    private static final String f44245d = "persist.sys.identifierid.supported";

    /* renamed from: e */
    public static final String f44246e = "persist.sys.identifierid";

    /* renamed from: f */
    private static final String f44247f = "com.vivo.vms";

    /* renamed from: g */
    private static final String f44248g = "appid";

    /* renamed from: h */
    private static final String f44249h = "type";

    /* renamed from: i */
    private static final String f44250i = "OAID";

    /* renamed from: j */
    private static final String f44251j = "VAID";

    /* renamed from: k */
    private static final String f44252k = "OAIDSTATUS";

    /* renamed from: l */
    private static Object f44253l = new Object();

    /* renamed from: m */
    private static final int f44254m = 0;

    /* renamed from: n */
    private static final int f44255n = 1;

    /* renamed from: o */
    private static final int f44256o = 2;

    /* renamed from: p */
    private static final int f44257p = 3;

    /* renamed from: q */
    private static final int f44258q = 4;

    /* renamed from: r */
    private static final int f44259r = 5;

    /* renamed from: s */
    private static final int f44260s = 6;

    /* renamed from: t */
    private static final int f44261t = 7;

    /* renamed from: u */
    private static final int f44262u = 8;

    /* renamed from: v */
    private static final int f44263v = 9;

    /* renamed from: w */
    private static final int f44264w = 10;

    /* renamed from: x */
    private static final int f44265x = 11;

    /* renamed from: y */
    private static final int f44266y = 2000;

    /* renamed from: z */
    private static Context f44267z;

    /* renamed from: a */
    private final int f44268a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IdentifierIdClient.java */
    /* renamed from: org.repackage.com.vivo.identifier.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class RunnableC15416a implements Runnable {
        RunnableC15416a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (IdentifierIdClient.f44231R + IdentifierIdClient.f44232S + IdentifierIdClient.f44237X + IdentifierIdClient.f44240a0 + IdentifierIdClient.f44233T + IdentifierIdClient.f44234U + IdentifierIdClient.f44239Z + IdentifierIdClient.f44240a0 + IdentifierIdClient.f44235V + IdentifierIdClient.f44236W + IdentifierIdClient.f44242b0 + IdentifierIdClient.f44244c0 > 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("oaid", IdentifierIdClient.this.m2724g(IdentifierIdClient.f44231R, IdentifierIdClient.f44232S, IdentifierIdClient.f44237X, IdentifierIdClient.f44238Y));
                contentValues.put("vaid", IdentifierIdClient.this.m2724g(IdentifierIdClient.f44233T, IdentifierIdClient.f44234U, IdentifierIdClient.f44239Z, IdentifierIdClient.f44240a0));
                contentValues.put("aaid", IdentifierIdClient.this.m2724g(IdentifierIdClient.f44235V, IdentifierIdClient.f44236W, IdentifierIdClient.f44242b0, IdentifierIdClient.f44244c0));
                IdentifierIdClient.f44230Q.m2763c(7, "vivo", new ContentValues[]{contentValues});
                int unused = IdentifierIdClient.f44231R = IdentifierIdClient.f44232S = IdentifierIdClient.f44233T = IdentifierIdClient.f44234U = IdentifierIdClient.f44235V = IdentifierIdClient.f44236W = 0;
                int unused2 = IdentifierIdClient.f44237X = IdentifierIdClient.f44238Y = IdentifierIdClient.f44239Z = IdentifierIdClient.f44240a0 = IdentifierIdClient.f44242b0 = IdentifierIdClient.f44244c0 = 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IdentifierIdClient.java */
    /* renamed from: org.repackage.com.vivo.identifier.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class HandlerC15417b extends Handler {
        HandlerC15417b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 11) {
                int i = message.getData().getInt("type");
                try {
                    String m2765a = IdentifierIdClient.f44230Q.m2765a(i, message.getData().getString("appid"));
                    if (i == 0) {
                        String unused = IdentifierIdClient.f44222I = m2765a;
                        IdentifierIdClient.m2700z(8, IdentifierIdClient.f44222I);
                    } else if (i == 1) {
                        if (m2765a != null) {
                            String unused2 = IdentifierIdClient.f44223J = m2765a;
                        } else {
                            Log.e(IdentifierIdClient.f44241b, "get vaid failed");
                        }
                        IdentifierIdClient.m2700z(9, IdentifierIdClient.f44223J);
                    } else if (i == 2) {
                        if (m2765a != null) {
                            String unused3 = IdentifierIdClient.f44224K = m2765a;
                        } else {
                            Log.e(IdentifierIdClient.f44241b, "get aaid failed");
                        }
                        IdentifierIdClient.m2700z(10, IdentifierIdClient.f44224K);
                    } else if (i != 3) {
                        if (i == 4) {
                            String unused4 = IdentifierIdClient.f44226M = m2765a;
                        } else if (i == 5) {
                            if (m2765a != null) {
                                String unused5 = IdentifierIdClient.f44227N = m2765a;
                            } else {
                                Log.e(IdentifierIdClient.f44241b, "get guid failed");
                            }
                        }
                    } else if (m2765a != null) {
                        String unused6 = IdentifierIdClient.f44225L = m2765a;
                    } else {
                        Log.e(IdentifierIdClient.f44241b, "get udid failed");
                    }
                } catch (Exception e) {
                    Log.e(IdentifierIdClient.f44241b, "readException:" + e.toString());
                }
                synchronized (IdentifierIdClient.f44253l) {
                    IdentifierIdClient.f44253l.notify();
                }
                return;
            }
            Log.e(IdentifierIdClient.f44241b, "message type valid");
        }
    }

    private IdentifierIdClient() {
        m2730d();
        f44230Q = new DataBaseOperation(f44267z);
        this.f44268a = m2703w(f44267z);
    }

    /* renamed from: D */
    private void m2759D(int i, String str) {
        m2714l(i, str);
    }

    /* renamed from: H */
    private void m2755H(int i, String str) {
        synchronized (f44253l) {
            m2714l(i, str);
            long uptimeMillis = SystemClock.uptimeMillis();
            try {
                f44253l.wait(2000L);
            } catch (InterruptedException unused) {
                Log.e(f44241b, "queryId: lock error");
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 2000) {
                Log.d(f44241b, "query timeout");
            }
        }
    }

    /* renamed from: c */
    private void m2732c() {
        Executors.newScheduledThreadPool(1).scheduleWithFixedDelay(new RunnableC15416a(), 600L, 600L, TimeUnit.SECONDS);
    }

    /* renamed from: d */
    private static void m2730d() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        f44220G = handlerThread;
        handlerThread.start();
        f44221H = new HandlerC15417b(f44220G.getLooper());
    }

    /* renamed from: e */
    private static void m2728e() {
        f44214A = "1".equals(m2720i(f44245d, "0")) || "1".equals(m2720i(f44246e, "0"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public String m2724g(int i, int i2, int i3, int i4) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i);
        stringBuffer.append(",");
        stringBuffer.append(i2);
        stringBuffer.append(";");
        stringBuffer.append(i3);
        stringBuffer.append(",");
        stringBuffer.append(i4);
        return stringBuffer.toString();
    }

    /* renamed from: i */
    private static String m2720i(String str, String str2) {
        try {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getMethod("get", String.class, String.class).invoke(cls, str, "0");
            } catch (Exception e) {
                Log.e(f44241b, "getProperty: invoke is error" + e.getMessage());
                return str2;
            }
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static IdentifierIdClient m2716k(Context context) {
        if (f44267z == null) {
            if (context == null) {
                return null;
            }
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext != null) {
                context = origApplicationContext;
            }
            f44267z = context;
        }
        if (f44229P == null) {
            synchronized (IdentifierIdClient.class) {
                if (f44229P == null) {
                    f44229P = new IdentifierIdClient();
                    f44229P.m2732c();
                }
            }
        }
        return f44229P;
    }

    /* renamed from: m */
    private static synchronized void m2713m(Context context, int i, String str) {
        synchronized (IdentifierIdClient.class) {
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        if (f44218E == null) {
                            f44218E = new IdentifierIdObserver(f44229P, 2, str);
                            ContentResolver contentResolver = context.getContentResolver();
                            contentResolver.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/" + context.getPackageName()), false, f44218E);
                        }
                    }
                } else if (f44217D == null) {
                    f44217D = new IdentifierIdObserver(f44229P, 1, str);
                    ContentResolver contentResolver2 = context.getContentResolver();
                    contentResolver2.registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/VAID_" + str), false, f44217D);
                }
            } else if (f44216C == null) {
                f44216C = new IdentifierIdObserver(f44229P, 0, null);
                context.getContentResolver().registerContentObserver(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), true, f44216C);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static boolean m2712n() {
        if (!f44214A) {
            m2728e();
        }
        return f44214A;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public static IdentifierIdClient m2706t(Context context) {
        if (m2712n()) {
            return m2716k(context);
        }
        return null;
    }

    /* renamed from: w */
    private static int m2703w(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(f44247f, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public static void m2700z(int i, String str) {
        if (i == 0) {
            if (str == null) {
                f44232S++;
            } else {
                f44231R++;
            }
        } else if (i == 1) {
            if (str == null) {
                f44234U++;
            } else {
                f44233T++;
            }
        } else if (i == 2) {
            if (str == null) {
                f44236W++;
            } else {
                f44235V++;
            }
        } else {
            switch (i) {
                case 8:
                    if (str == null) {
                        f44238Y++;
                        return;
                    } else {
                        f44237X++;
                        return;
                    }
                case 9:
                    if (str == null) {
                        f44240a0++;
                        return;
                    } else {
                        f44239Z++;
                        return;
                    }
                case 10:
                    if (str == null) {
                        f44244c0++;
                        return;
                    } else {
                        f44242b0++;
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public String m2761B() {
        String str = f44222I;
        if (str != null) {
            m2700z(0, str);
            return f44222I;
        }
        m2759D(0, null);
        if (f44216C == null) {
            m2713m(f44267z, 0, null);
        }
        m2700z(0, f44222I);
        return f44222I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: F */
    public String m2757F() {
        String str = f44223J;
        if (str != null) {
            m2700z(1, str);
            return f44223J;
        }
        m2755H(1, "vivo");
        if (f44217D == null) {
            m2713m(f44267z, 1, "vivo");
        }
        m2700z(1, f44223J);
        return f44223J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: J */
    public String m2753J() {
        String str = f44223J;
        if (str != null) {
            m2700z(1, str);
            return f44223J;
        }
        m2759D(1, "vivo");
        if (f44217D == null) {
            m2713m(f44267z, 1, "vivo");
        }
        m2700z(1, f44223J);
        return f44223J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: M */
    public String m2750M() {
        String str = f44224K;
        if (str != null) {
            m2700z(2, str);
            return f44224K;
        }
        m2755H(2, "vivo");
        if (f44218E == null) {
            m2713m(f44267z, 2, "vivo");
        }
        m2700z(2, f44224K);
        return f44224K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: O */
    public String m2748O() {
        String str = f44224K;
        if (str != null) {
            m2700z(2, str);
            return f44224K;
        }
        m2759D(2, "vivo");
        if (f44218E == null) {
            m2713m(f44267z, 2, "vivo");
        }
        m2700z(2, f44224K);
        return f44224K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Q */
    public String m2746Q() {
        m2755H(4, null);
        return f44226M;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: S */
    public String m2744S() {
        String str = f44227N;
        if (str != null) {
            return str;
        }
        m2755H(5, "vivo");
        return f44227N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: U */
    public String m2742U() {
        String str = f44227N;
        if (str != null) {
            return str;
        }
        m2759D(5, "vivo");
        return f44227N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public void m2714l(int i, String str) {
        Message obtainMessage = f44221H.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", i);
        if (i == 1 || i == 2 || i == 6) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        f44221H.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public boolean m2711o(List<String> list) {
        if (this.f44268a < f44215B) {
            return false;
        }
        if (list != null && list.size() != 0) {
            try {
                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
                for (int i = 0; i < list.size(); i++) {
                    ContentValues contentValues = new ContentValues();
                    String[] split = list.get(i).split(":");
                    if (split.length != 2) {
                        return false;
                    }
                    String str = split[0];
                    String str2 = split[1];
                    contentValues.put(TTDownloadField.TT_PACKAGE_NAME, str);
                    contentValues.put("uid", str2);
                    contentValues.put(DomainCampaignEx.LOOPBACK_VALUE, format);
                    contentValuesArr[i] = contentValues;
                }
                return f44230Q.m2763c(6, "vivo", contentValuesArr);
            } catch (Exception unused) {
                Log.e(f44241b, "insert OAIDBLACK failure");
                return false;
            }
        }
        Log.e(f44241b, "List is null when insert OAIDBLACK");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public String m2709q() {
        String str = f44225L;
        if (str != null) {
            return str;
        }
        m2755H(3, null);
        return f44225L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public List m2707s(List<String> list) {
        if (this.f44268a < f44215B) {
            return null;
        }
        if (list != null && list.size() != 0) {
            try {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    String[] split = list.get(i).split(":");
                    if (split.length == 2) {
                        arrayList.add(Boolean.valueOf(f44230Q.m2764b(6, "vivo", split[0], split[1])));
                    }
                }
                return arrayList;
            } catch (Exception unused) {
                Log.e(f44241b, "delete OAIDBLACK failure");
                return null;
            }
        }
        Log.e(f44241b, "List is null when delete OAIDBLACK");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: x */
    public String m2702x() {
        String str = f44222I;
        if (str != null) {
            m2700z(0, str);
            return f44222I;
        }
        m2755H(0, null);
        if (f44216C == null) {
            m2713m(f44267z, 0, null);
        }
        m2700z(0, f44222I);
        return f44222I;
    }
}
