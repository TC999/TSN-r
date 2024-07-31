package com.kuaishou.weapon.p205p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.LocaleList;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.kwad.sdk.p433f.C10758b;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.tencent.connect.common.Constants;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.bh */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7191bh {

    /* renamed from: a */
    private static String f24553a;

    /* renamed from: b */
    private static String f24554b;

    /* renamed from: A */
    private static JSONObject m34270A(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = WeaponHI.sUserId;
            String m34235m = m34235m();
            String str2 = WeaponHI.sChannel;
            String m34237l = m34237l();
            String m34239k = m34239k();
            String str3 = "";
            jSONObject.put("userId", TextUtils.isEmpty(str) ? "" : URLEncoder.encode(str, "UTF-8"));
            jSONObject.put(Constants.PARAM_PLATFORM, TextUtils.isEmpty(m34235m) ? "" : URLEncoder.encode(m34235m, "UTF-8"));
            jSONObject.put("channel", TextUtils.isEmpty(str2) ? "" : URLEncoder.encode(str2, "UTF-8"));
            try {
                if (C7283h.m33888a(context, "re_po_rt").m33867e("a1_p_s_p_s")) {
                    jSONObject.put("mod", TextUtils.isEmpty(m34237l) ? "" : URLEncoder.encode(m34237l, "UTF-8"));
                    if (!TextUtils.isEmpty(m34239k)) {
                        str3 = URLEncoder.encode(m34239k, "UTF-8");
                    }
                    jSONObject.put("sysver", str3);
                } else {
                    jSONObject.put("mod", "");
                    jSONObject.put("sysver", "");
                }
            } catch (Exception unused) {
            }
            return jSONObject;
        } catch (Exception unused2) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (android.text.TextUtils.isEmpty(r2) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
        if (r2.length() <= (r2.indexOf(" ") + 11)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        r1 = r2.substring(r2.indexOf(" ") + 1, r2.indexOf(" ") + 11);
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m34269a() {
        /*
            java.lang.String r0 = " "
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r3 = "c3RhdCAgL2RhdGEvc3lzdGVtL3VzZXJzLzA="
            r4 = 2
            java.lang.String r3 = com.kuaishou.weapon.p205p0.C7212c.m34106b(r3, r4)     // Catch: java.lang.Throwable -> L5c
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L5c
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5c
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L5c
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L5c
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L5c
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L5c
        L20:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L5d
            if (r2 == 0) goto L58
            java.lang.String r4 = "Access"
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L5d
            if (r4 == 0) goto L20
            java.lang.String r4 = "Uid"
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L5d
            if (r4 != 0) goto L20
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L5d
            if (r4 != 0) goto L58
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L5d
            int r5 = r2.indexOf(r0)     // Catch: java.lang.Throwable -> L5d
            int r5 = r5 + 11
            if (r4 <= r5) goto L58
            int r4 = r2.indexOf(r0)     // Catch: java.lang.Throwable -> L5d
            int r4 = r4 + 1
            int r0 = r2.indexOf(r0)     // Catch: java.lang.Throwable -> L5d
            int r0 = r0 + 11
            java.lang.String r1 = r2.substring(r4, r0)     // Catch: java.lang.Throwable -> L5d
        L58:
            r3.close()     // Catch: java.lang.Exception -> L5b
        L5b:
            return r1
        L5c:
            r3 = r1
        L5d:
            if (r3 == 0) goto L62
            r3.close()     // Catch: java.lang.Exception -> L62
        L62:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7191bh.m34269a():java.lang.String");
    }

    /* renamed from: b */
    public static String m34260b(Context context) {
        try {
            return m34254c(C10758b.m24900Is().mo24010Ig());
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: c */
    public static String m34255c(Context context) {
        try {
            return m34254c(C10758b.m24900Is().mo24010Ig());
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: d */
    public static String m34252d(Context context) {
        try {
            return m34254c(C10758b.m24900Is().mo24005Il());
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: e */
    public static String m34250e(Context context) {
        try {
            return m34254c(C10758b.m24900Is().getIccId());
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: f */
    public static String m34248f(Context context) {
        try {
            return m34254c(C10758b.m24900Is().mo24009Ih());
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: g */
    public static boolean m34246g(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: h */
    public static boolean m34244h(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: i */
    public static String m34242i(Context context) {
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
            StringBuilder sb = new StringBuilder();
            for (InputMethodInfo inputMethodInfo : inputMethodList) {
                sb.append(inputMethodInfo.getId());
                sb.append(";");
            }
            if (TextUtils.isEmpty(sb)) {
                return C7193bi.f24568c;
            }
            String sb2 = sb.toString();
            return sb2.endsWith(";") ? sb2.substring(0, sb2.length() - 1) : sb2;
        } catch (Exception unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: j */
    public static String m34240j(Context context) {
        List<InputMethodInfo> enabledInputMethodList;
        ActivityInfo activityInfo;
        int i = -1;
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
                if (string == null) {
                    string = "null";
                }
                String str = "1=" + string + ";";
                InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService("input_method");
                if (inputMethodManager != null && (enabledInputMethodList = inputMethodManager.getEnabledInputMethodList()) != null) {
                    str = str + "2=";
                    for (InputMethodInfo inputMethodInfo : enabledInputMethodList) {
                        String packageName = inputMethodInfo.getPackageName();
                        if (packageName == null) {
                            packageName = "null";
                        }
                        String settingsActivity = inputMethodInfo.getSettingsActivity();
                        if (settingsActivity == null) {
                            settingsActivity = "null";
                        }
                        if (packageManager != null) {
                            try {
                                if (!packageName.equals("null") && !settingsActivity.equals("null") && (activityInfo = packageManager.getActivityInfo(new ComponentName(packageName, settingsActivity), 0)) != null) {
                                    i = activityInfo.launchMode;
                                }
                            } catch (Exception unused) {
                            }
                        }
                        str = str + packageName + "-" + settingsActivity + "-" + String.format("%d", Integer.valueOf(i)) + ";";
                    }
                }
                return str;
            } catch (Throwable unused2) {
                return "";
            }
        }
        return "";
    }

    /* renamed from: k */
    public static String m34238k(Context context) {
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
                return C7193bi.f24570e;
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
            return TextUtils.isEmpty(string) ? C7193bi.f24568c : string;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m34236l(android.content.Context r5) {
        /*
            java.lang.String r0 = "accessibility"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.view.accessibility.AccessibilityManager r5 = (android.view.accessibility.AccessibilityManager) r5
            r0 = 0
            if (r5 != 0) goto Lc
            return r0
        Lc:
            java.util.List r5 = r5.getInstalledAccessibilityServiceList()     // Catch: java.lang.Exception -> L43
            if (r5 == 0) goto L43
            int r1 = r5.size()     // Catch: java.lang.Exception -> L43
            if (r1 <= 0) goto L43
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L43
            r1.<init>()     // Catch: java.lang.Exception -> L43
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> L41
        L21:
            boolean r2 = r5.hasNext()     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L44
            java.lang.Object r2 = r5.next()     // Catch: java.lang.Exception -> L41
            android.accessibilityservice.AccessibilityServiceInfo r2 = (android.accessibilityservice.AccessibilityServiceInfo) r2     // Catch: java.lang.Exception -> L41
            java.lang.String r2 = m34268a(r2)     // Catch: java.lang.Exception -> L41
            int r3 = r1.indexOf(r2)     // Catch: java.lang.Exception -> L41
            r4 = -1
            if (r3 != r4) goto L21
            r1.append(r2)     // Catch: java.lang.Exception -> L41
            java.lang.String r2 = "|"
            r1.append(r2)     // Catch: java.lang.Exception -> L41
            goto L21
        L41:
            goto L44
        L43:
            r1 = r0
        L44:
            if (r1 != 0) goto L47
            return r0
        L47:
            int r5 = r1.length()
            if (r5 <= 0) goto L56
            int r5 = r1.length()
            int r5 = r5 + (-1)
            r1.deleteCharAt(r5)
        L56:
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7191bh.m34236l(android.content.Context):java.lang.String");
    }

    /* renamed from: m */
    private static String m34235m() {
        return "ANDROID_PHONE";
    }

    /* renamed from: m */
    public static String m34234m(Context context) {
        StringBuilder sb;
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        StringBuilder sb2 = null;
        if (accessibilityManager == null) {
            return null;
        }
        try {
            if (!accessibilityManager.isEnabled() || (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(-1)) == null || enabledAccessibilityServiceList.size() <= 0) {
                sb = null;
            } else {
                sb = new StringBuilder();
                try {
                    for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                        String m34268a = m34268a(accessibilityServiceInfo);
                        if (sb.indexOf(m34268a) == -1) {
                            sb.append(m34268a);
                            sb.append("|");
                        }
                    }
                } catch (Exception unused) {
                    sb2 = sb;
                    sb = sb2;
                    return sb.toString();
                }
            }
        } catch (Exception unused2) {
        }
        if (sb == null) {
            return null;
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '|') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* renamed from: n */
    public static String m34233n(Context context) {
        return C7193bi.f24569d;
    }

    /* renamed from: o */
    public static String m34232o(Context context) {
        return C7193bi.f24568c;
    }

    /* renamed from: p */
    public static String m34231p(Context context) {
        return C7193bi.f24566a;
    }

    /* renamed from: q */
    public static String m34230q(Context context) {
        try {
            if (TextUtils.isEmpty(f24553a)) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                f24554b = (String) packageInfo.applicationInfo.loadLabel(context.getPackageManager());
                f24553a = packageInfo.versionName;
            }
        } catch (Throwable unused) {
        }
        return f24553a;
    }

    /* renamed from: r */
    public static String m34229r(Context context) {
        return f24554b;
    }

    /* renamed from: s */
    public static String m34228s(Context context) {
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return "";
        }
    }

    @TargetApi(23)
    /* renamed from: t */
    public static int m34227t(Context context) {
        try {
            String m34254c = m34254c(C10758b.m24900Is().mo24004Im());
            if (!TextUtils.isEmpty(m34254c) && !m34254c.startsWith("RISK")) {
                return Integer.parseInt(m34254c);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    @TargetApi(22)
    /* renamed from: u */
    public static int m34226u(Context context) {
        try {
            String m34254c = m34254c(C10758b.m24900Is().mo24003In());
            if (!TextUtils.isEmpty(m34254c) && !m34254c.startsWith("RISK")) {
                return Integer.parseInt(m34254c);
            }
            return -1;
        } catch (Throwable unused) {
            return -2;
        }
    }

    /* renamed from: v */
    public static String m34225v(Context context) {
        return C7193bi.f24568c;
    }

    /* renamed from: w */
    public static String m34224w(Context context) {
        try {
            return m34254c(C10758b.m24900Is().getOaid());
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: x */
    public static String m34223x(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            PackageManager packageManager = context.getPackageManager();
            String[] strArr = {"android.hardware.camera", "android.hardware.camera.autofocus", "android.hardware.camera.flash", "android.hardware.location", "android.hardware.location.gps", "android.hardware.location.network", "android.hardware.microphone", "android.hardware.sensor.compass", "android.hardware.sensor.accelerometer", "android.hardware.sensor.light", "android.hardware.sensor.proximity", "android.hardware.telephony", "android.hardware.telephony.cdma", "android.hardware.telephony.gsm", "android.hardware.touchscreen", "android.hardware.touchscreen.multitouch", "android.hardware.touchscreen.multitouch.distinct", "android.hardware.camera.front", "android.hardware.wifi", "android.hardware.bluetooth", "android.hardware.nfc", "android.hardware.fingerprint", "android.hardware.biometrics.face", "android.hardware.screen.portrait", "android.hardware.screen.landscape", "android.hardware.faketouch", "android.hardware.audio.output"};
            for (int i = 0; i < 27; i++) {
                if (packageManager.hasSystemFeature(strArr[i])) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    /* renamed from: y */
    public static String m34222y(Context context) {
        StringBuilder sb = new StringBuilder();
        try {
            String[] strArr = {C7282g.f24945c, C7282g.f24951i, C7282g.f24952j, "android.permission.READ_CONTACTS", "android.permission.CAMERA", "android.permission.RECORD_AUDIO", C7282g.f24949g, C7282g.f24950h, "android.permission.BLUETOOTH", "android.permission.WRITE_CALENDAR", "android.permission.READ_CALENDAR"};
            for (int i = 0; i < 11; i++) {
                if (C7282g.m33892a(context, strArr[i]) == 0) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    /* renamed from: z */
    public static String m34221z(Context context) {
        Iterator<String> keys;
        try {
            StringBuilder sb = new StringBuilder();
            JSONObject m34270A = m34270A(context);
            if (m34270A != null && (keys = m34270A.keys()) != null) {
                String str = "";
                while (keys.hasNext()) {
                    String next = keys.next();
                    String string = m34270A.getString(next);
                    sb.append(str);
                    str = ";";
                    sb.append(next);
                    sb.append("=");
                    sb.append(string);
                }
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* renamed from: b */
    public static String m34259b(Context context, int i) {
        try {
            if (i == 1) {
                return m34254c(C10758b.m24900Is().mo24007Ij());
            }
            return m34254c(C10758b.m24900Is().mo24010Ig());
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: c */
    public static double m34256c() {
        try {
            String m34254c = m34254c(C10758b.m24900Is().getLocation());
            if (!TextUtils.isEmpty(m34254c) && !m34254c.startsWith("RISK")) {
                return new JSONObject(m34254c).getDouble("longitude");
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    /* renamed from: d */
    public static String m34253d() {
        try {
            String m34254c = m34254c(C10758b.m24900Is().mo24002Io());
            if (!TextUtils.isEmpty(m34254c) && !m34254c.startsWith("RISK")) {
                JSONObject jSONObject = new JSONObject(m34254c);
                return jSONObject.getString("cellId") + ", " + jSONObject.getString("lac");
            }
            return m34254c;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: e */
    public static String m34251e() {
        try {
            String m34254c = m34254c(C10758b.m24900Is().mo24000Iq());
            if (!TextUtils.isEmpty(m34254c)) {
                m34254c.startsWith("RISK");
            }
            return m34254c;
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: f */
    public static JSONArray m34249f() {
        try {
            String m34254c = m34254c(C10758b.m24900Is().mo24001Ip());
            if (!TextUtils.isEmpty(m34254c) && !m34254c.startsWith("RISK")) {
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray(m34254c);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i).getString("ssid"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i).getString("bssid"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* renamed from: g */
    public static String m34247g() {
        try {
            return m34254c(C10758b.m24900Is().getIp());
        } catch (Throwable unused) {
            return C7193bi.f24568c;
        }
    }

    /* renamed from: h */
    public static String m34245h() {
        try {
            return m34254c(C10758b.m24900Is().mo24008Ii());
        } catch (Throwable unused) {
            return C7193bi.f24568c;
        }
    }

    /* renamed from: b */
    public static Method m34258b(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            if (method != null) {
                return method;
            }
        } catch (Throwable unused) {
        }
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException unused2) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    /* renamed from: k */
    public static String m34239k() {
        return "ANDROID_" + Build.VERSION.RELEASE;
    }

    /* renamed from: c */
    public static String m34254c(String str) {
        String str2 = "";
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            int i = jSONObject.getInt("errorCode");
            if (i != 0) {
                return i == 3 ? C7193bi.f24568c : i == 1 ? C7193bi.f24566a : C7193bi.f24569d;
            }
            str2 = jSONObject.getString(DomainCampaignEx.LOOPBACK_VALUE);
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    /* renamed from: a */
    public static String m34262a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class).invoke(cls, str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static double m34261b() {
        try {
            String m34254c = m34254c(C10758b.m24900Is().getLocation());
            if (!TextUtils.isEmpty(m34254c) && !m34254c.startsWith("RISK")) {
                return new JSONObject(m34254c).getDouble("latitude");
            }
            return -1.0d;
        } catch (Throwable unused) {
            return -1.0d;
        }
    }

    /* renamed from: a */
    public static String m34267a(Context context) {
        try {
            return m34254c(C10758b.m24900Is().mo24010Ig());
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: i */
    public static String m34243i() {
        try {
            Locale locale = Locale.getDefault();
            return locale.getLanguage() + "-" + locale.getCountry();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static String m34266a(Context context, int i) {
        try {
            if (i == 1) {
                return m34254c(C10758b.m24900Is().mo24007Ij());
            }
            return m34254c(C10758b.m24900Is().mo24010Ig());
        } catch (Throwable unused) {
            return C7193bi.f24569d;
        }
    }

    /* renamed from: b */
    public static int m34257b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return new JSONObject(str).getBoolean("userSet") ? 1 : 0;
        } catch (Throwable unused) {
            return -2;
        }
    }

    /* renamed from: l */
    public static String m34237l() {
        return Build.MANUFACTURER + "(" + Build.MODEL + ")";
    }

    /* renamed from: a */
    public static Method m34263a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            Method m34258b = m34258b(cls, str, clsArr);
            try {
                m34258b.setAccessible(true);
                return m34258b;
            } catch (Throwable unused) {
                return m34258b;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* renamed from: j */
    public static String m34241j() {
        Locale locale;
        if (Build.VERSION.SDK_INT >= 24) {
            locale = LocaleList.getDefault().get(0);
        } else {
            locale = Locale.getDefault();
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    /* renamed from: a */
    private static String m34268a(AccessibilityServiceInfo accessibilityServiceInfo) {
        String id = accessibilityServiceInfo.getId();
        int lastIndexOf = id.lastIndexOf("/");
        return lastIndexOf > 0 ? id.substring(0, lastIndexOf) : id;
    }

    /* renamed from: a */
    public static void m34264a(final Context context, String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || C7283h.m33888a(context, "re_po_rt").m33872c(C7262df.f24886br, 1) == 0) {
            return;
        }
        try {
            JSONObject m34081a = new C7229cm(str, C7227ck.f24680l).m34081a(context);
            if (map != null && map.size() > 0) {
                m34081a.put("module_section", new JSONObject(map));
            } else {
                m34081a.put("module_section", new JSONObject());
            }
            final String jSONObject = m34081a.toString();
            C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.bh.1
                @Override // java.lang.Runnable
                public final void run() {
                    C7232cp.m34049a(context, jSONObject);
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static boolean m34265a(Context context, String str) {
        try {
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
