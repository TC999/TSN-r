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
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.InternalContainer;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.SdkGlobalInfo;
import bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_case1.PermissionActivityCompat;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"MissingPermission"})
/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class IdUtils {

    /* renamed from: a */
    private static volatile String f657a;

    /* renamed from: b */
    private static volatile String f658b;

    /* renamed from: c */
    private static volatile String f659c;

    /* renamed from: d */
    private static volatile String f660d;

    /* renamed from: e */
    private static volatile String f661e;

    /* renamed from: f */
    private static volatile String f662f;

    /* renamed from: g */
    private static volatile String f663g;

    /* renamed from: h */
    private static volatile String f664h;

    /* renamed from: i */
    private static volatile String f665i;

    /* renamed from: j */
    private static final AtomicInteger f666j = new AtomicInteger(0);

    /* renamed from: k */
    private static volatile boolean f667k;

    /* renamed from: a */
    public static String m59201a(Context context) {
        if (TextUtils.isEmpty(f658b)) {
            m59181n(context);
        }
        return f658b;
    }

    /* renamed from: b */
    public static String m59194b(Context context) {
        if (f663g == null) {
            m59195b();
        }
        return f663g;
    }

    /* renamed from: c */
    private static Context m59192c(Context context) {
        return context == null ? InternalContainer.m59945d() : context;
    }

    /* renamed from: d */
    public static String m59191d(Context context) {
        if (TextUtils.isEmpty(f657a)) {
            m59179p(context);
        }
        return f657a;
    }

    /* renamed from: e */
    public static String m59190e(Context context) {
        if (SdkGlobalInfo.m59939B().m59897p().isCanUsePhoneState()) {
            if (TextUtils.isEmpty(f659c)) {
                m59176s(context);
            }
            return f659c;
        }
        return null;
    }

    /* renamed from: f */
    public static String m59189f(Context context) {
        if (SdkGlobalInfo.m59939B().m59897p().isCanUsePhoneState()) {
            if (TextUtils.isEmpty(f662f)) {
                m59176s(context);
            }
            return f662f;
        }
        return null;
    }

    /* renamed from: g */
    public static String m59188g(Context context) {
        if (SdkGlobalInfo.m59939B().m59897p().isCanUseLocation()) {
            if (TextUtils.isEmpty(f660d)) {
                m59177r(context);
            }
            return f660d;
        }
        return null;
    }

    /* renamed from: h */
    public static String m59187h(Context context) {
        if (TextUtils.isEmpty(f664h)) {
            m59178q(context);
        }
        return f664h;
    }

    /* renamed from: i */
    public static String m59186i(Context context) {
        if (SdkGlobalInfo.m59939B().m59897p().isCanUseLocation()) {
            if (TextUtils.isEmpty(f661e)) {
                m59177r(context);
            }
            return f661e;
        }
        return null;
    }

    /* renamed from: j */
    public static String m59185j(Context context) {
        if (SdkGlobalInfo.m59939B().m59897p().isCanUsePhoneState()) {
            if (TextUtils.isEmpty(f665i)) {
                m59180o(context);
            }
            return f665i;
        }
        return null;
    }

    /* renamed from: k */
    private static boolean m59184k(Context context) {
        return PermissionActivityCompat.m59825a(context, C7282g.f24949g) == 0 || PermissionActivityCompat.m59825a(context, C7282g.f24950h) == 0;
    }

    /* renamed from: l */
    private static boolean m59183l(Context context) {
        return PermissionActivityCompat.m59825a(context, C7282g.f24945c) == 0;
    }

    @RequiresPermission(anyOf = {C7282g.f24946d})
    @SuppressLint({"HardwareIds", "MissingPermission"})
    /* renamed from: m */
    public static void m59182m(Context context) {
        Context m59192c;
        if (f667k || (m59192c = m59192c(context)) == null) {
            return;
        }
        m59176s(m59192c);
        m59177r(context);
        m59180o(context);
        m59181n(context);
        m59179p(context);
        m59193c();
        m59195b();
        m59178q(context);
        f667k = true;
    }

    /* renamed from: n */
    private static synchronized void m59181n(Context context) {
        synchronized (IdUtils.class) {
            if (context == null) {
                return;
            }
            f658b = m59199a(context, true);
        }
    }

    @RequiresPermission(C7282g.f24945c)
    /* renamed from: o */
    private static synchronized void m59180o(Context context) {
        synchronized (IdUtils.class) {
            if (SdkGlobalInfo.m59939B().m59897p().isCanUsePhoneState() && m59183l(context)) {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        f665i = Build.getSerial();
                    } else {
                        f665i = Build.SERIAL;
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: p */
    private static synchronized void m59179p(Context context) {
        synchronized (IdUtils.class) {
            if (context == null) {
                return;
            }
            f657a = SPUtils.m59131a("tt_device_info", context).m59130a("did", (String) null);
        }
    }

    /* renamed from: q */
    private static synchronized void m59178q(Context context) {
        synchronized (IdUtils.class) {
            if (context == null) {
                return;
            }
            f664h = SPUtils.m59131a("tt_device_info", context).m59130a("uuid", (String) null);
        }
    }

    /* renamed from: r */
    private static synchronized void m59177r(Context context) {
        WifiInfo connectionInfo;
        synchronized (IdUtils.class) {
            if (context == null) {
                return;
            }
            try {
                WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
                if (wifiManager != null) {
                    if (SdkGlobalInfo.m59939B().m59897p().isCanUseLocation() && m59184k(context) && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                        f660d = connectionInfo.getSSID();
                    }
                    f661e = m59198a(wifiManager, context);
                }
            } catch (Exception unused) {
            }
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    /* renamed from: s */
    private static void m59176s(Context context) {
        AtomicInteger atomicInteger = f666j;
        if (atomicInteger.intValue() <= 5 && SdkGlobalInfo.m59939B().m59897p().isCanUsePhoneState() && m59183l(context)) {
            try {
                atomicInteger.incrementAndGet();
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    f659c = telephonyManager.getDeviceId();
                    f662f = telephonyManager.getSubscriberId();
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: t */
    public static void m59175t(Context context) {
        Context m59192c;
        if (TextUtils.isEmpty(f659c) && (m59192c = m59192c(context)) != null) {
            try {
                m59176s(m59192c);
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: c */
    private static synchronized void m59193c() {
        synchronized (IdUtils.class) {
            m59202a();
        }
    }

    /* renamed from: a */
    public static void m59200a(Context context, String str) {
        if (TextUtils.isEmpty(str) || str.equals(f657a)) {
            return;
        }
        SPUtils.m59131a("tt_device_info", context).m59123b("did", str);
        f657a = str;
    }

    /* renamed from: b */
    private static synchronized void m59195b() {
        synchronized (IdUtils.class) {
            f663g = String.valueOf(Build.TIME);
        }
    }

    /* renamed from: a */
    private static String m59198a(WifiManager wifiManager, Context context) {
        String str = "02:00:00:00:00:00";
        if (wifiManager == null) {
            return "02:00:00:00:00:00";
        }
        if (SdkGlobalInfo.m59939B().m59897p().isCanUseLocation() && m59184k(context)) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (scanResults != null && connectionInfo != null && connectionInfo.getBSSID() != null) {
                    for (int i = 0; i < scanResults.size(); i++) {
                        ScanResult scanResult = scanResults.get(i);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized java.lang.String m59199a(android.content.Context r6, boolean r7) {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.k> r0 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IdUtils.class
            monitor-enter(r0)
            android.content.Context r6 = m59192c(r6)     // Catch: java.lang.Throwable -> L90
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
            bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.r r6 = bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.SPUtils.m59131a(r4, r6)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            java.lang.String r4 = "openudid"
            java.lang.String r1 = r6.m59130a(r4, r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            boolean r4 = m59197a(r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
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
            java.lang.String r7 = m59196a(r7, r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            boolean r3 = m59197a(r7)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
            if (r3 == 0) goto L88
            r1 = r7
        L88:
            java.lang.String r7 = "openudid"
            r6.m59123b(r7, r1)     // Catch: java.lang.Exception -> L8e java.lang.Throwable -> L90
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
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.IdUtils.m59199a(android.content.Context, boolean):java.lang.String");
    }

    /* renamed from: a */
    private static String m59196a(String str, String str2) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        byte[] bArr;
        int read;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return str2;
        }
        String str3 = Environment.getExternalStorageDirectory().getPath() + "/Android/data/com.snssdk.api/cache";
        String str4 = str3 + "/" + str;
        FileLock fileLock = null;
        try {
            File file = new File(str3);
            if (file.exists() || file.mkdirs()) {
                File file2 = new File(str4);
                randomAccessFile2 = new RandomAccessFile(file2, "rwd");
                try {
                    fileLock = randomAccessFile2.getChannel().lock();
                    if (file2.isFile() && (read = randomAccessFile2.read((bArr = new byte[TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA]), 0, TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA)) > 0 && read < 129) {
                        String str5 = new String(bArr, 0, read, "UTF-8");
                        if (m59197a(str5)) {
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

    /* renamed from: a */
    private static boolean m59197a(String str) {
        int length;
        if (str != null && (length = str.length()) >= 13 && length <= 128) {
            for (int i = 0; i < length; i++) {
                char charAt = str.charAt(i);
                if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static String m59202a() {
        StringBuilder sb = new StringBuilder();
        try {
            if (RomUtils.m59138t()) {
                sb.append("MIUI-");
            } else if (RomUtils.m59141q()) {
                sb.append("FLYME-");
            } else {
                String m59152f = RomUtils.m59152f();
                if (RomUtils.m59154d(m59152f)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(m59152f)) {
                    sb.append(m59152f);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return sb.toString();
    }
}
