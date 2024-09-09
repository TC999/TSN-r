package com.amap.api.col.p0003l;

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
import com.stub.StubApp;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: DeviceInfo.java */
/* renamed from: com.amap.api.col.3l.i4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class i4 {
    private static String A = "";
    private static String B = "";
    private static String C = "";
    private static boolean D = false;
    static int E = -1;
    static String F = "";
    private static boolean G = false;
    static String H = "";
    private static String I = "";
    private static boolean J = false;
    private static boolean K = false;

    /* renamed from: L  reason: collision with root package name */
    private static long f8089L = 0;
    private static int M = 0;
    private static String N = null;
    private static String O = "";
    private static boolean P = true;
    private static boolean Q = false;
    private static String R = "";
    private static boolean S = false;
    private static int T = -1;
    private static boolean U = false;
    private static int V = -1;
    private static boolean W = false;
    private static volatile d X = null;

    /* renamed from: a  reason: collision with root package name */
    static String f8090a = "";

    /* renamed from: b  reason: collision with root package name */
    static String f8091b = "";

    /* renamed from: c  reason: collision with root package name */
    static volatile boolean f8092c = true;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f8093d = false;

    /* renamed from: e  reason: collision with root package name */
    static String f8094e = "";

    /* renamed from: f  reason: collision with root package name */
    static boolean f8095f = false;

    /* renamed from: g  reason: collision with root package name */
    private static String f8096g = null;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f8097h = false;

    /* renamed from: i  reason: collision with root package name */
    private static String f8098i = "";

    /* renamed from: j  reason: collision with root package name */
    public static c f8099j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f8100k = false;

    /* renamed from: l  reason: collision with root package name */
    private static String f8101l = "";

    /* renamed from: m  reason: collision with root package name */
    private static boolean f8102m = false;

    /* renamed from: n  reason: collision with root package name */
    private static boolean f8103n = true;

    /* renamed from: o  reason: collision with root package name */
    private static String f8104o = null;

    /* renamed from: p  reason: collision with root package name */
    private static IBinder f8105p = null;

    /* renamed from: q  reason: collision with root package name */
    private static boolean f8106q = false;

    /* renamed from: r  reason: collision with root package name */
    private static boolean f8107r = false;

    /* renamed from: s  reason: collision with root package name */
    private static String f8108s = "";

    /* renamed from: t  reason: collision with root package name */
    private static String f8109t = "";

    /* renamed from: u  reason: collision with root package name */
    private static boolean f8110u = false;

    /* renamed from: v  reason: collision with root package name */
    private static boolean f8111v = false;

    /* renamed from: w  reason: collision with root package name */
    private static String f8112w = "";

    /* renamed from: x  reason: collision with root package name */
    private static boolean f8113x = false;

    /* renamed from: y  reason: collision with root package name */
    private static String f8114y = "";

    /* renamed from: z  reason: collision with root package name */
    private static boolean f8115z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.i4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8116a;

        a(Context context) {
            this.f8116a = context;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            try {
                Map<String, String> b4 = i4.f8099j.b();
                String a4 = i4.f8099j.a(i4.F(this.f8116a), "", "", i4.U());
                if (TextUtils.isEmpty(a4)) {
                    return;
                }
                q6.b();
                String a5 = i4.f8099j.a(this.f8116a, new String(q6.d(i4.f8099j.b(a4.getBytes(), b4)).f9524a));
                if (TextUtils.isEmpty(a5)) {
                    return;
                }
                i4.f8091b = a5;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.i4$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f8117a;

        b(Context context) {
            this.f8117a = context;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            i4.a(this.f8117a);
            i4.d0();
        }
    }

    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.i4$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface c {
        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        Cif b(byte[] bArr, Map<String, String> map);

        Map<String, String> b();
    }

    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.i4$d */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private static Context f8118a;

        /* renamed from: b  reason: collision with root package name */
        private static BroadcastReceiver f8119b;

        /* renamed from: c  reason: collision with root package name */
        private static ConnectivityManager f8120c;

        /* renamed from: d  reason: collision with root package name */
        private static NetworkRequest f8121d;

        /* renamed from: e  reason: collision with root package name */
        private static ConnectivityManager.NetworkCallback f8122e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DeviceInfo.java */
        /* renamed from: com.amap.api.col.3l.i4$d$a */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public final class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (q4.u("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    i4.b0();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DeviceInfo.java */
        /* renamed from: com.amap.api.col.3l.i4$d$b */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public final class b extends ConnectivityManager.NetworkCallback {
            b() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
                i4.b0();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                i4.b0();
            }
        }

        @SuppressLint({"WrongConstant"})
        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || f8119b != null) {
                    return;
                }
                f8119b = new a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(q4.u("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(f8119b, intentFilter);
            } else if (i4.x(context, q4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f8120c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f8120c = connectivityManager;
                if (connectivityManager != null) {
                    f8121d = new NetworkRequest.Builder().addCapability(12).addTransportType(1).addTransportType(0).build();
                    b bVar = new b();
                    f8122e = bVar;
                    f8120c.registerNetworkCallback(f8121d, bVar);
                    f8118a = context;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeviceInfo.java */
    /* renamed from: com.amap.api.col.3l.i4$e */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = i4.f8105p = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    public static int A(Context context) {
        try {
            return d(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String B() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String U2 = U();
            return U2.length() < 5 ? "" : U2.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String C() {
        return "";
    }

    public static String D(Context context) {
        if (f8103n && !f8102m) {
            if (!TextUtils.isEmpty(f8101l)) {
                return f8101l;
            }
            if (f8106q) {
                return f8101l;
            }
            if (Looper.getMainLooper() == Looper.myLooper()) {
                z7.h().b(new b(context));
                return f8101l;
            }
            f8106q = true;
            return a(context);
        }
        return "";
    }

    public static String E() {
        return "";
    }

    public static String F(Context context) {
        String str;
        if (f8107r) {
            String str2 = f8090a;
            return str2 == null ? "" : str2;
        }
        try {
            str = f8090a;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f8090a;
        }
        if (x(context, q4.u("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f8090a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(f8090a)) {
            f8107r = true;
            return f8090a;
        }
        try {
            String h02 = h0(context);
            f8090a = h02;
            if (!TextUtils.isEmpty(h02)) {
                f8107r = true;
                return f8090a;
            }
        } catch (Throwable unused2) {
        }
        try {
            f8090a = i0(context);
            f8107r = true;
        } catch (Throwable unused3) {
        }
        String str3 = f8090a;
        return str3 == null ? "" : str3;
    }

    public static String G() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String H(Context context) {
        try {
            TelephonyManager g4 = g(context);
            if (g4 == null) {
                return "";
            }
            String networkOperator = g4.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
                return networkOperator.substring(0, 3);
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String I() {
        return f8112w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String J(Context context) {
        TelephonyManager g4;
        if (f8115z) {
            return f8114y;
        }
        try {
            l(context);
            g4 = g(context);
        } catch (Throwable unused) {
        }
        if (g4 == null) {
            return f8114y;
        }
        String networkOperator = g4.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            f8114y = networkOperator.substring(3);
            f8115z = true;
            return f8114y;
        }
        f8115z = true;
        return f8114y;
    }

    public static int K(Context context) {
        try {
            return f(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] L() {
        return new String[]{"", ""};
    }

    public static int M(Context context) {
        try {
            return d(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String N() {
        return F;
    }

    public static NetworkInfo O(Context context) {
        ConnectivityManager e4;
        if (x(context, q4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && (e4 = e(context)) != null) {
            return e4.getActiveNetworkInfo();
        }
        return null;
    }

    public static String P() {
        return B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String Q(Context context) {
        try {
            NetworkInfo O2 = O(context);
            if (O2 == null) {
                return null;
            }
            return O2.getExtraInfo();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void R() {
        try {
            p5.a();
        } catch (Throwable unused) {
        }
    }

    public static String S() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String T(Context context) {
        String str;
        String str2;
        try {
            str = A;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return A;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return "";
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        if (i5 > i4) {
            str2 = i4 + "*" + i5;
        } else {
            str2 = i5 + "*" + i4;
        }
        A = str2;
        return A;
    }

    public static String U() {
        return "";
    }

    public static String V(Context context) {
        try {
            if (!x(context, q4.u("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
                return O;
            }
            TelephonyManager g4 = g(context);
            return g4 == null ? "" : g4.getNetworkOperatorName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long W() {
        long blockCount;
        long blockCount2;
        long j4 = f8089L;
        if (j4 != 0) {
            return j4;
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
            f8089L = blockCount + blockCount2;
        } catch (Throwable unused) {
        }
        return f8089L;
    }

    public static String X(Context context) {
        ConnectivityManager e4;
        NetworkInfo activeNetworkInfo;
        try {
            return (!x(context, q4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (e4 = e(context)) == null || (activeNetworkInfo = e4.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String Y() {
        if (!TextUtils.isEmpty(N)) {
            return N;
        }
        String property = System.getProperty("os.arch");
        N = property;
        return property;
    }

    public static String Z(Context context) {
        String str;
        try {
            String P2 = P();
            try {
                if (TextUtils.isEmpty(P2)) {
                    P2 = o(context);
                }
                if (TextUtils.isEmpty(P2)) {
                    P2 = F(context);
                }
                if (TextUtils.isEmpty(P2)) {
                    P2 = D(context);
                }
                if (TextUtils.isEmpty(P2)) {
                    P2 = G();
                }
                return TextUtils.isEmpty(P2) ? b(context) : P2;
            } catch (Throwable unused) {
                return str;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String a(Context context) {
        String u3 = q4.u("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!u3.equalsIgnoreCase(str)) {
            String u4 = q4.u("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!u4.equalsIgnoreCase(str2) && !q4.u("IUkVETUk=").equalsIgnoreCase(str) && !q4.u("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (!q4.u("Idml2bw").equalsIgnoreCase(str) && !q4.u("Idml2bw").equalsIgnoreCase(str2)) {
                    if (!q4.u("IaHVhd2Vp").equalsIgnoreCase(str) && !q4.u("IaHVhd2Vp").equalsIgnoreCase(str2) && !q4.u("ISE9OT1I=").equalsIgnoreCase(str)) {
                        if (!q4.u("Mc2Ftc3VuZw").equalsIgnoreCase(str) && !q4.u("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                            if (!q4.u("IT1BQTw").equalsIgnoreCase(str) && !q4.u("IT1BQTw").equalsIgnoreCase(str2) && !q4.u("MT25lUGx1cw").equalsIgnoreCase(str) && !q4.u("MT25lUGx1cw").equalsIgnoreCase(str2) && !q4.u("IUkVBTE1F").equalsIgnoreCase(str2)) {
                                f8102m = true;
                                return f8101l;
                            }
                            return p(context, 5);
                        }
                        return p(context, 4);
                    }
                    return p(context, 2);
                }
                return l0(context);
            }
        }
        return k0(context);
    }

    public static String a0(Context context) {
        return P() + "#" + o(context) + "#" + Z(context);
    }

    private static String b(Context context) {
        if (!TextUtils.isEmpty(I)) {
            return I;
        }
        try {
            String o4 = f6.o(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(o4)) {
                I = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor c4 = f6.c(context, "open_common");
                f6.j(c4, "a1", q4.q(I));
                f6.f(c4);
            } else {
                I = q4.u(o4);
            }
            return I;
        } catch (Throwable unused) {
            return I;
        }
    }

    public static void b0() {
        T = -1;
        U = false;
        V = -1;
        W = false;
        R = "";
        S = false;
        f8114y = "";
        f8115z = false;
    }

    private static String c(Context context) {
        if (S) {
            return R;
        }
        l(context);
        TelephonyManager g4 = g(context);
        if (g4 == null) {
            return R;
        }
        String simOperatorName = g4.getSimOperatorName();
        R = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            R = g4.getNetworkOperatorName();
        }
        S = true;
        return R;
    }

    public static int c0(Context context) {
        int i4 = M;
        if (i4 != 0) {
            return i4;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return 0;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        int i5 = ((int) (memoryInfo.totalMem / 1024)) / 1024;
        M = i5;
        return i5;
    }

    private static int d(Context context) {
        if (U) {
            return T;
        }
        l(context);
        if (context != null && x(context, q4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            ConnectivityManager e4 = e(context);
            if (e4 == null) {
                return T;
            }
            NetworkInfo activeNetworkInfo = e4.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                U = true;
                return T;
            }
            int type = activeNetworkInfo.getType();
            T = type;
            U = true;
            return type;
        }
        return T;
    }

    static /* synthetic */ boolean d0() {
        f8106q = true;
        return true;
    }

    private static ConnectivityManager e(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e0(Context context) {
        try {
            return c(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static int f(Context context) {
        if (W) {
            return V;
        }
        l(context);
        if (!x(context, q4.u("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            return V;
        }
        ConnectivityManager e4 = e(context);
        if (e4 == null) {
            return V;
        }
        NetworkInfo activeNetworkInfo = e4.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
            V = activeNetworkInfo.getSubtype();
            W = true;
        }
        return V;
    }

    public static String f0(Context context) {
        try {
            if (TextUtils.isEmpty(f8098i)) {
                f8098i = y4.a(context);
            }
        } catch (Throwable unused) {
        }
        return f8098i;
    }

    private static TelephonyManager g(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String h(Context context) {
        if (f8092c) {
            String str = null;
            try {
                str = i(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
                f8092c = false;
                return "";
            }
            try {
                byte[] bytes = q4.u("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
                return new String(j4.e(q4.u("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), j4.g(str), bytes), "UTF-8");
            } catch (Throwable unused2) {
                f8092c = false;
                return "";
            }
        }
        return "";
    }

    private static String h0(Context context) {
        try {
            String o4 = f6.o(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(o4) ? f6.o(context, "Alvin2", "UTDID", "") : o4;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String i(Context context) {
        String str;
        try {
            str = j(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(q4.u("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(m4.d(q4.u("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static String i0(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (q4.l(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
                String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
                File file = new File(absolutePath + "/.UTSystemConfig/Global/Alvin2.xml");
                XmlPullParser newPullParser = Xml.newPullParser();
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    newPullParser.setInput(fileInputStream2, "utf-8");
                    boolean z3 = false;
                    for (int eventType = newPullParser.getEventType(); 1 != eventType; eventType = newPullParser.next()) {
                        if (eventType != 2) {
                            if (eventType == 3) {
                                z3 = false;
                            } else if (eventType == 4 && z3) {
                                String text = newPullParser.getText();
                                try {
                                    fileInputStream2.close();
                                } catch (Throwable unused) {
                                }
                                return text;
                            }
                        } else if (newPullParser.getAttributeCount() > 0) {
                            int attributeCount = newPullParser.getAttributeCount();
                            for (int i4 = 0; i4 < attributeCount; i4++) {
                                String attributeValue = newPullParser.getAttributeValue(i4);
                                if ("UTDID2".equals(attributeValue) || "UTDID".equals(attributeValue)) {
                                    z3 = true;
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

    private static String j(Context context) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String[] split;
        if (Build.VERSION.SDK_INT < 19 || x(context, q4.u("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            String d4 = m4.d(q4.u("LYW1hcF9kZXZpY2VfYWRpdQ"));
            String k4 = k(context);
            if (TextUtils.isEmpty(k4)) {
                return "";
            }
            File file = new File(k4 + File.separator + q4.u("KYmFja3Vwcw"), q4.u("MLmFkaXU"));
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
                                r(byteArrayOutputStream2);
                                r(randomAccessFile);
                                return "";
                            }
                        }
                        str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    randomAccessFile = null;
                }
                if (!TextUtils.isEmpty(str) && str.contains(q4.u("SIw")) && (split = str.split(q4.u("SIw"))) != null && split.length == 2 && TextUtils.equals(d4, split[0])) {
                    String str2 = split[1];
                    r(byteArrayOutputStream);
                    r(randomAccessFile);
                    return str2;
                }
                r(byteArrayOutputStream);
                r(randomAccessFile);
            }
            return "";
        }
        return "";
    }

    private static String j0(Context context) {
        try {
            if (!TextUtils.isEmpty(f8104o)) {
                return f8104o;
            }
            byte[] digest = MessageDigest.getInstance(q4.u("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                stringBuffer.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!TextUtils.isEmpty(stringBuffer2)) {
                f8104o = stringBuffer2;
            }
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String k(Context context) {
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

    private static String k0(Context context) {
        try {
            Class<?> cls = Class.forName(q4.u("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(q4.u("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str = (String) invoke;
                f8101l = str;
                return str;
            }
        } catch (Throwable th) {
            q5.e(th, "oa", "xm");
            f8102m = true;
        }
        return f8101l;
    }

    private static synchronized d l(Context context) {
        synchronized (i4.class) {
            if (X == null) {
                if (context == null) {
                    return null;
                }
                d dVar = new d();
                X = dVar;
                dVar.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            return X;
        }
    }

    private static String l0(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(q4.u("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= columnCount) {
                            break;
                        } else if (q4.u("IdmFsdWU").equals(query.getColumnName(i4))) {
                            f8101l = query.getString(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            f8102m = true;
            q5.e(th, "oa", "vivo");
        }
        return f8101l;
    }

    public static String n() {
        return f8096g;
    }

    public static String o(Context context) {
        if (TextUtils.isEmpty(f8091b)) {
            if (context == null) {
                return "";
            }
            String h4 = h(context);
            f8091b = h4;
            if (!TextUtils.isEmpty(h4)) {
                return f8091b;
            }
            if (z() == null || f8100k) {
                return "";
            }
            f8100k = true;
            z7.h().b(new a(context));
            return "";
        }
        return f8091b;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #2 {all -> 0x00f0, blocks: (B:3:0x0001, B:7:0x000f, B:9:0x0014, B:12:0x004f, B:17:0x0060, B:19:0x0068, B:21:0x006e, B:32:0x00c3, B:33:0x00c6, B:41:0x00e0, B:42:0x00e7, B:43:0x00ed, B:10:0x002d, B:11:0x003d, B:31:0x00b5, B:26:0x007e, B:27:0x009f, B:28:0x00a9), top: B:48:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String p(android.content.Context r12, int r13) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.i4.p(android.content.Context, int):java.lang.String");
    }

    public static void q(c cVar) {
        if (f8099j == null) {
            f8099j = cVar;
        }
    }

    private static void r(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void s(String str) {
        f8096g = str;
    }

    public static void t(boolean z3) {
        f8103n = z3;
    }

    public static String v() {
        try {
            if (!TextUtils.isEmpty(f8094e)) {
                return f8094e;
            }
            c cVar = f8099j;
            return cVar == null ? "" : cVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String w(Context context) {
        try {
            return c(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean x(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static int y(Context context) {
        try {
            return f(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static c z() {
        return f8099j;
    }
}
