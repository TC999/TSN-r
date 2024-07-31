package com.amap.api.col.p0463l;

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
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import kotlin.UByte;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: com.amap.api.col.3l.h4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class DeviceInfo {

    /* renamed from: A */
    private static String f4391A = "";

    /* renamed from: B */
    private static String f4392B = "";

    /* renamed from: C */
    private static String f4393C = "";

    /* renamed from: D */
    private static boolean f4394D = false;

    /* renamed from: E */
    static int f4395E = -1;

    /* renamed from: F */
    static String f4396F = "";

    /* renamed from: G */
    private static boolean f4397G = false;

    /* renamed from: H */
    static String f4398H = "";

    /* renamed from: I */
    private static String f4399I = "";

    /* renamed from: J */
    private static boolean f4400J = false;

    /* renamed from: K */
    private static boolean f4401K = false;

    /* renamed from: L */
    private static long f4402L = 0;

    /* renamed from: M */
    private static int f4403M = 0;

    /* renamed from: N */
    private static String f4404N = null;

    /* renamed from: O */
    private static String f4405O = "";

    /* renamed from: P */
    private static boolean f4406P = true;

    /* renamed from: Q */
    private static boolean f4407Q = false;

    /* renamed from: R */
    private static String f4408R = "";

    /* renamed from: S */
    private static boolean f4409S = false;

    /* renamed from: T */
    private static int f4410T = -1;

    /* renamed from: U */
    private static boolean f4411U = false;

    /* renamed from: V */
    private static int f4412V = -1;

    /* renamed from: W */
    private static boolean f4413W = false;

    /* renamed from: X */
    private static volatile C1832d f4414X = null;

    /* renamed from: a */
    static String f4415a = "";

    /* renamed from: b */
    static String f4416b = "";

    /* renamed from: c */
    static volatile boolean f4417c = true;

    /* renamed from: d */
    public static boolean f4418d = false;

    /* renamed from: e */
    static String f4419e = "";

    /* renamed from: f */
    static boolean f4420f = false;

    /* renamed from: g */
    private static String f4421g = null;

    /* renamed from: h */
    private static boolean f4422h = false;

    /* renamed from: i */
    private static String f4423i = "";

    /* renamed from: j */
    public static InterfaceC1831c f4424j = null;

    /* renamed from: k */
    private static volatile boolean f4425k = false;

    /* renamed from: l */
    private static String f4426l = "";

    /* renamed from: m */
    private static boolean f4427m = false;

    /* renamed from: n */
    private static boolean f4428n = true;

    /* renamed from: o */
    private static String f4429o = null;

    /* renamed from: p */
    private static IBinder f4430p = null;

    /* renamed from: q */
    private static boolean f4431q = false;

    /* renamed from: r */
    private static boolean f4432r = false;

    /* renamed from: s */
    private static String f4433s = "";

    /* renamed from: t */
    private static String f4434t = "";

    /* renamed from: u */
    private static boolean f4435u = false;

    /* renamed from: v */
    private static boolean f4436v = false;

    /* renamed from: w */
    private static String f4437w = "";

    /* renamed from: x */
    private static boolean f4438x = false;

    /* renamed from: y */
    private static String f4439y = "";

    /* renamed from: z */
    private static boolean f4440z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.h4$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1829a extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ Context f4441a;

        C1829a(Context context) {
            this.f4441a = context;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            try {
                Map<String, String> mo54652b = DeviceInfo.f4424j.mo54652b();
                String mo54653a = DeviceInfo.f4424j.mo54653a(DeviceInfo.m54816F(this.f4441a), "", "", DeviceInfo.m54801U());
                if (TextUtils.isEmpty(mo54653a)) {
                    return;
                }
                BaseNetManager.m54175b();
                String mo54654a = DeviceInfo.f4424j.mo54654a(this.f4441a, new String(BaseNetManager.m54173d(DeviceInfo.f4424j.mo54651b(mo54653a.getBytes(), mo54652b)).f5682a));
                if (TextUtils.isEmpty(mo54654a)) {
                    return;
                }
                DeviceInfo.f4416b = mo54654a;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.h4$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public final class C1830b extends ThreadTask {

        /* renamed from: a */
        final /* synthetic */ Context f4442a;

        C1830b(Context context) {
            this.f4442a = context;
        }

        @Override // com.amap.api.col.p0463l.ThreadTask
        public final void runTask() {
            DeviceInfo.m54795a(this.f4442a);
            DeviceInfo.m54788d0();
        }
    }

    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.h4$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public interface InterfaceC1831c {
        /* renamed from: a */
        String mo54655a();

        /* renamed from: a */
        String mo54654a(Context context, String str);

        /* renamed from: a */
        String mo54653a(String str, String str2, String str3, String str4);

        /* renamed from: b */
        AbstractC1840if mo54651b(byte[] bArr, Map<String, String> map);

        /* renamed from: b */
        Map<String, String> mo54652b();
    }

    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.h4$d */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class C1832d {

        /* renamed from: a */
        private static Context f4443a;

        /* renamed from: b */
        private static BroadcastReceiver f4444b;

        /* renamed from: c */
        private static ConnectivityManager f4445c;

        /* renamed from: d */
        private static NetworkRequest f4446d;

        /* renamed from: e */
        private static ConnectivityManager.NetworkCallback f4447e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DeviceInfo.java */
        /* renamed from: com.amap.api.col.3l.h4$d$a */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public final class C1833a extends BroadcastReceiver {
            C1833a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (C1925p4.m54183u("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    DeviceInfo.m54792b0();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DeviceInfo.java */
        /* renamed from: com.amap.api.col.3l.h4$d$b */
        /* loaded from: E:\fuckcool\tsn\6276784.dex */
        public final class C1834b extends ConnectivityManager.NetworkCallback {
            C1834b() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
                DeviceInfo.m54792b0();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                DeviceInfo.m54792b0();
            }
        }

        @SuppressLint({"WrongConstant"})
        /* renamed from: a */
        public final void m54757a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || f4444b != null) {
                    return;
                }
                f4444b = new C1833a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(C1925p4.m54183u("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(f4444b, intentFilter);
            } else if (DeviceInfo.m54760x(context, C1925p4.m54183u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f4445c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f4445c = connectivityManager;
                if (connectivityManager != null) {
                    f4446d = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
                    C1834b c1834b = new C1834b();
                    f4447e = c1834b;
                    f4445c.registerNetworkCallback(f4446d, c1834b);
                    f4443a = context;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.h4$e */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    public static class ServiceConnectionC1835e implements ServiceConnection {
        ServiceConnectionC1835e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = DeviceInfo.f4430p = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* renamed from: A */
    public static int m54821A(Context context) {
        try {
            return m54789d(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: B */
    public static String m54820B() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String m54801U = m54801U();
            return m54801U.length() < 5 ? "" : m54801U.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: C */
    public static String m54819C() {
        return "";
    }

    /* renamed from: D */
    public static String m54818D(Context context) {
        if (f4428n && !f4427m) {
            if (!TextUtils.isEmpty(f4426l)) {
                return f4426l;
            }
            if (f4431q) {
                return f4426l;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                ThreadPool.m53398h().m55654b(new C1830b(context));
                return f4426l;
            }
            f4431q = true;
            return m54795a(context);
        }
        return "";
    }

    /* renamed from: E */
    public static String m54817E() {
        return "";
    }

    /* renamed from: F */
    public static String m54816F(Context context) {
        String str;
        if (f4432r) {
            String str2 = f4415a;
            return str2 == null ? "" : str2;
        }
        try {
            str = f4415a;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f4415a;
        }
        if (m54760x(context, C1925p4.m54183u("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f4415a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(f4415a)) {
            f4432r = true;
            return f4415a;
        }
        try {
            String m54780h0 = m54780h0(context);
            f4415a = m54780h0;
            if (!TextUtils.isEmpty(m54780h0)) {
                f4432r = true;
                return f4415a;
            }
        } catch (Throwable unused2) {
        }
        try {
            f4415a = m54778i0(context);
            f4432r = true;
        } catch (Throwable unused3) {
        }
        String str3 = f4415a;
        return str3 == null ? "" : str3;
    }

    /* renamed from: G */
    public static String m54815G() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: H */
    public static String m54814H(Context context) {
        try {
            TelephonyManager m54783g = m54783g(context);
            if (m54783g == null) {
                return "";
            }
            String networkOperator = m54783g.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                return networkOperator.substring(0, 3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: I */
    public static String m54813I() {
        return f4437w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: J */
    public static String m54812J(Context context) {
        TelephonyManager m54783g;
        if (f4440z) {
            return f4439y;
        }
        try {
            m54773l(context);
            m54783g = m54783g(context);
        } catch (Throwable unused) {
        }
        if (m54783g == null) {
            return f4439y;
        }
        String networkOperator = m54783g.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            f4439y = networkOperator.substring(3);
            f4440z = true;
            return f4439y;
        }
        f4440z = true;
        return f4439y;
    }

    /* renamed from: K */
    public static int m54811K(Context context) {
        try {
            return m54785f(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: L */
    public static String[] m54810L() {
        return new String[]{"", ""};
    }

    /* renamed from: M */
    public static int m54809M(Context context) {
        try {
            return m54789d(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: N */
    public static String m54808N() {
        return f4396F;
    }

    /* renamed from: O */
    public static NetworkInfo m54807O(Context context) {
        ConnectivityManager m54787e;
        if (m54760x(context, C1925p4.m54183u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (m54787e = m54787e(context)) != null) {
            return m54787e.getActiveNetworkInfo();
        }
        return null;
    }

    /* renamed from: P */
    public static String m54806P() {
        return f4392B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Q */
    public static String m54805Q(Context context) {
        try {
            NetworkInfo m54807O = m54807O(context);
            if (m54807O == null) {
                return null;
            }
            return m54807O.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: R */
    public static void m54804R() {
        try {
            RomIdentifier.m54381a();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: S */
    public static String m54803S() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: T */
    public static String m54802T(Context context) {
        String str;
        String str2;
        try {
            str = f4391A;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f4391A;
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
        f4391A = str2;
        return f4391A;
    }

    /* renamed from: U */
    public static String m54801U() {
        return "";
    }

    /* renamed from: V */
    public static String m54800V(Context context) {
        try {
            if (!m54760x(context, C1925p4.m54183u("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return f4405O;
            }
            TelephonyManager m54783g = m54783g(context);
            return m54783g == null ? "" : m54783g.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: W */
    public static long m54799W() {
        long blockCount;
        long blockCount2;
        long j = f4402L;
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
            f4402L = blockCount + blockCount2;
        } catch (Throwable unused) {
        }
        return f4402L;
    }

    /* renamed from: X */
    public static String m54798X(Context context) {
        ConnectivityManager m54787e;
        NetworkInfo activeNetworkInfo;
        try {
            return (!m54760x(context, C1925p4.m54183u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (m54787e = m54787e(context)) == null || (activeNetworkInfo = m54787e.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: Y */
    public static String m54797Y() {
        if (!TextUtils.isEmpty(f4404N)) {
            return f4404N;
        }
        String property = System.getProperty("os.arch");
        f4404N = property;
        return property;
    }

    /* renamed from: Z */
    public static String m54796Z(Context context) {
        String str;
        try {
            String m54806P = m54806P();
            try {
                if (TextUtils.isEmpty(m54806P)) {
                    m54806P = m54769o(context);
                }
                if (TextUtils.isEmpty(m54806P)) {
                    m54806P = m54816F(context);
                }
                if (TextUtils.isEmpty(m54806P)) {
                    m54806P = m54818D(context);
                }
                if (TextUtils.isEmpty(m54806P)) {
                    m54806P = m54815G();
                }
                return TextUtils.isEmpty(m54806P) ? m54793b(context) : m54806P;
            } catch (Throwable unused) {
                return str;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static String m54795a(Context context) {
        String m54183u = C1925p4.m54183u("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!m54183u.equalsIgnoreCase(str)) {
            String m54183u2 = C1925p4.m54183u("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!m54183u2.equalsIgnoreCase(str2) && !C1925p4.m54183u("IUkVETUk=").equalsIgnoreCase(str) && !C1925p4.m54183u("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (!C1925p4.m54183u("Idml2bw").equalsIgnoreCase(str) && !C1925p4.m54183u("Idml2bw").equalsIgnoreCase(str2)) {
                    if (!C1925p4.m54183u("IaHVhd2Vp").equalsIgnoreCase(str) && !C1925p4.m54183u("IaHVhd2Vp").equalsIgnoreCase(str2) && !C1925p4.m54183u("ISE9OT1I=").equalsIgnoreCase(str)) {
                        if (!C1925p4.m54183u("Mc2Ftc3VuZw").equalsIgnoreCase(str) && !C1925p4.m54183u("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                            if (!C1925p4.m54183u("IT1BQTw").equalsIgnoreCase(str) && !C1925p4.m54183u("IT1BQTw").equalsIgnoreCase(str2) && !C1925p4.m54183u("MT25lUGx1cw").equalsIgnoreCase(str) && !C1925p4.m54183u("MT25lUGx1cw").equalsIgnoreCase(str2) && !C1925p4.m54183u("IUkVBTE1F").equalsIgnoreCase(str2)) {
                                f4427m = true;
                                return f4426l;
                            }
                            return m54768p(context, 5);
                        }
                        return m54768p(context, 4);
                    }
                    return m54768p(context, 2);
                }
                return m54772l0(context);
            }
        }
        return m54774k0(context);
    }

    /* renamed from: a0 */
    public static String m54794a0(Context context) {
        return m54806P() + "#" + m54769o(context) + "#" + m54796Z(context);
    }

    /* renamed from: b */
    private static String m54793b(Context context) {
        if (!TextUtils.isEmpty(f4399I)) {
            return f4399I;
        }
        try {
            String m55220o = SPUtil.m55220o(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(m55220o)) {
                f4399I = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor m55232c = SPUtil.m55232c(context, "open_common");
                SPUtil.m55225j(m55232c, "a1", C1925p4.m54187q(f4399I));
                SPUtil.m55229f(m55232c);
            } else {
                f4399I = C1925p4.m54183u(m55220o);
            }
            return f4399I;
        } catch (Throwable unused) {
            return f4399I;
        }
    }

    /* renamed from: b0 */
    public static void m54792b0() {
        f4410T = -1;
        f4411U = false;
        f4412V = -1;
        f4413W = false;
        f4408R = "";
        f4409S = false;
        f4439y = "";
        f4440z = false;
    }

    /* renamed from: c */
    private static String m54791c(Context context) {
        if (f4409S) {
            return f4408R;
        }
        m54773l(context);
        TelephonyManager m54783g = m54783g(context);
        if (m54783g == null) {
            return f4408R;
        }
        String simOperatorName = m54783g.getSimOperatorName();
        f4408R = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            f4408R = m54783g.getNetworkOperatorName();
        }
        f4409S = true;
        return f4408R;
    }

    /* renamed from: c0 */
    public static int m54790c0(Context context) {
        int i = f4403M;
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
        f4403M = i2;
        return i2;
    }

    /* renamed from: d */
    private static int m54789d(Context context) {
        if (f4411U) {
            return f4410T;
        }
        m54773l(context);
        if (context != null && m54760x(context, C1925p4.m54183u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            ConnectivityManager m54787e = m54787e(context);
            if (m54787e == null) {
                return f4410T;
            }
            NetworkInfo activeNetworkInfo = m54787e.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                f4411U = true;
                return f4410T;
            }
            int type = activeNetworkInfo.getType();
            f4410T = type;
            f4411U = true;
            return type;
        }
        return f4410T;
    }

    /* renamed from: d0 */
    static /* synthetic */ boolean m54788d0() {
        f4431q = true;
        return true;
    }

    /* renamed from: e */
    private static ConnectivityManager m54787e(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e0 */
    public static String m54786e0(Context context) {
        try {
            return m54791c(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: f */
    private static int m54785f(Context context) {
        if (f4413W) {
            return f4412V;
        }
        m54773l(context);
        if (!m54760x(context, C1925p4.m54183u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return f4412V;
        }
        ConnectivityManager m54787e = m54787e(context);
        if (m54787e == null) {
            return f4412V;
        }
        NetworkInfo activeNetworkInfo = m54787e.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            f4412V = activeNetworkInfo.getSubtype();
            f4413W = true;
        }
        return f4412V;
    }

    /* renamed from: f0 */
    public static String m54784f0(Context context) {
        try {
            if (TextUtils.isEmpty(f4423i)) {
                f4423i = AdvertisingId.m53532a(context);
            }
        } catch (Throwable unused) {
        }
        return f4423i;
    }

    /* renamed from: g */
    private static TelephonyManager m54783g(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    /* renamed from: h */
    private static String m54781h(Context context) {
        if (f4417c) {
            String str = null;
            try {
                str = m54779i(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
                f4417c = false;
                return "";
            }
            try {
                byte[] bytes = C1925p4.m54183u("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
                return new String(Encrypt.m54720e(C1925p4.m54183u("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), Encrypt.m54718g(str), bytes), "UTF-8");
            } catch (Throwable unused2) {
                f4417c = false;
                return "";
            }
        }
        return "";
    }

    /* renamed from: h0 */
    private static String m54780h0(Context context) {
        try {
            String m55220o = SPUtil.m55220o(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(m55220o) ? SPUtil.m55220o(context, "Alvin2", "UTDID", "") : m55220o;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: i */
    private static String m54779i(Context context) {
        String str;
        try {
            str = m54777j(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(C1925p4.m54183u("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(C1849l4.m54583d(C1925p4.m54183u("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    /* renamed from: i0 */
    private static String m54778i0(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (C1925p4.m54192l(context, C7282g.f24951i) && "mounted".equals(Environment.getExternalStorageState())) {
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

    /* renamed from: j */
    private static String m54777j(Context context) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String[] split;
        if (Build.VERSION.SDK_INT < 19 || m54760x(context, C1925p4.m54183u("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            String m54583d = C1849l4.m54583d(C1925p4.m54183u("LYW1hcF9kZXZpY2VfYWRpdQ"));
            String m54775k = m54775k(context);
            if (TextUtils.isEmpty(m54775k)) {
                return "";
            }
            File file = new File(m54775k + File.separator + C1925p4.m54183u("KYmFja3Vwcw"), C1925p4.m54183u("MLmFkaXU"));
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
                                m54766r(byteArrayOutputStream2);
                                m54766r(randomAccessFile);
                                return "";
                            }
                        }
                        str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    randomAccessFile = null;
                }
                if (!TextUtils.isEmpty(str) && str.contains(C1925p4.m54183u("SIw")) && (split = str.split(C1925p4.m54183u("SIw"))) != null && split.length == 2 && TextUtils.equals(m54583d, split[0])) {
                    String str2 = split[1];
                    m54766r(byteArrayOutputStream);
                    m54766r(randomAccessFile);
                    return str2;
                }
                m54766r(byteArrayOutputStream);
                m54766r(randomAccessFile);
            }
            return "";
        }
        return "";
    }

    /* renamed from: j0 */
    private static String m54776j0(Context context) {
        try {
            if (!TextUtils.isEmpty(f4429o)) {
                return f4429o;
            }
            byte[] digest = MessageDigest.getInstance(C1925p4.m54183u("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString((b & UByte.f41242c) | 256).substring(1, 3));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!TextUtils.isEmpty(stringBuffer2)) {
                f4429o = stringBuffer2;
            }
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: k */
    private static String m54775k(Context context) {
        try {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = context.getCacheDir();
            }
            if (externalCacheDir != null) {
                return externalCacheDir.getAbsolutePath();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: k0 */
    private static String m54774k0(Context context) {
        try {
            Class<?> cls = Class.forName(C1925p4.m54183u("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(C1925p4.m54183u("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str = (String) invoke;
                f4426l = str;
                return str;
            }
        } catch (Throwable th) {
            BasicLogHandler.m54177e(th, "oa", "xm");
            f4427m = true;
        }
        return f4426l;
    }

    /* renamed from: l */
    private static synchronized C1832d m54773l(Context context) {
        synchronized (DeviceInfo.class) {
            if (f4414X == null) {
                if (context == null) {
                    return null;
                }
                C1832d c1832d = new C1832d();
                f4414X = c1832d;
                c1832d.m54757a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            return f4414X;
        }
    }

    /* renamed from: l0 */
    private static String m54772l0(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(C1925p4.m54183u("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i = 0;
                    while (true) {
                        if (i >= columnCount) {
                            break;
                        } else if (C1925p4.m54183u("IdmFsdWU").equals(query.getColumnName(i))) {
                            f4426l = query.getString(i);
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            f4427m = true;
            BasicLogHandler.m54177e(th, "oa", "vivo");
        }
        return f4426l;
    }

    /* renamed from: n */
    public static String m54770n() {
        return f4421g;
    }

    /* renamed from: o */
    public static String m54769o(Context context) {
        if (TextUtils.isEmpty(f4416b)) {
            if (context == null) {
                return "";
            }
            String m54781h = m54781h(context);
            f4416b = m54781h;
            if (!TextUtils.isEmpty(m54781h)) {
                return f4416b;
            }
            if (m54758z() == null || f4425k) {
                return "";
            }
            f4425k = true;
            ThreadPool.m53398h().m55654b(new C1829a(context));
            return "";
        }
        return f4416b;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #2 {all -> 0x00f0, blocks: (B:3:0x0001, B:7:0x000f, B:9:0x0014, B:12:0x004f, B:17:0x0060, B:19:0x0068, B:21:0x006e, B:32:0x00c3, B:33:0x00c6, B:41:0x00e0, B:42:0x00e7, B:43:0x00ed, B:10:0x002d, B:11:0x003d, B:31:0x00b5, B:26:0x007e, B:27:0x009f, B:28:0x00a9), top: B:48:0x0001 }] */
    /* renamed from: p */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String m54768p(android.content.Context r12, int r13) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.DeviceInfo.m54768p(android.content.Context, int):java.lang.String");
    }

    /* renamed from: q */
    public static void m54767q(InterfaceC1831c interfaceC1831c) {
        if (f4424j == null) {
            f4424j = interfaceC1831c;
        }
    }

    /* renamed from: r */
    private static void m54766r(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: s */
    public static void m54765s(String str) {
        f4421g = str;
    }

    /* renamed from: t */
    public static void m54764t(boolean z) {
        f4428n = z;
    }

    /* renamed from: v */
    public static String m54762v() {
        try {
            if (!TextUtils.isEmpty(f4419e)) {
                return f4419e;
            }
            InterfaceC1831c interfaceC1831c = f4424j;
            return interfaceC1831c == null ? "" : interfaceC1831c.mo54655a();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: w */
    public static String m54761w(Context context) {
        try {
            return m54791c(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public static boolean m54760x(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: y */
    public static int m54759y(Context context) {
        try {
            return m54785f(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    /* renamed from: z */
    public static InterfaceC1831c m54758z() {
        return f4424j;
    }
}
