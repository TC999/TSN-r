package com.baidu.liantian.b;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* compiled from: DeviceId.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class g {
    public static String a(Context context) {
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String string = eVar.f12229b.getString("xyus", "");
            if (TextUtils.isEmpty(string)) {
                String n4 = n(context);
                String e4 = e(context);
                if (TextUtils.isEmpty(e4)) {
                    e4 = "0";
                }
                String str = n4 + "|" + new StringBuffer(e4).reverse().toString();
                eVar.f12231d.putString("xyus", str);
                eVar.f12231d.commit();
                return str;
            }
            return string;
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    public static String b(Context context) {
        try {
            com.baidu.liantian.e eVar = new com.baidu.liantian.e(context);
            String string = eVar.f12229b.getString("sgud", "");
            if (TextUtils.isEmpty(string)) {
                if (Build.VERSION.SDK_INT > 25) {
                    return "";
                }
                String e4 = e(context);
                String f4 = f(context);
                if (TextUtils.isEmpty(e4) && TextUtils.isEmpty(f4)) {
                    return "";
                }
                byte[] bytes = (e4 + ":" + f4).getBytes();
                for (int i4 = 0; i4 < bytes.length; i4++) {
                    bytes[i4] = (byte) (bytes[i4] ^ 246);
                }
                String a4 = o.a(bytes);
                if (TextUtils.isEmpty(a4)) {
                    return "";
                }
                eVar.f12231d.putString("sgud", a4);
                eVar.f12231d.commit();
                return a4;
            }
            return string;
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    public static String c(Context context) {
        try {
            return "4|" + p.a(context);
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002f A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0002, B:11:0x001f, B:13:0x002f, B:16:0x0053, B:19:0x005f, B:10:0x001c), top: B:23:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053 A[Catch: all -> 0x0081, TryCatch #0 {all -> 0x0081, blocks: (B:3:0x0002, B:11:0x001f, B:13:0x002f, B:16:0x0053, B:19:0x005f, B:10:0x001c), top: B:23:0x0002 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(android.content.Context r5) {
        /*
            java.lang.String r0 = ""
            java.lang.String r1 = f(r5)     // Catch: java.lang.Throwable -> L81
            android.content.ContentResolver r2 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L1b
            java.lang.String r3 = "bd_setting_i"
            java.lang.String r2 = android.provider.Settings.System.getString(r2, r3)     // Catch: java.lang.Throwable -> L1b
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L1f
            java.lang.String r2 = e(r5)     // Catch: java.lang.Throwable -> L1c
            goto L1f
        L1b:
            r2 = r0
        L1c:
            com.baidu.liantian.b.e.a()     // Catch: java.lang.Throwable -> L81
        L1f:
            android.content.ContentResolver r3 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "com.baidu.deviceid"
            java.lang.String r3 = android.provider.Settings.System.getString(r3, r4)     // Catch: java.lang.Throwable -> L81
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L81
            if (r4 == 0) goto L50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            java.lang.String r4 = "com.baidu"
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L81
            r3.append(r2)     // Catch: java.lang.Throwable -> L81
            r3.append(r1)     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L81
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> L81
            java.lang.String r1 = a(r1)     // Catch: java.lang.Throwable -> L81
            android.content.ContentResolver r2 = r5.getContentResolver()     // Catch: java.lang.Throwable -> L81
            java.lang.String r3 = android.provider.Settings.System.getString(r2, r1)     // Catch: java.lang.Throwable -> L81
        L50:
            if (r3 != 0) goto L53
            return r0
        L53:
            java.lang.String r5 = e(r5)     // Catch: java.lang.Throwable -> L81
            boolean r1 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L81
            if (r1 == 0) goto L5f
            java.lang.String r5 = "0"
        L5f:
            java.lang.StringBuffer r1 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L81
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuffer r5 = r1.reverse()     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> L81
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L81
            r1.<init>()     // Catch: java.lang.Throwable -> L81
            r1.append(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch: java.lang.Throwable -> L81
            r1.append(r5)     // Catch: java.lang.Throwable -> L81
            java.lang.String r5 = r1.toString()     // Catch: java.lang.Throwable -> L81
            return r5
        L81:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.liantian.b.g.d(android.content.Context):java.lang.String");
    }

    public static String e(Context context) {
        TelephonyManager telephonyManager;
        if (q.a(context) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            String deviceId = telephonyManager.getDeviceId();
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        return "";
    }

    public static String f(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return TextUtils.isEmpty(string) ? "" : string;
    }

    public static String g(Context context) {
        try {
            try {
                String string = Settings.System.getString(context.getContentResolver(), "bd_setting_i");
                if (TextUtils.isEmpty(string)) {
                    string = e(context);
                }
                String e4 = e(context);
                if (TextUtils.isEmpty(e4)) {
                    e4 = "0";
                }
                String stringBuffer = new StringBuffer(e4).reverse().toString();
                String a4 = a(string);
                if (TextUtils.isEmpty(a4)) {
                    return "";
                }
                return a4 + "|" + stringBuffer;
            } catch (Throwable unused) {
                e.a();
                return "";
            }
        } catch (Exception unused2) {
            return "";
        }
    }

    public static String h(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            if (displayMetrics.widthPixels < displayMetrics.heightPixels) {
                return displayMetrics.widthPixels + "*" + displayMetrics.heightPixels;
            }
            return displayMetrics.heightPixels + "*" + displayMetrics.widthPixels;
        } catch (Exception unused) {
            e.a();
            return "";
        }
    }

    public static String i(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            return telephonyManager != null ? telephonyManager.getSubscriberId() : "";
        } catch (Throwable unused) {
            e.a();
            return "";
        }
    }

    public static String j(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String simSerialNumber = telephonyManager.getSimSerialNumber();
                try {
                    return TextUtils.isEmpty(simSerialNumber) ? "" : simSerialNumber;
                } catch (Throwable unused) {
                    str = simSerialNumber;
                    e.a();
                    return str;
                }
            }
            return "";
        } catch (Throwable unused2) {
        }
    }

    public static String k(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String simOperatorName = telephonyManager.getSimOperatorName();
                try {
                    return TextUtils.isEmpty(simOperatorName) ? "" : simOperatorName;
                } catch (Throwable unused) {
                    str = simOperatorName;
                    e.a();
                    return str;
                }
            }
            return "";
        } catch (Throwable unused2) {
        }
    }

    public static String l(Context context) {
        String str = "";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperator = telephonyManager.getNetworkOperator();
                try {
                    return TextUtils.isEmpty(networkOperator) ? "" : networkOperator;
                } catch (Throwable unused) {
                    str = networkOperator;
                    e.a();
                    return str;
                }
            }
            return "";
        } catch (Throwable unused2) {
        }
    }

    public static String m(Context context) {
        String bssid;
        String str = "";
        try {
            bssid = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getBSSID();
        } catch (Throwable unused) {
        }
        try {
            return TextUtils.isEmpty(bssid) ? "" : bssid;
        } catch (Throwable unused2) {
            str = bssid;
            e.a();
            return str;
        }
    }

    private static String n(Context context) {
        String str;
        String str2 = "";
        try {
            str = e(context);
            try {
                str2 = f(context);
            } catch (Throwable unused) {
                e.a();
                String uuid = UUID.randomUUID().toString();
                return a((str + str2 + uuid).getBytes());
            }
        } catch (Throwable unused2) {
            str = "";
        }
        String uuid2 = UUID.randomUUID().toString();
        return a((str + str2 + uuid2).getBytes());
    }

    private static String c() {
        FileReader fileReader;
        try {
            fileReader = new FileReader("/sys/class/net/eth0/address");
            try {
                String a4 = a(fileReader);
                try {
                    fileReader.close();
                    return a4;
                } catch (Throwable unused) {
                    e.a();
                    return a4;
                }
            } catch (Throwable unused2) {
                try {
                    e.a();
                    return "";
                } finally {
                    if (fileReader != null) {
                        try {
                            fileReader.close();
                        } catch (Throwable unused3) {
                            e.a();
                        }
                    }
                }
            }
        } catch (Throwable unused4) {
            fileReader = null;
        }
    }

    private static String a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b4 : digest) {
                String upperCase = Integer.toHexString(b4 & 255).toUpperCase();
                if (upperCase.length() == 1) {
                    sb.append("0");
                }
                sb.append(upperCase);
                sb.append("");
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            e.a();
            return null;
        }
    }

    private static String b() {
        LineNumberReader lineNumberReader;
        String str = "";
        InputStreamReader inputStreamReader = null;
        try {
            InputStreamReader inputStreamReader2 = new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address").getInputStream());
            try {
                lineNumberReader = new LineNumberReader(inputStreamReader2);
                String str2 = "";
                while (str2 != null) {
                    try {
                        str2 = lineNumberReader.readLine();
                        if (str2 != null) {
                            str = str2.trim();
                            break;
                        }
                    } catch (Throwable unused) {
                        inputStreamReader = inputStreamReader2;
                        try {
                            e.a();
                        } finally {
                            if (inputStreamReader != null) {
                                try {
                                    inputStreamReader.close();
                                } catch (Throwable unused2) {
                                    e.a();
                                }
                            }
                            if (lineNumberReader != null) {
                                try {
                                    lineNumberReader.close();
                                } catch (IOException unused3) {
                                    e.a();
                                }
                            }
                        }
                    }
                }
                try {
                    inputStreamReader2.close();
                } catch (Throwable unused4) {
                    e.a();
                }
            } catch (Throwable unused5) {
                lineNumberReader = null;
            }
        } catch (Throwable unused6) {
            lineNumberReader = null;
        }
        return str;
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Environment.getExternalStorageDirectory(), "baidu/.cuid")));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\r\n");
            }
            bufferedReader.close();
            Object[] split = new String(a.a("30212102dicudiab", "30212102dicudiab", Base64.decode(sb.toString().getBytes(), 0))).split("=");
            return (split != null && split.length == 2 && str.equals(split[0])) ? split[1] : "";
        } catch (Exception unused) {
            e.a();
            return "";
        }
    }

    public static String a() {
        String b4 = b();
        if (TextUtils.isEmpty(b4)) {
            try {
                return c().toUpperCase().substring(0, 17);
            } catch (Throwable unused) {
                e.a();
            }
        }
        return b4;
    }

    private static String a(Reader reader) {
        try {
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[4096];
            int read = reader.read(cArr);
            while (read >= 0) {
                sb.append(cArr, 0, read);
                read = reader.read(cArr);
            }
            return sb.toString();
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }
}
