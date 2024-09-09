package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.stub.StubApp;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: IdUtils.java */
@SuppressLint({"MissingPermission"})
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static volatile String f650a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f651b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f652c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile String f653d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile String f654e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f655f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile String f656g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile String f657h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile String f658i;

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicInteger f659j = new AtomicInteger(0);

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f660k;

    public static String a(Context context) {
        if (TextUtils.isEmpty(f651b)) {
            n(context);
        }
        return f651b;
    }

    public static String b(Context context) {
        if (f656g == null) {
            b();
        }
        return f656g;
    }

    private static Context c(Context context) {
        return context == null ? bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.a.d() : context;
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(f650a)) {
            p(context);
        }
        return f650a;
    }

    public static String e(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUsePhoneState()) {
            if (TextUtils.isEmpty(f652c)) {
                s(context);
            }
            return f652c;
        }
        return null;
    }

    public static String f(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUsePhoneState()) {
            if (TextUtils.isEmpty(f655f)) {
                s(context);
            }
            return f655f;
        }
        return null;
    }

    public static String g(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUseLocation()) {
            if (TextUtils.isEmpty(f653d)) {
                r(context);
            }
            return f653d;
        }
        return null;
    }

    public static String h(Context context) {
        if (TextUtils.isEmpty(f657h)) {
            q(context);
        }
        return f657h;
    }

    public static String i(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUseLocation()) {
            if (TextUtils.isEmpty(f654e)) {
                r(context);
            }
            return f654e;
        }
        return null;
    }

    public static String j(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUsePhoneState()) {
            if (TextUtils.isEmpty(f658i)) {
                o(context);
            }
            return f658i;
        }
        return null;
    }

    private static boolean k(Context context) {
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.c.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.c.a(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private static boolean l(Context context) {
        return bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.c.a(context, "android.permission.READ_PHONE_STATE") == 0;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_WIFI_STATE"})
    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static void m(Context context) {
        Context c4;
        if (f660k || (c4 = c(context)) == null) {
            return;
        }
        s(c4);
        r(context);
        o(context);
        n(context);
        p(context);
        c();
        b();
        q(context);
        f660k = true;
    }

    private static synchronized void n(Context context) {
        synchronized (k.class) {
            if (context == null) {
                return;
            }
            f651b = a(context, true);
        }
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    private static synchronized void o(Context context) {
        synchronized (k.class) {
            if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUsePhoneState() && l(context)) {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        f658i = Build.getSerial();
                    } else {
                        f658i = Build.SERIAL;
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private static synchronized void p(Context context) {
        synchronized (k.class) {
            if (context == null) {
                return;
            }
            f650a = r.a("tt_device_info", context).a("did", (String) null);
        }
    }

    private static synchronized void q(Context context) {
        synchronized (k.class) {
            if (context == null) {
                return;
            }
            f657h = r.a("tt_device_info", context).a("uuid", (String) null);
        }
    }

    private static synchronized void r(Context context) {
        WifiInfo connectionInfo;
        synchronized (k.class) {
            if (context == null) {
                return;
            }
            try {
                WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
                if (wifiManager != null) {
                    if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUseLocation() && k(context) && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                        f653d = connectionInfo.getSSID();
                    }
                    f654e = a(wifiManager, context);
                }
            } catch (Exception unused) {
            }
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static void s(Context context) {
        AtomicInteger atomicInteger = f659j;
        if (atomicInteger.intValue() <= 5 && bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUsePhoneState() && l(context)) {
            try {
                atomicInteger.incrementAndGet();
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    f652c = telephonyManager.getDeviceId();
                    f655f = telephonyManager.getSubscriberId();
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void t(Context context) {
        Context c4;
        if (TextUtils.isEmpty(f652c) && (c4 = c(context)) != null) {
            try {
                s(c4);
            } catch (Exception unused) {
            }
        }
    }

    private static synchronized void c() {
        synchronized (k.class) {
            a();
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.equals(f650a)) {
            return;
        }
        r.a("tt_device_info", context).b("did", str);
        f650a = str;
    }

    private static synchronized void b() {
        synchronized (k.class) {
            f656g = String.valueOf(Build.TIME);
        }
    }

    private static String a(WifiManager wifiManager, Context context) {
        String str = "02:00:00:00:00:00";
        if (wifiManager == null) {
            return "02:00:00:00:00:00";
        }
        if (bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.b.B().p().isCanUseLocation() && k(context)) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (scanResults != null && connectionInfo != null && connectionInfo.getBSSID() != null) {
                    for (int i4 = 0; i4 < scanResults.size(); i4++) {
                        ScanResult scanResult = scanResults.get(i4);
                        if (connectionInfo.getBSSID().equals(scanResult.BSSID)) {
                            str = scanResult.BSSID;
                        }
                    }
                }
            } catch (Exception unused) {
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
        if (r2.length() >= 13) goto L33;
     */
    @android.annotation.SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized java.lang.String a(android.content.Context r6, boolean r7) {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.k> r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.k.class
            monitor-enter(r0)
            android.content.Context r6 = c(r6)     // Catch: java.lang.Throwable -> L90
            r1 = 0
            if (r6 != 0) goto Lc
            monitor-exit(r0)
            return r1
        Lc:
            android.content.ContentResolver r2 = r6.getContentResolver()     // Catch: java.lang.Exception -> L17 java.lang.Throwable -> L90
            java.lang.String r3 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r2, r3)     // Catch: java.lang.Exception -> L17 java.lang.Throwable -> L90
            goto L18
        L17:
            r2 = r1
        L18:
            r3 = 13
            if (r2 == 0) goto L2a
            java.lang.String r4 = "9774d56d682e549c"
            boolean r4 = r2.equals(r4)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            if (r4 != 0) goto L2a
            int r4 = r2.length()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            if (r4 >= r3) goto L8e
        L2a:
            java.lang.String r4 = "tt_device_info"
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r r6 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r.a(r4, r6)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            java.lang.String r4 = "openudid"
            java.lang.String r1 = r6.a(r4, r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            boolean r4 = a(r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            if (r4 != 0) goto L8d
            java.security.SecureRandom r1 = new java.security.SecureRandom     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            r1.<init>()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            java.math.BigInteger r4 = new java.math.BigInteger     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            r5 = 64
            r4.<init>(r5, r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            r1 = 16
            java.lang.String r1 = r4.toString(r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            r4 = 0
            char r4 = r1.charAt(r4)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            r5 = 45
            if (r4 != r5) goto L5c
            r4 = 1
            java.lang.String r1 = r1.substring(r4)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
        L5c:
            int r4 = r1.length()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            int r3 = r3 - r4
            if (r3 <= 0) goto L79
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            r4.<init>()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
        L68:
            if (r3 <= 0) goto L72
            r5 = 70
            r4.append(r5)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            int r3 = r3 + (-1)
            goto L68
        L72:
            r4.append(r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
        L79:
            if (r7 == 0) goto L88
            java.lang.String r7 = "openudid.dat"
            java.lang.String r7 = a(r7, r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            boolean r3 = a(r7)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            if (r3 == 0) goto L88
            r1 = r7
        L88:
            java.lang.String r7 = "openudid"
            r6.b(r7, r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
        L8d:
            r2 = r1
        L8e:
            monitor-exit(r0)
            return r2
        L90:
            r6 = move-exception
            monitor-exit(r0)
            goto L94
        L93:
            throw r6
        L94:
            goto L93
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.k.a(android.content.Context, boolean):java.lang.String");
    }

    private static String a(String str, String str2) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        byte[] bArr;
        int read;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return str2;
        }
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api/cache";
        String str4 = str3 + TTPathConst.sSeparator + str;
        FileLock fileLock = null;
        try {
            File file = new File(str3);
            if (file.exists() || file.mkdirs()) {
                File file2 = new File(str4);
                randomAccessFile2 = new RandomAccessFile(file2, "rwd");
                try {
                    fileLock = randomAccessFile2.getChannel().lock();
                    if (file2.isFile() && (read = randomAccessFile2.read((bArr = new byte[129]), 0, 129)) > 0 && read < 129) {
                        String str5 = new String(bArr, 0, read, "UTF-8");
                        if (a(str5)) {
                            if (fileLock != null) {
                                try {
                                    fileLock.release();
                                } catch (Exception unused) {
                                }
                            }
                            try {
                                randomAccessFile2.close();
                            } catch (Exception unused2) {
                            }
                            return str5;
                        }
                    }
                    byte[] bytes = str2.getBytes("UTF-8");
                    randomAccessFile2.setLength(0L);
                    randomAccessFile2.write(bytes);
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused3) {
                        }
                    }
                    try {
                        randomAccessFile2.close();
                    } catch (Exception unused4) {
                    }
                    return str2;
                } catch (Exception unused5) {
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused6) {
                        }
                    }
                    if (randomAccessFile2 != null) {
                        try {
                            randomAccessFile2.close();
                        } catch (Exception unused7) {
                        }
                    }
                    return str2;
                } catch (Throwable th) {
                    randomAccessFile = randomAccessFile2;
                    th = th;
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused8) {
                        }
                    }
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception unused9) {
                        }
                    }
                    throw th;
                }
            }
            return str2;
        } catch (Exception unused10) {
            randomAccessFile2 = null;
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    private static boolean a(String str) {
        int length;
        if (str != null && (length = str.length()) >= 13 && length <= 128) {
            for (int i4 = 0; i4 < length; i4++) {
                char charAt = str.charAt(i4);
                if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private static String a() {
        StringBuilder sb = new StringBuilder();
        try {
            if (q.t()) {
                sb.append("MIUI-");
            } else if (q.q()) {
                sb.append("FLYME-");
            } else {
                String f4 = q.f();
                if (q.d(f4)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(f4)) {
                    sb.append(f4);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return sb.toString();
    }
}
