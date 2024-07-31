package com.amap.api.col.p047s;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Xml;
import android.view.WindowManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import kotlin.UByte;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: DeviceInfo.java */
/* renamed from: com.amap.api.col.s.c1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2023c1 {

    /* renamed from: A */
    private static String f5911A = "";

    /* renamed from: B */
    private static String f5912B = "";

    /* renamed from: C */
    private static boolean f5913C = false;

    /* renamed from: D */
    static int f5914D = -1;

    /* renamed from: E */
    static String f5915E = "";

    /* renamed from: F */
    private static boolean f5916F = false;

    /* renamed from: G */
    static String f5917G = "";

    /* renamed from: H */
    private static String f5918H = "";

    /* renamed from: I */
    private static boolean f5919I = false;

    /* renamed from: J */
    private static boolean f5920J = false;

    /* renamed from: K */
    private static long f5921K = 0;

    /* renamed from: L */
    private static int f5922L = 0;

    /* renamed from: M */
    private static String f5923M = null;

    /* renamed from: N */
    private static String f5924N = "";

    /* renamed from: O */
    private static boolean f5925O = true;

    /* renamed from: P */
    private static boolean f5926P = false;

    /* renamed from: Q */
    private static String f5927Q = "";

    /* renamed from: R */
    private static boolean f5928R = false;

    /* renamed from: S */
    private static int f5929S = -1;

    /* renamed from: T */
    private static boolean f5930T = false;

    /* renamed from: U */
    private static int f5931U = -1;

    /* renamed from: V */
    private static boolean f5932V = false;

    /* renamed from: W */
    private static volatile C2027d f5933W = null;

    /* renamed from: a */
    static String f5934a = "";

    /* renamed from: b */
    static String f5935b = "";

    /* renamed from: c */
    static volatile boolean f5936c = true;

    /* renamed from: d */
    public static boolean f5937d = false;

    /* renamed from: e */
    static String f5938e = "";

    /* renamed from: f */
    static boolean f5939f = false;

    /* renamed from: g */
    private static String f5940g = null;

    /* renamed from: h */
    private static boolean f5941h = false;

    /* renamed from: i */
    private static String f5942i = "";

    /* renamed from: j */
    public static InterfaceC2026c f5943j = null;

    /* renamed from: k */
    private static volatile boolean f5944k = false;

    /* renamed from: l */
    private static String f5945l = "";

    /* renamed from: m */
    private static boolean f5946m = false;

    /* renamed from: n */
    private static String f5947n = null;

    /* renamed from: o */
    private static IBinder f5948o = null;

    /* renamed from: p */
    private static boolean f5949p = false;

    /* renamed from: q */
    private static boolean f5950q = false;

    /* renamed from: r */
    private static String f5951r = "";

    /* renamed from: s */
    private static String f5952s = "";

    /* renamed from: t */
    private static boolean f5953t = false;

    /* renamed from: u */
    private static boolean f5954u = false;

    /* renamed from: v */
    private static String f5955v = "";

    /* renamed from: w */
    private static boolean f5956w = false;

    /* renamed from: x */
    private static String f5957x = "";

    /* renamed from: y */
    private static boolean f5958y = false;

    /* renamed from: z */
    private static String f5959z = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.s.c1$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2024a extends AbstractRunnableC2229z3 {

        /* renamed from: b */
        final /* synthetic */ Context f5960b;

        C2024a(Context context) {
            this.f5960b = context;
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            try {
                Map<String, String> mo52315b = C2023c1.f5943j.mo52315b();
                String mo52316a = C2023c1.f5943j.mo52316a(C2023c1.m53149y(this.f5960b), "", "", C2023c1.m53191M());
                if (TextUtils.isEmpty(mo52316a)) {
                    return;
                }
                C2163u2.m52429b();
                String mo52317a = C2023c1.f5943j.mo52317a(this.f5960b, new String(C2163u2.m52427d(C2023c1.f5943j.mo52314b(mo52316a.getBytes(), mo52315b)).f5893a));
                if (TextUtils.isEmpty(mo52317a)) {
                    return;
                }
                C2023c1.f5935b = mo52317a;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.s.c1$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C2025b extends AbstractRunnableC2229z3 {

        /* renamed from: b */
        final /* synthetic */ Context f5961b;

        C2025b(Context context) {
            this.f5961b = context;
        }

        @Override // com.amap.api.col.p047s.AbstractRunnableC2229z3
        /* renamed from: a */
        public final void mo52171a() {
            C2023c1.m53178Z(this.f5961b);
            C2023c1.m53183U();
        }
    }

    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.s.c1$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC2026c {
        /* renamed from: a */
        String mo52318a();

        /* renamed from: a */
        String mo52317a(Context context, String str);

        /* renamed from: a */
        String mo52316a(String str, String str2, String str3, String str4);

        /* renamed from: b */
        AbstractC2044dz mo52314b(byte[] bArr, Map<String, String> map);

        /* renamed from: b */
        Map<String, String> mo52315b();
    }

    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.s.c1$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C2027d {

        /* renamed from: a */
        private static Context f5962a;

        /* renamed from: b */
        private static BroadcastReceiver f5963b;

        /* renamed from: c */
        private static ConnectivityManager f5964c;

        /* renamed from: d */
        private static NetworkRequest f5965d;

        /* renamed from: e */
        private static ConnectivityManager.NetworkCallback f5966e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DeviceInfo.java */
        /* renamed from: com.amap.api.col.s.c1$d$a */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public final class C2028a extends BroadcastReceiver {
            C2028a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (C2079j1.m52857t("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    C2023c1.m53185S();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DeviceInfo.java */
        /* renamed from: com.amap.api.col.s.c1$d$b */
        /* loaded from: E:\fuckcool\tsn\7241516.dex */
        public final class C2029b extends ConnectivityManager.NetworkCallback {
            C2029b() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
                C2023c1.m53185S();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                C2023c1.m53185S();
            }
        }

        @SuppressLint({"WrongConstant"})
        /* renamed from: a */
        public final void m53147a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || f5963b != null) {
                    return;
                }
                f5963b = new C2028a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(C2079j1.m52857t("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(f5963b, intentFilter);
            } else if (C2023c1.m53157q(context, C2079j1.m52857t("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f5964c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f5964c = connectivityManager;
                if (connectivityManager != null) {
                    f5965d = new NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    C2029b c2029b = new C2029b();
                    f5966e = c2029b;
                    f5964c.registerNetworkCallback(f5965d, c2029b);
                    f5962a = context;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.s.c1$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ServiceConnectionC2030e implements ServiceConnection {
        ServiceConnectionC2030e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = C2023c1.f5948o = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: A */
    public static String m53203A(Context context) {
        TelephonyManager m53175b;
        if (f5958y) {
            return f5957x;
        }
        try {
            m53167g(context);
            m53175b = m53175b(context);
        } catch (Throwable unused) {
        }
        if (m53175b == null) {
            return f5957x;
        }
        String networkOperator = m53175b.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            f5957x = networkOperator.substring(3);
            f5958y = true;
            return f5957x;
        }
        f5958y = true;
        return f5957x;
    }

    /* renamed from: B */
    public static int m53202B(Context context) {
        try {
            return m53177a(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: C */
    public static String m53201C() {
        return f5955v;
    }

    /* renamed from: D */
    public static int m53200D(Context context) {
        try {
            return m53172c0(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: E */
    public static String[] m53199E() {
        return new String[]{"", ""};
    }

    /* renamed from: F */
    public static String m53198F() {
        return f5915E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: G */
    public static String m53197G(Context context) {
        String str;
        String str2;
        try {
            str = f5959z;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f5959z;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (i2 > i) {
            str2 = i + "*" + i2;
        } else {
            str2 = i2 + "*" + i;
        }
        f5959z = str2;
        return f5959z;
    }

    /* renamed from: H */
    public static String m53196H() {
        return f5911A;
    }

    /* renamed from: I */
    public static String m53195I(Context context) {
        ConnectivityManager m53170d0;
        NetworkInfo activeNetworkInfo;
        try {
            return (!m53157q(context, C2079j1.m52857t("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (m53170d0 = m53170d0(context)) == null || (activeNetworkInfo = m53170d0.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: J */
    public static String m53194J() {
        return "";
    }

    /* renamed from: K */
    public static String m53193K(Context context) {
        String str;
        try {
            String m53196H = m53196H();
            try {
                if (TextUtils.isEmpty(m53196H)) {
                    m53196H = m53164j(context);
                }
                if (TextUtils.isEmpty(m53196H)) {
                    m53196H = m53149y(context);
                }
                if (TextUtils.isEmpty(m53196H)) {
                    m53196H = m53151w(context);
                }
                if (TextUtils.isEmpty(m53196H)) {
                    m53196H = m53148z();
                }
                return TextUtils.isEmpty(m53196H) ? m53176a0(context) : m53196H;
            } catch (Throwable unused) {
                return str;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* renamed from: L */
    public static int m53192L(Context context) {
        int i = f5922L;
        if (i != 0) {
            return i;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        int i2 = ((int) (memoryInfo.totalMem / 1024)) / 1024;
        f5922L = i2;
        return i2;
    }

    /* renamed from: M */
    public static String m53191M() {
        return "";
    }

    /* renamed from: N */
    public static long m53190N() {
        long blockCount;
        long blockCount2;
        long j = f5921K;
        if (j != 0) {
            return j;
        }
        try {
            StatFs statFs = new StatFs(Environment.getRootDirectory().getAbsolutePath());
            StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockCount = (statFs.getBlockCountLong() * statFs.getBlockSizeLong()) / 1048576;
                blockCount2 = (statFs2.getBlockCountLong() * statFs2.getBlockSizeLong()) / 1048576;
            } else {
                blockCount = (statFs.getBlockCount() * statFs.getBlockSize()) / 1048576;
                blockCount2 = (statFs2.getBlockCount() * statFs2.getBlockSize()) / 1048576;
            }
            f5921K = blockCount + blockCount2;
        } catch (Throwable unused) {
        }
        return f5921K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: O */
    public static String m53189O(Context context) {
        try {
            return m53174b0(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: P */
    public static String m53188P() {
        if (!TextUtils.isEmpty(f5923M)) {
            return f5923M;
        }
        String property = System.getProperty("os.arch");
        f5923M = property;
        return property;
    }

    /* renamed from: Q */
    public static String m53187Q(Context context) {
        try {
            if (TextUtils.isEmpty(f5942i)) {
                f5942i = C2120q1.m52653a(context);
            }
        } catch (Throwable unused) {
        }
        return f5942i;
    }

    /* renamed from: S */
    public static void m53185S() {
        f5929S = -1;
        f5930T = false;
        f5931U = -1;
        f5932V = false;
        f5927Q = "";
        f5928R = false;
        f5957x = "";
        f5958y = false;
    }

    /* renamed from: T */
    private static String m53184T(Context context) {
        try {
            String m52836o = C2080j2.m52836o(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(m52836o) ? C2080j2.m52836o(context, "Alvin2", "UTDID", "") : m52836o;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: U */
    static /* synthetic */ boolean m53183U() {
        f5949p = true;
        return true;
    }

    /* renamed from: V */
    private static String m53182V(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (C2079j1.m52865l(context, C7282g.f24951i) && "mounted".equals(Environment.getExternalStorageState())) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath + "/.UTSystemConfig/Global/Alvin2.xml");
                XmlPullParser newPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    newPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z = false;
                    for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                z = false;
                            } else if (eventType == 4 && z) {
                                String text = newPullParser.getText();
                                try {
                                    fileInputStream2.close();
                                } catch (Throwable unused) {
                                }
                                return text;
                            }
                        } else if (newPullParser.getAttributeCount() > 0) {
                            int attributeCount = newPullParser.getAttributeCount();
                            for (int i = 0; i < attributeCount; i++) {
                                String attributeValue = newPullParser.getAttributeValue(i);
                                if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                                    z = true;
                                }
                            }
                        }
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable unused2) {
                    fileInputStream = fileInputStream2;
                    if (fileInputStream == null) {
                        return "";
                    }
                    fileInputStream.close();
                }
            }
            if (fileInputStream == null) {
                return "";
            }
        } catch (Throwable unused3) {
        }
        try {
            fileInputStream.close();
        } catch (Throwable unused4) {
            return "";
        }
    }

    /* renamed from: W */
    private static String m53181W(Context context) {
        try {
            if (!TextUtils.isEmpty(f5947n)) {
                return f5947n;
            }
            byte[] digest = MessageDigest.getInstance(C2079j1.m52857t("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString((b & UByte.f41242c) | 256).substring(1, 3));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!TextUtils.isEmpty(stringBuffer2)) {
                f5947n = stringBuffer2;
            }
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: X */
    private static String m53180X(Context context) {
        try {
            Class<?> cls = Class.forName(C2079j1.m52857t("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(C2079j1.m52857t("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str = (String) invoke;
                f5945l = str;
                return str;
            }
        } catch (Throwable th) {
            C2041d2.m53085e(th, "oa", "xm");
            f5946m = true;
        }
        return f5945l;
    }

    /* renamed from: Y */
    private static String m53179Y(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(C2079j1.m52857t("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i = 0;
                    while (true) {
                        if (i >= columnCount) {
                            break;
                        } else if (C2079j1.m52857t("IdmFsdWU").equals(query.getColumnName(i))) {
                            f5945l = query.getString(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            f5946m = true;
            C2041d2.m53085e(th, "oa", "vivo");
        }
        return f5945l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Z */
    public static String m53178Z(Context context) {
        String m52857t = C2079j1.m52857t("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!m52857t.equalsIgnoreCase(str)) {
            String m52857t2 = C2079j1.m52857t("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!m52857t2.equalsIgnoreCase(str2) && !C2079j1.m52857t("IUkVETUk=").equalsIgnoreCase(str) && !C2079j1.m52857t("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (!C2079j1.m52857t("Idml2bw").equalsIgnoreCase(str) && !C2079j1.m52857t("Idml2bw").equalsIgnoreCase(str2)) {
                    if (!C2079j1.m52857t("IaHVhd2Vp").equalsIgnoreCase(str) && !C2079j1.m52857t("IaHVhd2Vp").equalsIgnoreCase(str2) && !C2079j1.m52857t("ISE9OT1I=").equalsIgnoreCase(str)) {
                        if (!C2079j1.m52857t("Mc2Ftc3VuZw").equalsIgnoreCase(str) && !C2079j1.m52857t("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                            if (!C2079j1.m52857t("IT1BQTw").equalsIgnoreCase(str) && !C2079j1.m52857t("IT1BQTw").equalsIgnoreCase(str2) && !C2079j1.m52857t("MT25lUGx1cw").equalsIgnoreCase(str) && !C2079j1.m52857t("MT25lUGx1cw").equalsIgnoreCase(str2) && !C2079j1.m52857t("IUkVBTE1F").equalsIgnoreCase(str2)) {
                                f5946m = true;
                                return f5945l;
                            }
                            return m53163k(context, 5);
                        }
                        return m53163k(context, 4);
                    }
                    return m53163k(context, 2);
                }
                return m53179Y(context);
            }
        }
        return m53180X(context);
    }

    /* renamed from: a */
    private static int m53177a(Context context) {
        if (f5932V) {
            return f5931U;
        }
        m53167g(context);
        if (!m53157q(context, C2079j1.m52857t("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return f5931U;
        }
        TelephonyManager m53175b = m53175b(context);
        if (m53175b == null) {
            return f5931U;
        }
        int networkType = m53175b.getNetworkType();
        f5931U = networkType;
        f5932V = true;
        return networkType;
    }

    /* renamed from: a0 */
    private static String m53176a0(Context context) {
        if (!TextUtils.isEmpty(f5918H)) {
            return f5918H;
        }
        try {
            String m52836o = C2080j2.m52836o(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(m52836o)) {
                f5918H = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor m52848c = C2080j2.m52848c(context, "open_common");
                C2080j2.m52841j(m52848c, "a1", C2079j1.m52860q(f5918H));
                C2080j2.m52845f(m52848c);
            } else {
                f5918H = C2079j1.m52857t(m52836o);
            }
            return f5918H;
        } catch (Throwable unused) {
            return f5918H;
        }
    }

    /* renamed from: b */
    private static TelephonyManager m53175b(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    /* renamed from: b0 */
    private static String m53174b0(Context context) {
        if (f5928R) {
            return f5927Q;
        }
        m53167g(context);
        if (!m53157q(context, C2079j1.m52857t("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return f5927Q;
        }
        TelephonyManager m53175b = m53175b(context);
        if (m53175b == null) {
            return f5927Q;
        }
        String simOperatorName = m53175b.getSimOperatorName();
        f5927Q = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            f5927Q = m53175b.getNetworkOperatorName();
        }
        f5928R = true;
        return f5927Q;
    }

    /* renamed from: c */
    private static String m53173c(Context context) {
        if (f5936c) {
            String str = null;
            try {
                str = m53171d(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
                f5936c = false;
                return "";
            }
            try {
                byte[] bytes = C2079j1.m52857t("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
                return new String(C2040d1.m53092e(C2079j1.m52857t("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), C2040d1.m53090g(str), bytes), "UTF-8");
            } catch (Throwable unused2) {
                f5936c = false;
                return "";
            }
        }
        return "";
    }

    /* renamed from: c0 */
    private static int m53172c0(Context context) {
        if (f5930T) {
            return f5929S;
        }
        m53167g(context);
        if (context != null && m53157q(context, C2079j1.m52857t("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            ConnectivityManager m53170d0 = m53170d0(context);
            if (m53170d0 == null) {
                return f5929S;
            }
            NetworkInfo activeNetworkInfo = m53170d0.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                f5930T = true;
                return f5929S;
            }
            int type = activeNetworkInfo.getType();
            f5929S = type;
            f5930T = true;
            return type;
        }
        return f5929S;
    }

    /* renamed from: d */
    private static String m53171d(Context context) {
        String str;
        try {
            str = m53169e(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(C2079j1.m52857t("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(C2059g1.m52992a(C2079j1.m52857t("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    /* renamed from: d0 */
    private static ConnectivityManager m53170d0(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    /* renamed from: e */
    private static String m53169e(Context context) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String[] split;
        if (Build.VERSION.SDK_INT < 19 || m53157q(context, C2079j1.m52857t("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            String m52992a = C2059g1.m52992a(C2079j1.m52857t("LYW1hcF9kZXZpY2VfYWRpdQ"));
            String m53168f = m53168f(context);
            if (TextUtils.isEmpty(m53168f)) {
                return "";
            }
            File file = new File(m53168f + File.separator + C2079j1.m52857t("KYmFja3Vwcw"), C2079j1.m52857t("MLmFkaXU"));
            if (file.exists() && file.canRead()) {
                if (file.length() == 0) {
                    file.delete();
                    return "";
                }
                ByteArrayOutputStream byteArrayOutputStream2 = null;
                try {
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        byte[] bArr = new byte[1024];
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            try {
                                int read = randomAccessFile.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                byteArrayOutputStream.write(bArr, 0, read);
                            } catch (Throwable unused) {
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                m53161m(byteArrayOutputStream2);
                                m53161m(randomAccessFile);
                                return "";
                            }
                        }
                        str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    randomAccessFile = null;
                }
                if (!TextUtils.isEmpty(str) && str.contains(C2079j1.m52857t("SIw")) && (split = str.split(C2079j1.m52857t("SIw"))) != null && split.length == 2 && TextUtils.equals(m52992a, split[0])) {
                    String str2 = split[1];
                    m53161m(byteArrayOutputStream);
                    m53161m(randomAccessFile);
                    return str2;
                }
                m53161m(byteArrayOutputStream);
                m53161m(randomAccessFile);
            }
            return "";
        }
        return "";
    }

    /* renamed from: f */
    private static String m53168f(Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(C2079j1.m52857t("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(C2079j1.m52857t("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(C2079j1.m52857t("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(C2079j1.m52857t("DaXNSZW1vdmFibGU"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i = 0; i < length; i++) {
                Object obj = Array.get(invoke, i);
                String str = (String) method2.invoke(obj, new Object[0]);
                if (!((Boolean) method3.invoke(obj, new Object[0])).booleanValue()) {
                    return str;
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: g */
    private static synchronized C2027d m53167g(Context context) {
        synchronized (C2023c1.class) {
            if (f5933W == null) {
                if (context == null) {
                    return null;
                }
                C2027d c2027d = new C2027d();
                f5933W = c2027d;
                c2027d.m53147a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            return f5933W;
        }
    }

    /* renamed from: i */
    public static String m53165i() {
        return f5940g;
    }

    /* renamed from: j */
    public static String m53164j(Context context) {
        if (TextUtils.isEmpty(f5935b)) {
            if (context == null) {
                return "";
            }
            String m53173c = m53173c(context);
            f5935b = m53173c;
            if (!TextUtils.isEmpty(m53173c)) {
                return f5935b;
            }
            if (m53155s() == null || f5944k) {
                return "";
            }
            f5944k = true;
            C2225y3.m52184e().m53246c(new C2024a(context));
            return "";
        }
        return f5935b;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #2 {all -> 0x00f0, blocks: (B:3:0x0001, B:7:0x000f, B:9:0x0014, B:12:0x004f, B:17:0x0060, B:19:0x0068, B:21:0x006e, B:32:0x00c3, B:33:0x00c6, B:41:0x00e0, B:42:0x00e7, B:43:0x00ed, B:10:0x002d, B:11:0x003d, B:31:0x00b5, B:26:0x007e, B:27:0x009f, B:28:0x00a9), top: B:48:0x0001 }] */
    /* renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m53163k(android.content.Context r12, int r13) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p047s.C2023c1.m53163k(android.content.Context, int):java.lang.String");
    }

    /* renamed from: l */
    public static void m53162l(InterfaceC2026c interfaceC2026c) {
        if (f5943j == null) {
            f5943j = interfaceC2026c;
        }
    }

    /* renamed from: m */
    private static void m53161m(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: o */
    public static String m53159o() {
        try {
            if (!TextUtils.isEmpty(f5938e)) {
                return f5938e;
            }
            InterfaceC2026c interfaceC2026c = f5943j;
            return interfaceC2026c == null ? "" : interfaceC2026c.mo52318a();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: p */
    public static String m53158p(Context context) {
        try {
            return m53174b0(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public static boolean m53157q(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: r */
    public static int m53156r(Context context) {
        try {
            return m53177a(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: s */
    public static InterfaceC2026c m53155s() {
        return f5943j;
    }

    /* renamed from: t */
    public static int m53154t(Context context) {
        try {
            return m53172c0(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: u */
    public static String m53153u() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String m53191M = m53191M();
            return m53191M.length() < 5 ? "" : m53191M.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: v */
    public static String m53152v() {
        return "";
    }

    /* renamed from: w */
    public static String m53151w(Context context) {
        if (f5946m) {
            return "";
        }
        if (!TextUtils.isEmpty(f5945l)) {
            return f5945l;
        }
        if (f5949p) {
            return f5945l;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            C2225y3.m52184e().m53246c(new C2025b(context));
            return f5945l;
        }
        f5949p = true;
        return m53178Z(context);
    }

    /* renamed from: x */
    public static String m53150x() {
        return "";
    }

    /* renamed from: y */
    public static String m53149y(Context context) {
        String str;
        if (f5950q) {
            String str2 = f5934a;
            return str2 == null ? "" : str2;
        }
        try {
            str = f5934a;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f5934a;
        }
        if (m53157q(context, C2079j1.m52857t("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f5934a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(f5934a)) {
            f5950q = true;
            return f5934a;
        }
        try {
            String m53184T = m53184T(context);
            f5934a = m53184T;
            if (!TextUtils.isEmpty(m53184T)) {
                f5950q = true;
                return f5934a;
            }
        } catch (Throwable unused2) {
        }
        try {
            f5934a = m53182V(context);
            f5950q = true;
        } catch (Throwable unused3) {
        }
        String str3 = f5934a;
        return str3 == null ? "" : str3;
    }

    /* renamed from: z */
    public static String m53148z() {
        return "";
    }
}
