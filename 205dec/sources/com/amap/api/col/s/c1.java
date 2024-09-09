package com.amap.api.col.s;

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
import org.xmlpull.v1.XmlPullParser;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DeviceInfo.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class c1 {
    private static String A = "";
    private static String B = "";
    private static boolean C = false;
    static int D = -1;
    static String E = "";
    private static boolean F = false;
    static String G = "";
    private static String H = "";
    private static boolean I = false;
    private static boolean J = false;
    private static long K = 0;

    /* renamed from: L  reason: collision with root package name */
    private static int f9661L = 0;
    private static String M = null;
    private static String N = "";
    private static boolean O = true;
    private static boolean P = false;
    private static String Q = "";
    private static boolean R = false;
    private static int S = -1;
    private static boolean T = false;
    private static int U = -1;
    private static boolean V = false;
    private static volatile d W = null;

    /* renamed from: a  reason: collision with root package name */
    static String f9662a = "";

    /* renamed from: b  reason: collision with root package name */
    static String f9663b = "";

    /* renamed from: c  reason: collision with root package name */
    static volatile boolean f9664c = true;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f9665d = false;

    /* renamed from: e  reason: collision with root package name */
    static String f9666e = "";

    /* renamed from: f  reason: collision with root package name */
    static boolean f9667f = false;

    /* renamed from: g  reason: collision with root package name */
    private static String f9668g = null;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f9669h = false;

    /* renamed from: i  reason: collision with root package name */
    private static String f9670i = "";

    /* renamed from: j  reason: collision with root package name */
    public static c f9671j = null;

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f9672k = false;

    /* renamed from: l  reason: collision with root package name */
    private static String f9673l = "";

    /* renamed from: m  reason: collision with root package name */
    private static boolean f9674m = false;

    /* renamed from: n  reason: collision with root package name */
    private static String f9675n = null;

    /* renamed from: o  reason: collision with root package name */
    private static IBinder f9676o = null;

    /* renamed from: p  reason: collision with root package name */
    private static boolean f9677p = false;

    /* renamed from: q  reason: collision with root package name */
    private static boolean f9678q = false;

    /* renamed from: r  reason: collision with root package name */
    private static String f9679r = "";

    /* renamed from: s  reason: collision with root package name */
    private static String f9680s = "";

    /* renamed from: t  reason: collision with root package name */
    private static boolean f9681t = false;

    /* renamed from: u  reason: collision with root package name */
    private static boolean f9682u = false;

    /* renamed from: v  reason: collision with root package name */
    private static String f9683v = "";

    /* renamed from: w  reason: collision with root package name */
    private static boolean f9684w = false;

    /* renamed from: x  reason: collision with root package name */
    private static String f9685x = "";

    /* renamed from: y  reason: collision with root package name */
    private static boolean f9686y = false;

    /* renamed from: z  reason: collision with root package name */
    private static String f9687z = "";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DeviceInfo.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends z3 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f9688b;

        a(Context context) {
            this.f9688b = context;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            try {
                Map<String, String> b4 = c1.f9671j.b();
                String a4 = c1.f9671j.a(c1.y(this.f9688b), "", "", c1.M());
                if (TextUtils.isEmpty(a4)) {
                    return;
                }
                u2.b();
                String a5 = c1.f9671j.a(this.f9688b, new String(u2.d(c1.f9671j.b(a4.getBytes(), b4)).f9643a));
                if (TextUtils.isEmpty(a5)) {
                    return;
                }
                c1.f9663b = a5;
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DeviceInfo.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b extends z3 {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f9689b;

        b(Context context) {
            this.f9689b = context;
        }

        @Override // com.amap.api.col.s.z3
        public final void a() {
            c1.Z(this.f9689b);
            c1.U();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DeviceInfo.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface c {
        String a();

        String a(Context context, String str);

        String a(String str, String str2, String str3, String str4);

        dz b(byte[] bArr, Map<String, String> map);

        Map<String, String> b();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DeviceInfo.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private static Context f9690a;

        /* renamed from: b  reason: collision with root package name */
        private static BroadcastReceiver f9691b;

        /* renamed from: c  reason: collision with root package name */
        private static ConnectivityManager f9692c;

        /* renamed from: d  reason: collision with root package name */
        private static NetworkRequest f9693d;

        /* renamed from: e  reason: collision with root package name */
        private static ConnectivityManager.NetworkCallback f9694e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: DeviceInfo.java */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public final class a extends BroadcastReceiver {
            a() {
            }

            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                if (j1.t("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF").equals(intent.getAction())) {
                    c1.S();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
        /* compiled from: DeviceInfo.java */
        /* loaded from: E:\TSN-r\205dec\7502512.dex */
        public final class b extends ConnectivityManager.NetworkCallback {
            b() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network network) {
                super.onAvailable(network);
                c1.S();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network network) {
                super.onLost(network);
                c1.S();
            }
        }

        @SuppressLint({"WrongConstant"})
        public final void a(Context context) {
            if (Build.VERSION.SDK_INT < 24) {
                if (context == null || f9691b != null) {
                    return;
                }
                f9691b = new a();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(j1.t("WYW5kcm9pZC5uZXQuY29ubi5DT05ORUNUSVZJVFlfQ0hBTkdF"));
                context.registerReceiver(f9691b, intentFilter);
            } else if (c1.q(context, j1.t("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) && context != null && f9692c == null) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                f9692c = connectivityManager;
                if (connectivityManager != null) {
                    f9693d = new NetworkRequest.Builder().addCapability(0).addCapability(1).build();
                    b bVar = new b();
                    f9694e = bVar;
                    f9692c.registerNetworkCallback(f9693d, bVar);
                    f9690a = context;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: DeviceInfo.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class e implements ServiceConnection {
        e() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = c1.f9676o = iBinder;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String A(Context context) {
        TelephonyManager b4;
        if (f9686y) {
            return f9685x;
        }
        try {
            g(context);
            b4 = b(context);
        } catch (Throwable unused) {
        }
        if (b4 == null) {
            return f9685x;
        }
        String networkOperator = b4.getNetworkOperator();
        if (!TextUtils.isEmpty(networkOperator) && networkOperator.length() >= 3) {
            f9685x = networkOperator.substring(3);
            f9686y = true;
            return f9685x;
        }
        f9686y = true;
        return f9685x;
    }

    public static int B(Context context) {
        try {
            return a(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    public static String C() {
        return f9683v;
    }

    public static int D(Context context) {
        try {
            return c0(context);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String[] E() {
        return new String[]{"", ""};
    }

    public static String F() {
        return E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String G(Context context) {
        String str;
        String str2;
        try {
            str = f9687z;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f9687z;
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
        f9687z = str2;
        return f9687z;
    }

    public static String H() {
        return A;
    }

    public static String I(Context context) {
        ConnectivityManager d02;
        NetworkInfo activeNetworkInfo;
        try {
            return (!q(context, j1.t("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF")) || (d02 = d0(context)) == null || (activeNetworkInfo = d02.getActiveNetworkInfo()) == null) ? "" : activeNetworkInfo.getTypeName();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String J() {
        return "";
    }

    public static String K(Context context) {
        String str;
        try {
            String H2 = H();
            try {
                if (TextUtils.isEmpty(H2)) {
                    H2 = j(context);
                }
                if (TextUtils.isEmpty(H2)) {
                    H2 = y(context);
                }
                if (TextUtils.isEmpty(H2)) {
                    H2 = w(context);
                }
                if (TextUtils.isEmpty(H2)) {
                    H2 = z();
                }
                return TextUtils.isEmpty(H2) ? a0(context) : H2;
            } catch (Throwable unused) {
                return str;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    public static int L(Context context) {
        int i4 = f9661L;
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
        f9661L = i5;
        return i5;
    }

    public static String M() {
        return "";
    }

    public static long N() {
        long blockCount;
        long blockCount2;
        long j4 = K;
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
            K = blockCount + blockCount2;
        } catch (Throwable unused) {
        }
        return K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String O(Context context) {
        try {
            return b0(context);
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String P() {
        if (!TextUtils.isEmpty(M)) {
            return M;
        }
        String property = System.getProperty("os.arch");
        M = property;
        return property;
    }

    public static String Q(Context context) {
        try {
            if (TextUtils.isEmpty(f9670i)) {
                f9670i = q1.a(context);
            }
        } catch (Throwable unused) {
        }
        return f9670i;
    }

    public static void S() {
        S = -1;
        T = false;
        U = -1;
        V = false;
        Q = "";
        R = false;
        f9685x = "";
        f9686y = false;
    }

    private static String T(Context context) {
        try {
            String o4 = j2.o(context, "Alvin2", "UTDID2", "");
            return TextUtils.isEmpty(o4) ? j2.o(context, "Alvin2", "UTDID", "") : o4;
        } catch (Throwable unused) {
            return "";
        }
    }

    static /* synthetic */ boolean U() {
        f9677p = true;
        return true;
    }

    private static String V(Context context) {
        FileInputStream fileInputStream = null;
        try {
            if (j1.l(context, "android.permission.READ_EXTERNAL_STORAGE") && "mounted".equals(Environment.getExternalStorageState())) {
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

    private static String W(Context context) {
        try {
            if (!TextUtils.isEmpty(f9675n)) {
                return f9675n;
            }
            byte[] digest = MessageDigest.getInstance(j1.t("IU0hBMQ")).digest(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                stringBuffer.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            String stringBuffer2 = stringBuffer.toString();
            if (!TextUtils.isEmpty(stringBuffer2)) {
                f9675n = stringBuffer2;
            }
            return stringBuffer2;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String X(Context context) {
        try {
            Class<?> cls = Class.forName(j1.t("WY29tLmFuZHJvaWQuaWQuaW1wbC5JZFByb3ZpZGVySW1wbA"));
            Object invoke = cls.getMethod(j1.t("MZ2V0T0FJRA"), Context.class).invoke(cls.newInstance(), context);
            if (invoke != null) {
                String str = (String) invoke;
                f9673l = str;
                return str;
            }
        } catch (Throwable th) {
            d2.e(th, "oa", "xm");
            f9674m = true;
        }
        return f9673l;
    }

    private static String Y(Context context) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(j1.t("QY29udGVudDovL2NvbS52aXZvLnZtcy5JZFByb3ZpZGVyL0lkZW50aWZpZXJJZC9PQUlE")), null, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    int columnCount = query.getColumnCount();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= columnCount) {
                            break;
                        } else if (j1.t("IdmFsdWU").equals(query.getColumnName(i4))) {
                            f9673l = query.getString(i4);
                            break;
                        } else {
                            i4++;
                        }
                    }
                }
                query.close();
            }
        } catch (Throwable th) {
            f9674m = true;
            d2.e(th, "oa", "vivo");
        }
        return f9673l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String Z(Context context) {
        String t3 = j1.t("IeGlhb21p");
        String str = Build.MANUFACTURER;
        if (!t3.equalsIgnoreCase(str)) {
            String t4 = j1.t("IeGlhb21p");
            String str2 = Build.BRAND;
            if (!t4.equalsIgnoreCase(str2) && !j1.t("IUkVETUk=").equalsIgnoreCase(str) && !j1.t("IUkVETUk=").equalsIgnoreCase(str2)) {
                if (!j1.t("Idml2bw").equalsIgnoreCase(str) && !j1.t("Idml2bw").equalsIgnoreCase(str2)) {
                    if (!j1.t("IaHVhd2Vp").equalsIgnoreCase(str) && !j1.t("IaHVhd2Vp").equalsIgnoreCase(str2) && !j1.t("ISE9OT1I=").equalsIgnoreCase(str)) {
                        if (!j1.t("Mc2Ftc3VuZw").equalsIgnoreCase(str) && !j1.t("Mc2Ftc3VuZw").equalsIgnoreCase(str2)) {
                            if (!j1.t("IT1BQTw").equalsIgnoreCase(str) && !j1.t("IT1BQTw").equalsIgnoreCase(str2) && !j1.t("MT25lUGx1cw").equalsIgnoreCase(str) && !j1.t("MT25lUGx1cw").equalsIgnoreCase(str2) && !j1.t("IUkVBTE1F").equalsIgnoreCase(str2)) {
                                f9674m = true;
                                return f9673l;
                            }
                            return k(context, 5);
                        }
                        return k(context, 4);
                    }
                    return k(context, 2);
                }
                return Y(context);
            }
        }
        return X(context);
    }

    private static int a(Context context) {
        if (V) {
            return U;
        }
        g(context);
        if (!q(context, j1.t("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return U;
        }
        TelephonyManager b4 = b(context);
        if (b4 == null) {
            return U;
        }
        int networkType = b4.getNetworkType();
        U = networkType;
        V = true;
        return networkType;
    }

    private static String a0(Context context) {
        if (!TextUtils.isEmpty(H)) {
            return H;
        }
        try {
            String o4 = j2.o(context, "open_common", "a1", "");
            if (TextUtils.isEmpty(o4)) {
                H = "amap" + UUID.randomUUID().toString().replace("_", "").toLowerCase();
                SharedPreferences.Editor c4 = j2.c(context, "open_common");
                j2.j(c4, "a1", j1.q(H));
                j2.f(c4);
            } else {
                H = j1.t(o4);
            }
            return H;
        } catch (Throwable unused) {
            return H;
        }
    }

    private static TelephonyManager b(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    private static String b0(Context context) {
        if (R) {
            return Q;
        }
        g(context);
        if (!q(context, j1.t("WYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfUEhPTkVfU1RBVEU="))) {
            return Q;
        }
        TelephonyManager b4 = b(context);
        if (b4 == null) {
            return Q;
        }
        String simOperatorName = b4.getSimOperatorName();
        Q = simOperatorName;
        if (TextUtils.isEmpty(simOperatorName)) {
            Q = b4.getNetworkOperatorName();
        }
        R = true;
        return Q;
    }

    private static String c(Context context) {
        if (f9664c) {
            String str = null;
            try {
                str = d(context);
            } catch (Throwable unused) {
            }
            if (TextUtils.isEmpty(str)) {
                f9664c = false;
                return "";
            }
            try {
                byte[] bytes = j1.t("MAAAAAAAAAAAAAAAAAAAAAA").getBytes("UTF-8");
                return new String(d1.e(j1.t("HYW1hcGFkaXVhbWFwYWRpdWFtYXBhZGl1YW1hcGFkaXU").getBytes("UTF-8"), d1.g(str), bytes), "UTF-8");
            } catch (Throwable unused2) {
                f9664c = false;
                return "";
            }
        }
        return "";
    }

    private static int c0(Context context) {
        if (T) {
            return S;
        }
        g(context);
        if (context != null && q(context, j1.t("AYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19ORVRXT1JLX1NUQVRF"))) {
            ConnectivityManager d02 = d0(context);
            if (d02 == null) {
                return S;
            }
            NetworkInfo activeNetworkInfo = d02.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                T = true;
                return S;
            }
            int type = activeNetworkInfo.getType();
            S = type;
            T = true;
            return type;
        }
        return S;
    }

    private static String d(Context context) {
        String str;
        try {
            str = e(context);
        } catch (Throwable unused) {
            str = "";
        }
        return !TextUtils.isEmpty(str) ? str : context == null ? "" : context.getSharedPreferences(j1.t("SU2hhcmVkUHJlZmVyZW5jZUFkaXU"), 0).getString(g1.a(j1.t("RYW1hcF9kZXZpY2VfYWRpdQ")), "");
    }

    private static ConnectivityManager d0(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static String e(Context context) {
        RandomAccessFile randomAccessFile;
        ByteArrayOutputStream byteArrayOutputStream;
        String str;
        String[] split;
        if (Build.VERSION.SDK_INT < 19 || q(context, j1.t("EYW5kcm9pZC5wZXJtaXNzaW9uLlJFQURfRVhURVJOQUxfU1RPUkFHRQ=="))) {
            String a4 = g1.a(j1.t("LYW1hcF9kZXZpY2VfYWRpdQ"));
            String f4 = f(context);
            if (TextUtils.isEmpty(f4)) {
                return "";
            }
            File file = new File(f4 + File.separator + j1.t("KYmFja3Vwcw"), j1.t("MLmFkaXU"));
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
                                m(byteArrayOutputStream2);
                                m(randomAccessFile);
                                return "";
                            }
                        }
                        str = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    } catch (Throwable unused2) {
                    }
                } catch (Throwable unused3) {
                    randomAccessFile = null;
                }
                if (!TextUtils.isEmpty(str) && str.contains(j1.t("SIw")) && (split = str.split(j1.t("SIw"))) != null && split.length == 2 && TextUtils.equals(a4, split[0])) {
                    String str2 = split[1];
                    m(byteArrayOutputStream);
                    m(randomAccessFile);
                    return str2;
                }
                m(byteArrayOutputStream);
                m(randomAccessFile);
            }
            return "";
        }
        return "";
    }

    private static String f(Context context) {
        try {
            StorageManager storageManager = (StorageManager) context.getSystemService("storage");
            Class<?> cls = Class.forName(j1.t("SYW5kcm9pZC5vcy5zdG9yYWdlLlN0b3JhZ2VWb2x1bWU"));
            Method method = storageManager.getClass().getMethod(j1.t("MZ2V0Vm9sdW1lTGlzdA"), new Class[0]);
            Method method2 = cls.getMethod(j1.t("FZ2V0UGF0aA"), new Class[0]);
            Method method3 = cls.getMethod(j1.t("DaXNSZW1vdmFibGU"), new Class[0]);
            Object invoke = method.invoke(storageManager, new Object[0]);
            int length = Array.getLength(invoke);
            for (int i4 = 0; i4 < length; i4++) {
                Object obj = Array.get(invoke, i4);
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

    private static synchronized d g(Context context) {
        synchronized (c1.class) {
            if (W == null) {
                if (context == null) {
                    return null;
                }
                d dVar = new d();
                W = dVar;
                dVar.a(StubApp.getOrigApplicationContext(context.getApplicationContext()));
            }
            return W;
        }
    }

    public static String i() {
        return f9668g;
    }

    public static String j(Context context) {
        if (TextUtils.isEmpty(f9663b)) {
            if (context == null) {
                return "";
            }
            String c4 = c(context);
            f9663b = c4;
            if (!TextUtils.isEmpty(c4)) {
                return f9663b;
            }
            if (s() == null || f9672k) {
                return "";
            }
            f9672k = true;
            y3.e().c(new a(context));
            return "";
        }
        return f9663b;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b5 A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #2 {all -> 0x00f0, blocks: (B:3:0x0001, B:7:0x000f, B:9:0x0014, B:12:0x004f, B:17:0x0060, B:19:0x0068, B:21:0x006e, B:32:0x00c3, B:33:0x00c6, B:41:0x00e0, B:42:0x00e7, B:43:0x00ed, B:10:0x002d, B:11:0x003d, B:31:0x00b5, B:26:0x007e, B:27:0x009f, B:28:0x00a9), top: B:48:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String k(android.content.Context r12, int r13) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.s.c1.k(android.content.Context, int):java.lang.String");
    }

    public static void l(c cVar) {
        if (f9671j == null) {
            f9671j = cVar;
        }
    }

    private static void m(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String o() {
        try {
            if (!TextUtils.isEmpty(f9666e)) {
                return f9666e;
            }
            c cVar = f9671j;
            return cVar == null ? "" : cVar.a();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String p(Context context) {
        try {
            return b0(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean q(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static int r(Context context) {
        try {
            return a(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static c s() {
        return f9671j;
    }

    public static int t(Context context) {
        try {
            return c0(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String u() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            String M2 = M();
            return M2.length() < 5 ? "" : M2.substring(3, 5);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String v() {
        return "";
    }

    public static String w(Context context) {
        if (f9674m) {
            return "";
        }
        if (!TextUtils.isEmpty(f9673l)) {
            return f9673l;
        }
        if (f9677p) {
            return f9673l;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            y3.e().c(new b(context));
            return f9673l;
        }
        f9677p = true;
        return Z(context);
    }

    public static String x() {
        return "";
    }

    public static String y(Context context) {
        String str;
        if (f9678q) {
            String str2 = f9662a;
            return str2 == null ? "" : str2;
        }
        try {
            str = f9662a;
        } catch (Throwable unused) {
        }
        if (str != null && !"".equals(str)) {
            return f9662a;
        }
        if (q(context, j1.t("WYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFVFRJTkdT"))) {
            f9662a = Settings.System.getString(context.getContentResolver(), "mqBRboGZkQPcAkyk");
        }
        if (!TextUtils.isEmpty(f9662a)) {
            f9678q = true;
            return f9662a;
        }
        try {
            String T2 = T(context);
            f9662a = T2;
            if (!TextUtils.isEmpty(T2)) {
                f9678q = true;
                return f9662a;
            }
        } catch (Throwable unused2) {
        }
        try {
            f9662a = V(context);
            f9678q = true;
        } catch (Throwable unused3) {
        }
        String str3 = f9662a;
        return str3 == null ? "" : str3;
    }

    public static String z() {
        return "";
    }
}
