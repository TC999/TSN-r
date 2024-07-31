package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.webkit.WebSettings;
import com.baidu.idl.face.platform.common.ConstantHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/* renamed from: com.kuaishou.weapon.p0.bl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7196bl {
    /* renamed from: A */
    public static String m34212A() {
        try {
            String m34262a = C7191bh.m34262a("persist.service.bdroid.bdaddr");
            return TextUtils.isEmpty(m34262a) ? C7193bi.f24568c : m34262a;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: B */
    public static String m34211B() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", String.class).invoke(cls, "gsm.version.baseband");
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: C */
    public static String m34210C() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfCameras);
            return sb.toString();
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: D */
    public static String m34209D() {
        try {
            return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: E */
    public static String m34208E() {
        try {
            return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: F */
    public static String m34207F() {
        File externalStorageDirectory;
        try {
            return (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? C7193bi.f24566a : BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: G */
    public static String m34206G() {
        File externalStorageDirectory;
        try {
            return (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? C7193bi.f24566a : BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: H */
    public static long m34205H() {
        BufferedReader bufferedReader;
        String readLine;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
        } catch (Throwable unused) {
            bufferedReader = null;
        }
        do {
            try {
                try {
                    readLine = bufferedReader.readLine();
                    if (readLine != null) {
                    }
                } catch (Throwable unused2) {
                    if (bufferedReader == null) {
                        return 0L;
                    }
                    bufferedReader.close();
                }
                bufferedReader.close();
            } catch (IOException unused3) {
                return 0L;
            }
        } while (!readLine.contains("MemTotal"));
        long longValue = Long.valueOf(readLine.split("\\s+")[1]).longValue();
        try {
            bufferedReader.close();
        } catch (IOException unused4) {
        }
        return longValue;
    }

    /* renamed from: I */
    public static String m34204I() {
        try {
            return C7281f.m33898a(new File("/system/bin/app_process"));
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: J */
    public static String m34203J() {
        try {
            File file = new File("/system/bin/servicemanager");
            return (file.exists() && file.canRead()) ? C7281f.m33898a(file) : C7193bi.f24569d;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: K */
    public static String m34202K() {
        try {
            File file = new File("/system/framework/framework.jar");
            return (file.exists() && file.canRead()) ? C7281f.m33898a(file) : C7193bi.f24569d;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: L */
    public static String m34201L() {
        return Build.getRadioVersion();
    }

    /* renamed from: a */
    public static String m34200a() {
        try {
            String str = Build.MANUFACTURER;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: b */
    public static String m34197b() {
        try {
            String str = Build.BRAND;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: c */
    public static String m34194c() {
        try {
            String str = Build.MODEL;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: d */
    public static String m34192d() {
        try {
            String str = Build.HARDWARE;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: e */
    public static String m34190e() {
        try {
            String str = Build.PRODUCT;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: f */
    public static String m34188f() {
        try {
            String str = Build.DEVICE;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: g */
    public static String m34186g() {
        try {
            String str = Build.BOARD;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: h */
    public static String m34184h() {
        try {
            String str = Build.HOST;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: i */
    public static String m34182i() {
        try {
            String str = Build.USER;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: j */
    public static String m34180j() {
        try {
            String str = Build.TYPE;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: k */
    public static String m34178k() {
        try {
            String str = Build.TAGS;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: l */
    public static String m34177l() {
        try {
            String str = Build.BOOTLOADER;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: m */
    public static String m34176m() {
        try {
            String str = Build.ID;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: n */
    public static String m34175n() {
        try {
            String str = Build.DISPLAY;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: o */
    public static String m34174o() {
        try {
            String str = Build.VERSION.CODENAME;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: p */
    public static String m34173p() {
        try {
            String m34262a = C7191bh.m34262a("rild.libpath");
            return TextUtils.isEmpty(m34262a) ? C7193bi.f24568c : m34262a;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: q */
    public static String m34172q() {
        try {
            String str = Build.VERSION.RELEASE;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: r */
    public static int m34171r() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
            return -2;
        }
    }

    /* renamed from: s */
    public static String m34170s() {
        try {
            String str = Build.FINGERPRINT;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: t */
    public static String m34169t() {
        try {
            String property = System.getProperty("http.agent");
            return TextUtils.isEmpty(property) ? C7193bi.f24568c : property;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: u */
    public static String m34168u() {
        Process process;
        InputStream inputStream;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            process = Runtime.getRuntime().exec("uname -a");
            try {
                if (process.waitFor() == 0) {
                    inputStream = process.getInputStream();
                } else {
                    inputStream = process.getErrorStream();
                }
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 512);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                inputStream = null;
            }
        } catch (Throwable unused3) {
            process = null;
            inputStream = null;
        }
        try {
            String readLine = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (Throwable unused4) {
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused5) {
                }
            }
            process.destroy();
            return readLine;
        } catch (Throwable unused6) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Throwable unused7) {
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable unused8) {
                }
            }
            if (process != null) {
                process.destroy();
                return C7193bi.f24569d;
            }
            return C7193bi.f24569d;
        }
    }

    /* renamed from: v */
    public static String m34167v() {
        try {
            String str = Build.RADIO;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: w */
    public static String m34166w() {
        try {
            String m34262a = C7191bh.m34262a("ro.build.description");
            return TextUtils.isEmpty(m34262a) ? C7193bi.f24568c : m34262a;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: x */
    public static String m34165x() {
        try {
            String str = Build.VERSION.INCREMENTAL;
            return TextUtils.isEmpty(str) ? C7193bi.f24568c : str;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: y */
    public static String m34164y() {
        try {
            String m34262a = C7191bh.m34262a("ro.product.name");
            return TextUtils.isEmpty(m34262a) ? C7193bi.f24568c : m34262a;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: z */
    public static String m34163z() {
        try {
            String m34262a = C7191bh.m34262a("dalvik.vm.heapgrowthlimit");
            return TextUtils.isEmpty(m34262a) ? C7193bi.f24568c : m34262a;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: a */
    public static int m34199a(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return -1;
            }
            return telephonyManager.getPhoneType();
        } catch (Throwable unused) {
            return -2;
        }
    }

    /* renamed from: b */
    public static String m34196b(Context context) {
        try {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            return TextUtils.isEmpty(defaultUserAgent) ? C7193bi.f24568c : defaultUserAgent;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: c */
    public static String m34193c(Context context) {
        int i;
        int i2;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            if (Build.VERSION.SDK_INT >= 31) {
                WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                i = maximumWindowMetrics.getBounds().width();
                i2 = maximumWindowMetrics.getBounds().height();
            } else {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i = point.x;
                i2 = point.y;
            }
            float m34198a = m34198a(m34179j(context));
            float m34195b = m34195b(m34179j(context));
            if (m34198a != 0.0f && m34195b != 0.0f) {
                int round = Math.round((i / m34198a) * 2.54f) * 10;
                int round2 = Math.round((i2 / m34195b) * 2.54f) * 10;
                if (round > round2) {
                    return round2 + "mm * " + round + "mm";
                }
                return round + "mm * " + round2 + "mm";
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    /* renamed from: d */
    public static String m34191d(Context context) {
        int i;
        int i2;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            if (Build.VERSION.SDK_INT >= 31) {
                WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                i = maximumWindowMetrics.getBounds().width();
                i2 = maximumWindowMetrics.getBounds().height();
            } else {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i = point.x;
                i2 = point.y;
            }
            if (i > i2) {
                return i2 + "*" + i;
            }
            return i + "*" + i2;
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: e */
    public static String m34189e(Context context) {
        DisplayMetrics m34179j = m34179j(context);
        if (m34179j != null) {
            return Integer.toString(m34179j.densityDpi);
        }
        return null;
    }

    /* renamed from: f */
    public static String m34187f(Context context) {
        Process process;
        InputStream inputStream;
        InputStream inputStream2 = null;
        r7 = null;
        String str = null;
        inputStream2 = null;
        try {
            process = Runtime.getRuntime().exec("cat /proc/version");
            try {
                inputStream = process.getInputStream();
            } catch (Throwable unused) {
            }
            try {
                byte[] bArr = new byte[1024];
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused2) {
                    }
                    process.destroy();
                    return C7193bi.f24568c;
                }
                byte[] bArr2 = new byte[read];
                System.arraycopy(bArr, 0, bArr2, 0, read);
                String str2 = new String(bArr2, "utf-8");
                int indexOf = str2.indexOf(ConstantHelper.LOG_VS);
                if (indexOf != -1) {
                    String[] split = str2.substring(indexOf).split(" ");
                    if (1 < split.length) {
                        str = split[1];
                    }
                }
                if (TextUtils.isEmpty(str)) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused3) {
                    }
                    process.destroy();
                    return C7193bi.f24568c;
                }
                try {
                    inputStream.close();
                } catch (Throwable unused4) {
                }
                process.destroy();
                return str;
            } catch (Throwable unused5) {
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (Throwable unused6) {
                    }
                }
                if (process != null) {
                    process.destroy();
                    return C7193bi.f24569d;
                }
                return C7193bi.f24569d;
            }
        } catch (Throwable unused7) {
            process = null;
        }
    }

    /* renamed from: g */
    public static int m34185g(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_off_timeout");
        } catch (Exception unused) {
            return -2;
        }
    }

    /* renamed from: h */
    public static int m34183h(Context context) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getRingerMode();
        } catch (Exception unused) {
            return -2;
        }
    }

    /* renamed from: i */
    public static int m34181i(Context context) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke((ConnectivityManager) context.getSystemService("connectivity"), new Object[0])).booleanValue() ? 0 : 1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    /* renamed from: j */
    private static DisplayMetrics m34179j(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static float m34198a(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.xdpi;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    /* renamed from: b */
    private static float m34195b(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.ydpi;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }
}
