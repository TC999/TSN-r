package com.kuaishou.weapon.p205p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import master.flame.danmaku.danmaku.parser.IDataSource;
import org.json.JSONArray;

/* renamed from: com.kuaishou.weapon.p0.dl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7268dl {
    /* renamed from: a */
    public static String m33948a(String str) {
        if (str.contains(IDataSource.f43971a)) {
            str = str.replace("https://", "").replace("http://", "");
        }
        return str.contains("/") ? str.substring(0, str.indexOf("/")) : str;
    }

    /* renamed from: b */
    public static Set m33946b(Context context) {
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
            HashSet hashSet = new HashSet();
            for (InputMethodInfo inputMethodInfo : inputMethodList) {
                hashSet.add(inputMethodInfo.getId().split("/")[0]);
            }
            if (hashSet.size() <= 0) {
                return null;
            }
            return hashSet;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: c */
    public static int m33945c(Context context) {
        try {
            return m33949a(context, "show_touches");
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: d */
    public static int m33944d(Context context) {
        try {
            return m33949a(context, "pointer_location");
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[RETURN] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m33943e(android.content.Context r3) {
        /*
            android.content.res.Resources r3 = r3.getResources()     // Catch: java.lang.Throwable -> L1b
            android.content.res.Configuration r3 = r3.getConfiguration()     // Catch: java.lang.Throwable -> L1b
            int r0 = r3.keyboard     // Catch: java.lang.Throwable -> L1b
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L16
            int r3 = r3.hardKeyboardHidden     // Catch: java.lang.Throwable -> L1b
            r0 = 2
            if (r3 != r0) goto L14
            goto L16
        L14:
            r3 = 0
            goto L17
        L16:
            r3 = 1
        L17:
            if (r3 == 0) goto L1a
            return r1
        L1a:
            return r2
        L1b:
            r3 = -1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7268dl.m33943e(android.content.Context):int");
    }

    /* renamed from: a */
    public static String m33951a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    public static Set m33950a(Context context) {
        try {
            List<AccessibilityServiceInfo> installedAccessibilityServiceList = ((AccessibilityManager) context.getSystemService("accessibility")).getInstalledAccessibilityServiceList();
            HashSet hashSet = new HashSet();
            for (AccessibilityServiceInfo accessibilityServiceInfo : installedAccessibilityServiceList) {
                if (accessibilityServiceInfo != null && !TextUtils.isEmpty(accessibilityServiceInfo.getId())) {
                    hashSet.add(accessibilityServiceInfo.getId());
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static int m33949a(Context context, String str) {
        try {
            return Settings.System.getInt(context.getContentResolver(), str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: a */
    public static int m33952a() {
        BufferedReader bufferedReader = null;
        try {
            FileInputStream fileInputStream = (FileInputStream) Class.forName("java.io.FileInputStream").getConstructor(String.class).newInstance("/sys/class/power_supply/usb/online");
            if (fileInputStream != null) {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream), 1000);
                try {
                    String readLine = bufferedReader2.readLine();
                    if (!TextUtils.isEmpty(readLine)) {
                        if (TextUtils.equals(readLine, "1")) {
                            try {
                                bufferedReader2.close();
                            } catch (Throwable unused) {
                            }
                            return 1;
                        }
                    }
                    bufferedReader = bufferedReader2;
                } catch (Throwable unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable unused3) {
                        }
                    }
                    return 0;
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Throwable unused4) {
                }
            }
            return 0;
        } catch (Throwable unused5) {
        }
    }

    /* renamed from: a */
    public static Set m33947a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    HashSet hashSet = new HashSet();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        hashSet.add(jSONArray.get(i));
                    }
                    return hashSet;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }
}
