package com.kuaishou.weapon.p0;

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
import com.acse.ottn.f3;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.math.BigDecimal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class bl {
    public static String A() {
        try {
            String a4 = bh.a("persist.service.bdroid.bdaddr");
            return TextUtils.isEmpty(a4) ? "RISK_GET_FIELD_EMPTY" : a4;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String B() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(f3.f5657f, String.class).invoke(cls, "gsm.version.baseband");
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String C() {
        try {
            int numberOfCameras = Camera.getNumberOfCameras();
            StringBuilder sb = new StringBuilder();
            sb.append(numberOfCameras);
            return sb.toString();
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String D() {
        try {
            return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String E() {
        try {
            return BigDecimal.valueOf(((float) (new StatFs(Environment.getDataDirectory().getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String F() {
        File externalStorageDirectory;
        try {
            return (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? "RISK_AUTH_FAILED" : BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getTotalBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String G() {
        File externalStorageDirectory;
        try {
            return (!"mounted".equals(Environment.getExternalStorageState()) || (externalStorageDirectory = Environment.getExternalStorageDirectory()) == null) ? "RISK_AUTH_FAILED" : BigDecimal.valueOf(((float) (new StatFs(externalStorageDirectory.getPath()).getAvailableBytes() >> 20)) / 1024.0f).setScale(2, 4).toString();
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static long H() {
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

    public static String I() {
        try {
            return f.a(new File("/system/bin/app_process"));
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String J() {
        try {
            File file = new File("/system/bin/servicemanager");
            return (file.exists() && file.canRead()) ? f.a(file) : "RISK_EXCEPTION_HAPPEN";
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String K() {
        try {
            File file = new File("/system/framework/framework.jar");
            return (file.exists() && file.canRead()) ? f.a(file) : "RISK_EXCEPTION_HAPPEN";
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String L() {
        return Build.getRadioVersion();
    }

    public static String a() {
        try {
            String str = Build.MANUFACTURER;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String b() {
        try {
            String str = Build.BRAND;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String c() {
        try {
            String str = Build.MODEL;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String d() {
        try {
            String str = Build.HARDWARE;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String e() {
        try {
            String str = Build.PRODUCT;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String f() {
        try {
            String str = Build.DEVICE;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String g() {
        try {
            String str = Build.BOARD;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String h() {
        try {
            String str = Build.HOST;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String i() {
        try {
            String str = Build.USER;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String j() {
        try {
            String str = Build.TYPE;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String k() {
        try {
            String str = Build.TAGS;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String l() {
        try {
            String str = Build.BOOTLOADER;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String m() {
        try {
            String str = Build.ID;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String n() {
        try {
            String str = Build.DISPLAY;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String o() {
        try {
            String str = Build.VERSION.CODENAME;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String p() {
        try {
            String a4 = bh.a("rild.libpath");
            return TextUtils.isEmpty(a4) ? "RISK_GET_FIELD_EMPTY" : a4;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String q() {
        try {
            String str = Build.VERSION.RELEASE;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static int r() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
            return -2;
        }
    }

    public static String s() {
        try {
            String str = Build.FINGERPRINT;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String t() {
        try {
            String property = System.getProperty("http.agent");
            return TextUtils.isEmpty(property) ? "RISK_GET_FIELD_EMPTY" : property;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String u() {
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
                return "RISK_EXCEPTION_HAPPEN";
            }
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String v() {
        try {
            String str = Build.RADIO;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String w() {
        try {
            String a4 = bh.a("ro.build.description");
            return TextUtils.isEmpty(a4) ? "RISK_GET_FIELD_EMPTY" : a4;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String x() {
        try {
            String str = Build.VERSION.INCREMENTAL;
            return TextUtils.isEmpty(str) ? "RISK_GET_FIELD_EMPTY" : str;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String y() {
        try {
            String a4 = bh.a("ro.product.name");
            return TextUtils.isEmpty(a4) ? "RISK_GET_FIELD_EMPTY" : a4;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String z() {
        try {
            String a4 = bh.a("dalvik.vm.heapgrowthlimit");
            return TextUtils.isEmpty(a4) ? "RISK_GET_FIELD_EMPTY" : a4;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static int a(Context context) {
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

    public static String b(Context context) {
        try {
            String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
            return TextUtils.isEmpty(defaultUserAgent) ? "RISK_GET_FIELD_EMPTY" : defaultUserAgent;
        } catch (Throwable unused) {
            return "RISK_EXCEPTION_HAPPEN";
        }
    }

    public static String c(Context context) {
        int i4;
        int i5;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            if (Build.VERSION.SDK_INT >= 31) {
                WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                i4 = maximumWindowMetrics.getBounds().width();
                i5 = maximumWindowMetrics.getBounds().height();
            } else {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i4 = point.x;
                i5 = point.y;
            }
            float a4 = a(j(context));
            float b4 = b(j(context));
            if (a4 != 0.0f && b4 != 0.0f) {
                int round = Math.round((i4 / a4) * 2.54f) * 10;
                int round2 = Math.round((i5 / b4) * 2.54f) * 10;
                if (round > round2) {
                    return round2 + "mm * " + round + "mm";
                }
                return round + "mm * " + round2 + "mm";
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String d(Context context) {
        int i4;
        int i5;
        try {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            defaultDisplay.getMetrics(new DisplayMetrics());
            if (Build.VERSION.SDK_INT >= 31) {
                WindowMetrics maximumWindowMetrics = windowManager.getMaximumWindowMetrics();
                i4 = maximumWindowMetrics.getBounds().width();
                i5 = maximumWindowMetrics.getBounds().height();
            } else {
                Point point = new Point();
                defaultDisplay.getRealSize(point);
                i4 = point.x;
                i5 = point.y;
            }
            if (i4 > i5) {
                return i5 + "*" + i4;
            }
            return i4 + "*" + i5;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String e(Context context) {
        DisplayMetrics j4 = j(context);
        if (j4 != null) {
            return Integer.toString(j4.densityDpi);
        }
        return null;
    }

    public static String f(Context context) {
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
                    return "RISK_GET_FIELD_EMPTY";
                }
                byte[] bArr2 = new byte[read];
                System.arraycopy(bArr, 0, bArr2, 0, read);
                String str2 = new String(bArr2, "utf-8");
                int indexOf = str2.indexOf("version");
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
                    return "RISK_GET_FIELD_EMPTY";
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
                    return "RISK_EXCEPTION_HAPPEN";
                }
                return "RISK_EXCEPTION_HAPPEN";
            }
        } catch (Throwable unused7) {
            process = null;
        }
    }

    public static int g(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_off_timeout");
        } catch (Exception unused) {
            return -2;
        }
    }

    public static int h(Context context) {
        try {
            return ((AudioManager) context.getSystemService("audio")).getRingerMode();
        } catch (Exception unused) {
            return -2;
        }
    }

    public static int i(Context context) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke((ConnectivityManager) context.getSystemService("connectivity"), new Object[0])).booleanValue() ? 0 : 1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    private static DisplayMetrics j(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static float a(DisplayMetrics displayMetrics) {
        if (displayMetrics == null) {
            return 0.0f;
        }
        try {
            return displayMetrics.xdpi;
        } catch (Throwable unused) {
            return 0.0f;
        }
    }

    private static float b(DisplayMetrics displayMetrics) {
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
