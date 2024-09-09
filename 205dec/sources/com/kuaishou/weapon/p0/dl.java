package com.kuaishou.weapon.p0;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class dl {
    public static String a(String str) {
        if (str.contains("http")) {
            str = str.replace(JPushConstants.HTTPS_PRE, "").replace(JPushConstants.HTTP_PRE, "");
        }
        return str.contains(TTPathConst.sSeparator) ? str.substring(0, str.indexOf(TTPathConst.sSeparator)) : str;
    }

    public static Set b(Context context) {
        try {
            List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
            HashSet hashSet = new HashSet();
            for (InputMethodInfo inputMethodInfo : inputMethodList) {
                hashSet.add(inputMethodInfo.getId().split(TTPathConst.sSeparator)[0]);
            }
            if (hashSet.size() <= 0) {
                return null;
            }
            return hashSet;
        } catch (Exception unused) {
            return null;
        }
    }

    public static int c(Context context) {
        try {
            return a(context, "show_touches");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int d(Context context) {
        try {
            return a(context, "pointer_location");
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0019 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int e(android.content.Context r3) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.dl.e(android.content.Context):int");
    }

    public static String a(long j4) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j4));
        } catch (Exception unused) {
            return "";
        }
    }

    public static Set a(Context context) {
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

    private static int a(Context context, String str) {
        try {
            return Settings.System.getInt(context.getContentResolver(), str, 0);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int a() {
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

    public static Set a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    HashSet hashSet = new HashSet();
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        hashSet.add(jSONArray.get(i4));
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
