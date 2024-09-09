package com.bytedance.msdk.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.stub.StubApp;
import java.io.File;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.channels.FileLock;
import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@SuppressLint({"MissingPermission"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ls {

    /* renamed from: c  reason: collision with root package name */
    private static volatile String f28334c;
    private static volatile String ev;

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f28335f;
    private static volatile String gd;

    /* renamed from: k  reason: collision with root package name */
    private static final AtomicInteger f28336k = new AtomicInteger(0);

    /* renamed from: p  reason: collision with root package name */
    private static volatile String f28337p;

    /* renamed from: r  reason: collision with root package name */
    private static volatile String f28338r;
    private static volatile String sr;
    private static volatile String ux;

    /* renamed from: w  reason: collision with root package name */
    private static volatile String f28339w;
    private static volatile String xv;

    private static synchronized void a(Context context) {
        synchronized (ls.class) {
            if (context == null) {
                return;
            }
            f28334c = ia.c();
            if (TextUtils.isEmpty(f28334c)) {
                f28334c = wv.c("tt_device_info", context).w("did", "");
            } else {
                c(com.bytedance.msdk.core.c.getContext(), f28334c);
            }
        }
    }

    private static synchronized void bk(Context context) {
        synchronized (ls.class) {
            if (context == null) {
                return;
            }
            if (com.bytedance.msdk.core.w.k().y().xv()) {
                f28339w = c(context, true);
            }
        }
    }

    public static String c(Context context) {
        if (TextUtils.isEmpty(f28334c)) {
            synchronized (ls.class) {
                if (TextUtils.isEmpty(f28334c)) {
                    a(context);
                }
            }
        }
        return f28334c;
    }

    public static String ev(Context context) {
        if (com.bytedance.msdk.core.w.k().y().c()) {
            if (TextUtils.isEmpty(ux)) {
                synchronized (ls.class) {
                    if (TextUtils.isEmpty(ux)) {
                        ys(context);
                    }
                }
            }
            return ux;
        }
        return null;
    }

    public static String f(Context context) {
        if (com.bytedance.msdk.core.w.k().y().w()) {
            if (TextUtils.isEmpty(f28335f)) {
                synchronized (ls.class) {
                    if (TextUtils.isEmpty(f28335f)) {
                        ia(context);
                    }
                }
            }
            return f28335f;
        }
        return null;
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    private static synchronized void fp(Context context) {
        synchronized (ls.class) {
            if (com.bytedance.msdk.core.w.k().y().w() && fz(context)) {
                try {
                    if (Build.VERSION.SDK_INT >= 28) {
                        f28337p = Build.getSerial();
                    } else {
                        f28337p = Build.SERIAL;
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    private static boolean fz(Context context) {
        return com.bytedance.msdk.core.t.xv.c(context, "android.permission.READ_PHONE_STATE") == 0;
    }

    public static String gd(Context context) {
        if (com.bytedance.msdk.core.w.k().y().w()) {
            if (TextUtils.isEmpty(f28337p)) {
                synchronized (ls.class) {
                    if (TextUtils.isEmpty(f28337p)) {
                        fp(context);
                    }
                }
            }
            return f28337p;
        }
        return null;
    }

    private static Context getContext(Context context) {
        return context == null ? com.bytedance.msdk.core.c.getContext() : context;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static synchronized void ia(Context context) {
        synchronized (ls.class) {
            AtomicInteger atomicInteger = f28336k;
            if (atomicInteger.intValue() > 5) {
                return;
            }
            if (com.bytedance.msdk.core.w.k().y().w() && fz(context)) {
                try {
                    atomicInteger.incrementAndGet();
                    TelephonyManager c4 = y.c();
                    if (c4 != null) {
                        xv = c4.getDeviceId();
                        f28335f = c4.getSubscriberId();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static synchronized void k(Context context) {
        synchronized (ls.class) {
            if (TextUtils.isEmpty(xv)) {
                Context context2 = getContext(context);
                if (context2 == null) {
                    return;
                }
                try {
                    ia(context2);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static synchronized void p(Context context) {
        synchronized (ls.class) {
            Context context2 = getContext(context);
            if (context2 == null) {
                return;
            }
            ia(context2);
            ys(context);
            fp(context);
            bk(context);
            a(context);
            c();
            w();
            t(context);
        }
    }

    public static String r(Context context) {
        if (com.bytedance.msdk.core.w.k().y().c()) {
            if (TextUtils.isEmpty(sr)) {
                synchronized (ls.class) {
                    if (TextUtils.isEmpty(sr)) {
                        ys(context);
                    }
                }
            }
            return sr;
        }
        return null;
    }

    private static boolean s(Context context) {
        return com.bytedance.msdk.core.t.xv.c(context, "android.permission.ACCESS_FINE_LOCATION") == 0 || com.bytedance.msdk.core.t.xv.c(context, "android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    public static String sr(Context context) {
        if (TextUtils.isEmpty(gd)) {
            synchronized (ls.class) {
                if (TextUtils.isEmpty(gd)) {
                    t(context);
                }
            }
        }
        return gd;
    }

    private static synchronized void t(Context context) {
        synchronized (ls.class) {
            if (context == null) {
                return;
            }
            gd = wv.c("tt_device_info", context).w("uuid", "");
        }
    }

    public static String ux(Context context) {
        if (com.bytedance.msdk.core.w.k().y().w()) {
            if (TextUtils.isEmpty(xv)) {
                synchronized (ls.class) {
                    if (TextUtils.isEmpty(xv)) {
                        ia(context);
                    }
                }
            }
            return xv;
        }
        return null;
    }

    public static String w(Context context) {
        if (TextUtils.isEmpty(ev)) {
            synchronized (ls.class) {
                if (TextUtils.isEmpty(ev)) {
                    w();
                }
            }
        }
        return ev;
    }

    public static String xv(Context context) {
        if (com.bytedance.msdk.core.w.k().y().xv()) {
            if (TextUtils.isEmpty(f28339w)) {
                synchronized (ls.class) {
                    if (TextUtils.isEmpty(f28339w)) {
                        bk(context);
                    }
                }
            }
            return f28339w;
        }
        return null;
    }

    private static synchronized void ys(Context context) {
        WifiInfo connectionInfo;
        synchronized (ls.class) {
            if (context == null) {
                return;
            }
            try {
                WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
                if (wifiManager != null) {
                    if (com.bytedance.msdk.core.w.k().y().c() && s(context) && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                        sr = connectionInfo.getSSID();
                    }
                    ux = c(wifiManager, context);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static synchronized void c(Context context, String str) {
        synchronized (ls.class) {
            if (!TextUtils.isEmpty(str) && !str.equals(f28334c)) {
                wv.c("tt_device_info", context).c("did", str);
                f28334c = str;
            }
        }
    }

    private static synchronized void w() {
        synchronized (ls.class) {
            ev = String.valueOf(Build.TIME);
        }
    }

    private static String xv() {
        StringBuilder sb = new StringBuilder();
        try {
            if (me.ux()) {
                sb.append("MIUI-");
            } else if (me.w()) {
                sb.append("FLYME-");
            } else {
                String t3 = me.t();
                if (me.c(t3)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(t3)) {
                    sb.append(t3);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    private static synchronized void c() {
        synchronized (ls.class) {
            f28338r = xv();
        }
    }

    private static String c(WifiManager wifiManager, Context context) {
        String str = "02:00:00:00:00:00";
        if (wifiManager == null) {
            return "02:00:00:00:00:00";
        }
        if (com.bytedance.msdk.core.w.k().y().c() && s(context)) {
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

    @SuppressLint({"TrulyRandom", "HardwareIds"})
    private static String c(Context context, boolean z3) {
        Context context2 = getContext(context);
        String str = null;
        if (context2 == null) {
            return null;
        }
        try {
            str = Settings.Secure.getString(context2.getContentResolver(), "android_id");
        } catch (Exception unused) {
        }
        if (str != null) {
            try {
                if (!str.equals("9774d56d682e549c") && str.length() >= 13) {
                    return str;
                }
            } catch (Exception unused2) {
                return str;
            }
        }
        wv c4 = wv.c("tt_device_info", context2);
        String w3 = c4.w("openudid", "");
        if (!c(w3)) {
            w3 = new BigInteger(64, new SecureRandom()).toString(16);
            if (w3.charAt(0) == '-') {
                w3 = w3.substring(1);
            }
            int length = 13 - w3.length();
            if (length > 0) {
                StringBuilder sb = new StringBuilder();
                while (length > 0) {
                    sb.append('F');
                    length--;
                }
                sb.append(w3);
                w3 = sb.toString();
            }
            if (z3) {
                String c5 = c("openudid.dat", w3);
                if (c(c5)) {
                    w3 = c5;
                }
            }
            c4.c("openudid", w3);
        }
        return w3;
    }

    private static String c(String str, String str2) {
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
                        if (c(str5)) {
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

    private static boolean c(String str) {
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
}
